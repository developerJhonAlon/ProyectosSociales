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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SIBINST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sibinst.findAll", query = "SELECT s FROM Sibinst s"),
    @NamedQuery(name = "Sibinst.findBySibinstPidm", query = "SELECT s FROM Sibinst s WHERE s.sibinstPK.sibinstPidm = :sibinstPidm"),
    @NamedQuery(name = "Sibinst.findBySibinstTermCodeEff", query = "SELECT s FROM Sibinst s WHERE s.sibinstPK.sibinstTermCodeEff = :sibinstTermCodeEff"),
    @NamedQuery(name = "Sibinst.findBySibinstFcstCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstFcstCode = :sibinstFcstCode"),
    @NamedQuery(name = "Sibinst.findBySibinstFctgCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstFctgCode = :sibinstFctgCode"),
    @NamedQuery(name = "Sibinst.findBySibinstFstpCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstFstpCode = :sibinstFstpCode"),
    @NamedQuery(name = "Sibinst.findBySibinstFcntCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstFcntCode = :sibinstFcntCode"),
    @NamedQuery(name = "Sibinst.findBySibinstSchdInd", query = "SELECT s FROM Sibinst s WHERE s.sibinstSchdInd = :sibinstSchdInd"),
    @NamedQuery(name = "Sibinst.findBySibinstAdvrInd", query = "SELECT s FROM Sibinst s WHERE s.sibinstAdvrInd = :sibinstAdvrInd"),
    @NamedQuery(name = "Sibinst.findBySibinstFcstDate", query = "SELECT s FROM Sibinst s WHERE s.sibinstFcstDate = :sibinstFcstDate"),
    @NamedQuery(name = "Sibinst.findBySibinstWkldCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstWkldCode = :sibinstWkldCode"),
    @NamedQuery(name = "Sibinst.findBySibinstCntrCode", query = "SELECT s FROM Sibinst s WHERE s.sibinstCntrCode = :sibinstCntrCode"),
    @NamedQuery(name = "Sibinst.findBySibinstAppointDate", query = "SELECT s FROM Sibinst s WHERE s.sibinstAppointDate = :sibinstAppointDate"),
    @NamedQuery(name = "Sibinst.findBySibinstActivityDate", query = "SELECT s FROM Sibinst s WHERE s.sibinstActivityDate = :sibinstActivityDate"),
    @NamedQuery(name = "Sibinst.findBySibinstDataOrigin", query = "SELECT s FROM Sibinst s WHERE s.sibinstDataOrigin = :sibinstDataOrigin"),
    @NamedQuery(name = "Sibinst.findBySibinstUserId", query = "SELECT s FROM Sibinst s WHERE s.sibinstUserId = :sibinstUserId")})
public class Sibinst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SibinstPK sibinstPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SIBINST_FCST_CODE")
    private String sibinstFcstCode;
    @Size(max = 6)
    @Column(name = "SIBINST_FCTG_CODE")
    private String sibinstFctgCode;
    @Size(max = 4)
    @Column(name = "SIBINST_FSTP_CODE")
    private String sibinstFstpCode;
    @Size(max = 2)
    @Column(name = "SIBINST_FCNT_CODE")
    private String sibinstFcntCode;
    @Size(max = 1)
    @Column(name = "SIBINST_SCHD_IND")
    private String sibinstSchdInd;
    @Size(max = 1)
    @Column(name = "SIBINST_ADVR_IND")
    private String sibinstAdvrInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIBINST_FCST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sibinstFcstDate;
    @Size(max = 6)
    @Column(name = "SIBINST_WKLD_CODE")
    private String sibinstWkldCode;
    @Size(max = 6)
    @Column(name = "SIBINST_CNTR_CODE")
    private String sibinstCntrCode;
    @Column(name = "SIBINST_APPOINT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sibinstAppointDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIBINST_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sibinstActivityDate;
    @Size(max = 30)
    @Column(name = "SIBINST_DATA_ORIGIN")
    private String sibinstDataOrigin;
    @Size(max = 30)
    @Column(name = "SIBINST_USER_ID")
    private String sibinstUserId;

    public Sibinst() {
    }

    public Sibinst(SibinstPK sibinstPK) {
        this.sibinstPK = sibinstPK;
    }

    public Sibinst(SibinstPK sibinstPK, String sibinstFcstCode, Date sibinstFcstDate, Date sibinstActivityDate) {
        this.sibinstPK = sibinstPK;
        this.sibinstFcstCode = sibinstFcstCode;
        this.sibinstFcstDate = sibinstFcstDate;
        this.sibinstActivityDate = sibinstActivityDate;
    }

    public Sibinst(int sibinstPidm, String sibinstTermCodeEff) {
        this.sibinstPK = new SibinstPK(sibinstPidm, sibinstTermCodeEff);
    }

    public SibinstPK getSibinstPK() {
        return sibinstPK;
    }

    public void setSibinstPK(SibinstPK sibinstPK) {
        this.sibinstPK = sibinstPK;
    }

    public String getSibinstFcstCode() {
        return sibinstFcstCode;
    }

    public void setSibinstFcstCode(String sibinstFcstCode) {
        this.sibinstFcstCode = sibinstFcstCode;
    }

    public String getSibinstFctgCode() {
        return sibinstFctgCode;
    }

    public void setSibinstFctgCode(String sibinstFctgCode) {
        this.sibinstFctgCode = sibinstFctgCode;
    }

    public String getSibinstFstpCode() {
        return sibinstFstpCode;
    }

    public void setSibinstFstpCode(String sibinstFstpCode) {
        this.sibinstFstpCode = sibinstFstpCode;
    }

    public String getSibinstFcntCode() {
        return sibinstFcntCode;
    }

    public void setSibinstFcntCode(String sibinstFcntCode) {
        this.sibinstFcntCode = sibinstFcntCode;
    }

    public String getSibinstSchdInd() {
        return sibinstSchdInd;
    }

    public void setSibinstSchdInd(String sibinstSchdInd) {
        this.sibinstSchdInd = sibinstSchdInd;
    }

    public String getSibinstAdvrInd() {
        return sibinstAdvrInd;
    }

    public void setSibinstAdvrInd(String sibinstAdvrInd) {
        this.sibinstAdvrInd = sibinstAdvrInd;
    }

    public Date getSibinstFcstDate() {
        return sibinstFcstDate;
    }

    public void setSibinstFcstDate(Date sibinstFcstDate) {
        this.sibinstFcstDate = sibinstFcstDate;
    }

    public String getSibinstWkldCode() {
        return sibinstWkldCode;
    }

    public void setSibinstWkldCode(String sibinstWkldCode) {
        this.sibinstWkldCode = sibinstWkldCode;
    }

    public String getSibinstCntrCode() {
        return sibinstCntrCode;
    }

    public void setSibinstCntrCode(String sibinstCntrCode) {
        this.sibinstCntrCode = sibinstCntrCode;
    }

    public Date getSibinstAppointDate() {
        return sibinstAppointDate;
    }

    public void setSibinstAppointDate(Date sibinstAppointDate) {
        this.sibinstAppointDate = sibinstAppointDate;
    }

    public Date getSibinstActivityDate() {
        return sibinstActivityDate;
    }

    public void setSibinstActivityDate(Date sibinstActivityDate) {
        this.sibinstActivityDate = sibinstActivityDate;
    }

    public String getSibinstDataOrigin() {
        return sibinstDataOrigin;
    }

    public void setSibinstDataOrigin(String sibinstDataOrigin) {
        this.sibinstDataOrigin = sibinstDataOrigin;
    }

    public String getSibinstUserId() {
        return sibinstUserId;
    }

    public void setSibinstUserId(String sibinstUserId) {
        this.sibinstUserId = sibinstUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sibinstPK != null ? sibinstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sibinst)) {
            return false;
        }
        Sibinst other = (Sibinst) object;
        if ((this.sibinstPK == null && other.sibinstPK != null) || (this.sibinstPK != null && !this.sibinstPK.equals(other.sibinstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Sibinst[ sibinstPK=" + sibinstPK + " ]";
    }
    
}
