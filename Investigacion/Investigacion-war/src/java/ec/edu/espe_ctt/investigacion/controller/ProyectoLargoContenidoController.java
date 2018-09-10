/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.saturno.entity.Stvtops;
import ec.edu.espe_ctt.saturno.session.StvtopsFacade;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaAnalisisFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaAreacUnesco;
import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaDiagnosProblema;
import ec.edu.espe_ctt_investigacion.entity.SeaFdifusionEvento;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoBibliografia;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoDifusion;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoEstrategiae;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoSeguimiento;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoViabilidad;
import ec.edu.espe_ctt_investigacion.entity.SeaObjAcFormulario;
import ec.edu.espe_ctt_investigacion.entity.SeaObjAdquisisiones;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEFormulario;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEntregables;
import ec.edu.espe_ctt_investigacion.entity.SeaObjetivosFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaObplanbv;
import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaTablaContenido;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.Sztaobjbvpr;
import ec.edu.espe_ctt_investigacion.entity.Sztapolobjbv;
import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import ec.edu.espe_ctt_investigacion.session.SeaAnalisisFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaAreacUnescoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCoberturaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDiagnosProblemaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFdifusionEventoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoBibliografiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoDifusionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoEstrategiaeFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoSeguimientoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoViabilidadFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjAcFormularioFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjAdquisisionesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjEFormularioFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjEntregablesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjetivosFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObplanbvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaOpcionInstitucionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoXConvocatoriaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTablaContenidoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaZonaDetalleFacade;
import ec.edu.espe_ctt_investigacion.session.ObjetivoProyectoFacade;
import ec.edu.espe_ctt_investigacion.session.SztaobjbvprFacade;
import ec.edu.espe_ctt_investigacion.session.SztapolobjbvFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteDeptoBFacade;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ProyectoLargoContenidoController implements Serializable {

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath = "";

    /**
     * Creates a new instance of ProyectoLargoController
     */
    public ProyectoLargoContenidoController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;

    /// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    private List<SeaDatGeneralProy> montProyList;
    private List<SeaDatGeneralProy> considConseProyList;
    private SeaDatGeneralProy notaConceptual;
    private boolean habilitaTab = true;
    private boolean validaVaciosP1 = true;
    private boolean validaVaciosP2 = true;
    private boolean validaVaciosP3 = true;
    private boolean validaVaciosP31 = true;
    private boolean validaVaciosP4 = true;
    private boolean controlGrabarP3 = false;
    private boolean controlGrabarP4 = false;
    private BigDecimal idUsuario;

    ////Formato Largo Proyecto
    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private SeaFormatoLargo formatoLargo;
    private List<SeaFormatoLargo> formatoLagoList;
    private String pagLegal = "";
    private String nomDepCentro = "";
    private String carrera = "";
    private String progPost = "";
    private String numConvoca = "";
    private String nomPrograma = "";
    private String grupInvest = "";
    private String lineaInvest = "";
    private String sublInvest = "";
    private String tipoInvest = "";
    public boolean controlPDF = false;
    private String nombreArchivoPdf;

    ///DEPCENPROY
    @EJB
    private SeaDepcenproyFacade depCenProyFacade;
    private SeaDepcenproy depCenProy;
    private List<SeaDepcenproy> departamentosList;

    /// COBERTURA
    @EJB
    private SeaCoberturaFacade coberturaFacade;
    private SeaCobertura cobertura;
    //private List<SeaCobertura> coberturaList;
    private List<Object> coberturaList;
    private SeaCobertura coberturaLocal;
    //private String idCobertura;

    /// ZONA DETALLE
    @EJB
    private SeaZonaDetalleFacade zonaDetalleFacade;
    private SeaZonaDetalle zonaDetalle;

    ///OBJETIVOS DEL BUEN VIVIR
    @EJB
    private SeaObplanbvFacade objetivoBuenVivirFacade;
    @EJB
    private SztaobjbvprFacade objetivoBuenVivirProyectoFacade;
    private List<SeaObplanbv> objetivoBuenVivirList;

    ///AREA CONOCIMIENTO ESPE
    @EJB
    private StvtopsFacade tvtopsFacade;
    private Stvtops tvtops;
    private List<Stvtops> areaEspeList;
    private String areaConocimientoEspe = "";
    private String areaEspEdit;

    ///AREA CONOCIMIENTO UNESCO
    @EJB
    private SeaAreacUnescoFacade areaUnescoFacade;
    private SeaAreacUnesco areaUnesco;
    private List<SeaAreacUnesco> areaUnescoList;
    private String areaConocimientoUnesco = "";
    private String areaUnescoEdit;

    ///Opción Institución
    @EJB
    private SeaOpcionInstitucionFacade opcInstFacade;
    private SeaOpcionInstitucion opcionInstituc;
    private List<SeaOpcionInstitucion> opcionInstList;
    private boolean validaVaciosP5 = true;
    private boolean controlGrabarP5 = false;
    private boolean validaVaciosP6 = true;
    private boolean controlGrabarP6 = false;

    /////
    private BigDecimal presupestoRiesgo;
    private BigDecimal presupuestoEspe;
    private BigDecimal presupuestoAuspiciante;
    private BigDecimal presupuestoTotal;
    private boolean validaVaciosP7 = true;
    private boolean controlGrabarP7 = false;
    private String fechaPresentacion = "";
    private Date fechPresent = null;
    private String fechaInicio = "";
    private Date fechInic = null;
    private String fechaFinaliza = "";
    private Date fechFinal;
    private String duracionProyecto = "";
    private boolean validaVaciosP8 = true;
    private boolean controlGrabarP8 = false;
    private boolean validaVaciosP9 = true;
    private boolean controlGrabarP9 = false;

    //// Parametros Detalle
    @EJB
    private SeaParametrosDetFacade paramDetFacade;
    private SeaParametrosDet parametrosDetalle;
    private List<SeaParametrosDet> paramDetList;
    private List<SeaParametrosDet> paramDetPlazoEjecList;
    private List<SeaParametrosDet> categoriaProyList;
    private List<SeaParametrosDet> objProyectList;
    private String paramEstado;
    private String estadoEdit;

    /// Responsable Programa
    @EJB
    private SeaResponsableProgFacade responsableProgFacade;
    private SeaResponsableProg responsableProg;
    private List<SeaResponsableProg> responsableProgList;

    ////
    @EJB
    private SeaDiagnosProblemaFacade diagnosProblemfacade;
    private SeaDiagnosProblema diagnosticoProblema;
    private boolean validaVaciosP10 = true;
    private boolean controlGrabarP10 = false;
    private String tablaBusq = "";
    private BigDecimal idDocente;

    //// Tabla Contenido
    @EJB
    private SeaTablaContenidoFacade tablaContenidoFacade;
    private SeaTablaContenido tablaContenidoSelected;

    //// Analisis Formato 
    @EJB
    private SeaAnalisisFormatoFacade analisisFormatoFacade;
    private SeaAnalisisFormato analisisFormato;
    private boolean validaVaciosP102 = true;
    private boolean controlGrabarP102 = false;

    //// Objetivo Formato
    @EJB
    private SeaObjetivosFormatoFacade objetivosFormatoFacade;
    private SeaObjetivosFormato objetivosFormato;
    private SeaObjetivosFormato objetivoFormatoSelected;
    private SeaObjetivosFormato objFormSelected;
    private List<SeaObjetivosFormato> objetivoFormatoList;

    private String indicador = "";
    private String medioVerif = "";
    private String supuestos = "";

    ////Objetivos Proyecto
    @EJB
    private ObjetivoProyectoFacade szObjProyFacade;
    private ObjetivoProyecto szObjProy;
    private ObjetivoProyecto objetivoProyecto;
    private List<ObjetivoProyecto> szObjProyList;
    private ObjetivoProyecto objProyPadreSelected;
    private ObjetivoProyecto objProySelected;
    private boolean validaVaciosP11 = true;
    private boolean controlGrabarP11 = false;
    private String objProyecto = "";
    private String descripObj = "";
    private String tipoObj;
    private boolean controlTipoFin;
    private boolean controlTipoPropos;
    private boolean controlTipoCompon;

    ///Objetivos Especificos del Formulario
    @EJB
    private SeaObjEFormularioFacade objEspcFormularioFacade;
    private SeaObjEFormulario objEspeciFormulario;
    private SeaObjEFormulario objEFormularioSelected;
    private List<SeaObjEFormulario> objEspeciFormularioList;
    private String descripObjEsp = "";
    private String indicadObjEsp = "";
    private String verificObjEsp = "";
    private String supuestObjEsp = "";
    private boolean validaVaciosObjEsp = true;

    ///Actividad Objetivos del Formulario
    @EJB
    private SeaObjAcFormularioFacade objActividadFormularioFacade;
    private SeaObjAcFormulario objActividadFormulario;
    private SeaObjAcFormulario objAcFormularioSelected;
    private List<SeaObjAcFormulario> objActividadFormuList;
    private String descripObjAct = "";
    private String indicadObjAct = "";
    private String verificObjAct = "";
    private String supuestObjAct = "";
    private boolean validaVaciosObjAct = true;

    ///// Objetivos Entregables
    @EJB
    private SeaObjEntregablesFacade objEntregablesFacade;
    //private SeaObjEntregables objEntregables;
    private SeaObjEntregables objEntregableSelected;
    private List<SeaObjEntregables> objEntregabList;
    private boolean validaVaciosP12 = true;
    private boolean controlGrabarP12 = false;
    private String objFormato = "";
    private String objFormatoEdit;
    private String bienServ = "";
    private String bienServEdit;
    private String detEntr = "";
    private String denEntrEdit;

    ////Objetivo Adquisisiones
    @EJB
    private SeaObjAdquisisionesFacade objAdquisisionesFacade;
    private SeaObjAdquisisiones objAdquisisiones;
    private SeaObjAdquisisiones objAdquisisioneSelected;
    private List<SeaObjAdquisisiones> objAdquisisionList;
    private boolean validaVaciosP13 = true;
    private boolean controlGrabarP13 = false;
    private String objetivoFormato = "";
    private String objetivoFormatoEdit;
    private String bienesServicios = "";
    private String bienesServiciosEdit = "";
    private String detalleInsNac = "";
    private String detalleInsImp = "";
    private String porcentNac = "";
    private String porcentImp = "";

    ///Categorización del proyecto
    private boolean validaVaciosP14 = true;
    private boolean controlGrabarP14 = false;
    private String categoriaProyecto = "";
    private String categoriaProyectoEdit;

    ///Metodología para la Investigación
    //// Viabilidad y Plan de Sostenibilidad
    @EJB
    private SeaFormatoViabilidadFacade formatoViabilidadFacade;
    private SeaFormatoViabilidad formatoViabilidad;
    private SeaFormatoViabilidad frmtViabilidad;
    private boolean validaVaciosP16 = true;
    private boolean controlGrabarP16 = false;
    private String viabilidadTecn = "";
    private String equipaTecnol = "";
    private String perderPais = "";
    private String impactoEsper = "";
    private String impactoAmbiental = "";
    private String sostenibiSocial = "";
    private String transferTecnol = "";
    private String artiCientif = "";
    private String prototip = "";
    private String regPropIntel = "";
    private String spinOff = "";
    private String otrosViabilidad = "";
    private String disponeMetodologia = "";

    //// formato Estrategia
    @EJB
    private SeaFormatoEstrategiaeFacade formatoEstrategiaFacade;
    private SeaFormatoEstrategiae formatoEstrategia;
    private SeaFormatoEstrategiae formatoEstrategiaSelected;
    private List<SeaFormatoEstrategiae> formatoEstrategiaList;
    private boolean validaVaciosP17 = true;
    private boolean controlGrabarP17 = false;
    private boolean controlGrabarP23 = false;
    private boolean validaVaciosP23 = true;
    private String nomFile1;
    private UploadedFile file;
    private byte[] file1 = null;
    private String nomFile2;
    private UploadedFile file2;
    private byte[] file22 = null;

    /// tabP18 Estrategia de Seguimiento y Evaluacion
    @EJB
    private SeaFormatoSeguimientoFacade formatoSeguimientoFacade;
    private SeaFormatoSeguimiento formatoSeguimiento;
    private SeaFormatoSeguimiento formatoSeguimientoSelected;
    private List<SeaFormatoSeguimiento> formatoSeguimientoList;
    private boolean validaVaciosP18 = true;
    private boolean controlGrabarP18 = false;
    private String mesSeguimiento = "";
    private String descripcionHito = "";
    private String presupuestoSegE = "";
    private String fechInicHitos = "";
    private Date fechaInicioHitos;
    private String fechFinHitos = "";
    private Date fechaFinalHitos;

    ///fDifusión  Evento
    @EJB
    private SeaFdifusionEventoFacade fdifusionEventoFacade;
    private SeaFdifusionEvento fdifusionEvento;
    private List<SeaFdifusionEvento> fdifusionEveantoList;
    private SeaFdifusionEvento fdifusionEventoSelected;
    private boolean validaVaciosP19 = true;
    private boolean controlGrabarP19 = false;
    private String fdescripcion = "";

    /// Formato Difusion
    @EJB
    private SeaFormatoDifusionFacade formatoDifusionFacade;
    private SeaFormatoDifusion formatoDifusion;
    private SeaFormatoDifusion formatoDifusionSelected;
    private List<SeaFormatoDifusion> formatoDifusionList;
    private boolean validaVaciosP20 = true;
    private boolean controlGrabarP20 = false;
    private String tipoEvento = "";
    private String tipoEventoEdit;
    private String actividad = "";
    private String costo = "";

    ///formato bibliografia
    @EJB
    private SeaFormatoBibliografiaFacade formatoBibliografiaFacade;
    private SeaFormatoBibliografia formatoBibliografia;
    private SeaFormatoBibliografia formatoBibliografiaSelected;
    private List<SeaFormatoBibliografia> formatoBibliografiaList;
    private boolean validaVaciosP21 = true;
    private boolean controlGrabarP21 = false;
    private String autor = "";
    private String titulo = "";
    private String edicion = "";
    private String anio = "";
    private String editorial = "";
    private String idioma = "";
    private String numPag = "";
    private String url = "";
    private String obserBiblio = "";

    @EJB
    private SeaProcesoXConvocatoriaFacade procesosXConvFacade;
    private SeaProcesoXConvocatoria procesoXConv;
    private Date fActual;
    private Date fechPresConvoca;

    ///Objetivos Plan Nacional Buen Vivir
    private Sztaobjbvpr objetivoBuenVivirProyectoSelected;

    ///Politicas del Objetivo Plan Nacional Buen Vivir
    @EJB
    private SztapolobjbvFacade politicaObjBuenVivirFacade;
    private Sztapolobjbv politicaObjBuenVivirSelected;

    /// Vista Docente DeptoB
    @EJB
    private VDocenteDeptoBFacade vDocenteDeptoBFacade;
    private VDocenteDeptoB vDocenteDeptoB;

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");

        Object idNotaConceptual = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idNotaConceptual");
        permitirEdicion=true;
        if (idNotaConceptual != null) {
            notaConceptual = notaConceptualFacade.find(new BigDecimal(idNotaConceptual.toString()));
            seleccionarNotaConceptual();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    private void initVariables() {
        szObjProyList = new ArrayList<>();
        objetivoFormatoList = new ArrayList<>();
        objEntregabList = new ArrayList<>();
        formatoSeguimientoList = new ArrayList<>();
        fdifusionEveantoList = new ArrayList<>();
        formatoBibliografiaList = new ArrayList<>();
        diagnosticoProblema = null;
        analisisFormato = null;
        frmtViabilidad = null;
        departamentosList = new ArrayList<>();

        viabilidadTecn = null;
        equipaTecnol = null;
        perderPais = null;
        impactoEsper = null;
        disponeMetodologia = null;
        impactoAmbiental = null;
        sostenibiSocial = null;
        transferTecnol = null;
        artiCientif = null;
        prototip = null;
        regPropIntel = null;
        spinOff = null;
        otrosViabilidad = null;

    }

    public String seleccionarNotaConceptual() {
        try {
            if (!notaConceptual.getDatgeproyEstado().equals(SeaDatGeneralProy.ESTADO_APROBADO_COMISION)){
                permitirEdicion=false;
            }
            initVariables();
            fActual = new Date();
            procesoXConv = procesosXConvFacade.findProcesoXConvProyLargoByCodCon(notaConceptual.getConvocaId().getConvocaId());
            if (procesoXConv == null) {
                throw new Exception("No se encuentra habilitado el proceso de presentación de proyecto extenso para esta convocatoria");
            }

            fechPresConvoca = procesoXConv.getPpcFecifin();
            if (!fActual.before(fechPresConvoca)) {
                throw new Exception("La Fecha de Presentación del Proyecto Extenso ha Caducado");
            }

            /// tabP1
            pagLegal = notaConceptual.getDatgeproyPagilegNombre();
            
            formatoLargo = formatoLargoFacade.findIdFormatoByCodPro(notaConceptual.getDatgeproyId());

            cargarDatosProyectoExtenso();
            depCenProy = depCenProyFacade.findDeptCentProy(notaConceptual.getDatgeproyId());
            if (depCenProy != null) {
                departamentosList = depCenProyFacade.findDepartCentProyByCodPro(notaConceptual.getDatgeproyId());
            }
            numConvoca = notaConceptual.getConvocaId().getConvocaCodigo();
            nomPrograma = notaConceptual.getProgId().getProgDescrip();
            tipoInvest = notaConceptual.getPrdId().getPrdDescripcion();
            /// tabP2
            coberturaList = coberturaFacade.findDatosCoberturaByCodPro(notaConceptual.getDatgeproyId());
            /// tabP3
            objetivoBuenVivirList = objetivoBuenVivirFacade.findAll();

            //formatoLagoList = formatoLargoFacade.findFormatoByCodPro(datGenProySelected.getDatgeproyId());
            /// tabP4
            areaEspeList = tvtopsFacade.findAll();
            areaUnescoList = areaUnescoFacade.findAll();
            formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
            //// tabP5
            opcionInstList = opcInstFacade.findOpcionInstitucionByCodPro(notaConceptual.getDatgeproyId());

            //// tabP6
            formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
            //// tabP7
            duracionProyecto = notaConceptual.getDatgeproyTiempoEjecucion();
            paramDetPlazoEjecList = paramDetFacade.findParamDetEstado();
            //paramDetList = paramDetFacade.findParamDetEstado();
            formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
            //// tabP8
            responsableProgList = responsableProgFacade.findResponsableProyByCodPro(notaConceptual.getDatgeproyId());
            //// tabP9
            considConseProyList = notaConceptualFacade.findDatosProyectoByCodProy(notaConceptual.getDatgeproyId());
            //// tabP10

            if (analisisFormato == null) {
                analisisFormato = new SeaAnalisisFormato();
            }
            /// tabP11
            objProyectList = paramDetFacade.findParamObjProy();

            paramDetList = paramDetFacade.findParamDetBieneServicios();
            paramDetList = paramDetFacade.findParamDetBieneServicios();
            objAdquisisionList = objAdquisisionesFacade.findAll();
            /// tabP14
            categoriaProyList = paramDetFacade.findParamDetCategoProy();
            formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
            //// tabP15
            //// tabP16

            if (frmtViabilidad != null) {
                viabilidadTecn = frmtViabilidad.getSfaViavilidadTec();
                equipaTecnol = frmtViabilidad.getSfaEquipamientoTec();
                perderPais = frmtViabilidad.getSfaPerderPais();
                impactoEsper = frmtViabilidad.getSfaImpactosEsperados();
                disponeMetodologia = frmtViabilidad.getSfaDisponeMetodologia();
                impactoAmbiental = frmtViabilidad.getSfaImpactoAmbiental();
                sostenibiSocial = frmtViabilidad.getSfaSostenibilidadSocial();
                transferTecnol = frmtViabilidad.getSfaTranferenciaTecno();
                artiCientif = frmtViabilidad.getSfaArticulosCientificos();
                prototip = frmtViabilidad.getSfaPrototipos();
                regPropIntel = frmtViabilidad.getSfaPropiedadIntelecto();
                spinOff = frmtViabilidad.getSfaEmpresaSpin();
                otrosViabilidad = frmtViabilidad.getSfaOtros();
            }
            //// tabP17
            formatoEstrategiaList = formatoEstrategiaFacade.findFormatoEntregableByCodFormL(notaConceptual.getDatgeproyId());
            //// tabP18

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        return "";
    }

    private boolean permitirEdicion;

    public boolean isPermitirEdicion() {
        return permitirEdicion;
    }

    public void setPermitirEdicion(boolean permitirEdicion) {
        this.permitirEdicion = permitirEdicion;
    }
        
    private void cargarDatosProyectoExtenso() {
        if (formatoLargo != null) {
            analisisFormato = analisisFormatoFacade.findAnalisiFormatoByCodForml(formatoLargo.getSflId());
            szObjProyList = szObjProyFacade.findObjProyByCodFormL(formatoLargo.getSflId());
            objetivoFormatoList = objetivosFormatoFacade.findObjetivoFormatoByCodFormL(formatoLargo.getSflId());
            objEntregabList = objEntregablesFacade.findEntregableByCodProy(formatoLargo.getSflId());
            frmtViabilidad = formatoViabilidadFacade.findFormtViabilidadByCodFormL(formatoLargo.getSflId());

            formatoSeguimientoList = formatoSeguimientoFacade.findEstraSeguiEvaByCodForL(formatoLargo.getSflId());
            fdifusionEveantoList = fdifusionEventoFacade.findDifusionEventeByCodFormL(formatoLargo.getSflId());
            formatoBibliografiaList = formatoBibliografiaFacade.findFormatoBiblioByCodFormL(formatoLargo.getSflId());

        } else {
            formatoLargo = new SeaFormatoLargo();
        }
        if (analisisFormato == null) {
            analisisFormato = new SeaAnalisisFormato();
        }
        cancelarP10();
    }

    /// funciones Tab1
    public void registraP1() {
        try {
            if (formatoLargo.getSflId() == null) {
                formatoLargo.setSflTituloEspaniol(notaConceptual.getDatgeproyTitulo());
                formatoLargo.setDatgeproyId(notaConceptual);
                /// INSERTAR EN TABLA SZDTAOBJPROY
                ObjetivoProyecto szobjProyFin = new ObjetivoProyecto();
                ObjetivoProyecto szobjProyPgen = new ObjetivoProyecto();
                ObjetivoProyecto szobjProyOEsp = new ObjetivoProyecto();
                szobjProyFin.setTipo(new SeaParametrosDet(new Long(302)));
                szobjProyPgen.setTipo(new SeaParametrosDet(new Long(303)));
                szobjProyOEsp.setTipo(new SeaParametrosDet(new Long(304)));
                szobjProyFin.setProyecto(formatoLargo);
                szobjProyPgen.setProyecto(formatoLargo);
                szobjProyOEsp.setProyecto(formatoLargo);
                formatoLargo.getObjetivoList().add(szobjProyFin);
                formatoLargo.getObjetivoList().add(szobjProyPgen);
                formatoLargo.getObjetivoList().add(szobjProyOEsp);

                formatoLargoFacade.create(formatoLargo);
                cargarDatosProyectoExtenso();
            } else {
                formatoLargoFacade.edit(formatoLargo);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    /// funciones tabP2
    public String registraP2() {
        return "";
    }

    public boolean validarVaciosP2() {
        validaVaciosP2 = false;
        return validaVaciosP2;
    }

    /// funciones tabP3
    public void agregarP3() {
        //controlGrabarP3 = true;
        objetivoBuenVivirProyectoSelected = new Sztaobjbvpr();

    }

    public void registraP3() {
        //Buscar si ya fue ingresado el objetivo
        /*objetivoIngList = objBvPrFacade.findObjetivoIngByCodObj(new BigDecimal(objetivoPlan), formatoLargo.getSflId());
        if (objetivoIngList != null) {
            RequestContext.getCurrentInstance().execute("alert('Objetivo ya Ingresado')");
            cancelarP3();
            return "";
        } else {
            SeaObplanbv obplanbv = new SeaObplanbv();
            obplanbv.setObplabvId(new BigDecimal(objetivoPlan));

            Sztaobjbvpr objetivoBvPr = new Sztaobjbvpr();
            objetivoBvPr.setObplabvId(obplanbv);
            objetivoBvPr.setSflId(formatoLargo);
            objBvPrFacade.create(objetivoBvPr);
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        }
        objetivoBvPrList = objBvPrFacade.findObjetivoBvPrByCodFormLargo(formatoLargo.getSflId());
        cancelarP3();
        return "";
         */

        try {
            if (formatoLargo.existeObjetivoBuenVivir(objetivoBuenVivirProyectoSelected)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El objetivo seleccionadp ya ha sido registrado."));
                return;
            }
            if (objetivoBuenVivirProyectoSelected.getSflId() == null) {
                objetivoBuenVivirProyectoSelected.setSflId(formatoLargo);
                objetivoBuenVivirProyectoFacade.create(objetivoBuenVivirProyectoSelected);
            } else {
                objetivoBuenVivirProyectoFacade.edit(objetivoBuenVivirProyectoSelected);
            }
            formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
            objetivoBuenVivirProyectoSelected = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarP3() {
        objetivoBuenVivirProyectoSelected = null;
    }

    public void eliminarP3() {
        /*Integer registro = 0;
        if (objetivoBuenVivirProyectoSelected != null) {
            Sztaobjbvpr eliminar = null;
            for (int i = 0; i < objetivoBvPrList.size(); i++) {
                Sztaobjbvpr elemento = this.objetivoBvPrList.get(i);
                if (objetivoBuenVivirProyectoSelected.getObplabvId() == objetivoBvPrList.get(i).getObplabvId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println("ingreso a eliminar");
                this.objetivoBvPrList.remove(eliminar);
                objetivoBuenVivirProyectoFacade.remove(eliminar);
                MensajeController m = null;
            }

        }*/
        try {
            objetivoBuenVivirProyectoFacade.remove(objetivoBuenVivirProyectoSelected);
            objetivoBuenVivirProyectoSelected = null;
            formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    public void nuevoPolitica() {
        politicaObjBuenVivirSelected = new Sztapolobjbv();

    }

    public void registraPoliticP31() {
        /*Sztapolobjbv polobjBv = new Sztapolobjbv();
        polobjBv.setSztaobjbvprCode(objetivoBuenVivirProyectoSelected);
        polobjBv.setSztapolobjbvDescrip(descriPolitica);
        polobjBvFacade.create(polobjBv);
        return "";
         */
        try {

            if (politicaObjBuenVivirSelected.getSztapolobjbvCode() == null) {
                politicaObjBuenVivirSelected.setSztaobjbvprCode(objetivoBuenVivirProyectoSelected);
                politicaObjBuenVivirFacade.create(politicaObjBuenVivirSelected);
            } else {
                politicaObjBuenVivirFacade.edit(politicaObjBuenVivirSelected);
            }
            objetivoBuenVivirProyectoSelected = null;
            formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            RequestContext.getCurrentInstance().execute("PF('dialogPolitica').hide();");

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    public void eliminarP31() {
        /*if (politicaObjBuenVivirSelected != null) {
            Sztapolobjbv eliminar = null;
            for (int i = 0; i < polobjBvList.size(); i++) {
                Sztapolobjbv elemento = this.polobjBvList.get(i);
                if (politicaObjBuenVivirSelected.getSztapolobjbvCode() == polobjBvList.get(i).getSztapolobjbvCode()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println("ingreso a eliminar");
                this.polobjBvList.remove(eliminar);
                politicaObjBuenVivirFacade.remove(eliminar);
                MensajeController m = null;
            }
        }*/
        try {
            politicaObjBuenVivirFacade.remove(politicaObjBuenVivirSelected);
            politicaObjBuenVivirSelected = null;
            formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    ////Funciones tabP4
    public String agregarP4() {
        controlGrabarP4 = true;
        return "";
    }

    public void registraP4() {
        try {
            formatoLargoFacade.edit(formatoLargo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarP4() {
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
    }

    public void onRowEditP4(RowEditEvent event) {
        SeaFormatoLargo formatoLargAreaEdit = new SeaFormatoLargo();
        formatoLargAreaEdit = (SeaFormatoLargo) event.getObject();
        tvtops = new Stvtops();
        tvtops.setStvtopsCode(areaEspEdit);

        areaUnesco = new SeaAreacUnesco();
        areaUnesco.setSacuId(new BigDecimal(areaUnescoEdit));

        formatoLargAreaEdit.setSacuId(areaUnesco);
        formatoLargAreaEdit.setStvtopsCode(tvtops);
        formatoLargoFacade.edit(formatoLargAreaEdit);
        formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
    }

    public void onRowCancelP4(RowEditEvent event) {
    }

    public void eliminarP4() {
        /*Integer registro = 0;
        if(formatoLargoAreaSelected != null){
            SeaFormatoLargo eliminar = null;
            for(int i=0; i< formatoLagoList.size(); i++){
                SeaFormatoLargo elemento = this.formatoLagoList.get(i);
                if(formatoLargoAreaSelected.getSflId() == formatoLagoList.get(i).getSflId()){
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar "+ eliminar);
            if(eliminar != null){
                System.out.println("ingreso a eliminar");
                this.formatoLagoList.remove(eliminar);
                formatoLargoFacade.remove(eliminar);
                MensajeController m = null;
            }
            
        }*/
    }

    ///funciones tabP5
    public String registraP5() {
        return "";
    }

    /// funciones tabP6
    public String agregarP6() {
        controlGrabarP6 = true;
        return "";
    }

    public String registraP6() {
        /*formatoLargo.setSflPresupRiesgo(presupestoRiesgo);
        formatoLargo.setSflPresupEspe(presupuestoEspe);
        formatoLargo.setSflPresupEntidadAuspicia(presupuestoAuspiciante);
        formatoLargo.setSflPresupTotal(presupuestoTotal);*/
        formatoLargo.setSflPresupTotal(formatoLargo.getPresupuestoTotal());
        formatoLargoFacade.edit(formatoLargo);
        //formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        cancelarP6();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    public void cancelarP6() {
        /*controlGrabarP6 = false;
        presupestoRiesgo = formatoLargo.getSflPresupRiesgo();
        presupuestoAuspiciante = formatoLargo.getSflPresupEntidadAuspicia();
        presupuestoEspe = formatoLargo.getSflPresupEspe();
        presupuestoTotal= formatoLargo.getSflPresupTotal();
        validaVaciosP6 = true;*/
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
    }

    public boolean validarVaciosP6() {
        validaVaciosP6 = false;
//        if(presupestoRiesgo == 0) validaVaciosP6 = true;
//        if(presupuestoEspe == 0) validaVaciosP6 = true;
//        if(presupuestoAuspiciante == 0) validaVaciosP6 = true;
        return validaVaciosP6;
    }

    public void eliminarP6() {
        /*Integer registro = 0;
        if(montoFormatoLargSelected != null){
            SeaFormatoLargo eliminar = null;
            for(int i=0; i< formatoLagoList.size(); i++){
                SeaFormatoLargo elemento = this.formatoLagoList.get(i);
                if(montoFormatoLargSelected.getSflId() == formatoLagoList.get(i).getSflId()){
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar "+ eliminar);
            if(eliminar != null){
                System.out.println("ingreso a eliminar");
                this.formatoLagoList.remove(eliminar);
                formatoLargoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }*/
    }

    public void onRowCancelP6(RowEditEvent event) {
    }

    /// funciones tabP7
    public String agregarP7() {
        controlGrabarP7 = true;
        return "";
    }

    public String registraP7() {
        parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(paramEstado));

        System.out.println("actualiza registro");
        formatoLargo.setSflFechaPresenta(fechPresent);
        formatoLargo.setSflFechaInicio(fechInic);
        formatoLargo.setSflFechaFinaliza(fechFinal);
        formatoLargo.setPrdId(parametrosDetalle);
        formatoLargoFacade.edit(formatoLargo);
        formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarP7();
        return "";
    }

    public void cancelarP7() {
        controlGrabarP7 = false;
        fechPresent = null;
        fechInic = null;
        fechFinal = null;
        paramEstado = "";
        validaVaciosP7 = true;
    }

    public boolean validarVaciosP7() {
        validaVaciosP7 = false;
        if (fechPresent != null) {
            fechaPresentacion = fechPresent.toString();
            fechaPresentacion = fechaPresentacion.trim();
        }
        if (fechInic != null) {
            fechaInicio = fechInic.toString();
            fechaInicio = fechaInicio.trim();
        }
        if (fechFinal != null) {
            fechaFinaliza = fechFinal.toString();
            fechaFinaliza = fechaFinaliza.trim();
        }

        if (fechaPresentacion.isEmpty()) {
            validaVaciosP7 = true;
        }
        if (fechaInicio.isEmpty()) {
            validaVaciosP7 = true;
        }
        if (fechaFinaliza.isEmpty()) {
            validaVaciosP7 = true;
        }
        return validaVaciosP7;
    }

    public void eliminarP7() {
        /*Integer registro = 0;
        if(plazoFormatoLargSelected != null){
            SeaFormatoLargo eliminar = null;
            for(int i=0; i< formatoLagoList.size(); i++){
                SeaFormatoLargo elemento = this.formatoLagoList.get(i);
                if(plazoFormatoLargSelected.getSflId() == formatoLagoList.get(i).getSflId()){
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar "+ eliminar);
            if(eliminar != null){
                System.out.println("ingreso a eliminar");
                this.formatoLagoList.remove(eliminar);
                formatoLargoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }*/
    }

    public void onRowEditP7(RowEditEvent event) {
        SeaFormatoLargo plazoFormatoLargEdit = new SeaFormatoLargo();
        plazoFormatoLargEdit = (SeaFormatoLargo) event.getObject();
        parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(estadoEdit));

        plazoFormatoLargEdit.setPrdId(parametrosDetalle);
        formatoLargoFacade.edit(plazoFormatoLargEdit);
        formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
    }

    public void onRowCancelP7(RowEditEvent event) {
    }

    //// funciones tabP8
    public String registraP8() {
        return "";
    }

    /// funciones tabP9
    public String registraP9() {
        return "";
    }

    /// funciones tabP10
    public String agregarP10() {
        controlGrabarP10 = true;
        return "";
    }

    public void registraP10() {
        try {
            if (diagnosticoProblema.getSdpId() == null) {
                diagnosticoProblema.setSflId(formatoLargo);
                diagnosProblemfacade.create(diagnosticoProblema);
            } else {
                diagnosProblemfacade.edit(diagnosticoProblema);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarP10() {
        if (formatoLargo.getSflId() != null) {
            diagnosticoProblema = diagnosProblemfacade.findDiagnosticoProblemByCodForLarg(formatoLargo.getSflId());
        }
        if (diagnosticoProblema == null) {
            diagnosticoProblema = new SeaDiagnosProblema();
        }
    }

    public SeaDiagnosProblema getDiagnosticoProblema() {
        return diagnosticoProblema;
    }

    public void setDiagnosticoProblema(SeaDiagnosProblema diagnosticoProblema) {
        this.diagnosticoProblema = diagnosticoProblema;
    }

    /// funciones tabP10.1
    public String agregarP101() {
        tablaContenidoSelected = new SeaTablaContenido();
        return "";
    }

    public String registraP101() {
        diagnosticoProblema = diagnosProblemfacade.findDiagnosticoProblemByCodForLarg(formatoLargo.getSflId());
        if (diagnosticoProblema == null) {
            diagnosticoProblema = new SeaDiagnosProblema();
            diagnosticoProblema.setSflId(formatoLargo);
            diagnosProblemfacade.create(diagnosticoProblema);
        }
        if (tablaContenidoSelected.getStcId() == null) {
            tablaContenidoSelected.setSdpId(diagnosticoProblema);
            tablaContenidoFacade.create(tablaContenidoSelected);
        } else {
            tablaContenidoFacade.edit(tablaContenidoSelected);
        }
        cancelarP101();
        return "";
    }

    /*
            tablaContenido.setStcBaseDatos(baseDatos);
            tablaContenido.setStcDenominacion(denominacion);
            tablaContenido.setStcNumeroPatente(patente);
            tablaContenido.setStcOtros(otros);
            tablaContenido.setSdpId(diagnosticoProblema);
     */
    public void cancelarP101() {
        tablaContenidoSelected = null;
    }

    public void eliminarP101() {
        /*Integer registro = 0;
        if (tablaContenidoSelected != null) {
            SeaTablaContenido eliminar = null;
            for (int i = 0; i < tablaContenidoList.size(); i++) {
                SeaTablaContenido elemento = this.tablaContenidoList.get(i);
                if (tablaContenidoSelected.getStcId() == tablaContenidoList.get(i).getStcId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar" + eliminar);
            if (eliminar != null) {
                this.tablaContenidoList.remove(eliminar);
                tablaContenidoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }*/

        try {
            tablaContenidoFacade.remove(tablaContenidoSelected);
            tablaContenidoSelected = null;
            diagnosticoProblema = diagnosProblemfacade.findDiagnosticoProblemByCodForLarg(formatoLargo.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    /// funciones tabP102
    public SeaAnalisisFormato getAnalisisFormato() {
        return analisisFormato;
    }

    public void setAnalisisFormato(SeaAnalisisFormato analisisFormato) {
        this.analisisFormato = analisisFormato;
    }

    public String registraP102() {
        /*if (analisisFormato == null) {
            System.out.println("ingresa registro");
            analisisFormato = new SeaAnalisisFormato();
            analisisFormato.setSafAnalisisCompara(analisisComparativo);
            analisisFormato.setSafNumHombresD(new BigInteger(numDirectoHombres));
            analisisFormato.setSafNumMujeresD(new BigInteger(numDirectoMujeres));
            analisisFormato.setSafTotalNumDirectos(new BigInteger(totalNumDirect));
            analisisFormato.setSafTotalNumIndirecto(new BigInteger(totalNumIndirect));
            analisisFormato.setSafNumCapacEspeciales(new BigInteger(personaCapacEspec));
            analisisFormato.setSafNumDocTotal(new BigInteger(numDocentesPartic));
            analisisFormato.setSafNumDocHombres(new BigInteger(docentesParticiHombres));
            analisisFormato.setSafNumDocMujeres(new BigInteger(docentesParticiMujeres));
            analisisFormato.setSafNumEstTotal(new BigInteger(numEstidiantParticipant));
            analisisFormato.setSafNumEstHombres(new BigInteger(estudiantParticHombres));
            analisisFormato.setSafNumEstMujeres(new BigInteger(estudiantParticiMujeres));
            analisisFormato.setSafFactoresCExito(factorCriticoExito);
            analisisFormato.setSafResticcionesSupuesto(restriccionSupuesto);
            analisisFormato.setSflId(formatoLargo);
            analisisFormatoFacade.create(analisisFormato);
            RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        }
        cancelarP102();
        return "";
        -*/
        analisisFormato.setSafNumDocTotal(analisisFormato.getTotalDocentes());
        analisisFormato.setSafNumEstTotal(analisisFormato.getTotalEstudiantes());
        analisisFormato.setSafTotalNumDirectos(analisisFormato.getTotalDirectos());
        if (analisisFormato.getSafId() == null) {
            analisisFormato.setSflId(formatoLargo);
            analisisFormatoFacade.create(analisisFormato);
        } else {
            analisisFormatoFacade.edit(analisisFormato);
        }
        cancelarP102();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    public void cancelarP102() {
        analisisFormato = analisisFormatoFacade.findAnalisiFormatoByCodForml(formatoLargo.getSflId());

    }

    public boolean validarVaciosP102() {
        validaVaciosP102 = false;
        return validaVaciosP102;
    }
    /// funciones tabP11

    public String agregarP11() {
        controlGrabarP11 = true;
        objProyPadreSelected = null;
        objProySelected = new ObjetivoProyecto();
        return "";
    }

    public String agregarObjetivoEsp() {
        objProySelected = new ObjetivoProyecto();
        //objProySelected.setSztaobjproyPadre(objProyPadreSelected);
        objProySelected.setProyecto(formatoLargo);
        objProySelected.setTipo(new SeaParametrosDet(new Long(304)));
        controlGrabarP11 = true;
        return "";
    }

    public String agregarObjHijo() {
        objProySelected = new ObjetivoProyecto();
        objProySelected.setObjetivoPadre(objProyPadreSelected);
        if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(304))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(308)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(302)) || objProyPadreSelected.getTipo().getPrdId().equals(new Long(303)) || objProyPadreSelected.getTipo().getPrdId().equals(new Long(308))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(305)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(305))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(306)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(306))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(307)));
        }

        controlGrabarP11 = true;
        return "";
    }

    public String agregarObjHijoEsp() {
        objProySelected = new ObjetivoProyecto();
        objProySelected.setObjetivoPadre(objProyPadreSelected);
        if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(304))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(305)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(305))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(306)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(306))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(307)));
        } else if (objProyPadreSelected.getTipo().getPrdId().equals(new Long(308))) {
            objProySelected.setTipo(new SeaParametrosDet(new Long(305)));
        }

        controlGrabarP11 = true;
        return "";
    }

    public String registraP11() {
        szObjProyFacade.create(objProySelected);
        szObjProyList = szObjProyFacade.findObjProyByCodFormL(formatoLargo.getSflId());
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarP11();
        return "";
    }

    public void cancelarP11() {
        controlGrabarP11 = false;
        objProyecto = "";
        objProySelected = null;
        validaVaciosP11 = true;
    }

    public boolean validarVaciosP11() {
        validaVaciosP11 = false;
        objProyecto = objProyecto.trim();
//        descripObj = descripObj.trim();
        if (objProyecto.isEmpty()) {
            validaVaciosP11 = true;
        }
//        if(descripObj.isEmpty()) validaVaciosP11 = true;
        return validaVaciosP11;
    }

    public boolean validarVaciosIndP11() {
        validaVaciosP11 = false;
        if (objProySelected.getDescripcion() == null || objProySelected.getDescripcion().isEmpty()) {
            validaVaciosP11 = true;
        }
        return validaVaciosP11;
    }

    public void onRowCancelObjP11(RowEditEvent event) {
    }

    public void onRowEditObjP11(RowEditEvent event) {
        ObjetivoProyecto objProyEdit = new ObjetivoProyecto();
        objProyEdit = (ObjetivoProyecto) event.getObject();
        szObjProyFacade.edit(objProyEdit);
    }

    public void onRowCancelIndP11(RowEditEvent event) {
    }

    public void onRowEditIndP11(RowEditEvent event) {
        ObjetivoProyecto indObjProyEdit = new ObjetivoProyecto();
        indObjProyEdit = (ObjetivoProyecto) event.getObject();
        szObjProyFacade.edit(indObjProyEdit);
    }

    public void onRowCancelMedP11(RowEditEvent event) {
    }

    public void onRowEditMedP11(RowEditEvent event) {
        ObjetivoProyecto medObjProyEdit = new ObjetivoProyecto();
        medObjProyEdit = (ObjetivoProyecto) event.getObject();
        szObjProyFacade.edit(medObjProyEdit);
    }

    public void onRowCancelSupP11(RowEditEvent event) {
    }

    public void onRowEditSupP11(RowEditEvent event) {
        ObjetivoProyecto supObjProyEdit = new ObjetivoProyecto();
        supObjProyEdit = (ObjetivoProyecto) event.getObject();
        szObjProyFacade.edit(supObjProyEdit);
    }

    public void onRowCancelSupActP11(RowEditEvent event) {
    }

    public void onRowEditSupActP11(RowEditEvent event) {
        ObjetivoProyecto supActObjProyEdit = new ObjetivoProyecto();
        supActObjProyEdit = (ObjetivoProyecto) event.getObject();
        szObjProyFacade.edit(supActObjProyEdit);
    }

    public void eliminarSupDos() {
        szObjProyFacade.remove(objProySelected);
        szObjProyList = szObjProyFacade.findObjProyByCodFormL(formatoLargo.getSflId());
    }

//// funciones tabP12
    public String agregarP12() {
        controlGrabarP12 = true;
        return "";
    }

    public void nuevoEntregable() {
        objEntregableSelected = new SeaObjEntregables();
    }

    public String registraP12() {
        /*parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(bienServ));

        if (objEntregables.getSoeId() == null) {
            objEntregables.setPrdId(parametrosDetalle);
            objEntregables.setSflId(formatoLargo);
            objEntregables.setSoeDescripcion(detEntr);
            objEntregablesFacade.create(objEntregables);
            //objEntregabList = objEntregablesFacade.findEntregableByCodProy(formatoLargo.getSflId());
            RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        }
        cancelarP12();
        return "";
         */
        if (objEntregableSelected.getSoeId() == null) {
            objEntregableSelected.setSflId(formatoLargo);
            objEntregablesFacade.create(objEntregableSelected);
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')"); 
        } else {
            objEntregablesFacade.edit(objEntregableSelected);
        }
        objEntregableSelected = null;
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarP12();
        return "";
    }

    public void cancelarP12() {
        controlGrabarP12 = false;
        objFormato = "";
        bienServ = "";
        detEntr = "";
        objEntregableSelected = null;
        validaVaciosP12 = true;
    }

    public boolean validarVaciosP12() {
        validaVaciosP12 = false;
        bienServ = bienServ.trim();
        detEntr = detEntr.trim();
        if (bienServ.isEmpty()) {
            validaVaciosP12 = true;
        }
        if (detEntr.isEmpty()) {
            validaVaciosP12 = true;
        }
        return validaVaciosP12;
    }

    public void eliminarP12() {
        /*Integer registro = 0;
        if (objEntregableSelected != null) {
            SeaObjEntregables eliminar = null;
            for (int i = 0; i < objEntregabList.size(); i++) {
                SeaObjEntregables elemento = this.objEntregabList.get(i);
                if (objEntregableSelected.getSoeId() == objEntregabList.get(i).getSoeId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                this.objEntregabList.remove(eliminar);
                objEntregablesFacade.remove(eliminar);
                MensajeController m = null;
            }
        }*/
        objEntregablesFacade.remove(objEntregableSelected);
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
    }

    public void onRowEditP12(RowEditEvent event) {
        SeaObjEntregables objEntregablEdit = new SeaObjEntregables();
        objEntregablEdit = (SeaObjEntregables) event.getObject();

        parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(bienServEdit));

        objetivosFormato = new SeaObjetivosFormato();
        objetivosFormato.setSofId(new BigDecimal(objFormatoEdit));

        objEntregablEdit.setPrdId(parametrosDetalle);
        objEntregablEdit.setSoeDescripcion(detEntr);
        objEntregablesFacade.edit(objEntregablEdit);
    }

    public void onRowCancelP12(RowEditEvent event) {
    }

    //// funciones tabP13
    public String agregarP13() {
        controlGrabarP13 = true;
        return "";
    }

    public void registraP13() {
        if (!objAdquisisioneSelected.getSoaNacional().equals(BigDecimal.ZERO)
                && (objAdquisisioneSelected.getSoaDestalleNacional() == null || objAdquisisioneSelected.getSoaDestalleNacional().isEmpty())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar el detalle de insumo nacional"));
            return;
        }
        if (!objAdquisisioneSelected.getSoaImportado().equals(BigDecimal.ZERO)
                && (objAdquisisioneSelected.getSoaDetalleImportado() == null || objAdquisisioneSelected.getSoaDetalleImportado().isEmpty())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar el detalle de insumo importado"));
            return;
        }
        BigDecimal total = BigDecimal.ZERO;
        total = total.add(objAdquisisioneSelected.getSoaImportado()).add(objAdquisisioneSelected.getSoaNacional());
        if (total.compareTo(new BigDecimal(100)) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El total del %Nacional + %Importado no debe pasar del 100%"));
            return;
        }

        if (objAdquisisioneSelected.getSoaId() == null) {
            objAdquisisioneSelected.setSoeId(objEntregableSelected);
            objAdquisisionesFacade.create(objAdquisisioneSelected);
        } else {
            objAdquisisionesFacade.edit(objAdquisisioneSelected);
        }
        objEntregableSelected = null;
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
        RequestContext.getCurrentInstance().execute("PF('dialogAdquisiciones').hide();");
        cancelarP13();
    }

    public void nuevoAdquisicion() {
        objAdquisisioneSelected = new SeaObjAdquisisiones();
    }

    public void cancelarP13() {
        controlGrabarP13 = false;
        bienesServicios = "";
        porcentNac = "";
        porcentImp = "";
        detalleInsNac = "";
        detalleInsImp = "";
        objetivoFormato = "";
        validaVaciosP13 = true;

    }

    public boolean validarVaciosP13() {
        validaVaciosP13 = false;
        bienesServicios = bienesServicios.trim();
        porcentNac = porcentNac.trim();
        porcentImp = porcentImp.trim();
        detalleInsNac = detalleInsNac.trim();
        detalleInsImp = detalleInsImp.trim();
        objetivoFormato = objetivoFormato.trim();
        if (bienesServicios.isEmpty()) {
            validaVaciosP13 = true;
        }
        if (porcentNac.isEmpty()) {
            validaVaciosP13 = true;
        }
        if (porcentImp.isEmpty()) {
            validaVaciosP13 = true;
        }
        if (detalleInsNac.isEmpty()) {
            validaVaciosP13 = true;
        }
        if (detalleInsImp.isEmpty()) {
            validaVaciosP13 = true;
        }
        if (objetivoFormato.isEmpty()) {
            validaVaciosP13 = true;
        }
        return validaVaciosP13;
    }

    public void eliminarP13() {
        objAdquisisionesFacade.remove(objAdquisisioneSelected);
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
    }

    public void onRowEditP13(RowEditEvent event) {
        SeaObjAdquisisiones objAdquiEdit = new SeaObjAdquisisiones();
        objAdquiEdit = (SeaObjAdquisisiones) event.getObject();
        objAdquiEdit.setSoaDestalleNacional(detalleInsNac);
        objAdquiEdit.setSoaDetalleImportado(detalleInsImp);
        objAdquiEdit.setSoaNacional(new BigDecimal(porcentNac));
        objAdquiEdit.setSoaImportado(new BigDecimal(porcentImp));
        objAdquisisionesFacade.edit(objAdquiEdit);

    }

    public void onRowCancelP13(RowEditEvent event) {
    }

    public void onRowToggleDetEntregable(ToggleEvent event) {
        SeaObjEntregables objEntr = new SeaObjEntregables();
        objEntr = (SeaObjEntregables) event.getData();
        if (objEntr != null) {
            objAdquisisionList = objAdquisisionesFacade.findObjAdquisicionesByCodEntr(objEntr.getSoeId());
        }
    }

    /// funciones tabP14
    public String agregarP14() {
        controlGrabarP14 = true;
        return "";
    }

    public String registraP14() {
        parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(categoriaProyecto));

        if (formatoLargo.getPrdIdCategoria() != null) {
            //RequestContext.getCurrentInstance().execute("alert('El Proyecto ya tiene asignado una Categoria')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Proyecto ya tiene asignado una Categoria."));
            cancelarP14();
            return "";
        } else {
            formatoLargo.setPrdIdCategoria(parametrosDetalle);
            formatoLargoFacade.edit(formatoLargo);
            formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }
        cancelarP14();
        return "";
    }

    public void cancelarP14() {
        controlGrabarP14 = false;
        categoriaProyecto = "";
        validaVaciosP14 = true;
    }

    public boolean validarVaciosP14() {
        validaVaciosP14 = false;
        categoriaProyecto = categoriaProyecto.trim();
        if (categoriaProyecto.isEmpty()) {
            validaVaciosP14 = true;
        }
        return validaVaciosP14;
    }

    public void eliminarP14() {
        /*Integer registro = 0;
       if(categorizacionFormatoSelected != null){
           SeaFormatoLargo eliminar = null;
           for(int i=0; i< formatoLagoList.size();i++){
              SeaFormatoLargo elemento = this.formatoLagoList.get(i);
              if(categorizacionFormatoSelected.getSflId() == formatoLagoList.get(i).getSflId()){
                  eliminar = elemento;
                  break;
              }
           }
           System.out.println("eliminar "+ eliminar);
           if(eliminar != null){
               this.formatoLagoList.remove(eliminar);
               formatoLargoFacade.remove(eliminar);
               MensajeController em = null;
           }
       }*/
    }

    public void onRowEditP14(RowEditEvent event) {
        SeaFormatoLargo categFormatoEdit = new SeaFormatoLargo();
        categFormatoEdit = (SeaFormatoLargo) event.getObject();

        parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(categoriaProyectoEdit));
        System.out.flush();

        categFormatoEdit.setPrdIdCategoria(parametrosDetalle);
        formatoLargoFacade.edit(categFormatoEdit);
        formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
    }

    public void onRowCancelP14(RowEditEvent event) {
    }

    /// funciones tabP15
    public void registraP15() {
        try {
            formatoLargoFacade.edit(formatoLargo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    public void cancelarP15() {
        formatoLargo = formatoLargoFacade.find(formatoLargo.getSflId());
    }

    /// funciones tabP16
    public boolean validarVaciosP16() {
        validaVaciosP16 = false;
        viabilidadTecn = viabilidadTecn.trim();
        equipaTecnol = equipaTecnol.trim();
        perderPais = perderPais.trim();
        impactoEsper = impactoEsper.trim();
        disponeMetodologia = disponeMetodologia.trim();
        impactoAmbiental = impactoAmbiental.trim();
        sostenibiSocial = sostenibiSocial.trim();
        transferTecnol = transferTecnol.trim();
        artiCientif = artiCientif.trim();
        prototip = prototip.trim();
        regPropIntel = regPropIntel.trim();
        spinOff = spinOff.trim();
        otrosViabilidad = otrosViabilidad.trim();
        if (viabilidadTecn.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (equipaTecnol.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (perderPais.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (impactoEsper.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (disponeMetodologia.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (impactoAmbiental.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (sostenibiSocial.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (transferTecnol.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (artiCientif.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (prototip.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (regPropIntel.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (spinOff.isEmpty()) {
            validaVaciosP16 = true;
        }
        if (otrosViabilidad.isEmpty()) {
            validaVaciosP16 = true;
        }
        return validaVaciosP16;
    }

    public String registraP16() {
        if (formatoViabilidad == null) {
            System.out.println("ingresa registro");
            formatoViabilidad = new SeaFormatoViabilidad();
            formatoViabilidad.setSfaViavilidadTec(viabilidadTecn);
            formatoViabilidad.setSfaEquipamientoTec(equipaTecnol);
            formatoViabilidad.setSfaPerderPais(perderPais);
            formatoViabilidad.setSfaImpactosEsperados(impactoEsper);
            formatoViabilidad.setSfaDisponeMetodologia(disponeMetodologia);
            formatoViabilidad.setSfaImpactoAmbiental(impactoAmbiental);
            formatoViabilidad.setSfaSostenibilidadSocial(sostenibiSocial);
            formatoViabilidad.setSfaTranferenciaTecno(transferTecnol);
            formatoViabilidad.setSfaArticulosCientificos(artiCientif);
            formatoViabilidad.setSfaPrototipos(prototip);
            formatoViabilidad.setSfaPropiedadIntelecto(regPropIntel);
            formatoViabilidad.setSfaEmpresaSpin(spinOff);
            formatoViabilidad.setSfaOtros(otrosViabilidad);
            formatoViabilidad.setSflId(formatoLargo);
            formatoViabilidadFacade.create(formatoViabilidad);
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')"); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }

        cancelarP16();
        return "";
    }

    public void cancelarP16() {
        controlGrabarP16 = false;
        viabilidadTecn = "";
        equipaTecnol = "";
        perderPais = "";
        impactoEsper = "";
        disponeMetodologia = "";
        impactoAmbiental = "";
        sostenibiSocial = "";
        transferTecnol = "";
        artiCientif = "";
        prototip = "";
        regPropIntel = "";
        spinOff = "";
        otrosViabilidad = "";
        validaVaciosP16 = true;
    }
    /// funciones tabP17

    public String agregarP17() {
        controlGrabarP17 = true;
        return "";
    }

    public String registraP17() {
        if (notaConceptual != null && formatoEstrategia == null) {
            System.out.println("ingresa registro");
            formatoEstrategia = new SeaFormatoEstrategiae();
            formatoEstrategia.setSfeNombreArchivo(nomFile1);
            formatoEstrategia.setSfeArchivoDigital(file1);
            formatoEstrategia.setSflId(formatoLargo);
            formatoEstrategiaFacade.create(formatoEstrategia);
            formatoEstrategiaList = formatoEstrategiaFacade.findFormatoEntregableByCodFormL(notaConceptual.getDatgeproyId());
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }
        cancelarP17();
        return "";
    }

    public void cancelarP17() {
        controlGrabarP17 = false;
        nomFile1 = "";
        validaVaciosP17 = true;
    }
    /// cargar archivo

    public void handFileUpload(FileUploadEvent event) throws IOException {
        nomFile1 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile1(IOUtils.toByteArray(is));
        System.out.println("nomfile  " + nomFile1);
        validarVaciosP17();
    }

    public boolean validarVaciosP17() {
        validaVaciosP17 = false;
        nomFile1 = nomFile1.trim();
        if (nomFile1.isEmpty()) {
            validaVaciosP17 = true;
        }
        return validaVaciosP17;
    }

    public void eliminarP17() {
        Integer registro = 0;
        if (formatoEstrategiaSelected != null) {
            SeaFormatoEstrategiae eliminar = null;
            for (int i = 0; i < formatoEstrategiaList.size(); i++) {
                SeaFormatoEstrategiae elemento = this.formatoEstrategiaList.get(i);
                if (formatoEstrategiaSelected.getSfeId() == formatoEstrategiaList.get(i).getSfeId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                this.formatoEstrategiaList.remove(eliminar);
                formatoEstrategiaFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP17(RowEditEvent event) {
        SeaFormatoEstrategiae formatoEstratEdit = new SeaFormatoEstrategiae();
        formatoEstratEdit = (SeaFormatoEstrategiae) event.getObject();
        formatoEstrategiaFacade.edit(formatoEstratEdit);
    }

    public void onRowCancelP17(RowEditEvent event) {
    }

    //// funciones tabP18
    public String agregarP18() {
        controlGrabarP18 = true;
        return "";
    }

    public String registraP18() {
        if (notaConceptual != null && formatoSeguimiento == null) {
            System.out.println("ingresa registro");
            formatoSeguimiento = new SeaFormatoSeguimiento();
            formatoSeguimiento.setSflId(formatoLargo);
            //formatoSeguimiento.setSfsMes(mesSeguimiento);
            formatoSeguimiento.setSfsFechaInicio(fechaInicioHitos);
            formatoSeguimiento.setSfsFechaFin(fechaFinalHitos);
            formatoSeguimiento.setSfsDescripcionHito(descripcionHito);
            formatoSeguimiento.setSfsPresupuesto(new BigDecimal(presupuestoSegE));
            formatoSeguimientoFacade.create(formatoSeguimiento);
        }
        formatoSeguimientoList = formatoSeguimientoFacade.findEstraSeguiEvaByCodForL(formatoLargo.getSflId());
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarP18();
        return "";
    }

    public void cancelarP18() {
        controlGrabarP18 = false;
        mesSeguimiento = "";
        descripcionHito = "";
        presupuestoSegE = "";
        fechaInicioHitos = null;
        fechaFinalHitos = null;
        fechInicHitos = "";
        fechFinHitos = "";
        formatoSeguimiento = null;
        validaVaciosP18 = true;
    }

    public boolean validarVaciosP18() {
        validaVaciosP18 = false;
        //mesSeguimiento = mesSeguimiento.trim();
        if (fechaInicioHitos != null) {
            fechInicHitos = fechaInicioHitos.toString();
            fechInicHitos = fechInicHitos.trim();
        }
        if (fechaFinalHitos != null) {
            fechFinHitos = fechaFinalHitos.toString();
            fechFinHitos = fechFinHitos.trim();
        }
        descripcionHito = descripcionHito.trim();
        presupuestoSegE = presupuestoSegE.trim();

//       if(mesSeguimiento.isEmpty()) validaVaciosP18 = true;       
        if (fechInicHitos.isEmpty()) {
            validaVaciosP18 = true;
        }
        if (fechFinHitos.isEmpty()) {
            validaVaciosP18 = true;
        }
        if (descripcionHito.isEmpty()) {
            validaVaciosP18 = true;
        }
        if (presupuestoSegE.isEmpty()) {
            validaVaciosP18 = true;
        }
        return validaVaciosP18;
    }

    public void eliminarP18() {
        Integer registro = 0;
        if (formatoSeguimientoSelected != null) {
            SeaFormatoSeguimiento eliminar = null;
            for (int i = 0; i < formatoSeguimientoList.size(); i++) {
                SeaFormatoSeguimiento elemento = this.formatoSeguimientoList.get(i);
                if (formatoSeguimientoSelected.getSfsId() == formatoSeguimientoList.get(i).getSfsId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                this.formatoSeguimientoList.remove(eliminar);
                formatoSeguimientoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP18(RowEditEvent event) {
        SeaFormatoSeguimiento formatoSeguimientoEdit = new SeaFormatoSeguimiento();
        formatoSeguimientoEdit = (SeaFormatoSeguimiento) event.getObject();
        formatoSeguimientoFacade.edit(formatoSeguimientoEdit);
    }

    public void onRowCancelP18(RowEditEvent event) {
    }

    ///funciones tabP19
    public String agregarP19() {
        controlGrabarP19 = true;
        return "";
    }

    public String registraP19() {
        if (notaConceptual != null && fdifusionEvento == null) {
            fdifusionEvento = new SeaFdifusionEvento();
            System.out.println("ingresa registro");
            fdifusionEvento.setSflId(formatoLargo);
            fdifusionEvento.setSfdeDescripcion(fdescripcion);
            fdifusionEventoFacade.create(fdifusionEvento);
            fdifusionEveantoList = fdifusionEventoFacade.findDifusionEventeByCodFormL(formatoLargo.getSflId());
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }
        cancelarP19();
        return "";
    }

    public void cancelarP19() {
        controlGrabarP19 = false;
        fdescripcion = "";
        fdifusionEvento = null;
        validaVaciosP19 = true;
    }

    public boolean validarVaciosP19() {
        validaVaciosP19 = false;
        fdescripcion = fdescripcion.trim();
        if (fdescripcion.isEmpty()) {
            validaVaciosP19 = true;
        }
        return validaVaciosP19;
    }

    public void eliminarP19() {
        if (fdifusionEventoSelected != null) {
            SeaFdifusionEvento eliminar = null;
            for (int i = 0; i < fdifusionEveantoList.size(); i++) {
                SeaFdifusionEvento elemento = this.fdifusionEveantoList.get(i);
                if (fdifusionEventoSelected.getSfdeId() == fdifusionEveantoList.get(i).getSfdeId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                this.fdifusionEveantoList.remove(eliminar);
                fdifusionEventoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP19(RowEditEvent event) {
        SeaFdifusionEvento fdifusionEventoEdit = new SeaFdifusionEvento();
        fdifusionEventoEdit = (SeaFdifusionEvento) event.getObject();
        fdifusionEventoFacade.edit(fdifusionEventoEdit);

    }

    public void onRowCancelP19(RowEditEvent event) {
    }

    public void onRowToggleTipoEvento(ToggleEvent event) {
        SeaFdifusionEvento difEvento = new SeaFdifusionEvento();
        difEvento = (SeaFdifusionEvento) event.getData();
        if (difEvento != null) {
            formatoDifusionList = formatoDifusionFacade.findFormatoDifuByCodFDif(difEvento.getSfdeId());
        }
    }

    ///funciones tabP20
    public String agregarP20() {
        controlGrabarP20 = true;
        return "";
    }

    public String registraP20() {
        if (notaConceptual != null && formatoDifusion == null) {
            System.out.println("ingresa registro");
            formatoDifusion = new SeaFormatoDifusion();
            formatoDifusion.setSfdActividad(actividad);
            formatoDifusion.setSfdCosto(new BigDecimal(costo));
            formatoDifusion.setSfdeId(fdifusionEventoSelected);
            formatoDifusionFacade.create(formatoDifusion);
            formatoDifusionList = formatoDifusionFacade.findAll();
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }
        cancelarP20();
        return "";
    }

    public void cancelarP20() {
        controlGrabarP20 = false;
        formatoDifusion = null;
        actividad = "";
        costo = "";
        validaVaciosP20 = true;
    }

    public boolean validarVaciosP20() {
        validaVaciosP20 = false;
        actividad = actividad.trim();
        costo = costo.trim();
        if (actividad.isEmpty()) {
            validaVaciosP20 = true;
        }
        if (costo.isEmpty()) {
            validaVaciosP20 = true;
        }
        return validaVaciosP20;
    }

    public void eliminarP20() {
        if (formatoDifusionSelected != null) {
            SeaFormatoDifusion eliminar = null;
            for (int i = 0; i < formatoDifusionList.size(); i++) {
                SeaFormatoDifusion elemento = this.formatoDifusionList.get(i);
                if (formatoDifusionSelected.getSfdId() == formatoDifusionList.get(i).getSfdId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                this.formatoDifusionList.remove(eliminar);
                formatoDifusionFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP20(RowEditEvent event) {
        SeaFormatoDifusion formatoDifusEdit = new SeaFormatoDifusion();
        formatoDifusEdit = (SeaFormatoDifusion) event.getObject();
        formatoDifusionFacade.edit(formatoDifusEdit);
        System.out.flush();
        formatoDifusionList = formatoDifusionFacade.findAll();
    }

    public void onRowCancelP20(RowEditEvent event) {
    }

    //// funciones tabP20
    public String agregarP21() {
        controlGrabarP21 = true;
        return "";
    }

    public String registraP21() {
        if (notaConceptual != null && formatoBibliografia == null) {
            System.out.println("ingresa registro");
            formatoBibliografia = new SeaFormatoBibliografia();
            formatoBibliografia.setSfbAutor(autor);
            formatoBibliografia.setSfbTitulo(titulo);
            formatoBibliografia.setSfbEdicion(edicion);
            formatoBibliografia.setSfbAnio(anio);
            formatoBibliografia.setSfbEditorial(editorial);
            formatoBibliografia.setSfbIdioma(idioma);
            formatoBibliografia.setSfbNumpag(numPag);
            formatoBibliografia.setSfbUrl(url);
            formatoBibliografia.setSfbObservacion(obserBiblio);
            formatoBibliografia.setSflId(formatoLargo);
            formatoBibliografiaFacade.create(formatoBibliografia);
            formatoBibliografiaList = formatoBibliografiaFacade.findFormatoBiblioByCodFormL(formatoLargo.getSflId());
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        }
        cancelarP21();
        return "";
    }

    public void cancelarP21() {
        controlGrabarP21 = false;
        autor = "";
        titulo = "";
        edicion = "";
        anio = "";
        editorial = "";
        idioma = "";
        numPag = "";
        url = "";
        obserBiblio = "";
        formatoBibliografia = null;
        validaVaciosP21 = true;
    }

    public boolean validarVaciosP21() {
        validaVaciosP21 = false;
        autor = autor.trim();
        titulo = titulo.trim();
        edicion = edicion.trim();
        anio = anio.trim();
        editorial = editorial.trim();
        idioma = idioma.trim();
        numPag = numPag.trim();
        url = url.trim();
        obserBiblio = obserBiblio.trim();
        if (autor.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (titulo.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (edicion.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (anio.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (editorial.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (idioma.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (numPag.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (url.isEmpty()) {
            validaVaciosP21 = true;
        }
        if (obserBiblio.isEmpty()) {
            validaVaciosP21 = true;
        }
        return validaVaciosP21;
    }

    public void eliminarP21() {
        Integer registro = 0;
        if (formatoBibliografiaSelected != null) {
            SeaFormatoBibliografia eliminar = null;
            for (int i = 0; i < formatoBibliografiaList.size(); i++) {
                SeaFormatoBibliografia elemento = this.formatoBibliografiaList.get(i);
                if (formatoBibliografiaSelected.getSfbId() == formatoBibliografiaList.get(i).getSfbId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar  " + eliminar);
            if (eliminar != null) {
                this.formatoBibliografiaList.remove(eliminar);
                formatoBibliografiaFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP21(RowEditEvent event) {
        SeaFormatoBibliografia formatoBiblioEdit = new SeaFormatoBibliografia();
        formatoBiblioEdit = (SeaFormatoBibliografia) event.getObject();
        formatoBibliografiaFacade.edit(formatoBiblioEdit);

    }

    public void onRowCancelP21(RowEditEvent event) {
    }
    //// funciones tabP23

    public String agregarP23() {
        controlGrabarP23 = true;
        return "";
    }

    public String registraP23() {

        System.out.println("Actualiza registro");
        formatoLargo = formatoLargoFacade.findIdFormatoByCodPro(notaConceptual.getDatgeproyId());
        formatoLargo.setSflNombreFinan(nomFile2);
        formatoLargo.setSflDigiFinan(file22);
        formatoLargoFacade.edit(formatoLargo);

        formatoLagoList = formatoLargoFacade.findFormatoByCodPro(notaConceptual.getDatgeproyId());
        //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarP23();
        return "";
    }

    public void cancelarP23() {
        controlGrabarP23 = false;
        nomFile2 = "";
        validaVaciosP23 = true;
    }

    public boolean validarVaciosP23() {
        validaVaciosP23 = false;
        nomFile2 = nomFile2.trim();
        if (nomFile2.isEmpty()) {
            validaVaciosP23 = true;
        }
        return validaVaciosP23;
    }
    /// cargar archivo

    public void handFileUploadFinancia(FileUploadEvent event) throws IOException {
        nomFile2 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile22(IOUtils.toByteArray(is));
        validarVaciosP23();
    }
    /// funciones tabP24

    public void generaReporteFormatoLargo() throws SQLException, JRException {
        idUsuario = notaConceptual.getUsuId().getUsuId();
        vDocenteDeptoB = vDocenteDeptoBFacade.findCodDeptoByUsuId(idUsuario);
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/proyecto_largo");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/proyecto_largo.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", notaConceptual.getDatgeproyId().toString());
        parametros.put("SFL_ID", formatoLargo.getSflId().toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        exporter.exportReport();
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        controlPDF = true;

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public String getNomDepCentro() {
        return nomDepCentro;
    }

    public void setNomDepCentro(String nomDepCentro) {
        this.nomDepCentro = nomDepCentro;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getProgPost() {
        return progPost;
    }

    public void setProgPost(String progPost) {
        this.progPost = progPost;
    }

    public String getNumConvoca() {
        return numConvoca;
    }

    public void setNumConvoca(String numConvoca) {
        this.numConvoca = numConvoca;
    }

    public String getNomPrograma() {
        return nomPrograma;
    }

    public void setNomPrograma(String nomPrograma) {
        this.nomPrograma = nomPrograma;
    }

    public String getGrupInvest() {
        return grupInvest;
    }

    public void setGrupInvest(String grupInvest) {
        this.grupInvest = grupInvest;
    }

    public String getLineaInvest() {
        return lineaInvest;
    }

    public void setLineaInvest(String lineaInvest) {
        this.lineaInvest = lineaInvest;
    }

    public String getSublInvest() {
        return sublInvest;
    }

    public void setSublInvest(String sublInvest) {
        this.sublInvest = sublInvest;
    }

    public String getTipoInvest() {
        return tipoInvest;
    }

    public void setTipoInvest(String tipoInvest) {
        this.tipoInvest = tipoInvest;
    }

    public List<SeaDepcenproy> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<SeaDepcenproy> departamentosList) {
        this.departamentosList = departamentosList;
    }

    //// get and set P2
    public List<Object> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<Object> coberturaList) {
        this.coberturaList = coberturaList;
    }

    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    /// get and set tabP3
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

    public List<SeaObplanbv> getObjetivoBuenVivirList() {
        return objetivoBuenVivirList;
    }

    public void setObjetivoBuenVivirList(List<SeaObplanbv> objetivoBuenVivirList) {
        this.objetivoBuenVivirList = objetivoBuenVivirList;
    }

    public List<SeaFormatoLargo> getFormatoLagoList() {
        return formatoLagoList;
    }

    public void setFormatoLagoList(List<SeaFormatoLargo> formatoLagoList) {
        this.formatoLagoList = formatoLagoList;
    }

    public Sztaobjbvpr getObjetivoBuenVivirProyectoSelected() {
        return objetivoBuenVivirProyectoSelected;
    }

    public void setObjetivoBuenVivirProyectoSelected(Sztaobjbvpr objetivoBuenVivirProyectoSelected) {
        this.objetivoBuenVivirProyectoSelected = objetivoBuenVivirProyectoSelected;
    }

    public boolean isValidaVaciosP31() {
        return validaVaciosP31;
    }

    public void setValidaVaciosP31(boolean validaVaciosP31) {
        this.validaVaciosP31 = validaVaciosP31;
    }

    public Sztapolobjbv getPoliticaObjBuenVivirSelected() {
        return politicaObjBuenVivirSelected;
    }

    public void setPoliticaObjBuenVivirSelected(Sztapolobjbv politicaObjBuenVivirSelected) {
        this.politicaObjBuenVivirSelected = politicaObjBuenVivirSelected;
    }

    /// get and set P4
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

    public List<Stvtops> getAreaEspeList() {
        return areaEspeList;
    }

    public void setAreaEspeList(List<Stvtops> areaEspeList) {
        this.areaEspeList = areaEspeList;
    }

    public String getAreaConocimientoEspe() {
        return areaConocimientoEspe;
    }

    public void setAreaConocimientoEspe(String areaConocimientoEspe) {
        this.areaConocimientoEspe = areaConocimientoEspe;
    }

    public List<SeaAreacUnesco> getAreaUnescoList() {
        return areaUnescoList;
    }

    public void setAreaUnescoList(List<SeaAreacUnesco> areaUnescoList) {
        this.areaUnescoList = areaUnescoList;
    }

    public String getAreaConocimientoUnesco() {
        return areaConocimientoUnesco;
    }

    public void setAreaConocimientoUnesco(String areaConocimientoUnesco) {
        this.areaConocimientoUnesco = areaConocimientoUnesco;
    }

    public String getAreaEspEdit() {
        return areaEspEdit;
    }

    public void setAreaEspEdit(String areaEspEdit) {
        this.areaEspEdit = areaEspEdit;
    }

    public String getAreaUnescoEdit() {
        return areaUnescoEdit;
    }

    public void setAreaUnescoEdit(String areaUnescoEdit) {
        this.areaUnescoEdit = areaUnescoEdit;
    }

    //// get and set tabP5
    public SeaOpcionInstitucionFacade getOpcInstFacade() {
        return opcInstFacade;
    }

    public void setOpcInstFacade(SeaOpcionInstitucionFacade opcInstFacade) {
        this.opcInstFacade = opcInstFacade;
    }

    public boolean isValidaVaciosP5() {
        return validaVaciosP5;
    }

    public void setValidaVaciosP5(boolean validaVaciosP5) {
        this.validaVaciosP5 = validaVaciosP5;
    }

    public boolean isControlGrabarP5() {
        return controlGrabarP5;
    }

    public void setControlGrabarP5(boolean controlGrabarP5) {
        this.controlGrabarP5 = controlGrabarP5;
    }

    public List<SeaOpcionInstitucion> getOpcionInstList() {
        return opcionInstList;
    }

    public void setOpcionInstList(List<SeaOpcionInstitucion> opcionInstList) {
        this.opcionInstList = opcionInstList;
    }

    public List<SeaDatGeneralProy> getMontProyList() {
        return montProyList;
    }

    public void setMontProyList(List<SeaDatGeneralProy> montProyList) {
        this.montProyList = montProyList;
    }

    /// get and set tabP6
    public boolean isValidaVaciosP6() {
        return validaVaciosP6;
    }

    public void setValidaVaciosP6(boolean validaVaciosP6) {
        this.validaVaciosP6 = validaVaciosP6;
    }

    public boolean isControlGrabarP6() {
        return controlGrabarP6;
    }

    public void setControlGrabarP6(boolean controlGrabarP6) {
        this.controlGrabarP6 = controlGrabarP6;
    }

    public BigDecimal getPresupestoRiesgo() {
        return presupestoRiesgo;
    }

    public void setPresupestoRiesgo(BigDecimal presupestoRiesgo) {
        this.presupestoRiesgo = presupestoRiesgo;
    }

    public BigDecimal getPresupuestoEspe() {
        return presupuestoEspe;
    }

    public void setPresupuestoEspe(BigDecimal presupuestoEspe) {
        this.presupuestoEspe = presupuestoEspe;
    }

    public BigDecimal getPresupuestoAuspiciante() {
        return presupuestoAuspiciante;
    }

    public void setPresupuestoAuspiciante(BigDecimal presupuestoAuspiciante) {
        this.presupuestoAuspiciante = presupuestoAuspiciante;
    }

    public BigDecimal getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public void setPresupuestoTotal(BigDecimal presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    /// get and set tabP7
    public boolean isValidaVaciosP7() {
        return validaVaciosP7;
    }

    public void setValidaVaciosP7(boolean validaVaciosP7) {
        this.validaVaciosP7 = validaVaciosP7;
    }

    public boolean isControlGrabarP7() {
        return controlGrabarP7;
    }

    public void setControlGrabarP7(boolean controlGrabarP7) {
        this.controlGrabarP7 = controlGrabarP7;
    }

    public Date getFechPresent() {
        return fechPresent;
    }

    public void setFechPresent(Date fechPresent) {
        this.fechPresent = fechPresent;
    }

    public Date getFechInic() {
        return fechInic;
    }

    public void setFechInic(Date fechInic) {
        this.fechInic = fechInic;
    }

    public Date getFechFinal() {
        return fechFinal;
    }

    public void setFechFinal(Date fechFinal) {
        this.fechFinal = fechFinal;
    }

    public String getDuracionProyecto() {
        return duracionProyecto;
    }

    public void setDuracionProyecto(String duracionProyecto) {
        this.duracionProyecto = duracionProyecto;
    }

    public List<SeaParametrosDet> getParamDetList() {
        return paramDetList;
    }

    public void setParamDetList(List<SeaParametrosDet> paramDetList) {
        this.paramDetList = paramDetList;
    }

    public String getParamEstado() {
        return paramEstado;
    }

    public void setParamEstado(String paramEstado) {
        this.paramEstado = paramEstado;
    }

    public String getEstadoEdit() {
        return estadoEdit;
    }

    public void setEstadoEdit(String estadoEdit) {
        this.estadoEdit = estadoEdit;
    }

    /// get and set tabP8
    public boolean isValidaVaciosP8() {
        return validaVaciosP8;
    }

    public void setValidaVaciosP8(boolean validaVaciosP8) {
        this.validaVaciosP8 = validaVaciosP8;
    }

    public boolean isControlGrabarP8() {
        return controlGrabarP8;
    }

    public void setControlGrabarP8(boolean controlGrabarP8) {
        this.controlGrabarP8 = controlGrabarP8;
    }

    public List<SeaResponsableProg> getResponsableProgList() {
        return responsableProgList;
    }

    public void setResponsableProgList(List<SeaResponsableProg> responsableProgList) {
        this.responsableProgList = responsableProgList;
    }

    /// get and set tabP9
    public boolean isValidaVaciosP9() {
        return validaVaciosP9;
    }

    public void setValidaVaciosP9(boolean validaVaciosP9) {
        this.validaVaciosP9 = validaVaciosP9;
    }

    public boolean isControlGrabarP9() {
        return controlGrabarP9;
    }

    public void setControlGrabarP9(boolean controlGrabarP9) {
        this.controlGrabarP9 = controlGrabarP9;
    }

    public List<SeaDatGeneralProy> getConsidConseProyList() {
        return considConseProyList;
    }

    public void setConsidConseProyList(List<SeaDatGeneralProy> considConseProyList) {
        this.considConseProyList = considConseProyList;
    }

    /// get and set tabP10
    public boolean isValidaVaciosP10() {
        return validaVaciosP10;
    }

    public void setValidaVaciosP10(boolean validaVaciosP10) {
        this.validaVaciosP10 = validaVaciosP10;
    }

    public boolean isControlGrabarP10() {
        return controlGrabarP10;
    }

    public void setControlGrabarP10(boolean controlGrabarP10) {
        this.controlGrabarP10 = controlGrabarP10;
    }

    public String getTablaBusq() {
        return tablaBusq;
    }

    public void setTablaBusq(String tablaBusq) {
        this.tablaBusq = tablaBusq;
    }

    public SeaTablaContenido getTablaContenidoSelected() {
        return tablaContenidoSelected;
    }

    public void setTablaContenidoSelected(SeaTablaContenido tablaContenidoSelected) {
        this.tablaContenidoSelected = tablaContenidoSelected;
    }

    /// get and set tabP102
    public boolean isValidaVaciosP102() {
        return validaVaciosP102;
    }

    public void setValidaVaciosP102(boolean validaVaciosP102) {
        this.validaVaciosP102 = validaVaciosP102;
    }

    public boolean isControlGrabarP102() {
        return controlGrabarP102;
    }

    public void setControlGrabarP102(boolean controlGrabarP102) {
        this.controlGrabarP102 = controlGrabarP102;
    }

    /// get and set tabP11
    public boolean isValidaVaciosP11() {
        return validaVaciosP11;
    }

    public void setValidaVaciosP11(boolean validaVaciosP11) {
        this.validaVaciosP11 = validaVaciosP11;
    }

    public boolean isControlGrabarP11() {
        return controlGrabarP11;
    }

    public void setControlGrabarP11(boolean controlGrabarP11) {
        this.controlGrabarP11 = controlGrabarP11;
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

    public void setSupuestos(String supuestos) {
        this.supuestos = supuestos;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public List<SeaObjetivosFormato> getObjetivoFormatoList() {
        return objetivoFormatoList;
    }

    public void setObjetivoFormatoList(List<SeaObjetivosFormato> objetivoFormatoList) {
        this.objetivoFormatoList = objetivoFormatoList;
    }

    public SeaObjetivosFormato getObjetivoFormatoSelected() {
        return objetivoFormatoSelected;
    }

    public void setObjetivoFormatoSelected(SeaObjetivosFormato objetivoFormatoSelected) {
        this.objetivoFormatoSelected = objetivoFormatoSelected;
    }

    public SeaObjetivosFormato getObjFormSelected() {
        return objFormSelected;
    }

    public void setObjFormSelected(SeaObjetivosFormato objFormSelected) {
        this.objFormSelected = objFormSelected;
    }

    public List<SeaObjEFormulario> getObjEspeciFormularioList() {
        return objEspeciFormularioList;
    }

    public void setObjEspeciFormularioList(List<SeaObjEFormulario> objEspeciFormularioList) {
        this.objEspeciFormularioList = objEspeciFormularioList;
    }

    public List<SeaObjAcFormulario> getObjActividadFormuList() {
        return objActividadFormuList;
    }

    public void setObjActividadFormuList(List<SeaObjAcFormulario> objActividadFormuList) {
        this.objActividadFormuList = objActividadFormuList;
    }

    public SeaObjEFormulario getObjEFormularioSelected() {
        return objEFormularioSelected;
    }

    public void setObjEFormularioSelected(SeaObjEFormulario objEFormularioSelected) {
        this.objEFormularioSelected = objEFormularioSelected;
    }

    public SeaObjAcFormulario getObjAcFormularioSelected() {
        return objAcFormularioSelected;
    }

    public void setObjAcFormularioSelected(SeaObjAcFormulario objAcFormularioSelected) {
        this.objAcFormularioSelected = objAcFormularioSelected;
    }

    public String getDescripObjEsp() {
        return descripObjEsp;
    }

    public void setDescripObjEsp(String descripObjEsp) {
        this.descripObjEsp = descripObjEsp;
    }

    public String getIndicadObjEsp() {
        return indicadObjEsp;
    }

    public void setIndicadObjEsp(String indicadObjEsp) {
        this.indicadObjEsp = indicadObjEsp;
    }

    public String getVerificObjEsp() {
        return verificObjEsp;
    }

    public void setVerificObjEsp(String verificObjEsp) {
        this.verificObjEsp = verificObjEsp;
    }

    public String getSupuestObjEsp() {
        return supuestObjEsp;
    }

    public void setSupuestObjEsp(String supuestObjEsp) {
        this.supuestObjEsp = supuestObjEsp;
    }

    public String getDescripObjAct() {
        return descripObjAct;
    }

    public void setDescripObjAct(String descripObjAct) {
        this.descripObjAct = descripObjAct;
    }

    public String getIndicadObjAct() {
        return indicadObjAct;
    }

    public void setIndicadObjAct(String indicadObjAct) {
        this.indicadObjAct = indicadObjAct;
    }

    public String getVerificObjAct() {
        return verificObjAct;
    }

    public void setVerificObjAct(String verificObjAct) {
        this.verificObjAct = verificObjAct;
    }

    public String getSupuestObjAct() {
        return supuestObjAct;
    }

    public void setSupuestObjAct(String supuestObjAct) {
        this.supuestObjAct = supuestObjAct;
    }

    public boolean isValidaVaciosObjEsp() {
        return validaVaciosObjEsp;
    }

    public void setValidaVaciosObjEsp(boolean validaVaciosObjEsp) {
        this.validaVaciosObjEsp = validaVaciosObjEsp;
    }

    public boolean isValidaVaciosObjAct() {
        return validaVaciosObjAct;
    }

    public void setValidaVaciosObjAct(boolean validaVaciosObjAct) {
        this.validaVaciosObjAct = validaVaciosObjAct;
    }

    /// get and set tabP12
    public boolean isValidaVaciosP12() {
        return validaVaciosP12;
    }

    public void setValidaVaciosP12(boolean validaVaciosP12) {
        this.validaVaciosP12 = validaVaciosP12;
    }

    public boolean isControlGrabarP12() {
        return controlGrabarP12;
    }

    public void setControlGrabarP12(boolean controlGrabarP12) {
        this.controlGrabarP12 = controlGrabarP12;
    }

    public String getObjFormato() {
        return objFormato;
    }

    public void setObjFormato(String objFormato) {
        this.objFormato = objFormato;
    }

    public String getBienServ() {
        return bienServ;
    }

    public void setBienServ(String bienServ) {
        this.bienServ = bienServ;
    }

    public String getDetEntr() {
        return detEntr;
    }

    public void setDetEntr(String detEntr) {
        this.detEntr = detEntr;
    }

    public List<SeaObjEntregables> getObjEntregabList() {
        return objEntregabList;
    }

    public void setObjEntregabList(List<SeaObjEntregables> objEntregabList) {
        this.objEntregabList = objEntregabList;
    }

    public String getObjFormatoEdit() {
        return objFormatoEdit;
    }

    public void setObjFormatoEdit(String objFormatoEdit) {
        this.objFormatoEdit = objFormatoEdit;
    }

    public String getBienServEdit() {
        return bienServEdit;
    }

    public void setBienServEdit(String bienServEdit) {
        this.bienServEdit = bienServEdit;
    }

    public String getDenEntrEdit() {
        return denEntrEdit;
    }

    public void setDenEntrEdit(String denEntrEdit) {
        this.denEntrEdit = denEntrEdit;
    }

    public SeaObjEntregables getObjEntregableSelected() {
        return objEntregableSelected;
    }

    public void setObjEntregableSelected(SeaObjEntregables objEntregableSelected) {
        this.objEntregableSelected = objEntregableSelected;
    }

    //// get and set tabP13
    public boolean isValidaVaciosP13() {
        return validaVaciosP13;
    }

    public void setValidaVaciosP13(boolean validaVaciosP13) {
        this.validaVaciosP13 = validaVaciosP13;
    }

    public boolean isControlGrabarP13() {
        return controlGrabarP13;
    }

    public void setControlGrabarP13(boolean controlGrabarP13) {
        this.controlGrabarP13 = controlGrabarP13;
    }

    public String getBienesServicios() {
        return bienesServicios;
    }

    public void setBienesServicios(String bienesServicios) {
        this.bienesServicios = bienesServicios;
    }

    public String getDetalleInsNac() {
        return detalleInsNac;
    }

    public void setDetalleInsNac(String detalleInsNac) {
        this.detalleInsNac = detalleInsNac;
    }

    public String getDetalleInsImp() {
        return detalleInsImp;
    }

    public void setDetalleInsImp(String detalleInsImp) {
        this.detalleInsImp = detalleInsImp;
    }

    public String getPorcentNac() {
        return porcentNac;
    }

    public void setPorcentNac(String porcentNac) {
        this.porcentNac = porcentNac;
    }

    public String getPorcentImp() {
        return porcentImp;
    }

    public void setPorcentImp(String porcentImp) {
        this.porcentImp = porcentImp;
    }

    public List<SeaObjAdquisisiones> getObjAdquisisionList() {
        return objAdquisisionList;
    }

    public void setObjAdquisisionList(List<SeaObjAdquisisiones> objAdquisisionList) {
        this.objAdquisisionList = objAdquisisionList;
    }

    public String getObjetivoFormato() {
        return objetivoFormato;
    }

    public void setObjetivoFormato(String objetivoFormato) {
        this.objetivoFormato = objetivoFormato;
    }

    public SeaObjAdquisisiones getObjAdquisisioneSelected() {
        return objAdquisisioneSelected;
    }

    public void setObjAdquisisioneSelected(SeaObjAdquisisiones objAdquisisioneSelected) {
        this.objAdquisisioneSelected = objAdquisisioneSelected;
    }

    public String getObjetivoFormatoEdit() {
        return objetivoFormatoEdit;
    }

    public void setObjetivoFormatoEdit(String objetivoFormatoEdit) {
        this.objetivoFormatoEdit = objetivoFormatoEdit;
    }

    public String getBienesServiciosEdit() {
        return bienesServiciosEdit;
    }

    public void setBienesServiciosEdit(String bienesServiciosEdit) {
        this.bienesServiciosEdit = bienesServiciosEdit;
    }

    /// get and set tabP14
    public boolean isValidaVaciosP14() {
        return validaVaciosP14;
    }

    public void setValidaVaciosP14(boolean validaVaciosP14) {
        this.validaVaciosP14 = validaVaciosP14;
    }

    public boolean isControlGrabarP14() {
        return controlGrabarP14;
    }

    public void setControlGrabarP14(boolean controlGrabarP14) {
        this.controlGrabarP14 = controlGrabarP14;
    }

    public String getCategoriaProyecto() {
        return categoriaProyecto;
    }

    public void setCategoriaProyecto(String categoriaProyecto) {
        this.categoriaProyecto = categoriaProyecto;
    }

    public List<SeaParametrosDet> getCategoriaProyList() {
        return categoriaProyList;
    }

    public void setCategoriaProyList(List<SeaParametrosDet> categoriaProyList) {
        this.categoriaProyList = categoriaProyList;
    }

    public List<SeaParametrosDet> getObjProyectList() {
        return objProyectList;
    }

    public void setObjProyectList(List<SeaParametrosDet> objProyectList) {
        this.objProyectList = objProyectList;
    }

    public String getCategoriaProyectoEdit() {
        return categoriaProyectoEdit;
    }

    public void setCategoriaProyectoEdit(String categoriaProyectoEdit) {
        this.categoriaProyectoEdit = categoriaProyectoEdit;
    }

    /// get and set tabP16
    public boolean isValidaVaciosP16() {
        return validaVaciosP16;
    }

    public void setValidaVaciosP16(boolean validaVaciosP16) {
        this.validaVaciosP16 = validaVaciosP16;
    }

    public boolean isControlGrabarP16() {
        return controlGrabarP16;
    }

    public void setControlGrabarP16(boolean controlGrabarP16) {
        this.controlGrabarP16 = controlGrabarP16;
    }

    public String getViabilidadTecn() {
        return viabilidadTecn;
    }

    public void setViabilidadTecn(String viabilidadTecn) {
        this.viabilidadTecn = viabilidadTecn;
    }

    public String getEquipaTecnol() {
        return equipaTecnol;
    }

    public void setEquipaTecnol(String equipaTecnol) {
        this.equipaTecnol = equipaTecnol;
    }

    public String getPerderPais() {
        return perderPais;
    }

    public void setPerderPais(String perderPais) {
        this.perderPais = perderPais;
    }

    public String getImpactoEsper() {
        return impactoEsper;
    }

    public void setImpactoEsper(String impactoEsper) {
        this.impactoEsper = impactoEsper;
    }

    public String getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(String impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }

    public String getSostenibiSocial() {
        return sostenibiSocial;
    }

    public void setSostenibiSocial(String sostenibiSocial) {
        this.sostenibiSocial = sostenibiSocial;
    }

    public String getTransferTecnol() {
        return transferTecnol;
    }

    public void setTransferTecnol(String transferTecnol) {
        this.transferTecnol = transferTecnol;
    }

    public String getArtiCientif() {
        return artiCientif;
    }

    public void setArtiCientif(String artiCientif) {
        this.artiCientif = artiCientif;
    }

    public String getPrototip() {
        return prototip;
    }

    public void setPrototip(String prototip) {
        this.prototip = prototip;
    }

    public String getRegPropIntel() {
        return regPropIntel;
    }

    public void setRegPropIntel(String regPropIntel) {
        this.regPropIntel = regPropIntel;
    }

    public String getSpinOff() {
        return spinOff;
    }

    public void setSpinOff(String spinOff) {
        this.spinOff = spinOff;
    }

    public String getOtrosViabilidad() {
        return otrosViabilidad;
    }

    public void setOtrosViabilidad(String otrosViabilidad) {
        this.otrosViabilidad = otrosViabilidad;
    }

    public String getDisponeMetodologia() {
        return disponeMetodologia;
    }

    public void setDisponeMetodologia(String disponeMetodologia) {
        this.disponeMetodologia = disponeMetodologia;
    }

    /// get and set tabP17
    public List<SeaFormatoEstrategiae> getFormatoEstrategiaList() {
        return formatoEstrategiaList;
    }

    public void setFormatoEstrategiaList(List<SeaFormatoEstrategiae> formatoEstrategiaList) {
        this.formatoEstrategiaList = formatoEstrategiaList;
    }

    public boolean isValidaVaciosP17() {
        return validaVaciosP17;
    }

    public void setValidaVaciosP17(boolean validaVaciosP17) {
        this.validaVaciosP17 = validaVaciosP17;
    }

    public boolean isControlGrabarP17() {
        return controlGrabarP17;
    }

    public void setControlGrabarP17(boolean controlGrabarP17) {
        this.controlGrabarP17 = controlGrabarP17;
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

    public SeaFormatoEstrategiae getFormatoEstrategiaSelected() {
        return formatoEstrategiaSelected;
    }

    public void setFormatoEstrategiaSelected(SeaFormatoEstrategiae formatoEstrategiaSelected) {
        this.formatoEstrategiaSelected = formatoEstrategiaSelected;
    }

    /// get and set tabP18
    public boolean isValidaVaciosP18() {
        return validaVaciosP18;
    }

    public void setValidaVaciosP18(boolean validaVaciosP18) {
        this.validaVaciosP18 = validaVaciosP18;
    }

    public boolean isControlGrabarP18() {
        return controlGrabarP18;
    }

    public void setControlGrabarP18(boolean controlGrabarP18) {
        this.controlGrabarP18 = controlGrabarP18;
    }

    public String getMesSeguimiento() {
        return mesSeguimiento;
    }

    public void setMesSeguimiento(String mesSeguimiento) {
        this.mesSeguimiento = mesSeguimiento;
    }

    public String getDescripcionHito() {
        return descripcionHito;
    }

    public void setDescripcionHito(String descripcionHito) {
        this.descripcionHito = descripcionHito;
    }

    public List<SeaFormatoSeguimiento> getFormatoSeguimientoList() {
        return formatoSeguimientoList;
    }

    public void setFormatoSeguimientoList(List<SeaFormatoSeguimiento> formatoSeguimientoList) {
        this.formatoSeguimientoList = formatoSeguimientoList;
    }

    public SeaFormatoSeguimiento getFormatoSeguimientoSelected() {
        return formatoSeguimientoSelected;
    }

    public void setFormatoSeguimientoSelected(SeaFormatoSeguimiento formatoSeguimientoSelected) {
        this.formatoSeguimientoSelected = formatoSeguimientoSelected;
    }

    public String getPresupuestoSegE() {
        return presupuestoSegE;
    }

    public void setPresupuestoSegE(String presupuestoSegE) {
        this.presupuestoSegE = presupuestoSegE;
    }

    public String getFechInicHitos() {
        return fechInicHitos;
    }

    public void setFechInicHitos(String fechInicHitos) {
        this.fechInicHitos = fechInicHitos;
    }

    public Date getFechaInicioHitos() {
        return fechaInicioHitos;
    }

    public void setFechaInicioHitos(Date fechaInicioHitos) {
        this.fechaInicioHitos = fechaInicioHitos;
    }

    public String getFechFinHitos() {
        return fechFinHitos;
    }

    public void setFechFinHitos(String fechFinHitos) {
        this.fechFinHitos = fechFinHitos;
    }

    public Date getFechaFinalHitos() {
        return fechaFinalHitos;
    }

    public void setFechaFinalHitos(Date fechaFinalHitos) {
        this.fechaFinalHitos = fechaFinalHitos;
    }

    /// get and set tabP19
    public boolean isValidaVaciosP19() {
        return validaVaciosP19;
    }

    public void setValidaVaciosP19(boolean validaVaciosP19) {
        this.validaVaciosP19 = validaVaciosP19;
    }

    public boolean isControlGrabarP19() {
        return controlGrabarP19;
    }

    public void setControlGrabarP19(boolean controlGrabarP19) {
        this.controlGrabarP19 = controlGrabarP19;
    }

    public List<SeaFdifusionEvento> getFdifusionEveantoList() {
        return fdifusionEveantoList;
    }

    public void setFdifusionEveantoList(List<SeaFdifusionEvento> fdifusionEveantoList) {
        this.fdifusionEveantoList = fdifusionEveantoList;
    }

    public SeaFdifusionEvento getFdifusionEventoSelected() {
        return fdifusionEventoSelected;
    }

    public void setFdifusionEventoSelected(SeaFdifusionEvento fdifusionEventoSelected) {
        this.fdifusionEventoSelected = fdifusionEventoSelected;
    }

    public String getFdescripcion() {
        return fdescripcion;
    }

    public void setFdescripcion(String fdescripcion) {
        this.fdescripcion = fdescripcion;
    }

    //// get and set tabP20
    public SeaFormatoDifusion getFormatoDifusionSelected() {
        return formatoDifusionSelected;
    }

    public void setFormatoDifusionSelected(SeaFormatoDifusion formatoDifusionSelected) {
        this.formatoDifusionSelected = formatoDifusionSelected;
    }

    public List<SeaFormatoDifusion> getFormatoDifusionList() {
        return formatoDifusionList;
    }

    public void setFormatoDifusionList(List<SeaFormatoDifusion> formatoDifusionList) {
        this.formatoDifusionList = formatoDifusionList;
    }

    public boolean isValidaVaciosP20() {
        return validaVaciosP20;
    }

    public void setValidaVaciosP20(boolean validaVaciosP20) {
        this.validaVaciosP20 = validaVaciosP20;
    }

    public boolean isControlGrabarP20() {
        return controlGrabarP20;
    }

    public void setControlGrabarP20(boolean controlGrabarP20) {
        this.controlGrabarP20 = controlGrabarP20;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getTipoEventoEdit() {
        return tipoEventoEdit;
    }

    public void setTipoEventoEdit(String tipoEventoEdit) {
        this.tipoEventoEdit = tipoEventoEdit;
    }

    //// get and set tabP21
    public boolean isValidaVaciosP21() {
        return validaVaciosP21;
    }

    public void setValidaVaciosP21(boolean validaVaciosP21) {
        this.validaVaciosP21 = validaVaciosP21;
    }

    public boolean isControlGrabarP21() {
        return controlGrabarP21;
    }

    public void setControlGrabarP21(boolean controlGrabarP21) {
        this.controlGrabarP21 = controlGrabarP21;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<SeaFormatoBibliografia> getFormatoBibliografiaList() {
        return formatoBibliografiaList;
    }

    public void setFormatoBibliografiaList(List<SeaFormatoBibliografia> formatoBibliografiaList) {
        this.formatoBibliografiaList = formatoBibliografiaList;
    }

    public SeaFormatoBibliografia getFormatoBibliografiaSelected() {
        return formatoBibliografiaSelected;
    }

    public void setFormatoBibliografiaSelected(SeaFormatoBibliografia formatoBibliografiaSelected) {
        this.formatoBibliografiaSelected = formatoBibliografiaSelected;
    }

    public List<SeaParametrosDet> getParamDetPlazoEjecList() {
        return paramDetPlazoEjecList;
    }

    public void setParamDetPlazoEjecList(List<SeaParametrosDet> paramDetPlazoEjecList) {
        this.paramDetPlazoEjecList = paramDetPlazoEjecList;
    }

    public String getNumPag() {
        return numPag;
    }

    public void setNumPag(String numPag) {
        this.numPag = numPag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getObserBiblio() {
        return obserBiblio;
    }

    public void setObserBiblio(String obserBiblio) {
        this.obserBiblio = obserBiblio;
    }

    //// get and set tabP23
    public boolean isControlGrabarP23() {
        return controlGrabarP23;
    }

    public void setControlGrabarP23(boolean controlGrabarP23) {
        this.controlGrabarP23 = controlGrabarP23;
    }

    public boolean isValidaVaciosP23() {
        return validaVaciosP23;
    }

    public void setValidaVaciosP23(boolean validaVaciosP23) {
        this.validaVaciosP23 = validaVaciosP23;
    }

    public String getNomFile2() {
        return nomFile2;
    }

    public void setNomFile2(String nomFile2) {
        this.nomFile2 = nomFile2;
    }

    public UploadedFile getFile2() {
        return file2;
    }

    public void setFile2(UploadedFile file2) {
        this.file2 = file2;
    }

    public byte[] getFile22() {
        return file22;
    }

    public void setFile22(byte[] file22) {
        this.file22 = file22;
    }

    public String getPagLegal() {
        return pagLegal;
    }

    public void setPagLegal(String pagLegal) {
        this.pagLegal = pagLegal;
    }

    ///////
    public String getObjProyecto() {
        return objProyecto;
    }

    public void setObjProyecto(String objProyecto) {
        this.objProyecto = objProyecto;
    }

    public boolean isControlTipoFin() {
        return controlTipoFin;
    }

    public void setControlTipoFin(boolean controlTipoFin) {
        this.controlTipoFin = controlTipoFin;
    }

    public boolean isControlTipoPropos() {
        return controlTipoPropos;
    }

    public void setControlTipoPropos(boolean controlTipoPropos) {
        this.controlTipoPropos = controlTipoPropos;
    }

    public boolean isControlTipoCompon() {
        return controlTipoCompon;
    }

    public void setControlTipoCompon(boolean controlTipoCompon) {
        this.controlTipoCompon = controlTipoCompon;
    }

    public String getDescripObj() {
        return descripObj;
    }

    public void setDescripObj(String descripObj) {
        this.descripObj = descripObj;
    }

    public String getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(String tipoObj) {
        this.tipoObj = tipoObj;
    }

    public List<ObjetivoProyecto> getSzObjProyList() {
        return szObjProyList;
    }

    public void setSzObjProyList(List<ObjetivoProyecto> szObjProyList) {
        this.szObjProyList = szObjProyList;
    }

    public ObjetivoProyecto getObjProyPadreSelected() {
        return objProyPadreSelected;
    }

    public void setObjProyPadreSelected(ObjetivoProyecto objProyPadreSelected) {
        this.objProyPadreSelected = objProyPadreSelected;
    }

    public ObjetivoProyecto getObjetivoProyecto() {
        return objetivoProyecto;
    }

    public void setObjetivoProyecto(ObjetivoProyecto objetivoProyecto) {
        this.objetivoProyecto = objetivoProyecto;
    }

    public ObjetivoProyecto getObjProySelected() {
        return objProySelected;
    }

    public void setObjProySelected(ObjetivoProyecto objProySelected) {
        this.objProySelected = objProySelected;
    }

    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }

//</editor-fold>
    public SeaDatGeneralProy getNotaConceptual() {
        return notaConceptual;
    }

    public void setNotaConceptual(SeaDatGeneralProy notaConceptual) {
        this.notaConceptual = notaConceptual;
    }

    public SeaFormatoLargo getFormatoLargo() {
        return formatoLargo;
    }

    public void setFormatoLargo(SeaFormatoLargo formatoLargo) {
        this.formatoLargo = formatoLargo;
    }

    public void onTabChange(TabChangeEvent event) {
        String[] temp = event.getTab().getClientId().split(":");
        String id = temp[temp.length - 1];
        switch (id) {
            case "tabP15": //14. Metodología para la Investigación
                cancelarP15();
                break;
            case "tabP1": //1. Datos Generales
                cancelarP15();
                break;
            case "tabP4": //4. Áreas de Conocimiento
                cancelarP15();
                break;
            case "tabP6": //6. Monto
                cancelarP15();
                break;
            case "tabP10": //10. Diagnóstico y Problema
                cancelarP10();
                break;
            case "tabP101": //10.2 Tabla de Búsqueda
                cancelarP10();
                break;
        }
    }

    public void finalizarNotaConceptual(){
        try {
            //notaConceptual.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_FINALIZADO_FORMATO_EXTENSO);
            notaConceptualFacade.edit(notaConceptual);
            notaConceptual= notaConceptualFacade.find(notaConceptual.getDatgeproyId());
            seleccionarNotaConceptual();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

}
