/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.session.StvcampFacade;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.saturno.session.StvsubjFacade;
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegPerfilFacade;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt.vinculacion.entity.ActividadPrograma;
import ec.edu.espe_ctt.vinculacion.entity.AnexoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.AspectoEvaluacionFinal;
import ec.edu.espe_ctt.vinculacion.entity.AvanceActividad;
import ec.edu.espe_ctt.vinculacion.entity.AvanceComponente;
import ec.edu.espe_ctt.vinculacion.entity.CarreraPrograma;
import ec.edu.espe_ctt.vinculacion.entity.DetalleEvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.EvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.DepartamentoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.EstrategiaPlanVincula;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPlanVincula;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico;
import ec.edu.espe_ctt.vinculacion.entity.EntidadEjecutoraPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPlanVinculaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivirPrograma;
import ec.edu.espe_ctt.vinculacion.entity.IndicadorEstrategiaProyecto;
import ec.edu.espe_ctt.vinculacion.entity.LeccionAprendidaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.EstrategiaPlanVinculaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorDepartamento;
import ec.edu.espe_ctt.vinculacion.entity.VistaCampusDeptoCarrera;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.session.ActividadProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.AnexoProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.CarreraProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionParametrosEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.DepartamentoProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.EstrategiaPlanVinculaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoPlanVinculaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoBVivirFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoEstrategicoFacade;
import ec.edu.espe_ctt.vinculacion.session.EntidadEjecutoraProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.IndicadorEstrategiaProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.LeccionAprendidaProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoPlanVinculaProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoBVivirProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.EstrategiaPlanVinculaProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.VDirectorDepartamentoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt.vinculacion.session.VistaCampusDeptoCarreraFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import ec.edu.espe_innovativa.util.FacesUtils;
import ec.edu.espe_innovativa.util.JasperReportUtil;
import java.io.ByteArrayInputStream;
import static java.io.File.separatorChar;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.Visibility;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ProgramaController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;
    private DualListModel<String> cities;

    //datos generales
    private boolean habilitaTab = true;
    private boolean botonInicio = true;
    private boolean controlGrabarP2 = false;
    private boolean controlGrabarP4 = false;
    private boolean controlGrabarP5 = false;
    private boolean controlGrabarP6 = false;
    private boolean controlGrabarP7 = false;
    private boolean controlGrabarP10 = false;
    private boolean controlGrabarP11 = false;
    private boolean controlGrabarP15 = false;
    private boolean controlGrabarP16 = false;
    private boolean controlGrabarP18 = false;
    private boolean validaVaciosP1 = true;
    private boolean validaVaciosP4 = true;
    private boolean validaVaciosP2 = true;
    private boolean validaVaciosP5 = true;
    private boolean validaVaciosP6 = true;
    private boolean validaVaciosP7 = true;
    private boolean validaVaciosP10 = true;
    private boolean validaVaciosP11 = true;
    private boolean validaVaciosP14 = true;
    private boolean validaVaciosP15 = true;
    private boolean validaVaciosP17 = true;
    private boolean validaVaciosP18 = true;

    /// Programas Vinculacion
    @EJB
    private ProgramaFacade programaFacade;
    @EJB
    private DepartamentoProgramaFacade svinDepcenproyFacade;
    private List<DepartamentoPrograma> departamentoCarreraProgramaList;

    @EJB
    SegPerfilFacade segPerfilFacade;
    private Programa programaSelected;
    private String nombreProg = "";
    private int meses;
    private int anos;
    private String duracion = "";
    private Date fechaFinReal;
    private String fechaInicioS = "";
    private int mes1;
    private int mes2;

    //Objetivo Plan nacional
    @EJB
    private ObjetivoBVivirFacade svinObjBVivirFacade;
    private List<ObjetivoBVivir> objBVivirPadreList;
    private List<ObjetivoBVivir> objBVivirHijoList;
    private ObjetivoBVivir objBVivirPadre = new ObjetivoBVivir();
    private ObjetivoBVivir objBVivirHijo = new ObjetivoBVivir();

    //Objetivos del Plan por programa
    @EJB
    private ObjetivoBVivirProgramaFacade svinProgObjFacade;
    private ObjetivoBVivirPrograma svinProgObjSelected;
    private List<ObjetivoBVivirPrograma> proObjList;

    /// Campus
    @EJB
    private StvcampFacade campusFacade;
    private List<Stvcamp> campusList;

/// Departamento
    @EJB
    private VistaCampusDeptoCarreraFacade campusDepartamentoFacade;
    private List<VistaCampusDeptoCarrera> campusDepartamentoList;
    @EJB
    private StvsubjFacade departamentoFacade;
    private List<Stvsubj> departamentoList;

    ///Carreras
    @EJB
    private StvmajrFacade stvCarrerasFacade;
    private List<Stvmajr> carreraList;

    ///Departamentos
    private DepartamentoPrograma svinDepcenproySelected;
    @EJB
    private CarreraProgramaFacade carreraProgramaFacade;
    private CarreraPrograma carreraProgramaSelected;
    private List<CarreraPrograma> carreraProgramaList;

    ////
    @EJB
    private EntidadEjecutoraProgramaFacade entidadEjecutoraFacade;
    private List<EntidadEjecutoraPrograma> entidadEjecutoraList;
    private EntidadEjecutoraPrograma entidadEjecutoraSelected;

    //Objetivos estrategicos institucionales
    @EJB
    private ObjetivoEstrategicoFacade objetivoEstrategicoFacade;
    private List<ObjetivoEstrategico> perspectivasList;
    private ObjetivoEstrategico perspectivaSelected;
    private ObjetivoEstrategico objetivoEstrategicoSelected;
    private IndicadorEstrategiaProyecto indicadorEstrategiaProyectoSelected;

    //Objetivos del plan de Vinculacion
    @EJB
    private ObjetivoPlanVinculaFacade svinObjPlanVinculaFacade;
    private List<ObjetivoPlanVincula> objPlanVinculaList;
    private ObjetivoPlanVincula planProgramaV;

    //Objetivos del plan de vinculacion por programa
    @EJB
    private ObjetivoPlanVinculaProgramaFacade svinPlanVProgramaFacade;
    private List<ObjetivoPlanVinculaPrograma> svinPlanVProgList;
    private ObjetivoPlanVinculaPrograma planVProgSelected;

    //Estratégias del plan de vinculacion
    @EJB
    private EstrategiaPlanVinculaFacade svinEstrategiasVinculaFacade;
    private List<EstrategiaPlanVincula> estrategiasVinculaList;
    private EstrategiaPlanVincula estrategiaV;

    //Estratégias del plan de vinculacion por programa
    @EJB
    private EstrategiaPlanVinculaProgramaFacade svinEstrategiaProgramaFacade;
    private List<EstrategiaPlanVinculaPrograma> estrategiasProgramaList;
    private EstrategiaPlanVinculaPrograma estrategiaProgSelected;

    ///Provincia
    @EJB
    private SeaProvinciaFacade provinciaFacade;
    private List<SeaProvincia> provinciaList;

    /// Docentes    
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;

    //private VDocenteVinculacion cargodocVinculacion = new VDocenteVinculacion();
    private VDocenteVinculacion2 docenteSelected;

    //Responsable del programa
    /*@EJB
     private ResponsableProyectoFacade svinResponsableProgFacade;*/
    //private ResponsableProyecto svinResponsableProg;
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private String codDocente = "";
    private String nomDocenteBusqueda = "";

    //tab13(matriz Objetivos del Programa)
    @EJB
    private ObjetivoProgramaFacade svinObjetivoprogramaFacade;
    private ObjetivoPrograma objPrograma;
    private List<ObjetivoPrograma> objetivoProgramaList;
    Integer tipoObjetivo = 0;
    String objetivo = "";
    String indicador = "";
    String medioVerif = "";
    String supuestos = "";

    ///Localizacion y Cobertura
    private boolean controlGrabarP3 = false;
    private boolean validaVaciosP3 = true;

    ///Zona Detalle
    @EJB
    private ObjetivoProgramaFacade objetivoProgramaFacade;
    private ObjetivoPrograma objetivoProgramaSelected;
    private ObjetivoPrograma objetivoProgramaPadreSelected;
    @EJB
    private VDirectorDepartamentoFacade vDirectorDepartamentoFacade;

    /**
     * Creates a new instance of ProgramaVinculacionController
     */
    public ProgramaController() {
        entidadEjecutoraSelected = new EntidadEjecutoraPrograma();
        objetivoProgramaSelected = new ObjetivoPrograma();
        carreraProgramaSelected = new CarreraPrograma();
    }

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");
        checkIngreso();
        modoEdicion = false;

        Object idPrograma = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPrograma");
        if (idPrograma != null) {
            programaSelected = programaFacade.find(Integer.valueOf(idPrograma.toString()));
            seleccionaPrograma();
        } else {
            modoEdicion = true;
            agregarPrograma();
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {

        /*campusList = campusFacade.findCampus();
        Collections.sort(campusList);*/
        campusList = new ArrayList<>();
        List<VDirectorDepartamento> vDirectorDepartamentoList = vDirectorDepartamentoFacade.findAll();
        for (VDirectorDepartamento dir : vDirectorDepartamentoList) {
            if (dir.getCampus() != null && dir.getDepartamento() != null) {
                boolean encontro = false;
                for (Stvcamp camp : campusList) {
                    if (camp.equals(dir.getCampus())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    Stvcamp cam = dir.getCampus();
                    for (VDirectorDepartamento dir2 : vDirectorDepartamentoList) {
                        if (dir2.getCampus() != null && dir2.getDepartamento() != null) {
                            if (dir2.getCampus().equals(cam)) {
                                cam.addDepartamento(dir2.getDepartamento());
                            }
                        }
                    }
                    campusList.add(cam);
                }
            }

        }
        Collections.sort(campusList);

        provinciaList = provinciaFacade.findAllOrdenados();

        carreraList = stvCarrerasFacade.findCarrera();

        //objetivos buen vivir tab 4
        objBVivirPadreList = svinObjBVivirFacade.findObjetivosPadre();
        //tab 5
        //tab 6
        objPlanVinculaList = svinObjPlanVinculaFacade.findAll();
        Collections.sort(objPlanVinculaList);

        planProgramaV = new ObjetivoPlanVincula();
        planProgramaV.setSvopviId(BigDecimal.ZERO);
        //tab 7     
        estrategiaV = new EstrategiaPlanVincula();
        // estrategiaV.setSvevId(BigDecimal.ZERO);
        //tab 10        
        //departamentoParticipante = new Stvsubj();
        //stvDepartPart.setStvsubjCode(BigDecimal.ZERO);
        //tab11
        //stvCarreras = new Stvmajr();

        estrategiasVinculaList = svinEstrategiasVinculaFacade.findAll();
        Collections.sort(estrategiasVinculaList);
    }

    public String seleccionaPrograma() {
        botonInicio = false;
        habilitaTab = false;
        indiceTabActivo = 0;
        /*campusList = campusFacade.findCampus();
        Collections.sort(campusList);*/
        //tab1

        nombreProg = programaSelected.getNombre();

        if (programaSelected.getDirector() != null) {
            llenarDatosDirectorXUsuId(programaSelected.getDirector().getUsuario().getUsuId());
        }

        calculaDuracion();

        //tab2            
        //entidadEjecutoraList = entidadEjecutoraFacade.findOpcionInstitucion(programaSelected.getSprvId());
        /// tabP3
        provinciaList = provinciaFacade.findAllOrdenados();
        // tab de los objetivos de la cobertura 

        validaVaciosP1 = true;
        crearArbolMenu();
        return "";
    }

    private void agregarPrograma() {
        indiceTabActivo = 0;
        nombreProg = "";
        docenteSelected = new VDocenteVinculacion2();
        nomDocenteBusqueda = "";
        programaSelected = new Programa();
        programaSelected.asignarCreador(usuarioActual);
        EntidadEjecutoraPrograma entidadEjecutora = new EntidadEjecutoraPrograma();
        entidadEjecutora.setSopinNombre("Universidad de las Fuerzas Armadas - ESPE");
        entidadEjecutora.setProId(new SeaProvincia("17")); //Pichincha
        entidadEjecutora.setSopinCiudad("Sangolqui");
        entidadEjecutora.setSopinDireccion("Av. Gral. Rumiñahui s/n");
        entidadEjecutora.setSopinTelefono("(593)02-3989400");
        entidadEjecutora.setSopinPaguinaWeb("www.espe.edu.ec");
        programaSelected.addEntidadEjecutora(entidadEjecutora);

        codDocente = null;
        duracion = null;
        validaVaciosP1 = true;

        habilitaTab = true;
        //// tabP1
        /*campusList = campusFacade.findCampus();
        Collections.sort(campusList);*/
        crearArbolMenu();
    }

    private void llenarObjetivos() {
        proObjList = new ArrayList<>();
        List<ObjetivoBVivirPrograma> proObjListTemp = svinProgObjFacade.findByPrograma(programaSelected.getId());

        for (ObjetivoBVivirPrograma svinProgObjHijo : proObjListTemp) {
            boolean encontro = false;
            for (ObjetivoBVivirPrograma svinProgObjPadre : proObjList) {

                if (svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre().getSvobviId().equals(svinProgObjPadre.getObjetivoBVivir().getSvobviId())) {
                    svinProgObjPadre.getSvinProgObjHijos().add(svinProgObjHijo);
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                ObjetivoBVivirPrograma svinProgObjPadreNuevo = new ObjetivoBVivirPrograma();
                svinProgObjPadreNuevo.setPrograma(svinProgObjHijo.getPrograma());
                svinProgObjPadreNuevo.setObjetivoBVivir(svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre());
                svinProgObjPadreNuevo.getSvinProgObjHijos().add(svinProgObjHijo);
                proObjList.add(svinProgObjPadreNuevo);

            }
        }
        Collections.sort(proObjList);
    }

    private void agregarObjetivo(ObjetivoBVivirPrograma svinProgObjHijo) {
        boolean encontro = false;
        for (ObjetivoBVivirPrograma svinProgObjPadre : proObjList) {

            if (svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre().getSvobviId().equals(svinProgObjPadre.getObjetivoBVivir().getSvobviId())) {
                svinProgObjPadre.getSvinProgObjHijos().add(svinProgObjHijo);
                encontro = true;
                break;
            }
        }
        if (!encontro) {
            ObjetivoBVivirPrograma svinProgObjPadreNuevo = new ObjetivoBVivirPrograma();
            svinProgObjPadreNuevo.setPrograma(svinProgObjHijo.getPrograma());
            svinProgObjPadreNuevo.setObjetivoBVivir(svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre());
            svinProgObjPadreNuevo.getSvinProgObjHijos().add(svinProgObjHijo);
            proObjList.add(svinProgObjPadreNuevo);

        }
        Collections.sort(proObjList);
    }

    /// funciones tabP1
    public void cancelarPerfil() {
        programaSelected = programaFacade.find(programaSelected.getId());
        nombreProg = programaSelected.getNombre();
        calculaDuracion();
        if (programaSelected.getDirector() != null) {
            llenarDatosDirectorXUsuId(programaSelected.getDirector().getUsuario().getUsuId());
        }
        validaVaciosP1 = true;
        modoEdicion = false;
    }

    public boolean validarVaciosP1() {
        boolean datosCompletos = true;
        if (!programaSelected.getFechaFin().after(programaSelected.getFechaInicio())) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:fechFin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización debe ser mayor que la fecha de inicio"));
            datosCompletos = false;
        }
        if (docenteSelected.getUsuario().getUsuId() == null) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblNombreDirector", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Campo obligatorio"));
            datosCompletos = false;
        }
        return datosCompletos;
    }

    public void eliminarCampus() {
        programaSelected.eliminarSvinDepcenProy(svinDepcenproySelected);
        //validarVaciosP1();
    }
    private boolean habilitarAgregarCampus;

    public boolean isHabilitarAgregarCampus() {
        return habilitarAgregarCampus;
    }

    public void setHabilitarAgregarCampus(boolean habilitarAgregarCampus) {
        this.habilitarAgregarCampus = habilitarAgregarCampus;
    }
    private DepartamentoPrograma campusPrograma;

    public DepartamentoPrograma getCampusPrograma() {
        return campusPrograma;
    }

    public void setCampusPrograma(DepartamentoPrograma campusPrograma) {
        this.campusPrograma = campusPrograma;
    }

    public String nuevoCampus() {
        campusPrograma = new DepartamentoPrograma();
        return "";
    }

    public String cancelarCampus() {
        campusPrograma = null;
        return "";
    }

    public String agregarCampus() {
        for (DepartamentoPrograma departamentoPrograma : programaSelected.getCampusList()) {
            if (departamentoPrograma.getCampus().equals(campusPrograma.getCampus())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Campus seleccionado ya ha sido agregado"));
                return null;
            }
        }
        DepartamentoPrograma campusProgramaNuevo = new DepartamentoPrograma();
        campusProgramaNuevo.setPrograma(programaSelected);
        for (Stvcamp campus : campusList) {
            if (campus.equals(campusPrograma.getCampus())) {
                campusProgramaNuevo.setCampus(campus);
                programaSelected.agregarSvinDepcenProy(campusProgramaNuevo);
                break;
            }
        }
        cancelarCampus();
        //validarVaciosP1();
        return "";
    }

    public String grabarPerfil() {
        try {
            if (validarVaciosP1()) {
                SegUsuario usu = usuarioFacade.find(docenteSelected.getUsuario().getUsuId());
                usu.setUsuEmail(docenteSelected.getUsuario().getUsuEmail());
                usu.setUsuTelefonoFijo(docenteSelected.getUsuario().getUsuTelefonoFijo());
                usuarioFacade.edit(usu);
                if (programaSelected.getId() == null) {
                    programaSelected.addObjetivoPrograma(new ObjetivoPrograma(programaSelected, ObjetivoPrograma.TIPO_FIN, 1));
                    programaSelected.addObjetivoPrograma(new ObjetivoPrograma(programaSelected, ObjetivoPrograma.TIPO_PROPOSITO, 2));

                    programaFacade.create(programaSelected);
                    crearArbolMenu();
                    RequestContext.getCurrentInstance().update("formPrincipal");

                } else {
                    programaFacade.edit(programaSelected);
                }
                habilitaTab = false;

                cancelarPerfil();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    //// funciones tabP2
    public void eliminarP2() {
        try {
            entidadEjecutoraFacade.remove(entidadEjecutoraSelected);
            cancelarP2();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    /*public void onRowEditP2(RowEditEvent event) {
     EntidadEjecutoraPrograma vinOpcionInstEdit = (EntidadEjecutoraPrograma) event.getObject();
     SeaProvincia obj = new SeaProvincia();
     obj.setProId(vinOpcionInstEdit.getProvinciaEdit());
     vinOpcionInstEdit.setProId(obj);
     entidadEjecutoraFacade.edit(vinOpcionInstEdit);
     entidadEjecutoraList = entidadEjecutoraFacade.findOpcionInstitucion(programaSelected.getSprvId());

     }*/

 /*public void onRowEditIniP2(RowEditEvent event) {

     EntidadEjecutoraPrograma vinOpcionInstEdit = (EntidadEjecutoraPrograma) event.getObject();
     vinOpcionInstEdit.setProvinciaEdit(vinOpcionInstEdit.getProId().getProId());

     UIData table = (UIData) event.getComponent();
     String updateClientId = table.getClientId() + ":" + table.getRowIndex() + ":aaa";
     FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(updateClientId);
     }*/
    public String agregarP2() {
        codProvinciaSelected = "";
        entidadEjecutoraSelected = new EntidadEjecutoraPrograma();
        controlGrabarP2 = true;
        return "";
    }

    /*
     public void seleccionarProvincia(ValueChangeEvent event) {
     String idProvincia = (String) event.getNewValue();
     if (idProvincia == null) {
     entidadEjecutoraSelected.setProId(new SeaProvincia());
     provinciaSelected = new SeaProvincia();
     } else {
     for (SeaProvincia prov : provinciaList) {
     if (prov.getProId().equals(idProvincia)) {
     entidadEjecutoraSelected.setProId(prov);
     provinciaSelected=prov;
     break;
     }
     }
     }
     validarVaciosP2();
     }*/
    public String registraP2() {
        try {
            if (entidadEjecutoraSelected.getProId() == null || !entidadEjecutoraSelected.getProId().getProId().equals(codProvinciaSelected)) {
                for (SeaProvincia prov : provinciaList) {
                    if (prov.getProId().equals(codProvinciaSelected)) {
                        entidadEjecutoraSelected.setProId(prov);
                        break;
                    }
                }
            }
            if (entidadEjecutoraSelected.getSopinId() == null) {
                entidadEjecutoraSelected.setPrograma(programaSelected);
                entidadEjecutoraFacade.create(entidadEjecutoraSelected);
            } else {
                entidadEjecutoraFacade.edit(entidadEjecutoraSelected);
            }
            validaVaciosP2 = true;
            cancelarP2();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public String seleccionarP2() {
        codProvinciaSelected = entidadEjecutoraSelected.getProId().getProId();
        controlGrabarP2 = true;
        validaVaciosP2 = true;
        return "";
    }

    public void seleccionarP2222(EntidadEjecutoraPrograma event) {
        entidadEjecutoraSelected = event;
        codProvinciaSelected = entidadEjecutoraSelected.getProId().getProId();
        controlGrabarP2 = true;
        validaVaciosP2 = true;
    }

    private String codProvinciaSelected;

    public String getCodProvinciaSelected() {
        return codProvinciaSelected;
    }

    public void setCodProvinciaSelected(String codProvinciaSelected) {
        this.codProvinciaSelected = codProvinciaSelected;
    }

    public void cancelarP2() {
        entidadEjecutoraList = entidadEjecutoraFacade.findOpcionInstitucion(programaSelected.getId());
        entidadEjecutoraSelected = new EntidadEjecutoraPrograma();
        controlGrabarP2 = false;
        validaVaciosP2 = true;
    }

    public boolean validarVaciosP2() {
        validaVaciosP2 = false;
        if (entidadEjecutoraSelected.getSopinNombre() == null || entidadEjecutoraSelected.getSopinNombre().trim().isEmpty()) {
            validaVaciosP2 = true;
        }
        /*if (entidadEjecutoraSelected.getProId().getProId()==null) {
         validaVaciosP2 = true;
         }*/
        if (codProvinciaSelected == null || codProvinciaSelected.isEmpty() || codProvinciaSelected.equals("0")) {
            validaVaciosP2 = true;
        }
        if (entidadEjecutoraSelected.getSopinCiudad() == null || entidadEjecutoraSelected.getSopinCiudad().trim().isEmpty()) {
            validaVaciosP2 = true;
        }
        if (entidadEjecutoraSelected.getSopinTelefono() == null || entidadEjecutoraSelected.getSopinTelefono().trim().isEmpty()) {
            validaVaciosP2 = true;
        }
        if (entidadEjecutoraSelected.getSopinPaguinaWeb() == null || entidadEjecutoraSelected.getSopinPaguinaWeb().trim().isEmpty()) {
            validaVaciosP2 = true;
        }
        if (entidadEjecutoraSelected.getSopinDireccion() == null || entidadEjecutoraSelected.getSopinDireccion().trim().isEmpty()) {
            validaVaciosP2 = true;
        }
        return validaVaciosP2;
    }

    public void calculaDuracion() {

        try {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(programaSelected.getFechaFin());
            c1.add(mes1, anos);

            if (programaSelected.getFechaFin() != null && programaSelected.getFechaInicio() != null) {
                SimpleDateFormat sdfIni = new SimpleDateFormat("dd/mm/yyyy");
                SimpleDateFormat sdfFIn = new SimpleDateFormat("dd/mm/yyyy");
                sdfIni.format(programaSelected.getFechaInicio().getTime());
                sdfFIn.format(programaSelected.getFechaFin().getTime());
                Calendar calendarInicio = Calendar.getInstance();
                calendarInicio.setTime(this.programaSelected.getFechaInicio());
                Calendar calendarFin = Calendar.getInstance();
                calendarFin.setTime(this.programaSelected.getFechaFin());
                if (calendarInicio.compareTo(calendarFin) == 1) {
                    //RequestContext.getCurrentInstance().execute("alert('La fecha de finalización no puede ser mayor que la fecha de inicio del programa.')");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización no puede ser mayor que la fecha de inicio del programa"));
                    programaSelected.setFechaFin(null);
                } else {
                    mes1 = calendarInicio.get(Calendar.MONTH);
                    mes2 = calendarFin.get(Calendar.MONTH);
                    if (mes1 > mes2) {
                        meses = (12 - mes1) + mes2;
                    } else {
                        meses = mes2 - mes1;
                    }
                    anos = calendarFin.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);
                    duracion = anos + " años y " + meses + " mes(es).";
                }
            }
            //validarVaciosP1();

        } catch (Exception e) {
        }
    }

    //funciones tab 3
    public String editarP3() {
        controlGrabar = true;
        return "";
    }

    public String registraP3() {
        //Eliminar los items ingresados incialmente, que han sido deseleccionados
        Iterator<LocalizacionPrograma> it = programaSelected.getObjetivosProvCanParr().iterator();
        while (it.hasNext()) {
            LocalizacionPrograma svinZonaDetalleIngresado = it.next();
            boolean encontro = false;
            if (svinZonaDetalleIngresado.getProvincia() != null && !cobertura.equals(1)) {
                for (TreeNode node : selectedNodes2) {
                    LocalizacionPrograma svinZonaDetalleSelected = (LocalizacionPrograma) node.getData();
                    if (svinZonaDetalleIngresado.getCanton() == null && svinZonaDetalleIngresado.getParroquia() == null) {
                        if (svinZonaDetalleIngresado.getProvincia().equals(svinZonaDetalleSelected.getProvincia())) {
                            encontro = true;
                            break;
                        }
                    } else if (svinZonaDetalleIngresado.getParroquia() == null) {
                        if (svinZonaDetalleIngresado.getCanton().equals(svinZonaDetalleSelected.getCanton())) {
                            encontro = true;
                            break;
                        }
                    } else if (svinZonaDetalleIngresado.getParroquia().equals(svinZonaDetalleSelected.getParroquia())) {
                        encontro = true;
                        break;
                    }
                }
            } else if (svinZonaDetalleIngresado.getProvincia() == null && cobertura.equals(1)) {
                encontro = true;
            }
            if (!encontro) {
                it.remove();
            }
        }

        //Agregar los items nuevos seleccionados
        if (cobertura.equals(1)) { //Nacional
            LocalizacionPrograma svinZonaDetalleSelected = new LocalizacionPrograma();
            programaSelected.addObjetivosProvCanParr(svinZonaDetalleSelected);
        } else {
            for (TreeNode node : selectedNodes2) {
                LocalizacionPrograma svinZonaDetalleSelected = (LocalizacionPrograma) node.getData();
                programaSelected.addObjetivosProvCanParr(svinZonaDetalleSelected);
            }
        }

        programaSelected.setCobertura(cobertura);
        programaFacade.edit(programaSelected);
        cancelarP3();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    private boolean buscarSvinZonaDetalleGuardado(LocalizacionPrograma svinZonaDetalleBuscar) {
        for (LocalizacionPrograma svinZonaDetalle : programaSelected.getObjetivosProvCanParr()) {
            boolean encontro = svinZonaDetalle.comparar(svinZonaDetalleBuscar);
            if (encontro) {
                return true;
            }
        }
        return false;
    }

    public void cancelarP3() {
        cancelarPerfil();
        cobertura = programaSelected.getCobertura();
        root3 = crearArbolCobertura();
        datosCompletos = false;
        controlGrabar = false;
        validaVaciosP3 = true;
    }

    private Integer cobertura;

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }

    public boolean validarVaciosP3() {
        validaVaciosP3 = false;

        if (selectedNodes2.length == 0) {
            validaVaciosP3 = true;
        }
        return validaVaciosP3;
    }

    //funciones tab 4
    public String registraP4() {
        try {
            System.out.println("ingresa registro");
            for (ObjetivoBVivirPrograma svinProgObjPadre : proObjList) {
                for (ObjetivoBVivirPrograma svinProgObjHijo : svinProgObjPadre.getSvinProgObjHijos()) {
                    if (svinProgObjHijo.getObjetivoBVivir().getSvobviId().equals(objBVivirHijo.getSvobviId())) {
                        FacesContext.getCurrentInstance().addMessage("formPrincipal:subojPlan1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Sub Objetivo seleccionado ya ha sido agregado"));
                        return null;
                    }
                }

            }
            svinProgObjSelected = new ObjetivoBVivirPrograma();
            ObjetivoBVivir svinObjetivoBVivirHijo = null;
            for (ObjetivoBVivir svinObjetivoBVivir : objBVivirHijoList) {
                if (svinObjetivoBVivir.getSvobviId().equals(objBVivirHijo.getSvobviId())) {
                    svinObjetivoBVivirHijo = svinObjetivoBVivir;
                    break;
                }

            }
            svinProgObjSelected.setObjetivoBVivir(svinObjetivoBVivirHijo);
            svinProgObjSelected.setPrograma(programaSelected);
            svinProgObjFacade.create(svinProgObjSelected);
            agregarObjetivo(svinProgObjSelected);
            for (ObjetivoBVivir svinObjetivoBVivir : objBVivirPadreList) {
                if (svinObjetivoBVivir.getSvobviId().equals(objBVivirPadre.getSvobviId())) {
                    svinObjetivoBVivirHijo.setSvobviIdPadre(svinObjetivoBVivir);
                    for (ObjetivoBVivirPrograma svinProgObj : proObjList) {
                        if (svinProgObj.getObjetivoBVivir().getSvobviId().equals(objBVivirPadre.getSvobviId())) {
                            svinProgObj.setExpanded(true);
                            break;
                        }
                    }
                    break;
                }

            }
            cancelarP4();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public String agregarP4() {
        controlGrabarP4 = true;
        return "";

    }

    public void cancelarP4() {
        llenarObjetivos();
        objBVivirPadre = new ObjetivoBVivir();
        objBVivirPadre.setSvobviId(BigDecimal.ZERO);
        objBVivirHijo = new ObjetivoBVivir();
        objBVivirHijo.setSvobviId(BigDecimal.ZERO);
        controlGrabarP4 = false;
        validaVaciosP4 = true;
    }

    public boolean validarVaciosP4() {
        validaVaciosP4 = false;
        if (objBVivirHijo == null || objBVivirHijo.getSvobviId().equals(BigDecimal.ZERO)) {
            validaVaciosP4 = true;
        }
        return validaVaciosP4;
    }

    public void eliminarP4() {
        svinProgObjFacade.remove(svinProgObjSelected);
        boolean eliminarPadre = false;
        boolean eliminarHijo = false;
        int posPadre = -1;
        int posHijo = -1;
        for (ObjetivoBVivirPrograma svinProgObjPadre : proObjList) {
            posPadre++;
            posHijo = -1;
            for (ObjetivoBVivirPrograma svinProgObjHijo : svinProgObjPadre.getSvinProgObjHijos()) {
                if (svinProgObjHijo.getObjetivoBVivir().getSvobviId().equals(svinProgObjSelected.getObjetivoBVivir().getSvobviId())) {
                    posHijo++;
                    eliminarHijo = true;
                    break;
                }
            }
            if (eliminarHijo) {
                svinProgObjPadre.getSvinProgObjHijos().remove(posHijo);
                if (svinProgObjPadre.getSvinProgObjHijos().isEmpty()) {
                    eliminarPadre = true;
                }
                break;
            }

        }
        if (eliminarPadre) {
            proObjList.remove(posPadre);
        }
        cancelarP4();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
    }

    public void onRowToggleLine(ToggleEvent event) {
        ObjetivoBVivirPrograma subObj = (ObjetivoBVivirPrograma) event.getData();

        if (event.getVisibility() == Visibility.VISIBLE) {
            subObj.setExpanded(true);

        } else {
            subObj.setExpanded(false);
        }
    }

    public void onRowEditP4(RowEditEvent event) {

    }

    public void onRowCancelP4(RowEditEvent event) {
    }

    public void onRowEditP41(RowEditEvent event) {
    }

    public void onRowCancelP41(RowEditEvent event) {
    }

    public String registraP41() {
        System.out.println("ingresa registro");
        return "";
    }

    public void bsqSubObjetivos() {
        System.out.println(" ");
        objBVivirHijoList = svinObjBVivirFacade.findObjXPadre(objBVivirPadre.getSvobviId());
        //  objBVivirHijoList = svinObjBVivirFacade.findObjetivosPadre1();
        System.out.println(" la lista es " + objBVivirHijoList.size());
    }

    //funciones panelIndicadorEstrategia:
    public IndicadorEstrategiaProyecto getIndicadorEstrategiaProyectoSelected() {
        return indicadorEstrategiaProyectoSelected;
    }

    public ObjetivoEstrategico getPerspectivaSelected() {
        return perspectivaSelected;
    }

    public void setPerspectivaSelected(ObjetivoEstrategico perspectivaSelected) {
        this.perspectivaSelected = perspectivaSelected;
    }

    public ObjetivoEstrategico getObjetivoEstrategicoSelected() {
        return objetivoEstrategicoSelected;
    }

    public void setObjetivoEstrategicoSelected(ObjetivoEstrategico objetivoEstrategicoSelected) {
        this.objetivoEstrategicoSelected = objetivoEstrategicoSelected;
    }

    public void setIndicadorEstrategiaProyectoSelected(IndicadorEstrategiaProyecto indicadorEstrategiaProyectoSelected) {
        this.indicadorEstrategiaProyectoSelected = indicadorEstrategiaProyectoSelected;
    }

    private Integer tipoObjetivoEstrategico;
    @EJB
    private IndicadorEstrategiaProyectoFacade indicadorEstrategiaProyectoFacade;

    private void initIndicadorEstrategia() {
        if (perspectivasList == null) {
            perspectivasList = objetivoEstrategicoFacade.findPrespectivas();
        }
        perspectivaSelected = null;
        objetivoEstrategicoSelected = null;
        cancelarIndicadorEstrategia();
    }

    public Integer getTipoObjetivoEstrategico() {
        return tipoObjetivoEstrategico;
    }

    public void setTipoObjetivoEstrategico(Integer tipoObjetivoEstrategico) {
        this.tipoObjetivoEstrategico = tipoObjetivoEstrategico;
    }

    public void nuevoIndicador(ActionEvent event) {
        indicadorEstrategiaProyectoSelected = new IndicadorEstrategiaProyecto(programaSelected);
        tipoObjetivoEstrategico = ObjetivoEstrategico.TIPO_INDICADOR;
    }

    public void nuevoEstrategia(ActionEvent event) {
        indicadorEstrategiaProyectoSelected = new IndicadorEstrategiaProyecto(programaSelected);
        tipoObjetivoEstrategico = ObjetivoEstrategico.TIPO_ESTRATEGIA;
    }

    public String grabarIndicadorEstrategia() {
        try {
            indicadorEstrategiaProyectoFacade.create(indicadorEstrategiaProyectoSelected);
            cancelarIndicadorEstrategia();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el Objetivo seleccionado";
                    controlMsgError = "formPrincipal:selIndicadorEstrategia";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarIndicadorEstrategia() {
        programaSelected = programaFacade.find(programaSelected.getId());
        indicadorEstrategiaProyectoSelected = null;
    }

    public void eliminarIndicadorEstrategia() {
        try {
            IndicadorEstrategiaProyecto ind = programaSelected.getIndicadorEstrategia(objetivoEstrategicoSelected.getId());
            indicadorEstrategiaProyectoFacade.remove(ind);
            cancelarIndicadorEstrategia();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    //funciones tab6
    public String agregarP6() {
        controlGrabarP6 = true;
        return "";
    }

    public void onRowEditP6(RowEditEvent event) {

    }

    public void onRowCancelP6(RowEditEvent event) {
    }

    public void cancelarP6() {
        svinPlanVProgList = svinPlanVProgramaFacade.findObjetivosPlanVin(programaSelected.getId());
        Collections.sort(svinPlanVProgList);

        planProgramaV = new ObjetivoPlanVincula();
        planProgramaV.setSvopviId(BigDecimal.ZERO);
        controlGrabarP6 = false;
        validaVaciosP6 = true;
    }

    public String registraP6() {
        try {
            for (ObjetivoPlanVinculaPrograma svinPlanVPrograma : svinPlanVProgList) {
                if (svinPlanVPrograma.getPrograma().getId().equals(programaSelected.getId())
                        && svinPlanVPrograma.getObjetivoPlanVinculacion().getSvopviId().equals(planProgramaV.getSvopviId())) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:objPlanVin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Objetivo seleccionado ya ha sido agregado"));
                    return null;
                }
            }

            System.out.println("ingresa registro");
            planVProgSelected = new ObjetivoPlanVinculaPrograma();
            planVProgSelected.setPrograma(programaSelected);
            planVProgSelected.setObjetivoPlanVinculacion(planProgramaV);
            svinPlanVProgramaFacade.create(planVProgSelected);
            svinPlanVProgList = svinPlanVProgramaFacade.findObjetivosPlanVin(programaSelected.getId());
            Collections.sort(svinPlanVProgList);
            validaVaciosP6 = true;
            cancelarP6();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public boolean validarVaciosP6() {
        validaVaciosP6 = false;

        if (planProgramaV == null || planProgramaV.getSvopviId().equals(BigDecimal.ZERO)) {
            validaVaciosP6 = true;
        }
        return validaVaciosP6;
    }

    public void eliminarP6() {
        if (planVProgSelected != null) {
            ObjetivoPlanVinculaPrograma eliminar = null;
            for (int i = 0; i < svinPlanVProgList.size(); i++) {
                ObjetivoPlanVinculaPrograma elemento = this.svinPlanVProgList.get(i);
                if (planVProgSelected.getId() == svinPlanVProgList.get(i).getId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.svinPlanVProgList.remove(eliminar);
                svinPlanVProgramaFacade.remove(eliminar);
                cancelarP6();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
    }

    //funciones tab7
    public String agregarP7() {
        controlGrabarP7 = true;
        return "";
    }

    public void onRowEditP7(RowEditEvent event) {

    }

    public void onRowCancelP7(RowEditEvent event) {
    }

    public void cancelarP7() {
        estrategiasProgramaList = svinEstrategiaProgramaFacade.findEstratPlanVinc(programaSelected.getId());
        estrategiaV = new EstrategiaPlanVincula();
        estrategiaV.setSvevplId(BigDecimal.ZERO);
        controlGrabarP7 = false;
        validaVaciosP7 = true;
    }

    public String registraP7() {
        try {
            for (EstrategiaPlanVinculaPrograma svinProgramaEplanv : estrategiasProgramaList) {
                if (svinProgramaEplanv.getEstrategiaPlanVinculacion().getSvevplId().equals(estrategiaV.getSvevplId())) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:estPlanVin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La Estrategia seleccionada ya ha sido agregada"));
                    return null;
                }
            }
            estrategiaProgSelected = new EstrategiaPlanVinculaPrograma();
            estrategiaProgSelected.setPrograma(programaSelected);
            estrategiaProgSelected.setEstrategiaPlanVinculacion(estrategiaV);
            svinEstrategiaProgramaFacade.create(estrategiaProgSelected);
            estrategiasProgramaList = svinEstrategiaProgramaFacade.findEstratPlanVinc(programaSelected.getId());
            validaVaciosP7 = true;
            cancelarP7();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }

        return "";
    }

    public boolean validarVaciosP7() {
        validaVaciosP7 = false;

        if (estrategiaV == null || estrategiaV.getSvevplId().equals(BigDecimal.ZERO)) {
            validaVaciosP7 = true;
        }
        return validaVaciosP7;
    }

    public void eliminarP7() {
        if (estrategiaProgSelected != null) {
            EstrategiaPlanVinculaPrograma eliminar = null;
            for (int i = 0; i < estrategiasProgramaList.size(); i++) {
                EstrategiaPlanVinculaPrograma elemento = this.estrategiasProgramaList.get(i);
                if (estrategiaProgSelected.getId() == estrategiasProgramaList.get(i).getId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.estrategiasProgramaList.remove(eliminar);
                svinEstrategiaProgramaFacade.remove(eliminar);
                cancelarP7();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
    }

    //funciones tab8
    public void cancelarP8() {
        programaSelected = programaFacade.find(programaSelected.getId());
        modoEdicion = false;
    }

    public String registraP8() {
        programaFacade.edit(programaSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        modoEdicion = false;
        return "";
    }

    public void cancelarPerfilPrograma() {
        programaSelected = programaFacade.find(programaSelected.getId());
        modoEdicion = false;
    }

    public String registraPerfilPrograma() {
        try {
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            modoEdicion = false;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    //funciones tab10
    public String agregarP10() {
        controlGrabarP10 = true;
        return "";
    }

    public void cancelarP10() {
        departamentoCarreraProgramaList = svinDepcenproyFacade.findDepartamentos(programaSelected.getId());
        departamentoProgramaSelected = new DepartamentoPrograma();
        controlGrabarP10 = false;
        validaVaciosP10 = true;
    }

    private DepartamentoPrograma departamentoProgramaSelected;

    public DepartamentoPrograma getDepartamentoProgramaSelected() {
        return departamentoProgramaSelected;
    }

    public void setDepartamentoProgramaSelected(DepartamentoPrograma departamentoProgramaSelected) {
        this.departamentoProgramaSelected = departamentoProgramaSelected;
    }

    public String registraP10() {
        try {
            for (DepartamentoPrograma departamentoPrograma : departamentoCarreraProgramaList) {
                if (departamentoPrograma.getDepartamento().equals(departamentoProgramaSelected.getDepartamento())
                        && departamentoPrograma.getCampus().equals(departamentoProgramaSelected.getCampus())) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:selDepartamentoParticipante", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Departamento seleccionado ya ha sido agregado"));
                    return null;
                }
            }
            departamentoProgramaSelected.setPrograma(programaSelected);
            svinDepcenproyFacade.create(departamentoProgramaSelected);
            cancelarP10();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public void eliminarP10() {
        DepartamentoPrograma eliminar = null;
        for (int i = 0; i < departamentoCarreraProgramaList.size(); i++) {
            DepartamentoPrograma elemento = this.departamentoCarreraProgramaList.get(i);
            if (svinDepcenproySelected.getId().equals(departamentoCarreraProgramaList.get(i).getId())) {
                eliminar = elemento;
                break;
            }
        }
        departamentoCarreraProgramaList.remove(eliminar);
        svinDepcenproyFacade.remove(eliminar);
        cancelarP10();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
    }

    //funciones tab11
    public String agregarP11() {
        carreraProgramaSelected = new CarreraPrograma(programaSelected);
        nomCarreraSeleccionada = "";

        controlGrabarP11 = true;
        return "";
    }

    public void cancelarP11() {
        carreraProgramaList = carreraProgramaFacade.findByPrograma(programaSelected.getId());
        controlGrabarP11 = false;
        validaVaciosP11 = true;
    }

    public String registraP11() {
        try {
            /*CarreraPrograma carreraPrograma = new CarreraPrograma();
            String[] temp = nomCarreraSeleccionada.split("-");
            String cod = temp[temp.length - 1];
            carreraPrograma.setCarrera(stvCarrerasFacade.find(cod));
            carreraPrograma.setPrograma(programaSelected);*/
            carreraProgramaFacade.create(carreraProgramaSelected);
            cancelarP11();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para la Carrera seleccionada";
                    RequestContext.getCurrentInstance().update("formPrincipal:dataTableCarrPart");
                    controlMsgError = "formPrincipal:selCarrera";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarP11() {
        try {
            if (carreraProgramaSelected != null) {
                CarreraPrograma eliminar = null;
                for (int i = 0; i < carreraProgramaList.size(); i++) {
                    CarreraPrograma elemento = carreraProgramaList.get(i);
                    if (carreraProgramaSelected.getCodigo().equals(carreraProgramaList.get(i).getCodigo())) {
                        eliminar = elemento;
                        break;
                    }
                }
                if (eliminar != null) {
                    carreraProgramaFacade.remove(eliminar);
                    carreraProgramaList.remove(eliminar);
                }
            }
            cancelarP11();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    //funciones tab15
    public boolean isDatosCompletos() {
        return datosCompletos;
    }

    public void setDatosCompletos(boolean datosCompletos) {
        this.datosCompletos = datosCompletos;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public void eliminarP15() {
        try {
            objetivoProgramaFacade.remove(objetivoProgramaSelected);
            estadoExpandidoObjetivo.remove(objetivoProgramaSelected.getSvopId());
            cancelarP15(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public String agregarP15() {
        objetivoProgramaSelected = new ObjetivoPrograma(programaSelected);
        objetivoProgramaSelected.setSvopTipo(objetivoProgramaPadreSelected.getSvopTipo() + 1);
        objetivoProgramaSelected.setSvinObjetivoPadre(objetivoProgramaPadreSelected);
        controlGrabar = true;
        return "";
    }

    public String registraP15() {
        try {
            boolean error = false;
            if (objetivoProgramaSelected.getSvopObjetivoProy().trim().length() < 10) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtObjetivo15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
                error = true;
            }
            if (objetivoProgramaSelected.getSvopIndicador().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtIndicador15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (objetivoProgramaSelected.getSvopMverifica().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtMedioVerificacion15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (objetivoProgramaSelected.getSvopSupuestos().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtSupuestos15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (!error) {
                if (objetivoProgramaSelected.getSvopId() == null) {
                    objetivoProgramaSelected.setSvopOrden(objetivoProgramaPadreSelected.getSvinObjetivoHijoList().size() + 1);
                    objetivoProgramaFacade.create(objetivoProgramaSelected);
                    objetivoProgramaSelected.setearEstadoExpanded();
                    estadoExpandidoObjetivo.put(objetivoProgramaSelected.getSvopId(), objetivoProgramaSelected.isExpanded());
                } else {

                    objetivoProgramaFacade.edit(objetivoProgramaSelected);
                }
                cancelarP15(true);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    private boolean datosCompletos;
    private boolean controlGrabar;

    public void cancelarP15(boolean mantenerEstadoExpansion) {
        controlGrabar = false;
        datosCompletos = false;
        programaSelected = programaFacade.find(programaSelected.getId());
        if (mantenerEstadoExpansion) {
            for (ObjetivoPrograma obj : programaSelected.getObjetivoProgramaList()) {
                Boolean expanded = estadoExpandidoObjetivo.get(obj.getSvopId());
                if (expanded != null) {
                    obj.setExpanded(expanded);
                } else {
                    obj.setExpanded(false);
                }
            }
        } else {
            estadoExpandidoObjetivo.clear();
            for (ObjetivoPrograma obj : programaSelected.getObjetivoProgramaList()) {
                obj.setearEstadoExpanded();
                estadoExpandidoObjetivo.put(obj.getSvopId(), obj.isExpanded());
            }

        }
    }

    public boolean validarVaciosP15() {
        datosCompletos = true;
        if (objetivoProgramaSelected.getSvopTipo() == null
                || objetivoProgramaSelected.getSvopIndicador() == null || objetivoProgramaSelected.getSvopIndicador().trim().isEmpty()
                || objetivoProgramaSelected.getSvopMverifica() == null || objetivoProgramaSelected.getSvopMverifica().trim().isEmpty()
                || objetivoProgramaSelected.getSvopObjetivoProy() == null || objetivoProgramaSelected.getSvopObjetivoProy().trim().isEmpty()
                || objetivoProgramaSelected.getSvopSupuestos() == null || objetivoProgramaSelected.getSvopSupuestos().trim().isEmpty()) {
            datosCompletos = false;
        }
        return datosCompletos;
    }

    public void onRowToggleObjetivoPrograma(ToggleEvent event) {
        ObjetivoPrograma obj = (ObjetivoPrograma) event.getData();
        estadoExpandidoObjetivo.put(obj.getSvopId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public ObjetivoPrograma getObjetivoProgramaPadreSelected() {
        return objetivoProgramaPadreSelected;
    }

    public void setObjetivoProgramaPadreSelected(ObjetivoPrograma objetivoProgramaPadreSelected) {
        this.objetivoProgramaPadreSelected = objetivoProgramaPadreSelected;
    }

    private Map<BigDecimal, Boolean> estadoExpandidoObjetivo = new HashMap<BigDecimal, Boolean>();

    public String cambiarOrdenActividad(Integer cambio) {
        try {
            objetivoProgramaSelected.cambiarOrdenObjetivo(cambio);
            objetivoProgramaFacade.edit(objetivoProgramaSelected.getSvinObjetivoPadre());
            cancelarP15(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }

        return "";
    }

    public String seleccionarEdicion() {
        modoEdicion = true;
        controlGrabar = true;
        datosCompletos = false;
        return "";
    }

    public void onRowEditP16(RowEditEvent event) {
    }

    public void onRowCancelP16(RowEditEvent event) {
    }

    public String registraP16() {
        try {
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarP16();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public String editarP16() {
        controlGrabarP16 = true;
        return "";
    }

    public String cancelarP16() {
        programaSelected = programaFacade.find(programaSelected.getId());
        controlGrabarP16 = false;
        return "";
    }

    public String agregarP18() {
        actividadPrograma = new ActividadPrograma();
        controlGrabarP18 = true;
        return "";
    }

    public String seleccionarP18() {
        nombreActividad = actividadPrograma.getDescripcion();
        /*fechaInicioActividad = actividadPrograma.getFechaInicio();
         fechaFinActividad = actividadPrograma.getFechaFin();*/
        presupuestoActividadGastoPermanente = actividadPrograma.getPresupuestoGastoPermanente();
        presupuestoActividadGastoNoPermanente = actividadPrograma.getPresupuestoGastoNoPermanente();
        nroBeneficiariosActividad = actividadPrograma.getNroBeneficiarios();
        anioActividad = actividadPrograma.getAnio();
        controlGrabarP18 = true;
        validaVaciosP18 = false;
        return "";
    }

    public String registraP18() {
        try {
            if (!validarVaciosP18()) {
                actividadPrograma.setDescripcion(nombreActividad);
                actividadPrograma.setFechaInicio(fechaInicioActividad);
                actividadPrograma.setFechaFin(fechaFinActividad);
                actividadPrograma.setPresupuestoGastoPermanente(presupuestoActividadGastoPermanente);
                actividadPrograma.setPresupuestoGastoNoPermanente(presupuestoActividadGastoNoPermanente);
                actividadPrograma.setNroBeneficiarios(nroBeneficiariosActividad);
                actividadPrograma.setAnio(anioActividad);
                actividadPrograma.setPrograma(programaSelected);
                if (actividadPrograma.getId() == null) {
                    actividadProgramaFacade.create(actividadPrograma);
                } else {
                    actividadProgramaFacade.edit(actividadPrograma);
                }
                cancelarP18();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public void cancelarP18() {
        actividadProgramaList = actividadProgramaFacade.findXPrograma(programaSelected.getId());
        nombreActividad = null;
        anioActividad = null;
        fechaInicioActividad = null;
        fechaFinActividad = null;
        presupuestoActividadGastoPermanente = null;
        presupuestoActividadGastoNoPermanente = null;
        nroBeneficiariosActividad = null;

        validaVaciosP18 = true;
        controlGrabarP18 = false;
    }

    public boolean validarVaciosP18() {
        validaVaciosP18 = false;
        /*if (!fechaFinActividad.after(fechaInicioActividad)) {
         FacesContext.getCurrentInstance().addMessage("formPrincipal:calFechaFinActividad", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha fin debe ser mayor que la fecha inicio"));
         validaVaciosP18 = true;
         }*/
        return validaVaciosP18;
    }

    public void eliminarP18() {
        try {
            actividadProgramaFacade.remove(actividadPrograma);
            cancelarP18();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// get and set datos generales
    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }

    public String getFechaInicioS() {
        return fechaInicioS;
    }

    public void setFechaInicioS(String fechaInicioS) {
        this.fechaInicioS = fechaInicioS;
    }

    public VDocenteVinculacion2 getDocenteSelected() {
        return docenteSelected;
    }

    public void setDocenteSelected(VDocenteVinculacion2 docenteSelected) {
        this.docenteSelected = docenteSelected;
    }

    public String getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public Programa getProgramaSelected() {
        return programaSelected;
    }

    public void setProgramaSelected(Programa programaSelected) {
        this.programaSelected = programaSelected;
    }

    public boolean isValidaVaciosP1() {

        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    /// get and set tabP1
    public String getNombreProg() {
        return nombreProg;
    }

    public void setNombreProg(String nombreProg) {
        this.nombreProg = nombreProg;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<Stvsubj> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Stvsubj> departamentoList) {
        this.departamentoList = departamentoList;
    }

    /// get and set tabP2
    public boolean isControlGrabarP2() {
        return controlGrabarP2;
    }

    public void setControlGrabarP2(boolean controlGrabarP2) {
        this.controlGrabarP2 = controlGrabarP2;
    }

    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public List<EntidadEjecutoraPrograma> getEntidadEjecutoraList() {
        return entidadEjecutoraList;
    }

    public void setEntidadEjecutoraList(List<EntidadEjecutoraPrograma> entidadEjecutoraList) {
        this.entidadEjecutoraList = entidadEjecutoraList;
    }

    public EntidadEjecutoraPrograma getEntidadEjecutoraSelected() {
        return entidadEjecutoraSelected;
    }

    public void setEntidadEjecutoraSelected(EntidadEjecutoraPrograma entidadEjecutoraSelected) {
        this.entidadEjecutoraSelected = entidadEjecutoraSelected;
    }

    public List<SeaProvincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<SeaProvincia> provinciaList) {
        this.provinciaList = provinciaList;
    }

    public boolean isControlGrabarP3() {
        return controlGrabarP3;
    }

    public void setControlGrabarP3(boolean controlGrabarP3) {
        this.controlGrabarP3 = controlGrabarP3;
    }

    public boolean isValidaVaciosP3() {
        return validaVaciosP3;
    }

    public void setValidaVaciosP3(boolean validaVaciosP3) {
        this.validaVaciosP3 = validaVaciosP3;
    }

    //tab 4
    public List<ObjetivoBVivir> getObjBVivirPadreList() {
        return objBVivirPadreList;
    }

    public void setObjBVivirPadreList(List<ObjetivoBVivir> objBVivirPadreList) {
        this.objBVivirPadreList = objBVivirPadreList;
    }

    public List<ObjetivoBVivirPrograma> getProObjList() {
        return proObjList;
    }

    public void setProObjList(List<ObjetivoBVivirPrograma> proObjList) {
        this.proObjList = proObjList;
    }

    public boolean isValidaVaciosP4() {
        return validaVaciosP4;
    }

    public void setValidaVaciosP4(boolean validaVaciosP4) {
        this.validaVaciosP4 = validaVaciosP4;
    }

    public boolean isControlGrabarP4() {
        return controlGrabarP4;
    }

    public void setControlGrabarP4(boolean controlGrabarP4) {
        this.controlGrabarP4 = controlGrabarP4;
    }

    public ObjetivoBVivirPrograma getSvinProgObjSelected() {
        return svinProgObjSelected;
    }

    public void setSvinProgObjSelected(ObjetivoBVivirPrograma svinProgObjSelected) {
        this.svinProgObjSelected = svinProgObjSelected;
    }

    public ObjetivoBVivir getObjBVivirPadre() {
        return objBVivirPadre;
    }

    public void setObjBVivirPadre(ObjetivoBVivir objBVivirPadre) {
        this.objBVivirPadre = objBVivirPadre;
    }

    public List<ObjetivoBVivir> getObjBVivirHijoList() {
        return objBVivirHijoList;
    }

    public void setObjBVivirHijoList(List<ObjetivoBVivir> objBVivirHijoList) {
        this.objBVivirHijoList = objBVivirHijoList;
    }

    public ObjetivoBVivir getObjBVivirHijo() {
        return objBVivirHijo;
    }

    public void setObjBVivirHijo(ObjetivoBVivir objBVivirHijo) {
        this.objBVivirHijo = objBVivirHijo;
    }

    public List<ObjetivoEstrategico> getPerspectivasList() {
        return perspectivasList;
    }

    public void setPerspectivasList(List<ObjetivoEstrategico> perspectivasList) {
        this.perspectivasList = perspectivasList;
    }

    public boolean isControlGrabarP5() {
        return controlGrabarP5;
    }

    public void setControlGrabarP5(boolean controlGrabarP5) {
        this.controlGrabarP5 = controlGrabarP5;
    }

    public boolean isValidaVaciosP5() {
        return validaVaciosP5;
    }

    public void setValidaVaciosP5(boolean validaVaciosP5) {
        this.validaVaciosP5 = validaVaciosP5;
    }

    //get and set tab6
    public List<ObjetivoPlanVincula> getObjPlanVinculaList() {
        return objPlanVinculaList;
    }

    public void setObjPlanVinculaList(List<ObjetivoPlanVincula> objPlanVinculaList) {
        this.objPlanVinculaList = objPlanVinculaList;
    }

    public boolean isControlGrabarP6() {
        return controlGrabarP6;
    }

    public void setControlGrabarP6(boolean controlGrabarP6) {
        this.controlGrabarP6 = controlGrabarP6;
    }

    public boolean isValidaVaciosP6() {
        return validaVaciosP6;
    }

    public void setValidaVaciosP6(boolean validaVaciosP6) {
        this.validaVaciosP6 = validaVaciosP6;
    }

    public List<ObjetivoPlanVinculaPrograma> getSvinPlanVProgList() {
        return svinPlanVProgList;
    }

    public void setSvinPlanVProgList(List<ObjetivoPlanVinculaPrograma> svinPlanVProgList) {
        this.svinPlanVProgList = svinPlanVProgList;
    }

    public ObjetivoPlanVincula getPlanProgramaV() {
        return planProgramaV;
    }

    public void setPlanProgramaV(ObjetivoPlanVincula planProgramaV) {
        this.planProgramaV = planProgramaV;
    }

    public ObjetivoPlanVinculaPrograma getPlanVProgSelected() {
        return planVProgSelected;
    }

    public void setPlanVProgSelected(ObjetivoPlanVinculaPrograma planVProgSelected) {
        this.planVProgSelected = planVProgSelected;
    }

    //get and set tab7
    public List<EstrategiaPlanVincula> getEstrategiasVinculaList() {
        return estrategiasVinculaList;
    }

    public void setEstrategiasVinculaList(List<EstrategiaPlanVincula> estrategiasVinculaList) {
        this.estrategiasVinculaList = estrategiasVinculaList;
    }

    public boolean isControlGrabarP7() {
        return controlGrabarP7;
    }

    public void setControlGrabarP7(boolean controlGrabarP7) {
        this.controlGrabarP7 = controlGrabarP7;
    }

    public boolean isValidaVaciosP7() {
        return validaVaciosP7;
    }

    public void setValidaVaciosP7(boolean validaVaciosP7) {
        this.validaVaciosP7 = validaVaciosP7;
    }

    public EstrategiaPlanVincula getEstrategiaV() {
        return estrategiaV;
    }

    public void setEstrategiaV(EstrategiaPlanVincula estrategiaV) {
        this.estrategiaV = estrategiaV;
    }

    public List<EstrategiaPlanVinculaPrograma> getEstrategiasProgramaList() {
        return estrategiasProgramaList;
    }

    public void setEstrategiasProgramaList(List<EstrategiaPlanVinculaPrograma> estrategiasProgramaList) {
        this.estrategiasProgramaList = estrategiasProgramaList;
    }

    public EstrategiaPlanVinculaPrograma getEstrategiaProgSelected() {
        return estrategiaProgSelected;
    }

    public void setEstrategiaProgSelected(EstrategiaPlanVinculaPrograma estrategiaProgSelected) {
        this.estrategiaProgSelected = estrategiaProgSelected;
    }

    //get and set tab10
    public boolean isControlGrabarP10() {
        return controlGrabarP10;
    }

    public void setControlGrabarP10(boolean controlGrabarP10) {
        this.controlGrabarP10 = controlGrabarP10;
    }

    public List<Stvmajr> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Stvmajr> carreraList) {
        this.carreraList = carreraList;
    }

    public boolean isValidaVaciosP10() {
        return validaVaciosP10;
    }

    public void setValidaVaciosP10(boolean validaVaciosP10) {
        this.validaVaciosP10 = validaVaciosP10;
    }

    //get and set tab11  
    public boolean isControlGrabarP11() {
        return controlGrabarP11;
    }

    public void setControlGrabarP11(boolean controlGrabarP11) {
        this.controlGrabarP11 = controlGrabarP11;
    }

    public boolean isValidaVaciosP11() {
        return validaVaciosP11;
    }

    public void setValidaVaciosP11(boolean validaVaciosP11) {
        this.validaVaciosP11 = validaVaciosP11;
    }

    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

    //get and set tab14
    public boolean isValidaVaciosP14() {
        return validaVaciosP14;
    }

    public void setValidaVaciosP14(boolean validaVaciosP14) {
        this.validaVaciosP14 = validaVaciosP14;
    }

    //////
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getMedioVerif() {
        return medioVerif;
    }

    public void setMedioVerif(String medioVerif) {
        this.medioVerif = medioVerif;
    }

    public String getSupuestos() {
        return supuestos;
    }

    public boolean isValidaVaciosP15_1() {
        return validaVaciosP15;
    }

    public void setValidaVaciosP15_1(boolean validaVaciosP15_1) {
        this.validaVaciosP15 = validaVaciosP15_1;
    }

    public void setSupuestos(String supuestos) {
        this.supuestos = supuestos;
    }

    public ObjetivoPrograma getObjPrograma() {
        return objPrograma;
    }

    public void setObjPrograma(ObjetivoPrograma objPrograma) {
        this.objPrograma = objPrograma;
    }

    public boolean isControlGrabarP15() {
        return controlGrabarP15;
    }

    public void setControlGrabarP15(boolean controlGrabarP15) {
        this.controlGrabarP15 = controlGrabarP15;
    }

    //</editor-fold>
    public CarreraPrograma getCarreraProgramaSelected() {
        return carreraProgramaSelected;
    }

    public void setCarreraProgramaSelected(CarreraPrograma carreraProgramaSelected) {
        this.carreraProgramaSelected = carreraProgramaSelected;
    }

    public List<CarreraPrograma> getCarreraProgramaList() {
        return carreraProgramaList;
    }

    public void setCarreraProgramaList(List<CarreraPrograma> carreraProgramaList) {
        this.carreraProgramaList = carreraProgramaList;
    }

    public List<ObjetivoPrograma> getObjetivoProgramaList() {
        return objetivoProgramaList;
    }

    public void setObjetivoProgramaList(List<ObjetivoPrograma> objetivoProgramaList) {
        this.objetivoProgramaList = objetivoProgramaList;
    }

    public boolean isValidaVaciosP15() {
        return validaVaciosP15;
    }

    public void setValidaVaciosP15(boolean validaVaciosP15) {
        this.validaVaciosP15 = validaVaciosP15;
    }

    public Integer getTipoObjetivo() {
        return tipoObjetivo;
    }

    public void setTipoObjetivo(Integer tipoObjetivo) {
        this.tipoObjetivo = tipoObjetivo;
    }

    public List<Stvcamp> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<Stvcamp> campusList) {
        this.campusList = campusList;
    }

    public List<VistaCampusDeptoCarrera> getCampusDepartamentoList() {
        return campusDepartamentoList;
    }

    public void setCampusDepartamentoList(List<VistaCampusDeptoCarrera> campusDepartamentoList) {
        this.campusDepartamentoList = campusDepartamentoList;
    }

    public Date getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(Date fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public boolean isValidaVaciosP17() {
        return validaVaciosP17;
    }

    public void setValidaVaciosP17(boolean validaVaciosP17) {
        this.validaVaciosP17 = validaVaciosP17;
    }

    private TreeNode root3;
    private TreeNode[] selectedNodes2;

    public TreeNode getRoot3() {
        return root3;
    }

    public void setRoot3(TreeNode root3) {
        this.root3 = root3;
    }

    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }

    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }

    private TreeNode crearArbolCobertura() {
        TreeNode root = new CheckboxTreeNode(new LocalizacionPrograma(), null);
        if (!cobertura.equals(Programa.COBERTURA_NACIONAL)) {
            for (SeaProvincia provincia : provinciaList) {
                TreeNode nodoProvincia = new CheckboxTreeNode(new LocalizacionPrograma(provincia), root);
                if (cobertura.equals(Programa.COBERTURA_CANTONAL) || cobertura.equals(Programa.COBERTURA_PARROQUIAL)) {
                    for (SeaCanton canton : provincia.getSeaCantonList()) {
                        TreeNode nodoCanton = new CheckboxTreeNode(new LocalizacionPrograma(canton), nodoProvincia);
                        if (cobertura.equals(Programa.COBERTURA_PARROQUIAL)) {
                            for (SeaParroquia parroquia : canton.getSeaParroquiaList()) {
                                LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(parroquia);
                                TreeNode nodoParroquia = new CheckboxTreeNode(svinZonaDetalle, nodoCanton);
                                if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                                    nodoParroquia.setSelected(true);
                                }
                            }
                        } else {
                            LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(canton);
                            if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                                nodoCanton.setSelected(true);
                            }
                        }
                    }
                } else {
                    LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(provincia);
                    if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                        nodoProvincia.setSelected(true);
                    }

                }
            }
        }

        return root;
    }

    public void eliminarPrograma() {
        try {
            /*programaSelected.setEstadoActivo(Programa.ESTADO_PROGRAMA_INACTIVO);
            programaFacade.edit(programaSelected);*/
            programaFacade.remove(programaSelected);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El programa ha sido eliminado exitosamente"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("listadoProgramas.xhtml");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    public String getNombreProgSeleccionado() {
        if (programaSelected.getId() != null) {
            return ("PROGRAMA: " + programaSelected.getNombre());
        } else {
            return "NUEVO PROGRAMA";
        }
    }

    private int indiceTabActivo;

    public int getIndiceTabActivo() {
        return indiceTabActivo;
    }

    public void setIndiceTabActivo(int indiceTabActivo) {
        this.indiceTabActivo = indiceTabActivo;
    }

    public boolean isControlGrabarP16() {
        return controlGrabarP16;
    }

    public void setControlGrabarP16(boolean controlGrabarP16) {
        this.controlGrabarP16 = controlGrabarP16;
    }

    public boolean isControlGrabarP18() {
        return controlGrabarP18;
    }

    public void setControlGrabarP18(boolean controlGrabarP18) {
        this.controlGrabarP18 = controlGrabarP18;
    }

    public SegUsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(SegUsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @EJB
    private ActividadProgramaFacade actividadProgramaFacade;
    @EJB
    private ProyectoFacade proyectoFacade;
    private List<ActividadPrograma> actividadProgramaList;
    private ActividadPrograma actividadPrograma;
    private String nombreActividad;
    private String proyectoActividad;
    private Date fechaInicioActividad;
    private Date fechaFinActividad;
    private BigDecimal presupuestoActividadGastoPermanente;
    private BigDecimal presupuestoActividadGastoNoPermanente;
    private Integer nroBeneficiariosActividad;
    private Integer anioActividad;
    private Integer codProyecto;

    public String getProyectoActividad() {
        return proyectoActividad;
    }

    public void setProyectoActividad(String proyectoActividad) {
        this.proyectoActividad = proyectoActividad;
    }

    public boolean isValidaVaciosP18() {
        return validaVaciosP18;
    }

    public void setValidaVaciosP18(boolean validaVaciosP18) {
        this.validaVaciosP18 = validaVaciosP18;
    }

    public List<ActividadPrograma> getActividadProgramaList() {
        return actividadProgramaList;
    }

    public void setActividadProgramaList(List<ActividadPrograma> actividadProgramaList) {
        this.actividadProgramaList = actividadProgramaList;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicioActividad() {
        return fechaInicioActividad;
    }

    public void setFechaInicioActividad(Date fechaInicioActividad) {
        this.fechaInicioActividad = fechaInicioActividad;
    }

    public Date getFechaFinActividad() {
        return fechaFinActividad;
    }

    public void setFechaFinActividad(Date fechaFinActividad) {
        this.fechaFinActividad = fechaFinActividad;
    }

    public BigDecimal getPresupuestoActividadGastoPermanente() {
        return presupuestoActividadGastoPermanente;
    }

    public void setPresupuestoActividadGastoPermanente(BigDecimal presupuestoActividadGastoPermanente) {
        this.presupuestoActividadGastoPermanente = presupuestoActividadGastoPermanente;
    }

    public BigDecimal getPresupuestoActividadGastoNoPermanente() {
        return presupuestoActividadGastoNoPermanente;
    }

    public void setPresupuestoActividadGastoNoPermanente(BigDecimal presupuestoActividadGastoNoPermanente) {
        this.presupuestoActividadGastoNoPermanente = presupuestoActividadGastoNoPermanente;
    }

    public Integer getNroBeneficiariosActividad() {
        return nroBeneficiariosActividad;
    }

    public void setNroBeneficiariosActividad(Integer nroBeneficiariosActividad) {
        this.nroBeneficiariosActividad = nroBeneficiariosActividad;
    }

    public Integer getAnioActividad() {
        return anioActividad;
    }

    public void setAnioActividad(Integer anioActividad) {
        this.anioActividad = anioActividad;
    }

    public Integer getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    public void validarFechaInicioActividad() {
        if (fechaFinActividad != null && fechaFinActividad.compareTo(fechaInicioActividad) <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de inicio debe ser menor que la fecha de finalización"));
            fechaInicioActividad = null;
        }
        validarVaciosP18();
    }

    public void validarFechaFinActividad() {
        if (fechaInicioActividad != null && fechaFinActividad.compareTo(fechaInicioActividad) <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización debe ser mayor que la fecha de inicio"));
            fechaFinActividad = null;
        }
        validarVaciosP18();
    }

    public ActividadPrograma getActividadPrograma() {
        return actividadPrograma;
    }

    public void setActividadPrograma(ActividadPrograma actividadPrograma) {
        this.actividadPrograma = actividadPrograma;
    }

    public List<String> completeText(String query) {
        System.out.println(" el valor es tar " + query);
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(query);
        System.out.println(" la lista es " + doceVincuLista.size());
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < doceVincuLista.size(); i++) {
            results.add(doceVincuLista.get(i).getUsuario().getUsuApellidos() + " " + doceVincuLista.get(i).getUsuario().getUsuNombres());
        }
        return results;
    }

    public void onItemSelect(SelectEvent event) {
        llenarDatosDirectorXNombres(event.getObject().toString());
        if (docenteSelected != null) {
            for (Stvcamp cam : campusList) {
                if (cam.equals(docenteSelected.getCampus())) {
                    programaSelected.setCampus(cam);
                    break;
                }
            }
            programaSelected.setDepartamento(docenteSelected.getDepartamento());
        }
    }

    private void llenarDatosDirectorXNombres(String nombresApellidos) {
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(nombresApellidos);
        docenteSelected = doceVincuLista.get(0);
        programaSelected.asignarDirector(docenteSelected.getUsuario(), docenteSelected.getDepartamento(), docenteSelected.getCampus());
    }

    private void llenarDatosDirectorXUsuId(BigDecimal usuId) {
        docenteSelected = vistaDocenteFacade.findByUsuId(usuId);
        nomDocenteBusqueda = docenteSelected.getUsuario().getUsuApellidos() + " " + docenteSelected.getUsuario().getUsuNombres();
    }

    public String getNomDocenteBusqueda() {
        return nomDocenteBusqueda;
    }

    public void setNomDocenteBusqueda(String nomDocenteBusqueda) {
        this.nomDocenteBusqueda = nomDocenteBusqueda;
    }

    public List<DepartamentoPrograma> getDepartamentoCarreraProgramaList() {
        return departamentoCarreraProgramaList;
    }

    public void setDepartamentoCarreraProgramaList(List<DepartamentoPrograma> departamentoCarreraProgramaList) {
        this.departamentoCarreraProgramaList = departamentoCarreraProgramaList;
    }

    public DepartamentoPrograma getSvinDepcenproySelected() {
        return svinDepcenproySelected;
    }

    public void setSvinDepcenproySelected(DepartamentoPrograma svinDepcenproySelected) {
        this.svinDepcenproySelected = svinDepcenproySelected;
    }

    public void onNodeSelect() {
        validarVaciosP3();
    }


    /*private boolean controlGrabar;
     private boolean datosCompletos;
    
     //<editor-fold defaultstate="collapsed" desc="Tab14-Carreras participantes">
     public void eliminarP14() {
     try {
     svinDepcenproyFacade.remove(svinDepcenproySelected);
     cancelarP14();
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
     } catch (Exception e) {
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
     }
     }

     public void cancelarP14() {
     controlGrabar = false;
     datosCompletos = false;
     departamentoCarreraProgramaList = svinDepcenproyFacade.findCarreras(programaSelected.getSprvId());
     }

     public boolean validarVaciosP14() {
     datosCompletos = true;
     if (svinDepcenproySelected.getCarrera().getStvmajrCode()==null || svinDepcenproySelected.getCarrera().getStvmajrCode().trim().isEmpty()
     ) {
     datosCompletos = false;
     }
     return datosCompletos;
     }

     public void seleccionarCarrera(ValueChangeEvent event) {
     String codSeleccionado = (String) event.getNewValue();
     if (codSeleccionado.equals("0")) {
     svinDepcenproySelected.setCarrera(new Stvmajr());
     } else {
     for (Stvmajr car : carreraList) {
     if (car.getStvmajrCode().equals(codSeleccionado)) {
     carreraProyectoSelected.setCarrera(car);
     break;
     }
     }

     }
     validarVaciosP6();
     }

     public String registraP6() {
     try {
     if (carreraProyectoSelected.getId() == null) {
     carreraProyectoFacade.create(carreraProyectoSelected);
     } else {
     carreraProyectoFacade.edit(carreraProyectoSelected);
     }
     cancelarP6();
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
     RequestContext.getCurrentInstance().update("formPrincipal:panel6");
     } catch (Exception e) {
     try {
     Throwable t = (Throwable) e;
     while (t.getCause() != null) {
     t = t.getCause();
     }
     String msgError = "No fue posible grabar la información ingresada";
     if (t.getMessage().toUpperCase().contains("ORA-00001")) {
     msgError = "Ya existe un registro para la Carrera seleccionada";
     carreraProyectoList = carreraProyectoFacade.findByProyecto(proyectoSelected.getId());
     RequestContext.getCurrentInstance().update("formPrincipal:dataTEstudiantesParticipantes");
     }
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
     } catch (Exception e2) {
     }
     }
     return "";
     }

     public void agregarP6(ActionEvent event) {
     carreraProyectoSelected = new CarreraProyecto(proyectoSelected);
     controlGrabar = true;

     }

     //</editor-fold>
     */
    public ObjetivoPrograma getObjetivoProgramaSelected() {
        return objetivoProgramaSelected;
    }

    public void setObjetivoProgramaSelected(ObjetivoPrograma objetivoProgramaSelected) {
        this.objetivoProgramaSelected = objetivoProgramaSelected;
    }

    private String nomCarreraSeleccionada;

    public String getNomCarreraSeleccionada() {
        return nomCarreraSeleccionada;
    }

    public void setNomCarreraSeleccionada(String nomCarreraSeleccionada) {
        this.nomCarreraSeleccionada = nomCarreraSeleccionada;
    }

    public List<String> buscarCarrera(String query) {
        carreraList = stvCarrerasFacade.findByNombre(query);
        List<String> temp = new ArrayList<>();
        for (Stvmajr car : carreraList) {
            temp.add(car.getStvmajrDesc() + "-" + car.getStvmajrCode());
        }
        return temp;
    }
    private TreeNode rootMenu;

    public TreeNode getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(TreeNode rootMenu) {
        this.rootMenu = rootMenu;
    }

    public void crearArbolMenu() {
        rootMenu = new DefaultTreeNode("Root", null);
        TreeNode nodePerfil = new DefaultTreeNode(new OpcionMenu("1", "Perfil"), rootMenu);
        nodePerfil.setExpanded(true);
        TreeNode node11 = new DefaultTreeNode(new OpcionMenu("1.1", "1. Datos Generales"), nodePerfil);
        node11.setExpanded(true);
        TreeNode node111 = new DefaultTreeNode(new OpcionMenu("1.1.1", "1.1. Datos Generales"), node11);
        node111.setExpanded(true);
        node111.setSelected(true);
        if (programaSelected.getId() != null) {
            TreeNode nodeEntidadEjecutora = new DefaultTreeNode(new OpcionMenu("1.1.2", "1.2. Entidad Ejecutora"), node11);
            TreeNode nodeCoberturaLocalizacion = new DefaultTreeNode(new OpcionMenu("1.1.3", "1.3. Cobertura y Localización"), node11);
            TreeNode nodeIntroduccion = new DefaultTreeNode(new OpcionMenu("1.2", "2. Introducción"), nodePerfil);
            TreeNode nodeIntroduccionObjPLNBV = new DefaultTreeNode(new OpcionMenu("1.2.1", "2.1. Objetivos PLNBV"), nodeIntroduccion);
            TreeNode nodeIntroduccionObjParr = new DefaultTreeNode(new OpcionMenu("1.2.5", "2.2. Objetivos Provinciales, Cantonales o Parroquiales"), nodeIntroduccion);
            TreeNode nodeIntroduccionobjEstr = new DefaultTreeNode(new OpcionMenu("1.2.2", "2.3. Objetivos Estratégicos Institucionales"), nodeIntroduccion);
            TreeNode nodeIntroduccionObjPlanV = new DefaultTreeNode(new OpcionMenu("1.2.3", "2.4. Objetivos del Plan de Vinculación"), nodeIntroduccion);
            TreeNode nodeIntroduccionEstrPlanV = new DefaultTreeNode(new OpcionMenu("1.2.4", "2.5. Estrategias del Plan de Vinculación"), nodeIntroduccion);
            TreeNode nodeIntroduccionResumen = new DefaultTreeNode(new OpcionMenu("1.2.6", "2.6. Resumen del programa"), nodeIntroduccion);
            TreeNode nodeDiagnostico = new DefaultTreeNode(new OpcionMenu("1.3", "3. Diagnóstico y Problema"), nodePerfil);
            TreeNode nodeDiagnosticoProblema = new DefaultTreeNode(new OpcionMenu("1.3.1", "3.1. Diagnóstico y Problemas"), nodeDiagnostico);
            TreeNode nodeDiagnosticoProblemaAnexos = new DefaultTreeNode(new OpcionMenu("1.3.4", "3.2. Anexos imágenes"), nodeDiagnostico);
            TreeNode nodeDiagnosticoDepar = new DefaultTreeNode(new OpcionMenu("1.3.2", "3.3. Departamentos Participantes"), nodeDiagnostico);
            TreeNode nodeDiagnosticoCarre = new DefaultTreeNode(new OpcionMenu("1.3.3", "3.4. Carreras Participantes"), nodeDiagnostico);
            TreeNode nodeMatrizMarcoLogico = new DefaultTreeNode(new OpcionMenu("1.4", "4. Matriz del Marco Lógico"), nodePerfil);
            TreeNode nodeEstrategiaEjecucion = new DefaultTreeNode(new OpcionMenu("1.5", "5. Estrategias para la Ejecución del Programa"), nodePerfil);
            TreeNode nodeViabilidad = new DefaultTreeNode(new OpcionMenu("1.6", "6. Viabilidad y Plan de Sostenibilidad"), nodePerfil);
            TreeNode nodeProyPlanificados = new DefaultTreeNode(new OpcionMenu("1.7", "7. Proyectos planificados"), nodePerfil);
            TreeNode nodeFinalizarPerfil = new DefaultTreeNode(new OpcionMenu("1.8", "8. Finalizar perfil"), nodePerfil);

            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || (verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA) && programaSelected.getDirector() != null && programaSelected.getDirector().getUsuario().equals(usuarioActual))) {
                TreeNode nodeSeguimiento = new DefaultTreeNode(new OpcionMenu("2", "Seguimiento"), rootMenu);
                TreeNode nodeSeguimientoProg = new DefaultTreeNode(new OpcionMenu("2.1", "1. Registrar Seguimiento"), nodeSeguimiento);
                TreeNode nodeCierreSeguimiento = new DefaultTreeNode(new OpcionMenu("2.2", "2. Finalizar Seguimiento"), nodeSeguimiento);

                TreeNode nodeCierre = new DefaultTreeNode(new OpcionMenu("3", "Cierre"), rootMenu);
                TreeNode nodeCierrePresupuesto = new DefaultTreeNode(new OpcionMenu("3.1", "1. Presupuesto"), nodeCierre);
                TreeNode nodeCierreBeneficiarios = new DefaultTreeNode(new OpcionMenu("3.2", "2. Beneficiarios"), nodeCierre);
                TreeNode nodeCierreLeccionesAprendidas = new DefaultTreeNode(new OpcionMenu("3.3", "3. Lecciones Aprendidas"), nodeCierre);
                TreeNode nodeFinalizarCierre = new DefaultTreeNode(new OpcionMenu("3.4", "4. Finalizar Cierre"), nodeCierre);

            }

            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)
                    || (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA) && programaSelected.getEvaluadorFinal() != null && programaSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual))) {
                TreeNode nodeEvaluacion = new DefaultTreeNode(new OpcionMenu("4", "Evaluación"), rootMenu);
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
                    TreeNode nodeEvaluacionDesignacionEvaluador = new DefaultTreeNode(new OpcionMenu("4.4", "1. Designar Evaluador final"), nodeEvaluacion);
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA) && programaSelected.getEvaluadorFinal() != null && programaSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual))) {
                    TreeNode nodeEvaluacionCuantitativa = new DefaultTreeNode(new OpcionMenu("4.1", "2. Evaluación Cuantitativa"), nodeEvaluacion);
                    TreeNode nodeEvaluacionCualitativa = new DefaultTreeNode(new OpcionMenu("4.2", "3. Evaluación Cualitativa"), nodeEvaluacion);
                    TreeNode nodeFinalizarEvaluacion = new DefaultTreeNode(new OpcionMenu("4.3", "4. Finalizar Evaluación"), nodeEvaluacion);
                }
            }

        }
    }

    public void onNodeMenuSelect(NodeSelectEvent event) {
        /*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
         FacesContext.getCurrentInstance().addMessage(null, message);*/
        OpcionMenu opcionMenu = (OpcionMenu) selectedNode.getData();
        switch (opcionMenu.getCodigo()) {
            case "1.1.1":
                cancelarPerfil();
                break;
            case "1.1.2":
                cancelarP2();
                break;
            case "1.1.3":
                cancelarP3();
                break;
            case "1.2.1":
                cancelarP4();
                break;
            case "1.2.2":
                initIndicadorEstrategia();
                break;
            case "1.2.3":
                cancelarP6();
                break;
            case "1.2.4":
                cancelarP7();
                break;
            case "1.2.5":
                cancelarP16();
                DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("formPrincipal:dataTableObjParroquiales");
                dataTable.setFirst(0);
                break;
            case "1.2.6":
                modoEdicion = false;
                cancelarP8();
                break;
            case "1.3.1":
                cancelarPerfilPrograma();
                break;
            case "1.3.2":
                cancelarP10();
                break;
            case "1.3.3":
                cancelarP11();
                break;
            case "1.3.4":
                cancelarAnexo();
                break;
            case "1.4":
                cancelarP15(false);
                break;
            case "1.5":
                cancelarPerfilPrograma();
                break;
            case "1.6":
                cancelarPerfilPrograma();
                break;
            case "1.7":
                cancelarP18();
                break;
            case "1.8":
                initFinalizarPerfil();
                break;
            case "2.1":
                initAvance();
                break;
            case "2.2":
                cancelarEdicionPrograma();
                break;
            case "3.1":
                initCierrePresupuesto();
                break;
            case "3.2":
                initCierreBeneficiarios();
                break;
            case "3.3":
                initCierreLeccionAprendida();
                break;
            case "4.1":
                initEvaluacionCuantitativa();
                break;
            case "4.2":
                initEvaluacionCualitativa();
                break;
            case "4.3":
                cancelarEdicionPrograma();
                break;
            case "4.4":
                cancelarEvaluadorFinal();
                break;

            default:
                selectedNode.setExpanded(true);
                opcionMenu.setExpanded(true);
        }

    }

    public void onNodeExpand(NodeExpandEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) event.getTreeNode();
        opcionMenu.setExpanded(event.getTreeNode().isExpanded());
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) event.getTreeNode();
        opcionMenu.setExpanded(event.getTreeNode().isExpanded());

    }
    private TreeNode selectedNode;

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public String getSelectedNodeCode() {
        if (selectedNode != null) {
            return ((OpcionMenu) selectedNode.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onRowToggleOpcionMenu(ToggleEvent event) {
        /*OpcionMenu opcionMenu = (OpcionMenu) event.getData();
         estadoExpandidoObjetivoBVivir.put(subObj.getObjetivoBVivir().getSvobviId(), event.getVisibility() == Visibility.VISIBLE);*/
    }
    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void seleccionarCobertura() {
        root3 = crearArbolCobertura();;
    }

    private boolean msgCoberturaLocalizacion;
    private boolean msgObjetivosPLNBV;
    private boolean msgObjetivosProvCanParr;
    private boolean msgObjetivosEstraInst;
    private boolean msgObjetivosPlanVinculacion;
    private boolean msgEstrategiasPlanVinculacion;
    private boolean msgResumen;
    private boolean msgDiagnosticoProblemas;
    private boolean msgDepartamentosParticipantes;
    private boolean msgCarrerasParticipantes;
    private boolean msgMatrizMarcoLogicoFin;
    private boolean msgMatrizMarcoLogicoProposito;
    private boolean msgMatrizMarcoLogicoComponente;
    private boolean msgEstrategiaEjecucion;
    private boolean msgViabilidad;
    private boolean msgProyectosPlanificados;

    public boolean isMsgCoberturaLocalizacion() {
        return msgCoberturaLocalizacion;
    }

    public void setMsgCoberturaLocalizacion(boolean msgCoberturaLocalizacion) {
        this.msgCoberturaLocalizacion = msgCoberturaLocalizacion;
    }

    public boolean isMsgObjetivosPLNBV() {
        return msgObjetivosPLNBV;
    }

    public void setMsgObjetivosPLNBV(boolean msgObjetivosPLNBV) {
        this.msgObjetivosPLNBV = msgObjetivosPLNBV;
    }

    public boolean isMsgObjetivosProvCanParr() {
        return msgObjetivosProvCanParr;
    }

    public void setMsgObjetivosProvCanParr(boolean msgObjetivosProvCanParr) {
        this.msgObjetivosProvCanParr = msgObjetivosProvCanParr;
    }

    public boolean isMsgObjetivosEstraInst() {
        return msgObjetivosEstraInst;
    }

    public void setMsgObjetivosEstraInst(boolean msgObjetivosEstraInst) {
        this.msgObjetivosEstraInst = msgObjetivosEstraInst;
    }

    public boolean isMsgObjetivosPlanVinculacion() {
        return msgObjetivosPlanVinculacion;
    }

    public void setMsgObjetivosPlanVinculacion(boolean msgObjetivosPlanVinculacion) {
        this.msgObjetivosPlanVinculacion = msgObjetivosPlanVinculacion;
    }

    public boolean isMsgEstrategiasPlanVinculacion() {
        return msgEstrategiasPlanVinculacion;
    }

    public void setMsgEstrategiasPlanVinculacion(boolean msgEstrategiasPlanVinculacion) {
        this.msgEstrategiasPlanVinculacion = msgEstrategiasPlanVinculacion;
    }

    public boolean isMsgResumen() {
        return msgResumen;
    }

    public void setMsgResumen(boolean msgResumen) {
        this.msgResumen = msgResumen;
    }

    public boolean isMsgDiagnosticoProblemas() {
        return msgDiagnosticoProblemas;
    }

    public void setMsgDiagnosticoProblemas(boolean msgDiagnosticoProblemas) {
        this.msgDiagnosticoProblemas = msgDiagnosticoProblemas;
    }

    public boolean isMsgDepartamentosParticipantes() {
        return msgDepartamentosParticipantes;
    }

    public void setMsgDepartamentosParticipantes(boolean msgDepartamentosParticipantes) {
        this.msgDepartamentosParticipantes = msgDepartamentosParticipantes;
    }

    public boolean isMsgCarrerasParticipantes() {
        return msgCarrerasParticipantes;
    }

    public void setMsgCarrerasParticipantes(boolean msgCarrerasParticipantes) {
        this.msgCarrerasParticipantes = msgCarrerasParticipantes;
    }

    public boolean isMsgMatrizMarcoLogicoFin() {
        return msgMatrizMarcoLogicoFin;
    }

    public void setMsgMatrizMarcoLogicoFin(boolean msgMatrizMarcoLogicoFin) {
        this.msgMatrizMarcoLogicoFin = msgMatrizMarcoLogicoFin;
    }

    public boolean isMsgMatrizMarcoLogicoProposito() {
        return msgMatrizMarcoLogicoProposito;
    }

    public void setMsgMatrizMarcoLogicoProposito(boolean msgMatrizMarcoLogicoProposito) {
        this.msgMatrizMarcoLogicoProposito = msgMatrizMarcoLogicoProposito;
    }

    public boolean isMsgMatrizMarcoLogicoComponente() {
        return msgMatrizMarcoLogicoComponente;
    }

    public void setMsgMatrizMarcoLogicoComponente(boolean msgMatrizMarcoLogicoComponente) {
        this.msgMatrizMarcoLogicoComponente = msgMatrizMarcoLogicoComponente;
    }

    public boolean isMsgEstrategiaEjecucion() {
        return msgEstrategiaEjecucion;
    }

    public void setMsgEstrategiaEjecucion(boolean msgEstrategiaEjecucion) {
        this.msgEstrategiaEjecucion = msgEstrategiaEjecucion;
    }

    public boolean isMsgViabilidad() {
        return msgViabilidad;
    }

    public void setMsgViabilidad(boolean msgViabilidad) {
        this.msgViabilidad = msgViabilidad;
    }

    public boolean isMsgProyectosPlanificados() {
        return msgProyectosPlanificados;
    }

    public void setMsgProyectosPlanificados(boolean msgProyectosPlanificados) {
        this.msgProyectosPlanificados = msgProyectosPlanificados;
    }

    private void initFinalizarPerfil() {
        programaSelected = programaFacade.find(programaSelected.getId());
        msgCoberturaLocalizacion = false;
        msgObjetivosPLNBV = false;
        msgObjetivosProvCanParr = false;
        msgObjetivosEstraInst = false;
        msgObjetivosPlanVinculacion = false;
        msgEstrategiasPlanVinculacion = false;
        msgResumen = false;
        msgDiagnosticoProblemas = false;
        msgDepartamentosParticipantes = false;
        msgCarrerasParticipantes = false;
        msgMatrizMarcoLogicoFin = false;
        msgMatrizMarcoLogicoProposito = false;
        msgMatrizMarcoLogicoComponente = false;
        msgEstrategiaEjecucion = false;
        msgViabilidad = false;
        msgProyectosPlanificados = false;
    }

    public void finalizarPerfil() {
        try {
            if (programaSelected.getObjetivosProvCanParr() == null || programaSelected.getObjetivosProvCanParr().isEmpty()) {
                msgCoberturaLocalizacion = true;
            }
            if (programaSelected.getObjetivoBVivirProyectoList() == null || programaSelected.getObjetivoBVivirProyectoList().isEmpty()) {
                msgObjetivosPLNBV = true;
            }
            if (programaSelected.getObjetivoBVivirProyectoList() == null || programaSelected.getObjetivoBVivirProyectoList().isEmpty()) {
                msgObjetivosPLNBV = true;
            }
            boolean encontro = false;
            for (LocalizacionPrograma parr : programaSelected.getObjetivosProvCanParr()) {
                if (parr.getObjetivos() != null && !parr.getObjetivos().isEmpty()) {
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                msgObjetivosProvCanParr = true;
            }
            if (programaSelected.getObjetivoEstrategicoList() == null || programaSelected.getObjetivoEstrategicoList().isEmpty()) {
                msgObjetivosEstraInst = true;
            }
            if (programaSelected.getObjetivoPlanVinculacionList() == null || programaSelected.getObjetivoPlanVinculacionList().isEmpty()) {
                msgObjetivosPlanVinculacion = true;
            }
            if (programaSelected.getEstrategiasPlanVinculacionList() == null || programaSelected.getEstrategiasPlanVinculacionList().isEmpty()) {
                msgEstrategiasPlanVinculacion = true;
            }
            if (programaSelected.getResumen() == null || programaSelected.getResumen().isEmpty()) {
                msgResumen = true;
            }
            if (programaSelected.getUbicacion() == null || programaSelected.getUbicacion().isEmpty()) {
                msgDiagnosticoProblemas = true;
            }
            if (programaSelected.getDepartamentoProgramaList() == null || programaSelected.getDepartamentoProgramaList().isEmpty()) {
                msgDepartamentosParticipantes = true;
            }
            if (programaSelected.getCarreraProgramaList() == null || programaSelected.getCarreraProgramaList().isEmpty()) {
                msgCarrerasParticipantes = true;
            }

            encontro = false;
            for (ObjetivoPrograma obj : programaSelected.getObjetivoProgramaList()) {
                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN) && (obj.getSvopObjetivoProy() == null || obj.getSvopObjetivoProy().isEmpty())) {
                    msgMatrizMarcoLogicoFin = true;
                }
                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    if (obj.getSvopObjetivoProy() == null || obj.getSvopObjetivoProy().isEmpty()) {
                        msgMatrizMarcoLogicoProposito = true;
                    }
                    if (obj.getSvinObjetivoHijoList() == null || obj.getSvinObjetivoHijoList().isEmpty()) {
                        msgMatrizMarcoLogicoComponente = true;
                    }
                }
            }
            if (programaSelected.getMetas() == null || programaSelected.getMetas().isEmpty()) {
                msgEstrategiaEjecucion = true;
            }
            if (programaSelected.getViabilidadTecnica() == null || programaSelected.getViabilidadTecnica().isEmpty()) {
                msgViabilidad = true;
            }
            if (programaSelected.getActividadPlanificadaList() == null || programaSelected.getActividadPlanificadaList().isEmpty()) {
                msgProyectosPlanificados = true;
            }

            if (!(msgCoberturaLocalizacion || msgObjetivosPLNBV || msgObjetivosProvCanParr || msgObjetivosEstraInst
                    || msgObjetivosPlanVinculacion || msgEstrategiasPlanVinculacion || msgResumen || msgDiagnosticoProblemas || msgDepartamentosParticipantes
                    || msgCarrerasParticipantes || msgMatrizMarcoLogicoFin || msgMatrizMarcoLogicoProposito || msgMatrizMarcoLogicoComponente || msgEstrategiaEjecucion
                    || msgViabilidad || msgProyectosPlanificados)) {
                programaSelected.setEstado(Programa.ESTADO_CERRADO_PERFIL);
                programaFacade.edit(programaSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
                initFinalizarPerfil();
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    private AvanceComponente avanceComponenteSelected;

    public AvanceComponente getAvanceComponenteSelected() {
        return avanceComponenteSelected;
    }

    public void setAvanceComponenteSelected(AvanceComponente avanceComponenteSelected) {
        this.avanceComponenteSelected = avanceComponenteSelected;
    }

    public void agregarAvance(ActionEvent event) {
        avanceComponenteSelected = new AvanceComponente();
        avanceComponenteSelected.setComponenteEspecifico(objetivoProgramaSelected);
        avanceComponenteSelected.setFecha(new Date());
        for (ObjetivoPrograma actividad : objetivoProgramaSelected.getSvinObjetivoHijoList()) {
            AvanceActividad seguimientoComponente = new AvanceActividad();
            seguimientoComponente.setAvanceComponente(avanceComponenteSelected);
            seguimientoComponente.setActividad(actividad);
            if (objetivoProgramaSelected.getSeguimientoProyectoActual().getAvanceActividadList() != null) {
                for (AvanceActividad seg : objetivoProgramaSelected.getSeguimientoProyectoActual().getAvanceActividadList()) {
                    if (seg.getActividad().getSvopId().equals(actividad.getSvopId())) {
                        seguimientoComponente.setPorcentajeAvance(seg.getPorcentajeAvance());
                        break;
                    }
                }
            }
            avanceComponenteSelected.addSeguimientoActividad(seguimientoComponente);
        }

    }

    public void cancelarAvance() {
        msgSeguimiento=false;
        avanceComponenteSelected = null;
        programaSelected = programaFacade.find(programaSelected.getId());
        objetivoProgramaSelected = programaSelected.getObjetivoGeneral();
    }

    private void initAvance() {
        objetivoProgramaSelected = null;
        avanceComponenteSelected = null;
        cancelarAvance();
    }

    public String registrarAvance() {
        try {
            if (avanceComponenteSelected.getId() == null) {
                objetivoProgramaSelected.addSeguimientoProyecto(avanceComponenteSelected);
            }
            programaFacade.edit(programaSelected);
            cancelarAvance();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarAvance() {
        try {
            objetivoProgramaSelected.removeSeguimientoProyecto(avanceComponenteSelected);
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarAvance();
        }
    }

    private void initCierrePresupuesto() {
        cancelarCierrePresupuesto();
    }

    public void cancelarCierrePresupuesto() {
        programaSelected = programaFacade.find(programaSelected.getId());
    }

    private void initCierreBeneficiarios() {
        cancelarCierrePresupuesto();
    }

    public void cancelarCierreBeneficiarios() {
        programaSelected = programaFacade.find(programaSelected.getId());
    }

    private void initCierreLeccionAprendida() {
        cancelarCierreLeccionAprendida();
    }

    public void cancelarCierreLeccionAprendida() {
        leccionAprendidaProgramaSelected = null;
        programaSelected = programaFacade.find(programaSelected.getId());
    }

    private LeccionAprendidaPrograma leccionAprendidaProgramaSelected;

    public LeccionAprendidaPrograma getLeccionAprendidaProgramaSelected() {
        return leccionAprendidaProgramaSelected;
    }

    public void setLeccionAprendidaProgramaSelected(LeccionAprendidaPrograma leccionAprendidaProgramaSelected) {
        this.leccionAprendidaProgramaSelected = leccionAprendidaProgramaSelected;
    }

    public void nuevoCierreLeccionAprendida() {
        leccionAprendidaProgramaSelected = new LeccionAprendidaPrograma();
    }
    @EJB
    private LeccionAprendidaProgramaFacade leccionAprendidaProgramaFacade;

    public void grabarCierreLeccionAprendida() {
        try {
            if (leccionAprendidaProgramaSelected.getId() == null) {
                leccionAprendidaProgramaSelected.setPrograma(programaSelected);
                leccionAprendidaProgramaFacade.create(leccionAprendidaProgramaSelected);
            } else {
                leccionAprendidaProgramaFacade.edit(leccionAprendidaProgramaSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarCierreLeccionAprendida();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    public void eliminarCierreLeccionAprendida() {
        try {
            leccionAprendidaProgramaFacade.remove(leccionAprendidaProgramaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarCierreLeccionAprendida();
        }
    }

    private void initEvaluacionCuantitativa() {
        //cancelarEvaluacionCuantitativa();
    }
    @EJB
    private ConfiguracionParametrosEvaluacionFacade configuracionParametrosEvaluacionFacade;

    private ParametroEvaluacion crearParametroEvaluacionMatrizMarcoLogico(ObjetivoPrograma obj) {
        ParametroEvaluacion par = new ParametroEvaluacion();
        par.setIdAspectoEvaluacion(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO);
        par.setObjetivoPrograma(obj);
        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
            par.setDescripcion("FIN: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
            par.setDescripcion("OBJETIVO GENERAL: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_COMPONENTE)) {
            par.setDescripcion("COMPONENTE: " + obj.getSvopObjetivoProy());
        } else {
            par.setDescripcion("ACTIVIDAD: " + obj.getSvopObjetivoProy());
        }

        for (int i = 0; i <= 5; i++) {
            ValoracionParametroEvaluacion val = new ValoracionParametroEvaluacion();
            val.setId(i);
            val.setDescripcion(String.valueOf(i));
            val.setPuntaje(i);
            par.addValoracion(val);
        }
        return par;
    }

    /*public void cancelarEvaluacionCuantitativa() {
        for (Proyecto proy : programaSelected.getProyectoActivoList()) {
            if (proy.getEvaluacionFinal() == null) {
                proy.addEvaluacionFinal(new EvaluacionFinalProyecto());
            }
            if (proy.getConfiguracionParametrosEvaluacionFinal() == null) {
                proy.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
            }
            if (proy.getConfiguracionParametrosEvaluacionFinal() != null) {
                for (ParametroEvaluacionFinalCabecera cab : proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraList()) {
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                        for (ObjetivoPrograma obj : proy.getObjetivoProyectoPadreList()) {
                            if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                            } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                    for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                        cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                    }
                                }
                            }
                        }
                    }
                    ParametroEvaluacion parametroEliminar = null;
                    for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                        if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                                && proy.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                                && par.getIdAspectoEvaluacion() != null
                                && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                            parametroEliminar = par;
                        }
                        par.setProyecto(proy);
                        if (proy.getEvaluacionFinal().getId() != null) {
                            if (!cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                                for (DetalleEvaluacionFinalProyecto det : proy.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                                    if (det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                        par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                        par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (parametroEliminar != null) {
                        cab.removeParametro(parametroEliminar);
                    }
                }
                proy.getConfiguracionParametrosEvaluacionFinal().initValoracion();
            }

        }
    }*/

    private void initEvaluacionCualitativa() {
        cancelarEvaluacionCualitativa();
    }

    public void cancelarEvaluacionCualitativa() {
        modoEdicion = false;
        programaSelected = programaFacade.find(programaSelected.getId());
    }

    public void grabarEvaluacionCualitativa() {
        try {
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarEvaluacionCualitativa();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    public void finalizarSeguimiento() {
        try {
            if (programaSelected.getObjetivoGeneral().getAvanceComponenteList()==null || programaSelected.getObjetivoGeneral().getAvanceComponenteList().isEmpty()){
                msgSeguimiento=true;
            }
            else{
                programaSelected.setEstado(Programa.ESTADO_CERRADO_SEGUIMIENTO);
                programaFacade.edit(programaSelected);
                cancelarEdicionPrograma();                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarEdicionPrograma() {
        modoEdicion = false;
        programaSelected = programaFacade.find(programaSelected.getId());
    }

    public void finalizarCierre() {
        try {
            programaSelected.setEstado(Programa.ESTADO_CERRADO);
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionPrograma();
        }
    }

    public void finalizarEvaluacionFinal() {
        try {
            programaSelected.setEstado(Programa.ESTADO_EVALUADO);
            programaFacade.edit(programaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionPrograma();
        }
    }

    public void cancelarEvaluadorFinal() {
        programaSelected = programaFacade.find(programaSelected.getId());
        modoEdicion = false;
        docenteSelected = new VDocenteVinculacion2();
        if (programaSelected.getEvaluadorFinal() != null) {
            docenteSelected.setUsuario(programaSelected.getEvaluadorFinal().getUsuario());
            /*docenteSelected.setDepartamento(programaSelected.getEvaluadorFinal().getDepartamento());
            docenteSelected.setCampus(programaSelected.getEvaluadorFinal().getCampus());*/
        }
    }

    public void seleccionarEvaluadorFinal(SelectEvent event) {
        docenteSelected = (VDocenteVinculacion2) event.getObject();
    }

    public void grabarEvaluadorFinal() {
        try {
            //if (docenteSelected.getUsuCc() == null) {
            if (docenteSelected.getUsuario().getUsuId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar el docente a designar como evaluador final"));
            } else {
                programaSelected = programaFacade.find(programaSelected.getId());
                programaSelected.asignarEvaluadorFinal(docenteSelected.getUsuario());
                programaFacade.edit(programaSelected);
                cancelarEvaluadorFinal();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void abrirBusquedaDocenteEvaluador(ActionEvent event) {
        abrirBusquedaDocente(TipoResponsable.TIPO_EVALUADOR_FINAL);
    }

    private void abrirBusquedaDocente(Integer tipoResponsable) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 380);
        options.put("contentWidth", 800);
        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<String, List<String>>();
        RequestContext.getCurrentInstance().openDialog("busquedaDocente", options, params);
    }

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPermitirEliminarPrograma() {
        if (programaSelected.getId() != null && !modoEdicion && verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)) {
            return true;
        }
        return false;
    }
    public boolean isPermitirEdicionPerfilDatosGenerales() {
        if (!programaSelected.getEstado().equals(Programa.ESTADO_CREADO)) {
            return false;
        }
        if ((verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA) && programaSelected.getDirector() != null && programaSelected.getDirector().getUsuario().equals(usuarioActual))
                || (programaSelected.getCreador() != null && programaSelected.getCreador().getUsuario().equals(usuarioActual))
                //|| (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION) && programaSelected.getCreador() != null && programaSelected.getCreador().getUsuario().equals(usuarioActual))
                ) {
            return true;
        }
        return false;
    }
    public boolean isPermitirEdicionPerfil() {
        if (!programaSelected.getEstado().equals(Programa.ESTADO_CREADO)) {
            return false;
        }
        if ((verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA) && programaSelected.getDirector() != null && programaSelected.getDirector().getUsuario().equals(usuarioActual))
                || (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION) && programaSelected.getCreador() != null && programaSelected.getCreador().getUsuario().equals(usuarioActual))
                ) {
            return true;
        }
        return false;
    }

    public boolean isPermitirEdicionProyectosPlanificados() {
        if ((verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA) && programaSelected.getDirector() != null && programaSelected.getDirector().getUsuario().equals(usuarioActual))
                || (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION) && programaSelected.getCreador() != null && programaSelected.getCreador().getUsuario().equals(usuarioActual))) {
            return true;
        }
        return false;
    }

    public boolean isPermitirEdicionSeguimiento() {
        if (programaSelected.getEstado().equals(Programa.ESTADO_CERRADO_PERFIL)
                && verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA)
                && programaSelected.getDirector().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    public boolean isPermitirEdicionCierre() {
        if (programaSelected.getEstado().equals(Programa.ESTADO_CERRADO_SEGUIMIENTO)
                && programaSelected.getMensajePermitirCierre().equals("")
                && verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA)
                && programaSelected.getDirector().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    public boolean isPermitirFinalizarCierre() {
        if (programaSelected.getEstado().equals(Programa.ESTADO_CERRADO_SEGUIMIENTO)
                && programaSelected.getMensajePermitirFinalizarCierre().equals("")
                && verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA)
                && programaSelected.getDirector().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    public boolean isPermitirDesignarEvaluador() {
        if (programaSelected.getEstado().equals(Programa.ESTADO_CERRADO) && isVerificarPerfilAdministrador()) {
            return true;
        }
        return false;
    }

    public boolean isVerificarPerfilAdministrador() {
        return (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION));
    }
    public boolean isPermitirEvaluacion() {
        if (programaSelected.getMensajePermitirEvaluacionFinal().equals("")
                && verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA)
                && programaSelected.getEvaluadorFinal() != null
                && programaSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    public boolean isPermitirFinalizarEvaluacion() {
        if (programaSelected.getMensajePermitirFinalizarEvaluacionFinal().equals("")
                && verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA)
                && programaSelected.getEvaluadorFinal() != null
                && programaSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    private AnexoProyecto anexoProyectoSelected;

    public AnexoProyecto getAnexoProyectoSelected() {
        return anexoProyectoSelected;
    }

    public void setAnexoProyectoSelected(AnexoProyecto anexoProyectoSelected) {
        this.anexoProyectoSelected = anexoProyectoSelected;
    }

    public void nuevoAnexo() {
        anexoProyectoSelected = new AnexoProyecto();
    }

    public void cancelarAnexo() {
        programaSelected = programaFacade.find(programaSelected.getId());
        anexoProyectoSelected = null;
    }

    @EJB
    private AnexoProyectoFacade anexoProyectoFacade;

    public void grabarAnexo() {
        try {
            if (programaSelected.existeAnexo(anexoProyectoSelected)) {
                String idControl = "formPrincipal:hidNombreAnexo";
                if (anexoProyectoSelected.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA)) {
                    idControl = "formPrincipal:hidNombreAnexoDiagnosticoProblema";
                }
                FacesContext.getCurrentInstance().addMessage(idControl, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe un anexo con el nombre ingresado"));
            } else {
                anexoProyectoSelected.setUsuario(usuarioActual);
                anexoProyectoSelected.setPrograma(programaSelected);
                anexoProyectoFacade.create(anexoProyectoSelected);
                cancelarAnexo();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }

        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void eliminarAnexo() {
        try {
            anexoProyectoFacade.remove(anexoProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarAnexo();
        }
    }

    private StreamedContent archivoAdjunto;

    public StreamedContent getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(StreamedContent archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public void prepararArchivoDownload(AnexoProyecto anexoProyecto) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + anexoProyecto.getArchivoUrlFinal();
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", anexoProyecto.getArchivoNombre());
        } catch (Exception e) {

        }

    }

    public void nuevoAnexoDiagnosticoProblema() {
        anexoProyectoSelected = new AnexoProyecto();
        anexoProyectoSelected.setTipo(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA);
    }

    public void subirAnexoDiagnosticoProblema(FileUploadEvent event) {
        try {

            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "anexosDiagnosticoProblema_Programa";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + programaSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            anexoProyectoSelected.setArchivoNombre(event.getFile().getFileName());
            anexoProyectoSelected.setArchivoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + programaSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void generarReportePerfilPDF() {
        generarReportePerfil(JasperReportUtil.TIPO_PDF);
    }

    private void generarReportePerfil(String tipoReporte) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            System.out.println("SUBREPORT_DIR" + JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("idPrograma", programaSelected.getId());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PERFIL_PROGRAMA, tipoReporte, parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean msgSeguimiento;

    public boolean isMsgSeguimiento() {
        return msgSeguimiento;
    }

    public void setMsgSeguimiento(boolean msgSeguimiento) {
        this.msgSeguimiento = msgSeguimiento;
    }
    
}
