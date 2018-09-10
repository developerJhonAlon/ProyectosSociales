/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.seguridades.navegacion;

import ec.edu.espe_ctt.seguridades.entity.SegOpcion;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegOpcionFacade;
import ec.edu.espe_ctt_investigacion.session.ParametrosGlobales;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author PC1
 */
@ManagedBean
@SessionScoped
public class NavegacionController implements Serializable {

    /**
     * Creates a new instance of NavegacionController
     */
    private MenuModel menuModel;
    private MenuModel model;
    private List<SegOpcion> lopciones = new ArrayList<SegOpcion>();
    private SegUsuario usu_login;
    @EJB
    private SegOpcionFacade segOpcionFacade;
    private static String pathSistema = "/webapp/";
    private static String home = "/WEB-INF/includes/content/splash.xhtml";
    //  private String selectedIncludePath = "/webapp/procesos/formulario/formularios.xhtml";
    //   private String selectedIncludePath = "/webapp/procesos/recinto/seleccionRecinto.xhtml";
    //  private String selectedIncludePath = "/webapp/procesos/miCuenta.xhtml";
    //private String selectedIncludePath = "/webapp/consultas/estadoProcesos.xhtml";
    public String selectedIncludePath = "";
    private StreamedContent imagen1 = null;

    public NavegacionController() {

        usu_login = (SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu_login");
        String url = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("url_navegaPage");

        if (url != null) {
            selectedIncludePath = url;
        }

    }

    @PostConstruct
    public void init() {
// cuando tenemos menu normal
//        if (usu_login != null) {
//            setLopciones(this.segOpcionFacade.listaOpciones(sistema, usu_login.getUsuId()));
//            for (int i = 0; i < getLopciones().size(); i++) {
//                SegOpcion opc = (SegOpcion) getLopciones().get(i);
//                List lopcionesHijos = this.segOpcionFacade.listaOpcionesPapaPerfil(opc.getOpcId(), sistema, usu_login.getUsuId());
//                opc.setLhijos(lopcionesHijos);
//            }
//
//        }

        if (usu_login != null) {
            BigDecimal idSistema = ParametrosGlobales.AMBIENTE_PRODUCCION1 ? new BigDecimal(3) : new BigDecimal(4);
            setLopciones(this.segOpcionFacade.listaOpcionesHijo(idSistema, usu_login.getUsuId()));
        }
    }

    public List<SegOpcion> getLopciones() {
        return lopciones;
    }

    public void setLopciones(List<SegOpcion> lopciones) {
        this.lopciones = lopciones;
    }

    public MenuModel getMenuModel() {

        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public void van() {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String archivo = (String) map.get("includePath");
        selectedIncludePath = (String) map.get("includePath");

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
        System.out.println("ec.getRequestContextPath(): " + ec.getRequestContextPath());
    }

    public String getSelectedIncludePath() {

        return selectedIncludePath;
    }

    public void setSelectedIncludePath(String selectedIncludePath) {
        this.selectedIncludePath = selectedIncludePath;
    }

    public void navigationPathChange(ActionEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String archivo = (String) map.get("includePath");

        if (archivo != null && archivo.length() > 0) {
            selectedIncludePath = (String) map.get("includePath");

        }
    }

    public StreamedContent getImagen1() {
        return imagen1;
    }

    public void setImagen1(StreamedContent imagen1) {
        this.imagen1 = imagen1;
    }

}
