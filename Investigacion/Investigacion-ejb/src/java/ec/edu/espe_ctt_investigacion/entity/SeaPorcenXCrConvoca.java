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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PORCEN_X_CR_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaPorcenXCrConvoca.findAll", query = "SELECT s FROM SeaPorcenXCrConvoca s"),
    @NamedQuery(name = "SeaPorcenXCrConvoca.findBySpxccId", query = "SELECT s FROM SeaPorcenXCrConvoca s WHERE s.spxccId = :spxccId"),
    @NamedQuery(name = "SeaPorcenXCrConvoca.findBySpxccPorcentaje", query = "SELECT s FROM SeaPorcenXCrConvoca s WHERE s.spxccPorcentaje = :spxccPorcentaje")})
public class SeaPorcenXCrConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @SequenceGenerator(name = "SEQ_SEA_PORCEN_X_CR_CONVOCA", sequenceName = "SEQ_SEA_PORCEN_X_CR_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PORCEN_X_CR_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPXCC_ID")
    private BigDecimal spxccId;
    @Column(name = "SPXCC_PORCENTAJE")
    private BigInteger spxccPorcentaje;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name = "SCE_ID", referencedColumnName = "SCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCriteriosEvalua sceId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;

    public SeaPorcenXCrConvoca() {
    }

    public SeaPorcenXCrConvoca(BigDecimal spxccId) {
        this.spxccId = spxccId;
    }

    public BigDecimal getSpxccId() {
        return spxccId;
    }

    public void setSpxccId(BigDecimal spxccId) {
        this.spxccId = spxccId;
    }

    public BigInteger getSpxccPorcentaje() {
        return spxccPorcentaje;
    }

    public void setSpxccPorcentaje(BigInteger spxccPorcentaje) {
        this.spxccPorcentaje = spxccPorcentaje;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    public SeaCriteriosEvalua getSceId() {
        return sceId;
    }

    public void setSceId(SeaCriteriosEvalua sceId) {
        this.sceId = sceId;
    }

    public SeaConvoca getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(SeaConvoca convocaId) {
        this.convocaId = convocaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spxccId != null ? spxccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaPorcenXCrConvoca)) {
            return false;
        }
        SeaPorcenXCrConvoca other = (SeaPorcenXCrConvoca) object;
        if ((this.spxccId == null && other.spxccId != null) || (this.spxccId != null && !this.spxccId.equals(other.spxccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca[ spxccId=" + spxccId + " ]";
    }
    
}
