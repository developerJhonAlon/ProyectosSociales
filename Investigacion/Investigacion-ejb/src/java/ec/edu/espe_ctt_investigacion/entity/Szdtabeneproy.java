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
@Table(name = "SZDTABENEPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtabeneproy.findAll", query = "SELECT s FROM Szdtabeneproy s"),
    @NamedQuery(name = "Szdtabeneproy.findBySzdtabeneproyCode", query = "SELECT s FROM Szdtabeneproy s WHERE s.szdtabeneproyCode = :szdtabeneproyCode"),
    @NamedQuery(name = "Szdtabeneproy.findBySzdtabeneproyNombres", query = "SELECT s FROM Szdtabeneproy s WHERE s.szdtabeneproyNombres = :szdtabeneproyNombres"),
    @NamedQuery(name = "Szdtabeneproy.findBySzdtabeneproyFechaCrea", query = "SELECT s FROM Szdtabeneproy s WHERE s.szdtabeneproyFechaCrea = :szdtabeneproyFechaCrea")})
public class Szdtabeneproy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTABENEPROY", sequenceName = "SEQ_SZDTABENEPROY", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTABENEPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTABENEPROY_CODE")
    private BigDecimal szdtabeneproyCode;
    @Size(max = 2000)
    @Column(name = "SZDTABENEPROY_NOMBRES")
    private String szdtabeneproyNombres;
    @Column(name = "SZDTABENEPROY_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date szdtabeneproyFechaCrea;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public Szdtabeneproy() {
    }

    public Szdtabeneproy(BigDecimal szdtabeneproyCode) {
        this.szdtabeneproyCode = szdtabeneproyCode;
    }

    public BigDecimal getSzdtabeneproyCode() {
        return szdtabeneproyCode;
    }

    public void setSzdtabeneproyCode(BigDecimal szdtabeneproyCode) {
        this.szdtabeneproyCode = szdtabeneproyCode;
    }

    public String getSzdtabeneproyNombres() {
        return szdtabeneproyNombres;
    }

    public void setSzdtabeneproyNombres(String szdtabeneproyNombres) {
        this.szdtabeneproyNombres = szdtabeneproyNombres;
    }

    public Date getSzdtabeneproyFechaCrea() {
        return szdtabeneproyFechaCrea;
    }

    public void setSzdtabeneproyFechaCrea(Date szdtabeneproyFechaCrea) {
        this.szdtabeneproyFechaCrea = szdtabeneproyFechaCrea;
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
        hash += (szdtabeneproyCode != null ? szdtabeneproyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtabeneproy)) {
            return false;
        }
        Szdtabeneproy other = (Szdtabeneproy) object;
        if ((this.szdtabeneproyCode == null && other.szdtabeneproyCode != null) || (this.szdtabeneproyCode != null && !this.szdtabeneproyCode.equals(other.szdtabeneproyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtabeneproy[ szdtabeneproyCode=" + szdtabeneproyCode + " ]";
    }
    
}
