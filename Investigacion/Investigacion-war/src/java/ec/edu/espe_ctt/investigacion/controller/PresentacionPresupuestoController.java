/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.ProgramacionAnualMes;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaMatrizRiesgos;
import ec.edu.espe_ctt_investigacion.entity.VResponsablesProyecto;
import ec.edu.espe_ctt_investigacion.session.CronogramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaMatrizRiesgosFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaAnualFacade;
import ec.edu.espe_ctt_investigacion.session.VResponsablesProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class PresentacionPresupuestoController {

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Cronograma
    private SegUsuario usuario;
    private boolean botonInicio = true;
    private boolean habilitaTab = true;

    @EJB
    private CronogramaFacade formatoCronogramaFacade;
    private List<Cronograma> formatoCronogramaList;
    private Cronograma formatoCronogramaSelected;

    ///Variables tab1
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;

    @EJB
    private SeaMatrizRiesgosFacade matrizRiesgosFacade;
    private List<SeaMatrizRiesgos> matrizRiesgosList;
    private SeaMatrizRiesgos matrizRiesgos;
    private SeaMatrizRiesgos matrizRiesgosSelected;

    private String estrategia = "";
    private String presupuesto = "";
    private String prioridad = "";
    private String probabilidad = "";
    private String riesgo = "";
    
    ///Variables tab1
    @EJB
    private SeaProgramaAnualFacade programaAnualFacade;
            
    private List<ProgramacionAnualMes> programacionAnualMesList;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }

    public String seleccionaConvo() {
        botonInicio = false;
        //habilitaTab = false;
        cargaDatosCronograma();
        return "";
    }

    public String inicioCronograma() {
        if (botonInicio) {
            /// regresar a lista de programas 
            System.out.println(" boton1 " + botonInicio);
            habilitaTab = true;

        } else {
            //// es nuevo 
            System.out.println(" boton 2" + botonInicio);

        }
        return "";

    }

    /////////////Funciones
    void checkIngreso() {
        //usuarioList = usuarioFacade.findAll();
        formatoCronogramaList = formatoCronogramaFacade.findFormatoCronogramaByCodUsu(usuario.getUsuId());

    }

    public void cargaDatosCronograma() {
        //tab1
        matrizRiesgosList = matrizRiesgosFacade.findMatrizRiesgosByCodCronograma(formatoCronogramaSelected.getId());
        

    }

    public String agregarP1() {
        controlGrabarP1 = true;
        return "";
    }

    public String registraP1() {

        if (matrizRiesgos == null) {
            //registra nuevo
            matrizRiesgos = new SeaMatrizRiesgos();
            //matrizRiesgos.setSfcrId(formatoCronogramaSelected);
            matrizRiesgos.setSmrEstrategia(estrategia);
            matrizRiesgos.setSmrPresupuesto(new BigDecimal(presupuesto));
            matrizRiesgos.setSmrPrioridad(new BigDecimal(prioridad));
            matrizRiesgos.setSmrProbabilidad(new BigDecimal(probabilidad));
            matrizRiesgos.setSmrRiesgo(riesgo);
            matrizRiesgosFacade.create(matrizRiesgos);
            matrizRiesgosList = matrizRiesgosFacade.findMatrizRiesgosByCodCronograma(formatoCronogramaSelected.getId());
            cancelarP1();
        }
        return "";

    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        //quitando espacios en blanco de las variales

        estrategia = estrategia.trim();
        presupuesto = presupuesto.trim();
        prioridad = prioridad.trim();
        probabilidad = probabilidad.trim();
        riesgo = riesgo.trim();

        //validando que no esten vacias.
        if (estrategia.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (presupuesto.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (prioridad.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (probabilidad.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (riesgo.isEmpty()) {
            validaVaciosP1 = true;
        }

        return validaVaciosP1;
    }

    public String eliminarP1() {
        if (matrizRiesgosSelected != null) {
            System.out.println(" eliminar ");
            SeaMatrizRiesgos eliminar = null;

            for (int i = 0; i < matrizRiesgosList.size(); i++) {
                SeaMatrizRiesgos elemento = this.matrizRiesgosList.get(i);
                if (matrizRiesgosSelected.getSmrId() == matrizRiesgosList.get(i).getSmrId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println(" eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar ");
                matrizRiesgosFacade.remove(eliminar);
                //matrizRiesgosList = matrizRiesgosFacade.findMatrizRiesgosByCodCronograma(formatoCronogramaSelected.getSflId().getSflId());
            }
        }
        return "";
    }

    public void cancelarP1() {
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        validaVaciosP1 = true;

        matrizRiesgos = null;
        estrategia = "";
        presupuesto = "";
        prioridad = "";
        probabilidad = "";
        riesgo = "";
    }

    public void onRowEdit(RowEditEvent event) {

        SeaMatrizRiesgos matrizRiesgosEdit = new SeaMatrizRiesgos();
        matrizRiesgosEdit = (SeaMatrizRiesgos) event.getObject();

        matrizRiesgosFacade.edit(matrizRiesgosEdit);

    }

    public void onRowCancel(RowEditEvent event) {

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    //selecciona formato
    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
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

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }


    //Tab 1
    public List<Cronograma> getFormatoCronogramaList() {
        return formatoCronogramaList;
    }

    public void setFormatoCronogramaList(List<Cronograma> formatoCronogramaList) {
        this.formatoCronogramaList = formatoCronogramaList;
    }

    public List<SeaMatrizRiesgos> getMatrizRiesgosList() {
        return matrizRiesgosList;
    }

    public Cronograma getFormatoCronogramaSelected() {
        return formatoCronogramaSelected;
    }

    public void setFormatoCronogramaSelected(Cronograma formatoCronogramaSelected) {
        this.formatoCronogramaSelected = formatoCronogramaSelected;
    }

    public void setMatrizRiesgosList(List<SeaMatrizRiesgos> matrizRiesgosList) {
        this.matrizRiesgosList = matrizRiesgosList;
    }

    public SeaMatrizRiesgos getMatrizRiesgosSelected() {
        return matrizRiesgosSelected;
    }

    public void setMatrizRiesgosSelected(SeaMatrizRiesgos matrizRiesgosSelected) {
        this.matrizRiesgosSelected = matrizRiesgosSelected;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(String probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }
    
    
    
    
    
//</editor-fold>

    //getter y setter tab2
    public List<ProgramacionAnualMes> getProgramacionAnualMesList() {
        return programacionAnualMesList;
    }

    public void setProgramacionAnualMesList(List<ProgramacionAnualMes> programacionAnualMesList) {
        this.programacionAnualMesList = programacionAnualMesList;
    }
}
