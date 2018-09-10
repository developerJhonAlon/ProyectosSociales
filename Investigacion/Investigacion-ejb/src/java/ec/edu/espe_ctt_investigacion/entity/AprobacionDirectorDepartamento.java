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
import javax.persistence.Lob;
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
@Table(name = "SEA_APRUEBA_NC")
@XmlRootElement
public class AprobacionDirectorDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_APRUEBA_NC", sequenceName = "SEQ_SEA_APRUEBA_NC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_APRUEBA_NC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAPNC_ID")
    private BigDecimal id;
    @Column(name = "SAPNC_FECHA_APRUEBA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 1)
    @Column(name = "SAPNC_ESTADO")
    private String estado;
    public final static String ESTADO_APROBADO="A";
    public final static String ESTADO_NEGADO="N";

    @Size(max = 500)
    @Column(name = "SAPNC_OBSERVACION")
    private String observacion;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy notaConceptual;
    @JoinColumn(name = "USU_ID_APRUEBA", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;
    @Size(max = 50)
    @Column(name = "SAPNC_ARCHIVO_NOMBRE")
    private String archivoNombre;
    @Lob
    @Column(name = "SAPNC_ARCHIVO_DIGITAL")
    private byte[] archivoDigital;
    

    public AprobacionDirectorDepartamento() {
        fecha = new Date();
    }

    public AprobacionDirectorDepartamento(BigDecimal sapncId) {
        this.id = sapncId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public SeaDatGeneralProy getNotaConceptual() {
        return notaConceptual;
    }

    public void setNotaConceptual(SeaDatGeneralProy notaConceptual) {
        this.notaConceptual = notaConceptual;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    public byte[] getArchivoDigital() {
        return archivoDigital;
    }

    public void setArchivoDigital(byte[] archivoDigital) {
        this.archivoDigital = archivoDigital;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AprobacionDirectorDepartamento)) {
            return false;
        }
        AprobacionDirectorDepartamento other = (AprobacionDirectorDepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.AprobacionDirectorDepartamento[ id=" + id + " ]";
    }

    public boolean isAprobado(){
        if (estado!=null && estado.equals(ESTADO_APROBADO)){
            return true;
        }
        return false;
    }
}
