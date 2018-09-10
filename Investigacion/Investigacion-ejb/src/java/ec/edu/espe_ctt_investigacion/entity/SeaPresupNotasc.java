/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PRESUP_NOTASC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaPresupNotasc.findAll", query = "SELECT s FROM SeaPresupNotasc s"),
    @NamedQuery(name = "SeaPresupNotasc.findBySpncId", query = "SELECT s FROM SeaPresupNotasc s WHERE s.spncId = :spncId"),
    @NamedQuery(name = "SeaPresupNotasc.findBySpncRubro", query = "SELECT s FROM SeaPresupNotasc s WHERE s.spncRubro = :spncRubro"),
    @NamedQuery(name = "SeaPresupNotasc.findBySpncEspe", query = "SELECT s FROM SeaPresupNotasc s WHERE s.spncEspe = :spncEspe"),
    @NamedQuery(name = "SeaPresupNotasc.findBySpncOtros", query = "SELECT s FROM SeaPresupNotasc s WHERE s.spncOtros = :spncOtros"),
    @NamedQuery(name = "SeaPresupNotasc.findBySpncTotal", query = "SELECT s FROM SeaPresupNotasc s WHERE s.spncTotal = :spncTotal")})
public class SeaPresupNotasc implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SEA_PRESUP_NOTASC", sequenceName = "SEQ_SEA_PRESUP_NOTASC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PRESUP_NOTASC")
    @Basic(optional = false)
    @NotNull

    @Column(name = "SPNC_ID")
    private BigDecimal spncId;
    @Size(max = 1000)
    @Column(name = "SPNC_RUBRO")
    private String spncRubro;
    @Column(name = "SPNC_ESPE")
    private BigDecimal spncEspe;
    @Column(name = "SPNC_OTROS")
    private BigDecimal spncOtros;
    @Column(name = "SPNC_TOTAL")
    private BigDecimal spncTotal;
    @JoinColumn(name = "SRC_ID", referencedColumnName = "SRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaRecursosConvoca srcId;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "SANI_ID", referencedColumnName = "SANI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaAnio saniId;
    @Column(name = "SPNC_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spncFechaCrea;

    public SeaPresupNotasc() {
    }

    public SeaPresupNotasc(BigDecimal spncId) {
        this.spncId = spncId;
    }

    public BigDecimal getSpncId() {
        return spncId;
    }

    public void setSpncId(BigDecimal spncId) {
        this.spncId = spncId;
    }

    public String getSpncRubro() {
        return spncRubro;
    }

    public void setSpncRubro(String spncRubro) {
        this.spncRubro = spncRubro;
    }

    public BigDecimal getSpncEspe() {
        return spncEspe;
    }

    public void setSpncEspe(BigDecimal spncEspe) {
        this.spncEspe = spncEspe;
    }

    public BigDecimal getSpncOtros() {
        return spncOtros;
    }

    public void setSpncOtros(BigDecimal spncOtros) {
        this.spncOtros = spncOtros;
    }

    public BigDecimal getSpncTotal() {
        return spncTotal;
    }

    public void setSpncTotal(BigDecimal spncTotal) {
        this.spncTotal = spncTotal;
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

    public Date getSpncFechaCrea() {
        return spncFechaCrea;
    }

    public void setSpncFechaCrea(Date spncFechaCrea) {
        this.spncFechaCrea = spncFechaCrea;
    }
    

}
