/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import java.io.Serializable;
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
public class PerfilProyectoController implements Serializable {
    
    public PerfilProyectoController() {
    }
    

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario usuario;
    @EJB
    private SeaDatGeneralProyFacade datGeneralProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    private List<SeaDatGeneralProy> datGeneralProyList;    
    //</editor-fold>
    
    
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        datGeneralProyList = datGeneralProyFacade.findDatGenProyByCodUsu(usuario.getUsuId());
    }

    public SeaDatGeneralProy getDatGeneralProy() {
        return datGeneralProy;
    }

    public void setDatGeneralProy(SeaDatGeneralProy datGeneralProy) {
        this.datGeneralProy = datGeneralProy;
    }

    public List<SeaDatGeneralProy> getDatGeneralProyList() {
        return datGeneralProyList;
    }

    public void setDatGeneralProyList(List<SeaDatGeneralProy> datGeneralProyList) {
        this.datGeneralProyList = datGeneralProyList;
    }
    public void eliminarP1() {
        datGeneralProy.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_ELIMINADO);
        datGeneralProyFacade.edit(datGeneralProy);
        datGeneralProyList = datGeneralProyFacade.findDatGenProyByCodUsu(usuario.getUsuId());
    }
    

}
