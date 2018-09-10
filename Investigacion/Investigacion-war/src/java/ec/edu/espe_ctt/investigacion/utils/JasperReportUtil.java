/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.utils;

import static ec.edu.espe_ctt.investigacion.utils.FacesUtils.getServletContext;
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
    public final static String PATH = getServletContext().getRealPath("reportes") + File.separator;
    public final static String PATHIMG;
    public final static String NOMBRE_BEAN;
    public final static String TIPO_PDF;
    public final static String TIPO_XLS;
    public final static String TIPO_WORD;
    public final static String TIPO_HTML;
    public final static String PATH_REPORTE_CATALOGO_INVESTIGACION_POLITICAS = PATH + File.separator + "Catalogos_Investigacion" + File.separator + "politicas.jasper";    
    public final static String PATH_REPORTE_CATALOGO_INVESTIGACION_LINEAS_SUBLINEAS = PATH + File.separator + "Catalogos_Investigacion" + File.separator + "lineas_sublineas.jasper";    
    public final static String PATH_REPORTE_CATALOGO_INVESTIGACION_ESTRATEGIAS = PATH + File.separator + "Catalogos_Investigacion" + File.separator + "estrategias.jasper";    
    public final static String PATH_REPORTE_CATALOGO_INVESTIGACION_OBJETIVOS_BVIVIR = PATH + File.separator + "Catalogos_Investigacion" + File.separator + "obj_buen_vivir.jasper";    
    
    public final static String PATH_REPORTE_CONVOCATORIA = PATH + File.separator + "Reporte_Convoca" + File.separator + "convocatoria.jasper";    
    public final static String PATH_REPORTE_PROYECTOS_POR_CONVOCATORIA = PATH + File.separator + "listado_proyectos" + File.separator + "listado_proyectos.jasper";    
    public final static String PATH_REPORTE_NOTA_CONCEPTUAL = PATH +  File.separator + "reportGrupNotasConceptuales.jasper";    
    public final static String PATH_REPORTE_PRESUPUESTO_NOTA_CONCEPTUAL = PATH + File.separator + "presupuesto_nota_conceptual" +  File.separator + "presupuesto_nota_conceptual.jasper";    
    public final static String PATH_REPORTE_NOTAS_CONCEPTUALES_APROBADAS = PATH + File.separator + "notas_conceptuales_aprobadas" +  File.separator + "notas_conceptuales_aprobadas.jasper";    
    public final static String PATH_REPORTE_FORMATO_EXTENSO = PATH + File.separator + "proyecto_largo" +  File.separator + "proyecto_largo.jasper";    
    public final static String PATH_REPORTE_SEGUIMIMIENTO_FORMATO_EXTENSO = PATH + File.separator + "seguimineto" +  File.separator + "seguimiento.jasper";    
    public final static String PATH_REPORTE_PROYECTOS = PATH + File.separator + "Reporte Nota C Terminadas.jasper";    
    public final static String PATH_REPORTE_PRESUPUESTO_PARTIDA = PATH + File.separator + "presupuesto_partida" +  File.separator + "presupuesto_partida.jasper";    
    public final static String PATH_REPORTE_PROGRAMA_ANUAL_INVERSION = PATH + File.separator + "programa_inversion" +  File.separator + "programa_inversion.jasper";    
    public final static String PATH_REPORTE_PROYECTOS_APROBADOS_PARES = PATH + File.separator + "proyectosAprobadosPares.jasper";    

    @Resource(name = "ds_conn")
    private DataSource siseacDS;

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

   public void generarReporte(final String urlReporte, String tipo, Map<String, Object> params) throws ClassNotFoundException {
        try {
            ExternalContext econtext = FacesUtils.getExternalContext();
            FacesContext fcontext = super.getFacesContext();
            Connection conn = this.siseacDS.getConnection();
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
        //Connection conn = this.siseacDS.getConnection();
        try {
            
            JRExporter exporter = null;

            InputStream inputStream = new FileInputStream(urlReporte);
            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo " + urlReporte + " no se encontró");
            }

            //params.put("REPORT_CONNECTION", conn);
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
            //conn.close();
        }        
        fcontext.responseComplete();
    }

}
