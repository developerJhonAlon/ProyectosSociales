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
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ProyectoLargoController implements Serializable {

    /**
     * Creates a new instance of ProyectoLargoController
     */
    public ProyectoLargoController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    private SegUsuario usuario;

    /// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGenProyectoFacade;
    private List<SeaDatGeneralProy> datGenProyList;
 
    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        datGenProyList = datGenProyectoFacade.findDatGenProyByFormatoExtCodUsu(usuario.getUsuId());
    }

    public List<SeaDatGeneralProy> getDatGenProyList() {
        return datGenProyList;
    }

    public void setDatGenProyList(List<SeaDatGeneralProy> datGenProyList) {
        this.datGenProyList = datGenProyList;
    }
    
  }
