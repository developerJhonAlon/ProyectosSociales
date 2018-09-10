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
@Table(name = "SEA_ANIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaAnio.findAll", query = "SELECT s FROM SeaAnio s"),
    @NamedQuery(name = "SeaAnio.findBySaniId", query = "SELECT s FROM SeaAnio s WHERE s.saniId = :saniId"),
    @NamedQuery(name = "SeaAnio.findBySaniDetalle", query = "SELECT s FROM SeaAnio s WHERE s.saniDetalle = :saniDetalle")})
public class SeaAnio implements Serializable {
    @OneToMany(mappedBy = "saniId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupnc> seaTotalPresupncList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SANI_ID")
    private BigDecimal saniId;
    @Size(max = 25)
    @Column(name = "SANI_DETALLE")
    private String saniDetalle;
    @OneToMany(mappedBy = "saniId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPresupNotasc> seaPresupNotascList;

    public SeaAnio() {
    }

    public SeaAnio(BigDecimal saniId) {
        this.saniId = saniId;
    }

    public BigDecimal getSaniId() {
        return saniId;
    }

    public void setSaniId(BigDecimal saniId) {
        this.saniId = saniId;
    }

    public String getSaniDetalle() {
        return saniDetalle;
    }

    public void setSaniDetalle(String saniDetalle) {
        this.saniDetalle = saniDetalle;
    }

    @XmlTransient
    public List<SeaPresupNotasc> getSeaPresupNotascList() {
        return seaPresupNotascList;
    }

    public void setSeaPresupNotascList(List<SeaPresupNotasc> seaPresupNotascList) {
        this.seaPresupNotascList = seaPresupNotascList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saniId != null ? saniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaAnio)) {
            return false;
        }
        SeaAnio other = (SeaAnio) object;
        if ((this.saniId == null && other.saniId != null) || (this.saniId != null && !this.saniId.equals(other.saniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaAnio[ saniId=" + saniId + " ]";
    }

    @XmlTransient
    public List<SeaTotalPresupnc> getSeaTotalPresupncList() {
        return seaTotalPresupncList;
    }

    public void setSeaTotalPresupncList(List<SeaTotalPresupnc> seaTotalPresupncList) {
        this.seaTotalPresupncList = seaTotalPresupncList;
    }
    
}
