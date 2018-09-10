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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_AREAC_UNESCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaAreacUnesco.findAll", query = "SELECT s FROM SeaAreacUnesco s"),
    @NamedQuery(name = "SeaAreacUnesco.findBySacuId", query = "SELECT s FROM SeaAreacUnesco s WHERE s.sacuId = :sacuId"),
    @NamedQuery(name = "SeaAreacUnesco.findBySacuDecsripcion", query = "SELECT s FROM SeaAreacUnesco s WHERE s.sacuDecsripcion = :sacuDecsripcion")})
public class SeaAreacUnesco implements Serializable {
    @OneToMany(mappedBy = "sacuId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaFormatoLargo> seaFormatoLargoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SACU_ID")
    private BigDecimal sacuId;
    @Size(max = 50)
    @Column(name = "SACU_DECSRIPCION")
    private String sacuDecsripcion;

    public SeaAreacUnesco() {
    }

    public SeaAreacUnesco(BigDecimal sacuId) {
        this.sacuId = sacuId;
    }

    public BigDecimal getSacuId() {
        return sacuId;
    }

    public void setSacuId(BigDecimal sacuId) {
        this.sacuId = sacuId;
    }

    public String getSacuDecsripcion() {
        return sacuDecsripcion;
    }

    public void setSacuDecsripcion(String sacuDecsripcion) {
        this.sacuDecsripcion = sacuDecsripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sacuId != null ? sacuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaAreacUnesco)) {
            return false;
        }
        SeaAreacUnesco other = (SeaAreacUnesco) object;
        if ((this.sacuId == null && other.sacuId != null) || (this.sacuId != null && !this.sacuId.equals(other.sacuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaAreacUnesco[ sacuId=" + sacuId + " ]";
    }

    @XmlTransient
    public List<SeaFormatoLargo> getSeaFormatoLargoList() {
        return seaFormatoLargoList;
    }

    public void setSeaFormatoLargoList(List<SeaFormatoLargo> seaFormatoLargoList) {
        this.seaFormatoLargoList = seaFormatoLargoList;
    }
    
}
