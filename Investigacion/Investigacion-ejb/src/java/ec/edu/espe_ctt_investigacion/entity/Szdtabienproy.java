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
@Table(name = "SZDTABIENPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtabienproy.findAll", query = "SELECT s FROM Szdtabienproy s"),
    @NamedQuery(name = "Szdtabienproy.findBySzdtabienproyCode", query = "SELECT s FROM Szdtabienproy s WHERE s.szdtabienproyCode = :szdtabienproyCode"),
    @NamedQuery(name = "Szdtabienproy.findBySzdtabienproyDesc", query = "SELECT s FROM Szdtabienproy s WHERE s.szdtabienproyDesc = :szdtabienproyDesc"),
    @NamedQuery(name = "Szdtabienproy.findBySzdtabienproyFechIngre", query = "SELECT s FROM Szdtabienproy s WHERE s.szdtabienproyFechIngre = :szdtabienproyFechIngre")})
public class Szdtabienproy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTABIENPROY", sequenceName = "SEQ_SZDTABIENPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTABIENPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTABIENPROY_CODE")
    private BigDecimal szdtabienproyCode;
    @Size(max = 2000)
    @Column(name = "SZDTABIENPROY_DESC")
    private String szdtabienproyDesc;
    @Column(name = "SZDTABIENPROY_FECH_INGRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date szdtabienproyFechIngre;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public Szdtabienproy() {
    }

    public Szdtabienproy(BigDecimal szdtabienproyCode) {
        this.szdtabienproyCode = szdtabienproyCode;
    }

    public BigDecimal getSzdtabienproyCode() {
        return szdtabienproyCode;
    }

    public void setSzdtabienproyCode(BigDecimal szdtabienproyCode) {
        this.szdtabienproyCode = szdtabienproyCode;
    }

    public String getSzdtabienproyDesc() {
        return szdtabienproyDesc;
    }

    public void setSzdtabienproyDesc(String szdtabienproyDesc) {
        this.szdtabienproyDesc = szdtabienproyDesc;
    }

    public Date getSzdtabienproyFechIngre() {
        return szdtabienproyFechIngre;
    }

    public void setSzdtabienproyFechIngre(Date szdtabienproyFechIngre) {
        this.szdtabienproyFechIngre = szdtabienproyFechIngre;
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
        hash += (szdtabienproyCode != null ? szdtabienproyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtabienproy)) {
            return false;
        }
        Szdtabienproy other = (Szdtabienproy) object;
        if ((this.szdtabienproyCode == null && other.szdtabienproyCode != null) || (this.szdtabienproyCode != null && !this.szdtabienproyCode.equals(other.szdtabienproyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtabienproy[ szdtabienproyCode=" + szdtabienproyCode + " ]";
    }
    
}
