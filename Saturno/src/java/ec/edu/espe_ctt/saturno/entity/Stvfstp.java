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
@Table(name = "STVFSTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvfstp.findAll", query = "SELECT s FROM Stvfstp s"),
    @NamedQuery(name = "Stvfstp.findByStvfstpCode", query = "SELECT s FROM Stvfstp s WHERE s.stvfstpCode = :stvfstpCode"),
    @NamedQuery(name = "Stvfstp.findByStvfstpDesc", query = "SELECT s FROM Stvfstp s WHERE s.stvfstpDesc = :stvfstpDesc"),
    @NamedQuery(name = "Stvfstp.findByStvfstpActivityDate", query = "SELECT s FROM Stvfstp s WHERE s.stvfstpActivityDate = :stvfstpActivityDate")})
public class Stvfstp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVFSTP_CODE")
    private String stvfstpCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVFSTP_DESC")
    private String stvfstpDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVFSTP_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvfstpActivityDate;

    public Stvfstp() {
    }

    public Stvfstp(String stvfstpCode) {
        this.stvfstpCode = stvfstpCode;
    }

    public Stvfstp(String stvfstpCode, String stvfstpDesc, Date stvfstpActivityDate) {
        this.stvfstpCode = stvfstpCode;
        this.stvfstpDesc = stvfstpDesc;
        this.stvfstpActivityDate = stvfstpActivityDate;
    }

    public String getStvfstpCode() {
        return stvfstpCode;
    }

    public void setStvfstpCode(String stvfstpCode) {
        this.stvfstpCode = stvfstpCode;
    }

    public String getStvfstpDesc() {
        return stvfstpDesc;
    }

    public void setStvfstpDesc(String stvfstpDesc) {
        this.stvfstpDesc = stvfstpDesc;
    }

    public Date getStvfstpActivityDate() {
        return stvfstpActivityDate;
    }

    public void setStvfstpActivityDate(Date stvfstpActivityDate) {
        this.stvfstpActivityDate = stvfstpActivityDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvfstpCode != null ? stvfstpCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvfstp)) {
            return false;
        }
        Stvfstp other = (Stvfstp) object;
        if ((this.stvfstpCode == null && other.stvfstpCode != null) || (this.stvfstpCode != null && !this.stvfstpCode.equals(other.stvfstpCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvfstp[ stvfstpCode=" + stvfstpCode + " ]";
    }
    
}
