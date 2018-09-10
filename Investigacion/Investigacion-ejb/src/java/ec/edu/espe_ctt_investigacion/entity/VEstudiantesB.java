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
 * @author Administrador
 */
@Entity
@Table(name = "V_ESTUDIANTES_B")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEstudiantesB.findAll", query = "SELECT v FROM VEstudiantesB v"),
    @NamedQuery(name = "VEstudiantesB.findById", query = "SELECT v FROM VEstudiantesB v WHERE v.id = :id"),
    @NamedQuery(name = "VEstudiantesB.findBySfrstcrPidm", query = "SELECT v FROM VEstudiantesB v WHERE v.sfrstcrPidm = :sfrstcrPidm"),
    @NamedQuery(name = "VEstudiantesB.findByUsuCc", query = "SELECT v FROM VEstudiantesB v WHERE v.usuCc = :usuCc"),
    @NamedQuery(name = "VEstudiantesB.findBySpbpersSsn", query = "SELECT v FROM VEstudiantesB v WHERE v.spbpersSsn = :spbpersSsn"),
    @NamedQuery(name = "VEstudiantesB.findByUsuNombres", query = "SELECT v FROM VEstudiantesB v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VEstudiantesB.findByUsuApellidos", query = "SELECT v FROM VEstudiantesB v WHERE v.usuApellidos = :usuApellidos")})
public class VEstudiantesB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFRSTCR_PIDM")
    private int sfrstcrPidm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_CC")
    private String usuCc;
    @Size(max = 15)
    @Column(name = "SPBPERS_SSN")
    private String spbpersSsn;
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

    public VEstudiantesB() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getSfrstcrPidm() {
        return sfrstcrPidm;
    }

    public void setSfrstcrPidm(int sfrstcrPidm) {
        this.sfrstcrPidm = sfrstcrPidm;
    }

    public String getUsuCc() {
        return usuCc;
    }

    public void setUsuCc(String usuCc) {
        this.usuCc = usuCc;
    }

    public String getSpbpersSsn() {
        return spbpersSsn;
    }

    public void setSpbpersSsn(String spbpersSsn) {
        this.spbpersSsn = spbpersSsn;
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
    
}
