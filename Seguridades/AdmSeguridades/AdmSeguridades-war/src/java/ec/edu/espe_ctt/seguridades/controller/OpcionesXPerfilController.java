/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.controller;

import ec.edu.espe_ctt.seguridades.entity.SegOpcPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegOpcion;
import ec.edu.espe_ctt.seguridades.session.SegOpcPerfilFacade;
import ec.edu.espe_ctt.seguridades.session.SegOpcionFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class OpcionesXPerfilController implements Serializable{

    /**
     * Creates a new instance of OpcionesXPerfilController
     */
    public OpcionesXPerfilController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private boolean controlGrabar = false;
    private boolean validaVacios = true;
    
    @EJB
    private SegOpcionFacade opcionFacade;
    private SegOpcion segOpcion;

    
    @EJB
    private SegOpcPerfilFacade opcionPerfilFacade;
    private SegOpcPerfil opcionPerfil;
    private List<SegOpcPerfil> opcionPerfiList;
    private String estadoEdit;
    
    
    
    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
        ///tab1
        opcionPerfiList = opcionPerfilFacade.findOpcionPerfil();
    }
   
    public boolean validarVaciosP1(){
        validaVacios = false;
        return validaVacios;
    }
    public void onRowEditP1(RowEditEvent event){
        SegOpcPerfil opcionPerfilEdit = new SegOpcPerfil();
        System.out.println("estadoEdit " + estadoEdit);
        System.out.println("");
        opcionPerfilEdit = (SegOpcPerfil) event.getObject();
//        opcionPerfilEdit.setOppActInact(new BigInteger(estadoEdit));
        opcionPerfilFacade.edit(opcionPerfilEdit);
        opcionPerfiList = opcionPerfilFacade.findOpcionPerfil();
    }
    public void onRowCancelP1(RowEditEvent event){
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    ///tab1
    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }
    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }
    public List<SegOpcPerfil> getOpcionPerfiList() {
        return opcionPerfiList;
    }

    public void setOpcionPerfiList(List<SegOpcPerfil> opcionPerfiList) {
        this.opcionPerfiList = opcionPerfiList;
    }
    public String getEstadoEdit() {
        return estadoEdit;
    }

    public void setEstadoEdit(String estadoEdit) {
        this.estadoEdit = estadoEdit;
    }

    
    //</editor-fold>

    

    

    

   
    

    
}
