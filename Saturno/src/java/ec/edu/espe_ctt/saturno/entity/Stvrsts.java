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
@Table(name = "STVRSTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvrsts.findAll", query = "SELECT s FROM Stvrsts s"),
    @NamedQuery(name = "Stvrsts.findByStvrstsCode", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsCode = :stvrstsCode"),
    @NamedQuery(name = "Stvrsts.findByStvrstsDesc", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsDesc = :stvrstsDesc"),
    @NamedQuery(name = "Stvrsts.findByStvrstsEnterableInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsEnterableInd = :stvrstsEnterableInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsInclSectEnrl", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsInclSectEnrl = :stvrstsInclSectEnrl"),
    @NamedQuery(name = "Stvrsts.findByStvrstsInclAssess", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsInclAssess = :stvrstsInclAssess"),
    @NamedQuery(name = "Stvrsts.findByStvrstsAutoGrade", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsAutoGrade = :stvrstsAutoGrade"),
    @NamedQuery(name = "Stvrsts.findByStvrstsGradableInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsGradableInd = :stvrstsGradableInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsActivityDate", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsActivityDate = :stvrstsActivityDate"),
    @NamedQuery(name = "Stvrsts.findByStvrstsWaitInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsWaitInd = :stvrstsWaitInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsSystemReqInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsSystemReqInd = :stvrstsSystemReqInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsVoiceType", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsVoiceType = :stvrstsVoiceType"),
    @NamedQuery(name = "Stvrsts.findByStvrstsSbPrintInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsSbPrintInd = :stvrstsSbPrintInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsWithdrawInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsWithdrawInd = :stvrstsWithdrawInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsWebInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsWebInd = :stvrstsWebInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsExtensionInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsExtensionInd = :stvrstsExtensionInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsAttemptHrInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsAttemptHrInd = :stvrstsAttemptHrInd"),
    @NamedQuery(name = "Stvrsts.findByStvrstsInclTmstInd", query = "SELECT s FROM Stvrsts s WHERE s.stvrstsInclTmstInd = :stvrstsInclTmstInd")})
public class Stvrsts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STVRSTS_CODE")
    private String stvrstsCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVRSTS_DESC")
    private String stvrstsDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_ENTERABLE_IND")
    private String stvrstsEnterableInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_INCL_SECT_ENRL")
    private String stvrstsInclSectEnrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_INCL_ASSESS")
    private String stvrstsInclAssess;
    @Size(max = 6)
    @Column(name = "STVRSTS_AUTO_GRADE")
    private String stvrstsAutoGrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_GRADABLE_IND")
    private String stvrstsGradableInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVRSTS_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvrstsActivityDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_WAIT_IND")
    private String stvrstsWaitInd;
    @Size(max = 1)
    @Column(name = "STVRSTS_SYSTEM_REQ_IND")
    private String stvrstsSystemReqInd;
    @Size(max = 1)
    @Column(name = "STVRSTS_VOICE_TYPE")
    private String stvrstsVoiceType;
    @Size(max = 1)
    @Column(name = "STVRSTS_SB_PRINT_IND")
    private String stvrstsSbPrintInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_WITHDRAW_IND")
    private String stvrstsWithdrawInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_WEB_IND")
    private String stvrstsWebInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_EXTENSION_IND")
    private String stvrstsExtensionInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_ATTEMPT_HR_IND")
    private String stvrstsAttemptHrInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVRSTS_INCL_TMST_IND")
    private String stvrstsInclTmstInd;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sfrstcrRstsCode")
    private List<Sfrstcr> sfrstcrList;

    public Stvrsts() {
    }

    public Stvrsts(String stvrstsCode) {
        this.stvrstsCode = stvrstsCode;
    }

    public Stvrsts(String stvrstsCode, String stvrstsDesc, String stvrstsEnterableInd, String stvrstsInclSectEnrl, String stvrstsInclAssess, String stvrstsGradableInd, Date stvrstsActivityDate, String stvrstsWaitInd, String stvrstsWithdrawInd, String stvrstsWebInd, String stvrstsExtensionInd, String stvrstsAttemptHrInd, String stvrstsInclTmstInd) {
        this.stvrstsCode = stvrstsCode;
        this.stvrstsDesc = stvrstsDesc;
        this.stvrstsEnterableInd = stvrstsEnterableInd;
        this.stvrstsInclSectEnrl = stvrstsInclSectEnrl;
        this.stvrstsInclAssess = stvrstsInclAssess;
        this.stvrstsGradableInd = stvrstsGradableInd;
        this.stvrstsActivityDate = stvrstsActivityDate;
        this.stvrstsWaitInd = stvrstsWaitInd;
        this.stvrstsWithdrawInd = stvrstsWithdrawInd;
        this.stvrstsWebInd = stvrstsWebInd;
        this.stvrstsExtensionInd = stvrstsExtensionInd;
        this.stvrstsAttemptHrInd = stvrstsAttemptHrInd;
        this.stvrstsInclTmstInd = stvrstsInclTmstInd;
    }

    public String getStvrstsCode() {
        return stvrstsCode;
    }

    public void setStvrstsCode(String stvrstsCode) {
        this.stvrstsCode = stvrstsCode;
    }

    public String getStvrstsDesc() {
        return stvrstsDesc;
    }

    public void setStvrstsDesc(String stvrstsDesc) {
        this.stvrstsDesc = stvrstsDesc;
    }

    public String getStvrstsEnterableInd() {
        return stvrstsEnterableInd;
    }

    public void setStvrstsEnterableInd(String stvrstsEnterableInd) {
        this.stvrstsEnterableInd = stvrstsEnterableInd;
    }

    public String getStvrstsInclSectEnrl() {
        return stvrstsInclSectEnrl;
    }

    public void setStvrstsInclSectEnrl(String stvrstsInclSectEnrl) {
        this.stvrstsInclSectEnrl = stvrstsInclSectEnrl;
    }

    public String getStvrstsInclAssess() {
        return stvrstsInclAssess;
    }

    public void setStvrstsInclAssess(String stvrstsInclAssess) {
        this.stvrstsInclAssess = stvrstsInclAssess;
    }

    public String getStvrstsAutoGrade() {
        return stvrstsAutoGrade;
    }

    public void setStvrstsAutoGrade(String stvrstsAutoGrade) {
        this.stvrstsAutoGrade = stvrstsAutoGrade;
    }

    public String getStvrstsGradableInd() {
        return stvrstsGradableInd;
    }

    public void setStvrstsGradableInd(String stvrstsGradableInd) {
        this.stvrstsGradableInd = stvrstsGradableInd;
    }

    public Date getStvrstsActivityDate() {
        return stvrstsActivityDate;
    }

    public void setStvrstsActivityDate(Date stvrstsActivityDate) {
        this.stvrstsActivityDate = stvrstsActivityDate;
    }

    public String getStvrstsWaitInd() {
        return stvrstsWaitInd;
    }

    public void setStvrstsWaitInd(String stvrstsWaitInd) {
        this.stvrstsWaitInd = stvrstsWaitInd;
    }

    public String getStvrstsSystemReqInd() {
        return stvrstsSystemReqInd;
    }

    public void setStvrstsSystemReqInd(String stvrstsSystemReqInd) {
        this.stvrstsSystemReqInd = stvrstsSystemReqInd;
    }

    public String getStvrstsVoiceType() {
        return stvrstsVoiceType;
    }

    public void setStvrstsVoiceType(String stvrstsVoiceType) {
        this.stvrstsVoiceType = stvrstsVoiceType;
    }

    public String getStvrstsSbPrintInd() {
        return stvrstsSbPrintInd;
    }

    public void setStvrstsSbPrintInd(String stvrstsSbPrintInd) {
        this.stvrstsSbPrintInd = stvrstsSbPrintInd;
    }

    public String getStvrstsWithdrawInd() {
        return stvrstsWithdrawInd;
    }

    public void setStvrstsWithdrawInd(String stvrstsWithdrawInd) {
        this.stvrstsWithdrawInd = stvrstsWithdrawInd;
    }

    public String getStvrstsWebInd() {
        return stvrstsWebInd;
    }

    public void setStvrstsWebInd(String stvrstsWebInd) {
        this.stvrstsWebInd = stvrstsWebInd;
    }

    public String getStvrstsExtensionInd() {
        return stvrstsExtensionInd;
    }

    public void setStvrstsExtensionInd(String stvrstsExtensionInd) {
        this.stvrstsExtensionInd = stvrstsExtensionInd;
    }

    public String getStvrstsAttemptHrInd() {
        return stvrstsAttemptHrInd;
    }

    public void setStvrstsAttemptHrInd(String stvrstsAttemptHrInd) {
        this.stvrstsAttemptHrInd = stvrstsAttemptHrInd;
    }

    public String getStvrstsInclTmstInd() {
        return stvrstsInclTmstInd;
    }

    public void setStvrstsInclTmstInd(String stvrstsInclTmstInd) {
        this.stvrstsInclTmstInd = stvrstsInclTmstInd;
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
        hash += (stvrstsCode != null ? stvrstsCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvrsts)) {
            return false;
        }
        Stvrsts other = (Stvrsts) object;
        if ((this.stvrstsCode == null && other.stvrstsCode != null) || (this.stvrstsCode != null && !this.stvrstsCode.equals(other.stvrstsCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvrsts[ stvrstsCode=" + stvrstsCode + " ]";
    }
    
}
