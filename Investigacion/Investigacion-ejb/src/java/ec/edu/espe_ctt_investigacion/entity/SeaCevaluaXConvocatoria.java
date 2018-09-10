/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SEA_CEVALUA_X_CONVOCATORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaCevaluaXConvocatoria.findAll", query = "SELECT s FROM SeaCevaluaXConvocatoria s"),
    @NamedQuery(name = "SeaCevaluaXConvocatoria.findByScexcId", query = "SELECT s FROM SeaCevaluaXConvocatoria s WHERE s.scexcId = :scexcId"),
    @NamedQuery(name = "SeaCevaluaXConvocatoria.findByScexcCalificacion", query = "SELECT s FROM SeaCevaluaXConvocatoria s WHERE s.scexcCalificacion = :scexcCalificacion"),
    @NamedQuery(name = "SeaCevaluaXConvocatoria.findByPrdId", query = "SELECT s FROM SeaCevaluaXConvocatoria s WHERE s.prdId = :prdId")})

public class SeaCevaluaXConvocatoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_CEVALUA_X_CONVOCATORIA", sequenceName = "SEQ_SEA_CEVALUA_X_CONVOCATORIA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_CEVALUA_X_CONVOCATORIA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCEXC_ID")
    private BigDecimal scexcId;
    @Column(name = "SCEXC_CALIFICACION")
    private BigDecimal scexcCalificacion;
//    @Column(name = "PRD_ID")
//    private BigInteger prdId;
//    @JoinColumn(name = "SCE_ID", referencedColumnName = "SCE_ID")
//    @ManyToOne
//    private SeaCriteriosEvalua sceId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
//    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
//    @ManyToOne
//    private SeaConvoca convocaId;
    @Column(name = "SCEXC_JUSTIFICACION")
    private String scexcjustificacion;
    @Size(max = 500)

    public SeaCevaluaXConvocatoria() {
    }

    public SeaCevaluaXConvocatoria(BigDecimal scexcId) {
        this.scexcId = scexcId;
    }

    public BigDecimal getScexcId() {
        return scexcId;
    }

    public void setScexcId(BigDecimal scexcId) {
        this.scexcId = scexcId;
    }

    public BigDecimal getScexcCalificacion() {
        return scexcCalificacion;
    }

    public void setScexcCalificacion(BigDecimal scexcCalificacion) {
        this.scexcCalificacion = scexcCalificacion;
    }

//    public BigInteger getPrdId() {
//        return prdId;
//    }
//
//    public void setPrdId(BigInteger prdId) {
//        this.prdId = prdId;
//    }
    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

//    public SeaCriteriosEvalua getSceId() {
//        return sceId;
//    }
//
//    public void setSceId(SeaCriteriosEvalua sceId) {
//        this.sceId = sceId;
//    }

    public String getScexcjustificacion() {
        return scexcjustificacion;
    }

    public void setScexcjustificacion(String scexcjustificacion) {
        this.scexcjustificacion = scexcjustificacion;
    }

//    public SeaConvoca getConvocaId() {
//        return convocaId;
//    }
//
//    public void setConvocaId(SeaConvoca convocaId) {
//        this.convocaId = convocaId;
//    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scexcId != null ? scexcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaCevaluaXConvocatoria)) {
            return false;
        }
        SeaCevaluaXConvocatoria other = (SeaCevaluaXConvocatoria) object;
        if ((this.scexcId == null && other.scexcId != null) || (this.scexcId != null && !this.scexcId.equals(other.scexcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaCevaluaXConvocatoria[ scexcId=" + scexcId + " ]";
    }
    
}
