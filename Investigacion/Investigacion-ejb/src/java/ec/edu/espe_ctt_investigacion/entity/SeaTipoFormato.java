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
@Table(name = "SEA_TIPO_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTipoFormato.findAll", query = "SELECT s FROM SeaTipoFormato s"),
    @NamedQuery(name = "SeaTipoFormato.findByTiformaId", query = "SELECT s FROM SeaTipoFormato s WHERE s.tiformaId = :tiformaId"),
    @NamedQuery(name = "SeaTipoFormato.findByTiformaDescrip", query = "SELECT s FROM SeaTipoFormato s WHERE s.tiformaDescrip = :tiformaDescrip")})
public class SeaTipoFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIFORMA_ID")
    private BigDecimal tiformaId;
    @Size(max = 50)
    @Column(name = "TIFORMA_DESCRIP")
    private String tiformaDescrip;
    @OneToMany(mappedBy = "tiformaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTipoRespons> seaTipoResponsList;

    public SeaTipoFormato() {
    }

    public SeaTipoFormato(BigDecimal tiformaId) {
        this.tiformaId = tiformaId;
    }

    public BigDecimal getTiformaId() {
        return tiformaId;
    }

    public void setTiformaId(BigDecimal tiformaId) {
        this.tiformaId = tiformaId;
    }

    public String getTiformaDescrip() {
        return tiformaDescrip;
    }

    public void setTiformaDescrip(String tiformaDescrip) {
        this.tiformaDescrip = tiformaDescrip;
    }

    @XmlTransient
    public List<SeaTipoRespons> getSeaTipoResponsList() {
        return seaTipoResponsList;
    }

    public void setSeaTipoResponsList(List<SeaTipoRespons> seaTipoResponsList) {
        this.seaTipoResponsList = seaTipoResponsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiformaId != null ? tiformaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaTipoFormato)) {
            return false;
        }
        SeaTipoFormato other = (SeaTipoFormato) object;
        if ((this.tiformaId == null && other.tiformaId != null) || (this.tiformaId != null && !this.tiformaId.equals(other.tiformaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaTipoFormato[ tiformaId=" + tiformaId + " ]";
    }
    
}
