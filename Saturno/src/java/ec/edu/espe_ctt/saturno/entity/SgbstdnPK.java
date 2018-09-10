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
public class SgbstdnPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SGBSTDN_PIDM")
    private int sgbstdnPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_EFF")
    private String sgbstdnTermCodeEff;

    public SgbstdnPK() {
    }

    public SgbstdnPK(int sgbstdnPidm, String sgbstdnTermCodeEff) {
        this.sgbstdnPidm = sgbstdnPidm;
        this.sgbstdnTermCodeEff = sgbstdnTermCodeEff;
    }

    public int getSgbstdnPidm() {
        return sgbstdnPidm;
    }

    public void setSgbstdnPidm(int sgbstdnPidm) {
        this.sgbstdnPidm = sgbstdnPidm;
    }

    public String getSgbstdnTermCodeEff() {
        return sgbstdnTermCodeEff;
    }

    public void setSgbstdnTermCodeEff(String sgbstdnTermCodeEff) {
        this.sgbstdnTermCodeEff = sgbstdnTermCodeEff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sgbstdnPidm;
        hash += (sgbstdnTermCodeEff != null ? sgbstdnTermCodeEff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgbstdnPK)) {
            return false;
        }
        SgbstdnPK other = (SgbstdnPK) object;
        if (this.sgbstdnPidm != other.sgbstdnPidm) {
            return false;
        }
        if ((this.sgbstdnTermCodeEff == null && other.sgbstdnTermCodeEff != null) || (this.sgbstdnTermCodeEff != null && !this.sgbstdnTermCodeEff.equals(other.sgbstdnTermCodeEff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.SgbstdnPK[ sgbstdnPidm=" + sgbstdnPidm + ", sgbstdnTermCodeEff=" + sgbstdnTermCodeEff + " ]";
    }
    
}
