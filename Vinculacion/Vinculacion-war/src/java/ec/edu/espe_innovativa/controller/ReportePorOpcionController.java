/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt.vinculacion.entity.HitoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.TipoPoblacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.extensions.event.timeline.TimelineRangeEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineGroup;
import org.primefaces.extensions.model.timeline.TimelineModel;

@ManagedBean(name = "reportePorOpcionController")
@ViewScoped
public class ReportePorOpcionController implements Serializable {

    private String opcionMenu;
    private List<SeaParametrosDet> tipoPoblacionSelectedList;

    private VDocenteVinculacion2 docenteSelected;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;    
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private Proyecto proyectoSelected;
    @EJB
    private ProyectoFacade proyectoFacade;
    private List<SeaParametrosDet> tipoPoblacionList;
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
private List<SeaParametrosDet> coberturaList;    
    
    @PostConstruct
    public void init() {
        
        opcionMenu = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("opcionMenu");
        Object idProyecto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProyecto");
        proyectoSelected = proyectoFacade.findById(Integer.valueOf(idProyecto.toString()));
        if (proyectoSelected.getResponsableList() != null && !proyectoSelected.getResponsableList().isEmpty()) {
            llenarDatosDocenteXUsuId(proyectoSelected.getResponsableList().get(0).getUsuario().getUsuId());
        }
        proyectoSelected.setearObjetivoBVivirProyectoPadreList();
        proyectoSelected.resetEstadoExpandidoObjetivo();
        tipoPoblacionSelectedList = new ArrayList<>();
        tipoPoblacionList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_POBLACION);
        for (TipoPoblacionProyecto tipoPoblacionProyecto : proyectoSelected.getTipoPoblacionList()) {
            tipoPoblacionSelectedList.add(tipoPoblacionProyecto.getTipoPoblacion());
        }
        coberturaList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
        cancelarP8(true);
    }

    private void llenarDatosDocenteXUsuId(BigDecimal usuId) {
        docenteSelected = vistaDocenteFacade.findByUsuId(usuId);
    }
    public String getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public Proyecto getProyectoSelected() {
        return proyectoSelected;
    }

    public void setProyectoSelected(Proyecto proyectoSelected) {
        this.proyectoSelected = proyectoSelected;
    }

    private ObjetivoPrograma objetivoProyectoSelected;

    public ObjetivoPrograma getObjetivoProyectoSelected() {
        return objetivoProyectoSelected;
    }

    public void setObjetivoProyectoSelected(ObjetivoPrograma objetivoProyectoSelected) {
        this.objetivoProyectoSelected = objetivoProyectoSelected;
    }
    private TimelineModel modelActividades;
    private TimelineModel modelHitos;

    public TimelineModel getModelActividades() {
        return modelActividades;
    }

    public void setModelActividades(TimelineModel modelActividades) {
        this.modelActividades = modelActividades;
    }

    public TimelineModel getModelHitos() {
        return modelHitos;
    }

    public void setModelHitos(TimelineModel modelHitos) {
        this.modelHitos = modelHitos;
    }

    private Date start;
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void cancelarP8(boolean resetearZoom) {
        //proyectoSelected = proyectoFacade.find(proyectoSelected.getId());

        modelActividades = new TimelineModel();
        if (objetivoProyectoSelected != null) {
            for (ObjetivoPrograma obj1 : proyectoSelected.getObjetivoProyectoList()) {
                if (obj1.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    for (ObjetivoPrograma obj2 : obj1.getSvinObjetivoHijoList()) {
                        // create groups  
                        if (obj2.getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                            for (ObjetivoPrograma act : obj2.getSvinObjetivoHijoList()) {
                                //TimelineEvent event = new TimelineEvent(act.getSvopObjetivoProy(), act.getFechaInicio(), act.getFechaFin(), true, act.getSvopObjetivoProy(), act.getSvopObjetivoProy().toLowerCase());
                                TimelineGroup group = new TimelineGroup(act.getSvopId().toString(), act);
                                modelActividades.addGroup(group);

                                TimelineEvent event = new TimelineEvent(act, act.getFechaInicio(), act.getFechaFin(), true, act.getSvopId().toString());
                                modelActividades.add(event);
                            }
                        }
                    }
                }
            }
        }

        modelHitos = new TimelineModel();
        TimelineGroup group = new TimelineGroup("Hitos", "Hitos");
        modelHitos.addGroup(group);
        if (objetivoProyectoSelected != null) {
            for (HitoProyecto hito : proyectoSelected.getHitoProyectoList()) {
                if (hito.getComponenteEspecifico().getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                    TimelineEvent event = new TimelineEvent(hito, hito.getFecha(), null, true, "Hitos");
                    modelHitos.add(event);
                }
            }

        }

        if (resetearZoom) {
            start = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(start);
            cal1.add(Calendar.DATE, -5);
            cal1.set(Calendar.HOUR_OF_DAY, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            start = cal1.getTime();

            end = new Date();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(end);
            cal2.add(Calendar.DATE, 5);
            cal2.set(Calendar.HOUR_OF_DAY, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            end = cal2.getTime();
        }
    }

    public void onRangeChanged(TimelineRangeEvent e) {
        start = e.getStartDate();
        end = e.getEndDate();
    }


    public List<SeaParametrosDet> getTipoPoblacionList() {
        return tipoPoblacionList;
    }

    public void setTipoPoblacionList(List<SeaParametrosDet> tipoPoblacionList) {
        this.tipoPoblacionList = tipoPoblacionList;
    }

    public List<SeaParametrosDet> getTipoPoblacionSelectedList() {
        return tipoPoblacionSelectedList;
    }

    public void setTipoPoblacionSelectedList(List<SeaParametrosDet> tipoPoblacionSelectedList) {
        this.tipoPoblacionSelectedList = tipoPoblacionSelectedList;
    }

    public VDocenteVinculacion2 getDocenteSelected() {
        return docenteSelected;
    }

    public void setDocenteSelected(VDocenteVinculacion2 docenteSelected) {
        this.docenteSelected = docenteSelected;
    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }

    public List<SeaParametrosDet> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<SeaParametrosDet> coberturaList) {
        this.coberturaList = coberturaList;
    }

    
}
