/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SIRASGN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirasgn.findAll", query = "SELECT s FROM Sirasgn s"),
    @NamedQuery(name = "Sirasgn.findBySirasgnTermCode", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPK.sirasgnTermCode = :sirasgnTermCode"),
    @NamedQuery(name = "Sirasgn.findBySirasgnCrn", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPK.sirasgnCrn = :sirasgnCrn"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPidm", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPK.sirasgnPidm = :sirasgnPidm"),
    @NamedQuery(name = "Sirasgn.findBySirasgnCategory", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPK.sirasgnCategory = :sirasgnCategory"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPercentResponse", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPercentResponse = :sirasgnPercentResponse"),
    @NamedQuery(name = "Sirasgn.findBySirasgnWorkloadAdjust", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnWorkloadAdjust = :sirasgnWorkloadAdjust"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPercentSess", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPercentSess = :sirasgnPercentSess"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPrimaryInd", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPrimaryInd = :sirasgnPrimaryInd"),
    @NamedQuery(name = "Sirasgn.findBySirasgnOverRide", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnOverRide = :sirasgnOverRide"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPosition", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPosition = :sirasgnPosition"),
    @NamedQuery(name = "Sirasgn.findBySirasgnActivityDate", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnActivityDate = :sirasgnActivityDate"),
    @NamedQuery(name = "Sirasgn.findBySirasgnFcntCode", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnFcntCode = :sirasgnFcntCode"),
    @NamedQuery(name = "Sirasgn.findBySirasgnPosn", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnPosn = :sirasgnPosn"),
    @NamedQuery(name = "Sirasgn.findBySirasgnSuff", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnSuff = :sirasgnSuff"),
    @NamedQuery(name = "Sirasgn.findBySirasgnAstyCode", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnAstyCode = :sirasgnAstyCode"),
    @NamedQuery(name = "Sirasgn.findBySirasgnDataOrigin", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnDataOrigin = :sirasgnDataOrigin"),
    @NamedQuery(name = "Sirasgn.findBySirasgnUserId", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnUserId = :sirasgnUserId"),
    @NamedQuery(name = "Sirasgn.findBySirasgnWorkloadIncr", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnWorkloadIncr = :sirasgnWorkloadIncr"),
    @NamedQuery(name = "Sirasgn.findBySirasgnIncrEnrl", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnIncrEnrl = :sirasgnIncrEnrl"),
    @NamedQuery(name = "Sirasgn.findBySirasgnIncrEnrlDate", query = "SELECT s FROM Sirasgn s WHERE s.sirasgnIncrEnrlDate = :sirasgnIncrEnrlDate")})
public class Sirasgn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SirasgnPK sirasgnPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIRASGN_PERCENT_RESPONSE")
    private short sirasgnPercentResponse;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SIRASGN_WORKLOAD_ADJUST")
    private BigDecimal sirasgnWorkloadAdjust;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIRASGN_PERCENT_SESS")
    private short sirasgnPercentSess;
    @Size(max = 1)
    @Column(name = "SIRASGN_PRIMARY_IND")
    private String sirasgnPrimaryInd;
    @Size(max = 1)
    @Column(name = "SIRASGN_OVER_RIDE")
    private String sirasgnOverRide;
    @Column(name = "SIRASGN_POSITION")
    private Integer sirasgnPosition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIRASGN_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sirasgnActivityDate;
    @Size(max = 2)
    @Column(name = "SIRASGN_FCNT_CODE")
    private String sirasgnFcntCode;
    @Size(max = 6)
    @Column(name = "SIRASGN_POSN")
    private String sirasgnPosn;
    @Size(max = 2)
    @Column(name = "SIRASGN_SUFF")
    private String sirasgnSuff;
    @Size(max = 4)
    @Column(name = "SIRASGN_ASTY_CODE")
    private String sirasgnAstyCode;
    @Size(max = 30)
    @Column(name = "SIRASGN_DATA_ORIGIN")
    private String sirasgnDataOrigin;
    @Size(max = 30)
    @Column(name = "SIRASGN_USER_ID")
    private String sirasgnUserId;
    @Column(name = "SIRASGN_WORKLOAD_INCR")
    private BigDecimal sirasgnWorkloadIncr;
    @Column(name = "SIRASGN_INCR_ENRL")
    private Short sirasgnIncrEnrl;
    @Column(name = "SIRASGN_INCR_ENRL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sirasgnIncrEnrlDate;

    public Sirasgn() {
    }

    public Sirasgn(SirasgnPK sirasgnPK) {
        this.sirasgnPK = sirasgnPK;
    }

    public Sirasgn(SirasgnPK sirasgnPK, short sirasgnPercentResponse, short sirasgnPercentSess, Date sirasgnActivityDate) {
        this.sirasgnPK = sirasgnPK;
        this.sirasgnPercentResponse = sirasgnPercentResponse;
        this.sirasgnPercentSess = sirasgnPercentSess;
        this.sirasgnActivityDate = sirasgnActivityDate;
    }

    public Sirasgn(String sirasgnTermCode, String sirasgnCrn, int sirasgnPidm, String sirasgnCategory) {
        this.sirasgnPK = new SirasgnPK(sirasgnTermCode, sirasgnCrn, sirasgnPidm, sirasgnCategory);
    }

    public SirasgnPK getSirasgnPK() {
        return sirasgnPK;
    }

    public void setSirasgnPK(SirasgnPK sirasgnPK) {
        this.sirasgnPK = sirasgnPK;
    }

    public short getSirasgnPercentResponse() {
        return sirasgnPercentResponse;
    }

    public void setSirasgnPercentResponse(short sirasgnPercentResponse) {
        this.sirasgnPercentResponse = sirasgnPercentResponse;
    }

    public BigDecimal getSirasgnWorkloadAdjust() {
        return sirasgnWorkloadAdjust;
    }

    public void setSirasgnWorkloadAdjust(BigDecimal sirasgnWorkloadAdjust) {
        this.sirasgnWorkloadAdjust = sirasgnWorkloadAdjust;
    }

    public short getSirasgnPercentSess() {
        return sirasgnPercentSess;
    }

    public void setSirasgnPercentSess(short sirasgnPercentSess) {
        this.sirasgnPercentSess = sirasgnPercentSess;
    }

    public String getSirasgnPrimaryInd() {
        return sirasgnPrimaryInd;
    }

    public void setSirasgnPrimaryInd(String sirasgnPrimaryInd) {
        this.sirasgnPrimaryInd = sirasgnPrimaryInd;
    }

    public String getSirasgnOverRide() {
        return sirasgnOverRide;
    }

    public void setSirasgnOverRide(String sirasgnOverRide) {
        this.sirasgnOverRide = sirasgnOverRide;
    }

    public Integer getSirasgnPosition() {
        return sirasgnPosition;
    }

    public void setSirasgnPosition(Integer sirasgnPosition) {
        this.sirasgnPosition = sirasgnPosition;
    }

    public Date getSirasgnActivityDate() {
        return sirasgnActivityDate;
    }

    public void setSirasgnActivityDate(Date sirasgnActivityDate) {
        this.sirasgnActivityDate = sirasgnActivityDate;
    }

    public String getSirasgnFcntCode() {
        return sirasgnFcntCode;
    }

    public void setSirasgnFcntCode(String sirasgnFcntCode) {
        this.sirasgnFcntCode = sirasgnFcntCode;
    }

    public String getSirasgnPosn() {
        return sirasgnPosn;
    }

    public void setSirasgnPosn(String sirasgnPosn) {
        this.sirasgnPosn = sirasgnPosn;
    }

    public String getSirasgnSuff() {
        return sirasgnSuff;
    }

    public void setSirasgnSuff(String sirasgnSuff) {
        this.sirasgnSuff = sirasgnSuff;
    }

    public String getSirasgnAstyCode() {
        return sirasgnAstyCode;
    }

    public void setSirasgnAstyCode(String sirasgnAstyCode) {
        this.sirasgnAstyCode = sirasgnAstyCode;
    }

    public String getSirasgnDataOrigin() {
        return sirasgnDataOrigin;
    }

    public void setSirasgnDataOrigin(String sirasgnDataOrigin) {
        this.sirasgnDataOrigin = sirasgnDataOrigin;
    }

    public String getSirasgnUserId() {
        return sirasgnUserId;
    }

    public void setSirasgnUserId(String sirasgnUserId) {
        this.sirasgnUserId = sirasgnUserId;
    }

    public BigDecimal getSirasgnWorkloadIncr() {
        return sirasgnWorkloadIncr;
    }

    public void setSirasgnWorkloadIncr(BigDecimal sirasgnWorkloadIncr) {
        this.sirasgnWorkloadIncr = sirasgnWorkloadIncr;
    }

    public Short getSirasgnIncrEnrl() {
        return sirasgnIncrEnrl;
    }

    public void setSirasgnIncrEnrl(Short sirasgnIncrEnrl) {
        this.sirasgnIncrEnrl = sirasgnIncrEnrl;
    }

    public Date getSirasgnIncrEnrlDate() {
        return sirasgnIncrEnrlDate;
    }

    public void setSirasgnIncrEnrlDate(Date sirasgnIncrEnrlDate) {
        this.sirasgnIncrEnrlDate = sirasgnIncrEnrlDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirasgnPK != null ? sirasgnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirasgn)) {
            return false;
        }
        Sirasgn other = (Sirasgn) object;
        if ((this.sirasgnPK == null && other.sirasgnPK != null) || (this.sirasgnPK != null && !this.sirasgnPK.equals(other.sirasgnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Sirasgn[ sirasgnPK=" + sirasgnPK + " ]";
    }
    
}
