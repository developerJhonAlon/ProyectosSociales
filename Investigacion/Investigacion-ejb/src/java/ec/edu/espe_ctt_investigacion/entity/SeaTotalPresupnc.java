/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
 * @author PC1
 */
@Entity
@Table(name = "SEA_TOTAL_PRESUPNC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTotalPresupnc.findAll", query = "SELECT s FROM SeaTotalPresupnc s"),
    @NamedQuery(name = "SeaTotalPresupnc.findByStpnId", query = "SELECT s FROM SeaTotalPresupnc s WHERE s.stpnId = :stpnId"),
    @NamedQuery(name = "SeaTotalPresupnc.findByStpnTotalEspe", query = "SELECT s FROM SeaTotalPresupnc s WHERE s.stpnTotalEspe = :stpnTotalEspe"),
    @NamedQuery(name = "SeaTotalPresupnc.findByStpnTotalOtros", query = "SELECT s FROM SeaTotalPresupnc s WHERE s.stpnTotalOtros = :stpnTotalOtros"),
    @NamedQuery(name = "SeaTotalPresupnc.findByStpnPorcentaje", query = "SELECT s FROM SeaTotalPresupnc s WHERE s.stpnPorcentaje = :stpnPorcentaje")})
public class SeaTotalPresupnc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_TOTAL_PRESUPNC", sequenceName = "SEQ_SEA_TOTAL_PRESUPNC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_TOTAL_PRESUPNC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "STPN_ID")
    private BigDecimal stpnId;
    @Column(name = "STPN_TOTAL_ESPE")
    private BigDecimal stpnTotalEspe;
    @Column(name = "STPN_TOTAL_OTROS")
    private BigDecimal stpnTotalOtros;
    @Column(name = "STPN_PORCENTAJE")
    private BigDecimal stpnPorcentaje;
    @JoinColumn(name = "SRC_ID", referencedColumnName = "SRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaRecursosConvoca srcId;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "SANI_ID", referencedColumnName = "SANI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaAnio saniId;

    public SeaTotalPresupnc() {
    }

    public SeaTotalPresupnc(BigDecimal stpnId) {
        this.stpnId = stpnId;
    }

    public BigDecimal getStpnId() {
        return stpnId;
    }

    public void setStpnId(BigDecimal stpnId) {
        this.stpnId = stpnId;
    }

    public BigDecimal getStpnTotalEspe() {
        return stpnTotalEspe;
    }

    public void setStpnTotalEspe(BigDecimal stpnTotalEspe) {
        this.stpnTotalEspe = stpnTotalEspe;
    }

    public BigDecimal getStpnTotalOtros() {
        return stpnTotalOtros;
    }

    public void setStpnTotalOtros(BigDecimal stpnTotalOtros) {
        this.stpnTotalOtros = stpnTotalOtros;
    }

    public BigDecimal getStpnPorcentaje() {
        return stpnPorcentaje;
    }

    public void setStpnPorcentaje(BigDecimal stpnPorcentaje) {
        this.stpnPorcentaje = stpnPorcentaje;
    }

    public SeaRecursosConvoca getSrcId() {
        return srcId;
    }

    public void setSrcId(SeaRecursosConvoca srcId) {
        this.srcId = srcId;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public SeaAnio getSaniId() {
        return saniId;
    }

    public void setSaniId(SeaAnio saniId) {
        this.saniId = saniId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.srcId);
        hash = 11 * hash + Objects.hashCode(this.datgeproyId);
        hash = 11 * hash + Objects.hashCode(this.saniId);
        return hash;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeaTotalPresupnc other = (SeaTotalPresupnc) obj;
        if (!Objects.equals(this.srcId, other.srcId)) {
            return false;
        }
        if (!Objects.equals(this.datgeproyId.getDatgeproyId(), other.datgeproyId.getDatgeproyId())) {
            return false;
        }
        if (!Objects.equals(this.saniId, other.saniId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc[ stpnId=" + stpnId + " ]";
    }

}
