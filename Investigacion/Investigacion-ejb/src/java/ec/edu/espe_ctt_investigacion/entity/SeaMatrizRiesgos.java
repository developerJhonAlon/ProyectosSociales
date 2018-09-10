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
@Table(name = "SEA_MATRIZ_RIESGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaMatrizRiesgos.findAll", query = "SELECT s FROM SeaMatrizRiesgos s"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrId", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrId = :smrId"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrRiesgo", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrRiesgo = :smrRiesgo"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrProbabilidad", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrProbabilidad = :smrProbabilidad"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrPrioridad", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrPrioridad = :smrPrioridad"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrEstrategia", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrEstrategia = :smrEstrategia"),
    @NamedQuery(name = "SeaMatrizRiesgos.findBySmrPresupuesto", query = "SELECT s FROM SeaMatrizRiesgos s WHERE s.smrPresupuesto = :smrPresupuesto")})
public class SeaMatrizRiesgos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @SequenceGenerator(name = "SEQ_SEA_MATRIZ_RIESGOS", sequenceName = "SEQ_SEA_MATRIZ_RIESGOS", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_MATRIZ_RIESGOS")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SMR_ID")
    private BigDecimal smrId;
    @Size(max = 1500)
    @Column(name = "SMR_RIESGO")
    private String smrRiesgo;
    @Column(name = "SMR_PROBABILIDAD")
    private BigDecimal smrProbabilidad;
    @Column(name = "SMR_PRIORIDAD")
    private BigDecimal smrPrioridad;
    @Size(max = 1500)
    @Column(name = "SMR_ESTRATEGIA")
    private String smrEstrategia;
    @Column(name = "SMR_PRESUPUESTO")
    private BigDecimal smrPresupuesto;
    /*@JoinColumn(name = "SFCR_ID", referencedColumnName = "SFCR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cronograma sfcrId;*/

    public SeaMatrizRiesgos() {
    }

    public SeaMatrizRiesgos(BigDecimal smrId) {
        this.smrId = smrId;
    }

    public BigDecimal getSmrId() {
        return smrId;
    }

    public void setSmrId(BigDecimal smrId) {
        this.smrId = smrId;
    }

    public String getSmrRiesgo() {
        return smrRiesgo;
    }

    public void setSmrRiesgo(String smrRiesgo) {
        this.smrRiesgo = smrRiesgo;
    }

    public BigDecimal getSmrProbabilidad() {
        return smrProbabilidad;
    }

    public void setSmrProbabilidad(BigDecimal smrProbabilidad) {
        this.smrProbabilidad = smrProbabilidad;
    }

    public BigDecimal getSmrPrioridad() {
        return smrPrioridad;
    }

    public void setSmrPrioridad(BigDecimal smrPrioridad) {
        this.smrPrioridad = smrPrioridad;
    }

    public String getSmrEstrategia() {
        return smrEstrategia;
    }

    public void setSmrEstrategia(String smrEstrategia) {
        this.smrEstrategia = smrEstrategia;
    }

    public BigDecimal getSmrPresupuesto() {
        return smrPresupuesto;
    }

    public void setSmrPresupuesto(BigDecimal smrPresupuesto) {
        this.smrPresupuesto = smrPresupuesto;
    }

    /*public Cronograma getSfcrId() {
        return sfcrId;
    }

    public void setSfcrId(Cronograma sfcrId) {
        this.sfcrId = sfcrId;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smrId != null ? smrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaMatrizRiesgos)) {
            return false;
        }
        SeaMatrizRiesgos other = (SeaMatrizRiesgos) object;
        if ((this.smrId == null && other.smrId != null) || (this.smrId != null && !this.smrId.equals(other.smrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaMatrizRiesgos[ smrId=" + smrId + " ]";
    }
    
}
