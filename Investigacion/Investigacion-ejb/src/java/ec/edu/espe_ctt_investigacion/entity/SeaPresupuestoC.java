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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_PRESUPUESTO_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaPresupuestoC.findAll", query = "SELECT s FROM SeaPresupuestoC s"),
    @NamedQuery(name = "SeaPresupuestoC.findBySpcId", query = "SELECT s FROM SeaPresupuestoC s WHERE s.spcId = :spcId"),
    @NamedQuery(name = "SeaPresupuestoC.findBySpcValorAsigna", query = "SELECT s FROM SeaPresupuestoC s WHERE s.spcValorAsigna = :spcValorAsigna")})
public class SeaPresupuestoC implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_PRESUPUESTO_C", sequenceName = "SEQ_SEA_PRESUPUESTO_C", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PRESUPUESTO_C")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPC_ID")
    private BigDecimal spcId;
    @Column(name = "SPC_VALOR_ASIGNA")
    private BigInteger spcValorAsigna;
    @JoinColumn(name = "SRC_ID", referencedColumnName = "SRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaRecursosConvoca srcId;
    @JoinColumn(name = "SFC_ID", referencedColumnName = "SFC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFinanciaConvoca sfcId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpId;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    /*
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpId;
    */

    public SeaPresupuestoC() {
    }

    public SeaPresupuestoC(BigDecimal spcId) {
        this.spcId = spcId;
    }

    public BigDecimal getSpcId() {
        return spcId;
    }

    public void setSpcId(BigDecimal spcId) {
        this.spcId = spcId;
    }

    public BigInteger getSpcValorAsigna() {
        return spcValorAsigna;
    }

    public void setSpcValorAsigna(BigInteger spcValorAsigna) {
        this.spcValorAsigna = spcValorAsigna;
    }

    public SeaRecursosConvoca getSrcId() {
        return srcId;
    }

    public void setSrcId(SeaRecursosConvoca srcId) {
        this.srcId = srcId;
    }

    public SeaFinanciaConvoca getSfcId() {
        return sfcId;
    }

    public void setSfcId(SeaFinanciaConvoca sfcId) {
        this.sfcId = sfcId;
    }

    public SeaConvoca getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(SeaConvoca convocaId) {
        this.convocaId = convocaId;
    }

    public SeaClasificadorPresup getScpId() {
        return scpId;
    }

    public void setScpId(SeaClasificadorPresup scpId) {
        this.scpId = scpId;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spcId != null ? spcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaPresupuestoC)) {
            return false;
        }
        SeaPresupuestoC other = (SeaPresupuestoC) object;
        if ((this.spcId == null && other.spcId != null) || (this.spcId != null && !this.spcId.equals(other.spcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaPresupuestoC[ spcId=" + spcId + " ]";
    }
    
}
