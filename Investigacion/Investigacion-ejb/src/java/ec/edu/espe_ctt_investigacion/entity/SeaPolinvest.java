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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "SEA_POLINVEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaPolinvest.findAll", query = "SELECT s FROM SeaPolinvest s"),
    @NamedQuery(name = "SeaPolinvest.findByPolinvId", query = "SELECT s FROM SeaPolinvest s WHERE s.polinvId = :polinvId"),
    @NamedQuery(name = "SeaPolinvest.findByPolinvNombre", query = "SELECT s FROM SeaPolinvest s WHERE s.polinvNombre = :polinvNombre"),
    @NamedQuery(name = "SeaPolinvest.findByPolinvAmbito", query = "SELECT s FROM SeaPolinvest s WHERE s.polinvAmbito = :polinvAmbito"),
    @NamedQuery(name = "SeaPolinvest.findByPolinvDescrip", query = "SELECT s FROM SeaPolinvest s WHERE s.polinvDescrip = :polinvDescrip")})
public class SeaPolinvest implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_POLINVEST", sequenceName = "SEQ_SEA_POLINVEST", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_POLINVEST")
    @Basic(optional = false)
    @NotNull
    @Column(name = "POLINV_ID")
    private BigDecimal polinvId;
    @Size(max = 1000)
    @Column(name = "POLINV_NOMBRE")
    private String polinvNombre;
    @Size(max = 1000)
    @Column(name = "POLINV_AMBITO")
    private String polinvAmbito;
    @Size(max = 1000)
    @Column(name = "POLINV_DESCRIP")
    private String polinvDescrip;

    public SeaPolinvest() {
    }

    public SeaPolinvest(BigDecimal polinvId) {
        this.polinvId = polinvId;
    }

    public BigDecimal getPolinvId() {
        return polinvId;
    }

    public void setPolinvId(BigDecimal polinvId) {
        this.polinvId = polinvId;
    }

    public String getPolinvNombre() {
        return polinvNombre;
    }

    public void setPolinvNombre(String polinvNombre) {
        this.polinvNombre = polinvNombre;
    }

    public String getPolinvAmbito() {
        return polinvAmbito;
    }

    public void setPolinvAmbito(String polinvAmbito) {
        this.polinvAmbito = polinvAmbito;
    }

    public String getPolinvDescrip() {
        return polinvDescrip;
    }

    public void setPolinvDescrip(String polinvDescrip) {
        this.polinvDescrip = polinvDescrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polinvId != null ? polinvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaPolinvest)) {
            return false;
        }
        SeaPolinvest other = (SeaPolinvest) object;
        if ((this.polinvId == null && other.polinvId != null) || (this.polinvId != null && !this.polinvId.equals(other.polinvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaPolinvest[ polinvId=" + polinvId + " ]";
    }
    
}
