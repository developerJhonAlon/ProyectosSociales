/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ReporteNotasCTerminadasController implements Serializable{
    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath ="";
    private StreamedContent media;
    
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private boolean botonInicio = true;
    public  boolean controlPDF = false;
    private String nombreArchivoPdf;
    
    ///Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGenProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    private List<SeaDatGeneralProy> datGeneralProyList;
    private SeaDatGeneralProy datGeneralProySelected;
    
    //</editor-fold>

    /**
     * Creates a new instance of ReporteNotasCTerminadasController
     */
    
    public ReporteNotasCTerminadasController() {
    }
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
    }
    public String inicioProgramas(){
        return "";
    }
    public void generaReporteNotasTPDF() throws SQLException, JRException{
         connection = ds_conn.getConnection();
         HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
         realPath = servletContext.getRealPath("/reportes");
         Date fecha = new Date();
         String nombreRandomico = Long.toString(fecha.getTime());
         nombreArchivoPdf = nombreRandomico + ".pdf";
         JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/Reporte Nota C Terminadas.jasper");
         Map<String, Object> parametros = new HashMap<>();
         String logo = servletContext.getRealPath("/resources/images/");
         System.out.println("logo " + logo);
         parametros.put("path", realPath + "/");
         parametros.put("dirPhoto", logo + "/");
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
         connection.close();
         System.out.println("salio");
         controlPDF = true;
    }
    public void verPDF(ActionEvent actionEvent) throws SQLException, JRException, IOException{
      ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      connection = ds_conn.getConnection();
        realPath = servletContext.getRealPath("/reportes");
        File jasper = new File(realPath + "/reportGrupNotasConceptuales.jasper");
        System.out.println(" jasper " + jasper);
        // JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/prueba3.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/img");
        parametros.put("path", realPath + "/");
        System.out.println(" real path " + realPath);
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, connection);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        try (ServletOutputStream outStream = response.getOutputStream()) {
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
        }
        FacesContext.getCurrentInstance().getResponseComplete();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }
    public List<SeaDatGeneralProy> getDatGeneralProyList() {
        return datGeneralProyList;
    }

    public void setDatGeneralProyList(List<SeaDatGeneralProy> datGeneralProyList) {
        this.datGeneralProyList = datGeneralProyList;
    }
    public SeaDatGeneralProy getDatGeneralProySelected() {
        return datGeneralProySelected;
    }

    public void setDatGeneralProySelected(SeaDatGeneralProy datGeneralProySelected) {
        this.datGeneralProySelected = datGeneralProySelected;
    }
    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }
    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }
    //</editor-fold>

    
    
}
