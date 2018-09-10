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
@Table(name = "SEA_OBJ_E_FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjEFormulario.findAll", query = "SELECT s FROM SeaObjEFormulario s"),
    @NamedQuery(name = "SeaObjEFormulario.findBySoefId", query = "SELECT s FROM SeaObjEFormulario s WHERE s.soefId = :soefId"),
    @NamedQuery(name = "SeaObjEFormulario.findBySoefDescripcion", query = "SELECT s FROM SeaObjEFormulario s WHERE s.soefDescripcion = :soefDescripcion"),
    @NamedQuery(name = "SeaObjEFormulario.findBySoefIndicador", query = "SELECT s FROM SeaObjEFormulario s WHERE s.soefIndicador = :soefIndicador"),
    @NamedQuery(name = "SeaObjEFormulario.findBySoefVerficac\u00edon", query = "SELECT s FROM SeaObjEFormulario s WHERE s.soefVerficac\u00edon = :soefVerficac\u00edon"),
    @NamedQuery(name = "SeaObjEFormulario.findBySoefSupuestos", query = "SELECT s FROM SeaObjEFormulario s WHERE s.soefSupuestos = :soefSupuestos")})
public class SeaObjEFormulario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJ_E_FORMULARIO", sequenceName = "SEQ_SEA_OBJ_E_FORMULARIO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJ_E_FORMULARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOEF_ID")
    private BigDecimal soefId;
    @Size(max = 50)
    @Column(name = "SOEF_DESCRIPCION")
    private String soefDescripcion;
    @Size(max = 25)
    @Column(name = "SOEF_INDICADOR")
    private String soefIndicador;
    @Size(max = 25)
    @Column(name = "SOEF_VERFICAC\u00cdON")
    private String soefVerficacíon;
    @Size(max = 25)
    @Column(name = "SOEF_SUPUESTOS")
    private String soefSupuestos;
    @JoinColumn(name = "SOF_ID", referencedColumnName = "SOF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaObjetivosFormato sofId;

    public SeaObjEFormulario() {
    }

    public SeaObjEFormulario(BigDecimal soefId) {
        this.soefId = soefId;
    }

    public BigDecimal getSoefId() {
        return soefId;
    }

    public void setSoefId(BigDecimal soefId) {
        this.soefId = soefId;
    }

    public String getSoefDescripcion() {
        return soefDescripcion;
    }

    public void setSoefDescripcion(String soefDescripcion) {
        this.soefDescripcion = soefDescripcion;
    }

    public String getSoefIndicador() {
        return soefIndicador;
    }

    public void setSoefIndicador(String soefIndicador) {
        this.soefIndicador = soefIndicador;
    }

    public String getSoefVerficacíon() {
        return soefVerficacíon;
    }

    public void setSoefVerficacíon(String soefVerficacíon) {
        this.soefVerficacíon = soefVerficacíon;
    }

    public String getSoefSupuestos() {
        return soefSupuestos;
    }

    public void setSoefSupuestos(String soefSupuestos) {
        this.soefSupuestos = soefSupuestos;
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
        hash += (soefId != null ? soefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjEFormulario)) {
            return false;
        }
        SeaObjEFormulario other = (SeaObjEFormulario) object;
        if ((this.soefId == null && other.soefId != null) || (this.soefId != null && !this.soefId.equals(other.soefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaObjEFormulario[ soefId=" + soefId + " ]";
    }
    
}
