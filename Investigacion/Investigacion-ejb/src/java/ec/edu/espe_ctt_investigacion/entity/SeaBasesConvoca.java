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
@Table(name = "SEA_BASES_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaBasesConvoca.findAll", query = "SELECT s FROM SeaBasesConvoca s"),
    @NamedQuery(name = "SeaBasesConvoca.findBySbcId", query = "SELECT s FROM SeaBasesConvoca s WHERE s.sbcId = :sbcId"),
    @NamedQuery(name = "SeaBasesConvoca.findBySbcBases", query = "SELECT s FROM SeaBasesConvoca s WHERE s.sbcBases = :sbcBases")})
public class SeaBasesConvoca implements Serializable {
 private static final long serialVersionUID = 1L;
     @SequenceGenerator(name = "SEQ_SEA_BASES_CONVOCA", sequenceName = "SEQ_SEA_BASES_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_BASES_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SBC_ID")
    private BigDecimal sbcId;
    @Size(max = 500)
    @Column(name = "SBC_BASES")
    private String sbcBases;
     @Column(name = "SBC_ORDEN")
    private BigInteger sbcOrden;
    @Size(max = 1)
    @Column(name = "SBC_ORDENS")
    private String sbcOrdens;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;

    public SeaBasesConvoca() {
    }

    public SeaBasesConvoca(BigDecimal sbcId) {
        this.sbcId = sbcId;
    }

    public BigDecimal getSbcId() {
        return sbcId;
    }

    public void setSbcId(BigDecimal sbcId) {
        this.sbcId = sbcId;
    }

    public String getSbcBases() {
        return sbcBases;
    }

    public void setSbcBases(String sbcBases) {
        this.sbcBases = sbcBases;
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
        hash += (sbcId != null ? sbcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaBasesConvoca)) {
            return false;
        }
        SeaBasesConvoca other = (SeaBasesConvoca) object;
        if ((this.sbcId == null && other.sbcId != null) || (this.sbcId != null && !this.sbcId.equals(other.sbcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaBasesConvoca[ sbcId=" + sbcId + " ]";
    }

    public BigInteger getSbcOrden() {
        return sbcOrden;
    }

    public void setSbcOrden(BigInteger sbcOrden) {
        this.sbcOrden = sbcOrden;
    }

    public String getSbcOrdens() {
        return sbcOrdens;
    }

    public void setSbcOrdens(String sbcOrdens) {
        this.sbcOrdens = sbcOrdens;
    }
    
}
