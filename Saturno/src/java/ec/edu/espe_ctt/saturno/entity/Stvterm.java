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
import javax.persistence.OneToOne;
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
@Table(name = "STVTERM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvterm.findAll", query = "SELECT s FROM Stvterm s"),
    @NamedQuery(name = "Stvterm.findByStvtermCode", query = "SELECT s FROM Stvterm s WHERE s.stvtermCode = :stvtermCode"),
    @NamedQuery(name = "Stvterm.findByStvtermDesc", query = "SELECT s FROM Stvterm s WHERE s.stvtermDesc = :stvtermDesc"),
    @NamedQuery(name = "Stvterm.findByStvtermStartDate", query = "SELECT s FROM Stvterm s WHERE s.stvtermStartDate = :stvtermStartDate"),
    @NamedQuery(name = "Stvterm.findByStvtermEndDate", query = "SELECT s FROM Stvterm s WHERE s.stvtermEndDate = :stvtermEndDate"),
    @NamedQuery(name = "Stvterm.findByStvtermFaProcYr", query = "SELECT s FROM Stvterm s WHERE s.stvtermFaProcYr = :stvtermFaProcYr"),
    @NamedQuery(name = "Stvterm.findByStvtermActivityDate", query = "SELECT s FROM Stvterm s WHERE s.stvtermActivityDate = :stvtermActivityDate"),
    @NamedQuery(name = "Stvterm.findByStvtermFaTerm", query = "SELECT s FROM Stvterm s WHERE s.stvtermFaTerm = :stvtermFaTerm"),
    @NamedQuery(name = "Stvterm.findByStvtermFaPeriod", query = "SELECT s FROM Stvterm s WHERE s.stvtermFaPeriod = :stvtermFaPeriod"),
    @NamedQuery(name = "Stvterm.findByStvtermFaEndPeriod", query = "SELECT s FROM Stvterm s WHERE s.stvtermFaEndPeriod = :stvtermFaEndPeriod"),
    @NamedQuery(name = "Stvterm.findByStvtermAcyrCode", query = "SELECT s FROM Stvterm s WHERE s.stvtermAcyrCode = :stvtermAcyrCode"),
    @NamedQuery(name = "Stvterm.findByStvtermHousingStartDate", query = "SELECT s FROM Stvterm s WHERE s.stvtermHousingStartDate = :stvtermHousingStartDate"),
    @NamedQuery(name = "Stvterm.findByStvtermHousingEndDate", query = "SELECT s FROM Stvterm s WHERE s.stvtermHousingEndDate = :stvtermHousingEndDate"),
    @NamedQuery(name = "Stvterm.findByStvtermSystemReqInd", query = "SELECT s FROM Stvterm s WHERE s.stvtermSystemReqInd = :stvtermSystemReqInd"),
    @NamedQuery(name = "Stvterm.findByStvtermTrmtCode", query = "SELECT s FROM Stvterm s WHERE s.stvtermTrmtCode = :stvtermTrmtCode")})
public class Stvterm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "STVTERM_CODE")
    private String stvtermCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVTERM_DESC")
    private String stvtermDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTERM_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtermStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTERM_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtermEndDate;
    @Size(max = 4)
    @Column(name = "STVTERM_FA_PROC_YR")
    private String stvtermFaProcYr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTERM_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtermActivityDate;
    @Size(max = 1)
    @Column(name = "STVTERM_FA_TERM")
    private String stvtermFaTerm;
    @Column(name = "STVTERM_FA_PERIOD")
    private Short stvtermFaPeriod;
    @Column(name = "STVTERM_FA_END_PERIOD")
    private Short stvtermFaEndPeriod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVTERM_ACYR_CODE")
    private String stvtermAcyrCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTERM_HOUSING_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtermHousingStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STVTERM_HOUSING_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvtermHousingEndDate;
    @Size(max = 1)
    @Column(name = "STVTERM_SYSTEM_REQ_IND")
    private String stvtermSystemReqInd;
    @Size(max = 1)
    @Column(name = "STVTERM_TRMT_CODE")
    private String stvtermTrmtCode;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stvterm")
    private Sobterm sobterm;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stvterm")
    private List<Sfrstcr> sfrstcrList;

    public Stvterm() {
    }

    public Stvterm(String stvtermCode) {
        this.stvtermCode = stvtermCode;
    }

    public Stvterm(String stvtermCode, String stvtermDesc, Date stvtermStartDate, Date stvtermEndDate, Date stvtermActivityDate, String stvtermAcyrCode, Date stvtermHousingStartDate, Date stvtermHousingEndDate) {
        this.stvtermCode = stvtermCode;
        this.stvtermDesc = stvtermDesc;
        this.stvtermStartDate = stvtermStartDate;
        this.stvtermEndDate = stvtermEndDate;
        this.stvtermActivityDate = stvtermActivityDate;
        this.stvtermAcyrCode = stvtermAcyrCode;
        this.stvtermHousingStartDate = stvtermHousingStartDate;
        this.stvtermHousingEndDate = stvtermHousingEndDate;
    }

    public String getStvtermCode() {
        return stvtermCode;
    }

    public void setStvtermCode(String stvtermCode) {
        this.stvtermCode = stvtermCode;
    }

    public String getStvtermDesc() {
        return stvtermDesc;
    }

    public void setStvtermDesc(String stvtermDesc) {
        this.stvtermDesc = stvtermDesc;
    }

    public Date getStvtermStartDate() {
        return stvtermStartDate;
    }

    public void setStvtermStartDate(Date stvtermStartDate) {
        this.stvtermStartDate = stvtermStartDate;
    }

    public Date getStvtermEndDate() {
        return stvtermEndDate;
    }

    public void setStvtermEndDate(Date stvtermEndDate) {
        this.stvtermEndDate = stvtermEndDate;
    }

    public String getStvtermFaProcYr() {
        return stvtermFaProcYr;
    }

    public void setStvtermFaProcYr(String stvtermFaProcYr) {
        this.stvtermFaProcYr = stvtermFaProcYr;
    }

    public Date getStvtermActivityDate() {
        return stvtermActivityDate;
    }

    public void setStvtermActivityDate(Date stvtermActivityDate) {
        this.stvtermActivityDate = stvtermActivityDate;
    }

    public String getStvtermFaTerm() {
        return stvtermFaTerm;
    }

    public void setStvtermFaTerm(String stvtermFaTerm) {
        this.stvtermFaTerm = stvtermFaTerm;
    }

    public Short getStvtermFaPeriod() {
        return stvtermFaPeriod;
    }

    public void setStvtermFaPeriod(Short stvtermFaPeriod) {
        this.stvtermFaPeriod = stvtermFaPeriod;
    }

    public Short getStvtermFaEndPeriod() {
        return stvtermFaEndPeriod;
    }

    public void setStvtermFaEndPeriod(Short stvtermFaEndPeriod) {
        this.stvtermFaEndPeriod = stvtermFaEndPeriod;
    }

    public String getStvtermAcyrCode() {
        return stvtermAcyrCode;
    }

    public void setStvtermAcyrCode(String stvtermAcyrCode) {
        this.stvtermAcyrCode = stvtermAcyrCode;
    }

    public Date getStvtermHousingStartDate() {
        return stvtermHousingStartDate;
    }

    public void setStvtermHousingStartDate(Date stvtermHousingStartDate) {
        this.stvtermHousingStartDate = stvtermHousingStartDate;
    }

    public Date getStvtermHousingEndDate() {
        return stvtermHousingEndDate;
    }

    public void setStvtermHousingEndDate(Date stvtermHousingEndDate) {
        this.stvtermHousingEndDate = stvtermHousingEndDate;
    }

    public String getStvtermSystemReqInd() {
        return stvtermSystemReqInd;
    }

    public void setStvtermSystemReqInd(String stvtermSystemReqInd) {
        this.stvtermSystemReqInd = stvtermSystemReqInd;
    }

    public String getStvtermTrmtCode() {
        return stvtermTrmtCode;
    }

    public void setStvtermTrmtCode(String stvtermTrmtCode) {
        this.stvtermTrmtCode = stvtermTrmtCode;
    }

    public Sobterm getSobterm() {
        return sobterm;
    }

    public void setSobterm(Sobterm sobterm) {
        this.sobterm = sobterm;
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
        hash += (stvtermCode != null ? stvtermCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvterm)) {
            return false;
        }
        Stvterm other = (Stvterm) object;
        if ((this.stvtermCode == null && other.stvtermCode != null) || (this.stvtermCode != null && !this.stvtermCode.equals(other.stvtermCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvterm[ stvtermCode=" + stvtermCode + " ]";
    }
    
}
