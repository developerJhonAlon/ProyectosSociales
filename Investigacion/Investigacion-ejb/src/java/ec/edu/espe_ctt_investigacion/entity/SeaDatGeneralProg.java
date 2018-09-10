/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_DAT_GENERAL_PROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaDatGeneralProg.findAll", query = "SELECT s FROM SeaDatGeneralProg s"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogId", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogId = :datgeprogId"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogNombreIngles", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogNombreIngles = :datgeprogNombreIngles"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogResumen", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogResumen = :datgeprogResumen"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogFechaPresenta", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogFechaPresenta = :datgeprogFechaPresenta"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogFechaInicio", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogFechaInicio = :datgeprogFechaInicio"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogNombreEspanol", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogNombreEspanol = :datgeprogNombreEspanol"),
    @NamedQuery(name = "SeaDatGeneralProg.findByDatgeprogFechaFin", query = "SELECT s FROM SeaDatGeneralProg s WHERE s.datgeprogFechaFin = :datgeprogFechaFin")})
public class SeaDatGeneralProg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_DAT_GENERAL_PROG", sequenceName = "SEQ_SEA_DAT_GENERAL_PROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_DAT_GENERAL_PROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATGEPROG_ID")
    private BigDecimal datgeprogId;
    @Size(max = 100)
    @Column(name = "DATGEPROG_NOMBRE_INGLES")
    private String datgeprogNombreIngles;
    @Size(max = 4000)
    @Column(name = "DATGEPROG_RESUMEN")
    private String datgeprogResumen;
    @Column(name = "DATGEPROG_FECHA_PRESENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datgeprogFechaPresenta;
    @Column(name = "DATGEPROG_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datgeprogFechaInicio;
    @Column(name = "DATGEPROG_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datgeprogFechaFin;
    @Size(max = 100)
    @Column(name = "DATGEPROG_NOMBRE_ESPANOL")
    private String datgeprogNombreEspanol;
    @JoinColumn(name = "PROG_ID", referencedColumnName = "PROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaPrograma progId;
    @JoinColumn(name = "OBPLABV_ID", referencedColumnName = "OBPLABV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaObplanbv obplabvId;
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaId;

    public SeaDatGeneralProg() {
    }

    public SeaDatGeneralProg(BigDecimal datgeprogId) {
        this.datgeprogId = datgeprogId;
    }

    public BigDecimal getDatgeprogId() {
        return datgeprogId;
    }

    public void setDatgeprogId(BigDecimal datgeprogId) {
        this.datgeprogId = datgeprogId;
    }

    public String getDatgeprogNombreIngles() {
        return datgeprogNombreIngles;
    }

    public void setDatgeprogNombreIngles(String datgeprogNombreIngles) {
        this.datgeprogNombreIngles = datgeprogNombreIngles;
    }

    public String getDatgeprogResumen() {
        return datgeprogResumen;
    }

    public void setDatgeprogResumen(String datgeprogResumen) {
        this.datgeprogResumen = datgeprogResumen;
    }

    public Date getDatgeprogFechaPresenta() {
        return datgeprogFechaPresenta;
    }

    public void setDatgeprogFechaPresenta(Date datgeprogFechaPresenta) {
        this.datgeprogFechaPresenta = datgeprogFechaPresenta;
    }

    public Date getDatgeprogFechaInicio() {
        return datgeprogFechaInicio;
    }

    public void setDatgeprogFechaInicio(Date datgeprogFechaInicio) {
        this.datgeprogFechaInicio = datgeprogFechaInicio;
    }

    public Date getDatgeprogFechaFin() {
        return datgeprogFechaFin;
    }

    public void setDatgeprogFechaFin(Date datgeprogFechaFin) {
        this.datgeprogFechaFin = datgeprogFechaFin;
    }

    public String getDatgeprogNombreEspanol() {
        return datgeprogNombreEspanol;
    }

    public void setDatgeprogNombreEspanol(String datgeprogNombreEspanol) {
        this.datgeprogNombreEspanol = datgeprogNombreEspanol;
    }
    
    public SeaPrograma getProgId() {
        return progId;
    }

    public void setProgId(SeaPrograma progId) {
        this.progId = progId;
    }

    public SeaObplanbv getObplabvId() {
        return obplabvId;
    }

    public void setObplabvId(SeaObplanbv obplabvId) {
        this.obplabvId = obplabvId;
    }

    public SeaLineainves getLineaId() {
        return lineaId;
    }

    public void setLineaId(SeaLineainves lineaId) {
        this.lineaId = lineaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datgeprogId != null ? datgeprogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaDatGeneralProg)) {
            return false;
        }
        SeaDatGeneralProg other = (SeaDatGeneralProg) object;
        if ((this.datgeprogId == null && other.datgeprogId != null) || (this.datgeprogId != null && !this.datgeprogId.equals(other.datgeprogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeaDatGeneralProg[ datgeprogId=" + datgeprogId + " ]";
    }
    
}
