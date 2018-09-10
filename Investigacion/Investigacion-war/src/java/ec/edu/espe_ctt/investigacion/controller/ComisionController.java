/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion;
import ec.edu.espe_ctt_investigacion.session.SeaComisionXConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTipoResponsFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteInvestigacionFacade;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ComisionController {

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Convocatoria
    @EJB
    private SeaConvocaFacade convocatoriaFacade;
    private List<SeaConvoca> convocatoriaList;
    private SeaConvoca convocatoriaSelected;

    ///Variables tab1
    @EJB
    private SeaComisionXConvocaFacade comisionFacade;
    private SeaComisionXConvoca comisionSelected;

    @EJB
    private VDocenteInvestigacionFacade investigadorFacade;
    private List<VDocenteInvestigacion> docenteEspeList;
    private String investigadorEspe = "";
    private String investigadorExterno = "";

    @EJB
    private SeaTipoResponsFacade tipoResponsFacade;
    private List<SeaTipoRespons> tipoResponsList;
    private String estado = "A";

    ///Seg Usuario
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private List<SegUsuario> docenteExternoList;
    private List<SegUsuario> paresExternoList;

    @EJB
    private VDocenteInvestigacionFacade investigadorParFacade;
    private String tipoMiembro = "";

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        listarConvocatorias();
    }

    public void seleccionarConvocatoria() {
        docenteEspeList = investigadorFacade.findInvestigadorByName(investigadorEspe);
        tipoResponsList = tipoResponsFacade.findTipoResponComision();
        modoEdicion=false;
    }

    //funciones tab1
    public void registraP1() {
        try {
            SegUsuario inves = new SegUsuario();
            if (tipoMiembro.equals("E")) {  //Miembro ESPE
                if (docenteEspeList == null || docenteEspeList.isEmpty()) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:tabView:investigadorEspe_input", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteEspeList.get(0).getUsuId());
            } else { //Miembro Externo
                if (docenteExternoList == null || docenteExternoList.isEmpty()) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:tabView:investigadorExterno_input", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteExternoList.get(0).getUsuId());
            }
            comisionSelected.setUsuId(inves);
            for (SeaComisionXConvoca par : convocatoriaSelected.getSeaComisionXConvocaList()) {
                if (par.getUsuId().getUsuId().equals(comisionSelected.getUsuId().getUsuId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El investigador ya fue asignado a esta Convocatoria"));
                    return;
                }
            }
            comisionSelected.setConvocaId(convocatoriaSelected);
            comisionSelected.setUsuIdCrea(usuario);
            comisionSelected.setScxcFechaCrea(new Date());
            comisionFacade.create(comisionSelected);
            convocatoriaSelected = convocatoriaFacade.find(convocatoriaSelected.getConvocaId());
            cancelarP1();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void agregarP1() {
        comisionSelected = new SeaComisionXConvoca();
        tipoMiembro = "E";
        investigadorEspe = "";
        investigadorExterno = "";
        docenteEspeList = null;
        docenteExternoList = null;
    }

    public void cancelarP1() {
        comisionSelected = null;
    }

    public void eliminarP1() {
        try {
            comisionFacade.remove(comisionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarP1();
            convocatoriaSelected = convocatoriaFacade.find(convocatoriaSelected.getConvocaId());
        }

    }

    public List<String> completeTextMiembroEspe(String query) {
        docenteEspeList = investigadorParFacade.findInvestigadorByName(query);
        List<String> results = new ArrayList<>();
        for (VDocenteInvestigacion investigadorList1 : docenteEspeList) {
            results.add(investigadorList1.getUsuCc() + "-" + investigadorList1.getUsuApellidos() + " " + investigadorList1.getUsuNombres());
        }

        return results;
    }

    public List<String> completeTextMiembroExterno(String query) {
        docenteExternoList = usuarioFacade.findMiembrosExternoByName(query);
        List<String> results = new ArrayList<>();
        for (SegUsuario paresExternoList1 : docenteExternoList) {
            results.add(paresExternoList1.getUsuCc() + "-" + paresExternoList1.getUsuApellidos() + " " + paresExternoList1.getUsuNombres());
        }
        return results;
    }

    public void onItemSelectComisionEspe(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteEspeList = investigadorFacade.findInvestigadorByName(temp[1]);
    }

    public void onItemSelectComisionExterno(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteExternoList = usuarioFacade.findMiembrosExternoByName(temp[1]);
    }

//<editor-fold defaultstate="collapsed" desc="Getter y Setter">    
    //getter y setter seleccion convocatoria
    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public SeaConvoca getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(SeaConvoca convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }

    //getter y setter seleccion tab 1
    public SeaComisionXConvoca getComisionSelected() {
        return comisionSelected;
    }

    public void setComisionSelected(SeaComisionXConvoca comisionSelected) {
        this.comisionSelected = comisionSelected;
    }

    public List<VDocenteInvestigacion> getDocenteEspeList() {
        return docenteEspeList;
    }

    public void setDocenteEspeList(List<VDocenteInvestigacion> docenteEspeList) {
        this.docenteEspeList = docenteEspeList;
    }

    public String getInvestigadorEspe() {
        return investigadorEspe;
    }

    public void setInvestigadorEspe(String investigadorEspe) {
        this.investigadorEspe = investigadorEspe;
    }

    public List<SeaTipoRespons> getTipoResponsList() {
        return tipoResponsList;
    }

    public void setTipoResponsList(List<SeaTipoRespons> tipoResponsList) {
        this.tipoResponsList = tipoResponsList;
    }

//</editor-fold>
//getter y setter seleccion tab 2
    public String getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(String tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    public String getInvestigadorExterno() {
        return investigadorExterno;
    }

    public void setInvestigadorExterno(String investigadorExterno) {
        this.investigadorExterno = investigadorExterno;
    }

    public List<SegUsuario> getDocenteExternoList() {
        return docenteExternoList;
    }

    public void setDocenteExternoList(List<SegUsuario> docenteExternoList) {
        this.docenteExternoList = docenteExternoList;
    }

    public List<SegUsuario> getParesExternoList() {
        return paresExternoList;
    }

    public void setParesExternoList(List<SegUsuario> paresExternoList) {
        this.paresExternoList = paresExternoList;
    }

    public void listarConvocatorias() {
        convocatoriaSelected=null;
        convocatoriaList = convocatoriaFacade.findAll();
    }

    private StreamedContent archivoAdjunto;

    public StreamedContent getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(StreamedContent archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public void prepararArchivoDownload() {
        try {
            byte[] conteudo = convocatoriaSelected.getDocumentoComisionDigital();
            String nom = convocatoriaSelected.getDocumentoComisionNombre();
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(conteudo), "application/octet-stream", nom);
        } catch (Exception e) {
        }
    }

    public void subirAnexo(FileUploadEvent event) {
        try {
            convocatoriaSelected.setDocumentoComisionDigital(IOUtils.toByteArray(event.getFile().getInputstream()));
            convocatoriaSelected.setDocumentoComisionNombre(event.getFile().getFileName());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void guardarDocumento() {
        try {
            convocatoriaFacade.edit(convocatoriaSelected);
            modoEdicion=false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }
    }

    public void cancelarDocumento() {
        modoEdicion=false;
        convocatoriaSelected = convocatoriaFacade.find(convocatoriaSelected.getConvocaId());
    }

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

}
