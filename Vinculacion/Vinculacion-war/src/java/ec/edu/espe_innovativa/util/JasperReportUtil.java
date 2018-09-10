/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.util;

import static ec.edu.espe_innovativa.util.FacesUtils.getServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 *
 * @author ContactCntr4
 */
@ManagedBean
@ApplicationScoped
public class JasperReportUtil extends FacesUtils {

    private static final Logger LOG = Logger.getLogger(JasperReportUtil.class.getName());
    public final static String PATH_APLICACION;
    public final static String PATH = getServletContext().getRealPath("jrxml") + File.separator;
    public final static String PATHIMG;
    public final static String NOMBRE_BEAN;
    public final static String TIPO_PDF;
    public final static String TIPO_XLS;
    public final static String TIPO_WORD;
    public final static String TIPO_HTML;

    public final static String PATH_REPORTE_PERFIL_PROYECTO = PATH + "perfilProyecto.jasper";
    public final static String PATH_REPORTE_PERFIL_PROGRAMA = PATH + "perfilPrograma.jasper";
    /*public final static String PATH_REPORTE_PROGRAMA_ANIO = PATH + "programasAnio.jasper";
    public final static String PATH_REPORTE_AVANCE_PROGRAMA = PATH + "avancePrograma.jasper";
    public final static String PATH_REPORTE_EVALUACION_PROGRAMA = PATH + "evaluacionPrograma.jasper";
    public final static String PATH_REPORTE_RESULTADOS_PROGRAMA = PATH + "resultadosPrograma.jasper";

    public final static String PATH_REPORTE_PROYECTOS_EJECUTADOS = PATH + "proyectosEjecutados.jasper";
    public final static String PATH_REPORTE_APROBACION_PROYECTO = PATH + "aprobacionProyecto.jasper";
    public final static String PATH_REPORTE_PARTICIPACION_DOCENTE = PATH + "proyectosDocentes.jasper";
    public final static String PATH_REPORTE_PARTICIPACION_ESTUDIANTE = PATH + "proyectosEstudiantes.jasper";
    public final static String PATH_REPORTE_BENEFICIARIOS_PROYECTO = PATH + "proyectosBeneficiarios.jasper";
    public final static String PATH_REPORTE_PRESUPUESTO_PROYECTO = PATH + "proyectosPresupuesto.jasper";
    public final static String PATH_REPORTE_AVANCE_PROYECTO = PATH + "proyectosAvance.jasper";
    public final static String PATH_REPORTE_EVALUACION_PROYECTO = PATH + "proyectosEvaluacion.jasper";
    public final static String PATH_REPORTE_RESULTADOS_PROYECTO = PATH + "proyectosResultados.jasper";
    public final static String PATH_REPORTE_CERTIFICADOS_PROYECTO = PATH + "proyectosCertificados.jasper";*/
    public final static String PATH_REPORTE_CERTIFICADO_PARTICIPACION_ESTUDIANTE = PATH + "certificadoEstudiante.jasper";
    public final static String PATH_REPORTE_CERTIFICADO_PARTICIPACION_DOCENTE = PATH + "certificadoDocente.jasper";
    public final static String PATH_REPORTE_ACTA_APROBACION_VICERRECTORADO = PATH + "actaAprobacionVicerrectorado.jasper";
    public final static String PATH_REPORTE_ACTA_DESIGNACION_DOCENTES = PATH + "actaDesignacionDocentes.jasper";
    public final static String PATH_REPORTE_ACTA_DESIGNACION_ESTUDIANTES = PATH + "actaDesignacionEstudiantes.jasper";
    public final static String PATH_REPORTE_CRONOGRAMA = PATH + "cronograma.jasper";

    @Resource(name = "sieval")
    private DataSource sievalDS;

    static {
        PATH_APLICACION = getServletContext().getRealPath("") + File.separator;
        PATHIMG = getServletContext().getRealPath("imagenes") + File.separator;
        NOMBRE_BEAN = "jasperReportUtil";
        TIPO_PDF = "application/pdf";
        TIPO_XLS = "application/vnd.ms-excel";
        TIPO_WORD = "application/rtf";
        TIPO_HTML = "text/html";
    }

    /**
     * Creates a new instance of JasperReportUtil
     */
    public JasperReportUtil() {
    }

    /**
     * Genera el reporte y lo visualiza en el browser.
     *
     * @param urlReporte Path del archivo jasper.
     * @param tipo Tipo de reporte, por el momento solo se generan pdf
     * @param params Parámetros para el reporte
     * @throws ClassNotFoundException
     */
    public void generarReporte(final String urlReporte, String tipo, Map<String, Object> params) throws ClassNotFoundException {
        try {
            ExternalContext econtext = FacesUtils.getExternalContext();
            FacesContext fcontext = super.getFacesContext();
            Connection conn = this.sievalDS.getConnection();
            try {
                JRExporter exporter = null;

                InputStream inputStream = new FileInputStream(urlReporte);
                if (inputStream == null) {
                    throw new ClassNotFoundException("Archivo " + urlReporte + " no se encontró");
                }

                JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, conn);

                HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
                response.setContentType(tipo);
                if ("application/pdf".equals(tipo)) {
                    exporter = new JRPdfExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                }
                if ("text/html".equals(tipo)) {
                    exporter = new JRHtmlExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
                }
                if ("application/rtf".equals(tipo)) {
                    exporter = new JRDocxExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                }
                if ("application/csv".equals(tipo)) {
                    exporter = new JRCsvExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                }
                if ("application/vnd.ms-excel".equals(tipo)) {
                    exporter = new JRXlsExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                    exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                            Boolean.TRUE);
                }
                if (exporter != null) {
                    exporter.exportReport();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                LOG.log(Level.SEVERE, "Error al generar el reporte. ", ex);
            } finally {
                conn.close();
            }
            fcontext.responseComplete();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al ejecutar la sentecia sql del reporte. ", ex);
        }
    }

    public void generarReporte(final String urlReporte, String tipo, Map<String, Object> params, Collection<?> objectList) throws Exception {
        ExternalContext econtext = FacesUtils.getExternalContext();
        FacesContext fcontext = super.getFacesContext();
        Connection conn = this.sievalDS.getConnection();
        try {
            
            JRExporter exporter = null;

            InputStream inputStream = new FileInputStream(urlReporte);
            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo " + urlReporte + " no se encontró");
            }

            params.put("REPORT_CONNECTION", conn);
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(objectList);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, ds);

            HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
            response.setContentType(tipo);
            if ("application/pdf".equals(tipo)) {
                exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            }
            if ("text/html".equals(tipo)) {
                exporter = new JRHtmlExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
            }
            if ("application/rtf".equals(tipo)) {
                exporter = new JRRtfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            }
            if ("application/csv".equals(tipo)) {
                exporter = new JRCsvExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            }
            if ("application/vnd.ms-excel".equals(tipo)) {
                exporter = new JRXlsExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                        Boolean.TRUE);
            }
            if (exporter != null) {
                exporter.exportReport();
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al generar el reporte. ", ex);
        } finally {
            conn.close();
        }        
        fcontext.responseComplete();
    }

}
