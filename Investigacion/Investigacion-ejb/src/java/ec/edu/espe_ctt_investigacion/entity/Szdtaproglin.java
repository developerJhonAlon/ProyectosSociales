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
@Table(name = "SZDTAPROGLIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtaproglin.findAll", query = "SELECT s FROM Szdtaproglin s"),
    @NamedQuery(name = "Szdtaproglin.findBySzdtaproglinCode", query = "SELECT s FROM Szdtaproglin s WHERE s.szdtaproglinCode = :szdtaproglinCode")})
public class Szdtaproglin implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAPROGLIN", sequenceName = "SEQ_SZDTAPROGLIN", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAPROGLIN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAPROGLIN_CODE")
    private BigDecimal szdtaproglinCode;
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaId;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;

    public Szdtaproglin() {
    }

    public Szdtaproglin(BigDecimal szdtaproglinCode) {
        this.szdtaproglinCode = szdtaproglinCode;
    }

    public BigDecimal getSzdtaproglinCode() {
        return szdtaproglinCode;
    }

    public void setSzdtaproglinCode(BigDecimal szdtaproglinCode) {
        this.szdtaproglinCode = szdtaproglinCode;
    }

    public SeaLineainves getLineaId() {
        return lineaId;
    }

    public void setLineaId(SeaLineainves lineaId) {
        this.lineaId = lineaId;
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
        hash += (szdtaproglinCode != null ? szdtaproglinCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtaproglin)) {
            return false;
        }
        Szdtaproglin other = (Szdtaproglin) object;
        if ((this.szdtaproglinCode == null && other.szdtaproglinCode != null) || (this.szdtaproglinCode != null && !this.szdtaproglinCode.equals(other.szdtaproglinCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtaproglin[ szdtaproglinCode=" + szdtaproglinCode + " ]";
    }
    
}
