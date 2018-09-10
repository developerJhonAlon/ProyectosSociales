/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "V_DOCENTE_DEPTO_B")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VDocenteDeptoB.findAll", query = "SELECT v FROM VDocenteDeptoB v"),
    @NamedQuery(name = "VDocenteDeptoB.findById", query = "SELECT v FROM VDocenteDeptoB v WHERE v.id = :id"),
    @NamedQuery(name = "VDocenteDeptoB.findByUsuId", query = "SELECT v FROM VDocenteDeptoB v WHERE v.usuId = :usuId"),
    @NamedQuery(name = "VDocenteDeptoB.findByUsuNombres", query = "SELECT v FROM VDocenteDeptoB v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VDocenteDeptoB.findByUsuApellidos", query = "SELECT v FROM VDocenteDeptoB v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VDocenteDeptoB.findByPebemplCollCode", query = "SELECT v FROM VDocenteDeptoB v WHERE v.pebemplCollCode = :pebemplCollCode"),
    @NamedQuery(name = "VDocenteDeptoB.findByStvcollDesc", query = "SELECT v FROM VDocenteDeptoB v WHERE v.stvcollDesc = :stvcollDesc"),
    @NamedQuery(name = "VDocenteDeptoB.findByStvsubjCode", query = "SELECT v FROM VDocenteDeptoB v WHERE v.stvsubjCode = :stvsubjCode"),
    @NamedQuery(name = "VDocenteDeptoB.findByStvsubjDesc", query = "SELECT v FROM VDocenteDeptoB v WHERE v.stvsubjDesc = :stvsubjDesc"),
    @NamedQuery(name = "VDocenteDeptoB.findByStvcampCode", query = "SELECT v FROM VDocenteDeptoB v WHERE v.stvcampCode = :stvcampCode"),
    @NamedQuery(name = "VDocenteDeptoB.findByStvcampDesc", query = "SELECT v FROM VDocenteDeptoB v WHERE v.stvcampDesc = :stvcampDesc")})
public class VDocenteDeptoB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private BigInteger id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_NOMBRES")
    private String usuNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_APELLIDOS")
    private String usuApellidos;
    @Size(max = 2)
    @Column(name = "PEBEMPL_COLL_CODE")
    private String pebemplCollCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVCOLL_DESC")
    private String stvcollDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVSUBJ_CODE")
    private String stvsubjCode;
    @Size(max = 30)
    @Column(name = "STVSUBJ_DESC")
    private String stvsubjDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STVCAMP_CODE")
    private String stvcampCode;
    @Size(max = 30)
    @Column(name = "STVCAMP_DESC")
    private String stvcampDesc;

    public VDocenteDeptoB() {
    }

    public VDocenteDeptoB(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public VDocenteDeptoB(BigDecimal usuId, String usuNombres, String usuApellidos, String stvcollDesc, String stvsubjCode, String stvcampCode) {
        this.usuId = usuId;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.stvcollDesc = stvcollDesc;
        this.stvsubjCode = stvsubjCode;
        this.stvcampCode = stvcampCode;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getPebemplCollCode() {
        return pebemplCollCode;
    }

    public void setPebemplCollCode(String pebemplCollCode) {
        this.pebemplCollCode = pebemplCollCode;
    }

    public String getStvcollDesc() {
        return stvcollDesc;
    }

    public void setStvcollDesc(String stvcollDesc) {
        this.stvcollDesc = stvcollDesc;
    }

    public String getStvsubjCode() {
        return stvsubjCode;
    }

    public void setStvsubjCode(String stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public String getStvsubjDesc() {
        return stvsubjDesc;
    }

    public void setStvsubjDesc(String stvsubjDesc) {
        this.stvsubjDesc = stvsubjDesc;
    }

    public String getStvcampCode() {
        return stvcampCode;
    }

    public void setStvcampCode(String stvcampCode) {
        this.stvcampCode = stvcampCode;
    }

    public String getStvcampDesc() {
        return stvcampDesc;
    }

    public void setStvcampDesc(String stvcampDesc) {
        this.stvcampDesc = stvcampDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VDocenteDeptoB)) {
            return false;
        }
        VDocenteDeptoB other = (VDocenteDeptoB) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB[ usuId=" + usuId + " ]";
    }
    
}
