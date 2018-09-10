/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.investigacion.utils.FacesUtils;
import ec.edu.espe_ctt.investigacion.utils.JasperReportUtil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupNotasc;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.VDirectFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPresupNotascFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaAnualFacade;
import ec.edu.espe_ctt_investigacion.session.VDirectFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteDeptoBFacade;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
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
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ReportesInvestigacionController implements Serializable {

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath = "";
    private boolean controlPDF = false;
    private String nombreArchivoPdf;
    private String nombreArchivoXlsx;

    /**
     * Creates a new instance of ReportesInvestigacionController
     */
    public ReportesInvestigacionController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    //public  boolean controlPDF = false;

    /// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGeneralProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    private SeaDatGeneralProy datGeneralProySelected;
    private List<SeaDatGeneralProy> notaConceptualList;
    private String estadoNotaConceptual;
    private String catalogoInvest;
    private boolean validaVaciosP1 = true;
    private boolean controlNotasCI;
    private boolean controlNotasCT;
    private String idNotaConceptual;
    private String idFormatoLargo;
    private BigDecimal idDocente;
    private BigDecimal idUsuario;
    private Integer indexTabs;
    private String tipoDocumento;

    ///Vista Docente DeptoB
    @EJB
    private VDocenteDeptoBFacade vDocenteDeptoBFacade;
    private VDocenteDeptoB vDocenteDeptoB;

    ///Formato Largo
    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private SeaFormatoLargo formatoLargoSelected;
    private List<SeaFormatoLargo> formatoLargoList;

    //private List<String[]> datosProyectoList;
    private boolean habilitaTab18 = false;
    private boolean habilitaTab19 = false;
    private boolean habilitaTab20 = false;
    private boolean habilitaTab21 = false;
    private boolean habilitaTab22 = false;
    private boolean habilitaTab23 = false;

    ///Presupuesto Nota Conceptual
    @EJB
    private SeaPresupNotascFacade presupNotasCFacade;
    private SeaPresupNotasc presupNotasC;
    private List<SeaPresupNotasc> presupNotasCList;

    /// Presupuesto por Partida
    @EJB
    private PresupuestoPartidaFacade presupuestoXPartidaFacade;
    private PresupuestoPartida presupuestoXPartida;
    private List<PresupuestoPartida> presupuestoXPartidaList;

    /// Programa Anula de Inversion
    @EJB
    private SeaProgramaAnualFacade programAnualFacade;
    private SeaProgramaAnual programAnual;
    private List<SeaProgramaAnual> programAnuaList;

    /// Convocatoria
    @EJB
    private SeaConvocaFacade convocaFacade;
    private SeaConvoca convocaSelected;
    private BigDecimal idConvocatoria1;
    private BigDecimal idConvocatoria2;
    private BigDecimal idConvocatoria3;
    private BigDecimal idConvocatoria4;
    private BigDecimal idConvocatoria5;
    private BigDecimal idConvocatoria6;
    private List<SeaConvoca> convocatoriaList;

    /// Vista Formato Largo, Director de Proyecto
    @EJB
    private VDirectFormatoLargoFacade vDirectFormatoLargoFacade;
    private VDirectFormatoLargo vDirectFormatoLargo;
    private VDirectFormatoLargo directFrmtLargoSelected;
    private List<VDirectFormatoLargo> directFormatoLargoList;

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        convocatoriaList = convocaFacade.findConvocatoria();
        indexTabs = 0;
        onTabChange(null);
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void listarNotasConceptuales() {
        notaConceptualList = datGeneralProyFacade.findNotasConceptuales(estadoNotaConceptual, idConvocatoria2);
    }

    public void listarNotasConceptualesPresupuesto() {
        notaConceptualList = datGeneralProyFacade.findNotasConceptuales(estadoNotaConceptual, idConvocatoria3);
    }

    public void generaReporteNotasCPDF() throws SQLException, JRException {
        datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(datGeneralProySelected.getConvocaId().getConvocaId(), datGeneralProySelected.getDatgeproyId());
        idNotaConceptual = datGeneralProy.getDatgeproyId().toString();
        idUsuario = datGeneralProy.getUsuId().getUsuId();
        vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
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
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", idNotaConceptual.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
        controlPDF = true;
        indexTabs = 18;
        habilitaTab18 = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteNotasCPDF2(String tipoReporte, SeaDatGeneralProy notaConceptual) throws SQLException, JRException {
        try {
            datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(notaConceptual.getConvocaId().getConvocaId(), notaConceptual.getDatgeproyId());
            idNotaConceptual = datGeneralProy.getDatgeproyId().toString();
            idUsuario = datGeneralProy.getUsuId().getUsuId();
            vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
            if (vDocenteDeptoB != null) {
                idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
            } else {
                idDocente = new BigDecimal(1);
            }

            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes") + "/");
            parametros.put("SUBREPORT_DIR", realPath + "/");
            parametros.put("STVCAMP_CODE", idDocente);
            parametros.put("DATGEPROY_ID", idNotaConceptual);

            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_NOTA_CONCEPTUAL, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generarReportePresupuestoNC(SeaDatGeneralProy presupNC, String tipo) {
        try {
            datGeneralProySelected = presupNC;
            datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(datGeneralProySelected.getConvocaId().getConvocaId(), datGeneralProySelected.getDatgeproyId());
            idNotaConceptual = datGeneralProy.getDatgeproyId().toString();
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/presupuesto_nota_conceptual");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/presupuesto_nota_conceptual.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            parametros.put("DATGEPROY_ID", idNotaConceptual.toString());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            ///Verificar si tiene o no Informacion
            presupNotasCList = presupNotasCFacade.findPresupuestoNotasCByProyId(new BigDecimal(idNotaConceptual));
            if (presupNotasCList.size() > 0) {
                if (tipo.equals("pdf")) {
                    nombreArchivoPdf = nombreRandomico + ".pdf";
                    JRExporter exporter = new JRPdfExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                    exporter.exportReport();
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                    FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                    connection.close();
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoPdf))), "application/octet-stream", nombreArchivoPdf);
                } else if (tipo.equals("xls")) {
                    nombreArchivoXlsx = nombreRandomico + ".xls";
                    JRXlsxExporter exporter = new JRXlsxExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                    exporter.exportReport();
                    connection.close();
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);
                }
            } else {
                RequestContext.getCurrentInstance().execute("alert('Presupuesto Nota Conceptual no esta lleno')");
                return;
            }
        } catch (Exception e) {
        }
    }

    public void generarReportePresupuestoNC2(String tipoReporte, SeaDatGeneralProy notaConceptual) throws SQLException, JRException {
        try {
            //Verificar si tiene o no Informacion
            //presupNotasCList = presupNotasCFacade.findPresupuestoNotasCByProyId(notaConceptual.getDatgeproyId());
            //if (presupNotasCList.size() > 0) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/presupuesto_nota_conceptual");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes") + "/");
            parametros.put("DATGEPROY_ID", notaConceptual.getDatgeproyId().toString());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PRESUPUESTO_NOTA_CONCEPTUAL, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
            /*} else {
                RequestContext.getCurrentInstance().execute("alert('Presupuesto Nota Conceptual no esta lleno')");
                return;
            }*/
        } catch (Exception e) {
        }

    }

    public void generaReporteNotasAceptadas() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/notas_conceptuales_aprobadas");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/notas_conceptuales_aprobadas.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteNotasAceptadas2(String tipoReporte) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes/notas_conceptuales_aprobadas") + "/");
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_NOTAS_CONCEPTUALES_APROBADAS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void listarFormatoExtenso() {
        //directFormatoLargoList = vDirectFormatoLargoFacade.findFormatoLargo(idConvocatoria4);
        formatoLargoList = formatoLargoFacade.findByConvocatoria(idConvocatoria4);
    }

    public void listarFormatoExtensoSeguimientoTecnico() {
        directFormatoLargoList = vDirectFormatoLargoFacade.findFormatoLargo(idConvocatoria5);
    }

    public void generarReporteFormatoLPdf() throws SQLException, JRException {
        idFormatoLargo = formatoLargoSelected.getSflId().toString();
        idNotaConceptual = formatoLargoSelected.getDatgeproyId().getDatgeproyId().toString();
        idUsuario = formatoLargoSelected.getDatgeproyId().getUsuId().getUsuId();
        vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/proyecto_largo");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/proyecto_largo.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", idNotaConceptual);
        parametros.put("SFL_ID", idFormatoLargo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        indexTabs = 19;
        habilitaTab19 = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generarReporteFormatoLPdf2(String tipoReporte, SeaFormatoLargo formatoExtenso) throws SQLException, JRException {
        try {
            datGeneralProy = formatoExtenso.getDatgeproyId();
            idUsuario = datGeneralProy.getUsuId().getUsuId();
            vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
            if (vDocenteDeptoB != null) {
                idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
            } else {
                idDocente = new BigDecimal(1);
            }

            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/proyecto_largo");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", realPath + "/");
            parametros.put("SUBREPORT_DIR", realPath + "/");
            parametros.put("STVCAMP_CODE", idDocente);
            parametros.put("DATGEPROY_ID", datGeneralProy.getDatgeproyId().toString());
            parametros.put("SFL_ID", formatoExtenso.getSflId().toString());

            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_FORMATO_EXTENSO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReporteInvestigadorXProy() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/investigadores_por_proyecto");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/investigadores_por_poyecto.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteProyectoXDpto() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/proyectos_por_departamento");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/proyectos_por_departamento.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteInvestigadorXGenero() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/total_investigadores_genero");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/investigadores_genero.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReportEstudiantesXGenero() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/total_estudiantes_genero");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/estudiantes_genero.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReportePresupuestoXPartida(VDirectFormatoLargo presPartd, String tipo) throws SQLException, JRException {
        try {
            directFrmtLargoSelected = presPartd;
            idFormatoLargo = directFrmtLargoSelected.getSflId().toString();
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/presupuesto_partida");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/presupuesto_partida.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            parametros.put("SFL_ID", idFormatoLargo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            /// Verificar si el Proyecto Ingreso el Presupuesto por Partida
            presupuestoXPartidaList = presupuestoXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(new BigDecimal(idFormatoLargo));
            if (presupuestoXPartidaList.size() > 0) {
                if (tipo.equals("pdf")) {
                    nombreArchivoPdf = nombreRandomico + ".pdf";
                    JRExporter exporter = new JRPdfExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                    exporter.exportReport();
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                    FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                    connection.close();
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoPdf))), "application/octet-stream", nombreArchivoPdf);
                } else if (tipo.equals("xls")) {
                    nombreArchivoXlsx = nombreRandomico + ".xls";
                    JRXlsxExporter exporter = new JRXlsxExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                    exporter.exportReport();
                    connection.close();
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);
                }
            } else {
                RequestContext.getCurrentInstance().execute("alert('Presupuesto por Partida no esta lleno')");
                return;
            }
        } catch (Exception e) {
        }
    }

    public void generaReportePresupuestoXPartida2(String tipoReporte, VDirectFormatoLargo vDirectFormatoLargo) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/presupuesto_partida");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", realPath + "/");
            parametros.put("SFL_ID", vDirectFormatoLargo.getSflId().toString());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PRESUPUESTO_PARTIDA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReporteProgramAnualInversion(VDirectFormatoLargo progrInv, String tipo) throws SQLException, JRException {
        try {
            directFrmtLargoSelected = progrInv;
            idFormatoLargo = directFrmtLargoSelected.getSflId().toString();
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/programa_inversion");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/programa_inversion.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            parametros.put("SFL_ID", idFormatoLargo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            /// Verificar si el proyecto tiene ingresado el programa anual de inversion
            programAnuaList = programAnualFacade.findProgramaAnualByFormatoCronograma(new BigDecimal(idFormatoLargo));
            if (programAnuaList.size() > 0) {
                if (tipo.equals("pdf")) {
                    nombreArchivoPdf = nombreRandomico + ".pdf";
                    JRExporter exporter = new JRPdfExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                    exporter.exportReport();
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                    FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                    FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                    connection.close();
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoPdf))), "application/octet-stream", nombreArchivoPdf);
                } else if (tipo.equals("xls")) {
                    nombreArchivoXlsx = nombreRandomico + ".xls";
                    JRXlsxExporter exporter = new JRXlsxExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                    exporter.exportReport();
                    connection.close();
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                    this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);

                }
            } else {
                RequestContext.getCurrentInstance().execute("alert('Programa de Inversión no esta lleno')");
                return;
            }
        } catch (Exception e) {
        }
    }

    public void generaReporteProgramAnualInversion2(String tipoReporte, VDirectFormatoLargo vDirectFormatoLargo) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/programa_inversion");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", realPath + "/");
            parametros.put("SFL_ID", vDirectFormatoLargo.getSflId().toString());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROGRAMA_ANUAL_INVERSION, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReporteSeguimiento() throws SQLException, JRException {
        idFormatoLargo = directFrmtLargoSelected.getSflId().toString();
        datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(new BigDecimal(directFrmtLargoSelected.getConvocaId()), new BigDecimal(directFrmtLargoSelected.getDatgeproyId()));
        idNotaConceptual = datGeneralProy.getDatgeproyId().toString();
        idUsuario = datGeneralProy.getUsuId().getUsuId();
        vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/seguimineto");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/seguimiento.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        System.out.println("logo " + logo);
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", idNotaConceptual.toString());
        parametros.put("SFL_ID", idFormatoLargo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        indexTabs = 20;
        habilitaTab20 = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteSeguimiento2(String tipoReporte, VDirectFormatoLargo formatoExtenso) throws SQLException, JRException {
        try {
            datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(new BigDecimal(formatoExtenso.getConvocaId()), new BigDecimal(formatoExtenso.getDatgeproyId()));
            idUsuario = datGeneralProy.getUsuId().getUsuId();
            vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
            if (vDocenteDeptoB != null) {
                idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
            } else {
                idDocente = new BigDecimal(1);
            }
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/seguimineto");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", realPath + "/");
            parametros.put("SUBREPORT_DIR", realPath + "/");
            parametros.put("STVCAMP_CODE", idDocente);
            parametros.put("DATGEPROY_ID", datGeneralProy.getDatgeproyId().toString());
            parametros.put("SFL_ID", formatoExtenso.getSflId().toString());

            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_SEGUIMIMIENTO_FORMATO_EXTENSO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReportePortafolioPry(String tipo) {
        try {
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/Reporte Nota C Terminadas.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            if (tipo.equals("pdf")) {
                nombreArchivoPdf = nombreRandomico + ".pdf";
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                exporter.exportReport();
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                connection.close();
                this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoPdf))), "application/octet-stream", nombreArchivoPdf);
            } else if (tipo.equals("xls")) {
                nombreArchivoXlsx = nombreRandomico + ".xlsx";
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                exporter.exportReport();
                connection.close();
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);
            }
        } catch (Exception e) {

        }
    }

    public void generaReportePortafolioPry2(String tipoReporte) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", realPath + "/");
            //parametros.put("idConvocatoria1", convocaSelected == null ? null : convocaSelected.getConvocaId());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROYECTOS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReporteConvocatoria() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/Reporte_Convoca");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/convocatoria.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("CONVOCA_ID", convocaSelected.getConvocaId().toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
        controlPDF = true;
        //indexTabs = 21;
        habilitaTab21 = true;
    }

    public void generaReporteConvocatoria2(String tipoReporte, SeaConvoca convoca) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/Reporte_Convoca");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes/Reporte_Convoca") + "/");
            parametros.put("SUBREPORT_DIR", realPath + "/");
            parametros.put("CONVOCA_ID", convoca.getConvocaId().toString());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CONVOCATORIA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception e) {
        }

    }

    public void generaReporteCatalogos() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        if (catalogoInvest.equals("L")) {
            realPath = servletContext.getRealPath("/reportes/Catalogos_Investigacion");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreArchivoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/lineas_sublineas.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
            exporter.exportReport();
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            connection.close();
            controlPDF = true;
        }
        if (catalogoInvest.equals("E")) {
            realPath = servletContext.getRealPath("/reportes/Catalogos_Investigacion");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreArchivoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/estrategias.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
            exporter.exportReport();
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            connection.close();
            controlPDF = true;
        }
        if (catalogoInvest.equals("O")) {
            realPath = servletContext.getRealPath("/reportes/Catalogos_Investigacion");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreArchivoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/obj_buen_vivir.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
            exporter.exportReport();
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            connection.close();
            controlPDF = true;
        }
        if (catalogoInvest.equals("P")) {
            realPath = servletContext.getRealPath("/reportes/Catalogos_Investigacion");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreArchivoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/politicas.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
            exporter.exportReport();
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            connection.close();
            controlPDF = true;
        }
    }

    public void generaReporteCatalogos2(String tipoReporte) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes/Catalogos_Investigacion") + "/");
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            if (catalogoInvest.equals("L")) {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CATALOGO_INVESTIGACION_LINEAS_SUBLINEAS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
            } else if (catalogoInvest.equals("E")) {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CATALOGO_INVESTIGACION_ESTRATEGIAS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
            } else if (catalogoInvest.equals("O")) {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CATALOGO_INVESTIGACION_OBJETIVOS_BVIVIR, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
            } else if (catalogoInvest.equals("P")) {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CATALOGO_INVESTIGACION_POLITICAS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
            }
        } catch (Exception e) {
        }

    }

    public void generaReporteActaLiquidacion() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/liquidacion_proyecto");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/liquidacion_proyecto.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("SFL_ID", formatoLargoSelected.getSflId().toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
        controlPDF = true;
        //indexTabs = 22;
        habilitaTab22 = true;
    }

    public void generaReporteActaCierre() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/acta_cierre_proyecto");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/acta_cierre.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("SFL_ID", formatoLargoSelected.getSflId().toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
        controlPDF = true;
        //indexTabs = 23;
        habilitaTab23 = true;
    }

    public void generaReporteProyectosXConvoca() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/listado_proyectos");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/listado_proyectos.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;
        jasperPrint = null;
        jasperReport = null;
        parametros = null;
        request = null;
    }

    public void generaReporteProyectosXConvoca2(String tipoReporte) throws SQLException, JRException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG);
            parametros.put("path", servletContext.getRealPath("/reportes/listado_proyectos") + "/");
            parametros.put("idConvocatoria", idConvocatoria1);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROYECTOS_POR_CONVOCATORIA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);

        } catch (Exception e) {
        }

    }

    public void generaReporteProyectosPortafolio(String tipo) {
        try {
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes/portafolio_proyectos");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/portafolio_proyectos.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            if (tipo.equals("pdf")) {
                nombreArchivoPdf = nombreRandomico + ".pdf";
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                exporter.exportReport();
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                connection.close();
                this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoPdf))), "application/octet-stream", nombreArchivoPdf);
            } else if (tipo.equals("xls")) {
                nombreArchivoXlsx = nombreRandomico + ".xlsx";
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                exporter.exportReport();
                connection.close();
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);
            }
        } catch (Exception e) {
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// get and set tabP1
    public List<SeaDatGeneralProy> getNotaConceptualList() {
        return notaConceptualList;
    }

    public void setNotaConceptualList(List<SeaDatGeneralProy> notaConceptualList) {
        this.notaConceptualList = notaConceptualList;
    }

    public SeaDatGeneralProy getDatGeneralProySelected() {
        return datGeneralProySelected;
    }

    public void setDatGeneralProySelected(SeaDatGeneralProy datGeneralProySelected) {
        this.datGeneralProySelected = datGeneralProySelected;
    }

    public String getEstadoNotaConceptual() {
        return estadoNotaConceptual;
    }

    public void setEstadoNotaConceptual(String estadoNotaConceptual) {
        this.estadoNotaConceptual = estadoNotaConceptual;
    }

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public boolean isControlNotasCI() {
        return controlNotasCI;
    }

    public void setControlNotasCI(boolean controlNotasCI) {
        this.controlNotasCI = controlNotasCI;
    }

    public boolean isControlNotasCT() {
        return controlNotasCT;
    }

    public void setControlNotasCT(boolean controlNotasCT) {
        this.controlNotasCT = controlNotasCT;
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

    public Integer getIndexTabs() {
        return indexTabs;
    }

    public void setIndexTabs(Integer indexTabs) {
        this.indexTabs = indexTabs;
    }

    /// get and Set tabP3
    public List<VDirectFormatoLargo> getDirectFormatoLargoList() {
        return directFormatoLargoList;
    }

    public void setDirectFormatoLargoList(List<VDirectFormatoLargo> directFormatoLargoList) {
        this.directFormatoLargoList = directFormatoLargoList;
    }

    public VDirectFormatoLargo getDirectFrmtLargoSelected() {
        return directFrmtLargoSelected;
    }

    public void setDirectFrmtLargoSelected(VDirectFormatoLargo directFrmtLargoSelected) {
        this.directFrmtLargoSelected = directFrmtLargoSelected;
    }

    public List<SeaFormatoLargo> getFormatoLargoList() {
        return formatoLargoList;
    }

    public void setFormatoLargoList(List<SeaFormatoLargo> formatoLargoList) {
        this.formatoLargoList = formatoLargoList;
    }

    public SeaFormatoLargo getFormatoLargoSelected() {
        return formatoLargoSelected;
    }

    public void setFormatoLargoSelected(SeaFormatoLargo formatoLargoSelected) {
        this.formatoLargoSelected = formatoLargoSelected;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public SeaConvoca getConvocaSelected() {
        return convocaSelected;
    }

    public void setConvocaSelected(SeaConvoca convocaSelected) {
        this.convocaSelected = convocaSelected;
    }

    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public String getCatalogoInvest() {
        return catalogoInvest;
    }

    public void setCatalogoInvest(String catalogoInvest) {
        this.catalogoInvest = catalogoInvest;
    }

    public boolean isHabilitaTab18() {
        return habilitaTab18;
    }

    public void setHabilitaTab18(boolean habilitaTab18) {
        this.habilitaTab18 = habilitaTab18;
    }

    public boolean isHabilitaTab19() {
        return habilitaTab19;
    }

    public void setHabilitaTab19(boolean habilitaTab19) {
        this.habilitaTab19 = habilitaTab19;
    }

    public boolean isHabilitaTab20() {
        return habilitaTab20;
    }

    public void setHabilitaTab20(boolean habilitaTab20) {
        this.habilitaTab20 = habilitaTab20;
    }

    public boolean isHabilitaTab21() {
        return habilitaTab21;
    }

    public void setHabilitaTab21(boolean habilitaTab21) {
        this.habilitaTab21 = habilitaTab21;
    }

    public boolean isHabilitaTab22() {
        return habilitaTab22;
    }

    public void setHabilitaTab22(boolean habilitaTab22) {
        this.habilitaTab22 = habilitaTab22;
    }

    public boolean isHabilitaTab23() {
        return habilitaTab23;
    }

    public void setHabilitaTab23(boolean habilitaTab23) {
        this.habilitaTab23 = habilitaTab23;
    }

    //</editor-fold>
//ejemplo igual EDGAR
    public void reporte(SeaDatGeneralProy seaDatGeneralProy) {
        try {
            datGeneralProySelected = seaDatGeneralProy;
            datGeneralProy = datGeneralProyFacade.findProyectoByCodConCodProy(datGeneralProySelected.getConvocaId().getConvocaId(), datGeneralProySelected.getDatgeproyId());
            idNotaConceptual = datGeneralProy.getDatgeproyId().toString();
            idUsuario = datGeneralProy.getUsuId().getUsuId();
            vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
            if (vDocenteDeptoB != null) {
                idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
            } else {
                idDocente = new BigDecimal(1);
            }
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/reportGrupNotasConceptuales.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("dirPhoto", logo + "/");
            parametros.put("SUBREPORT_DIR", realPath + "/");
            parametros.put("STVCAMP_CODE", idDocente);
            parametros.put("DATGEPROY_ID", idNotaConceptual.toString());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            if (tipoDocumento.equals("pdf")) {
                nombreArchivoPdf = nombreRandomico + ".pdf";
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                exporter.exportReport();
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                connection.close();
                //controlPDF = true;
            } else if (tipoDocumento.equals("xls")) {
                nombreArchivoXlsx = nombreRandomico + ".xls";
                System.out.println("nombreArchivoXlsx" + nombreArchivoXlsx);
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoXlsx));
                exporter.exportReport();
//            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
//            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
//            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
//            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/xlsx");
                connection.close();
                // controlPDF = true;
            }
            /*
             JRXlsxExporter exporter = new JRXlsxExporter();
             exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
             exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
             exporter.exportReport();
             */

            //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
            /*indexTabs = 12;
             habilitaTab12 = true;
             jasperPrint = null;
             jasperReport = null;
             parametros = null;
             request = null;*/
            //ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //String path = servletContext.getRealPath("") + separatorChar + anexoProyecto.getArchivoUrlFinal();
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(realPath + "/" + nombreArchivoXlsx))), "application/octet-stream", nombreArchivoXlsx);
        } catch (Exception e) {

        }

    }
    private StreamedContent archivoAdjunto;

    public StreamedContent getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(StreamedContent archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public void onTabChange(TabChangeEvent event) {
        if (event==null){
            formatoLargoList = formatoLargoFacade.findByConvocatoria(idConvocatoria4);
        }else{
        String[] temp = event.getTab().getClientId().split(":");
        String id = temp[temp.length - 1];
        switch (id) {
            case "tabProyectos":
                formatoLargoList = formatoLargoFacade.findByConvocatoria(idConvocatoria4);
                break;
            case "tabCatalogos":
                catalogoInvest = "L";
                break;
            case "tabConvocatorias":
                convocatoriaList = convocaFacade.findConvocatoria();
                break;
            case "tabProyectosConvocatoria":
                convocatoriaList = convocaFacade.findConvocatoria();
                idConvocatoria1 = null;
                break;
            case "tabPresupuesto":
                notaConceptualList = new ArrayList<>();
                idConvocatoria3 = null;
                estadoNotaConceptual = SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL.toString();
                break;
            case "tabAprobacion":
                break;
            case "tabInvestigadores":
                break;
            case "tabProyectosDepartamento":
                break;
            case "tabInvestigadoresGenero":
                break;
            case "tabEstudiantesGenero":
                break;
            case "tabPresupuestoPartida":
                directFormatoLargoList = vDirectFormatoLargoFacade.findFormatoLargo(null);
                break;
            case "tabSeguimientoTecnico":
                idConvocatoria5 = null;
                directFormatoLargoList = new ArrayList<>();

                break;
            case "tabProyectosConsolidado":
                idConvocatoria6 = null;

                break;
            case "tabPortafolioProyectos":
                break;
            case "tabActaLiquidacion":
                formatoLargoList = formatoLargoFacade.findFormatoLargo();
                break;
            case "tabActaCierre":
                formatoLargoList = formatoLargoFacade.findFormatoLargo();
                break;

        }     
        }
       
    }

    public void cambiarTabIndex() {
        controlPDF = false;
        if (indexTabs.equals(0)) {//Catalogos de Investigacion
            catalogoInvest = "L";
        } else if (indexTabs.equals(1)) {//Convocatoria
            //convocatoriaList = convocaFacade.findConvocatoria();
        } else if (indexTabs.equals(2)) {//Listado de proyectos por convocatoria
            //convocatoriaList = convocaFacade.findConvocatoria();
            idConvocatoria1 = null;
        } else if (indexTabs.equals(3)) {//Notas conceptuales
            //convocatoriaList = convocaFacade.findConvocatoria();
            notaConceptualList = new ArrayList<>();
            //estadoNotaConceptual = "I";
            estadoNotaConceptual = SeaDatGeneralProy.ESTADO_INGRESO_PERFIL.toString();
            idConvocatoria2 = null;
        } else if (indexTabs.equals(4)) {//Presupuesto Nota conceptual
            //convocatoriaList = convocaFacade.findConvocatoria();
            notaConceptualList = new ArrayList<>();
            idConvocatoria3 = null;
            //estadoNotaConceptual = "T";
            estadoNotaConceptual = SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL.toString();
        } else if (indexTabs.equals(6)) //Formato0 extenso 
        {
            //convocatoriaList = convocaFacade.findConvocatoria();
            idConvocatoria4 = null;
            directFormatoLargoList = new ArrayList<>();
        } else if (indexTabs.equals(11) //Presupuesto por partida
                || indexTabs.equals(12) //Programa anual de inversion
                ) {
            directFormatoLargoList = vDirectFormatoLargoFacade.findFormatoLargo(null);
        } else if (indexTabs.equals(13)) //Seguimiento tecnico de proyectos
        {
            //convocatoriaList = convocaFacade.findConvocatoria();
            idConvocatoria5 = null;
            directFormatoLargoList = new ArrayList<>();
        } else if (indexTabs.equals(14)) //Listado de proyectos
        {
            //convocatoriaList = convocaFacade.findConvocatoria();
            idConvocatoria6 = null;
        } else if (indexTabs.equals(16) //Acta de liquidacion del proyecto 
                || indexTabs.equals(17) //Acta de cierre del proyecto
                ) {
            formatoLargoList = formatoLargoFacade.findFormatoLargo();
        }

    }

    public BigDecimal getIdConvocatoria1() {
        return idConvocatoria1;
    }

    public void setIdConvocatoria1(BigDecimal idConvocatoria1) {
        this.idConvocatoria1 = idConvocatoria1;
    }

    public BigDecimal getIdConvocatoria2() {
        return idConvocatoria2;
    }

    public void setIdConvocatoria2(BigDecimal idConvocatoria2) {
        this.idConvocatoria2 = idConvocatoria2;
    }

    public BigDecimal getIdConvocatoria3() {
        return idConvocatoria3;
    }

    public void setIdConvocatoria3(BigDecimal idConvocatoria3) {
        this.idConvocatoria3 = idConvocatoria3;
    }

    public BigDecimal getIdConvocatoria4() {
        return idConvocatoria4;
    }

    public void setIdConvocatoria4(BigDecimal idConvocatoria4) {
        this.idConvocatoria4 = idConvocatoria4;
    }

    public BigDecimal getIdConvocatoria5() {
        return idConvocatoria5;
    }

    public void setIdConvocatoria5(BigDecimal idConvocatoria5) {
        this.idConvocatoria5 = idConvocatoria5;
    }

    public BigDecimal getIdConvocatoria6() {
        return idConvocatoria6;
    }

    public void setIdConvocatoria6(BigDecimal idConvocatoria6) {
        this.idConvocatoria6 = idConvocatoria6;
    }

}
