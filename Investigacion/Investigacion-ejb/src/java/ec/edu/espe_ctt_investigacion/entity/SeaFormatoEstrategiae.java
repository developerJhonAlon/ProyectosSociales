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
import javax.persistence.Lob;
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
@Table(name = "SEA_FORMATO_ESTRATEGIAE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFormatoEstrategiae.findAll", query = "SELECT s FROM SeaFormatoEstrategiae s"),
    @NamedQuery(name = "SeaFormatoEstrategiae.findBySfeId", query = "SELECT s FROM SeaFormatoEstrategiae s WHERE s.sfeId = :sfeId"),
    @NamedQuery(name = "SeaFormatoEstrategiae.findBySfeNombreArchivo", query = "SELECT s FROM SeaFormatoEstrategiae s WHERE s.sfeNombreArchivo = :sfeNombreArchivo")})
public class SeaFormatoEstrategiae implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_ESTRATEGIAE", sequenceName = "SEQ_SEA_FORMATO_ESTRATEGIAE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_ESTRATEGIAE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFE_ID")
    private BigDecimal sfeId;
    @Size(max = 50)
    @Column(name = "SFE_NOMBRE_ARCHIVO")
    private String sfeNombreArchivo;
    @Lob
    @Column(name = "SFE_ARCHIVO_DIGITAL")
    private byte[] sfeArchivoDigital;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public SeaFormatoEstrategiae() {
    }

    public SeaFormatoEstrategiae(BigDecimal sfeId) {
        this.sfeId = sfeId;
    }

    public BigDecimal getSfeId() {
        return sfeId;
    }

    public void setSfeId(BigDecimal sfeId) {
        this.sfeId = sfeId;
    }

    public String getSfeNombreArchivo() {
        return sfeNombreArchivo;
    }

    public void setSfeNombreArchivo(String sfeNombreArchivo) {
        this.sfeNombreArchivo = sfeNombreArchivo;
    }

    public byte[] getSfeArchivoDigital() {
        return sfeArchivoDigital;
    }

    public void setSfeArchivoDigital(byte[] sfeArchivoDigital) {
        this.sfeArchivoDigital = sfeArchivoDigital;
    }


    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfeId != null ? sfeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoEstrategiae)) {
            return false;
        }
        SeaFormatoEstrategiae other = (SeaFormatoEstrategiae) object;
        if ((this.sfeId == null && other.sfeId != null) || (this.sfeId != null && !this.sfeId.equals(other.sfeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFormatoEstrategiae[ sfeId=" + sfeId + " ]";
    }
    
}
