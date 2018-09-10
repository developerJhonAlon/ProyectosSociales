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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAEVALEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtaevalest.findAll", query = "SELECT s FROM Szdtaevalest s"),
    @NamedQuery(name = "Szdtaevalest.findBySzdtaevalestCode", query = "SELECT s FROM Szdtaevalest s WHERE s.szdtaevalestCode = :szdtaevalestCode"),
    @NamedQuery(name = "Szdtaevalest.findBySzdtaevalestAnalpa", query = "SELECT s FROM Szdtaevalest s WHERE s.szdtaevalestAnalpa = :szdtaevalestAnalpa")})
public class Szdtaevalest implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAEVALEST", sequenceName = "SEQ_SZDTAEVALEST", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAEVALEST")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAEVALEST_CODE")
    private BigDecimal szdtaevalestCode;
    @Size(max = 4000)
    @Column(name = "SZDTAEVALEST_ANALPA")
    private String szdtaevalestAnalpa;
    @JoinColumn(name = "SESF_ID", referencedColumnName = "SESF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaEstudiantesFormato sesfId;
    @JoinColumn(name = "PRD_ID_TIPOEV", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public Szdtaevalest() {
    }

    public Szdtaevalest(BigDecimal szdtaevalestCode) {
        this.szdtaevalestCode = szdtaevalestCode;
    }

    public BigDecimal getSzdtaevalestCode() {
        return szdtaevalestCode;
    }

    public void setSzdtaevalestCode(BigDecimal szdtaevalestCode) {
        this.szdtaevalestCode = szdtaevalestCode;
    }

    public String getSzdtaevalestAnalpa() {
        return szdtaevalestAnalpa;
    }

    public void setSzdtaevalestAnalpa(String szdtaevalestAnalpa) {
        this.szdtaevalestAnalpa = szdtaevalestAnalpa;
    }

    public SeaEstudiantesFormato getSesfId() {
        return sesfId;
    }

    public void setSesfId(SeaEstudiantesFormato sesfId) {
        this.sesfId = sesfId;
    }
    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
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
        hash += (szdtaevalestCode != null ? szdtaevalestCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtaevalest)) {
            return false;
        }
        Szdtaevalest other = (Szdtaevalest) object;
        if ((this.szdtaevalestCode == null && other.szdtaevalestCode != null) || (this.szdtaevalestCode != null && !this.szdtaevalestCode.equals(other.szdtaevalestCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtaevalest[ szdtaevalestCode=" + szdtaevalestCode + " ]";
    }
    
}
