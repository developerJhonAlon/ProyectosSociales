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
@Table(name = "SEA_FDIFUSION_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFdifusionEvento.findAll", query = "SELECT s FROM SeaFdifusionEvento s"),
    @NamedQuery(name = "SeaFdifusionEvento.findBySfdeId", query = "SELECT s FROM SeaFdifusionEvento s WHERE s.sfdeId = :sfdeId"),
    @NamedQuery(name = "SeaFdifusionEvento.findBySfdeDescripcion", query = "SELECT s FROM SeaFdifusionEvento s WHERE s.sfdeDescripcion = :sfdeDescripcion")})
public class SeaFdifusionEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FDIFUSION_EVENTO", sequenceName = "SEQ_SEA_FDIFUSION_EVENTO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FDIFUSION_EVENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFDE_ID")
    private BigDecimal sfdeId;
    @Size(max = 500)
    @Column(name = "SFDE_DESCRIPCION")
    private String sfdeDescripcion;
    @OneToMany(mappedBy = "sfdeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaFormatoDifusion> seaFormatoDifusionList;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public SeaFdifusionEvento() {
    }

    public SeaFdifusionEvento(BigDecimal sfdeId) {
        this.sfdeId = sfdeId;
    }

    public BigDecimal getSfdeId() {
        return sfdeId;
    }

    public void setSfdeId(BigDecimal sfdeId) {
        this.sfdeId = sfdeId;
    }

    public String getSfdeDescripcion() {
        return sfdeDescripcion;
    }

    public void setSfdeDescripcion(String sfdeDescripcion) {
        this.sfdeDescripcion = sfdeDescripcion;
    }

    @XmlTransient
    public List<SeaFormatoDifusion> getSeaFormatoDifusionList() {
        return seaFormatoDifusionList;
    }

    public void setSeaFormatoDifusionList(List<SeaFormatoDifusion> seaFormatoDifusionList) {
        this.seaFormatoDifusionList = seaFormatoDifusionList;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfdeId != null ? sfdeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFdifusionEvento)) {
            return false;
        }
        SeaFdifusionEvento other = (SeaFdifusionEvento) object;
        if ((this.sfdeId == null && other.sfdeId != null) || (this.sfdeId != null && !this.sfdeId.equals(other.sfdeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFdifusionEvento[ sfdeId=" + sfdeId + " ]";
    }
    
}
