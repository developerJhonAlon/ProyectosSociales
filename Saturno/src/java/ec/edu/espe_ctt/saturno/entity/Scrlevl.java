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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SCRLEVL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scrlevl.findAll", query = "SELECT s FROM Scrlevl s"),
    @NamedQuery(name = "Scrlevl.findByScrlevlSubjCode", query = "SELECT s FROM Scrlevl s WHERE s.scrlevlPK.scrlevlSubjCode = :scrlevlSubjCode"),
    @NamedQuery(name = "Scrlevl.findByScrlevlCrseNumb", query = "SELECT s FROM Scrlevl s WHERE s.scrlevlPK.scrlevlCrseNumb = :scrlevlCrseNumb"),
    @NamedQuery(name = "Scrlevl.findByScrlevlEffTerm", query = "SELECT s FROM Scrlevl s WHERE s.scrlevlPK.scrlevlEffTerm = :scrlevlEffTerm"),
    @NamedQuery(name = "Scrlevl.findByScrlevlLevlCode", query = "SELECT s FROM Scrlevl s WHERE s.scrlevlPK.scrlevlLevlCode = :scrlevlLevlCode"),
    @NamedQuery(name = "Scrlevl.findByScrlevlActivityDate", query = "SELECT s FROM Scrlevl s WHERE s.scrlevlActivityDate = :scrlevlActivityDate")})
public class Scrlevl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScrlevlPK scrlevlPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCRLEVL_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scrlevlActivityDate;

    public Scrlevl() {
    }

    public Scrlevl(ScrlevlPK scrlevlPK) {
        this.scrlevlPK = scrlevlPK;
    }

    public Scrlevl(ScrlevlPK scrlevlPK, Date scrlevlActivityDate) {
        this.scrlevlPK = scrlevlPK;
        this.scrlevlActivityDate = scrlevlActivityDate;
    }

    public Scrlevl(String scrlevlSubjCode, String scrlevlCrseNumb, String scrlevlEffTerm, String scrlevlLevlCode) {
        this.scrlevlPK = new ScrlevlPK(scrlevlSubjCode, scrlevlCrseNumb, scrlevlEffTerm, scrlevlLevlCode);
    }

    public ScrlevlPK getScrlevlPK() {
        return scrlevlPK;
    }

    public void setScrlevlPK(ScrlevlPK scrlevlPK) {
        this.scrlevlPK = scrlevlPK;
    }

    public Date getScrlevlActivityDate() {
        return scrlevlActivityDate;
    }

    public void setScrlevlActivityDate(Date scrlevlActivityDate) {
        this.scrlevlActivityDate = scrlevlActivityDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scrlevlPK != null ? scrlevlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scrlevl)) {
            return false;
        }
        Scrlevl other = (Scrlevl) object;
        if ((this.scrlevlPK == null && other.scrlevlPK != null) || (this.scrlevlPK != null && !this.scrlevlPK.equals(other.scrlevlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Scrlevl[ scrlevlPK=" + scrlevlPK + " ]";
    }
    
}
