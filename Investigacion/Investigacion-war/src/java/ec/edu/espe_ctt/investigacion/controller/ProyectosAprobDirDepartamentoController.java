/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto;
import ec.edu.espe_ctt_investigacion.session.SeaDepcenproyFacade;
import ec.edu.espe_ctt_investigacion.session.VDirectoresDeptoFacade;
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
public class ProyectosAprobDirDepartamentoController implements Serializable {

    @EJB
    private SeaDepcenproyFacade depCenProyFacade;
    @EJB
    private VDirectoresDeptoFacade directorDeptoFacade;

    private List<SeaDepcenproy> depCenProyList;
    private SegUsuario usuarioActual;

    public ProyectosAprobDirDepartamentoController() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        List<VDirectoresDepto> directorDepList= directorDeptoFacade.findAll();
        //VDirectoresDepto directorDepto = directorDeptoFacade.findByUsuario(usuarioActual.getUsuId());
        depCenProyList= new ArrayList<>();
        //if (directorDepto != null) {
            for (VDirectoresDepto d : directorDepList) {
                if (d.getUsuId().equals(usuarioActual.getUsuId())){
                    depCenProyList.addAll(depCenProyFacade.findByCampusDepartamento(d.getCampusId(), d.getStvsubjCode()));
                }
                
            }
            
        //}
    }

    public List<SeaDepcenproy> getDepCenProyList() {
        return depCenProyList;
    }

    public void setDepCenProyList(List<SeaDepcenproy> depCenProyList) {
        this.depCenProyList = depCenProyList;
    }

}
