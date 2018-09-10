/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.entity.Stvtops;
import ec.edu.espe_ctt.saturno.session.StvcampFacade;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.saturno.session.StvsubjFacade;
import ec.edu.espe_ctt.saturno.session.StvtopsFacade;
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.AprobacionDirectorDepartamento;
import ec.edu.espe_ctt_investigacion.entity.CalificacionComision;
import ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionPar;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionParDetalle;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaAnalisisFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaAreacUnesco;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaDiagnosProblema;
import ec.edu.espe_ctt_investigacion.entity.SeaFdifusionEvento;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoBibliografia;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoDifusion;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoEstrategiae;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoViabilidad;
import ec.edu.espe_ctt_investigacion.entity.SeaGrupinv;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaLocaliza;
import ec.edu.espe_ctt_investigacion.entity.SeaObjAdquisisiones;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEntregables;
import ec.edu.espe_ctt_investigacion.entity.SeaObplanbv;
import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupuestoC;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaProgPostgrado;
import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaTablaContenido;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoInvestigacion;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion;
import ec.edu.espe_ctt_investigacion.entity.Sztaainv;
import ec.edu.espe_ctt_investigacion.entity.Sztainanex;
import ec.edu.espe_ctt_investigacion.entity.Sztainco;
import ec.edu.espe_ctt_investigacion.entity.Sztaobjbvpr;
import ec.edu.espe_ctt_investigacion.entity.Sztapolobjbv;
import ec.edu.espe_ctt_investigacion.entity.VCampusDeptoCarrera;
import ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto;
import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion;
import ec.edu.espe_ctt_investigacion.entity.VEstudiantesB;
import ec.edu.espe_ctt_investigacion.session.AprobacionDirectorDepartamentoFacade;
import ec.edu.espe_ctt_investigacion.session.ConfiguracionParametrosEvaluacionInvFacade;
import ec.edu.espe_ctt_investigacion.session.CronogramaFacade;
import ec.edu.espe_ctt_investigacion.session.EvaluacionParFacade;
import ec.edu.espe_ctt_investigacion.session.ObjetivoProyectoFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaAnalisisFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaAreacUnescoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCantonFacade;
import ec.edu.espe_ctt_investigacion.session.SeaClasificadorPresupFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDiagnosProblemaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFdifusionEventoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFinanciaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoBibliografiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoDifusionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoEstrategiaeFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoViabilidadFacade;
import ec.edu.espe_ctt_investigacion.session.SeaGrupinvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLocalizaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjAdquisisionesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjEntregablesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObplanbvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaOpcionInstitucionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPresupuestoCFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoXConvocatoriaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgPostgradoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaRecursosConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTablaContenidoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTipoInvestigacionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTipoResponsFacade;
import ec.edu.espe_ctt_investigacion.session.SeaZonaPlanificacionFacade;
import ec.edu.espe_ctt_investigacion.session.SztaainvFacade;
import ec.edu.espe_ctt_investigacion.session.SztainanexFacade;
import ec.edu.espe_ctt_investigacion.session.SztaincoFacade;
import ec.edu.espe_ctt_investigacion.session.SztaobjbvprFacade;
import ec.edu.espe_ctt_investigacion.session.SztapolobjbvFacade;
import ec.edu.espe_ctt_investigacion.session.VCampusDeptoCarreraFacade;
import ec.edu.espe_ctt_investigacion.session.VDirectoresDeptoFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteDeptoBFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteInvestigacionFacade;
import ec.edu.espe_ctt_investigacion.session.VEstudiantesBFacade;
import java.io.ByteArrayInputStream;
import java.io.File;
import static java.io.File.separatorChar;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.Visibility;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProyectoContenidoController implements Serializable {

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath = "";
    private StreamedContent media;
    public boolean controlPDF = false;
    private String resuProy = "";
    private String desObProy = "";
    private String metodProy = "";
    private String resultEsProy = "";
    private String nombreArchivoPdf;

    /**
     * Creates a new instance of PerfilProyectoController
     */
    public ProyectoContenidoController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;
    private String estado = null;

    @EJB
    private SeaProcesoXConvocatoriaFacade procesoXConvocatoriaFacade;
    private SeaProcesoXConvocatoria procesoXConv;
    private Date fechaPresConv;

    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    //private SeaDatGeneralProy notaConceptualSelected;
    private List<SeaDatGeneralProy> datGenProyPagLegList;
    private boolean validaVaciosP1 = true;
    private boolean controlTipoPersonal;
    private boolean controlTipoEstudiante;
    private boolean controlTipoExterno;
    private boolean controlTipoOtros;
    private String progInvestiga = "";
    private String tipologia = "";
    private String tituloProy = "";
    private String duracionProyecto;
    private String nomFile1 = "";
    private String otros = "";
    private UploadedFile file;
    private byte[] file1 = null;
    private String[] zonaPlafinicacionSelected;
    private String[] provinciaSelected;
    private String[] cantonProv;
    private boolean validaVaciosP7 = true;
    private boolean controlGrabarP7 = false;

    private boolean validaVaciosP9 = true;
    private boolean controlGrabarP9 = false;
    private String nomFile2 = "";
//    private SeaDatGeneralProy datGenProyeSelected;xxx
    private StreamedContent fileLegal;

    private UploadedFile file2;
    private byte[] file21 = null;
    private String nomFile3 = "";
    private UploadedFile file3;
    private byte[] file31 = null;
    private String nomFileRes = "";
    private byte[] fileRes = null;
    private String nomFileDes = "";
    private byte[] fileDes = null;
    private String tipoPersonal = "";
    private String nombrEstudiante = "";
    private String nombrExterno = "";
    private Date fechActual;
    private String identif;

    //tab2
    @EJB
    private SeaZonaPlanificacionFacade zonaPlanifFacade;
    private List<SeaZonaPlanificacion> zonaPlanifList;
    private SeaZonaPlanificacion zonaPlanif;

    @EJB
    private SeaLocalizaFacade localizaFacade;
    private List<SeaLocaliza> localizaList;

    @EJB
    private SeaProvinciaFacade provinciaFacade;
    private List<SeaProvincia> provinciaList;
    private List<SeaProvincia> proList;

    @EJB
    private SeaCantonFacade cantonFacade;
    private List<SeaCanton> cantonList;

    /// programa Investigacion
    @EJB
    private SeaProgramaFacade programaFacade;
    private SeaPrograma programaInvestigacion;
    private List<SeaPrograma> prgInvestigaList;

    //// tipo Investigacion
    @EJB
    private SeaTipoInvestigacionFacade tipoInvestFacade;
    private SeaTipoInvestigacion tipoInvestigacion;

    /// tab3
    @EJB
    private SeaDepcenproyFacade depCenProyFacade;
    private SeaDepcenproy depCenProy;
    private SeaDepcenproy depcenproySelected;
    private boolean controlGrabarP3 = false;
    private boolean validaVaciosP3 = true;
    private String carrera = "";
    private String programaPost = "";
    private String numConvocat = "";
    private String sublinea = "";
    private String grupoInvest = "";
    private List<SeaDepcenproy> depcenproyList;
    private String centroEdit;
    private String carreraEdit;
    private String progPostEdit;
    private String sublineaEdit;
    private String grupoInvestEdit;
    private String programaInvest = "";

    ///departamento
    @EJB
    private StvsubjFacade subjFacade;
    private Stvsubj subj;
    private List<Stvsubj> subjList;
    private Stvsubj subjDept;
    private Stvsubj stvSubj;

    ///carrera
    @EJB
    private StvmajrFacade majrFacade;
    private Stvmajr majr;
    private List<Stvmajr> majrList;
    private Stvmajr stvMajr;
    private Stvmajr stvMajrCarre;

    ///convocatoria
    @EJB
    private SeaConvocaFacade convocaFacade;
    private SeaConvoca convocatoria;
    private List<SeaConvoca> convocaList;
    private String convocatoriaEdit;
    private List<SeaConvoca> convocatoriaList;
    private String convocaProy = "";
    private SeaConvoca convocaProyecto;
    private SeaConvoca datosConvocaSelected;
    private String localidad;
    private BigDecimal convocaId;

    @EJB
    private SeaProgPostgradoFacade progPostgradoFacade;
    private SeaProgPostgrado progPostgrado;
    private List<SeaProgPostgrado> progPostgradoList;

    //// sub línea
    @EJB
    private SeaLineainvesFacade lineaInvesFacade;
    private SeaLineainves lineaInvestigacion;
    private List<SeaLineainves> sublineaList;
    private List<SeaLineainves> lineaInvestList;
    private String lineaInvst;

    //// grupo Investigación
    @EJB
    private SeaGrupinvFacade grupoInvestFacade;
    private SeaGrupinv grupoInvestiga;
    private List<SeaGrupinv> grupInvestigaList;

    //// opcion institucion tab 4
    @EJB
    private SeaOpcionInstitucionFacade opcionInstitucionFacade;
    private SeaOpcionInstitucion opcionInstSelected;
    private boolean controlGrabarP4 = false;
    private boolean validaVaciosP4 = true;
    private List<SeaOpcionInstitucion> opInstitucionList;
    private List<SeaOpcionInstitucion> datosOrdenList;

    ///datos generales programa
    @EJB
    private SeaDatGeneralProgFacade datgenprogFacade;
    private SeaDatGeneralProg datgenProg;
    private List<SeaDatGeneralProg> datgenprogList;
    private String datgenEdit;
    private Integer ordenInstitucion;
    private String ordenInstit;

    //variables Tab 5    
    @EJB
    private SeaResponsableProgFacade responsableProyFacade;
    private List<SeaResponsableProg> responsableProyList;
    private List<SeaResponsableProg> respOrdenProyList;
    private boolean validaVaciosP5 = true;
    private boolean controlGrabarP5 = false;
    private SeaResponsableProg responsableProyecto;
    private SeaResponsableProg resProyecto;
    private SeaResponsableProg responsableProyectoSelected;

    @EJB
    private SegUsuarioFacade docenteProyFacade;
    private List<SegUsuario> docenteProyList;
    private SegUsuario estudianteUsuario;
    private List<SegUsuario> otrosProyLits;
    private List<SegUsuario> externoProyLits;

    @EJB
    private SeaTipoResponsFacade tipoResponDoceFacade;
    private List<SeaTipoRespons> tipoResponDoceList;
    private String docente = "";
    private String departamento = "";
    private String tipoResponsabilidad = "";

    //variables Tab 6 Descripcion Proyecto
    private boolean validaVaciosP61 = true;
    private boolean validaVaciosP62 = true;
    private boolean validaVaciosP63 = true;
    private boolean validaVaciosP64 = true;
    private boolean controlGrabarP61 = false;
    private boolean controlGrabarP62 = false;
    private boolean controlGrabarP63 = false;
    private boolean controlGrabarP64 = false;

    @EJB
    private SeaDatGeneralProyFacade objetivosProyFacade;
    private boolean controlGrabarP8 = false;
    private boolean validaVaciosP8 = true;
    private List<SeaDatGeneralProy> datosGeneralesList;

    /// financiamiento convocatoria
    @EJB
    private SeaFinanciaConvocaFacade financiaConvocaFacade;
    private SeaFinanciaConvoca financiaConvoca;
    private SeaFinanciaConvoca financiamientoConvocatoria;
    private String recursoFisico = "";
    private String idRecFisico = "";
    private String recursoHumano = "";
    private String idRecHumano = "";
    private String recursoLogistico = "";
    private String idRecLogistico = "";
    private BigInteger valor;
    private BigInteger aux = new BigInteger("0");
    private BigInteger result = new BigInteger("0");
    private String tipoRecurso;
    private String montoPresupuestado;
    private BigDecimal monTA;
    private BigDecimal monTB;
    private BigDecimal monTC;
    private BigDecimal monTot;
    private boolean grabaProceso = false;

    /// recursos convocatoria
    @EJB
    private SeaRecursosConvocaFacade recursosFacade;
    private SeaRecursosConvoca recursosConvoca;
    private List<SeaRecursosConvoca> recursoConvocaList;

    /// clasificador Presupuestario
    @EJB
    private SeaClasificadorPresupFacade clasificadorPresupFacade;
    private SeaClasificadorPresup clasificadorPresup;
    private List<SeaClasificadorPresup> clasificadorList;
    private String partidaPresup;

    ///Presupuesto Convocatoria
    @EJB
    private SeaPresupuestoCFacade presupuestoFacade;
    private SeaPresupuestoC presupuestoConvoca;
    private SeaPresupuestoC presupuestoConvocatoria;
    private SeaPresupuestoC presupuestoCSelected;
    private List<SeaPresupuestoC> presupuestoCLits;
    private String tipoRecursoEdit;
    private String partidaPresEdit;
    private List<SeaPresupuestoC> preConvocaList;
    private List<SeaPresupuestoC> presupuestoConvocaList;

    /// parametros detalle
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    private SeaParametrosDet parametrosDet;
    private List<SeaParametrosDet> tipoInvestigaList;

    /// Vista Docente Investigacion
    @EJB
    private VDocenteInvestigacionFacade docenteInvestigaFacade;
    private VDocenteInvestigacion docenteInvestigacion;
    private List<VDocenteInvestigacion> docenteInvestigacionList;

    /// Vista Estudiantes
    @EJB
    private VEstudiantesBFacade estdudiantesBFacade;
    private VEstudiantesB estudiantesB;
    private List<VEstudiantesB> estudiantesBList;
    private String cedula;

    /// Vista Campus Departamento Carrera
    @EJB
    private VCampusDeptoCarreraFacade campusDeptoCarreraFacade;
    private VCampusDeptoCarrera campusDeptoCarrera;
    private VCampusDeptoCarrera dptoCarrera;
    private List<VCampusDeptoCarrera> centroRespList;
    private String campus = "";
    private String campusEdit = "";

    //// campus
    @EJB
    private StvcampFacade campFacade;
    private Stvcamp stvCamp;
    private Stvcamp stvCampus;
    private List<Stvcamp> campList;
    private String centroResp = "";
    private String idDepto;
    private String idCarre;
    private String idCampus;

    //// Areas de Investigacion
    @EJB
    private SztaainvFacade aaInvFacade;
    private Sztaainv aaInv;
    private List<Sztaainv> aaInvList;
    private boolean validaVaciosP12 = true;
    private boolean controlGrabarP12 = false;
    private String[] aaInvest = null;

    ///Area Investigacion por Nota Conceptual
    @EJB
    private SztaincoFacade taincoFacade;
    private Sztainco tainco;
    private List<Sztainco> taincoList;
    private Sztainco taincoSelected;
    private Sztainco areaIngresada;

    ///Anexos Investigacion
    @EJB
    private SztainanexFacade anexoProyectoFacade;
    private Sztainanex investAnexo;
    private Sztainanex investAnexoResuSelected;
    private Sztainanex investAnexoObjSelected;
    private List<Sztainanex> investResumenList;
    private List<Sztainanex> investObjetivList;
    private List<Sztainanex> anexoProyectoList;

    ////Aprueba NC
    @EJB
    private AprobacionDirectorDepartamentoFacade apruebaNcFacade;
    private List<AprobacionDirectorDepartamento> apruebaNcList;

    //// Vista V_Docente_Deptob
    @EJB
    private VDocenteDeptoBFacade vDocenteDeptoFacade;
    private VDocenteDeptoB vDocenteDeptoB;
    private BigDecimal idDocente;

    private BigDecimal idNotaConceptualSelected;

    private SeaFormatoLargo proyectoSelected;
    @EJB
    private SeaFormatoLargoFacade proyectoFacade;

    private String operacion;
    private static final String OPERACION_APROBACION_DIRECTOR_DEP = "aprdir";
    private static final String OPERACION_EVALUACION_PAR = "evapar";

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");
        cargarCatalogos();

        Object idNotaConceptual = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (idNotaConceptual != null) {
            idNotaConceptualSelected = new BigDecimal(idNotaConceptual.toString());
            Object op = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("op");
            if (op != null) {
                this.operacion = op.toString();
            }
            cargaDatosProyecto();

        } else {
            //notaConceptualSelected = new SeaDatGeneralProy();
            permitirEdicionPerfil = true;
            proyectoSelected = new SeaFormatoLargo();
            proyectoSelected.addObjetivoProyecto(new ObjetivoProyecto(proyectoSelected, new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_FIN), 1));
            proyectoSelected.addObjetivoProyecto(new ObjetivoProyecto(proyectoSelected, new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_GENERAL), 2));

            proyectoSelected.setDatgeproyId(new SeaDatGeneralProy());
        }
        crearArbolMenu();
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    /*
     Objetivo: Crear nuevo perfil proyecto asi exista uno, solo activa TAB1
     Fecha: 15-Abril-2015
     */
    public void inicializarDatosProyectoNuevo() {
        if (responsableProyecto == null) {
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(new SegUsuario());
            responsableProyecto.setTipresId(new SeaTipoRespons());
        }
        docente = "";
    }

    private void cargarCatalogos() {

        prgInvestigaList = programaFacade.findPrograma();
        tipoInvestigaList = parametrosDetFacade.findTipoInves();

        /////nuevo proyecto
        convocaList = convocaFacade.findConvocatoria();

        ////nuevo proyecto
        recursoConvocaList = recursosFacade.findTipoRecurso();

        //tab 2 localizacion
        localizaList = localizaFacade.findLocalizaByOrden();
        zonaPlanifList = zonaPlanifFacade.findAll();
        provinciaList = provinciaFacade.findAllOrdenados();
        cantonList = cantonFacade.findByProvincia("17");

        // tab3
        campList = campFacade.findCampus();

        subjList = subjFacade.findDepartamento();
        majrList = majrFacade.findCarrera();

        progPostgradoList = progPostgradoFacade.findProgramaPostgrado();
        lineaInvestList = lineaInvesFacade.findLineas();
        grupInvestigaList = grupoInvestFacade.findGrupoInvestiga();

        datgenprogList = datgenprogFacade.findPrograma();

        docenteInvestigacionList = docenteInvestigaFacade.findAll();
        otrosProyLits = docenteProyFacade.findUsuarioOtros();
        tipoResponDoceList = tipoResponDoceFacade.findTipoResponDocenteProyecto(new BigDecimal(1));

        aaInvList = aaInvFacade.findAreasInvestiga();

        objetivoBuenVivirList = objetivoBuenVivirFacade.findAll();
        areaEspeList = tvtopsFacade.findAll();
        areaUnescoList = areaUnescoFacade.findAll();
        paramDetPlazoEjecList = paramDetFacade.findParamDetEstado();
        bienesList = paramDetFacade.findParamDetBieneServicios();
        categoriaList = paramDetFacade.findParamDetCategoProy();
    }

    public void cargaDatosProyecto() {
        permitirEdicionPerfil = false;
        proyectoSelected = proyectoFacade.findIdFormatoByCodPro(idNotaConceptualSelected);
        if (proyectoSelected == null) {
            proyectoSelected = new SeaFormatoLargo();
            SeaDatGeneralProy notaConceptualSelected = notaConceptualFacade.find(idNotaConceptualSelected);
            proyectoSelected.setDatgeproyId(notaConceptualSelected);
        }
        apruebaNcList = apruebaNcFacade.findNotasAprobadasByCodProy(proyectoSelected.getDatgeproyId().getDatgeproyId());
        fechActual = new Date();
        procesoXConv = procesoXConvocatoriaFacade.findProcesoXConvByCodCon(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        fechaPresConv = procesoXConv.getPpcFecifin();

        if (proyectoSelected.isEstadoIngresoPerfil() && proyectoSelected.getDatgeproyId().getUsuId().equals(usuarioActual)) {
            if (fechaPresConv.after(fechActual)) {
                permitirEdicionPerfil = true;
            } else {
                RequestContext.getCurrentInstance().execute("alert('La Fecha de Presentación de Notas Conceptuales para esta convocatoria ha Caducado')");
            }

        }

        convocaProy = proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId().toString();
        progInvestiga = proyectoSelected.getDatgeproyId().getProgId().getProgId().toString();
        tituloProy = proyectoSelected.getDatgeproyId().getDatgeproyTitulo();
        tipologia = proyectoSelected.getDatgeproyId().getPrdId().getPrdId().toString();
        resultEsProy = proyectoSelected.getDatgeproyId().getDatgeproyResultadoEspera();
        metodProy = proyectoSelected.getDatgeproyId().getDatgeproyMetodologia();
        duracionProyecto = proyectoSelected.getDatgeproyId().getDatgeproyTiempoEjecucion();
        resuProy = proyectoSelected.getDatgeproyId().getDatgeproyResumen();
        desObProy = proyectoSelected.getDatgeproyId().getDatgeproyObjetivo();
        datGenProyPagLegList = notaConceptualFacade.findDatGenProyPagLegByCodProy(proyectoSelected.getDatgeproyId().getDatgeproyId());
        convocaProyecto = convocaFacade.findConvocaByIdConvoca(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        //// tab7
        investResumenList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_IMAGEN_RESUMEN);
        investObjetivList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_IMAGEN_OBJETIVO);
        anexoProyectoList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_ANEXO_PROYECTO);
        //// tab8
        // Obtener el monto de la convocatoria
        BigDecimal var = new BigDecimal(100);
        convocaProyecto = convocaFacade.findConvocaByIdConvoca(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        if (convocaProyecto != null) {
            monTot = convocaProyecto.getConvocaFinanciamiento();
        }
        financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurFisByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        if (financiamientoConvocatoria != null) {
            recursoFisico = financiamientoConvocatoria.getSfcPorcentaje().toString();
            idRecFisico = financiamientoConvocatoria.getSfcId().toString();
            BigDecimal porcA = new BigDecimal(recursoFisico);
            monTA = monTot.multiply(porcA);
            monTA = monTA.divide(var);
        }
        financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurHumaByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        if (financiamientoConvocatoria != null) {
            recursoHumano = financiamientoConvocatoria.getSfcPorcentaje().toString();
            idRecHumano = financiamientoConvocatoria.getSfcId().toString();
            BigDecimal porB = new BigDecimal(recursoHumano);
            monTB = monTot.multiply(porB);
            monTB = monTB.divide(var);
        }
        financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurLogisByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        if (financiamientoConvocatoria != null) {
            recursoLogistico = financiamientoConvocatoria.getSfcPorcentaje().toString();
            idRecLogistico = financiamientoConvocatoria.getSfcId().toString();
            BigDecimal porC = new BigDecimal(recursoLogistico);
            monTC = monTot.multiply(porC);
            monTC = monTC.divide(var);
        }
        presupuestoCLits = presupuestoFacade.findPresupuestoByCodConCodProy(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), proyectoSelected.getDatgeproyId().getDatgeproyId());
        presupuestoConvocatoria = presupuestoFacade.findRecursoPartidaByConvoca(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
        if (presupuestoConvocatoria != null) {
            tipoRecurso = presupuestoConvocatoria.getSrcId().toString();
            // montoPresupuestado = presupuestoConvocatoria.getSpcValorAsigna().toString();
            partidaPresup = presupuestoConvocatoria.getSpcId().toString();

        }
        depCenProy = new SeaDepcenproy();

        //notaConceptualSelected = notaConceptualFacade.findProyectoByCodConCodProy(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), proyectoSelected.getDatgeproyId().getDatgeproyId());
        //// tab4
        ///tab5
        responsableProyList = responsableProyFacade.findOrdenResProyectoByCodPro(idNotaConceptualSelected);

        if (responsableProyecto == null) {
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(new SegUsuario());
            responsableProyecto.setTipresId(new SeaTipoRespons());
        }
        docente = "";
        //tab6

        //proyectoSelected = proyectoFacade.findIdFormatoByCodPro(idNotaConceptualSelected);
        proyectoList = new ArrayList<>();
        proyectoList.add(proyectoSelected);
        verificarDirectorDepartamento();
        verificarIntegranteComision();
    }

    public void cargaDatosTabsProyecto() {
        //// tab8
        if (proyectoSelected.getDatgeproyId() != null) {
            BigDecimal var = new BigDecimal(100);
            /// recurso convocatoria
            recursoConvocaList = recursosFacade.findTipoRecurso();
            convocaProyecto = convocaFacade.findConvocaByIdConvoca(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
            if (convocaProyecto != null) {
                monTot = convocaProyecto.getConvocaFinanciamiento();
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurFisByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoFisico = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecFisico = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porcA = new BigDecimal(recursoFisico);
                monTA = monTot.multiply(porcA);
                monTA = monTA.divide(var);
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurHumaByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoHumano = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecHumano = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porB = new BigDecimal(recursoHumano);
                monTB = monTot.multiply(porB);
                monTB = monTB.divide(var);
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurLogisByConvocatoria(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoLogistico = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecLogistico = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porC = new BigDecimal(recursoLogistico);
                monTC = monTot.multiply(porC);
                monTC = monTC.divide(var);
            }
            presupuestoCLits = presupuestoFacade.findPresupuestoByCodConCodProy(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), proyectoSelected.getDatgeproyId().getDatgeproyId());
            presupuestoConvocatoria = presupuestoFacade.findRecursoPartidaByConvoca(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId());
            if (presupuestoConvocatoria != null) {
                tipoRecurso = presupuestoConvocatoria.getSrcId().toString();
                // montoPresupuestado = presupuestoConvocatoria.getSpcValorAsigna().toString();
                partidaPresup = presupuestoConvocatoria.getSpcId().toString();
            }
        }
        /// tabP12
        if (proyectoSelected.getDatgeproyId() != null) {
            aaInvList = aaInvFacade.findAreasInvestiga();
        }
    }

    ///funciones tabP1
    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        convocaProy = convocaProy.trim();
        progInvestiga = progInvestiga.trim();
        tipologia = tipologia.trim();
        tituloProy = tituloProy.trim();
        /*if (duracionProyecto != null) {
            duracionProyecto = duracionProyecto.trim();
        }*/
//        nomFile1 = nomFile1.trim();
        if (convocaProy.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (progInvestiga.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (tipologia.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (tituloProy.isEmpty()) {
            validaVaciosP1 = true;
        }
        /*if (duracionProyecto == null || duracionProyecto.isEmpty()) {
            validaVaciosP1 = true;
        }*/
//        if(nomFile1.isEmpty()) validaVaciosP1 = true;
        return validaVaciosP1;
    }

    /*Objetivo: Encerar variables utilizadas en el Tab 1, 
     Fecha: 21 Abril  2015
     */
    public void cancelarP1() {
        cargaDatosProyecto();
        /*progInvestiga = "";
        tipologia = "";
        tituloProy = "";
        duracionProyecto = "";
        montoProyecto = "";
        montoInstituciones = "";*/
    }

    /// cargar archivo
    public void handFileUpload1(FileUploadEvent event) throws IOException {
        nomFile1 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile1(IOUtils.toByteArray(is));

        validarVaciosP1();
    }

    public void registraP1() {
        try {
            fechActual = new Date();
            procesoXConv = procesoXConvocatoriaFacade.findProcesoXConvByCodCon(new BigDecimal(convocaProy));

            if (procesoXConv == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No sehan definido fechas de procesos para esta convocatoria"));
                return;
            }
            fechaPresConv = procesoXConv.getPpcFecifin();
            SeaConvoca convocaProyecto = new SeaConvoca();
            convocaProyecto.setConvocaId(new BigDecimal(convocaProy));
            if (fechActual.before(fechaPresConv)) {
                programaInvestigacion = new SeaPrograma();
                programaInvestigacion.setProgId(new BigDecimal(progInvestiga));
                parametrosDet = new SeaParametrosDet();
                parametrosDet.setPrdId(new Long(tipologia));
                proyectoSelected.getDatgeproyId().setDatgeproyTitulo(tituloProy);
                if (proyectoSelected.getDatgeproyId().getDatgeproyId() == null) {
                    proyectoSelected.getDatgeproyId().setProgId(programaInvestigacion);
                    System.out.println(" ingresa registro");
                    //datGeneralProy.setTipinveId(tipoInvestigacion);

                    proyectoSelected.getDatgeproyId().setDatgeproyTiempoEjecucion(duracionProyecto);
                    proyectoSelected.getDatgeproyId().setDatgeproyFechaCreacion(fechActual);
                    proyectoSelected.getDatgeproyId().setConvocaId(convocaProyecto);
                    proyectoSelected.getDatgeproyId().setPrdId(parametrosDet);
                    proyectoSelected.getDatgeproyId().setProgId(programaInvestigacion);
                    proyectoSelected.getDatgeproyId().setUsuId(usuarioActual);
                    //notaConceptualFacade.create(notaConceptualSelected);
                    //proyectoSelected.setDatgeproyId(notaConceptualSelected);
                    proyectoFacade.create(proyectoSelected);
                    idNotaConceptualSelected = proyectoSelected.getDatgeproyId().getDatgeproyId();
                    inicializarDatosProyectoNuevo();
                    cargaDatosTabsProyecto();
                    convocaId = proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId();
                    convocatoriaList = convocaFacade.findDatosConvocatoria();
                } else {
                    if (proyectoSelected.getObjetivoList() == null || proyectoSelected.getObjetivoList().isEmpty()) {
                        proyectoSelected.addObjetivoProyecto(new ObjetivoProyecto(proyectoSelected, new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_FIN), 1));
                        proyectoSelected.addObjetivoProyecto(new ObjetivoProyecto(proyectoSelected, new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_GENERAL), 2));
                    }

                    proyectoSelected.getDatgeproyId().setDatgeproyTiempoEjecucion(duracionProyecto);
                    //notaConceptualFacade.edit(notaConceptualSelected);
                    proyectoFacade.edit(proyectoSelected);
                }
            } else {
                RequestContext.getCurrentInstance().execute("alert('La Fecha de Presentación de la Nota Conceptual ha Caducado')");
                cancelarP1();
                return;
            }
            if (getSelectedNodeCode().equals("1.1")) {
                crearArbolMenu();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "Ocurrió un problema al tratar de registrar la información";
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = "No es posible eliminar el item, ya que está relacionado con otro registro.";
                } else if (t.getMessage().contains("cannot be merged because it has changed or been deleted since it was last read")) {
                    msgError = "La información está desactualizada porque otro usuario ha modificado antes que usted. Por favor ingrese nuevamente a la opción del menú e ingrese nuevamente la información requerida. ";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    //funciones tab p2
    private BigDecimal idLocalizacion;

    public void cancelarLocalizacionGeografica() {
        modoEdicion = false;
        //notaConceptualSelected = notaConceptualFacade.find(notaConceptualSelected.getDatgeproyId());
        proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
        idLocalizacion = proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId();
        root3 = crearArbolCobertura();
    }

    public void editarP2() {
        modoEdicion = true;

        if (proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId().equals(SeaLocaliza.TIPO_PROVINCIAL)) {
            zonaPlafinicacionSelected = new String[0];
            if (proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList() != null) {
                provinciaSelected = new String[proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList().size()];
            } else {
                provinciaSelected = new String[0];
            }
            int i = 0;
            for (SeaZonaDetalle seaZonaDetalle : proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList()) {
                provinciaSelected[i] = seaZonaDetalle.getProId().getProId();
                i++;
            }
        } else if (proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId().equals(SeaLocaliza.TIPO_ZONA_PLANIFICACION)) {
            provinciaSelected = new String[0];
            if (proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList() != null) {
                zonaPlafinicacionSelected = new String[proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList().size()];
            } else {
                zonaPlafinicacionSelected = new String[0];
            }
            int i = 0;
            for (SeaZonaDetalle seaZonaDetalle : proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList()) {
                zonaPlafinicacionSelected[i] = seaZonaDetalle.getZopId().getZopId().toString();
                i++;
            }
        }
    }

    public void registraP2() {
        try {
            if (!idLocalizacion.equals(proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId())) {
                //datGeneralProy.cambiarCobertura(notaConceptualSelected.getCobertura());
                proyectoSelected.getDatgeproyId().getCobertura().removeAllZonaDetalle();
            }
            if (proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId().equals(SeaLocaliza.TIPO_PROVINCIAL)) {
                if (provinciaSelected.length > 0) {
                    for (int i = 0; i < provinciaSelected.length; i++) {
                        SeaZonaDetalle zonaDetalle = new SeaZonaDetalle();
                        zonaDetalle.setProId(new SeaProvincia(provinciaSelected[i]));
                        proyectoSelected.getDatgeproyId().addZonaDetalle(zonaDetalle);
                    }
                    Iterator iterator = proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList().iterator();
                    while (iterator.hasNext()) {
                        SeaZonaDetalle seaZonaDetalle = (SeaZonaDetalle) iterator.next();
                        boolean encontro = false;
                        for (int i = 0; i < provinciaSelected.length; i++) {
                            if (provinciaSelected[i].equals(seaZonaDetalle.getProId().getProId())) {
                                encontro = true;
                                break;
                            }
                        }
                        if (!encontro) {
                            iterator.remove();
                        }

                    }
                }
            } else if (proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId().equals(SeaLocaliza.TIPO_ZONA_PLANIFICACION)) {
                if (zonaPlafinicacionSelected.length > 0) {
                    for (int i = 0; i < zonaPlafinicacionSelected.length; i++) {
                        SeaZonaDetalle zonaDetalle = new SeaZonaDetalle();
                        zonaDetalle.setZopId(new SeaZonaPlanificacion(new BigDecimal(zonaPlafinicacionSelected[i])));
                        proyectoSelected.getDatgeproyId().addZonaDetalle(zonaDetalle);
                    }
                    Iterator iterator = proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList().iterator();
                    while (iterator.hasNext()) {
                        SeaZonaDetalle seaZonaDetalle = (SeaZonaDetalle) iterator.next();
                        boolean encontro = false;
                        for (int i = 0; i < zonaPlafinicacionSelected.length; i++) {
                            if (zonaPlafinicacionSelected[i].equals(seaZonaDetalle.getZopId().getZopId().toString())) {
                                encontro = true;
                                break;
                            }
                        }
                        if (!encontro) {
                            iterator.remove();
                        }
                    }
                }
            } else if (proyectoSelected.getDatgeproyId().getCobertura().getLocalId().getLocalId().equals(SeaLocaliza.TIPO_LOCAL)) {
                Iterator<SeaZonaDetalle> it = proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList().iterator();
                while (it.hasNext()) {
                    SeaZonaDetalle svinZonaDetalleIngresado = it.next();
                    boolean encontro = false;
                    for (TreeNode node : selectedNodes2) {
                        SeaZonaDetalle svinZonaDetalleSelected = (SeaZonaDetalle) node.getData();
                        if (svinZonaDetalleIngresado.getCanId().equals(svinZonaDetalleSelected.getCanId())) {
                            encontro = true;
                            break;
                        }
                    }
                    if (!encontro) {
                        it.remove();
                    }
                }
                //Agregar los items nuevos seleccionados
                for (TreeNode node : selectedNodes2) {
                    SeaZonaDetalle svinZonaDetalleSelected = (SeaZonaDetalle) node.getData();
                    //proyectoSelected.addObjetivosProvCanParr(svinZonaDetalleSelected);
                    proyectoSelected.getDatgeproyId().addZonaDetalle(svinZonaDetalleSelected);
                }
            }
            //notaConceptualFacade.edit(notaConceptualSelected);
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarLocalizacionGeografica();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

        /*
        
        seaLocaliza.setLocalId(coberturaNew.getLocalId().getLocalId());

        int idLocaliza = coberturaNew.getLocalId().getLocalId().intValue();
        if (idLocaliza == 1) { /// localiza Local
            cobertura = new SeaCobertura();
            cobertura.setLocalId(seaLocaliza);
            cobertura.setDatgeproyId(datGeneralProyB);
            coberturaFacade.create(cobertura);

            /// Id de Provincia que selecciono del dropdown
            seaProvincia = new SeaProvincia();
            seaProvincia.setProId(provinciaId);

            if (cantonProv.length > 0) {
                for (int i = 0; i < cantonProv.length; i++) {
                    seaCanton = new SeaCanton();
                    seaCanton.setCanId(cantonProv[i]);
                    zonaDetalle = new SeaZonaDetalle();
                    zonaDetalle.setCobertId(cobertura);
                    zonaDetalle.setProId(seaProvincia);
                    zonaDetalle.setCanId(seaCanton);
                    zonaDetalleFacade.create(zonaDetalle);
                }
            }
        }
        if (idLocaliza == 2) { /// localiza Provincial
            if (provinciaSelected.length > 0) {
                /// ingreso a recorrer la lista
                cobertura = new SeaCobertura();
                cobertura.setLocalId(seaLocaliza);
                cobertura.setDatgeproyId(datGeneralProyB);
                coberturaFacade.create(cobertura);
                for (int i = 0; i < provinciaSelected.length; i++) {
                    seaProvincia = new SeaProvincia();
                    seaProvincia.setProId(provinciaSelected[i]);

                    zonaDetalle = new SeaZonaDetalle();
                    zonaDetalle.setCobertId(cobertura);
                    zonaDetalle.setProId(seaProvincia);
                    zonaDetalleFacade.create(zonaDetalle);
                }
            }
        }
        if (idLocaliza == 3) { /// localiza Nacional
            cobertura = new SeaCobertura();
            cobertura.setLocalId(seaLocaliza);
            cobertura.setDatgeproyId(datGeneralProyB);
            coberturaFacade.create(cobertura);
        }
        if (idLocaliza == 4) { /// localiza Zona Planificacion
            if (zonaPlafinicacionSelected.length > 0) {
                /// ingreso a recorrer la lista
                cobertura = new SeaCobertura();
                cobertura.setLocalId(seaLocaliza);
                cobertura.setDatgeproyId(datGeneralProyB);
                coberturaFacade.create(cobertura);
                for (int i = 0; i < zonaPlafinicacionSelected.length; i++) {
                    zonaPlanif = new SeaZonaPlanificacion();
                    zonaPlanif.setZopId(new BigDecimal(zonaPlafinicacionSelected[i]));

                    zonaDetalle = new SeaZonaDetalle();
                    zonaDetalle.setZopId(zonaPlanif);
                    zonaDetalle.setCobertId(cobertura);
                    zonaDetalleFacade.create(zonaDetalle);
                }
            }
        }
        coberturaList = coberturaFacade.findDatosCoberturaByCodPro(notaConceptualSelected.getDatgeproyId());
        RequestContext.getCurrentInstance().execute("alert('Grabación Exitosa')");
        cancelarLocalizacionGeografica();
         */
    }

    //funciones tab p5
    public String agregarP5() {
        controlGrabarP5 = true;
        return "";
    }

    public boolean validarVaciosP5() {
        validaVaciosP5 = false;
        departamento = departamento.trim();
        tipoPersonal = tipoPersonal.trim();
        nombrEstudiante = nombrEstudiante.trim();
        nombrExterno = nombrExterno.trim();
        otros = otros.trim();
        if (tipoPersonal.equals("D") && responsableProyecto.getUsuIdDocente().getUsuId() == null) {
            validaVaciosP5 = true;
        }
//        if (responsableProyecto.getUsuIdDocente().getUsuId() == null){
//           validaVaciosP5 = true; 
//        }
        if (responsableProyecto.getTipresId().getTipresId() == null) {
            validaVaciosP5 = true;
        }
        if (departamento.isEmpty()) {
            validaVaciosP5 = true;
        }
        if (tipoPersonal.equals("E") && nombrEstudiante.isEmpty()) {
            validaVaciosP5 = true;
        }
        if (tipoPersonal.equals("I") && nombrExterno.isEmpty()) {
            validaVaciosP5 = true;
        }
        if (tipoPersonal.equals("O") && otros.isEmpty()) {
            validaVaciosP5 = true;
        }
        return validaVaciosP5;
    }

    public String registraP5() {
        respOrdenProyList = responsableProyFacade.findOrdenResProyectoByCodPro(proyectoSelected.getDatgeproyId().getDatgeproyId());

        if (respOrdenProyList != null) {
            ordenInstitucion = respOrdenProyList.size() + 1;
            ordenInstit = Integer.toString(ordenInstitucion);
        } else {
            ordenInstitucion = 1;
            ordenInstit = Integer.toString(ordenInstitucion);
        }
        stvSubj = new Stvsubj();
        stvSubj = subjFacade.findDepartamentoByCodDep(departamento);
        SegUsuario docente = new SegUsuario();
        docente = docenteProyFacade.findUsuarioByCodUsu(responsableProyecto.getUsuIdDocente().getUsuId());
        System.out.println("docente " + docente);
        SeaTipoRespons tipoRespo = new SeaTipoRespons();
        SeaDatGeneralProy datGeneralProyPers = new SeaDatGeneralProy();
        datGeneralProyPers.setDatgeproyId(proyectoSelected.getDatgeproyId().getDatgeproyId());

        tipoRespo.setTipresId(responsableProyecto.getTipresId().getTipresId());
        System.out.println("tipoREspo" + tipoRespo);
        if (tipoPersonal.equals("D")) {
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(docente);
            responsableProyecto.setTipresId(tipoRespo);
            responsableProyecto.setDatgeproyId(proyectoSelected.getDatgeproyId());

            responsableProyecto.setStvsubjCode(stvSubj);
            responsableProyecto.setResprogOrden(new BigInteger(ordenInstit));
            responsableProyFacade.create(responsableProyecto);
        }
        if (tipoPersonal.equals("E")) {
            for (int i = nombrEstudiante.length(); i >= 0; i--) {
                if (i > 0 && nombrEstudiante.substring(i - 1, i).equals(" ")) {
                    if (nombrEstudiante.substring(i - 1, i).equals(" ")) {
                        int ultima = i;
                        cedula = nombrEstudiante.substring(ultima, nombrEstudiante.length());
                        break;
                    }
                }
            }
            estudianteUsuario = docenteProyFacade.findEstudianteByCedula(cedula);
            //String idEstudiante = estudianteUsuario.getUsuId().toString();
            SegUsuario estudiante = new SegUsuario();
            estudiante = docenteProyFacade.findEstudianteByCedula(cedula);
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(estudiante);
            responsableProyecto.setTipresId(tipoRespo);

            responsableProyecto.setDatgeproyId(proyectoSelected.getDatgeproyId());
            responsableProyecto.setStvsubjCode(stvSubj);
            responsableProyecto.setResprogOrden(new BigInteger(ordenInstit));
            responsableProyFacade.create(responsableProyecto);
        }
        if (tipoPersonal.equals("I")) {
            for (int i = nombrExterno.length(); i >= 0; i--) {
                if (i > 0 && nombrExterno.substring(i - 1, i).equals(" ")) {
                    if (nombrExterno.substring(i - 1, i).equals(" ")) {
                        int ultima = i;
                        cedula = nombrExterno.substring(ultima, nombrExterno.length());
                        break;
                    }
                }
            }
            estudianteUsuario = docenteProyFacade.findEstudianteByCedula(cedula);
            SegUsuario estudiante = new SegUsuario();
            estudiante = docenteProyFacade.findEstudianteByCedula(cedula);
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(estudiante);
            responsableProyecto.setTipresId(tipoRespo);
            responsableProyecto.setDatgeproyId(proyectoSelected.getDatgeproyId());

            responsableProyecto.setStvsubjCode(stvSubj);
            responsableProyecto.setResprogOrden(new BigInteger(ordenInstit));
            responsableProyFacade.create(responsableProyecto);
        }
        if (tipoPersonal.equals("O")) {
            SegUsuario otrosProyect = new SegUsuario();
            System.out.println("otros" + otros);
            otrosProyect = docenteProyFacade.findInvstOtrosByCodId(new BigDecimal(otros));
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(otrosProyect);
            responsableProyecto.setTipresId(tipoRespo);
            responsableProyecto.setDatgeproyId(proyectoSelected.getDatgeproyId());
            responsableProyecto.setStvsubjCode(stvSubj);
            responsableProyecto.setResprogOrden(new BigInteger(ordenInstit));
            responsableProyFacade.create(responsableProyecto);
        }
        responsableProyList = responsableProyFacade.findRespProyByDatPro(proyectoSelected.getDatgeproyId().getDatgeproyId());
        cancelarP5();
        return "";
    }

    public void cancelarP5() {
        controlGrabarP5 = false;
        responsableProyecto = new SeaResponsableProg();
        responsableProyecto.setUsuIdDocente(new SegUsuario());
        responsableProyecto.setTipresId(new SeaTipoRespons());
        nombrEstudiante = "";
        nombrExterno = "";
        departamento = "";
        validaVaciosP5 = true;
    }

    public void eliminarP5() {
        Integer registro = 0;
        if (responsableProyectoSelected != null) {
            SeaResponsableProg eliminar = null;
            for (int i = 0; i < responsableProyList.size(); i++) {
                SeaResponsableProg elemento = this.responsableProyList.get(i);
                if (responsableProyectoSelected.getResprogId() == responsableProyList.get(i).getResprogId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar");
                this.responsableProyList.remove(eliminar);
                responsableProyFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP5(RowEditEvent event) {
        SeaResponsableProg responsableProyEdit = new SeaResponsableProg();

//        SeaDocente doc = new SeaDocente();
//        doc.setDocId(new BigDecimal(docente));
        SegUsuario doc = new SegUsuario();
        doc.setUsuId(new BigDecimal(docente));

        SeaTipoRespons tipRes = new SeaTipoRespons();
        tipRes.setTipresId(new BigDecimal(tipoResponsabilidad));

        responsableProyEdit = (SeaResponsableProg) event.getObject();
        //docente.setDocId(responsableProyEdit.getDocId().getDocId());//// anterior

        //  responsableProyEdit.setDocId(doc);
        responsableProyEdit.setUsuIdDocente(doc);
        responsableProyEdit.setTipresId(tipRes);
        responsableProyFacade.edit(responsableProyEdit);
        responsableProyList = responsableProyFacade.findRespProyByDatPro(proyectoSelected.getDatgeproyId().getDatgeproyId());
    }

    public void onRowCancelP5(RowEditEvent event) {
    }

    //// funciones tab3
    public String aregarP3() {
        depCenProy = new SeaDepcenproy();
        controlGrabarP3 = true;
        return "";
    }

    public boolean validarVaciosP3() {
        validaVaciosP3 = false;
        centroResp = centroResp.trim();
        carrera = carrera.trim();
        programaPost = programaPost.trim();
        //numConvocat = numConvocat.trim();
        sublinea = sublinea.trim();
        grupoInvest = grupoInvest.trim();

        if (centroResp.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (carrera.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (programaPost.isEmpty()) {
            validaVaciosP3 = true;
        }
        /*if (numConvocat.isEmpty()) {
         validaVaciosP3 = true;
         }*/
        if (sublinea.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (grupoInvest.isEmpty()) {
            validaVaciosP3 = true;
        }

        return validaVaciosP3;
    }

    public String registraDatosDepartamento() {
        dptoCarrera = campusDeptoCarreraFacade.findDeptCarreraByCodId(new BigDecimal(centroResp));
        if (dptoCarrera != null) {
            idDepto = dptoCarrera.getStvsubjCode();
            idCampus = dptoCarrera.getStvcampCode();
        }
        subjDept = subjFacade.findDepartamentoByCodDep(idDepto);
        stvMajrCarre = majrFacade.findCarreraByCodCar(carrera);
        stvCampus = campFacade.findCampusByCodCamp(idCampus);

        progPostgrado = new SeaProgPostgrado();
        progPostgrado.setPostprogId(new BigDecimal(programaPost));
        lineaInvestigacion = new SeaLineainves();
        lineaInvestigacion.setLineaId(new BigDecimal(sublinea));
        grupoInvestiga = new SeaGrupinv();
        grupoInvestiga.setGrupiId(new BigDecimal(grupoInvest));

        depCenProy.setStvsubjCode(subjDept);
        depCenProy.setStvmajrCode(stvMajrCarre);
        depCenProy.setStvcampCode(stvCampus);
        depCenProy.setPostprogId(progPostgrado);
        depCenProy.setLineaId(lineaInvestigacion);
        depCenProy.setGrupiId(grupoInvestiga);
        depCenProy.setConvocaId(proyectoSelected.getDatgeproyId().getConvocaId());
        depCenProy.setDatgeproyId(proyectoSelected.getDatgeproyId());
        depCenProyFacade.edit(depCenProy);

        cancelarDatosDepartamento();
        return "";
    }

    public void cancelarDatosDepartamento() {
        //inicializar variables de entrada
        controlGrabarP3 = false;
        depCenProy = null;
        centroResp = "";
        carrera = "";
        programaPost = "";
        numConvocat = "";
        lineaInvst = "";
        sublinea = "";
        grupoInvest = "";
        validaVaciosP3 = true;
        depcenproyList = depCenProyFacade.findDepartCentroProy(idNotaConceptualSelected);
    }

    public void eliminarDatosDepartamento() {
        depCenProyFacade.remove(depcenproySelected);
        cancelarDatosDepartamento();
    }

    public void onRowEditP3(RowEditEvent event) {
        stvSubj = new Stvsubj();
        stvSubj.setStvsubjCode(centroEdit);
        stvMajr = new Stvmajr();
        stvMajr.setStvmajrCode(carreraEdit);
        convocatoria = new SeaConvoca();
        convocatoria.setConvocaId(new BigDecimal(convocatoriaEdit));
        progPostgrado = new SeaProgPostgrado();
        lineaInvestigacion = new SeaLineainves();
        grupoInvestiga = new SeaGrupinv();

        SeaDepcenproy cenproyEdit = new SeaDepcenproy();
        cenproyEdit = (SeaDepcenproy) event.getObject();
        cenproyEdit.setStvsubjCode(stvSubj);
        cenproyEdit.setStvmajrCode(stvMajr);
        cenproyEdit.setConvocaId(convocatoria);
        progPostgrado.setPostprogId(new BigDecimal(progPostEdit));
        lineaInvestigacion.setLineaId(new BigDecimal(sublineaEdit));
        grupoInvestiga.setGrupiId(new BigDecimal(grupoInvestEdit));
        cenproyEdit.setPostprogId(progPostgrado);
        cenproyEdit.setLineaId(lineaInvestigacion);
        cenproyEdit.setGrupiId(grupoInvestiga);
        depCenProyFacade.edit(cenproyEdit);
        depcenproyList = depCenProyFacade.findDepartCentroProy(proyectoSelected.getDatgeproyId().getDatgeproyId());
    }

    public void onRowCancelP3(RowEditEvent event) {
    }

    public void onSublineaChange() {
        sublineaList = lineaInvesFacade.findSublinea(new BigDecimal(lineaInvst));
        //sublineaList = lineaInvesFacade.findSublineaInvestiga();
    }

    public void onCentRespChange() {
        //centroRespList = campusDeptoCarreraFacade.findCentroRespByCampus(campus);
        List<VCampusDeptoCarrera> l = campusDeptoCarreraFacade.findCentroRespByCampus(campus);
        centroRespList = new ArrayList<>();
        for (VCampusDeptoCarrera v : l) {
            boolean encontro = false;
            for (VCampusDeptoCarrera v2 : centroRespList) {
                if (v.getStvsubjCode().equals(v2.getStvsubjCode())) {
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                centroRespList.add(v);
            }
        }
    }

    /// funciones tab4
    public String nuevoInstitucionParticipante() {
        controlGrabarP4 = true;
        opcionInstSelected = new SeaOpcionInstitucion();
        return "";
    }

    public boolean validarVaciosP4() {
        validaVaciosP4 = false;
        if (opcionInstSelected.getOpinstiRepresentaLegal().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiCedulaRl().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiTelefono().isEmpty()) {
            validaVaciosP4 = true;
        }
//        if (fax.isEmpty()) {
//            validaVaciosP4 = true;
//        }
        if (opcionInstSelected.getOpinstiMail().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiDireccion().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiCiudad().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiPaguinaWeb().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiOrganoEjecutor().isEmpty()) {
            validaVaciosP4 = true;
        }
        if (opcionInstSelected.getOpinstiNombre().isEmpty()) {
            validaVaciosP4 = true;
        }
//        if (programaInvest.isEmpty()) {
//            validaVaciosP4 = true;
//        }
        return validaVaciosP4;
    }

    public String registraInstitucionParticipante() throws ParseException {
        Date fecha = new Date();

        //// validar email
        //Pattern patronEmail = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z]{2,9}.)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mEmail = patronEmail.matcher(opcionInstSelected.getOpinstiMail());
        //check whether match is found 
        boolean matchFound = mEmail.matches();
        if (matchFound) {
            if (opcionInstSelected.getOpinstiId() == null) {
                datosOrdenList = opcionInstitucionFacade.findOrdenByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId());

                if (datosOrdenList != null) {
                    ordenInstitucion = datosOrdenList.size() + 1;
                    ordenInstit = Integer.toString(ordenInstitucion);
                } else {
                    ordenInstitucion = 1;
                    ordenInstit = Integer.toString(ordenInstitucion);
                }
                opcionInstSelected.setOpinstiFechaCrea(new Timestamp(fecha.getTime()));
                opcionInstSelected.setOpinstiOrden(new BigInteger(ordenInstit));
                opcionInstSelected.setDatgeproyId(proyectoSelected.getDatgeproyId());
                opcionInstitucionFacade.create(opcionInstSelected);
            } else {
                opcionInstitucionFacade.edit(opcionInstSelected);
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La dirección de correo no es válida"));
            return "";
        }
        validaVaciosP4 = true;
        cancelarInstitucionesParticipantes();
        return "";
    }

    public void cancelarInstitucionesParticipantes() {
        ///inicializar variables de entrada
        controlGrabarP4 = false;
        programaInvest = "";
        validaVaciosP4 = true;
        opcionInstSelected = null;
        opInstitucionList = opcionInstitucionFacade.findOpcionInstitucionByCodPro(idNotaConceptualSelected);
    }

    public void seleccionarInstitucionParticipante() {
        controlGrabarP4 = true;
    }

    public void eliminarInstitucionParticipante() {
        opcionInstitucionFacade.remove(opcionInstSelected);
        cancelarInstitucionesParticipantes();
    }

    public void onRowEditP4(RowEditEvent event) {
        SeaOpcionInstitucion opcionInstEdit = new SeaOpcionInstitucion();
        opcionInstEdit = (SeaOpcionInstitucion) event.getObject();
        opcionInstitucionFacade.edit(opcionInstEdit);
        opInstitucionList = opcionInstitucionFacade.findAll();
    }

    public void onRowCancelP4(RowEditEvent event) {
    }

    ///funcion  tab 6
    public void registraP61() {
        System.out.println(" registra 61");
        proyectoSelected.getDatgeproyId().setDatgeproyResumen(resuProy);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        proyectoSelected.getDatgeproyId().setDatgeproyObjetivo(desObProy);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        cancelarP61();
    }

    public void eliminarP61() {
        if (investAnexoResuSelected != null) {
            Sztainanex eliminar = null;
            for (int i = 0; i < investResumenList.size(); i++) {
                Sztainanex elemento = this.investResumenList.get(i);
                if (investAnexoResuSelected.getSztainanexCode() == investResumenList.get(i).getSztainanexCode()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.investResumenList.remove(eliminar);
                anexoProyectoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void eliminarP62() {
        if (investAnexoObjSelected != null) {
            Sztainanex eliminar = null;
            for (int i = 0; i < investObjetivList.size(); i++) {
                Sztainanex elemento = this.investObjetivList.get(i);
                if (investAnexoObjSelected.getSztainanexCode() == investObjetivList.get(i).getSztainanexCode()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.investObjetivList.remove(eliminar);
                anexoProyectoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void registraP62() {
        System.out.println(" registra 62");

        proyectoSelected.getDatgeproyId().setDatgeproyResultadoEspera(resultEsProy);
        proyectoSelected.getDatgeproyId().setDatgeproyPlantNombre(nomFile3);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        proyectoSelected.getDatgeproyId().setDatgeproyPlanDigi(file31);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        proyectoSelected.getDatgeproyId().setDatgeproyMetodologia(metodProy);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        cancelarP62();
    }

    public void handleFileUpload3(FileUploadEvent event) throws IOException {
        nomFile3 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile31(IOUtils.toByteArray(is));
        validarVaciosP62();
    }

    public void handleFileUploadRes(FileUploadEvent event) throws IOException {
        nomFileRes = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFileRes(IOUtils.toByteArray(is));
        if (nomFileRes != null) {
            investAnexo = new Sztainanex();
            investAnexo.setSztainanexAnexoNombre(nomFileRes);
            investAnexo.setSztainanexAnexoDigi(fileRes);
            investAnexo.setTipoAnexo(Sztainanex.TIPO_IMAGEN_RESUMEN);
            investAnexo.setDatgeproyId(proyectoSelected.getDatgeproyId());
            anexoProyectoFacade.create(investAnexo);
        }
        cancelarAnexoRes();
        //investResumenList = investAnexoFacade.findImagenResumenByCodPro(notaConceptualSelected.getDatgeproyId());
        investResumenList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_IMAGEN_RESUMEN);

        RequestContext.getCurrentInstance().execute("alert('Grabación Exitosa')");

    }

    public void cancelarAnexoRes() {
        ///inicializar variables de entrada
        nomFileRes = null;
        fileRes = null;
    }

    public void handleFileUploadDescObj(FileUploadEvent event) throws IOException {
        nomFileDes = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFileDes(IOUtils.toByteArray(is));
        if (nomFileDes != null) {
            investAnexo = new Sztainanex();
            investAnexo.setSztainanexAnexoNombre(nomFileDes);
            investAnexo.setSztainanexAnexoDigi(fileDes);
            investAnexo.setTipoAnexo(Sztainanex.TIPO_IMAGEN_OBJETIVO);
            investAnexo.setDatgeproyId(proyectoSelected.getDatgeproyId());
            anexoProyectoFacade.create(investAnexo);
        }
        //investObjetivList = investAnexoFacade.findImagenDescripByCodPro(notaConceptualSelected.getDatgeproyId());
        investObjetivList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_IMAGEN_OBJETIVO);

        cancelarAnexoDes();
        RequestContext.getCurrentInstance().execute("alert('Grabación Exitosa')");
    }

    public void cancelarAnexoDes() {
        ///inicializar variables de entrada
        nomFileDes = null;
        fileDes = null;
    }

    public void registraP63() {
        System.out.println(" registra 63");
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        cancelarP63();
    }

    public void registraP64() {
        System.out.println(" registra 64");

        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        cancelarP64();
    }

    /*
    public void registraP61() {
        System.out.println(" registra 61");
        if (notaConceptualSelected == null) {
            objetivosProyFacade.create(notaConceptualSelected);
            
        } else {
            notaConceptualSelected.setDatgeproyResumen(resuProy);
            objetivosProyFacade.edit(notaConceptualSelected);
            notaConceptualSelected.setDatgeproyObjetivo(desObProy);
           objetivosProyFacade.edit(notaConceptualSelected);
        }
        cancelarP61();
    }
     */
    public boolean validarVaciosP61() {
        validaVaciosP61 = false;
        /*  if (notaConceptualSelected.getDatgeproyResumen() == null) {
            validaVaciosP61 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyResumen().equals("")) {
                validaVaciosP61 = true;
            }
        }
//        if (notaConceptualSelected.getDatgeproyDescrip() == null) {
//            validaVaciosP61 = true;
//        } else {
//            if (notaConceptualSelected.getDatgeproyDescrip().equals("")) {
//                validaVaciosP61 = true;
//            }
//        }
        if(notaConceptualSelected.getDatgeproyObjetivo() == null){
            validaVaciosP61 = true;
        } else {
            if(notaConceptualSelected.getDatgeproyObjetivo().equals("")){
                validaVaciosP61 = true;
            }
        }*/
        resuProy = resuProy.trim();
        desObProy = desObProy.trim();
        if (resuProy.isEmpty()) {
            validaVaciosP61 = true;
        }
        if (desObProy.isEmpty()) {
            validaVaciosP61 = true;
        }
        return validaVaciosP61;
    }

    public boolean validarVaciosP62() {
        validaVaciosP62 = false;
        //validar que no esten vacias 
        /*if (notaConceptualSelected.getDatgeproyMetodologia() == null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyMetodologia().equals("")) {
                validaVaciosP62 = true;
            }
        }
        if (notaConceptualSelected.getDatgeproyPlantNombre()== null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyPlantNombre().equals("")) {
                validaVaciosP62 = true;
            }
        }
        if (notaConceptualSelected.getDatgeproyResultadoEspera() == null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyResultadoEspera().equals("")) {
                validaVaciosP62 = true;
            }
        }*/
 /*nomFile3 = nomFile3.trim();
        if (nomFile3.isEmpty()) {
            validaVaciosP62 = true;
        } else if (nomFile3 != null) {
            validaVaciosP62 = false;
        }
        resultEsProy = resultEsProy.trim();*/
        metodProy = metodProy.trim();
        /*if (resultEsProy.isEmpty()) {
            validaVaciosP62 = true;
        }*/
        if (metodProy.isEmpty()) {
            validaVaciosP62 = true;
        }
        return validaVaciosP62;
    }

    /*
    public boolean validarVaciosP62() {
        validaVaciosP62 = false;
        //validar que no esten vacias 
        if (notaConceptualSelected.getDatgeproyMetodologia() == null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyMetodologia().equals("")) {
                validaVaciosP62 = true;
            }
        }
        if (notaConceptualSelected.getDatgeproyPlantNombre()== null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyPlantNombre().equals("")) {
                validaVaciosP62 = true;
            }
        }
        if (notaConceptualSelected.getDatgeproyResultadoEspera() == null) {
            validaVaciosP62 = true;
        } else {
            if (notaConceptualSelected.getDatgeproyResultadoEspera().equals("")) {
                validaVaciosP62 = true;
            }
        }
        nomFile3 = nomFile3.trim();
        if(nomFile3.isEmpty()){
            validaVaciosP62 = true;
        } else {
            if(nomFile3 != null){
                validaVaciosP62 = false;
            }
            
        }
        return validaVaciosP62;
    }
     */
    public boolean validarVaciosP63() {
        validaVaciosP63 = false;

        if (proyectoSelected.getDatgeproyId().getDatgeproyConsideraciones() == null) {
            validaVaciosP63 = true;
        } else if (proyectoSelected.getDatgeproyId().getDatgeproyConsideraciones().equals("")) {
            validaVaciosP63 = true;
        }
        /*if (proyectoSelected.getDatgeproyId().getDatgeproyMonitoreoEvalua() == null) {
            validaVaciosP63 = true;
        } else if (proyectoSelected.getDatgeproyId().getDatgeproyMonitoreoEvalua().equals("")) {
            validaVaciosP63 = true;
        }*/
        if (proyectoSelected.getDatgeproyId().getDatgeproyConsecuencias() == null) {
            validaVaciosP63 = true;
        } else if (proyectoSelected.getDatgeproyId().getDatgeproyConsecuencias().equals("")) {
            validaVaciosP63 = true;
        }
        return validaVaciosP63;
    }

    public boolean validarVaciosP64() {
        validaVaciosP64 = false;
        if (proyectoSelected.getDatgeproyId().getDatgeproyTransferResult() == null) {
            validaVaciosP64 = true;
        } else if (proyectoSelected.getDatgeproyId().getDatgeproyTransferResult().equals("")) {
            validaVaciosP64 = true;
        }
        if (proyectoSelected.getDatgeproyId().getDatgeproyImpactoResult() == null) {
            validaVaciosP64 = true;
        } else if (proyectoSelected.getDatgeproyId().getDatgeproyImpactoResult().equals("")) {
            validaVaciosP64 = true;
        }
//        if (objetivosProy.getDatgeproyPagilegNombre()== null) {
//            validaVaciosP64 = true;
//        } else {
//            if (objetivosProy.getDatgeproyPagilegNombre().equals("")) {
//                validaVaciosP64 = true;
//            }
//        }
        return validaVaciosP64;
    }

    public void cancelarP61() {
        ///inicializar variables de entrada
        controlGrabarP61 = false;
        validaVaciosP61 = true;
    }

    public void cancelarP62() {
        ///inicializar variables de entrada
        controlGrabarP62 = false;
        validaVaciosP62 = true;
    }

    public void cancelarP63() {
        ///inicializar variables de entrada
        controlGrabarP63 = false;
        validaVaciosP63 = true;
    }

    public void cancelarP64() {
        ///inicializar variables de entrada
        controlGrabarP64 = false;
        validaVaciosP64 = true;
    }

    public List<String> completeTextP6(String query) {
        estudiantesBList = estdudiantesBFacade.findEstudiantesByName(query);
        List<String> results = new ArrayList<>();
        for (VEstudiantesB estudiantesBList1 : estudiantesBList) {
            results.add(estudiantesBList1.getUsuApellidos() + " " + estudiantesBList1.getUsuNombres() + "  " + estudiantesBList1.getUsuCc());
        }
        return results;
    }

    public List<String> completeTextExterno(String query) {
        externoProyLits = docenteProyFacade.findExternosByName(query);
        List<String> results = new ArrayList<>();
        for (SegUsuario externoProyLits1 : externoProyLits) {
            results.add(externoProyLits1.getUsuApellidos() + " " + externoProyLits1.getUsuNombres() + " " + externoProyLits1.getUsuCc());
        }
        return results;
    }

    /// funciones tabP7
    public String agregarP7() {
        controlGrabarP7 = true;
        return "";
    }

    public String registraP7() {
        proyectoSelected.getDatgeproyId().setDatgeproyPagilegNombre(nomFile2);
        proyectoSelected.getDatgeproyId().setDatgeproyPaglegDigi(file21);
        //objetivosProyFacade.edit(notaConceptualSelected);
        proyectoFacade.edit(proyectoSelected);
        datGenProyPagLegList = notaConceptualFacade.findDatGenProyPagLegByCodProy(proyectoSelected.getDatgeproyId().getDatgeproyId());
        cancelarP7();
        return "";
    }

    public void handleFileUpload2(FileUploadEvent event) throws IOException {
        nomFile2 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile21(IOUtils.toByteArray(is));
        validarVaciosP7();
    }

    public boolean validarVaciosP7() {
        validaVaciosP7 = false;
        nomFile2 = nomFile2.trim();
        if (nomFile2.isEmpty()) {
            validaVaciosP7 = true;
        }
        System.out.println("validaVaciosP7 " + validaVaciosP7);
        return validaVaciosP7;

    }

    public void cancelarP7() {
        controlGrabarP7 = false;
        nomFile2 = "";
        //objetivosProy = null;
        validaVaciosP7 = true;
    }

    public void descargarArchivo() {

        InputStream myInputStream = new ByteArrayInputStream(proyectoSelected.getDatgeproyId().getDatgeproyPaglegDigi());
//        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/optimus.jpg");
        fileLegal = new DefaultStreamedContent(myInputStream, new MimetypesFileTypeMap().getContentType(proyectoSelected.getDatgeproyId().getDatgeproyPagilegNombre()), proyectoSelected.getDatgeproyId().getDatgeproyPagilegNombre());
    }

    ///funciones tabP8
    public String agregarP8() {
        controlGrabarP8 = true;
        return "";
    }

    public String registraP8() {
        clasificadorPresup = new SeaClasificadorPresup();
        clasificadorPresup.setScpId(new BigDecimal(partidaPresup));
        recursosConvoca = new SeaRecursosConvoca();
        recursosConvoca.setSrcId(new BigDecimal(tipoRecurso));
        int entero = Integer.parseInt(tipoRecurso);

        if (proyectoSelected.getDatgeproyId() != null) {
            System.out.println("Ingresa Registro");
            SeaPresupuestoC presupuestoConvoca = new SeaPresupuestoC();
            preConvocaList = presupuestoFacade.findPartidasByConvocaRecurso(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), new BigDecimal(tipoRecurso));
            if (preConvocaList != null) {
                if (entero == 1) {
                    for (int i = 0; i < preConvocaList.size(); i++) {
                        valor = preConvocaList.get(i).getSpcValorAsigna();
                        aux = aux.add(valor);
                    }
                    aux = aux.add(new BigInteger(montoPresupuestado));
                    if (aux.doubleValue() > monTA.doubleValue()) {
                        grabaProceso = true;
                        RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTA + "')");
                    } else {
                        grabaProceso = false;
                        presupuestoConvoca.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                    }
                    financiaConvoca = new SeaFinanciaConvoca();
                    financiaConvoca.setSfcId(new BigDecimal(idRecFisico));
                }
                if (entero == 2) {
                    for (int i = 0; i < preConvocaList.size(); i++) {
                        valor = preConvocaList.get(i).getSpcValorAsigna();
                        aux = aux.add(valor);
                    }
                    aux = aux.add(new BigInteger(montoPresupuestado));
                    if (aux.doubleValue() > monTB.doubleValue()) {
                        grabaProceso = true;
                        RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTB + "')");
                    } else {
                        grabaProceso = false;
                        presupuestoConvoca.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                    }
                    financiaConvoca = new SeaFinanciaConvoca();
                    financiaConvoca.setSfcId(new BigDecimal(idRecHumano));
                }
                if (entero == 3) {
                    for (int i = 0; i < preConvocaList.size(); i++) {
                        valor = preConvocaList.get(i).getSpcValorAsigna();
                        aux = aux.add(valor);
                    }
                    aux = aux.add(new BigInteger(montoPresupuestado));
                    if (aux.doubleValue() > monTB.doubleValue()) {
                        grabaProceso = true;
                        RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTC + "')");
                    } else {
                        grabaProceso = false;
                        presupuestoConvoca.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                    }
                    financiaConvoca = new SeaFinanciaConvoca();
                    financiaConvoca.setSfcId(new BigDecimal(idRecLogistico));
                }
            } else {
                presupuestoConvoca.setSpcValorAsigna(new BigInteger(montoPresupuestado));
            }
            if (grabaProceso == false) {
                presupuestoConvoca.setSrcId(recursosConvoca);
                presupuestoConvoca.setSfcId(financiaConvoca);
                presupuestoConvoca.setScpId(clasificadorPresup);
                presupuestoConvoca.setConvocaId(proyectoSelected.getDatgeproyId().getConvocaId());
                presupuestoConvoca.setDatgeproyId(proyectoSelected.getDatgeproyId());
                presupuestoFacade.create(presupuestoConvoca);
            }
        }
        presupuestoCLits = presupuestoFacade.findPresupuestoByCodConCodProy(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), proyectoSelected.getDatgeproyId().getDatgeproyId());
        cancelarP8();
        return "";
    }

    public void cancelarP8() {
        controlGrabarP8 = false;
        montoPresupuestado = "";
        partidaPresup = "";
        tipoRecurso = "";
        aux = new BigInteger("0");

        validaVaciosP8 = true;
    }

    public boolean validarVaciosP8() {
        validaVaciosP8 = false;
        tipoRecurso = tipoRecurso.trim();
        partidaPresup = partidaPresup.trim();
        montoPresupuestado = montoPresupuestado.trim();

        if (tipoRecurso.isEmpty()) {
            validaVaciosP8 = true;
        }
        if (partidaPresup.isEmpty()) {
            validaVaciosP8 = true;
        }
        if (montoPresupuestado.isEmpty()) {
            validaVaciosP8 = true;
        }

        return validaVaciosP8;
    }

    public void onFinanciaChange() {
        int tip = Integer.parseInt(tipoRecurso);
        ///recursos Físicos
        if (tip == 1) {
            clasificadorList = clasificadorPresupFacade.findClasificadorByRecFis();
        }
        /// recursos Humanos
        if (tip == 2) {
            clasificadorList = clasificadorPresupFacade.findClasificadorByRecHum();
        }
        /// recursos Logisticos
        if (tip == 3) {
            clasificadorList = clasificadorPresupFacade.findClasificadorByRecLogFis();
        }
    }

    public void eliminarP8() {
        Integer registro = 0;
        if (presupuestoCSelected != null) {
            SeaPresupuestoC eliminar = null;
            for (int i = 0; i < presupuestoCLits.size(); i++) {
                SeaPresupuestoC elemento = this.presupuestoCLits.get(i);
                if (presupuestoCSelected.getSpcId() == presupuestoCLits.get(i).getSpcId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.presupuestoCLits.remove(eliminar);
                presupuestoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowCancelP8(RowEditEvent event) {
    }

    public void onRowEditP8(RowEditEvent event) {
        SeaPresupuestoC presupEdit = new SeaPresupuestoC();
        presupEdit = (SeaPresupuestoC) event.getObject();
        int tipoRec = Integer.parseInt(presupEdit.getSrcId().getSrcId().toString());

        if (tipoRec == 1) {
            presupuestoConvocaList = presupuestoFacade.findPartidasByConvocaRecursoCodPre(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), new BigDecimal(tipoRec), presupEdit.getSpcId());
            if (presupuestoConvocaList != null) {
                for (int i = 0; i < presupuestoConvocaList.size(); i++) {
                    valor = presupuestoConvocaList.get(i).getSpcValorAsigna();
                    aux = aux.add(valor);
                }
                aux = aux.add(presupEdit.getSpcValorAsigna());
                if (aux.doubleValue() > monTA.doubleValue()) {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTA + "')");

                } else {
                    grabaProceso = false;
                    presupEdit.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                }
            }

        }
        if (tipoRec == 2) {
            presupuestoConvocaList = presupuestoFacade.findPartidasByConvocaRecursoCodPre(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), new BigDecimal(tipoRec), presupEdit.getSpcId());
            if (presupuestoConvocaList != null) {
                for (int i = 0; i < presupuestoConvocaList.size(); i++) {
                    valor = presupuestoConvocaList.get(i).getSpcValorAsigna();
                    aux = aux.add(valor);
                }
                aux = aux.add(presupEdit.getSpcValorAsigna());
                if (aux.doubleValue() > monTB.doubleValue()) {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTB + "')");

                } else {
                    grabaProceso = false;
                    presupEdit.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                }
            }
        }

        if (tipoRec == 3) {
            presupuestoConvocaList = presupuestoFacade.findPartidasByConvocaRecursoCodPre(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), new BigDecimal(tipoRec), presupEdit.getSpcId());
            if (presupuestoConvocaList != null) {
                for (int i = 0; i < presupuestoConvocaList.size(); i++) {
                    valor = presupuestoConvocaList.get(i).getSpcValorAsigna();
                    aux = aux.add(valor);
                }
                aux = aux.add(presupEdit.getSpcValorAsigna());
                if (aux.doubleValue() > monTB.doubleValue()) {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('Cantidad sobrepasa Monto Asignado " + monTB + "')");

                } else {
                    grabaProceso = false;
                    presupEdit.setSpcValorAsigna(new BigInteger(montoPresupuestado));
                }
            }
        }
        if (grabaProceso == false) {
            presupuestoFacade.edit(presupEdit);
        }
        presupuestoCLits = presupuestoFacade.findPresupuestoByCodConCodProy(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId(), proyectoSelected.getDatgeproyId().getDatgeproyId());
        aux = new BigInteger("0");
    }

    /// funcion tabP9
    public String agregarP9() {
        controlGrabarP9 = true;
        anexoProyectoSelected = new Sztainanex();
        return "";
    }

    public String registraP9() {
        /*if(notaConceptualSelected == null){
            objetivosProyFacade.create(notaConceptualSelected);
        } else {
            notaConceptualSelected.setDatgeproyAnexosNom(nomFileP9);
            notaConceptualSelected.setDatgeproyAnexosDigi(file41);
            objetivosProyFacade.edit(notaConceptualSelected);
        }
        cancelarP9();
         */

        anexoProyectoSelected.setDatgeproyId(proyectoSelected.getDatgeproyId());
        anexoProyectoSelected.setTipoAnexo(Sztainanex.TIPO_ANEXO_PROYECTO);
        anexoProyectoFacade.create(anexoProyectoSelected);
        anexoProyectoList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_ANEXO_PROYECTO);
        anexoProyectoSelected = null;

        return "";
    }
    private Sztainanex anexoProyectoSelected;

    public Sztainanex getAnexoProyectoSelected() {
        return anexoProyectoSelected;
    }

    public void setAnexoProyectoSelected(Sztainanex anexoProyectoSelected) {
        this.anexoProyectoSelected = anexoProyectoSelected;
    }
    private StreamedContent archivoAdjunto;

    public StreamedContent getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(StreamedContent archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public void prepararArchivoDownload(Sztainanex anexoProyecto) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", anexoProyecto.getArchivoNombre());
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(anexoProyecto.getSztainanexAnexoDigi()), "application/octet-stream", anexoProyecto.getSztainanexAnexoNombre());
        } catch (Exception e) {

        }

    }

    public void eliminarP9() {
        try {
            anexoProyectoFacade.remove(anexoProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            anexoProyectoSelected = null;
            anexoProyectoList = anexoProyectoFacade.findByProyecto(proyectoSelected.getDatgeproyId().getDatgeproyId(), Sztainanex.TIPO_ANEXO_PROYECTO);
        }
    }

    public void cancelarP9() {
        controlGrabarP9 = false;
        validaVaciosP9 = true;
        anexoProyectoSelected = null;
    }

    public void handleFileUpload9(FileUploadEvent event) throws IOException {
        /*nomFileP9 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile41(IOUtils.toByteArray(is));
        validarVaciosP9();*/
        anexoProyectoSelected.setSztainanexAnexoNombre(event.getFile().getFileName());
        InputStream is = null;
        is = event.getFile().getInputstream();
        anexoProyectoSelected.setSztainanexAnexoDigi(IOUtils.toByteArray(is));
        validaVaciosP9 = false;
    }

    public void generaReporteNotasCPDF() throws SQLException, JRException {
        vDocenteDeptoB = vDocenteDeptoFacade.findCodDeptoByUsuId(usuarioActual.getUsuId());
        if (vDocenteDeptoB != null) {
            idDocente = new BigDecimal(vDocenteDeptoB.getStvcampCode());
        } else {
            idDocente = new BigDecimal(1);
        }
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";

        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/reportGrupNotasConceptuales.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        System.out.println("logo " + logo);
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/");
        parametros.put("STVCAMP_CODE", idDocente);
        parametros.put("DATGEPROY_ID", idNotaConceptualSelected.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
        System.out.println("real path   1111 " + realPath);
        exporter.exportReport();
        System.out.println(" exportes  " + exporter);
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        System.out.println("salio");
        controlPDF = true;
    }

    public void verPDF(ActionEvent actionEvent) throws SQLException, JRException, IOException {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        connection = ds_conn.getConnection();
        realPath = servletContext.getRealPath("/reportes");
        File jasper = new File(realPath + "/reportGrupNotasConceptuales.jasper");
        System.out.println(" jasper " + jasper);
        // JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/prueba3.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/img");
        parametros.put("path", realPath + "/");
        parametros.put("DATGEPROY_ID", idNotaConceptualSelected.toString());
        System.out.println(" real path " + realPath);
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, connection);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        try (ServletOutputStream outStream = response.getOutputStream()) {
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
        }
        FacesContext.getCurrentInstance().getResponseComplete();
    }

    ///funciones tabP12
    public String agregarP12() {
        controlGrabarP12 = true;
        return "";
    }

    public String registraAreaInvestigacion() {
        if (tainco == null) {
            if (aaInvest.length > 0) {
                for (int i = 0; i < aaInvest.length; i++) {
                    aaInv = new Sztaainv();
                    aaInv.setSztaainvCode(new BigDecimal(aaInvest[i]));
                    ///Buscar si area ya fue ingresada
                    areaIngresada = taincoFacade.findAreasIngresadasCByCodProyCodArea(new BigDecimal(aaInvest[i]), idNotaConceptualSelected);
                    if (areaIngresada != null) {
                        RequestContext.getCurrentInstance().execute("alert('El Área ya fue ingresada')");
                        break;
                    } else {
                        tainco = new Sztainco();
                        tainco.setDatgeproyId(proyectoSelected.getDatgeproyId());
                        tainco.setSztaainvCode(aaInv);
                        taincoFacade.create(tainco);
                    }
                }
            }
        }
        cancelarAreaInvestigacion();
        return "";
    }

    public void cancelarAreaInvestigacion() {
        controlGrabarP12 = false;
        aaInvest = null;
        tainco = null;
        validaVaciosP12 = true;
        taincoList = taincoFacade.findAreasNotasCByCodProy(idNotaConceptualSelected);
    }

    public boolean validarVaciosP12() {
        validaVaciosP12 = false;
        if (aaInvest.length < 0) {
            validaVaciosP12 = true;
        }
        return validaVaciosP12;
    }

    public void eliminarAreaInvestigacion() {
        taincoFacade.remove(taincoSelected);
        cancelarAreaInvestigacion();
    }

    /// funciones tabP14
    public void generaReportePresupuestoNC() throws SQLException, JRException {
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes/presupuesto_nota_conceptual");
        Date fecha = new Date();
        String nombreRandomico = Long.toString(fecha.getTime());
        nombreArchivoPdf = nombreRandomico + ".pdf";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/presupuesto_nota_conceptual.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("DATGEPROY_ID", idNotaConceptualSelected.toString());
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
    // getter y setter 2
    public List<SeaDatGeneralProy> getDatosGeneralesList() {
        return datosGeneralesList;
    }

    public void setDatosGeneralesList(List<SeaDatGeneralProy> datosGeneralesList) {
        this.datosGeneralesList = datosGeneralesList;
    }

    public List<SeaLocaliza> getLocalizaList() {
        return localizaList;
    }

    public void setLocalizaList(List<SeaLocaliza> localizaList) {
        this.localizaList = localizaList;
    }

    public List<SeaZonaPlanificacion> getZonaPlanifList() {
        return zonaPlanifList;
    }

    public void setZonaPlanifList(List<SeaZonaPlanificacion> zonaPlanifList) {
        this.zonaPlanifList = zonaPlanifList;
    }

    public List<SeaProvincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<SeaProvincia> provinciaList) {
        this.provinciaList = provinciaList;
    }

    public void setCantonList(List<SeaCanton> cantonList) {
        this.cantonList = cantonList;
    }

    public String getTipoPersonal() {
        if (tipoPersonal != null) {
            if (tipoPersonal.equals("D")) {
                controlTipoPersonal = true;
            } else {
                controlTipoPersonal = false;
            }
        } else {
            controlTipoPersonal = false;
        }
        if (tipoPersonal.equals("E")) {
            controlTipoEstudiante = true;
        } else {
            controlTipoEstudiante = false;
        }
        if (tipoPersonal.equals("O")) {
            controlTipoOtros = true;
        } else {
            controlTipoOtros = false;
        }
        if (tipoPersonal.equals("I")) {
            controlTipoExterno = true;
        } else {
            controlTipoExterno = false;
        }
        return tipoPersonal;
    }

    public boolean isControlTipoOtros() {
        return controlTipoOtros;
    }

    public void setControlTipoOtros(boolean controlTipoOtros) {
        this.controlTipoOtros = controlTipoOtros;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public boolean isControlTipoPersonal() {
        return controlTipoPersonal;
    }

    public void setControlTipoPersonal(boolean controlTipoPersonal) {
        this.controlTipoPersonal = controlTipoPersonal;
    }

    public boolean isControlTipoEstudiante() {
        return controlTipoEstudiante;
    }

    public void setControlTipoEstudiante(boolean controlTipoEstudiante) {
        this.controlTipoEstudiante = controlTipoEstudiante;
    }

    public String getNombrEstudiante() {
        return nombrEstudiante;
    }

    public void setNombrEstudiante(String nombrEstudiante) {
        this.nombrEstudiante = nombrEstudiante;
    }

    public boolean isControlTipoExterno() {
        return controlTipoExterno;
    }

    public void setControlTipoExterno(boolean controlTipoExterno) {
        this.controlTipoExterno = controlTipoExterno;
    }

    public String getNombrExterno() {
        return nombrExterno;
    }

    public void setNombrExterno(String nombrExterno) {
        this.nombrExterno = nombrExterno;
    }

    //setter y getter datos generales
    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public String getProgInvestiga() {
        return progInvestiga;
    }

    public void setProgInvestiga(String progInvestiga) {
        this.progInvestiga = progInvestiga;
    }

    public List<SeaPrograma> getPrgInvestigaList() {
        return prgInvestigaList;
    }

    public void setPrgInvestigaList(List<SeaPrograma> prgInvestigaList) {
        this.prgInvestigaList = prgInvestigaList;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public List<SeaParametrosDet> getTipoInvestigaList() {
        return tipoInvestigaList;
    }

    public void setTipoInvestigaList(List<SeaParametrosDet> tipoInvestigaList) {
        this.tipoInvestigaList = tipoInvestigaList;
    }

    public String getTituloProy() {
        return tituloProy;
    }

    public void setTituloProy(String tituloProy) {
        this.tituloProy = tituloProy;
    }

    public String getDuracionProyecto() {
        return duracionProyecto;
    }

    public void setDuracionProyecto(String duracionProyecto) {
        this.duracionProyecto = duracionProyecto;
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

    /// get and set p3
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

    public String getCentroResp() {
        return centroResp;
    }

    public void setCentroResp(String centroResp) {
        this.centroResp = centroResp;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getProgramaPost() {
        return programaPost;
    }

    public void setProgramaPost(String programaPost) {
        this.programaPost = programaPost;
    }

    public List<SeaProgPostgrado> getProgPostgradoList() {
        return progPostgradoList;
    }

    public void setProgPostgradoList(List<SeaProgPostgrado> progPostgradoList) {
        this.progPostgradoList = progPostgradoList;
    }

    public String getNumConvocat() {
        return numConvocat;
    }

    public void setNumConvocat(String numConvocat) {
        this.numConvocat = numConvocat;
    }

    public String getSublinea() {
        return sublinea;
    }

    public void setSublinea(String sublinea) {
        this.sublinea = sublinea;
    }

    public List<SeaLineainves> getSublineaList() {
        return sublineaList;
    }

    public void setSublineaList(List<SeaLineainves> sublineaList) {
        this.sublineaList = sublineaList;
    }

    public List<SeaLineainves> getLineaInvestList() {
        return lineaInvestList;
    }

    public void setLineaInvestList(List<SeaLineainves> lineaInvestList) {
        this.lineaInvestList = lineaInvestList;
    }

    public String getLineaInvst() {
        return lineaInvst;
    }

    public void setLineaInvst(String lineaInvst) {
        this.lineaInvst = lineaInvst;
    }

    public String getGrupoInvest() {
        return grupoInvest;
    }

    public void setGrupoInvest(String grupoInvest) {
        this.grupoInvest = grupoInvest;
    }

    public List<SeaGrupinv> getGrupInvestigaList() {
        return grupInvestigaList;
    }

    public void setGrupInvestigaList(List<SeaGrupinv> grupInvestigaList) {
        this.grupInvestigaList = grupInvestigaList;
    }

    public List<SeaDepcenproy> getDepcenproyList() {
        return depcenproyList;
    }

    public void setDepcenproyList(List<SeaDepcenproy> depcenproyList) {
        this.depcenproyList = depcenproyList;
    }

    public String getCentroEdit() {
        return centroEdit;
    }

    public void setCentroEdit(String centroEdit) {
        this.centroEdit = centroEdit;
    }

    public String getCarreraEdit() {
        return carreraEdit;
    }

    public void setCarreraEdit(String carreraEdit) {
        this.carreraEdit = carreraEdit;
    }

    public String getProgPostEdit() {
        return progPostEdit;
    }

    public void setProgPostEdit(String progPostEdit) {
        this.progPostEdit = progPostEdit;
    }

    public String getSublineaEdit() {
        return sublineaEdit;
    }

    public void setSublineaEdit(String sublineaEdit) {
        this.sublineaEdit = sublineaEdit;
    }

    public String getGrupoInvestEdit() {
        return grupoInvestEdit;
    }

    public void setGrupoInvestEdit(String grupoInvestEdit) {
        this.grupoInvestEdit = grupoInvestEdit;
    }

    public SeaDepcenproy getDepcenproySelected() {
        return depcenproySelected;
    }

    public void setDepcenproySelected(SeaDepcenproy depcenproySelected) {
        this.depcenproySelected = depcenproySelected;
    }

    /// get and set p4
    public SeaOpcionInstitucionFacade getOpcionInstitucionFacade() {
        return opcionInstitucionFacade;
    }

    public void setOpcionInstitucionFacade(SeaOpcionInstitucionFacade opcionInstitucionFacade) {
        this.opcionInstitucionFacade = opcionInstitucionFacade;
    }

    public boolean isControlGrabarP4() {
        return controlGrabarP4;
    }

    public void setControlGrabarP4(boolean controlGrabarP4) {
        this.controlGrabarP4 = controlGrabarP4;
    }

    public boolean isValidaVaciosP4() {
        return validaVaciosP4;
    }

    public void setValidaVaciosP4(boolean validaVaciosP4) {
        this.validaVaciosP4 = validaVaciosP4;
    }

    public SeaOpcionInstitucion getOpcionInstSelected() {
        return opcionInstSelected;
    }

    public void setOpcionInstSelected(SeaOpcionInstitucion opcionInstSelected) {
        this.opcionInstSelected = opcionInstSelected;
    }

    public List<SeaOpcionInstitucion> getOpInstitucionList() {
        return opInstitucionList;
    }

    public void setOpInstitucionList(List<SeaOpcionInstitucion> opInstitucionList) {
        this.opInstitucionList = opInstitucionList;
    }

    public List<SeaDatGeneralProg> getDatgenprogList() {
        return datgenprogList;
    }

    public void setDatgenprogList(List<SeaDatGeneralProg> datgenprogList) {
        this.datgenprogList = datgenprogList;
    }

    public String getDatgenEdit() {
        return datgenEdit;
    }

    public void setDatgenEdit(String datgenEdit) {
        this.datgenEdit = datgenEdit;
    }

    public Integer getOrdenInstitucion() {
        return ordenInstitucion;
    }

    public void setOrdenInstitucion(Integer ordenInstitucion) {
        this.ordenInstitucion = ordenInstitucion;
    }

    //getter y setter
    public List<SeaResponsableProg> getResponsableProyList() {
        return responsableProyList;
    }

    public void setResponsableProyList(List<SeaResponsableProg> responsableProyList) {
        this.responsableProyList = responsableProyList;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getTipoResponsabilidad() {
        return tipoResponsabilidad;
    }

    public void setTipoResponsabilidad(String tipoResponsabilidad) {
        this.tipoResponsabilidad = tipoResponsabilidad;
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

    public SeaResponsableProg getResponsableProyecto() {
        return responsableProyecto;
    }

    public void setResponsableProyecto(SeaResponsableProg responsableProyecto) {
        this.responsableProyecto = responsableProyecto;
    }

    public SeaResponsableProg getResponsableProyectoSelected() {
        return responsableProyectoSelected;
    }

    public void setResponsableProyectoSelected(SeaResponsableProg responsableProyectoSelected) {
        this.responsableProyectoSelected = responsableProyectoSelected;
    }

    public List<SegUsuario> getDocenteProyList() {
        return docenteProyList;
    }

    public void setDocenteProyList(List<SegUsuario> docenteProyList) {
        this.docenteProyList = docenteProyList;
    }

    public List<SegUsuario> getOtrosProyLits() {
        return otrosProyLits;
    }

    public void setOtrosProyLits(List<SegUsuario> otrosProyLits) {
        this.otrosProyLits = otrosProyLits;
    }

    public List<SeaTipoRespons> getTipoResponDoceList() {
        return tipoResponDoceList;
    }

    public void setTipoResponDoceList(List<SeaTipoRespons> tipoResponDoceList) {
        this.tipoResponDoceList = tipoResponDoceList;
    }

    public List<SegUsuario> getExternoProyLits() {
        return externoProyLits;
    }

    public void setExternoProyLits(List<SegUsuario> externoProyLits) {
        this.externoProyLits = externoProyLits;
    }

    //getter y setter tab 6
    public boolean isValidaVaciosP61() {
        return validaVaciosP61;
    }

    public void setValidaVaciosP61(boolean validaVaciosP61) {
        this.validaVaciosP61 = validaVaciosP61;
    }

    public boolean isValidaVaciosP62() {
        return validaVaciosP62;
    }

    public void setValidaVaciosP62(boolean validaVaciosP62) {
        this.validaVaciosP62 = validaVaciosP62;
    }

    public boolean isValidaVaciosP63() {
        return validaVaciosP63;
    }

    public void setValidaVaciosP63(boolean validaVaciosP63) {
        this.validaVaciosP63 = validaVaciosP63;
    }

    public boolean isValidaVaciosP64() {
        return validaVaciosP64;
    }

    public void setValidaVaciosP64(boolean validaVaciosP64) {
        this.validaVaciosP64 = validaVaciosP64;
    }

    public boolean isControlGrabarP61() {
        return controlGrabarP61;
    }

    public void setControlGrabarP61(boolean controlGrabarP61) {
        this.controlGrabarP61 = controlGrabarP61;
    }

    public boolean isControlGrabarP62() {
        return controlGrabarP62;
    }

    public void setControlGrabarP62(boolean controlGrabarP62) {
        this.controlGrabarP62 = controlGrabarP62;
    }

    public boolean isControlGrabarP63() {
        return controlGrabarP63;
    }

    public void setControlGrabarP63(boolean controlGrabarP63) {
        this.controlGrabarP63 = controlGrabarP63;
    }

    public boolean isControlGrabarP64() {
        return controlGrabarP64;
    }

    public void setControlGrabarP64(boolean controlGrabarP64) {
        this.controlGrabarP64 = controlGrabarP64;
    }

    public List<VEstudiantesB> getEstudiantesBList() {
        return estudiantesBList;
    }

    public void setEstudiantesBList(List<VEstudiantesB> estudiantesBList) {
        this.estudiantesBList = estudiantesBList;
    }

    /// get and set tabP7
    public boolean isValidaVaciosP7() {
        return validaVaciosP7;
    }

    public void setValidaVaciosP7(boolean validaVaciosP7) {
        this.validaVaciosP7 = validaVaciosP7;
    }

    public String getNomFile2() {
        return nomFile2;
    }

    public void setNomFile2(String nomFile2) {
        this.nomFile2 = nomFile2;
    }

    public StreamedContent getFileLegal() {
        return fileLegal;
    }

    public void setFileLegal(StreamedContent fileLegal) {
        this.fileLegal = fileLegal;
    }

    public UploadedFile getFile2() {
        return file2;
    }

    public void setFile2(UploadedFile file2) {
        this.file2 = file2;
    }

    public byte[] getFile21() {
        return file21;
    }

    public void setFile21(byte[] file21) {
        this.file21 = file21;
    }

    public boolean isControlGrabarP7() {
        return controlGrabarP7;
    }

    public void setControlGrabarP7(boolean controlGrabarP7) {
        this.controlGrabarP7 = controlGrabarP7;
    }

    public String getNomFile3() {
        return nomFile3;
    }

    public void setNomFile3(String nomFile3) {
        this.nomFile3 = nomFile3;
    }

    public UploadedFile getFile3() {
        return file3;
    }

    public void setFile3(UploadedFile file3) {
        this.file3 = file3;
    }

    public byte[] getFile31() {
        return file31;
    }

    public void setFile31(byte[] file31) {
        this.file31 = file31;
    }

    public String getNomFileRes() {
        return nomFileRes;
    }

    public void setNomFileRes(String nomFileRes) {
        this.nomFileRes = nomFileRes;
    }

    public String getNomFileDes() {
        return nomFileDes;
    }

    public void setNomFileDes(String nomFileDes) {
        this.nomFileDes = nomFileDes;
    }

    public byte[] getFileRes() {
        return fileRes;
    }

    public void setFileRes(byte[] fileRes) {
        this.fileRes = fileRes;
    }

    public byte[] getFileDes() {
        return fileDes;
    }

    public void setFileDes(byte[] fileDes) {
        this.fileDes = fileDes;
    }

    /// nuevos get and set
    public List<Stvsubj> getSubjList() {
        return subjList;
    }

    public void setSubjList(List<Stvsubj> subjList) {
        this.subjList = subjList;
    }

    public List<Stvmajr> getMajrList() {
        return majrList;
    }

    public void setMajrList(List<Stvmajr> majrList) {
        this.majrList = majrList;
    }

    public List<SeaConvoca> getConvocaList() {
        return convocaList;
    }

    public void setConvocaList(List<SeaConvoca> convocaList) {
        this.convocaList = convocaList;
    }

    public String getConvocatoriaEdit() {
        return convocatoriaEdit;
    }

    public void setConvocatoriaEdit(String convocatoriaEdit) {
        this.convocatoriaEdit = convocatoriaEdit;
    }

    public String getProgramaInvest() {
        return programaInvest;
    }

    public void setProgramaInvest(String programaInvest) {
        this.programaInvest = programaInvest;
    }

    /// get and set tab8
    public boolean isControlGrabarP8() {
        return controlGrabarP8;
    }

    public void setControlGrabarP8(boolean controlGrabarP8) {
        this.controlGrabarP8 = controlGrabarP8;
    }

    public boolean isValidaVaciosP8() {
        return validaVaciosP8;
    }

    public void setValidaVaciosP8(boolean validaVaciosP8) {
        this.validaVaciosP8 = validaVaciosP8;
    }

    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public String getConvocaProy() {
        return convocaProy;
    }

    public void setConvocaProy(String convocaProy) {
        this.convocaProy = convocaProy;
    }

    public String getRecursoFisico() {
        return recursoFisico;
    }

    public void setRecursoFisico(String recursoFisico) {
        this.recursoFisico = recursoFisico;
    }

    public String getRecursoHumano() {
        return recursoHumano;
    }

    public void setRecursoHumano(String recursoHumano) {
        this.recursoHumano = recursoHumano;
    }

    public String getRecursoLogistico() {
        return recursoLogistico;
    }

    public void setRecursoLogistico(String recursoLogistico) {
        this.recursoLogistico = recursoLogistico;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public List<SeaRecursosConvoca> getRecursoConvocaList() {
        return recursoConvocaList;
    }

    public void setRecursoConvocaList(List<SeaRecursosConvoca> recursoConvocaList) {
        this.recursoConvocaList = recursoConvocaList;
    }

    public List<SeaClasificadorPresup> getClasificadorList() {
        return clasificadorList;
    }

    public void setClasificadorList(List<SeaClasificadorPresup> clasificadorList) {
        this.clasificadorList = clasificadorList;
    }

    public String getPartidaPresup() {
        return partidaPresup;
    }

    public void setPartidaPresup(String partidaPresup) {
        this.partidaPresup = partidaPresup;
    }

    public String getMontoPresupuestado() {
        return montoPresupuestado;
    }

    public void setMontoPresupuestado(String montoPresupuestado) {
        this.montoPresupuestado = montoPresupuestado;
    }

    public List<SeaPresupuestoC> getPresupuestoCLits() {
        return presupuestoCLits;
    }

    public void setPresupuestoCLits(List<SeaPresupuestoC> presupuestoCLits) {
        this.presupuestoCLits = presupuestoCLits;
    }

    public String getTipoRecursoEdit() {
        return tipoRecursoEdit;
    }

    public void setTipoRecursoEdit(String tipoRecursoEdit) {
        this.tipoRecursoEdit = tipoRecursoEdit;
    }

    public SeaPresupuestoC getPresupuestoCSelected() {
        return presupuestoCSelected;
    }

    public void setPresupuestoCSelected(SeaPresupuestoC presupuestoCSelected) {
        this.presupuestoCSelected = presupuestoCSelected;
    }

    public BigDecimal getMonTA() {
        return monTA;
    }

    public void setMonTA(BigDecimal monTA) {
        this.monTA = monTA;
    }

    public BigDecimal getMonTB() {
        return monTB;
    }

    public void setMonTB(BigDecimal monTB) {
        this.monTB = monTB;
    }

    public BigDecimal getMonTC() {
        return monTC;
    }

    public void setMonTC(BigDecimal monTC) {
        this.monTC = monTC;
    }

    public BigDecimal getMonTot() {
        return monTot;
    }

    public void setMonTot(BigDecimal monTot) {
        this.monTot = monTot;
    }

    //// convocatoria
    public SeaConvoca getDatosConvocaSelected() {
        return datosConvocaSelected;
    }

    public void setDatosConvocaSelected(SeaConvoca datosConvocaSelected) {
        this.datosConvocaSelected = datosConvocaSelected;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPartidaPresEdit() {
        return partidaPresEdit;
    }

    public void setPartidaPresEdit(String partidaPresEdit) {
        this.partidaPresEdit = partidaPresEdit;
    }

    public String getIdRecFisico() {
        return idRecFisico;
    }

    public void setIdRecFisico(String idRecFisico) {
        this.idRecFisico = idRecFisico;
    }

    public String getIdRecHumano() {
        return idRecHumano;
    }

    public void setIdRecHumano(String idRecHumano) {
        this.idRecHumano = idRecHumano;
    }

    public String getIdRecLogistico() {
        return idRecLogistico;
    }

    public void setIdRecLogistico(String idRecLogistico) {
        this.idRecLogistico = idRecLogistico;
    }

    public boolean isGrabaProceso() {
        return grabaProceso;
    }

    public void setGrabaProceso(boolean grabaProceso) {
        this.grabaProceso = grabaProceso;
    }

    public String[] getZonaPlafinicacionSelected() {
        return zonaPlafinicacionSelected;
    }

    public void setZonaPlafinicacionSelected(String[] zonaPlafinicacionSelected) {
        this.zonaPlafinicacionSelected = zonaPlafinicacionSelected;
    }

    public String[] getProvinciaSelected() {
        return provinciaSelected;
    }

    public void setProvinciaSelected(String[] provinciaSelected) {
        this.provinciaSelected = provinciaSelected;
    }

    public String[] getCantonProv() {
        return cantonProv;
    }

    public void setCantonProv(String[] cantonProv) {
        this.cantonProv = cantonProv;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<SeaProvincia> getProList() {
        return proList;
    }

    public void setProList(List<SeaProvincia> proList) {
        this.proList = proList;
    }

    public BigDecimal getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(BigDecimal convocaId) {
        this.convocaId = convocaId;
    }

    public List<VDocenteInvestigacion> getDocenteInvestigacionList() {
        return docenteInvestigacionList;
    }

    public void setDocenteInvestigacionList(List<VDocenteInvestigacion> docenteInvestigacionList) {
        this.docenteInvestigacionList = docenteInvestigacionList;
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

    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }
    ////

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public List<Stvcamp> getCampList() {
        return campList;
    }

    public void setCampList(List<Stvcamp> campList) {
        this.campList = campList;
    }

    public List<VCampusDeptoCarrera> getCentroRespList() {
        return centroRespList;
    }

    public void setCentroRespList(List<VCampusDeptoCarrera> centroRespList) {
        this.centroRespList = centroRespList;
    }

    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    public String getIdCarre() {
        return idCarre;
    }

    public void setIdCarre(String idCarre) {
        this.idCarre = idCarre;
    }

    public String getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(String idCampus) {
        this.idCampus = idCampus;
    }

    public String getCampusEdit() {
        return campusEdit;
    }

    public void setCampusEdit(String campusEdit) {
        this.campusEdit = campusEdit;
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

    public List<Sztaainv> getAaInvList() {
        return aaInvList;
    }

    public void setAaInvList(List<Sztaainv> aaInvList) {
        this.aaInvList = aaInvList;
    }

    public String[] getAaInvest() {
        return aaInvest;
    }

    public void setAaInvest(String[] aaInvest) {
        this.aaInvest = aaInvest;
    }

    public List<Sztainco> getTaincoList() {
        return taincoList;
    }

    public void setTaincoList(List<Sztainco> taincoList) {
        this.taincoList = taincoList;
    }

    public Sztainco getTaincoSelected() {
        return taincoSelected;
    }

    public void setTaincoSelected(Sztainco taincoSelected) {
        this.taincoSelected = taincoSelected;
    }

    public String getResuProy() {
        return resuProy;
    }

    public void setResuProy(String resuProy) {
        this.resuProy = resuProy;
    }

    public String getDesObProy() {
        return desObProy;
    }

    public void setDesObProy(String desObProy) {
        this.desObProy = desObProy;
    }

    public String getMetodProy() {
        return metodProy;
    }

    public void setMetodProy(String metodProy) {
        this.metodProy = metodProy;
    }

    public String getResultEsProy() {
        return resultEsProy;
    }

    public void setResultEsProy(String resultEsProy) {
        this.resultEsProy = resultEsProy;
    }

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }

    /// Lista Cobertura
    public List<Sztainanex> getInvestResumenList() {
        return investResumenList;
    }

    public void setInvestResumenList(List<Sztainanex> investResumenList) {
        this.investResumenList = investResumenList;
    }

    public List<Sztainanex> getInvestObjetivList() {
        return investObjetivList;
    }

    public void setInvestObjetivList(List<Sztainanex> investObjetivList) {
        this.investObjetivList = investObjetivList;
    }

    public Sztainanex getInvestAnexoResuSelected() {
        return investAnexoResuSelected;
    }

    public void setInvestAnexoResuSelected(Sztainanex investAnexoResuSelected) {
        this.investAnexoResuSelected = investAnexoResuSelected;
    }

    public Sztainanex getInvestAnexoObjSelected() {
        return investAnexoObjSelected;
    }

    public void setInvestAnexoObjSelected(Sztainanex investAnexoObjSelected) {
        this.investAnexoObjSelected = investAnexoObjSelected;
    }

    public List<SeaDatGeneralProy> getDatGenProyPagLegList() {
        return datGenProyPagLegList;
    }

    public void setDatGenProyPagLegList(List<SeaDatGeneralProy> datGenProyPagLegList) {
        this.datGenProyPagLegList = datGenProyPagLegList;
    }
    //</editor-fold>

    public List<Sztainanex> getAnexoProyectoList() {
        return anexoProyectoList;
    }

    public void setAnexoProyectoList(List<Sztainanex> anexoProyectoList) {
        this.anexoProyectoList = anexoProyectoList;
    }

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void onTabChange(TabChangeEvent event) {
        String[] temp = event.getTab().getClientId().split(":");
        String id = temp[temp.length - 1];
        switch (id) {
            case "tabP1": //
                //cancelarAprobacionDirDepartamento();
                break;
            case "tabP2": //
                cancelarAprobacionDirDepartamento();
                break;
            case "tabP3": //
                cancelarAprobacionComision();
                break;
            case "tabP4": //
                cancelarPar();
                break;
            case "tabP5": //
                cancelarEvaluacionPar();
                break;

        }
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
        TreeNode root = new CheckboxTreeNode(new SeaZonaDetalle(), null);
        for (SeaProvincia provincia : provinciaList) {
            TreeNode nodoProvincia = new CheckboxTreeNode(new SeaZonaDetalle(provincia), root);
            for (SeaCanton canton : provincia.getSeaCantonList()) {
                TreeNode nodoCanton = new CheckboxTreeNode(new SeaZonaDetalle(canton), nodoProvincia);
                SeaZonaDetalle svinZonaDetalle = new SeaZonaDetalle(canton);
                if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                    nodoCanton.setSelected(true);
                }
            }
        }
        return root;
    }

    private boolean buscarSvinZonaDetalleGuardado(SeaZonaDetalle svinZonaDetalleBuscar) {
        if (proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList() != null) {
            for (SeaZonaDetalle svinZonaDetalle : proyectoSelected.getDatgeproyId().getCobertura().getZonaDetalleList()) {
                boolean encontro = svinZonaDetalle.comparar(svinZonaDetalleBuscar);
                if (encontro) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean permitirEdicionPerfil;

    public boolean isPermitirEdicionPerfil() {
        return permitirEdicionPerfil;
    }

    public void setPermitirEdicionPerfil(boolean permitirEdicionPerfil) {
        this.permitirEdicionPerfil = permitirEdicionPerfil;
    }

    public void finalizarIngresoPerfil() {
        try {
            proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL);
            //notaConceptualFacade.edit(notaConceptualSelected);
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    private TreeNode menuPerfil;
    private TreeNode menuAprobacionDirectorDepartamento;
    private TreeNode menuEvaluacionPar;

    public TreeNode getMenuPerfil() {
        return menuPerfil;
    }

    public void setMenuPerfil(TreeNode menuPerfil) {
        this.menuPerfil = menuPerfil;
    }

    public TreeNode getMenuEvaluacionPar() {
        return menuEvaluacionPar;
    }

    public void setMenuEvaluacionPar(TreeNode menuEvaluacionPar) {
        this.menuEvaluacionPar = menuEvaluacionPar;
    }

    public TreeNode getMenuAprobacionDirectorDepartamento() {
        return menuAprobacionDirectorDepartamento;
    }

    public void setMenuAprobacionDirectorDepartamento(TreeNode menuAprobacionDirectorDepartamento) {
        this.menuAprobacionDirectorDepartamento = menuAprobacionDirectorDepartamento;
    }

    public void crearArbolMenu() {
        menuPerfil = new DefaultTreeNode("Root", null);
        TreeNode node1 = new DefaultTreeNode(new OpcionMenu("1.1", "1. Datos Generales"), menuPerfil);
        //TreeNode node1_1 = new DefaultTreeNode(new OpcionMenu("1.1", "1.1. Datos Generales"), node1);
        node1.setSelected(true);
        if (proyectoSelected.getSflId() != null) {
            //TreeNode node1_2 = new DefaultTreeNode(new OpcionMenu("1.2", "1.2. Areas de Investigación"), node1);
            TreeNode node3 = new DefaultTreeNode(new OpcionMenu("3", "2. Datos de Departamento/Centro"), menuPerfil);
            TreeNode node2 = new DefaultTreeNode(new OpcionMenu("2", "3. Localización Geográfica"), menuPerfil);
            TreeNode node15 = new DefaultTreeNode(new OpcionMenu("14", "4. Objetivos del Plan Nacional del Buen Vivir"), menuPerfil);
            TreeNode node16 = new DefaultTreeNode(new OpcionMenu("15", "5. Areas de Conocimiento"), menuPerfil);
            TreeNode node4 = new DefaultTreeNode(new OpcionMenu("4", "6. Instituciones Participantes"), menuPerfil);
            TreeNode node17 = new DefaultTreeNode(new OpcionMenu("16", "7. Monto"), menuPerfil);
            TreeNode node18 = new DefaultTreeNode(new OpcionMenu("17", "8. Plazo de Ejecución"), menuPerfil);
            TreeNode node5 = new DefaultTreeNode(new OpcionMenu("5", "9. Personal del proyecto"), menuPerfil);
            TreeNode node9 = new DefaultTreeNode(new OpcionMenu("8", "10. Consideración Género y Conoc. Ancestral, Consecuencias no Intencionales"), menuPerfil);
            TreeNode node19 = new DefaultTreeNode(new OpcionMenu("18", "11. Diagnóstico y Problema"), menuPerfil);
            TreeNode node19_1 = new DefaultTreeNode(new OpcionMenu("18.1", "11.1. Diagnóstico y Problema"), node19);
            TreeNode node19_2 = new DefaultTreeNode(new OpcionMenu("18.2", "11.2. Tabla de Búsqueda"), node19);
            TreeNode node19_3 = new DefaultTreeNode(new OpcionMenu("18.3", "11.3. Análisis Comparativo"), node19);
            TreeNode node11 = new DefaultTreeNode(new OpcionMenu("10", "12. Página Legal"), menuPerfil);
            TreeNode node20 = new DefaultTreeNode(new OpcionMenu("19", "13. Objetivos del Proyecto"), menuPerfil);
            TreeNode node21 = new DefaultTreeNode(new OpcionMenu("20", "14. Detalle de Entregables del Proyecto"), menuPerfil);
            TreeNode node29 = new DefaultTreeNode(new OpcionMenu("29", "15. Categorización del Proyecto"), menuPerfil);
            TreeNode node8 = new DefaultTreeNode(new OpcionMenu("7", "16. Metodología para la Investigación"), menuPerfil);
            TreeNode node22 = new DefaultTreeNode(new OpcionMenu("21", "17. Financiamiento"), menuPerfil);
            TreeNode node23 = new DefaultTreeNode(new OpcionMenu("22", "18. Viabilidad y Plan de Sostenibilidad"), menuPerfil);
            //TreeNode node10 = new DefaultTreeNode(new OpcionMenu("9", "19. Transferencia e Impacto de Resultados"), menuPerfil);            
            TreeNode node28 = new DefaultTreeNode(new OpcionMenu("28", "19. Estrategia de Ejecución y Seguimiento"), menuPerfil);
            TreeNode node25 = new DefaultTreeNode(new OpcionMenu("24", "20. Difusión Evento"), menuPerfil);
            TreeNode node26 = new DefaultTreeNode(new OpcionMenu("25", "21. Bibliografía y Otra Producción Científica"), menuPerfil);
            TreeNode node12 = new DefaultTreeNode(new OpcionMenu("11", "22. Anexos Varios"), menuPerfil);
            TreeNode node13 = new DefaultTreeNode(new OpcionMenu("26", "23. Finalizar"), menuPerfil);
            TreeNode node14 = new DefaultTreeNode(new OpcionMenu("27", "24. Reporte"), menuPerfil);
            //TreeNode node6 = new DefaultTreeNode(new OpcionMenu("6", "6. Resumen y Descripción"), menuPerfil);
            //TreeNode node24 = new DefaultTreeNode(new OpcionMenu("23", "21. Estrategia de Ejecución"), menuPerfil);
        }

        menuAprobacionDirectorDepartamento = new DefaultTreeNode("Root1", null);
        TreeNode node222 = new DefaultTreeNode(new OpcionMenu("1", "1. Aceptación"), menuAprobacionDirectorDepartamento);
        TreeNode node333 = new DefaultTreeNode(new OpcionMenu("2", "2. Certificado"), menuAprobacionDirectorDepartamento);
        node222.setSelected(true);

        menuEvaluacionPar = new DefaultTreeNode("Root2", null);
        TreeNode node201 = new DefaultTreeNode(new OpcionMenu("1", "1. Evaluación"), menuEvaluacionPar);
        TreeNode nod202 = new DefaultTreeNode(new OpcionMenu("2", "2. Consolidación"), menuEvaluacionPar);
        if (!verificarPerfil(SegPerfil.PERFIL_INVESTIGACION_ADMINISTRADOR)) {
            nod202.setSelectable(false);
        }
        node201.setSelected(true);

    }

    private TreeNode selectedNodePerfil;
    private TreeNode selectedNodeAprobDirDepartamento;
    private TreeNode selectedNodeEvaluacionPar;

    public TreeNode getSelectedNodeEvaluacionPar() {
        return selectedNodeEvaluacionPar;
    }

    public void setSelectedNodeEvaluacionPar(TreeNode selectedNodeEvaluacionPar) {
        this.selectedNodeEvaluacionPar = selectedNodeEvaluacionPar;
    }

    public TreeNode getSelectedNodeAprobDirDepartamento() {
        return selectedNodeAprobDirDepartamento;
    }

    public void setSelectedNodeAprobDirDepartamento(TreeNode selectedNodeAprobDirDepartamento) {
        this.selectedNodeAprobDirDepartamento = selectedNodeAprobDirDepartamento;
    }

    public TreeNode getSelectedNodePerfil() {
        return selectedNodePerfil;
    }

    public void setSelectedNodePerfil(TreeNode selectedNodePerfil) {
        this.selectedNodePerfil = selectedNodePerfil;
    }

    public void onNodeSelectPerfil(NodeSelectEvent event) {
        try {
            /*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
         FacesContext.getCurrentInstance().addMessage(null, message);*/
            modoEdicion = false;
            OpcionMenu opcionMenu = (OpcionMenu) selectedNodePerfil.getData();
            switch (opcionMenu.getCodigo()) {
                case "1.1": //Datos generales
                    cancelarP1();
                    break;
                case "1.2":
                    cancelarAreaInvestigacion();
                    break;
                case "2":
                    cancelarLocalizacionGeografica();
                    break;
                case "3":
                    cancelarDatosDepartamento();
                    break;
                case "4":
                    cancelarInstitucionesParticipantes();
                    break;
                case "18.1":
                    cancelarDiagnosticoProblema();
                    break;
                case "18.2":
                    cancelarTablaBusqueda();
                    break;
                case "18.3":
                    cancelarAnalisisComparativo();
                    break;
                case "19": //Datos generales
                    cancelarP1();
                    break;
                case "21":
                    cancelarFinanciamiento();
                    break;
                case "22":
                    cancelarViabilidad();
                    break;
                case "23":
                    cancelarEstrategiaEjecucion();
                    break;
                case "24":
                    cancelarDifusionEvento();
                    break;
                case "25":
                    cancelarFormatoBibliografia();
                    break;
                case "27":
                    generaReporteFormatoLargo();
                    break;
                case "28":
                    initCronograma();
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onNodeSelectAprobDirDepartamento(NodeSelectEvent event) {
        try {
            OpcionMenu opcionMenu = (OpcionMenu) selectedNodeAprobDirDepartamento.getData();
            switch (opcionMenu.getCodigo()) {
                case "1": //
                    cancelarAprobacionDirDepartamento();
                    break;
                case "2":
                    cancelarAreaInvestigacion();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onNodeSelectEvaluacionPar(NodeSelectEvent event) {
        try {
            OpcionMenu opcionMenu = (OpcionMenu) selectedNodeEvaluacionPar.getData();
            switch (opcionMenu.getCodigo()) {
                case "1": //
                    cancelarEvaluacionPar();
                    break;
                case "2":
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    public String getSelectedNodeCode() {
        if (selectedNodePerfil != null) {
            return ((OpcionMenu) selectedNodePerfil.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public String getSelectedNodeCodeAprobDirDepartamento() {
        if (selectedNodeAprobDirDepartamento != null) {
            return ((OpcionMenu) selectedNodeAprobDirDepartamento.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public String getSelectedNodeCodeEvaluacionPar() {
        if (selectedNodeEvaluacionPar != null) {
            return ((OpcionMenu) selectedNodeEvaluacionPar.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public SeaFormatoLargo getProyectoSelected() {
        return proyectoSelected;
    }

    public void setProyectoSelected(SeaFormatoLargo proyectoSelected) {
        this.proyectoSelected = proyectoSelected;
    }

    private Sztaobjbvpr objetivoBuenVivirProyectoSelected;

    public Sztaobjbvpr getObjetivoBuenVivirProyectoSelected() {
        return objetivoBuenVivirProyectoSelected;
    }

    public void setObjetivoBuenVivirProyectoSelected(Sztaobjbvpr objetivoBuenVivirProyectoSelected) {
        this.objetivoBuenVivirProyectoSelected = objetivoBuenVivirProyectoSelected;
    }

    public void nuevoObjetivoBuenVivir() {
        //controlGrabarP3 = true;
        objetivoBuenVivirProyectoSelected = new Sztaobjbvpr();

    }
    @EJB
    private SztaobjbvprFacade objetivoBuenVivirProyectoFacade;

    public void registraObjetivoBuenVivir() {
        try {
            if (proyectoSelected.existeObjetivoBuenVivir(objetivoBuenVivirProyectoSelected)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El objetivo seleccionadp ya ha sido registrado."));
                return;
            }
            if (objetivoBuenVivirProyectoSelected.getSflId() == null) {
                objetivoBuenVivirProyectoSelected.setSflId(proyectoSelected);
                objetivoBuenVivirProyectoFacade.create(objetivoBuenVivirProyectoSelected);
            } else {
                objetivoBuenVivirProyectoFacade.edit(objetivoBuenVivirProyectoSelected);
            }
            proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
            objetivoBuenVivirProyectoSelected = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }
    private List<SeaObplanbv> objetivoBuenVivirList;

    public List<SeaObplanbv> getObjetivoBuenVivirList() {
        return objetivoBuenVivirList;
    }

    public void setObjetivoBuenVivirList(List<SeaObplanbv> objetivoBuenVivirList) {
        this.objetivoBuenVivirList = objetivoBuenVivirList;
    }

    @EJB
    private SeaObplanbvFacade objetivoBuenVivirFacade;

    public void cancelarObjetivoBuenVivir() {
        objetivoBuenVivirProyectoSelected = null;
    }
    @EJB
    private SztapolobjbvFacade politicaObjBuenVivirFacade;
    private Sztapolobjbv politicaObjBuenVivirSelected;

    public Sztapolobjbv getPoliticaObjBuenVivirSelected() {
        return politicaObjBuenVivirSelected;
    }

    public void setPoliticaObjBuenVivirSelected(Sztapolobjbv politicaObjBuenVivirSelected) {
        this.politicaObjBuenVivirSelected = politicaObjBuenVivirSelected;
    }

    public void nuevoPolitica() {
        politicaObjBuenVivirSelected = new Sztapolobjbv();

    }

    public void registraPoliticaObjetivoBuenVivir() {
        try {

            if (politicaObjBuenVivirSelected.getSztapolobjbvCode() == null) {
                politicaObjBuenVivirSelected.setSztaobjbvprCode(objetivoBuenVivirProyectoSelected);
                politicaObjBuenVivirFacade.create(politicaObjBuenVivirSelected);
            } else {
                politicaObjBuenVivirFacade.edit(politicaObjBuenVivirSelected);
            }
            objetivoBuenVivirProyectoSelected = null;
            proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            RequestContext.getCurrentInstance().execute("PF('dialogPolitica').hide();");

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void eliminarPoliticaObjetivoBuenVivir() {

        try {
            politicaObjBuenVivirFacade.remove(politicaObjBuenVivirSelected);
            politicaObjBuenVivirSelected = null;
            proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void eliminarObjetivoBuenVivir() {
        try {
            objetivoBuenVivirProyectoFacade.remove(objetivoBuenVivirProyectoSelected);
            objetivoBuenVivirProyectoSelected = null;
            proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    public void registraProyecto() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarProyecto() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getSflId());
    }

    @EJB
    private StvtopsFacade tvtopsFacade;
    private List<Stvtops> areaEspeList;

    public List<Stvtops> getAreaEspeList() {
        return areaEspeList;
    }

    public void setAreaEspeList(List<Stvtops> areaEspeList) {
        this.areaEspeList = areaEspeList;
    }
    private List<SeaAreacUnesco> areaUnescoList;
    @EJB
    private SeaAreacUnescoFacade areaUnescoFacade;

    public List<SeaAreacUnesco> getAreaUnescoList() {
        return areaUnescoList;
    }

    public void setAreaUnescoList(List<SeaAreacUnesco> areaUnescoList) {
        this.areaUnescoList = areaUnescoList;
    }

    public String registraMonto() {
        proyectoSelected.setSflPresupTotal(proyectoSelected.getPresupuestoTotal());
        proyectoFacade.edit(proyectoSelected);
        cancelarProyecto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    private boolean validaVaciosPlazoEjecucuion;

    public boolean isValidaVaciosPlazoEjecucuion() {
        return validaVaciosPlazoEjecucuion;
    }

    public void setValidaVaciosPlazoEjecucuion(boolean validaVaciosPlazoEjecucuion) {
        this.validaVaciosPlazoEjecucuion = validaVaciosPlazoEjecucuion;
    }

    private String paramEstado;

    public String getParamEstado() {
        return paramEstado;
    }

    public void setParamEstado(String paramEstado) {
        this.paramEstado = paramEstado;
    }

    private List<SeaFormatoLargo> proyectoList;

    public List<SeaFormatoLargo> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<SeaFormatoLargo> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public void registraPlazoEjecucion() {
        /*SeaParametrosDet parametrosDetalle = new SeaParametrosDet();
        parametrosDetalle.setPrdId(new Long(paramEstado));
        proyectoSelected.setPrdId(parametrosDetalle);*/
        proyectoFacade.edit(proyectoSelected);
        proyectoList = proyectoFacade.findFormatoByCodPro(idNotaConceptualSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        cancelarPlazoEjecucion();
    }

    public void cancelarPlazoEjecucion() {
        proyectoSelected = proyectoFacade.findIdFormatoByCodPro(idNotaConceptualSelected);
        proyectoList = new ArrayList<>();
        proyectoList.add(proyectoSelected);
        paramEstado = "";
        validaVacios = true;
        modoEdicion = false;
    }
    private List<SeaParametrosDet> paramDetPlazoEjecList;

    public List<SeaParametrosDet> getParamDetPlazoEjecList() {
        return paramDetPlazoEjecList;
    }

    public void setParamDetPlazoEjecList(List<SeaParametrosDet> paramDetPlazoEjecList) {
        this.paramDetPlazoEjecList = paramDetPlazoEjecList;
    }
    @EJB
    private SeaParametrosDetFacade paramDetFacade;

    public boolean validarVaciosPlazoEjecucion() {
        validaVacios = false;
        if (proyectoSelected.getSflFechaPresenta() == null) {
            validaVacios = true;
        }
        if (proyectoSelected.getSflFechaInicio() == null) {
            validaVacios = true;
        }
        if (proyectoSelected.getSflFechaFinaliza() == null) {
            validaVacios = true;
        }
        return validaVacios;
    }

    private boolean validaVacios;

    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public void registraDiagnisticoProblema() {
        try {
            if (diagnosticoProblema.getSdpId() == null) {
                diagnosticoProblema.setSflId(proyectoSelected);
                diagnosProblemfacade.create(diagnosticoProblema);
            } else {
                diagnosProblemfacade.edit(diagnosticoProblema);
            }
            cancelarDiagnosticoProblema();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }
    @EJB
    private SeaDiagnosProblemaFacade diagnosProblemfacade;
    private SeaDiagnosProblema diagnosticoProblema;

    public SeaDiagnosProblema getDiagnosticoProblema() {
        return diagnosticoProblema;
    }

    public void setDiagnosticoProblema(SeaDiagnosProblema diagnosticoProblema) {
        this.diagnosticoProblema = diagnosticoProblema;
    }

    public void cancelarDiagnosticoProblema() {
        diagnosticoProblema = diagnosProblemfacade.findDiagnosticoProblemByCodForLarg(proyectoSelected.getSflId());
        if (diagnosticoProblema == null) {
            diagnosticoProblema = new SeaDiagnosProblema();
        }
    }

    @EJB
    private SeaTablaContenidoFacade tablaContenidoFacade;
    private SeaTablaContenido tablaContenidoSelected;

    public SeaTablaContenido getTablaContenidoSelected() {
        return tablaContenidoSelected;
    }

    public void setTablaContenidoSelected(SeaTablaContenido tablaContenidoSelected) {
        this.tablaContenidoSelected = tablaContenidoSelected;
    }

    public void nuevoTablaBusqueda() {
        tablaContenidoSelected = new SeaTablaContenido();
    }

    public void registraTablaBusqueda() {
        if (diagnosticoProblema.getSdpId() == null) {
            diagnosticoProblema.setSflId(proyectoSelected);
            diagnosProblemfacade.create(diagnosticoProblema);
        }
        if (tablaContenidoSelected.getStcId() == null) {
            tablaContenidoSelected.setSdpId(diagnosticoProblema);
            tablaContenidoFacade.create(tablaContenidoSelected);
        } else {
            tablaContenidoFacade.edit(tablaContenidoSelected);
        }
        cancelarTablaBusqueda();
    }

    public void cancelarTablaBusqueda() {
        tablaContenidoSelected = null;
        cancelarDiagnosticoProblema();
    }

    public void eliminarTablaBusqueda() {
        try {
            tablaContenidoFacade.remove(tablaContenidoSelected);
            tablaContenidoSelected = null;
            cancelarTablaBusqueda();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }

    }

    public void cancelarAnalisisComparativo() {
        analisisFormato = analisisFormatoFacade.findAnalisiFormatoByCodForml(proyectoSelected.getSflId());
        if (analisisFormato == null) {
            analisisFormato = new SeaAnalisisFormato();
        }
    }

    public String registraAnalisisComparativo() {
        analisisFormato.setSafNumDocTotal(analisisFormato.getTotalDocentes());
        analisisFormato.setSafNumEstTotal(analisisFormato.getTotalEstudiantes());
        analisisFormato.setSafTotalNumDirectos(analisisFormato.getTotalDirectos());
        if (analisisFormato.getSafId() == null) {
            analisisFormato.setSflId(proyectoSelected);
            analisisFormatoFacade.create(analisisFormato);
        } else {
            analisisFormatoFacade.edit(analisisFormato);
        }
        cancelarAnalisisComparativo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }
    @EJB
    private SeaAnalisisFormatoFacade analisisFormatoFacade;
    private SeaAnalisisFormato analisisFormato;

    public SeaAnalisisFormato getAnalisisFormato() {
        return analisisFormato;
    }

    public void setAnalisisFormato(SeaAnalisisFormato analisisFormato) {
        this.analisisFormato = analisisFormato;
    }

    @EJB
    private SeaObjEntregablesFacade entregableFacade;
    private SeaObjEntregables entregableSelected;

    public SeaObjEntregables getEntregableSelected() {
        return entregableSelected;
    }

    public void setEntregableSelected(SeaObjEntregables entregableSelected) {
        this.entregableSelected = entregableSelected;
    }

    public void cancelarEntregable() {
        entregableSelected = null;
        cancelarProyecto();
    }

    public void nuevoEntregable() {
        entregableSelected = new SeaObjEntregables();
    }

    public void registraEntregable() {
        if (entregableSelected.getSoeId() == null) {
            entregableSelected.setSflId(proyectoSelected);
            entregableFacade.create(entregableSelected);
            //RequestContext.getCurrentInstance().execute("alert('Grabado Exitoso')"); 
        } else {
            entregableFacade.edit(entregableSelected);
        }
        cancelarEntregable();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
    }

    public void eliminarEntregable() {
        entregableFacade.remove(entregableSelected);
        cancelarEntregable();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
    }
    private List<SeaParametrosDet> bienesList;

    public List<SeaParametrosDet> getBienesList() {
        return bienesList;
    }

    public void setBienesList(List<SeaParametrosDet> bienesList) {
        this.bienesList = bienesList;
    }

    public void nuevoAdquisicion() {
        objAdquisisioneSelected = new SeaObjAdquisisiones();
    }
    private SeaObjAdquisisiones objAdquisisioneSelected;

    public SeaObjAdquisisiones getObjAdquisisioneSelected() {
        return objAdquisisioneSelected;
    }

    public void setObjAdquisisioneSelected(SeaObjAdquisisiones objAdquisisioneSelected) {
        this.objAdquisisioneSelected = objAdquisisioneSelected;
    }

    @EJB
    private SeaObjAdquisisionesFacade objAdquisisionesFacade;

    public void registraAdquisicion() {
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
            objAdquisisioneSelected.setSoeId(entregableSelected);
            objAdquisisionesFacade.create(objAdquisisioneSelected);
        } else {
            objAdquisisionesFacade.edit(objAdquisisioneSelected);
        }
        entregableSelected = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        RequestContext.getCurrentInstance().execute("PF('dialogAdquisiciones').hide();");
        cancelarEntregable();
        //cancelarP13();
    }

    public void eliminarAdquisicion() {
        objAdquisisionesFacade.remove(objAdquisisioneSelected);
        cancelarEntregable();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
    }
    private List<SeaParametrosDet> categoriaList;

    public List<SeaParametrosDet> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<SeaParametrosDet> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public void registraFinanciamiento() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarFinanciamiento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarFinanciamiento() {
        proyectoSelected = proyectoFacade.findIdFormatoByCodPro(idNotaConceptualSelected);
        proyectoList = new ArrayList<>();
        proyectoList.add(proyectoSelected);
        modoEdicion = false;
    }

    public void subirDocumentoFinanciamiento(FileUploadEvent event) throws IOException {
        proyectoSelected.setSflNombreFinan(event.getFile().getFileName());
        InputStream is = event.getFile().getInputstream();
        proyectoSelected.setSflDigiFinan(IOUtils.toByteArray(is));
        //validarVaciosP23();
    }
    private StreamedContent documentoFinanciamiento;

    public StreamedContent getDocumentoFinanciamiento() {
        return documentoFinanciamiento;
    }

    public void setDocumentoFinanciamiento(StreamedContent documentoFinanciamiento) {
        this.documentoFinanciamiento = documentoFinanciamiento;
    }

    public void prepararDocumentoFinanciamientoDownload() {
        this.documentoFinanciamiento = new DefaultStreamedContent(new ByteArrayInputStream(proyectoSelected.getSflDigiFinan()), "application/octet-stream", proyectoSelected.getSflNombreFinan());
    }

    @EJB
    private SeaFormatoViabilidadFacade formatoViabilidadFacade;
    private SeaFormatoViabilidad formatoViabilidadSelected;

    public SeaFormatoViabilidad getFormatoViabilidadSelected() {
        return formatoViabilidadSelected;
    }

    public void setFormatoViabilidadSelected(SeaFormatoViabilidad formatoViabilidadSelected) {
        this.formatoViabilidadSelected = formatoViabilidadSelected;
    }

    public void cancelarViabilidad() {
        formatoViabilidadSelected = formatoViabilidadFacade.findFormtViabilidadByCodFormL(proyectoSelected.getSflId());
        if (formatoViabilidadSelected == null) {
            formatoViabilidadSelected = new SeaFormatoViabilidad();
        }
    }

    public void registraViabilidad() {
        try {
            if (formatoViabilidadSelected.getSfaId() == null) {
                formatoViabilidadSelected.setSflId(proyectoSelected);
                formatoViabilidadFacade.create(formatoViabilidadSelected);
            } else {
                formatoViabilidadFacade.edit(formatoViabilidadSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarViabilidad();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    @EJB
    private SeaFormatoEstrategiaeFacade formatoEstrategiaFacade;
    private SeaFormatoEstrategiae formatoEstrategiaSelected;
    private List<SeaFormatoEstrategiae> formatoEstrategiaList;

    public SeaFormatoEstrategiae getFormatoEstrategiaSelected() {
        return formatoEstrategiaSelected;
    }

    public void setFormatoEstrategiaSelected(SeaFormatoEstrategiae formatoEstrategiaSelected) {
        this.formatoEstrategiaSelected = formatoEstrategiaSelected;
    }

    public List<SeaFormatoEstrategiae> getFormatoEstrategiaList() {
        return formatoEstrategiaList;
    }

    public void setFormatoEstrategiaList(List<SeaFormatoEstrategiae> formatoEstrategiaList) {
        this.formatoEstrategiaList = formatoEstrategiaList;
    }

    public void cancelarEstrategiaEjecucion() {
        formatoEstrategiaSelected = null;
        formatoEstrategiaList = formatoEstrategiaFacade.findFormatoEntregableByCodFormL(idNotaConceptualSelected);
        if (formatoEstrategiaList == null) {
            formatoEstrategiaList = new ArrayList<>();
            formatoEstrategiaList.add(new SeaFormatoEstrategiae());
        }
    }

    public void registraEstrategiaEjecucion() {
        try {
            if (formatoEstrategiaSelected.getSfeId() == null) {
                formatoEstrategiaSelected.setSflId(proyectoSelected);
                formatoEstrategiaFacade.create(formatoEstrategiaSelected);
            } else {
                formatoEstrategiaFacade.edit(formatoEstrategiaSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarEstrategiaEjecucion();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void subirDocumentoEstrategiaEjecucion(FileUploadEvent event) throws IOException {
        formatoEstrategiaSelected.setSfeNombreArchivo(event.getFile().getFileName());
        InputStream is = event.getFile().getInputstream();
        formatoEstrategiaSelected.setSfeArchivoDigital(IOUtils.toByteArray(is));
    }

    public void prepararDocumentoEstrategiaEjecucionDownload(SeaFormatoEstrategiae formatoEstrategia) {
        //proyectoSelected.setSflDigiFinan(IOUtils.toByteArray(is));
        this.documentoEstrategiaEjecucion = new DefaultStreamedContent(new ByteArrayInputStream(formatoEstrategia.getSfeArchivoDigital()), "application/octet-stream", formatoEstrategia.getSfeNombreArchivo());
        //this.documentoEstrategiaEjecucion = new DefaultStreamedContent(new ByteArrayInputStream(proyectoSelected.getSflDigiFinan()), "application/octet-stream", proyectoSelected.getSflNombreFinan());
    }

    private StreamedContent documentoEstrategiaEjecucion;

    public StreamedContent getDocumentoEstrategiaEjecucion() {
        return documentoEstrategiaEjecucion;
    }

    public void setDocumentoEstrategiaEjecucion(StreamedContent documentoEstrategiaEjecucion) {
        this.documentoEstrategiaEjecucion = documentoEstrategiaEjecucion;
    }

    @EJB
    private SeaFdifusionEventoFacade difusionEventoFacade;
    private SeaFdifusionEvento difusionEventoSelected;
    private List<SeaFdifusionEvento> difusionEveantoList;

    public SeaFdifusionEvento getDifusionEventoSelected() {
        return difusionEventoSelected;
    }

    public void setDifusionEventoSelected(SeaFdifusionEvento difusionEventoSelected) {
        this.difusionEventoSelected = difusionEventoSelected;
    }

    public List<SeaFdifusionEvento> getDifusionEveantoList() {
        return difusionEveantoList;
    }

    public void setDifusionEveantoList(List<SeaFdifusionEvento> difusionEveantoList) {
        this.difusionEveantoList = difusionEveantoList;
    }

    public void nuevoDifusionEvento() {
        difusionEventoSelected = new SeaFdifusionEvento();
    }

    public void registraDifusionEvento() {
        try {
            if (difusionEventoSelected.getSfdeId() == null) {
                difusionEventoSelected.setSflId(proyectoSelected);
                difusionEventoFacade.create(difusionEventoSelected);
            } else {
                difusionEventoFacade.edit(difusionEventoSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarDifusionEvento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarDifusionEvento() {
        difusionEveantoList = difusionEventoFacade.findDifusionEventeByCodFormL(proyectoSelected.getSflId());
        difusionEventoSelected = null;
        formatoDifusionSelected = null;
    }

    public void eliminarDifusionEvento() {
        try {
            difusionEventoFacade.remove(difusionEventoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
            cancelarDifusionEvento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de eliminar el item seleccionado"));
        }
    }
    private SeaFormatoDifusion formatoDifusionSelected;

    public SeaFormatoDifusion getFormatoDifusionSelected() {
        return formatoDifusionSelected;
    }

    public void setFormatoDifusionSelected(SeaFormatoDifusion formatoDifusionSelected) {
        this.formatoDifusionSelected = formatoDifusionSelected;
    }

    @EJB
    private SeaFormatoDifusionFacade formatoDifusionFacade;

    public void eliminarFormatoDifusion() {
        try {
            formatoDifusionFacade.remove(formatoDifusionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
            cancelarDifusionEvento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de eliminar el item seleccionado"));
        }
    }

    public void nuevoFormatoDifusion() {
        formatoDifusionSelected = new SeaFormatoDifusion();
    }

    public void registraFormatoDifusion() {
        try {
            if (formatoDifusionSelected.getSfdId() == null) {
                formatoDifusionSelected.setSfdeId(difusionEventoSelected);
                formatoDifusionFacade.create(formatoDifusionSelected);
            } else {
                formatoDifusionFacade.edit(formatoDifusionSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarDifusionEvento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    @EJB
    private SeaFormatoBibliografiaFacade formatoBibliografiaFacade;
    private SeaFormatoBibliografia formatoBibliografiaSelected;
    private List<SeaFormatoBibliografia> formatoBibliografiaList;

    public SeaFormatoBibliografia getFormatoBibliografiaSelected() {
        return formatoBibliografiaSelected;
    }

    public void setFormatoBibliografiaSelected(SeaFormatoBibliografia formatoBibliografiaSelected) {
        this.formatoBibliografiaSelected = formatoBibliografiaSelected;
    }

    public List<SeaFormatoBibliografia> getFormatoBibliografiaList() {
        return formatoBibliografiaList;
    }

    public void setFormatoBibliografiaList(List<SeaFormatoBibliografia> formatoBibliografiaList) {
        this.formatoBibliografiaList = formatoBibliografiaList;
    }

    public void nuevoFormatoBibliografia() {
        formatoBibliografiaSelected = new SeaFormatoBibliografia();
    }

    public void registraFormatoBibliografia() {
        try {
            if (formatoBibliografiaSelected.getSfbId() == null) {
                formatoBibliografiaSelected.setSflId(proyectoSelected);
                formatoBibliografiaFacade.create(formatoBibliografiaSelected);
            } else {
                formatoBibliografiaFacade.edit(formatoBibliografiaSelected);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarFormatoBibliografia();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarFormatoBibliografia() {
        formatoBibliografiaSelected = null;
        formatoBibliografiaList = formatoBibliografiaFacade.findFormatoBiblioByCodFormL(proyectoSelected.getSflId());
    }

    public void eliminarFormatoBibliografia() {
        try {
            formatoBibliografiaFacade.remove(formatoBibliografiaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El item se eliminó exitosamente"));
            cancelarFormatoBibliografia();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de eliminar el item seleccionado"));
        }
    }

    @EJB
    private VDocenteDeptoBFacade vDocenteDeptoBFacade;

    public void generaReporteFormatoLargo() throws SQLException, JRException {
        BigDecimal idUsuario = proyectoSelected.getDatgeproyId().getUsuId().getUsuId();
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
        parametros.put("DATGEPROY_ID", idNotaConceptualSelected.toString());
        parametros.put("SFL_ID", proyectoSelected.getSflId().toString());
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

    public void guardarAprobacionDirDepartamento() {
        try {
            AprobacionDirectorDepartamento ap = proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento();
            ap.setFecha(new Date());
            ap.setUsuario(usuarioActual);
            if (ap.isAprobado()) {
                proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO);
            } else {
                proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO);
            }
            notaConceptualFacade.edit(proyectoSelected.getDatgeproyId());
            cancelarAprobacionDirDepartamento();
            //generarCertificadoPDF();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarAprobacionDirDepartamento() {
        try {
            cancelarProyecto();
            proyectoSelected.getDatgeproyId().addAprobacionDirectorDepartamento();
            generarCertificadoPDF();
            if (proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().getId() != null) {
                archivoAceptacionDirDepartamento = new DefaultStreamedContent(new ByteArrayInputStream(proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().getArchivoDigital()), "application/octet-stream", proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().getArchivoNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String nombreCertificadoPdf;

    public String getNombreCertificadoPdf() {
        return nombreCertificadoPdf;
    }

    public void setNombreCertificadoPdf(String nombreCertificadoPdf) {
        this.nombreCertificadoPdf = nombreCertificadoPdf;
    }

    public void generarCertificadoPDF() throws SQLException, JRException {
        if (proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().getId() != null
                && proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().getEstado().equals(AprobacionDirectorDepartamento.ESTADO_APROBADO)) {
            BigDecimal idProyecto = proyectoSelected.getDatgeproyId().getDatgeproyId();
            connection = ds_conn.getConnection();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            realPath = servletContext.getRealPath("/reportes");
            Date fecha = new Date();
            String nombreRandomico = Long.toString(fecha.getTime());
            nombreCertificadoPdf = nombreRandomico + ".pdf";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/memo.jasper");
            Map<String, Object> parametros = new HashMap<>();
            String logo = servletContext.getRealPath("/resources/images/");
            parametros.put("path", realPath + "/");
            parametros.put("proy", idProyecto.toString());
            parametros.put("respo", 3);
            parametros.put("dirPhoto", logo + "/");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreCertificadoPdf));
            exporter.exportReport();
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
            FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
            connection.close();
            controlPDF = true;
        }

    }

    private StreamedContent archivoAceptacionDirDepartamento;

    public StreamedContent getArchivoAceptacionDirDepartamento() {
        return archivoAceptacionDirDepartamento;
    }

    public void setArchivoAceptacionDirDepartamento(StreamedContent archivoAceptacionDirDepartamento) {
        this.archivoAceptacionDirDepartamento = archivoAceptacionDirDepartamento;
    }

    public void subirArchivoAprobacionDirDepartamento(FileUploadEvent event) throws IOException {
        InputStream is = event.getFile().getInputstream();
        proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().setArchivoDigital(IOUtils.toByteArray(is));
        proyectoSelected.getDatgeproyId().getAprobacionDirectorDepartamento().setArchivoNombre(event.getFile().getFileName());
    }

    public void cancelarAprobacionComision() {
        cancelarProyecto();
        proyectoSelected.getDatgeproyId().addCalificacionComision();
    }

    public void guardarAprobacionComision() {
        try {
            CalificacionComision cal = proyectoSelected.getDatgeproyId().getCalificacionComision();
            cal.setUsuario(usuarioActual);
            cal.setFecha(new Date());
            if (cal.isAprobado()) {
                proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_APROBADO_COMISION);
            } else {
                proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION);
            }
            notaConceptualFacade.edit(proyectoSelected.getDatgeproyId());
            cancelarAprobacionComision();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    private SeaParesConvoca parSelected;

    public SeaParesConvoca getParSelected() {
        return parSelected;
    }

    public void setParSelected(SeaParesConvoca parSelected) {
        this.parSelected = parSelected;
    }

    public void nuevoPar() {
        parSelected = new SeaParesConvoca();
    }
    @EJB
    private VDocenteInvestigacionFacade investigadorParFacade;

    private String investigadorEspe = "";
    private String investigadorExterno = "";

    public String getInvestigadorEspe() {
        return investigadorEspe;
    }

    public void setInvestigadorEspe(String investigadorEspe) {
        this.investigadorEspe = investigadorEspe;
    }

    public String getInvestigadorExterno() {
        return investigadorExterno;
    }

    public void setInvestigadorExterno(String investigadorExterno) {
        this.investigadorExterno = investigadorExterno;
    }

    public void eliminarPar() {
        try {
            comisionParFacade.remove(parSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarPar();
        }

    }

    public List<String> completeTextParEspe(String query) {
        docenteEspeList = investigadorParFacade.findInvestigadorByName(query);
        List<String> results = new ArrayList<>();
        for (VDocenteInvestigacion investigadorList1 : docenteEspeList) {
            results.add(investigadorList1.getUsuCc() + "-" + investigadorList1.getUsuApellidos() + " " + investigadorList1.getUsuNombres());
        }

        return results;
    }

    public List<String> completeTextParExterno(String query) {
        docenteExternoList = usuarioFacade.findParesExternoByName(query);
        List<String> results = new ArrayList<>();
        for (SegUsuario paresExternoList1 : docenteExternoList) {
            results.add(paresExternoList1.getUsuCc() + "-" + paresExternoList1.getUsuApellidos() + " " + paresExternoList1.getUsuNombres());
        }
        return results;
    }

    public void onItemSelectParEspe(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteEspeList = investigadorParFacade.findInvestigadorByName(temp[1]);
    }

    public void onItemSelectParExterno(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteExternoList = usuarioFacade.findParesExternoByName(temp[1]);
    }

    public void cancelarPar() {
        cancelarProyecto();
        parSelected = null;
        docenteEspeList = null;
        docenteExternoList = null;
        tipoPar = "L";
        investigadorEspe = "";
        investigadorExterno = "";

    }
    private String tipoPar = "";

    public String getTipoPar() {
        return tipoPar;
    }

    public void setTipoPar(String tipoPar) {
        this.tipoPar = tipoPar;
    }
    private List<VDocenteInvestigacion> docenteEspeList;
    private List<SegUsuario> docenteExternoList;

    public List<VDocenteInvestigacion> getDocenteEspeList() {
        return docenteEspeList;
    }

    public void setDocenteEspeList(List<VDocenteInvestigacion> docenteEspeList) {
        this.docenteEspeList = docenteEspeList;
    }

    public List<SegUsuario> getDocenteExternoList() {
        return docenteExternoList;
    }

    public void setDocenteExternoList(List<SegUsuario> docenteExternoList) {
        this.docenteExternoList = docenteExternoList;
    }

    @EJB
    private SeaParesConvocaFacade comisionParFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;

    public void grabarPar() {
        try {
            SegUsuario inves = new SegUsuario();
            if (tipoPar.equals("L")) {  //Par ESPE
                if (docenteEspeList == null || docenteEspeList.isEmpty()) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:investigadorEspe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteEspeList.get(0).getUsuId());
            } else { //Par Externo
                if (docenteExternoList == null || docenteExternoList.isEmpty()) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:investigadorEspe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteExternoList.get(0).getUsuId());
            }
            parSelected.setUsuId(inves);
            for (SeaParesConvoca par : proyectoSelected.getDatgeproyId().getParEvaluacionList()) {
                if (par.getUsuId().getUsuId().equals(parSelected.getUsuId().getUsuId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El investigador ya fue asignado a esta Fase"));
                    return;
                }
            }
            parSelected.setNotaConceptual(proyectoSelected.getDatgeproyId());
            parSelected.setUsuIdCrea(usuarioActual);
            parSelected.setSpcFechaCrea(new Date());
            parSelected.setSpcEstado("A");
            comisionParFacade.create(parSelected);

            proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_ASIGNADO_PAR);
            cancelarPar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    public void finalizarAsignacionPar() {
        try {
            proyectoSelected.getDatgeproyId().setDatgeproyEstado(SeaDatGeneralProy.ESTADO_ASIGNADO_PAR);
            notaConceptualFacade.edit(proyectoSelected.getDatgeproyId());
            cancelarProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    private EvaluacionPar evaluacionParSelected;

    public EvaluacionPar getEvaluacionParSelected() {
        return evaluacionParSelected;
    }

    public void setEvaluacionParSelected(EvaluacionPar evaluacionParSelected) {
        this.evaluacionParSelected = evaluacionParSelected;
    }

    public void editarEvaluacionPar() {
        modoEdicion = true;
    }

    public void finalizarEvaluacionPar() {
        try {
            evaluacionParSelected.setEstadoFinalizado(EvaluacionPar.ESTADO_FINALIZADO_SI);
            evaluacionParFacade.edit(evaluacionParSelected);
            modoEdicion = false;

            SeaDatGeneralProy notaConceptual = notaConceptualFacade.find(proyectoSelected.getDatgeproyId().getDatgeproyId());
            if (notaConceptual.verificarEvaluacionPar()) {
                notaConceptual.setDatgeproyEstado(SeaDatGeneralProy.ESTADO_EVALUADO_PAR);
                notaConceptualFacade.edit(notaConceptual);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }
    private ConfiguracionParametrosEvaluacionInv configParametrosEvaluacionSelected;

    public ConfiguracionParametrosEvaluacionInv getConfigParametrosEvaluacionSelected() {
        return configParametrosEvaluacionSelected;
    }

    public void setConfigParametrosEvaluacionSelected(ConfiguracionParametrosEvaluacionInv configParametrosEvaluacionSelected) {
        this.configParametrosEvaluacionSelected = configParametrosEvaluacionSelected;
    }

    @EJB
    private EvaluacionParFacade evaluacionParFacade;
    @EJB
    private ConfiguracionParametrosEvaluacionInvFacade configuParametrosEvaluacionFacade;

    public void cancelarEvaluacionPar() {
        try {
            cancelarProyecto();
            parSelected = comisionParFacade.findByProyectoUsuario(idNotaConceptualSelected, usuarioActual.getUsuId());
            if (parSelected != null) {
                if (parSelected.getEvaluacionList() == null || parSelected.getEvaluacionList().isEmpty()) {
                    modoEdicion = true;
                    evaluacionParSelected = new EvaluacionPar();
                    configParametrosEvaluacionSelected = configuParametrosEvaluacionFacade.findXEvaluacionInicialAndActivo();
                    if (configParametrosEvaluacionSelected == null) {
                        throw new Exception("No existe una configuraciion activa");
                    }
                } else {
                    modoEdicion = false;
                    evaluacionParSelected = parSelected.getEvaluacionList().get(0);
                    for (EvaluacionParDetalle evaluacionParDetalle : evaluacionParSelected.getEvaluacionDetalleList()) {
                        configParametrosEvaluacionSelected = evaluacionParDetalle.getConfiguracion();
                        break;
                    }

                    for (EvaluacionParDetalle evalDetalle : evaluacionParSelected.getEvaluacionDetalleList()) {
                        if (evalDetalle.getParametroEvaluacion() != null) {
                            for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                                if (param.equals(evalDetalle.getParametroEvaluacion())) {
                                    param.setPuntaje(evalDetalle.getPuntaje());
                                    param.setJustificacion(evalDetalle.getJustificacion());
                                    break;
                                }
                                if (param.getParametroEvaluacionList() != null && !param.getParametroEvaluacionList().isEmpty()) {
                                    for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                                        if (paramHijo.equals(evalDetalle.getParametroEvaluacion())) {
                                            paramHijo.setPuntaje(evalDetalle.getPuntaje());
                                            paramHijo.setJustificacion(evalDetalle.getJustificacion());
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                                if (param.equals(evalDetalle.getValoracionParametroEvaluacion().getParametroEvaluacion())) {
                                    param.setValoracionParametroEvaluacion(evalDetalle.getValoracionParametroEvaluacion());
                                    param.setJustificacion(evalDetalle.getJustificacion());
                                    break;
                                }
                                if (param.getParametroEvaluacionList() != null && !param.getParametroEvaluacionList().isEmpty()) {
                                    for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                                        if (paramHijo.equals(evalDetalle.getValoracionParametroEvaluacion().getParametroEvaluacion())) {
                                            paramHijo.setValoracionParametroEvaluacion(evalDetalle.getValoracionParametroEvaluacion());
                                            paramHijo.setJustificacion(evalDetalle.getJustificacion());
                                            break;
                                        }
                                    }

                                }
                            }

                        }

                    }
                }
            }

            cancelarConsolidacionEvaluacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grabarEvaluacionPar() {
        try {
            evaluacionParSelected.removeAllDetalle();
            for (ParametroEvaluacionInv param : configParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                EvaluacionParDetalle evaluacionParDetalle = new EvaluacionParDetalle();
                if (param.getParametroEvaluacionList() == null || param.getParametroEvaluacionList().isEmpty()) {
                    if (param.getValoracionList() == null || param.getValoracionList().isEmpty()) {
                        evaluacionParDetalle.setParametroEvaluacion(param);
                        evaluacionParDetalle.setPuntaje(param.getPuntaje());
                        evaluacionParDetalle.setJustificacion(param.getJustificacion());
                        if (evaluacionParDetalle.getPuntaje().compareTo(param.getPuntajeMaximo()) > 0) {
                            throw new Exception("El parámetro: '" + param.getDescripcion() + "' puede tener un puntaje máximo de: " + param.getPuntajeMaximo().toString());
                        }
                    } else {
                        evaluacionParDetalle.setValoracionParametroEvaluacion(param.getValoracionParametroEvaluacion());
                    }
                    evaluacionParSelected.addDetalle(evaluacionParDetalle);
                } else {
                    for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                        evaluacionParDetalle = new EvaluacionParDetalle();
                        if (paramHijo.getValoracionList() == null || paramHijo.getValoracionList().isEmpty()) {
                            evaluacionParDetalle.setParametroEvaluacion(paramHijo);
                            evaluacionParDetalle.setPuntaje(paramHijo.getPuntaje());
                            evaluacionParDetalle.setJustificacion(paramHijo.getJustificacion());
                            if (evaluacionParDetalle.getPuntaje().compareTo(paramHijo.getPuntajeMaximo()) > 0) {
                                throw new Exception("El parámetro: '" + paramHijo.getDescripcion() + "' puede tener un puntaje máximo de: " + paramHijo.getPuntajeMaximo().toString());
                            }
                        } else {
                            evaluacionParDetalle.setValoracionParametroEvaluacion(paramHijo.getValoracionParametroEvaluacion());
                        }
                        evaluacionParSelected.addDetalle(evaluacionParDetalle);
                    }
                }

            }

            evaluacionParSelected.setFechaModificacion(new Date());
            if (evaluacionParSelected.getId() == null) {
                evaluacionParSelected.setPar(parSelected);
                evaluacionParFacade.create(evaluacionParSelected);
            } else {
                evaluacionParFacade.edit(evaluacionParSelected);
            }
            modoEdicion = false;
            cancelarEvaluacionPar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

    }

    private boolean esDirectorDepartamento;
    private boolean esIntegranteComision;

    private void verificarDirectorDepartamento() {
        List<SeaDepcenproy> depCenProyList = new ArrayList<>();
        List<VDirectoresDepto> directorDepList = directorDeptoFacade.findAll();
        for (VDirectoresDepto d : directorDepList) {
            if (d.getUsuId().equals(usuarioActual.getUsuId())) {
                depCenProyList.addAll(depCenProyFacade.findByCampusDepartamento(d.getCampusId(), d.getStvsubjCode()));
            }

        }
        for (SeaDepcenproy d : depCenProyList) {
            if (d.getDatgeproyId().getDatgeproyId().equals(proyectoSelected.getDatgeproyId().getDatgeproyId())) {
                esDirectorDepartamento = true;
                return;
            }
        }
    }

    private void verificarIntegranteComision() {
        List<SeaConvoca> convList = convocatoriaFacade.findByUsuario(usuarioActual.getUsuId());
        for (SeaConvoca c : convList) {
            if (c.getConvocaId().equals(proyectoSelected.getDatgeproyId().getConvocaId().getConvocaId())) {
                esIntegranteComision = true;
                break;
            }
        }
    }

    public boolean isPermitirEditarAceptacionDirDep() {
        if (!proyectoSelected.isEstadoAceptacionDirDep()) {
            return false;
        }
        return esDirectorDepartamento;
    }

    public boolean isPermitirVerAceptacionDirDep() {
        return (verificarPerfil(SegPerfil.PERFIL_INVESTIGACION_ADMINISTRADOR) || esDirectorDepartamento);
    }

    @EJB
    private SeaConvocaFacade convocatoriaFacade;

    public boolean isPermitirVerAprobacionComision() {
        return (verificarPerfil(SegPerfil.PERFIL_INVESTIGACION_ADMINISTRADOR) || esIntegranteComision);
        /*List<SeaConvoca> convocatoriaList = convocatoriaFacade.findByUsuario(usuarioActual.getUsuId());
        for (SeaConvoca conv : convocatoriaList) {
            if (conv.equals(proyectoSelected.getDatgeproyId().getConvocaId())) {
                return true;
            }
        }
        return false;*/
    }

    public boolean isPermitirEditarAprobacionComision() {
        if (!proyectoSelected.isEstadoAprobacionComision()) {
            return false;
        }
        return esIntegranteComision;

    }

    public boolean isPermitirEditarAsignacionPares() {
        if (!proyectoSelected.isEstadoAsignacionPares()) {
            return false;
        }
        return isPermitirVerAprobacionComision();

    }

    public boolean isPermitirVerEvaluacionPar() {
        if (verificarPerfil(SegPerfil.PERFIL_INVESTIGACION_ADMINISTRADOR)) {
            return true;
        }
        parSelected = comisionParFacade.findByProyectoUsuario(idNotaConceptualSelected, usuarioActual.getUsuId());
        return (parSelected != null);
    }

    public boolean isPermitirEditarEvaluacionPar() {
        if (!proyectoSelected.isEstadoEvaluacionPar()) {
            return false;
        }
        return isPermitirVerEvaluacionPar();

    }

    @EJB
    private VDirectoresDeptoFacade directorDeptoFacade;

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    private Map<BigDecimal, Boolean> estadoExpandidoObjetivo = new HashMap<BigDecimal, Boolean>();
    private ObjetivoProyecto objetivoProyectoSelected;
    private ObjetivoProyecto objetivoProyectoPadreSelected;
    @EJB
    private ObjetivoProyectoFacade objetivoProyectoFacade;

    public ObjetivoProyecto getObjetivoProyectoPadreSelected() {
        return objetivoProyectoPadreSelected;
    }

    public void setObjetivoProyectoPadreSelected(ObjetivoProyecto objetivoProyectoPadreSelected) {
        this.objetivoProyectoPadreSelected = objetivoProyectoPadreSelected;
    }

    public ObjetivoProyecto getObjetivoProyectoSelected() {
        return objetivoProyectoSelected;
    }

    public void setObjetivoProyectoSelected(ObjetivoProyecto objetivoProyectoSelected) {
        this.objetivoProyectoSelected = objetivoProyectoSelected;
    }

    public void cancelarObjetivoProyecto(boolean setearEstadoExpansion) {
        cancelarProyecto();
        objetivoProyectoSelected = null;
        if (setearEstadoExpansion) {
            estadoExpandidoObjetivo = null;
            proyectoSelected.resetEstadoExpandidoObjetivo();
            estadoExpandidoObjetivo = proyectoSelected.getEstadoExpandidoObjetivo();
        } else {
            proyectoSelected.setEstadoExpandidoObjetivo(estadoExpandidoObjetivo);
        }
    }

    public void registraObjetivoProyecto() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarObjetivoProyecto(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    public void onRowToggleObjetivoProyecto(ToggleEvent event) {
        ObjetivoProyecto obj = (ObjetivoProyecto) event.getData();
        estadoExpandidoObjetivo.put(obj.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public void nuevoObjetivoProyecto() {
        objetivoProyectoSelected = new ObjetivoProyecto(proyectoSelected);
        objetivoProyectoSelected.setTipo(objetivoProyectoPadreSelected.getTipoHijo());
        objetivoProyectoSelected.setObjetivoPadre(objetivoProyectoPadreSelected);
        objetivoProyectoSelected.setOrden(objetivoProyectoPadreSelected.getObjetivoHijoList().size() + 1);
        proyectoSelected.addObjetivoProyecto(objetivoProyectoSelected);
    }

    public void eliminarObjetivoProyecto() {
        try {
            objetivoProyectoSelected.getObjetivoPadre().removeObjetivo(objetivoProyectoSelected);
            objetivoProyectoFacade.edit(objetivoProyectoSelected.getObjetivoPadre());
            estadoExpandidoObjetivo.remove(objetivoProyectoSelected.getId());
            cancelarObjetivoProyecto(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void cambiarOrdenActividad(Integer cambio) {
        try {
            objetivoProyectoSelected.cambiarOrdenObjetivo(cambio);
            objetivoProyectoFacade.edit(objetivoProyectoSelected.getObjetivoPadre());
            cancelarObjetivoProyecto(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    private Cronograma cronogramaSelected;
    @EJB
    private CronogramaFacade cronogramaFacade;
    @EJB
    private PresupuestoPartidaFacade presupuestoPartidaFacade;

    private PresupuestoPartida presupuestoPartidaSelected;

    public PresupuestoPartida getPresupuestoPartidaSelected() {
        return presupuestoPartidaSelected;
    }

    public void setPresupuestoPartidaSelected(PresupuestoPartida presupuestoPartidaSelected) {
        this.presupuestoPartidaSelected = presupuestoPartidaSelected;
    }

    public Cronograma getCronogramaSelected() {
        return cronogramaSelected;
    }

    public void setCronogramaSelected(Cronograma cronogramaSelected) {
        this.cronogramaSelected = cronogramaSelected;
    }

    private void initCronograma() {
        cargarArbolPartidas();
        cancelarCronograma();
    }

    public void nuevoCronograma() {
        cronogramaSelected = new Cronograma();
        cronogramaSelected.setActividad(new ObjetivoProyecto());
    }

    public void cancelarCronograma() {
        cancelarProyecto();
        cronogramaSelected = null;
        presupuestoPartidaSelected = null;
    }

    public void registraCronograma() {
        try {
            if (cronogramaSelected.getId() == null) {
                cronogramaSelected.setProyecto(proyectoSelected);
                cronogramaFacade.create(cronogramaSelected);
            } else {
                cronogramaFacade.edit(cronogramaSelected);
            }
            cancelarCronograma();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    public void registraCronogramaPresupuesto() {
        try {
            if (presupuestoPartidaSelected.getId() == null) {
                presupuestoPartidaSelected.setCronograma(cronogramaSelected);
                presupuestoPartidaFacade.create(presupuestoPartidaSelected);
            } else {
                presupuestoPartidaFacade.edit(presupuestoPartidaSelected);
            }
            cancelarCronograma();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
    }

    private TreeNode nodoRaizPartidas;
    private TreeNode nodoPartidaSelected;

    public TreeNode getNodoPartidaSelected() {
        return nodoPartidaSelected;
    }

    public void setNodoPartidaSelected(TreeNode nodoPartidaSelected) {
        this.nodoPartidaSelected = nodoPartidaSelected;
    }

    public TreeNode getNodoRaizPartidas() {
        return nodoRaizPartidas;
    }

    public void setNodoRaizPartidas(TreeNode nodoRaizPartidas) {
        this.nodoRaizPartidas = nodoRaizPartidas;
    }

    public void onNodePartidasSelect(NodeSelectEvent event) {
        SeaClasificadorPresup a = (SeaClasificadorPresup) event.getTreeNode().getData();
        presupuestoPartidaSelected.setPartida(a);
        RequestContext.getCurrentInstance().execute("PF('dlgPartidaPresupuestaria').hide();");
    }
    @EJB
    private SeaClasificadorPresupFacade clasificadorPresupuestoFacade;

    private void cargarArbolPartidas() {
        this.nodoRaizPartidas = new DefaultTreeNode("Grupo", null);
        List<SeaClasificadorPresup> principales = clasificadorPresupuestoFacade.findClasificadorPadre();
        for (SeaClasificadorPresup opcion : principales) {
            TreeNode itemHijo = new DefaultTreeNode(opcion, nodoRaizPartidas);
            itemHijo.setSelectable(true);
            llenarHijos(opcion, itemHijo);
        }
    }

    private void llenarHijos(SeaClasificadorPresup opc, TreeNode menuPadre) {
        for (SeaClasificadorPresup opcion : opc.getSeaClasificadorPresupList()) {
            TreeNode itemHijo = new DefaultTreeNode(opcion, menuPadre);
            itemHijo.setSelectable(true);
            if (opcion.getSeaClasificadorPresupList() != null && !opcion.getSeaClasificadorPresupList().isEmpty()) {
                llenarHijos(opcion, itemHijo);
            }
        }
    }

    public void nuevoCronogramaPresupuesto() {
        presupuestoPartidaSelected = new PresupuestoPartida();
        presupuestoPartidaSelected.setPartida(new SeaClasificadorPresup());
        presupuestoPartidaSelected.setInstitucionNombre("ESPE");
    }

    public void abrirSeleccionPresupuesto() {
        for (TreeNode nodePadre : nodoRaizPartidas.getChildren()) {
            nodePadre.setExpanded(false);
            nodePadre.setSelected(false);
            resetearHijosArbol(nodePadre);
        }
        nodoPartidaSelected = null;
        RequestContext.getCurrentInstance().execute("PF('dlgPartidaPresupuestaria').show();");
    }

    private void resetearHijosArbol(TreeNode node) {
        if (node.getChildCount() > 0) {
            for (TreeNode nodeHijo : node.getChildren()) {
                nodeHijo.setExpanded(false);
                nodeHijo.setSelected(false);
                resetearHijosArbol(nodeHijo);
            }
        }

    }

    public void eliminarCronogramaPresupuesto() {
        try {
            presupuestoPartidaFacade.remove(presupuestoPartidaSelected);
            cancelarCronograma();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void eliminarCronograma() {
        try {
            cronogramaFacade.remove(cronogramaSelected);
            cancelarCronograma();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void cambiarTipoInstitucion() {
        if (presupuestoPartidaSelected.getInstitucionTipo().equals(PresupuestoPartida.INSTITUCION_TIPO_ESPE)) {
            presupuestoPartidaSelected.setInstitucionNombre("ESPE");
        } else {
            presupuestoPartidaSelected.setInstitucionNombre(null);
        }
    }

    public void cancelarConsolidacionEvaluacion() {
        seleccionarNotaConceptual(proyectoList.get(0).getDatgeproyId());
        proyectoList.get(0).getDatgeproyId().setearPuntaje();
    }

    public void seleccionarNotaConceptual(SeaDatGeneralProy notaConceptual) {
        try {
            for (SeaParesConvoca p : notaConceptual.getParEvaluacionList()) {
                for (EvaluacionPar e : p.getEvaluacionList()) {
                    for (EvaluacionParDetalle d : e.getEvaluacionDetalleList()) {
                        notaConceptual.setConfigParametrosEvaluacion(d.getConfiguracion().clone());
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
