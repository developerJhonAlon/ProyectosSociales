/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
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
@Table(name = "SEA_INFORME_DIRECTOR_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaInformeDirectorFormato.findAll", query = "SELECT s FROM SeaInformeDirectorFormato s"),
    @NamedQuery(name = "SeaInformeDirectorFormato.findBySidfId", query = "SELECT s FROM SeaInformeDirectorFormato s WHERE s.sidfId = :sidfId"),
    @NamedQuery(name = "SeaInformeDirectorFormato.findBySidfPorcentajeProgram", query = "SELECT s FROM SeaInformeDirectorFormato s WHERE s.sidfPorcentajeProgram = :sidfPorcentajeProgram"),
    @NamedQuery(name = "SeaInformeDirectorFormato.findBySidfPorcetajeRealizada", query = "SELECT s FROM SeaInformeDirectorFormato s WHERE s.sidfPorcetajeRealizada = :sidfPorcetajeRealizada"),
    @NamedQuery(name = "SeaInformeDirectorFormato.findBySidfAnalisis", query = "SELECT s FROM SeaInformeDirectorFormato s WHERE s.sidfAnalisis = :sidfAnalisis"),
    @NamedQuery(name = "SeaInformeDirectorFormato.findBySidfObservacion", query = "SELECT s FROM SeaInformeDirectorFormato s WHERE s.sidfObservacion = :sidfObservacion")})
    
public class SeaInformeDirectorFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_INFORME_DIRECTOR_FORMA", sequenceName = "SEQ_SEA_INFORME_DIRECTOR_FORMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_INFORME_DIRECTOR_FORMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIDF_ID")
    private BigDecimal sidfId;
    @JoinColumn(name = "PRD_ID_EJECUCION",referencedColumnName = "PRD_ID" )
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet  prdId;
    @Column(name = "SIDF_PORCENTAJE_PROGRAM")
    private BigDecimal sidfPorcentajeProgram;
    @Column(name = "SIDF_PORCETAJE_REALIZADA")
    private BigDecimal sidfPorcetajeRealizada;
    @Size(max = 500)
    @Column(name = "SIDF_ANALISIS")
    private String sidfAnalisis;
    @JoinColumn(name = "SSEF_ID", referencedColumnName = "SSEF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaSeguimientoFormato ssefId;
    @Size(max = 150)
    @Column(name = "SIDF_OBSERVACION")
    private String sidfObservacion;
    @JoinColumn(name = "USU_ID",referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuId;   

    public SeaInformeDirectorFormato() {
    }

    public SeaInformeDirectorFormato(BigDecimal sidfId) {
        this.sidfId = sidfId;
    }

    public BigDecimal getSidfId() {
        return sidfId;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }
    

    public void setSidfId(BigDecimal sidfId) {
        this.sidfId = sidfId;
    }

    public BigDecimal getSidfPorcentajeProgram() {
        return sidfPorcentajeProgram;
    }

    public void setSidfPorcentajeProgram(BigDecimal sidfPorcentajeProgram) {
        this.sidfPorcentajeProgram = sidfPorcentajeProgram;
    }

    public BigDecimal getSidfPorcetajeRealizada() {
        return sidfPorcetajeRealizada;
    }

    public void setSidfPorcetajeRealizada(BigDecimal sidfPorcetajeRealizada) {
        this.sidfPorcetajeRealizada = sidfPorcetajeRealizada;
    }

    public String getSidfAnalisis() {
        return sidfAnalisis;
    }

    public void setSidfAnalisis(String sidfAnalisis) {
        this.sidfAnalisis = sidfAnalisis;
    }

    public SeaSeguimientoFormato getSsefId() {
        return ssefId;
    }

    public void setSsefId(SeaSeguimientoFormato ssefId) {
        this.ssefId = ssefId;
    }

    public String getSidfObservacion() {
        return sidfObservacion;
    }

    public void setSidfObservacion(String sidfObservacion) {
        this.sidfObservacion = sidfObservacion;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }  
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sidfId != null ? sidfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaInformeDirectorFormato)) {
            return false;
        }
        SeaInformeDirectorFormato other = (SeaInformeDirectorFormato) object;
        if ((this.sidfId == null && other.sidfId != null) || (this.sidfId != null && !this.sidfId.equals(other.sidfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaInformeDirectorFormato[ sidfId=" + sidfId + " ]";
    }
    
}
