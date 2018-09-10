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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "SEA_ZONA_PLANIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaZonaPlanificacion.findAll", query = "SELECT s FROM SeaZonaPlanificacion s")
    ,
    @NamedQuery(name = "SeaZonaPlanificacion.findByZopId", query = "SELECT s FROM SeaZonaPlanificacion s WHERE s.zopId = :zopId")
    ,
    @NamedQuery(name = "SeaZonaPlanificacion.findByZopNombre", query = "SELECT s FROM SeaZonaPlanificacion s WHERE s.zopNombre = :zopNombre")
    ,
    @NamedQuery(name = "SeaZonaPlanificacion.findByZopNombreLargo", query = "SELECT s FROM SeaZonaPlanificacion s WHERE s.zopNombreLargo = :zopNombreLargo")})
public class SeaZonaPlanificacion implements Serializable {

    @OneToMany(mappedBy = "zopId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaZonaDetalle> seaZonaDetalleList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(generator = "SEQ_SEA_ZONA_PLANIFICACION")
    @SequenceGenerator(name = "SEQ_SEA_ZONA_PLANIFICACION", sequenceName = "SEQ_SEA_ZONA_PLANIFICACION", allocationSize = 1)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZOP_ID")
    private BigDecimal zopId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ZOP_NOMBRE")
    private String zopNombre;
    @Size(max = 100)
    @Column(name = "ZOP_NOMBRE_LARGO")
    private String zopNombreLargo;
    @OneToMany(mappedBy = "zopId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaCanton> seaCantonList;

    public SeaZonaPlanificacion() {
    }

    public SeaZonaPlanificacion(BigDecimal zopId) {
        this.zopId = zopId;
    }

    public SeaZonaPlanificacion(BigDecimal zopId, String zopNombre) {
        this.zopId = zopId;
        this.zopNombre = zopNombre;
    }

    public BigDecimal getZopId() {
        return zopId;
    }

    public void setZopId(BigDecimal zopId) {
        this.zopId = zopId;
    }

    public String getZopNombre() {
        return zopNombre;
    }

    public void setZopNombre(String zopNombre) {
        this.zopNombre = zopNombre;
    }

    public String getZopNombreLargo() {
        return zopNombreLargo;
    }

    public void setZopNombreLargo(String zopNombreLargo) {
        this.zopNombreLargo = zopNombreLargo;
    }

    @XmlTransient
    public List<SeaCanton> getSeaCantonList() {
        return seaCantonList;
    }

    public void setSeaCantonList(List<SeaCanton> seaCantonList) {
        this.seaCantonList = seaCantonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zopId != null ? zopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaZonaPlanificacion)) {
            return false;
        }
        SeaZonaPlanificacion other = (SeaZonaPlanificacion) object;
        if ((this.zopId == null && other.zopId != null) || (this.zopId != null && !this.zopId.equals(other.zopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion[ zopId=" + zopId + " ]";
    }

    @XmlTransient
    public List<SeaZonaDetalle> getSeaZonaDetalleList() {
        return seaZonaDetalleList;
    }

    public void setSeaZonaDetalleList(List<SeaZonaDetalle> seaZonaDetalleList) {
        this.seaZonaDetalleList = seaZonaDetalleList;
    }

}
