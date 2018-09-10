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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_VALOR_X_CE_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaValorXCeConvoca.findAll", query = "SELECT s FROM SeaValorXCeConvoca s"),
    @NamedQuery(name = "SeaValorXCeConvoca.findBySvxccId", query = "SELECT s FROM SeaValorXCeConvoca s WHERE s.svxccId = :svxccId"),
    @NamedQuery(name = "SeaValorXCeConvoca.findBySvxccValor", query = "SELECT s FROM SeaValorXCeConvoca s WHERE s.svxccValor = :svxccValor")})
public class SeaValorXCeConvoca implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_VALOR_X_CE_CONVOCA", sequenceName = "SEQ_SEA_VALOR_X_CE_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_VALOR_X_CE_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVXCC_ID")
    private BigDecimal svxccId;
    @Column(name = "SVXCC_VALOR")
    private BigDecimal svxccValor;
    @JoinColumn(name = "SCE_ID", referencedColumnName = "SCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCriteriosEvalua sceId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;

    public SeaValorXCeConvoca() {
    }

    public SeaValorXCeConvoca(BigDecimal svxccId) {
        this.svxccId = svxccId;
    }

    public BigDecimal getSvxccId() {
        return svxccId;
    }

    public void setSvxccId(BigDecimal svxccId) {
        this.svxccId = svxccId;
    }

    public BigDecimal getSvxccValor() {
        return svxccValor;
    }

    public void setSvxccValor(BigDecimal svxccValor) {
        this.svxccValor = svxccValor;
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
        hash += (svxccId != null ? svxccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaValorXCeConvoca)) {
            return false;
        }
        SeaValorXCeConvoca other = (SeaValorXCeConvoca) object;
        if ((this.svxccId == null && other.svxccId != null) || (this.svxccId != null && !this.svxccId.equals(other.svxccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity1.SeaValorXCeConvoca[ svxccId=" + svxccId + " ]";
    }
    
}