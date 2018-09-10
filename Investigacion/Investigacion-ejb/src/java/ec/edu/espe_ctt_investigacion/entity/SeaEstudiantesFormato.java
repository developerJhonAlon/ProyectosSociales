/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
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
@Table(name = "SEA_ESTUDIANTES_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaEstudiantesFormato.findAll", query = "SELECT s FROM SeaEstudiantesFormato s"),
    @NamedQuery(name = "SeaEstudiantesFormato.findBySesfId", query = "SELECT s FROM SeaEstudiantesFormato s WHERE s.sesfId = :sesfId"),
    @NamedQuery(name = "SeaEstudiantesFormato.findBySesfPrograma", query = "SELECT s FROM SeaEstudiantesFormato s WHERE s.sesfPrograma = :sesfPrograma"),
    @NamedQuery(name = "SeaEstudiantesFormato.findBySesfFechaInicio", query = "SELECT s FROM SeaEstudiantesFormato s WHERE s.sesfFechaInicio = :sesfFechaInicio"),
    @NamedQuery(name = "SeaEstudiantesFormato.findBySesfFechaFin", query = "SELECT s FROM SeaEstudiantesFormato s WHERE s.sesfFechaFin = :sesfFechaFin"),
    @NamedQuery(name = "SeaEstudiantesFormato.findBySesfGeneroTesis", query = "SELECT s FROM SeaEstudiantesFormato s WHERE s.sesfGeneroTesis = :sesfGeneroTesis")})
public class SeaEstudiantesFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_ESTUDIANTES_FORMATO", sequenceName = "SEQ_SEA_ESTUDIANTES_FORMATO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_ESTUDIANTES_FORMATO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SESF_ID")
    private BigDecimal sesfId;
    @Size(max = 50)
    @Column(name = "SESF_PROGRAMA")
    private String sesfPrograma;
    @Column(name = "SESF_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sesfFechaInicio;
    @Column(name = "SESF_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sesfFechaFin;
    @Size(max = 1)
    @Column(name = "SESF_GENERO_TESIS")
    private String sesfGeneroTesis;
    @JoinColumn(name = "SSEF_ID", referencedColumnName = "SSEF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaSeguimientoFormato ssefId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuId;
    @Size(max = 500)
    @Column(name = "SESF_TESIS")
    private String sesfTesis;
    
    public SeaEstudiantesFormato() {
    }

    public SeaEstudiantesFormato(BigDecimal sesfId) {
        this.sesfId = sesfId;
    }

    public BigDecimal getSesfId() {
        return sesfId;
    }

    public void setSesfId(BigDecimal sesfId) {
        this.sesfId = sesfId;
    }

    public String getSesfPrograma() {
        return sesfPrograma;
    }

    public void setSesfPrograma(String sesfPrograma) {
        this.sesfPrograma = sesfPrograma;
    }

    public Date getSesfFechaInicio() {
        return sesfFechaInicio;
    }

    public void setSesfFechaInicio(Date sesfFechaInicio) {
        this.sesfFechaInicio = sesfFechaInicio;
    }

    public Date getSesfFechaFin() {
        return sesfFechaFin;
    }

    public void setSesfFechaFin(Date sesfFechaFin) {
        this.sesfFechaFin = sesfFechaFin;
    }

    public String getSesfGeneroTesis() {
        return sesfGeneroTesis;
    }

    public void setSesfGeneroTesis(String sesfGeneroTesis) {
        this.sesfGeneroTesis = sesfGeneroTesis;
    }

    public SeaSeguimientoFormato getSsefId() {
        return ssefId;
    }

    public void setSsefId(SeaSeguimientoFormato ssefId) {
        this.ssefId = ssefId;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }

    public String getSesfTesis() {
        return sesfTesis;
    }

    public void setSesfTesis(String sesfTesis) {
        this.sesfTesis = sesfTesis;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesfId != null ? sesfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaEstudiantesFormato)) {
            return false;
        }
        SeaEstudiantesFormato other = (SeaEstudiantesFormato) object;
        if ((this.sesfId == null && other.sesfId != null) || (this.sesfId != null && !this.sesfId.equals(other.sesfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaEstudiantesFormato[ sesfId=" + sesfId + " ]";
    }
    
}
