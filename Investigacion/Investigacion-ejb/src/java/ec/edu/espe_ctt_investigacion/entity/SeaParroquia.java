/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PARROQUIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaParroquia.findAll", query = "SELECT s FROM SeaParroquia s"),
    @NamedQuery(name = "SeaParroquia.findByPrqId", query = "SELECT s FROM SeaParroquia s WHERE s.prqId = :prqId"),
    @NamedQuery(name = "SeaParroquia.findByPrqNombre", query = "SELECT s FROM SeaParroquia s WHERE s.prqNombre = :prqNombre"),
    @NamedQuery(name = "SeaParroquia.findByPrqTipo", query = "SELECT s FROM SeaParroquia s WHERE s.prqTipo = :prqTipo"),
    @NamedQuery(name = "SeaParroquia.findByPrqGrupoRecinto", query = "SELECT s FROM SeaParroquia s WHERE s.prqGrupoRecinto = :prqGrupoRecinto")})
public class SeaParroquia implements Serializable, Comparable<SeaParroquia> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PRQ_ID")
    private String prqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PRQ_NOMBRE")
    private String prqNombre;
    @Size(max = 1)
    @Column(name = "PRQ_TIPO")
    private String prqTipo;
    @Column(name = "PRQ_GRUPO_RECINTO")
    private BigInteger prqGrupoRecinto;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeaCanton canId;

    public SeaParroquia() {
    }

    public SeaParroquia(String prqId) {
        this.prqId = prqId;
    }

    public SeaParroquia(String prqId, String prqNombre) {
        this.prqId = prqId;
        this.prqNombre = prqNombre;
    }

    public String getPrqId() {
        return prqId;
    }

    public void setPrqId(String prqId) {
        this.prqId = prqId;
    }

    public String getPrqNombre() {
        return prqNombre;
    }

    public void setPrqNombre(String prqNombre) {
        this.prqNombre = prqNombre;
    }

    public String getPrqTipo() {
        return prqTipo;
    }

    public void setPrqTipo(String prqTipo) {
        this.prqTipo = prqTipo;
    }

    public BigInteger getPrqGrupoRecinto() {
        return prqGrupoRecinto;
    }

    public void setPrqGrupoRecinto(BigInteger prqGrupoRecinto) {
        this.prqGrupoRecinto = prqGrupoRecinto;
    }

    public SeaCanton getCanId() {
        return canId;
    }

    public void setCanId(SeaCanton canId) {
        this.canId = canId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prqId != null ? prqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaParroquia)) {
            return false;
        }
        SeaParroquia other = (SeaParroquia) object;
        if ((this.prqId == null && other.prqId != null) || (this.prqId != null && !this.prqId.equals(other.prqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaParroquia[ prqId=" + prqId + " ]";
    }

    @Override
    public int compareTo(SeaParroquia o) {
        return this.prqNombre.compareTo(o.prqNombre);
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
