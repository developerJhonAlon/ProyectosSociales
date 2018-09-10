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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "STVMAJR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvmajr.findAll", query = "SELECT s FROM Stvmajr s"),
    @NamedQuery(name = "Stvmajr.findByStvmajrCode", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrCode = :stvmajrCode"),
    @NamedQuery(name = "Stvmajr.findByStvmajrDesc", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrDesc = :stvmajrDesc"),
    @NamedQuery(name = "Stvmajr.findByStvmajrCipcCode", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrCipcCode = :stvmajrCipcCode"),
    @NamedQuery(name = "Stvmajr.findByStvmajrValidMajorInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrValidMajorInd = :stvmajrValidMajorInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrValidMinorInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrValidMinorInd = :stvmajrValidMinorInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrValidConcentratnInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrValidConcentratnInd = :stvmajrValidConcentratnInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrActivityDate", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrActivityDate = :stvmajrActivityDate"),
    @NamedQuery(name = "Stvmajr.findByStvmajrOccupationInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrOccupationInd = :stvmajrOccupationInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrAidEligibilityInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrAidEligibilityInd = :stvmajrAidEligibilityInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrSystemReqInd", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrSystemReqInd = :stvmajrSystemReqInd"),
    @NamedQuery(name = "Stvmajr.findByStvmajrVrMsgNo", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrVrMsgNo = :stvmajrVrMsgNo"),
    @NamedQuery(name = "Stvmajr.findByStvmajrSevisEquiv", query = "SELECT s FROM Stvmajr s WHERE s.stvmajrSevisEquiv = :stvmajrSevisEquiv")})
public class Stvmajr implements Serializable, Comparable<Stvmajr> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVMAJR_CODE")
    private String stvmajrCode;
    @Size(max = 30)
    @Column(name = "STVMAJR_DESC")
    private String stvmajrDesc;
    @Size(max = 6)
    @Column(name = "STVMAJR_CIPC_CODE")
    private String stvmajrCipcCode;
    @Size(max = 1)
    @Column(name = "STVMAJR_VALID_MAJOR_IND")
    private String stvmajrValidMajorInd;
    @Size(max = 1)
    @Column(name = "STVMAJR_VALID_MINOR_IND")
    private String stvmajrValidMinorInd;
    @Size(max = 1)
    @Column(name = "STVMAJR_VALID_CONCENTRATN_IND")
    private String stvmajrValidConcentratnInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVMAJR_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvmajrActivityDate;
    @Size(max = 1)
    @Column(name = "STVMAJR_OCCUPATION_IND")
    private String stvmajrOccupationInd;
    @Size(max = 1)
    @Column(name = "STVMAJR_AID_ELIGIBILITY_IND")
    private String stvmajrAidEligibilityInd;
    @Size(max = 1)
    @Column(name = "STVMAJR_SYSTEM_REQ_IND")
    private String stvmajrSystemReqInd;
    @Column(name = "STVMAJR_VR_MSG_NO")
    private Integer stvmajrVrMsgNo;
    @Lob
    @Column(name = "STVMAJR_DISP_WEB_IND")
    private byte[] stvmajrDispWebInd;
    @Size(max = 6)
    @Column(name = "STVMAJR_SEVIS_EQUIV")
    private String stvmajrSevisEquiv;

    public Stvmajr() {
    }

    public Stvmajr(String stvmajrCode) {
        this.stvmajrCode = stvmajrCode;
    }

    public Stvmajr(String id, String descripcion) {
        this.stvmajrCode = id;
        this.stvmajrDesc = descripcion;
    }

    public Stvmajr(String stvmajrCode, Date stvmajrActivityDate) {
        this.stvmajrCode = stvmajrCode;
        this.stvmajrActivityDate = stvmajrActivityDate;
    }

    public String getStvmajrCode() {
        return stvmajrCode;
    }

    public void setStvmajrCode(String stvmajrCode) {
        this.stvmajrCode = stvmajrCode;
    }

    public String getStvmajrDesc() {
        return stvmajrDesc;
    }

    public void setStvmajrDesc(String stvmajrDesc) {
        this.stvmajrDesc = stvmajrDesc;
    }

    public String getStvmajrCipcCode() {
        return stvmajrCipcCode;
    }

    public void setStvmajrCipcCode(String stvmajrCipcCode) {
        this.stvmajrCipcCode = stvmajrCipcCode;
    }

    public String getStvmajrValidMajorInd() {
        return stvmajrValidMajorInd;
    }

    public void setStvmajrValidMajorInd(String stvmajrValidMajorInd) {
        this.stvmajrValidMajorInd = stvmajrValidMajorInd;
    }

    public String getStvmajrValidMinorInd() {
        return stvmajrValidMinorInd;
    }

    public void setStvmajrValidMinorInd(String stvmajrValidMinorInd) {
        this.stvmajrValidMinorInd = stvmajrValidMinorInd;
    }

    public String getStvmajrValidConcentratnInd() {
        return stvmajrValidConcentratnInd;
    }

    public void setStvmajrValidConcentratnInd(String stvmajrValidConcentratnInd) {
        this.stvmajrValidConcentratnInd = stvmajrValidConcentratnInd;
    }

    public Date getStvmajrActivityDate() {
        return stvmajrActivityDate;
    }

    public void setStvmajrActivityDate(Date stvmajrActivityDate) {
        this.stvmajrActivityDate = stvmajrActivityDate;
    }

    public String getStvmajrOccupationInd() {
        return stvmajrOccupationInd;
    }

    public void setStvmajrOccupationInd(String stvmajrOccupationInd) {
        this.stvmajrOccupationInd = stvmajrOccupationInd;
    }

    public String getStvmajrAidEligibilityInd() {
        return stvmajrAidEligibilityInd;
    }

    public void setStvmajrAidEligibilityInd(String stvmajrAidEligibilityInd) {
        this.stvmajrAidEligibilityInd = stvmajrAidEligibilityInd;
    }

    public String getStvmajrSystemReqInd() {
        return stvmajrSystemReqInd;
    }

    public void setStvmajrSystemReqInd(String stvmajrSystemReqInd) {
        this.stvmajrSystemReqInd = stvmajrSystemReqInd;
    }

    public Integer getStvmajrVrMsgNo() {
        return stvmajrVrMsgNo;
    }

    public void setStvmajrVrMsgNo(Integer stvmajrVrMsgNo) {
        this.stvmajrVrMsgNo = stvmajrVrMsgNo;
    }

    public byte[] getStvmajrDispWebInd() {
        return stvmajrDispWebInd;
    }

    public void setStvmajrDispWebInd(byte[] stvmajrDispWebInd) {
        this.stvmajrDispWebInd = stvmajrDispWebInd;
    }

    public String getStvmajrSevisEquiv() {
        return stvmajrSevisEquiv;
    }

    public void setStvmajrSevisEquiv(String stvmajrSevisEquiv) {
        this.stvmajrSevisEquiv = stvmajrSevisEquiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvmajrCode != null ? stvmajrCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvmajr)) {
            return false;
        }
        Stvmajr other = (Stvmajr) object;
        if ((this.stvmajrCode == null && other.stvmajrCode != null) || (this.stvmajrCode != null && !this.stvmajrCode.equals(other.stvmajrCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvmajr[ stvmajrCode=" + stvmajrCode + " ]";
    }

    @Transient
    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public int compareTo(Stvmajr o) {
        if (this.stvmajrDesc!=null){
            return this.stvmajrDesc.compareTo(o.stvmajrDesc);
        }
        return 0;
    }

}
