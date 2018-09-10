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
 * @author PC1
 */
@Entity
@Table(name = "SEA_CRITERIOS_EVALUA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaCriteriosEvalua.findAll", query = "SELECT s FROM SeaCriteriosEvalua s")
    ,
    @NamedQuery(name = "SeaCriteriosEvalua.findBySceId", query = "SELECT s FROM SeaCriteriosEvalua s WHERE s.sceId = :sceId")
    ,
    @NamedQuery(name = "SeaCriteriosEvalua.findBySceNombre", query = "SELECT s FROM SeaCriteriosEvalua s WHERE s.sceNombre = :sceNombre")})
public class SeaCriteriosEvalua implements Serializable {

    @OneToMany(mappedBy = "sceId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    @OneToMany(mappedBy = "sceId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @GeneratedValue(generator = "SEQ_SEA_CRITERIOS_EVALUA")
    @SequenceGenerator(name = "SEQ_SEA_CRITERIOS_EVALUA", sequenceName = "SEQ_SEA_CRITERIOS_EVALUA", allocationSize = 1)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCE_ID")
    private BigDecimal sceId;
    @Size(max = 1000)
    @Column(name = "SCE_NOMBRE")
    private String sceNombre;
    @OneToMany(mappedBy = "sceId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaEvaluaParConvoca> seaEvaluaParConvocaList;
    @OneToMany(mappedBy = "sceId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaEvaluaComisionConvoca> seaEvaluaComisionConvocaList;
//    @OneToMany(mappedBy = "sceId")
//    private List<SeaCevaluaXConvocatoria> seaCevaluaXConvocatoriaList;
    @OneToMany(mappedBy = "scePadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaCriteriosEvalua> seaCriteriosEvaluaList;
    @JoinColumn(name = "SCE_PADRE", referencedColumnName = "SCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCriteriosEvalua scePadre;

    public SeaCriteriosEvalua() {
    }

    public SeaCriteriosEvalua(BigDecimal sceId) {
        this.sceId = sceId;
    }

    public BigDecimal getSceId() {
        return sceId;
    }

    public void setSceId(BigDecimal sceId) {
        this.sceId = sceId;
    }

    public String getSceNombre() {
        return sceNombre;
    }

    public void setSceNombre(String sceNombre) {
        this.sceNombre = sceNombre;
    }

    @XmlTransient
    public List<SeaEvaluaParConvoca> getSeaEvaluaParConvocaList() {
        return seaEvaluaParConvocaList;
    }

    public void setSeaEvaluaParConvocaList(List<SeaEvaluaParConvoca> seaEvaluaParConvocaList) {
        this.seaEvaluaParConvocaList = seaEvaluaParConvocaList;
    }

    @XmlTransient
    public List<SeaEvaluaComisionConvoca> getSeaEvaluaComisionConvocaList() {
        return seaEvaluaComisionConvocaList;
    }

    public void setSeaEvaluaComisionConvocaList(List<SeaEvaluaComisionConvoca> seaEvaluaComisionConvocaList) {
        this.seaEvaluaComisionConvocaList = seaEvaluaComisionConvocaList;
    }

//    @XmlTransient
//    public List<SeaCevaluaXConvocatoria> getSeaCevaluaXConvocatoriaList() {
//        return seaCevaluaXConvocatoriaList;
//    }
//
//    public void setSeaCevaluaXConvocatoriaList(List<SeaCevaluaXConvocatoria> seaCevaluaXConvocatoriaList) {
//        this.seaCevaluaXConvocatoriaList = seaCevaluaXConvocatoriaList;
//    }
    @XmlTransient
    public List<SeaCriteriosEvalua> getSeaCriteriosEvaluaList() {
        return seaCriteriosEvaluaList;
    }

    public void setSeaCriteriosEvaluaList(List<SeaCriteriosEvalua> seaCriteriosEvaluaList) {
        this.seaCriteriosEvaluaList = seaCriteriosEvaluaList;
    }

    public SeaCriteriosEvalua getScePadre() {
        return scePadre;
    }

    public void setScePadre(SeaCriteriosEvalua scePadre) {
        this.scePadre = scePadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sceId != null ? sceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaCriteriosEvalua)) {
            return false;
        }
        SeaCriteriosEvalua other = (SeaCriteriosEvalua) object;
        if ((this.sceId == null && other.sceId != null) || (this.sceId != null && !this.sceId.equals(other.sceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua[ sceId=" + sceId + " ]";
    }

    @XmlTransient
    public List<SeaPorcenXCrConvoca> getSeaPorcenXCrConvocaList() {
        return seaPorcenXCrConvocaList;
    }

    public void setSeaPorcenXCrConvocaList(List<SeaPorcenXCrConvoca> seaPorcenXCrConvocaList) {
        this.seaPorcenXCrConvocaList = seaPorcenXCrConvocaList;
    }

}
