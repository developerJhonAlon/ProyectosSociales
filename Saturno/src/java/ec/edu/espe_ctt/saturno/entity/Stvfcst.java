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
@Table(name = "STVFCST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvfcst.findAll", query = "SELECT s FROM Stvfcst s"),
    @NamedQuery(name = "Stvfcst.findByStvfcstCode", query = "SELECT s FROM Stvfcst s WHERE s.stvfcstCode = :stvfcstCode"),
    @NamedQuery(name = "Stvfcst.findByStvfcstDesc", query = "SELECT s FROM Stvfcst s WHERE s.stvfcstDesc = :stvfcstDesc"),
    @NamedQuery(name = "Stvfcst.findByStvfcstActiveInd", query = "SELECT s FROM Stvfcst s WHERE s.stvfcstActiveInd = :stvfcstActiveInd"),
    @NamedQuery(name = "Stvfcst.findByStvfcstActivityDate", query = "SELECT s FROM Stvfcst s WHERE s.stvfcstActivityDate = :stvfcstActivityDate")})
public class Stvfcst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STVFCST_CODE")
    private String stvfcstCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVFCST_DESC")
    private String stvfcstDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVFCST_ACTIVE_IND")
    private String stvfcstActiveInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVFCST_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvfcstActivityDate;

    public Stvfcst() {
    }

    public Stvfcst(String stvfcstCode) {
        this.stvfcstCode = stvfcstCode;
    }

    public Stvfcst(String stvfcstCode, String stvfcstDesc, String stvfcstActiveInd, Date stvfcstActivityDate) {
        this.stvfcstCode = stvfcstCode;
        this.stvfcstDesc = stvfcstDesc;
        this.stvfcstActiveInd = stvfcstActiveInd;
        this.stvfcstActivityDate = stvfcstActivityDate;
    }

    public String getStvfcstCode() {
        return stvfcstCode;
    }

    public void setStvfcstCode(String stvfcstCode) {
        this.stvfcstCode = stvfcstCode;
    }

    public String getStvfcstDesc() {
        return stvfcstDesc;
    }

    public void setStvfcstDesc(String stvfcstDesc) {
        this.stvfcstDesc = stvfcstDesc;
    }

    public String getStvfcstActiveInd() {
        return stvfcstActiveInd;
    }

    public void setStvfcstActiveInd(String stvfcstActiveInd) {
        this.stvfcstActiveInd = stvfcstActiveInd;
    }

    public Date getStvfcstActivityDate() {
        return stvfcstActivityDate;
    }

    public void setStvfcstActivityDate(Date stvfcstActivityDate) {
        this.stvfcstActivityDate = stvfcstActivityDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvfcstCode != null ? stvfcstCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvfcst)) {
            return false;
        }
        Stvfcst other = (Stvfcst) object;
        if ((this.stvfcstCode == null && other.stvfcstCode != null) || (this.stvfcstCode != null && !this.stvfcstCode.equals(other.stvfcstCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvfcst[ stvfcstCode=" + stvfcstCode + " ]";
    }
    
}
