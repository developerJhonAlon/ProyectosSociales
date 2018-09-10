/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "STVTOPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvtops.findAll", query = "SELECT s FROM Stvtops s"),
    @NamedQuery(name = "Stvtops.findByStvtopsCode", query = "SELECT s FROM Stvtops s WHERE s.stvtopsCode = :stvtopsCode"),
    @NamedQuery(name = "Stvtops.findByStvtopsDesc", query = "SELECT s FROM Stvtops s WHERE s.stvtopsDesc = :stvtopsDesc"),
    @NamedQuery(name = "Stvtops.findByStvtopsActivityDate", query = "SELECT s FROM Stvtops s WHERE s.stvtopsActivityDate = :stvtopsActivityDate")})
public class Stvtops implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "STVTOPS_CODE")
    private String stvtopsCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVTOPS_DESC")
    private String stvtopsDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTOPS_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtopsActivityDate;

    public Stvtops() {
    }

    public Stvtops(String stvtopsCode) {
        this.stvtopsCode = stvtopsCode;
    }

    public Stvtops(String stvtopsCode, String stvtopsDesc, Date stvtopsActivityDate) {
        this.stvtopsCode = stvtopsCode;
        this.stvtopsDesc = stvtopsDesc;
        this.stvtopsActivityDate = stvtopsActivityDate;
    }

    public String getStvtopsCode() {
        return stvtopsCode;
    }

    public void setStvtopsCode(String stvtopsCode) {
        this.stvtopsCode = stvtopsCode;
    }

    public String getStvtopsDesc() {
        return stvtopsDesc;
    }

    public void setStvtopsDesc(String stvtopsDesc) {
        this.stvtopsDesc = stvtopsDesc;
    }

    public Date getStvtopsActivityDate() {
        return stvtopsActivityDate;
    }

    public void setStvtopsActivityDate(Date stvtopsActivityDate) {
        this.stvtopsActivityDate = stvtopsActivityDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvtopsCode != null ? stvtopsCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvtops)) {
            return false;
        }
        Stvtops other = (Stvtops) object;
        if ((this.stvtopsCode == null && other.stvtopsCode != null) || (this.stvtopsCode != null && !this.stvtopsCode.equals(other.stvtopsCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvtops[ stvtopsCode=" + stvtopsCode + " ]";
    }
    
}
