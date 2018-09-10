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
@Table(name = "STVDEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvdept.findAll", query = "SELECT s FROM Stvdept s"),
    @NamedQuery(name = "Stvdept.findByStvdeptCode", query = "SELECT s FROM Stvdept s WHERE s.stvdeptCode = :stvdeptCode"),
    @NamedQuery(name = "Stvdept.findByStvdeptDesc", query = "SELECT s FROM Stvdept s WHERE s.stvdeptDesc = :stvdeptDesc"),
    @NamedQuery(name = "Stvdept.findByStvdeptActivityDate", query = "SELECT s FROM Stvdept s WHERE s.stvdeptActivityDate = :stvdeptActivityDate"),
    @NamedQuery(name = "Stvdept.findByStvdeptSystemReqInd", query = "SELECT s FROM Stvdept s WHERE s.stvdeptSystemReqInd = :stvdeptSystemReqInd"),
    @NamedQuery(name = "Stvdept.findByStvdeptVrMsgNo", query = "SELECT s FROM Stvdept s WHERE s.stvdeptVrMsgNo = :stvdeptVrMsgNo")})
public class Stvdept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVDEPT_CODE")
    private String stvdeptCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVDEPT_DESC")
    private String stvdeptDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVDEPT_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvdeptActivityDate;
    @Size(max = 1)
    @Column(name = "STVDEPT_SYSTEM_REQ_IND")
    private String stvdeptSystemReqInd;
    @Column(name = "STVDEPT_VR_MSG_NO")
    private Integer stvdeptVrMsgNo;

    public Stvdept() {
    }

    public Stvdept(String stvdeptCode) {
        this.stvdeptCode = stvdeptCode;
    }

    public Stvdept(String stvdeptCode, String stvdeptDesc, Date stvdeptActivityDate) {
        this.stvdeptCode = stvdeptCode;
        this.stvdeptDesc = stvdeptDesc;
        this.stvdeptActivityDate = stvdeptActivityDate;
    }

    public String getStvdeptCode() {
        return stvdeptCode;
    }

    public void setStvdeptCode(String stvdeptCode) {
        this.stvdeptCode = stvdeptCode;
    }

    public String getStvdeptDesc() {
        return stvdeptDesc;
    }

    public void setStvdeptDesc(String stvdeptDesc) {
        this.stvdeptDesc = stvdeptDesc;
    }

    public Date getStvdeptActivityDate() {
        return stvdeptActivityDate;
    }

    public void setStvdeptActivityDate(Date stvdeptActivityDate) {
        this.stvdeptActivityDate = stvdeptActivityDate;
    }

    public String getStvdeptSystemReqInd() {
        return stvdeptSystemReqInd;
    }

    public void setStvdeptSystemReqInd(String stvdeptSystemReqInd) {
        this.stvdeptSystemReqInd = stvdeptSystemReqInd;
    }

    public Integer getStvdeptVrMsgNo() {
        return stvdeptVrMsgNo;
    }

    public void setStvdeptVrMsgNo(Integer stvdeptVrMsgNo) {
        this.stvdeptVrMsgNo = stvdeptVrMsgNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvdeptCode != null ? stvdeptCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvdept)) {
            return false;
        }
        Stvdept other = (Stvdept) object;
        if ((this.stvdeptCode == null && other.stvdeptCode != null) || (this.stvdeptCode != null && !this.stvdeptCode.equals(other.stvdeptCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvdept[ stvdeptCode=" + stvdeptCode + " ]";
    }
    
}
