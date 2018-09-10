/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.ProgramacionAnualMes;
import ec.edu.espe_ctt_investigacion.entity.SeaAnio;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupNotasc;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupuestoC;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc;
import ec.edu.espe_ctt_investigacion.entity.VResponsablesProyecto;
import ec.edu.espe_ctt_investigacion.session.SeaAnioFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProyFacade;
import ec.edu.espe_ctt_investigacion.session.CronogramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaPresupNotascFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaAnualFacade;
import ec.edu.espe_ctt_investigacion.session.SeaRecursosConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTotalPresupAnualFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTotalPresupncFacade;
import ec.edu.espe_ctt_investigacion.session.VResponsablesProyectoFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class PresupuestoNotaConceptualController {

    private SegUsuario usuario;

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ///Variables Seleccion Convocatoria
    private boolean botonInicio = true;
    private boolean habilitaTab = true;

    @EJB
    private SeaDatGeneralProyFacade datGenProyectoFacade;
    private SeaDatGeneralProy datGenProySelected;
    private List<SeaDatGeneralProy> datGenProyList;

    @EJB
    private SeaFormatoLargoFacade formatoLargoFacade;
    private List<SeaFormatoLargo> formatoLargoList;
    private SeaFormatoLargo formatoLargoSelected;

///Variables tab1
    @EJB
    private SeaProgramaAnualFacade programaAnualFacade;
    private List<ProgramacionAnualMes> programacionAnualMesList;

    @EJB
    private SeaAnioFacade anioFacade;
    private List<SeaAnio> anioList;

    @EJB
    private SeaPresupNotascFacade presupuestoNotasCFacade;
    private List<SeaPresupNotasc> presupuestoNotasCList;
    private SeaPresupNotasc presupuestoNotasC;
    private SeaPresupNotasc presupuestoNotasCSelected;

    @EJB
    private SeaTotalPresupncFacade totalPresupuestoNCFacade;
    private List<SeaTotalPresupnc> totalPresupuestoNCList;

    @EJB
    private SeaRecursosConvocaFacade parametrosDetFacade;
    private List<SeaRecursosConvoca> tipoRecursoList;

    private String anio = "";
    private String rubro = "";
    private String tipoRecurso = "";
    private String valorEspe = "";
    private String valorOtros = "";
    private String valorTotal = "";
    private Date fechActual;

    private BigDecimal[] totalRecFisicos = new BigDecimal[3];
    private BigDecimal[] totalRecHumanos = new BigDecimal[3];
    private BigDecimal[] totalRecLogisticos = new BigDecimal[3];
    private BigDecimal[] totalRecursos = new BigDecimal[3];

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

    public String inicioNotaConceptual() {
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
        cargaDatosNotasConceptuales();
        return "";
    }

    /////////////Funciones
    void checkIngreso() {
//        formatoLargoList = formatoLargoFacade.findAll();
        datGenProyList = datGenProyectoFacade.findDatGenProyByCodUsu(usuario.getUsuId());

    }

    public void cargaDatosNotasConceptuales() {

        //tab1        
        presupuestoNotasCList = presupuestoNotasCFacade.findPresupuestoNotasCByProyId(datGenProySelected.getDatgeproyId());
        anioList = anioFacade.findAll();
        tipoRecursoList = parametrosDetFacade.findTipoRecurso();

        totalPresupuestoNCList = totalPresupuestoNCFacade.findTotalPresupuestoByProyId(datGenProySelected.getDatgeproyId());

        obtenerSubTotal();
//        programacionAnualMesList = programaAnualFacade.findMesAndProgramaAnual(formatoLargoSelected.getSflId());
//        totalPres = new SeaTotalPresupAnual();
//        obtenerTotal();
        //totalPres = totalPresuFacade.
    }

    public String agregarP1() {
        controlGrabarP1 = true;
        return "";
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;

        anio = anio.trim();
        rubro = rubro.trim();
        tipoRecurso = tipoRecurso.trim();
        valorEspe = valorEspe.trim();
        valorOtros = valorOtros.trim();

        if (anio.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (rubro.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (tipoRecurso.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (valorEspe.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (valorOtros.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (!(valorOtros.isEmpty() && valorOtros.isEmpty())) {
            int total = Integer.parseInt(valorEspe) + Integer.parseInt(valorOtros);
            valorTotal = Integer.toString(total);
        }
        return validaVaciosP1;
    }

    public void cancelarP1() {
        //inicializar variables de entrada
        controlGrabarP1 = false;
        validaVaciosP1 = true;
        presupuestoNotasC = null;
        anio = "";
        rubro = "";
        tipoRecurso = "";
        valorEspe = "";
        valorOtros = "";
        valorTotal = "";
        validaVaciosP1 = true;

    }

    public String registraP1() {
        System.out.println("registro");

        if (presupuestoNotasC == null) {
            fechActual = new Date();
            SeaAnio an = new SeaAnio(new BigDecimal(anio));
            SeaRecursosConvoca rec = new SeaRecursosConvoca(new BigDecimal(tipoRecurso));
            presupuestoNotasC = new SeaPresupNotasc();
            presupuestoNotasC.setDatgeproyId(datGenProySelected);
            presupuestoNotasC.setSaniId(an);
            presupuestoNotasC.setSpncRubro(rubro);
            presupuestoNotasC.setSrcId(rec);
            presupuestoNotasC.setSpncEspe(new BigDecimal(valorEspe));
            presupuestoNotasC.setSpncOtros(new BigDecimal(valorOtros));
            presupuestoNotasC.setSpncTotal(new BigDecimal(valorTotal));
            presupuestoNotasC.setSpncFechaCrea(fechActual);
            presupuestoNotasCFacade.create(presupuestoNotasC);

            presupuestoNotasCList = presupuestoNotasCFacade.findPresupuestoNotasCByProyId(datGenProySelected.getDatgeproyId());

        }
        obtenerSubTotal();
        cancelarP1();
        return "";
    }

    public void onRowEditP1(RowEditEvent event) {

        SeaPresupNotasc preEdit = new SeaPresupNotasc();

        preEdit = (SeaPresupNotasc) event.getObject();

        if (!(preEdit.getSpncEspe() == null && preEdit.getSpncOtros() == null)) {
            BigDecimal total = preEdit.getSpncEspe().add(preEdit.getSpncOtros());
            preEdit.setSpncTotal(total);
        }

        presupuestoNotasCFacade.edit(preEdit);
        obtenerSubTotal();

    }

    public void onRowCancelP1(RowEditEvent event) {

    }

    public void eliminarP1() {
        if (presupuestoNotasCSelected != null) {
            SeaPresupNotasc eliminar = null;
            for (int i = 0; i < presupuestoNotasCList.size(); i++) {
                SeaPresupNotasc elemento = this.presupuestoNotasCList.get(i);
                if (presupuestoNotasCSelected.getSpncId() == presupuestoNotasCList.get(i).getSpncId()) {
                    eliminar = elemento;
                    break;
                }
            }
            if (eliminar != null) {
                this.presupuestoNotasCList.remove(eliminar);
                presupuestoNotasCFacade.remove(eliminar);
            }
        }
    }

    public void obtenerSubTotal() {
        totalRecFisicos[0] = BigDecimal.ZERO;
        totalRecFisicos[1] = BigDecimal.ZERO;
        totalRecFisicos[2] = BigDecimal.ZERO;
        totalRecHumanos[0] = BigDecimal.ZERO;
        totalRecHumanos[1] = BigDecimal.ZERO;
        totalRecHumanos[2] = BigDecimal.ZERO;
        totalRecLogisticos[0] = BigDecimal.ZERO;
        totalRecLogisticos[1] = BigDecimal.ZERO;
        totalRecLogisticos[2] = BigDecimal.ZERO;
        totalRecursos[0] = BigDecimal.ZERO;
        totalRecursos[1] = BigDecimal.ZERO;
        totalRecursos[2] = BigDecimal.ZERO;

        totalPresupuestoNCFacade.deleteTotalPresupuestoByProyId(datGenProySelected.getDatgeproyId());
        totalPresupuestoNCList = new ArrayList<>();//totalPresupuestoNCFacade.findTotalPresupuestoByProyId(datGenProySelected.getDatgeproyId());
        
        for (int i = 0; i < presupuestoNotasCList.size(); i++) {
            SeaPresupNotasc prep = presupuestoNotasCList.get(i);

            SeaTotalPresupnc totalNC = new SeaTotalPresupnc();
            totalNC.setDatgeproyId(datGenProySelected);
            totalNC.setSaniId(prep.getSaniId());
            totalNC.setSrcId(prep.getSrcId());


            System.out.println("proy id:" + prep.getDatgeproyId().getDatgeproyId() + " anio: " + prep.getSaniId().getSaniDetalle() + " rubro: " + prep.getSrcId().getSrcNombre());

            System.out.println("totalPresupuestoNCList.indexOf(totalNC): " + totalPresupuestoNCList.indexOf(totalNC));
            if (totalPresupuestoNCList.contains(totalNC)) {
                totalNC = totalPresupuestoNCList.get(totalPresupuestoNCList.indexOf(totalNC));
                BigDecimal totalEspe = BigDecimal.ZERO;
                totalEspe = totalNC.getStpnTotalEspe();
                System.out.println("totalEspe:" + totalEspe);

                totalEspe = totalEspe.add(prep.getSpncEspe());
                System.out.println("inc totalEspe:" + totalEspe);

                BigDecimal totalOtros = totalNC.getStpnTotalOtros();
                totalOtros = totalOtros.add(prep.getSpncOtros());
                totalNC.setStpnTotalEspe(totalEspe);
                totalNC.setStpnTotalOtros(totalOtros);
                
                System.out.println("totalNC.getStpnTotalEspe() : " + totalNC.getStpnTotalEspe());
                totalPresupuestoNCFacade.edit(totalNC);
                totalPresupuestoNCList.set(totalPresupuestoNCList.indexOf(totalNC), totalNC);

            } else {
                totalNC.setStpnTotalEspe(prep.getSpncEspe());
                totalNC.setStpnTotalOtros(prep.getSpncOtros());
                totalPresupuestoNCFacade.create(totalNC);
                totalPresupuestoNCList.add(totalNC);
            }

            if (prep.getSrcId().getSrcId().equals(BigDecimal.valueOf(1))) {
                totalRecFisicos[0] = totalRecFisicos[0].add(prep.getSpncEspe());
                totalRecFisicos[1] = totalRecFisicos[1].add(prep.getSpncOtros());
                totalRecFisicos[2] = totalRecFisicos[2].add(prep.getSpncTotal());
            }
            if (prep.getSrcId().getSrcId().equals(BigDecimal.valueOf(2))) {
                totalRecHumanos[0] = totalRecHumanos[0].add(prep.getSpncEspe());
                totalRecHumanos[1] = totalRecHumanos[1].add(prep.getSpncOtros());
                totalRecHumanos[2] = totalRecHumanos[2].add(prep.getSpncTotal());
            }
            if (prep.getSrcId().getSrcId().equals(BigDecimal.valueOf(3))) {
                totalRecLogisticos[0] = totalRecLogisticos[0].add(prep.getSpncEspe());
                totalRecLogisticos[1] = totalRecLogisticos[1].add(prep.getSpncOtros());
                totalRecLogisticos[2] = totalRecLogisticos[2].add(prep.getSpncTotal());
            }

        }

    }

    public String obtenerRubro(BigDecimal codRecurso, int campo) {

        String res = "";

        if (codRecurso.equals(BigDecimal.valueOf(1))) {
            res = totalRecFisicos[campo].toString();
        } else if (codRecurso.equals(BigDecimal.valueOf(2))) {
            res = totalRecHumanos[campo].toString();
        } else if (codRecurso.equals(BigDecimal.valueOf(3))) {
            res = totalRecLogisticos[campo].toString();
        }
        return res;
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

    public SeaDatGeneralProy getDatGenProySelected() {
        return datGenProySelected;
    }

    public void setDatGenProySelected(SeaDatGeneralProy datGenProySelected) {
        this.datGenProySelected = datGenProySelected;
    }

    public List<SeaDatGeneralProy> getDatGenProyList() {
        return datGenProyList;
    }

    public void setDatGenProyList(List<SeaDatGeneralProy> datGenProyList) {
        this.datGenProyList = datGenProyList;
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
    public List<SeaAnio> getAnioList() {
        return anioList;
    }

    public void setAnioList(List<SeaAnio> anioList) {
        this.anioList = anioList;
    }

    public List<SeaPresupNotasc> getPresupuestoNotasCList() {
        return presupuestoNotasCList;
    }

    public void setPresupuestoNotasCList(List<SeaPresupNotasc> presupuestoNotasCList) {
        this.presupuestoNotasCList = presupuestoNotasCList;
    }

    public SeaPresupNotasc getPresupuestoNotasCSelected() {
        return presupuestoNotasCSelected;
    }

    public void setPresupuestoNotasCSelected(SeaPresupNotasc presupuestoNotasCSelected) {
        this.presupuestoNotasCSelected = presupuestoNotasCSelected;
    }

    public List<SeaRecursosConvoca> getTipoRecursoList() {
        return tipoRecursoList;
    }

    public void setTipoRecursoList(List<SeaRecursosConvoca> tipoRecursoList) {
        this.tipoRecursoList = tipoRecursoList;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getValorEspe() {
        return valorEspe;
    }

    public void setValorEspe(String valorEspe) {
        this.valorEspe = valorEspe;
    }

    public String getValorOtros() {
        return valorOtros;
    }

    public void setValorOtros(String valorOtros) {
        this.valorOtros = valorOtros;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal[] getTotalRecFisicos() {
        return totalRecFisicos;
    }

    public void setTotalRecFisicos(BigDecimal[] totalRecFisicos) {
        this.totalRecFisicos = totalRecFisicos;
    }

    public BigDecimal[] getTotalRecHumanos() {
        return totalRecHumanos;
    }

    public void setTotalRecHumanos(BigDecimal[] totalRecHumanos) {
        this.totalRecHumanos = totalRecHumanos;
    }

    public BigDecimal[] getTotalRecLogisticos() {
        return totalRecLogisticos;
    }

    public void setTotalRecLogisticos(BigDecimal[] totalRecLogisticos) {
        this.totalRecLogisticos = totalRecLogisticos;
    }

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
    public Date getFechActual() {
        return fechActual;
    }

    public void setFechActual(Date fechActual) {
        this.fechActual = fechActual;
    }

//</editor-fold>

    
}
