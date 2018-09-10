/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaEstudiantesFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaInformeDirectorFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaObjAcFormulario;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEFormulario;
import ec.edu.espe_ctt_investigacion.entity.SeaObjetivosFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.VEstudiantesB;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaEstudiantesFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaInformeDirectorFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjAcFormularioFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjEFormularioFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjetivosFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaOpcionInstitucionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaSeguimientoFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.ObjetivoProyectoFacade;
import ec.edu.espe_ctt_investigacion.session.VEstudiantesBFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class SeguimienTecnProyectoController implements Serializable{

    /**
     * Creates a new instance of SeguimienTecnProyectoController
     */
    public SeguimienTecnProyectoController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private SegUsuario estudianteUsuario;
    private String idEstudiante;
    private String cedula;
    private SegUsuario usuarioEstud;
    
    /// Opcion Institución
    @EJB
    private SeaOpcionInstitucionFacade opcionInstitucionFacade;
    private SeaOpcionInstitucion opcionInstitucion;
    private List<SeaOpcionInstitucion> opcionInstitucionList;
    
    /// formato Largo
    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private SeaFormatoLargo formatoLargo;
    private SeaFormatoLargo formatoLargoSelected;
    private List<SeaFormatoLargo> formatoLargoList;
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    
    /// Parametros Detalle
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    private SeaParametrosDet parametrosDet;
    private List<SeaParametrosDet> parametrosDetList;
    
    /// Vista Estudiantes
    @EJB
    private VEstudiantesBFacade estdudiantesBFacade;
    private VEstudiantesB estudiantesB;
    private List<VEstudiantesB> estudiantesBList;

    
    ///Estudiantes vinculados al Proyecto
    @EJB
    private SeaEstudiantesFormatoFacade estudiantesFormatoFacade;
    private SeaEstudiantesFormato estudiantesFormato;
    private SeaEstudiantesFormato estudianteFormatoSelected;
    private List<SeaEstudiantesFormato> estudianteFormatoList;
    private boolean validaVaciosP1 = true;
    private boolean controlGrabarP1 = false;
    private boolean controlGrabarP4 = false;
    private boolean validaVaciosP2 = true;
    private boolean controlGrabarP3 = false;
    private boolean validaVaciosP3 = true;
    private boolean validaVaciosP4 = true;
    private String nombrEstudiante ="";
    private String progPrePost ="";
    private String fechaInicio = "";
    private String fechaFin ="";
    private Date fDateIni = null;
    private Date fDateFin = null;
    private String generaTesis ="";
    private String tituloTesis ="";
    private boolean  controlGeneraTesis;
    
    /// informe del director del departamento/centro
    @EJB
    private SeaInformeDirectorFormatoFacade informeDirectorFormatoFacade;
    private SeaInformeDirectorFormato informeDirectorFormato;
    private SeaInformeDirectorFormato informeDirectorFormatoSelected;
    private List<SeaInformeDirectorFormato> informeDirectorFormatoList;
    private List<SeaInformeDirectorFormato> informeFormatoList;
    private boolean controlGrabarP6 = false;
    private boolean validaVaciosP6 = true;
    private boolean controlGrabarP7 = false;
    private boolean validaVaciosP7 = true;
    private String ejecucion ="";
    private String ejecucionEdit ;
    private String porcEjePrgd ="";
    private String porcEjeReald ="";
    private String analisis ="";
    private String observacion ="";
    
    /// Objetivo del Formato
    @EJB
    private SeaObjetivosFormatoFacade objetivoFormatoFacade;
    private SeaObjetivosFormato objetivoFormato;
    private List<SeaObjetivosFormato> objFormatoList;
    private SeaObjetivosFormato objetivosFormato;
    private BigDecimal ibObjetivoFormato;
    private BigDecimal idFormatoL;
    
    ///Objetivos Especificos Formulario     
    @EJB
    private SeaObjEFormularioFacade objEFormularioFacade;
    private SeaObjEFormulario objEFormulario;
    private List<SeaObjEFormulario> objEFormularioList;
    
    /// Actividades Formulario
    @EJB
    private SeaObjAcFormularioFacade objAcFormularioFacade;
    private SeaObjAcFormulario objAcFormulario;
    private List<SeaObjAcFormulario> objAcFormularioList;
    
    /// Datos Generales Proyecto
    @EJB
    private SeaDatGeneralProyFacade datGeneralProyFacade;
    private SeaDatGeneralProy datGeneralProy;
    private List<SeaDatGeneralProy> datGeneralProyList;
    private String codProyecto ="";
    private String finanDevengado ="";
    
    /// Responsable Programa
    @EJB
    private SeaResponsableProgFacade responsableProgFacade;
    private SeaResponsableProg responsableProg;
    private List<SeaResponsableProg> responsableProgList;
    
    /// Departamento / Centro
    @EJB
    private SeaDepcenproyFacade depCenProyFacade;
    private SeaDepcenproy depCenProy;
    private List<SeaDepcenproy> depCenProyList;  
    private SeaDepcenproy depCentroProyecto;
    private String fPerInicio ="";
    private String fPerFin ="";
    private Date fechPerIni = null;
    private Date fechPerFin = null;
    private String lineaPadreInvest;
    
    /// Líneas de Investigación
    @EJB
    private SeaLineainvesFacade lineaInvesFacade;
    private SeaLineainves lineaInvest;
    private String lineaInvestigacion="";
    
    ///Seguimiento Formato
    @EJB
    private SeaSeguimientoFormatoFacade seguimtoFormatFacade;
    private SeaSeguimientoFormato seguimientoFormato;
    private SeaSeguimientoFormato seguimientoFormatoSelected;
    private String informeNum ="";
    private String justificacion="";
    
    ///Presupuesto por Partida
    @EJB
    private PresupuestoPartidaFacade presupXPartidaFacade;
    private PresupuestoPartida presupXPartida;
    private List<PresupuestoPartida> presupXPartidaList;
    private PresupuestoPartida presupXPartidaSelected;
    
    /// Objetivos Proyecto
    @EJB
    private ObjetivoProyectoFacade objProyectoFacade;
    private ObjetivoProyecto objProyecto;
    private List<ObjetivoProyecto> objGenProyectoList;
    
    //</editor-fold>
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
       usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso(){
        formatoLargoList = formatoLargoFacade.findFormatoLargoByCodUsu(usuario.getUsuId());
    }
    public String seleccioneFormato(){
        botonInicio = false;
        habilitaTab = false;
        cargaDatosFormato();
        return "";
    }
    public String inicioProgramas(){
        return "";
    }
    public void cargaDatosFormato(){
        /// tabP1
        if(formatoLargoSelected != null){
            datGeneralProyList = datGeneralProyFacade.findDatosProyectoByCodProy(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
            responsableProgList = responsableProgFacade.findResponsableProyectoByCodProy(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
            depCenProyList = depCenProyFacade.findDepartCentProyByCodPro(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
            depCentroProyecto = depCenProyFacade.findDeptCentProy(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
            if(depCentroProyecto != null){
                lineaPadreInvest = depCentroProyecto.getLineaId().getLineaIdPadre().getLineaId().toString();
                lineaInvest = lineaInvesFacade.findLineaByCodLin(new BigDecimal(lineaPadreInvest));
                if(lineaInvest != null){
                    lineaInvestigacion = lineaInvest.getLineaDescip();
                }
            }
            seguimientoFormato = seguimtoFormatFacade.findSeguimientoByCodFormL(formatoLargoSelected.getSflId());
            if(seguimientoFormato != null){
                codProyecto = seguimientoFormato.getSsefCodigoProy();
                informeNum = seguimientoFormato.getSsefInforme();
                finanDevengado = seguimientoFormato.getSsfeFinanDevengado().toString();
                fechPerIni= seguimientoFormato.getSsfeFechaDesde();
                fechPerFin= seguimientoFormato.getSsfeFechaHasta();
                justificacion= seguimientoFormato.getSsefAnalisis();
            }
        }
        
        /// tabP2
        if(formatoLargoSelected != null){
            opcionInstitucionList = opcionInstitucionFacade.findOpcionInstitucionByCodPro(formatoLargoSelected.getDatgeproyId().getDatgeproyId());
        }
        /// tabP3
        if(formatoLargoSelected != null){
            estudianteFormatoList = estudiantesFormatoFacade.findAll();
            estudiantesBList = estdudiantesBFacade.findAll();
        }
        /// tabP4
        if(formatoLargoSelected != null){
            objGenProyectoList = objProyectoFacade.findTipObjProyCodFormL(formatoLargoSelected.getSflId());
        }
        /// tabP5
        presupXPartidaList = presupXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(formatoLargoSelected.getSflId());
        
        /// tabP6
        if(formatoLargoSelected != null){
            System.out.println("seguimiento " + seguimientoFormatoSelected);
            parametrosDetList = parametrosDetFacade.findParamDetEjecucion();
            if(seguimientoFormato != null){
                informeDirectorFormatoList = informeDirectorFormatoFacade.findInformeDirectorByCodSeg(seguimientoFormato.getSsefId());
            }
        }
    }
    /// funciones tabP1
    public void cancelarP1(){
        controlGrabarP1 = false;
//        codProyecto ="";
//        informeNum ="";
//        fPerInicio = "";
//        fPerFin ="";
//        finanDevengado="";
        validaVaciosP1 = true;
    }
    public  boolean  validarVaciosP1(){
        validaVaciosP1 = false;
        codProyecto = codProyecto.trim();
        informeNum = informeNum.trim();
        if(codProyecto.isEmpty()) validaVaciosP1 = true;
        if(informeNum.isEmpty()) validaVaciosP1 = true;
        if(fechPerIni != null ){
            fPerInicio = fechPerIni.toString();
            fPerInicio = fPerInicio.trim();
        }
        if(fPerInicio.isEmpty())validaVaciosP1 = true;
        if(fechPerFin != null){
            fPerFin = fechPerFin.toString();
            fPerFin = fPerFin.trim();
        }
        if(fPerFin.isEmpty()) validaVaciosP1 = true;
        finanDevengado = finanDevengado.trim();
        if(finanDevengado.isEmpty()) validaVaciosP1 = true;
        return validaVaciosP1;
        
    }

    public String registraP1(){
        if(formatoLargoSelected != null && seguimientoFormato == null){
            System.out.println("ingresa registro");
            seguimientoFormato = new SeaSeguimientoFormato();
            seguimientoFormato.setSflId(formatoLargoSelected);
            seguimientoFormato.setSsefCodigoProy(codProyecto);
            seguimientoFormato.setSsefInforme(informeNum);
            seguimientoFormato.setSsfeFechaDesde(fechPerIni);
            seguimientoFormato.setSsfeFechaHasta(fechPerFin);
            seguimientoFormato.setSsfeFinanDevengado(new BigDecimal(finanDevengado));
            seguimtoFormatFacade.create(seguimientoFormato);
            seguimientoFormatoSelected = seguimientoFormato;
        }else{
            seguimientoFormato.setSflId(formatoLargoSelected);
            seguimientoFormato.setSsefCodigoProy(codProyecto);
            seguimientoFormato.setSsefInforme(informeNum);
            seguimientoFormato.setSsfeFechaDesde(fechPerIni);
            seguimientoFormato.setSsfeFechaHasta(fechPerFin);
            seguimientoFormato.setSsfeFinanDevengado(new BigDecimal(finanDevengado));
            seguimtoFormatFacade.edit(seguimientoFormato);
        }
        cancelarP1();
        return "";
    }
    ///funciones tabP2
    public String registraP2(){
        return "";
    }
    
    /// funciones tabP3
    public String agregarP3(){
        controlGrabarP3 = true;
        return "";
    }
    public String registraP3(){
        for(int i=nombrEstudiante.length(); i>=0; i--){
            if(i>0 && nombrEstudiante.substring(i-1, i).equals(" ")){
                if(nombrEstudiante.substring(i-1, i).equals(" ")){
                    int ultima = i;
                    cedula = nombrEstudiante.substring(ultima, nombrEstudiante.length());
                    break;
                }
            }
        }
        estudianteUsuario = usuarioFacade.findEstudianteByCedula(cedula);
        if(estudianteUsuario != null){
            idEstudiante = estudianteUsuario.getUsuId().toString();
            usuarioEstud = usuarioFacade.findUsuarioByCodUsu(new BigDecimal (idEstudiante));
//            usuario = new SegUsuario();
//            usuario.setUsuId(new BigDecimal(idEstudiante));
//            System.out.println("usuario " + usuario );
            
        }
        if(formatoLargoSelected != null && estudiantesFormato == null){
            estudiantesFormato = new SeaEstudiantesFormato();
            System.out.println("ingresa registro");
            estudiantesFormato.setUsuId(usuarioEstud);
            estudiantesFormato.setSesfPrograma(progPrePost);
            estudiantesFormato.setSesfFechaInicio(fDateIni);
            estudiantesFormato.setSesfFechaFin(fDateFin);
            estudiantesFormato.setSesfGeneroTesis(generaTesis);
            estudiantesFormato.setSsefId(seguimientoFormato);
            estudiantesFormato.setSesfTesis(tituloTesis);
            estudiantesFormatoFacade.create(estudiantesFormato);
            estudianteFormatoList = estudiantesFormatoFacade.findAll();
        }
        cancelarP3();
        return "";
    }
    public void cancelarP3(){
        controlGrabarP3 = false;
        nombrEstudiante="";
        progPrePost ="";
        fechaInicio = "";
        fechaFin ="";
        generaTesis ="";
        validaVaciosP3 = true;
    }
    public boolean validarVaciosP3(){
        validaVaciosP3 = false;
        nombrEstudiante = nombrEstudiante.trim();
        progPrePost = progPrePost.trim();
        generaTesis = generaTesis.trim();
        tituloTesis = tituloTesis.trim();
        if(fDateIni != null){
            fechaInicio = fDateIni.toString();
            fechaInicio = fechaInicio.trim();
        }
        if(fDateFin != null){
            fechaFin = fDateFin.toString();
            fechaFin = fechaFin.trim();
        }
        if(nombrEstudiante.isEmpty()) validaVaciosP3 = true;
        if(progPrePost.isEmpty()) validaVaciosP3 = true;
        if(fechaInicio.isEmpty()) validaVaciosP3 = true;
        if(fechaFin.isEmpty()) validaVaciosP3 = true;
        if(generaTesis.isEmpty()) validaVaciosP3 = true;
        if(tituloTesis.isEmpty()) validaVaciosP3 = true;
        
        return validaVaciosP3;
    }
    public void eliminarP3(){
        if(estudianteFormatoSelected != null){
            SeaEstudiantesFormato eliminar = null;
            for (int i = 0; i < estudianteFormatoList.size(); i++){
                SeaEstudiantesFormato elemento = this.estudianteFormatoList.get(i);
                if(estudianteFormatoSelected.getSesfId() == estudianteFormatoList.get(i).getSesfId()){
                    eliminar = elemento;
                    break;
                }
            } 
            System.out.println("eliminar " + eliminar);
            if(eliminar != null){
                System.out.println("Ingreso a elimninar");
                this.estudianteFormatoList.remove(eliminar);
                estudiantesFormatoFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }
    public void onRowEditP3(RowEditEvent event){
        SeaEstudiantesFormato estudianteFormatroEdit = new SeaEstudiantesFormato();
        estudianteFormatroEdit = (SeaEstudiantesFormato) event.getObject();
        estudiantesFormatoFacade.edit(estudianteFormatroEdit);
        estudianteFormatoList = estudiantesFormatoFacade.findAll();
        
    }
    public void onRowCancelP3(RowEditEvent event){
    }
    public List<String> completeTextP3(String query){
        System.out.println(" el valor es tar " + query);
        estudiantesBList = estdudiantesBFacade.findEstudiantesByName(query);
        System.out.println(" la lista es " + estudiantesBList.size());
        List<String> results = new ArrayList<>();
        for(VEstudiantesB estudiantesBList1 : estudiantesBList){
            results.add(estudiantesBList1.getUsuApellidos()+ " " + estudiantesBList1.getUsuNombres()+"  "+ estudiantesBList1.getUsuCc());
        }
        return results;
    } 
    /// funciones tabP4
    public String registraP4(){
        if(formatoLargoSelected != null){
            System.out.println("Actualiza Análisis");
            seguimientoFormato.setSsefAnalisis(justificacion);
            seguimtoFormatFacade.edit(seguimientoFormato);
        }
        cancelarP4();
        return "";
    }
    public void cancelarP4(){
        controlGrabarP4 = false;
        seguimientoFormato = null;
        validaVaciosP4 = true;
    }
    /*
    public void cancelarP3(){
        controlGrabarP3 = false;
        nombrEstudiante="";
        progPrePost ="";
        fechaInicio = "";
        fechaFin ="";
        generaTesis ="";
        validaVaciosP3 = true;
    }
    */
    public void onRowEditResulP4(RowEditEvent event){
        ObjetivoProyecto actResulProyEdit = new ObjetivoProyecto();
        actResulProyEdit = (ObjetivoProyecto) event.getObject();
        objProyectoFacade.edit(actResulProyEdit);
    }
    public void  onRowCancelResulP4(RowEditEvent event){
    }
    public boolean  validarVaciosP4(){
        validaVaciosP4 = false;
        justificacion = justificacion.trim();
        if(justificacion.isEmpty()) validaVaciosP4 = true;
        return validaVaciosP4;
    }
    
    
    /// funciones tabP5
    public void eliminarP5(){
        if(presupXPartidaSelected != null){
            PresupuestoPartida eliminar = null;
            for (int i = 0; i < presupXPartidaList.size(); i++) {
                PresupuestoPartida elemento = this.presupXPartidaList.get(i);
                if(presupXPartidaSelected.getId() == presupXPartidaList.get(i).getId()){
                    eliminar = elemento;
                    break;
                }
            }
            if(eliminar != null){
                System.out.println("Ingreso a elimninar");
                this.presupXPartidaList.remove(eliminar);
                presupXPartidaFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }
    public void  onRowEditP5(RowEditEvent event){
        PresupuestoPartida presupXPartEdit = new PresupuestoPartida();
        presupXPartEdit = (PresupuestoPartida) event.getObject();
        presupXPartidaFacade.edit(presupXPartEdit);
    }
    public void onRowCancelP5(RowEditEvent event){
    }
    /// funciones tabP6
    public String agregarP6(){
        controlGrabarP6 = true;
        return "";
    }
    public String registraP6(){
        //Buscamos si Tipo de Ejecucion ya esta registrada
        SeaParametrosDet paramDet = new SeaParametrosDet();
        paramDet.setPrdId(new Long(ejecucion));
        informeFormatoList = informeDirectorFormatoFacade.findTipoEjByCodTipoCodSeg(new BigDecimal(paramDet.getPrdId()) ,seguimientoFormato.getSsefId());
        if(informeFormatoList == null){
            System.out.println("Ingresa registro");
            informeDirectorFormato = new SeaInformeDirectorFormato();
            parametrosDet = new SeaParametrosDet();
            parametrosDet.setPrdId(new Long(ejecucion));
            informeDirectorFormato.setPrdId(parametrosDet);
            informeDirectorFormato.setSidfPorcentajeProgram(new BigDecimal(porcEjePrgd));
            informeDirectorFormato.setSidfPorcetajeRealizada(new BigDecimal(porcEjeReald));
            informeDirectorFormato.setSidfObservacion(observacion);
            informeDirectorFormato.setUsuId(usuario);
            informeDirectorFormato.setSsefId(seguimientoFormato);
            informeDirectorFormato.setSidfAnalisis(analisis);
            informeDirectorFormatoFacade.create(informeDirectorFormato);
            informeDirectorFormatoList = informeDirectorFormatoFacade.findInformeDirectorByCodSeg(seguimientoFormato.getSsefId());
            /// Actualiza Estado del Seguimiento
            seguimientoFormato.setSsfeEstado("T");
            seguimtoFormatFacade.edit(seguimientoFormato);
            
        } else {
            RequestContext.getCurrentInstance().execute("alert('Tipo de Ejecución ya esta registrado')");
            cancelarP6();
            return "";
            
        }
        cancelarP6();
        return "";
    }
    public void cancelarP6(){
        controlGrabarP6 = false;
        ejecucion ="";
        porcEjePrgd ="";
        porcEjeReald ="";
        observacion ="";
        analisis="";
        validaVaciosP6 = true;
    }
    public boolean  validarVaciosP6(){
        validaVaciosP6 = false;
        ejecucion = ejecucion.trim();
        porcEjePrgd = porcEjePrgd.trim();
        porcEjeReald = porcEjeReald.trim();
        observacion = observacion.trim();
        analisis = analisis.trim();
        if(ejecucion.isEmpty()) validaVaciosP6 = true;
        if(porcEjePrgd.isEmpty()) validaVaciosP6 = true;
        if(porcEjeReald.isEmpty()) validaVaciosP6 = true;
        if(observacion.isEmpty()) validaVaciosP6 = true;
        if(analisis.isEmpty()) validaVaciosP6 = true;
        return validaVaciosP6;
    }
    public void  eliminarP6(){
        informeDirectorFormatoFacade.remove(informeDirectorFormatoSelected);
        informeDirectorFormatoList = informeDirectorFormatoFacade.findInformeDirectorByCodSeg(seguimientoFormato.getSsefId());
    }
    public void  onRowEditP6(RowEditEvent event){
        SeaInformeDirectorFormato informDirectorFormatoEdit = new SeaInformeDirectorFormato();
        informDirectorFormatoEdit = (SeaInformeDirectorFormato) event.getObject();
        parametrosDet = new SeaParametrosDet();
        parametrosDet.setPrdId(new Long(ejecucionEdit));
        
        informDirectorFormatoEdit.setPrdId(parametrosDet);
        informeDirectorFormatoFacade.edit(informDirectorFormatoEdit);
    }
    public void onRowCancelP6(RowEditEvent event){
    }
    /*
    /// funciones tabP7
    public void cancelarP7(){
        controlGrabarP7 = false;
        //analisis ="";
        validaVaciosP7 = true;
    }
    
    public String registraP7(){
        if(formatoLargoSelected != null && seguimientoFormato != null){
            System.out.println("seguimientoFormato" + seguimientoFormato);
            System.out.println("analisis " + analisis);
            System.out.println("actualiza registro");
            //seguimientoFormato = seguimientoFormatoSelected;
            seguimientoFormato.setSsefAnalisis(analisis);
            seguimtoFormatFacade.edit(seguimientoFormato);
        }
        cancelarP7();
        return "";
    }
    public boolean  validarVaciosP7(){
        validaVaciosP7 = false;
        analisis = analisis.trim();
        if(analisis.isEmpty()) validaVaciosP7 = true;
        return validaVaciosP7;
    }
    */
    

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    
    public SegUsuario getEstudianteUsuario() {
        return estudianteUsuario;
    }

    public void setEstudianteUsuario(SegUsuario estudianteUsuario) {
        this.estudianteUsuario = estudianteUsuario;
    }

    public SeaFormatoLargo getFormatoLargoSelected() {
        return formatoLargoSelected;
    }

    public void setFormatoLargoSelected(SeaFormatoLargo formatoLargoSelected) {
        this.formatoLargoSelected = formatoLargoSelected;
    }

    public List<SeaFormatoLargo> getFormatoLargoList() {
        return formatoLargoList;
    }

    public void setFormatoLargoList(List<SeaFormatoLargo> formatoLargoList) {
        this.formatoLargoList = formatoLargoList;
    }
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

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
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

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public List<SeaResponsableProg> getResponsableProgList() {
        return responsableProgList;
    }

    public void setResponsableProgList(List<SeaResponsableProg> responsableProgList) {
        this.responsableProgList = responsableProgList;
    }

    public List<SeaDepcenproy> getDepCenProyList() {
        return depCenProyList;
    }

    public void setDepCenProyList(List<SeaDepcenproy> depCenProyList) {
        this.depCenProyList = depCenProyList;
    }

    public String getfPerInicio() {
        return fPerInicio;
    }

    public void setfPerInicio(String fPerInicio) {
        this.fPerInicio = fPerInicio;
    }

    public String getfPerFin() {
        return fPerFin;
    }

    public void setfPerFin(String fPerFin) {
        this.fPerFin = fPerFin;
    }

    public Date getFechPerIni() {
        return fechPerIni;
    }

    public void setFechPerIni(Date fechPerIni) {
        this.fechPerIni = fechPerIni;
    }

    public Date getFechPerFin() {
        return fechPerFin;
    }

    public void setFechPerFin(Date fechPerFin) {
        this.fechPerFin = fechPerFin;
    }

    public String getFinanDevengado() {
        return finanDevengado;
    }

    public void setFinanDevengado(String finanDevengado) {
        this.finanDevengado = finanDevengado;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public String getInformeNum() {
        return informeNum;
    }

    public void setInformeNum(String informeNum) {
        this.informeNum = informeNum;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    

    /// get and set tabP2
    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    public List<SeaOpcionInstitucion> getOpcionInstitucionList() {
        return opcionInstitucionList;
    }

    public void setOpcionInstitucionList(List<SeaOpcionInstitucion> opcionInstitucionList) {
        this.opcionInstitucionList = opcionInstitucionList;
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
    public String getNombrEstudiante() {
        return nombrEstudiante;
    }

    public void setNombrEstudiante(String nombrEstudiante) {
        this.nombrEstudiante = nombrEstudiante;
    }
    public SeaEstudiantesFormato getEstudianteFormatoSelected() {
        return estudianteFormatoSelected;
    }

    public void setEstudianteFormatoSelected(SeaEstudiantesFormato estudianteFormatoSelected) {
        this.estudianteFormatoSelected = estudianteFormatoSelected;
    }

    public List<SeaEstudiantesFormato> getEstudianteFormatoList() {
        return estudianteFormatoList;
    }

    public void setEstudianteFormatoList(List<SeaEstudiantesFormato> estudianteFormatoList) {
        this.estudianteFormatoList = estudianteFormatoList;
    }
    public String getProgPrePost() {
        return progPrePost;
    }

    public void setProgPrePost(String progPrePost) {
        this.progPrePost = progPrePost;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Date getfDateIni() {
        return fDateIni;
    }

    public void setfDateIni(Date fDateIni) {
        this.fDateIni = fDateIni;
    }

    public Date getfDateFin() {
        return fDateFin;
    }

    public void setfDateFin(Date fDateFin) {
        this.fDateFin = fDateFin;
    }
    public String getGeneraTesis() {
        if(generaTesis != null){
            if(generaTesis.equals("S")){
                controlGeneraTesis = true;
            } else {
                controlGeneraTesis = false;
            }
        } else {
            controlGeneraTesis = false;
        }
        return generaTesis;
    }
    public void setGeneraTesis(String generaTesis) {
        this.generaTesis = generaTesis;
    }

    public String getTituloTesis() {
        return tituloTesis;
    }

    public void setTituloTesis(String tituloTesis) {
        this.tituloTesis = tituloTesis;
    }

    public boolean isControlGeneraTesis() {
        return controlGeneraTesis;
    }

    public void setControlGeneraTesis(boolean controlGeneraTesis) {
        this.controlGeneraTesis = controlGeneraTesis;
    }
    

    /// get and set tabP4
    public boolean isValidaVaciosP4() {
        return validaVaciosP4;
    }

    public void setValidaVaciosP4(boolean validaVaciosP4) {
        this.validaVaciosP4 = validaVaciosP4;
    }

    public List<SeaObjetivosFormato> getObjFormatoList() {
        return objFormatoList;
    }

    public void setObjFormatoList(List<SeaObjetivosFormato> objFormatoList) {
        this.objFormatoList = objFormatoList;
    }

    public BigDecimal getIbObjetivoFormato() {
        return ibObjetivoFormato;
    }

    public void setIbObjetivoFormato(BigDecimal ibObjetivoFormato) {
        this.ibObjetivoFormato = ibObjetivoFormato;
    }

    public List<SeaObjEFormulario> getObjEFormularioList() {
        return objEFormularioList;
    }

    public void setObjEFormularioList(List<SeaObjEFormulario> objEFormularioList) {
        this.objEFormularioList = objEFormularioList;
    }

    public List<SeaObjAcFormulario> getObjAcFormularioList() {
        return objAcFormularioList;
    }

    public void setObjAcFormularioList(List<SeaObjAcFormulario> objAcFormularioList) {
        this.objAcFormularioList = objAcFormularioList;
    }

    public boolean isControlGrabarP4() {
        return controlGrabarP4;
    }

    public void setControlGrabarP4(boolean controlGrabarP4) {
        this.controlGrabarP4 = controlGrabarP4;
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
     public List<SeaParametrosDet> getParametrosDetList() {
        return parametrosDetList;
    }

    public void setParametrosDetList(List<SeaParametrosDet> parametrosDetList) {
        this.parametrosDetList = parametrosDetList;
    }
    public String getEjecucionEdit() {
        return ejecucionEdit;
    }

    public void setEjecucionEdit(String ejecucionEdit) {
        this.ejecucionEdit = ejecucionEdit;
    }
    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getPorcEjePrgd() {
        return porcEjePrgd;
    }

    public void setPorcEjePrgd(String porcEjePrgd) {
        this.porcEjePrgd = porcEjePrgd;
    }

    public String getPorcEjeReald() {
        return porcEjeReald;
    }

    public void setPorcEjeReald(String porcEjeReald) {
        this.porcEjeReald = porcEjeReald;
    }
     public SeaInformeDirectorFormato getInformeDirectorFormatoSelected() {
        return informeDirectorFormatoSelected;
    }

    public void setInformeDirectorFormatoSelected(SeaInformeDirectorFormato informeDirectorFormatoSelected) {
        this.informeDirectorFormatoSelected = informeDirectorFormatoSelected;
    }

    public List<SeaInformeDirectorFormato> getInformeDirectorFormatoList() {
        return informeDirectorFormatoList;
    }

    public void setInformeDirectorFormatoList(List<SeaInformeDirectorFormato> informeDirectorFormatoList) {
        this.informeDirectorFormatoList = informeDirectorFormatoList;
    }
     public List<VEstudiantesB> getEstudiantesBList() {
        return estudiantesBList;
    }

    public void setEstudiantesBList(List<VEstudiantesB> estudiantesBList) {
        this.estudiantesBList = estudiantesBList;
    }
    /// get and set tabP7
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
     public List<PresupuestoPartida> getPresupXPartidaList() {
        return presupXPartidaList;
    }

    public void setPresupXPartidaList(List<PresupuestoPartida> presupXPartidaList) {
        this.presupXPartidaList = presupXPartidaList;
    }
    public PresupuestoPartida getPresupXPartidaSelected() {
        return presupXPartidaSelected;
    }

    public void setPresupXPartidaSelected(PresupuestoPartida presupXPartidaSelected) {
        this.presupXPartidaSelected = presupXPartidaSelected;
    }

    public List<ObjetivoProyecto> getObjGenProyectoList() {
        return objGenProyectoList;
    }

    public void setObjGenProyectoList(List<ObjetivoProyecto> objGenProyectoList) {
        this.objGenProyectoList = objGenProyectoList;
    }
    

    //</editor-fold>
}
