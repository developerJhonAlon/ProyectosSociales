/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEG_USU_PERFIL",schema = "SISEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuPerfil.findAll", query = "SELECT s FROM SegUsuPerfil s"),
    @NamedQuery(name = "SegUsuPerfil.findByUspId", query = "SELECT s FROM SegUsuPerfil s WHERE s.uspId = :uspId"),
    @NamedQuery(name = "SegUsuPerfil.findByUspFechaIni", query = "SELECT s FROM SegUsuPerfil s WHERE s.uspFechaIni = :uspFechaIni"),
    @NamedQuery(name = "SegUsuPerfil.findByUspFechaFin", query = "SELECT s FROM SegUsuPerfil s WHERE s.uspFechaFin = :uspFechaFin")})
public class SegUsuPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEG_USU_PERFIL", sequenceName = "SEQ_SEG_USU_PERFIL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_USU_PERFIL")
    @Basic(optional = false)
    @NotNull
    @Column(name = "USP_ID")
    private BigDecimal uspId;
    @Column(name = "USP_FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uspFechaIni;
    @Column(name = "USP_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uspFechaFin;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne
     private SegUsuario segUsuario;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne
    private SegPerfil segPerfil;

    public SegUsuPerfil() {
    }

    public SegUsuPerfil(BigDecimal uspId) {
        this.uspId = uspId;
    }

    public BigDecimal getUspId() {
        return uspId;
    }

    public void setUspId(BigDecimal uspId) {
        this.uspId = uspId;
    }

    public Date getUspFechaIni() {
        return uspFechaIni;
    }

    public void setUspFechaIni(Date uspFechaIni) {
        this.uspFechaIni = uspFechaIni;
    }

    public Date getUspFechaFin() {
        return uspFechaFin;
    }

    public void setUspFechaFin(Date uspFechaFin) {
        this.uspFechaFin = uspFechaFin;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uspId != null ? uspId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuPerfil)) {
            return false;
        }
        SegUsuPerfil other = (SegUsuPerfil) object;
        if ((this.uspId == null && other.uspId != null) || (this.uspId != null && !this.uspId.equals(other.uspId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil[ uspId=" + uspId + " ]";
    }
    
}
