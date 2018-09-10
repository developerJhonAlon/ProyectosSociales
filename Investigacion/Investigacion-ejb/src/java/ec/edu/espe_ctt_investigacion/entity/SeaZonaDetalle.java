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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_ZONA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaZonaDetalle.findAll", query = "SELECT s FROM SeaZonaDetalle s"),
    @NamedQuery(name = "SeaZonaDetalle.findByZondetaId", query = "SELECT s FROM SeaZonaDetalle s WHERE s.zondetaId = :zondetaId")})
public class SeaZonaDetalle implements Serializable, Comparable<SeaZonaDetalle> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_ZONA_DETALLE", sequenceName = "SEQ_SEA_ZONA_DETALLE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_ZONA_DETALLE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZONDETA_ID")
    private BigDecimal zondetaId;
    @JoinColumn(name = "ZOP_ID", referencedColumnName = "ZOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaZonaPlanificacion zopId;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaProvincia proId;
    @JoinColumn(name = "COBERT_ID", referencedColumnName = "COBERT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCobertura cobertId;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCanton canId;

    public SeaZonaDetalle() {
    }


    public SeaZonaDetalle(BigDecimal zondetaId) {
        this.zondetaId = zondetaId;
    }

    public SeaZonaDetalle(SeaProvincia seaProvincia) {
        this.proId = seaProvincia;
    }
    public SeaZonaDetalle(SeaCanton seaCanton) {
        this.canId = seaCanton;
    }
    
    public BigDecimal getZondetaId() {
        return zondetaId;
    }

    public void setZondetaId(BigDecimal zondetaId) {
        this.zondetaId = zondetaId;
    }

    public SeaZonaPlanificacion getZopId() {
        return zopId;
    }

    public void setZopId(SeaZonaPlanificacion zopId) {
        this.zopId = zopId;
    }

    public SeaProvincia getProId() {
        return proId;
    }

    public void setProId(SeaProvincia proId) {
        this.proId = proId;
    }

    public SeaCobertura getCobertId() {
        return cobertId;
    }

    public void setCobertId(SeaCobertura cobertId) {
        this.cobertId = cobertId;
    }

    public SeaCanton getCanId() {
        return canId;
    }

    public void setCanId(SeaCanton canId) {
        this.canId = canId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zondetaId != null ? zondetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaZonaDetalle)) {
            return false;
        }
        SeaZonaDetalle other = (SeaZonaDetalle) object;
        if ((this.zondetaId == null && other.zondetaId != null) || (this.zondetaId != null && !this.zondetaId.equals(other.zondetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle[ zondetaId=" + zondetaId + " ]";
    }

    @Override
    public int compareTo(SeaZonaDetalle o) {
        if (zopId != null) {
            if (zopId.getZopNombreLargo()==null)
                return 1;
            if (o.zopId == null) 
                return -1;
            return zopId.getZopNombreLargo().compareTo(o.zopId.getZopNombreLargo());
        }
        if (canId != null) {
            if (canId.getCanNombre()==null)
                return 1;
            if (o.canId == null) 
                return -1;
            if (canId.getProId().getProId().equals(o.canId.getProId().getProId())) {
                return canId.getCanNombre().compareTo(o.canId.getCanNombre());
            } else {
                return canId.getCanNombre().compareTo(o.canId.getCanNombre());
            }
        }
        if (proId != null) {
            if (o.proId==null)
                return -1;
            if (proId.getProNombre()==null){
                return 1;
            }
            return proId.getProNombre().compareTo(o.proId.getProNombre());
        }
        return 0;
    }
    
    public boolean comparar(SeaZonaDetalle svinZonaDetalleBuscar)
    {
        if (svinZonaDetalleBuscar.getCanId()!=null)
        {
            if (this.getCanId()!=null 
                    && this.getCanId().getCanId().equals(svinZonaDetalleBuscar.getCanId().getCanId())
                    )
            {
                return true;
            }
        }
        return false;
    }    

    @Transient
    public String getNombre()
    {
        if (this.canId!=null)
            return this.canId.getCanNombre();
        else if (this.proId!=null)
            return this.proId.getProNombre();
        else
            return "";
    }
}
