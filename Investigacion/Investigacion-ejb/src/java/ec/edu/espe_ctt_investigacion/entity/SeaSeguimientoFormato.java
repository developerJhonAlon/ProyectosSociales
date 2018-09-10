/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_SEGUIMIENTO_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaSeguimientoFormato.findAll", query = "SELECT s FROM SeaSeguimientoFormato s"),
    @NamedQuery(name = "SeaSeguimientoFormato.findBySsefId", query = "SELECT s FROM SeaSeguimientoFormato s WHERE s.ssefId = :ssefId")})
public class SeaSeguimientoFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_SEGUIMIENTO_FORMATO", sequenceName = "SEQ_SEA_SEGUIMIENTO_FORMATO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_SEGUIMIENTO_FORMATO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSEF_ID")
    private BigDecimal ssefId;
    @Size(max = 4000)
    @Column(name = "SSEF_ANALISIS")
    private String ssefAnalisis;
    @Size(max = 15)
    @Column(name = "SSEF_CODIGO_PROY")
    private String ssefCodigoProy;
    @Size(max = 3)
    @Column(name = "SSEF_INFORME")
    private String ssefInforme;
    @Column(name = "SSFE_FECHA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssfeFechaDesde;
    @Column(name = "SSFE_FECHA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssfeFechaHasta;
    @Column(name = "SSFE_FINAN_DEVENGADO")
    private BigDecimal ssfeFinanDevengado;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @Size(max = 1)
    @Column(name = "SSFE_ESTADO")
    private String ssfeEstado;
    @Size(max = 1)
    @Column(name = "SSFE_REVISADO")
    private String ssfeRevisado;
    
    
    
//    @OneToMany(mappedBy = "ssefId")
//    private List<SeaEstudiantesFormato> seaEstudiantesFormatoList;

    public SeaSeguimientoFormato() {
    }

    public SeaSeguimientoFormato(BigDecimal ssefId) {
        this.ssefId = ssefId;
    }

    public BigDecimal getSsefId() {
        return ssefId;
    }

    public void setSsefId(BigDecimal ssefId) {
        this.ssefId = ssefId;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    public String getSsefCodigoProy() {
        return ssefCodigoProy;
    }

    public void setSsefCodigoProy(String ssefCodigoProy) {
        this.ssefCodigoProy = ssefCodigoProy;
    }

    public String getSsefInforme() {
        return ssefInforme;
    }

    public void setSsefInforme(String ssefInforme) {
        this.ssefInforme = ssefInforme;
    }

    public Date getSsfeFechaDesde() {
        return ssfeFechaDesde;
    }

    public void setSsfeFechaDesde(Date ssfeFechaDesde) {
        this.ssfeFechaDesde = ssfeFechaDesde;
    }

    public Date getSsfeFechaHasta() {
        return ssfeFechaHasta;
    }

    public void setSsfeFechaHasta(Date ssfeFechaHasta) {
        this.ssfeFechaHasta = ssfeFechaHasta;
    }

    public BigDecimal getSsfeFinanDevengado() {
        return ssfeFinanDevengado;
    }

    public void setSsfeFinanDevengado(BigDecimal ssfeFinanDevengado) {
        this.ssfeFinanDevengado = ssfeFinanDevengado;
    }

    public String getSsefAnalisis() {
        return ssefAnalisis;
    }

    public void setSsefAnalisis(String ssefAnalisis) {
        this.ssefAnalisis = ssefAnalisis;
    }

    public String getSsfeEstado() {
        return ssfeEstado;
    }

    public void setSsfeEstado(String ssfeEstado) {
        this.ssfeEstado = ssfeEstado;
    }

    public String getSsfeRevisado() {
        return ssfeRevisado;
    }

    public void setSsfeRevisado(String ssfeRevisado) {
        this.ssfeRevisado = ssfeRevisado;
    }
    

    @XmlTransient
//    public List<SeaEstudiantesFormato> getSeaEstudiantesFormatoList() {
//        return seaEstudiantesFormatoList;
//    }
//
//    public void setSeaEstudiantesFormatoList(List<SeaEstudiantesFormato> seaEstudiantesFormatoList) {
//        this.seaEstudiantesFormatoList = seaEstudiantesFormatoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssefId != null ? ssefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaSeguimientoFormato)) {
            return false;
        }
        SeaSeguimientoFormato other = (SeaSeguimientoFormato) object;
        if ((this.ssefId == null && other.ssefId != null) || (this.ssefId != null && !this.ssefId.equals(other.ssefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaSeguimientoFormato[ ssefId=" + ssefId + " ]";
    }
    
}
