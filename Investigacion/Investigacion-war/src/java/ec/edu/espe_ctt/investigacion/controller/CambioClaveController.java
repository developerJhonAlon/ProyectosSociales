/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class CambioClaveController implements Serializable{

    /**
     * Creates a new instance of CambioClaveController
     */
    public CambioClaveController()  {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Seg Usuario
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private List<SegUsuario> usuarioList;
    private SegUsuario usuarioClave;
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    private String identif ="";
    private String password ="";
    private String confirmapassw ="";
    private BigDecimal idUsuario ;
    
    //</editor-fold>
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
        usuarioList = usuarioFacade.findUsuarioByidUsu(usuario.getUsuId());
    }
    /// funciones tabP1
    public String agregarP1(){
        controlGrabarP1 = true;
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        identif = identif.trim();
        //password = password.trim();
        //confirmapassw = confirmapassw.trim();
        if(identif.isEmpty())validaVaciosP1 = true;
        //if(password.isEmpty()) validaVaciosP1 = true;
        //if(confirmapassw.isEmpty()) validaVaciosP1 = true;
        return validaVaciosP1;
     }
    public String registraP1() throws IOException{
        idUsuario = usuario.getUsuId();
        String oldClave = usuario.getUsuClave();
        if(password.equals(confirmapassw)){
            usuarioFacade.UpdateClaveByIdUsuCodUsu(password, idUsuario);
            ///Recupera clave actual
            usuarioClave = usuarioFacade.findByCedula(identif);
            String newClave = usuarioClave.getUsuClave();
            if(!oldClave.equals(newClave)){
                //RequestContext.getCurrentInstance().execute("alert('Actualización Exitosa')");
                RequestContext.getCurrentInstance().execute("PF('cambiaPassDialog').show();");
            }
        } else {
            RequestContext.getCurrentInstance().execute("alert('No Coincide el Password Ingresado')");
            return "";
        }
        usuarioList = usuarioFacade.findUsuarioByidUsu(usuario.getUsuId());
        cancelarP1();
        return "";
        
    }
    public void cancelarP1(){
        controlGrabarP1 = false;
        identif = "";
        password = "";
        confirmapassw ="";
        validaVaciosP1 = true;
    }
    public void cerrar_session() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usu_login");
        context.getExternalContext().getSessionMap().remove("navegacion");
        context.getExternalContext().getSessionMap().remove("eventos");
        context.getExternalContext().getSessionMap().remove("sesionBean");
        context.getExternalContext().getSessionMap().remove("usu_login");
        ec.invalidateSession();   
        ec.redirect(ec.getRequestContextPath());
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
    public String getIdentif() {
        return identif;
    }

    public void setIdentif(String identif) {
        this.identif = identif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmapassw() {
        return confirmapassw;
    }

    public void setConfirmapassw(String confirmapassw) {
        this.confirmapassw = confirmapassw;
    }
    public List<SegUsuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<SegUsuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    //</editor-fold>
}


