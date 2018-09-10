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
@Table(name = "V_DIRECTORES_DEPTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VDirectoresDepto.findAll", query = "SELECT v FROM VDirectoresDepto v"),
    @NamedQuery(name = "VDirectoresDepto.findById", query = "SELECT v FROM VDirectoresDepto v WHERE v.id = :id"),
    @NamedQuery(name = "VDirectoresDepto.findByUsuNombres", query = "SELECT v FROM VDirectoresDepto v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VDirectoresDepto.findByUsuApellidos", query = "SELECT v FROM VDirectoresDepto v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VDirectoresDepto.findBySpridenPidm", query = "SELECT v FROM VDirectoresDepto v WHERE v.spridenPidm = :spridenPidm"),
    @NamedQuery(name = "VDirectoresDepto.findByUsuId", query = "SELECT v FROM VDirectoresDepto v WHERE v.usuId = :usuId"),
    @NamedQuery(name = "VDirectoresDepto.findByStvsubjDesc", query = "SELECT v FROM VDirectoresDepto v WHERE v.stvsubjDesc = :stvsubjDesc"),
    @NamedQuery(name = "VDirectoresDepto.findBySibinstFstpCode", query = "SELECT v FROM VDirectoresDepto v WHERE v.sibinstFstpCode = :sibinstFstpCode"),
    @NamedQuery(name = "VDirectoresDepto.findBySibinstFcstCode", query = "SELECT v FROM VDirectoresDepto v WHERE v.sibinstFcstCode = :sibinstFcstCode"),
    @NamedQuery(name = "VDirectoresDepto.findBySibinstTermCodeEff", query = "SELECT v FROM VDirectoresDepto v WHERE v.sibinstTermCodeEff = :sibinstTermCodeEff"),
    @NamedQuery(name = "VDirectoresDepto.findByStvsubjCode", query = "SELECT v FROM VDirectoresDepto v WHERE v.stvsubjCode = :stvsubjCode"),
    @NamedQuery(name = "VDirectoresDepto.findByStvfstpDesc", query = "SELECT v FROM VDirectoresDepto v WHERE v.stvfstpDesc = :stvfstpDesc")})
public class VDirectoresDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private BigInteger id;
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
    @Column(name = "SPRIDEN_PIDM")
    private Integer spridenPidm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Size(max = 30)
    @Column(name = "STVSUBJ_DESC")
    private String stvsubjDesc;
    @Size(max = 4)
    @Column(name = "SIBINST_FSTP_CODE")
    private String sibinstFstpCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SIBINST_FCST_CODE")
    private String sibinstFcstCode;
    @Size(max = 6)
    @Column(name = "SIBINST_TERM_CODE_EFF")
    private String sibinstTermCodeEff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVSUBJ_CODE")
    private String stvsubjCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVFSTP_DESC")
    private String stvfstpDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVCAMP_CODE")
    private String campusId;
    

    public VDirectoresDepto() {
    }

    public VDirectoresDepto(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public VDirectoresDepto(BigDecimal usuId, String usuNombres, String usuApellidos, String sibinstFcstCode, String stvsubjCode, String stvfstpDesc) {
        this.usuId = usuId;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.sibinstFcstCode = sibinstFcstCode;
        this.stvsubjCode = stvsubjCode;
        this.stvfstpDesc = stvfstpDesc;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public Integer getSpridenPidm() {
        return spridenPidm;
    }

    public void setSpridenPidm(Integer spridenPidm) {
        this.spridenPidm = spridenPidm;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public String getStvsubjDesc() {
        return stvsubjDesc;
    }

    public void setStvsubjDesc(String stvsubjDesc) {
        this.stvsubjDesc = stvsubjDesc;
    }

    public String getSibinstFstpCode() {
        return sibinstFstpCode;
    }

    public void setSibinstFstpCode(String sibinstFstpCode) {
        this.sibinstFstpCode = sibinstFstpCode;
    }

    public String getSibinstFcstCode() {
        return sibinstFcstCode;
    }

    public void setSibinstFcstCode(String sibinstFcstCode) {
        this.sibinstFcstCode = sibinstFcstCode;
    }

    public String getSibinstTermCodeEff() {
        return sibinstTermCodeEff;
    }

    public void setSibinstTermCodeEff(String sibinstTermCodeEff) {
        this.sibinstTermCodeEff = sibinstTermCodeEff;
    }

    public String getStvsubjCode() {
        return stvsubjCode;
    }

    public void setStvsubjCode(String stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public String getStvfstpDesc() {
        return stvfstpDesc;
    }

    public void setStvfstpDesc(String stvfstpDesc) {
        this.stvfstpDesc = stvfstpDesc;
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
        if (!(object instanceof VDirectoresDepto)) {
            return false;
        }
        VDirectoresDepto other = (VDirectoresDepto) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto[ usuId=" + usuId + " ]";
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

}
