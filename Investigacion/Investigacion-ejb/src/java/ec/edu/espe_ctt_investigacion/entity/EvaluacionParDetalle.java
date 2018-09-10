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
@Table(name = "SZDTADETEVALNOTAC")
@XmlRootElement
public class EvaluacionParDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTADETEVALNOTAC", sequenceName = "SEQ_SZDTADETEVALNOTAC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTADETEVALNOTAC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTADETEVALNOTAC_CODE")
    private Integer id;

    @JoinColumn(name = "SZDTAEVALNOTAC_CODE", referencedColumnName = "SZDTAEVALNOTAC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvaluacionPar evaluacionPar;    

    @JoinColumn(name = "SZTVALORPAR_CODE", referencedColumnName = "SZTVALORPAR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ValoracionParametroEvaluacionInv valoracionParametroEvaluacion;    

    @JoinColumn(name = "SZTVPARAEVA_CODE", referencedColumnName = "SZTVPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacionInv parametroEvaluacion;
    
    @Column(name = "SZDTADETEVALNOTAC_PUNTAJE")
    private BigDecimal puntaje;    
    
    
    @Size(max = 500)
    @Column(name = "SZDTADETEVALNOTAC_JUSTIF")
    private String justificacion;
    
    
    public EvaluacionParDetalle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EvaluacionPar getEvaluacionPar() {
        return evaluacionPar;
    }

    public void setEvaluacionPar(EvaluacionPar evaluacionPar) {
        this.evaluacionPar = evaluacionPar;
    }

    public ValoracionParametroEvaluacionInv getValoracionParametroEvaluacion() {
        return valoracionParametroEvaluacion;
    }

    public void setValoracionParametroEvaluacion(ValoracionParametroEvaluacionInv valoracionParametroEvaluacion) {
        this.valoracionParametroEvaluacion = valoracionParametroEvaluacion;
    }

    public ParametroEvaluacionInv getParametroEvaluacion() {
        return parametroEvaluacion;
    }

    public void setParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion) {
        this.parametroEvaluacion = parametroEvaluacion;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

  
    
   
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionParDetalle)) {
            return false;
        }
        EvaluacionParDetalle other = (EvaluacionParDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.EvaluacionParDetalle[ id=" + id + " ]";
    }

    public ConfiguracionParametrosEvaluacionInv getConfiguracion() {
        if (parametroEvaluacion!=null){
            return parametroEvaluacion.getConfiguracion();
        }
        else{
            return valoracionParametroEvaluacion.getConfiguracion();
        }
    }

    
   
}
