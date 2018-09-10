/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PRESUPUESTO_X_PARTIDA")
@XmlRootElement
public class PresupuestoPartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SEA_PRESUPUESTO_X_PARTIDA", sequenceName = "SEQ_SEA_PRESUPUESTO_X_PARTIDA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PRESUPUESTO_X_PARTIDA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPXP_ID")
    private BigDecimal id;
    @JoinColumn(name = "SFCR_ID", referencedColumnName = "SFCR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cronograma cronograma;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup partida;
    @Column(name = "SPXP_VALOR")
    private BigDecimal valor;
    @Column(name = "SPXP_INSTITUCION_TIPO")
    private Integer institucionTipo;
    public final static Integer INSTITUCION_TIPO_ESPE = 1;
    public final static Integer INSTITUCION_TIPO_OTROS = 2;
    @Column(name = "SPXP_INSTITUCION_NOMBRE")
    @Size(max = 100)
    private String institucionNombre;
    @Size(max = 500)
    @Column(name = "SPXP_ESPECIFICACIONES")
    private String especificacionesTecnicas;
    @Size(max = 100)
    @Column(name = "SPXP_CODINCOP")
    private String codigoCategoriaCPC;

    /*@Column(name = "SPXP_VALOTRAS")
    private BigDecimal spxpValotras;
    @Size(max = 500)
    @Column(name = "SPXP_NOMBRE_DOCUMENTO")
    private String spxpNombreDocumento;
    @Lob
    @Column(name = "SPXP_DOCUMENTO_DIGITAL")
    private byte[] spxpDocumentoDigital;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @Column(name = "SPXP_DEVENGADO")
    private BigDecimal spxpDevengado;
    @Size(max = 1000)
    @Column(name = "SPXP_FACTORD")
    private String spxpFactorD;
    @Size(max = 100)
    @Column(name = "SPXP_CODINCOP")
    private String spxpCodincop;
    @Column(name = "SPXP_VALOR_UTILIZADO")
    private BigDecimal spxpValorUtilizado;
    @Column(name = "SPXP_UTILIZADO")
    private Character spxpUtilizado;*/
    public PresupuestoPartida() {
    }

    public PresupuestoPartida(BigDecimal spxpId) {
        this.id = spxpId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public SeaClasificadorPresup getPartida() {
        return partida;
    }

    public void setPartida(SeaClasificadorPresup partida) {
        this.partida = partida;
    }

    public String getCodigoCategoriaCPC() {
        return codigoCategoriaCPC;
    }

    public void setCodigoCategoriaCPC(String codigoCategoriaCPC) {
        this.codigoCategoriaCPC = codigoCategoriaCPC;
    }

    public Integer getInstitucionTipo() {
        return institucionTipo;
    }

    public void setInstitucionTipo(Integer institucionTipo) {
        this.institucionTipo = institucionTipo;
    }

    public String getInstitucionNombre() {
        return institucionNombre;
    }

    public void setInstitucionNombre(String institucionNombre) {
        this.institucionNombre = institucionNombre;
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoPartida)) {
            return false;
        }
        PresupuestoPartida other = (PresupuestoPartida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida[ id=" + id + " ]";
    }

    public String getPartidaNombreCompleto(){
        if (partida!=null && partida.getScpId()!=null){
            return partida.getPartidaNombreCompleto();
        }
        return null;
    }
}
