/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.controller;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegSistemasFacade;
import java.io.Serializable;
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
public class SeguridadSistemaController implements Serializable{

    /**
     * Creates a new instance of SeguridadSistemaController
     */
    public SeguridadSistemaController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegSistemasFacade segSistemasFacade;
    private SegSistemas segSistemas;
    private List<SegSistemas> segSistemasList;
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    private String nombreSistema ="";
    private String urlSistema ="";
    private SegSistemas sistemaSelected;
    
    //</editor-fold>
    @PostConstruct
    public void init(){
         FacesContext context = FacesContext.getCurrentInstance();
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
        segSistemasList = segSistemasFacade.findSistemas();
    }
    public String agregarP1(){
        controlGrabarP1=true;
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 =false;
        nombreSistema = nombreSistema.trim();
        urlSistema = urlSistema.trim();
        
        if(nombreSistema.isEmpty()) validaVaciosP1=true;
        if(urlSistema.isEmpty()) validaVaciosP1 =true;
        return validaVaciosP1;
    }
    public  void cancelarP1(){
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        segSistemas = null;
        nombreSistema ="";
        urlSistema ="";
        validaVaciosP1 = true;
        
    }

    public String registrarP1(){
        if(segSistemas == null){
            /// ingreso nuevo registro
            segSistemas = new SegSistemas();
            segSistemas.setSisNombre(nombreSistema);
            segSistemas.setSisUrlSistema(urlSistema);
            segSistemasFacade.create(segSistemas);
            segSistemasList = segSistemasFacade.findSistemas();
            cancelarP1();
        }
        return "";
    }
    public void eliminarP1(){
        Integer registro = 0;
        if(sistemaSelected != null){
            SegSistemas eliminar = null;
            for(int i =0; i< segSistemasList.size(); i++){
                SegSistemas elemento = this.segSistemasList.get(i);
                if(sistemaSelected.getSisId() == segSistemasList.get(i).getSisId()){
                    eliminar = elemento;
                    break;
                }
            }
            if(eliminar != null){
                this.segSistemasList.remove(eliminar);
                segSistemasFacade.remove(eliminar);
                MensajeController m= null;
            }
            segSistemasList = segSistemasFacade.findSistemas();
        }
    }
    public void onRowEditP1(RowEditEvent event){
        SegSistemas segSistemaEdit = new SegSistemas();
        segSistemaEdit = (SegSistemas) event.getObject();
        segSistemasFacade.edit(segSistemaEdit);
    }
    public void onRowCancelP1(RowEditEvent event){
    }
    
    //</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
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
    public String getNombreSistema() {
        return nombreSistema;
    }

    public void setNombreSistema(String nombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    public String getUrlSistema() {
        return urlSistema;
    }

    public void setUrlSistema(String urlSistema) {
        this.urlSistema = urlSistema;
    }
    public List<SegSistemas> getSegSistemasList() {
        return segSistemasList;
    }

    public void setSegSistemasList(List<SegSistemas> segSistemasList) {
        this.segSistemasList = segSistemasList;
    }
    public SegSistemas getSistemaSelected() {
        return sistemaSelected;
    }

    public void setSistemaSelected(SegSistemas sistemaSelected) {
        this.sistemaSelected = sistemaSelected;
    }
    
    //</editor-fold>

 
   

    

    

    
}
