/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.controller;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegPerfilFacade;
import ec.edu.espe_ctt.seguridades.session.SegSistemasFacade;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class SeguridadPerfilController implements Serializable{

    /**
     * Creates a new instance of SeguridadPerfilController
     */
    public SeguridadPerfilController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegSistemasFacade segSistemaFacade;
    private SegSistemas segSistemas;
    private List<SegSistemas> sistemasList;
    private String sistemas = "";
    private String perfilSistema ="";
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    private String sisPerfEdit;
    
    
    @EJB
    private SegPerfilFacade perfilFacade;
    private SegPerfil segPerfilSistema;
    private SegPerfil perfiles;
    private List<SegPerfil> segPerfiList;
    private String sistPerfil;
    private SegPerfil segPerfilSelected;
    
    
    
    
    //</editor-fold>
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
         /// tab1
       sistemasList = segSistemaFacade.findSistemas();
       segPerfiList = perfilFacade.findPerfilSistema();
       
    }
    public String agregarP1(){
        controlGrabarP1=true;
//        sistemasList = segSistemaFacade.findSistemas();
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        sistemas = sistemas.trim();
        perfilSistema = perfilSistema.trim();
        
        if(sistemas.isEmpty()) validaVaciosP1 =true;
        if(perfilSistema.isEmpty()) validaVaciosP1 = true;
        
        return  validaVaciosP1;
    }
    public void cancelarP1(){
        /// inicializar variables de entrada
        controlGrabarP1=false;
        segPerfilSistema=null;
        sistemas ="";
        perfilSistema="";
        validaVaciosP1 = true;
    }
    public String registrarP1(){
        SegSistemas segSistemas = new SegSistemas();
        segSistemas.setSisId(new BigDecimal(sistemas));
        
        if(segPerfilSistema == null){
            /// ingreso nuevo registro
            segPerfilSistema = new SegPerfil();
            segPerfilSistema.setSegSistemas(segSistemas);
            segPerfilSistema.setPerNombre(perfilSistema);
            perfilFacade.create(segPerfilSistema);
            segPerfiList = perfilFacade.findPerfilSistema();
            cancelarP1();
        }
        return "";
    }
    public void eliminarP1(){
        Integer registro = 0;
        if(segPerfilSelected !=null){
            SegPerfil eliminar = null;
            for(int i =0; i< segPerfiList.size(); i++){
                SegPerfil elemento = this.segPerfiList.get(i);
                if(segPerfilSelected.getPerId()== segPerfiList.get(i).getPerId()){
                    eliminar = elemento;
                    break;
                }
            }
            if(eliminar !=null){
                this.segPerfiList.remove(eliminar);
                perfilFacade.remove(eliminar);
                MensajeController m = null;
            }
            segPerfiList = perfilFacade.findPerfilSistema();
        }
    }
    public void onRowEditP1(RowEditEvent event){
        SegPerfil segPerfiledit = new SegPerfil();
        segPerfiledit = (SegPerfil) event.getObject();
        
//        SegSistemas segSistemas = new SegSistemas();
//        segSistemas.setSisId(new BigDecimal(sisPerfEdit));
//        segPerfiledit.setSegSistemas(segSistemas);
        perfilFacade.edit(segPerfiledit);
        segPerfiList = perfilFacade.findPerfilSistema();
    }
    public void onRowCancelP1(RowEditEvent event){
    }
 
    
    //</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// tab1
    public List<SegSistemas> getSistemasList() {
        return sistemasList;
    }

    public void setSistemasList(List<SegSistemas> sistemasList) {
        this.sistemasList = sistemasList;
    }

    public String getSistemas() {
        return sistemas;
    }

    public void setSistemas(String sistemas) {
        this.sistemas = sistemas;
    }
    public boolean isControlGrabarP1() {
        return controlGrabarP1;
    }

    public void setControlGrabarP1(boolean controlGrabarP1) {
        this.controlGrabarP1 = controlGrabarP1;
    }
    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }
    public String getPerfilSistema() {
        return perfilSistema;
    }

    public void setPerfilSistema(String perfilSistema) {
        this.perfilSistema = perfilSistema;
    }
    public List<SegPerfil> getSegPerfiList() {
        return segPerfiList;
    }

    public void setSegPerfiList(List<SegPerfil> segPerfiList) {
        this.segPerfiList = segPerfiList;
    }
    public String getSistPerfil() {
        return sistPerfil;
    }

    public void setSistPerfil(String sistPerfil) {
        this.sistPerfil = sistPerfil;
    }
     public SegPerfil getSegPerfilSelected() {
        return segPerfilSelected;
    }

    public void setSegPerfilSelected(SegPerfil segPerfilSelected) {
        this.segPerfilSelected = segPerfilSelected;
    }
   public String getSisPerfEdit() {
        return sisPerfEdit;
    }

    public void setSisPerfEdit(String sisPerfEdit) {
        this.sisPerfEdit = sisPerfEdit;
    }
    
    //</editor-fold>

    
}
