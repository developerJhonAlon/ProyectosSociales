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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_CALIFICA_X_CONVOCA")
@XmlRootElement
public class CalificacionComision implements Serializable {

    @Size(max = 250)
    @Column(name = "SCXC_JUSTIFICACION")
    private String justificacion;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_CALIFICA_X_CONVOCA", sequenceName = "SEQ_SEA_CALIFICA_X_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_CALIFICA_X_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCXC_ID")
    private BigDecimal id;
    @Size(max = 1)
    @Column(name = "SCXC_APROBACION")
    private String estado;
    public final static String ESTADO_APROBADO="A";
    public final static String ESTADO_NEGADO="N";
    
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy notaConceptual;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;
    @Column(name = "SCXC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    

    public CalificacionComision() {
        fecha=new Date();
    }

    public CalificacionComision(BigDecimal scxcId) {
        this.id = scxcId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public SeaDatGeneralProy getNotaConceptual() {
        return notaConceptual;
    }

    public void setNotaConceptual(SeaDatGeneralProy notaConceptual) {
        this.notaConceptual = notaConceptual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public boolean isAprobado(){
        if (estado!=null && estado.equals(ESTADO_APROBADO)){
            return true;
        }
        return false;
    }

}
