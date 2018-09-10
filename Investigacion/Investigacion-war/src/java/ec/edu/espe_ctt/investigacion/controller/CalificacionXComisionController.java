/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.session.CalificacionComisionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import java.io.IOException;
import java.io.Serializable;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class CalificacionXComisionController implements Serializable {

    private SeaDatGeneralProy notaConceptualSelected;
    private List<SeaDatGeneralProy> notaConceptualList;
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    @EJB
    private SeaConvocaFacade convocatoriaFacade;
    private SegUsuario usuarioActual;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        notaConceptualSelected = null;
        List<SeaConvoca> convocatoriaList = convocatoriaFacade.findByUsuario(usuarioActual.getUsuId());
        notaConceptualList = new ArrayList<>();
        for (SeaConvoca conv : convocatoriaList) {
            for (SeaDatGeneralProy notaC : conv.getSeaDatGeneralProyList()) {
                if (!notaC.getDatgeproyEstado().equals(SeaDatGeneralProy.ESTADO_INGRESO_PERFIL)
                        && !notaC.getDatgeproyEstado().equals(SeaDatGeneralProy.ESTADO_ELIMINADO)
                        && !notaC.getDatgeproyEstado().equals(SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL)
                        && !notaC.getDatgeproyEstado().equals(SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO)) {
                    notaConceptualList.add(notaC);
                }

            }
        }
    }

    public SeaDatGeneralProy getNotaConceptualSelected() {
        return notaConceptualSelected;
    }

    public void setNotaConceptualSelected(SeaDatGeneralProy notaConceptualSelected) {
        this.notaConceptualSelected = notaConceptualSelected;
    }

    public List<SeaDatGeneralProy> getNotaConceptualList() {
        return notaConceptualList;
    }

    public void setNotaConceptualList(List<SeaDatGeneralProy> notaConceptualList) {
        this.notaConceptualList = notaConceptualList;
    }

    public void seleccionarNotaConceptual(SeaDatGeneralProy notaConceptual) {
        try {
            this.notaConceptualSelected = notaConceptual;
            notaConceptualSelected.addCalificacionComision();
            generarReportePDF();

        } catch (Exception e) {
        }
    }

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    @EJB
    private CalificacionComisionFacade calificacionComisionFacade;

    public void generarReportePDF() throws JRException, IOException, SQLException {
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
        parametros.put("DATGEPROY_ID", notaConceptualSelected.getDatgeproyId().toString());
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
    }

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void guardarAprobacion() {
        try {
            if (notaConceptualSelected.getCalificacionComision().getEstado().equals(SeaDatGeneralProy.ESTADO_APROBADO_COMISION.toString())
                    || notaConceptualSelected.getCalificacionComision().getEstado().equals(SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION.toString())) {
                notaConceptualSelected.setDatgeproyEstado(notaConceptualSelected.getCalificacionComision().getEstado().charAt(0));
            } else {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:tabP:selAprobacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar el estado APROBADO ó RECHAZADO"));
                return;
            }
            notaConceptualSelected.getCalificacionComision().setUsuario(usuarioActual);
            notaConceptualSelected.getCalificacionComision().setFecha(new Date());

            notaConceptualFacade.edit(notaConceptualSelected);
            notaConceptualSelected = notaConceptualFacade.find(notaConceptualSelected.getDatgeproyId());
            modoEdicion = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    public void cancelar() {
        modoEdicion = false;
        notaConceptualSelected = notaConceptualFacade.find(notaConceptualSelected.getDatgeproyId());
        notaConceptualSelected.addCalificacionComision();
    }

}
