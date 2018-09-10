/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.session.SeaClasificadorPresupFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.PresupuestoPartidaFacade;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class PresupuestoPartidaController {

    private SegUsuario usuario;

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Convocatoria
    private boolean botonInicio = true;
    private boolean habilitaTab = true;

    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private List<SeaFormatoLargo> formatoLargoList;
    private SeaFormatoLargo formatoLargoSelected;

    ///Variables tab1
    @EJB
    private PresupuestoPartidaFacade presupuestoXPartidaFacade;
    private List<PresupuestoPartida> presupuestoXPartidaList;
    private PresupuestoPartida presupuestoXPartida;
    private PresupuestoPartida presupuestoXPartidaSelected;
    
    @EJB
    private SeaClasificadorPresupFacade clasificadorPresupuestoFacade;
    private List<SeaClasificadorPresup> clasificadorPresupuestoList;
    private List<SeaClasificadorPresup> subPartidaPresupList;
    private List<SeaClasificadorPresup> partidaPresupList;

    private String clasificador = "";
    private String subPartida = "";
    private String partidaPresp = "";
    private String valor = "";
    private String valorOtras = "";
    private String codIncop ="";
    private String nomFileP1 = "";
    private byte[] fileP1 = null;
    private String especificacion = "";


    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;


    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        checkIngreso();
    }

    public String inicioFormatoLargo() {
        if (botonInicio) {
            /// regresar a lista de programas 
            System.out.println(" boton1 " + botonInicio);
            habilitaTab = true;

        } else {
            //// es nuevo 
            System.out.println(" boton 2" + botonInicio);

        }
        return "";

    }

    public String seleccionaConvo() {
        botonInicio = false;
        //habilitaTab = false;
        cargaDatosConvoca();
        return "";
    }

    /////////////Funciones
    void checkIngreso() {
        formatoLargoList = formatoLargoFacade.findFormatoLargoByCodUsu(usuario.getUsuId());

    }

    public void cargaDatosConvoca() {

        //tab1        
        presupuestoXPartidaList = presupuestoXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(formatoLargoSelected.getSflId());
        clasificadorPresupuestoList = clasificadorPresupuestoFacade.findClasificadorByPrepupuesto();
//        programacionAnualMesList = programaAnualFacade.findMesAndProgramaAnual(formatoLargoSelected.getSflId());
//        totalPres = new SeaTotalPresupAnual();
//        obtenerTotal();
        //totalPres = totalPresuFacade.
    }

    //funciones tab1
    public String registraP1() {

        if (presupuestoXPartida == null) {
            ///registra nuevo               
            presupuestoXPartida = new PresupuestoPartida();
            /*presupuestoXPartida.setSflId(formatoLargoSelected);
            SeaClasificadorPresup cp = new SeaClasificadorPresup(new BigDecimal(partidaPresp));
            presupuestoXPartida.setPartida(cp);
            presupuestoXPartida.setValor(new BigDecimal(valor));
            presupuestoXPartida.setSpxpValotras(new BigDecimal(valorOtras));
            presupuestoXPartida.setSpxpEspecificaciones(especificacion);
            presupuestoXPartida.setCodigoCategoriaCPC(codIncop);
            presupuestoXPartida.setSpxpNombreDocumento(nomFileP1);
            presupuestoXPartida.setSpxpDocumentoDigital(fileP1);
            presupuestoXPartidaFacade.create(presupuestoXPartida);
            presupuestoXPartidaList = presupuestoXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(formatoLargoSelected.getSflId());*/
            cancelarP1();
        }
        return "";
    }
    public String agregarP1() {

        controlGrabarP1 = true;
        return "";
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        clasificador = clasificador.trim();
        subPartida = subPartida.trim();
        partidaPresp = partidaPresp.trim();
        valor = valor.trim();
        valorOtras = valorOtras.trim();
        codIncop = codIncop.trim();
        //nomFileP1 = nomFileP1.trim();
        especificacion = especificacion.trim();

        if (clasificador.isEmpty()) {
            validaVaciosP1 = true;
        }
        if(subPartida.isEmpty()) validaVaciosP1 = true;
        if(partidaPresp.isEmpty()) validaVaciosP1 = true;
        if(valorOtras.isEmpty()) validaVaciosP1 = true;
        if(codIncop.isEmpty()) validaVaciosP1 = true;
        
        if (valor.isEmpty()) {
            validaVaciosP1 = true;
        }
//        if (nomFileP1.isEmpty()) {
//            validaVaciosP1 = true;
//        }

        if (especificacion.isEmpty()) {
            validaVaciosP1 = true;
        }
        return validaVaciosP1;
    }

    public void cancelarP1() {
        /// inicializar variables de entrada
        controlGrabarP1 = false;
        validaVaciosP1 = true;
        presupuestoXPartida = null;

        clasificador = "";
        subPartida ="";
        partidaPresp ="";
        valor = "";
        valorOtras ="";
        codIncop ="";
//        nomFileP1 = "";
        especificacion = "";
    }

    public void eliminarP1() {
        Integer registro = 0;
        if (presupuestoXPartidaSelected != null) {
            PresupuestoPartida eliminar = null;
            for (int i = 0; i < presupuestoXPartidaList.size(); i++) {
                PresupuestoPartida elemento = this.presupuestoXPartidaList.get(i);
                if (presupuestoXPartidaSelected.getId() == presupuestoXPartidaList.get(i).getId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.presupuestoXPartidaList.remove(eliminar);
                presupuestoXPartidaFacade.remove(eliminar);
            }
        }
    }

    public void onRowEditP1(RowEditEvent event) {

        PresupuestoPartida seaPrepEdit = new PresupuestoPartida();
        seaPrepEdit = (PresupuestoPartida) event.getObject();
        
//        SeaClasificadorPresup cp = new SeaClasificadorPresup();
//        cp.setScpId(seaPrepEdit.getScpId().getScpId());
//        
//        seaPrepEdit.setScpId(cp);
        
        if (!nomFileP1.isEmpty() && fileP1 != null) {
            /*seaPrepEdit.setSpxpNombreDocumento(nomFileP1);
            seaPrepEdit.setSpxpDocumentoDigital(fileP1);*/
        }
        presupuestoXPartidaFacade.edit(seaPrepEdit);

        presupuestoXPartidaList = presupuestoXPartidaFacade.findPrespuestoXPartidaByFormatoLargo(formatoLargoSelected.getSflId());
    }

    public void onRowCancelP1(RowEditEvent event) {
        //        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        //        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }


    //// carga archivo
    public void handleFileUploadP1(FileUploadEvent event) throws IOException {

        nomFileP1 = event.getFile().getFileName();
        InputStream is = null;

        is = event.getFile().getInputstream();
        this.setFileP1(IOUtils.toByteArray(is));

        validarVaciosP1();

    }
    public void onSubPartidaChange(){
        subPartidaPresupList = clasificadorPresupuestoFacade.findSubPartidaByCodCp(new BigDecimal(clasificador));
    }
    public void onPartidaPresupChange(){
        partidaPresupList = clasificadorPresupuestoFacade.findPartidaPrespByCodCp(new BigDecimal(subPartida));
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    //selecciona formato
    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public List<SeaFormatoLargo> getFormatoLargoList() {
        return formatoLargoList;
    }

    public void setFormatoLargoList(List<SeaFormatoLargo> formatoLargoList) {
        this.formatoLargoList = formatoLargoList;
    }

    public SeaFormatoLargo getFormatoLargoSelected() {
        return formatoLargoSelected;
    }

    public void setFormatoLargoSelected(SeaFormatoLargo formatoLargoSelected) {
        this.formatoLargoSelected = formatoLargoSelected;
    }

    public boolean isControlGrabarP1() {
        return controlGrabarP1;
    }

    public void setControlGrabarP1(boolean controlGrabarP1) {
        this.controlGrabarP1 = controlGrabarP1;
    }

    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }


//</editor-fold>

    //Tab 1
    public List<PresupuestoPartida> getPresupuestoXPartidaList() {
        return presupuestoXPartidaList;
    }

    public void setPresupuestoXPartidaList(List<PresupuestoPartida> presupuestoXPartidaList) {
        this.presupuestoXPartidaList = presupuestoXPartidaList;
    }

    public PresupuestoPartida getPresupuestoXPartidaSelected() {
        return presupuestoXPartidaSelected;
    }

    public void setPresupuestoXPartidaSelected(PresupuestoPartida presupuestoXPartidaSelected) {
        this.presupuestoXPartidaSelected = presupuestoXPartidaSelected;
    }

    public List<SeaClasificadorPresup> getClasificadorPresupuestoList() {
        return clasificadorPresupuestoList;
    }

    public void setClasificadorPresupuestoList(List<SeaClasificadorPresup> clasificadorPresupuestoList) {
        this.clasificadorPresupuestoList = clasificadorPresupuestoList;
    }
    
    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNomFileP1() {
        return nomFileP1;
    }

    public void setNomFileP1(String nomFileP1) {
        this.nomFileP1 = nomFileP1;
    }

    public byte[] getFileP1() {
        return fileP1;
    }

    public void setFileP1(byte[] fileP1) {
        this.fileP1 = fileP1;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public List<SeaClasificadorPresup> getSubPartidaPresupList() {
        return subPartidaPresupList;
    }

    public void setSubPartidaPresupList(List<SeaClasificadorPresup> subPartidaPresupList) {
        this.subPartidaPresupList = subPartidaPresupList;
    }

    public String getSubPartida() {
        return subPartida;
    }

    public void setSubPartida(String subPartida) {
        this.subPartida = subPartida;
    }

    public List<SeaClasificadorPresup> getPartidaPresupList() {
        return partidaPresupList;
    }

    public void setPartidaPresupList(List<SeaClasificadorPresup> partidaPresupList) {
        this.partidaPresupList = partidaPresupList;
    }

    public String getPartidaPresp() {
        return partidaPresp;
    }

    public void setPartidaPresp(String partidaPresp) {
        this.partidaPresp = partidaPresp;
    }

    public String getValorOtras() {
        return valorOtras;
    }

    public void setValorOtras(String valorOtras) {
        this.valorOtras = valorOtras;
    }

    public String getCodIncop() {
        return codIncop;
    }

    public void setCodIncop(String codIncop) {
        this.codIncop = codIncop;
    }
    
    
}
