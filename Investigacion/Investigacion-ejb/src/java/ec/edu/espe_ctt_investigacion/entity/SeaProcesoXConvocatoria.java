/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PROCESO_X_CONVOCATORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaProcesoXConvocatoria.findAll", query = "SELECT s FROM SeaProcesoXConvocatoria s"),
    @NamedQuery(name = "SeaProcesoXConvocatoria.findByPpcId", query = "SELECT s FROM SeaProcesoXConvocatoria s WHERE s.ppcId = :ppcId"),
    @NamedQuery(name = "SeaProcesoXConvocatoria.findByPpcFecini", query = "SELECT s FROM SeaProcesoXConvocatoria s WHERE s.ppcFecini = :ppcFecini"),
    @NamedQuery(name = "SeaProcesoXConvocatoria.findByPpcFecifin", query = "SELECT s FROM SeaProcesoXConvocatoria s WHERE s.ppcFecifin = :ppcFecifin"),
    @NamedQuery(name = "SeaProcesoXConvocatoria.findByPpcEstado", query = "SELECT s FROM SeaProcesoXConvocatoria s WHERE s.ppcEstado = :ppcEstado")})
public class SeaProcesoXConvocatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_PROCESO_X_CONVOCATORIA", sequenceName = "SEQ_SEA_PROCESO_X_CONVOCATORIA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PROCESO_X_CONVOCATORIA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PPC_ID")
    private BigDecimal ppcId;
    @Column(name = "PPC_FECINI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppcFecini;
    @Column(name = "PPC_FECIFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppcFecifin;
    @Column(name = "PPC_ESTADO")
    private BigInteger ppcEstado;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaProceso seaProceso;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
//    @ManyToOne
//    private SeaConvoca convocaId;
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca seaConvoca;
    
     @Transient
    private String fechaTextoDesde;
  @Transient
    private String fechaTextoHasta;
    public SeaProcesoXConvocatoria() {
    }

    public SeaProcesoXConvocatoria(BigDecimal ppcId) {
        this.ppcId = ppcId;
    }

    public BigDecimal getPpcId() {
        return ppcId;
    }

    public void setPpcId(BigDecimal ppcId) {
        this.ppcId = ppcId;
    }

    public Date getPpcFecini() {
        return ppcFecini;
    }

    public void setPpcFecini(Date ppcFecini) {
        this.ppcFecini = ppcFecini;
    }

    public Date getPpcFecifin() {
        return ppcFecifin;
    }

    public void setPpcFecifin(Date ppcFecifin) {
        this.ppcFecifin = ppcFecifin;
    }

    public BigInteger getPpcEstado() {
        return ppcEstado;
    }

    public void setPpcEstado(BigInteger ppcEstado) {
        this.ppcEstado = ppcEstado;
    }

    public SeaProceso getSeaProceso() {
        return seaProceso;
    }

    public void setSeaProceso(SeaProceso seaProceso) {
        this.seaProceso = seaProceso;
    }

    public SeaConvoca getSeaConvoca() {
        return seaConvoca;
    }

    public void setSeaConvoca(SeaConvoca seaConvoca) {
        this.seaConvoca = seaConvoca;
    }
     public String getFechaTextoDesde() {
         if (ppcFecini != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));
            return sdf1.format(ppcFecini);
        } else {
          return fechaTextoDesde;
        }
        
    }
      public String getFechaTextoHasta() {
         if (ppcFecifin != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));
            return sdf1.format(ppcFecifin);
        } else {
          return fechaTextoHasta;
        }
        
    }

//    public SeaConvoca getConvocaId() {
//        return convocaId;
//    }
//
//    public void setConvocaId(SeaConvoca convocaId) {
//        this.convocaId = convocaId;
//    }
    

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppcId != null ? ppcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaProcesoXConvocatoria)) {
            return false;
        }
        SeaProcesoXConvocatoria other = (SeaProcesoXConvocatoria) object;
        if ((this.ppcId == null && other.ppcId != null) || (this.ppcId != null && !this.ppcId.equals(other.ppcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria[ ppcId=" + ppcId + " ]";
    }
    
}
