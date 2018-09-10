/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEG_SISTEMAS",schema = "SISEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegSistemas.findAll", query = "SELECT s FROM SegSistemas s"),
    @NamedQuery(name = "SegSistemas.findBySisId", query = "SELECT s FROM SegSistemas s WHERE s.sisId = :sisId"),
    @NamedQuery(name = "SegSistemas.findBySisNombre", query = "SELECT s FROM SegSistemas s WHERE s.sisNombre = :sisNombre"),
    @NamedQuery(name = "SegSistemas.findBySisUrlSistema", query = "SELECT s FROM SegSistemas s WHERE s.sisUrlSistema = :sisUrlSistema")})
public class SegSistemas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEG_SISTEMAS", sequenceName = "SEQ_SEG_SISTEMAS", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_SISTEMAS")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIS_ID")
    private BigDecimal sisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SIS_NOMBRE")
    private String sisNombre;
    @Size(max = 255)
    @Column(name = "SIS_URL_SISTEMA")
    private String sisUrlSistema;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segSistemas")
//    private List<SegOpcion> segOpcionList;
//    @OneToMany(mappedBy = "segSistemas")
//    private List<SegPerfil> segPerfilList;

    public SegSistemas() {
    }

    public SegSistemas(BigDecimal sisId) {
        this.sisId = sisId;
    }

    public SegSistemas(BigDecimal sisId, String sisNombre) {
        this.sisId = sisId;
        this.sisNombre = sisNombre;
    }

    public BigDecimal getSisId() {
        return sisId;
    }

    public void setSisId(BigDecimal sisId) {
        this.sisId = sisId;
    }

    public String getSisNombre() {
        return sisNombre;
    }

    public void setSisNombre(String sisNombre) {
        this.sisNombre = sisNombre;
    }

    public String getSisUrlSistema() {
        return sisUrlSistema;
    }

    public void setSisUrlSistema(String sisUrlSistema) {
        this.sisUrlSistema = sisUrlSistema;
    }

//    @XmlTransient
//    public List<SegOpcion> getSegOpcionList() {
//        return segOpcionList;
//    }
//
//    public void setSegOpcionList(List<SegOpcion> segOpcionList) {
//        this.segOpcionList = segOpcionList;
//    }
//
//    @XmlTransient
//    public List<SegPerfil> getSegPerfilList() {
//        return segPerfilList;
//    }
//
//    public void setSegPerfilList(List<SegPerfil> segPerfilList) {
//        this.segPerfilList = segPerfilList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisId != null ? sisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegSistemas)) {
            return false;
        }
        SegSistemas other = (SegSistemas) object;
        if ((this.sisId == null && other.sisId != null) || (this.sisId != null && !this.sisId.equals(other.sisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegSistemas[ sisId=" + sisId + " ]";
    }
    
}
