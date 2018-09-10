/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.ProgramacionAnualMes;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import ec.edu.espe_ctt_investigacion.entity.VResponsablesProyecto;
import ec.edu.espe_ctt_investigacion.session.CronogramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaAnualFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTotalPresupAnualFacade;
import ec.edu.espe_ctt_investigacion.session.VResponsablesProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProgramacionPresupuestoController {

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
    ///Variables tab1
    @EJB
    private SeaProgramaAnualFacade programaAnualFacade;
    private SeaProgramaAnual programaAnual;
    private List<ProgramacionAnualMes> programacionAnualMesList;
    @EJB
    private SeaTotalPresupAnualFacade totalPresuFacade;
    private SeaTotalPresupAnual totalPres;

    private boolean controlGrabarP1 = false;
    private boolean validaVaciosP1 = true;

    private BigDecimal totalInversion = BigDecimal.ZERO;
    private BigDecimal totalBienesServicios = BigDecimal.ZERO;
    private BigDecimal totalObrasPublicas = BigDecimal.ZERO;
    private BigDecimal totalOtrosGastos = BigDecimal.ZERO;
    private BigDecimal totalBienesLargaDuracion = BigDecimal.ZERO;
    
    private BigDecimal totalValEspePerInversion = BigDecimal.ZERO;
    private BigDecimal totalValEspeBienesServicios = BigDecimal.ZERO;
    private BigDecimal totalValEspeObrasPublicas = BigDecimal.ZERO;
    private BigDecimal totalValEspeOtrosGastos = BigDecimal.ZERO;
    private BigDecimal totalValEspeBienesLargaDuracion = BigDecimal.ZERO;
    
    private BigDecimal totalValOtrosPerInversion = BigDecimal.ZERO;
    private BigDecimal totalValOtrosBienesServicios = BigDecimal.ZERO;
    private BigDecimal totalValOtrosObrasPublicas = BigDecimal.ZERO;
    private BigDecimal totalValOtrosOtrosGastos = BigDecimal.ZERO;
    private BigDecimal totalValOtrosBienesLargaDuracion = BigDecimal.ZERO;

    @EJB
    private CronogramaFacade formatoCronogramaFacade;
    private List<Cronograma> formatoCronogramaList;
    private Cronograma formatoCronograma;

    @EJB
    private VResponsablesProyectoFacade responsableFormatoFacade;
    private List<VResponsablesProyecto> responsableFormatoList;

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
        programacionAnualMesList = programaAnualFacade.findMesAndProgramaAnual(formatoLargoSelected.getSflId());
        totalPres = new SeaTotalPresupAnual();
        obtenerTotal();
        //totalPres = totalPresuFacade.

    }
    public void onRowEditP1(RowEditEvent event){
        ProgramacionAnualMes pamEdit = new ProgramacionAnualMes();
        pamEdit = (ProgramacionAnualMes) event.getObject();
        
        SeaProgramaAnual pa = new SeaProgramaAnual();
        SeaClasificadorPresup cp = new SeaClasificadorPresup();
        
        // GASTOS EN PERSONAL PARA INVERSION
        if(pamEdit.getPartidaPerInver()!= null || pamEdit.getValorEspe() != null || pamEdit.getValorOtras() != null){
            pa = programaAnualFacade.findProgramaAnualByFormatoCronogramaMesAndCriterio(formatoLargoSelected.getSflId(), pamEdit.getSeaMeses().getSemeId(), new BigDecimal(71));
            cp.setScpId(new BigDecimal(71));
            if (pa.getSpanId() != null){
                pa.setSpanPartida(pamEdit.getPartidaPerInver());
                pa.setSpanVEspe(pamEdit.getValorEspe());
                pa.setSpanOInstitu(pamEdit.getValorOtras());
                programaAnualFacade.edit(pa);
            }else {
                pa = new SeaProgramaAnual();
                pa.setScpId(cp);
                pa.setSflId(formatoLargoSelected);
                pa.setSemeId(pamEdit.getSeaMeses());
                pa.setSpanPartida(pamEdit.getPartidaPerInver());
                pa.setSpanVEspe(pamEdit.getValorEspe());
                pa.setSpanOInstitu(pamEdit.getValorOtras());
                programaAnualFacade.create(pa);
            }
        }
        //BIENES Y SERVICIOS PARA INVERSION
        if(pamEdit.getPartidaBienSer() != null || pamEdit.getValorEspeBienSer() !=null || pamEdit.getValorOtrasBienSer() != null){
            pa = programaAnualFacade.findProgramaAnualByFormatoCronogramaMesAndCriterio(formatoLargoSelected.getSflId(), pamEdit.getSeaMeses().getSemeId(), new BigDecimal(73));
            cp.setScpId(new BigDecimal(73));
            if(pa.getSpanId() != null){
                pa.setSpanPartida(pamEdit.getPartidaBienSer());
                pa.setSpanVEspe(pamEdit.getValorEspeBienSer());
                pa.setSpanOInstitu(pamEdit.getValorOtrasBienSer());
                programaAnualFacade.edit(pa);
            }else {
                pa = new SeaProgramaAnual();
                pa.setScpId(cp);
                pa.setSflId(formatoLargoSelected);
                pa.setSemeId(pamEdit.getSeaMeses());
                pa.setSpanPartida(pamEdit.getPartidaBienSer());
                pa.setSpanVEspe(pamEdit.getValorEspeBienSer());
                pa.setSpanOInstitu(pamEdit.getValorOtrasBienSer());
                programaAnualFacade.create(pa);
            }
        }
        //OBRAS PUBLICAS
        if(pamEdit.getPartidaObrasP() != null || pamEdit.getValorEspeObrasP() != null || pamEdit.getValorOtrasObrasP() != null){
            pa = programaAnualFacade.findProgramaAnualByFormatoCronogramaMesAndCriterio(formatoLargoSelected.getSflId(), pamEdit.getSeaMeses().getSemeId(), new BigDecimal(75));
            cp.setScpId(new BigDecimal(75));
            if (pa.getSpanId() != null){
                pa.setSpanPartida(pamEdit.getPartidaObrasP());
                pa.setSpanVEspe(pamEdit.getValorEspeObrasP());
                pa.setSpanOInstitu(pamEdit.getValorOtrasObrasP());
                programaAnualFacade.edit(pa);
            }else {
                pa = new SeaProgramaAnual();
                pa.setScpId(cp);
                pa.setSflId(formatoLargoSelected);
                pa.setSemeId(pamEdit.getSeaMeses());
                pa.setSpanPartida(pamEdit.getPartidaObrasP());
                pa.setSpanVEspe(pamEdit.getValorEspeObrasP());
                pa.setSpanOInstitu(pamEdit.getValorOtrasObrasP());
                programaAnualFacade.create(pa);
            }
        }
        //OTROS GASTOS DE INVERSION
        if(pamEdit.getPartidaOtrosGastos() != null || pamEdit.getValorEspeGastosIn() != null || pamEdit.getValorOtrasGastosIn() != null){
           pa = programaAnualFacade.findProgramaAnualByFormatoCronogramaMesAndCriterio(formatoLargoSelected.getSflId(), pamEdit.getSeaMeses().getSemeId(), new BigDecimal(77));
           cp.setScpId(new BigDecimal(77));
           if (pa.getSpanId() != null){
               pa.setSpanPartida(pamEdit.getPartidaOtrosGastos());
               pa.setSpanVEspe(pamEdit.getValorEspeGastosIn());
               pa.setSpanOInstitu(pamEdit.getValorOtrasGastosIn());
               programaAnualFacade.edit(pa);
           }else {
               pa = new SeaProgramaAnual();
               pa.setScpId(cp);
               pa.setSflId(formatoLargoSelected);
               pa.setSemeId(pamEdit.getSeaMeses());
               pa.setSpanPartida(pamEdit.getPartidaOtrosGastos());
               pa.setSpanVEspe(pamEdit.getValorEspeGastosIn());
               pa.setSpanOInstitu(pamEdit.getValorOtrasGastosIn());
               programaAnualFacade.create(pa);
           }
        }
        //BIENES DE LARGA DURACION
        if(pamEdit.getPartidaBienLargaD() != null || pamEdit.getValorEspeLargaD() != null || pamEdit.getValorOtrasLargaD() != null){
           pa = programaAnualFacade.findProgramaAnualByFormatoCronogramaMesAndCriterio(formatoLargoSelected.getSflId(), pamEdit.getSeaMeses().getSemeId(), new BigDecimal(84));
           cp.setScpId(new BigDecimal(84));
           if (pa.getSpanId() != null){
               pa.setSpanPartida(pamEdit.getPartidaBienLargaD());
               pa.setSpanVEspe(pamEdit.getValorEspeLargaD());
               pa.setSpanOInstitu(pamEdit.getValorOtrasLargaD());
               programaAnualFacade.edit(pa);
           }else {
               pa = new SeaProgramaAnual();
               pa.setScpId(cp);
               pa.setSflId(formatoLargoSelected);
               pa.setSemeId(pamEdit.getSeaMeses());
               pa.setSpanPartida(pamEdit.getPartidaBienLargaD());
               pa.setSpanVEspe(pamEdit.getValorEspeLargaD());
               pa.setSpanOInstitu(pamEdit.getValorOtrasLargaD());
               programaAnualFacade.create(pa);
           }
        }
        obtenerTotal();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEsp').innerHTML ='" + totalValEspePerInversion.toString() + "'"); 
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspOtr').innerHTML ='" + totalValOtrosPerInversion.toString() + "'"); 
        
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspBienSer').innerHTML ='" + totalValEspeBienesServicios.toString() + "'"); 
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspOtrBienSer').innerHTML ='" + totalValOtrosBienesServicios.toString() + "'"); 
        
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspObrasP').innerHTML ='" + totalValEspeObrasPublicas.toString() + "'"); 
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspOtrObrasP').innerHTML ='" + totalValOtrosObrasPublicas.toString() + "'"); 
        
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspGastI').innerHTML ='" + totalValEspeOtrosGastos.toString() + "'"); 
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValOtrasGastI').innerHTML ='" + totalValOtrosOtrosGastos.toString() + "'"); 
        
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValEspLarD').innerHTML ='" + totalValEspeBienesLargaDuracion.toString() + "'"); 
        context.execute("document.getElementById('formPrincipal:formPrincipal1:tabP:dtProPre:totValOtrLargD').innerHTML ='" + totalValOtrosBienesLargaDuracion.toString() + "'"); 

    }
    public void onRowCancelP1(RowEditEvent event) {
    }
    /*
    
    */
    public void obtenerTotal(){
        BigDecimal total = BigDecimal.ZERO;
        
        totalValEspePerInversion = BigDecimal.ZERO;
        totalValEspeBienesServicios = BigDecimal.ZERO;
        totalValEspeObrasPublicas = BigDecimal.ZERO;
        totalValEspeOtrosGastos = BigDecimal.ZERO;
        totalValEspeBienesLargaDuracion = BigDecimal.ZERO;
        
        totalValOtrosPerInversion = BigDecimal.ZERO;
        totalValOtrosBienesServicios = BigDecimal.ZERO;
        totalValOtrosObrasPublicas = BigDecimal.ZERO;
        totalValOtrosOtrosGastos = BigDecimal.ZERO;
        totalValOtrosBienesLargaDuracion = BigDecimal.ZERO;
        
        
        for (int i = 0; i < programacionAnualMesList.size(); i++) {
            ProgramacionAnualMes pam = programacionAnualMesList.get(i);
            total = BigDecimal.ZERO;
            //GASTOS EN PERSONAL PARA INVERSION
            if(pam.getValorEspe() !=null && pam.getValorOtras() != null){
                total = total.add(pam.getValorEspe().add(pam.getValorOtras()));
                totalValEspePerInversion = totalValEspePerInversion.add(pam.getValorEspe());
                totalValOtrosPerInversion = totalValOtrosPerInversion.add(pam.getValorOtras());
                //totalValEspeBienesServicios = totalValEspeBienesServicios.add(pam.getValorEspe());
            }
            //BIENES Y SERVICIOS PARA INVERSION
            if(pam.getValorEspeBienSer() != null && pam.getValorOtrasBienSer() != null){
                total = total.add(pam.getValorEspeBienSer().add(pam.getValorOtrasBienSer()));
                totalValEspeBienesServicios = totalValEspeBienesServicios.add(pam.getValorEspeBienSer());
                totalValOtrosBienesServicios = totalValOtrosBienesServicios.add(pam.getValorOtrasBienSer());
            }
            //OBRAS PUBLICAS
            if(pam.getValorEspeObrasP() != null && pam.getValorOtrasObrasP() != null){
                total = total.add(pam.getValorEspeObrasP().add( pam.getValorOtrasObrasP()));
                totalValEspeObrasPublicas = totalValEspeObrasPublicas.add(pam.getValorEspeObrasP());
                totalValOtrosObrasPublicas = totalValOtrosObrasPublicas.add(pam.getValorOtrasObrasP());
            }
            //OTROS GASTOS DE INVERSION
            if(pam.getValorEspeGastosIn() != null && pam.getValorOtrasGastosIn() != null){
                total = total.add(pam.getValorEspeGastosIn().add(pam.getValorOtrasGastosIn()));
                totalValEspeOtrosGastos = totalValEspeOtrosGastos.add(pam.getValorEspeGastosIn());
                totalValOtrosOtrosGastos = totalValOtrosOtrosGastos.add(pam.getValorOtrasGastosIn());
            }
            //BIENES DE LARGA DURACION
            if(pam.getValorEspeLargaD() != null && pam.getValorOtrasLargaD() != null){
                total = total.add(pam.getValorEspeLargaD().add(pam.getValorOtrasLargaD()));
                totalValEspeBienesLargaDuracion = totalValEspeBienesLargaDuracion.add(pam.getValorEspeLargaD());
                totalValOtrosBienesLargaDuracion = totalValOtrosBienesLargaDuracion.add(pam.getValorOtrasLargaD());
            }
            pam.setTotal(total);
            programacionAnualMesList.set(i, pam);
        }
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

    //Tab 1
    public List<ProgramacionAnualMes> getProgramacionAnualMesList() {
        return programacionAnualMesList;
    }

    public void setProgramacionAnualMesList(List<ProgramacionAnualMes> programacionAnualMesList) {
        this.programacionAnualMesList = programacionAnualMesList;
    }

    public BigDecimal getTotalInversion() {
        return totalInversion;
    }

    public void setTotalInversion(BigDecimal totalInversion) {
        this.totalInversion = totalInversion;
    }

    public BigDecimal getTotalBienesServicios() {
        return totalBienesServicios;
    }

    public void setTotalBienesServicios(BigDecimal totalBienesServicios) {
        this.totalBienesServicios = totalBienesServicios;
    }



    public BigDecimal getTotalObrasPublicas() {
        return totalObrasPublicas;
    }

    public void setTotalObrasPublicas(BigDecimal totalObrasPublicas) {
        this.totalObrasPublicas = totalObrasPublicas;
    }

    public BigDecimal getTotalOtrosGastos() {
        return totalOtrosGastos;
    }

    public void setTotalOtrosGastos(BigDecimal totalOtrosGastos) {
        this.totalOtrosGastos = totalOtrosGastos;
    }

    public BigDecimal getTotalBienesLargaDuracion() {
        return totalBienesLargaDuracion;
    }

    public void setTotalBienesLargaDuracion(BigDecimal totalBienesLargaDuracion) {
        this.totalBienesLargaDuracion = totalBienesLargaDuracion;
    }


    
    public List<VResponsablesProyecto> getResponsableFormatoList() {
        return responsableFormatoList;
    }

    public void setResponsableFormatoList(List<VResponsablesProyecto> responsableFormatoList) {
        this.responsableFormatoList = responsableFormatoList;
    }
    public BigDecimal getTotalValEspeBienesServicios() {
        return totalValEspeBienesServicios;
    }

    public void setTotalValEspeBienesServicios(BigDecimal totalValEspeBienesServicios) {
        this.totalValEspeBienesServicios = totalValEspeBienesServicios;
    }

    public BigDecimal getTotalValEspeObrasPublicas() {
        return totalValEspeObrasPublicas;
    }

    public void setTotalValEspeObrasPublicas(BigDecimal totalValEspeObrasPublicas) {
        this.totalValEspeObrasPublicas = totalValEspeObrasPublicas;
    }

    public BigDecimal getTotalValEspeOtrosGastos() {
        return totalValEspeOtrosGastos;
    }

    public void setTotalValEspeOtrosGastos(BigDecimal totalValEspeOtrosGastos) {
        this.totalValEspeOtrosGastos = totalValEspeOtrosGastos;
    }

    public BigDecimal getTotalValEspeBienesLargaDuracion() {
        return totalValEspeBienesLargaDuracion;
    }

    public void setTotalValEspeBienesLargaDuracion(BigDecimal totalValEspeBienesLargaDuracion) {
        this.totalValEspeBienesLargaDuracion = totalValEspeBienesLargaDuracion;
    }

    public BigDecimal getTotalValOtrosPerInversion() {
        return totalValOtrosPerInversion;
    }

    public void setTotalValOtrosPerInversion(BigDecimal totalValOtrosPerInversion) {
        this.totalValOtrosPerInversion = totalValOtrosPerInversion;
    }

    

    public BigDecimal getTotalValOtrosBienesServicios() {
        return totalValOtrosBienesServicios;
    }

    public void setTotalValOtrosBienesServicios(BigDecimal totalValOtrosBienesServicios) {
        this.totalValOtrosBienesServicios = totalValOtrosBienesServicios;
    }

    public BigDecimal getTotalValOtrosObrasPublicas() {
        return totalValOtrosObrasPublicas;
    }

    public void setTotalValOtrosObrasPublicas(BigDecimal totalValOtrosObrasPublicas) {
        this.totalValOtrosObrasPublicas = totalValOtrosObrasPublicas;
    }

    public BigDecimal getTotalValOtrosBienesLargaDuracion() {
        return totalValOtrosBienesLargaDuracion;
    }

    public void setTotalValOtrosBienesLargaDuracion(BigDecimal totalValOtrosBienesLargaDuracion) {
        this.totalValOtrosBienesLargaDuracion = totalValOtrosBienesLargaDuracion;
    }
    public BigDecimal getTotalValEspePerInversion() {
        return totalValEspePerInversion;
    }

    public void setTotalValEspePerInversion(BigDecimal totalValEspePerInversion) {
        this.totalValEspePerInversion = totalValEspePerInversion;
    }

    public BigDecimal getTotalValOtrosOtrosGastos() {
        return totalValOtrosOtrosGastos;
    }

    public void setTotalValOtrosOtrosGastos(BigDecimal totalValOtrosOtrosGastos) {
        this.totalValOtrosOtrosGastos = totalValOtrosOtrosGastos;
    }
//</editor-fold>
    
}
