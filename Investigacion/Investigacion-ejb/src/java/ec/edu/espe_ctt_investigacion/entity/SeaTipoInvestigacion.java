/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_TIPO_INVESTIGACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTipoInvestigacion.findAll", query = "SELECT s FROM SeaTipoInvestigacion s"),
    @NamedQuery(name = "SeaTipoInvestigacion.findByTipinveId", query = "SELECT s FROM SeaTipoInvestigacion s WHERE s.tipinveId = :tipinveId"),
    @NamedQuery(name = "SeaTipoInvestigacion.findByTipinveDescrip", query = "SELECT s FROM SeaTipoInvestigacion s WHERE s.tipinveDescrip = :tipinveDescrip")})
public class SeaTipoInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPINVE_ID")
    private BigDecimal tipinveId;
    @Size(max = 50)
    @Column(name = "TIPINVE_DESCRIP")
    private String tipinveDescrip;
    @OneToMany(mappedBy = "tipinveId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProy> seaDatGeneralProyList;

    public SeaTipoInvestigacion() {
    }

    public SeaTipoInvestigacion(BigDecimal tipinveId) {
        this.tipinveId = tipinveId;
    }

    public BigDecimal getTipinveId() {
        return tipinveId;
    }

    public void setTipinveId(BigDecimal tipinveId) {
        this.tipinveId = tipinveId;
    }

    public String getTipinveDescrip() {
        return tipinveDescrip;
    }

    public void setTipinveDescrip(String tipinveDescrip) {
        this.tipinveDescrip = tipinveDescrip;
    }

    @XmlTransient
    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
        return seaDatGeneralProyList;
    }

    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
        this.seaDatGeneralProyList = seaDatGeneralProyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipinveId != null ? tipinveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaTipoInvestigacion)) {
            return false;
        }
        SeaTipoInvestigacion other = (SeaTipoInvestigacion) object;
        if ((this.tipinveId == null && other.tipinveId != null) || (this.tipinveId != null && !this.tipinveId.equals(other.tipinveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaTipoInvestigacion[ tipinveId=" + tipinveId + " ]";
    }
    
}
