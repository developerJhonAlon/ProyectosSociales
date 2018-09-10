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
@Table(name = "SEA_PROG_POSTGRADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaProgPostgrado.findAll", query = "SELECT s FROM SeaProgPostgrado s"),
    @NamedQuery(name = "SeaProgPostgrado.findByPostprogId", query = "SELECT s FROM SeaProgPostgrado s WHERE s.postprogId = :postprogId"),
    @NamedQuery(name = "SeaProgPostgrado.findByPostprogDescrip", query = "SELECT s FROM SeaProgPostgrado s WHERE s.postprogDescrip = :postprogDescrip")})
public class SeaProgPostgrado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTPROG_ID")
    private BigDecimal postprogId;
    @Size(max = 50)
    @Column(name = "POSTPROG_DESCRIP")
    private String postprogDescrip;
    @OneToMany(mappedBy = "postprogId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDepcenproy> seaDepcenproyList;

    public SeaProgPostgrado() {
    }

    public SeaProgPostgrado(BigDecimal postprogId) {
        this.postprogId = postprogId;
    }

    public BigDecimal getPostprogId() {
        return postprogId;
    }

    public void setPostprogId(BigDecimal postprogId) {
        this.postprogId = postprogId;
    }

    public String getPostprogDescrip() {
        return postprogDescrip;
    }

    public void setPostprogDescrip(String postprogDescrip) {
        this.postprogDescrip = postprogDescrip;
    }

    @XmlTransient
    public List<SeaDepcenproy> getSeaDepcenproyList() {
        return seaDepcenproyList;
    }

    public void setSeaDepcenproyList(List<SeaDepcenproy> seaDepcenproyList) {
        this.seaDepcenproyList = seaDepcenproyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postprogId != null ? postprogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaProgPostgrado)) {
            return false;
        }
        SeaProgPostgrado other = (SeaProgPostgrado) object;
        if ((this.postprogId == null && other.postprogId != null) || (this.postprogId != null && !this.postprogId.equals(other.postprogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaProgPostgrado[ postprogId=" + postprogId + " ]";
    }
    
}
