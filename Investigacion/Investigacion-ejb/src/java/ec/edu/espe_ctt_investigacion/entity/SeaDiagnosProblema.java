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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_DIAGNOS_PROBLEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaDiagnosProblema.findAll", query = "SELECT s FROM SeaDiagnosProblema s"),
    @NamedQuery(name = "SeaDiagnosProblema.findBySdpId", query = "SELECT s FROM SeaDiagnosProblema s WHERE s.sdpId = :sdpId"),
    @NamedQuery(name = "SeaDiagnosProblema.findBySdpSituacionActualTema", query = "SELECT s FROM SeaDiagnosProblema s WHERE s.sdpSituacionActualTema = :sdpSituacionActualTema"),
    @NamedQuery(name = "SeaDiagnosProblema.findBySdpIdentificaDescripProblem", query = "SELECT s FROM SeaDiagnosProblema s WHERE s.sdpIdentificaDescripProblem = :sdpIdentificaDescripProblem")})
public class SeaDiagnosProblema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_DIAGNOS_PROBLEMA", sequenceName = "SEQ_SEA_DIAGNOS_PROBLEMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_DIAGNOS_PROBLEMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SDP_ID")
    private BigDecimal sdpId;
    @Lob
    @Column (name = "SDP_SITUACION_ACTUAL_TEMA")
    private String sdpSituacionActualTema;
    @Lob
    @Column (name = "SDP_IDENTIFICA_DESCRIP_PROBLEM")
    private String sdpIdentificaDescripProblem;
//    @Size(max = 4000)
//    @Column(name = "SDP_SITUACION_ACTUAL_TEMA")
//    private String sdpSituacionActualTema;
//    @Size(max = 4000)
//    @Column(name = "SDP_IDENTIFICA_DESCRIP_PROBLEM")
//    private String sdpIdentificaDescripProblem;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @OneToMany(mappedBy = "sdpId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTablaContenido> tablaContenidoList;
    

    public SeaDiagnosProblema() {
    }

    public SeaDiagnosProblema(BigDecimal sdpId) {
        this.sdpId = sdpId;
    }

    public BigDecimal getSdpId() {
        return sdpId;
    }

    public void setSdpId(BigDecimal sdpId) {
        this.sdpId = sdpId;
    }

    public String getSdpSituacionActualTema() {
        return sdpSituacionActualTema;
    }

    public void setSdpSituacionActualTema(String sdpSituacionActualTema) {
        this.sdpSituacionActualTema = sdpSituacionActualTema;
    }

    public String getSdpIdentificaDescripProblem() {
        return sdpIdentificaDescripProblem;
    }

    public void setSdpIdentificaDescripProblem(String sdpIdentificaDescripProblem) {
        this.sdpIdentificaDescripProblem = sdpIdentificaDescripProblem;
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
        hash += (sdpId != null ? sdpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaDiagnosProblema)) {
            return false;
        }
        SeaDiagnosProblema other = (SeaDiagnosProblema) object;
        if ((this.sdpId == null && other.sdpId != null) || (this.sdpId != null && !this.sdpId.equals(other.sdpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.SeaDiagnosProblema[ sdpId=" + sdpId + " ]";
    }

    public List<SeaTablaContenido> getTablaContenidoList() {
        return tablaContenidoList;
    }

    public void setTablaContenidoList(List<SeaTablaContenido> tablaContenidoList) {
        this.tablaContenidoList = tablaContenidoList;
    }
    
    
    
}
