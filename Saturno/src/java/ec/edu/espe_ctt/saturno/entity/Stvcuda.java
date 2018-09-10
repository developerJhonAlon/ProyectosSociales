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
@Table(name = "STVCUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvcuda.findAll", query = "SELECT s FROM Stvcuda s"),
    @NamedQuery(name = "Stvcuda.findByStvcudaCode", query = "SELECT s FROM Stvcuda s WHERE s.stvcudaCode = :stvcudaCode"),
    @NamedQuery(name = "Stvcuda.findByStvcudaDesc", query = "SELECT s FROM Stvcuda s WHERE s.stvcudaDesc = :stvcudaDesc"),
    @NamedQuery(name = "Stvcuda.findByStvcudaActivityDate", query = "SELECT s FROM Stvcuda s WHERE s.stvcudaActivityDate = :stvcudaActivityDate")})
public class Stvcuda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "STVCUDA_CODE")
    private String stvcudaCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVCUDA_DESC")
    private String stvcudaDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVCUDA_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvcudaActivityDate;

    public Stvcuda() {
    }

    public Stvcuda(String stvcudaCode) {
        this.stvcudaCode = stvcudaCode;
    }

    public Stvcuda(String stvcudaCode, String stvcudaDesc, Date stvcudaActivityDate) {
        this.stvcudaCode = stvcudaCode;
        this.stvcudaDesc = stvcudaDesc;
        this.stvcudaActivityDate = stvcudaActivityDate;
    }

    public String getStvcudaCode() {
        return stvcudaCode;
    }

    public void setStvcudaCode(String stvcudaCode) {
        this.stvcudaCode = stvcudaCode;
    }

    public String getStvcudaDesc() {
        return stvcudaDesc;
    }

    public void setStvcudaDesc(String stvcudaDesc) {
        this.stvcudaDesc = stvcudaDesc;
    }

    public Date getStvcudaActivityDate() {
        return stvcudaActivityDate;
    }

    public void setStvcudaActivityDate(Date stvcudaActivityDate) {
        this.stvcudaActivityDate = stvcudaActivityDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvcudaCode != null ? stvcudaCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvcuda)) {
            return false;
        }
        Stvcuda other = (Stvcuda) object;
        if ((this.stvcudaCode == null && other.stvcudaCode != null) || (this.stvcudaCode != null && !this.stvcudaCode.equals(other.stvcudaCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvcuda[ stvcudaCode=" + stvcudaCode + " ]";
    }
    
}
