/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;
   
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaResplineai;
import ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResplineaiFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteInvestigacionFacade;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class LineaSubInvestigacionController {

    /**
     * Creates a new instance of LineaSubInvestigacionController
     */
    public LineaSubInvestigacionController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private String usuID;
    private SegUsuario usuarioResp;
    
    
    /// tab1
    @EJB
    private SeaLineainvesFacade lineaInvestFacade;
    private SeaLineainves lineaInvestigacion;
    private List<SeaLineainves> lineaInvesList;
    private boolean controlGrabar1 = false;
    private boolean validaVaciosP1 = true;
    private String lineaInvest ="";
    private String docenteInves ="";
    private SeaLineainves lineaInvestRespon;
    
//    
//    
//    private SeaLineainves sublineaInvest;
//    private SeaLineainves lineaInvestSelected;
//    private SeaLineainves sublineaInveSelected;
//    
//    private List<SeaLineainves> sublineaList;
//    private boolean validaVaciosSubP1 = true;
//    
//    
//    private String descripSub ="";
//    private String codUnesco="";
//    private String descripLinea ="";
//    
//    
    
    @EJB
    private VDocenteInvestigacionFacade vDocenteInvestFacade;
    private VDocenteInvestigacion vDocenteInvest;
    private List<VDocenteInvestigacion> docenteInvestList;
    private String docentEdit;
    
    ///Responsable Lineas de Investigacion
    @EJB
    private SeaResplineaiFacade respLineaFacade;
    private SeaResplineai respLinea;
    private List<SeaResplineai> responsableList;
    private String responLinEdit;
    private SeaResplineai responsableLineaSelected;
    private String nomFile1="";
    private UploadedFile file;
    private byte[] file1 = null;

    
    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
     void checkIngreso(){
         /// tab1
        lineaInvesList = lineaInvestFacade.findLineaSublinea();
        docenteInvestList = vDocenteInvestFacade.findAll();
        //docenteInvestList = vDocenteInvestFacade.findDocente();
        responsableList = respLineaFacade.findResponsable();
       
     }
     
     /// funciones tab1
    public String agregarP1(){
        controlGrabar1 = true;
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        lineaInvest = lineaInvest.trim();
        docenteInves = docenteInves.trim();
        nomFile1 = nomFile1.trim();
        
        if(lineaInvest.isEmpty()) validaVaciosP1 = true;
        if(docenteInves.isEmpty()) validaVaciosP1 =true;
        if(nomFile1.isEmpty()) validaVaciosP1 = true;

        return validaVaciosP1;
    }
    public String registraP1(){
        SegUsuario usuarioResp = new SegUsuario();
        usuarioResp = usuarioFacade.findUsuarioByCodUsu(new BigDecimal(docenteInves));
        SeaLineainves lineaInvestRespon = new SeaLineainves();
        lineaInvestRespon.setLineaId(new BigDecimal(lineaInvest));
        Date fecha = new Date();        
        System.out.println("lineaIn " + lineaInvest);
        
        if(respLinea == null){
            respLinea = new SeaResplineai();
            respLinea.setLineaId(lineaInvestRespon);
            respLinea.setUsuId(usuarioResp);
            respLinea.setRplineaiDocNombre(nomFile1);
            respLinea.setRplineaiFechaCrea(new Timestamp(fecha.getTime()));
            respLinea.setRplineaiDocDigital(file1);
            respLinea.setRplineaiEstado("A");
            respLineaFacade.create(respLinea);
            responsableList = respLineaFacade.findResponsable();
        }
        cancelarP1();
        return "";
    }
    
    public void cancelarP1(){
        controlGrabar1 = false;
        respLinea = null;
        lineaInvest ="";
        docenteInves ="";
        nomFile1="";
        validaVaciosP1 = true;
        
    }
    public  void eliminarP1(){
        Integer registro =0;
        if(responsableLineaSelected != null){
            SeaResplineai eliminar = null;
            for(int i=0; i< responsableList.size(); i++){
                SeaResplineai elemento = this.responsableList.get(i);
                if(responsableLineaSelected.getRlineaiId() == responsableList.get(i).getRlineaiId()){
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar !=null){
                this.responsableList.remove(eliminar);
               respLineaFacade.remove(eliminar);
               MensajeController m = null;
            }
            responsableList = respLineaFacade.findResponsable();
        }
    }
    
    public void onRowEditP1(RowEditEvent event){
        System.out.println("usuario " + usuario.getUsuId());
        System.out.println("docente " + docentEdit);
        
        SeaResplineai respInvestigaEdit = new SeaResplineai();
        respInvestigaEdit = (SeaResplineai) event.getObject();
        
        SeaLineainves lineaInvestigacion = new SeaLineainves();
        lineaInvestigacion.setLineaId(new BigDecimal(responLinEdit));
        respInvestigaEdit.setLineaId(lineaInvestigacion);
        SegUsuario usuarioResp = new SegUsuario();
        usuarioResp.setUsuId(new BigDecimal(docentEdit));
        respInvestigaEdit.setUsuId(usuarioResp);
        respLineaFacade.edit(respInvestigaEdit);
        responsableList = respLineaFacade.findResponsable();
        
    }
    public void onRowCancelP1(RowEditEvent event){
    }
    //// cargar archivo
    public void handFileUpload1(FileUploadEvent event) throws IOException {
        nomFile1 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile1(IOUtils.toByteArray(is));
        System.out.println("nomfile  " + nomFile1);
        validarVaciosP1();
        
    }
   
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// get and set p1
    
    public List<SeaLineainves> getLineaInvesList() {    
        return lineaInvesList;
    }

    public void setLineaInvesList(List<SeaLineainves> lineaInvesList) {
        this.lineaInvesList = lineaInvesList;
    }

    public boolean isControlGrabar1() {
        return controlGrabar1;
    }

    public void setControlGrabar1(boolean controlGrabar1) {
        this.controlGrabar1 = controlGrabar1;
    }

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

     public String getLineaInvest() {
        return lineaInvest;
    }

    public void setLineaInvest(String lineaInvest) {
        this.lineaInvest = lineaInvest;
    }
    public String getDocenteInves() {
        return docenteInves;
    }

    public void setDocenteInves(String docenteInves) {
        this.docenteInves = docenteInves;
    }
    
    public List<VDocenteInvestigacion> getDocenteInvestList() {
        return docenteInvestList;
    }

    public void setDocenteInvestList(List<VDocenteInvestigacion> docenteInvestList) {
        this.docenteInvestList = docenteInvestList;
    }
    public List<SeaResplineai> getResponsableList() {
        return responsableList;
    }

    public void setResponsableList(List<SeaResplineai> responsableList) {
        this.responsableList = responsableList;
    }
    public String getResponLinEdit() {
        return responLinEdit;
    }

    public void setResponLinEdit(String responLinEdit) {
        this.responLinEdit = responLinEdit;
    }
    public String getDocentEdit() {
        return docentEdit;
    }

    public void setDocentEdit(String docentEdit) {
        this.docentEdit = docentEdit;
    }
    public SeaResplineai getResponsableLineaSelected() {
        return responsableLineaSelected;
    }

    public void setResponsableLineaSelected(SeaResplineai responsableLineaSelected) {
        this.responsableLineaSelected = responsableLineaSelected;
    }
    public String getNomFile1() {
        return nomFile1;
    }

    public void setNomFile1(String nomFile1) {
        this.nomFile1 = nomFile1;
    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public byte[] getFile1() {
        return file1;
    }

    public void setFile1(byte[] file1) {
        this.file1 = file1;
    }
    
    //</editor-fold>
    
}
