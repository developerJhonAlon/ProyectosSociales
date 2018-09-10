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
public class SirasgnPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SIRASGN_TERM_CODE")
    private String sirasgnTermCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SIRASGN_CRN")
    private String sirasgnCrn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIRASGN_PIDM")
    private int sirasgnPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SIRASGN_CATEGORY")
    private String sirasgnCategory;

    public SirasgnPK() {
    }

    public SirasgnPK(String sirasgnTermCode, String sirasgnCrn, int sirasgnPidm, String sirasgnCategory) {
        this.sirasgnTermCode = sirasgnTermCode;
        this.sirasgnCrn = sirasgnCrn;
        this.sirasgnPidm = sirasgnPidm;
        this.sirasgnCategory = sirasgnCategory;
    }

    public String getSirasgnTermCode() {
        return sirasgnTermCode;
    }

    public void setSirasgnTermCode(String sirasgnTermCode) {
        this.sirasgnTermCode = sirasgnTermCode;
    }

    public String getSirasgnCrn() {
        return sirasgnCrn;
    }

    public void setSirasgnCrn(String sirasgnCrn) {
        this.sirasgnCrn = sirasgnCrn;
    }

    public int getSirasgnPidm() {
        return sirasgnPidm;
    }

    public void setSirasgnPidm(int sirasgnPidm) {
        this.sirasgnPidm = sirasgnPidm;
    }

    public String getSirasgnCategory() {
        return sirasgnCategory;
    }

    public void setSirasgnCategory(String sirasgnCategory) {
        this.sirasgnCategory = sirasgnCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirasgnTermCode != null ? sirasgnTermCode.hashCode() : 0);
        hash += (sirasgnCrn != null ? sirasgnCrn.hashCode() : 0);
        hash += (int) sirasgnPidm;
        hash += (sirasgnCategory != null ? sirasgnCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SirasgnPK)) {
            return false;
        }
        SirasgnPK other = (SirasgnPK) object;
        if ((this.sirasgnTermCode == null && other.sirasgnTermCode != null) || (this.sirasgnTermCode != null && !this.sirasgnTermCode.equals(other.sirasgnTermCode))) {
            return false;
        }
        if ((this.sirasgnCrn == null && other.sirasgnCrn != null) || (this.sirasgnCrn != null && !this.sirasgnCrn.equals(other.sirasgnCrn))) {
            return false;
        }
        if (this.sirasgnPidm != other.sirasgnPidm) {
            return false;
        }
        if ((this.sirasgnCategory == null && other.sirasgnCategory != null) || (this.sirasgnCategory != null && !this.sirasgnCategory.equals(other.sirasgnCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.SirasgnPK[ sirasgnTermCode=" + sirasgnTermCode + ", sirasgnCrn=" + sirasgnCrn + ", sirasgnPidm=" + sirasgnPidm + ", sirasgnCategory=" + sirasgnCategory + " ]";
    }
    
}
