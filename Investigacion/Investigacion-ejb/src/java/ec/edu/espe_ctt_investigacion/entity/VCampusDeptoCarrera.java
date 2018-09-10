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
@Table(name = "V_CAMPUS_DEPTO_CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VCampusDeptoCarrera.findAll", query = "SELECT v FROM VCampusDeptoCarrera v"),
    @NamedQuery(name = "VCampusDeptoCarrera.findById", query = "SELECT v FROM VCampusDeptoCarrera v WHERE v.id = :id"),
    @NamedQuery(name = "VCampusDeptoCarrera.findByStvcampCode", query = "SELECT v FROM VCampusDeptoCarrera v WHERE v.stvcampCode = :stvcampCode"),
    @NamedQuery(name = "VCampusDeptoCarrera.findByStvcampDesc", query = "SELECT v FROM VCampusDeptoCarrera v WHERE v.stvcampDesc = :stvcampDesc"),
    @NamedQuery(name = "VCampusDeptoCarrera.findByStvsubjCode", query = "SELECT v FROM VCampusDeptoCarrera v WHERE v.stvsubjCode = :stvsubjCode"),
    @NamedQuery(name = "VCampusDeptoCarrera.findByStvsubjDesc", query = "SELECT v FROM VCampusDeptoCarrera v WHERE v.stvsubjDesc = :stvsubjDesc")})
public class VCampusDeptoCarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STVCAMP_CODE")
    private String stvcampCode;
    @Size(max = 30)
    @Column(name = "STVCAMP_DESC")
    private String stvcampDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVSUBJ_CODE")
    private String stvsubjCode;
    @Size(max = 30)
    @Column(name = "STVSUBJ_DESC")
    private String stvsubjDesc;

    public VCampusDeptoCarrera() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
    
}
