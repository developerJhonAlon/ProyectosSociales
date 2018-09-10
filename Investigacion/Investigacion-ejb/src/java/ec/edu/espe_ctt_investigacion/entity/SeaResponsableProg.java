/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import javax.persistence.FetchType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_RESPONSABLE_PROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaResponsableProg.findAll", query = "SELECT s FROM SeaResponsableProg s"),
    @NamedQuery(name = "SeaResponsableProg.findByResprogId", query = "SELECT s FROM SeaResponsableProg s WHERE s.resprogId = :resprogId"),
    @NamedQuery(name = "SeaResponsableProg.findByCargoId", query = "SELECT s FROM SeaResponsableProg s WHERE s.cargoId = :cargoId"),
    @NamedQuery(name = "SeaResponsableProg.findByResprogOrden", query = "SELECT s FROM SeaResponsableProg s WHERE s.resprogOrden = :resprogOrden")})
    public class SeaResponsableProg implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = " SEQ_SEA_RESPONSABLE_PROG", sequenceName = " SEQ_SEA_RESPONSABLE_PROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_SEA_RESPONSABLE_PROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESPROG_ID")
    private BigDecimal resprogId;
    @Column(name = "CARGO_ID")
    private BigInteger cargoId;
    
    
//    @Size(max = 4)
//    @Column(name = "STVSUBJ_CODE_DPTO")
//   
//private String stvsubjCodeDpto;
    @JoinColumn(name = "STVSUBJ_CODE_DPTO", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj stvsubjCode;
    
    @Column(name = "RESPROG_ORDEN") 
    private BigInteger resprogOrden;    
    
    @JoinColumn(name = "USU_ID_DOCENTE", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuIdDocente;
    
    @JoinColumn(name = "TIPRES_ID", referencedColumnName = "TIPRES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaTipoRespons tipresId;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;

    public SeaResponsableProg() {
    }

    public SeaResponsableProg(BigDecimal resprogId) {
        this.resprogId = resprogId;
    }

    public BigDecimal getResprogId() {
        return resprogId;
    }

    public void setResprogId(BigDecimal resprogId) {
        this.resprogId = resprogId;
    }

    public BigInteger getCargoId() {
        return cargoId;
    }

    public void setCargoId(BigInteger cargoId) {
        this.cargoId = cargoId;
    }

//    public Stvsubj getStvSubj() {
//        return stvSubj1;
//    }
//
//    public void setStvSubj(Stvsubj stvSubj) {
//        this.stvSubj1 = stvSubj;
//    }
    public Stvsubj getStvsubjCode() {
        return stvsubjCode;
    }

    public void setStvsubjCode(Stvsubj stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public BigInteger getResprogOrden() {
        return resprogOrden;
    }

    public void setResprogOrden(BigInteger resprogOrden) {
        this.resprogOrden = resprogOrden;
    }

    public SegUsuario getUsuIdDocente() {
        return usuIdDocente;
    }

    public void setUsuIdDocente(SegUsuario usuIdDocente) {
        this.usuIdDocente = usuIdDocente;
    }

    public SeaTipoRespons getTipresId() {
        return tipresId;
    }

    public void setTipresId(SeaTipoRespons tipresId) {
        this.tipresId = tipresId;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public SeaDatGeneralProg getDatgeprogId() {
        return datgeprogId;
    }

    public void setDatgeprogId(SeaDatGeneralProg datgeprogId) {
        this.datgeprogId = datgeprogId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resprogId != null ? resprogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaResponsableProg)) {
            return false;
        }
        SeaResponsableProg other = (SeaResponsableProg) object;
        if ((this.resprogId == null && other.resprogId != null) || (this.resprogId != null && !this.resprogId.equals(other.resprogId))) {
            return false;
        }
        return true;
    }

    
//    @JoinColumn(name = "TIPRES_ID", referencedColumnName = "TIPRES_ID")
//    @ManyToOne
//    private SeaTipoRespons tipresId;
//    @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID")
//    @ManyToOne
//    private SeaDocente docId;
//    @JoinColumn(name = "DEPTO_ID", referencedColumnName = "DEP_ID")
//    @ManyToOne
//    private SeaDepartamento deptoId;
//    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
//    @ManyToOne
//    private SeaDatGeneralProy datgeproyId;
//    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
//    @ManyToOne
//    private SeaDatGeneralProg datgeprogId;
//
//    public SeaResponsableProg() {
//    }
//
//    public SeaResponsableProg(BigDecimal resprogId) {
//        this.resprogId = resprogId;
//    }
//
//    public BigDecimal getResprogId() {
//        return resprogId;
//    }
//
//    public void setResprogId(BigDecimal resprogId) {
//        this.resprogId = resprogId;
//    }
//
//    public BigInteger getCargoId() {
//        return cargoId;
//    }
//
//    public void setCargoId(BigInteger cargoId) {
//        this.cargoId = cargoId;
//    }
//
//    public BigInteger getResprogOrden() {
//        return resprogOrden;
//    }
//
//    public void setResprogOrden(BigInteger resprogOrden) {
//        this.resprogOrden = resprogOrden;
//    }
//
//    public SeaTipoRespons getTipresId() {
//        return tipresId;
//    }
//
//    public void setTipresId(SeaTipoRespons tipresId) {
//        this.tipresId = tipresId;
//    }
//
//    public SeaDocente getDocId() {
//        return docId;
//    }
//
//    public void setDocId(SeaDocente docId) {
//        this.docId = docId;
//    }
//
//    public SeaDepartamento getDeptoId() {
//        return deptoId;
//    }
//
//    public void setDeptoId(SeaDepartamento deptoId) {
//        this.deptoId = deptoId;
//    }
//
//    public SeaDatGeneralProy getDatgeproyId() {
//        return datgeproyId;
//    }
//
//    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
//        this.datgeproyId = datgeproyId;
//    }
//
//    public SeaDatGeneralProg getDatgeprogId() {
//        return datgeprogId;
//    }
//
//    public void setDatgeprogId(SeaDatGeneralProg datgeprogId) {
//        this.datgeprogId = datgeprogId;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (resprogId != null ? resprogId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SeaResponsableProg)) {
//            return false;
//        }
//        SeaResponsableProg other = (SeaResponsableProg) object;
//        if ((this.resprogId == null && other.resprogId != null) || (this.resprogId != null && !this.resprogId.equals(other.resprogId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg[ resprogId=" + resprogId + " ]";
    }
    
}
