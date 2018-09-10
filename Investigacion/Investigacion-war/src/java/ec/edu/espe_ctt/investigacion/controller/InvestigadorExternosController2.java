/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class InvestigadorExternosController2 implements Serializable{

    /**
     * Creates a new instance of InvestigadorExternosController
     */
    public InvestigadorExternosController2() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private boolean inicio;
    private SegUsuario personalExternoSelected;
    private List<SegUsuario> personalExternoList;
    private SegUsuario usuarioActual;
    
    
    
    
    
    
    
    
    
    
    
    private List<SegUsuario> miembrosExternosList;
    private List<SegUsuario> paresExternosList;
    private List<SegUsuario> investigadorExternoList;
    private SegUsuario usuarioExiste;
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    private String nombres ="";
    private String apellidos ="";
    private String email ="";
    private String identificacion="";
    private String personalExterno;
    private Date fechActual;
    
    //</editor-fold>
   //<editor-fold defaultstate="collapsed" desc="Funciones">

    public String agregarP1(){
        controlGrabarP1 = true;
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        identificacion = identificacion.trim();
        nombres = nombres.trim();
        apellidos = apellidos.trim();
        email = email.trim();
        personalExterno = personalExterno.trim();
        if(identificacion.isEmpty()) validaVaciosP1 = true;
        if(nombres.isEmpty()) validaVaciosP1 = true;
        if(apellidos.isEmpty()) validaVaciosP1 = true;
        if(email.isEmpty()) validaVaciosP1 = true;
        if(personalExterno.isEmpty()) validaVaciosP1 = true;
        return validaVaciosP1;
    }
    public String registraP1(){
        /// validar si usuario existe en la base
        usuarioExiste = usuarioFacade.findUsuarioExisteByCedula(identificacion);
        if (usuarioExiste != null){
            RequestContext.getCurrentInstance().execute("alert('El Personal ya esta Registrado')");
             return "";
        } else {
            if(personalExterno.equals("M")){
                String mExt ="MIEMBEXT";
                miembrosExternosList = usuarioFacade.findMiembrosExternos();
                if(miembrosExternosList != null){
                    Integer sec = miembrosExternosList.size() + 1;
                    mExt = mExt + sec;
                }else {
                    Integer sec = 1;
                    mExt = mExt + sec;
                }
                fechActual = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("MM/dd/yyyy");
                String fechIngreso = formateador.format(fechActual);
                usuarioFacade.InsertUsuarioExterno(identificacion, identificacion,nombres,apellidos, email,fechIngreso ,"A",mExt);
            }
            if(personalExterno.equals("P")){
                String pExt = "PAREXT";
                paresExternosList = usuarioFacade.findParesExternos();
                if(paresExternosList != null){
                     Integer sec = paresExternosList.size() +1;
                     pExt = pExt + sec;
                } else {
                    Integer sec = 1;
                     pExt = pExt + sec;
                }
                fechActual = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("MM/dd/yyyy");
                String fechIngreso = formateador.format(fechActual);
                usuarioFacade.InsertUsuarioExterno(identificacion, identificacion,nombres,apellidos, email,fechIngreso ,"A",pExt);
            }
            if(personalExterno.equals("I")){
                String iExt = "INVEXT";
                investigadorExternoList = usuarioFacade.findInvestigadorExterno();
                if(investigadorExternoList != null){
                    Integer sec = investigadorExternoList.size() +1;
                    iExt = iExt + sec;
                }else {
                    Integer sec = 1;
                    iExt = iExt + sec;
                }
                fechActual = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("MM/dd/yyyy");
                String fechIngreso = formateador.format(fechActual);
                usuarioFacade.InsertUsuarioExterno(identificacion, identificacion,nombres,apellidos, email,fechIngreso ,"A",iExt);
            }
        }
        personalExternoList = usuarioFacade.findUsuarioExternos();
        cancelarP1();
         return "";
    }
    public void cancelarP1(){
        controlGrabarP1 = false;
        identificacion="";
        nombres="";
        apellidos="";
        email="";
        validaVaciosP1 = true;
    }
    public void  eliminarP1(){
        if(personalExternoSelected != null){
            SegUsuario eliminar = null;
            for (int i = 0; i < personalExternoList.size(); i++) {
                SegUsuario elemento = this.personalExternoList.get(i);
                if(personalExternoSelected.getUsuId() == personalExternoList.get(i).getUsuId()){
                    eliminar = elemento;
                    break;
                }
            }
            if(eliminar != null){
                this.personalExternoList.remove(eliminar);
                usuarioFacade.remove(eliminar);
                MensajeController  m = null;
            }
        }
        personalExternoList = usuarioFacade.findUsuarioExternos();
    }
    public void onRowEditP1(RowEditEvent event){
        SegUsuario usuExterEdit = new SegUsuario();
        usuExterEdit = (SegUsuario) event.getObject();
        usuarioFacade.edit(usuExterEdit);
    }    
    public void onRowCancelP1(RowEditEvent event){
    }
    
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
    public List<SegUsuario> getPersonalExternoList() {
        return personalExternoList;
    }

    public void setPersonalExternoList(List<SegUsuario> personalExternoList) {
        this.personalExternoList = personalExternoList;
    }
     public SegUsuario getPersonalExternoSelected() {
        return personalExternoSelected;
    }

    public void setPersonalExternoSelected(SegUsuario personalExternoSelected) {
        this.personalExternoSelected = personalExternoSelected;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getPersonalExterno() {
        return personalExterno;
    }

    public void setPersonalExterno(String personalExterno) {
        this.personalExterno = personalExterno;
    }
    //</editor-fold>








    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }
    
    public void nuevo(){
        personalExternoSelected = new SegUsuario();
    }
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        inicio=true;
        listarPersonalExterno();
    }
    
    public void listarPersonalExterno(){
        personalExternoList = usuarioFacade.findUsuarioExternos();
    }

    public void grabar(){
        personalExterno=null;
    }
    
    public void cancelar(){
        personalExterno=null;
    }
    
    
}
