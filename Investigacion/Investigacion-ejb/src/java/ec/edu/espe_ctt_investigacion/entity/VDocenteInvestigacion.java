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
@Table(name = "V_DOCENTE_INVESTIGACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VDocenteInvestigacion.findAll", query = "SELECT v FROM VDocenteInvestigacion v"),
    @NamedQuery(name = "VDocenteInvestigacion.findByCod", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.cod = :cod"),
    @NamedQuery(name = "VDocenteInvestigacion.findByUsuId", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.usuId = :usuId"),
    @NamedQuery(name = "VDocenteInvestigacion.findBySibinstPidm", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.sibinstPidm = :sibinstPidm"),
    @NamedQuery(name = "VDocenteInvestigacion.findByUsuNombres", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VDocenteInvestigacion.findByUsuApellidos", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VDocenteInvestigacion.findByStvfcstDesc", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.stvfcstDesc = :stvfcstDesc"),
    @NamedQuery(name = "VDocenteInvestigacion.findByPeriodo", query = "SELECT v FROM VDocenteInvestigacion v WHERE v.periodo = :periodo")})
public class VDocenteInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "COD")
    private BigInteger cod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIBINST_PIDM")
    private int sibinstPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_NOMBRES")
    private String usuNombres;
    @Column(name = "USU_CC")
    private String usuCc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_APELLIDOS")
    private String usuApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVFCST_DESC")
    private String stvfcstDesc;
    @Size(max = 6)
    @Column(name = "PERIODO")
    private String periodo;

    public VDocenteInvestigacion() {
    }

    public VDocenteInvestigacion(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public VDocenteInvestigacion(BigDecimal usuId, int sibinstPidm, String usuNombres, String usuApellidos, String stvfcstDesc) {
        this.usuId = usuId;
        this.sibinstPidm = sibinstPidm;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.stvfcstDesc = stvfcstDesc;
    }

    public BigInteger getCod() {
        return cod;
    }

    public void setCod(BigInteger cod) {
        this.cod = cod;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public int getSibinstPidm() {
        return sibinstPidm;
    }

    public void setSibinstPidm(int sibinstPidm) {
        this.sibinstPidm = sibinstPidm;
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

    public String getStvfcstDesc() {
        return stvfcstDesc;
    }

    public void setStvfcstDesc(String stvfcstDesc) {
        this.stvfcstDesc = stvfcstDesc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUsuCc() {
        return usuCc;
    }

    public void setUsuCc(String usuCc) {
        this.usuCc = usuCc;
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
        if (!(object instanceof VDocenteInvestigacion)) {
            return false;
        }
        VDocenteInvestigacion other = (VDocenteInvestigacion) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion[ usuId=" + usuId + " ]";
    }

    
}
