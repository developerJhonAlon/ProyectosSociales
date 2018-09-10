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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTACANTPROD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtacantprod.findAll", query = "SELECT s FROM Szdtacantprod s"),
    @NamedQuery(name = "Szdtacantprod.findBySzdtacantprodCode", query = "SELECT s FROM Szdtacantprod s WHERE s.szdtacantprodCode = :szdtacantprodCode"),
    @NamedQuery(name = "Szdtacantprod.findBySzdtacantprodDesc", query = "SELECT s FROM Szdtacantprod s WHERE s.szdtacantprodDesc = :szdtacantprodDesc"),
    @NamedQuery(name = "Szdtacantprod.findBySzdtacantprodFechIngre", query = "SELECT s FROM Szdtacantprod s WHERE s.szdtacantprodFechIngre = :szdtacantprodFechIngre"),
    @NamedQuery(name = "Szdtacantprod.findBySzdtacantprodEstado", query = "SELECT s FROM Szdtacantprod s WHERE s.szdtacantprodEstado = :szdtacantprodEstado")})
public class Szdtacantprod implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTACANTPROD", sequenceName = "SEQ_SZDTACANTPROD", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTACANTPROD")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTACANTPROD_CODE")
    private BigDecimal szdtacantprodCode;
    @Size(max = 1000)
    @Column(name = "SZDTACANTPROD_DESC")
    private String szdtacantprodDesc;
    @Column(name = "SZDTACANTPROD_FECH_INGRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date szdtacantprodFechIngre;
    @Column(name = "SZDTACANTPROD_ESTADO")
    private Character szdtacantprodEstado;

    public Szdtacantprod() {
    }

    public Szdtacantprod(BigDecimal szdtacantprodCode) {
        this.szdtacantprodCode = szdtacantprodCode;
    }

    public BigDecimal getSzdtacantprodCode() {
        return szdtacantprodCode;
    }

    public void setSzdtacantprodCode(BigDecimal szdtacantprodCode) {
        this.szdtacantprodCode = szdtacantprodCode;
    }

    public String getSzdtacantprodDesc() {
        return szdtacantprodDesc;
    }

    public void setSzdtacantprodDesc(String szdtacantprodDesc) {
        this.szdtacantprodDesc = szdtacantprodDesc;
    }

    public Date getSzdtacantprodFechIngre() {
        return szdtacantprodFechIngre;
    }

    public void setSzdtacantprodFechIngre(Date szdtacantprodFechIngre) {
        this.szdtacantprodFechIngre = szdtacantprodFechIngre;
    }

    public Character getSzdtacantprodEstado() {
        return szdtacantprodEstado;
    }

    public void setSzdtacantprodEstado(Character szdtacantprodEstado) {
        this.szdtacantprodEstado = szdtacantprodEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (szdtacantprodCode != null ? szdtacantprodCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtacantprod)) {
            return false;
        }
        Szdtacantprod other = (Szdtacantprod) object;
        if ((this.szdtacantprodCode == null && other.szdtacantprodCode != null) || (this.szdtacantprodCode != null && !this.szdtacantprodCode.equals(other.szdtacantprodCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.Szdtacantprod[ szdtacantprodCode=" + szdtacantprodCode + " ]";
    }
    
}
