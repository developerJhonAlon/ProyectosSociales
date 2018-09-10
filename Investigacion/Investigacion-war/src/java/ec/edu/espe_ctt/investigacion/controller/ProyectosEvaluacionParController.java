/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ProyectosEvaluacionParController implements Serializable {

    private SegUsuario usuarioActual;

    private List<SeaParesConvoca> parEvaluacionList;
    @EJB
    private SeaParesConvocaFacade parEvaluacionFacade;

    public ProyectosEvaluacionParController() {

    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        parEvaluacionList = parEvaluacionFacade.findByUsuario(usuarioActual.getUsuId());
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

}
