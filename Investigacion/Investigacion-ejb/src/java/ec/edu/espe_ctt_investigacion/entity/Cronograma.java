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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_FORMATO_CRONOGRAMA")
@XmlRootElement
public class Cronograma implements Serializable, Comparable<Cronograma> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_CRONOGRAMA", sequenceName = "SEQ_SEA_FORMATO_CRONOGRAMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_CRONOGRAMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFCR_ID")
    private BigDecimal id;
    @JoinColumn(name = "SZDTAOBJPROY_CODE", referencedColumnName = "SZDTAOBJPROY_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoProyecto actividad;
    @Column(name = "SFCR_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SFCR_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @OneToMany(mappedBy = "cronograma", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresupuestoPartida> presupuestoList;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo proyecto;

    /*@JoinColumn(name="USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)    
    private SegUsuario usuId;    
    @OneToMany(mappedBy = "sfcrId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaMatrizRiesgos> seaMatrizRiesgosList;
     */
    public Cronograma() {
    }

    public Cronograma(BigDecimal sfcrId) {
        this.id = sfcrId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ObjetivoProyecto getActividad() {
        return actividad;
    }

    public String getActividadDescripcion(){
        if (actividad!=null){
            return actividad.getActividadNombreCompleto();
        }
        return null;
    }
    public String getActividadMedioVerificacion(){
        if (actividad!=null){
            return actividad.getMedioVerificacion();
        }
        return null;
    }
    public void setActividad(ObjetivoProyecto actividad) {
        this.actividad = actividad;
    }

    public List<PresupuestoPartida> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<PresupuestoPartida> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    public SeaFormatoLargo getProyecto() {
        return proyecto;
    }

    public void setProyecto(SeaFormatoLargo proyecto) {
        this.proyecto = proyecto;
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
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.Cronograma[ id=" + id + " ]";
    }
    
    public BigDecimal getTotalPresupuesto(){
        BigDecimal result= BigDecimal.ZERO;
        if (presupuestoList!=null){
            for (PresupuestoPartida p : presupuestoList) {
                result = result.add(p.getValor());
            }
        }
        return result;
    }

    @Override
    public int compareTo(Cronograma o) {
        if (actividad.getObjetivoPadre().getOrden().equals(o.actividad.getObjetivoPadre().getOrden())){
            return actividad.getOrden().compareTo(o.actividad.getOrden());
        }
        else{
            return (actividad.getObjetivoPadre().getOrden().compareTo(o.actividad.getObjetivoPadre().getOrden()));
        }
    }

}
