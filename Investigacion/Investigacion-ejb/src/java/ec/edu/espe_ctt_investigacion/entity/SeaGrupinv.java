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
@Table(name = "SEA_GRUPINV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaGrupinv.findAll", query = "SELECT s FROM SeaGrupinv s"),
    @NamedQuery(name = "SeaGrupinv.findByGrupiId", query = "SELECT s FROM SeaGrupinv s WHERE s.grupiId = :grupiId"),
    @NamedQuery(name = "SeaGrupinv.findByGrupiDescrip", query = "SELECT s FROM SeaGrupinv s WHERE s.grupiDescrip = :grupiDescrip")})
public class SeaGrupinv implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(generator="SEQ_SEA_FINANCIA_CONVOCA")
    @SequenceGenerator(name="SEQ_SEA_FINANCIA_CONVOCA",sequenceName="SEQ_SEA_FINANCIA_CONVOCA", allocationSize=1) 
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUPI_ID")
    private BigDecimal grupiId;
    @Size(max = 150)
    @Column(name = "GRUPI_DESCRIP")
    private String grupiDescrip;
    @OneToMany(mappedBy = "grupiId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDepcenproy> seaDepcenproyList;

    public SeaGrupinv() {
    }

    public SeaGrupinv(BigDecimal grupiId) {
        this.grupiId = grupiId;
    }

    public BigDecimal getGrupiId() {
        return grupiId;
    }

    public void setGrupiId(BigDecimal grupiId) {
        this.grupiId = grupiId;
    }

    public String getGrupiDescrip() {
        return grupiDescrip;
    }

    public void setGrupiDescrip(String grupiDescrip) {
        this.grupiDescrip = grupiDescrip;
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
        hash += (grupiId != null ? grupiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaGrupinv)) {
            return false;
        }
        SeaGrupinv other = (SeaGrupinv) object;
        if ((this.grupiId == null && other.grupiId != null) || (this.grupiId != null && !this.grupiId.equals(other.grupiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaGrupinv[ grupiId=" + grupiId + " ]";
    }
    
}
