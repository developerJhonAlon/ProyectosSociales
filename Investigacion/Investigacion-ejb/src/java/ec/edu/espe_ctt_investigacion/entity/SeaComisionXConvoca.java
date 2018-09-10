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
 * @author PC1
 */
@Entity
@Table(name = "SEA_COMISION_X_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaComisionXConvoca.findAll", query = "SELECT s FROM SeaComisionXConvoca s"),
    @NamedQuery(name = "SeaComisionXConvoca.findByScxcId", query = "SELECT s FROM SeaComisionXConvoca s WHERE s.scxcId = :scxcId"),
    @NamedQuery(name = "SeaComisionXConvoca.findByScxcFechaCrea", query = "SELECT s FROM SeaComisionXConvoca s WHERE s.scxcFechaCrea = :scxcFechaCrea"),
    @NamedQuery(name = "SeaComisionXConvoca.findByScxcDocNombre", query = "SELECT s FROM SeaComisionXConvoca s WHERE s.scxcDocNombre = :scxcDocNombre"),
    @NamedQuery(name = "SeaComisionXConvoca.findByScxcEstado", query = "SELECT s FROM SeaComisionXConvoca s WHERE s.scxcEstado = :scxcEstado")})
public class SeaComisionXConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @SequenceGenerator(name = "SEQ_SEA_COMISION_X_CONVOCA", sequenceName = "SEQ_SEA_COMISION_X_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_COMISION_X_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCXC_ID")
    private BigDecimal scxcId;
    @Column(name = "SCXC_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scxcFechaCrea;
    @Size(max = 1000)
    @Column(name = "SCXC_DOC_NOMBRE")
    private String scxcDocNombre;
    @Lob
    @Column(name = "SCXC_DOC_DIGITAL")    
    private byte[] scxcDocDigital;
    @Size(max = 1)
    @Column(name = "SCXC_ESTADO")
    private String scxcEstado;
    @JoinColumn(name = "TIPRES_ID", referencedColumnName = "TIPRES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaTipoRespons tipresId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    @JoinColumn(name="USU_ID_CREA",referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuIdCrea;
    @JoinColumn(name="USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)    
    private SegUsuario usuId;
    
    
    

    public SeaComisionXConvoca() {
    }

    public SeaComisionXConvoca(BigDecimal scxcId) {
        this.scxcId = scxcId;
    }

    public BigDecimal getScxcId() {
        return scxcId;
    }

    public void setScxcId(BigDecimal scxcId) {
        this.scxcId = scxcId;
    }

    public Date getScxcFechaCrea() {
        return scxcFechaCrea;
    }

    public void setScxcFechaCrea(Date scxcFechaCrea) {
        this.scxcFechaCrea = scxcFechaCrea;
    }

    public String getScxcDocNombre() {
        return scxcDocNombre;
    }

    public void setScxcDocNombre(String scxcDocNombre) {
        this.scxcDocNombre = scxcDocNombre;
    }

    public byte[] getScxcDocDigital() {
        return scxcDocDigital;
    }

    public void setScxcDocDigital(byte[] scxcDocDigital) {
        this.scxcDocDigital = scxcDocDigital;
    }



    public String getScxcEstado() {
        return scxcEstado;
    }

    public void setScxcEstado(String scxcEstado) {
        this.scxcEstado = scxcEstado;
    }

    public SeaTipoRespons getTipresId() {
        return tipresId;
    }

    public void setTipresId(SeaTipoRespons tipresId) {
        this.tipresId = tipresId;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    public SeaConvoca getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(SeaConvoca convocaId) {
        this.convocaId = convocaId;
    }

    public SegUsuario getUsuIdCrea() {
        return usuIdCrea;
    }

    public void setUsuIdCrea(SegUsuario usuIdCrea) {
        this.usuIdCrea = usuIdCrea;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }


        
}
