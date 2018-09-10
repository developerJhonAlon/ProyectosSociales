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
 * @author PC1
 */
@Entity
@Table(name = "SEA_VIABILIDAD_PROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaViabilidadProg.findAll", query = "SELECT s FROM SeaViabilidadProg s"),
    @NamedQuery(name = "SeaViabilidadProg.findByViaprogId", query = "SELECT s FROM SeaViabilidadProg s WHERE s.viaprogId = :viaprogId"),
    @NamedQuery(name = "SeaViabilidadProg.findByViaprogViabilidadTecnica", query = "SELECT s FROM SeaViabilidadProg s WHERE s.viaprogViabilidadTecnica = :viaprogViabilidadTecnica"),
    @NamedQuery(name = "SeaViabilidadProg.findByViaprogPerderiaPais", query = "SELECT s FROM SeaViabilidadProg s WHERE s.viaprogPerderiaPais = :viaprogPerderiaPais"),
    @NamedQuery(name = "SeaViabilidadProg.findByViaprogImpactEsperado", query = "SELECT s FROM SeaViabilidadProg s WHERE s.viaprogImpactEsperado = :viaprogImpactEsperado"),
    @NamedQuery(name = "SeaViabilidadProg.findByViaprogImpactAmbiental", query = "SELECT s FROM SeaViabilidadProg s WHERE s.viaprogImpactAmbiental = :viaprogImpactAmbiental")})
public class SeaViabilidadProg implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = " SEQ_SEA_VIABILIDAD_PROG", sequenceName = " SEQ_SEA_VIABILIDAD_PROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_SEA_VIABILIDAD_PROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIAPROG_ID")
    private BigDecimal viaprogId;
    @Size(max = 250)
    @Column(name = "VIAPROG_VIABILIDAD_TECNICA")
    private String viaprogViabilidadTecnica;
    @Size(max = 250)
    @Column(name = "VIAPROG_PERDERIA_PAIS")
    private String viaprogPerderiaPais;
    @Size(max = 1000)
    @Column(name = "VIAPROG_IMPACT_ESPERADO")
    private String viaprogImpactEsperado;
    @Size(max = 1000)
    @Column(name = "VIAPROG_IMPACT_AMBIENTAL")
    private String viaprogImpactAmbiental;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;

    public SeaViabilidadProg() {
    }

    public SeaViabilidadProg(BigDecimal viaprogId) {
        this.viaprogId = viaprogId;
    }

    public BigDecimal getViaprogId() {
        return viaprogId;
    }

    public void setViaprogId(BigDecimal viaprogId) {
        this.viaprogId = viaprogId;
    }

    public String getViaprogViabilidadTecnica() {    
        return viaprogViabilidadTecnica;
    }

    public void setViaprogViabilidadTecnica(String viaprogViabilidadTecnica) {
        this.viaprogViabilidadTecnica = viaprogViabilidadTecnica;
    }

    public String getViaprogPerderiaPais() {
        return viaprogPerderiaPais;
    }

    public void setViaprogPerderiaPais(String viaprogPerderiaPais) {
        this.viaprogPerderiaPais = viaprogPerderiaPais;
    }

    public String getViaprogImpactEsperado() {
        return viaprogImpactEsperado;
    }

    public void setViaprogImpactEsperado(String viaprogImpactEsperado) {
        this.viaprogImpactEsperado = viaprogImpactEsperado;
    }

    public String getViaprogImpactAmbiental() {
        return viaprogImpactAmbiental;
    }

    public void setViaprogImpactAmbiental(String viaprogImpactAmbiental) {
        this.viaprogImpactAmbiental = viaprogImpactAmbiental;
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
        hash += (viaprogId != null ? viaprogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaViabilidadProg)) {
            return false;
        }
        SeaViabilidadProg other = (SeaViabilidadProg) object;
        if ((this.viaprogId == null && other.viaprogId != null) || (this.viaprogId != null && !this.viaprogId.equals(other.viaprogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaViabilidadProg[ viaprogId=" + viaprogId + " ]";
    }
    
}
