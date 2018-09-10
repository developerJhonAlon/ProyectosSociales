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
@Table(name = "SEA_NO_FINANCIA_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaNoFinanciaConvoca.findAll", query = "SELECT s FROM SeaNoFinanciaConvoca s"),
    @NamedQuery(name = "SeaNoFinanciaConvoca.findBySnfcId", query = "SELECT s FROM SeaNoFinanciaConvoca s WHERE s.snfcId = :snfcId"),
    @NamedQuery(name = "SeaNoFinanciaConvoca.findBySnfcDetalle", query = "SELECT s FROM SeaNoFinanciaConvoca s WHERE s.snfcDetalle = :snfcDetalle"),
    @NamedQuery(name = "SeaNoFinanciaConvoca.findBySfncOrden", query = "SELECT s FROM SeaNoFinanciaConvoca s WHERE s.sfncOrden = :sfncOrden")})
public class SeaNoFinanciaConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @SequenceGenerator(name = "SEQ_SEA_NO_FINANCIA_CONVOCA", sequenceName = "SEQ_SEA_NO_FINANCIA_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_NO_FINANCIA_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SNFC_ID")
    private BigDecimal snfcId;
    @Size(max = 500)
    @Column(name = "SNFC_DETALLE")
    private String snfcDetalle;
    @Column(name = "SFNC_ORDEN")
    private BigInteger sfncOrden;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    
    public SeaNoFinanciaConvoca() {
    }

    public SeaNoFinanciaConvoca(BigDecimal snfcId) {
        this.snfcId = snfcId;
    }

    public BigDecimal getSnfcId() {
        return snfcId;
    }

    public void setSnfcId(BigDecimal snfcId) {
        this.snfcId = snfcId;
    }

    public String getSnfcDetalle() {
        return snfcDetalle;
    }

    public void setSnfcDetalle(String snfcDetalle) {
        this.snfcDetalle = snfcDetalle;
    }

    public BigInteger getSfncOrden() {
        return sfncOrden;
    }

    public void setSfncOrden(BigInteger sfncOrden) {
        this.sfncOrden = sfncOrden;
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
        hash += (snfcId != null ? snfcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaNoFinanciaConvoca)) {
            return false;
        }
        SeaNoFinanciaConvoca other = (SeaNoFinanciaConvoca) object;
        if ((this.snfcId == null && other.snfcId != null) || (this.snfcId != null && !this.snfcId.equals(other.snfcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaNoFinanciaConvoca[ snfcId=" + snfcId + " ]";
    }
    
}
