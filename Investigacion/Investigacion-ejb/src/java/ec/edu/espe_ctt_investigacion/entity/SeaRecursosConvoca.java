/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_RECURSOS_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaRecursosConvoca.findAll", query = "SELECT s FROM SeaRecursosConvoca s")
    ,
    @NamedQuery(name = "SeaRecursosConvoca.findBySrcId", query = "SELECT s FROM SeaRecursosConvoca s WHERE s.srcId = :srcId")
    ,
    @NamedQuery(name = "SeaRecursosConvoca.findBySrcNombre", query = "SELECT s FROM SeaRecursosConvoca s WHERE s.srcNombre = :srcNombre")
    ,
    @NamedQuery(name = "SeaRecursosConvoca.findBySrcDescripcion", query = "SELECT s FROM SeaRecursosConvoca s WHERE s.srcDescripcion = :srcDescripcion")})
public class SeaRecursosConvoca implements Serializable {

    @OneToMany(mappedBy = "srcId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupnc> seaTotalPresupncList;
    @OneToMany(mappedBy = "srcId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPresupNotasc> seaPresupNotascList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(generator = "SEQ_SEA_NO_FINANCIA_CONVOCA")
    @SequenceGenerator(name = "SEQ_SEA_NO_FINANCIA_CONVOCA", sequenceName = "SEQ_SEA_NO_FINANCIA_CONVOCA", allocationSize = 1)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SRC_ID")
    private BigDecimal srcId;
    @Size(max = 30)
    @Column(name = "SRC_NOMBRE")
    private String srcNombre;
    @Size(max = 100)
    @Column(name = "SRC_DESCRIPCION")
    private String srcDescripcion;
    @OneToMany(mappedBy = "srcId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPresupuestoC> seaPresupuestoCList;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpId;
    @OneToMany(mappedBy = "srcId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaFinanciaConvoca> seaFinanciaConvocaList;

    public SeaRecursosConvoca() {
    }

    public SeaRecursosConvoca(BigDecimal srcId) {
        this.srcId = srcId;
    }

    public BigDecimal getSrcId() {
        return srcId;
    }

    public void setSrcId(BigDecimal srcId) {
        this.srcId = srcId;
    }

    public String getSrcNombre() {
        return srcNombre;
    }

    public void setSrcNombre(String srcNombre) {
        this.srcNombre = srcNombre;
    }

    public String getSrcDescripcion() {
        return srcDescripcion;
    }

    public void setSrcDescripcion(String srcDescripcion) {
        this.srcDescripcion = srcDescripcion;
    }

    @XmlTransient
    public List<SeaPresupuestoC> getSeaPresupuestoCList() {
        return seaPresupuestoCList;
    }

    public void setSeaPresupuestoCList(List<SeaPresupuestoC> seaPresupuestoCList) {
        this.seaPresupuestoCList = seaPresupuestoCList;
    }

    public SeaClasificadorPresup getScpId() {
        return scpId;
    }

    public void setScpId(SeaClasificadorPresup scpId) {
        this.scpId = scpId;
    }

    @XmlTransient
    public List<SeaFinanciaConvoca> getSeaFinanciaConvocaList() {
        return seaFinanciaConvocaList;
    }

    public void setSeaFinanciaConvocaList(List<SeaFinanciaConvoca> seaFinanciaConvocaList) {
        this.seaFinanciaConvocaList = seaFinanciaConvocaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srcId != null ? srcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaRecursosConvoca)) {
            return false;
        }
        SeaRecursosConvoca other = (SeaRecursosConvoca) object;
        if ((this.srcId == null && other.srcId != null) || (this.srcId != null && !this.srcId.equals(other.srcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaRecursosConvoca[ srcId=" + srcId + " ]";
    }

    @XmlTransient
    public List<SeaPresupNotasc> getSeaPresupNotascList() {
        return seaPresupNotascList;
    }

    public void setSeaPresupNotascList(List<SeaPresupNotasc> seaPresupNotascList) {
        this.seaPresupNotascList = seaPresupNotascList;
    }

    @XmlTransient
    public List<SeaTotalPresupnc> getSeaTotalPresupncList() {
        return seaTotalPresupncList;
    }

    public void setSeaTotalPresupncList(List<SeaTotalPresupnc> seaTotalPresupncList) {
        this.seaTotalPresupncList = seaTotalPresupncList;
    }

}
