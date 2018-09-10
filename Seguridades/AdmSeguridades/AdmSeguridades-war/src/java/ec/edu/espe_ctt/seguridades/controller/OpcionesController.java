/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.seguridades.controller;

import ec.edu.espe_ctt.seguridades.entity.SegOpcion;
import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegOpcionFacade;
import ec.edu.espe_ctt.seguridades.session.SegSistemasFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class OpcionesController implements Serializable {

    /**
     * Creates a new instance of SeguridadSistemaController
     */
    public OpcionesController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">

    private String nombre = "";
    private String opcionPadre = "";
    private String nivel = "";
    private String orden = "";
    private String url = "";
    private String icono = "";
    private String sistema = "";

    @EJB
    private SegOpcionFacade opcionPadreFacade;
    private List<SegOpcion> opcionPadreList;

    @EJB
    private SegSistemasFacade sistemasFacade;
    private SegSistemas sistemas;
    private List<SegSistemas> sistemasList;

    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;

    @EJB
    private SegOpcionFacade opcionesFacade;

    private List<SegOpcion> opcionesList;
    private SegOpcion opcionSelected;
    private SegOpcion opcion;

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        checkIngreso();
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {

        sistemasList = sistemasFacade.findSistemas();
        opcionesList = opcionesFacade.listaOpcionesPadreHijo();
    }

    public void cargarOpcionesPadre() {
        if (!sistema.equals("")) {
            opcionPadreList = opcionPadreFacade.listaOpcionesPadreSistema(new BigDecimal(sistema));
        }
    }

    public String agregarP1() {
        controlGrabarP1 = true;
        return "";
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        nombre = nombre.trim();
        opcionPadre = opcionPadre.trim();

        if (opcionPadre.equals("x")) {
            nivel = "1";
        } else {
            if (url.isEmpty()) {
                validaVaciosP1 = true;
            }
            nivel = "2";
        }
        orden = orden.trim();
        url = url.trim();
        sistema = sistema.trim();

        if (nombre.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (opcionPadre.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (nivel.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (orden.isEmpty()) {
            validaVaciosP1 = true;
        }

        if (sistema.isEmpty()) {
            validaVaciosP1 = true;
        }
        return validaVaciosP1;
    }

    public void cancelarP1() {
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        opcion = null;
        String nombre = "";
        String opcionPadre = "";
        String nivel = "";
        String orden = "";
        String url = "";
        String icono = "";
        String sistema = "";
        validaVaciosP1 = true;

    }

    public String registrarP1() {
        if (opcion == null) {
            /// ingreso nuevo registro
            opcion = new SegOpcion();
            opcion.setOpcNombre(nombre);
            if (!opcionPadre.equals("x")) {
                opcion.setSegOpcion(new SegOpcion(new BigDecimal(opcionPadre)));
                opcion.setOpcUrl(url);
            }            
            opcion.setOpcImagen(icono);
            opcion.setOpcNivel(new BigInteger(nivel));
            opcion.setOpcOrden(new BigInteger(orden));

            opcion.setSegSistemas(new SegSistemas(new BigDecimal(sistema)));
            opcionesFacade.create(opcion);
            opcionesList = opcionesFacade.listaOpcionesPadreHijo();
            cancelarP1();
        }
        return "";
    }

    public void eliminarP1() {
        Integer registro = 0;
        List<SegOpcion> lstOpc = opcionesFacade.listaOpcionesPorPadre(opcionSelected.getOpcId());
        if (lstOpc.isEmpty()) {
            if (opcionSelected != null) {
                SegOpcion eliminar = null;
                for (int i = 0; i < opcionesList.size(); i++) {
                    SegOpcion elemento = this.opcionesList.get(i);
                    if (opcionSelected.getOpcId() == opcionesList.get(i).getOpcId()) {
                        eliminar = elemento;
                        break;
                    }
                }
                if (eliminar != null) {
                    this.opcionesList.remove(eliminar);
                    opcionesFacade.remove(eliminar);
                    MensajeController m = null;
                }
            }
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El menu contiene submenús eliminelos y vuelva a intentar')");
        }
    }

    public void onRowEditP1(RowEditEvent event) {
        SegOpcion segOpcionEdit = new SegOpcion();
        segOpcionEdit = (SegOpcion) event.getObject();
        opcionesFacade.edit(segOpcionEdit);
    }

    public void onRowCancelP1(RowEditEvent event) {
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

    //</editor-fold>
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOpcionPadre() {
        return opcionPadre;
    }

    public void setOpcionPadre(String opcionPadre) {
        this.opcionPadre = opcionPadre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public List<SegOpcion> getOpcionPadreList() {
        return opcionPadreList;
    }

    public void setOpcionPadreList(List<SegOpcion> opcionPadreList) {
        this.opcionPadreList = opcionPadreList;
    }

    public List<SegSistemas> getSistemasList() {
        return sistemasList;
    }

    public void setSistemasList(List<SegSistemas> sistemasList) {
        this.sistemasList = sistemasList;
    }

    public List<SegOpcion> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<SegOpcion> opcionesList) {
        this.opcionesList = opcionesList;
    }

    public SegOpcion getOpcionSelected() {
        return opcionSelected;
    }

    public void setOpcionSelected(SegOpcion opcionSelected) {
        this.opcionSelected = opcionSelected;
    }

    public SegOpcion getOpcion() {
        return opcion;
    }

    public void setOpcion(SegOpcion opcion) {
        this.opcion = opcion;
    }
}
