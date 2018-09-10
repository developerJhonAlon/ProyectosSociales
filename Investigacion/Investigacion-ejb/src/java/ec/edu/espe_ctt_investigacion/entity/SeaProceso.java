/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
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
 * @author PC1
 */
@Entity
@Table(name = "SEA_PROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaProceso.findAll", query = "SELECT s FROM SeaProceso s"),
    @NamedQuery(name = "SeaProceso.findByProId", query = "SELECT s FROM SeaProceso s WHERE s.proId = :proId"),
    @NamedQuery(name = "SeaProceso.findByProDescrip", query = "SELECT s FROM SeaProceso s WHERE s.proDescrip = :proDescrip")})
public class SeaProceso implements Serializable {
    private static final long serialVersionUID = 1L;
     @SequenceGenerator(name = "SEQ_SEA_PROCESO", sequenceName = "SEQ_SEA_PROCESO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PROCESO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Size(max = 1000)
    @Column(name = "PRO_DESCRIP")
    private String proDescrip;
    
    @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegSistemas segSistemas;
   
    @OneToMany(mappedBy = "seaProceso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaProcesoXConvocatoria> seaProcesoXConvocatoriaList;

    public SeaProceso() {
    }

    public SeaProceso(BigDecimal proId) {
        this.proId = proId;
    }

    public BigDecimal getProId() {
        return proId;
    }

    public void setProId(BigDecimal proId) {
        this.proId = proId;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public SegSistemas getSegSistemas() {
        return segSistemas;
    }

    public void setSegSistemas(SegSistemas segSistemas) {
        this.segSistemas = segSistemas;
    }
    

    @XmlTransient
    public List<SeaProcesoXConvocatoria> getSeaProcesoXConvocatoriaList() {
        return seaProcesoXConvocatoriaList;
    }

    public void setSeaProcesoXConvocatoriaList(List<SeaProcesoXConvocatoria> seaProcesoXConvocatoriaList) {
        this.seaProcesoXConvocatoriaList = seaProcesoXConvocatoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaProceso)) {
            return false;
        }
        SeaProceso other = (SeaProceso) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaProceso[ proId=" + proId + " ]";
    }
    
}
