/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoXConvocatoriaFacade;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProcesoXConvocatoriaController extends ControllerBase implements Serializable{

    /**
     * Creates a new instance of Convocatoria
     */
    public ProcesoXConvocatoriaController() {
    }
    
     //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
      private SegUsuario usuario;
      private String usuID;
      private boolean validaVacios = true;
      private boolean controlGrabar = false;
      private String tituloConv = "";
      private String tituloConvEdit = ""; 
      private String proDescrip = "";
      private String proDescripEdit = "";
      private String fechaIniVal = "";
      private String fechaFinVal = "";
//    
//
    private List<SeaConvoca> tituloConvList;
    private List<SeaProceso> proDescripList;
    
    @EJB
    private SeaConvocaFacade tituloConvFacade; 
    @EJB
    private SeaProcesoFacade proDescripFacade;
    private String proceso = "";
    
    @EJB
   private SeaConvocaFacade convocatoriaFacade;
   private SeaConvoca seaConvoca;
   private SeaConvoca seaConvocaSelected;
   private String convocaTitulo;
   private List<SeaConvoca> seaConvocaList;
   private String convocatoria = "";
   
  private SeaProcesoXConvocatoria prosXConvocatoria;
  private SeaProcesoXConvocatoria prosXConvocatoriaSelected;
  @EJB
   private SeaProcesoXConvocatoriaFacade prosXConvocatoriaFacade;
   private List<SeaProcesoXConvocatoria> proProcDescripLista;
   private List<SeaProcesoXConvocatoria> procesoConvList;
  
   private Date fechaIni;
   private Date fechaFin;
    
    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
   void checkIngreso(){
       
       tituloConvList = tituloConvFacade.findConvocatoria();
       proDescripList = proDescripFacade.findAll();
       procesoConvList = prosXConvocatoriaFacade.findProcesosConvocatoria();
        //System.out.println(" la lista es  "+proDescripList.size());
   
     
       // System.out.println("tamaño lista "+ tituloConvList.size());
//       seaConvocaList = convocatoriaFacade.findSeaConvoca();
//       System.out.println("listaconvocatoria" + seaConvocaList.size());
//       
//     
       
       
       //nrcEstudianteAsignatList = vmEstudianteFacade.findNrcByCodUsuCodPer(usuario.getUsuCc())
       
   }
  
     public String agregarP1(){
        controlGrabar = true;
        return "";
    }
    public String registra() {
        String estado ="1";
        seaConvoca = new SeaConvoca();
        seaConvoca.setConvocaId(new BigDecimal(tituloConv));
        SeaProceso obj = new SeaProceso();
        obj.setProId(new BigDecimal(proDescrip));
        if (prosXConvocatoria == null) {
            prosXConvocatoria = new SeaProcesoXConvocatoria();
            prosXConvocatoria.setSeaProceso(obj);
            prosXConvocatoria.setSeaConvoca(seaConvoca);
            prosXConvocatoria.setPpcFecifin(fechaFin);
            prosXConvocatoria.setPpcFecini(fechaIni);
            prosXConvocatoria.setPpcEstado(new BigInteger(estado));
            /*  prosXConvocatoria.setPpcEstado(BigInteger.ZERO);*/
            prosXConvocatoriaFacade.create(prosXConvocatoria);
            procesoConvList = prosXConvocatoriaFacade.findProcesosConvocatoria();
        }
        cancelar();
        return "";
    }
      public void eliminar(){
         if (prosXConvocatoriaSelected != null) {
             SeaProcesoXConvocatoria eliminar = null;
             for(int i = 0; i < procesoConvList.size(); i++) {
                SeaProcesoXConvocatoria elemento = this.procesoConvList.get(i);
                if(prosXConvocatoriaSelected.getPpcId()== procesoConvList.get(i).getPpcId())
                {
                    eliminar = elemento;
                    break;
                }                
             }
             System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar");
                this.procesoConvList.remove(eliminar);
                prosXConvocatoriaFacade.remove(eliminar);
            }
         }
     }
     
      public void cancelar(){
        controlGrabar =false;
        tituloConv = "";
        proDescrip ="";
        fechaIni = null;
        fechaFin = null;
        prosXConvocatoria = null;
        validaVacios = true;
    }
           
      public String seleccionaConvo(){
          return "";
      }
      public boolean validarVacios(){
            System.out.println(" valida vacios ");
            fechaFinVal= fechaFin.toString();
            fechaIniVal = fechaIni.toString();
            validaVacios = false;            
            tituloConv = tituloConv.trim();
            proDescrip = proDescrip.trim();
            fechaFinVal = fechaFinVal.trim();
           
            
            if(tituloConv.isEmpty()){
            validaVacios = true;
            }
            if(proDescrip.isEmpty()){
            validaVacios = true;
            }
            if(fechaIniVal.isEmpty()){
            validaVacios = true;}
            if(fechaFinVal.isEmpty()){
            validaVacios = true;
            }
            
                       
          return validaVacios;
      }
      /*public void onRowEditP5(RowEditEvent event) {
        SeaResponsableProg responsableProyEdit = new SeaResponsableProg();

//        SeaDocente doc = new SeaDocente();
//        doc.setDocId(new BigDecimal(docente));
        SegUsuario doc = new SegUsuario();
        doc.setUsuId(new BigDecimal(docente));

        SeaTipoRespons tipRes = new SeaTipoRespons();
        tipRes.setTipresId(new BigDecimal(tipoResponsabilidad));

        responsableProyEdit = (SeaResponsableProg) event.getObject();
        //docente.setDocId(responsableProyEdit.getDocId().getDocId());//// anterior

        //  responsableProyEdit.setDocId(doc);
        responsableProyEdit.setUsuIdDocente(doc);
        responsableProyEdit.setTipresId(tipRes);
        responsableProyFacade.edit(responsableProyEdit);
        responsableProyList = responsableProyFacade.findRespProyByDatPro(datosProyectoSelected.getDatgeproyId());

    }*/
       public void onRowEdit(RowEditEvent event)
     {         
         SeaProcesoXConvocatoria convxProc = new SeaProcesoXConvocatoria();         
          convxProc = (SeaProcesoXConvocatoria) event.getObject();
          prosXConvocatoriaFacade.edit(convxProc);
          procesoConvList = prosXConvocatoriaFacade.findProcesosConvocatoria();
         
     }
         public void onRowCancel(RowEditEvent event) {

    }       
    //</editor-fold>

  
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    
//// get and set 
    
     public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public List<SeaConvoca> getTituloConvList() {
        return tituloConvList;
    }

    public void setTituloConvList(List<SeaConvoca> tituloConvList) {
        this.tituloConvList = tituloConvList;
    }

    public List<SeaProceso> getProDescripList() {
        return proDescripList;
    }

    public void setProDescripList(List<SeaProceso> proDescripList) {
        this.proDescripList = proDescripList;
    }

    public SeaConvocaFacade getTituloConvFacade() {
        return tituloConvFacade;
    }

    public void setTituloConvFacade(SeaConvocaFacade tituloConvFacade) {
        this.tituloConvFacade = tituloConvFacade;
    }

    public SeaProcesoFacade getProDescripFacade() {
        return proDescripFacade;
    }

    public void setProDescripFacade(SeaProcesoFacade proDescripFacade) {
        this.proDescripFacade = proDescripFacade;
    }

    public String getTituloConv() {
        return tituloConv;
    }

    public void setTituloConv(String tituloConv) {
        this.tituloConv = tituloConv;
    }

    public String getTituloConvEdit() {
        return tituloConvEdit;
    }

    public void setTituloConvEdit(String tituloConvEdit) {
        this.tituloConvEdit = tituloConvEdit;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public String getProDescripEdit() {
        return proDescripEdit;
    }

    public void setProDescripEdit(String proDescripEdit) {
        this.proDescripEdit = proDescripEdit;
    }
    

    
    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }
     
    //</editor-fold>
    public String getConvocaTitulo() {
        return convocaTitulo;
    }

    public void setConvocaTitulo(String convocaTitulo) {
        this.convocaTitulo = convocaTitulo;
    }

    public List<SeaProcesoXConvocatoria> getProProcDescripLista() {
        return proProcDescripLista;
    }

    public void setProProcDescripLista(List<SeaProcesoXConvocatoria> proProcDescripLista) {
        this.proProcDescripLista = proProcDescripLista;
    }

    public List<SeaProcesoXConvocatoria> getProcesoConvList() {
        return procesoConvList;
    }

    public void setProcesoConvList(List<SeaProcesoXConvocatoria> procesoConvList) {
        this.procesoConvList = procesoConvList;
    }

    public SeaProcesoXConvocatoria getProsXConvocatoriaSelected() {
        return prosXConvocatoriaSelected;
    }

    public void setProsXConvocatoriaSelected(SeaProcesoXConvocatoria prosXConvocatoriaSelected) {
        this.prosXConvocatoriaSelected = prosXConvocatoriaSelected;
    }

    public List<SeaConvoca> getSeaConvocaList() {
        return seaConvocaList;
    }

    public void setSeaConvocaList(List<SeaConvoca> seaConvocaList) {
        this.seaConvocaList = seaConvocaList;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    
    
    
    

   

}
