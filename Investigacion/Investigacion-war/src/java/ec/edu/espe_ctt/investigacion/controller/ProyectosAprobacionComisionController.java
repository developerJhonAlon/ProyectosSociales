/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProyectosAprobacionComisionController implements Serializable {

    private List<SeaDatGeneralProy> notaConceptualList;
    @EJB
    private SeaConvocaFacade convocatoriaFacade;
    private SegUsuario usuarioActual;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
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

    public List<SeaDatGeneralProy> getNotaConceptualList() {
        return notaConceptualList;
    }

    public void setNotaConceptualList(List<SeaDatGeneralProy> notaConceptualList) {
        this.notaConceptualList = notaConceptualList;
    }

}
