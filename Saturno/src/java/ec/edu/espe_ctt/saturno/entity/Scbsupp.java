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
@Table(name = "SCBSUPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scbsupp.findAll", query = "SELECT s FROM Scbsupp s"),
    @NamedQuery(name = "Scbsupp.findByScbsuppSubjCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppPK.scbsuppSubjCode = :scbsuppSubjCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCrseNumb", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppPK.scbsuppCrseNumb = :scbsuppCrseNumb"),
    @NamedQuery(name = "Scbsupp.findByScbsuppEffTerm", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppPK.scbsuppEffTerm = :scbsuppEffTerm"),
    @NamedQuery(name = "Scbsupp.findByScbsuppTopsCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppTopsCode = :scbsuppTopsCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppOccsCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppOccsCode = :scbsuppOccsCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCcslCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCcslCode = :scbsuppCcslCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCoopEdInd", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCoopEdInd = :scbsuppCoopEdInd"),
    @NamedQuery(name = "Scbsupp.findByScbsuppActivityDate", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppActivityDate = :scbsuppActivityDate"),
    @NamedQuery(name = "Scbsupp.findByScbsuppPermDistInd", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppPermDistInd = :scbsuppPermDistInd"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCudaCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCudaCode = :scbsuppCudaCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCudbCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCudbCode = :scbsuppCudbCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCudcCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCudcCode = :scbsuppCudcCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCuddCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCuddCode = :scbsuppCuddCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCudeCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCudeCode = :scbsuppCudeCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCudfCode", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCudfCode = :scbsuppCudfCode"),
    @NamedQuery(name = "Scbsupp.findByScbsuppCreditCategoryInd", query = "SELECT s FROM Scbsupp s WHERE s.scbsuppCreditCategoryInd = :scbsuppCreditCategoryInd")})
public class Scbsupp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScbsuppPK scbsuppPK;
    @Size(max = 6)
    @Column(name = "SCBSUPP_TOPS_CODE")
    private String scbsuppTopsCode;
    @Size(max = 2)
    @Column(name = "SCBSUPP_OCCS_CODE")
    private String scbsuppOccsCode;
    @Size(max = 2)
    @Column(name = "SCBSUPP_CCSL_CODE")
    private String scbsuppCcslCode;
    @Size(max = 1)
    @Column(name = "SCBSUPP_COOP_ED_IND")
    private String scbsuppCoopEdInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCBSUPP_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scbsuppActivityDate;
    @Size(max = 12)
    @Column(name = "SCBSUPP_PERM_DIST_IND")
    private String scbsuppPermDistInd;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDA_CODE")
    private String scbsuppCudaCode;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDB_CODE")
    private String scbsuppCudbCode;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDC_CODE")
    private String scbsuppCudcCode;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDD_CODE")
    private String scbsuppCuddCode;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDE_CODE")
    private String scbsuppCudeCode;
    @Size(max = 15)
    @Column(name = "SCBSUPP_CUDF_CODE")
    private String scbsuppCudfCode;
    @Size(max = 5)
    @Column(name = "SCBSUPP_CREDIT_CATEGORY_IND")
    private String scbsuppCreditCategoryInd;

    public Scbsupp() {
    }

    public Scbsupp(ScbsuppPK scbsuppPK) {
        this.scbsuppPK = scbsuppPK;
    }

    public Scbsupp(ScbsuppPK scbsuppPK, Date scbsuppActivityDate) {
        this.scbsuppPK = scbsuppPK;
        this.scbsuppActivityDate = scbsuppActivityDate;
    }

    public Scbsupp(String scbsuppSubjCode, String scbsuppCrseNumb, String scbsuppEffTerm) {
        this.scbsuppPK = new ScbsuppPK(scbsuppSubjCode, scbsuppCrseNumb, scbsuppEffTerm);
    }

    public ScbsuppPK getScbsuppPK() {
        return scbsuppPK;
    }

    public void setScbsuppPK(ScbsuppPK scbsuppPK) {
        this.scbsuppPK = scbsuppPK;
    }

    public String getScbsuppTopsCode() {
        return scbsuppTopsCode;
    }

    public void setScbsuppTopsCode(String scbsuppTopsCode) {
        this.scbsuppTopsCode = scbsuppTopsCode;
    }

    public String getScbsuppOccsCode() {
        return scbsuppOccsCode;
    }

    public void setScbsuppOccsCode(String scbsuppOccsCode) {
        this.scbsuppOccsCode = scbsuppOccsCode;
    }

    public String getScbsuppCcslCode() {
        return scbsuppCcslCode;
    }

    public void setScbsuppCcslCode(String scbsuppCcslCode) {
        this.scbsuppCcslCode = scbsuppCcslCode;
    }

    public String getScbsuppCoopEdInd() {
        return scbsuppCoopEdInd;
    }

    public void setScbsuppCoopEdInd(String scbsuppCoopEdInd) {
        this.scbsuppCoopEdInd = scbsuppCoopEdInd;
    }

    public Date getScbsuppActivityDate() {
        return scbsuppActivityDate;
    }

    public void setScbsuppActivityDate(Date scbsuppActivityDate) {
        this.scbsuppActivityDate = scbsuppActivityDate;
    }

    public String getScbsuppPermDistInd() {
        return scbsuppPermDistInd;
    }

    public void setScbsuppPermDistInd(String scbsuppPermDistInd) {
        this.scbsuppPermDistInd = scbsuppPermDistInd;
    }

    public String getScbsuppCudaCode() {
        return scbsuppCudaCode;
    }

    public void setScbsuppCudaCode(String scbsuppCudaCode) {
        this.scbsuppCudaCode = scbsuppCudaCode;
    }

    public String getScbsuppCudbCode() {
        return scbsuppCudbCode;
    }

    public void setScbsuppCudbCode(String scbsuppCudbCode) {
        this.scbsuppCudbCode = scbsuppCudbCode;
    }

    public String getScbsuppCudcCode() {
        return scbsuppCudcCode;
    }

    public void setScbsuppCudcCode(String scbsuppCudcCode) {
        this.scbsuppCudcCode = scbsuppCudcCode;
    }

    public String getScbsuppCuddCode() {
        return scbsuppCuddCode;
    }

    public void setScbsuppCuddCode(String scbsuppCuddCode) {
        this.scbsuppCuddCode = scbsuppCuddCode;
    }

    public String getScbsuppCudeCode() {
        return scbsuppCudeCode;
    }

    public void setScbsuppCudeCode(String scbsuppCudeCode) {
        this.scbsuppCudeCode = scbsuppCudeCode;
    }

    public String getScbsuppCudfCode() {
        return scbsuppCudfCode;
    }

    public void setScbsuppCudfCode(String scbsuppCudfCode) {
        this.scbsuppCudfCode = scbsuppCudfCode;
    }

    public String getScbsuppCreditCategoryInd() {
        return scbsuppCreditCategoryInd;
    }

    public void setScbsuppCreditCategoryInd(String scbsuppCreditCategoryInd) {
        this.scbsuppCreditCategoryInd = scbsuppCreditCategoryInd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scbsuppPK != null ? scbsuppPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scbsupp)) {
            return false;
        }
        Scbsupp other = (Scbsupp) object;
        if ((this.scbsuppPK == null && other.scbsuppPK != null) || (this.scbsuppPK != null && !this.scbsuppPK.equals(other.scbsuppPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Scbsupp[ scbsuppPK=" + scbsuppPK + " ]";
    }
    
}
