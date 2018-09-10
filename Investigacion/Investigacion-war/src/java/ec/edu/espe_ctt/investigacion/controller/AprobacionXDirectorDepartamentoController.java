/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import org.primefaces.model.DefaultStreamedContent;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto;
import ec.edu.espe_ctt_investigacion.session.AprobacionDirectorDepartamentoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.VDirectoresDeptoFacade;
import java.io.ByteArrayInputStream;
import static java.io.File.separatorChar;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import javax.faces.application.FacesMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class AprobacionXDirectorDepartamentoController implements Serializable {

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath = "";
    private StreamedContent media;
    public boolean controlPDF = false;
    private StreamedContent archivoPagLegal;
    private StreamedContent archivoPlanT;

    ////
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private SegUsuario usuarioDirector;

    //// SEADEPCENPROY
    @EJB
    private SeaDepcenproyFacade depCenProyFacade;
    private List<SeaDepcenproy> depCenProyList;
    private SeaDepcenproy depCenProySelected;

    ///Aprueba Notas Conceptuales
    @EJB
    private AprobacionDirectorDepartamentoFacade apruebaNcFacade;
    private String estadoAprueba = "";
    private String observacion = "";
    private Date fechAprueba = null;
    private String fechaAprueba = "";
    private String tipoAprobacion = "";
    private boolean validaVaciosP2 = true;
    private boolean controlTipoAprobacion;
    private boolean controlTipoNoAprobacion;
    private boolean controlGrabarP2 = false;
    private String estadoEdit;
    private boolean habilitaTab = true;
    private BigDecimal totPresupuesto;
    private BigDecimal totalPresupto;
    private BigDecimal montoEspe;
    private BigDecimal montOtras;
    private UploadedFile file;
    private byte[] file1 = null;
    private byte[] filePagL;
    private byte[] filePlanT;

    /// Dat Gen Proy
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    private SeaDatGeneralProy notaConceptualSelected;
    private List<SeaDatGeneralProy> datGenProyList;

    /// Vista Director por Departamento
    @EJB
    private VDirectoresDeptoFacade directorDeptoFacade;
    private VDirectoresDepto directorDepto;
    private String codDepto;

    ///Responsable del Proyecto
    @EJB
    private SeaResponsableProgFacade resProgFacade;
    private SeaResponsableProg responsableProyecto;
    private String nombresDirectorProyecto = "";
    private BigDecimal idUsuario;
    private String nombreArchivoPdf;
    private String nombreCertificadoPdf;
    private String fileCampo;
    private String strPathPDF;
    private String direcCorreo;

    /**
     * Creates a new instance of ReporteNotasConceptualesController
     */
    public AprobacionXDirectorDepartamentoController() {
    }

    public void buttonImprimir_processAction(ActionEvent ae) throws JRException, SQLException, IOException, Exception {
        generarReportePDF();
    }

    @PostConstruct
    public void init() {
        notaConceptualSelected = null;
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        usuarioDirector = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        directorDepto = directorDeptoFacade.findByUsuario(usuario.getUsuId());
        if (directorDepto != null) {
            depCenProyList = depCenProyFacade.findByCampusDepartamento(directorDepto.getCampusId(), directorDepto.getStvsubjCode());
        }
    }


    /*public String seleccioneNotaConceptual() throws JRException, IOException, SQLException {
        inicio = false;
        habilitaTab = false;
        //////
        resProyecto = depCenProyFacade.findCodigoProyectoByCodResp(depCenProySelected.getDepceId());
        if (resProyecto != null) {
            idProyecto = resProyecto.getDatgeproyId().getDatgeproyId();
            datGenProyList = notaConceptualFacade.findDatosProyectoByCodProy(idProyecto);
            responsableProyecto = resProgFacade.findResponsableProyByCodProy(idProyecto);
            if (responsableProyecto != null) {
                idUsuario = responsableProyecto.getUsuIdDocente().getUsuId();
                usuarioDirector = usuarioFacade.findUsuarioByCodId(idUsuario);
                if (usuarioDirector != null) {
                    direcCorreo = usuarioDirector.getUsuEmail();
                    nombresDirectorProyecto = usuarioDirector.getUsuNombres() + ' ' + usuarioDirector.getUsuApellidos();
                }
            }
            if (datGenProyList.size() > 0 && apruebaNcList.size() > 0) {
                System.out.println("calcular el total");
                for (int i = 0; i < datGenProyList.size(); i++) {
                    montoEspe = datGenProyList.get(i).getDatgeproyMontoTotal();
                    montOtras = datGenProyList.get(i).getDatgeproyMontoOtraInst();
                    totPresupuesto = montoEspe.add(montOtras);
                    totalPresupto = totPresupuesto;
                }
            }
        }
        generarReportePDF();
        if ((filePagL = resProyecto.getDatgeproyId().getDatgeproyPaglegDigi()) != null) {
            String nomPagLeg = resProyecto.getDatgeproyId().getDatgeproyPagilegNombre();
            InputStream inputStream = new ByteArrayInputStream(resProyecto.getDatgeproyId().getDatgeproyPaglegDigi());
            archivoPagLegal = new DefaultStreamedContent(inputStream, "application/pdf", nomPagLeg);
        } else {
            RequestContext.getCurrentInstance().execute("alert('No se encuentra Registrado la página Legal')");
        }
        if ((filePlanT = resProyecto.getDatgeproyId().getDatgeproyPlanDigi()) != null) {
            String nomPlanTrab = resProyecto.getDatgeproyId().getDatgeproyPlantNombre();
            InputStream inputStreamPlanT = new ByteArrayInputStream(resProyecto.getDatgeproyId().getDatgeproyPlanDigi());
            archivoPlanT = new DefaultStreamedContent(inputStreamPlanT, "application/pdf", nomPlanTrab);
        } else {
            RequestContext.getCurrentInstance().execute("alert('No se encuentra Registrado el Plan de Trabajo')");
        }

        return "";
    }*/
    public void generarReportePDF() throws JRException, IOException, SQLException {
        BigDecimal idProyecto = null;
        idProyecto = notaConceptualSelected.getDatgeproyId();
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/reportGrupNotasConceptuales.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        System.out.println("logo " + logo);
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("DATGEPROY_ID", idProyecto.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        System.out.println("real path   1111 " + realPath);
        exporter.exportReport();
        System.out.println(" exportes  " + exporter);
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        System.out.println("salio");
        controlPDF = true;
    }
    /// funciones tabP2

    /*public void handleFileUpload(FileUploadEvent event) throws IOException {
        nomFile = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile1(IOUtils.toByteArray(is));
    }
     */
    public void generarCertificadoPDF() throws SQLException, JRException {
        if (notaConceptualSelected.getAprobacionDirectorDepartamento().getId() != null
                && notaConceptualSelected.getAprobacionDirectorDepartamento().getEstado().equals(SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO.toString())) {
            BigDecimal idProyecto = notaConceptualSelected.getDatgeproyId();
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreCertificadoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/memo.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            System.out.println("logo " + logo);
            parametros.put("path", realPath + "/");
            parametros.put("proy", idProyecto.toString());
            parametros.put("respo", 3);
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreCertificadoPdf));
            System.out.println("real path   1111 " + realPath);
            exporter.exportReport();
            System.out.println(" exportes  " + exporter);
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            connection.close();
            System.out.println("salio");
            controlPDF = true;
        }

    }

    public String getDirecCorreo() {
        return direcCorreo;
    }

    /// funcion download
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public void setDirecCorreo(String direcCorreo) {
        this.direcCorreo = direcCorreo;
    }

    public StreamedContent getArchivoPagLegal() {
        return archivoPagLegal;
    }

    public void setArchivoPagLegal(StreamedContent archivoPagLegal) {
        this.archivoPagLegal = archivoPagLegal;
    }

    public StreamedContent getArchivoPlanT() {
        return archivoPlanT;
    }

    public void setArchivoPlanT(StreamedContent archivoPlanT) {
        this.archivoPlanT = archivoPlanT;
    }

    public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }

    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }

    public List<SeaDepcenproy> getDepCenProyList() {
        return depCenProyList;
    }

    public void setDepCenProyList(List<SeaDepcenproy> depCenProyList) {
        this.depCenProyList = depCenProyList;
    }

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }

    public SeaDepcenproy getDepCenProySelected() {
        return depCenProySelected;
    }

    public void setDepCenProySelected(SeaDepcenproy depCenProySelected) {
        this.depCenProySelected = depCenProySelected;
    }

    /// get and set tabP1
    public String getEstadoAprueba() {
        return estadoAprueba;
    }

    public void setEstadoAprueba(String estadoAprueba) {
        this.estadoAprueba = estadoAprueba;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechAprueba() {
        return fechAprueba;
    }

    public void setFechAprueba(Date fechAprueba) {
        this.fechAprueba = fechAprueba;
    }

    public String getFechaAprueba() {
        return fechaAprueba;
    }

    public void setFechaAprueba(String fechaAprueba) {
        this.fechaAprueba = fechaAprueba;
    }

    public String getTipoAprobacion() {
        if (tipoAprobacion != null) {
            if (tipoAprobacion.equalsIgnoreCase("S")) {
                controlTipoAprobacion = true;
            } else {
                controlTipoAprobacion = false;
            }
        } else {
            controlTipoAprobacion = false;
        }
        return tipoAprobacion;
    }

    public void setTipoAprobacion(String tipoAprobacion) {
        this.tipoAprobacion = tipoAprobacion;
    }

    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public boolean isControlTipoAprobacion() {
        return controlTipoAprobacion;
    }

    public void setControlTipoAprobacion(boolean controlTipoAprobacion) {
        this.controlTipoAprobacion = controlTipoAprobacion;
    }

    public boolean isControlTipoNoAprobacion() {
        return controlTipoNoAprobacion;
    }

    public void setControlTipoNoAprobacion(boolean controlTipoNoAprobacion) {
        this.controlTipoNoAprobacion = controlTipoNoAprobacion;
    }

    public boolean isControlGrabarP2() {
        return controlGrabarP2;
    }

    public void setControlGrabarP2(boolean controlGrabarP2) {
        this.controlGrabarP2 = controlGrabarP2;
    }

    public String getEstadoEdit() {
        return estadoEdit;
    }

    public void setEstadoEdit(String estadoEdit) {
        this.estadoEdit = estadoEdit;
    }

    /// get and set para calculo total del dataTable
    public BigDecimal getTotPresupuesto() {
        return totPresupuesto;
    }

    public void setTotPresupuesto(BigDecimal totPresupuesto) {
        this.totPresupuesto = totPresupuesto;
    }

    public List<SeaDatGeneralProy> getDatGenProyList() {
        return datGenProyList;
    }

    public void setDatGenProyList(List<SeaDatGeneralProy> datGenProyList) {
        this.datGenProyList = datGenProyList;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public BigDecimal getTotalPresupto() {
        return totalPresupto;
    }

    public void setTotalPresupto(BigDecimal totalPresupto) {
        this.totalPresupto = totalPresupto;
    }

    public SeaDatGeneralProy getNotaConceptualSelected() {
        return notaConceptualSelected;
    }

    public void setNotaConceptualSelected(SeaDatGeneralProy notaConceptualSelected) {
        this.notaConceptualSelected = notaConceptualSelected;
    }

    public String getNombresDirectorProyecto() {
        return nombresDirectorProyecto;
    }

    public void setNombresDirectorProyecto(String nombresDirectorProyecto) {
        this.nombresDirectorProyecto = nombresDirectorProyecto;
    }

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }

    public String getNombreCertificadoPdf() {
        return nombreCertificadoPdf;
    }

    public void setNombreCertificadoPdf(String nombreCertificadoPdf) {
        this.nombreCertificadoPdf = nombreCertificadoPdf;
    }

    //</editor-fold>
    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    private String pathArchivo;

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    private StreamedContent archivoAceptacion;

    public StreamedContent getArchivoAceptacion() {
        return archivoAceptacion;
    }

    public void setArchivoAceptacion(StreamedContent archivoAceptacion) {
        this.archivoAceptacion = archivoAceptacion;
    }

    public void seleccionarNotaConceptual(SeaDatGeneralProy notaConceptual) {
        try {
            this.notaConceptualSelected = notaConceptual;
            notaConceptualSelected.addAprobacionDirectorDepartamento();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String carpetaAdjuntos = "temp";
            pathArchivo = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos;
            if (!Files.isDirectory(Paths.get(pathArchivo))) {
                Files.createDirectories(Paths.get(pathArchivo));
            }

            if (notaConceptual.getAprobacionDirectorDepartamento().getId() != null) {
                pathArchivo = pathArchivo + separatorChar + notaConceptual.getAprobacionDirectorDepartamento().getArchivoNombre();
                Files.copy(new ByteArrayInputStream(notaConceptual.getAprobacionDirectorDepartamento().getArchivoDigital()), Paths.get(pathArchivo), StandardCopyOption.REPLACE_EXISTING);
            }

            if ((filePagL = notaConceptualSelected.getDatgeproyPaglegDigi()) != null) {
                String nomPagLeg = notaConceptualSelected.getDatgeproyPagilegNombre();
                InputStream inputStream = new ByteArrayInputStream(notaConceptualSelected.getDatgeproyPaglegDigi());
                archivoPagLegal = new DefaultStreamedContent(inputStream, "application/pdf", nomPagLeg);
            }
            if ((filePlanT = notaConceptualSelected.getDatgeproyPlanDigi()) != null) {
                String nomPlanTrab = notaConceptualSelected.getDatgeproyPlantNombre();
                InputStream inputStreamPlanT = new ByteArrayInputStream(notaConceptualSelected.getDatgeproyPlanDigi());
                archivoPlanT = new DefaultStreamedContent(inputStreamPlanT, "application/pdf", nomPlanTrab);
            }
            generarReportePDF();
            generarCertificadoPDF();
            archivoAceptacion = new DefaultStreamedContent(new ByteArrayInputStream(notaConceptual.getAprobacionDirectorDepartamento().getArchivoDigital()), "pplication/octet-stream", notaConceptual.getAprobacionDirectorDepartamento().getArchivoNombre());

        } catch (Exception e) {
        }
    }

    public void guardarAprobacion() {
        try {
            if (notaConceptualSelected.getAprobacionDirectorDepartamento().getEstado().equals(SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO.toString())
                    || notaConceptualSelected.getAprobacionDirectorDepartamento().getEstado().equals(SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO.toString())) {
                notaConceptualSelected.setDatgeproyEstado(notaConceptualSelected.getAprobacionDirectorDepartamento().getEstado().charAt(0));
            } else {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:tabP:selAprobacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar el estado ACEPTADO ó RECHAZADO"));
                return;
            }
            notaConceptualFacade.edit(notaConceptualSelected);
            notaConceptualSelected = notaConceptualFacade.find(notaConceptualSelected.getDatgeproyId());
            modoEdicion = false;
            generarCertificadoPDF();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    public void subirArchivo(FileUploadEvent event) throws IOException {
        InputStream is = event.getFile().getInputstream();
        notaConceptualSelected.getAprobacionDirectorDepartamento().setArchivoDigital(IOUtils.toByteArray(is));
        notaConceptualSelected.getAprobacionDirectorDepartamento().setArchivoNombre(event.getFile().getFileName());
    }

    public void cancelar() {
        modoEdicion = false;
        notaConceptualSelected = notaConceptualFacade.find(notaConceptualSelected.getDatgeproyId());
        notaConceptualSelected.addAprobacionDirectorDepartamento();

    }
}
