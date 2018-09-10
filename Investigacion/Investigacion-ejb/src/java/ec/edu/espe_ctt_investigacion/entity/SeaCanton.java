/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SEA_CANTON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaCanton.findAll", query = "SELECT s FROM SeaCanton s"),
    @NamedQuery(name = "SeaCanton.findByCanId", query = "SELECT s FROM SeaCanton s WHERE s.canId = :canId"),
    @NamedQuery(name = "SeaCanton.findByCanNombre", query = "SELECT s FROM SeaCanton s WHERE s.canNombre = :canNombre"),
    @NamedQuery(name = "SeaCanton.findByCanBanner", query = "SELECT s FROM SeaCanton s WHERE s.canBanner = :canBanner"),
    @NamedQuery(name = "SeaCanton.findByCanGrupo", query = "SELECT s FROM SeaCanton s WHERE s.canGrupo = :canGrupo"),
    @NamedQuery(name = "SeaCanton.findByCanLatitud", query = "SELECT s FROM SeaCanton s WHERE s.canLatitud = :canLatitud"),
    @NamedQuery(name = "SeaCanton.findByCanLongitud", query = "SELECT s FROM SeaCanton s WHERE s.canLongitud = :canLongitud")})
public class SeaCanton implements Serializable, Comparable<SeaCanton> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CAN_ID")
    private String canId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CAN_NOMBRE")
    private String canNombre;
    @Size(max = 100)
    @Column(name = "CAN_BANNER")
    private String canBanner;
    @Column(name = "CAN_GRUPO")
    private BigInteger canGrupo;
    @Column(name = "CAN_LATITUD")
    private BigInteger canLatitud;
    @Column(name = "CAN_LONGITUD")
    private BigInteger canLongitud;
    @JoinColumn(name = "ZOP_ID", referencedColumnName = "ZOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaZonaPlanificacion zopId;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeaProvincia proId;
    @OneToMany(mappedBy = "canId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaParroquia> seaParroquiaList;

    public SeaCanton() {
    }

    public SeaCanton(String canId) {
        this.canId = canId;
    }

    public SeaCanton(String canId, String canNombre) {
        this.canId = canId;
        this.canNombre = canNombre;
    }

    public String getCanId() {
        return canId;
    }

    public void setCanId(String canId) {
        this.canId = canId;
    }

    public String getCanNombre() {
        return canNombre;
    }

    public void setCanNombre(String canNombre) {
        this.canNombre = canNombre;
    }

    public String getCanBanner() {
        return canBanner;
    }

    public void setCanBanner(String canBanner) {
        this.canBanner = canBanner;
    }

    public BigInteger getCanGrupo() {
        return canGrupo;
    }

    public void setCanGrupo(BigInteger canGrupo) {
        this.canGrupo = canGrupo;
    }

    public BigInteger getCanLatitud() {
        return canLatitud;
    }

    public void setCanLatitud(BigInteger canLatitud) {
        this.canLatitud = canLatitud;
    }

    public BigInteger getCanLongitud() {
        return canLongitud;
    }

    public void setCanLongitud(BigInteger canLongitud) {
        this.canLongitud = canLongitud;
    }

    public SeaZonaPlanificacion getZopId() {
        return zopId;
    }

    public void setZopId(SeaZonaPlanificacion zopId) {
        this.zopId = zopId;
    }

    public SeaProvincia getProId() {
        return proId;
    }

    public void setProId(SeaProvincia proId) {
        this.proId = proId;
    }

    @XmlTransient
    public List<SeaParroquia> getSeaParroquiaList() {
        Collections.sort(seaParroquiaList);
        return seaParroquiaList;
    }

    public void setSeaParroquiaList(List<SeaParroquia> seaParroquiaList) {
        this.seaParroquiaList = seaParroquiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canId != null ? canId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaCanton)) {
            return false;
        }
        SeaCanton other = (SeaCanton) object;
        if ((this.canId == null && other.canId != null) || (this.canId != null && !this.canId.equals(other.canId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaCanton[ canId=" + canId + " ]";
    }

    @Override
    public int compareTo(SeaCanton o) {
        return this.canNombre.compareTo(o.canNombre);
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
