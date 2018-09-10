/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
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
 * @author PC1
 */
@Entity
@Table(name = "V_RESPONSABLES_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VResponsablesProyecto.findAll", query = "SELECT v FROM VResponsablesProyecto v"),
    @NamedQuery(name = "VResponsablesProyecto.findById", query = "SELECT v FROM VResponsablesProyecto v WHERE v.id = :id"),
    @NamedQuery(name = "VResponsablesProyecto.findByUsuId", query = "SELECT v FROM VResponsablesProyecto v WHERE v.usuId = :usuId"),
    @NamedQuery(name = "VResponsablesProyecto.findByDatgeproyId", query = "SELECT v FROM VResponsablesProyecto v WHERE v.datgeproyId = :datgeproyId"),
    @NamedQuery(name = "VResponsablesProyecto.findByUsuNombres", query = "SELECT v FROM VResponsablesProyecto v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VResponsablesProyecto.findByUsuApellidos", query = "SELECT v FROM VResponsablesProyecto v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VResponsablesProyecto.findBySpridenPidm", query = "SELECT v FROM VResponsablesProyecto v WHERE v.spridenPidm = :spridenPidm"),
    @NamedQuery(name = "VResponsablesProyecto.findByTipresDescrip", query = "SELECT v FROM VResponsablesProyecto v WHERE v.tipresDescrip = :tipresDescrip")})
public class VResponsablesProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigInteger usuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATGEPROY_ID")
    private BigInteger datgeproyId;
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
    @Size(max = 250)
    @Column(name = "TIPRES_DESCRIP")
    private String tipresDescrip;

    public VResponsablesProyecto() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUsuId() {
        return usuId;
    }

    public void setUsuId(BigInteger usuId) {
        this.usuId = usuId;
    }

    public BigInteger getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(BigInteger datgeproyId) {
        this.datgeproyId = datgeproyId;
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

    public String getTipresDescrip() {
        return tipresDescrip;
    }

    public void setTipresDescrip(String tipresDescrip) {
        this.tipresDescrip = tipresDescrip;
    }
    
}
