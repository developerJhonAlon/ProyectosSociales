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
@Table(name = "SZDTAPRODUPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtaproduproy.findAll", query = "SELECT s FROM Szdtaproduproy s"),
    @NamedQuery(name = "Szdtaproduproy.findBySzdtaproduproyCode", query = "SELECT s FROM Szdtaproduproy s WHERE s.szdtaproduproyCode = :szdtaproduproyCode"),
    @NamedQuery(name = "Szdtaproduproy.findBySzdtaproduproyCant", query = "SELECT s FROM Szdtaproduproy s WHERE s.szdtaproduproyCant = :szdtaproduproyCant")})
public class Szdtaproduproy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAPRODUPROY", sequenceName = "SEQ_SZDTAPRODUPROY", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAPRODUPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAPRODUPROY_CODE")
    private BigDecimal szdtaproduproyCode;
    @Column(name = "SZDTAPRODUPROY_CANT")
    private BigInteger szdtaproduproyCant;
    @JoinColumn(name = "SZDTACANTPROD_CODE", referencedColumnName = "SZDTACANTPROD_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Szdtacantprod szdtacantprodCode;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public Szdtaproduproy() {
    }

    public Szdtaproduproy(BigDecimal szdtaproduproyCode) {
        this.szdtaproduproyCode = szdtaproduproyCode;
    }

    public BigDecimal getSzdtaproduproyCode() {
        return szdtaproduproyCode;
    }

    public void setSzdtaproduproyCode(BigDecimal szdtaproduproyCode) {
        this.szdtaproduproyCode = szdtaproduproyCode;
    }

    public BigInteger getSzdtaproduproyCant() {
        return szdtaproduproyCant;
    }

    public void setSzdtaproduproyCant(BigInteger szdtaproduproyCant) {
        this.szdtaproduproyCant = szdtaproduproyCant;
    }

    public Szdtacantprod getSzdtacantprodCode() {
        return szdtacantprodCode;
    }

    public void setSzdtacantprodCode(Szdtacantprod szdtacantprodCode) {
        this.szdtacantprodCode = szdtacantprodCode;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (szdtaproduproyCode != null ? szdtaproduproyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtaproduproy)) {
            return false;
        }
        Szdtaproduproy other = (Szdtaproduproy) object;
        if ((this.szdtaproduproyCode == null && other.szdtaproduproyCode != null) || (this.szdtaproduproyCode != null && !this.szdtaproduproyCode.equals(other.szdtaproduproyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtaproduproy[ szdtaproduproyCode=" + szdtaproduproyCode + " ]";
    }
    
}
