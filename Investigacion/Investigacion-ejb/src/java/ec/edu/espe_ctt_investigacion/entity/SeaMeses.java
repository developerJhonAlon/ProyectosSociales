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
@Table(name = "SEA_MESES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaMeses.findAll", query = "SELECT s FROM SeaMeses s"),
    @NamedQuery(name = "SeaMeses.findBySemeId", query = "SELECT s FROM SeaMeses s WHERE s.semeId = :semeId"),
    @NamedQuery(name = "SeaMeses.findBySemeDetalle", query = "SELECT s FROM SeaMeses s WHERE s.semeDetalle = :semeDetalle")})
public class SeaMeses implements Serializable {
    @OneToMany(mappedBy = "semeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupAnual> seaTotalPresupAnualList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEME_ID")
    private BigDecimal semeId;
    @Size(max = 25)
    @Column(name = "SEME_DETALLE")
    private String semeDetalle;
    @OneToMany(mappedBy = "semeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaProgramaAnual> seaProgramaAnualList;

    public SeaMeses() {
    }

    public SeaMeses(BigDecimal semeId) {
        this.semeId = semeId;
    }

    public BigDecimal getSemeId() {
        return semeId;
    }

    public void setSemeId(BigDecimal semeId) {
        this.semeId = semeId;
    }

    public String getSemeDetalle() {
        return semeDetalle;
    }

    public void setSemeDetalle(String semeDetalle) {
        this.semeDetalle = semeDetalle;
    }

    @XmlTransient
    public List<SeaProgramaAnual> getSeaProgramaAnualList() {
        return seaProgramaAnualList;
    }

    public void setSeaProgramaAnualList(List<SeaProgramaAnual> seaProgramaAnualList) {
        this.seaProgramaAnualList = seaProgramaAnualList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semeId != null ? semeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaMeses)) {
            return false;
        }
        SeaMeses other = (SeaMeses) object;
        if ((this.semeId == null && other.semeId != null) || (this.semeId != null && !this.semeId.equals(other.semeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaMeses[ semeId=" + semeId + " ]";
    }

    @XmlTransient
    public List<SeaTotalPresupAnual> getSeaTotalPresupAnualList() {
        return seaTotalPresupAnualList;
    }

    public void setSeaTotalPresupAnualList(List<SeaTotalPresupAnual> seaTotalPresupAnualList) {
        this.seaTotalPresupAnualList = seaTotalPresupAnualList;
    }
    
}
