/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_ESTRATEGIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaEstrategia.findAll", query = "SELECT s FROM SeaEstrategia s"),
    @NamedQuery(name = "SeaEstrategia.findByEstrategId", query = "SELECT s FROM SeaEstrategia s WHERE s.estrategId = :estrategId"),
    @NamedQuery(name = "SeaEstrategia.findByEstrategDescrip", query = "SELECT s FROM SeaEstrategia s WHERE s.estrategDescrip = :estrategDescrip")})

public class SeaEstrategia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_ESTRATEGIA", sequenceName = "SEQ_SEA_ESTRATEGIA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_ESTRATEGIA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTRATEG_ID")
    private BigDecimal estrategId;
    @Size(max = 200)
    @Column(name = "ESTRATEG_DESCRIP")
    private String estrategDescrip;
    @OneToMany(mappedBy = "estrategIdPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaEstrategia> seaEstrategiaList;
    @JoinColumn(name = "ESTRATEG_ID_PADRE", referencedColumnName = "ESTRATEG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaEstrategia estrategIdPadre;

    public SeaEstrategia() {
    }

    public SeaEstrategia(BigDecimal estrategId) {
        this.estrategId = estrategId;
    }

    public BigDecimal getEstrategId() {
        return estrategId;
    }

    public void setEstrategId(BigDecimal estrategId) {
        this.estrategId = estrategId;
    }

    public String getEstrategDescrip() {
        return estrategDescrip;
    }

    public void setEstrategDescrip(String estrategDescrip) {
        this.estrategDescrip = estrategDescrip;
    }

    @XmlTransient
    public List<SeaEstrategia> getSeaEstrategiaList() {
        return seaEstrategiaList;
    }

    public void setSeaEstrategiaList(List<SeaEstrategia> seaEstrategiaList) {
        this.seaEstrategiaList = seaEstrategiaList;
    }

    public SeaEstrategia getEstrategIdPadre() {
        return estrategIdPadre;
    }

    public void setEstrategIdPadre(SeaEstrategia estrategIdPadre) {
        this.estrategIdPadre = estrategIdPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estrategId != null ? estrategId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaEstrategia)) {
            return false;
        }
        SeaEstrategia other = (SeaEstrategia) object;
        if ((this.estrategId == null && other.estrategId != null) || (this.estrategId != null && !this.estrategId.equals(other.estrategId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaEstrategia[ estrategId=" + estrategId + " ]";
    }
    
}
