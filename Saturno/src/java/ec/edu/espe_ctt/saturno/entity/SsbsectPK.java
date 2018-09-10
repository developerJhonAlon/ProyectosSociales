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
public class SsbsectPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SSBSECT_TERM_CODE")
    private String ssbsectTermCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SSBSECT_CRN")
    private String ssbsectCrn;

    public SsbsectPK() {
    }

    public SsbsectPK(String ssbsectTermCode, String ssbsectCrn) {
        this.ssbsectTermCode = ssbsectTermCode;
        this.ssbsectCrn = ssbsectCrn;
    }

    public String getSsbsectTermCode() {
        return ssbsectTermCode;
    }

    public void setSsbsectTermCode(String ssbsectTermCode) {
        this.ssbsectTermCode = ssbsectTermCode;
    }

    public String getSsbsectCrn() {
        return ssbsectCrn;
    }

    public void setSsbsectCrn(String ssbsectCrn) {
        this.ssbsectCrn = ssbsectCrn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssbsectTermCode != null ? ssbsectTermCode.hashCode() : 0);
        hash += (ssbsectCrn != null ? ssbsectCrn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsbsectPK)) {
            return false;
        }
        SsbsectPK other = (SsbsectPK) object;
        if ((this.ssbsectTermCode == null && other.ssbsectTermCode != null) || (this.ssbsectTermCode != null && !this.ssbsectTermCode.equals(other.ssbsectTermCode))) {
            return false;
        }
        if ((this.ssbsectCrn == null && other.ssbsectCrn != null) || (this.ssbsectCrn != null && !this.ssbsectCrn.equals(other.ssbsectCrn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.SsbsectPK[ ssbsectTermCode=" + ssbsectTermCode + ", ssbsectCrn=" + ssbsectCrn + " ]";
    }
    
}
