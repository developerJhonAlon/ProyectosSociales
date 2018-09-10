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
@Table(name = "SEA_OBJ_ADQUISISIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjAdquisisiones.findAll", query = "SELECT s FROM SeaObjAdquisisiones s"),
    @NamedQuery(name = "SeaObjAdquisisiones.findBySoaId", query = "SELECT s FROM SeaObjAdquisisiones s WHERE s.soaId = :soaId"),
    @NamedQuery(name = "SeaObjAdquisisiones.findBySoaNacional", query = "SELECT s FROM SeaObjAdquisisiones s WHERE s.soaNacional = :soaNacional"),
    @NamedQuery(name = "SeaObjAdquisisiones.findBySoaImportado", query = "SELECT s FROM SeaObjAdquisisiones s WHERE s.soaImportado = :soaImportado"),
    @NamedQuery(name = "SeaObjAdquisisiones.findBySoaDestalleNacional", query = "SELECT s FROM SeaObjAdquisisiones s WHERE s.soaDestalleNacional = :soaDestalleNacional"),
    @NamedQuery(name = "SeaObjAdquisisiones.findBySoaDetalleImportado", query = "SELECT s FROM SeaObjAdquisisiones s WHERE s.soaDetalleImportado = :soaDetalleImportado")})
public class SeaObjAdquisisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJ_ADQUISISIONES", sequenceName = "SEQ_SEA_OBJ_ADQUISISIONES", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJ_ADQUISISIONES")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOA_ID")
    private BigDecimal soaId;
    @Column(name = "SOA_NACIONAL")
    private BigDecimal soaNacional;
    @Column(name = "SOA_IMPORTADO")
    private BigDecimal soaImportado;
    @Size(max = 500)
    @Column(name = "SOA_DESTALLE_NACIONAL")
    private String soaDestalleNacional;
    @Size(max = 500)
    @Column(name = "SOA_DETALLE_IMPORTADO")
    private String soaDetalleImportado;
    @JoinColumn(name = "SOE_ID", referencedColumnName = "SOE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaObjEntregables soeId;

    public SeaObjAdquisisiones() {
        soaNacional= BigDecimal.ZERO;
        soaImportado = BigDecimal.ZERO;
    }

    public SeaObjAdquisisiones(BigDecimal soaId) {
        this.soaId = soaId;
    }

    public BigDecimal getSoaId() {
        return soaId;
    }

    public void setSoaId(BigDecimal soaId) {
        this.soaId = soaId;
    }

    public BigDecimal getSoaNacional() {
        return soaNacional;
    }

    public void setSoaNacional(BigDecimal soaNacional) {
        this.soaNacional = soaNacional;
    }

    public BigDecimal getSoaImportado() {
        return soaImportado;
    }

    public void setSoaImportado(BigDecimal soaImportado) {
        this.soaImportado = soaImportado;
    }

    public String getSoaDestalleNacional() {
        return soaDestalleNacional;
    }

    public void setSoaDestalleNacional(String soaDestalleNacional) {
        this.soaDestalleNacional = soaDestalleNacional;
    }

    public String getSoaDetalleImportado() {
        return soaDetalleImportado;
    }

    public void setSoaDetalleImportado(String soaDetalleImportado) {
        this.soaDetalleImportado = soaDetalleImportado;
    }

    public SeaObjEntregables getSoeId() {
        return soeId;
    }

    public void setSoeId(SeaObjEntregables soeId) {
        this.soeId = soeId;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soaId != null ? soaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjAdquisisiones)) {
            return false;
        }
        SeaObjAdquisisiones other = (SeaObjAdquisisiones) object;
        if ((this.soaId == null && other.soaId != null) || (this.soaId != null && !this.soaId.equals(other.soaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaObjAdquisisiones[ soaId=" + soaId + " ]";
    }
    
}
