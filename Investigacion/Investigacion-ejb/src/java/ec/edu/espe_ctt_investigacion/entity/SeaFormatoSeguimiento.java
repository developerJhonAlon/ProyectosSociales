/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_FORMATO_SEGUIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFormatoSeguimiento.findAll", query = "SELECT s FROM SeaFormatoSeguimiento s"),
    @NamedQuery(name = "SeaFormatoSeguimiento.findBySfsId", query = "SELECT s FROM SeaFormatoSeguimiento s WHERE s.sfsId = :sfsId"),
    @NamedQuery(name = "SeaFormatoSeguimiento.findBySfsMes", query = "SELECT s FROM SeaFormatoSeguimiento s WHERE s.sfsMes = :sfsMes"),
    @NamedQuery(name = "SeaFormatoSeguimiento.findBySfsDescripcionHito", query = "SELECT s FROM SeaFormatoSeguimiento s WHERE s.sfsDescripcionHito = :sfsDescripcionHito"),
    @NamedQuery(name = "SeaFormatoSeguimiento.findBySfsPresupuesto", query = "SELECT s FROM SeaFormatoSeguimiento s WHERE s.sfsPresupuesto = :sfsPresupuesto")})
public class SeaFormatoSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_SEGUIMIENTO", sequenceName = "SEQ_SEA_FORMATO_SEGUIMIENTO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_SEGUIMIENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFS_ID")
    private BigDecimal sfsId;
    @Size(max = 25)
    @Column(name = "SFS_MES")
    private String sfsMes;
    @Size(max = 500)
    @Column(name = "SFS_DESCRIPCION_HITO")
    private String sfsDescripcionHito;
    @Column(name = "SFS_PRESUPUESTO")
    private BigDecimal sfsPresupuesto;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @Column(name = "SFS_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfsFechaInicio;
    @Column(name = "SFS_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfsFechaFin;

    public SeaFormatoSeguimiento() {
    }

    public SeaFormatoSeguimiento(BigDecimal sfsId) {
        this.sfsId = sfsId;
    }

    public BigDecimal getSfsId() {
        return sfsId;
    }

    public void setSfsId(BigDecimal sfsId) {
        this.sfsId = sfsId;
    }

    public String getSfsMes() {
        return sfsMes;
    }

    public void setSfsMes(String sfsMes) {
        this.sfsMes = sfsMes;
    }

    public String getSfsDescripcionHito() {
        return sfsDescripcionHito;
    }

    public void setSfsDescripcionHito(String sfsDescripcionHito) {
        this.sfsDescripcionHito = sfsDescripcionHito;
    }

    public BigDecimal getSfsPresupuesto() {
        return sfsPresupuesto;
    }

    public void setSfsPresupuesto(BigDecimal sfsPresupuesto) {
        this.sfsPresupuesto = sfsPresupuesto;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    public Date getSfsFechaInicio() {
        return sfsFechaInicio;
    }

    public void setSfsFechaInicio(Date sfsFechaInicio) {
        this.sfsFechaInicio = sfsFechaInicio;
    }

    public Date getSfsFechaFin() {
        return sfsFechaFin;
    }

    public void setSfsFechaFin(Date sfsFechaFin) {
        this.sfsFechaFin = sfsFechaFin;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfsId != null ? sfsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoSeguimiento)) {
            return false;
        }
        SeaFormatoSeguimiento other = (SeaFormatoSeguimiento) object;
        if ((this.sfsId == null && other.sfsId != null) || (this.sfsId != null && !this.sfsId.equals(other.sfsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFormatoSeguimiento[ sfsId=" + sfsId + " ]";
    }
    
}
