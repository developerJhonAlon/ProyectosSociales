/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
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
import javax.persistence.Lob;
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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_RESPLINEAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaResplineai.findAll", query = "SELECT s FROM SeaResplineai s"),
    @NamedQuery(name = "SeaResplineai.findByRlineaiId", query = "SELECT s FROM SeaResplineai s WHERE s.rlineaiId = :rlineaiId"),
    @NamedQuery(name = "SeaResplineai.findByRplineaiFechaCrea", query = "SELECT s FROM SeaResplineai s WHERE s.rplineaiFechaCrea = :rplineaiFechaCrea"),
    @NamedQuery(name = "SeaResplineai.findByRplineaiEstado", query = "SELECT s FROM SeaResplineai s WHERE s.rplineaiEstado = :rplineaiEstado"),
    @NamedQuery(name = "SeaResplineai.findByRplineaiDocNombre", query = "SELECT s FROM SeaResplineai s WHERE s.rplineaiDocNombre = :rplineaiDocNombre")})
public class SeaResplineai implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_RESPLINEAI", sequenceName = "SEQ_SEA_RESPLINEAI", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_RESPLINEAI")
    @Basic(optional = false)
    @NotNull
    @Column(name = "RLINEAI_ID")
    private BigDecimal rlineaiId;
    @Column(name = "RPLINEAI_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rplineaiFechaCrea;
    @Size(max = 1)
    @Column(name = "RPLINEAI_ESTADO")
    private String rplineaiEstado;
    @Size(max = 25)
    @Column(name = "RPLINEAI_DOC_NOMBRE")
    private String rplineaiDocNombre;
    @Lob
    @Column(name = "RPLINEAI_DOC_DIGITAL")
    private Serializable rplineaiDocDigital;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuId;
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaId;

    public SeaResplineai() {
    }

    public SeaResplineai(BigDecimal rlineaiId) {
        this.rlineaiId = rlineaiId;
    }

    public BigDecimal getRlineaiId() {
        return rlineaiId;
    }

    public void setRlineaiId(BigDecimal rlineaiId) {
        this.rlineaiId = rlineaiId;
    }

    public Date getRplineaiFechaCrea() {
        return rplineaiFechaCrea;
    }

    public void setRplineaiFechaCrea(Date rplineaiFechaCrea) {
        this.rplineaiFechaCrea = rplineaiFechaCrea;
    }

    public String getRplineaiEstado() {
        return rplineaiEstado;
    }

    public void setRplineaiEstado(String rplineaiEstado) {
        this.rplineaiEstado = rplineaiEstado;
    }

    public String getRplineaiDocNombre() {
        return rplineaiDocNombre;
    }

    public void setRplineaiDocNombre(String rplineaiDocNombre) {
        this.rplineaiDocNombre = rplineaiDocNombre;
    }

    public Serializable getRplineaiDocDigital() {
        return rplineaiDocDigital;
    }

    public void setRplineaiDocDigital(Serializable rplineaiDocDigital) {
        this.rplineaiDocDigital = rplineaiDocDigital;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }

    public SeaLineainves getLineaId() {
        return lineaId;
    }

    public void setLineaId(SeaLineainves lineaId) {
        this.lineaId = lineaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlineaiId != null ? rlineaiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaResplineai)) {
            return false;
        }
        SeaResplineai other = (SeaResplineai) object;
        if ((this.rlineaiId == null && other.rlineaiId != null) || (this.rlineaiId != null && !this.rlineaiId.equals(other.rlineaiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaResplineai[ rlineaiId=" + rlineaiId + " ]";
    }
    
}
