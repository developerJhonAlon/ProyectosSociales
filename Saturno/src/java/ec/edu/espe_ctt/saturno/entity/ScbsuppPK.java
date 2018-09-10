/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC1
 */
@Embeddable
public class ScbsuppPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SCBSUPP_SUBJ_CODE")
    private String scbsuppSubjCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SCBSUPP_CRSE_NUMB")
    private String scbsuppCrseNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SCBSUPP_EFF_TERM")
    private String scbsuppEffTerm;

    public ScbsuppPK() {
    }

    public ScbsuppPK(String scbsuppSubjCode, String scbsuppCrseNumb, String scbsuppEffTerm) {
        this.scbsuppSubjCode = scbsuppSubjCode;
        this.scbsuppCrseNumb = scbsuppCrseNumb;
        this.scbsuppEffTerm = scbsuppEffTerm;
    }

    public String getScbsuppSubjCode() {
        return scbsuppSubjCode;
    }

    public void setScbsuppSubjCode(String scbsuppSubjCode) {
        this.scbsuppSubjCode = scbsuppSubjCode;
    }

    public String getScbsuppCrseNumb() {
        return scbsuppCrseNumb;
    }

    public void setScbsuppCrseNumb(String scbsuppCrseNumb) {
        this.scbsuppCrseNumb = scbsuppCrseNumb;
    }

    public String getScbsuppEffTerm() {
        return scbsuppEffTerm;
    }

    public void setScbsuppEffTerm(String scbsuppEffTerm) {
        this.scbsuppEffTerm = scbsuppEffTerm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scbsuppSubjCode != null ? scbsuppSubjCode.hashCode() : 0);
        hash += (scbsuppCrseNumb != null ? scbsuppCrseNumb.hashCode() : 0);
        hash += (scbsuppEffTerm != null ? scbsuppEffTerm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScbsuppPK)) {
            return false;
        }
        ScbsuppPK other = (ScbsuppPK) object;
        if ((this.scbsuppSubjCode == null && other.scbsuppSubjCode != null) || (this.scbsuppSubjCode != null && !this.scbsuppSubjCode.equals(other.scbsuppSubjCode))) {
            return false;
        }
        if ((this.scbsuppCrseNumb == null && other.scbsuppCrseNumb != null) || (this.scbsuppCrseNumb != null && !this.scbsuppCrseNumb.equals(other.scbsuppCrseNumb))) {
            return false;
        }
        if ((this.scbsuppEffTerm == null && other.scbsuppEffTerm != null) || (this.scbsuppEffTerm != null && !this.scbsuppEffTerm.equals(other.scbsuppEffTerm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.ScbsuppPK[ scbsuppSubjCode=" + scbsuppSubjCode + ", scbsuppCrseNumb=" + scbsuppCrseNumb + ", scbsuppEffTerm=" + scbsuppEffTerm + " ]";
    }
    
}
