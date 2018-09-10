/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import ec.edu.espe_ctt_investigacion.session.ParametrosGlobales;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoFacade;
import ec.edu.espe_ctt_investigacion.session.SegSistemasFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC1
 */
@Named(value = "catalogoProcesoController")
@ViewScoped
public class CatalogoProcesoController extends ControllerBase implements Serializable{

    /**
     * Creates a new instance of CatalogoProcesoController
     */
    public CatalogoProcesoController() {
    }
    
    
     //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    
    private SegUsuario usuario;
    private boolean validaVacios = true;
    private boolean controlGrabar = false;
    private String proDescrip = "";
    
      
    
    @EJB
   private SeaProcesoFacade procesoFacade;
   private SeaProceso seaProceso;
   private SeaProceso seaProcesoSelected;
   private List<SeaProceso> seaProcesoList;
   
   @EJB
   private SegSistemasFacade segSistemasFacade;
   private SegSistemas segSistemas;

    
      //</editor-fold>
      @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
         seaProcesoList = procesoFacade.findProceso();
        
}
    public String agregarP1(){
        controlGrabar = true;
        return "";
    }
    
    public boolean validarVacios(){
         validaVacios = false;
         proDescrip = proDescrip.trim();
         if(proDescrip.isEmpty())validaVacios = true;
         return validaVacios;
     }
    
    public String registra() {
        BigDecimal idSistema = ParametrosGlobales.AMBIENTE_PRODUCCION1?new BigDecimal(3):new BigDecimal(4);
        SegSistemas sistema = new SegSistemas(idSistema);

        if (seaProceso == null) {
            seaProceso = new SeaProceso();
            seaProceso.setProDescrip(proDescrip);
            seaProceso.setSegSistemas(sistema);
            procesoFacade.create(seaProceso);
             seaProcesoList = procesoFacade.findProceso();
        }
        cancelar();
        return "";
    }
    public void cancelar(){
        controlGrabar =false;
        seaProceso = null;
         proDescrip ="";
         validaVacios = true;
    }
    
     
     public void onRowEdit(RowEditEvent event){
          
               
        SeaProceso procesoEdit = new SeaProceso();
        procesoEdit = (SeaProceso) event.getObject();
        procesoFacade.edit(procesoEdit); 
        //seaProcesoList = procesoFacade.findAll();
        
            
    }
    public void onRowCancel(RowEditEvent event){
        
    }
     public void eliminarP1(){
          Integer registro = 0;
        if(seaProcesoSelected != null){
            SeaProceso eliminar = null;
            for(int i=0; i< seaProcesoList.size(); i++){
                SeaProceso elemento = this.seaProcesoList.get(i);
                if(seaProcesoSelected.getProId()== seaProcesoList.get(i).getProId()){
                   eliminar = elemento;
                    break;
                }
            }
            if(eliminar != null){
                this.seaProcesoList.remove(eliminar);
                procesoFacade.remove(eliminar);
                
                MensajeController  m = null;
            }
          //  seaProcesoList = procesoFacade.findSeaProceso();
             
        }
    }
     
     //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    
      
    public SegUsuario getUsuario() {
        return usuario;
    }

    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public SeaProcesoFacade getProcesoFacade() {
        return procesoFacade;
    }

    public void setProcesoFacade(SeaProcesoFacade procesoFacade) {
        this.procesoFacade = procesoFacade;
    }

    public SeaProceso getSeaProceso() {
        return seaProceso;
    }

    public void setSeaProceso(SeaProceso seaProceso) {
        this.seaProceso = seaProceso;
    }

    public SeaProceso getSeaProcesoSelected() {
        return seaProcesoSelected;
    }

    public void setSeaProcesoSelected(SeaProceso seaProcesoSelected) {
        this.seaProcesoSelected = seaProcesoSelected;
    }

    public List<SeaProceso> getSeaProcesoList() {
        return seaProcesoList;
    }

    public void setSeaProcesoList(List<SeaProceso> seaProcesoList) {
        this.seaProcesoList = seaProcesoList;
    }

    
    
    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }
    
    
    //</editor-fold>

   

  
    
}
