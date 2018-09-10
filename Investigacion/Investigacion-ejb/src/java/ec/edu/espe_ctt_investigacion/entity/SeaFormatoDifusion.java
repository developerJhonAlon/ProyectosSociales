/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_FORMATO_DIFUSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFormatoDifusion.findAll", query = "SELECT s FROM SeaFormatoDifusion s"),
    @NamedQuery(name = "SeaFormatoDifusion.findBySfdId", query = "SELECT s FROM SeaFormatoDifusion s WHERE s.sfdId = :sfdId"),
    @NamedQuery(name = "SeaFormatoDifusion.findBySfdActividad", query = "SELECT s FROM SeaFormatoDifusion s WHERE s.sfdActividad = :sfdActividad"),
    @NamedQuery(name = "SeaFormatoDifusion.findBySfdCosto", query = "SELECT s FROM SeaFormatoDifusion s WHERE s.sfdCosto = :sfdCosto")})
public class SeaFormatoDifusion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_DIFUSION", sequenceName = "SEQ_SEA_FORMATO_DIFUSION", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_DIFUSION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFD_ID")
    private BigDecimal sfdId;
    @Size(max = 500)
    @Column(name = "SFD_ACTIVIDAD")
    private String sfdActividad;
    @Column(name = "SFD_COSTO")
    private BigDecimal sfdCosto;
    @JoinColumn(name = "SFDE_ID", referencedColumnName = "SFDE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFdifusionEvento sfdeId;

    public SeaFormatoDifusion() {
    }

    public SeaFormatoDifusion(BigDecimal sfdId) {
        this.sfdId = sfdId;
    }

    public BigDecimal getSfdId() {
        return sfdId;
    }

    public void setSfdId(BigDecimal sfdId) {
        this.sfdId = sfdId;
    }

    public String getSfdActividad() {
        return sfdActividad;
    }

    public void setSfdActividad(String sfdActividad) {
        this.sfdActividad = sfdActividad;
    }

    public BigDecimal getSfdCosto() {
        return sfdCosto;
    }

    public void setSfdCosto(BigDecimal sfdCosto) {
        this.sfdCosto = sfdCosto;
    }

    public SeaFdifusionEvento getSfdeId() {
        return sfdeId;
    }

    public void setSfdeId(SeaFdifusionEvento sfdeId) {
        this.sfdeId = sfdeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfdId != null ? sfdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoDifusion)) {
            return false;
        }
        SeaFormatoDifusion other = (SeaFormatoDifusion) object;
        if ((this.sfdId == null && other.sfdId != null) || (this.sfdId != null && !this.sfdId.equals(other.sfdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFormatoDifusion[ sfdId=" + sfdId + " ]";
    }
    
}
