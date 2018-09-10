/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZTAPOLOBJBV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztapolobjbv.findAll", query = "SELECT s FROM Sztapolobjbv s"),
    @NamedQuery(name = "Sztapolobjbv.findBySztapolobjbvCode", query = "SELECT s FROM Sztapolobjbv s WHERE s.sztapolobjbvCode = :sztapolobjbvCode"),
    @NamedQuery(name = "Sztapolobjbv.findBySztapolobjbvDescrip", query = "SELECT s FROM Sztapolobjbv s WHERE s.sztapolobjbvDescrip = :sztapolobjbvDescrip")})
public class Sztapolobjbv implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZTAPOLOBJBV", sequenceName = "SEQ_SZTAPOLOBJBV", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZTAPOLOBJBV")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAPOLOBJBV_CODE")
    private BigDecimal sztapolobjbvCode;
    @Size(max = 500)
    @Column(name = "SZTAPOLOBJBV_DESCRIP")
    private String sztapolobjbvDescrip;
    @JoinColumn(name = "SZTAOBJBVPR_CODE", referencedColumnName = "SZTAOBJBVPR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sztaobjbvpr sztaobjbvprCode;

    public Sztapolobjbv() {
    }

    public Sztapolobjbv(BigDecimal sztapolobjbvCode) {
        this.sztapolobjbvCode = sztapolobjbvCode;
    }

    public BigDecimal getSztapolobjbvCode() {
        return sztapolobjbvCode;
    }

    public void setSztapolobjbvCode(BigDecimal sztapolobjbvCode) {
        this.sztapolobjbvCode = sztapolobjbvCode;
    }

    public String getSztapolobjbvDescrip() {
        return sztapolobjbvDescrip;
    }

    public void setSztapolobjbvDescrip(String sztapolobjbvDescrip) {
        this.sztapolobjbvDescrip = sztapolobjbvDescrip;
    }

    public Sztaobjbvpr getSztaobjbvprCode() {
        return sztaobjbvprCode;
    }

    public void setSztaobjbvprCode(Sztaobjbvpr sztaobjbvprCode) {
        this.sztaobjbvprCode = sztaobjbvprCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztapolobjbvCode != null ? sztapolobjbvCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztapolobjbv)) {
            return false;
        }
        Sztapolobjbv other = (Sztapolobjbv) object;
        if ((this.sztapolobjbvCode == null && other.sztapolobjbvCode != null) || (this.sztapolobjbvCode != null && !this.sztapolobjbvCode.equals(other.sztapolobjbvCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztapolobjbv[ sztapolobjbvCode=" + sztapolobjbvCode + " ]";
    }
    
}
