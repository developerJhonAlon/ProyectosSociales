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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SEA_TIPO_RESPONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTipoRespons.findAll", query = "SELECT s FROM SeaTipoRespons s"),
    @NamedQuery(name = "SeaTipoRespons.findByTipresId", query = "SELECT s FROM SeaTipoRespons s WHERE s.tipresId = :tipresId"),
    @NamedQuery(name = "SeaTipoRespons.findByTipresDescrip", query = "SELECT s FROM SeaTipoRespons s WHERE s.tipresDescrip = :tipresDescrip")})
public class SeaTipoRespons implements Serializable {
    @OneToMany(mappedBy = "tipresId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaComisionXConvoca> seaComisionXConvocaList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPRES_ID")
    private BigDecimal tipresId;
    @Size(max = 250)
    @Column(name = "TIPRES_DESCRIP")
    private String tipresDescrip;
    @JoinColumn(name = "TIFORMA_ID", referencedColumnName = "TIFORMA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaTipoFormato tiformaId;
    @OneToMany(mappedBy = "tipresId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaResponsableProg> seaResponsableProgList;
    @Column(name = "TIPRES_ORDEN")
    private BigInteger tipresOrden;

    public final static Integer TIPO_DIRECTOR=3;
    public final static Integer TIPO_PRESIDENTE_COMISION=15;
        
        
    public SeaTipoRespons() {
    }

    public SeaTipoRespons(BigDecimal tipresId) {
        this.tipresId = tipresId;
    }

    public BigDecimal getTipresId() {
        return tipresId;
    }

    public void setTipresId(BigDecimal tipresId) {
        this.tipresId = tipresId;
    }

    public String getTipresDescrip() {
        return tipresDescrip;
    }

    public void setTipresDescrip(String tipresDescrip) {
        this.tipresDescrip = tipresDescrip;
    }

    public SeaTipoFormato getTiformaId() {
        return tiformaId;
    }

    public void setTiformaId(SeaTipoFormato tiformaId) {
        this.tiformaId = tiformaId;
    }

    public BigInteger getTipresOrden() {
        return tipresOrden;
    }

    public void setTipresOrden(BigInteger tipresOrden) {
        this.tipresOrden = tipresOrden;
    }
    
    @XmlTransient
    public List<SeaResponsableProg> getSeaResponsableProgList() {
        return seaResponsableProgList;
    }

    public void setSeaResponsableProgList(List<SeaResponsableProg> seaResponsableProgList) {
        this.seaResponsableProgList = seaResponsableProgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipresId != null ? tipresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaTipoRespons)) {
            return false;
        }
        SeaTipoRespons other = (SeaTipoRespons) object;
        if ((this.tipresId == null && other.tipresId != null) || (this.tipresId != null && !this.tipresId.equals(other.tipresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons[ tipresId=" + tipresId + " ]";
    }

    @XmlTransient
    public List<SeaComisionXConvoca> getSeaComisionXConvocaList() {
        return seaComisionXConvocaList;
    }

    public void setSeaComisionXConvocaList(List<SeaComisionXConvoca> seaComisionXConvocaList) {
        this.seaComisionXConvocaList = seaComisionXConvocaList;
    }
    
}
