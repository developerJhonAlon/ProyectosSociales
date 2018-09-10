/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_FINANCIA_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFinanciaConvoca.findAll", query = "SELECT s FROM SeaFinanciaConvoca s"),
    @NamedQuery(name = "SeaFinanciaConvoca.findBySfcId", query = "SELECT s FROM SeaFinanciaConvoca s WHERE s.sfcId = :sfcId"),
    @NamedQuery(name = "SeaFinanciaConvoca.findBySfcPorcentaje", query = "SELECT s FROM SeaFinanciaConvoca s WHERE s.sfcPorcentaje = :sfcPorcentaje")})
public class SeaFinanciaConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @SequenceGenerator(name = "SEQ_SEA_FINANCIA_CONVOCA", sequenceName = "SEQ_SEA_FINANCIA_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FINANCIA_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFC_ID")
    private BigDecimal sfcId;
    @Column(name = "SFC_PORCENTAJE")
    private BigInteger sfcPorcentaje;
    @OneToMany(mappedBy = "sfcId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPresupuestoC> seaPresupuestoCList;
    @JoinColumn(name = "SRC_ID", referencedColumnName = "SRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaRecursosConvoca srcId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    
    public SeaFinanciaConvoca() {
    }

    public SeaFinanciaConvoca(BigDecimal sfcId) {
        this.sfcId = sfcId;
    }

    public BigDecimal getSfcId() {
        return sfcId;
    }

    public void setSfcId(BigDecimal sfcId) {
        this.sfcId = sfcId;
    }

    public BigInteger getSfcPorcentaje() {
        return sfcPorcentaje;
    }

    public void setSfcPorcentaje(BigInteger sfcPorcentaje) {
        this.sfcPorcentaje = sfcPorcentaje;
    }

    @XmlTransient
    public List<SeaPresupuestoC> getSeaPresupuestoCList() {
        return seaPresupuestoCList;
    }

    public void setSeaPresupuestoCList(List<SeaPresupuestoC> seaPresupuestoCList) {
        this.seaPresupuestoCList = seaPresupuestoCList;
    }

    public SeaRecursosConvoca getSrcId() {
        return srcId;
    }

    public void setSrcId(SeaRecursosConvoca srcId) {
        this.srcId = srcId;
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
        hash += (sfcId != null ? sfcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFinanciaConvoca)) {
            return false;
        }
        SeaFinanciaConvoca other = (SeaFinanciaConvoca) object;
        if ((this.sfcId == null && other.sfcId != null) || (this.sfcId != null && !this.sfcId.equals(other.sfcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaFinanciaConvoca[ sfcId=" + sfcId + " ]";
    }
    
    public BigDecimal getValor() {
        try {
            return ((new BigDecimal(sfcPorcentaje)).multiply(convocaId.getConvocaFinanciamiento())).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);            
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
        
    }

}
