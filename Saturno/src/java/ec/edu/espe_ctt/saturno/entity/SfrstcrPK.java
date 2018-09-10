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
public class SfrstcrPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SFRSTCR_TERM_CODE")
    private String sfrstcrTermCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFRSTCR_PIDM")
    private int sfrstcrPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SFRSTCR_CRN")
    private String sfrstcrCrn;

    public SfrstcrPK() {
    }

    public SfrstcrPK(String sfrstcrTermCode, int sfrstcrPidm, String sfrstcrCrn) {
        this.sfrstcrTermCode = sfrstcrTermCode;
        this.sfrstcrPidm = sfrstcrPidm;
        this.sfrstcrCrn = sfrstcrCrn;
    }

    public String getSfrstcrTermCode() {
        return sfrstcrTermCode;
    }

    public void setSfrstcrTermCode(String sfrstcrTermCode) {
        this.sfrstcrTermCode = sfrstcrTermCode;
    }

    public int getSfrstcrPidm() {
        return sfrstcrPidm;
    }

    public void setSfrstcrPidm(int sfrstcrPidm) {
        this.sfrstcrPidm = sfrstcrPidm;
    }

    public String getSfrstcrCrn() {
        return sfrstcrCrn;
    }

    public void setSfrstcrCrn(String sfrstcrCrn) {
        this.sfrstcrCrn = sfrstcrCrn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfrstcrTermCode != null ? sfrstcrTermCode.hashCode() : 0);
        hash += (int) sfrstcrPidm;
        hash += (sfrstcrCrn != null ? sfrstcrCrn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfrstcrPK)) {
            return false;
        }
        SfrstcrPK other = (SfrstcrPK) object;
        if ((this.sfrstcrTermCode == null && other.sfrstcrTermCode != null) || (this.sfrstcrTermCode != null && !this.sfrstcrTermCode.equals(other.sfrstcrTermCode))) {
            return false;
        }
        if (this.sfrstcrPidm != other.sfrstcrPidm) {
            return false;
        }
        if ((this.sfrstcrCrn == null && other.sfrstcrCrn != null) || (this.sfrstcrCrn != null && !this.sfrstcrCrn.equals(other.sfrstcrCrn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.SfrstcrPK[ sfrstcrTermCode=" + sfrstcrTermCode + ", sfrstcrPidm=" + sfrstcrPidm + ", sfrstcrCrn=" + sfrstcrCrn + " ]";
    }
    
}
