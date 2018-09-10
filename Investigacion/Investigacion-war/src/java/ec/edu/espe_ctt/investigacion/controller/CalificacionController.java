/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller; 

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.AprobacionDirectorDepartamento;
import ec.edu.espe_ctt_investigacion.entity.CalificacionComision;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.session.AprobacionDirectorDepartamentoFacade;
import ec.edu.espe_ctt_investigacion.session.CalificacionComisionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class CalificacionController implements Serializable{
    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath ="";
    private StreamedContent media;
    public boolean  controlPDF = false;


    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Convocatoria
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    

    @EJB
    private SeaConvocaFacade convocatoriaFacade;
    private List<SeaConvoca> convocatoriaList;
    private SeaConvoca convocat;
    private BigDecimal idConvocatoria;
    private String convocatoria = "";
    private SeaConvoca convocatoriaSelected;

    ///Variables tab1    
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;

    @EJB
    private SeaDatGeneralProyFacade proyectoFacade;
    private SeaDatGeneralProy datGenProyecto;
    private List<String[]> datosProyectoList;
    private String aprobacion = "";
    private String justificacion = "";
    private SegUsuario usuario;
    private CalificacionComision calificacionConvocatoria;

    @EJB
    private CalificacionComisionFacade calificacionConvocatoriaFacade;
    private List<CalificacionComision> calificacionList;
    private BigDecimal idProyecto;
    
    /// Notas Conceptuales Aprobadas
    @EJB
    private AprobacionDirectorDepartamentoFacade apruebaNCFacade;
    private AprobacionDirectorDepartamento apruebaNc;
    private AprobacionDirectorDepartamento apruebaNcSelected;
    private List<AprobacionDirectorDepartamento> apruebaNCLits;
    
    ///Responsable Proyecto
    @EJB
    private SeaResponsableProgFacade responProgFacade;
    private SeaResponsableProg responProg;
    private String nombreArchivoPdf;
    private Integer indice;
    
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }

    public String inicioConvocatorias() {
        if (botonInicio) {
            /// regresar a lista de programas 
            System.out.println(" boton1 " + botonInicio);
            habilitaTab = true;

        } else {
            //// es nuevo 
            System.out.println(" boton 2" + botonInicio);

        }
        return "";

    }

    public String seleccionaConvo() {
        botonInicio = false;
        //habilitaTab = false;
        cargaDatosConvoca();
        return "";
    }
    /////////////Funciones
    void checkIngreso() {
        //usuarioList = usuarioFacade.findAll();
        convocatoriaList = convocatoriaFacade.findConvocatoriaByUsuId(usuario.getUsuId());
    }

    public void cargaDatosConvoca() {
        indice = 0;
        //tab1
        aprobacion="";
        justificacion="";
        datosProyectoList = proyectoFacade.findCalificacionProyectoByConvocat(convocatoriaSelected.getConvocaId());
        
        if (datosProyectoList.isEmpty()){
            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('No se ha ingresado los datos del proyecto')");
        }
        
        //calificacionList = calificacionConvocatoriaFacade.findCalificaByConvocatoria(convocatoriaSelected.getConvocaId());

        if (!calificacionList.isEmpty()) {
            aprobacion = calificacionList.get(0).getEstado();
            if (calificacionList.get(0).getEstado().equals("N")){
                justificacion = calificacionList.get(0).getJustificacion();
            }
        }
        if(convocatoriaSelected != null){
            apruebaNCLits = apruebaNCFacade.findNotasAprobadasByCodConv(convocatoriaSelected.getConvocaId());
        }

    }

    //funciones tab1
    public String registraP1() {
        if (calificacionConvocatoria == null) {
            calificacionConvocatoria = new CalificacionComision();
            calificacionConvocatoria.setUsuario(usuario);
            //calificacionConvocatoria.setConvocaId(convocatoriaSelected);
            calificacionConvocatoria.setEstado(aprobacion);
            calificacionConvocatoria.setJustificacion(justificacion);
        }
        ///registra nuevo               
        /*if (calificacionConvocatoriaFacade.findCalificaByConvocatoria(convocatoriaSelected.getConvocaId()).size() > 0) {
            calificacionConvocatoriaFacade.edit(calificacionConvocatoria);
        } else {
            calificacionConvocatoriaFacade.create(calificacionConvocatoria);
//                    cancelarP1();
        }*/
        cargaDatosConvoca();
        return "";
    }

    public void cancelarP1() {
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        validaVaciosP1 = true;
        calificacionConvocatoria = null;
        //convocatoria = "";
        justificacion = "";
        //tipoInvestigacion = "";
        aprobacion = "";

        //estado = "";
    }
    public void generarReportePDF() throws SQLException, JRException{
        if(apruebaNcSelected != null){
            idProyecto = apruebaNcSelected.getNotaConceptual().getDatgeproyId();
            System.out.println("idProyecto" + idProyecto);
        }
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/NotasConceptualesCalificacion.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        System.out.println("logo " + logo );
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("DATGEPROY_ID",idProyecto.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        System.out.println("real path   1111 "+realPath);
        exporter.exportReport();
        System.out.println(" exportes  "+exporter);
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
        System.out.println("salio");
        controlPDF = true;
        indice = 1;
        habilitaTab = false;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter y Setter">    
    //getter y setter seleccion convocatoria
    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }

    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public SeaConvoca getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(SeaConvoca convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }

    //getter y setter seleccion tab 1
    public boolean isControlGrabarP1() {
        return controlGrabarP1;
    }

    public void setControlGrabarP1(boolean controlGrabarP1) {
        this.controlGrabarP1 = controlGrabarP1;
    }

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public List<String[]> getDatosProyectoList() {
        return datosProyectoList;
    }

    public void setDatosProyectoList(List<String[]> datosProyectoList) {
        this.datosProyectoList = datosProyectoList;
    }

    public List<CalificacionComision> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<CalificacionComision> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    public boolean isControlPDF() {
        return controlPDF;
    }

    public BigDecimal getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }
    
    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }
    public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }
    /// get and set aprueba Nc
    public List<AprobacionDirectorDepartamento> getApruebaNCLits() {
        return apruebaNCLits;
    }

    public void setApruebaNCLits(List<AprobacionDirectorDepartamento> apruebaNCLits) {
        this.apruebaNCLits = apruebaNCLits;
    }
    public AprobacionDirectorDepartamento getApruebaNcSelected() {
        return apruebaNcSelected;
    }

    public void setApruebaNcSelected(AprobacionDirectorDepartamento apruebaNcSelected) {
        this.apruebaNcSelected = apruebaNcSelected;
    }
    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }
     public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }
    
   
//</editor-fold>   
}
