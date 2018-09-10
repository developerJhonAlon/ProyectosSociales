/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "SZDTAEVALNOTAC")
@XmlRootElement
public class EvaluacionPar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAEVALNOTAC", sequenceName = "SEQ_SZDTAEVALNOTAC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAEVALNOTAC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAEVALNOTAC_CODE")
    private Integer id;

    @JoinColumn(name = "SPC_ID", referencedColumnName = "SPC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParesConvoca par;    
  
    @Size(max = 500)
    @Column(name = "SZDTAEVALNOTAC_OBS")
    private String observaciones;
    
    @Column(name = "SZDTAEVALNOTAC_FECCREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "SZDTAEVALNOTAC_FECMODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @OneToMany(mappedBy = "evaluacionPar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionParDetalle> evaluacionDetalleList;

    
    @Size(max = 1)
    @Column(name = "SZDTAEVALNOTAC_ESTADOFIN")
    private String estadoFinalizado;
    public final static String ESTADO_FINALIZADO_SI= "S";
    public final static String ESTADO_FINALIZADO_NO= "N";
    
    
    public EvaluacionPar() {
        fechaCreacion = new Date();
        estadoFinalizado = ESTADO_FINALIZADO_NO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SeaParesConvoca getPar() {
        return par;
    }

    public void setPar(SeaParesConvoca par) {
        this.par = par;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<EvaluacionParDetalle> getEvaluacionDetalleList() {
        return evaluacionDetalleList;
    }

    public void setEvaluacionDetalleList(List<EvaluacionParDetalle> evaluacionDetalleList) {
        this.evaluacionDetalleList = evaluacionDetalleList;
    }

    public void removeAllDetalle(){
        if (evaluacionDetalleList!=null){
            evaluacionDetalleList.clear();
        }
    }
    public void addDetalle(EvaluacionParDetalle evaluacionParDetalle){
        if (evaluacionDetalleList==null){
            evaluacionDetalleList = new ArrayList<>();
        }
        evaluacionParDetalle.setEvaluacionPar(this);
        evaluacionDetalleList.add(evaluacionParDetalle);
    }

    public String getEstadoFinalizado() {
        return estadoFinalizado;
    }

    public void setEstadoFinalizado(String estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }
    
    
   
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionPar)) {
            return false;
        }
        EvaluacionPar other = (EvaluacionPar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.EvaluacionPar[ id=" + id + " ]";
    }

    public BigDecimal getPuntaje(){
        BigDecimal result = BigDecimal.ZERO;
        if (evaluacionDetalleList!=null){
            for (EvaluacionParDetalle evaluacionParDetalle : evaluacionDetalleList) {
                if (evaluacionParDetalle.getPuntaje()!=null){
                    result = result.add(evaluacionParDetalle.getPuntaje());
                }
            }
        }
        return result;
    }
   
}
