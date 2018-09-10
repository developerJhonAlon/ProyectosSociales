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
import javax.persistence.GenerationType;
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
@Table(name = "SEA_OBPLANBV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObplanbv.findAll", query = "SELECT s FROM SeaObplanbv s"),
    @NamedQuery(name = "SeaObplanbv.findByObplabvId", query = "SELECT s FROM SeaObplanbv s WHERE s.obplabvId = :obplabvId"),
    @NamedQuery(name = "SeaObplanbv.findByObplabvNombre", query = "SELECT s FROM SeaObplanbv s WHERE s.obplabvNombre = :obplabvNombre"),
    @NamedQuery(name = "SeaObplanbv.findByObplanbvDecrip", query = "SELECT s FROM SeaObplanbv s WHERE s.obplanbvDecrip = :obplanbvDecrip")})
public class SeaObplanbv implements Serializable {
//    @OneToMany(mappedBy = "obplabvId")
//    private List<SeaFormatoLargo> seaFormatoLargoList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBPLANBV", sequenceName = "SEQ_SEA_OBPLANBV", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBPLANBV")
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBPLABV_ID")
    private BigDecimal obplabvId;
    @Size(max = 50)
    @Column(name = "OBPLABV_NOMBRE")
    private String obplabvNombre;
    @Size(max = 150)
    @Column(name = "OBPLANBV_DECRIP")
    private String obplanbvDecrip;
    @OneToMany(mappedBy = "obplabvId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProg> seaDatGeneralProgList;

    public SeaObplanbv() {
    }

    public SeaObplanbv(BigDecimal obplabvId) {
        this.obplabvId = obplabvId;
    }

    public BigDecimal getObplabvId() {
        return obplabvId;
    }

    public void setObplabvId(BigDecimal obplabvId) {
        this.obplabvId = obplabvId;
    }

    public String getObplabvNombre() {
        return obplabvNombre;
    }

    public void setObplabvNombre(String obplabvNombre) {
        this.obplabvNombre = obplabvNombre;
    }

    public String getObplanbvDecrip() {
        return obplanbvDecrip;
    }

    public void setObplanbvDecrip(String obplanbvDecrip) {
        this.obplanbvDecrip = obplanbvDecrip;
    }

    @XmlTransient
    public List<SeaDatGeneralProg> getSeaDatGeneralProgList() {
        return seaDatGeneralProgList;
    }

    public void setSeaDatGeneralProgList(List<SeaDatGeneralProg> seaDatGeneralProgList) {
        this.seaDatGeneralProgList = seaDatGeneralProgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obplabvId != null ? obplabvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObplanbv)) {
            return false;
        }
        SeaObplanbv other = (SeaObplanbv) object;
        if ((this.obplabvId == null && other.obplabvId != null) || (this.obplabvId != null && !this.obplabvId.equals(other.obplabvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaObplanbv[ obplabvId=" + obplabvId + " ]";
    }

//    @XmlTransient
//    public List<SeaFormatoLargo> getSeaFormatoLargoList() {
//        return seaFormatoLargoList;
//    }
//
//    public void setSeaFormatoLargoList(List<SeaFormatoLargo> seaFormatoLargoList) {
//        this.seaFormatoLargoList = seaFormatoLargoList;
//    }
    
}
