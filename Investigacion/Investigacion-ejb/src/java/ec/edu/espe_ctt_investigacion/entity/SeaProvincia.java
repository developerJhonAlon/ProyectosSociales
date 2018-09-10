/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.util.Collections;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaProvincia.findAll", query = "SELECT s FROM SeaProvincia s"),
    @NamedQuery(name = "SeaProvincia.findByProId", query = "SELECT s FROM SeaProvincia s WHERE s.proId = :proId"),
    @NamedQuery(name = "SeaProvincia.findByProNombre", query = "SELECT s FROM SeaProvincia s WHERE s.proNombre = :proNombre"),
    @NamedQuery(name = "SeaProvincia.findByProCodInen", query = "SELECT s FROM SeaProvincia s WHERE s.proCodInen = :proCodInen"),
    @NamedQuery(name = "SeaProvincia.findByProRegion", query = "SELECT s FROM SeaProvincia s WHERE s.proRegion = :proRegion")})
public class SeaProvincia implements Serializable {
    @OneToMany(mappedBy = "proId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaCanton> seaCantonList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PRO_ID")
    private String proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Size(max = 100)
    @Column(name = "PRO_COD_INEN")
    private String proCodInen;
    @Size(max = 15)
    @Column(name = "PRO_REGION")
    private String proRegion;

    public SeaProvincia() {
    }

    public SeaProvincia(String proId) {
        this.proId = proId;
    }

    public SeaProvincia(String proId, String proNombre) {
        this.proId = proId;
        this.proNombre = proNombre;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProCodInen() {
        return proCodInen;
    }

    public void setProCodInen(String proCodInen) {
        this.proCodInen = proCodInen;
    }

    public String getProRegion() {
        return proRegion;
    }

    public void setProRegion(String proRegion) {
        this.proRegion = proRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaProvincia)) {
            return false;
        }
        SeaProvincia other = (SeaProvincia) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaProvincia[ proId=" + proId + " ]";
    }

    @XmlTransient
    public List<SeaCanton> getSeaCantonList() {
        Collections.sort(seaCantonList);
        return seaCantonList;
    }

    public void setSeaCantonList(List<SeaCanton> seaCantonList) {
        this.seaCantonList = seaCantonList;
    }

    @Transient
    private Boolean selected;    

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    
}
