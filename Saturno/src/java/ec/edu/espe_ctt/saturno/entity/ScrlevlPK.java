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
public class ScrlevlPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SCRLEVL_SUBJ_CODE")
    private String scrlevlSubjCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SCRLEVL_CRSE_NUMB")
    private String scrlevlCrseNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SCRLEVL_EFF_TERM")
    private String scrlevlEffTerm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SCRLEVL_LEVL_CODE")
    private String scrlevlLevlCode;

    public ScrlevlPK() {
    }

    public ScrlevlPK(String scrlevlSubjCode, String scrlevlCrseNumb, String scrlevlEffTerm, String scrlevlLevlCode) {
        this.scrlevlSubjCode = scrlevlSubjCode;
        this.scrlevlCrseNumb = scrlevlCrseNumb;
        this.scrlevlEffTerm = scrlevlEffTerm;
        this.scrlevlLevlCode = scrlevlLevlCode;
    }

    public String getScrlevlSubjCode() {
        return scrlevlSubjCode;
    }

    public void setScrlevlSubjCode(String scrlevlSubjCode) {
        this.scrlevlSubjCode = scrlevlSubjCode;
    }

    public String getScrlevlCrseNumb() {
        return scrlevlCrseNumb;
    }

    public void setScrlevlCrseNumb(String scrlevlCrseNumb) {
        this.scrlevlCrseNumb = scrlevlCrseNumb;
    }

    public String getScrlevlEffTerm() {
        return scrlevlEffTerm;
    }

    public void setScrlevlEffTerm(String scrlevlEffTerm) {
        this.scrlevlEffTerm = scrlevlEffTerm;
    }

    public String getScrlevlLevlCode() {
        return scrlevlLevlCode;
    }

    public void setScrlevlLevlCode(String scrlevlLevlCode) {
        this.scrlevlLevlCode = scrlevlLevlCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scrlevlSubjCode != null ? scrlevlSubjCode.hashCode() : 0);
        hash += (scrlevlCrseNumb != null ? scrlevlCrseNumb.hashCode() : 0);
        hash += (scrlevlEffTerm != null ? scrlevlEffTerm.hashCode() : 0);
        hash += (scrlevlLevlCode != null ? scrlevlLevlCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScrlevlPK)) {
            return false;
        }
        ScrlevlPK other = (ScrlevlPK) object;
        if ((this.scrlevlSubjCode == null && other.scrlevlSubjCode != null) || (this.scrlevlSubjCode != null && !this.scrlevlSubjCode.equals(other.scrlevlSubjCode))) {
            return false;
        }
        if ((this.scrlevlCrseNumb == null && other.scrlevlCrseNumb != null) || (this.scrlevlCrseNumb != null && !this.scrlevlCrseNumb.equals(other.scrlevlCrseNumb))) {
            return false;
        }
        if ((this.scrlevlEffTerm == null && other.scrlevlEffTerm != null) || (this.scrlevlEffTerm != null && !this.scrlevlEffTerm.equals(other.scrlevlEffTerm))) {
            return false;
        }
        if ((this.scrlevlLevlCode == null && other.scrlevlLevlCode != null) || (this.scrlevlLevlCode != null && !this.scrlevlLevlCode.equals(other.scrlevlLevlCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.ScrlevlPK[ scrlevlSubjCode=" + scrlevlSubjCode + ", scrlevlCrseNumb=" + scrlevlCrseNumb + ", scrlevlEffTerm=" + scrlevlEffTerm + ", scrlevlLevlCode=" + scrlevlLevlCode + " ]";
    }
    
}
