/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionPar;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionParDetalle;
import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import ec.edu.espe_ctt_investigacion.session.ConfiguracionParametrosEvaluacionInvFacade;
import ec.edu.espe_ctt_investigacion.session.EvaluacionParFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteDeptoBFacade;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class EvaluacionXParController implements Serializable {

    private SegUsuario usuario;
    private SeaDatGeneralProy notaConceptualSelected;
    private List<SeaDatGeneralProy> notaConceptualList;
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;

    private SeaParesConvoca parEvaluacionSelected;
    private List<SeaParesConvoca> parEvaluacionList;
    @EJB
    private SeaParesConvocaFacade parEvaluacionFacade;
    @EJB
    private EvaluacionParFacade evaluacionParFacade;

    public EvaluacionXParController() {

    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        parEvaluacionList = parEvaluacionFacade.findByUsuario(usuario.getUsuId());
        parEvaluacionSelected = null;
    }

    public List<SeaParesConvoca> getParEvaluacionList() {
        return parEvaluacionList;
    }

    public void setParEvaluacionList(List<SeaParesConvoca> parEvaluacionList) {
        this.parEvaluacionList = parEvaluacionList;
    }

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void seleccionarParEvaluacion() {
        try {
            if (parEvaluacionSelected.getEvaluacionList() == null || parEvaluacionSelected.getEvaluacionList().isEmpty()) {
                modoEdicion = true;
                evaluacionParSelected = new EvaluacionPar();
                configParametrosEvaluacionSelected = configuParametrosEvaluacionFacade.findXEvaluacionInicialAndActivo();
                if (configParametrosEvaluacionSelected == null) {
                    throw new Exception("No existe una configuraciion activa");
                }
            } else {
                modoEdicion = false;
                evaluacionParSelected = parEvaluacionSelected.getEvaluacionList().get(0);
                for (EvaluacionParDetalle evaluacionParDetalle : evaluacionParSelected.getEvaluacionDetalleList()) {
                    configParametrosEvaluacionSelected = evaluacionParDetalle.getConfiguracion();
                    break;
                }

                for (EvaluacionParDetalle evalDetalle : evaluacionParSelected.getEvaluacionDetalleList()) {
                    if (evalDetalle.getParametroEvaluacion() != null) {
                        for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                            if (param.equals(evalDetalle.getParametroEvaluacion())) {
                                param.setPuntaje(evalDetalle.getPuntaje());
                                param.setJustificacion(evalDetalle.getJustificacion());
                                break;
                            }
                            if (param.getParametroEvaluacionList() != null && !param.getParametroEvaluacionList().isEmpty()) {
                                for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                                    if (paramHijo.equals(evalDetalle.getParametroEvaluacion())) {
                                        paramHijo.setPuntaje(evalDetalle.getPuntaje());
                                        paramHijo.setJustificacion(evalDetalle.getJustificacion());
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                            if (param.equals(evalDetalle.getValoracionParametroEvaluacion().getParametroEvaluacion())) {
                                param.setValoracionParametroEvaluacion(evalDetalle.getValoracionParametroEvaluacion());
                                param.setJustificacion(evalDetalle.getJustificacion());
                                break;
                            }
                            if (param.getParametroEvaluacionList() != null && !param.getParametroEvaluacionList().isEmpty()) {
                                for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                                    if (paramHijo.equals(evalDetalle.getValoracionParametroEvaluacion().getParametroEvaluacion())) {
                                        paramHijo.setValoracionParametroEvaluacion(evalDetalle.getValoracionParametroEvaluacion());
                                        paramHijo.setJustificacion(evalDetalle.getJustificacion());
                                        break;
                                    }
                                }

                            }
                        }

                    }

                }
            }
            generarReportePDF();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @EJB
    private ConfiguracionParametrosEvaluacionInvFacade configuParametrosEvaluacionFacade;
    private ConfiguracionParametrosEvaluacionInv configParametrosEvaluacionSelected;

    public SeaParesConvoca getParEvaluacionSelected() {
        return parEvaluacionSelected;
    }

    public void setParEvaluacionSelected(SeaParesConvoca parEvaluacionSelected) {
        this.parEvaluacionSelected = parEvaluacionSelected;
    }

    public ConfiguracionParametrosEvaluacionInv getConfigParametrosEvaluacionSelected() {
        return configParametrosEvaluacionSelected;
    }

    public void setConfigParametrosEvaluacionSelected(ConfiguracionParametrosEvaluacionInv configParametrosEvaluacionSelected) {
        this.configParametrosEvaluacionSelected = configParametrosEvaluacionSelected;
    }

    private EvaluacionPar evaluacionParSelected;

    public EvaluacionPar getEvaluacionParSelected() {
        return evaluacionParSelected;
    }

    public void setEvaluacionParSelected(EvaluacionPar evaluacionParSelected) {
        this.evaluacionParSelected = evaluacionParSelected;
    }

    public void grabar() {
        try {
            evaluacionParSelected.removeAllDetalle();
            for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                EvaluacionParDetalle evaluacionParDetalle = new EvaluacionParDetalle();
                if (param.getParametroEvaluacionList() == null || param.getParametroEvaluacionList().isEmpty()) {
                    if (param.getValoracionList() == null || param.getValoracionList().isEmpty()) {
                        evaluacionParDetalle.setParametroEvaluacion(param);
                        evaluacionParDetalle.setPuntaje(param.getPuntaje());
                        evaluacionParDetalle.setJustificacion(param.getJustificacion());
                        if (evaluacionParDetalle.getPuntaje().compareTo(param.getPuntajeMaximo()) > 0) {
                            throw new Exception("El parámetro: '" + param.getDescripcion() + "' puede tener un puntaje máximo de: " + param.getPuntajeMaximo().toString());
                        }
                    } else {
                        evaluacionParDetalle.setValoracionParametroEvaluacion(param.getValoracionParametroEvaluacion());
                    }
                    evaluacionParSelected.addDetalle(evaluacionParDetalle);
                } else {
                    for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                        evaluacionParDetalle = new EvaluacionParDetalle();
                        if (paramHijo.getValoracionList() == null || paramHijo.getValoracionList().isEmpty()) {
                            evaluacionParDetalle.setParametroEvaluacion(paramHijo);
                            evaluacionParDetalle.setPuntaje(paramHijo.getPuntaje());
                            evaluacionParDetalle.setJustificacion(paramHijo.getJustificacion());
                            if (evaluacionParDetalle.getPuntaje().compareTo(paramHijo.getPuntajeMaximo()) > 0) {
                                throw new Exception("El parámetro: '" + paramHijo.getDescripcion() + "' puede tener un puntaje máximo de: " + paramHijo.getPuntajeMaximo().toString());
                            }
                        } else {
                            evaluacionParDetalle.setValoracionParametroEvaluacion(paramHijo.getValoracionParametroEvaluacion());
                        }
                        evaluacionParSelected.addDetalle(evaluacionParDetalle);
                    }
                }

            }

            evaluacionParSelected.setFechaModificacion(new Date());
            if (evaluacionParSelected.getId() == null) {
                evaluacionParSelected.setPar(parEvaluacionSelected);
                evaluacionParFacade.create(evaluacionParSelected);
            } else {
                evaluacionParFacade.edit(evaluacionParSelected);
            }
            modoEdicion = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

    }

    public void cancelar() {
        if (evaluacionParSelected.getId() == null) {
            init();
        } else {
            seleccionarParEvaluacion();
            modoEdicion = false;
        }
    }

    public void editar() {
        modoEdicion = true;
    }

    /*public void generarReportePDF() throws JRException, IOException, SQLException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = servletContext.getRealPath("/reportes");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/reportGrupNotasConceptuales.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("DATGEPROY_ID", parEvaluacionSelected.getNotaConceptual().getDatgeproyId().toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + "notasConcept.pdf"));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        connection.close();
    }*/
    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    @EJB
    private VDocenteDeptoBFacade vDocenteDeptoBFacade;
    
    private String nombreArchivoPdf;

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }
    
    
    public void generarReportePDF() throws JRException, IOException, SQLException {
        BigDecimal idUsuario = parEvaluacionSelected.getNotaConceptual().getUsuId().getUsuId();
        VDocenteDeptoB vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
        BigDecimal idDocente =null;
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
        SeaFormatoLargo formatoLargo = formatoLargoFacade.findFormatoByCodPro(parEvaluacionSelected.getNotaConceptual().getDatgeproyId()).get(0);
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        Date fecha = new Date();
        nombreArchivoPdf = Long.toString(fecha.getTime()) + ".pdf";
        String realPath = servletContext.getRealPath("/reportes/proyecto_largo");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/proyecto_largo.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", parEvaluacionSelected.getNotaConceptual().getDatgeproyId().toString());
        parametros.put("SFL_ID", formatoLargo.getSflId().toString());
        parametros.put("DATGEPROY_ID", parEvaluacionSelected.getNotaConceptual().getDatgeproyId().toString());
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
    }
    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;

    public void finalizar() {
        try {
            evaluacionParSelected.setEstadoFinalizado(EvaluacionPar.ESTADO_FINALIZADO_SI);
            evaluacionParFacade.edit(evaluacionParSelected);
            modoEdicion = false;

            SeaDatGeneralProy notaConceptual = notaConceptualFacade.find(parEvaluacionSelected.getNotaConceptual().getDatgeproyId());
            if (notaConceptual.verificarEvaluacionPar()) {
                notaConceptual.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_EVALUADO_PAR);
                notaConceptualFacade.edit(notaConceptual);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    public void validarPuntaje(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String selectedRadio = (String) value;
        String msg = "V3-- Since you indicated that you play Tennis, Please enter Club Name.";
        if (1 == 1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
    }
}
