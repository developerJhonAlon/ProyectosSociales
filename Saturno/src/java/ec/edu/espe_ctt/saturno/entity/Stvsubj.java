/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "STVSUBJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stvsubj.findAll", query = "SELECT s FROM Stvsubj s"),
    @NamedQuery(name = "Stvsubj.findByStvsubjCode", query = "SELECT s FROM Stvsubj s WHERE s.stvsubjCode = :stvsubjCode"),
    @NamedQuery(name = "Stvsubj.findByStvsubjDesc", query = "SELECT s FROM Stvsubj s WHERE s.stvsubjDesc = :stvsubjDesc"),
    @NamedQuery(name = "Stvsubj.findByStvsubjActivityDate", query = "SELECT s FROM Stvsubj s WHERE s.stvsubjActivityDate = :stvsubjActivityDate"),
    @NamedQuery(name = "Stvsubj.findByStvsubjVrMsgNo", query = "SELECT s FROM Stvsubj s WHERE s.stvsubjVrMsgNo = :stvsubjVrMsgNo"),
    @NamedQuery(name = "Stvsubj.findByStvsubjDispWebInd", query = "SELECT s FROM Stvsubj s WHERE s.stvsubjDispWebInd = :stvsubjDispWebInd")})
public class Stvsubj implements Serializable, Comparable<Stvsubj> {

    private static final long serialVersionUID = 1L;
    @Id
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
    @Column(name = "STVSUBJ_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stvsubjActivityDate;
    @Column(name = "STVSUBJ_VR_MSG_NO")
    private Integer stvsubjVrMsgNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STVSUBJ_DISP_WEB_IND")
    private String stvsubjDispWebInd;

    public Stvsubj() {
    }

    public Stvsubj(String stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public Stvsubj(String id, String descripcion) {
        this.stvsubjCode = id;
        this.stvsubjDesc = descripcion;
    }

    public Stvsubj(String stvsubjCode, Date stvsubjActivityDate, String stvsubjDispWebInd) {
        this.stvsubjCode = stvsubjCode;
        this.stvsubjActivityDate = stvsubjActivityDate;
        this.stvsubjDispWebInd = stvsubjDispWebInd;
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

    public Date getStvsubjActivityDate() {
        return stvsubjActivityDate;
    }

    public void setStvsubjActivityDate(Date stvsubjActivityDate) {
        this.stvsubjActivityDate = stvsubjActivityDate;
    }

    public Integer getStvsubjVrMsgNo() {
        return stvsubjVrMsgNo;
    }

    public void setStvsubjVrMsgNo(Integer stvsubjVrMsgNo) {
        this.stvsubjVrMsgNo = stvsubjVrMsgNo;
    }

    public String getStvsubjDispWebInd() {
        return stvsubjDispWebInd;
    }

    public void setStvsubjDispWebInd(String stvsubjDispWebInd) {
        this.stvsubjDispWebInd = stvsubjDispWebInd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stvsubjCode != null ? stvsubjCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stvsubj)) {
            return false;
        }
        Stvsubj other = (Stvsubj) object;
        if ((this.stvsubjCode == null && other.stvsubjCode != null) || (this.stvsubjCode != null && !this.stvsubjCode.equals(other.stvsubjCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Stvsubj[ stvsubjCode=" + stvsubjCode + " ]";
    }

    @Transient
    private Stvcamp campus;

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    @Override
    public int compareTo(Stvsubj o) {
        if (this.stvsubjDesc != null) {
            return this.stvsubjDesc.compareTo(o.stvsubjDesc);
        }
        return 0;
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
