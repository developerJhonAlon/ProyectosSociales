/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteInvestigacionFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ComisionProyectoController implements Serializable {

    @EJB
    private SeaParametrosDetFacade faseParFacade;
    private List<SeaParametrosDet> faseParList;
    private String fasePar = "";
    @EJB
    private SeaParesConvocaFacade comisionParFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    @EJB
    private SeaDatGeneralProyFacade notaConceptualFacade;
    private BigDecimal idConvocatoria;
    private List<SeaDatGeneralProy> notaConceptualList;
    private SeaParesConvoca parSelected;
    private List<SeaConvoca> convocatoriaList;
    @EJB
    private SeaConvocaFacade convocatoriaFacade;

    private SeaDatGeneralProy notaconceptualSelected;
    @EJB
    private VDocenteInvestigacionFacade investigadorParFacade;

    public ComisionProyectoController() {

    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        convocatoriaList = convocatoriaFacade.findConvocatoria();
        faseParList = faseParFacade.findFaseComisionPar();
        listarNotasConceptuales();
    }

    public List<SeaParametrosDet> getFaseParList() {
        return faseParList;
    }

    public void setFaseParList(List<SeaParametrosDet> faseParList) {
        this.faseParList = faseParList;
    }

    public void listarNotasConceptuales() {
        cancelaPar();
        notaConceptualList = notaConceptualFacade.findByAsignacionParConvocatoria(idConvocatoria);
        notaconceptualSelected=null;
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

    public SeaParesConvoca getParSelected() {
        return parSelected;
    }

    public void setParSelected(SeaParesConvoca parSelected) {
        this.parSelected = parSelected;
    }

    public void nuevoPar() {
        parSelected = new SeaParesConvoca();
    }

    public void cancelaPar() {
        parSelected=null;
        docenteEspeList=null;
        docenteExternoList=null;
        tipoPar = "L";
        investigadorEspe = "";
        investigadorExterno = "";        
        fasePar="";
    }

    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public SeaDatGeneralProy getNotaconceptualSelected() {
        return notaconceptualSelected;
    }

    public void setNotaconceptualSelected(SeaDatGeneralProy notaconceptualSelected) {
        this.notaconceptualSelected = notaconceptualSelected;
    }

    public void grabar() {
        try {
            SegUsuario inves = new SegUsuario();
            if (tipoPar.equals("L")) {  //Par ESPE
                if (docenteEspeList==null || docenteEspeList.isEmpty()){
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:investigadorEspe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteEspeList.get(0).getUsuId());
            } else { //Par Externo
                if (docenteExternoList==null || docenteExternoList.isEmpty()){
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:investigadorEspe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un investigador"));
                    return;
                }
                inves.setUsuId(docenteExternoList.get(0).getUsuId());
            }
            parSelected.setUsuId(inves);
            for (SeaParesConvoca par : notaconceptualSelected.getParEvaluacionList()) {
                if (par.getUsuId().getUsuId().equals(parSelected.getUsuId().getUsuId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El investigador ya fue asignado a esta Fase"));
                    return;
                }
            }
            SeaParametrosDet fase = new SeaParametrosDet();
            fase.setPrdId(new Long(fasePar));
            parSelected.setPrdId(fase);
            parSelected.setNotaConceptual(notaconceptualSelected);
            parSelected.setUsuIdCrea(usuario);
            parSelected.setSpcFechaCrea(new Date());
            parSelected.setSpcEstado("A");
            comisionParFacade.create(parSelected);
            notaconceptualSelected = notaConceptualFacade.find(notaconceptualSelected.getDatgeproyId());
            /*docenteEspeList = investigadorParFacade.findInvestigadorByName("");
            parSelected = null;*/
            cancelaPar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un problema al tratar de registrar la información"));
        }

    }

    private String tipoPar = "";

    public String getTipoPar() {
        return tipoPar;
    }

    public void setTipoPar(String tipoPar) {
        this.tipoPar = tipoPar;
    }

    private String investigadorEspe = "";
    private String investigadorExterno = "";

    public String getInvestigadorEspe() {
        return investigadorEspe;
    }

    public void setInvestigadorEspe(String investigadorEspe) {
        this.investigadorEspe = investigadorEspe;
    }

    public String getInvestigadorExterno() {
        return investigadorExterno;
    }

    public void setInvestigadorExterno(String investigadorExterno) {
        this.investigadorExterno = investigadorExterno;
    }
    private List<VDocenteInvestigacion> docenteEspeList;
    private List<SegUsuario> docenteExternoList;

    public List<String> completeTextParEspe(String query) {
        docenteEspeList = investigadorParFacade.findInvestigadorByName(query);
        List<String> results = new ArrayList<>();
        for (VDocenteInvestigacion investigadorList1 : docenteEspeList) {
            results.add(investigadorList1.getUsuCc() + "-" + investigadorList1.getUsuApellidos() + " " + investigadorList1.getUsuNombres());
        }

        return results;
    }

    public List<String> completeTextParExterno(String query) {
        docenteExternoList = usuarioFacade.findParesExternoByName(query);
        List<String> results = new ArrayList<>();
        for (SegUsuario paresExternoList1 : docenteExternoList) {
            results.add(paresExternoList1.getUsuCc() + "-" + paresExternoList1.getUsuApellidos() + " " + paresExternoList1.getUsuNombres());
        }
        return results;
    }

    public void onItemSelectParEspe(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteEspeList = investigadorParFacade.findInvestigadorByName(temp[1]);
    }

    public void onItemSelectParExterno(SelectEvent event) {
        String[] temp = event.getObject().toString().split("-");
        docenteExternoList = usuarioFacade.findParesExternoByName(temp[1]);
    }

    public String getFasePar() {
        return fasePar;
    }

    public void setFasePar(String fasePar) {
        this.fasePar = fasePar;
    }
    
     public void eliminarPar() {
        try {
            comisionParFacade.remove(parSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            notaconceptualSelected = notaConceptualFacade.find(notaconceptualSelected.getDatgeproyId());
        }
       
    }

    public void onConvocatoriaChange() {
        
    }    
}

