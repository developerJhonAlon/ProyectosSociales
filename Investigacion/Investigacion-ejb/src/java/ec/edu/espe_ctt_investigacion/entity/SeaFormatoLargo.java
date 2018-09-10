/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvtops;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_FORMATO_LARGO")
@XmlRootElement
public class SeaFormatoLargo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_LARGO", sequenceName = "SEQ_SEA_FORMATO_LARGO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_LARGO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFL_ID")
    private BigDecimal sflId;
    @Column(name = "SFL_PRESUP_TOTAL")
    private BigDecimal sflPresupTotal;
    @Column(name = "SFL_PRESUP_RIESGO")
    private BigDecimal sflPresupRiesgo;
    @Column(name = "SFL_PRESUP_ESPE")
    private BigDecimal sflPresupEspe;
    @Column(name = "SFL_PRESUP_ENTIDAD_AUSPICIA")
    private BigDecimal sflPresupEntidadAuspicia;
    /*@OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cronograma> seaFormatoCronogramaList;*/

    @Size(max = 2000)
    @Column(name = "SFL_TITULO_ESPANIOL")
    private String sflTituloEspaniol;
    @Size(max = 2000)
    @Column(name = "SFL_TITULO_INGLES")
    private String sflTituloIngles;
    @Column(name = "SFL_FECHA_PRESENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sflFechaPresenta;
    @Column(name = "SFL_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sflFechaInicio;
    @Column(name = "SFL_FECHA_FINALIZA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sflFechaFinaliza;
//    @JoinColumn(name = "OBPLABV_ID", referencedColumnName = "OBPLABV_ID")
//    @ManyToOne
//    private SeaObplanbv obplabvId;
//    @OneToMany(mappedBy = "formtL", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SeaResponsableProg> resprogList;
    @JoinColumn(name = "STVTOPS_CODE_AC", referencedColumnName = "STVTOPS_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvtops stvtopsCode;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "SACU_ID", referencedColumnName = "SACU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaAreacUnesco sacuId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name = "PRD_ID_CATEGORIA", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdIdCategoria;
    @Lob
    @Column(name = "SFL_DIGI_FINAN")
    private byte[] sflDigiFinan;
    @Size(max = 250)
    @Column(name = "SFL_NOMBRE_FINAN")
    private String sflNombreFinan;
    @Lob
    @Column(name = "SFL_METODOLOGIA")
    private String sflMetodologia;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoProyecto> objetivoList;
    /*@OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PresupuestoPartida> seaPresupuestoXPartidaList;*/
    @OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupAnual> seaTotalPresupAnualList;
    @OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaProgramaAnual> seaProgramaAnualList;
    @OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaObjEntregables> entregableList;
    @OneToMany(mappedBy = "sflId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sztaobjbvpr> objetivoBuenVivirList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cronograma> cronogramaList;
    @Lob
    @Column(name = "SFL_BIBLIOGRAFIA")
    private String bibliografia;
    

    public SeaFormatoLargo() {
        objetivoList = new ArrayList<>();
        prdIdCategoria = new SeaParametrosDet(SeaParametrosDet.CATEGORIA_INDISPENSABLE);
    }

    public SeaFormatoLargo(BigDecimal sflId) {
        this.sflId = sflId;
    }

    public BigDecimal getSflId() {
        return sflId;
    }

    public void setSflId(BigDecimal sflId) {
        this.sflId = sflId;
    }

    public String getSflTituloEspaniol() {
        return sflTituloEspaniol;
    }

    public void setSflTituloEspaniol(String sflTituloEspaniol) {
        this.sflTituloEspaniol = sflTituloEspaniol;
    }

    public String getSflTituloIngles() {
        return sflTituloIngles;
    }

    public void setSflTituloIngles(String sflTituloIngles) {
        this.sflTituloIngles = sflTituloIngles;
    }

    public Stvtops getStvtopsCode() {
        return stvtopsCode;
    }

    public void setStvtopsCode(Stvtops stvtopsCode) {
        this.stvtopsCode = stvtopsCode;
    }

    public BigDecimal getSflPresupRiesgo() {
        return sflPresupRiesgo;
    }

    public void setSflPresupRiesgo(BigDecimal sflPresupRiesgo) {
        this.sflPresupRiesgo = sflPresupRiesgo;
    }

    public BigDecimal getSflPresupEspe() {
        return sflPresupEspe;
    }

    public void setSflPresupEspe(BigDecimal sflPresupEspe) {
        this.sflPresupEspe = sflPresupEspe;
    }

    public BigDecimal getSflPresupEntidadAuspicia() {
        return sflPresupEntidadAuspicia;
    }

    public void setSflPresupEntidadAuspicia(BigDecimal sflPresupEntidadAuspicia) {
        this.sflPresupEntidadAuspicia = sflPresupEntidadAuspicia;
    }

    public Date getSflFechaPresenta() {
        return sflFechaPresenta;
    }

    public void setSflFechaPresenta(Date sflFechaPresenta) {
        this.sflFechaPresenta = sflFechaPresenta;
    }

    public Date getSflFechaInicio() {
        return sflFechaInicio;
    }

    public void setSflFechaInicio(Date sflFechaInicio) {
        this.sflFechaInicio = sflFechaInicio;
    }

    public Date getSflFechaFinaliza() {
        return sflFechaFinaliza;
    }

    public void setSflFechaFinaliza(Date sflFechaFinaliza) {
        this.sflFechaFinaliza = sflFechaFinaliza;
    }

//    public SeaObplanbv getObplabvId() {
//        return obplabvId;
//    }
//
//    public void setObplabvId(SeaObplanbv obplabvId) {
//        this.obplabvId = obplabvId;
//    }
    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public SeaAreacUnesco getSacuId() {
        return sacuId;
    }

    public void setSacuId(SeaAreacUnesco sacuId) {
        this.sacuId = sacuId;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    public SeaParametrosDet getPrdIdCategoria() {
        return prdIdCategoria;
    }

    public void setPrdIdCategoria(SeaParametrosDet prdIdCategoria) {
        this.prdIdCategoria = prdIdCategoria;
    }

    public byte[] getSflDigiFinan() {
        return sflDigiFinan;
    }

    public void setSflDigiFinan(byte[] sflDigiFinan) {
        this.sflDigiFinan = sflDigiFinan;
    }

    public String getSflNombreFinan() {
        return sflNombreFinan;
    }

    public void setSflNombreFinan(String sflNombreFinan) {
        this.sflNombreFinan = sflNombreFinan;
    }

    public List<ObjetivoProyecto> getObjetivoList() {
        return objetivoList;
    }

    public void setObjetivoList(List<ObjetivoProyecto> objetivoList) {
        this.objetivoList = objetivoList;
    }

    public String getSflMetodologia() {
        return sflMetodologia;
    }

    public void setSflMetodologia(String sflMetodologia) {
        this.sflMetodologia = sflMetodologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sflId != null ? sflId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoLargo)) {
            return false;
        }
        SeaFormatoLargo other = (SeaFormatoLargo) object;
        if ((this.sflId == null && other.sflId != null) || (this.sflId != null && !this.sflId.equals(other.sflId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.SeaFormatoLargo[ sflId=" + sflId + " ]";
    }

    /*@XmlTransient
    public List<Cronograma> getSeaFormatoCronogramaList() {
        return seaFormatoCronogramaList;
    }

    public void setSeaFormatoCronogramaList(List<Cronograma> seaFormatoCronogramaList) {
        this.seaFormatoCronogramaList = seaFormatoCronogramaList;
    }*/

    public BigDecimal getSflPresupTotal() {
        return sflPresupTotal;
    }

    public void setSflPresupTotal(BigDecimal sflPresupTotal) {
        this.sflPresupTotal = sflPresupTotal;
    }

    public BigDecimal getPresupuestoTotal() {
        sflPresupTotal = BigDecimal.ZERO;
        if (sflPresupEntidadAuspicia != null) {
            sflPresupTotal = sflPresupTotal.add(sflPresupEntidadAuspicia);
        }
        if (sflPresupEspe != null) {
            sflPresupTotal = sflPresupTotal.add(sflPresupEspe);
        }
        if (sflPresupRiesgo != null) {
            sflPresupTotal = sflPresupTotal.add(sflPresupRiesgo);
        }
        return sflPresupTotal;
    }

    @XmlTransient
    public List<SeaProgramaAnual> getSeaProgramaAnualList() {
        return seaProgramaAnualList;
    }

    public void setSeaProgramaAnualList(List<SeaProgramaAnual> seaProgramaAnualList) {
        this.seaProgramaAnualList = seaProgramaAnualList;
    }

    @XmlTransient
    public List<SeaTotalPresupAnual> getSeaTotalPresupAnualList() {
        return seaTotalPresupAnualList;
    }

    public void setSeaTotalPresupAnualList(List<SeaTotalPresupAnual> seaTotalPresupAnualList) {
        this.seaTotalPresupAnualList = seaTotalPresupAnualList;
    }

    /*@XmlTransient
    public List<PresupuestoPartida> getSeaPresupuestoXPartidaList() {
        return seaPresupuestoXPartidaList;
    }

    public void setSeaPresupuestoXPartidaList(List<PresupuestoPartida> seaPresupuestoXPartidaList) {
        this.seaPresupuestoXPartidaList = seaPresupuestoXPartidaList;
    }*/

    public List<SeaObjEntregables> getEntregableList() {
        return entregableList;
    }

    public void setEntregableList(List<SeaObjEntregables> entregableList) {
        this.entregableList = entregableList;
    }

    public List<Sztaobjbvpr> getObjetivoBuenVivirList() {
        return objetivoBuenVivirList;
    }

    public void setObjetivoBuenVivirList(List<Sztaobjbvpr> objetivoBuenVivirList) {
        this.objetivoBuenVivirList = objetivoBuenVivirList;
    }

    public boolean existeObjetivoBuenVivir(Sztaobjbvpr objVerificar) {
        for (Sztaobjbvpr obj : objetivoBuenVivirList) {
            if (obj.getObplabvId().equals(objVerificar.getObplabvId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEstadoIngresoPerfil() {
        return (this.datgeproyId.isEstadoIngresoPerfil());
    }

    public boolean isEstadoAceptacionDirDep() {
        return (this.datgeproyId.isEstadoAceptacionDirDep());
    }

    public boolean isEstadoAprobacionComision() {
        return (this.datgeproyId.isEstadoAprobacionComision());
    }

    public boolean isEstadoAsignacionPares() {
        return (this.datgeproyId.isEstadoAsignacionPares());
    }

    public boolean isEstadoEvaluacionPar() {
        return (this.datgeproyId.isEstadoEvaluacionPar());
    }

    public String getEstado() {
        return datgeproyId.getEstado();
    }

    public String getNombresCompletosUsuario() {
        return datgeproyId.getNombresCompletosUsuario();
    }

    public String getNombre() {
        return datgeproyId.getDatgeproyTitulo();
    }

    @Transient
    private Map<BigDecimal, Boolean> estadoExpandidoObjetivo = new HashMap<BigDecimal, Boolean>();

    public Map<BigDecimal, Boolean> getEstadoExpandidoObjetivo() {
        return estadoExpandidoObjetivo;
    }

    public void setEstadoExpandidoObjetivo(Map<BigDecimal, Boolean> estadoExpandidoObjetivo) {
        this.estadoExpandidoObjetivo = estadoExpandidoObjetivo;
    }

    public void resetEstadoExpandidoObjetivo() {
        this.estadoExpandidoObjetivo = new HashMap<>();
        for (ObjetivoProyecto obj : objetivoList) {
            obj.setExpanded(!obj.getTipo().getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_FIN));
            estadoExpandidoObjetivo.put(obj.getId(), obj.isExpanded());
        }
    }

    public List<ObjetivoProyecto> getObjetivoProyectoPadreList() {
        List<ObjetivoProyecto> temp = new ArrayList<>();
        for (ObjetivoProyecto obj : objetivoList) {
            if (obj.getObjetivoPadre() == null) {
                temp.add(obj);
            }
        }
        Collections.sort(temp);
        return temp;
    }
    public void addObjetivoProyecto(ObjetivoProyecto obj) {
        objetivoList.add(obj);
    }

    public List<Cronograma> getCronogramaList() {
        return cronogramaList;
    }

    public void setCronogramaList(List<Cronograma> cronogramaList) {
        this.cronogramaList = cronogramaList;
    }
    private List<ObjetivoProyecto> getObjetivosByTipo(Long tipo) {
        List<ObjetivoProyecto> temp = new ArrayList<>();
        for (ObjetivoProyecto obj : objetivoList) {
            if (obj.getTipo().getPrdId().equals(tipo)) {
                temp.add(obj);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public List<ObjetivoProyecto> getComponentes() {
        return getObjetivosByTipo(SeaParametrosDet.TIPO_OBJETIVO_ESPECIFICO);
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

}
