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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZTAINCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztainco.findAll", query = "SELECT s FROM Sztainco s"),
    @NamedQuery(name = "Sztainco.findBySztaincoCode", query = "SELECT s FROM Sztainco s WHERE s.sztaincoCode = :sztaincoCode")})
public class Sztainco implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZTAINCO", sequenceName = "SEQ_SZTAINCO", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZTAINCO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAINCO_CODE")
    private BigDecimal sztaincoCode;
    @JoinColumn(name = "SZTAAINV_CODE", referencedColumnName = "SZTAAINV_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sztaainv sztaainvCode;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;

    public Sztainco() {
    }

    public Sztainco(BigDecimal sztaincoCode) {
        this.sztaincoCode = sztaincoCode;
    }

    public BigDecimal getSztaincoCode() {
        return sztaincoCode;
    }

    public void setSztaincoCode(BigDecimal sztaincoCode) {
        this.sztaincoCode = sztaincoCode;
    }

    public Sztaainv getSztaainvCode() {
        return sztaainvCode;
    }

    public void setSztaainvCode(Sztaainv sztaainvCode) {
        this.sztaainvCode = sztaainvCode;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztaincoCode != null ? sztaincoCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztainco)) {
            return false;
        }
        Sztainco other = (Sztainco) object;
        if ((this.sztaincoCode == null && other.sztaincoCode != null) || (this.sztaincoCode != null && !this.sztaincoCode.equals(other.sztaincoCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztainco[ sztaincoCode=" + sztaincoCode + " ]";
    }
    
}
