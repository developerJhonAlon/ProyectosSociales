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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_OBJ_AC_FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjAcFormulario.findAll", query = "SELECT s FROM SeaObjAcFormulario s"),
    @NamedQuery(name = "SeaObjAcFormulario.findBySoafId", query = "SELECT s FROM SeaObjAcFormulario s WHERE s.soafId = :soafId"),
    @NamedQuery(name = "SeaObjAcFormulario.findBySoafDescripcion", query = "SELECT s FROM SeaObjAcFormulario s WHERE s.soafDescripcion = :soafDescripcion"),
    @NamedQuery(name = "SeaObjAcFormulario.findBySoafIndicador", query = "SELECT s FROM SeaObjAcFormulario s WHERE s.soafIndicador = :soafIndicador"),
    @NamedQuery(name = "SeaObjAcFormulario.findBySoafVerificacion", query = "SELECT s FROM SeaObjAcFormulario s WHERE s.soafVerificacion = :soafVerificacion"),
    @NamedQuery(name = "SeaObjAcFormulario.findBySoafSupuestos", query = "SELECT s FROM SeaObjAcFormulario s WHERE s.soafSupuestos = :soafSupuestos")})
public class SeaObjAcFormulario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJ_AC_FORMULARIO", sequenceName = "SEQ_SEA_OBJ_AC_FORMULARIO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJ_AC_FORMULARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOAF_ID")
    private BigDecimal soafId;
    @Size(max = 100)
    @Column(name = "SOAF_DESCRIPCION")
    private String soafDescripcion;
    @Size(max = 25)
    @Column(name = "SOAF_INDICADOR")
    private String soafIndicador;
    @Size(max = 25)
    @Column(name = "SOAF_VERIFICACION")
    private String soafVerificacion;
    @Size(max = 25)
    @Column(name = "SOAF_SUPUESTOS")
    private String soafSupuestos;
    @JoinColumn(name = "SOF_ID", referencedColumnName = "SOF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaObjetivosFormato sofId;

    public SeaObjAcFormulario() {
    }

    public SeaObjAcFormulario(BigDecimal soafId) {
        this.soafId = soafId;
    }

    public BigDecimal getSoafId() {
        return soafId;
    }

    public void setSoafId(BigDecimal soafId) {
        this.soafId = soafId;
    }

    public String getSoafDescripcion() {
        return soafDescripcion;
    }

    public void setSoafDescripcion(String soafDescripcion) {
        this.soafDescripcion = soafDescripcion;
    }

    public String getSoafIndicador() {
        return soafIndicador;
    }

    public void setSoafIndicador(String soafIndicador) {
        this.soafIndicador = soafIndicador;
    }

    public String getSoafVerificacion() {
        return soafVerificacion;
    }

    public void setSoafVerificacion(String soafVerificacion) {
        this.soafVerificacion = soafVerificacion;
    }

    public String getSoafSupuestos() {
        return soafSupuestos;
    }

    public void setSoafSupuestos(String soafSupuestos) {
        this.soafSupuestos = soafSupuestos;
    }

    public SeaObjetivosFormato getSofId() {
        return sofId;
    }

    public void setSofId(SeaObjetivosFormato sofId) {
        this.sofId = sofId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soafId != null ? soafId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjAcFormulario)) {
            return false;
        }
        SeaObjAcFormulario other = (SeaObjAcFormulario) object;
        if ((this.soafId == null && other.soafId != null) || (this.soafId != null && !this.soafId.equals(other.soafId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaObjAcFormulario[ soafId=" + soafId + " ]";
    }
    
}
