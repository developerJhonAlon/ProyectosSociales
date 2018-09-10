/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.ValoracionParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.session.ConfiguracionParametrosEvaluacionInvFacade;
import ec.edu.espe_ctt_investigacion.session.ParametroEvaluacionInvFacade;
import ec.edu.espe_ctt_investigacion.session.ValoracionParametroEvaluacionInvFacade;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.Visibility;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ConfiguracionesController implements Serializable {

    @EJB
    private ConfiguracionParametrosEvaluacionInvFacade configuracionParametrosEvaluacionFacade;
    @EJB
    private ParametroEvaluacionInvFacade parametroEvaluacionFacade;
    @EJB
    private ValoracionParametroEvaluacionInvFacade valoracionParametroEvaluacionFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;

    private TreeNode opcionesMenu;
    private ParametroEvaluacionInv parametroEvaluacionSelected;
    private ParametroEvaluacionInv parametroEvaluacionPadreSelected;
    private TreeNode opcionMenuSelected;
    private ValoracionParametroEvaluacionInv valoracionParametroEvaluacionSelected;
    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;

    public ConfiguracionesController() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");
        inicializarOpcionesMenu();
        initConfiguracionParametrosEvaluacion();
    }

    public ParametroEvaluacionInv getParametroEvaluacionSelected() {
        return parametroEvaluacionSelected;
    }

    public void setParametroEvaluacionSelected(ParametroEvaluacionInv parametroEvaluacionSelected) {
        this.parametroEvaluacionSelected = parametroEvaluacionSelected;
    }

    public TreeNode getOpcionesMenu() {
        return opcionesMenu;
    }

    public void setOpcionesMenu(TreeNode opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    public TreeNode getOpcionMenuSelected() {
        return opcionMenuSelected;
    }

    public void setOpcionMenuSelected(TreeNode opcionMenuSelected) {
        this.opcionMenuSelected = opcionMenuSelected;
    }

    public void onMenuSelect(NodeSelectEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) opcionMenuSelected.getData();
        switch (opcionMenu.getCodigo()) {
            case "1":
                initConfiguracionParametrosEvaluacion();
                break;
        }

    }

    public String getOpcionMenuCodeSelected() {
        if (opcionMenuSelected != null) {
            return ((OpcionMenu) opcionMenuSelected.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public String nuevoParametroEvaluacion() {
        if ((configuracionParametrosEvaluacionSelected != null && !verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId()))
                || (parametroEvaluacionPadreSelected != null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionPadreSelected.getConfiguracionParametrosEvaluacion().getId()))) {
            configuracionParametrosEvaluacionSelected = null;
            parametroEvaluacionPadreSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            return "";
        }
        parametroEvaluacionSelected = new ParametroEvaluacionInv();
        RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
        return "";
    }

    public String grabarParametroEvaluacion() {
        try {
            if (parametroEvaluacionSelected.getId() == null) {
                if (configuracionParametrosEvaluacionSelected != null) {
                    parametroEvaluacionSelected.setConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected);
                    parametroEvaluacionSelected.setOrden(configuracionParametrosEvaluacionSelected.getParametroEvaluacionList().size() + 1);
                } else {
                    parametroEvaluacionSelected.setParametroEvaluacionPadre(parametroEvaluacionPadreSelected);
                    parametroEvaluacionSelected.setOrden(parametroEvaluacionPadreSelected.getParametroEvaluacionList().size() + 1);
                }
                parametroEvaluacionFacade.create(parametroEvaluacionSelected);
            } else {
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: La información se guardó exitosamente", ""));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void initConfiguracionParametrosEvaluacion() {
        if (expandedParametroEvaluacion == null) {
            expandedParametroEvaluacion = new HashMap<>();
        } else {
            expandedParametroEvaluacion.clear();
        }
        if (expandedParametroEvaluacionHijo == null) {
            expandedParametroEvaluacionHijo = new HashMap<>();
        } else {
            expandedParametroEvaluacionHijo.clear();
        }
        if (expandedConfigParametroEvaluacion == null) {
            expandedConfigParametroEvaluacion = new HashMap<>();
        } else {
            expandedConfigParametroEvaluacion.clear();;
        }

        cancelarEdicionConfiguracionParametrosEvaluacion(true);
        for (ConfiguracionParametrosEvaluacionInv conf : configuracionParametrosEvaluacionList) {
            expandedConfigParametroEvaluacion.put(conf.getId(), conf.isExpanded());
            for (ParametroEvaluacionInv parametroEvaluacion : conf.getParametroEvaluacionList()) {
                expandedParametroEvaluacion.put(parametroEvaluacion.getId(), parametroEvaluacion.isExpanded());
                for (ParametroEvaluacionInv parametroEvaluacionHijo : parametroEvaluacion.getParametroEvaluacionList()) {
                    expandedParametroEvaluacionHijo.put(parametroEvaluacionHijo.getId(), parametroEvaluacionHijo.isExpanded());
                }
            }
        }
    }

    public String cambiarOrdenValoracionParametroEvaluacion(ValoracionParametroEvaluacionInv valoracionParametroEvaluacion, Integer cambio) {
        try {
            valoracionParametroEvaluacion.cambiarOrden(cambio);
            parametroEvaluacionFacade.edit(valoracionParametroEvaluacion.getParametroEvaluacion());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }

    public String cambiarOrdenParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion, Integer cambio) {
        try {
            parametroEvaluacion.cambiarOrden(cambio);
            if (parametroEvaluacion.getParametroEvaluacionPadre() == null) {
                configuracionParametrosEvaluacionFacade.edit(parametroEvaluacion.getConfiguracionParametrosEvaluacion());
            } else {
                parametroEvaluacionFacade.edit(parametroEvaluacion.getParametroEvaluacionPadre());
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }

    public void inicializarOpcionesMenu() {
        opcionesMenu = new DefaultTreeNode("Root", null);
        TreeNode node1 = new DefaultTreeNode(new OpcionMenu("1", "- Parámetros de evaluación"), opcionesMenu);
        node1.setExpanded(true);
        node1.setSelected(true);
        initConfiguracionParametrosEvaluacion();
    }

    public void eliminarParametroEvaluacion() { 
        try {
            //if (!verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId())) {
        if ((parametroEvaluacionSelected.getParametroEvaluacionPadre() != null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getParametroEvaluacionPadre().getConfiguracionParametrosEvaluacion().getId()))
                || (parametroEvaluacionSelected.getParametroEvaluacionPadre() == null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId()))) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                if (parametroEvaluacionSelected.getParametroEvaluacionPadre() == null) {
                    configuracionParametrosEvaluacionSelected.removeParametroEvaluacion(parametroEvaluacionSelected);
                    configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected);
                } else {
                    parametroEvaluacionSelected.getParametroEvaluacionPadre().removeParametroEvaluacion(parametroEvaluacionSelected);
                    parametroEvaluacionFacade.edit(parametroEvaluacionSelected.getParametroEvaluacionPadre());
                }

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public ValoracionParametroEvaluacionInv getValoracionParametroEvaluacionSelected() {
        return valoracionParametroEvaluacionSelected;
    }

    public void setValoracionParametroEvaluacionSelected(ValoracionParametroEvaluacionInv valoracionParametroEvaluacionSelected) {
        this.valoracionParametroEvaluacionSelected = valoracionParametroEvaluacionSelected;
    }

    public String nuevoValoracionParametro() {
        if ((parametroEvaluacionSelected.getParametroEvaluacionPadre() != null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getParametroEvaluacionPadre().getConfiguracionParametrosEvaluacion().getId()))
                || (parametroEvaluacionSelected.getParametroEvaluacionPadre() == null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId()))) {
            parametroEvaluacionSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
        } else {
            valoracionParametroEvaluacionSelected = new ValoracionParametroEvaluacionInv();
        }
        return "";
    }

    public String grabarValoracionParametro() {
        try {
            if (valoracionParametroEvaluacionSelected.getId() == null) {
                valoracionParametroEvaluacionSelected.setParametroEvaluacion(parametroEvaluacionSelected);
                valoracionParametroEvaluacionSelected.setOrden(parametroEvaluacionSelected.getValoracionList().size() + 1);
                valoracionParametroEvaluacionFacade.create(valoracionParametroEvaluacionSelected);
            } else {
                valoracionParametroEvaluacionFacade.edit(valoracionParametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarValoracionParametroEvaluacion() {
        try {
            if ((parametroEvaluacionSelected.getParametroEvaluacionPadre() != null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getParametroEvaluacionPadre().getConfiguracionParametrosEvaluacion().getId()))
                    || (parametroEvaluacionSelected.getParametroEvaluacionPadre() == null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId()))) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                parametroEvaluacionSelected.removeValoracion(valoracionParametroEvaluacionSelected);
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }
    private Map<Integer, Boolean> expandedParametroEvaluacion = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> expandedParametroEvaluacionHijo = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> expandedConfigParametroEvaluacion = new HashMap<Integer, Boolean>();

    public Map<Integer, Boolean> getExpandedConfigParametroEvaluacion() {
        return expandedConfigParametroEvaluacion;
    }

    public void setExpandedConfigParametroEvaluacion(Map<Integer, Boolean> expandedConfigParametroEvaluacion) {
        this.expandedConfigParametroEvaluacion = expandedConfigParametroEvaluacion;
    }

    public Map<Integer, Boolean> getExpandedParametroEvaluacion() {
        return expandedParametroEvaluacion;
    }

    public void setExpandedParametroEvaluacion(Map<Integer, Boolean> expandedParametroEvaluacion) {
        this.expandedParametroEvaluacion = expandedParametroEvaluacion;
    }

    public Map<Integer, Boolean> getExpandedParametroEvaluacionHijo() {
        return expandedParametroEvaluacionHijo;
    }

    public void setExpandedParametroEvaluacionHijo(Map<Integer, Boolean> expandedParametroEvaluacionHijo) {
        this.expandedParametroEvaluacionHijo = expandedParametroEvaluacionHijo;
    }

    public void onRowToggleParametroEvaluacion(ToggleEvent event) {
        ParametroEvaluacionInv parametroEvaluacion = (ParametroEvaluacionInv) event.getData();
        expandedParametroEvaluacion.put(parametroEvaluacion.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public void onRowToggleParametroEvaluacionHijo(ToggleEvent event) {
        ParametroEvaluacionInv parametroEvaluacion = (ParametroEvaluacionInv) event.getData();
        expandedParametroEvaluacionHijo.put(parametroEvaluacion.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public void onRowToggleConfigParametroEvaluacion(ToggleEvent event) {
        ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacion = (ConfiguracionParametrosEvaluacionInv) event.getData();
        expandedConfigParametroEvaluacion.put(configuracionParametrosEvaluacion.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    private void setExpandedConfigParametroEvaluacion() {
        for (ConfiguracionParametrosEvaluacionInv conf : configuracionParametrosEvaluacionList) {
            Boolean expandedConf = (expandedConfigParametroEvaluacion.get(conf.getId()) != null) ? expandedConfigParametroEvaluacion.get(conf.getId()) : false;
            conf.setExpanded(expandedConf);

            for (ParametroEvaluacionInv parametroEvaluacion : conf.getParametroEvaluacionList()) {
                Boolean expanded = (expandedParametroEvaluacion.get(parametroEvaluacion.getId()) != null) ? expandedParametroEvaluacion.get(parametroEvaluacion.getId()) : false;
                parametroEvaluacion.setExpanded(expanded);
                for (ParametroEvaluacionInv parametroEvaluacionHijo : parametroEvaluacion.getParametroEvaluacionList()) {
                    Boolean expanded2 = (expandedParametroEvaluacionHijo.get(parametroEvaluacionHijo.getId()) != null) ? expandedParametroEvaluacionHijo.get(parametroEvaluacionHijo.getId()) : false;
                    parametroEvaluacionHijo.setExpanded(expanded2);

                }
            }
        }
    }

    private ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacionSelected;

    public ConfiguracionParametrosEvaluacionInv getConfiguracionParametrosEvaluacionSelected() {
        return configuracionParametrosEvaluacionSelected;
    }

    public void setConfiguracionParametrosEvaluacionSelected(ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacionSelected) {
        this.configuracionParametrosEvaluacionSelected = configuracionParametrosEvaluacionSelected;
    }

    public String nuevoConfiguracionParametrosEvaluacion() {
        permitirEdicionConfigParametroEvaluacion = true;
        estadoActivoConfiguracionParametros = false;
        configuracionParametrosEvaluacionSelected = new ConfiguracionParametrosEvaluacionInv();
        configuracionParametrosEvaluacionSelected.setTipo(ConfiguracionParametrosEvaluacionInv.TIPO_EVALUACION_INICIAL);
        return "";
    }

    public String grabarConfiguracionParametrosEvaluacion() {
        try {
            boolean actualizarEstado = false;
            if (estadoActivoConfiguracionParametros) {
                if (configuracionParametrosEvaluacionSelected.getId() != null && (configuracionParametrosEvaluacionSelected.getEstado() == null || configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacionInv.ESTADO_INACTIVA))) {
                    actualizarEstado = true;
                }
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacionInv.ESTADO_ACTIVA);
            } else {
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacionInv.ESTADO_INACTIVA);
            }
            if (configuracionParametrosEvaluacionSelected.getId() == null) {
                configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            } else {
                configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected, actualizarEstado);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String clonarConfiguracionParametrosEvaluacion() {
        try {
            configuracionParametrosEvaluacionSelected.setId(null);
            configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacionInv.ESTADO_INACTIVA);
            configuracionParametrosEvaluacionSelected.setFechaConfiguracion(new Date());
            configuracionParametrosEvaluacionSelected.setDescripcion("Configuración replicada de: " + configuracionParametrosEvaluacionSelected.getDescripcion());
            configuracionParametrosEvaluacionSelected.setExpanded(true);
            for (ParametroEvaluacionInv param : configuracionParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                param.setId(null);
                for (ValoracionParametroEvaluacionInv val : param.getValoracionList()) {
                    val.setId(null);
                }
                for (ParametroEvaluacionInv paramHijo : param.getParametroEvaluacionList()) {
                    paramHijo.setId(null);
                    for (ValoracionParametroEvaluacionInv valHijo : paramHijo.getValoracionList()) {
                        valHijo.setId(null);
                    }
                }
            }
            configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            expandedConfigParametroEvaluacion.put(configuracionParametrosEvaluacionSelected.getId(), true);

            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarEdicionConfiguracionParametrosEvaluacion(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            configuracionParametrosEvaluacionSelected = null;
            parametroEvaluacionSelected = null;
            valoracionParametroEvaluacionSelected = null;
        }
        configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionFacade.findXEvaluacionInicial();
        Collections.sort(configuracionParametrosEvaluacionList);
        setExpandedConfigParametroEvaluacion();
    }
    private List<ConfiguracionParametrosEvaluacionInv> configuracionParametrosEvaluacionList;

    public List<ConfiguracionParametrosEvaluacionInv> getConfiguracionParametrosEvaluacionList() {
        return configuracionParametrosEvaluacionList;
    }

    public void setConfiguracionParametrosEvaluacionList(List<ConfiguracionParametrosEvaluacionInv> configuracionParametrosEvaluacionList) {
        this.configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionList;
    }

    private boolean verificarEdicionConfiguracionParametrosEvaluacion(Integer idConfiguracionParametrosEvaluacion) {
        //return (proyectoFacade.verificarPermitirEdicionConfParamEvaluacion(idConfiguracionParametrosEvaluacion));
        return true;
    }

    private boolean verificarEdicionConfiguracionParametrosEvaluacionFinal(Integer idConfiguracionParametrosEvaluacion) {
        //return (proyectoFacade.verificarPermitirEdicionConfParamEvaluacionFinal(idConfiguracionParametrosEvaluacion));
        return true;
    }

    public void eliminarConfigParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                configuracionParametrosEvaluacionFacade.remove(configuracionParametrosEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public void seleccionarEditarValoracionParametroEvaluacion() {
        try {
            //if (!verificarEdicionConfiguracionParametrosEvaluacion(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getConfiguracionParametrosEvaluacion().getId())) {
            if ((valoracionParametroEvaluacionSelected.getParametroEvaluacion().getParametroEvaluacionPadre() != null && !verificarEdicionConfiguracionParametrosEvaluacion(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getParametroEvaluacionPadre().getConfiguracionParametrosEvaluacion().getId()))
                    || (valoracionParametroEvaluacionSelected.getParametroEvaluacion().getParametroEvaluacionPadre() == null && !verificarEdicionConfiguracionParametrosEvaluacion(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getConfiguracionParametrosEvaluacion().getId()))) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public void seleccionarEditarParametroEvaluacion() {
        try {
            //if (!verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId())) {
            if ((parametroEvaluacionSelected.getParametroEvaluacionPadre() != null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getParametroEvaluacionPadre().getConfiguracionParametrosEvaluacion().getId()))
                || (parametroEvaluacionSelected.getParametroEvaluacionPadre() == null && !verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId()))) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            } else {
                /*for (OpcionMenu op : opcionesMenuParametroList) {
                    if (op.getCodigo().equals(parametroEvaluacionSelected.getOpcionMenu())) {
                        opcionMenuParametroSelected = op;
                        break;
                    }
                }*/
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    private boolean permitirEdicionConfigParametroEvaluacion;

    public boolean isPermitirEdicionConfigParametroEvaluacion() {
        return permitirEdicionConfigParametroEvaluacion;
    }

    public void setPermitirEdicionConfigParametroEvaluacion(boolean permitirEdicionConfigParametroEvaluacion) {
        this.permitirEdicionConfigParametroEvaluacion = permitirEdicionConfigParametroEvaluacion;
    }

    public void seleccionarEditarConfigParametroEvaluacion() {
        try {
            //permitirEdicionConfigParametroEvaluacion = verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId());
            permitirEdicionConfigParametroEvaluacion = true;
            if (configuracionParametrosEvaluacionSelected.getEstado() != null && configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacionInv.ESTADO_ACTIVA)) {
                estadoActivoConfiguracionParametros = true;
            } else {
                estadoActivoConfiguracionParametros = false;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    private List<OpcionMenu> opcionesMenuParametroList;

    public List<OpcionMenu> getOpcionesMenuParametroList() {
        return opcionesMenuParametroList;
    }

    public void setOpcionesMenuParametroList(List<OpcionMenu> opcionesMenuParametroList) {
        this.opcionesMenuParametroList = opcionesMenuParametroList;
    }

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private boolean estadoActivoConfiguracionParametros;

    public boolean isEstadoActivoConfiguracionParametros() {
        return estadoActivoConfiguracionParametros;
    }

    public void setEstadoActivoConfiguracionParametros(boolean estadoActivoConfiguracionParametros) {
        this.estadoActivoConfiguracionParametros = estadoActivoConfiguracionParametros;
    }

    public ParametroEvaluacionInv getParametroEvaluacionPadreSelected() {
        return parametroEvaluacionPadreSelected;
    }

    public void setParametroEvaluacionPadreSelected(ParametroEvaluacionInv parametroEvaluacionPadreSelected) {
        this.parametroEvaluacionPadreSelected = parametroEvaluacionPadreSelected;
    }

}
