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
@Table(name = "SEA_LOCALIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaLocaliza.findAll", query = "SELECT s FROM SeaLocaliza s"),
    @NamedQuery(name = "SeaLocaliza.findByLocalId", query = "SELECT s FROM SeaLocaliza s WHERE s.localId = :localId"),
    @NamedQuery(name = "SeaLocaliza.findByLocalDescrip", query = "SELECT s FROM SeaLocaliza s WHERE s.localDescrip = :localDescrip")})
public class SeaLocaliza implements Serializable {
    @Column(name = "LOCAL_ORDEN")
    private BigInteger localOrden;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCAL_ID")
    private BigDecimal localId;
    public final static BigDecimal TIPO_LOCAL = new BigDecimal(1);
    public final static BigDecimal TIPO_PROVINCIAL = new BigDecimal(2);
    public final static BigDecimal TIPO_NACIONAL = new BigDecimal(3);
    public final static BigDecimal TIPO_ZONA_PLANIFICACION = new BigDecimal(4);
    
    @Size(max = 50)
    @Column(name = "LOCAL_DESCRIP")
    private String localDescrip;
    @OneToMany(mappedBy = "localId" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaCobertura> seaCoberturaList;

    public SeaLocaliza() {
    }

    public SeaLocaliza(BigDecimal localId) {
        this.localId = localId;
    }

    public BigDecimal getLocalId() {
        return localId;
    }

    public void setLocalId(BigDecimal localId) {
        this.localId = localId;
    }

    public String getLocalDescrip() {
        return localDescrip;
    }

    public void setLocalDescrip(String localDescrip) {
        this.localDescrip = localDescrip;
    }

    @XmlTransient
    public List<SeaCobertura> getSeaCoberturaList() {
        return seaCoberturaList;
    }

    public void setSeaCoberturaList(List<SeaCobertura> seaCoberturaList) {
        this.seaCoberturaList = seaCoberturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localId != null ? localId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaLocaliza)) {
            return false;
        }
        SeaLocaliza other = (SeaLocaliza) object;
        if ((this.localId == null && other.localId != null) || (this.localId != null && !this.localId.equals(other.localId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaLocaliza[ localId=" + localId + " ]";
    }

    public BigInteger getLocalOrden() {
        return localOrden;
    }

    public void setLocalOrden(BigInteger localOrden) {
        this.localOrden = localOrden;
    }
    
}
