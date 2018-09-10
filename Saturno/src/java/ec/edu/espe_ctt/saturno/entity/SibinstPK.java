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
public class SibinstPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIBINST_PIDM")
    private int sibinstPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SIBINST_TERM_CODE_EFF")
    private String sibinstTermCodeEff;

    public SibinstPK() {
    }

    public SibinstPK(int sibinstPidm, String sibinstTermCodeEff) {
        this.sibinstPidm = sibinstPidm;
        this.sibinstTermCodeEff = sibinstTermCodeEff;
    }

    public int getSibinstPidm() {
        return sibinstPidm;
    }

    public void setSibinstPidm(int sibinstPidm) {
        this.sibinstPidm = sibinstPidm;
    }

    public String getSibinstTermCodeEff() {
        return sibinstTermCodeEff;
    }

    public void setSibinstTermCodeEff(String sibinstTermCodeEff) {
        this.sibinstTermCodeEff = sibinstTermCodeEff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sibinstPidm;
        hash += (sibinstTermCodeEff != null ? sibinstTermCodeEff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SibinstPK)) {
            return false;
        }
        SibinstPK other = (SibinstPK) object;
        if (this.sibinstPidm != other.sibinstPidm) {
            return false;
        }
        if ((this.sibinstTermCodeEff == null && other.sibinstTermCodeEff != null) || (this.sibinstTermCodeEff != null && !this.sibinstTermCodeEff.equals(other.sibinstTermCodeEff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.SibinstPK[ sibinstPidm=" + sibinstPidm + ", sibinstTermCodeEff=" + sibinstTermCodeEff + " ]";
    }
    
}
