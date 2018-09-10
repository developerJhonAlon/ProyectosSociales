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
 * @author PC1
 */
@Entity
@Table(name = "SEA_PROGRAMA_ANUAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaProgramaAnual.findAll", query = "SELECT s FROM SeaProgramaAnual s"),
    @NamedQuery(name = "SeaProgramaAnual.findBySpanId", query = "SELECT s FROM SeaProgramaAnual s WHERE s.spanId = :spanId"),
    @NamedQuery(name = "SeaProgramaAnual.findBySpanTotal", query = "SELECT s FROM SeaProgramaAnual s WHERE s.spanTotal = :spanTotal")})
public class SeaProgramaAnual implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SEA_PROGRAMA_ANUAL", sequenceName = "SEQ_SEA_PROGRAMA_ANUAL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PROGRAMA_ANUAL")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPAN_ID")
    private BigDecimal spanId;
    @Column(name = "SPAN_TOTAL")
    private BigDecimal spanTotal;
    @JoinColumn(name = "SEME_ID", referencedColumnName = "SEME_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaMeses semeId;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpId;
    @Size(max = 1001)
    @Column(name = "SPAN_PARTIDA")
    private String spanPartida;
    @Column(name = "SPAN_VESPE")
    private BigDecimal spanVEspe;
    @Column(name = "SPAN_OINSTITU")
    private BigDecimal spanOInstitu;
    
    public SeaProgramaAnual() {
    }

    public SeaProgramaAnual(BigDecimal spanId) {
        this.spanId = spanId;
    }

    public BigDecimal getSpanId() {
        return spanId;
    }

    public void setSpanId(BigDecimal spanId) {
        this.spanId = spanId;
    }

    public BigDecimal getSpanTotal() {
        return spanTotal;
    }

    public void setSpanTotal(BigDecimal spanTotal) {
        this.spanTotal = spanTotal;
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

    public String getSpanPartida() {
        return spanPartida;
    }

    public void setSpanPartida(String spanPartida) {
        this.spanPartida = spanPartida;
    }

    public BigDecimal getSpanVEspe() {
        return spanVEspe;
    }

    public void setSpanVEspe(BigDecimal spanVEspe) {
        this.spanVEspe = spanVEspe;
    }

    public BigDecimal getSpanOInstitu() {
        return spanOInstitu;
    }

    public void setSpanOInstitu(BigDecimal spanOInstitu) {
        this.spanOInstitu = spanOInstitu;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spanId != null ? spanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaProgramaAnual)) {
            return false;
        }
        SeaProgramaAnual other = (SeaProgramaAnual) object;
        if ((this.spanId == null && other.spanId != null) || (this.spanId != null && !this.spanId.equals(other.spanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual[ spanId=" + spanId + " ]";
    }
    
}
