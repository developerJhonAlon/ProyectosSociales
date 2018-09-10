/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaEstudiantesFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEntregables;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import ec.edu.espe_ctt_investigacion.entity.Szdtabeneproy;
import ec.edu.espe_ctt_investigacion.entity.Szdtabienproy;
import ec.edu.espe_ctt_investigacion.entity.Szdtacantprod;
import ec.edu.espe_ctt_investigacion.entity.Szdtaevalest;
import ec.edu.espe_ctt_investigacion.entity.Szdtaliqproy;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.Szdtaproduproy;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaEstudiantesFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjEntregablesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaSeguimientoFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtabeneproyFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtabienproyFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtacantprodFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtaevalestFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtaliqproyFacade;
import ec.edu.espe_ctt_investigacion.session.ObjetivoProyectoFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtaproduproyFacade;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrador
 */
@Named(value = "cierreProyectosController")
@ViewScoped
public class CierreProyectosController  implements Serializable{

    /**
     * Creates a new instance of CierreProyectosController
     */
    public CierreProyectosController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario usuario;
    
    /// datos Generales
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    private boolean validaVaciosP1 = true;
    private boolean validaVaciosP11 = true;
    private boolean validaVaciosP2 = true;
    private boolean validaVaciosP21 = true;
    private boolean validaVaciosP3 = true;
    private boolean validaVaciosP5 = true;
    private boolean validaVaciosP8 = true;
    
    ///Seguimiento Tecnico
    @EJB
    private SeaSeguimientoFormatoFacade seguimientoFormatoFacade;
    private SeaSeguimientoFormato seguimientoFormato;
    private SeaSeguimientoFormato seguimFormatoSelected;
    private List<SeaSeguimientoFormato> seguimientFormatoList;
    
    ///Objetivos Proyecto
    @EJB
    private ObjetivoProyectoFacade szdtaobproyfacade;
    private ObjetivoProyecto szdtaObjProy;
    private List<ObjetivoProyecto> szdtaObjProyList;
    
    ///Entregables del Proyecto
    @EJB
    private SeaObjEntregablesFacade objEntregableFacade;
    private SeaObjEntregables objEntregables;
    private List<SeaObjEntregables> objEntregablesList;
    
    ///Bienes del Proyecto
    @EJB
    private SzdtabienproyFacade bienProyFacade;
    private Szdtabienproy bienProy;
    private Szdtabienproy bienProySelected;
    private List<Szdtabienproy> bienProyList;
    private String bienesUnivers ="";
    private boolean controlGrabarP11 = false;
    private Date fechaIngreso;
    private String logrosProy ="";
    private String apliResulProy ="";
    private String comentGeneral ="";
    private String documentSoport ="";
    private String beneficiarioPry ="";
    
    ///Liquidacion del Proyecto
    @EJB
    private SzdtaliqproyFacade liqProyFacade;
    private Szdtaliqproy liqProy;
    private List<Szdtaliqproy> liqProyList;
    private String comentarios ="";
    private String patrocinador ="";
    private Double costoEjecucion = new Double(0);
    private Double costoFinProyecto = new Double(0);
    private Double aporteFinPatrocinador = new Double(0);
    private boolean controlGrabarP1 = false;
    private boolean controlGrabarP2 = false;
    
    //// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGeneralProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    private List<SeaDatGeneralProy> datGeneralProyList;
    
    ///// Beneficiarios del proyecto
    @EJB
    private SzdtabeneproyFacade beneficiaProyFacade;
    private Szdtabeneproy beneficiaProy;
    private Szdtabeneproy beneficiaProySelected;
    private List<Szdtabeneproy> beneficiaProyList;
    private boolean controlGrabarP21 = false;
    private boolean controlGrabarP3 = false;
    
    /// Presupuesto X Partida
    @EJB
    private PresupuestoPartidaFacade presupXPartidaFacade;
    private PresupuestoPartida presupestoXPartida;
    private List<PresupuestoPartida> presupestoXPartidaList;
    
    ////Responsable del Proyecto
    @EJB
    private SeaResponsableProgFacade responsableProgFacade;
    private SeaResponsableProg responsableProg;
    private List<SeaResponsableProg> responsableProgList;
    private String concluyeFecha ="";
    private boolean controlConcluye;
    private String justificaNo="";
    private String nomFile1="";
    private UploadedFile file1;
    private byte[] file11 = null;
    private String nomFile2="";
    private UploadedFile file2;
    private byte[] file21 = null;
    private String utilizaPresup ="";
    private boolean controUtilizaPresp;
    private String justificaPrespUtilzd="";
    
    
    /// Estudiantes Formato
    @EJB
    private SeaEstudiantesFormatoFacade estudiantesFormatoFacade;
    private SeaEstudiantesFormato estudiantesFormato;
    private List<SeaEstudiantesFormato> estudiantesFormatoList;
    private String resultdAlc="";
    private String factorFacil ="";
    private String factorDific ="";
    private String coordinActiv ="";
    private boolean controlGrabarP6 = false;
    private boolean validaVaciosP6 = true;
    private String desempEstudiante ="";
    private String evaluaEstudiante ="";
    private String analisisEvaluaEst ="";
    private BigDecimal idEstFor;
    
    /// Parametros Detalle
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    private SeaParametrosDet parametrosDet;
    private List<SeaParametrosDet> parametrosDetList;
    private String conclusiones ="";
    
    /// Evaluación de Estudiantes
    @EJB
    private SzdtaevalestFacade evalEstudianteFacade;
    private Szdtaevalest evalEstudiante;
    private Szdtaevalest evalEstudianteSelected;
    private List<Szdtaevalest> evalEstudianteList;
    
    //// Formato Largo
    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private SeaFormatoLargo formatoLargo;
    
    /// Producción Proyectos
    @EJB
    private SzdtaproduproyFacade produProyFacade;
    private Szdtaproduproy produProy;
    private List<Szdtaproduproy> produProyList;
    
    /// Cantidad de Produccion
    @EJB
    private SzdtacantprodFacade cantProdFacade;
    private Szdtacantprod cantProd;
    private List<Szdtacantprod> cantProdList;
    
    //</editor-fold>
    @PostConstruct
    public void intit(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {  
        seguimientFormatoList = seguimientoFormatoFacade.findSeguimientoFormato();
    }
    public String seleccioneProyecto(){
        botonInicio = false;
        habilitaTab = false;
        cargaDatosProyecto();
        return "";
    }
    
    public String inicioProgramas(){
        return "";
    }
    public void cargaDatosProyecto(){
        /// tabP1
        if(seguimFormatoSelected != null){
            liqProy = liqProyFacade.findLiquidaByCodFormL(seguimFormatoSelected.getSflId().getSflId());
            if(liqProy != null){
                patrocinador = liqProy.getSzdtaliqproyNomausp();
                costoEjecucion = liqProy.getSzdtaliqproyToteje().doubleValue();
                comentarios = liqProy.getSzdtaliqproyComent();
                costoFinProyecto = liqProy.getSzdtaliqproyCostFproy().doubleValue();
                aporteFinPatrocinador = liqProy.getSzdtaliqproyAporFausp().doubleValue();
                logrosProy = liqProy.getSzdtaliqproyLogros();
                apliResulProy = liqProy.getSzdtaliqproyPosibAplic();
                comentGeneral = liqProy.getSzdtaliqproyComent();
                documentSoport = liqProy.getSzdtaliqproyDocuSoport();
                        
            }
            szdtaObjProyList = szdtaobproyfacade.findObjProyCodFormL(seguimFormatoSelected.getSflId().getSflId());
            objEntregablesList = objEntregableFacade.findEntregableByCodProy(seguimFormatoSelected.getSflId().getSflId());
            bienProyList = bienProyFacade.findBienesByCodFormL(seguimFormatoSelected.getSflId().getSflId());
            datGeneralProyList = datGeneralProyFacade.findDatosProyectoByCodProy(seguimFormatoSelected.getSflId().getDatgeproyId().getDatgeproyId());
            cantProdList = cantProdFacade.findCantidadProduccion();
        }
        //// tabP2
        if(seguimFormatoSelected != null){
            beneficiaProyList = beneficiaProyFacade.findBeneficiarioByCodFormL(seguimFormatoSelected.getSflId().getSflId());
            presupestoXPartidaList = presupXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(seguimFormatoSelected.getSflId().getSflId());
        }
        /// tabP3
        if(seguimFormatoSelected != null){
            responsableProgList = responsableProgFacade.findResponsableProyectoByCodProy(seguimFormatoSelected.getSflId().getDatgeproyId().getDatgeproyId());
        }
        
        /// tabP5
        if(seguimFormatoSelected != null){
            estudiantesFormatoList = estudiantesFormatoFacade.findEstudFormatoByCodSeg(seguimFormatoSelected.getSsefId());
        }
        //// tabP6
        if(seguimFormatoSelected != null){
            parametrosDetList = parametrosDetFacade.findParametroEvaluacion();
            evalEstudianteList = evalEstudianteFacade.findEvalEstByCodFormL(seguimFormatoSelected.getSflId().getSflId());
        }
        //// tabP7
        if(seguimFormatoSelected != null){
            produProyList = produProyFacade.findProducProyBydCodFormL(seguimFormatoSelected.getSflId().getSflId());
        }
        
    }
    /// funciones tabP1
    public String registraP1(){
        if(seguimFormatoSelected != null){
            fechaIngreso = new Date();
            Szdtaliqproy liqProy = new Szdtaliqproy();
            liqProy.setSzdtaliqproyNomausp(patrocinador);
            //liqProy.setSzdtaliqproyToteje(new BigDecimal(input5));
            liqProy.setSzdtaliqproyToteje(new BigDecimal(costoEjecucion));
            liqProy.setSzdtaliqproyComent(comentarios);
            liqProy.setSflId(seguimFormatoSelected.getSflId());
            liqProy.setSzdtaliqproyFechIng(fechaIngreso);
            liqProyFacade.create(liqProy);
            ///Insertar en la Cantidad de Produccion;
            for (int i = 0; i < cantProdList.size(); i++) {
                idEstFor = cantProdList.get(i).getSzdtacantprodCode();
                cantProd = new Szdtacantprod();
                cantProd.setSzdtacantprodCode(idEstFor);
                produProy = new Szdtaproduproy();
                produProy.setSzdtacantprodCode(cantProd);
                produProy.setSflId(seguimFormatoSelected.getSflId());
                produProyFacade.create(produProy);
            }
        }
        produProyList = produProyFacade.findProducProyBydCodFormL(seguimFormatoSelected.getSflId().getSflId());
        cancelarP1();
        return "";
    }
    public boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        patrocinador = patrocinador.trim();
        //costoEjecucion = costoEjecucion.trim();
       // if(costoEjecucion.isEmpty()) validaVaciosP1 = true;
        if(patrocinador.isEmpty()) validaVaciosP1 = true;
        return validaVaciosP1;
    }
    public void  cancelarP1(){
        controlGrabarP1 = false;
        validaVaciosP1 = true;
    }
    
    public boolean  validarVaciosP11(){
        validaVaciosP11 = false;
        bienesUnivers = bienesUnivers.trim();
        if(bienesUnivers.isEmpty()) validaVaciosP11 = true;
        return validaVaciosP11;
    }
    public String registraP11(){
        if(bienProy == null){
            fechaIngreso = new Date();
            bienProy = new Szdtabienproy();
            bienProy.setSzdtabienproyDesc(bienesUnivers);
            bienProy.setSflId(seguimFormatoSelected.getSflId());
            bienProy.setSzdtabienproyFechIngre(fechaIngreso);
            bienProyFacade.create(bienProy);
            bienProyList = bienProyFacade.findBienesByCodFormL(seguimFormatoSelected.getSflId().getSflId());
        }
        cancelarP11();
        return "";
    }
    
    public void eliminarBienes(){
        bienProyFacade.remove(bienProySelected);
        bienProyList = bienProyFacade.findBienesByCodFormL(seguimFormatoSelected.getSflId().getSflId());
    }
    public void cancelarP11(){
        controlGrabarP11 = false;
        bienesUnivers ="";
        bienProy = null;
        validaVaciosP11 = true;
    }
    
    /// funciones tabP2
    public String registraP2() {
        if (seguimFormatoSelected != null) {
            if (logrosProy.length() > 0) {
                logrosProy = logrosProy.replaceAll("\\r|\\n", "");
            }
            apliResulProy = apliResulProy.trim();
            if (apliResulProy.length() > 0) {
                apliResulProy = apliResulProy.replaceAll("\\r|\\n", "");
            }
            comentGeneral = comentGeneral.trim();
            if (comentGeneral.length() > 0) {
                comentGeneral = comentGeneral.replaceAll("\\r|\\n", "");
            }
            documentSoport = documentSoport.trim();
            if (documentSoport.length() > 0) {
                documentSoport = documentSoport.replaceAll("\\r|\\n", "");
            }
            liqProy.setSzdtaliqproyCostFproy(new BigDecimal(costoFinProyecto));
            liqProy.setSzdtaliqproyAporFausp(new BigDecimal(aporteFinPatrocinador));
            liqProy.setSzdtaliqproyLogros(logrosProy);
            liqProy.setSzdtaliqproyPosibAplic(apliResulProy);
            liqProy.setSzdtaliqproyComenGener(comentGeneral);
            liqProy.setSzdtaliqproyDocuSoport(documentSoport);
            liqProyFacade.edit(liqProy);
        }
        return "";
    }
    public boolean  validarVaciosP2(){
        validaVaciosP2 = false;
//        costoFinProyecto = costoFinProyecto.trim();
//        aporteFinPatrocinador = aporteFinPatrocinador.trim();
//        if(costoFinProyecto.isEmpty()) validaVaciosP2 = true;
//        if(aporteFinPatrocinador.isEmpty()) validaVaciosP2 = true;
        logrosProy = logrosProy.trim();
        if(logrosProy.length() > 0){
           logrosProy = logrosProy.replaceAll("\\r|\\n", "");
        }
        apliResulProy = apliResulProy.trim();
        if(apliResulProy.length() >0){
            apliResulProy = apliResulProy.replaceAll("\\r|\\n", "");
        }
        comentGeneral = comentGeneral.trim();
        if(comentGeneral.length() >0){
            comentGeneral = comentGeneral.replaceAll("\\r|\\n", "");
        }
        documentSoport = documentSoport.trim();
        if(documentSoport.length() >0){
            documentSoport = documentSoport.replaceAll("\\r|\\n", "");
        }
        
        return validaVaciosP2;
    }
    public void cancelarP2(){
        controlGrabarP2 = false;
        validaVaciosP2 = true;
    }
    public boolean  validarVaciosP21(){
        validaVaciosP21 = false;
        beneficiarioPry = beneficiarioPry.trim();
        if(beneficiarioPry.isEmpty()) validaVaciosP21 = true;
        return  validaVaciosP21;
    }
    public String registraP21(){
        if(seguimFormatoSelected != null && beneficiaProy == null){
            System.out.println("ingresa registro");
            fechaIngreso = new Date();
            beneficiaProy = new Szdtabeneproy();
            beneficiaProy.setSflId(seguimFormatoSelected.getSflId());
            beneficiaProy.setSzdtabeneproyNombres(beneficiarioPry);
            beneficiaProy.setSzdtabeneproyFechaCrea(fechaIngreso);
            beneficiaProyFacade.create(beneficiaProy);
        }
        beneficiaProyList = beneficiaProyFacade.findBeneficiarioByCodFormL(seguimFormatoSelected.getSflId().getSflId());
        cancelarP21();
        return "";
    }
    public void eliminarBeneficiario() {
        beneficiaProyFacade.remove(beneficiaProySelected);
        beneficiaProyList = beneficiaProyFacade.findBeneficiarioByCodFormL(seguimFormatoSelected.getSflId().getSflId());
    }
    public void  cancelarP21(){
        controlGrabarP21 = false;
        beneficiarioPry = "";
        beneficiaProy = null;
        validaVaciosP21 = true;
    }
    public void onRowEditP2(RowEditEvent event){
        PresupuestoPartida prespXPartEdit = new PresupuestoPartida();
        prespXPartEdit = (PresupuestoPartida) event.getObject();
        presupXPartidaFacade.edit(prespXPartEdit);
        presupestoXPartidaList = presupXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(seguimFormatoSelected.getSflId().getSflId());
    }
    public void onRowCancelP2(RowEditEvent event){
    }
    /// funciones tabP3
    public String registraP3(){
        if(seguimFormatoSelected != null){
            switch (concluyeFecha) {
                case "S":
                    liqProy.setSzdtaliqproyProyConcl(concluyeFecha.charAt(0));
                    liqProyFacade.edit(liqProy);
                    break;
                case "N":
                    liqProy.setSzdtaliqproyProyConcl(concluyeFecha.charAt(0));
                    liqProy.setSzdtaliqproyJustConcl(justificaNo);
                    liqProy.setSzdtaliqproyConclNom(nomFile1);
                    liqProy.setSzdtaliqproyConclDigi(file11);
                    liqProyFacade.edit(liqProy);
                    break;
            }
            switch (utilizaPresup){
                case "S":
                    liqProy.setSzdtaliqproyPrespUtil(utilizaPresup.charAt(0));
                    break;
                case "N":
                    liqProy.setSzdtaliqproyPrespUtil(utilizaPresup.charAt(0));
                    liqProy.setSzdtaliqproyJustPresup(justificaPrespUtilzd);
                    liqProy.setSzdtaliqproyPrespDocu(nomFile2);
                    liqProy.setSzdtaliqproyPrespDigi(file21);
                    break;
            }
        }
        cancelarP3();
        return "";
    }
    public void cancelarP3(){
        controlGrabarP3 = false;
        concluyeFecha = "";
        justificaNo ="";
        nomFile1 = "";
        utilizaPresup ="";
        justificaPrespUtilzd="";
        nomFile2="";
        validaVaciosP3 = true;
    }
    /*
    public void  cancelarP21(){
        controlGrabarP21 = false;
        beneficiarioPry = "";
        beneficiaProy = null;
        validaVaciosP21 = true;
    }
    */
    public boolean  validarVaciosP3(){
        validaVaciosP3 = false;
         if(concluyeFecha != null){
            if(concluyeFecha.equals("N")){
                controlConcluye = true;
            }else {
                controlConcluye = false;
            }
        }
         if(utilizaPresup != null){
             if(utilizaPresup.equals("N")){
                 controUtilizaPresp = true;
             }else{
                 controUtilizaPresp = false;
             }
         }
        concluyeFecha = concluyeFecha.trim();
        justificaNo = justificaNo.trim();
        utilizaPresup = utilizaPresup.trim();
        justificaPrespUtilzd = justificaPrespUtilzd.trim();
        if(concluyeFecha.isEmpty()) validaVaciosP3 = true;
        if(justificaNo.isEmpty()) validaVaciosP3 = true;
        if(utilizaPresup.isEmpty()) validaVaciosP3 = true;
        if(justificaPrespUtilzd.isEmpty()) validaVaciosP3 = true;
        
        return validaVaciosP3;
    }
    public void handleFileUploadP3(FileUploadEvent event) throws IOException{
        nomFile1 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile11(IOUtils.toByteArray(is));
        validarVaciosP3();
    }
    public void handleFileUploadP31 (FileUploadEvent event) throws IOException{
        nomFile2 = event.getFile().getFileName();
        InputStream is = null;
        is = event.getFile().getInputstream();
        this.setFile21(IOUtils.toByteArray(is));
        validarVaciosP3();
    }
    
    /// funciones tabP5
    public boolean  validarVaciosP5(){
        validaVaciosP5 = false;
        resultdAlc = resultdAlc.trim();
        if(resultdAlc.isEmpty()) validaVaciosP5 = true;
        
        return validaVaciosP5;
    }
    public String registraP5() {
        if (seguimFormatoSelected != null) {
            if (resultdAlc.length() > 0) {
                resultdAlc = resultdAlc.replaceAll("\\r|\\n", "");
                liqProy.setSzdtaliqproyReslAlc(resultdAlc);
                liqProyFacade.edit(liqProy);
            }
            if (factorFacil.length() > 0) {
                factorFacil = factorFacil.replaceAll("\\r|\\n", "");
                liqProy.setSzdtaliqproyFactFdes(factorFacil);
                liqProyFacade.edit(liqProy);
            }
            if (factorDific.length() > 0) {
                factorDific = factorDific.replaceAll("\\r|\\n", "");
                liqProy.setSzdtaliqproyFactDdes(factorDific);
                liqProyFacade.edit(liqProy);
            }
            if (coordinActiv.length() > 0) {
                coordinActiv = coordinActiv.replaceAll("\\r|\\n", "");
                liqProy.setSzdtaliqproyCoorAct(coordinActiv);
                liqProyFacade.edit(liqProy);
            }
        }
        return "";
    }
    /// funciones tabP6
    public String agregarP6(){
        controlGrabarP6 = true;
        return "";
    }
    public String registraP6(){
        if(seguimFormatoSelected != null){
            SeaParametrosDet parametrosDet = new SeaParametrosDet();
            parametrosDet.setPrdId(new Long(evaluaEstudiante));
            SeaEstudiantesFormato estudiantesFormato = new SeaEstudiantesFormato();
            estudiantesFormato.setSesfId(new BigDecimal(desempEstudiante));
            SeaFormatoLargo formatoLargo = new SeaFormatoLargo();
            formatoLargo.setSflId(seguimFormatoSelected.getSflId().getSflId());
            if(evalEstudiante == null){
                System.out.println("ingrese registro");
                evalEstudiante = new Szdtaevalest();
                evalEstudiante.setPrdId(parametrosDet);
                evalEstudiante.setSesfId(estudiantesFormato);
                evalEstudiante.setSzdtaevalestAnalpa(analisisEvaluaEst);
                evalEstudiante.setSflId(formatoLargo);
                evalEstudianteFacade.create(evalEstudiante);
            }
        }
        evalEstudianteList = evalEstudianteFacade.findEvalEstByCodFormL(seguimFormatoSelected.getSflId().getSflId());
        cancelarP6();
        return "";
    }
    public void cancelarP6(){
        controlGrabarP6 = false;
        desempEstudiante ="";
        evaluaEstudiante = "";
        analisisEvaluaEst ="";
        evalEstudiante = null;
        validaVaciosP6 = true;
    }
    public  boolean  validarVaciosP6(){
        validaVaciosP6 = false;
        desempEstudiante = desempEstudiante.trim();
        evaluaEstudiante = evaluaEstudiante.trim();
        analisisEvaluaEst = analisisEvaluaEst.trim();
        if(desempEstudiante.isEmpty()) validaVaciosP6 = true;
        if(evaluaEstudiante.isEmpty()) validaVaciosP6 = true;
        if(analisisEvaluaEst.isEmpty()) validaVaciosP6 = true;
        return validaVaciosP6;
    }
    public void  eliminarP6(){
        evalEstudianteFacade.remove(evalEstudianteSelected);
        evalEstudianteList = evalEstudianteFacade.findEvalEstByCodFormL(seguimFormatoSelected.getSflId().getSflId());
    }
    
    public void onRowCancelP6(RowEditEvent event){
    }
    /// funciones tabP7
    public void onRowCancelP7(RowEditEvent event){
    }
    public void  onRowEditP7(RowEditEvent event){
        Szdtaproduproy produProyEdit = new Szdtaproduproy();
        produProyEdit = (Szdtaproduproy) event.getObject();
        produProyFacade.edit(produProyEdit);
    }
    ///funciones tabP8
    public String registraP8() {
        if (seguimFormatoSelected != null) {
            if (conclusiones.length() > 0) {
                conclusiones = conclusiones.replaceAll("\\r|\\n", "");
                liqProy.setSzdtaliqproyConclusion(conclusiones);
                liqProyFacade.edit(liqProy);
            }
        }
        return "";
    }
    public boolean  validarVaciosP8(){
        validaVaciosP8 = false;
        conclusiones = "";
        return  validaVaciosP8;
    }
    /*
     public boolean  validarVaciosP5(){
        validaVaciosP5 = false;
        resultdAlc = resultdAlc.trim();
        if(resultdAlc.isEmpty()) validaVaciosP5 = true;
        
        return validaVaciosP5;
    }
    */
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }
    

    public List<SeaSeguimientoFormato> getSeguimientFormatoList() {
        return seguimientFormatoList;
    }

    public void setSeguimientFormatoList(List<SeaSeguimientoFormato> seguimientFormatoList) {
        this.seguimientFormatoList = seguimientFormatoList;
    }
   
    public SeaSeguimientoFormato getSeguimFormatoSelected() {
        return seguimFormatoSelected;
    }

    public void setSeguimFormatoSelected(SeaSeguimientoFormato seguimFormatoSelected) {
        this.seguimFormatoSelected = seguimFormatoSelected;
    }
    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }
    /// get and set tabP1

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }
    public List<ObjetivoProyecto> getSzdtaObjProyList() {
        return szdtaObjProyList;
    }

    public void setSzdtaObjProyList(List<ObjetivoProyecto> szdtaObjProyList) {
        this.szdtaObjProyList = szdtaObjProyList;
    }
    public List<SeaObjEntregables> getObjEntregablesList() {
        return objEntregablesList;
    }

    public void setObjEntregablesList(List<SeaObjEntregables> objEntregablesList) {
        this.objEntregablesList = objEntregablesList;
    }
    public String getBienesUnivers() {
        return bienesUnivers;
    }

    public void setBienesUnivers(String bienesUnivers) {
        this.bienesUnivers = bienesUnivers;
    }
    public boolean isValidaVaciosP11() {
        return validaVaciosP11;
    }

    public void setValidaVaciosP11(boolean validaVaciosP11) {
        this.validaVaciosP11 = validaVaciosP11;
    }
    public List<Szdtabienproy> getBienProyList() {
        return bienProyList;
    }

    public void setBienProyList(List<Szdtabienproy> bienProyList) {
        this.bienProyList = bienProyList;
    }
    public Szdtabienproy getBienProySelected() {
        return bienProySelected;
    }

    public void setBienProySelected(Szdtabienproy bienProySelected) {
        this.bienProySelected = bienProySelected;
    }
    public boolean isControlGrabarP11() {
        return controlGrabarP11;
    }

    public void setControlGrabarP11(boolean controlGrabarP11) {
        this.controlGrabarP11 = controlGrabarP11;
    }
    public List<Szdtaliqproy> getLiqProyList() {
        return liqProyList;
    }

    public void setLiqProyList(List<Szdtaliqproy> liqProyList) {
        this.liqProyList = liqProyList;
    }
     public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public boolean isControlGrabarP1() {
        return controlGrabarP1;
    }

    public void setControlGrabarP1(boolean controlGrabarP1) {
        this.controlGrabarP1 = controlGrabarP1;
    }
    public List<SeaDatGeneralProy> getDatGeneralProyList() {
        return datGeneralProyList;
    }

    public void setDatGeneralProyList(List<SeaDatGeneralProy> datGeneralProyList) {
        this.datGeneralProyList = datGeneralProyList;
    }
    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Double getCostoEjecucion() {
        return costoEjecucion;
    }

    public void setCostoEjecucion(Double costoEjecucion) {
        this.costoEjecucion = costoEjecucion;
    }
    ///get and set tabP2
    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public Double getCostoFinProyecto() {
        return costoFinProyecto;
    }

    public void setCostoFinProyecto(Double costoFinProyecto) {
        this.costoFinProyecto = costoFinProyecto;
    }

    public Double getAporteFinPatrocinador() {
        return aporteFinPatrocinador;
    }

    public void setAporteFinPatrocinador(Double aporteFinPatrocinador) {
        this.aporteFinPatrocinador = aporteFinPatrocinador;
    }
    
     public boolean isControlGrabarP2() {
        return controlGrabarP2;
    }

    public void setControlGrabarP2(boolean controlGrabarP2) {
        this.controlGrabarP2 = controlGrabarP2;
    }
    public String getLogrosProy() {
        return logrosProy;
    }

    public void setLogrosProy(String logrosProy) {
        this.logrosProy = logrosProy;
    }

    public String getApliResulProy() {
        return apliResulProy;
    }

    public void setApliResulProy(String apliResulProy) {
        this.apliResulProy = apliResulProy;
    }

    public String getComentGeneral() {
        return comentGeneral;
    }

    public void setComentGeneral(String comentGeneral) {
        this.comentGeneral = comentGeneral;
    }

    public String getDocumentSoport() {
        return documentSoport;
    }

    public void setDocumentSoport(String documentSoport) {
        this.documentSoport = documentSoport;
    }
    public String getBeneficiarioPry() {
        return beneficiarioPry;
    }

    public void setBeneficiarioPry(String beneficiarioPry) {
        this.beneficiarioPry = beneficiarioPry;
    }
    public boolean isValidaVaciosP21() {
        return validaVaciosP21;
    }

    public void setValidaVaciosP21(boolean validaVaciosP21) {
        this.validaVaciosP21 = validaVaciosP21;
    }
    
     public List<Szdtabeneproy> getBeneficiaProyList() {
        return beneficiaProyList;
    }

    public void setBeneficiaProyList(List<Szdtabeneproy> beneficiaProyList) {
        this.beneficiaProyList = beneficiaProyList;
    }
    public Szdtabeneproy getBeneficiaProySelected() {
        return beneficiaProySelected;
    }

    public void setBeneficiaProySelected(Szdtabeneproy beneficiaProySelected) {
        this.beneficiaProySelected = beneficiaProySelected;
    }
    public boolean isControlGrabarP21() {
        return controlGrabarP21;
    }

    public void setControlGrabarP21(boolean controlGrabarP21) {
        this.controlGrabarP21 = controlGrabarP21;
    }
    public List<PresupuestoPartida> getPresupestoXPartidaList() {
        return presupestoXPartidaList;
    }

    public void setPresupestoXPartidaList(List<PresupuestoPartida> presupestoXPartidaList) {
        this.presupestoXPartidaList = presupestoXPartidaList;
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
     public List<SeaResponsableProg> getResponsableProgList() {
        return responsableProgList;
    }

    public void setResponsableProgList(List<SeaResponsableProg> responsableProgList) {
        this.responsableProgList = responsableProgList;
    }
    public String getConcluyeFecha() {
        return concluyeFecha;
    }
    public void setConcluyeFecha(String concluyeFecha) {
        this.concluyeFecha = concluyeFecha;
    }
     public boolean isControlConcluye() {
        return controlConcluye;
    }

    public void setControlConcluye(boolean controlConcluye) {
        this.controlConcluye = controlConcluye;
    }
    public String getJustificaNo() {
        return justificaNo;
    }

    public void setJustificaNo(String justificaNo) {
        this.justificaNo = justificaNo;
    }
     public String getNomFile1() {
        return nomFile1;
    }

    public void setNomFile1(String nomFile1) {
        this.nomFile1 = nomFile1;
    }

    public UploadedFile getFile1() {
        return file1;
    }

    public void setFile1(UploadedFile file1) {
        this.file1 = file1;
    }

    public byte[] getFile11() {
        return file11;
    }

    public void setFile11(byte[] file11) {
        this.file11 = file11;
    }
     public String getUtilizaPresup() {
        return utilizaPresup;
    }

    public void setUtilizaPresup(String utilizaPresup) {
        this.utilizaPresup = utilizaPresup;
    }
    public boolean isControUtilizaPresp() {
        return controUtilizaPresp;
    }

    public void setControUtilizaPresp(boolean controUtilizaPresp) {
        this.controUtilizaPresp = controUtilizaPresp;
    }
    public String getJustificaPrespUtilzd() {
        return justificaPrespUtilzd;
    }

    public void setJustificaPrespUtilzd(String justificaPrespUtilzd) {
        this.justificaPrespUtilzd = justificaPrespUtilzd;
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

    public byte[] getFile21() {
        return file21;
    }

    public void setFile21(byte[] file21) {
        this.file21 = file21;
    }
    /// get and set tabP5
    public boolean isValidaVaciosP5() {
        return validaVaciosP5;
    }

    public void setValidaVaciosP5(boolean validaVaciosP5) {
        this.validaVaciosP5 = validaVaciosP5;
    }
    public String getResultdAlc() {
        return resultdAlc;
    }

    public void setResultdAlc(String resultdAlc) {
        this.resultdAlc = resultdAlc;
    }
    public String getFactorFacil() {
        return factorFacil;
    }

    public void setFactorFacil(String factorFacil) {
        this.factorFacil = factorFacil;
    }

    public String getFactorDific() {
        return factorDific;
    }

    public void setFactorDific(String factorDific) {
        this.factorDific = factorDific;
    }

    public String getCoordinActiv() {
        return coordinActiv;
    }

    public void setCoordinActiv(String coordinActiv) {
        this.coordinActiv = coordinActiv;
    }
    
    public List<SeaEstudiantesFormato> getEstudiantesFormatoList() {
        return estudiantesFormatoList;
    }

    public void setEstudiantesFormatoList(List<SeaEstudiantesFormato> estudiantesFormatoList) {
        this.estudiantesFormatoList = estudiantesFormatoList;
    }
    
    /// get and set tabP6
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
    public String getDesempEstudiante() {
        return desempEstudiante;
    }

    public void setDesempEstudiante(String desempEstudiante) {
        this.desempEstudiante = desempEstudiante;
    }
    public String getEvaluaEstudiante() {
        return evaluaEstudiante;
    }

    public void setEvaluaEstudiante(String evaluaEstudiante) {
        this.evaluaEstudiante = evaluaEstudiante;
    }
    public List<SeaParametrosDet> getParametrosDetList() {
        return parametrosDetList;
    }

    public void setParametrosDetList(List<SeaParametrosDet> parametrosDetList) {
        this.parametrosDetList = parametrosDetList;
    }

    public Szdtaevalest getEvalEstudianteSelected() {
        return evalEstudianteSelected;
    }

    public void setEvalEstudianteSelected(Szdtaevalest evalEstudianteSelected) {
        this.evalEstudianteSelected = evalEstudianteSelected;
    }

    public List<Szdtaevalest> getEvalEstudianteList() {
        return evalEstudianteList;
    }

    public void setEvalEstudianteList(List<Szdtaevalest> evalEstudianteList) {
        this.evalEstudianteList = evalEstudianteList;
    }
    public String getAnalisisEvaluaEst() {
        return analisisEvaluaEst;
    }

    public void setAnalisisEvaluaEst(String analisisEvaluaEst) {
        this.analisisEvaluaEst = analisisEvaluaEst;
    }
    /// get and set tabP7

    public List<Szdtaproduproy> getProduProyList() {
        return produProyList;
    }

    public void setProduProyList(List<Szdtaproduproy> produProyList) {
        this.produProyList = produProyList;
    }
    
    
    //// get and set tabP8
    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }
    public boolean isValidaVaciosP8() {
        return validaVaciosP8;
    }

    public void setValidaVaciosP8(boolean validaVaciosP8) {
        this.validaVaciosP8 = validaVaciosP8;
    }
    

    //</editor-fold>    

    

    

    
    
}
