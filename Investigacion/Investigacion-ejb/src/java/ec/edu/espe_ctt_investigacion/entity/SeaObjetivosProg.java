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
 * @author PC1
 */
@Entity
@Table(name = "SEA_OBJETIVOS_PROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjetivosProg.findAll", query = "SELECT s FROM SeaObjetivosProg s"),
    @NamedQuery(name = "SeaObjetivosProg.findByObjprogId", query = "SELECT s FROM SeaObjetivosProg s WHERE s.objprogId = :objprogId"),
    @NamedQuery(name = "SeaObjetivosProg.findByObjprogObjetivo", query = "SELECT s FROM SeaObjetivosProg s WHERE s.objprogObjetivo = :objprogObjetivo"),
    @NamedQuery(name = "SeaObjetivosProg.findByObjprogOrden", query = "SELECT s FROM SeaObjetivosProg s WHERE s.objprogOrden = :objprogOrden")})
public class SeaObjetivosProg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJETIVOS_PROG", sequenceName = "SEQ_SEA_OBJETIVOS_PROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJETIVOS_PROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBJPROG_ID")
    private BigDecimal objprogId;
    @Size(max = 500)
    @Column(name = "OBJPROG_OBJETIVO")
    private String objprogObjetivo;
    @Column(name = "OBJPROG_ORDEN")
    private BigInteger objprogOrden;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;

    public SeaObjetivosProg() {
    }

    public SeaObjetivosProg(BigDecimal objprogId) {
        this.objprogId = objprogId;
    }

    public BigDecimal getObjprogId() {
        return objprogId;
    }

    public void setObjprogId(BigDecimal objprogId) {
        this.objprogId = objprogId;
    }

    public String getObjprogObjetivo() {
        return objprogObjetivo;
    }

    public void setObjprogObjetivo(String objprogObjetivo) {
        this.objprogObjetivo = objprogObjetivo;
    }

    public BigInteger getObjprogOrden() {
        return objprogOrden;
    }

    public void setObjprogOrden(BigInteger objprogOrden) {
        this.objprogOrden = objprogOrden;
    }

    public SeaDatGeneralProg getDatgeprogId() {
        return datgeprogId;
    }

    public void setDatgeprogId(SeaDatGeneralProg datgeprogId) {
        this.datgeprogId = datgeprogId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objprogId != null ? objprogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjetivosProg)) {
            return false;
        }
        SeaObjetivosProg other = (SeaObjetivosProg) object;
        if ((this.objprogId == null && other.objprogId != null) || (this.objprogId != null && !this.objprogId.equals(other.objprogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaObjetivosProg[ objprogId=" + objprogId + " ]";
    }
    
}
