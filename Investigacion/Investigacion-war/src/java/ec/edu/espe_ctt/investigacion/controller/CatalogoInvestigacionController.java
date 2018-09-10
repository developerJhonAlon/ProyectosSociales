/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaEstrategia;
import ec.edu.espe_ctt_investigacion.entity.SeaGrupinv;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaObplanbv;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaPolinvest;
import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion;
import ec.edu.espe_ctt_investigacion.entity.Szdtacantprod;
import ec.edu.espe_ctt_investigacion.session.ParametrosGlobales;
import ec.edu.espe_ctt_investigacion.session.SeaClasificadorPresupFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCriteriosEvaluaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaEstrategiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaGrupinvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObplanbvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPolinvestFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaRecursosConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaZonaPlanificacionFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtacantprodFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class CatalogoInvestigacionController implements Serializable {

    /**
     * Creates a new instance of LineasInvestigacionController
     */
    public CatalogoInvestigacionController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario usuario;
    private String usuID;

    /// tab1
    @EJB
    private SeaLineainvesFacade lineaInvestFacade;
    private SeaLineainves lineaInvestigacion;
    private SeaLineainves sublineaInvest;
    private SeaLineainves lineaInvestSelected;
    private SeaLineainves sublineaInveSelected;
    private List<SeaLineainves> lineaInvesList;
    private List<SeaLineainves> sublineaList;
    private boolean validaVaciosSubP1 = true;
    private boolean validaVaciosP1 = true;
    private boolean controlGrabar1 = false;
    private String descripSub = "";
    private String codUnesco = "";
    private String descripLinea = "";

    /// tab2
    @EJB
    private SeaEstrategiaFacade estrategiaFacade;
    private SeaEstrategia estrategia;
    private SeaEstrategia subEstrategia;
    private SeaEstrategia estrategiaSelected;
    private SeaEstrategia subEstrategiaSelected;
    private boolean validaVaciosP2 = true;
    private boolean validaVaciosSubP2 = true;
    private boolean controlGrabar2 = false;
    private String descripEstra = "";
    private String descSubEstra = "";
    private List<SeaEstrategia> estrategiaList;
    private List<SeaEstrategia> estrategiaSubList;

    /// tab3
    @EJB
    private SeaPolinvestFacade polinvesFacade;
    private SeaPolinvest polinvest;
    private SeaPolinvest polinvestSelected;
    private List<SeaPolinvest> polinvestList;
    private boolean controlGrabar3 = false;
    private boolean validaVaciosP3 = true;
    private String nombrePolit = "";
    private String ambitoPolit = "";
    private String descriPolit = "";

    /// tab4
    @EJB
    private SeaObplanbvFacade obplanbvFacade;
    private SeaObplanbv objetivoBuenV;
    private SeaObplanbv objBuenVSelected;
    private List<SeaObplanbv> objetivoBList;
    private boolean controlGrabar4 = false;
    private boolean validaVaciosP4 = true;
    private boolean controlGrabar5 = false;
    private boolean validaVaciosP5 = true;
    private boolean controlGrabarP6 = false;
    private boolean validaVaciosP6 = true;
    private String nombreBV = "";
    private String descripBV = "";

    ///SeaProceso
    @EJB
    private SeaProcesoFacade procesoFacade;
    private SeaProceso seaProceso;
    private SeaProceso seaProcesoSelected;
    private List<SeaProceso> seaProcesoList;
    private BigDecimal sistema;
    private String proDescrip = "";

    ////SeaPrograma
    @EJB
    private SeaProgramaFacade programaFacade;
    private SeaPrograma seaPrograma;
    private SeaPrograma seaProgramaSelected;
    private List<SeaPrograma> seaProgramaList;
    private String descriProgr = "";

    /// Cantidad de Produccion
    @EJB
    private SzdtacantprodFacade cantProdFacade;
    private Szdtacantprod cantProd;
    private Szdtacantprod cantProdSelected;
    private List<Szdtacantprod> cantProdList;
    private boolean controlGrabarP7 = false;
    private boolean validaVaciosP7 = true;
    private String descriProducto = "";
    private String estadoProduccion = "";
    private Date fechaIngreso;

    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    private List<SeaParametrosDet> tipoInvestigacionList;
    private SeaParametrosDet tipoInvestigacion;
    private SeaParametrosDet tipoInvestigacionSelected;
    private boolean controlGrabarTipoInvestigacion = false;
    private boolean validaVaciosTipoInvestigacion = true;
    private String descripcionTipoInvestigacion = "";
    private String estadoTipoInvestigacion = "A";

    @EJB
    private SeaRecursosConvocaFacade recursoAFinanciarFacade;
    private List<SeaRecursosConvoca> recursoAFinanciarList;
    private SeaRecursosConvoca recursoAFinanciar;
    private SeaRecursosConvoca recursoAFinanciarSelected;

    @EJB
    private SeaClasificadorPresupFacade clasificadorPresupuestoFacade;

    private List<SeaClasificadorPresup> clasificadorPresupuestoList;
    private SeaClasificadorPresup clasificadorPresupuestoSelected;

    private List<SeaClasificadorPresup> subPartidaPresupuestoList;
    private SeaClasificadorPresup subPartidaPresupuestoSelected;

    private List<SeaClasificadorPresup> partidaPresupuestoList;
    private SeaClasificadorPresup partidaPresupuestoSelected;

    private boolean controlGrabarRecursoAFinanciar = false;
    private boolean validaVaciosRecursoAFinanciar = true;

    private String nombreRecursoAFinanciar = "";
    private String descripcionRecursoAFinanciar = "";

    //criterios de evaluación
    @EJB
    private SeaCriteriosEvaluaFacade criterioEvaluacionFacade;
    private List<SeaCriteriosEvalua> criterioEvaluacionList;
    private SeaCriteriosEvalua criterioEvaluacionSelected;
    private SeaCriteriosEvalua criterioEvaluacion;

    private boolean controlGrabarCriterioEvaluacion = false;
    private boolean validaVaciosCriterioEvaluacion = true;

    private boolean controlGrabarSubCriterioEvaluacion = false;
    private boolean validaVaciosSubCriterioEvaluacion = true;

    private SeaCriteriosEvalua criterioSubEvaluacionSelected;
    private SeaCriteriosEvalua criterioSubEvaluacion;
    private String nombreCriterioEvaluacion = "";
    private String nombreSubCriterioEvaluacion = "";

    @EJB
    private SeaZonaPlanificacionFacade zonaPlanificacionFacade;
    private List<SeaZonaPlanificacion> zonaPlanificacionList;
    private SeaZonaPlanificacion zonaPlanificacionSelected;
    private SeaZonaPlanificacion zonaPlanificacion;

    private boolean controlGrabarZonaPlanificacion = false;
    private boolean validaVaciosZonaPlanificacion = true;

    private String nombreZonaPlanificacion = "";
    private String nombreLargoZonaPlanificacion = "";

    @EJB
    private SeaGrupinvFacade grupoInvestigacionFacade;
    private List<SeaGrupinv> grupoInvestigacionList;
    private SeaGrupinv grupoInvestigacionSelected;
    private SeaGrupinv grupoInvestigacion;

    private boolean controlGrabarGrupoInvestigacion = false;
    private boolean validaVaciosGrupoInvestigacion = true;

    private String descripcionGrupoInvestigacion = "";

//</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {
        /// tab1
        lineaInvesList = lineaInvestFacade.findLineaSublinea();

        /// tab2
        estrategiaList = estrategiaFacade.findEstrategia();

        //// tab3
        polinvestList = polinvesFacade.findAll();

        ////tab4
        objetivoBList = obplanbvFacade.findAll();
        ///// tabP5
        seaProcesoList = procesoFacade.findProceso();
        /// tabP6
        seaProgramaList = programaFacade.findPrograma();
        /// tabP7
        cantProdList = cantProdFacade.findCantidadProduccion();
        //tabP8 tipo de Investigacion        
        tipoInvestigacionList = parametrosDetFacade.findByCodigoParametro(SeaParametrosDet.PARAM_TIPO_INVESTIGACION);
        //tabP9 recursos a financiar
        recursoAFinanciarList = recursoAFinanciarFacade.findTipoRecurso();
//        clasificadorPresupuestoPadreList = clasificadorPresupuestoFacade.findClasificadorPadre();
        clasificadorPresupuestoList = clasificadorPresupuestoFacade.findClasificadorPadre();
        //tabP 10 criterios de evaluación
        criterioEvaluacionList = criterioEvaluacionFacade.findCriterioEvalua();
        //tabP 11 zona de planificación
        zonaPlanificacionList = zonaPlanificacionFacade.findAll();
        //tab12 grupos de investigacion
        grupoInvestigacionList = grupoInvestigacionFacade.findGrupoInvestiga();
    }

    /// funciones tab1
    public String agregarP1() {
        controlGrabar1 = true;
        return "";
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        descripLinea = descripLinea.trim();
        if (descripLinea.isEmpty()) {
            validaVaciosP1 = true;
        }
        return validaVaciosP1;
    }

    public String registraP1() {
        if (lineaInvestigacion == null) {
            lineaInvestigacion = new SeaLineainves();
            lineaInvestigacion.setLineaDescip(descripLinea);
            lineaInvestFacade.create(lineaInvestigacion);
            lineaInvesList = lineaInvestFacade.findLineaSublinea();
        }
        cancelarP1();
        return "";
    }

    public void cancelarP1() {
        controlGrabar1 = false;
        lineaInvestigacion = null;
        descripLinea = "";
        validaVaciosP1 = true;
    }

    public void eliminarP1() {
        Integer registro = 0;
        if (lineaInvestSelected != null) {
            SeaLineainves eliminar = null;
            for (int i = 0; i < lineaInvesList.size(); i++) {
                SeaLineainves elemento = this.lineaInvesList.get(i);
                if (lineaInvestSelected.getLineaId() == lineaInvesList.get(i).getLineaId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.lineaInvesList.remove(eliminar);
                lineaInvestFacade.remove(eliminar);
                MensajeController m = null;
            }
            lineaInvesList = lineaInvestFacade.findLineaSublinea();
        }
    }

    public void onRowToggleLine(ToggleEvent event) {
        SeaLineainves lin = new SeaLineainves();
        lin = (SeaLineainves) event.getData();
        if (lin != null) {
            sublineaList = lineaInvestFacade.findSublineByLinea(lin.getLineaId());
        }
    }

    public boolean validarVaciosSubP1() {
        validaVaciosSubP1 = false;
        descripSub = descripSub.trim();
        codUnesco = codUnesco.trim();

        if (descripSub.isEmpty()) {
            validaVaciosSubP1 = true;
        }
        if (codUnesco.isEmpty()) {
            validaVaciosSubP1 = true;
        }
        return validaVaciosSubP1;
    }

    public String registraSubP1() {
        if (sublineaInvest == null) {
            System.out.println("linea" + lineaInvestSelected);

            sublineaInvest = new SeaLineainves();
            sublineaInvest.setLineaDescip(descripSub);
            sublineaInvest.setLineaUnesco(new BigInteger(codUnesco));
            sublineaInvest.setLineaIdPadre(lineaInvestSelected);
            lineaInvestFacade.create(sublineaInvest);
            //sublineaList = lineaInvestFacade.findSublineByLinea()
        }
        return "";
    }

    public void eliminarSubP1() {
        Integer registro = 0;
        if (sublineaInveSelected != null) {
            SeaLineainves eliminar = null;
            for (int i = 0; i < sublineaList.size(); i++) {
                SeaLineainves elemento = this.sublineaList.get(i);
                if (sublineaInveSelected.getLineaId() == sublineaList.get(i).getLineaId()) {
                    lineaInvestigacion = sublineaList.get(i).getLineaIdPadre();
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.sublineaList.remove(eliminar);
                lineaInvestFacade.remove(eliminar);
                sublineaList = lineaInvestFacade.findSublineByLinea(BigDecimal.ONE);
                MensajeController m = null;
                //sublineaList = lineaInvestFacade.findSublineByLinea(lineaInvestigacion.getLineaId());
            }

        }
    }

    public void onRowEditSubP1(RowEditEvent event) {
        SeaLineainves sublineaEdit = new SeaLineainves();
        sublineaEdit = (SeaLineainves) event.getObject();
        lineaInvestFacade.edit(sublineaEdit);
    }

    public void onRowCancelSubP1(RowEditEvent event) {

    }

    public void onRowEditP1(RowEditEvent event) {
        SeaLineainves lineaInvEdit = new SeaLineainves();
        lineaInvEdit = (SeaLineainves) event.getObject();
        lineaInvestFacade.edit(lineaInvEdit);
    }

    public void onRowCancelP1(RowEditEvent event) {

    }

    /// funciones tab2
    public String agregarP2() {
        controlGrabar2 = true;
        return "";
    }

    public boolean validarVaciosP2() {
        validaVaciosP2 = false;
        descripEstra = descripEstra.trim();
        if (descripEstra.isEmpty()) {
            validaVaciosP2 = true;
        }
        return validaVaciosP2;
    }

    public String registraP2() {
        if (estrategia == null) {
            estrategia = new SeaEstrategia();
            estrategia.setEstrategDescrip(descripEstra);
            estrategiaFacade.create(estrategia);
            estrategiaList = estrategiaFacade.findEstrategia();
        }
        cancelarP2();
        return "";
    }

    public void cancelarP2() {
        /// inicializar variables de entrada
        controlGrabar2 = false;
        estrategia = null;
        descripEstra = "";
        validaVaciosP2 = true;
    }

    public void eliminarP2() {
        Integer registro = 0;
        if (estrategiaSelected != null) {
            SeaEstrategia eliminar = null;
            for (int i = 0; i < estrategiaList.size(); i++) {
                SeaEstrategia elemento = this.estrategiaList.get(i);
                if (estrategiaSelected.getEstrategId() == estrategiaList.get(i).getEstrategId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.estrategiaList.remove(eliminar);
                estrategiaFacade.remove(eliminar);
                MensajeController m = null;
            }
            estrategiaList = estrategiaFacade.findEstrategia();
        }
    }

    public void onRowToggleEstrat(ToggleEvent event) {
        SeaEstrategia est = new SeaEstrategia();
        est = (SeaEstrategia) event.getData();
        if (est != null) {
            estrategiaSubList = estrategiaFacade.findEstrategiaByEstrat(est.getEstrategId());
        }
    }

    public void onRowEditP2(RowEditEvent event) {
        SeaEstrategia estrategiaEdit = new SeaEstrategia();
        estrategiaEdit = (SeaEstrategia) event.getObject();
        estrategiaFacade.edit(estrategiaEdit);
        estrategiaList = estrategiaFacade.findEstrategia();
    }

    public void onRowCancelP2(RowEditEvent event) {
    }

    public boolean validarVaciosSubP2() {
        validaVaciosSubP2 = false;
        descSubEstra = descSubEstra.trim();
        if (descSubEstra.isEmpty()) {
            validaVaciosSubP2 = true;
        }
        return validaVaciosSubP2;
    }

    public String registraSubP2() {
        if (subEstrategia == null) {
            subEstrategia = new SeaEstrategia();
            subEstrategia.setEstrategDescrip(descSubEstra);
            subEstrategia.setEstrategIdPadre(estrategiaSelected);
            estrategiaFacade.create(subEstrategia);
        }
        return "";
    }

    public void onRowEditSubP2(RowEditEvent event) {
        SeaEstrategia estratSubEdit = new SeaEstrategia();
        estratSubEdit = (SeaEstrategia) event.getObject();
        estrategiaFacade.edit(estratSubEdit);
    }

    public void onRowCancelSubP2(RowEditEvent event) {
    }

    public void eliminarSubP2() {
        Integer registro = 0;
        if (subEstrategiaSelected != null) {
            SeaEstrategia eliminar = null;
            for (int i = 0; i < estrategiaSubList.size(); i++) {
                SeaEstrategia elemento = this.estrategiaSubList.get(i);
                if (subEstrategiaSelected.getEstrategId() == estrategiaSubList.get(i).getEstrategId()) {
                    estrategia = estrategiaSubList.get(i).getEstrategIdPadre();
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.estrategiaSubList.remove(eliminar);
                estrategiaFacade.remove(eliminar);
                MensajeController m = null;
            }
            estrategiaSubList = estrategiaFacade.findEstrategiaByEstrat(estrategia.getEstrategId());
            System.out.println("");
        }
    }

    /// funciones tab3
    public String agregarP3() {
        controlGrabar3 = true;
        return "";
    }

    public boolean validarVaciosP3() {
        validaVaciosP3 = false;
        nombrePolit = nombrePolit.trim();
        ambitoPolit = ambitoPolit.trim();
        descriPolit = descriPolit.trim();

        if (nombrePolit.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (ambitoPolit.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (descriPolit.isEmpty()) {
            validaVaciosP3 = true;
        }
        return validaVaciosP3;
    }

    public String registraP3() {
        if (polinvest == null) {
            polinvest = new SeaPolinvest();
            polinvest.setPolinvNombre(nombrePolit);
            polinvest.setPolinvAmbito(ambitoPolit);
            polinvest.setPolinvDescrip(descriPolit);
            polinvesFacade.create(polinvest);
            polinvestList = polinvesFacade.findAll();
        }
        cancelarP3();
        return "";
    }

    public void cancelarP3() {
        /// inicializar variables de entrada
        controlGrabar3 = false;
        polinvest = null;
        nombrePolit = "";
        ambitoPolit = "";
        descriPolit = "";
        validaVaciosP3 = true;
    }

    public void eliminarP3() {
        Integer registro = 0;
        if (polinvestSelected != null) {
            SeaPolinvest eliminar = null;
            for (int i = 0; i < polinvestList.size(); i++) {
                SeaPolinvest elemento = this.polinvestList.get(i);
                if (polinvestSelected.getPolinvId() == polinvestList.get(i).getPolinvId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.polinvestList.remove(eliminar);
                polinvesFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP3(RowEditEvent event) {
        SeaPolinvest polinvestEdit = new SeaPolinvest();
        polinvestEdit = (SeaPolinvest) event.getObject();

        polinvesFacade.edit(polinvestEdit);
        polinvestList = polinvesFacade.findAll();
    }

    public void onRowCancelP3(RowEditEvent event) {

    }

    /// funciones tab4
    public String agregarP4() {
        controlGrabar4 = true;
        return "";
    }

    public boolean validarVaciosP4() {
        validaVaciosP4 = false;
        nombreBV = nombreBV.trim();
        descripBV = descripBV.trim();
        if (nombreBV.isEmpty()) {
            validaVaciosP4 = true;
        }
        if (descripBV.isEmpty()) {
            validaVaciosP4 = true;
        }
        return validaVaciosP4;
    }

    public String registraP4() {
        if (objetivoBuenV == null) {
            objetivoBuenV = new SeaObplanbv();
            objetivoBuenV.setObplabvNombre(nombreBV);
            objetivoBuenV.setObplanbvDecrip(descripBV);
            obplanbvFacade.create(objetivoBuenV);
            objetivoBList = obplanbvFacade.findAll();
        }
        cancelarP4();
        return "";
    }

    public void cancelarP4() {
        /// inicializar variables de entrada
        controlGrabar4 = false;
        objetivoBuenV = null;
        nombreBV = "";
        descripBV = "";
        validaVaciosP4 = true;
    }

    public void eliminarP4() {
        Integer registro = 0;
        if (objBuenVSelected != null) {
            SeaObplanbv eliminar = null;
            for (int i = 0; i < objetivoBList.size(); i++) {
                SeaObplanbv elemento = this.objetivoBList.get(i);
                if (objBuenVSelected.getObplabvId() == objetivoBList.get(i).getObplabvId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.objetivoBList.remove(eliminar);
                obplanbvFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP4(RowEditEvent event) {
        SeaObplanbv objetivoBEdit = new SeaObplanbv();
        objetivoBEdit = (SeaObplanbv) event.getObject();
        obplanbvFacade.edit(objetivoBEdit);
        objetivoBList = obplanbvFacade.findAll();
    }

    public void onRowCancelP4(RowEditEvent event) {

    }

    /// funciones tabP5
    public String agregarP5() {
        controlGrabar5 = true;
        return "";
    }

    public boolean validarVaciosP5() {
        validaVaciosP5 = false;
        proDescrip = proDescrip.trim();
        if (proDescrip.isEmpty()) {
            validaVaciosP5 = true;
        }
        return validaVaciosP5;
    }

    public String registraP5() {
        //sistema.setSisId(new BigDecimal(4)); //DESARROLLO
        //sistema.setSisId(new BigDecimal(3)); //PRODUCCION  
        BigDecimal idSistema = ParametrosGlobales.AMBIENTE_PRODUCCION1 ? new BigDecimal(3) : new BigDecimal(4);
        SegSistemas sistema = new SegSistemas(idSistema);
        if (seaProceso == null) {
            seaProceso = new SeaProceso();
            seaProceso.setProDescrip(proDescrip);
            seaProceso.setSegSistemas(sistema);
            procesoFacade.create(seaProceso);
            seaProcesoList = procesoFacade.findProceso();
        }
        cancelarP5();
        return "";
    }

    public void cancelarP5() {
        controlGrabar5 = false;
        seaProceso = null;
        proDescrip = "";
        validaVaciosP5 = true;
    }

    public void eliminarP5() {
        if (seaProcesoSelected != null) {
            SeaProceso eliminar = null;
            for (int i = 0; i < seaProcesoList.size(); i++) {
                SeaProceso elemento = this.seaProcesoList.get(i);
                if (seaProcesoSelected.getProId() == seaProcesoList.get(i).getProId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaProcesoList.remove(eliminar);
                procesoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP5(RowEditEvent event) {
        SeaProceso procesoEdit = new SeaProceso();
        procesoEdit = (SeaProceso) event.getObject();
        procesoFacade.edit(procesoEdit);
    }

    public void onRowCancelP5(RowEditEvent event) {
    }

    /// funciones tabP6
    public String agregarP6() {
        controlGrabarP6 = true;
        return "";
    }

    public String registraP6() {
        if (seaPrograma == null) {
            seaPrograma = new SeaPrograma();
            seaPrograma.setProgDescrip(descriProgr);
            programaFacade.create(seaPrograma);
            seaProgramaList = programaFacade.findPrograma();
        }
        cancelarP6();
        return "";
    }

    public void cancelarP6() {
        controlGrabarP6 = false;
        descriProgr = "";
        seaPrograma = null;
        validaVaciosP6 = true;
    }

    public boolean validarVaciosP6() {
        validaVaciosP6 = false;
        descriProgr = descriProgr.trim();
        if (descriProgr.isEmpty()) {
            validaVaciosP6 = true;
        }
        return validaVaciosP6;
    }

    public void eliminarP6() {
        if (seaProgramaSelected != null) {
            SeaPrograma eliminar = null;
            for (int i = 0; i < seaProgramaList.size(); i++) {
                SeaPrograma elemento = this.seaProgramaList.get(i);
                if (seaProgramaSelected.getProgId() == seaProgramaList.get(i).getProgId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaProgramaList.remove(eliminar);
                programaFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP6(RowEditEvent event) {
        SeaPrograma programaEdit = new SeaPrograma();
        programaEdit = (SeaPrograma) event.getObject();
        programaFacade.edit(programaEdit);
    }

    public void onRowCancelP6(RowEditEvent event) {
    }

    ////Funciones tabP7
    public String agregarP7() {
        controlGrabarP7 = true;
        return "";
    }

    public String registraP7() {
        fechaIngreso = new Date();
        if (cantProd == null) {
            System.out.println("ingresa registro");
            cantProd = new Szdtacantprod();
            cantProd.setSzdtacantprodDesc(descriProducto);
            cantProd.setSzdtacantprodFechIngre(fechaIngreso);
            cantProd.setSzdtacantprodEstado(estadoProduccion.charAt(0));
            cantProdFacade.create(cantProd);

        }
        cantProdList = cantProdFacade.findCantidadProduccion();
        cancelarP7();
        return "";
    }

    public void cancelarP7() {
        controlGrabarP7 = false;
        descriProducto = "";
        estadoProduccion = "";
        cantProd = null;
        validaVaciosP7 = true;
    }

    public boolean validarVaciosP7() {
        validaVaciosP7 = false;
        descriProducto = descriProducto.trim();
        estadoProduccion = estadoProduccion.trim();
        if (descriProducto.isEmpty()) {
            validaVaciosP7 = true;
        }
        if (estadoProduccion.isEmpty()) {
            validaVaciosP7 = true;
        }
        return validaVaciosP7;
    }

    public void eliminarP7() {
        cantProdFacade.remove(cantProdSelected);
        cantProdList = cantProdFacade.findCantidadProduccion();
    }

    public void onRowEditP7(RowEditEvent event) {
        Szdtacantprod cantProduccionEdit = new Szdtacantprod();
        cantProduccionEdit = (Szdtacantprod) event.getObject();
        cantProdFacade.edit(cantProduccionEdit);
    }

    public void onRowCancelP7(RowEditEvent event) {
    }

    ////Funciones tab TipoInvestigacion
    public String agregarTipoInvestigacion() {
        controlGrabarTipoInvestigacion = true;
        return "";
    }

    public String registraTipoInvestigacion() {

        if (tipoInvestigacion == null) {
            tipoInvestigacion = new SeaParametrosDet();
            tipoInvestigacion.setPrdId(parametrosDetFacade.getMaxPrdId());
            tipoInvestigacion.setPrdDescripcion(descripcionTipoInvestigacion);
            tipoInvestigacion.setPrdEstado("A");
            tipoInvestigacion.setSeaParametros(new SeaParametros(SeaParametrosDet.PARAM_TIPO_INVESTIGACION));
            parametrosDetFacade.create(tipoInvestigacion);

        }
        tipoInvestigacionList = parametrosDetFacade.findByCodigoParametro(SeaParametrosDet.PARAM_TIPO_INVESTIGACION);
        cancelarTipoInvestigacion();
        return "";
    }

    public void cancelarTipoInvestigacion() {
        controlGrabarTipoInvestigacion = false;
        descripcionTipoInvestigacion = "";

        tipoInvestigacion = null;
        validaVaciosTipoInvestigacion = true;
    }

    public boolean validarVaciosTipoInvestigacion() {
        validaVaciosTipoInvestigacion = false;
        descripcionTipoInvestigacion = descripcionTipoInvestigacion.trim();
        if (descripcionTipoInvestigacion.isEmpty()) {
            validaVaciosTipoInvestigacion = true;
        }
        return validaVaciosTipoInvestigacion;
    }

    public void eliminarTipoInvestigacion() {
        parametrosDetFacade.remove(tipoInvestigacionSelected);
        tipoInvestigacionList.remove(tipoInvestigacionSelected);
    }

    public void onRowEditTipoInvestigacion(RowEditEvent event) {
        SeaParametrosDet tipoInvestigacionEdit = new SeaParametrosDet();

        tipoInvestigacionEdit = (SeaParametrosDet) event.getObject();
        parametrosDetFacade.edit(tipoInvestigacionEdit);
    }

    public void onRowCancelTipoInvestigacion(RowEditEvent event) {
    }

    ////Funciones tab Recursos a financiar
    public String agregarRecursoAFinanciar() {
        controlGrabarRecursoAFinanciar = true;
        return "";
    }

    public void onchangeClasificadorPresupuesto() {
        subPartidaPresupuestoList = clasificadorPresupuestoFacade.findPartidaPrespByCodCp(clasificadorPresupuestoSelected.getScpId());
        validarVaciosRecursoAFinanciar();
    }

    public void onchangeSubPartidaPresupuesto() {
        partidaPresupuestoList = clasificadorPresupuestoFacade.findPartidaPrespByCodCp(subPartidaPresupuestoSelected.getScpId());
        validarVaciosRecursoAFinanciar();
    }

    public String registraRecursoAFinanciar() {

        if (recursoAFinanciar == null) {
            recursoAFinanciar = new SeaRecursosConvoca();
            recursoAFinanciar.setSrcDescripcion(descripcionRecursoAFinanciar);
            recursoAFinanciar.setSrcNombre(nombreRecursoAFinanciar);
            recursoAFinanciar.setScpId(partidaPresupuestoSelected);
//            recursoAFinanciar.setSrcId(recursoAFinanciarFacade.getMaxSrcId());
            recursoAFinanciarFacade.create(recursoAFinanciar);
        }
        recursoAFinanciarList = recursoAFinanciarFacade.findTipoRecurso();
        cancelarRecursoAFinanciar();
        return "";
    }

    public void cancelarRecursoAFinanciar() {
        controlGrabarRecursoAFinanciar = false;
        nombreRecursoAFinanciar = "";
        descripcionRecursoAFinanciar = "";
        clasificadorPresupuestoSelected = new SeaClasificadorPresup();

        recursoAFinanciar = null;
        validaVaciosRecursoAFinanciar = true;
    }

    public boolean validarVaciosRecursoAFinanciar() {
        validaVaciosRecursoAFinanciar = false;
        nombreRecursoAFinanciar = nombreRecursoAFinanciar.trim();
        descripcionRecursoAFinanciar = descripcionRecursoAFinanciar.trim();

        if (nombreRecursoAFinanciar.isEmpty()) {
            validaVaciosRecursoAFinanciar = true;
        }

        if (descripcionRecursoAFinanciar.isEmpty()) {
            validaVaciosRecursoAFinanciar = true;
        }

        if (clasificadorPresupuestoSelected == null) {
            validaVaciosRecursoAFinanciar = true;
        }

        return validaVaciosRecursoAFinanciar;
    }

    public void eliminarRecursoAFinanciar() {
        recursoAFinanciarFacade.remove(recursoAFinanciarSelected);
        recursoAFinanciarList.remove(recursoAFinanciarSelected);
    }

    public void onRowEditRecursoAFinanciar(RowEditEvent event) {
        SeaRecursosConvoca recursoAFinanciarEdit = new SeaRecursosConvoca();

        recursoAFinanciarEdit = (SeaRecursosConvoca) event.getObject();
        recursoAFinanciarFacade.edit(recursoAFinanciarEdit);
    }

    public void onRowCancelRecursoAFinanciar(RowEditEvent event) {
    }

    //criterios evaluación
    public String agregarCriterioEvaluacion() {
        controlGrabarCriterioEvaluacion = true;
        return "";
    }

    public String registraCriterioEvaluacion() {

        if (criterioEvaluacion == null) {
            criterioEvaluacion = new SeaCriteriosEvalua();
            criterioEvaluacion.setSceNombre(nombreCriterioEvaluacion);
//            criterioEvaluacion.setSceId(criterioEvaluacionFacade.getMaxSceId());
            criterioEvaluacionFacade.create(criterioEvaluacion);
        }
        criterioEvaluacionList = criterioEvaluacionFacade.findCriterioEvalua();
        cancelarCriterioEvaluacion();
        return "";
    }

    public void cancelarCriterioEvaluacion() {
        controlGrabarCriterioEvaluacion = false;
        nombreCriterioEvaluacion = "";
        criterioEvaluacion = null;

        validaVaciosCriterioEvaluacion = true;
    }

    public boolean validarVaciosCriterioEvaluacion() {
        validaVaciosCriterioEvaluacion = false;
        nombreCriterioEvaluacion = nombreCriterioEvaluacion.trim();

        if (nombreCriterioEvaluacion.isEmpty()) {
            validaVaciosCriterioEvaluacion = true;
        }

        return validaVaciosCriterioEvaluacion;
    }

    public void eliminarCriterioEvaluacion() {
        criterioEvaluacionFacade.remove(criterioEvaluacionSelected);
        criterioEvaluacionList.remove(criterioEvaluacionSelected);
    }

    public void onRowEditCriterioEvaluacion(RowEditEvent event) {
        SeaCriteriosEvalua criterioEvaluacionEdit = new SeaCriteriosEvalua();

        criterioEvaluacionEdit = (SeaCriteriosEvalua) event.getObject();
        criterioEvaluacionFacade.edit(criterioEvaluacionEdit);
    }

    public void onRowCancelCriterioEvaluacion(RowEditEvent event) {
    }

    public String registraSubCriterioEvaluacion() {

        if (criterioSubEvaluacion == null) {
            criterioSubEvaluacion = new SeaCriteriosEvalua();
            criterioSubEvaluacion.setSceNombre(nombreSubCriterioEvaluacion);
            criterioSubEvaluacion.setSceId(criterioEvaluacionFacade.getMaxSceId());
            criterioSubEvaluacion.setScePadre(criterioEvaluacionSelected);
            criterioEvaluacionFacade.create(criterioSubEvaluacion);
        }
        criterioEvaluacionSelected.getSeaCriteriosEvaluaList().add(criterioSubEvaluacion);
        cancelarSubCriterioEvaluacion();
        return "";
    }

    public void cancelarSubCriterioEvaluacion() {
        controlGrabarSubCriterioEvaluacion = false;
        nombreSubCriterioEvaluacion = "";
        criterioSubEvaluacion = null;

        validaVaciosSubCriterioEvaluacion = true;
    }

    public boolean validarVaciosSubCriterioEvaluacion() {
        validaVaciosSubCriterioEvaluacion = false;
        nombreSubCriterioEvaluacion = nombreSubCriterioEvaluacion.trim();

        if (nombreSubCriterioEvaluacion.isEmpty()) {
            validaVaciosSubCriterioEvaluacion = true;
        }

        return validaVaciosSubCriterioEvaluacion;
    }

    public void eliminarSubCriterioEvaluacion() {
        criterioEvaluacionFacade.remove(criterioSubEvaluacionSelected);
        criterioSubEvaluacionSelected.getScePadre().getSeaCriteriosEvaluaList().remove(criterioSubEvaluacionSelected);
    }

    public void onRowEditSubCriterioEvaluacion(RowEditEvent event) {
        SeaCriteriosEvalua criterioEvaluacionEdit = new SeaCriteriosEvalua();

        criterioEvaluacionEdit = (SeaCriteriosEvalua) event.getObject();
        criterioEvaluacionFacade.edit(criterioEvaluacionEdit);
    }

    public void onRowCancelSubCriterioEvaluacion(RowEditEvent event) {
    }

    ////Funciones tab Zonas de Planificación
    public String agregarZonaPlanificacion() {
        controlGrabarZonaPlanificacion = true;
        return "";
    }

    public String registraZonaPlanificacion() {

        if (zonaPlanificacion == null) {
            zonaPlanificacion = new SeaZonaPlanificacion();
            zonaPlanificacion.setZopNombre(nombreZonaPlanificacion);
            zonaPlanificacion.setZopNombreLargo(nombreLargoZonaPlanificacion);
//            zonaPlanificacion.setZopId(zonaPlanificacionFacade.getMaxZopId());
            zonaPlanificacionFacade.create(zonaPlanificacion);
        }
        zonaPlanificacionList = zonaPlanificacionFacade.findAll();
        cancelarZonaPlanificacion();
        return "";
    }

    public void cancelarZonaPlanificacion() {
        controlGrabarZonaPlanificacion = false;
        nombreZonaPlanificacion = "";
        nombreLargoZonaPlanificacion = "";

        zonaPlanificacion = null;
        validaVaciosZonaPlanificacion = true;
    }

    public boolean validarVaciosZonaPlanificacion() {
        validaVaciosZonaPlanificacion = false;
        nombreZonaPlanificacion = nombreZonaPlanificacion.trim();
        nombreLargoZonaPlanificacion = nombreLargoZonaPlanificacion.trim();

        if (nombreZonaPlanificacion.isEmpty()) {
            validaVaciosZonaPlanificacion = true;
        }

        if (nombreLargoZonaPlanificacion.isEmpty()) {
            validaVaciosZonaPlanificacion = true;
        }

        return validaVaciosZonaPlanificacion;
    }

    public void eliminarZonaPlanificacion() {
        zonaPlanificacionFacade.remove(zonaPlanificacionSelected);
        zonaPlanificacionList.remove(zonaPlanificacionSelected);
    }

    public void onRowEditZonaPlanificacion(RowEditEvent event) {
        SeaZonaPlanificacion zonaPlanificacionEdit = new SeaZonaPlanificacion();

        zonaPlanificacionEdit = (SeaZonaPlanificacion) event.getObject();
        zonaPlanificacionFacade.edit(zonaPlanificacionEdit);
    }

    public void onRowCancelZonaPlanificacion(RowEditEvent event) {
    }

    ////Funciones tab Grupo de Investigacion Asociados
    public String agregarGrupoInvestigacion() {
        controlGrabarGrupoInvestigacion = true;
        return "";
    }

    public String registraGrupoInvestigacion() {

        if (grupoInvestigacion == null) {
            grupoInvestigacion = new SeaGrupinv();
            grupoInvestigacion.setGrupiDescrip(descripcionGrupoInvestigacion);
            grupoInvestigacionFacade.create(grupoInvestigacion);
        }
        grupoInvestigacionList = grupoInvestigacionFacade.findGrupoInvestiga();
        cancelarGrupoInvestigacion();
        return "";
    }

    public void cancelarGrupoInvestigacion() {
        controlGrabarGrupoInvestigacion = false;
        descripcionGrupoInvestigacion = "";

        grupoInvestigacion = null;
        validaVaciosGrupoInvestigacion = true;
    }

    public boolean validarVaciosGrupoInvestigacion() {
        validaVaciosGrupoInvestigacion = false;
        descripcionGrupoInvestigacion = descripcionGrupoInvestigacion.trim();

        if (descripcionGrupoInvestigacion.isEmpty()) {
            validaVaciosGrupoInvestigacion = true;
        }

        return validaVaciosGrupoInvestigacion;
    }

    public void eliminarGrupoInvestigacion() {
        grupoInvestigacionFacade.remove(grupoInvestigacionSelected);
        grupoInvestigacionList.remove(grupoInvestigacionSelected);
    }

    public void onRowEditGrupoInvestigacion(RowEditEvent event) {
        SeaGrupinv grupoInvestigacionEdit = new SeaGrupinv();

        grupoInvestigacionEdit = (SeaGrupinv) event.getObject();
        grupoInvestigacionFacade.edit(grupoInvestigacionEdit);
    }

    public void onRowCancelGrupoInvestigacion(RowEditEvent event) {
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    /// get and set p1
    public List<SeaLineainves> getLineaInvesList() {
        return lineaInvesList;
    }

    public void setLineaInvesList(List<SeaLineainves> lineaInvesList) {
        this.lineaInvesList = lineaInvesList;
    }

    public List<SeaLineainves> getSublineaList() {
        return sublineaList;
    }

    public void setSublineaList(List<SeaLineainves> sublineaList) {
        this.sublineaList = sublineaList;
    }

    public SeaLineainves getLineaInvestSelected() {
        return lineaInvestSelected;
    }

    public void setLineaInvestSelected(SeaLineainves lineaInvestSelected) {
        this.lineaInvestSelected = lineaInvestSelected;
    }

    public boolean isValidaVaciosSubP1() {
        return validaVaciosSubP1;
    }

    public void setValidaVaciosSubP1(boolean validaVaciosSubP1) {
        this.validaVaciosSubP1 = validaVaciosSubP1;
    }

    public String getDescripSub() {
        return descripSub;
    }

    public void setDescripSub(String descripSub) {
        this.descripSub = descripSub;
    }

    public String getCodUnesco() {
        return codUnesco;
    }

    public void setCodUnesco(String codUnesco) {
        this.codUnesco = codUnesco;
    }

    public SeaLineainves getSublineaInveSelected() {
        return sublineaInveSelected;
    }

    public void setSublineaInveSelected(SeaLineainves sublineaInveSelected) {
        this.sublineaInveSelected = sublineaInveSelected;
    }

    public boolean isControlGrabar1() {
        return controlGrabar1;
    }

    public void setControlGrabar1(boolean controlGrabar1) {
        this.controlGrabar1 = controlGrabar1;
    }

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public String getDescripLinea() {
        return descripLinea;
    }

    public void setDescripLinea(String descripLinea) {
        this.descripLinea = descripLinea;
    }

    /// get and set p2
    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public boolean isControlGrabar2() {
        return controlGrabar2;
    }

    public void setControlGrabar2(boolean controlGrabar2) {
        this.controlGrabar2 = controlGrabar2;
    }

    public String getDescripEstra() {
        return descripEstra;
    }

    public void setDescripEstra(String descripEstra) {
        this.descripEstra = descripEstra;
    }

    public List<SeaEstrategia> getEstrategiaList() {
        return estrategiaList;
    }

    public void setEstrategiaList(List<SeaEstrategia> estrategiaList) {
        this.estrategiaList = estrategiaList;
    }

    public List<SeaEstrategia> getEstrategiaSubList() {
        return estrategiaSubList;
    }

    public void setEstrategiaSubList(List<SeaEstrategia> estrategiaSubList) {
        this.estrategiaSubList = estrategiaSubList;
    }

    public SeaEstrategia getEstrategiaSelected() {
        return estrategiaSelected;
    }

    public void setEstrategiaSelected(SeaEstrategia estrategiaSelected) {
        this.estrategiaSelected = estrategiaSelected;
    }

    public String getDescSubEstra() {
        return descSubEstra;
    }

    public void setDescSubEstra(String descSubEstra) {
        this.descSubEstra = descSubEstra;
    }

    public boolean isValidaVaciosSubP2() {
        return validaVaciosSubP2;
    }

    public void setValidaVaciosSubP2(boolean validaVaciosSubP2) {
        this.validaVaciosSubP2 = validaVaciosSubP2;
    }

    public SeaEstrategia getSubEstrategiaSelected() {
        return subEstrategiaSelected;
    }

    public void setSubEstrategiaSelected(SeaEstrategia subEstrategiaSelected) {
        this.subEstrategiaSelected = subEstrategiaSelected;
    }

    /// get and set p3
    public boolean isControlGrabar3() {
        return controlGrabar3;
    }

    public void setControlGrabar3(boolean controlGrabar3) {
        this.controlGrabar3 = controlGrabar3;
    }

    public boolean isValidaVaciosP3() {
        return validaVaciosP3;
    }

    public void setValidaVaciosP3(boolean validaVaciosP3) {
        this.validaVaciosP3 = validaVaciosP3;
    }

    public String getNombrePolit() {
        return nombrePolit;
    }

    public void setNombrePolit(String nombrePolit) {
        this.nombrePolit = nombrePolit;
    }

    public String getAmbitoPolit() {
        return ambitoPolit;
    }

    public void setAmbitoPolit(String ambitoPolit) {
        this.ambitoPolit = ambitoPolit;
    }

    public String getDescriPolit() {
        return descriPolit;
    }

    public void setDescriPolit(String descriPolit) {
        this.descriPolit = descriPolit;
    }

    public List<SeaPolinvest> getPolinvestList() {
        return polinvestList;
    }

    public void setPolinvestList(List<SeaPolinvest> polinvestList) {
        this.polinvestList = polinvestList;
    }

    public SeaPolinvest getPolinvestSelected() {
        return polinvestSelected;
    }

    public void setPolinvestSelected(SeaPolinvest polinvestSelected) {
        this.polinvestSelected = polinvestSelected;
    }

    /// get and set p4
    public SeaObplanbv getObjBuenVSelected() {
        return objBuenVSelected;
    }

    public void setObjBuenVSelected(SeaObplanbv objBuenVSelected) {
        this.objBuenVSelected = objBuenVSelected;
    }

    public boolean isControlGrabar4() {
        return controlGrabar4;
    }

    public void setControlGrabar4(boolean controlGrabar4) {
        this.controlGrabar4 = controlGrabar4;
    }

    public boolean isValidaVaciosP4() {
        return validaVaciosP4;
    }

    public void setValidaVaciosP4(boolean validaVaciosP4) {
        this.validaVaciosP4 = validaVaciosP4;
    }

    public String getNombreBV() {
        return nombreBV;
    }

    public void setNombreBV(String nombreBV) {
        this.nombreBV = nombreBV;
    }

    public String getDescripBV() {
        return descripBV;
    }

    public void setDescripBV(String descripBV) {
        this.descripBV = descripBV;
    }

    public List<SeaObplanbv> getObjetivoBList() {
        return objetivoBList;
    }

    public void setObjetivoBList(List<SeaObplanbv> objetivoBList) {
        this.objetivoBList = objetivoBList;
    }
    /// get and set tabP5

    public boolean isControlGrabar5() {
        return controlGrabar5;
    }

    public void setControlGrabar5(boolean controlGrabar5) {
        this.controlGrabar5 = controlGrabar5;
    }

    public boolean isValidaVaciosP5() {
        return validaVaciosP5;
    }

    public void setValidaVaciosP5(boolean validaVaciosP5) {
        this.validaVaciosP5 = validaVaciosP5;
    }

    public SeaProceso getSeaProcesoSelected() {
        return seaProcesoSelected;
    }

    public void setSeaProcesoSelected(SeaProceso seaProcesoSelected) {
        this.seaProcesoSelected = seaProcesoSelected;
    }

    public List<SeaProceso> getSeaProcesoList() {
        return seaProcesoList;
    }

    public void setSeaProcesoList(List<SeaProceso> seaProcesoList) {
        this.seaProcesoList = seaProcesoList;
    }

    public BigDecimal getSistema() {
        return sistema;
    }

    public void setSistema(BigDecimal sistema) {
        this.sistema = sistema;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }
    /// get and Set tabP6

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

    public SeaPrograma getSeaProgramaSelected() {
        return seaProgramaSelected;
    }

    public void setSeaProgramaSelected(SeaPrograma seaProgramaSelected) {
        this.seaProgramaSelected = seaProgramaSelected;
    }

    public List<SeaPrograma> getSeaProgramaList() {
        return seaProgramaList;
    }

    public void setSeaProgramaList(List<SeaPrograma> seaProgramaList) {
        this.seaProgramaList = seaProgramaList;
    }

    public String getDescriProgr() {
        return descriProgr;
    }

    public void setDescriProgr(String descriProgr) {
        this.descriProgr = descriProgr;
    }

    /// get and set tabP7
    public Szdtacantprod getCantProdSelected() {
        return cantProdSelected;
    }

    public void setCantProdSelected(Szdtacantprod cantProdSelected) {
        this.cantProdSelected = cantProdSelected;
    }

    public List<Szdtacantprod> getCantProdList() {
        return cantProdList;
    }

    public void setCantProdList(List<Szdtacantprod> cantProdList) {
        this.cantProdList = cantProdList;
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

    public String getDescriProducto() {
        return descriProducto;
    }

    public void setDescriProducto(String descriProducto) {
        this.descriProducto = descriProducto;
    }

    public String getEstadoProduccion() {
        return estadoProduccion;
    }

    public void setEstadoProduccion(String estadoProduccion) {
        this.estadoProduccion = estadoProduccion;
    }

    public List<SeaParametrosDet> getTipoInvestigacionList() {
        return tipoInvestigacionList;
    }

    public void setTipoInvestigacionList(List<SeaParametrosDet> tipoInvestigacionList) {
        this.tipoInvestigacionList = tipoInvestigacionList;
    }

    public SeaParametrosDet getTipoInvestigacionSelected() {
        return tipoInvestigacionSelected;
    }

    public void setTipoInvestigacionSelected(SeaParametrosDet tipoInvestigacionSelected) {
        this.tipoInvestigacionSelected = tipoInvestigacionSelected;
    }

    public boolean isControlGrabarTipoInvestigacion() {
        return controlGrabarTipoInvestigacion;
    }

    public void setControlGrabarTipoInvestigacion(boolean controlGrabarTipoInvestigacion) {
        this.controlGrabarTipoInvestigacion = controlGrabarTipoInvestigacion;
    }

    public boolean isValidaVaciosTipoInvestigacion() {
        return validaVaciosTipoInvestigacion;
    }

    public void setValidaVaciosTipoInvestigacion(boolean validaVaciosTipoInvestigacion) {
        this.validaVaciosTipoInvestigacion = validaVaciosTipoInvestigacion;
    }

    public String getDescripcionTipoInvestigacion() {
        return descripcionTipoInvestigacion;
    }

    public void setDescripcionTipoInvestigacion(String descripcionTipoInvestigacion) {
        this.descripcionTipoInvestigacion = descripcionTipoInvestigacion;
    }

    public String getEstadoTipoInvestigacion() {
        return estadoTipoInvestigacion;
    }

    public void setEstadoTipoInvestigacion(String estadoTipoInvestigacion) {
        this.estadoTipoInvestigacion = estadoTipoInvestigacion;
    }

    ///recursos a financiar
    public List<SeaRecursosConvoca> getRecursoAFinanciarList() {
        return recursoAFinanciarList;
    }

    public void setRecursoAFinanciarList(List<SeaRecursosConvoca> recursoAFinanciarList) {
        this.recursoAFinanciarList = recursoAFinanciarList;
    }

    public SeaRecursosConvoca getRecursoAFinanciarSelected() {
        return recursoAFinanciarSelected;
    }

    public void setRecursoAFinanciarSelected(SeaRecursosConvoca recursoAFinanciarSelected) {
        this.recursoAFinanciarSelected = recursoAFinanciarSelected;
    }

    public SeaClasificadorPresup getClasificadorPresupuestoSelected() {
        return clasificadorPresupuestoSelected;
    }

    public void setClasificadorPresupuestoSelected(SeaClasificadorPresup clasificadorPresupuestoSelected) {
        this.clasificadorPresupuestoSelected = clasificadorPresupuestoSelected;
    }

    public List<SeaClasificadorPresup> getSubPartidaPresupuestoList() {
        return subPartidaPresupuestoList;
    }

    public void setSubPartidaPresupuestoList(List<SeaClasificadorPresup> subPartidaPresupuestoList) {
        this.subPartidaPresupuestoList = subPartidaPresupuestoList;
    }

    public SeaClasificadorPresup getSubPartidaPresupuestoSelected() {
        return subPartidaPresupuestoSelected;
    }

    public void setSubPartidaPresupuestoSelected(SeaClasificadorPresup subPartidaPresupuestoSelected) {
        this.subPartidaPresupuestoSelected = subPartidaPresupuestoSelected;
    }

    public List<SeaClasificadorPresup> getPartidaPresupuestoList() {
        return partidaPresupuestoList;
    }

    public void setPartidaPresupuestoList(List<SeaClasificadorPresup> partidaPresupuestoList) {
        this.partidaPresupuestoList = partidaPresupuestoList;
    }

    public SeaClasificadorPresup getPartidaPresupuestoSelected() {
        return partidaPresupuestoSelected;
    }

    public void setPartidaPresupuestoSelected(SeaClasificadorPresup partidaPresupuestoSelected) {
        this.partidaPresupuestoSelected = partidaPresupuestoSelected;
    }

    public List<SeaClasificadorPresup> getClasificadorPresupuestoList() {
        return clasificadorPresupuestoList;
    }

    public void setClasificadorPresupuestoList(List<SeaClasificadorPresup> clasificadorPresupuestoList) {
        this.clasificadorPresupuestoList = clasificadorPresupuestoList;
    }

    public boolean isControlGrabarRecursoAFinanciar() {
        return controlGrabarRecursoAFinanciar;
    }

    public void setControlGrabarRecursoAFinanciar(boolean controlGrabarRecursoAFinanciar) {
        this.controlGrabarRecursoAFinanciar = controlGrabarRecursoAFinanciar;
    }

    public boolean isValidaVaciosRecursoAFinanciar() {
        return validaVaciosRecursoAFinanciar;
    }

    public void setValidaVaciosRecursoAFinanciar(boolean validaVaciosRecursoAFinanciar) {
        this.validaVaciosRecursoAFinanciar = validaVaciosRecursoAFinanciar;
    }

    public String getNombreRecursoAFinanciar() {
        return nombreRecursoAFinanciar;
    }

    public void setNombreRecursoAFinanciar(String nombreRecursoAFinanciar) {
        this.nombreRecursoAFinanciar = nombreRecursoAFinanciar;
    }

    public String getDescripcionRecursoAFinanciar() {
        return descripcionRecursoAFinanciar;
    }

    public void setDescripcionRecursoAFinanciar(String descripcionRecursoAFinanciar) {
        this.descripcionRecursoAFinanciar = descripcionRecursoAFinanciar;
    }

    //criterios de evaluación
    public List<SeaCriteriosEvalua> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<SeaCriteriosEvalua> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
    }

    public SeaCriteriosEvalua getCriterioEvaluacionSelected() {
        return criterioEvaluacionSelected;
    }

    public void setCriterioEvaluacionSelected(SeaCriteriosEvalua criterioEvaluacionSelected) {
        this.criterioEvaluacionSelected = criterioEvaluacionSelected;
    }

    public String getNombreCriterioEvaluacion() {
        return nombreCriterioEvaluacion;
    }

    public void setNombreCriterioEvaluacion(String nombreCriterioEvaluacion) {
        this.nombreCriterioEvaluacion = nombreCriterioEvaluacion;
    }

    public SeaCriteriosEvalua getCriterioSubEvaluacionSelected() {
        return criterioSubEvaluacionSelected;
    }

    public void setCriterioSubEvaluacionSelected(SeaCriteriosEvalua criterioSubEvaluacionSelected) {
        this.criterioSubEvaluacionSelected = criterioSubEvaluacionSelected;
    }

    public boolean isControlGrabarSubCriterioEvaluacion() {
        return controlGrabarSubCriterioEvaluacion;
    }

    public void setControlGrabarSubCriterioEvaluacion(boolean controlGrabarSubCriterioEvaluacion) {
        this.controlGrabarSubCriterioEvaluacion = controlGrabarSubCriterioEvaluacion;
    }

    public boolean isValidaVaciosSubCriterioEvaluacion() {
        return validaVaciosSubCriterioEvaluacion;
    }

    public void setValidaVaciosSubCriterioEvaluacion(boolean validaVaciosSubCriterioEvaluacion) {
        this.validaVaciosSubCriterioEvaluacion = validaVaciosSubCriterioEvaluacion;
    }

    public String getNombreSubCriterioEvaluacion() {
        return nombreSubCriterioEvaluacion;
    }

    public void setNombreSubCriterioEvaluacion(String nombreSubCriterioEvaluacion) {
        this.nombreSubCriterioEvaluacion = nombreSubCriterioEvaluacion;
    }

    public boolean isControlGrabarCriterioEvaluacion() {
        return controlGrabarCriterioEvaluacion;
    }

    public void setControlGrabarCriterioEvaluacion(boolean controlGrabarCriterioEvaluacion) {
        this.controlGrabarCriterioEvaluacion = controlGrabarCriterioEvaluacion;
    }

    public boolean isValidaVaciosCriterioEvaluacion() {
        return validaVaciosCriterioEvaluacion;
    }

    public void setValidaVaciosCriterioEvaluacion(boolean validaVaciosCriterioEvaluacion) {
        this.validaVaciosCriterioEvaluacion = validaVaciosCriterioEvaluacion;
    }

    // zona planificacion
    public List<SeaZonaPlanificacion> getZonaPlanificacionList() {
        return zonaPlanificacionList;
    }

    public void setZonaPlanificacionList(List<SeaZonaPlanificacion> zonaPlanificacionList) {
        this.zonaPlanificacionList = zonaPlanificacionList;
    }

    public SeaZonaPlanificacion getZonaPlanificacionSelected() {
        return zonaPlanificacionSelected;
    }

    public void setZonaPlanificacionSelected(SeaZonaPlanificacion zonaPlanificacionSelected) {
        this.zonaPlanificacionSelected = zonaPlanificacionSelected;
    }

    public boolean isControlGrabarZonaPlanificacion() {
        return controlGrabarZonaPlanificacion;
    }

    public void setControlGrabarZonaPlanificacion(boolean controlGrabarZonaPlanificacion) {
        this.controlGrabarZonaPlanificacion = controlGrabarZonaPlanificacion;
    }

    public boolean isValidaVaciosZonaPlanificacion() {
        return validaVaciosZonaPlanificacion;
    }

    public void setValidaVaciosZonaPlanificacion(boolean validaVaciosZonaPlanificacion) {
        this.validaVaciosZonaPlanificacion = validaVaciosZonaPlanificacion;
    }

    public String getNombreZonaPlanificacion() {
        return nombreZonaPlanificacion;
    }

    public void setNombreZonaPlanificacion(String nombreZonaPlanificacion) {
        this.nombreZonaPlanificacion = nombreZonaPlanificacion;
    }

    public String getNombreLargoZonaPlanificacion() {
        return nombreLargoZonaPlanificacion;
    }

    public void setNombreLargoZonaPlanificacion(String nombreLargoZonaPlanificacion) {
        this.nombreLargoZonaPlanificacion = nombreLargoZonaPlanificacion;
    }

    //grupo de investigacion
    public List<SeaGrupinv> getGrupoInvestigacionList() {
        return grupoInvestigacionList;
    }

    public void setGrupoInvestigacionList(List<SeaGrupinv> grupoInvestigacionList) {
        this.grupoInvestigacionList = grupoInvestigacionList;
    }

    public SeaGrupinv getGrupoInvestigacionSelected() {
        return grupoInvestigacionSelected;
    }

    public void setGrupoInvestigacionSelected(SeaGrupinv grupoInvestigacionSelected) {
        this.grupoInvestigacionSelected = grupoInvestigacionSelected;
    }

    public boolean isControlGrabarGrupoInvestigacion() {
        return controlGrabarGrupoInvestigacion;
    }

    public void setControlGrabarGrupoInvestigacion(boolean controlGrabarGrupoInvestigacion) {
        this.controlGrabarGrupoInvestigacion = controlGrabarGrupoInvestigacion;
    }

    public boolean isValidaVaciosGrupoInvestigacion() {
        return validaVaciosGrupoInvestigacion;
    }

    public void setValidaVaciosGrupoInvestigacion(boolean validaVaciosGrupoInvestigacion) {
        this.validaVaciosGrupoInvestigacion = validaVaciosGrupoInvestigacion;
    }

    public String getDescripcionGrupoInvestigacion() {
        return descripcionGrupoInvestigacion;
    }

    public void setDescripcionGrupoInvestigacion(String descripcionGrupoInvestigacion) {
        this.descripcionGrupoInvestigacion = descripcionGrupoInvestigacion;
    }
//</editor-fold>
}
