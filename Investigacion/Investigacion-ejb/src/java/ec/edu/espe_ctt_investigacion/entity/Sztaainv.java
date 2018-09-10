/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZTAAINV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztaainv.findAll", query = "SELECT s FROM Sztaainv s"),
    @NamedQuery(name = "Sztaainv.findBySztaainvCode", query = "SELECT s FROM Sztaainv s WHERE s.sztaainvCode = :sztaainvCode"),
    @NamedQuery(name = "Sztaainv.findBySztaainvDescripcion", query = "SELECT s FROM Sztaainv s WHERE s.sztaainvDescripcion = :sztaainvDescripcion")})
public class Sztaainv implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAAINV_CODE")
    private BigDecimal sztaainvCode;
    @Size(max = 250)
    @Column(name = "SZTAAINV_DESCRIPCION")
    private String sztaainvDescripcion;
    @OneToMany(mappedBy = "sztaainvCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sztainco> sztaincoList;

    public Sztaainv() {
    }

    public Sztaainv(BigDecimal sztaainvCode) {
        this.sztaainvCode = sztaainvCode;
    }

    public BigDecimal getSztaainvCode() {
        return sztaainvCode;
    }

    public void setSztaainvCode(BigDecimal sztaainvCode) {
        this.sztaainvCode = sztaainvCode;
    }

    public String getSztaainvDescripcion() {
        return sztaainvDescripcion;
    }

    public void setSztaainvDescripcion(String sztaainvDescripcion) {
        this.sztaainvDescripcion = sztaainvDescripcion;
    }

    @XmlTransient
    public List<Sztainco> getSztaincoList() {
        return sztaincoList;
    }

    public void setSztaincoList(List<Sztainco> sztaincoList) {
        this.sztaincoList = sztaincoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztaainvCode != null ? sztaainvCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztaainv)) {
            return false;
        }
        Sztaainv other = (Sztaainv) object;
        if ((this.sztaainvCode == null && other.sztaainvCode != null) || (this.sztaainvCode != null && !this.sztaainvCode.equals(other.sztaainvCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztaainv[ sztaainvCode=" + sztaainvCode + " ]";
    }
    
}
