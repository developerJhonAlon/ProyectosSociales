/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTACONPARAEVA")
@XmlRootElement
public class ConfiguracionParametrosEvaluacionInv implements Serializable, Comparable<ConfiguracionParametrosEvaluacionInv> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTACONPARAEVA", sequenceName = "SEQ_SZDTACONPARAEVA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTACONPARAEVA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCONPARAEVA_CODE")
    private Integer id;

    @Column(name = "SZTVCONPARAEVA_FECHA_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConfiguracion;

    @Size(max = 100)
    @Column(name = "SZTVCONPARAEVA_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVCONPARAEVA_PUMINIRE")
    private BigDecimal puntajeMinimoRequerido;

    @OneToMany(mappedBy = "configuracionParametrosEvaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroEvaluacionInv> parametroEvaluacionList;

    @Column(name = "SZTVCONPARAEVA_TIPO")
    private Integer tipo;
    public final static Integer TIPO_EVALUACION_INICIAL = 1;
    public final static Integer TIPO_EVALUACION_FINAL = 2;

    @Size(max = 1)
    @Column(name = "SZTVCONPARAEVA_ESTADO")
    private String estado;
    public final static String ESTADO_ACTIVA = "A";
    public final static String ESTADO_INACTIVA = "I";

    @Transient
    private boolean expanded;

    public ConfiguracionParametrosEvaluacionInv() {
        fechaConfiguracion = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaConfiguracion() {
        return fechaConfiguracion;
    }

    public void setFechaConfiguracion(Date fechaConfiguracion) {
        this.fechaConfiguracion = fechaConfiguracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public BigDecimal getPuntajeMinimoRequerido() {
        return puntajeMinimoRequerido;
    }

    public BigDecimal getPuntajeMaximoEvaluacion() {
        BigDecimal result = BigDecimal.ZERO;
        for (ParametroEvaluacionInv par : parametroEvaluacionList) {
            try {
                result = result.add(par.getPuntajeMaximo());
            } catch (Exception e) {
            }
        }
        return result;
    }

    public void setPuntajeMinimoRequerido(BigDecimal puntajeMinimoRequerido) {
        this.puntajeMinimoRequerido = puntajeMinimoRequerido;
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

    public void addParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion) {
        if (parametroEvaluacionList == null) {
            parametroEvaluacionList = new ArrayList<>();
        }
        parametroEvaluacion.setConfiguracionParametrosEvaluacion(this);
        parametroEvaluacionList.add(parametroEvaluacion);
    }

    public void removeParametroEvaluacion(ParametroEvaluacionInv parametroEvaluacion) {
        for (ParametroEvaluacionInv param : getParametroEvaluacionList()) {
            if (param.getOrden() > parametroEvaluacion.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionList.remove(parametroEvaluacion);
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
        if (!(object instanceof ConfiguracionParametrosEvaluacionInv)) {
            return false;
        }
        ConfiguracionParametrosEvaluacionInv other = (ConfiguracionParametrosEvaluacionInv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ConfiguracionParametrosEvaluacionInv o) {
        return this.id.compareTo(o.getId()) * -1;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getEstadoActiva() {
        if (estado != null && estado.equals(ESTADO_ACTIVA)) {
            return true;
        }
        return false;
    }

    public BigDecimal getPuntaje() {
        BigDecimal result = BigDecimal.ZERO;
        if (parametroEvaluacionList != null && !parametroEvaluacionList.isEmpty()) {
            for (ParametroEvaluacionInv parametroEvaluacion : parametroEvaluacionList) {
                try {
                    result = result.add(parametroEvaluacion.getPuntaje());
                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    public String getPuntajeStr() {
        return decimalToString(getPuntaje());
    }

    private String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }
    
    public ConfiguracionParametrosEvaluacionInv clone(){
        ConfiguracionParametrosEvaluacionInv conf = new ConfiguracionParametrosEvaluacionInv();
        conf.setPuntajeMinimoRequerido(puntajeMinimoRequerido);
        for (ParametroEvaluacionInv parPadre : parametroEvaluacionList) {
            ParametroEvaluacionInv parPadreNuevo= new ParametroEvaluacionInv();
            parPadreNuevo.setId(parPadre.getId());
            parPadreNuevo.setDescripcion(parPadre.getDescripcion());
            parPadreNuevo.setOrden(parPadre.getOrden());
            parPadreNuevo.setTieneSubitems(parPadre.getTieneSubitems());
            parPadreNuevo.setPuntajeMaximo(parPadre.getPuntajeMaximo());
            
            for (ParametroEvaluacionInv parHijo : parPadre.getParametroEvaluacionList()) {
                ParametroEvaluacionInv parHijoNuevo= new ParametroEvaluacionInv();
                parHijoNuevo.setId(parHijo.getId());
                parHijoNuevo.setDescripcion(parHijo.getDescripcion());
                parHijoNuevo.setOrden(parHijo.getOrden());
                parHijoNuevo.setTieneSubitems(parHijo.getTieneSubitems());
                parHijoNuevo.setPuntajeMaximo(parHijo.getPuntajeMaximo());
                for (ValoracionParametroEvaluacionInv valor : parHijo.getValoracionList()) {
                    ValoracionParametroEvaluacionInv valorNuevo = new ValoracionParametroEvaluacionInv();
                    valorNuevo.setId(valor.getId());
                    valorNuevo.setDescripcion(valor.getDescripcion());
                    valorNuevo.setOrden(valor.getOrden());
                    valorNuevo.setPuntaje(valor.getPuntaje());
                    parHijoNuevo.addValoracion(valorNuevo);
                }
                parPadreNuevo.addParametro(parHijoNuevo);
            }
            for (ValoracionParametroEvaluacionInv valor : parPadre.getValoracionList()) {
                ValoracionParametroEvaluacionInv valorNuevo = new ValoracionParametroEvaluacionInv();
                valorNuevo.setId(valor.getId());
                valorNuevo.setDescripcion(valor.getDescripcion());
                valorNuevo.setOrden(valor.getOrden());
                valorNuevo.setPuntaje(valor.getPuntaje());
                parPadreNuevo.addValoracion(valorNuevo);
            }
            conf.addParametroEvaluacion(parPadreNuevo);
        }
        return conf;
    }

}
