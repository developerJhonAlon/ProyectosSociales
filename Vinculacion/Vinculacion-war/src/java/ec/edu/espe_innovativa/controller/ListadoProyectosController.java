/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

//<editor-fold defaultstate="collapsed" desc="Import">
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.CoordinadorVinculacion;
import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.session.CoordinadorVinculacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

//</editor-fold>
/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ListadoProyectosController implements Serializable {
//<editor-fold defaultstate="collapsed" desc="Constructor">

    public ListadoProyectosController() {

    }

    //</editor-fold>
    
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    @EJB
    private CoordinadorVinculacionFacade coordinadorVinculacionFacade;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;
    @EJB
    private ProyectoFacade proyectoFacade;

    private SegUsuario usuarioActual;
    private List<SeaParametrosDet> estadoList;
    private List<SegPerfil> perfilUsuarioActual;
    private CoordinadorVinculacion coordinadorVinculacion;

//<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
            coordinadorVinculacion = coordinadorVinculacionFacade.getCoordinacionVincluacionById(usuarioActual.getUsuId());
        }
        
        estadoList = parametrosDetFacade.findByCodigoParametroActivos(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
        listarProyectos();
    }

    /*private void agregarPrograma(Programa programa){
        for (Programa prog : programaList) {
            if (prog.equals(programa)){
                return;
            }
        }
        programaList.add(programa);
    }*/
    
    /*private void listarProgramas() {
        List<Programa> temp = programaFacade.findXEstado(null);
        programaList = new ArrayList<>();
        if (!verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_VICERRECTORADO)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
            for (Programa prog : temp) {
                
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                    if (prog.getCreador()!=null && prog.getCreador().getUsuario().equals(usuarioActual)) {
                        programaList.add(prog);
                        continue;
                    }
                } 
                boolean agregadoPrograma=false;
                for (Proyecto proy : prog.getProyectoActivoList()) {
                    if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROYECTO)) {
                        if (proy.getDirector().getUsuario().equals(usuarioActual)) {
                            programaList.add(prog);
                            agregadoPrograma=true;
                            break;
                        }
                    } 
                    if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)) {
                        if (proy.getComisionCalificacion() != null) {
                            for (MiembroComisionCalificacion m : proy.getComisionCalificacion().getMiembroList()) {
                                if (m.getEstado().equals(MiembroComisionCalificacion.ESTADO_ACTIVO) && m.getUsuario().equals(usuarioActual)) {
                                    programaList.add(prog);
                                    agregadoPrograma = true;
                                    break;
                                }
                            }
                        }
                        if (agregadoPrograma) {
                            break;
                        }
                    } 
                    if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                        if (proy.getEvaluadorFinal() != null) {
                            if (proy.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
                                programaList.add(prog);
                                agregadoPrograma = true;
                                break;
                            }
                        }
                    }
                }
                if (agregadoPrograma){
                    continue;
                }
            }
        } else {
            programaList = temp;
        }
    }
    */
    private List<Proyecto> proyectoList;

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    /*private void agregarProyecto(Proyecto proyecto){
        for (Proyecto proy : proyectoList) {
            if (proy.equals(proyecto)){
                return;
            }
        }
        proyectoList.add(proyecto);
    }
    */
    public void listarProyectos() {
        List<Proyecto> temp = proyectoFacade.findByProgramaEstado(null, null);
        proyectoList = new ArrayList<>();
        if (!verificarPerfil(SegPerfil.PERFIL_VINCULACION_REPORTES)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_IMPRESION_CERTIFICADOS)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_VICERRECTORADO)
                && !verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
            for (Proyecto proy : temp) {
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                    if (coordinadorVinculacion!=null && coordinadorVinculacion.getCampus()!=null && proy.getCampus()!=null && coordinadorVinculacion.getCampus().equals(proy.getCampus())){
                        if (coordinadorVinculacion.getDepartamento()!=null && proy.getDepartamento()!=null){
                            if (coordinadorVinculacion.getDepartamento().equals(proy.getDepartamento())){
                                if (coordinadorVinculacion.getCarrera()!=null && proy.getCarrera()!=null){
                                    if (coordinadorVinculacion.getCarrera().equals(proy.getCarrera())){
                                        proyectoList.add(proy);
                                        continue;
                                    }
                                }
                                else{
                                    proyectoList.add(proy);
                                    continue;
                                }
                            }
                        }
                        else{
                            proyectoList.add(proy);
                            continue;
                        }
                    }
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROYECTO)) {
                    if (proy.getDirector().getUsuario().equals(usuarioActual)) {
                        proyectoList.add(proy);
                        continue;
                    }
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                    if (proy.getEvaluadorFinal() != null) {
                        if (proy.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
                            proyectoList.add(proy);
                            continue;
                        }
                    }
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)) {
                    if (proy.getComisionCalificacion() != null) {
                        for (MiembroComisionCalificacion m : proy.getComisionCalificacion().getMiembroList()) {
                            if (m.getEstado().equals(MiembroComisionCalificacion.ESTADO_ACTIVO) && m.getUsuario().equals(usuarioActual)) {
                                proyectoList.add(proy);
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            proyectoList = temp;
        }
    }

    public String agregarProyecto() {
        try {
            /*Convocatoria convocatoria = convocatoriaFacade.findByEstadoAbierto();
            if (convocatoria == null) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:btnAgregarProyecto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe una convocatoria abierta a la fecha actual. Por favor, previamente debe crear una convocatoria."));
                return "";
            } else {*/
            //FacesContext.getCurrentInstance().getExternalContext().redirect("proyecto.xhtml?idPrograma=" + codProgramaSelected);
            FacesContext.getCurrentInstance().getExternalContext().redirect("proyecto.xhtml");
            //}
        } catch (Exception e) {
        }
        return "";
    }

    public boolean isPermitirAgregarProyecto() {
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROYECTO)) {
            return true;
        }
        return false;
    }

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public List<SeaParametrosDet> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<SeaParametrosDet> estadoList) {
        this.estadoList = estadoList;
    }
    
    
}
