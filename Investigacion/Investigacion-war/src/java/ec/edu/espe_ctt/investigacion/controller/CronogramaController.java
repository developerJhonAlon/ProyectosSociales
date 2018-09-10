/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.VResponsablesProyecto;
import ec.edu.espe_ctt_investigacion.session.CronogramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
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
public class CronogramaController {

    private SegUsuario usuario;
    private Date base;

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Convocatoria
    private boolean botonInicio = true;
    private boolean habilitaTab = true;

    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private List<SeaFormatoLargo> formatoLargoList;
    private SeaFormatoLargo formatoLargoSelected;

    ///Variables tab1
    private ScheduleModel eventModel;
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    private int duracion;
    private String responsable = "";
    private String nombre = "";

    @EJB
    private CronogramaFacade formatoCronogramaFacade;
    private List<Cronograma> formatoCronogramaList;
    private Cronograma formatoCronograma;

    @EJB
    private VResponsablesProyectoFacade responsableFormatoFacade;
    private List<VResponsablesProyecto> responsableFormatoList;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }

    public String inicioFormatoLargo() {
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

    public String seleccionaConvo() {
        botonInicio = false;
        //habilitaTab = false;
        cargaDatosConvoca();
        return "";
    }

    /////////////Funciones
    void checkIngreso() {
        //usuarioList = usuarioFacade.findAll();
        formatoLargoList = formatoLargoFacade.findFormatoLargoByCodUsu(usuario.getUsuId());
    }

    public void cargaDatosConvoca() {

        //tab1
        responsableFormatoList = responsableFormatoFacade.findResponsablesByDatProy(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
        formatoCronogramaList = formatoCronogramaFacade.findFormatoCronogramaByFormatoLargo(formatoLargoSelected.getSflId());
        eventModel = new DefaultScheduleModel();
        for (Cronograma fc : formatoCronogramaList) {
            //eventModel.addEvent(new DefaultScheduleEvent(fc.getSfcrActividad(), fc.getFechaInicio(), fc.getFechaFin(), fc));
        }
//        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
//        eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));

        lazyEventModel = new LazyScheduleModel() {

            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));

                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
            }
        };

    }

    public void calculaFechas() {
        if (event.getStartDate() != null) {
            Calendar fecha = GregorianCalendar.getInstance();
            fecha.setTime(event.getStartDate());
            fecha.add(Calendar.DATE, duracion-1);
            event = new DefaultScheduleEvent(event.getTitle(), event.getStartDate(), fecha.getTime());

        }
    }

    public void calculaDuracion() {
        Calendar fecha = GregorianCalendar.getInstance();
        fecha.setTimeInMillis(event.getEndDate().getTime() - event.getStartDate().getTime());
        duracion = fecha.get(Calendar.DAY_OF_YEAR);
        duracion = duracion + 1;
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        //quitando espacios en blanco de las variales
        responsable = responsable.trim();
        System.out.println("x:" + nombre);

        //validando que no esten vacias.
        if (event.getTitle().isEmpty()) {
            validaVaciosP1 = true;
        }
        if (event.getStartDate() == null) {
            validaVaciosP1 = true;
        }
        if (event.getEndDate() == null) {
            validaVaciosP1 = true;
        }
        if (duracion == 0) {
            validaVaciosP1 = true;
        }
        if (responsable.isEmpty()) {
            validaVaciosP1 = true;
        }
        calculaFechas();
        return validaVaciosP1;
    }

    public String eliminarP1() {
        eventModel.deleteEvent(event);
        System.out.println("event.getData():" + event.getData().toString());
        formatoCronogramaFacade.remove((Cronograma) event.getData());
        return "";
    }

    public void cancelarP1() {
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        validaVaciosP1 = true;
        formatoCronograma = null;
        event = new DefaultScheduleEvent();
        duracion = 1;
        responsable = "";
//        comisionConvocatoria = null;
//        //convocatoria = "";
//        investigador = "";
//        //tipoInvestigacion = "";
//        tipoResponsabilidad = "";
//        nomFileP1 = "";
        //estado = "";
    }

    public void onIdle() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "No activity.", "What are you doing over there?"));
    }

    public void onActive() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Welcome Back", "Well, that's a long coffee break!"));
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);

        return t.getTime();
    }

    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);

        return t.getTime();
    }

    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }

    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);

        return t.getTime();
    }

    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
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

    public List<SeaFormatoLargo> getFormatoLargoList() {
        return formatoLargoList;
    }

    public void setFormatoLargoList(List<SeaFormatoLargo> formatoLargoList) {
        this.formatoLargoList = formatoLargoList;
    }

    public SeaFormatoLargo getFormatoLargoSelected() {
        return formatoLargoSelected;
    }

    public void setFormatoLargoSelected(SeaFormatoLargo formatoLargoSelected) {
        this.formatoLargoSelected = formatoLargoSelected;
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
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VResponsablesProyecto> getResponsableFormatoList() {
        return responsableFormatoList;
    }

    public void setResponsableFormatoList(List<VResponsablesProyecto> responsableFormatoList) {
        this.responsableFormatoList = responsableFormatoList;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        if (formatoCronograma == null) {
            formatoCronograma = new Cronograma();
            /*formatoCronograma.setSfcrActividad(event.getTitle());
            formatoCronograma.setFechaInicio(event.getStartDate());
            formatoCronograma.setFechaFin(event.getEndDate());
            formatoCronograma.setSfcrDuracion(BigInteger.valueOf(duracion));
            formatoCronograma.setSflId(formatoLargoSelected);
            formatoCronograma.setUsuId(new SegUsuario(new BigDecimal(responsable)));*/

        }
        if (event.getId() == null) {
            eventModel.addEvent(event);
            formatoCronogramaFacade.create(formatoCronograma);
        } else {
            eventModel.updateEvent(event);
            formatoCronogramaFacade.edit(formatoCronograma);
        }

        cancelarP1();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        /*event = (ScheduleEvent) selectEvent.getObject();
        Cronograma fc = (Cronograma) event.getData();
        duracion=fc.getSfcrDuracion().intValue();
        responsable = fc.getUsuId().getUsuId().toString();*/

    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        Calendar fi = Calendar.getInstance();        
        fi.setTime(event.getScheduleEvent().getStartDate());
        fi.add(Calendar.DATE, event.getDayDelta());
        
        System.out.println("Day delta:" + event.getDayDelta());
        System.out.println("event.getScheduleEvent().getEndDate():" + event.getScheduleEvent().getEndDate());
        Calendar ff = Calendar.getInstance();
        System.out.println("ff.getTime()1:"+ff.getTime());
        ff.setTime(event.getScheduleEvent().getEndDate());
        System.out.println("ff.getTime()2:"+ff.getTime());
        ff.add(Calendar.DATE, event.getDayDelta());
        System.out.println("ff.getTime()3:"+ff.getTime());

        if (formatoCronograma == null) {
            formatoCronograma = new Cronograma();
            formatoCronograma = (Cronograma) event.getScheduleEvent().getData();
            formatoCronograma.setFechaInicio(fi.getTime());
            formatoCronograma.setFechaFin(ff.getTime());
            formatoCronogramaFacade.edit(formatoCronograma);
        }
        formatoCronograma = null;
//        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        
        System.out.println("event.getDayDelta():" + event.getDayDelta());
        
        Calendar ff = Calendar.getInstance();
        ff.setTime(event.getScheduleEvent().getEndDate());
        System.out.println("ff.getTime():"+ff.getTime());
        ff.add(Calendar.DATE, event.getDayDelta());
        System.out.println("ff.getTime() 1:"+ff.getTime());
        if (formatoCronograma == null) {
            formatoCronograma = new Cronograma();
            formatoCronograma = (Cronograma) event.getScheduleEvent().getData();
            formatoCronograma.setFechaFin(ff.getTime());
            formatoCronogramaFacade.edit(formatoCronograma);
        }
        formatoCronograma = null;
//        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
//</editor-fold>

}
