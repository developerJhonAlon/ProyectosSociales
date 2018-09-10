/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.seguridades.navegacion;

import ec.edu.espe_ctt.seguridades.entity.*;
import ec.edu.espe_ctt.seguridades.session.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author Ing. Cristian Asimbaya
 */
@ManagedBean(name = "login")
@ViewScoped
public class LoginController implements Serializable {

    /**
     * Creates a new instance of CambioPasswordController
     */
//    @EJB
//    private BzdtusuFacade usuarioFacade;
//    @EJB
//    private BzdtusuperFacade usuPerfilFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;

    @EJB
    private SegUsuPerfilFacade usuPerfilFacade;

//    private HtmlInputText txt_usuario = new HtmlInputText();
//    private HtmlInputSecret txt_clave = new HtmlInputSecret();
    private InputText txt_usuario = new InputText();
    private Password txt_clave = new Password();
    @ManagedProperty(value = "#{mensajeBean}")
    private MensajeController mensajeBean;
    private BigDecimal sistema;
    private String password;
    private String uname;

    public LoginController() {

    }

    @PostConstruct
    public void init() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        session.invalidate();

        sistema = new BigDecimal(22);//// el sistema al que estoy habilitado 

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            String dato = (String) context.getExternalContext().getSessionMap().get("usuId");
            SegUsuario usu = usuarioFacade.find(new BigDecimal(dato));
            context.getExternalContext().getSessionMap().put("usu_login", usu);

            context.getExternalContext().getSessionMap().remove("usuId");
            context.getExternalContext().getSessionMap().remove("navegacion");
            context.getExternalContext().getSessionMap().remove("eventos");
            context.getExternalContext().getSessionMap().remove("sesionBean");
            context.getExternalContext().getSessionMap().remove("calificacion");
            context.getExternalContext().getSessionMap().remove("calificacionFinal");
            context.getExternalContext().getSessionMap().remove("configuracionParametrosEvaluacionActual");
            context.getExternalContext().dispatch("/vista/sistema.xhtml");

        } catch (Exception ex) {
        }
    }

    public String valida() {

        String result = "";
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
                .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);

        System.out.println(" ingreso ");

//        if (!txt_captcha.getValue().toString().equalsIgnoreCase(captcha)) {
//            FacesMessage message = new FacesMessage("Diferente a Imagen", "Diferente a Imagen");
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            context.addMessage("form_acceso:inputTextCaptcha", message);
//            txt_captcha.requestFocus();
//            return null;
//        }
        SegUsuario usu = null;
        List<SegPerfil> perfil = null;
        try {
            usu = usuarioFacade.validarUsuario(uname.trim(), password.trim());
            if (usu == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", usuarioFacade.getMensajeError()));
                return null;
            }
            if (usu.getUsuEstado().equalsIgnoreCase("I")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cuenta Inactiva. Debe haber recibido un mensaje de Correo para Activar su cuenta"));
                return null;
            }
            perfil = usuPerfilFacade.findPerfilesByUsuario(usu, getSistema());
            if (perfil == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario no tiene un perfil asignado para el acceso al sistema."));
                return null;
            }

            System.out.println("Usuario logueado exitosamente");

            context.getExternalContext().getSessionMap().remove("usu_login");
            context.getExternalContext().getSessionMap().remove("usu_perfil");
            context.getExternalContext().getSessionMap().remove("navegacion");
            context.getExternalContext().getSessionMap().remove("eventos");
            context.getExternalContext().getSessionMap().remove("sesionBean");
            context.getExternalContext().getSessionMap().remove("calificacion");
            context.getExternalContext().getSessionMap().remove("calificacionFinal");
            context.getExternalContext().getSessionMap().remove("configuracionParametrosEvaluacionActual");
            context.getExternalContext().getSessionMap().put("usu_login", usu);
            context.getExternalContext().getSessionMap().put("usu_perfil", perfil);

            //Obtener IP del equipo local
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            System.out.println("AppAspirante ipLocal: " + request.getRemoteAddr() + " User: " + usu.getUsuId() + " Date: " + new Date());

            result = "/vista/sistema.xhtml";
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problemas en verificación de usuario"));
            Logger.getLogger(LoginController.class.getName()).log(Level.INFO, null, ex);
        }
        return result;
    }

    public MensajeController getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeController mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public BigDecimal getSistema() {
        return sistema;
    }

    public void setSistema(BigDecimal sistema) {
        this.sistema = sistema;
    }

    public InputText getTxt_usuario() {
        return txt_usuario;
    }

    public void setTxt_usuario(InputText txt_usuario) {
        this.txt_usuario = txt_usuario;
    }

    public Password getTxt_clave() {
        return txt_clave;
    }

    public void setTxt_clave(Password txt_clave) {
        this.txt_clave = txt_clave;
    }

    public void buscarProductosActionListener(ActionEvent event) {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    private String passwordNuevo;

    public String getPasswordNuevo() {
        return passwordNuevo;
    }

    public void setPasswordNuevo(String passwordNuevo) {
        this.passwordNuevo = passwordNuevo;
    }

}
