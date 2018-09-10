/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;


import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaCevaluaXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaValorXCeConvoca;
import ec.edu.espe_ctt_investigacion.session.SeaCevaluaXConvocatoriaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCriteriosEvaluaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPorcenXCrConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaValorXCeConvocaFacade;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class EvaluacionXConvocatoriaController implements Serializable {
    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath ="";
    private StreamedContent media;
    public boolean controlPDF = false;
    

    /**
     * Creates a new instance of EvaluacionXConvocatoriaController
     */
    public EvaluacionXConvocatoriaController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    
    ///convocatoria
    @EJB
    private SeaConvocaFacade convocaFacade;
    private SeaConvoca convocatoria;
   
    
    /// pares convocatoria
    @EJB
    private SeaParesConvocaFacade paresConvocaFacade;
    private SeaParesConvoca paresConvoca;
    private SeaParesConvoca convocatoriaSelected;
    private List<SeaParesConvoca> paresConvocaList;
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    private BigDecimal idConvocatoria;
    private BigDecimal idProyecto;
    
    
    
    /// porcenteje Criterio Evaluacion por convocatoria
    @EJB
    private SeaPorcenXCrConvocaFacade porcenConvocaFacade;
    private SeaPorcenXCrConvoca porConvocatoria;
    private List<SeaPorcenXCrConvoca> porConvocaList;
    
    
    /// criterios de evaluacion
    @EJB
    private SeaCriteriosEvaluaFacade criterioEvaluFacade;
    private SeaCriteriosEvalua criterioEvaluacion;
    private List<SeaCriteriosEvalua> criterioCrList;
    private List<SeaCriteriosEvalua> convCriCrList;
    private SeaCriteriosEvalua criterioEvaluaSelected;
    private List<SeaCriteriosEvalua> criterioValorList;
    private Double puntaje;
    private Double puntajeConvoca;
    private String justificacion;
    private boolean validaVaciosEvalu = true;
   
    /// Evalua convocatoria
    @EJB
    private SeaCevaluaXConvocatoriaFacade cEvaluaConvocaFacade;
    private SeaCevaluaXConvocatoria cEvaluaConvocatoria;
    private SeaCevaluaXConvocatoria cEvaluaConvoSelected;
    private boolean  grabaProceso = false;
    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;
    
    ///parametros detalle
    @EJB
    private SeaParametrosDetFacade parametDetFacade;
    private SeaParametrosDet parametrosDet;
    
    /// valor Criterios de Evaluacion por Convocatoria
    @EJB
    private SeaValorXCeConvocaFacade valorCeConvocaFacade;
    private SeaValorXCeConvoca valorCeConvoca;
    private SeaValorXCeConvoca valorCeConvSelected;
    private List<SeaValorXCeConvoca> valorCeConvList;
    private SeaValorXCeConvoca valorXCeConvoca;
    private String criEvalua;
    private String criEvaluaEdit;
    private Double valorPuntaje;
    private String valorPuntajeEdit;
    
    /// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGeneralProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    
    
    
    //</editor-fold>
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
       usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
  
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
        ///tab2
        paresConvocaList = paresConvocaFacade.findByUsuario(usuario.getUsuId());
    }
    public String seleccionaConvocatoria(){
        botonInicio = false;
        cargaDatosProyecto();
        habilitaTab = false;
        return "";
    }
    
    public String inicioProgramas(){
        if(botonInicio == false){
            /// regresa a la lista de convocatorias
            System.out.println("boton1 " + botonInicio);
            habilitaTab = true;
        }
        return "";
    }
    /*
    public String inicioProgramas() {
        if (botonInicio) {
            /// regresar a lista de programas 
            System.out.println(" boton1 " + botonInicio);
            habilitaTab = true;
            visibleDrop = false;

        } else {
            //// es nuevo 
            System.out.println(" boton 2" + botonInicio);
            cargaDatosProyectoNuevo();
            cancelarP1();
            validarVisible();
            //cargaDatosProyecto();
        }

        datosProyectoSelected = null;
        //  cancelarTotal();
        return "";

    }
    */
    public void cargaDatosProyecto(){
        /// tab1
        valorCeConvList = valorCeConvocaFacade.findValorCeConvByCodConv(convocatoriaSelected.getConvocaId().getConvocaId());
        criterioValorList = criterioEvaluFacade.findCriterioValor();
        ///porcentaje convocatoria   
        if(convocatoriaSelected != null){
            porConvocaList = porcenConvocaFacade.findPorcenConvocatByConvoc(convocatoriaSelected.getConvocaId().getConvocaId());
        }
        
    }
    
    /*
    public void cargaDatosProyecto() {
        /// tab1
        prgInvestigaList = programaFacade.findPrograma();
        tipoInvestigaList = parametrosDetFacade.findTipoInves();
        if (datosConvocaSelected != null) {
            datGenProyecto = datGeneralProyFacade.findProyectoByConvocat(datosConvocaSelected.getConvocaId());
            if (datGenProyecto != null && datGenProyecto.getProgId().toString() != null) {
                progInvestiga = datGenProyecto.getProgId().getProgId().toString();
                tituloProy = datGenProyecto.getDatgeproyTitulo();
                duracionProyecto = datGenProyecto.getDatgeproyTiempoEjecucion();
                montoProyecto = datGenProyecto.getDatgeproyMontoTotal().toString();
                montoInstituciones = datGenProyecto.getDatgeproyMontoOtraInst().toString();
                idProyecto = datGenProyecto.getDatgeproyId().toString();
            }
            convocaProyecto = convocaFacade.findConvocaByIdConvoca(datosConvocaSelected.getConvocaId());
            if (convocaProyecto != null) {
                tipologia = convocaProyecto.getPrdId().getPrdId().toString();
            }
        }
        //// tab8
        // Obtener el monto de la convocatoria
        if (datosConvocaSelected != null) {
            BigDecimal var = new BigDecimal(100);
            /// recurso convocatoria
            recursoConvocaList = recursosFacade.findTipoRecurso();
            convocaProyecto = convocaFacade.findConvocaByIdConvoca(datosConvocaSelected.getConvocaId());
            if (convocaProyecto != null) {
                monTot = convocaProyecto.getConvocaFinanciamiento();
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurFisByConvocatoria(datosConvocaSelected.getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoFisico = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecFisico = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porcA = new BigDecimal(recursoFisico);
                monTA = monTot.multiply(porcA);
                monTA = monTA.divide(var);
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurHumaByConvocatoria(datosConvocaSelected.getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoHumano = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecHumano = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porB = new BigDecimal(recursoHumano);
                monTB = monTot.multiply(porB);
                monTB = monTB.divide(var);
            }
            financiamientoConvocatoria = financiaConvocaFacade.findFinanRecurLogisByConvocatoria(datosConvocaSelected.getConvocaId());
            if (financiamientoConvocatoria != null) {
                recursoLogistico = financiamientoConvocatoria.getSfcPorcentaje().toString();
                idRecLogistico = financiamientoConvocatoria.getSfcId().toString();
                BigDecimal porC = new BigDecimal(recursoLogistico);
                monTC = monTot.multiply(porC);
                monTC = monTC.divide(var);
            }
            presupuestoCLits = presupuestoFacade.findPresupuestoByConvoca(datosConvocaSelected.getConvocaId());
            presupuestoConvocatoria = presupuestoFacade.findRecursoPartidaByConvoca(datosConvocaSelected.getConvocaId());
            if (presupuestoConvocatoria != null) {
                tipoRecurso = presupuestoConvocatoria.getSrcId().toString();
               // montoPresupuestado = presupuestoConvocatoria.getSpcValorAsigna().toString();
                partidaPresup = presupuestoConvocatoria.getSpcId().toString();

            }
        }
        //tab 2 localizacion
        localizaList = localizaFacade.findLocalizaByOrden();
      zonaPlanifList = zonaPlanifFacade.findAll();
      provinciaList = provinciaFacade.findAllOrdenados();
        cantonList = cantonFacade.findByProvincia("17");

        if (coberturaNew == null) {
            coberturaNew = new SeaCobertura();
            coberturaNew.setLocalId(new SeaLocaliza());
        }
        if (zonaDetalleNew == null) {
            zonaDetalleNew = new SeaZonaDetalle();
            zonaDetalleNew.setCanId(new SeaCanton());
        }

        /// tab3
        depCenProy = new SeaDepcenproy();

        subjList = subjFacade.findDepartamento();
        majrList = majrFacade.findCarrera();
        convocaList = convocaFacade.findConvocatoria();
        //        departamentoList = departamentoFacade.findDepartamento();
        //        carreraList = carreraFacade.findCarrera();
        progPostgradoList = progPostgradoFacade.findProgramaPostgrado();
        sublineaList = lineaInvesFacade.findSublineaInvestiga();
        grupInvestigaList = grupoInvestFacade.findGrupoInvestiga();

        if (datosConvocaSelected != null) {
            depcenproyList = depCenProyFacade.findDepartCentroProy(new BigDecimal(idProyecto));
        }

        //// tab4
        if (datosConvocaSelected != null) {
            // opInstitucionList = opcionInstitucionFacade.findOpcionInstitucion(datosProyectoSelected.getDatgeproyId());
            opInstitucionList = opcionInstitucionFacade.findOpcionInstitucion(new BigDecimal(idProyecto));
        }
        datgenprogList = datgenprogFacade.findPrograma();

        ///tab5
        if (datosConvocaSelected != null) {
            responsableProyList = responsableProyFacade.findOrdenResProyectoByCodPro(new BigDecimal(idProyecto));
        }

        //docenteProyList = docenteProyFacade.findAll(); //findEsTudiantesByName
        docenteProyList = docenteProyFacade.findEsTudiantesByName(nomFile1);

        tipoResponDoceList = tipoResponDoceFacade.findTipoResponDocenteProyecto(new BigDecimal(1));
        if (responsableProyecto == null) {
            responsableProyecto = new SeaResponsableProg();
            responsableProyecto.setUsuIdDocente(new SegUsuario());
            //   responsableProyecto.setDocId(new SeaDocente());
            responsableProyecto.setTipresId(new SeaTipoRespons());
        }
        docente = "";
        //tab6
        if (datosConvocaSelected != null) {
            objetivosProy = objetivosProyFacade.findCoberturabyPro(new BigDecimal(idProyecto));
        } else {
            if (objetivosProy == null) {
                objetivosProy = new SeaDatGeneralProy();
            }
        }
    }
    */
    public String agregarP1(){
        controlGrabarP1 = true;
        return "";
    }
    public String registraP1(){
        criterioEvaluacion = new SeaCriteriosEvalua();
        criterioEvaluacion.setSceId(new BigDecimal(criEvalua));
        if(valorCeConvoca == null){
            System.out.println("Inserta Registro");
            valorCeConvoca = new SeaValorXCeConvoca();
            valorCeConvoca.setConvocaId(convocatoriaSelected.getConvocaId());
            valorCeConvoca.setSceId(criterioEvaluacion);
            valorCeConvoca.setSvxccValor(new BigDecimal(valorPuntaje));
            valorCeConvocaFacade.create(valorCeConvoca);            
            valorCeConvList = valorCeConvocaFacade.findValorCeConvByCodConv(convocatoriaSelected.getConvocaId().getConvocaId());
        }
        cancelarP1();
        return "";
    }
    public void cancelarP1(){
        controlGrabarP1 = false;
        criEvalua ="";
        valorPuntaje =0.0;
        valorCeConvoca = null;
        validaVaciosP1 = true;
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        criEvalua = criEvalua.trim();
        if(criEvalua.isEmpty()) validaVaciosP1 = true;
        
        return  validaVaciosP1;
    }
    public void eliminarP1() {
        Integer registro = 0;
        if (valorCeConvSelected != null) {
            System.out.println("eliminar registro");
            SeaValorXCeConvoca eliminar = null;
            for (int i = 0; i < valorCeConvList.size(); i++) {
                SeaValorXCeConvoca elemento = this.valorCeConvList.get(i);
                if (valorCeConvSelected.getSvxccId() == valorCeConvList.get(i).getSvxccId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.valorCeConvList.remove(eliminar);
                valorCeConvocaFacade.remove(eliminar);
            }
        }
    }
    public void onRowEditP1(RowEditEvent event){
        SeaValorXCeConvoca valorXConvocaEdit = new SeaValorXCeConvoca();
        valorXConvocaEdit = (SeaValorXCeConvoca) event.getObject();
        valorXConvocaEdit.setSvxccValor(new BigDecimal(valorPuntajeEdit));
        valorCeConvocaFacade.edit(valorXConvocaEdit);
        valorCeConvList = valorCeConvocaFacade.findValorCeConvByCodConv(convocatoriaSelected.getConvocaId().getConvocaId());
    }
    
    public void onRowCancelP1(RowEditEvent event){
    }

    /// funciones tab2
    public void onRowToggleCriterio(ToggleEvent event){
        SeaPorcenXCrConvoca porCr = new SeaPorcenXCrConvoca();
        porCr = (SeaPorcenXCrConvoca) event.getData();
        if(porCr != null){
           criterioCrList = criterioEvaluFacade.findCriterioHijoByCodCr(porCr.getSceId().getSceId());
        }
    }
    public void onRowToggleConvCr(ToggleEvent event){
        SeaCriteriosEvalua cr = new SeaCriteriosEvalua();
        cr = (SeaCriteriosEvalua) event.getData();
        if(cr != null){
            convCriCrList = criterioEvaluFacade.findCriterConvoCrByCodCr(cr.getSceId());
        }
    }
    public void  updateValor(ValueChangeEvent event){
        puntaje = (Double) event.getNewValue();
    }
    public boolean  validarVaciosEvaluacion(){
        validaVaciosEvalu = false;
        justificacion = justificacion.trim();
        if(justificacion.isEmpty()) validaVaciosEvalu = true;
        return  validaVaciosEvalu;
    }
    public String registraEvaluacion (){
        String fase = "261";
        parametrosDet = new SeaParametrosDet();
        parametrosDet.setPrdId(new Long(fase));
        int c = Integer.parseInt(criterioEvaluaSelected.getSceId().toString());
        
        switch (c) {
            case 7:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 8:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 9:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 10:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 11:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 13:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 14:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 18:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 19:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
            case 20:
                valorXCeConvoca = valorCeConvocaFacade.findValorXCeConvByCodIdConCodCon(new BigDecimal(c), convocatoriaSelected.getConvocaId().getConvocaId());
                if (valorXCeConvoca != null) {
                    puntajeConvoca = valorXCeConvoca.getSvxccValor().doubleValue();
                    if (puntaje <= puntajeConvoca) {
                        grabaProceso = false;
                        puntaje = puntaje;
                    } else {
                        RequestContext.getCurrentInstance().execute("alert('La calificación máxima es" + puntajeConvoca + "')");
                    }
                    break;
                }
        }

     /*      valorXCeConvocaList
        
        
        
        switch (c) {
            case 7:
                if (puntaje <= 1) {
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 1')");
                }
                break;
            case 8:
                if (puntaje <= 1) {
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 1')");
                }
                break;
            case 9:
                if(puntaje <= 2){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 2')");
                }
                break;
            case 10:
                if(puntaje <= 1.5){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 1.5')");
                }
                break;
            case 11:
                if(puntaje <= 1.5){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 1.5')");
                }
                break;
            case 13:
                if(puntaje <= 0.85){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 0.85')");
                }
                break;
            case 14:
                if(puntaje <= 0.9){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 0.9')");
                }
                break;
            case 18:
                if(puntaje <= 1){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 1')");
                }
                break;
            case 19:
                if(puntaje <= 0.5){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 0.5')");
                }
                break;
            case 20:
                if(puntaje <= 0.5){
                    grabaProceso = false;
                    puntaje = puntaje;
                } else {
                    grabaProceso = true;
                    RequestContext.getCurrentInstance().execute("alert('La calificación máxima es 0.5')");
                }
                break;
        }
        */
        if (grabaProceso == false) {
            if (convocatoriaSelected != null) {
                System.out.println("ingresa registro");
                cEvaluaConvocatoria = new SeaCevaluaXConvocatoria();
                cEvaluaConvocatoria.setScexcCalificacion(new BigDecimal(puntaje));
                cEvaluaConvocatoria.setPrdId(parametrosDet);
                cEvaluaConvocatoria.setScexcjustificacion(justificacion);
                cEvaluaConvocaFacade.create(cEvaluaConvocatoria);
            }
        }
        cancelarP2();
        return "";
    }
    public void cancelarP2(){
        cEvaluaConvocatoria = null;
        puntaje = 0.0;
        justificacion = "";
        validaVaciosEvalu = true;
        
    }
    public void generarReportePDF() throws JRException, IOException, SQLException{
        paresConvoca = paresConvocaFacade.findByUsuario(usuario.getUsuId()).get(0);
        if(paresConvoca != null){
            idConvocatoria = paresConvoca.getConvocaId().getConvocaId();
            /// obtenemos Id Proyecto
            datGeneralProy = datGeneralProyFacade.findProyectoByConvocat(idConvocatoria);
            if(datGeneralProy != null){
                idProyecto = datGeneralProy.getDatgeproyId();
            }
        }
        
        connection = ds_conn.getConnection();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        realPath = servletContext.getRealPath("/reportes");      
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/reportGrupNotasConceptuales.jasper");
        Map<String, Object> parametros = new HashMap<>();
        String logo = servletContext.getRealPath("/resources/images/");
        System.out.println("logo " + logo );
        parametros.put("path", realPath + "/");
        parametros.put("dirPhoto", logo + "/");
        parametros.put("SUBREPORT_DIR", realPath + "/" );
        parametros.put("DATGEPROY_ID",idProyecto.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + "notasConcept.pdf"));
        System.out.println("real path   1111 "+realPath);
        exporter.exportReport();
        System.out.println(" exportes  "+exporter);
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
        FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
        FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../reportes/prueba.pdf");
        connection.close();
        System.out.println("salio");
        controlPDF = true;
    }
     public void verPDF(ActionEvent actionEvent) throws SQLException, JRException, IOException{
         paresConvoca = paresConvocaFacade.findByUsuario(usuario.getUsuId()).get(0);
        if(paresConvoca != null){
            idConvocatoria = paresConvoca.getConvocaId().getConvocaId();
            /// obtenemos Id Proyecto
            datGeneralProy = datGeneralProyFacade.findProyectoByConvocat(idConvocatoria);
            if(datGeneralProy != null){
                idProyecto = datGeneralProy.getDatgeproyId();
            }
        }
         System.out.println(" ingreso estoy ");
         ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
         connection = ds_conn.getConnection();
         realPath = servletContext.getRealPath("/reportes");
         File jasper = new File(realPath + "/reportGrupNotasConceptuales.jasper");
         System.out.println(" jasper "+jasper);
         // JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/prueba3.jasper");
         Map<String, Object> parametros = new HashMap<>();
         String logo = servletContext.getRealPath("/img");
         parametros.put("path", realPath + "/");
         parametros.put("DATGEPROY_ID",idProyecto.toString());
         System.out.println(" real path "+realPath);
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
    
    //</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// get and set tab1
    
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

    public List<SeaValorXCeConvoca> getValorCeConvList() {
        return valorCeConvList;
    }

    public void setValorCeConvList(List<SeaValorXCeConvoca> valorCeConvList) {
        this.valorCeConvList = valorCeConvList;
    }

    public List<SeaCriteriosEvalua> getCriterioValorList() {
        return criterioValorList;
    }

    public void setCriterioValorList(List<SeaCriteriosEvalua> criterioValorList) {
        this.criterioValorList = criterioValorList;
    }

    public Double getValorPuntaje() {
        return valorPuntaje;
    }

    public void setValorPuntaje(Double valorPuntaje) {
        this.valorPuntaje = valorPuntaje;
    }

    public String getCriEvaluaEdit() {
        return criEvaluaEdit;
    }

    public void setCriEvaluaEdit(String criEvaluaEdit) {
        this.criEvaluaEdit = criEvaluaEdit;
    }

    public SeaValorXCeConvoca getValorCeConvSelected() {
        return valorCeConvSelected;
    }

    public void setValorCeConvSelected(SeaValorXCeConvoca valorCeConvSelected) {
        this.valorCeConvSelected = valorCeConvSelected;
    }

    public String getValorPuntajeEdit() {
        return valorPuntajeEdit;
    }

    public void setValorPuntajeEdit(String valorPuntajeEdit) {
        this.valorPuntajeEdit = valorPuntajeEdit;
    }
    

    /// tab2 pares convoca
    public SeaParesConvoca getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(SeaParesConvoca convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }

    public List<SeaParesConvoca> getParesConvocaList() {
        return paresConvocaList;
    }

    public void setParesConvocaList(List<SeaParesConvoca> paresConvocaList) {
        this.paresConvocaList = paresConvocaList;
    }

    public String getCriEvalua() {
        return criEvalua;
    }

    public void setCriEvalua(String criEvalua) {
        this.criEvalua = criEvalua;
    }
    
    /////

    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }
    /// porcentaje convocatoria
    public List<SeaPorcenXCrConvoca> getPorConvocaList() {
        return porConvocaList;
    }

    public void setPorConvocaList(List<SeaPorcenXCrConvoca> porConvocaList) {
        this.porConvocaList = porConvocaList;
    }
    /// criterios de evaluacion hijo
    public List<SeaCriteriosEvalua> getCriterioCrList() {
        return criterioCrList;
    }

    public void setCriterioCrList(List<SeaCriteriosEvalua> criterioCrList) {
        this.criterioCrList = criterioCrList;
    }
    public List<SeaCriteriosEvalua> getConvCriCrList() {
        return convCriCrList;
    }

    public void setConvCriCrList(List<SeaCriteriosEvalua> convCriCrList) {
        this.convCriCrList = convCriCrList;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    
    
    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public boolean isValidaVaciosEvalu() {
        return validaVaciosEvalu;
    }

    public void setValidaVaciosEvalu(boolean validaVaciosEvalu) {
        this.validaVaciosEvalu = validaVaciosEvalu;
    }

    public SeaCevaluaXConvocatoria getcEvaluaConvoSelected() {
        return cEvaluaConvoSelected;
    }

    public void setcEvaluaConvoSelected(SeaCevaluaXConvocatoria cEvaluaConvoSelected) {
        this.cEvaluaConvoSelected = cEvaluaConvoSelected;
    }

    public SeaCriteriosEvalua getCriterioEvaluaSelected() {
        return criterioEvaluaSelected;
    }

    public void setCriterioEvaluaSelected(SeaCriteriosEvalua criterioEvaluaSelected) {
        this.criterioEvaluaSelected = criterioEvaluaSelected;
    }
    
    public boolean isGrabaProceso() {
        return grabaProceso;
    }

    public void setGrabaProceso(boolean grabaProceso) {
        this.grabaProceso = grabaProceso;
    }
    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }
    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }
    public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }
    //</editor-fold>
    
}
