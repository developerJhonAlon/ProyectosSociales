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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_TOTAL_PRESUP_ANUAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTotalPresupAnual.findAll", query = "SELECT s FROM SeaTotalPresupAnual s"),
    @NamedQuery(name = "SeaTotalPresupAnual.findByStpaId", query = "SELECT s FROM SeaTotalPresupAnual s WHERE s.stpaId = :stpaId"),
    @NamedQuery(name = "SeaTotalPresupAnual.findByStpaTotalMes", query = "SELECT s FROM SeaTotalPresupAnual s WHERE s.stpaTotalMes = :stpaTotalMes"),
    @NamedQuery(name = "SeaTotalPresupAnual.findByStpaTotalPartida", query = "SELECT s FROM SeaTotalPresupAnual s WHERE s.stpaTotalPartida = :stpaTotalPartida")})
public class SeaTotalPresupAnual implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STPA_ID")
    private BigDecimal stpaId;
    @Column(name = "STPA_TOTAL_MES")
    private BigDecimal stpaTotalMes;
    @Column(name = "STPA_TOTAL_PARTIDA")
    private BigDecimal stpaTotalPartida;
    @JoinColumn(name = "SEME_ID", referencedColumnName = "SEME_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaMeses semeId;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpId;

    public SeaTotalPresupAnual() {
    }

    public SeaTotalPresupAnual(BigDecimal stpaId) {
        this.stpaId = stpaId;
    }

    public BigDecimal getStpaId() {
        return stpaId;
    }

    public void setStpaId(BigDecimal stpaId) {
        this.stpaId = stpaId;
    }

    public BigDecimal getStpaTotalMes() {
        return stpaTotalMes;
    }

    public void setStpaTotalMes(BigDecimal stpaTotalMes) {
        this.stpaTotalMes = stpaTotalMes;
    }

    public BigDecimal getStpaTotalPartida() {
        return stpaTotalPartida;
    }

    public void setStpaTotalPartida(BigDecimal stpaTotalPartida) {
        this.stpaTotalPartida = stpaTotalPartida;
    }

    public SeaMeses getSemeId() {
        return semeId;
    }

    public void setSemeId(SeaMeses semeId) {
        this.semeId = semeId;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    public SeaClasificadorPresup getScpId() {
        return scpId;
    }

    public void setScpId(SeaClasificadorPresup scpId) {
        this.scpId = scpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stpaId != null ? stpaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaTotalPresupAnual)) {
            return false;
        }
        SeaTotalPresupAnual other = (SeaTotalPresupAnual) object;
        if ((this.stpaId == null && other.stpaId != null) || (this.stpaId != null && !this.stpaId.equals(other.stpaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual[ stpaId=" + stpaId + " ]";
    }
    
}
