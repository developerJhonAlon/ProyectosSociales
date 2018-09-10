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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_OBJETIVOS_FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjetivosFormato.findAll", query = "SELECT s FROM SeaObjetivosFormato s"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofId", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofId = :sofId"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofObjetivoGeneral", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofObjetivoGeneral = :sofObjetivoGeneral"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofFin", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofFin = :sofFin"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofIndicador", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofIndicador = :sofIndicador"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofMverifica", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofMverifica = :sofMverifica"),
    @NamedQuery(name = "SeaObjetivosFormato.findBySofSupuestos", query = "SELECT s FROM SeaObjetivosFormato s WHERE s.sofSupuestos = :sofSupuestos")})
public class SeaObjetivosFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJETIVOS_FORMATO", sequenceName = "SEQ_SEA_OBJETIVOS_FORMATO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJETIVOS_FORMATO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOF_ID")
    private BigDecimal sofId;
    @Size(max = 1000)
    @Column(name = "SOF_OBJETIVO_GENERAL")
    private String sofObjetivoGeneral;
    @Size(max = 25)
    @Column(name = "SOF_FIN")
    private String sofFin;
    @Size(max = 25)
    @Column(name = "SOF_INDICADOR")
    private String sofIndicador;
    @Size(max = 25)
    @Column(name = "SOF_MVERIFICA")
    private String sofMverifica;
    @Size(max = 25)
    @Column(name = "SOF_SUPUESTOS")
    private String sofSupuestos;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public SeaObjetivosFormato() {
    }

    public SeaObjetivosFormato(BigDecimal sofId) {
        this.sofId = sofId;
    }

    public BigDecimal getSofId() {
        return sofId;
    }

    public void setSofId(BigDecimal sofId) {
        this.sofId = sofId;
    }

    public String getSofObjetivoGeneral() {
        return sofObjetivoGeneral;
    }

    public void setSofObjetivoGeneral(String sofObjetivoGeneral) {
        this.sofObjetivoGeneral = sofObjetivoGeneral;
    }

    public String getSofFin() {
        return sofFin;
    }

    public void setSofFin(String sofFin) {
        this.sofFin = sofFin;
    }

    public String getSofIndicador() {
        return sofIndicador;
    }

    public void setSofIndicador(String sofIndicador) {
        this.sofIndicador = sofIndicador;
    }

    public String getSofMverifica() {
        return sofMverifica;
    }

    public void setSofMverifica(String sofMverifica) {
        this.sofMverifica = sofMverifica;
    }

    public String getSofSupuestos() {
        return sofSupuestos;
    }

    public void setSofSupuestos(String sofSupuestos) {
        this.sofSupuestos = sofSupuestos;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sofId != null ? sofId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjetivosFormato)) {
            return false;
        }
        SeaObjetivosFormato other = (SeaObjetivosFormato) object;
        if ((this.sofId == null && other.sofId != null) || (this.sofId != null && !this.sofId.equals(other.sofId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaObjetivosFormato[ sofId=" + sofId + " ]";
    }
    
}
