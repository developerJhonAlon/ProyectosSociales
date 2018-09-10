/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaEstudiantesFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaInformeDirectorFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaEstudiantesFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaInformeDirectorFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaOpcionInstitucionFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaSeguimientoFormatoFacade;
import ec.edu.espe_ctt_investigacion.session.ObjetivoProyectoFacade;
import ec.edu.espe_ctt_investigacion.session.VDirectoresDeptoFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class RevisionSeguimientoController implements Serializable{

    /**
     * Creates a new instance of RevisionSeguimientoController
     */
    public RevisionSeguimientoController() {
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
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    private BigDecimal idFormatoL;
    
    /// Vista Director por Departamento
    @EJB
    private VDirectoresDeptoFacade directorDeptoFacade;
    private VDirectoresDepto directorDepto;
    private List<VDirectoresDepto> directorDeptoList;
    private String codDepto;
    
    ///Departamento Centro Proyecto
    @EJB
    private SeaDepcenproyFacade departCenProyFacade;
    private SeaDepcenproy departCenProy;
    private List<SeaDepcenproy> departCenProyList;
    private BigDecimal idDepcenProy;
    
    ///Seguimiento Formato
    private SeaSeguimientoFormato seguimientoFormato;
    private SeaSeguimientoFormato seguimientoFormatoSelected;
    private List<SeaSeguimientoFormato> seguimientoFormatoList;
    
    ////Opción Institución
    @EJB
    private SeaOpcionInstitucionFacade opcionInstitucionFacade;
    private SeaOpcionInstitucion opcionInstitucion;
    private List<SeaOpcionInstitucion> opcionInstList;
    
    /// Estudiante Formato
    @EJB
    private SeaEstudiantesFormatoFacade estudFormatoFacade;
    private SeaEstudiantesFormato estudianteFormato;
    private List<SeaEstudiantesFormato> estudianteFormatoList;
    
    ///Objetivos Proyecto
    @EJB
    private ObjetivoProyectoFacade objetProyectoFacade;
    private ObjetivoProyecto objetProyecto;
    private List<ObjetivoProyecto> objetGenProyList;
    private String justifProy="";
    
     ///Presupuesto por Partida
    @EJB
    private PresupuestoPartidaFacade presXPartidaFacade;
    private PresupuestoPartida presXPartida;
    private List<PresupuestoPartida> presXPartidaList;
    
    ///Informe del Director
    @EJB
    private SeaInformeDirectorFormatoFacade informeDirectFacade;
    private SeaInformeDirectorFormato informeDirectFormato;
    private List<SeaInformeDirectorFormato> informeDirectFormatoList;
    private boolean validaVaciosP6 = true;
    private String revisado="";
    private boolean  revisa;
    
    
    ///Responsable del Proyecto
    @EJB
    private SeaResponsableProgFacade responsableProgFacade;
    private SeaResponsableProg responsableProg;
    private List<SeaResponsableProg> responsableProgList;
    private boolean controlGrabarP6 = false;
    
    /// Seguimiento Formato
    @EJB
    private SeaSeguimientoFormatoFacade seguimientFormatoFacade;
    
    //</editor-fold>
    @PostConstruct
     public void init(){
         FacesContext context = FacesContext.getCurrentInstance();
         usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
         checkIngreso();
     }
     //<editor-fold defaultstate="collapsed" desc="Funciones">
    void checkIngreso() {

        directorDepto = directorDeptoFacade.findByUsuario(usuario.getUsuId());
        if (directorDepto != null) {
            codDepto = directorDepto.getStvsubjCode();
        }
        seguimientoFormatoList = departCenProyFacade.findSeguimientoDepartamentoByCodDep(codDepto);
       /* seguimientoFormato = seguimientFormatoFacade.findSeguimientoFormatoByCodSeg(seguimientoFormatoSelected.getSsefId());
        if(seguimientoFormato != null){
            revisado = seguimientoFormato.getSsfeRevisado();
            if(revisado.equals("S")){
                revisado = "REVISADO";
            } else {
                revisado ="";
            }
        }*/
        departCenProyList = departCenProyFacade.findDepartamentoByCodDep(codDepto);

    }
    public String seleccioneSeguimiento() {
        seguimientoFormato = seguimientFormatoFacade.findSeguimientoFormatoByCodSeg(seguimientoFormatoSelected.getSsefId());
        if (seguimientoFormato != null) {
            revisado = seguimientoFormato.getSsfeRevisado();
            if (revisado == null) {
                botonInicio = false;
                habilitaTab = false;
                cargaDatosSeguimiento();
            } else {
                if (revisado.equals("S")) {
                    RequestContext.getCurrentInstance().execute("alert('El Seguimiento ya fue Revisado')");
                    return "";
                }
            }
        }
        return "";
    }
     public String inicioProgramas(){
        return "";
    }
    public void cargaDatosSeguimiento() {
        ///tabP1
        if (seguimientoFormatoSelected != null) { 
            directorDeptoList = directorDeptoFacade.findDirectorDepartoByCodUsu(usuario.getUsuId());
            responsableProgList = responsableProgFacade.findResponsableProyectoByCodProy(seguimientoFormatoSelected.getSflId().getDatgeproyId().getDatgeproyId());
        }
        /// tabP2
        if (seguimientoFormatoSelected != null) {
            idFormatoL= seguimientoFormatoSelected.getSflId().getDatgeproyId().getDatgeproyId();
            opcionInstList = opcionInstitucionFacade.findOpcionInstitucionByCodPro(idFormatoL);
        }
        /// tabP3
        if(seguimientoFormatoSelected != null){
            estudianteFormatoList = estudFormatoFacade.findAll();
        }
        /// tabP4
        if(seguimientoFormatoSelected != null){
            objetGenProyList = objetProyectoFacade.findTipObjProyCodFormL(seguimientoFormatoSelected.getSflId().getSflId());
        }
        /// tabP5
        if(seguimientoFormatoSelected != null){
            presXPartidaList = presXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(seguimientoFormatoSelected.getSflId().getSflId());
        }
        /// tabP6
        if(seguimientoFormatoSelected != null){
            informeDirectFormatoList = informeDirectFacade.findInformeDirectorByCodSeg(seguimientoFormatoSelected.getSsefId());
        }
    }
    /// funciones tabP6
    public String registraP6() {
        if (seguimientoFormatoSelected != null) {
            String marca = String.valueOf(revisado);
            if (marca.equals("true")) {
                marca = "S";
            }
            seguimientoFormato = seguimientoFormatoSelected;
            seguimientoFormato.setSsfeRevisado(marca);
            seguimientFormatoFacade.edit(seguimientoFormato);
        }
        cancelarP6();
        return "";
    }
    public boolean  validarVaciosP6(){
        validaVaciosP6 = false;
        revisado = revisado.trim();
        if(revisado.isEmpty()) validaVaciosP6 = true;
        return  validaVaciosP6;
    }
    public void cancelarP6(){
        controlGrabarP6 = false;
        seguimientoFormato = null;
        validaVaciosP6 = true;
    }
    /*
     public void cancelarP1(){
        controlGrabarP1 = false;
//        codProyecto ="";
//        informeNum ="";
//        fPerInicio = "";
//        fPerFin ="";
//        finanDevengado="";
        validaVaciosP1 = true;
    */
    
     //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
   
    public List<SeaDepcenproy> getDepartCenProyList() {
        return departCenProyList;
    }

    public void setDepartCenProyList(List<SeaDepcenproy> departCenProyList) {
        this.departCenProyList = departCenProyList;
    }

    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }
    public List<SeaSeguimientoFormato> getSeguimientoFormatoList() {
        return seguimientoFormatoList;
    }

    public void setSeguimientoFormatoList(List<SeaSeguimientoFormato> seguimientoFormatoList) {
        this.seguimientoFormatoList = seguimientoFormatoList;
    }
     public SeaSeguimientoFormato getSeguimientoFormatoSelected() {
        return seguimientoFormatoSelected;
    }

    public void setSeguimientoFormatoSelected(SeaSeguimientoFormato seguimientoFormatoSelected) {
        this.seguimientoFormatoSelected = seguimientoFormatoSelected;
    }
    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }
    public List<VDirectoresDepto> getDirectorDeptoList() {
        return directorDeptoList;
    }

    public void setDirectorDeptoList(List<VDirectoresDepto> directorDeptoList) {
        this.directorDeptoList = directorDeptoList;
    }
    /// get and set tabP2
    public List<SeaOpcionInstitucion> getOpcionInstList() {
        return opcionInstList;
    }

    public void setOpcionInstList(List<SeaOpcionInstitucion> opcionInstList) {
        this.opcionInstList = opcionInstList;
    }
    ///get and set  tabP3
    public List<SeaEstudiantesFormato> getEstudianteFormatoList() {
        return estudianteFormatoList;
    }

    public void setEstudianteFormatoList(List<SeaEstudiantesFormato> estudianteFormatoList) {
        this.estudianteFormatoList = estudianteFormatoList;
    }
    /// get and set tabP4

    public List<ObjetivoProyecto> getObjetGenProyList() {
        return objetGenProyList;
    }

    public void setObjetGenProyList(List<ObjetivoProyecto> objetGenProyList) {
        this.objetGenProyList = objetGenProyList;
    }
    
    public String getJustifProy() {
        return justifProy;
    }

    public void setJustifProy(String justifProy) {
        this.justifProy = justifProy;
    }
    /// get and set tabP5
    public List<PresupuestoPartida> getPresXPartidaList() {
        return presXPartidaList;
    }

    public void setPresXPartidaList(List<PresupuestoPartida> presXPartidaList) {
        this.presXPartidaList = presXPartidaList;
    }
    //// get and set tabP6
    public List<SeaInformeDirectorFormato> getInformeDirectFormatoList() {
        return informeDirectFormatoList;
    }

    public void setInformeDirectFormatoList(List<SeaInformeDirectorFormato> informeDirectFormatoList) {
        this.informeDirectFormatoList = informeDirectFormatoList;
    }
    public boolean isValidaVaciosP6() {
        return validaVaciosP6;
    }

    public void setValidaVaciosP6(boolean validaVaciosP6) {
        this.validaVaciosP6 = validaVaciosP6;
    }
    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }
    public List<SeaResponsableProg> getResponsableProgList() {
        return responsableProgList;
    }

    public void setResponsableProgList(List<SeaResponsableProg> responsableProgList) {
        this.responsableProgList = responsableProgList;
    }
    public boolean isControlGrabarP6() {
        return controlGrabarP6;
    }

    public void setControlGrabarP6(boolean controlGrabarP6) {
        this.controlGrabarP6 = controlGrabarP6;
    }
    public boolean isRevisa() {
        return revisa;
    }

    public void setRevisa(boolean revisa) {
        this.revisa = revisa;
    }
    //</editor-fold>

    
}
