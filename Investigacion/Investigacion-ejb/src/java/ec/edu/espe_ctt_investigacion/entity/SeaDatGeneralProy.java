/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_DAT_GENERAL_PROY")
@XmlRootElement
public class SeaDatGeneralProy implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_DAT_GENERAL_PROY", sequenceName = "SEQ_SEA_DAT_GENERAL_PROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_DAT_GENERAL_PROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATGEPROY_ID")
    private BigDecimal datgeproyId;

    
    /*@Version
    @Column(name = "DATGEPROY_VERSION")
    private Long version;*/
    
    @Lob
    @Column(name = "DATGEPROY_PLAN_DIGI")
    private byte[] datgeproyPlanDigi;
    @Lob
    @Column(name = "DATGEPROY_PAGLEG_DIGI")
    private byte[] datgeproyPaglegDigi;
    @OneToMany(mappedBy = "datgeproyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupnc> seaTotalPresupncList;

    @OneToMany(mappedBy = "datgeproyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPresupNotasc> seaPresupNotascList;

    @Size(max = 20)
    @Column(name = "DATGEPROY_TIEMPO_EJECUCION")
    private String datgeproyTiempoEjecucion;
    @Size(max = 2000)
    @Column(name = "DATGEPROY_TITULO")
    private String datgeproyTitulo;
    @Column(name = "DATGEPROY_FINANCIA_TOTAL")
    private BigDecimal datgeproyFinanciaTotal;
    @Column(name = "DATGEPROY_FINANCIA_OTRAS")
    private BigDecimal datgeproyFinanciaOtras;
    @Lob
    @Column(name = "DATGEPROY_PRESUPUESTO")
    private Serializable datgeproyPresupuesto;
    @Size(max = 25)
    @Column(name = "DATGEPROY_PRESUPUESTO_ARCHI")
    private String datgeproyPresupuestoArchi;
    @Column(name = "DATGEPROY_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datgeproyFechaCreacion;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_RESUMEN")
    private String datgeproyResumen;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_DESCRIP")
    private String datgeproyDescrip;
    @Lob
    @Column(name = "DATGEPROY_OBJETIVO")
    private String datgeproyObjetivo;
//    @Size(max = 4000)
//    @Column(name = "DATGEPROY_OBJETIVO")
//    private String datgeproyObjetivo;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_JUSTIFICACION")
    private String datgeproyJustificacion;
    @Lob
    @Column(name = "DATGEPROY_METODOLOGIA")
    private String datgeproyMetodologia;
//    @Size(max = 4000)
//    @Column(name = "DATGEPROY_METODOLOGIA")
//    private String datgeproyMetodologia;
    @Size(max = 500)
    @Column(name = "DATGEPROY_PLANT_NOMBRE")
    private String datgeproyPlantNombre;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_RESULTADO_ESPERA")
    private String datgeproyResultadoEspera;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_CONSIDERACIONES")
    private String datgeproyConsideraciones;
    /*@Size(max = 4000)
    @Column(name = "DATGEPROY_MONITOREO_EVALUA")
    private String datgeproyMonitoreoEvalua;*/
    @Size(max = 4000)
    @Column(name = "DATGEPROY_CONSECUENCIAS")
    private String datgeproyConsecuencias;
    @Size(max = 4000)
    @Column(name = "DATGEPROY_TRANSFER_RESULT")
    private String datgeproyTransferResult;
    @Lob
    @Column(name = "DATGEPROY_IMPACTO_RESULT")
    private String datgeproyImpactoResult;
//    @Size(max = 4000)
//    @Column(name = "DATGEPROY_IMPACTO_RESULT")
//    private String datgeproyImpactoResult;
    @Size(max = 500)
    @Column(name = "DATGEPROY_PAGILEG_NOMBRE")
    private String datgeproyPagilegNombre;
    /*@Column(name = "DATGEPROY_MONTO_TOTAL")
    private BigDecimal datgeproyMontoTotal;
    @Column(name = "DATGEPROY_MONTO_OTRA_INST")
    private BigDecimal datgeproyMontoOtraInst;*/
    @Column(name = "DATGEPROY_ESTADO")
    private Character datgeproyEstado;
    public final static Character ESTADO_INGRESO_PERFIL = 'A';
    public final static Character ESTADO_ELIMINADO = 'B';
    public final static Character ESTADO_FINALIZADO_PERFIL = 'C';
    public final static Character ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO = 'D';
    public final static Character ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO = 'E';
    public final static Character ESTADO_RECHAZADO_COMISION = 'F';
    public final static Character ESTADO_APROBADO_COMISION = 'G';
    public final static Character ESTADO_ASIGNADO_PAR = 'H';
    public final static Character ESTADO_EVALUADO_PAR = 'I';
    public final static Character ESTADO_RECHAZADO_CONSEJO = 'J';
    public final static Character ESTADO_APROBADO_CONSEJO = 'K';
    
    
    /*public final static Character ESTADO_INGRESO_PERFIL = '0';
    public final static Character ESTADO_ELIMINADO = '1';
    public final static Character ESTADO_FINALIZADO_PERFIL = '2';
    public final static Character ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO = '3';
    public final static Character ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO = '4';
    public final static Character ESTADO_APROBADO_COMISION = '5';
    public final static Character ESTADO_RECHAZADO_COMISION = '6';
    public final static Character ESTADO_FINALIZADO_FORMATO_EXTENSO = '7';
    public final static Character ESTADO_EVALUADO_PAR = '8';
    public final static Character ESTADO_APROBADO_CONSEJO = '9';
    public final static Character ESTADO_RECHAZADO_CONSEJO = 'X';*/

    
    /*public final static Character ESTADO_INGRESO_PERFIL = 'I'; //Ingresado
    public final static Character ESTADO_ELIMINADO = 'E'; //Eliminado    
    public final static Character ESTADO_FINALIZADO_PERFIL = 'F'; //
    public final static Character ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO = 'A';  //Aceptado por el Director de Departamento
    public final static Character ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO = 'D';  //
    public final static Character ESTADO_APROBADO_COMISION = 'C';  //Aprobado por Comision
    public final static Character ESTADO_RECHAZADO_COMISION = 'R';  //Rechazado por comision
    public final static Character ESTADO_EVALUADO_PAR = 'P';  //Aprobado por Par    */
    @JoinColumn(name = "PROG_ID", referencedColumnName = "PROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaPrograma progId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name = "TIPINVE_ID", referencedColumnName = "TIPINVE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaTipoInvestigacion tipinveId;
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    @JoinColumn(name = "USU_ID_CREAP", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuId;
    @Lob
    @Column(name = "DATGEPROY_ANEXOS_DIGI")
    private byte[] datgeproyAnexosDigi;
    @Size(max = 500)
    @Column(name = "DATGEPROY_ANEXOS_NOM")
    private String datgeproyAnexosNom;
    @Column(name = "DATGEPROY_FECHA_PRIORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPriorizacion;
    @OneToMany(mappedBy = "datgeproyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaResponsableProg> responsableList = new ArrayList<>();
    @OneToMany(mappedBy = "notaConceptual", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaParesConvoca> parEvaluacionList;
    @OneToMany(mappedBy = "datgeproyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaCobertura> coberturaList;
    @OneToMany(mappedBy = "notaConceptual", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionComision> calificacionComisionList;
    @OneToMany(mappedBy = "notaConceptual", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AprobacionDirectorDepartamento> aprobacionDirectorDepartamentoList;

    @OneToMany(mappedBy = "datgeproyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaDepcenproy> departamentoList;
    
    
    public SeaDatGeneralProy() {
        coberturaList = new ArrayList<>();
        coberturaList.add(new SeaCobertura(this));
        datgeproyEstado = ESTADO_INGRESO_PERFIL;
    }

    public SeaDatGeneralProy(BigDecimal datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public BigDecimal getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(BigDecimal datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public SeaTipoInvestigacion getTipinveId() {
        return tipinveId;
    }

    public void setTipinveId(SeaTipoInvestigacion tipinveId) {
        this.tipinveId = tipinveId;
    }

    public String getDatgeproyTiempoEjecucion() {
        return datgeproyTiempoEjecucion;
    }

    public void setDatgeproyTiempoEjecucion(String datgeproyTiempoEjecucion) {
        this.datgeproyTiempoEjecucion = datgeproyTiempoEjecucion;
    }

    public String getDatgeproyTitulo() {
        return datgeproyTitulo;
    }

    public void setDatgeproyTitulo(String datgeproyTitulo) {
        this.datgeproyTitulo = datgeproyTitulo;
    }

    public BigDecimal getDatgeproyFinanciaTotal() {
        return datgeproyFinanciaTotal;
    }

    public void setDatgeproyFinanciaTotal(BigDecimal datgeproyFinanciaTotal) {
        this.datgeproyFinanciaTotal = datgeproyFinanciaTotal;
    }

    public BigDecimal getDatgeproyFinanciaOtras() {
        return datgeproyFinanciaOtras;
    }

    public void setDatgeproyFinanciaOtras(BigDecimal datgeproyFinanciaOtras) {
        this.datgeproyFinanciaOtras = datgeproyFinanciaOtras;
    }

    public Serializable getDatgeproyPresupuesto() {
        return datgeproyPresupuesto;
    }

    public void setDatgeproyPresupuesto(Serializable datgeproyPresupuesto) {
        this.datgeproyPresupuesto = datgeproyPresupuesto;
    }

    public String getDatgeproyPresupuestoArchi() {
        return datgeproyPresupuestoArchi;
    }

    public void setDatgeproyPresupuestoArchi(String datgeproyPresupuestoArchi) {
        this.datgeproyPresupuestoArchi = datgeproyPresupuestoArchi;
    }

    public Date getDatgeproyFechaCreacion() {
        return datgeproyFechaCreacion;
    }

    public void setDatgeproyFechaCreacion(Date datgeproyFechaCreacion) {
        this.datgeproyFechaCreacion = datgeproyFechaCreacion;
    }

    public String getDatgeproyResumen() {
        return datgeproyResumen;
    }

    public void setDatgeproyResumen(String datgeproyResumen) {
        this.datgeproyResumen = datgeproyResumen;
    }

    public String getDatgeproyDescrip() {
        return datgeproyDescrip;
    }

    public void setDatgeproyDescrip(String datgeproyDescrip) {
        this.datgeproyDescrip = datgeproyDescrip;
    }

    public String getDatgeproyObjetivo() {
        return datgeproyObjetivo;
    }

    public void setDatgeproyObjetivo(String datgeproyObjetivo) {
        this.datgeproyObjetivo = datgeproyObjetivo;
    }

    public String getDatgeproyJustificacion() {
        return datgeproyJustificacion;
    }

    public void setDatgeproyJustificacion(String datgeproyJustificacion) {
        this.datgeproyJustificacion = datgeproyJustificacion;
    }

    public String getDatgeproyMetodologia() {
        return datgeproyMetodologia;
    }

    public void setDatgeproyMetodologia(String datgeproyMetodologia) {
        this.datgeproyMetodologia = datgeproyMetodologia;
    }

    public String getDatgeproyPlantNombre() {
        return datgeproyPlantNombre;
    }

    public void setDatgeproyPlantNombre(String datgeproyPlantNombre) {
        this.datgeproyPlantNombre = datgeproyPlantNombre;
    }

    public byte[] getDatgeproyPlanDigi() {
        return datgeproyPlanDigi;
    }

    public void setDatgeproyPlanDigi(byte[] datgeproyPlanDigi) {
        this.datgeproyPlanDigi = datgeproyPlanDigi;
    }

    public String getDatgeproyResultadoEspera() {
        return datgeproyResultadoEspera;
    }

    public void setDatgeproyResultadoEspera(String datgeproyResultadoEspera) {
        this.datgeproyResultadoEspera = datgeproyResultadoEspera;
    }

    public String getDatgeproyConsideraciones() {
        return datgeproyConsideraciones;
    }

    public void setDatgeproyConsideraciones(String datgeproyConsideraciones) {
        this.datgeproyConsideraciones = datgeproyConsideraciones;
    }

    /*public String getDatgeproyMonitoreoEvalua() {
        return datgeproyMonitoreoEvalua;
    }

    public void setDatgeproyMonitoreoEvalua(String datgeproyMonitoreoEvalua) {
        this.datgeproyMonitoreoEvalua = datgeproyMonitoreoEvalua;
    }*/

    public String getDatgeproyConsecuencias() {
        return datgeproyConsecuencias;
    }

    public void setDatgeproyConsecuencias(String datgeproyConsecuencias) {
        this.datgeproyConsecuencias = datgeproyConsecuencias;
    }

    public String getDatgeproyTransferResult() {
        return datgeproyTransferResult;
    }

    public void setDatgeproyTransferResult(String datgeproyTransferResult) {
        this.datgeproyTransferResult = datgeproyTransferResult;
    }

    public String getDatgeproyImpactoResult() {
        return datgeproyImpactoResult;
    }

    public void setDatgeproyImpactoResult(String datgeproyImpactoResult) {
        this.datgeproyImpactoResult = datgeproyImpactoResult;
    }

    public String getDatgeproyPagilegNombre() {
        return datgeproyPagilegNombre;
    }

    public void setDatgeproyPagilegNombre(String datgeproyPagilegNombre) {
        this.datgeproyPagilegNombre = datgeproyPagilegNombre;
    }

    public byte[] getDatgeproyPaglegDigi() {
        return datgeproyPaglegDigi;
    }

    public void setDatgeproyPaglegDigi(byte[] datgeproyPaglegDigi) {
        this.datgeproyPaglegDigi = datgeproyPaglegDigi;
    }

    /*public BigDecimal getDatgeproyMontoTotal() {
        return datgeproyMontoTotal;
    }

    public void setDatgeproyMontoTotal(BigDecimal datgeproyMontoTotal) {
        this.datgeproyMontoTotal = datgeproyMontoTotal;
    }

    public BigDecimal getDatgeproyMontoOtraInst() {
        return datgeproyMontoOtraInst;
    }

    public void setDatgeproyMontoOtraInst(BigDecimal datgeproyMontoOtraInst) {
        this.datgeproyMontoOtraInst = datgeproyMontoOtraInst;
    }*/

    public Character getDatgeproyEstado() {
        return datgeproyEstado;
    }

    public void setDatgeproyEstado(Character datgeproyEstado) {
        this.datgeproyEstado = datgeproyEstado;
    }

    public SeaPrograma getProgId() {
        return progId;
    }

    public void setProgId(SeaPrograma progId) {
        this.progId = progId;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    public SeaLineainves getLineaId() {
        return lineaId;
    }

    public void setLineaId(SeaLineainves lineaId) {
        this.lineaId = lineaId;
    }

    public SeaConvoca getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(SeaConvoca convocaId) {
        this.convocaId = convocaId;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }

    public byte[] getDatgeproyAnexosDigi() {
        return datgeproyAnexosDigi;
    }

    public void setDatgeproyAnexosDigi(byte[] datgeproyAnexosDigi) {
        this.datgeproyAnexosDigi = datgeproyAnexosDigi;
    }

    public String getDatgeproyAnexosNom() {
        return datgeproyAnexosNom;
    }

    public void setDatgeproyAnexosNom(String datgeproyAnexosNom) {
        this.datgeproyAnexosNom = datgeproyAnexosNom;
    }

    @XmlTransient
    public List<SeaPresupNotasc> getSeaPresupNotascList() {
        return seaPresupNotascList;
    }

    public void setSeaPresupNotascList(List<SeaPresupNotasc> seaPresupNotascList) {
        this.seaPresupNotascList = seaPresupNotascList;
    }

    @XmlTransient
    public List<SeaTotalPresupnc> getSeaTotalPresupncList() {
        return seaTotalPresupncList;
    }

    public void setSeaTotalPresupncList(List<SeaTotalPresupnc> seaTotalPresupncList) {
        this.seaTotalPresupncList = seaTotalPresupncList;
    }

    public SeaResponsableProg getDirector() {
        List<SeaResponsableProg> temp = getResponsableListByTipo(SeaTipoRespons.TIPO_DIRECTOR);
        if (!temp.isEmpty()) {
            return temp.get(0);
        }
        return null;
    }

    private List<SeaResponsableProg> getResponsableListByTipo(Integer tipoResponsable) {
        List<SeaResponsableProg> temp = new ArrayList<>();
        for (SeaResponsableProg svinResponsableProg : responsableList) {
            if (svinResponsableProg.getTipresId().getTipresId().equals(new BigDecimal(tipoResponsable))) {
                temp.add(svinResponsableProg);
            }
        }
        return temp;
    }

    public List<SeaParesConvoca> getParEvaluacionList() {
        return parEvaluacionList;
    }
    public BigDecimal getPuntajeEvaluacionPar1(){
        if (parEvaluacionList!=null && !parEvaluacionList.isEmpty()){
            return (parEvaluacionList.get(0).getPuntaje());
        }
        return null;
    }
    public BigDecimal getPuntajeEvaluacionPar2(){
        if (parEvaluacionList!=null && parEvaluacionList.size()==2){
            return (parEvaluacionList.get(1).getPuntaje());
        }
        return null;
    }
    
    public void setParEvaluacionList(List<SeaParesConvoca> parEvaluacionList) {
        this.parEvaluacionList = parEvaluacionList;
    }

    public List<SeaCobertura> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<SeaCobertura> coberturaList) {
        this.coberturaList = coberturaList;
    }

    public SeaCobertura getCobertura() {
        if (coberturaList != null && !coberturaList.isEmpty()) {
            return coberturaList.get(0);
        }
        return new SeaCobertura();
    }

    /*public void cambiarCobertura(SeaCobertura seaCobertura){
        if (coberturaList!=null && !coberturaList.isEmpty()){
            coberturaList.clear();
        }
        seaCobertura.removeAllZonaDetalle();
        seaCobertura.setDatgeproyId(this);
        coberturaList.add(seaCobertura);
    }*/
    public void addZonaDetalle(SeaZonaDetalle seaZonaDetalle) {
        getCobertura().addZonaDelatalle(seaZonaDetalle);
    }

    public List<CalificacionComision> getCalificacionComisionList() {
        return calificacionComisionList;
    }

    public void setCalificacionComisionList(List<CalificacionComision> calificacionComisionList) {
        this.calificacionComisionList = calificacionComisionList;
    }

    public CalificacionComision getCalificacionComision() {
        if (calificacionComisionList != null && !calificacionComisionList.isEmpty()) {
            return calificacionComisionList.get(0);
        }
        return null;
    }

    public AprobacionDirectorDepartamento getAprobacionDirectorDepartamento() {
        if (aprobacionDirectorDepartamentoList != null && !aprobacionDirectorDepartamentoList.isEmpty()) {
            return aprobacionDirectorDepartamentoList.get(0);
        }
        return null;
    }

    public void addCalificacionComision() {
        if (getCalificacionComision() == null) {
            if (calificacionComisionList == null) {
                calificacionComisionList = new ArrayList<>();
            }
            CalificacionComision calificacionComision = new CalificacionComision();
            calificacionComision.setNotaConceptual(this);
            calificacionComisionList.add(calificacionComision);
        }
    }

    public void addAprobacionDirectorDepartamento() {
        if (getAprobacionDirectorDepartamento() == null) {
            if (aprobacionDirectorDepartamentoList == null) {
                aprobacionDirectorDepartamentoList = new ArrayList<>();
            }
            AprobacionDirectorDepartamento aprobacionDirectorDepartamento = new AprobacionDirectorDepartamento();
            aprobacionDirectorDepartamento.setNotaConceptual(this);
            aprobacionDirectorDepartamentoList.add(aprobacionDirectorDepartamento);
        }
    }

    public String getEstadoAprobacionComisionStr() {
        if (getCalificacionComision() != null) {
            if (getCalificacionComision().getEstado().equals(CalificacionComision.ESTADO_APROBADO)) {
                return "APROBADO";
            } else {
                return "NEGADO";
            }
        }
        return "PENDIENTE";
    }

    public String getEstadoAprobacionDirectorDepartamentoStr() {
        if (getAprobacionDirectorDepartamento() != null) {
            if (getAprobacionDirectorDepartamento().getEstado().equals(AprobacionDirectorDepartamento.ESTADO_APROBADO)) {
                return "APROBADO";
            } else if (getAprobacionDirectorDepartamento().getEstado().equals(SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO.toString())) {
                return "NEGADO";
            }
        }
        return "PENDIENTE";
    }

    public String getEstado() {
        if (this.datgeproyEstado.equals(ESTADO_INGRESO_PERFIL)) {
            return "INGRESO";
        } else if (this.datgeproyEstado.equals(ESTADO_ELIMINADO)) {
            return "ELIMINADO";
        } else if (this.datgeproyEstado.equals(ESTADO_FINALIZADO_PERFIL)) {
            return "EN APROBACION POR DIRECTOR DEPARTAMENTO";
        } else if (this.datgeproyEstado.equals(ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO)) {
            return "NEGADO POR DIRECTOR DEPARTAMENTO";
        } else if (this.datgeproyEstado.equals(ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO)) {
            return "EN APROBACION POR COMISION";
        } else if (this.datgeproyEstado.equals(ESTADO_RECHAZADO_COMISION)) {
            return "NEGADO POR COMISION";
        } else if (this.datgeproyEstado.equals(ESTADO_APROBADO_COMISION)) {
            return "EN ASIGNACION DE PARES";
        } else if (this.datgeproyEstado.equals(ESTADO_ASIGNADO_PAR)) {
            return "EN EVALUACION POR PARES";
        } else if (this.datgeproyEstado.equals(ESTADO_EVALUADO_PAR)) {
            return "EN APROBACION POR CONSEJO ACADEMICO";
        } else if (this.datgeproyEstado.equals(ESTADO_RECHAZADO_CONSEJO)) {
            return "NEGADO POR CONSEJO ACADEMICO";
        } else if (this.datgeproyEstado.equals(ESTADO_APROBADO_CONSEJO)) {
            return "EJECUCION";
        }


        return "";

    }

    public List<SeaDepcenproy> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<SeaDepcenproy> departamentoList) {
        this.departamentoList = departamentoList;
    }
    /*
    public SeaDepcenproy getDepartamento(){
        if (departamentoList!=null && !departamentoList.isEmpty()){
            return departamentoList.get(0);
        }
        return null;
    }*/
    public boolean verificarEvaluacionPar() {
        if (parEvaluacionList == null || parEvaluacionList.isEmpty()) {
            return false;
        }
        for (SeaParesConvoca p : parEvaluacionList) {
            if (p.getEvaluacionList() == null
                    || p.getEvaluacionList().isEmpty()
                    || p.getEvaluacionList().get(0).getEstadoFinalizado() == null
                    || p.getEvaluacionList().get(0).getEstadoFinalizado().equals(EvaluacionPar.ESTADO_FINALIZADO_NO)) {
                return false;
            }
        }
        return true;
    }

    @Transient
    private ConfiguracionParametrosEvaluacionInv configParametrosEvaluacion;

    public ConfiguracionParametrosEvaluacionInv getConfigParametrosEvaluacion() {
        return configParametrosEvaluacion;
    }

    public void setConfigParametrosEvaluacion(ConfiguracionParametrosEvaluacionInv configParametrosEvaluacion) {
        this.configParametrosEvaluacion = configParametrosEvaluacion;
    }

    public void setearPuntaje() {
        for (ParametroEvaluacionInv p : configParametrosEvaluacion.getParametroEvaluacionList()) {
            p.setPuntajeReporte(calcularPuntajePromedio(p));
            if (p.getParametroEvaluacionList() != null) {
                for (ParametroEvaluacionInv pHijo : p.getParametroEvaluacionList()) {
                    pHijo.setPuntajeReporte(calcularPuntajePromedio(pHijo));
                    /*if (pHijo.getValoracionList() != null) {
                        for (ValoracionParametroEvaluacionInv v : pHijo.getValoracionList()) {
                            v.setPuntaje(calcularPuntajePromedio(null, v));
                        }
                    }*/
                 }
            }
            /*if (p.getValoracionList() != null) {
                for (ValoracionParametroEvaluacionInv v : p.getValoracionList()) {
                    calcularPuntajePromedio(null, v);
                }
            }*/
        }

    }

    private BigDecimal calcularPuntajePromedio(ParametroEvaluacionInv parametroEvaluacionInv) {
        BigDecimal puntaje = BigDecimal.ZERO;
        for (SeaParesConvoca p : parEvaluacionList) {
            for (EvaluacionPar e : p.getEvaluacionList()) {
                for (EvaluacionParDetalle d : e.getEvaluacionDetalleList()) {
                    if (d.getParametroEvaluacion() != null && d.getParametroEvaluacion().equals(parametroEvaluacionInv) && d.getPuntaje() != null) {
                        puntaje = puntaje.add(d.getPuntaje());
                        break;
                    }
                    else{
                        if (d.getValoracionParametroEvaluacion() != null && d.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(parametroEvaluacionInv) && d.getValoracionParametroEvaluacion().getPuntaje() != null) {
                            puntaje = puntaje.add(d.getValoracionParametroEvaluacion().getPuntaje());
                            break;
                        }
                    }
                }
            }
        }
        return puntaje.divide(new BigDecimal(parEvaluacionList.size()));

    }

    public String getPuntajeStr() {
        BigDecimal result = BigDecimal.ZERO;
        if (configParametrosEvaluacion != null) {
            for (ParametroEvaluacionInv p : configParametrosEvaluacion.getParametroEvaluacionList()) {
                if (p.getPuntajeReporte()!=null){
                    result = result.add(p.getPuntajeReporte());
                }
            }
        }
        return Utils.decimalToString(result);
    }
    public String getPuntajeMaximoStr() {
        BigDecimal result = BigDecimal.ZERO;
        if (configParametrosEvaluacion != null) {
            for (ParametroEvaluacionInv p : configParametrosEvaluacion.getParametroEvaluacionList()) {
                if (p.getPuntajeMaximo()!=null){
                    result = result.add(p.getPuntajeMaximo());
                }
            }
        }
        return Utils.decimalToString(result);
    }
    
    @Transient
    private Boolean aprobado;
    @Transient
    private Boolean noAprobado;

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Boolean getNoAprobado() {
        return noAprobado;
    }

    public void setNoAprobado(Boolean noAprobado) {
        this.noAprobado = noAprobado;
    }

    public Date getFechaPriorizacion() {
        return fechaPriorizacion;
    }

    public void setFechaPriorizacion(Date fechaPriorizacion) {
        this.fechaPriorizacion = fechaPriorizacion;
    }

    /*public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }*/


    public boolean isEstadoIngresoPerfil(){
        return (this.datgeproyEstado.equals(ESTADO_INGRESO_PERFIL));
    }
    public boolean isEstadoAceptacionDirDep(){
        return (this.datgeproyEstado.equals(ESTADO_FINALIZADO_PERFIL));
    }
    public boolean isEstadoAprobacionComision(){
        return (this.datgeproyEstado.equals(ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO));
    }
    public boolean isEstadoAsignacionPares(){
        return (this.datgeproyEstado.equals(ESTADO_APROBADO_COMISION));
    }
    public boolean isEstadoEvaluacionPar(){
        return (this.datgeproyEstado.equals(ESTADO_ASIGNADO_PAR));
    }
    public String getNombresCompletosUsuario(){
        return usuId.getUsuCc() + "-" + usuId.getNombresCompletos();
    }

}
