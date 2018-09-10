/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.session.SeaComisionXConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ProyectosAsignacionParController implements Serializable {
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    private BigDecimal idConvocatoria;
    private List<SeaDatGeneralProy> notaConceptualList;
    private List<SeaConvoca> convocatoriaList;
    private SegUsuario usuarioActual;
    @EJB
    private SeaComisionXConvocaFacade comisionConvocatoriaFacade;
    
    public ProyectosAsignacionParController() {

    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        convocatoriaList=comisionConvocatoriaFacade.findConvocatoriaByUsuario(usuarioActual.getUsuId());
        listarNotasConceptuales();
    }

    public void listarNotasConceptuales() {
        if (idConvocatoria==null){
            notaConceptualList = notaConceptualFacade.findByAsignacionParUsuario(usuarioActual.getUsuId());
        }
        else{
            notaConceptualList = notaConceptualFacade.findByAsignacionParConvocatoria(idConvocatoria);
        }
        
    }

    public BigDecimal getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(BigDecimal idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public List<SeaDatGeneralProy> getNotaConceptualList() {
        return notaConceptualList;
    }

    public void setNotaConceptualList(List<SeaDatGeneralProy> notaConceptualList) {
        this.notaConceptualList = notaConceptualList;
    }
    
    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    
}

