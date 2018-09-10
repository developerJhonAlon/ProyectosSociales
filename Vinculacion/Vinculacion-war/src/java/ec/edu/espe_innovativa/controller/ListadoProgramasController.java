/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.CoordinadorVinculacion;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.session.CoordinadorVinculacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ListadoProgramasController implements Serializable {

    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;

    @EJB
    private ProgramaFacade programaFacade;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;
    private CoordinadorVinculacion coordinadorVinculacion;
    @EJB
    private CoordinadorVinculacionFacade coordinadorVinculacionFacade;

    @PostConstruct
    public void init() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
            if (usuarioActual == null) {
                //FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
                FacesContext.getCurrentInstance().getExternalContext().dispatch("/login.xhtml");
                //context.getExternalContext().dispatch("/vista/sistema.xhtml");
            } else {
                perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                    coordinadorVinculacion = coordinadorVinculacionFacade.getCoordinacionVincluacionById(usuarioActual.getUsuId());
                }

                listarProgramas();
            }

        } catch (Exception e) {
        }
    }

    private List<Programa> programaList;

    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public void listarProgramas() {
        List<Programa> temp = programaFacade.findXEstado(estado);
        programaList = new ArrayList<>();
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_REPORTES)
                || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
            programaList = temp;
        } else {
            for (Programa prog : temp) {
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                    /*if (prog.getCreador() != null && prog.getCreador().getUsuario().equals(usuarioActual)) {
                        programaList.add(prog);
                        continue;
                    }*/
                    if (coordinadorVinculacion!=null && coordinadorVinculacion.getCampus()!=null && prog.getCampus()!=null && coordinadorVinculacion.getCampus().equals(prog.getCampus())){
                        if (coordinadorVinculacion.getDepartamento()!=null && prog.getDepartamento()!=null){
                            if (coordinadorVinculacion.getDepartamento().equals(prog.getDepartamento())){
                                programaList.add(prog);
                                continue;
                            }
                        }
                        else{
                            programaList.add(prog);
                            continue;
                        }
                    }
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA)) {
                    if (prog.getDirector() != null && prog.getDirector().getUsuario().equals(usuarioActual)) {
                        programaList.add(prog);
                        continue;
                    }
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA)) {
                    if (prog.getEvaluadorFinal() != null && prog.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
                        programaList.add(prog);
                    }
                }
            }
        }
    }

    public boolean isPermitirAgregarPrograma() {
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROGRAMA)) {
            return true;
        }
        return false;
    }
}
