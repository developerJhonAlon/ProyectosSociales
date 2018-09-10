/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_COBERTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaCobertura.findAll", query = "SELECT s FROM SeaCobertura s"),
    @NamedQuery(name = "SeaCobertura.findByCobertId", query = "SELECT s FROM SeaCobertura s WHERE s.cobertId = :cobertId")})
public class SeaCobertura implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_COBERTURA", sequenceName = "SEQ_SEA_COBERTURA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_COBERTURA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "COBERT_ID")
    private BigDecimal cobertId;
    @JoinColumn(name = "PRQ_ID", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParroquia prqId;
    @JoinColumn(name = "LOCAL_ID", referencedColumnName = "LOCAL_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeaLocaliza localId;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;
    @OneToMany(mappedBy = "cobertId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaZonaDetalle> zonaDetalleList;    
    

    public SeaCobertura() {
        localId = new SeaLocaliza(SeaLocaliza.TIPO_NACIONAL);
    }
    public SeaCobertura(SeaDatGeneralProy seaDatGeneralProy) {
        this();
        this.datgeproyId= seaDatGeneralProy;
    }

    public SeaCobertura(BigDecimal cobertId) {
        this();
        this.cobertId = cobertId;
    }

    public BigDecimal getCobertId() {
        return cobertId;
    }

    public void setCobertId(BigDecimal cobertId) {
        this.cobertId = cobertId;
    }

    public SeaParroquia getPrqId() {
        return prqId;
    }

    public void setPrqId(SeaParroquia prqId) {
        this.prqId = prqId;
    }

    public SeaLocaliza getLocalId() {
        return localId;
    }

    public void setLocalId(SeaLocaliza localId) {
        this.localId = localId;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public SeaDatGeneralProg getDatgeprogId() {
        return datgeprogId;
    }

    public void setDatgeprogId(SeaDatGeneralProg datgeprogId) {
        this.datgeprogId = datgeprogId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobertId != null ? cobertId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaCobertura)) {
            return false;
        }
        SeaCobertura other = (SeaCobertura) object;
        if ((this.cobertId == null && other.cobertId != null) || (this.cobertId != null && !this.cobertId.equals(other.cobertId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaCobertura[ cobertId=" + cobertId + " ]";
    }


    @XmlTransient
    public List<SeaZonaDetalle> getZonaDetalleList() {
        if (zonaDetalleList!=null){
            Collections.sort(zonaDetalleList);
        }
        return zonaDetalleList;
    }

    public void setZonaDetalleList(List<SeaZonaDetalle> zonaDetalleList) {
        this.zonaDetalleList = zonaDetalleList;
    }
    
    public void addZonaDelatalle(SeaZonaDetalle seaZonaDetalle){
        if (zonaDetalleList==null){
            zonaDetalleList = new ArrayList<>();
        }
        
        boolean encontro= false;
        for (SeaZonaDetalle seaZonaDetalle1 : zonaDetalleList) {
            if ((localId.getLocalId().equals(SeaLocaliza.TIPO_PROVINCIAL) && seaZonaDetalle.getProId().getProId().equals(seaZonaDetalle1.getProId().getProId()))
                || (localId.getLocalId().equals(SeaLocaliza.TIPO_ZONA_PLANIFICACION) && seaZonaDetalle.getZopId().getZopId().equals(seaZonaDetalle1.getZopId().getZopId()))
                || (localId.getLocalId().equals(SeaLocaliza.TIPO_LOCAL) && seaZonaDetalle.getCanId().getCanId().equals(seaZonaDetalle1.getCanId().getCanId()))                    
                    ){
                encontro=true;
                break;
            }
        }
        if (!encontro){
            seaZonaDetalle.setCobertId(this);
            zonaDetalleList.add(seaZonaDetalle);
        }
        
    }
    public void removeAllZonaDetalle(){
        if (zonaDetalleList!=null){
            zonaDetalleList.clear();
        }
    }
    public void removeZonaDetalle(SeaZonaDetalle seaZonaDetalle){
        if (zonaDetalleList!=null){
            zonaDetalleList.remove(seaZonaDetalle);
        }
    }
}
