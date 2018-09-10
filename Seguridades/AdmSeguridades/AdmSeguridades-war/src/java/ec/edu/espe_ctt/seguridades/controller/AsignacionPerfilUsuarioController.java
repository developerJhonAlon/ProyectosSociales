/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.seguridades.controller;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegPerfilFacade;
import ec.edu.espe_ctt.seguridades.session.SegUsuPerfilFacade;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class AsignacionPerfilUsuarioController extends LazyDataModel<SegUsuPerfil> {

    private String usuario = "";
    private String perfil = "";
    private boolean controlGrabar = false;
    private boolean validaVacios = true;
    private boolean existe = false;

    @EJB
    private SegUsuarioFacade usuarioFacade;
    private List<SegUsuario> usuarioList;
    //private SegUsuario usuario;

    @EJB
    private SegPerfilFacade perfilFacade;
    private List<SegPerfil> perfilList;

    @EJB
    private SegUsuPerfilFacade segUsuPerfilFacade;

    private SegUsuPerfil segUsuPerfil;

    private SegUsuPerfil segUsuPerSelected;

    ///Variables
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        checkIngreso();
    }
    @Override
    public List<SegUsuPerfil> load(
            int first, int pageSize,
            String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        List<SegUsuPerfil> users = segUsuPerfilFacade.findByPaginacion(first, pageSize, sortField, sortOrder, filters);
        setRowCount(segUsuPerfilFacade.count(filters));
        return users;
    }    

    /////////////Funciones
    public void checkIngreso() {
        usuarioList = usuarioFacade.findEsTudiantesByName(usuario);
        perfilList = perfilFacade.findPerfilSistema();
    }

    public String registra() {

        if (segUsuPerfil == null) {
            ///registra nuevo               
            if (segUsuPerfilFacade.findPerfilByUserAndPerfil(usuarioList.get(0).getUsuId(), new BigDecimal(perfil)).isEmpty()) {
                Date fecha = new Date();
                SegPerfil per = new SegPerfil();
                per.setPerId(new BigDecimal(perfil));
                SegUsuario usu = new SegUsuario();
                usu.setUsuId(usuarioList.get(0).getUsuId());
                segUsuPerfil = new SegUsuPerfil();
                segUsuPerfil.setSegPerfil(per);
                segUsuPerfil.setSegUsuario(usu);
                segUsuPerfil.setUspFechaIni(fecha);
                segUsuPerfilFacade.create(segUsuPerfil);
                usuarioList = usuarioFacade.findEsTudiantesByName("");
                cancelar();
            } else {
//                FacesContext context = FacesContext.getCurrentInstance();
//                context.addMessage(null, new FacesMessage("El usuario ya tiene asignado ese perfil"));
                existe = true;
            }
        }
        return "";
    }

    public String agregar() {

        controlGrabar = true;
        return "";
    }

    public boolean validarVacios() {
        validaVacios = false;
        //quitando espacios en blanco de las variales
//        usuario = usuario.trim();
        perfil = perfil.trim();

//validando que no esten vacias.
        if (usuario.isEmpty()) {
            validaVacios = true;
        }
        
//        if (usuarioList.size()!=1){
//            validaVacios = true;
//        }
        if (perfil.isEmpty()) {
            validaVacios = true;
        }
//validacion de usuario
        if (!validaVacios) {
            
            if (segUsuPerfilFacade.findPerfilByUserAndPerfil(usuarioList.get(0).getUsuId(), new BigDecimal(perfil)).isEmpty()) {
                existe = false;
            } else {
                existe = true;
            }            
        }

        return validaVacios;
    }

    public void cancelar() {
        /// inicializar variables de entrada
        controlGrabar = false;
        validaVacios = true;
        segUsuPerfil = null;        
        existe = false;
        usuario = "";
        perfil = "";
    }


    public void inactivar() {
        if (segUsuPerSelected != null) {
            Date fecha = new Date();
            if (segUsuPerSelected.getUspFechaFin() == null) {
                segUsuPerSelected.setUspFechaFin(fecha);
            } else {
                segUsuPerSelected.setUspFechaFin(null);
            }
            segUsuPerfilFacade.edit(segUsuPerSelected);

        }
    }
    
    
     public List<String> completeText(String query) {
         usuarioList = usuarioFacade.findEsTudiantesByName(query);
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < usuarioList.size(); i++) {
            results.add(usuarioList.get(i).getUsuApellidos()+ " "+usuarioList.get(i).getUsuNombres() );
        }
         
        return results;
    }
     
      public List<String> completeText1(String query) {
         System.out.println(" el valor es tar "+query );
         usuarioList = usuarioFacade.findEsTudiantesByName(query);
         System.out.println(" la lista es "+usuarioList.size());
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < usuarioList.size(); i++) {
            results.add(usuarioList.get(i).getUsuApellidos());
        }
         
        return results;
    }
   
      public void onItemSelect(SelectEvent event) {
          
          System.out.println(" el evet es "+event.getObject());
          usuarioList = usuarioFacade.findEsTudiantesByName(event.getObject().toString());
          validarVacios();
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
     
    //getter y setter
    public List<SegUsuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<SegUsuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<SegPerfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<SegPerfil> perfilList) {
        this.perfilList = perfilList;
    }

    public SegUsuPerfil getSegUsuPerSelected() {
        return segUsuPerSelected;
    }

    public void setSegUsuPerSelected(SegUsuPerfil segUsuPerSelected) {
        this.segUsuPerSelected = segUsuPerSelected;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

}
