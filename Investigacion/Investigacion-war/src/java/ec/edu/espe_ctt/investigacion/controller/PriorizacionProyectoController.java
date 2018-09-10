/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionPar;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionParDetalle;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class PriorizacionProyectoController implements Serializable {

    private SegUsuario usuarioActual;
    private List<SeaDatGeneralProy> notaConceptualList;
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;

    public PriorizacionProyectoController() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        listarNotasConceptuales();
    }

    private void listarNotasConceptuales() {
        notaConceptualList = notaConceptualFacade.findByEstado(SeaDatGeneralProy.ESTADO_EVALUADO_PAR);
        for (SeaDatGeneralProy n : notaConceptualList) {
            seleccionarNotaConceptual(n);
            n.setearPuntaje();
        }

    }

    public List<SeaDatGeneralProy> getNotaConceptualList() {
        return notaConceptualList;
    }

    public void setNotaConceptualList(List<SeaDatGeneralProy> notaConceptualList) {
        this.notaConceptualList = notaConceptualList;
    }

    public void seleccionarNotaConceptual(SeaDatGeneralProy notaConceptual) {
        try {
            for (SeaParesConvoca p : notaConceptual.getParEvaluacionList()) {
                for (EvaluacionPar e : p.getEvaluacionList()) {
                    for (EvaluacionParDetalle d : e.getEvaluacionDetalleList()) {
                        notaConceptual.setConfigParametrosEvaluacion(d.getConfiguracion().clone());
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void seleccionarNoAprobado(SeaDatGeneralProy seaDatGeneralProy) {
        if (seaDatGeneralProy.getNoAprobado() != null && seaDatGeneralProy.getNoAprobado()) {
            seaDatGeneralProy.setAprobado(false);
        }
    }

    public void seleccionarAprobado(SeaDatGeneralProy seaDatGeneralProy) {
        if (seaDatGeneralProy.getAprobado() != null && seaDatGeneralProy.getAprobado()) {
            seaDatGeneralProy.setNoAprobado(false);
        }
    }

    public String grabarAprobacionConsejo() {
        try {
            List<SeaDatGeneralProy> temp = new ArrayList<>();
            for (SeaDatGeneralProy proyecto : notaConceptualList) {
                if (proyecto.getAprobado() != null && proyecto.getAprobado()) {
                    proyecto.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_APROBADO_CONSEJO);
                    proyecto.setFechaPriorizacion(new Date());
                    temp.add(proyecto);
                }
                if (proyecto.getNoAprobado() != null && proyecto.getNoAprobado()) {
                    proyecto.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_RECHAZADO_CONSEJO);
                    proyecto.setFechaPriorizacion(new Date());
                    temp.add(proyecto);
                }
            }
            notaConceptualFacade.actualizarProyectos(temp);
            listarNotasConceptuales();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            } catch (Exception e2) {
            }
        }
        return "";
    }
}
