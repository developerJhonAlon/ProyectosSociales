/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_EVALUA_COMISION_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaEvaluaComisionConvoca.findAll", query = "SELECT s FROM SeaEvaluaComisionConvoca s"),
    @NamedQuery(name = "SeaEvaluaComisionConvoca.findBySeccId", query = "SELECT s FROM SeaEvaluaComisionConvoca s WHERE s.seccId = :seccId"),
    @NamedQuery(name = "SeaEvaluaComisionConvoca.findBySeccFechaEvalua", query = "SELECT s FROM SeaEvaluaComisionConvoca s WHERE s.seccFechaEvalua = :seccFechaEvalua"),
    @NamedQuery(name = "SeaEvaluaComisionConvoca.findBySeccCalificacion", query = "SELECT s FROM SeaEvaluaComisionConvoca s WHERE s.seccCalificacion = :seccCalificacion")})
public class SeaEvaluaComisionConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECC_ID")
    private BigDecimal seccId;
    @Column(name = "SECC_FECHA_EVALUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seccFechaEvalua;
    @Column(name = "SECC_CALIFICACION")
    private BigDecimal seccCalificacion;
    @JoinColumn(name = "SCE_ID", referencedColumnName = "SCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCriteriosEvalua sceId;
    @JoinColumn(name = "SCXC_ID", referencedColumnName = "SCXC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaComisionXConvoca scxcId;

    public SeaEvaluaComisionConvoca() {
    }

    public SeaEvaluaComisionConvoca(BigDecimal seccId) {
        this.seccId = seccId;
    }

    public BigDecimal getSeccId() {
        return seccId;
    }

    public void setSeccId(BigDecimal seccId) {
        this.seccId = seccId;
    }

    public Date getSeccFechaEvalua() {
        return seccFechaEvalua;
    }

    public void setSeccFechaEvalua(Date seccFechaEvalua) {
        this.seccFechaEvalua = seccFechaEvalua;
    }

    public BigDecimal getSeccCalificacion() {
        return seccCalificacion;
    }

    public void setSeccCalificacion(BigDecimal seccCalificacion) {
        this.seccCalificacion = seccCalificacion;
    }

    public SeaCriteriosEvalua getSceId() {
        return sceId;
    }

    public void setSceId(SeaCriteriosEvalua sceId) {
        this.sceId = sceId;
    }

    public SeaComisionXConvoca getScxcId() {
        return scxcId;
    }

    public void setScxcId(SeaComisionXConvoca scxcId) {
        this.scxcId = scxcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seccId != null ? seccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaEvaluaComisionConvoca)) {
            return false;
        }
        SeaEvaluaComisionConvoca other = (SeaEvaluaComisionConvoca) object;
        if ((this.seccId == null && other.seccId != null) || (this.seccId != null && !this.seccId.equals(other.seccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaEvaluaComisionConvoca[ seccId=" + seccId + " ]";
    }
    
}
