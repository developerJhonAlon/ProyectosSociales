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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_EVALUA_PAR_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaEvaluaParConvoca.findAll", query = "SELECT s FROM SeaEvaluaParConvoca s"),
    @NamedQuery(name = "SeaEvaluaParConvoca.findBySepcId", query = "SELECT s FROM SeaEvaluaParConvoca s WHERE s.sepcId = :sepcId"),
    @NamedQuery(name = "SeaEvaluaParConvoca.findBySepcNota", query = "SELECT s FROM SeaEvaluaParConvoca s WHERE s.sepcNota = :sepcNota"),
    @NamedQuery(name = "SeaEvaluaParConvoca.findBySepcJustificacion", query = "SELECT s FROM SeaEvaluaParConvoca s WHERE s.sepcJustificacion = :sepcJustificacion")})
public class SeaEvaluaParConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEPC_ID")
    private BigDecimal sepcId;
    @Column(name = "SEPC_NOTA")
    private BigDecimal sepcNota;
    @Size(max = 500)
    @Column(name = "SEPC_JUSTIFICACION")
    private String sepcJustificacion;
    @JoinColumn(name = "SCE_ID", referencedColumnName = "SCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCriteriosEvalua sceId;

    public SeaEvaluaParConvoca() {
    }

    public SeaEvaluaParConvoca(BigDecimal sepcId) {
        this.sepcId = sepcId;
    }

    public BigDecimal getSepcId() {
        return sepcId;
    }

    public void setSepcId(BigDecimal sepcId) {
        this.sepcId = sepcId;
    }

    public BigDecimal getSepcNota() {
        return sepcNota;
    }

    public void setSepcNota(BigDecimal sepcNota) {
        this.sepcNota = sepcNota;
    }

    public String getSepcJustificacion() {
        return sepcJustificacion;
    }

    public void setSepcJustificacion(String sepcJustificacion) {
        this.sepcJustificacion = sepcJustificacion;
    }

    public SeaCriteriosEvalua getSceId() {
        return sceId;
    }

    public void setSceId(SeaCriteriosEvalua sceId) {
        this.sceId = sceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sepcId != null ? sepcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaEvaluaParConvoca)) {
            return false;
        }
        SeaEvaluaParConvoca other = (SeaEvaluaParConvoca) object;
        if ((this.sepcId == null && other.sepcId != null) || (this.sepcId != null && !this.sepcId.equals(other.sepcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaEvaluaParConvoca[ sepcId=" + sepcId + " ]";
    }
    
}
