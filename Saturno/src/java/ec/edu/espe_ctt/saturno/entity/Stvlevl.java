/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "STVLEVL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvlevl.findAll", query = "SELECT s FROM Stvlevl s"),
    @NamedQuery(name = "Stvlevl.findByStvlevlCode", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlCode = :stvlevlCode"),
    @NamedQuery(name = "Stvlevl.findByStvlevlDesc", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlDesc = :stvlevlDesc"),
    @NamedQuery(name = "Stvlevl.findByStvlevlActivityDate", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlActivityDate = :stvlevlActivityDate"),
    @NamedQuery(name = "Stvlevl.findByStvlevlAcadInd", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlAcadInd = :stvlevlAcadInd"),
    @NamedQuery(name = "Stvlevl.findByStvlevlCeuInd", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlCeuInd = :stvlevlCeuInd"),
    @NamedQuery(name = "Stvlevl.findByStvlevlSystemReqInd", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlSystemReqInd = :stvlevlSystemReqInd"),
    @NamedQuery(name = "Stvlevl.findByStvlevlVrMsgNo", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlVrMsgNo = :stvlevlVrMsgNo"),
    @NamedQuery(name = "Stvlevl.findByStvlevlEdiEquiv", query = "SELECT s FROM Stvlevl s WHERE s.stvlevlEdiEquiv = :stvlevlEdiEquiv")})
public class Stvlevl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STVLEVL_CODE")
    private String stvlevlCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVLEVL_DESC")
    private String stvlevlDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVLEVL_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvlevlActivityDate;
    @Size(max = 1)
    @Column(name = "STVLEVL_ACAD_IND")
    private String stvlevlAcadInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVLEVL_CEU_IND")
    private String stvlevlCeuInd;
    @Size(max = 1)
    @Column(name = "STVLEVL_SYSTEM_REQ_IND")
    private String stvlevlSystemReqInd;
    @Column(name = "STVLEVL_VR_MSG_NO")
    private Integer stvlevlVrMsgNo;
    @Size(max = 2)
    @Column(name = "STVLEVL_EDI_EQUIV")
    private String stvlevlEdiEquiv;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sfrstcrLevlCode")
    private List<Sfrstcr> sfrstcrList;

    public Stvlevl() {
    }

    public Stvlevl(String stvlevlCode) {
        this.stvlevlCode = stvlevlCode;
    }

    public Stvlevl(String stvlevlCode, String stvlevlDesc, Date stvlevlActivityDate, String stvlevlCeuInd) {
        this.stvlevlCode = stvlevlCode;
        this.stvlevlDesc = stvlevlDesc;
        this.stvlevlActivityDate = stvlevlActivityDate;
        this.stvlevlCeuInd = stvlevlCeuInd;
    }

    public String getStvlevlCode() {
        return stvlevlCode;
    }

    public void setStvlevlCode(String stvlevlCode) {
        this.stvlevlCode = stvlevlCode;
    }

    public String getStvlevlDesc() {
        return stvlevlDesc;
    }

    public void setStvlevlDesc(String stvlevlDesc) {
        this.stvlevlDesc = stvlevlDesc;
    }

    public Date getStvlevlActivityDate() {
        return stvlevlActivityDate;
    }

    public void setStvlevlActivityDate(Date stvlevlActivityDate) {
        this.stvlevlActivityDate = stvlevlActivityDate;
    }

    public String getStvlevlAcadInd() {
        return stvlevlAcadInd;
    }

    public void setStvlevlAcadInd(String stvlevlAcadInd) {
        this.stvlevlAcadInd = stvlevlAcadInd;
    }

    public String getStvlevlCeuInd() {
        return stvlevlCeuInd;
    }

    public void setStvlevlCeuInd(String stvlevlCeuInd) {
        this.stvlevlCeuInd = stvlevlCeuInd;
    }

    public String getStvlevlSystemReqInd() {
        return stvlevlSystemReqInd;
    }

    public void setStvlevlSystemReqInd(String stvlevlSystemReqInd) {
        this.stvlevlSystemReqInd = stvlevlSystemReqInd;
    }

    public Integer getStvlevlVrMsgNo() {
        return stvlevlVrMsgNo;
    }

    public void setStvlevlVrMsgNo(Integer stvlevlVrMsgNo) {
        this.stvlevlVrMsgNo = stvlevlVrMsgNo;
    }

    public String getStvlevlEdiEquiv() {
        return stvlevlEdiEquiv;
    }

    public void setStvlevlEdiEquiv(String stvlevlEdiEquiv) {
        this.stvlevlEdiEquiv = stvlevlEdiEquiv;
    }

    @XmlTransient
    public List<Sfrstcr> getSfrstcrList() {
        return sfrstcrList;
    }

    public void setSfrstcrList(List<Sfrstcr> sfrstcrList) {
        this.sfrstcrList = sfrstcrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvlevlCode != null ? stvlevlCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvlevl)) {
            return false;
        }
        Stvlevl other = (Stvlevl) object;
        if ((this.stvlevlCode == null && other.stvlevlCode != null) || (this.stvlevlCode != null && !this.stvlevlCode.equals(other.stvlevlCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvlevl[ stvlevlCode=" + stvlevlCode + " ]";
    }
    
}
