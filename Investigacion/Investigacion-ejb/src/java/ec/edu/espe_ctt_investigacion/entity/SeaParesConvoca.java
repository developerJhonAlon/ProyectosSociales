/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "SEA_PARES_CONVOCA")
@XmlRootElement
public class SeaParesConvoca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @SequenceGenerator(name = "SEQ_SEA_PARES_CONVOCA", sequenceName = "SEQ_SEA_PARES_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PARES_CONVOCA")
    @Basic(optional = false)
    @NotNull

    @Column(name = "SPC_ID")
    private BigDecimal spcId;

    @Column(name = "SPC_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spcFechaCrea;
    @Size(max = 1000)
    @Column(name = "SPC_DOC_NOMBRE")
    private String spcDocNombre;
    @Lob
    @Column(name = "SPC_DOC_DIGITAL")
    private Serializable spcDocDigital;
    @Size(max = 1)
    @Column(name = "SPC_ESTADO")
    private String spcEstado;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @JoinColumn(name="USU_ID_CREA_PAR",referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuIdCrea;
    @JoinColumn(name="USU_ID_PAR", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)    
    private SegUsuario usuId;
    @JoinColumn(name = "CONVOCA_ID", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    
    
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    //@Transient
    private SeaDatGeneralProy notaConceptual;
    
    @OneToMany(mappedBy = "par", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EvaluacionPar> evaluacionList = new ArrayList<>();

    public SeaParesConvoca() {
    }

    public SeaParesConvoca(BigDecimal spcId) {
        this.spcId = spcId;
    }

    public BigDecimal getSpcId() {
        return spcId;
    }

    public void setSpcId(BigDecimal spcId) {
        this.spcId = spcId;
    }


    public Date getSpcFechaCrea() {
        return spcFechaCrea;
    }

    public void setSpcFechaCrea(Date spcFechaCrea) {
        this.spcFechaCrea = spcFechaCrea;
    }

    public String getSpcDocNombre() {
        return spcDocNombre;
    }

    public void setSpcDocNombre(String spcDocNombre) {
        this.spcDocNombre = spcDocNombre;
    }

    public Serializable getSpcDocDigital() {
        return spcDocDigital;
    }

    public void setSpcDocDigital(Serializable spcDocDigital) {
        this.spcDocDigital = spcDocDigital;
    }

    public String getSpcEstado() {
        return spcEstado;
    }

    public void setSpcEstado(String spcEstado) {
        this.spcEstado = spcEstado;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spcId != null ? spcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaParesConvoca)) {
            return false;
        }
        SeaParesConvoca other = (SeaParesConvoca) object;
        if ((this.spcId == null && other.spcId != null) || (this.spcId != null && !this.spcId.equals(other.spcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca[ spcId=" + spcId + " ]";
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

    public SeaDatGeneralProy getNotaConceptual() {
        return notaConceptual;
    }

    public void setNotaConceptual(SeaDatGeneralProy notaConceptual) {
        this.notaConceptual = notaConceptual;
    }

    public List<EvaluacionPar> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<EvaluacionPar> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }
    public BigDecimal getPuntaje(){
        BigDecimal result= BigDecimal.ZERO;
        if (evaluacionList!=null){
            for (EvaluacionPar evaluacionPar : evaluacionList) {
                result = result.add(evaluacionPar.getPuntaje());
            }
        }
        return result;
    }
    
    public EvaluacionPar getEvaluacionPar(){
        if (evaluacionList!=null && !evaluacionList.isEmpty()){
            return evaluacionList.get(0);
        }
        return null;
    }

}
