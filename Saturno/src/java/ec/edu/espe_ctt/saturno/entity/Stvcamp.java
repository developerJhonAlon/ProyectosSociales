/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "STVCAMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvcamp.findAll", query = "SELECT s FROM Stvcamp s"),
    @NamedQuery(name = "Stvcamp.findByStvcampCode", query = "SELECT s FROM Stvcamp s WHERE s.stvcampCode = :stvcampCode"),
    @NamedQuery(name = "Stvcamp.findByStvcampDesc", query = "SELECT s FROM Stvcamp s WHERE s.stvcampDesc = :stvcampDesc"),
    @NamedQuery(name = "Stvcamp.findByStvcampActivityDate", query = "SELECT s FROM Stvcamp s WHERE s.stvcampActivityDate = :stvcampActivityDate"),
    @NamedQuery(name = "Stvcamp.findByStvcampDicdCode", query = "SELECT s FROM Stvcamp s WHERE s.stvcampDicdCode = :stvcampDicdCode")})
public class Stvcamp implements Serializable, Comparable<Stvcamp> {

    private static final long serialVersionUID = 1L;
    @Id
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
    @Column(name = "STVCAMP_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvcampActivityDate;
    @Size(max = 3)
    @Column(name = "STVCAMP_DICD_CODE")
    private String stvcampDicdCode;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sfrstcrCampCode")
    private List<Sfrstcr> sfrstcrList;

    public Stvcamp() {
    }

    public Stvcamp(String stvcampCode) {
        this.stvcampCode = stvcampCode;
    }

    public Stvcamp(String id, String descripcion) {
        this.stvcampCode = id;
        this.stvcampDesc = descripcion;
    }

    public Stvcamp(String stvcampCode, Date stvcampActivityDate) {
        this.stvcampCode = stvcampCode;
        this.stvcampActivityDate = stvcampActivityDate;
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

    public Date getStvcampActivityDate() {
        return stvcampActivityDate;
    }

    public void setStvcampActivityDate(Date stvcampActivityDate) {
        this.stvcampActivityDate = stvcampActivityDate;
    }

    public String getStvcampDicdCode() {
        return stvcampDicdCode;
    }

    public void setStvcampDicdCode(String stvcampDicdCode) {
        this.stvcampDicdCode = stvcampDicdCode;
    }

    @XmlTransient
    public List<Sfrstcr> getSfrstcrList() {
        return sfrstcrList;
    }

    public void setSfrstcrList(List<Sfrstcr> sfrstcrList) {
        this.sfrstcrList = sfrstcrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvcampCode != null ? stvcampCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvcamp)) {
            return false;
        }
        Stvcamp other = (Stvcamp) object;
        if ((this.stvcampCode == null && other.stvcampCode != null) || (this.stvcampCode != null && !this.stvcampCode.equals(other.stvcampCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvcamp[ stvcampCode=" + stvcampCode + " ]";
    }

    @Override
    public int compareTo(Stvcamp o) {
        return this.stvcampDesc.compareTo(o.stvcampDesc);
    }

    @Transient
    private List<Stvsubj> departamentoList = new ArrayList<>();

    public List<Stvsubj> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Stvsubj> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public void addDepartamento(Stvsubj dep) {
        if (departamentoList == null) {
            departamentoList = new ArrayList<>();
        }
        departamentoList.add(dep);
    }

    @Transient
    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
