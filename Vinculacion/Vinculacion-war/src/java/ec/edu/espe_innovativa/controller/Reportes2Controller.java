/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import com.lowagie.text.PageSize;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.session.StvcampFacade;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.saturno.session.StvsubjFacade;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.AspectoEvaluacionFinal;
import ec.edu.espe_ctt.vinculacion.entity.AvanceActividad;
import ec.edu.espe_ctt.vinculacion.entity.CarreraProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Cobertura;
import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.DepartamentoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Estado;
import ec.edu.espe_ctt.vinculacion.entity.LineaInvestigacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.PresupuestoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ProyectoReporte;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
//import ec.edu.espe_ctt.vinculacion.entity.TipoPoblacionBeneficiaria;
import ec.edu.espe_ctt.vinculacion.entity.TipoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionParametrosEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ResponsableProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.session.SeaCantonFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParroquiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import ec.edu.espe_innovativa.util.DynamicColumnDataSource;
import ec.edu.espe_innovativa.util.DynamicReportBuilder2;
import ec.edu.espe_innovativa.util.JasperReportUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.primefaces.event.data.SortEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class Reportes2Controller implements Serializable {

    private TreeNode opcionesMenu;
    private TreeNode opcionMenuSelected;
    private List<ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacionList;
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    @EJB
    private ConfiguracionParametrosEvaluacionFacade configuracionParametrosEvaluacionFacade;
    @EJB
    private StvsubjFacade departamentoFacade;
    @EJB
    private ProgramaFacade programaFacade;
    @EJB
    private StvmajrFacade carrerasFacade;
    @EJB
    private StvcampFacade sedesFacade;
    @EJB
    private SeaProvinciaFacade provinciasFacade;
    @EJB
    private SeaCantonFacade cantonesFacade;
    @EJB
    private SeaParroquiaFacade parroquiasFacade;

    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionSelected;
    private List<Stvsubj> departamentos;
    private List<Programa> programas;
    private List<Proyecto> proyectos;
    private List<Stvmajr> carreras;
    private List<Stvcamp> sedes;
    private List<SeaProvincia> provincias;
    private List<SeaCanton> cantones;
    private List<SeaParroquia> parroquias;

    private Date fechaDesde;
    private Date fechaHasta;
    private String codigoDepartamento;
    private String codigoCarrera;
    private Integer codigoPrograma;
    private String codigoSede;
    private String codigoReporte;

    public Reportes2Controller() {
    }

    @PostConstruct
    public void init() {
        /*this.codigoCarrera = "";
        this.codigoDepartamento = "";
        this.codigoPrograma = 0;
        this.codigoSede = "";
        this.codigoReporte = "1";*/
        tipoReporte = 0;
        this.departamentos = departamentoFacade.findAll();
        this.programas = programaFacade.findXEstado("");
        this.carreras = carrerasFacade.findAll();
        this.sedes = sedesFacade.findAll();
        this.provincias = provinciasFacade.findAll();
        this.cantones = cantonesFacade.findAll();
        this.parroquias = parroquiasFacade.findAll();
        this.proyectos = proyectoFacade.findAll();
        tipoProyectoList = new ArrayList<>();
        tipoProyectoList.add(new TipoProyecto("C", "Gasto Permanente"));
        tipoProyectoList.add(new TipoProyecto("I", "Gasto No Permanente"));

        coberturaList = parametrosDetFacade.findByCodigoParametroActivos(SeaParametros.PARAM_COBERTURA);  
        docenteList = responsableProyectoFacade.findDocenteParticipante();
        estudianteList = responsableProyectoFacade.findParticipante(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);

        estadoList = parametrosDetFacade.findByCodigoParametroActivos(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
        tipoPoblacionBeneficiariaList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_POBLACION);

        visualizarPrograma = true;
        visualizarCodigoProyecto = true;
        visualizarEstado = true;
        visualizarTipoProyecto = true;
        visualizarDirector = true;
        visualizarCampus = true;
        visualizarDepartamento = true;
        visualizarFechaInicio = true;
        visualizarFechaFinalizacion = true;
        //inicializarOpcionesMenu();
    }

    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacionSelected() {
        return configuracionParametrosEvaluacionSelected;
    }

    public void setConfiguracionParametrosEvaluacionSelected(ConfiguracionParametrosEvaluacion ConfiguracionParametrosEvaluacionSelected) {
        this.configuracionParametrosEvaluacionSelected = ConfiguracionParametrosEvaluacionSelected;
    }

    public List<ConfiguracionParametrosEvaluacion> getConfiguracionParametrosEvaluacionList() {
        return configuracionParametrosEvaluacionList;
    }

    public void setConfiguracionParametrosEvaluacionList(List<ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacionList) {
        this.configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionList;
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

    public String getOpcionMenuCodeSelected() {
        if (opcionMenuSelected != null) {
            return ((OpcionMenu) opcionMenuSelected.getData()).getCodigo();
        } else {
            return "";
        }
    }

    @EJB
    private ProyectoFacade proyectoFacade;

    public void inicializarOpcionesMenu() {
        opcionesMenu = new DefaultTreeNode("Root", null);
        TreeNode node1 = new DefaultTreeNode(new OpcionMenu("1", "1. Proyectos pendientes de evaluación por Consejo Académico"), opcionesMenu);
        TreeNode node2 = new DefaultTreeNode(new OpcionMenu("2", "2. Proyectos aprobados por Comisión de Evaluación"), opcionesMenu);
        TreeNode node3 = new DefaultTreeNode(new OpcionMenu("3", "3. Reportes Generales Programas"), opcionesMenu);
        TreeNode node4 = new DefaultTreeNode(new OpcionMenu("4", "4. Reportes Generales Proyectos"), opcionesMenu);
    }

    /*public void onMenuSelect(NodeSelectEvent event) {
        initVariables();
        OpcionMenu opcionMenu = (OpcionMenu) opcionMenuSelected.getData();

        switch (opcionMenu.getCodigo()) {
            case "1":
                generarReporteProyAprobacionConsejoAcadémico();
                break;
            case "2":
                initReporteProyAprobadosComisionEvaluacion();
                break;
            case "4":
                initReporteProyectos();
        }
    }*/

    private void initVariables() {
        estado = "";
        provincia = null;
        canton = null;
        parroquia = null;
        codigoCarrera = null;
        codigoDepartamento = null;
        codigoPrograma = null;
        codigoSede = null;
        fechaDesde = null;
        fechaHasta = null;
        codigoReporte = "1";
    }

    private List<Proyecto> proyectoList;

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    private List<String> cols;
    private List<ValoracionParametroEvaluacion> cols2;

    public List<ValoracionParametroEvaluacion> getCols2() {
        return cols2;
    }

    public void setCols2(List<ValoracionParametroEvaluacion> cols2) {
        this.cols2 = cols2;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }
    
    
    public List<String> getCols() {
        /*List<String> cols = new ArrayList<>();
         if (proyectoList!=null && !proyectoList.isEmpty()){
         for (ParametroEvaluacion par : proyectoList.get(0).getConfiguracionParametrosEvaluacion().getParametroEvaluacionList()) {
         cols.add(par.getDescripcion());
         }
         }
         cols.add("TOTAL");*/
        return cols;
    }

    private Map<String, Integer> colsSpan;

    public void setColsSpan(Map<String, Integer> colsSpan) {
        this.colsSpan = colsSpan;
    }

    public Map<String, Integer> getColsSpan() {
        /*Map<String, Integer> m= new HashMap<>();
         for (String col : getCols()) {
         m.put(col, 3);
         }*/
        return colsSpan;
    }
    private Integer colspanParametrosEvaluacion;

    public void setColspanParametrosEvaluacion(Integer colspanParametrosEvaluacion) {
        this.colspanParametrosEvaluacion = colspanParametrosEvaluacion;
    }

    public Integer getColspanParametrosEvaluacion() {
        /*int cont = 0;
        if (configuracionParametrosEvaluacionSelected == null) {
            return 0;
        }
        for (ParametroEvaluacion par : configuracionParametrosEvaluacionSelected.getParametroEvaluacionList()) {
            cont = cont + par.getValoracionList().size();
        }
        return cont + 1;*/
        return colspanParametrosEvaluacion;
    }

    /*public void generarReporteProyAprobadosComisionEvaluacion() {
        proyectoList = proyectoFacade.findByEstadoAprobadoComisionVinculacion(estado);
        colsSpan = new HashMap<>();
        cols = new ArrayList<>();
        cols2 = new ArrayList<>();
        colspanParametrosEvaluacion = 0;
        if (proyectoList != null && !proyectoList.isEmpty()) {
            for (ParametroEvaluacion par : proyectoList.get(0).getConfiguracionParametrosEvaluacion().getParametroEvaluacionList()) {
                cols.add(par.getDescripcion());
                colsSpan.put(par.getDescripcion(), par.getValoracionList().size());
                colspanParametrosEvaluacion = colspanParametrosEvaluacion + par.getValoracionList().size();
                for (ValoracionParametroEvaluacion val : par.getValoracionList()) {
                    cols2.add(val);
                }
            }
        }
        colspanParametrosEvaluacion = colspanParametrosEvaluacion + 3;
        //cols.add("TOTAL");
    }*/

    /*public void initReporteProyAprobadosComisionEvaluacion() {
        configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionFacade.findXProyAprobadoComisionVinculacion();
        if (!configuracionParametrosEvaluacionList.isEmpty()) {
            configuracionParametrosEvaluacionSelected = configuracionParametrosEvaluacionList.get(0);
        }
    }*/

    /*public String generarReporteProyAprobacionConsejoAcadémico() {
        proyectoList = proyectoFacade.findByPorAutorizarConsejoAcadémico();
        return "";
    }*/

//<editor-fold defaultstate="collapsed" desc="Reportes de Programas">
    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Integer getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(Integer codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public List<Stvsubj> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Stvsubj> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public List<Stvmajr> getCarrerasPrograma() {
        return carreras;
    }

    public void setCarrerasPrograma(List<Stvmajr> carrerasPrograma) {
        this.carreras = carrerasPrograma;
    }

    public List<Stvmajr> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Stvmajr> carreras) {
        this.carreras = carreras;
    }

    public List<Stvcamp> getSedes() {
        return sedes;
    }

    public void setSedes(List<Stvcamp> sedes) {
        this.sedes = sedes;
    }

    public List<SeaProvincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<SeaProvincia> provincias) {
        this.provincias = provincias;
    }

    public String getCodigoReporte() {
        return codigoReporte;
    }

    public void setCodigoReporte(String codigoReporte) {
        this.codigoReporte = codigoReporte;
    }

    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private SeaProvincia provincia;
    private SeaCanton canton;
    private SeaParroquia parroquia;

    public SeaProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(SeaProvincia provincia) {
        this.provincia = provincia;
    }

    public SeaCanton getCanton() {
        return canton;
    }

    public void setCanton(SeaCanton canton) {
        this.canton = canton;
    }

    public SeaParroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(SeaParroquia parroquia) {
        this.parroquia = parroquia;
    }

    public void seleccionarProvincia() {
        canton = null;
        parroquia = null;
    }

    /*public void generarReporteProgramas(String tipo) {
        if (this.codigoReporte.equals("1")) {
            generarReporteProgramasAnio(tipo);
        } else if (this.codigoReporte.equals("2")) {
            generarReporteAvancePrograma(tipo);
        } else if (this.codigoReporte.equals("3")) {
            generarReporteEvaluacionPrograma(tipo);
        } else if (this.codigoReporte.equals("4")) {
            generarReporteResultadosPrograma(tipo);
        }
    }*/

    /*private void generarReporteProgramasAnio(String tipoReporte) {
        try {
            //prepararParametrosProgramas();
            programaList = programaFacade.findXCampos(fechaDesde, fechaHasta, codigoPrograma, estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROGRAMA_ANIO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, programaList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteAvancePrograma(String tipoReporte) {
        try {
            prepararParametrosProgramas();
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_AVANCE_PROGRAMA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteEvaluacionPrograma(String tipoReporte) {
        try {
            generarReporteEvaluacionPrograma();
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_EVALUACION_PROGRAMA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, programaList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteResultadosPrograma(String tipoReporte) {
        try {
            programaList = programaFacade.findXCampos(fechaDesde, fechaHasta, codigoPrograma, estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_RESULTADOS_PROGRAMA, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, programaList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    List<Programa> programaList;

    /*private void generarReporteEvaluacionPrograma() {
        programaList = programaFacade.findXCampos(fechaDesde, fechaHasta, codigoPrograma, estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede);
        for (Programa prog : programaList) {
            for (Proyecto proy : prog.getProyectoActivoList()) {
                if (proy.getEvaluacionFinal() == null) {
                    proy.addEvaluacionFinal(new EvaluacionFinalProyecto());
                }
                if (proy.getConfiguracionParametrosEvaluacionFinal() == null) {
                    proy.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
                }
                if (proy.getConfiguracionParametrosEvaluacionFinal() != null) {
                    for (ParametroEvaluacionFinalCabecera cab : proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraList()) {
                        if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                            for (ObjetivoPrograma obj : proy.getObjetivoProyectoPadreList()) {
                                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                    for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                        cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                        for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                        }
                                    }
                                }
                            }
                        }
                        ParametroEvaluacion parametroEliminar = null;
                        for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                            if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                                    && proy.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                                    && par.getIdAspectoEvaluacion() != null
                                    && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                                parametroEliminar = par;
                            }
                            par.setProyecto(proy);
                            if (proy.getEvaluacionFinal().getId() != null) {
                                if (!cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                                    for (DetalleEvaluacionFinalProyecto det : proy.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                                        if (det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                            par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                            par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (parametroEliminar != null) {
                            cab.removeParametro(parametroEliminar);
                        }
                    }
                    proy.getConfiguracionParametrosEvaluacionFinal().initValoracion();
                }

            }
        }
    }*/

    private ParametroEvaluacion crearParametroEvaluacionMatrizMarcoLogico(ObjetivoPrograma obj) {
        ParametroEvaluacion par = new ParametroEvaluacion();
        par.setIdAspectoEvaluacion(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO);
        par.setObjetivoPrograma(obj);
        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
            par.setDescripcion("FIN: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
            par.setDescripcion("OBJETIVO GENERAL: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_COMPONENTE)) {
            par.setDescripcion("COMPONENTE: " + obj.getSvopObjetivoProy());
        } else {
            par.setDescripcion("ACTIVIDAD: " + obj.getSvopObjetivoProy());
        }

        for (int i = 0; i <= 5; i++) {
            ValoracionParametroEvaluacion val = new ValoracionParametroEvaluacion();
            val.setId(i);
            val.setDescripcion(String.valueOf(i));
            val.setPuntaje(i);
            par.addValoracion(val);
        }
        return par;
    }
    private Map<String, Object> parametros;

    /*private void prepararParametrosProgramas() {
        parametros = new HashMap<String, Object>();
        parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
        //parametros.put("as_hclinica", this.turnoSeleccionado.getDpaHclinica().getDpaHclinica());
        //parametros.put("simbologia", JasperReportUtil.PATHSIMBOLOGIA);
        //parametros.put("PATH", JasperReportUtil.PATH);
        parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
        parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
        if (codigoDepartamento == null) {
            parametros.put("codigoDepartamento", "");
        } else {
            parametros.put("codigoDepartamento", this.codigoDepartamento);
        }
        if (codigoCarrera == null) {
            parametros.put("codigoCarrera", "");
        } else {
            parametros.put("codigoCarrera", this.codigoCarrera);
        }
        parametros.put("fechaDesde", this.fechaDesde);
        parametros.put("fechaHasta", this.fechaHasta);
        if (codigoSede == null) {
            parametros.put("codigoSede", "");
        } else {
            parametros.put("codigoSede", this.codigoSede);
        }
        if (this.codigoPrograma == null || this.codigoPrograma == -1) {
            parametros.put("codigoPrograma", null);
        } else {
            parametros.put("codigoPrograma", this.codigoPrograma);
        }
        if (estado == null) {
            parametros.put("estado", "");
        } else {
            parametros.put("estado", this.estado);
        }
        if (provincia == null) {
            parametros.put("codigoProvincia", "");
        } else {
            parametros.put("codigoProvincia", this.provincia.getProId());
        }
        if (canton == null) {
            parametros.put("codigoCanton", "");
        } else {
            parametros.put("codigoCanton", this.canton.getCanId());
        }
        if (parroquia == null) {
            parametros.put("codigoParroquia", "");
        } else {
            parametros.put("codigoParroquia", this.parroquia.getPrqId());
        }
        //parametros.put("PATH_IMG_1", JasperReportUtil.PATHIMG);
    }*/

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Reportes de Proyectos"> 
    /*public void generarReporteProyectos(String tipo) {
        if (this.codigoReporte.equals("1")) {
            generarReporteAprobacionProyectos(tipo);
        } else if (this.codigoReporte.equals("2")) {
            generarReporteProyectosEjecutados(tipo);
        } else if (this.codigoReporte.equals("3")) {
            generarReporteDocentesProyectos(tipo);
        } else if (this.codigoReporte.equals("4")) {
            generarReporteEstudiantesProyectos(tipo);
        } else if (this.codigoReporte.equals("5")) {
            generarReporteBeneficiariosProyectos(tipo);
        } else if (this.codigoReporte.equals("6")) {
            generarReportePresupuestoProyectos(tipo);
        } else if (this.codigoReporte.equals("7")) {
            generarReporteAvanceProyectos(tipo);
        } else if (this.codigoReporte.equals("8")) {
            generarReporteEvaluacionProyectos(tipo);
        } else if (this.codigoReporte.equals("9")) {
            generarReporteResultadosProyectos(tipo);
        } else if (this.codigoReporte.equals("10")) {
            generarReporteCertificadosProyectos(tipo);
        }
    }*/
    /*private void generarReporteProyectosEjecutados(String tipoReporte) {
        try {
            prepararParametrosReporteProyectos();
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROYECTOS_EJECUTADOS, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteAprobacionProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findByAprobadoComisionVinculacion(programa, codigoProyecto, tipoProyecto, codigoCarrera, codigoDepartamento, cobertura, provincia, canton, parroquia, codigoSede);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_APROBACION_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    private Programa programa;
    private Integer codigoProyecto;
    @EJB
    private ResponsableProyectoFacade responsableProyectoFacade;

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void seleccionarCobertura() {
        provincia = null;
        canton = null;
        parroquia = null;
    }

    private List<SegUsuario> docenteList;
    private List<SegUsuario> estudianteList;
    private SegUsuario usuario;

    public List<SegUsuario> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<SegUsuario> estudianteList) {
        this.estudianteList = estudianteList;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public List<SegUsuario> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<SegUsuario> docenteList) {
        this.docenteList = docenteList;
    }

    /*private void initReporteProyectos() {
        cobertura = 0;
        docenteList = responsableProyectoFacade.findParticipante(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
        estudianteList = responsableProyectoFacade.findParticipante(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);
    }*/

    /*private void prepararParametrosReporteProyectos() {
        parametros = new HashMap<String, Object>();
        parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
        parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
        parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
        parametros.put("codigoDepartamento", codigoDepartamento == null ? "" : codigoDepartamento);
        parametros.put("codigoCarrera", codigoCarrera == null ? "" : codigoCarrera);
        parametros.put("fechaDesde", this.fechaDesde);
        parametros.put("fechaHasta", this.fechaHasta);
        parametros.put("codigoSede", codigoSede == null ? "" : codigoSede);
        parametros.put("codigoPrograma", codigoPrograma == null ? -1 : codigoPrograma);
        parametros.put("estado", estado == null ? "" : estado);
        parametros.put("codigoProvincia", provincia == null ? "" : provincia.getProId());
        parametros.put("codigoCanton", canton == null ? "" : canton.getCanId());
        parametros.put("codigoParroquia", parroquia == null ? "" : parroquia.getPrqId());
        parametros.put("tipoProyecto", tipoProyecto == null ? "" : tipoProyecto);
        parametros.put("cobertura", cobertura);

    }*/

    private String tipoProyecto;

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    private Integer cobertura;

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }

    /*private void generarReporteDocentesProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, usuario, null);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PARTICIPACION_DOCENTE, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteEstudiantesProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, usuario);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PARTICIPACION_ESTUDIANTE, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteBeneficiariosProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_BENEFICIARIOS_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReportePresupuestoProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);
            for (Proyecto proy : proyectoList) {
                proy.inicializarListadoPresupuestos();
            }

            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PRESUPUESTO_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generarReporteAvanceProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_AVANCE_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteEvaluacionProyecto() {
        proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);

        for (Proyecto proy : proyectoList) {
            if (proy.getEvaluacionFinal() == null) {
                proy.addEvaluacionFinal(new EvaluacionFinalProyecto());
            }
            if (proy.getConfiguracionParametrosEvaluacionFinal() == null) {
                proy.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
            }
            if (proy.getConfiguracionParametrosEvaluacionFinal() != null) {
                for (ParametroEvaluacionFinalCabecera cab : proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraList()) {
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                        for (ObjetivoPrograma obj : proy.getObjetivoProyectoPadreList()) {
                            if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                            } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                    for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                        cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                    }
                                }
                            }
                        }
                    }
                    ParametroEvaluacion parametroEliminar = null;
                    for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                        if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                                && proy.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                                && par.getIdAspectoEvaluacion() != null
                                && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                            parametroEliminar = par;
                        }
                        par.setProyecto(proy);
                        if (proy.getEvaluacionFinal().getId() != null) {
                            if (!cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                                for (DetalleEvaluacionFinalProyecto det : proy.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                                    if (det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                        par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                        par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (parametroEliminar != null) {
                        cab.removeParametro(parametroEliminar);
                    }
                }
                proy.getConfiguracionParametrosEvaluacionFinal().initValoracion();
            }

        }
    }*/

    /*private void generarReporteEvaluacionProyectos(String tipoReporte) {
        try {
            generarReporteEvaluacionProyecto();
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_EVALUACION_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteResultadosProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_RESULTADOS_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /*private void generarReporteCertificadosProyectos(String tipoReporte) {
        try {
            proyectoList = proyectoFacade.findXCampos(fechaDesde, fechaHasta, programa, codigoProyecto, tipoProyecto,
                    estado, codigoCarrera, codigoDepartamento, provincia, canton, parroquia, codigoSede, cobertura, null, null);
            parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);//JasperReportUtil.PATHIMG);
            parametros.put("dirPhoto", JasperReportUtil.PATHIMG + "banner_SSD.png");//JasperReportUtil.PATHIMG);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CERTIFICADOS_PROYECTO, tipoReporte.equals("PDF") ? JasperReportUtil.TIPO_PDF : (tipoReporte.equals("XLS") ? JasperReportUtil.TIPO_XLS : JasperReportUtil.TIPO_WORD), parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    //</editor-fold>    

    /*public void dynamicJasper() {
        try {

            FastReportBuilder drb = new FastReportBuilder();
            DynamicReport dr = drb.addColumn("State", "state", String.class.getName(), 30)
                    .addColumn("Branch", "branch", String.class.getName(), 30)
                    .addColumn("Product Line", "productLine", String.class.getName(), 50)
                    .addColumn("Item", "item", String.class.getName(), 50)
                    .addColumn("Item Code", "id", Long.class.getName(), 30, true)
                    .addColumn("Quantity", "quantity", Long.class.getName(), 60, true)
                    .addColumn("Amount", "amount", Float.class.getName(), 70, true)
                    .addGroups(2)
                    .setTitle("November 2006 sales report")
                    .setSubtitle("This report was generated at " + new Date())
                    .setPrintBackgroundOnOddRows(true)
                    .setUseFullPageWidth(true)
                    .build();

            //JRDataSource ds = new JRBeanCollectionDataSource(TestRepositoryProducts.getDummyCollection());
            JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
            JasperViewer.viewReport(jp);    //finally display the report report
        } catch (Exception e) {
        }
    }
    
    
     */
    public void runReport(List<String> columnHeaders, List<List<String>> rows) throws JRException {

        System.out.println("Loading the .jrxml");
        //InputStream is = getClass().getResourceAsStream("../../../DynamicColumns.jrxml");
        InputStream is = getClass().getResourceAsStream("../../../../../../../web/jrxml/DynamicColumns.jrxml");
        //InputStream is = getClass().getResourceAsStream(JasperReportUtil.PATH_REPORTE_DINAMICO);
        JasperDesign jasperReportDesign = JRXmlLoader.load(is);

        System.out.println("Adding the dynamic columns");
        DynamicReportBuilder2 reportBuilder = new DynamicReportBuilder2(jasperReportDesign, columnHeaders.size());
        reportBuilder.addDynamicColumns();

        System.out.println("Compiling the report");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperReportDesign);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("REPORT_TITLE", "Sample Dynamic Columns Report");
        DynamicColumnDataSource pdfDataSource = new DynamicColumnDataSource(columnHeaders, rows);
        System.out.println("Filling the report");

        //jasperPrint = JasperFillManager.fillReport(jasperReport, params, pdfDataSource);
        //System.out.println("Exporting the report to pdf");
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "/tmp/DynamicColumns.pdf");
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "E:/temp/DynamicColumns.pdf");
    }

    protected JasperPrint jp;
    protected JasperReport jr;
    protected Map params = new HashMap();
    protected DynamicReport dr;

    protected JRDataSource getDataSource() {
// Generate dummy data to show in the report.
        List records = new ArrayList();
        for (int i = 1; i < 10; i++) {

            Map columns = new HashMap();
            for (int j = 1; j <= 10; j++) {
// The HashMap Key must save with ColumnProperty Name
                columns.put("Column" + j, "Record " + i + " Column " + j + " data.");
            }
            records.add(columns);
        }
        JRDataSource ds = new JRMapCollectionDataSource(records);
        return ds;
    }

    public void buildReport() throws Exception {
        params.put("ReportTitle1", "Report Title");
        DynamicReportBuilder drb = new DynamicReportBuilder();
        Font font = new Font(10, "Sarif", true);
        Style headerStyle = new Style();
        headerStyle.setFont(font);
        headerStyle.setHorizontalAlign(HorizontalAlign.LEFT);
        headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
        font = new Font(8, "Sarif", false);
        Style detailStyle = new Style();
        detailStyle.setFont(font);
        detailStyle.setHorizontalAlign(HorizontalAlign.LEFT);
        detailStyle.setVerticalAlign(VerticalAlign.MIDDLE);
        for (int i = 1; i <= 10; i++) {
            AbstractColumn column = ColumnBuilder.getInstance()
                    .setColumnProperty("Column" + i, String.class.getName())
                    .setTitle("Column " + i + " Title").setWidth(200)
                    .setStyle(detailStyle).setHeaderStyle(headerStyle).build();
            drb.addColumn(column);
        }
        drb.setUseFullPageWidth(true);
        //Pass the JasperReport Template to DynamicJasper
        drb.setTemplateFile("C:/DynamicJasperTemplate.jrxml");
        DynamicReport dr = drb.build();
        JRDataSource ds = getDataSource();
        jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
        if (ds != null) {
            jp = JasperFillManager.fillReport(jr, params, ds);
        } else {
            jp = JasperFillManager.fillReport(jr, params);
        }
        JasperExportManager.exportReportToPdfFile(jp, "C:/report-out.pdf");
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A0);
        pdf.setPageSize(new Rectangle(5000, 1000));

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        //String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";
        //pdf.add(Image.getInstance(logo));
    }

    private Integer filtroReporte;

    public Integer getFiltroReporte() {
        return filtroReporte;
    }

    public void setFiltroReporte(Integer filtroReporte) {
        this.filtroReporte = filtroReporte;
    }

    public String getFiltroReporteStr() {
        switch (filtroReporte) {
            case 1:
                return "Programa";
            case 2:
                return "Proyecto";
            case 3:
                return "Tipo Proyecto";
            case 4:
                return "Carrera";
            case 5:
                return "Cobertura";
            case 6:
                return "Provincia";
            case 7:
                return "Cantón";
            case 8:
                return "Parroquia";
            case 9:
                return "Docente Participante";
            case 10:
                return "Estudiante Participante";
            case 11:
                return "Estado";
            case 12:
                return "Población Beneficiaria";

            default:
                break;
        }
        return "";
    }

    public void seleccionarFiltro() {

        filtroReporte = null;
    }

    public void cancelarFiltro(Integer filtroReporte) {
        switch (filtroReporte) {
            case 1:
                for (Programa p : programas) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 2:
                for (Proyecto p : proyectos) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 3:
                for (TipoProyecto p : tipoProyectoList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 4:
                for (Stvmajr p : carreras) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 5:
                for (SeaParametrosDet p : coberturaList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 6:
                for (SeaProvincia p : provincias) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 7:
                for (SeaCanton p : cantones) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 8:
                for (SeaParroquia p : parroquias) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 9:
                for (SegUsuario p : docenteList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 10:
                for (SegUsuario p : estudianteList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 11:
                for (SeaParametrosDet p : estadoList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 12:
                for (SeaParametrosDet p : tipoPoblacionBeneficiariaList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;

        }
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    private List<TipoProyecto> tipoProyectoList;

    public List<TipoProyecto> getTipoProyectoList() {
        return tipoProyectoList;
    }

    public void setTipoProyectoList(List<TipoProyecto> tipoProyectoList) {
        this.tipoProyectoList = tipoProyectoList;
    }

    private List<SeaParametrosDet> estadoList;
    

    public List<SeaParametrosDet> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<SeaParametrosDet> estadoList) {
        this.estadoList = estadoList;
    }

    private List<SeaParametrosDet> tipoPoblacionBeneficiariaList;

    public List<SeaParametrosDet> getTipoPoblacionBeneficiariaList() {
        return tipoPoblacionBeneficiariaList;
    }

    public void setTipoPoblacionBeneficiariaList(List<SeaParametrosDet> tipoPoblacionBeneficiariaList) {
        this.tipoPoblacionBeneficiariaList = tipoPoblacionBeneficiariaList;
    }

    private List<SeaParametrosDet> coberturaList;

    public List<SeaParametrosDet> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<SeaParametrosDet> coberturaList) {
        this.coberturaList = coberturaList;
    }
    
    /**
     * Verfica cuales filtros fueron seleccionados por el usuario. 
     * y devuelve un Boolean para saber si debo o no filtrar esos datos. 
     *
     * @param  filtroReporte  codigo correspondiente a cada filtro definido.
     * @return      boolean de verificacion.
     * @see         Boolean
     */
    public Boolean verificarFiltro(Integer filtroReporte) {
        switch (filtroReporte) {
            case 1:
                for (Programa p : programas) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 2:
                for (Proyecto p : proyectos) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 3:
                for (TipoProyecto p : tipoProyectoList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 4:
                for (Stvmajr p : carreras) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 5:
                for (SeaParametrosDet p : coberturaList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 6:
                for (SeaProvincia p : provincias) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 7:
                for (SeaCanton p : cantones) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 8:
                for (SeaParroquia p : parroquias) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 9:
                for (SegUsuario p : docenteList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 10:
                for (SegUsuario p : estudianteList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 11:
                for (SeaParametrosDet p : estadoList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 12:
                for (SeaParametrosDet p : tipoPoblacionBeneficiariaList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;

        }
        return false;
    }

//    variable para use filter of primefaces
   private List<ProyectoReporte> proyectoReporteFilter;

    public List<ProyectoReporte> getProyectoReporteFilter() {
        return proyectoReporteFilter;
    }

    public void setProyectoReporteFilter(List<ProyectoReporte> proyectoReporteFilter) {
        this.proyectoReporteFilter = proyectoReporteFilter;
    }
   
   
    
    
    private List<ProyectoReporte> proyectosReporteList;

    public List<ProyectoReporte> getProyectosReporteList() {
        return proyectosReporteList;
    }

    public void setProyectosReporteList(List<ProyectoReporte> proyectosReporteList) {
        this.proyectosReporteList = proyectosReporteList;
    }

    private void filtrarProyectos() {
        //Filtro por programas
        if (verificarFiltro(1)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (Programa progFiltro : programas) {
                    if (progFiltro.getSelected() != null && progFiltro.getSelected() && progFiltro.equals(proy.getPrograma())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por proyecto
        if (verificarFiltro(2)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (Proyecto proyFiltro : proyectos) {
                    if (proyFiltro.getSelected() != null && proyFiltro.getSelected() && proyFiltro.equals(proy)) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por estado
        if (verificarFiltro(11)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaParametrosDet estadoFiltro : estadoList) {
                    if (estadoFiltro.getSelected() != null && estadoFiltro.getSelected()) {
                        /*if (estadoFiltro.getId().equals(Proyecto.ESTADO_CREADO)) {
                            if (proy.getEstado().equals(Proyecto.ESTADO_CREADO) || proy.getEstado().equals(Proyecto.ESTADO_REVISION)) {
                                encontro = true;
                                break;
                            }
                        } else if (estadoFiltro.getId().equals(proy.getEstado())) {
                            encontro = true;
                            break;
                        }*/
                        if (estadoFiltro.getPrdId().equals(proy.getEstado().getPrdId())) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por tipo de proyecto
        if (verificarFiltro(3)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (TipoProyecto tipoProyFiltro : tipoProyectoList) {
                    if (tipoProyFiltro.getSelected() != null && tipoProyFiltro.getSelected() && tipoProyFiltro.getId().equals(proy.getTipo())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por carrera
        if (verificarFiltro(4)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (Stvmajr carreraFiltro : carreras) {
                    if (carreraFiltro.getSelected() != null && carreraFiltro.getSelected()) {
                        for (CarreraProyecto car : proy.getCarreraProyectoList()) {
                            if (carreraFiltro.equals(car.getCarrera())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por cobertura
        if (verificarFiltro(5)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaParametrosDet cobertura : coberturaList) {
                    if (cobertura.getSelected() != null && cobertura.getSelected() && cobertura.getPrdId().equals(proy.getCobertura2().getPrdId())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Provincia
        if (verificarFiltro(6)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaProvincia provinciaFiltro : provincias) {
                    if (provinciaFiltro.getSelected() != null && provinciaFiltro.getSelected()) {
                        for (LocalizacionPrograma car : proy.getLocalizacionDistinctProvinciaList()) {
                            if (provinciaFiltro.equals(car.getProvincia())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Canton
        if (verificarFiltro(7)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaCanton cantonFiltro : cantones) {
                    if (cantonFiltro.getSelected() != null && cantonFiltro.getSelected()) {
                        for (LocalizacionPrograma car : proy.getLocalizacionDistinctCantonList()) {
                            if (cantonFiltro.equals(car.getCanton())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Parroquia
        if (verificarFiltro(8)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaParroquia parroquiaFiltro : parroquias) {
                    if (parroquiaFiltro.getSelected() != null && parroquiaFiltro.getSelected()) {
                        for (LocalizacionPrograma car : proy.getLocalizacionDistinctParroquiaList()) {
                            if (parroquiaFiltro.equals(car.getParroquia())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Docente participante
        if (verificarFiltro(9)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SegUsuario docenteFiltro : docenteList) {
                    if (docenteFiltro.getSelected() != null && docenteFiltro.getSelected()) {
                        for (ResponsableProyecto car : proy.getParticipanteDocenteTodosList()) {
                            if (docenteFiltro.equals(car.getUsuario())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Estudiante participante
        if (verificarFiltro(10)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SegUsuario estudianteFiltro : estudianteList) {
                    if (estudianteFiltro.getSelected() != null && estudianteFiltro.getSelected()) {
                        for (ResponsableProyecto car : proy.getParticipanteEstudianteList()) {
                            if (estudianteFiltro.equals(car.getUsuario())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por tipo poblacion beneficiaria
        if (verificarFiltro(12)) {
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto proy = (Proyecto) it.next();
                boolean encontro = false;
                for (SeaParametrosDet tipoPoblacionFiltro : tipoPoblacionBeneficiariaList) {
                    if (tipoPoblacionFiltro.getSelected() != null && tipoPoblacionFiltro.getSelected() && proy.verificarTipoPoblacionBeneficiariaRural(new Long(tipoPoblacionFiltro.getPrdId()))) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

    }

    /*private void agregaEvaluacionFinal() {
        if (visualizarEvaluacionFinal) {
            for (Proyecto proy : proyectoList) {
                if (proy.getEstado().equals(Proyecto.ESTADO_EVALUADO) && proy.getEvaluacionFinal() != null) {

                    for (ParametroEvaluacionFinalCabecera cab : proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraList()) {
                        if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                            for (ObjetivoPrograma obj : proy.getObjetivoProyectoPadreList()) {
                                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                                    for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                        cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                        for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                        }
                                    }
                                }
                            }
                        }

                        ParametroEvaluacion parametroEliminar = null;
                        for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                            if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                                    && proy.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                                    && par.getIdAspectoEvaluacion() != null
                                    && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                                parametroEliminar = par;
                            }
                            par.setProyecto(proy);
                            if (proy.getEvaluacionFinal().getId() != null) {
                                if (!cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                                    for (DetalleEvaluacionFinalProyecto det : proy.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                                        try {
                                            if (det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                                par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                                par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                                break;
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                            }
                        }
                        if (parametroEliminar != null) {
                            cab.removeParametro(parametroEliminar);
                        }
                    }
                    proy.getConfiguracionParametrosEvaluacionFinal().initValoracion();
                    proy.setPuntajeEvaluacionEficacia(proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraEficaciaList().get(0).getPuntajeTotal());
                    proy.setPuntajeEvaluacionEficiencia(proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraEficienciaList().get(0).getPuntajeTotal());
                    proy.setPuntajeEvaluacionPertinencia(proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraPertinenciaList().get(0).getPuntajeTotal());
                    proy.setPuntajeEvaluacionSostenibilidad(proy.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraSostenibilidadList().get(0).getPuntajeTotal());
                    proy.setPuntajeEvaluacionTotal(proy.getConfiguracionParametrosEvaluacionFinal().getPuntajeTotalEvaluacionFinal());
                    proy.setPuntajeEvaluacionSobre(proy.getConfiguracionParametrosEvaluacionFinal().getPuntajeMaximoEvaluacionFinal());
                }

            }
        }
    }*/
    
    public void generarReporteProyectos() {
        try {
            columnaOrdenada = null;
            proyectosReporteList = new ArrayList<>();
            //proyectoList = proyectoFacade.find22(101);
            proyectoList = proyectoFacade.findAll();
            Iterator it = proyectoList.iterator();
            while (it.hasNext()) {
                Proyecto p = (Proyecto) it.next();
                //Programas y Proyectos inactivos Removidos del Iterador.
                if (p.getPrograma().getEstadoActivo().equals(Programa.ESTADO_PROGRAMA_INACTIVO)
                        || p.getEstadoActivo().equals(Proyecto.ESTADO_PROYECTO_INACTIVO)) {
                    it.remove();
                    continue;
                }
                //Remover del Iterador Los que no correspondan a las fechas necesitas por el Usuario.
                if (fechaDesde != null && p.getFechaInicio() != null && p.getFechaInicio().before(fechaDesde)) {
                    it.remove();
                    continue;
                }
                if (fechaHasta != null && (p.getFechaCierre() == null || p.getFechaCierre().after(fechaHasta))) {
                    it.remove();
                }
            }
            filtrarProyectos();
            //agregaEvaluacionFinal();

           
            for (Proyecto p : proyectoList) {
                if ((p.getLineaInvestigacionProyectoList() == null || p.getLineaInvestigacionProyectoList().isEmpty())
                        && (p.getDepartamentoProyectoList() == null || p.getDepartamentoProyectoList().isEmpty())
                        && (p.getCarreraProyectoList() == null || p.getCarreraProyectoList().isEmpty())
                        && (p.getObjetivosProvCanParr() == null || p.getObjetivosProvCanParr().isEmpty())
                        && (p.getParticipanteDocenteTodosList() == null || p.getParticipanteDocenteTodosList().isEmpty())
                        && (p.getParticipanteEstudianteList() == null || p.getParticipanteEstudianteList().isEmpty())) {
                    proyectosReporteList.add(crearObjetoReporteProyecto(p));
                }
            }

            //Lineas de Investigacion
            for (Proyecto p : proyectoList) {
                List<LineaInvestigacionProyecto> lista = p.getLineaInvestigacionProyectoList();
                if (lista == null || lista.isEmpty() || !visualizarLineaInvestigacion) {
                    agregarProyecto(p);
                } else if (visualizarLineaInvestigacion) {
                    for (LineaInvestigacionProyecto item : lista) {
                        agregarProyectoLineaInvestigacion(p, item.getLineaInvestigacion());
                    }
                }
            }

            //Campus participantes
            for (Proyecto p : proyectoList) {
                List<DepartamentoProyecto> lista = p.getDepartamentoProyectoDistinctCampusList();
                if (lista == null || lista.isEmpty() || !visualizarCampusParticipante) {
                    agregarProyecto(p);
                } else if (visualizarCampusParticipante) {
                    for (DepartamentoProyecto item : lista) {
                        agregarProyectoCampusParticipante(p, item.getCampus());
                    }
                }
            }
            //Departamentos participantes
            for (Proyecto p : proyectoList) {
                List<DepartamentoProyecto> lista;
                if (visualizarCampusParticipante) {
                    lista = p.getDepartamentoProyectoList();
                } else {
                    lista = p.getDepartamentoProyectoDistinctDepList();
                }

                if (lista == null || lista.isEmpty() || !visualizarDepartamentoParticipante) {
                    agregarProyecto(p);
                } else if (visualizarDepartamentoParticipante) {
                    for (DepartamentoProyecto item : lista) {
                        agregarProyectoDepartamentoParticipante(p, item.getDepartamento(), item.getCampus());
                    }
                }
            }

            //Carreras
            for (Proyecto p : proyectoList) {
                List<CarreraProyecto> lista = p.getCarreraProyectoList();
                if (lista == null || lista.isEmpty() || !visualizarCarrera) {
                    agregarProyecto(p);
                } else if (visualizarCarrera) {
                    for (CarreraProyecto item : lista) {
                        agregarProyectoCarrera(p, item.getCarrera());
                    }
                }
            }

            //Provincias
            for (Proyecto p : proyectoList) {
                List<LocalizacionPrograma> lista = p.getLocalizacionDistinctProvinciaList();
                if (lista == null || lista.isEmpty() || !visualizarProvincia) {
                    agregarProyecto(p);
                } else if (visualizarProvincia) {
                    for (LocalizacionPrograma item : lista) {
                        agregarProyectoProvincia(p, item.getProvincia());
                    }
                }
            }

            //Cantones
            for (Proyecto p : proyectoList) {
                List<LocalizacionPrograma> lista = p.getLocalizacionDistinctCantonList();
                if (lista == null || lista.isEmpty() || !visualizarCanton) {
                    agregarProyecto(p);
                } else if (visualizarCanton) {
                    for (LocalizacionPrograma item : lista) {
                        agregarProyectoCanton(p, item.getCanton());
                    }
                }
            }

            //Parroquias
            for (Proyecto p : proyectoList) {
                List<LocalizacionPrograma> lista = p.getLocalizacionDistinctParroquiaList();
                if (lista == null || lista.isEmpty() || !visualizarParroquia) {
                    agregarProyecto(p);
                } else if (visualizarParroquia) {
                    for (LocalizacionPrograma item : lista) {
                        if (item.getParroquia() == null) {
                            System.out.println("ec.edu.espe_innovativa.controller.Reportes2Controller.agregarProyectoParroquia()");
                        }
                        agregarProyectoParroquia(p, item.getParroquia());
                    }
                }
            }

            //Docentes participantes
            for (Proyecto p : proyectoList) {
                List<ResponsableProyecto> lista = p.getParticipanteDocenteTodosList();
                if (lista == null || lista.isEmpty() || !visualizarDocenteParticipante) {
                    agregarProyecto(p);
                } else if (visualizarDocenteParticipante) {
                    for (ResponsableProyecto item : lista) {
                        agregarProyectoDocenteParticipante(p, item);
                    }
                }
            }

            //Estudiantes participantes
            for (Proyecto p : proyectoList) {
                List<ResponsableProyecto> lista = p.getParticipanteEstudianteList();
                if (lista == null || lista.isEmpty() || !visualizarEstudianteParticipante) {
                    agregarProyecto(p);
                } else if (visualizarEstudianteParticipante) {
                    for (ResponsableProyecto item : lista) {
                        agregarProyectoEstudianteParticipante(p, item);
                    }
                }
            }

            //Presupuesto
            for (Proyecto p : proyectoList) {
                List<PresupuestoProyecto> lista = p.getPresupuestoProyectoList();
                if (lista == null || lista.isEmpty() || !visualizarPresupuesto) {
                    agregarProyecto(p);
                } else if (visualizarPresupuesto) {
                    for (PresupuestoProyecto item : lista) {
                        agregarProyectoPresupuesto(p, item);
                    }
                }
            }
            //Avance
            for (Proyecto p : proyectoList) {
                boolean encontro = false;
                if (p.getObjetivoProyectoList() != null) {
                    for (ObjetivoPrograma obj : p.getObjetivoProyectoList()) {
                        if (obj.getSeguimientoProyectoActual().getAvanceActividadList() != null && !obj.getSeguimientoProyectoActual().getAvanceActividadList().isEmpty()) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro || !visualizarAvance) {
                    agregarProyecto(p);
                } else if (visualizarAvance) {
                    for (ObjetivoPrograma obj : p.getObjetivoProyectoList()) {
                        if (obj.getSeguimientoProyectoActual() != null && obj.getSeguimientoProyectoActual().getAvanceActividadList() != null) {
                            for (AvanceActividad av : obj.getSeguimientoProyectoActual().getAvanceActividadList()) {
                                agregarProyectoAvance(p, av);
                            }
                        }
                    }
                }
            }

            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getCarrera() == null) {
                    p.setCarrera(new Stvmajr("-1", ""));
                }
                if (p.getCampusParticipante() == null) {
                    p.setCampusParticipante(new Stvcamp("-1", ""));
                }
                if (p.getDepartamentoParticipante() == null) {
                    p.setDepartamentoParticipante(new Stvsubj("-1", ""));
                }
                if (p.getLineaInvestigacion() == null) {   
                    p.setLineaInvestigacion(new SeaLineainves(new BigDecimal("-1"), ""));
                }
                if (p.getProvincia() == null) {
                    p.setProvincia(new SeaProvincia("-1", ""));
                }
                if (p.getCanton() == null) {
                    p.setCanton(new SeaCanton("-1", ""));
                }
                if (p.getParroquia() == null) {
                    p.setParroquia(new SeaParroquia("-1", ""));
                }
                if (p.getDocenteParticipante() == null) {
                    p.setDocenteParticipante(new ResponsableProyecto(-1, new SegUsuario(new BigDecimal("-1"), "", "", "")));
                }
                if (p.getEstudianteParticipante() == null) {
                    p.setEstudianteParticipante(new ResponsableProyecto(-1, new SegUsuario(new BigDecimal("-1"), "", "", "")));
                }
                if (p.getPresupuestoProyecto() == null) {
                    p.setPresupuestoProyecto(new PresupuestoProyecto(new BigInteger("-1")));
                }
                if (p.getAvanceActividad() == null) {
                    p.setAvanceActividad(new AvanceActividad(-1));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void agregarProyecto(Proyecto p) {
        if (buscarProyectos(p.getId(), null).isEmpty()) {
            ProyectoReporte proy = crearObjetoReporteProyecto(p);
            proyectosReporteList.add(proy);
        }
    }

    private void agregarProyectoLineaInvestigacion(Proyecto proyecto, SeaLineainves lineaInvestigacion) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.LINEA_INVESTIGACION)) {
            p.setLineaInvestigacion(lineaInvestigacion);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getLineaInvestigacion() != null) {
                    idBuscar = p.getLineaInvestigacion().getLineaIdPadre().getLineaId().toString() + "-" + p.getLineaInvestigacion().getLineaId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setLineaInvestigacion(lineaInvestigacion);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setLineaInvestigacion(lineaInvestigacion);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.LINEA_INVESTIGACION)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setLineaInvestigacion(lineaInvestigacion);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }
            }
        }
    }

    private void agregarProyectoDepartamentoParticipante(Proyecto proyecto, Stvsubj departamento, Stvcamp campus) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.DEPARTAMENTO)) {
            if (!visualizarCampusParticipante || (visualizarCampusParticipante && p.getCampusParticipante().equals(campus))) {
                p.setDepartamentoParticipante(departamento);
                encontro = true;
            }
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (visualizarCampusParticipante && p.getId().equals(proyecto.getId()) && p.getCampusParticipante() != null && p.getCampusParticipante().equals(campus) && p.getDepartamentoParticipante() != null) {
                    idBuscar = p.getDepartamentoParticipante().getStvsubjCode();
                    break;
                } else if (!visualizarCampusParticipante && p.getId().equals(proyecto.getId()) && p.getDepartamentoParticipante() != null) {
                    idBuscar = p.getDepartamentoParticipante().getStvsubjCode();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    if (!visualizarCampusParticipante || (visualizarCampusParticipante && p.getCampusParticipante().equals(campus))) {
                        p.setDepartamentoParticipante(departamento);
                        encontro2 = true;
                    }
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setDepartamentoParticipante(departamento);
                    if (visualizarCampusParticipante) {
                        proy.setCampusParticipante(campus);
                    }
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.DEPARTAMENTO)) {
                    if (!visualizarCampusParticipante || (visualizarCampusParticipante && p.getCampusParticipante().equals(campus))) {
                        ProyectoReporte proyectoReporteNuevo = p.clon();
                        proyectoReporteNuevo.setDepartamentoParticipante(departamento);
                        proyectosReporteList.add(proyectoReporteNuevo);
                    }
                }
            }
        }
    }
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;

    private ProyectoReporte crearObjetoReporteProyecto(Proyecto proyecto) {
        ProyectoReporte reporteProyecto = new ProyectoReporte();
        reporteProyecto.setId(proyecto.getId());
        // Jhonny Jami; Aparece nombre convocatoria de los proyectos.
        reporteProyecto.setConvocatoria(proyecto.getConvocatoria());
        //

        reporteProyecto.setNombre(proyecto.getNombre().toUpperCase());
        reporteProyecto.setCodigo(proyecto.getCodigo());
        if (proyecto.getPrograma() != null) {
            reporteProyecto.setPrograma(proyecto.getPrograma().getNombre().toUpperCase());
        } else {
            reporteProyecto.setPrograma("");
        }
        reporteProyecto.setEstado(new Estado(proyecto.getEstado().getPrdId().toString(), proyecto.getEstadoStr().toUpperCase()));
        reporteProyecto.setTipo(proyecto.getTipo());
        reporteProyecto.setCobertura(proyecto.getCoberturaStr().toUpperCase());
        VDocenteVinculacion2 doc = vistaDocenteFacade.findByUsuId(proyecto.getDirector().getUsuario().getUsuId());
        // Jhonny Jami; Posible Null en la variable DOC.
        if(doc != null){
            ResponsableProyecto director = new ResponsableProyecto();
            director.setUsuario(doc.getUsuario());
            director.setCampus(doc.getCampus());
            director.setDepartamento(doc.getDepartamento());
            reporteProyecto.setDirector(director);
        }
        //    
        if (proyecto.getEvaluacionFinal() != null) {
            reporteProyecto.setPuntajeEvaluacionFinalPertinencia(proyecto.getPuntajeEvaluacionPertinencia());
            reporteProyecto.setPuntajeEvaluacionFinalEficacia(proyecto.getPuntajeEvaluacionEficacia());
            reporteProyecto.setPuntajeEvaluacionFinalEficiencia(proyecto.getPuntajeEvaluacionEficiencia());
            reporteProyecto.setPuntajeEvaluacionFinalSostenibilidad(proyecto.getPuntajeEvaluacionSostenibilidad());
            reporteProyecto.setPuntajeEvaluacionFinalPertinenciaMaximo(proyecto.getPuntajeEvaluacionPertinenciaMaximo());
            reporteProyecto.setPuntajeEvaluacionFinalEficaciaMaximo(proyecto.getPuntajeEvaluacionEficaciaMaximo());
            reporteProyecto.setPuntajeEvaluacionFinalEficienciaMaximo(proyecto.getPuntajeEvaluacionEficienciaMaximo());
            reporteProyecto.setPuntajeEvaluacionFinalSostenibilidadMaximo(proyecto.getPuntajeEvaluacionSostenibilidadMaximo());
            reporteProyecto.setPuntajeEvaluacionFinalMaximo(proyecto.getPuntajeEvaluacionMaximo());
            reporteProyecto.setPuntajeEvaluacionFinalTotal(proyecto.getPuntajeTotalEvaluacionFinal());
        }
        reporteProyecto.setNroBeneficiariosDirectosDiscapac(proyecto.getNroBeneficiariosDirectosDiscapac());
        reporteProyecto.setNroBeneficiariosDirectosHombres(proyecto.getNroBeneficiariosDirectosHombres());
        reporteProyecto.setNroBeneficiariosDirectosMujeres(proyecto.getNroBeneficiariosDirectosMujeres());
        reporteProyecto.setNroBeneficiariosDirectosNinios(proyecto.getNroBeneficiariosDirectosNinios());
        reporteProyecto.setNroBeneficiariosIndirectos(proyecto.getNroBeneficiariosIndirectos());
        reporteProyecto.setTotalBeneficiariosPlanificados(proyecto.getTotalBeneficiariosPlanificado());
        reporteProyecto.setNroBeneficiariosDirectosDiscapacEjec(proyecto.getTotalBeneficiariosDirectosEjecutadosDiscapacidad());
        reporteProyecto.setNroBeneficiariosDirectosHombresEjec(proyecto.getTotalBeneficiariosDirectosEjecutadosHombres());
        reporteProyecto.setNroBeneficiariosDirectosMujeresEjec(proyecto.getTotalBeneficiariosDirectosEjecutadosMujeres());
        reporteProyecto.setNroBeneficiariosDirectosNiniosEjec(proyecto.getTotalBeneficiariosDirectosEjecutadosNinios());
        reporteProyecto.setNroBeneficiariosIndirectosEjec(proyecto.getTotalBeneficiariosIndirectosEjecutados());
        reporteProyecto.setTotalBeneficiariosEjecutados(proyecto.getTotalBeneficiariosEjecutados());
        reporteProyecto.setPoblacionBeneficiariaUrbanoMarginal(proyecto.isTipoPoblacionBeneficiariaUrbanoMarginal());
        reporteProyecto.setPoblacionBeneficiariaRural(proyecto.isTipoPoblacionBeneficiariaRural());
        reporteProyecto.setPoblacionBeneficiariaGrupoAtencionPrioritaria(proyecto.isTipoPoblacionGrupoAtencionPrioritaria());
        reporteProyecto.setPresupuestoTotalPlanificado(proyecto.getTotalPresupuesto());
        reporteProyecto.setPresupuestoTotalEjecutado(proyecto.getTotalPresupuestoEjecutado());
        if (proyecto.getMensajePermitirCalificacionComisionVinculacion().equals("")) {
            reporteProyecto.setDocumentacionPerfil(true);
        }
        if (proyecto.verificarCronogramaIngresado()) {
            reporteProyecto.setDocumentacionCronograma(true);
        }
        if (proyecto.getPresupuestoProyectoList() != null && !proyecto.getPresupuestoProyectoList().isEmpty()) {
            reporteProyecto.setDocumentacionCosteo(true);
        }
        if (proyecto.getCompromisoParticipacionList() != null && !proyecto.getCompromisoParticipacionList().isEmpty()) {
            reporteProyecto.setDocumentacionCompromisoParticipacion(true);
        }
        if (proyecto.getTotalBeneficiariosPlanificado() != null && proyecto.getTotalBeneficiariosPlanificado() != 0) {
            reporteProyecto.setDocumentacionBeneficiarios(true);
        }
        if (proyecto.getParticipanteDocenteList() != null && !proyecto.getParticipanteDocenteList().isEmpty()) {
            reporteProyecto.setDocumentacionNroDocentes(true);
        }
        if (proyecto.getParticipanteEstudianteList() != null && !proyecto.getParticipanteEstudianteList().isEmpty()) {
            reporteProyecto.setDocumentacionNroEstudiantes(true);
        }
        
        if (proyecto.getObjetivoProyectoList() != null && !proyecto.getObjetivoProyectoList().isEmpty()) {
            for (ObjetivoPrograma obj : proyecto.getObjetivoProyectoList()) {
                if (obj.getSeguimientoProyectoActual().getAvanceActividadList() != null && !obj.getSeguimientoProyectoActual().getAvanceActividadList().isEmpty()) {
                    reporteProyecto.setDocumentacionAvance(true);
                    break;
                }
            }
        }
        if (proyecto.getParticipanteDocenteList() != null && !proyecto.getParticipanteDocenteList().isEmpty()) {
            for (ResponsableProyecto resp : proyecto.getParticipanteDocenteList()) {
                if (resp.getTotalHorasDedicadas() > 0) {
                    reporteProyecto.setDocumentacionHorasDocentes(true);
                    break;
                }
            }
        }
        if (proyecto.getParticipanteEstudianteList() != null && !proyecto.getParticipanteEstudianteList().isEmpty()) {
            for (ResponsableProyecto resp : proyecto.getParticipanteEstudianteList()) {
                if (resp.getTotalHorasDedicadas() > 0) {
                    reporteProyecto.setDocumentacionHorasEstudiantes(true);
                    break;
                }
            }
        }
        if (proyecto.getMensajePermitirEvaluacionFinal().equals("")) {
            reporteProyecto.setDocumentacionCierre(true);
        }
        if (proyecto.isEstadoFinalizado()) {
            reporteProyecto.setDocumentacionEvaluacionFinal(true);
        }
        proyecto.initAnexos();
        if (proyecto.getAnexoDocumentoProyectoList() != null && !proyecto.getAnexoDocumentoProyectoList().isEmpty()) {
            reporteProyecto.setDocumentacionAnexos(true);
        }
        reporteProyecto.setFechaInicio(proyecto.getFechaInicio());
        reporteProyecto.setFechaFinalizacion(proyecto.getFechaCierre());

        return reporteProyecto;
    }

    private void agregarProyectoCampusParticipante(Proyecto proyecto, Stvcamp campus) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.CAMPUS)) {
            p.setCampusParticipante(campus);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getCampusParticipante() != null) {
                    idBuscar = p.getCampusParticipante().getStvcampCode();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setCampusParticipante(campus);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setCampusParticipante(campus);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.CAMPUS)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setCampusParticipante(campus);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoCarrera(Proyecto proyecto, Stvmajr carrera) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.CARRERA)) {
            p.setCarrera(carrera);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getCarrera() != null) {
                    idBuscar = p.getCarrera().getStvmajrCode();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setCarrera(carrera);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setCarrera(carrera);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.CARRERA)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setCarrera(carrera);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }
            }

        }
    }

    private void agregarProyectoProvincia(Proyecto proyecto, SeaProvincia provincia) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.PROVINCIA)) {
            p.setProvincia(provincia);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getProvincia() != null) {
                    idBuscar = p.getProvincia().getProId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setProvincia(provincia);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setProvincia(provincia);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.PROVINCIA)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setProvincia(provincia);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoCanton(Proyecto proyecto, SeaCanton canton) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.CANTON)) {
            if (p.getProvincia() != null && p.getProvincia().equals(canton.getProId())) {
                p.setCanton(canton);
                encontro = true;
            }
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getCanton() != null) {
                    //idBuscar = p.getCanton().getProId().getProId() + "*" + p.getCanton().getCanId();
                    idBuscar = p.getCanton().getCanId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setCanton(canton);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setCanton(canton);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.CANTON)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setCanton(canton);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoParroquia(Proyecto proyecto, SeaParroquia parroquia) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.PARROQUIA)) {
            if (parroquia.getCanId() == null) {
                System.out.println("ec.edu.espe_innovativa.controller.Reportes2Controller.agregarProyectoParroquia()");
            }
            if (p.getCanton() != null && p.getCanton().equals(parroquia.getCanId())) {
                p.setParroquia(parroquia);
                encontro = true;
            }
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getParroquia() != null) {
                    idBuscar = p.getParroquia().getPrqId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setParroquia(parroquia);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setParroquia(parroquia);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.PARROQUIA)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setParroquia(parroquia);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoDocenteParticipante(Proyecto proyecto, ResponsableProyecto docente) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.DOCENTE)) {
            p.setDocenteParticipante(docente);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getDocenteParticipante() != null) {
                    idBuscar = p.getDocenteParticipante().getUsuario().getUsuId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setDocenteParticipante(docente);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setDocenteParticipante(docente);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.DOCENTE)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setDocenteParticipante(docente);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoEstudianteParticipante(Proyecto proyecto, ResponsableProyecto estudiante) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.ESTUDIANTE)) {
            p.setEstudianteParticipante(estudiante);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getEstudianteParticipante() != null) {
                    idBuscar = p.getEstudianteParticipante().getUsuario().getUsuId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setEstudianteParticipante(estudiante);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setEstudianteParticipante(estudiante);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.ESTUDIANTE)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setEstudianteParticipante(estudiante);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoPresupuesto(Proyecto proyecto, PresupuestoProyecto presupuestoProyecto) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.PRESUPUESTO)) {
            p.setPresupuestoProyecto(presupuestoProyecto);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getPresupuestoProyecto() != null) {
                    //idBuscar = p.getPresupuestoProyecto().getNombreCompleto();
                    idBuscar = p.getPresupuestoProyecto().getId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setPresupuestoProyecto(presupuestoProyecto);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setPresupuestoProyecto(presupuestoProyecto);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.PRESUPUESTO)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setPresupuestoProyecto(presupuestoProyecto);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private void agregarProyectoAvance(Proyecto proyecto, AvanceActividad avanceActividad) {
        boolean encontro = false;
        for (ProyectoReporte p : buscarProyectos(proyecto.getId(), TipoBusqueda.AVANCE)) {
            p.setAvanceActividad(avanceActividad);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProyectoReporte p : proyectosReporteList) {
                if (p.getId().equals(proyecto.getId()) && p.getAvanceActividad() != null) {
                    idBuscar = p.getAvanceActividad().getAvanceComponente().getComponenteEspecifico().getSvopId().toString() + "*" + p.getAvanceActividad().getActividad().getSvopId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), null)) {
                    p.setAvanceActividad(avanceActividad);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProyectoReporte proy = crearObjetoReporteProyecto(proyecto);
                    proy.setAvanceActividad(avanceActividad);
                    proyectosReporteList.add(proy);
                }
            } else {
                for (ProyectoReporte p : buscarProyectos(proyecto.getId(), idBuscar, TipoBusqueda.AVANCE)) {
                    ProyectoReporte proyectoReporteNuevo = p.clon();
                    proyectoReporteNuevo.setAvanceActividad(avanceActividad);
                    proyectosReporteList.add(proyectoReporteNuevo);
                }

            }
        }
    }

    private List<ProyectoReporte> buscarProyectos(Integer idProyecto, String idBuscar, TipoBusqueda tipoBusqueda) {
        List<ProyectoReporte> result = new ArrayList<>();
        for (ProyectoReporte p : proyectosReporteList) {
            if (p.getId().equals(idProyecto)) {
                if (tipoBusqueda.equals(TipoBusqueda.LINEA_INVESTIGACION)) {
                    if ((p.getLineaInvestigacion().getLineaIdPadre().getLineaId().toString() + "-" + p.getLineaInvestigacion().getLineaId().toString()).equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.DEPARTAMENTO)) {
                    if (p.getDepartamentoParticipante() != null && p.getDepartamentoParticipante().getStvsubjCode().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.CAMPUS)) {
                    if (p.getCampusParticipante().getStvcampCode().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.CARRERA)) {
                    if (p.getCarrera().getStvmajrCode().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.PROVINCIA)) {
                    if (p.getProvincia() != null && p.getProvincia().getProId().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.CANTON)) {
                    //if ((p.getProvincia().getProId() + "*" + p.getCanton().getCanId()).equals(idBuscar)) {
                    if (p.getCanton() != null && p.getCanton().getCanId().equals(idBuscar)) {
                        result.add(p);
                    }
                }

                if (tipoBusqueda.equals(TipoBusqueda.PARROQUIA)) {
                    if (p.getParroquia() != null && p.getParroquia().getPrqId().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.DOCENTE)) {
                    if (p.getDocenteParticipante().getUsuario().getUsuId().toString().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.ESTUDIANTE)) {
                    if (p.getEstudianteParticipante().getUsuario().getUsuId().toString().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.PRESUPUESTO)) {
                    //if (p.getPresupuestoProyecto().getNombreCompleto().equals(idBuscar)) {
                    if (p.getPresupuestoProyecto().getId().toString().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.AVANCE)) {
                    if ((p.getAvanceActividad().getAvanceComponente().getComponenteEspecifico().getSvopId().toString() + "*" + p.getAvanceActividad().getActividad().getSvopId().toString()).equals(idBuscar)) {
                        result.add(p);
                    }
                }

            }
        }
        return result;
    }

    private List<ProyectoReporte> buscarProyectos(Integer idProyecto, TipoBusqueda tipoBusqueda) {
        List<ProyectoReporte> result = new ArrayList<>();
        for (ProyectoReporte p : proyectosReporteList) {
            if (p.getId().equals(idProyecto)) {
                if (tipoBusqueda == null) {
                    result.add(p);
                } else if (tipoBusqueda.equals(TipoBusqueda.LINEA_INVESTIGACION)) {
                    if (p.getLineaInvestigacion() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.DEPARTAMENTO)) {
                    if (p.getDepartamentoParticipante() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.CAMPUS)) {
                    if (p.getCampusParticipante() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.CARRERA)) {
                    if (p.getCarrera() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.PROVINCIA)) {
                    if (p.getProvincia() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.CANTON)) {
                    if (p.getCanton() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.PARROQUIA)) {
                    if (p.getParroquia() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.DOCENTE)) {
                    if (p.getDocenteParticipante() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.ESTUDIANTE)) {
                    if (p.getEstudianteParticipante() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.PRESUPUESTO)) {
                    if (p.getPresupuestoProyecto() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.AVANCE)) {
                    if (p.getAvanceActividad() == null) {
                        result.add(p);
                    }
                }

            }
        }
        return result;
    }

    private enum TipoBusqueda {
        LINEA_INVESTIGACION, DEPARTAMENTO, CAMPUS, CARRERA, PROVINCIA, CANTON, PARROQUIA, DOCENTE, ESTUDIANTE, PRESUPUESTO, AVANCE
    }

    private boolean visualizarTodos;
    private boolean visualizarPrograma;
    private boolean visualizarCodigoProyecto;
    private boolean visualizarEstado;
    private boolean visualizarTipoProyecto;
    private boolean visualizarDirector;
    private boolean visualizarCampus;
    private boolean visualizarDepartamento;
    private boolean visualizarCobertura;
    private boolean visualizarLineaInvestigacion;
    private boolean visualizarDepartamentoParticipante;
    private boolean visualizarCampusParticipante;
    private boolean visualizarCarrera;
    private boolean visualizarProvincia;
    private boolean visualizarCanton;
    private boolean visualizarParroquia;
    private boolean visualizarDocenteParticipante;
    private boolean visualizarEstudianteParticipante;
    private boolean visualizarEvaluacionFinal;
    private boolean visualizarBeneficiarios;
    private boolean visualizarPresupuesto;
    private boolean visualizarAvance;
    private boolean visualizarDocumentacion;
    private boolean visualizarFechaInicio;
    private boolean visualizarFechaFinalizacion;

    public boolean isVisualizarDocumentacion() {
        return visualizarDocumentacion;
    }

    public void setVisualizarDocumentacion(boolean visualizarDocumentacion) {
        this.visualizarDocumentacion = visualizarDocumentacion;
    }

    public boolean isVisualizarAvance() {
        return visualizarAvance;
    }

    public void setVisualizarAvance(boolean visualizarAvance) {
        this.visualizarAvance = visualizarAvance;
    }

    public boolean isVisualizarPresupuesto() {
        return visualizarPresupuesto;
    }

    public void setVisualizarPresupuesto(boolean visualizarPresupuesto) {
        this.visualizarPresupuesto = visualizarPresupuesto;
    }

    public boolean isVisualizarBeneficiarios() {
        return visualizarBeneficiarios;
    }

    public void setVisualizarBeneficiarios(boolean visualizarBeneficiarios) {
        this.visualizarBeneficiarios = visualizarBeneficiarios;
    }

    public boolean isVisualizarEvaluacionFinal() {
        return visualizarEvaluacionFinal;
    }

    public void setVisualizarEvaluacionFinal(boolean visualizarEvaluacionFinal) {
        this.visualizarEvaluacionFinal = visualizarEvaluacionFinal;
    }

    public boolean isVisualizarEstudianteParticipante() {
        return visualizarEstudianteParticipante;
    }

    public void setVisualizarEstudianteParticipante(boolean visualizarEstudianteParticipante) {
        this.visualizarEstudianteParticipante = visualizarEstudianteParticipante;
    }

    public boolean isVisualizarDocenteParticipante() {
        return visualizarDocenteParticipante;
    }

    public void setVisualizarDocenteParticipante(boolean visualizarDocenteParticipante) {
        this.visualizarDocenteParticipante = visualizarDocenteParticipante;
    }

    public boolean isVisualizarParroquia() {
        return visualizarParroquia;
    }

    public void setVisualizarParroquia(boolean visualizarParroquia) {
        this.visualizarParroquia = visualizarParroquia;
    }

    public boolean isVisualizarCanton() {
        return visualizarCanton;
    }

    public void setVisualizarCanton(boolean visualizarCanton) {
        this.visualizarCanton = visualizarCanton;
    }

    public boolean isVisualizarProvincia() {
        return visualizarProvincia;
    }

    public void setVisualizarProvincia(boolean visualizarProvincia) {
        this.visualizarProvincia = visualizarProvincia;
    }

    public boolean isVisualizarLineaInvestigacion() {
        return visualizarLineaInvestigacion;
    }

    public void setVisualizarLineaInvestigacion(boolean visualizarLineaInvestigacion) {
        this.visualizarLineaInvestigacion = visualizarLineaInvestigacion;
    }

    public boolean isVisualizarDepartamentoParticipante() {
        return visualizarDepartamentoParticipante;
    }

    public void setVisualizarDepartamentoParticipante(boolean visualizarDepartamentoParticipante) {
        this.visualizarDepartamentoParticipante = visualizarDepartamentoParticipante;
    }

    public boolean isVisualizarCampusParticipante() {
        return visualizarCampusParticipante;
    }

    public void setVisualizarCampusParticipante(boolean visualizarCampusParticipante) {
        this.visualizarCampusParticipante = visualizarCampusParticipante;
    }

    public boolean isVisualizarCarrera() {
        return visualizarCarrera;
    }

    public void setVisualizarCarrera(boolean visualizarCarrera) {
        this.visualizarCarrera = visualizarCarrera;
    }

    private List<ProyectoReporte> proyectoReporteListTemp;

    private boolean buscarProyectoTemp(ProyectoReporte proyectoReporte) {
        for (ProyectoReporte p : proyectoReporteListTemp) {
            if (p.equals(proyectoReporte)) {
                return true;
            }
        }
        return false;
    }

    public Integer getTotalItems(ProyectoReporte p, Integer tipo) {
        Integer cont = 0;
        proyectoReporteListTemp = new ArrayList<>();
        for (ProyectoReporte proy : proyectosReporteList) {
            boolean agregar = false;
            switch (columnaOrdenada) {
                case PROYECTO:
                    if (p.getNombre().equals(proy.getNombre())) {
                        agregar = true;
                    }
                    break;
                case CODIGO_PROYECTO:
                    if (p.getCodigo().equals(proy.getCodigo())) {
                        agregar = true;
                    }
                    break;
                case ESTADO:
                    if (p.getEstado().equals(proy.getEstado())) {
                        agregar = true;
                    }
                    break;
                case TIPO_PROYECTO:
                    if (p.getTipo().equals(proy.getTipo())) {
                        agregar = true;
                    }
                    break;
                case DIRECTOR:
                    if (p.getDirector().equals(proy.getDirector())) {
                        agregar = true;
                    }
                    break;
                case CAMPUS:
                    if (p.getDirector().getCampus().equals(proy.getDirector().getCampus())) {
                        agregar = true;
                    }
                    break;
                case DEPARTAMENTO:
                    if (p.getDirector().getDepartamento().equals(proy.getDirector().getDepartamento())) {
                        agregar = true;
                    }
                    break;
                case PROGRAMA:
                    if (p.getPrograma().equals(proy.getPrograma())) {
                        agregar = true;
                    }
                    break;
                case COBERTURA:
                    if (p.getCobertura().equals(proy.getCobertura())) {
                        agregar = true;
                    }
                    break;
                case LINEA_INVESTIGACION:
                    if (p.getLineaInvestigacion().equals(proy.getLineaInvestigacion())) {
                        agregar = true;
                    }
                    break;
                case CARRERA:
                    if (p.getCarrera() != null && proy.getCarrera() != null && p.getCarrera().equals(proy.getCarrera())) {
                        agregar = true;
                    }
                    break;
                case CAMPUS_PARTICIPANTE:
                    if (p.getCampusParticipante().equals(proy.getCampusParticipante())) {
                        agregar = true;
                    }
                    break;
                case DEPARTAMENTO_PARTICIPANTE:
                    if (p.getDepartamentoParticipante().equals(proy.getDepartamentoParticipante())) {
                        agregar = true;
                    }
                    break;
                case PROVINCIA:
                    if (p.getProvincia().equals(proy.getProvincia())) {
                        agregar = true;
                    }
                    break;
                case CANTON:
                    if (p.getCanton().equals(proy.getCanton())) {
                        agregar = true;
                    }
                    break;
                case PARROQUIA:
                    if (p.getParroquia().equals(proy.getParroquia())) {
                        agregar = true;
                    }
                    break;
                case DOCENTE_PARTICIPANTE:
                    if (p.getDocenteParticipante().equals(proy.getDocenteParticipante())) {
                        agregar = true;
                    }
                    break;
                case ESTUDIANTE_PARTICIPANTE:
                    if (p.getEstudianteParticipante().equals(proy.getEstudianteParticipante())) {
                        agregar = true;
                    }
                    break;
                case PRESUPUESTO_PARTIDA:
                    if (p.getPresupuestoProyecto().getNombrePartida().equals(proy.getPresupuestoProyecto().getNombrePartida())) {
                        agregar = true;
                    }
                    break;

                default:
                    break;
            }
            if (agregar) {
                if (tipo.equals(1)) {
                    cont++;
                } else if (!buscarProyectoTemp(proy)) {
                    cont++;
                    proyectoReporteListTemp.add(proy);
                }

            }

        }
        return cont;
    }

    private COLUMNA columnaOrdenada;

    public COLUMNA getColumnaOrdenada() {
        return columnaOrdenada;
    }

    public void setColumnaOrdenada(COLUMNA columnaOrdenada) {
        this.columnaOrdenada = columnaOrdenada;
    }

    public void detectSortEvent(SortEvent event) {
        if (event.getSortColumn().getClientId().contains(":colProyecto")) {
            columnaOrdenada = COLUMNA.PROYECTO;
        } else if (event.getSortColumn().getClientId().contains(":colEstado")) {
            columnaOrdenada = COLUMNA.ESTADO;
        } else if (event.getSortColumn().getClientId().contains(":colTipoProyecto")) {
            columnaOrdenada = COLUMNA.TIPO_PROYECTO;
        } else if (event.getSortColumn().getClientId().contains(":colDirector")) {
            columnaOrdenada = COLUMNA.DIRECTOR;
        } else if (event.getSortColumn().getClientId().contains(":colPrograma")) {
            columnaOrdenada = COLUMNA.PROGRAMA;
        } else if (event.getSortColumn().getClientId().contains(":colLineaInvestigacion")) {
            columnaOrdenada = COLUMNA.LINEA_INVESTIGACION;
        } else if (event.getSortColumn().getClientId().contains(":colCarrera")) {
            columnaOrdenada = COLUMNA.CARRERA;
        } else if (event.getSortColumn().getClientId().contains(":colCampus")) {
            columnaOrdenada = COLUMNA.CAMPUS;
        } else if (event.getSortColumn().getClientId().contains(":colDepartamento")) {
            columnaOrdenada = COLUMNA.DEPARTAMENTO;
        } else if (event.getSortColumn().getClientId().contains(":colCampusParticipante")) {
            columnaOrdenada = COLUMNA.CAMPUS_PARTICIPANTE;
        } else if (event.getSortColumn().getClientId().contains(":colDepartamentoParticipante")) {
            columnaOrdenada = COLUMNA.DEPARTAMENTO_PARTICIPANTE;
        } else if (event.getSortColumn().getClientId().contains(":colCobertura")) {
            columnaOrdenada = COLUMNA.COBERTURA;
        } else if (event.getSortColumn().getClientId().contains(":colProvincia")) {
            columnaOrdenada = COLUMNA.PROVINCIA;
        } else if (event.getSortColumn().getClientId().contains(":colCanton")) {
            columnaOrdenada = COLUMNA.CANTON;
        } else if (event.getSortColumn().getClientId().contains(":colParroquia")) {
            columnaOrdenada = COLUMNA.PARROQUIA;
        } else if (event.getSortColumn().getClientId().contains(":colDocente")) {
            columnaOrdenada = COLUMNA.DOCENTE_PARTICIPANTE;
        } else if (event.getSortColumn().getClientId().contains(":colEstudiante")) {
            columnaOrdenada = COLUMNA.ESTUDIANTE_PARTICIPANTE;
        } else if (event.getSortColumn().getClientId().contains(":colPresupuestoPartida")) {
            columnaOrdenada = COLUMNA.PRESUPUESTO_PARTIDA;
        }

    }

    private enum COLUMNA {
        PROGRAMA, PROYECTO, CODIGO_PROYECTO, ESTADO, TIPO_PROYECTO, DIRECTOR, CAMPUS, DEPARTAMENTO, COBERTURA, LINEA_INVESTIGACION, CARRERA, CAMPUS_PARTICIPANTE, DEPARTAMENTO_PARTICIPANTE, PROVINCIA, CANTON, PARROQUIA, DOCENTE_PARTICIPANTE, ESTUDIANTE_PARTICIPANTE, PRESUPUESTO_PARTIDA
    }

    public Integer getColspan() {
        Integer result = 10;
        if (columnaOrdenada != null) {
            switch (columnaOrdenada) {
                case PROGRAMA:
                    result = 1;
                    break;
                case PROYECTO:
                    result = 2;
                    break;
                case CODIGO_PROYECTO:
                    result = 3;
                    break;
                case ESTADO:
                    result = 4;
                    break;
                case TIPO_PROYECTO:
                    result = 5;
                    break;
                case DIRECTOR:
                    result = 6;
                    break;
                case CAMPUS:
                    result = 7;
                    break;
                case DEPARTAMENTO:
                    result = 8;
                    break;
                case COBERTURA:
                    result = 9;
                    break;
                case DEPARTAMENTO_PARTICIPANTE:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    break;
                case CARRERA:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    break;
                case LINEA_INVESTIGACION:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    break;
                case PROVINCIA:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    break;
                case CANTON:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    if (visualizarProvincia) {
                        result++;
                    }
                    break;
                case PARROQUIA:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    if (visualizarProvincia) {
                        result++;
                    }
                    if (visualizarCanton) {
                        result++;
                    }
                    break;
                case DOCENTE_PARTICIPANTE:
                    result++;
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    if (visualizarProvincia) {
                        result++;
                    }
                    if (visualizarCanton) {
                        result++;
                    }
                    if (visualizarParroquia) {
                        result++;
                    }
                    break;
                case ESTUDIANTE_PARTICIPANTE:
                    result++;
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    if (visualizarProvincia) {
                        result++;
                    }
                    if (visualizarCanton) {
                        result++;
                    }
                    if (visualizarParroquia) {
                        result++;
                    }
                    if (visualizarDocenteParticipante) {
                        result++;
                        result++;
                        result++;
                    }
                    break;
                case PRESUPUESTO_PARTIDA:
                    if (visualizarCampusParticipante) {
                        result++;
                    }
                    if (visualizarDepartamentoParticipante) {
                        result++;
                    }
                    if (visualizarCarrera) {
                        result++;
                    }
                    if (visualizarLineaInvestigacion) {
                        result++;
                    }
                    if (visualizarProvincia) {
                        result++;
                    }
                    if (visualizarCanton) {
                        result++;
                    }
                    if (visualizarParroquia) {
                        result++;
                    }
                    if (visualizarDocenteParticipante) {
                        result++;
                        result++;
                        result++;
                    }
                    if (visualizarEstudianteParticipante) {
                        result++;
                        result++;
                        result++;
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public List<SeaCanton> getCantones() {
        return cantones;
    }

    public void setCantones(List<SeaCanton> cantones) {
        this.cantones = cantones;
    }

    public List<SeaParroquia> getParroquias() {
        return parroquias;
    }

    public void setParroquias(List<SeaParroquia> parroquias) {
        this.parroquias = parroquias;
    }

    public boolean isVisualizarPrograma() {
        return visualizarPrograma;
    }

    public void setVisualizarPrograma(boolean visualizarPrograma) {
        this.visualizarPrograma = visualizarPrograma;
    }

    public boolean isVisualizarCodigoProyecto() {
        return visualizarCodigoProyecto;
    }

    public void setVisualizarCodigoProyecto(boolean visualizarCodigoProyecto) {
        this.visualizarCodigoProyecto = visualizarCodigoProyecto;
    }

    public boolean isVisualizarEstado() {
        return visualizarEstado;
    }

    public void setVisualizarEstado(boolean visualizarEstado) {
        this.visualizarEstado = visualizarEstado;
    }

    public boolean isVisualizarTipoProyecto() {
        return visualizarTipoProyecto;
    }

    public void setVisualizarTipoProyecto(boolean visualizarTipoProyecto) {
        this.visualizarTipoProyecto = visualizarTipoProyecto;
    }

    public boolean isVisualizarDirector() {
        return visualizarDirector;
    }

    public void setVisualizarDirector(boolean visualizarDirector) {
        this.visualizarDirector = visualizarDirector;
    }

    public boolean isVisualizarCampus() {
        return visualizarCampus;
    }

    public void setVisualizarCampus(boolean visualizarCampus) {
        this.visualizarCampus = visualizarCampus;
    }

    public boolean isVisualizarDepartamento() {
        return visualizarDepartamento;
    }

    public void setVisualizarDepartamento(boolean visualizarDepartamento) {
        this.visualizarDepartamento = visualizarDepartamento;
    }

    public boolean isVisualizarTodos() {
        return visualizarTodos;
    }

    public void setVisualizarTodos(boolean visualizarTodos) {
        this.visualizarTodos = visualizarTodos;
    }

    public void seleccionarDeseleccionarTodos() {
        visualizarAvance = visualizarTodos;
        visualizarBeneficiarios = visualizarTodos;
        visualizarCampus = visualizarTodos;
        visualizarCampusParticipante = visualizarTodos;
        visualizarCanton = visualizarTodos;
        visualizarCarrera = visualizarTodos;
        visualizarCobertura = visualizarTodos;
        visualizarCodigoProyecto = visualizarTodos;
        visualizarDepartamento = visualizarTodos;
        visualizarDepartamentoParticipante = visualizarTodos;
        visualizarDirector = visualizarTodos;
        visualizarDocenteParticipante = visualizarTodos;
        visualizarDocumentacion = visualizarTodos;
        visualizarEstado = visualizarTodos;
        visualizarEstudianteParticipante = visualizarTodos;
        visualizarEvaluacionFinal = visualizarTodos;
        visualizarLineaInvestigacion = visualizarTodos;
        visualizarParroquia = visualizarTodos;
        visualizarPresupuesto = visualizarTodos;
        visualizarPrograma = visualizarTodos;
        visualizarProvincia = visualizarTodos;
        visualizarTipoProyecto = visualizarTodos;
    }

    public void seleccionarDeseleccionarItem() {
        if (visualizarAvance && visualizarBeneficiarios && visualizarCampus && visualizarCampusParticipante && visualizarCanton
                && visualizarCarrera && visualizarCobertura && visualizarCodigoProyecto && visualizarDepartamento && visualizarDepartamentoParticipante
                && visualizarDirector && visualizarDocenteParticipante && visualizarDocumentacion && visualizarEstado
                && visualizarEstudianteParticipante && visualizarEvaluacionFinal && visualizarLineaInvestigacion
                && visualizarParroquia && visualizarPresupuesto && visualizarPrograma && visualizarProvincia
                && visualizarTipoProyecto) {
            visualizarTodos = true;
        }
        visualizarTodos = false;
    }

    public boolean isVisualizarCobertura() {
        return visualizarCobertura;
    }

    public void setVisualizarCobertura(boolean visualizarCobertura) {
        this.visualizarCobertura = visualizarCobertura;
    }

    public boolean isVisualizarFechaInicio() {
        return visualizarFechaInicio;
    }

    public void setVisualizarFechaInicio(boolean visualizarFechaInicio) {
        this.visualizarFechaInicio = visualizarFechaInicio;
    }

    public boolean isVisualizarFechaFinalizacion() {
        return visualizarFechaFinalizacion;
    }

    public void setVisualizarFechaFinalizacion(boolean visualizarFechaFinalizacion) {
        this.visualizarFechaFinalizacion = visualizarFechaFinalizacion;
    }

    private Integer tipoReporte;

    public Integer getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(Integer tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public void cambiarTipoReporte() {
        if (tipoReporte == 1) {
            proyectoList = proyectoFacade.findByPorAutorizarConsejoAcadémico();
            for (Proyecto p : proyectoList) {
                p.setNombre(p.getNombre().toUpperCase());
            }
        } else {
            proyectoList = null;
        }

    }
}
