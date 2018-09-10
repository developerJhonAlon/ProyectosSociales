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
@Table(name = "SZDTAVALORPAR")
@XmlRootElement
public class ValoracionParametroEvaluacionInv implements Serializable, Comparable<ValoracionParametroEvaluacionInv> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVALORPAR", sequenceName = "SEQ_SZDTAVALORPAR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVALORPAR")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVALORPAR_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPARAEVA_CODE", referencedColumnName = "SZTVPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacionInv parametroEvaluacion;

    @Size(max = 100)
    @Column(name = "SZTVALORPAR_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVALORPAR_ORDEN")
    private Integer orden;

    @Column(name = "SZTVALORPAR_PUNTAJE")
    private BigDecimal puntaje;

    public ValoracionParametroEvaluacionInv() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParametroEvaluacionInv getParametroEvaluacion() {
        return parametroEvaluacion;
    }

    public void setParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion) {
        this.parametroEvaluacion = parametroEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionParametroEvaluacionInv)) {
            return false;
        }
        ValoracionParametroEvaluacionInv other = (ValoracionParametroEvaluacionInv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.ValoracionParametroEvaluacionInv[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ValoracionParametroEvaluacionInv o) {
        return this.orden.compareTo(o.getOrden());
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = this.orden;
        if (cambio.equals(-1)) {
            parametroEvaluacion.getValoracionList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            parametroEvaluacion.getValoracionList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }
    
     public ConfiguracionParametrosEvaluacionInv getConfiguracion() {
         return parametroEvaluacion.getConfiguracion();
    }
    
}
