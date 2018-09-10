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
@Table(name = "SEA_TABLA_CONTENIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaTablaContenido.findAll", query = "SELECT s FROM SeaTablaContenido s"),
    @NamedQuery(name = "SeaTablaContenido.findByStcId", query = "SELECT s FROM SeaTablaContenido s WHERE s.stcId = :stcId"),
    @NamedQuery(name = "SeaTablaContenido.findByStcBaseDatos", query = "SELECT s FROM SeaTablaContenido s WHERE s.stcBaseDatos = :stcBaseDatos"),
    @NamedQuery(name = "SeaTablaContenido.findByStcDenominacion", query = "SELECT s FROM SeaTablaContenido s WHERE s.stcDenominacion = :stcDenominacion"),
    @NamedQuery(name = "SeaTablaContenido.findByStcNumeroPatente", query = "SELECT s FROM SeaTablaContenido s WHERE s.stcNumeroPatente = :stcNumeroPatente"),
    @NamedQuery(name = "SeaTablaContenido.findByStcOtros", query = "SELECT s FROM SeaTablaContenido s WHERE s.stcOtros = :stcOtros")})
public class SeaTablaContenido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_TABLA_CONTENIDO", sequenceName = "SEQ_SEA_TABLA_CONTENIDO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_TABLA_CONTENIDO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "STC_ID")
    private BigDecimal stcId;
    @Size(max = 1000)
    @Column(name = "STC_BASE_DATOS")
    private String stcBaseDatos;
    @Size(max = 1000)
    @Column(name = "STC_DENOMINACION")
    private String stcDenominacion;
    @Size(max = 1000)
    @Column(name = "STC_NUMERO_PATENTE")
    private String stcNumeroPatente;
    @Size(max = 1000)
    @Column(name = "STC_OTROS")
    private String stcOtros;
    @JoinColumn(name = "SDP_ID", referencedColumnName = "SDP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDiagnosProblema sdpId;

    public SeaTablaContenido() {
    }

    public SeaTablaContenido(BigDecimal stcId) {
        this.stcId = stcId;
    }

    public BigDecimal getStcId() {
        return stcId;
    }

    public void setStcId(BigDecimal stcId) {
        this.stcId = stcId;
    }

    public String getStcBaseDatos() {
        return stcBaseDatos;
    }

    public void setStcBaseDatos(String stcBaseDatos) {
        this.stcBaseDatos = stcBaseDatos;
    }

    public String getStcDenominacion() {
        return stcDenominacion;
    }

    public void setStcDenominacion(String stcDenominacion) {
        this.stcDenominacion = stcDenominacion;
    }

    public String getStcNumeroPatente() {
        return stcNumeroPatente;
    }

    public void setStcNumeroPatente(String stcNumeroPatente) {
        this.stcNumeroPatente = stcNumeroPatente;
    }

    public String getStcOtros() {
        return stcOtros;
    }

    public void setStcOtros(String stcOtros) {
        this.stcOtros = stcOtros;
    }

    public SeaDiagnosProblema getSdpId() {
        return sdpId;
    }

    public void setSdpId(SeaDiagnosProblema sdpId) {
        this.sdpId = sdpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stcId != null ? stcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaTablaContenido)) {
            return false;
        }
        SeaTablaContenido other = (SeaTablaContenido) object;
        if ((this.stcId == null && other.stcId != null) || (this.stcId != null && !this.stcId.equals(other.stcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaTablaContenido[ stcId=" + stcId + " ]";
    }
    
}
