/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt_investigacion.entity.SeaBasesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaNoFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import ec.edu.espe_ctt_investigacion.session.SeaBasesConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFinanciaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaNoFinanciaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoXConvocatoriaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProcesoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaRecursosConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCriteriosEvaluaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPorcenXCrConvocaFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import java.util.Date;
import javax.faces.application.FacesMessage;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ConvocatoriaController extends ControllerBase implements Serializable {

    /**
     * Creates a new instance of Convocatoria
     */
    public ConvocatoriaController() {
    }

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    private SegUsuario usuario;
    private String usuID;
    private boolean validaVacios = true;
    private boolean controlGrabar = false;
    private boolean validaVaciosP2 = true;
    private boolean controlGrabarP2 = false;
    private boolean validaVaciosP3 = true;
    private boolean controlGrabarP3 = false;
    private boolean validaVaciosP31 = true;
    private boolean controlGrabarP31 = false;
    private boolean validaVaciosP32 = true;
//    private boolean controlGrabarP32 = false;
    private String recurso = "";
    private String porcentaje = "";

    private String tituloConv = "";
    private String tipoConv = "";
    private String tipoConvEdit = "";
    private String docConv = "";
    private String sbcBases = "";
    private String montoFinanciamiento = "";
    private String snfcDetalle = "";
    private String fInicio = "";
    private Date fechaInicio;
    private String fFinal = "";
    private Date fechaFinal;
    private String estado = "";

    private List<SeaParametrosDet> tipoInvesList;

    @EJB
    private SeaParametrosDetFacade tipoInvesFacade;

    @EJB
    private SeaConvocaFacade convocatoriaFacade;
    private SeaConvoca seaConvoca;
    private SeaConvoca convocatoriaSelected;
    private List<SeaConvoca> seaConvocaList;
    private SeaConvoca convocatoria;

    //Tab2
    @EJB
    private SeaBasesConvocaFacade baseConvocaFacade;
    private SeaBasesConvoca seaBaseConvoca;
    private SeaBasesConvoca seaBaseConvocaSelected;
    private List<SeaBasesConvoca> seaBaseConvocaList;

    //Tab3
    @EJB
    private SeaRecursosConvocaFacade recursoConvocaFacade;
    private List<SeaRecursosConvoca> recursoConvocaList;
    private SeaNoFinanciaConvoca noFinanciaSelected;

    @EJB
    private SeaFinanciaConvocaFacade financiaConvocaFacade;
    private List<SeaFinanciaConvoca> financiaConvocaList;
    private SeaFinanciaConvoca financiaConvocaSelected;

    @EJB
    private SeaNoFinanciaConvocaFacade noFinanciaFacade;

    //Tab4
    private String calificacion1 = "";
    private String calificacion2 = "";
    private String evalua1 = "";
    private String evalua2 = "";
    private String seleccion = "";
    private boolean validaVaciosP4 = true;
    private boolean controlGrabarP4 = false;
    private boolean validaVaciosP41 = true;
    private boolean controlGrabarP41 = false;
    private boolean validaVaciosP42 = true;
    private boolean controlGrabarP42 = false;
    private String criterio1 = "";
    private String criterio2 = "";
    private String porcEvalua1 = "";
    private String porcEvalua2 = "";

    @EJB
    private SeaCriteriosEvaluaFacade seaCriteriosEvaluaFacade;
    private List<SeaCriteriosEvalua> seaCriteriosEvaluaList;
    private SeaCriteriosEvalua seaCritertiosEvaluaSelected;
    @EJB
    private SeaPorcenXCrConvocaFacade seaPorcEvaluaFacade;
    private List<SeaPorcenXCrConvoca> seaPorcEvaluaList;
    private SeaPorcenXCrConvoca seaPorcEvaluaSelected;
    private SeaPorcenXCrConvoca seaPorcEvalua;
    private List<SeaPorcenXCrConvoca> seaPorcEvaluaList2;
    private SeaPorcenXCrConvoca seaPorcEvaluaSelected2;
    private SeaPorcenXCrConvoca seaPorcEvalua2;

    //Tab6
    private String nomProceso = "";
    private String proDescrip = "";
    private Date fechaIni;
    private Date fechaFin;
    private boolean validaVaciosP6 = true;
    private boolean controlGrabarP6 = false;

    //// procesos
    @EJB
    private SeaProcesoFacade procesoFacade;
    private SeaProceso procesoSelected;
    private List<SeaProceso> procesoList;

    @EJB
    private SeaProcesoXConvocatoriaFacade proConvaFacade;
    private List<SeaProcesoXConvocatoria> proConvaList;
    private List<SeaProcesoXConvocatoria> procesoXConvaList;
    private SeaProcesoXConvocatoria proConvaSelected;

    //Tab7
    private String convocaF1 = "";
    private String convocaF2 = "";
    private boolean validaVaciosP7 = true;
    private boolean controlGrabarP7 = false;

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
        System.out.println("hola ");
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {
        tipoInvesList = tipoInvesFacade.findTipoInves();
        // System.out.println("tamaño lista "+ tipoInvesList.size());
        seaConvocaList = convocatoriaFacade.findSeaConvoca();
        procesoList = procesoFacade.findAll();
        seaCriteriosEvaluaList = seaCriteriosEvaluaFacade.findCriterioEvalua();
        financiaConvocaSelected = new SeaFinanciaConvoca();
        noFinanciaSelected = new SeaNoFinanciaConvoca();
    }
    //////

    public String seleccionaConvo() {
        botonInicio = false;
        habilitaTab = false;
        /// tab1
        tipoInvesList = tipoInvesFacade.findTipoInves();

        System.out.println("23  " + convocatoriaSelected.getConvocaTitulo());
        tituloConv = convocatoriaSelected.getConvocaTitulo();
        docConv = convocatoriaSelected.getConvocaDocNombre();
        estado = convocatoriaSelected.getConvocaEstado();
        fechaInicio = convocatoriaSelected.getConvocaFechaInicia();
        fechaFinal = convocatoriaSelected.getConvocaFechaFin();
        tipoConv = String.valueOf(convocatoriaSelected.getPrdId().getPrdId());
        montoFinanciamiento = String.valueOf(convocatoriaSelected.getConvocaFinanciamiento());
        if (montoFinanciamiento.isEmpty()) {
            montoFinanciamiento = "";
        } else {
            montoFinanciamiento = String.valueOf(convocatoriaSelected.getConvocaFinanciamiento());
        }
        calificacion1 = convocatoriaSelected.getConvocaCalifica1();
        evalua1 = convocatoriaSelected.getConvocaEvalua1();
        calificacion2 = convocatoriaSelected.getConvocaCalifica2();
        evalua2 = convocatoriaSelected.getConvocaEvalua2();
        convocaF1 = convocatoriaSelected.getConvocaFormatoF1();
        convocaF2 = convocatoriaSelected.getConvocaFormatoF2();
        seleccion = convocatoriaSelected.getConvocaSeleccionF2();
        financiaConvocaList = financiaConvocaFacade.findFinanAllByConvocatoriaActivo(convocatoriaSelected.getConvocaId());
        //// tab2

        seaBaseConvocaList = baseConvocaFacade.findBasesbyConvocatoria(convocatoriaSelected);
        recursoConvocaList = recursoConvocaFacade.findTipoRecurso();
        /// tab4
        convocatoria = convocatoriaFacade.findConvocaByIdConvoca(convocatoriaSelected.getConvocaId());
        if (convocatoria != null && (convocatoria.getConvocaFinanciamiento() != null)) {
            System.out.println("fffff " + convocatoria.getConvocaFinanciamiento());
            montoFinanciamiento = convocatoria.getConvocaFinanciamiento().toString();
            if (montoFinanciamiento == null) {
                montoFinanciamiento = "";
            } else {
                montoFinanciamiento = convocatoria.getConvocaFinanciamiento().toString();
            }
        }
        seaPorcEvaluaList = seaPorcEvaluaFacade.findPorcenbyConvocatoria(convocatoriaSelected);
        seaPorcEvaluaList2 = seaPorcEvaluaFacade.findPorcenbyConvocatoria2(convocatoriaSelected);
        // tab 6
        proConvaList = proConvaFacade.findProcesoByConvocatoria(convocatoriaSelected);
        return "";
    }

    public String agregarP1() {
        controlGrabar = true;
        return "";
    }

    public String agregarP3() {
        /*controlGrabarP3 = true;
         if (convocatoriaSelected != null) {
            //insert
            noFinancia = new SeaNoFinanciaConvoca();
            noFinancia.setSnfcDetalle(snfcDetalle);
            noFinancia.setConvocaId(convocatoriaSelected);
            noFinanciaFacade.create(noFinancia);
            //System.out.println("lista " + noFinanciaList.size() );
            noFinanciaList = noFinanciaFacade.findNoFinanciabyConvocatoria(convocatoriaSelected);
        }
        cancelarP31();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";*/
        try {
            convocatoriaSelected.addNoFinanciamientoRecurso(noFinanciaSelected);
            noFinanciaSelected = new SeaNoFinanciaConvoca();

        } catch (Exception e) {
        }
        return "";
    }

    public String agregarP6() {
        controlGrabarP6 = true;
        return "";
    }

    public void cancelarP1() {
        controlGrabar = false;
        tituloConv = "";
        docConv = "";
        tipoConv = "";
        fechaInicio = null;
        fechaFinal = null;
        estado = "";
        seaConvoca = null;
        validaVacios = true;
    }

    public String registra() {
        if (!convocatoriaSelected.getConvocaFechaInicia().before(convocatoriaSelected.getConvocaFechaFin())) {
            RequestContext.getCurrentInstance().execute("alert('La Fecha Inicial no puede ser mayor a la Fecha Final')");
            return "";
        }
        if (convocatoriaSelected.getConvocaId() == null) { // Insert

            convocatoriaSelected.setUsuId(usuario);
            convocatoriaFacade.create(convocatoriaSelected);
            seaConvocaList = convocatoriaFacade.findSeaConvoca();
        } else { // Update
            convocatoriaSelected.setUsuId(usuario);
            convocatoriaFacade.edit(convocatoriaSelected);
            seaConvocaList = convocatoriaFacade.findSeaConvoca();
        }
        //cancelarP1();
        habilitaTab = false;
        validaVacios = true;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        return "";
    }

    public String agregarP2() {
        controlGrabarP2 = true;
        return "";
    }

    public String registraP2() {

        //insert
        if (seaBaseConvoca == null) {
            seaBaseConvoca = new SeaBasesConvoca();

            seaBaseConvoca.setSbcBases(sbcBases);
            seaBaseConvoca.setConvocaId(convocatoriaSelected);

            baseConvocaFacade.create(seaBaseConvoca);

            seaBaseConvocaList = baseConvocaFacade.findBasesbyConvocatoria(convocatoriaSelected);

        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        //validaVaciosP2 = true;
        cancelarP2();
        return "";
    }

    public void cancelarP2() {
        controlGrabarP2 = false;
        seaBaseConvoca = null;
        sbcBases = "";
        validaVaciosP2 = true;
    }

    public boolean validarVaciosP2() {
        validaVaciosP2 = false;
        sbcBases = sbcBases.trim();
        if (sbcBases.isEmpty()) {
            validaVaciosP2 = true;
        }
        return validaVaciosP2;
    }

    ////funciones tabP3
    public String registraP3() {
        convocatoriaFacade.edit(convocatoriaSelected);
        financiaConvocaSelected = new SeaFinanciaConvoca();
        noFinanciaSelected = new SeaNoFinanciaConvoca();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    public String registraP32() {//agrega recurso financiamiento
        /*System.out.println("registra");
        if (Integer.valueOf(porcentaje) <= 100) {
            if (financiaConvocaFacade.findFinanAllByRecurso(convocatoriaSelected.getConvocaId(), new BigInteger(recurso)).size() < 1) {
                BigInteger suma = obtenerTotalPorcentajeFinan().add(new BigInteger(porcentaje));
                if (suma.compareTo(new BigInteger("100")) <= 0) {

                    SeaFinanciaConvoca financiaEdit = new SeaFinanciaConvoca();
                    SeaRecursosConvoca rec = new SeaRecursosConvoca();
                    financiaEdit.setSfcPorcentaje(new BigInteger(porcentaje));
                    financiaEdit.setConvocaId(convocatoriaSelected);
                    rec.setSrcId(new BigDecimal(recurso));
                    financiaEdit.setSrcId(rec);
                    financiaConvocaFacade.create(financiaEdit);
                    financiaConvocaList = financiaConvocaFacade.findFinanAllByConvocatoria(convocatoriaSelected.getConvocaId());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
                } else {
                    org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El porcentaje Total no debe ser mayor a 100')");
                }
            } else {
                org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El recurso ya fue asignado')");
            }
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El porcentaje debe ser menor a 100')");
        }
        cancelarP32();
        return "";
         */

        try {
            convocatoriaSelected.addFinanciamientoRecurso(financiaConvocaSelected);
            financiaConvocaSelected = new SeaFinanciaConvoca();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return "";
    }

    public void cancelarP31() {
        controlGrabarP31 = false;
        snfcDetalle = "";
        validaVaciosP31 = true;
    }

    public String registraP41() {
        BigInteger fase1 = BigInteger.valueOf(261);
        //if (financiaConvocaFacade.findFinanAllByRecurso(convocatoriaSelected.getConvocaId(), new BigInteger(recurso)).size() < 1) {
        if (seaPorcEvaluaFacade.findPorConvocaByCodConCodFaseCodSec(convocatoriaSelected.getConvocaId(), fase1, new BigDecimal(criterio1)).size() < 1) {
            System.out.println("registra");
            if (convocatoriaSelected != null) {

                System.out.println("111");
                //insert
                seaPorcEvalua = new SeaPorcenXCrConvoca();

                SeaCriteriosEvalua crit = new SeaCriteriosEvalua();
                SeaParametrosDet fase = new SeaParametrosDet();

                seaPorcEvalua.setConvocaId(convocatoriaSelected);
                fase.setPrdId(Long.parseLong("261"));/// 261 codigo de la fase1          
                seaPorcEvalua.setPrdId(fase);
                crit.setSceId(new BigDecimal(criterio1));
                seaPorcEvalua.setSceId(crit);

                seaPorcEvalua.setSpxccPorcentaje(new BigInteger(porcEvalua1));
                System.out.println("antes");
                seaPorcEvaluaFacade.create(seaPorcEvalua);
                System.out.println("despues");

                seaPorcEvaluaList = seaPorcEvaluaFacade.findPorcenbyConvocatoria(convocatoriaSelected);
                System.out.println("lista " + seaPorcEvaluaList.size());

            }
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El Criterio para la Fase 1 ya fue asignado')");
            cancelarP41();
        }
        cancelarP41();
        return "";
    }

    public String registraP42() {
        BigInteger faseD = BigInteger.valueOf(262);
        if (seaPorcEvaluaFacade.findPorConvocaByCodConCodFaseCodSec(convocatoriaSelected.getConvocaId(), faseD, new BigDecimal(criterio2)).size() < 1) {
            System.out.println("registrafase2");
            if (convocatoriaSelected != null) {

                System.out.println("111");
                //insert
                seaPorcEvalua2 = new SeaPorcenXCrConvoca();

                SeaCriteriosEvalua crit2 = new SeaCriteriosEvalua();
                SeaParametrosDet fase2 = new SeaParametrosDet();

                seaPorcEvalua2.setConvocaId(convocatoriaSelected);
                fase2.setPrdId(Long.parseLong("262"));/// 262 codigo de la fase2          
                seaPorcEvalua2.setPrdId(fase2);
                crit2.setSceId(new BigDecimal(criterio2));
                seaPorcEvalua2.setSceId(crit2);

                seaPorcEvalua2.setSpxccPorcentaje(new BigInteger(porcEvalua2));
                System.out.println("antes");
                seaPorcEvaluaFacade.create(seaPorcEvalua2);
                System.out.println("despues");

                seaPorcEvaluaList2 = seaPorcEvaluaFacade.findPorcenbyConvocatoria2(convocatoriaSelected);
                System.out.println("lista " + seaPorcEvaluaList2.size());

            }
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('El Criterio para la Fase 2 ya fue asignado')");
            cancelarP42();
        }
        cancelarP42();
        return "";
    }

    public String registraP6() {
        SeaProceso obj1 = new SeaProceso();
        obj1.setProId(new BigDecimal(nomProceso));
        procesoXConvaList = procesoFacade.findProcesoByCodProCodConv(new BigDecimal(nomProceso), convocatoriaSelected.getConvocaId());
        if (procesoXConvaList != null) {
            RequestContext.getCurrentInstance().execute("alert('Proceso ya fue asignado a Convocatoria')");
        } else if (convocatoriaSelected != null) {
            if (fechaIni.before(fechaFin)) {
                /// Insert
                proConvaSelected = new SeaProcesoXConvocatoria();
                proConvaSelected.setPpcEstado(new BigInteger("1"));
                proConvaSelected.setPpcFecini(fechaIni);
                proConvaSelected.setPpcFecifin(fechaFin);
                proConvaSelected.setSeaConvoca(convocatoriaSelected);
                proConvaSelected.setSeaProceso(obj1);
                proConvaFacade.create(proConvaSelected);
                proConvaList = proConvaFacade.findProcesoByConvocatoria(convocatoriaSelected);
            } else {
                RequestContext.getCurrentInstance().execute("alert('La Fecha de Recepción no puede ser mayor a la Fecha de Presentación')");
            }
        }
        cancelarP6();
        habilitaTab = false;
        validaVaciosP6 = true;
        return "";
    }

    public void cancelarP3() {
        convocatoriaSelected = convocatoriaFacade.find(convocatoriaSelected.getConvocaId());
        financiaConvocaSelected = new SeaFinanciaConvoca();
        noFinanciaSelected = new SeaNoFinanciaConvoca();
    }

    public void eliminarP32() {
        convocatoriaSelected.removeFinanciamientoRecurso(financiaConvocaSelected);
    }

    public void cancelarP41() {
        validaVaciosP41 = true;
        criterio1 = "";
        porcEvalua1 = "";
        //seaPorcEvaluaList.clear();

    }

    public void cancelarP42() {
        validaVaciosP42 = true;
        criterio2 = "";
        porcEvalua2 = "";
        //seaPorcEvaluaList2.clear();
    }

    public void cancelarP6() {
        controlGrabarP6 = false;
        nomProceso = "";
        fechaIni = null;
        fechaFin = null;
        proConvaSelected = null;
        validaVaciosP6 = true;
    }

    public void eliminarP1() {
        if (convocatoriaSelected != null) {
            SeaConvoca eliminar = null;
            for (int i = 0; i < seaConvocaList.size(); i++) {
                SeaConvoca elemento = this.seaConvocaList.get(i);
                if (convocatoriaSelected.getConvocaId() == seaConvocaList.get(i).getConvocaId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaConvocaList.remove(eliminar);
                convocatoriaFacade.remove(eliminar);
                MensajeController m = null;
            }
            seaConvocaList = convocatoriaFacade.findAll();
        }
    }

    public void eliminarP3() { //Elimina recurso no financiado
        /*System.out.println("eliminar");
        Integer registro = 0;
        if (noFinanciaSelected != null) {
            SeaNoFinanciaConvoca eliminar = null;
            for (int i = 0; i < noFinanciaList.size(); i++) {
                SeaNoFinanciaConvoca elemento = this.noFinanciaList.get(i);
                if (noFinanciaSelected.getSnfcId() == noFinanciaList.get(i).getSnfcId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.noFinanciaList.remove(eliminar);
                noFinanciaFacade.remove(eliminar);
                MensajeController m = null;
            }
            noFinanciaList = noFinanciaFacade.findNoFinanciabyConvocatoria(convocatoriaSelected);
        }*/
        convocatoriaSelected.removeNoFinanciamientoRecurso(noFinanciaSelected);
    }

    public void eliminarP2() {
        Integer registro = 0;
        if (seaBaseConvocaSelected != null) {
            SeaBasesConvoca eliminar = null;
            for (int i = 0; i < seaBaseConvocaList.size(); i++) {
                SeaBasesConvoca elemento = this.seaBaseConvocaList.get(i);
                if (seaBaseConvocaSelected.getSbcId() == seaBaseConvocaList.get(i).getSbcId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaBaseConvocaList.remove(eliminar);
                baseConvocaFacade.remove(eliminar);
                MensajeController m = null;
            }
            seaBaseConvocaList = baseConvocaFacade.findBasesbyConvocatoria(convocatoriaSelected);
        }
    }

    public void eliminarP41() {
        System.out.println("eliminar");
        Integer registro = 0;
        if (seaPorcEvaluaSelected != null) {
            SeaPorcenXCrConvoca eliminar = null;
            for (int i = 0; i < seaPorcEvaluaList.size(); i++) {
                SeaPorcenXCrConvoca elemento = this.seaPorcEvaluaList.get(i);
                if (seaPorcEvaluaSelected.getSpxccId() == seaPorcEvaluaList.get(i).getSpxccId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaPorcEvaluaList.remove(eliminar);
                seaPorcEvaluaFacade.remove(eliminar);
                MensajeController m = null;
            }

            //seaPorcEvaluaList = seaPorcEvaluaFacade.findPorcenbyConvocatoria2(convocatoriaSelected);
        }
    }

    public void eliminarP42() {

        Integer registro = 0;
        if (seaPorcEvaluaSelected2 != null) {
            SeaPorcenXCrConvoca eliminar = null;
            for (int i = 0; i < seaPorcEvaluaList2.size(); i++) {
                SeaPorcenXCrConvoca elemento = this.seaPorcEvaluaList2.get(i);
                if (seaPorcEvaluaSelected2.getSpxccId() == seaPorcEvaluaList2.get(i).getSpxccId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.seaPorcEvaluaList2.remove(eliminar);
                seaPorcEvaluaFacade.remove(eliminar);
                MensajeController m = null;
            }

            seaPorcEvaluaList2 = seaPorcEvaluaFacade.findPorcenbyConvocatoria2(convocatoriaSelected);

        }
    }

    public void eliminarP6() {
        // System.out.println("eliminar");
        Integer registro = 0;
        if (proConvaSelected != null) {
            SeaProcesoXConvocatoria eliminar = null;
            for (int i = 0; i < proConvaList.size(); i++) {
                SeaProcesoXConvocatoria elemento = this.proConvaList.get(i);
                if (proConvaSelected.getPpcId() == proConvaList.get(i).getPpcId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.proConvaList.remove(eliminar);
                proConvaFacade.remove(eliminar);
                MensajeController m = null;
            }
            proConvaList = proConvaFacade.findProcesoByConvocatoria(convocatoriaSelected);
        }
    }

    public String registraP4() {
        try {
            convocatoriaSelected.setConvocaCalifica1(calificacion1);
            convocatoriaSelected.setConvocaEvalua1(evalua1);
            convocatoriaSelected.setConvocaCalifica2(calificacion2);
            convocatoriaSelected.setConvocaEvalua2(evalua2);
            convocatoriaSelected.setConvocaSeleccionF2(seleccion);
            convocatoriaFacade.edit(convocatoriaSelected);
            validaVaciosP4 = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return "";
    }

    public String registraP7() {
        System.out.println("registra");
        if (convocatoriaSelected == null) {

            /// insert
        } else {
            ///update

            convocatoriaSelected.setConvocaFormatoF1(convocaF1);
            convocatoriaSelected.setConvocaFormatoF2(convocaF2);
            convocatoriaFacade.edit(convocatoriaSelected);

        }
        validaVaciosP7 = true;
        return "";
    }

    public boolean validarVacios() {
        validaVacios = false;
        tituloConv = tituloConv.trim();
        tipoConv = tipoConv.trim();
        docConv = docConv.trim();
        estado = estado.trim();
        if (fechaInicio != null) {
            fInicio = fechaInicio.toString();
            fInicio = fInicio.trim();
        }
        if (fechaFinal != null) {
            fFinal = fechaFinal.toString();
            fFinal = fFinal.trim();
        }
        if (tituloConv.isEmpty()) {
            validaVacios = true;
        }
        if (tipoConv.isEmpty()) {
            validaVacios = true;
        }
        if (docConv.isEmpty()) {
            validaVacios = true;
        }
        if (fInicio.isEmpty()) {
            validaVacios = true;
        }
        if (fFinal.isEmpty()) {
            validaVacios = true;
        }
        if (estado.isEmpty()) {
            validaVacios = true;
        }
        return validaVacios;
    }

    public boolean validarVaciosP3() {
        validaVaciosP3 = false;
        montoFinanciamiento = montoFinanciamiento.trim();

        if (montoFinanciamiento.isEmpty()) {
            validaVaciosP3 = true;
        }

        return validaVaciosP3;

    }

    public boolean validarVaciosP31() {
        validaVaciosP31 = false;
        snfcDetalle = snfcDetalle.trim();

        if (snfcDetalle.isEmpty()) {
            validaVaciosP3 = true;
        }

        return validaVaciosP31;

    }

    public boolean validarVaciosP32() {
        validaVaciosP32 = false;
        recurso = recurso.trim();
        porcentaje = porcentaje.trim();

        if (recurso.isEmpty()) {
            validaVaciosP32 = true;
        }
        if (porcentaje.isEmpty()) {
            validaVaciosP32 = true;
        }

        return validaVaciosP32;

    }

    public boolean validarVaciosP4() {
        validaVaciosP4 = false;
        System.out.println("valida1 ");
        calificacion1 = calificacion1.trim();
        //calificacion2 = calificacion2.trim();
        //evalua1 = evalua1.trim();
        evalua2 = evalua2.trim();
        seleccion = seleccion.trim();

        if (calificacion1.isEmpty()) {
            validaVaciosP4 = true;
        }
        if (evalua2.isEmpty()) {
            validaVaciosP4 = true;
        }

        /*if (calificacion2.isEmpty()) {
            validaVaciosP4 = true;
        }*/
        if (seleccion.isEmpty()) {
            validaVaciosP4 = true;
        }

        return validaVaciosP4;

    }

    public boolean validarVaciosP41() {
        validaVaciosP41 = false;
        criterio1 = criterio1.trim();
        porcEvalua1 = porcEvalua1.trim();

        if (criterio1.isEmpty()) {
            validaVaciosP41 = true;
        }
        if (porcEvalua1.isEmpty()) {
            validaVaciosP41 = true;
        }

        return validaVaciosP41;

    }

    public boolean validarVaciosP42() {

        validaVaciosP42 = false;
        criterio2 = criterio2.trim();
        porcEvalua2 = porcEvalua2.trim();

        if (criterio2.isEmpty()) {
            System.out.println("no 1");
            validaVaciosP42 = true;
        }
        if (porcEvalua2.isEmpty()) {
            System.out.println("no 2");
            validaVaciosP42 = true;
        }
        System.out.println(" retorna " + validaVaciosP42);
        return validaVaciosP42;

    }

    public boolean validarVaciosP6() {
        validaVaciosP6 = false;
        nomProceso = nomProceso.trim();

        if (nomProceso.isEmpty()) {
            validaVaciosP6 = true;
        }
//        
//        
        if (fechaIni == null) {
            validaVaciosP6 = true;

        }
        if (fechaFin == null) {
            validaVaciosP6 = true;

        }
        return validaVaciosP6;

    }

    public boolean validarVaciosP7() {
        validaVaciosP7 = false;
        convocaF1 = convocaF1.trim();
        convocaF2 = convocaF2.trim();

        if (convocaF1.isEmpty()) {
            validaVaciosP7 = true;
        }
        if (convocaF2.isEmpty()) {
            validaVaciosP7 = true;
        }
//        
//        
        return validaVaciosP7;

    }

    public void onRowEdit(RowEditEvent event) {

        SeaConvoca convocatoriaEdit = new SeaConvoca();
        convocatoriaEdit = (SeaConvoca) event.getObject();

        convocatoriaFacade.edit(convocatoriaEdit);

    }

    public void onRowEditP3(RowEditEvent event) {

        SeaNoFinanciaConvoca noFinanciaEdit = new SeaNoFinanciaConvoca();
        noFinanciaEdit = (SeaNoFinanciaConvoca) event.getObject();

        noFinanciaFacade.edit(noFinanciaEdit);

    }

    public void onRowCancel(RowEditEvent event) {

    }

    public void onRowEdit2(RowEditEvent event) {

        SeaBasesConvoca basesEdit = new SeaBasesConvoca();
        basesEdit = (SeaBasesConvoca) event.getObject();

        baseConvocaFacade.edit(basesEdit);

    }

    public void onRowCancel2(RowEditEvent event) {

    }

    public String inicioConvocatorias() {
        seaBaseConvocaSelected = null;
        noFinanciaSelected = null;
        tituloConv = "";
        tipoConv = "";
        docConv = "";
        sbcBases = "";
        montoFinanciamiento = "";
        snfcDetalle = "";
        calificacion1 = "";
        calificacion2 = "";
        evalua1 = "";
        evalua2 = "";
        convocaF1 = "";
        convocaF2 = "";
        if (botonInicio) {//listado de convocatorias
            convocatoriaSelected = null;
            habilitaTab = true;
        } else {//nuevo
            convocatoriaSelected = new SeaConvoca();
            convocatoriaSelected.setConvocaEstado("A");
            convocatoriaSelected.setConvocaAnio(convocatoriaFacade.findAnio());
            noFinanciaSelected = new SeaNoFinanciaConvoca();
        }

        return "";

    }

    /*
        Objetivo: Crear nueva convocatoria  asi exista una, solo activa TAB1
        Fecha: 20-Abril-2015
     */
    /// funciones tab4
    public String agregarP4() {
        controlGrabarP4 = true;
        return "";
    }
    /// funciones tab6

    public String seleccionaProceso() {
        botonInicio = false;
        habilitaTab = false;
        //cargaDatosConvoca();
        return "";
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    //// get and set tab1
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getfFinal() {
        return fFinal;
    }

    public void setfFinal(String fFinal) {
        this.fFinal = fFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public String getTituloConv() {
        return tituloConv;
    }

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }

    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public void setTituloConv(String tituloConv) {
        this.tituloConv = tituloConv;
    }

    public String getTipoConv() {
        return tipoConv;
    }

    public void setTipoConv(String tipoConv) {
        this.tipoConv = tipoConv;
    }

    public String getDocConv() {
        return docConv;
    }

    public void setDocConv(String docConv) {
        this.docConv = docConv;
    }

    public List<SeaParametrosDet> getTipoInvesList() {
        return tipoInvesList;
    }

    public void setTipoInvesList(List<SeaParametrosDet> tipoInvesList) {
        this.tipoInvesList = tipoInvesList;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public SeaConvoca getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(SeaConvoca convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }

    public String getTipoConvEdit() {
        return tipoConvEdit;
    }

    public void setTipoConvEdit(String tipoConvEdit) {
        this.tipoConvEdit = tipoConvEdit;
    }

    public String getSbcBases() {
        return sbcBases;
    }

    public void setSbcBases(String sbcBases) {
        this.sbcBases = sbcBases;
    }

    public SeaBasesConvocaFacade getBaseConvocaFacade() {
        return baseConvocaFacade;
    }

    public void setBaseConvocaFacade(SeaBasesConvocaFacade baseConvocaFacade) {
        this.baseConvocaFacade = baseConvocaFacade;
    }

    public SeaBasesConvoca getSeaBaseConvoca() {
        return seaBaseConvoca;
    }

    public void setSeaBaseConvoca(SeaBasesConvoca seaBaseConvoca) {
        this.seaBaseConvoca = seaBaseConvoca;
    }

    public SeaBasesConvoca getSeaBaseConvocaSelected() {
        return seaBaseConvocaSelected;
    }

    public void setSeaBaseConvocaSelected(SeaBasesConvoca seaBaseConvocaSelected) {
        this.seaBaseConvocaSelected = seaBaseConvocaSelected;
    }

    public List<SeaBasesConvoca> getSeaBaseConvocaList() {
        return seaBaseConvocaList;
    }

    public void setSeaBaseConvocaList(List<SeaBasesConvoca> seaBaseConvocaList) {
        this.seaBaseConvocaList = seaBaseConvocaList;
    }

    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public boolean isControlGrabarP2() {
        return controlGrabarP2;
    }

    public void setControlGrabarP2(boolean controlGrabarP2) {
        this.controlGrabarP2 = controlGrabarP2;
    }

    public boolean isValidaVaciosP3() {
        return validaVaciosP3;
    }

    public void setValidaVaciosP3(boolean validaVaciosP3) {
        this.validaVaciosP3 = validaVaciosP3;
    }

    public boolean isControlGrabarP3() {
        return controlGrabarP3;
    }

    public void setControlGrabarP3(boolean controlGrabarP3) {
        this.controlGrabarP3 = controlGrabarP3;
    }

    public String getMontoFinanciamiento() {
        return montoFinanciamiento;
    }

    public void setMontoFinanciamiento(String montoFinanciamiento) {
        this.montoFinanciamiento = montoFinanciamiento;
    }

    public String getSnfcDetalle() {
        return snfcDetalle;
    }

    public void setSnfcDetalle(String snfcDetalle) {
        this.snfcDetalle = snfcDetalle;
    }

    public List<SeaFinanciaConvoca> getFinanciaConvocaList() {
        return financiaConvocaList;
    }

    public void setFinanciaConvocaList(List<SeaFinanciaConvoca> financiaConvocaList) {
        this.financiaConvocaList = financiaConvocaList;
    }

    public SeaFinanciaConvoca getFinanciaConvocaSelected() {
        return financiaConvocaSelected;
    }

    public void setFinanciaConvocaSelected(SeaFinanciaConvoca financiaConvocaSelected) {
        this.financiaConvocaSelected = financiaConvocaSelected;
    }

    public SeaNoFinanciaConvoca getNoFinanciaSelected() {
        return noFinanciaSelected;
    }

    public void setNoFinanciaSelected(SeaNoFinanciaConvoca noFinanciaSelected) {
        this.noFinanciaSelected = noFinanciaSelected;
    }

    public SeaNoFinanciaConvocaFacade getNoFinanciaFacade() {
        return noFinanciaFacade;
    }

    public void setNoFinanciaFacade(SeaNoFinanciaConvocaFacade noFinanciaFacade) {
        this.noFinanciaFacade = noFinanciaFacade;
    }

    public boolean isValidaVaciosP31() {
        return validaVaciosP31;
    }

    public void setValidaVaciosP31(boolean validaVaciosP31) {
        this.validaVaciosP31 = validaVaciosP31;
    }

    public boolean isControlGrabarP31() {
        return controlGrabarP31;
    }

    public void setControlGrabarP31(boolean controlGrabarP31) {
        this.controlGrabarP31 = controlGrabarP31;
    }

    public boolean isValidaVaciosP32() {
        return validaVaciosP32;
    }

    public void setValidaVaciosP32(boolean validaVaciosP32) {
        this.validaVaciosP32 = validaVaciosP32;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(String calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public String getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(String calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public String getEvalua1() {
        return evalua1;
    }

    public void setEvalua1(String evalua1) {
        this.evalua1 = evalua1;
    }

    public String getEvalua2() {
        return evalua2;
    }

    public void setEvalua2(String evalua2) {
        this.evalua2 = evalua2;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
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

    public List<SeaCriteriosEvalua> getSeaCriteriosEvaluaList() {
        return seaCriteriosEvaluaList;
    }

    public void setSeaCriteriosEvaluaList(List<SeaCriteriosEvalua> seaCriteriosEvaluaList) {
        this.seaCriteriosEvaluaList = seaCriteriosEvaluaList;
    }

    public SeaCriteriosEvaluaFacade getSeaCriteriosEvaluaFacade() {
        return seaCriteriosEvaluaFacade;
    }

    public void setSeaCriteriosEvaluaFacade(SeaCriteriosEvaluaFacade seaCriteriosEvaluaFacade) {
        this.seaCriteriosEvaluaFacade = seaCriteriosEvaluaFacade;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

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

    public SeaProcesoFacade getProcesoFacade() {
        return procesoFacade;
    }

    public void setProcesoFacade(SeaProcesoFacade procesoFacade) {
        this.procesoFacade = procesoFacade;
    }

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

    public String getConvocaF1() {
        return convocaF1;
    }

    public void setConvocaF1(String convocaF1) {
        this.convocaF1 = convocaF1;
    }

    public String getConvocaF2() {
        return convocaF2;
    }

    public void setConvocaF2(String convocaF2) {
        this.convocaF2 = convocaF2;
    }

    public List<SeaProceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<SeaProceso> procesoList) {
        this.procesoList = procesoList;
    }

    public SeaProceso getProcesoSelected() {
        return procesoSelected;
    }

    public void setProcesoSelected(SeaProceso procesoSelected) {
        this.procesoSelected = procesoSelected;
    }

    public String getNomProceso() {
        return nomProceso;
    }

    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    public SeaProcesoXConvocatoriaFacade getProConvaFacade() {
        return proConvaFacade;
    }

    public void setProConvaFacade(SeaProcesoXConvocatoriaFacade proConvaFacade) {
        this.proConvaFacade = proConvaFacade;
    }

    public List<SeaProcesoXConvocatoria> getProConvaList() {
        return proConvaList;
    }

    public void setProConvaList(List<SeaProcesoXConvocatoria> proConvaList) {
        this.proConvaList = proConvaList;
    }

    public SeaProcesoXConvocatoria getProConvaSelected() {
        return proConvaSelected;
    }

    public void setProConvaSelected(SeaProcesoXConvocatoria proConvaSelected) {
        this.proConvaSelected = proConvaSelected;
    }

    public SeaPorcenXCrConvocaFacade getSeaPorcEvaluaFacade() {
        return seaPorcEvaluaFacade;
    }

    public void setSeaPorcEvaluaFacade(SeaPorcenXCrConvocaFacade seaPorcEvaluaFacade) {
        this.seaPorcEvaluaFacade = seaPorcEvaluaFacade;
    }

    public List<SeaPorcenXCrConvoca> getSeaPorcEvaluaList() {
        return seaPorcEvaluaList;
    }

    public void setSeaPorcEvaluaList(List<SeaPorcenXCrConvoca> seaPorcEvaluaList) {
        this.seaPorcEvaluaList = seaPorcEvaluaList;
    }

    public SeaPorcenXCrConvoca getSeaPorcEvaluaSelected() {
        return seaPorcEvaluaSelected;
    }

    public void setSeaPorcEvaluaSelected(SeaPorcenXCrConvoca seaPorcEvaluaSelected) {
        this.seaPorcEvaluaSelected = seaPorcEvaluaSelected;
    }

    public String getPorcEvalua1() {
        return porcEvalua1;
    }

    public void setPorcEvalua1(String porcEvalua1) {
        this.porcEvalua1 = porcEvalua1;
    }

    public String getPorcEvalua2() {
        return porcEvalua2;
    }

    public void setPorcEvalua2(String porcEvalua2) {
        this.porcEvalua2 = porcEvalua2;
    }

    public String getCriterio1() {
        return criterio1;
    }

    public void setCriterio1(String criterio1) {
        this.criterio1 = criterio1;
    }

    public String getCriterio2() {
        return criterio2;
    }

    public void setCriterio2(String criterio2) {
        this.criterio2 = criterio2;
    }

    public SeaPorcenXCrConvoca getSeaPorcEvalua() {
        return seaPorcEvalua;
    }

    public void setSeaPorcEvalua(SeaPorcenXCrConvoca seaPorcEvalua) {
        this.seaPorcEvalua = seaPorcEvalua;
    }

    public SeaCriteriosEvalua getSeaCritertiosEvaluaSelected() {
        return seaCritertiosEvaluaSelected;
    }

    public void setSeaCritertiosEvaluaSelected(SeaCriteriosEvalua seaCritertiosEvaluaSelected) {
        this.seaCritertiosEvaluaSelected = seaCritertiosEvaluaSelected;
    }

    public boolean isValidaVaciosP41() {
        return validaVaciosP41;
    }

    public void setValidaVaciosP41(boolean validaVaciosP41) {
        this.validaVaciosP41 = validaVaciosP41;
    }

    public boolean isControlGrabarP41() {
        return controlGrabarP41;
    }

    public void setControlGrabarP41(boolean controlGrabarP41) {
        this.controlGrabarP41 = controlGrabarP41;
    }

    public boolean isValidaVaciosP42() {
        return validaVaciosP42;
    }

    public void setValidaVaciosP42(boolean validaVaciosP42) {
        this.validaVaciosP42 = validaVaciosP42;
    }

    public boolean isControlGrabarP42() {
        return controlGrabarP42;
    }

    public void setControlGrabarP42(boolean controlGrabarP42) {
        this.controlGrabarP42 = controlGrabarP42;
    }

    public List<SeaPorcenXCrConvoca> getSeaPorcEvaluaList2() {
        return seaPorcEvaluaList2;
    }

    public void setSeaPorcEvaluaList2(List<SeaPorcenXCrConvoca> seaPorcEvaluaList2) {
        this.seaPorcEvaluaList2 = seaPorcEvaluaList2;
    }

    public SeaPorcenXCrConvoca getSeaPorcEvaluaSelected2() {
        return seaPorcEvaluaSelected2;
    }

    public void setSeaPorcEvaluaSelected2(SeaPorcenXCrConvoca seaPorcEvaluaSelected2) {
        this.seaPorcEvaluaSelected2 = seaPorcEvaluaSelected2;
    }

    public SeaPorcenXCrConvoca getSeaPorcEvalua2() {
        return seaPorcEvalua2;
    }

    public void setSeaPorcEvalua2(SeaPorcenXCrConvoca seaPorcEvalua2) {
        this.seaPorcEvalua2 = seaPorcEvalua2;
    }

    public List<SeaConvoca> getSeaConvocaList() {
        return seaConvocaList;
    }

    public void setSeaConvocaList(List<SeaConvoca> seaConvocaList) {
        this.seaConvocaList = seaConvocaList;
    }

    public List<SeaProcesoXConvocatoria> getProcesoXConvaList() {
        return procesoXConvaList;
    }

    public void setProcesoXConvaList(List<SeaProcesoXConvocatoria> procesoXConvaList) {
        this.procesoXConvaList = procesoXConvaList;
    }

//</editor-fold>
    public List<SeaRecursosConvoca> getRecursoConvocaList() {
        return recursoConvocaList;
    }

    public void setRecursoConvocaList(List<SeaRecursosConvoca> recursoConvocaList) {
        this.recursoConvocaList = recursoConvocaList;
    }

}
