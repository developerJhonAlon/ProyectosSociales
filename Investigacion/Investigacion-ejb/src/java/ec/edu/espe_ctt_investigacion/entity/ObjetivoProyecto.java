/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAOBJPROY")
@XmlRootElement
public class ObjetivoProyecto implements Serializable, Comparable<ObjetivoProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAOBJPROY", sequenceName = "SEQ_SZDTAOBJPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAOBJPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAOBJPROY_CODE")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "SZDTAOBJPROY_DESCR")
    private String descripcion;
    @Column(name = "SZDTAOBJPROY_ORDEN")
    private Integer orden = 1;

    @JoinColumn(name = "SZDTAOBJPROY_PADRE", referencedColumnName = "SZDTAOBJPROY_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoProyecto objetivoPadre;
    @OneToMany(mappedBy = "objetivoPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoProyecto> objetivoHijoList;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo proyecto;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet tipo;
    @Size(max = 1000)
    @Column(name = "SZDTAOBJPROY_MVERIFICA")
    private String medioVerificacion;
    @Size(max = 1000)
    @Column(name = "SZDTAOBJPROY_SUPUESTOS")
    private String supuestos;

    @Size(max = 1000)
    @Column(name = "SZDTAOBJPROY_INDICADOR_DESC")
    private String indicadorDescripcion;
    @Column(name = "SZDTAOBJPROY_INDICADOR_TIPO")
    private Integer indicadorTipo;
    public final static Integer TIPO_INDICADOR_VALOR = 1;
    public final static Integer TIPO_INDICADOR_PORCENTAJE = 2;
    @Column(name = "SZDTAOBJPROY_INDICADOR_VALOR")
    private Integer indicadorValor;

    public ObjetivoProyecto() {
    }

    public ObjetivoProyecto(SeaFormatoLargo proyecto) {
        this.proyecto = proyecto;
    }

    public ObjetivoProyecto(SeaFormatoLargo proyecto, SeaParametrosDet tipo, Integer orden) {
        this.proyecto = proyecto;
        this.tipo = tipo;
        this.orden = orden;
    }

    public ObjetivoProyecto(SeaParametrosDet tipo) {
        this.tipo = tipo;
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

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public ObjetivoProyecto getObjetivoPadre() {
        return objetivoPadre;
    }

    public void setObjetivoPadre(ObjetivoProyecto objetivoPadre) {
        this.objetivoPadre = objetivoPadre;
    }

    public List<ObjetivoProyecto> getObjetivoHijoList() {
        Collections.sort(objetivoHijoList);
        return objetivoHijoList;
    }

    public void setObjetivoHijoList(List<ObjetivoProyecto> objetivoHijoList) {
        this.objetivoHijoList = objetivoHijoList;
    }

    public SeaFormatoLargo getProyecto() {
        return proyecto;
    }

    public void setProyecto(SeaFormatoLargo proyecto) {
        this.proyecto = proyecto;
    }

    public SeaParametrosDet getTipo() {
        return tipo;
    }

    public void setTipo(SeaParametrosDet tipo) {
        this.tipo = tipo;
    }

    public String getMedioVerificacion() {
        return medioVerificacion;
    }

    public void setMedioVerificacion(String medioVerificacion) {
        this.medioVerificacion = medioVerificacion;
    }

    public String getSupuestos() {
        return supuestos;
    }

    public void setSupuestos(String supuestos) {
        this.supuestos = supuestos;
    }

    public String getIndicadorDescripcion() {
        return indicadorDescripcion;
    }

    public void setIndicadorDescripcion(String indicadorDescripcion) {
        this.indicadorDescripcion = indicadorDescripcion;
    }

    public Integer getIndicadorTipo() {
        return indicadorTipo;
    }

    public void setIndicadorTipo(Integer indicadorTipo) {
        this.indicadorTipo = indicadorTipo;
    }

    public Integer getIndicadorValor() {
        return indicadorValor;
    }

    public void setIndicadorValor(Integer indicadorValor) {
        this.indicadorValor = indicadorValor;
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
        if (!(object instanceof ObjetivoProyecto)) {
            return false;
        }
        ObjetivoProyecto other = (ObjetivoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getTipoStr() {
        return tipo.getPrdDescripcion();
    }

    @Override
    public String toString() {
        return "entity.ObjetivoProyecto[ id=" + id + " ]";
    }
    @Transient
    private boolean expanded = true;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void setearEstadoExpanded() {
        expanded = !tipo.getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_FIN);
    }

    @Override
    public int compareTo(ObjetivoProyecto o) {
        return this.orden.compareTo(o.getOrden());
    }
    
    public boolean isTipoFin(){
        return tipo.getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_FIN);
    }
    public boolean isTipoObjetivoGeneral(){
        return tipo.getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_GENERAL);
    }
    public boolean isTipoObjetivoEspecifico(){
        return tipo.getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_ESPECIFICO);
    }
    public boolean isTipoActividad(){
        return tipo.getPrdId().equals(SeaParametrosDet.TIPO_OBJETIVO_ACTIVIDAD);
    }

    public SeaParametrosDet getTipoHijo(){
        if (isTipoObjetivoGeneral()){
            return new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_ESPECIFICO);
        }
        else if (isTipoObjetivoEspecifico()){
            return new SeaParametrosDet(SeaParametrosDet.TIPO_OBJETIVO_ACTIVIDAD);
        }
        return null;
    }
    public void removeObjetivo(ObjetivoProyecto objetivoProyecto){
        for (ObjetivoProyecto act : objetivoHijoList) {
            if (act.getOrden().compareTo(objetivoProyecto.getOrden())>0){
                act.setOrden(act.getOrden()-1);
            }
        }
        objetivoHijoList.remove(objetivoProyecto);
    }

    public void cambiarOrdenObjetivo(Integer cambio) {
        Integer temp = orden;
        orden = -1;
        if (cambio.equals(-1)) {
            objetivoPadre.getObjetivoHijoList().get(temp - 1).setOrden(temp);
            orden = temp - 1;
        } else {
            objetivoPadre.getObjetivoHijoList().get(temp).setOrden(temp);
            orden = temp + 1;
        }

    }
    public Integer getNroHijos() {
        Integer temp = 0;
        if (objetivoHijoList != null) {
            temp = objetivoHijoList.size();
        }
        return temp;
    }

    public String getActividadNombreCompleto(){
        if (objetivoPadre!=null){
            StringBuilder nom = new StringBuilder();
               nom.append("COMPONENTE:  ").append(objetivoPadre.descripcion)
                       .append("\r\n").append("ACTIVIDAD: ").append(descripcion);
           return nom.toString();
        }
        else{
            return null;
        }
    }
    

}
