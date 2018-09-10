/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAPARAEVA")
@XmlRootElement
public class ParametroEvaluacionInv implements Serializable, Comparable<ParametroEvaluacionInv> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAPARAEVA", sequenceName = "SEQ_SZDTAPARAEVA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAPARAEVA")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPARAEVA_CODE")
    private Integer id;

    @Size(max = 500)
    @Column(name = "SZTVPARAEVA_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVPARAEVA_ORDEN")
    private Integer orden;

    @JoinColumn(name = "SZTVCONPARAEVA_CODE", referencedColumnName = "SZTVCONPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacion;

    @OneToMany(mappedBy = "parametroEvaluacionPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroEvaluacionInv> parametroEvaluacionList;

    @JoinColumn(name = "SZTVPARAEVA_CODE_PADRE", referencedColumnName = "SZTVPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacionInv parametroEvaluacionPadre;

    @OneToMany(mappedBy = "parametroEvaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValoracionParametroEvaluacionInv> valoracionList;

    @Column(name = "SZTVPARAEVA_PUNTAJEMAX")
    private BigDecimal puntajeMaximo;

    @Size(max = 1)
    @Column(name = "SZTVPARAEVA_SUBITEM")
    private String tieneSubitems;
    public final static String TIENE_SUBITEMS_SI = "S";
    public final static String TIENE_SUBITEMS_NO = "N";

    /*@Size(max = 1)
    @Column(name = "SZTVPARAEVA_OPCPREDEF")
    private String tieneOcionesPredefinidas;
    public final static String TIENE_OPCIONES_PREDEFINIDAS_SI = "S";
    public final static String TIENE_OPCIONES_PREDEFINIDAS_NO = "N";*/
    @Transient
    private boolean expanded;

    public ParametroEvaluacionInv() {
        tieneSubitems = ParametroEvaluacionInv.TIENE_SUBITEMS_NO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<ValoracionParametroEvaluacionInv> getValoracionList() {
        if (valoracionList != null) {
            Collections.sort(valoracionList);
        }
        return valoracionList;
    }

    public void setValoracionList(List<ValoracionParametroEvaluacionInv> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroEvaluacionInv)) {
            return false;
        }
        ParametroEvaluacionInv other = (ParametroEvaluacionInv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ParametroEvaluacionInv o) {
        return this.orden.compareTo(o.getOrden());
    }

    public void addValoracion(ValoracionParametroEvaluacionInv valoracionParametroEvaluacion) {
        if (valoracionList == null) {
            valoracionList = new ArrayList<>();
            valoracionParametroEvaluacion.setOrden(0);
        } else {
            valoracionParametroEvaluacion.setOrden(valoracionList.size() + 1);
        }
        valoracionParametroEvaluacion.setParametroEvaluacion(this);
        valoracionList.add(valoracionParametroEvaluacion);
    }

    public void removeValoracion(ValoracionParametroEvaluacionInv valoracionParametroEvaluacion) {
        for (ValoracionParametroEvaluacionInv valoracion : getValoracionList()) {
            if (valoracion.getOrden() > valoracionParametroEvaluacion.getOrden()) {
                valoracion.setOrden(valoracion.getOrden() - 1);
            }
        }
        valoracionList.remove(valoracionParametroEvaluacion);
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public ConfiguracionParametrosEvaluacionInv getConfiguracionParametrosEvaluacion() {
        return configuracionParametrosEvaluacion;
    }

    public void setConfiguracionParametrosEvaluacion(ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacion) {
        this.configuracionParametrosEvaluacion = configuracionParametrosEvaluacion;
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = orden;
        if (parametroEvaluacionPadre == null) {
            if (cambio.equals(-1)) {
                configuracionParametrosEvaluacion.getParametroEvaluacionList().get(temp - 2).setOrden(temp);
                setOrden(temp - 1);
            } else {
                configuracionParametrosEvaluacion.getParametroEvaluacionList().get(temp).setOrden(temp);
                setOrden(temp + 1);
            }

        } else if (cambio.equals(-1)) {
            parametroEvaluacionPadre.getParametroEvaluacionList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            parametroEvaluacionPadre.getParametroEvaluacionList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }

    }

    public BigDecimal getPuntajeMaximo() {
        if (valoracionList == null || valoracionList.isEmpty()) {
            if (parametroEvaluacionList==null || parametroEvaluacionList.isEmpty()){
                return puntajeMaximo;
            }
            else{
                BigDecimal result = BigDecimal.ZERO;
                for (ParametroEvaluacionInv p : parametroEvaluacionList) {
                    result=result.add(p.getPuntajeMaximo());
                }
                return result;
            }
        }
        BigDecimal result = BigDecimal.ZERO;
        for (ValoracionParametroEvaluacionInv val : valoracionList) {
            if (val.getPuntaje().compareTo(result)>0){
                result= val.getPuntaje();
            }
        }
        return result;
    }
    
    public String getPuntajeMaximoStr(){
        return Utils.decimalToString(getPuntajeMaximo());
    }
    public String getPuntajeReporteStr(){
        return Utils.decimalToString(getPuntajeReporte());
    }

    public void setPuntajeMaximo(BigDecimal puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    public List<ParametroEvaluacionInv> getParametroEvaluacionList() {
        if (parametroEvaluacionList != null) {
            Collections.sort(parametroEvaluacionList);
        }
        return parametroEvaluacionList;
    }

    public void setParametroEvaluacionList(List<ParametroEvaluacionInv> parametroEvaluacionList) {
        this.parametroEvaluacionList = parametroEvaluacionList;
    }

    public ParametroEvaluacionInv getParametroEvaluacionPadre() {
        return parametroEvaluacionPadre;
    }

    public void setParametroEvaluacionPadre(ParametroEvaluacionInv parametroEvaluacionPadre) {
        this.parametroEvaluacionPadre = parametroEvaluacionPadre;
    }

    public String getTieneSubitems() {
        return tieneSubitems;
    }

    public void setTieneSubitems(String tieneSubitems) {
        this.tieneSubitems = tieneSubitems;
    }

    public void removeParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion) {
        for (ParametroEvaluacionInv param : getParametroEvaluacionList()) {
            if (param.getOrden() > parametroEvaluacion.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionList.remove(parametroEvaluacion);
    }

    
    @Transient
    private BigDecimal puntaje;

    public BigDecimal getPuntaje() {
        if (parametroEvaluacionList!=null && !parametroEvaluacionList.isEmpty()){
            BigDecimal result = BigDecimal.ZERO;
            for (ParametroEvaluacionInv param : parametroEvaluacionList) {
                try {
                    result = result.add(param.getPuntaje());
                } catch (Exception e) {
                }
                
            }
            return result;
        }
        if (valoracionList!=null && !valoracionList.isEmpty()){
            try {
                return valoracionParametroEvaluacion.getPuntaje();
            } catch (Exception e) {
                return BigDecimal.ZERO;
            }
            
        }
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }
    
    @Transient
    private String justificacion;

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    
    @Transient
    private ValoracionParametroEvaluacionInv valoracionParametroEvaluacion;

    public ValoracionParametroEvaluacionInv getValoracionParametroEvaluacion() {
        return valoracionParametroEvaluacion;
    }

    public void setValoracionParametroEvaluacion(ValoracionParametroEvaluacionInv valoracionParametroEvaluacion) {
        this.valoracionParametroEvaluacion = valoracionParametroEvaluacion;
    }

    public ConfiguracionParametrosEvaluacionInv getConfiguracion() {
        if (parametroEvaluacionPadre!=null){
            return parametroEvaluacionPadre.getConfiguracionParametrosEvaluacion();
        }
        else{
            return configuracionParametrosEvaluacion;
        }
    }
    
    public void addParametro(ParametroEvaluacionInv parametroEvaluacionInv) {
        if (parametroEvaluacionList == null) {
            parametroEvaluacionList = new ArrayList<>();
        }
        parametroEvaluacionList.add(parametroEvaluacionInv);
    }

  @Transient
    private BigDecimal puntajeReporte;

    public BigDecimal getPuntajeReporte() {
        if (parametroEvaluacionList!=null){
            puntajeReporte = BigDecimal.ZERO;
            for (ParametroEvaluacionInv p : parametroEvaluacionList) {
                puntajeReporte= puntajeReporte.add(p.getPuntajeReporte());
            }
        }
        return puntajeReporte;
    }

    public void setPuntajeReporte(BigDecimal puntajeReporte) {
        this.puntajeReporte = puntajeReporte;
    }

  
}
