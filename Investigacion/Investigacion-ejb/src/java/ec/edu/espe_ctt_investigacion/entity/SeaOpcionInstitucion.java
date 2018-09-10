/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_OPCION_INSTITUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaOpcionInstitucion.findAll", query = "SELECT s FROM SeaOpcionInstitucion s"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiId", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiId = :opinstiId"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiOrden", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiOrden = :opinstiOrden"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiNombre", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiNombre = :opinstiNombre"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiFechaCrea", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiFechaCrea = :opinstiFechaCrea"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiDireccion", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiDireccion = :opinstiDireccion"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiCiudad", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiCiudad = :opinstiCiudad"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiTelefono", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiTelefono = :opinstiTelefono"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiPaguinaWeb", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiPaguinaWeb = :opinstiPaguinaWeb"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiMail", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiMail = :opinstiMail"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiFax", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiFax = :opinstiFax"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiRepresentaLegal", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiRepresentaLegal = :opinstiRepresentaLegal"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiCedulaRl", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiCedulaRl = :opinstiCedulaRl"),
    @NamedQuery(name = "SeaOpcionInstitucion.findByOpinstiOrganoEjecutor", query = "SELECT s FROM SeaOpcionInstitucion s WHERE s.opinstiOrganoEjecutor = :opinstiOrganoEjecutor")})
public class SeaOpcionInstitucion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OPCION_INSTITUCION", sequenceName = "SEQ_SEA_OPCION_INSTITUCION", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OPCION_INSTITUCION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPINSTI_ID")
    private BigDecimal opinstiId;
    @Column(name = "OPINSTI_ORDEN")
    private BigInteger opinstiOrden;
    @Size(max = 100)
    @Column(name = "OPINSTI_NOMBRE")
    private String opinstiNombre;
    @Column(name = "OPINSTI_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opinstiFechaCrea;
    @Size(max = 500)
    @Column(name = "OPINSTI_DIRECCION")
    private String opinstiDireccion;
    @Size(max = 25)
    @Column(name = "OPINSTI_CIUDAD")
    private String opinstiCiudad;
    @Size(max = 15)
    @Column(name = "OPINSTI_TELEFONO")
    private String opinstiTelefono;
    @Size(max = 50)
    @Column(name = "OPINSTI_PAGUINA_WEB")
    private String opinstiPaguinaWeb;
    @Size(max = 50)
    @Column(name = "OPINSTI_MAIL")
    private String opinstiMail;
    @Size(max = 15)
    @Column(name = "OPINSTI_FAX")
    private String opinstiFax;
    @Size(max = 50)
    @Column(name = "OPINSTI_REPRESENTA_LEGAL")
    private String opinstiRepresentaLegal;
    @Size(max = 10)
    @Column(name = "OPINSTI_CEDULA_RL")
    private String opinstiCedulaRl;
    @Size(max = 200)
    @Column(name = "OPINSTI_ORGANO_EJECUTOR")
    private String opinstiOrganoEjecutor;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @JoinColumn(name = "DATGEPROG_ID", referencedColumnName = "DATGEPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProg datgeprogId;

    public SeaOpcionInstitucion() {
    }

    public SeaOpcionInstitucion(BigDecimal opinstiId) {
        this.opinstiId = opinstiId;
    }

    public BigDecimal getOpinstiId() {
        return opinstiId;
    }

    public void setOpinstiId(BigDecimal opinstiId) {
        this.opinstiId = opinstiId;
    }

    public BigInteger getOpinstiOrden() {
        return opinstiOrden;
    }

    public void setOpinstiOrden(BigInteger opinstiOrden) {
        this.opinstiOrden = opinstiOrden;
    }

    public String getOpinstiNombre() {
        return opinstiNombre;
    }

    public void setOpinstiNombre(String opinstiNombre) {
        this.opinstiNombre = opinstiNombre;
    }

    public Date getOpinstiFechaCrea() {
        return opinstiFechaCrea;
    }

    public void setOpinstiFechaCrea(Date opinstiFechaCrea) {
        this.opinstiFechaCrea = opinstiFechaCrea;
    }

    public String getOpinstiDireccion() {
        return opinstiDireccion;
    }

    public void setOpinstiDireccion(String opinstiDireccion) {
        this.opinstiDireccion = opinstiDireccion;
    }

    public String getOpinstiCiudad() {
        return opinstiCiudad;
    }

    public void setOpinstiCiudad(String opinstiCiudad) {
        this.opinstiCiudad = opinstiCiudad;
    }

    public String getOpinstiTelefono() {
        return opinstiTelefono;
    }

    public void setOpinstiTelefono(String opinstiTelefono) {
        this.opinstiTelefono = opinstiTelefono;
    }

    public String getOpinstiPaguinaWeb() {
        return opinstiPaguinaWeb;
    }

    public void setOpinstiPaguinaWeb(String opinstiPaguinaWeb) {
        this.opinstiPaguinaWeb = opinstiPaguinaWeb;
    }

    public String getOpinstiMail() {
        return opinstiMail;
    }

    public void setOpinstiMail(String opinstiMail) {
        this.opinstiMail = opinstiMail;
    }

    public String getOpinstiFax() {
        return opinstiFax;
    }

    public void setOpinstiFax(String opinstiFax) {
        this.opinstiFax = opinstiFax;
    }

    public String getOpinstiRepresentaLegal() {
        return opinstiRepresentaLegal;
    }

    public void setOpinstiRepresentaLegal(String opinstiRepresentaLegal) {
        this.opinstiRepresentaLegal = opinstiRepresentaLegal;
    }

    public String getOpinstiCedulaRl() {
        return opinstiCedulaRl;
    }

    public void setOpinstiCedulaRl(String opinstiCedulaRl) {
        this.opinstiCedulaRl = opinstiCedulaRl;
    }

    public String getOpinstiOrganoEjecutor() {
        return opinstiOrganoEjecutor;
    }

    public void setOpinstiOrganoEjecutor(String opinstiOrganoEjecutor) {
        this.opinstiOrganoEjecutor = opinstiOrganoEjecutor;
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
        hash += (opinstiId != null ? opinstiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaOpcionInstitucion)) {
            return false;
        }
        SeaOpcionInstitucion other = (SeaOpcionInstitucion) object;
        if ((this.opinstiId == null && other.opinstiId != null) || (this.opinstiId != null && !this.opinstiId.equals(other.opinstiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion[ opinstiId=" + opinstiId + " ]";
    }
    
}
