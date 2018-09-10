/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
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
@Table(name = "SEA_DEPCENPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaDepcenproy.findAll", query = "SELECT s FROM SeaDepcenproy s"),
    @NamedQuery(name = "SeaDepcenproy.findByDepceId", query = "SELECT s FROM SeaDepcenproy s WHERE s.depceId = :depceId")})
   // @NamedQuery(name = "SeaDepcenproy.findByDepceConvocatoria", query = "SELECT s FROM SeaDepcenproy s WHERE s.depceConvocatoria = :depceConvocatoria")})
public class SeaDepcenproy implements Serializable {
    @JoinColumn(name ="DEPCE_CONVOCATORIA", referencedColumnName = "CONVOCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaConvoca convocaId;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_DEPCENPROY", sequenceName = "SEQ_SEA_DEPCENPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_DEPCENPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPCE_ID")
    private BigDecimal depceId;
    
    @JoinColumn (name = "STVSUBJ_CODE_DEPTO", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj stvsubjCode;
    
    @JoinColumn (name = "STVMAJR_CODE_CAR", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr stvmajrCode;
    
    @JoinColumn(name = "POSTPROG_ID", referencedColumnName = "POSTPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaProgPostgrado postprogId;
    
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaId;
    
    @JoinColumn(name = "GRUPI_ID", referencedColumnName = "GRUPI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaGrupinv grupiId;
    
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    
    @JoinColumn (name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp stvcampCode;

    public SeaDepcenproy() {
    }

    public SeaDepcenproy(BigDecimal depceId) {
        this.depceId = depceId;
    }

    public BigDecimal getDepceId() {
        return depceId; 
    }

    public void setDepceId(BigDecimal depceId) {
        this.depceId = depceId;
    }

    public SeaConvoca getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(SeaConvoca convocaId) {
        this.convocaId = convocaId;
    }
   
    public SeaProgPostgrado getPostprogId() {
        return postprogId;
    }

    public void setPostprogId(SeaProgPostgrado postprogId) {
        this.postprogId = postprogId;
    }

    public SeaLineainves getLineaId() {
        return lineaId;
    }

    public void setLineaId(SeaLineainves lineaId) {
        this.lineaId = lineaId;
    }

    public SeaGrupinv getGrupiId() {
        return grupiId;
    }

    public void setGrupiId(SeaGrupinv grupiId) {
        this.grupiId = grupiId;
    }

    public Stvsubj getStvsubjCode() {
        return stvsubjCode;
    }

    public void setStvsubjCode(Stvsubj stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public Stvmajr getStvmajrCode() {
        return stvmajrCode;
    }

    public void setStvmajrCode(Stvmajr stvmajrCode) {
        this.stvmajrCode = stvmajrCode;
    }
    
    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public Stvcamp getStvcampCode() {
        return stvcampCode;
    }

    public void setStvcampCode(Stvcamp stvcampCode) {
        this.stvcampCode = stvcampCode;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depceId != null ? depceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaDepcenproy)) {
            return false;
        }
        SeaDepcenproy other = (SeaDepcenproy) object;
        if ((this.depceId == null && other.depceId != null) || (this.depceId != null && !this.depceId.equals(other.depceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy[ depceId=" + depceId + " ]";
    }
    
}
