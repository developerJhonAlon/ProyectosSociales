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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "SEA_ANALISIS__FORMATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaAnalisisFormato.findAll", query = "SELECT s FROM SeaAnalisisFormato s"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafId", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safId = :safId"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumHombresD", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumHombresD = :safNumHombresD"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumMujeresD", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumMujeresD = :safNumMujeresD"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafTotalNumDirectos", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safTotalNumDirectos = :safTotalNumDirectos"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafTotalNumIndirecto", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safTotalNumIndirecto = :safTotalNumIndirecto"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumCapacEspeciales", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumCapacEspeciales = :safNumCapacEspeciales"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumDocHombres", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumDocHombres = :safNumDocHombres"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumDocMujeres", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumDocMujeres = :safNumDocMujeres"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumDocTotal", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumDocTotal = :safNumDocTotal"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumEstHombres", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumEstHombres = :safNumEstHombres"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumEstMujeres", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumEstMujeres = :safNumEstMujeres"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafNumEstTotal", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safNumEstTotal = :safNumEstTotal"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafFactoresCExito", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safFactoresCExito = :safFactoresCExito"),
    @NamedQuery(name = "SeaAnalisisFormato.findBySafResticcionesSupuesto", query = "SELECT s FROM SeaAnalisisFormato s WHERE s.safResticcionesSupuesto = :safResticcionesSupuesto")})
public class SeaAnalisisFormato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_ANALISIS__FORMATO", sequenceName = "SEQ_SEA_ANALISIS__FORMATO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_ANALISIS__FORMATO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAF_ID")
    private BigDecimal safId;
    @Column(name = "SAF_NUM_HOMBRES_D")
    private BigInteger safNumHombresD;
    @Column(name = "SAF_NUM_MUJERES_D")
    private BigInteger safNumMujeresD;
    @Column(name = "SAF_TOTAL_NUM_DIRECTOS")
    private BigInteger safTotalNumDirectos;
    @Column(name = "SAF_TOTAL_NUM_INDIRECTO")
    private BigInteger safTotalNumIndirecto;
    @Column(name = "SAF_NUM_CAPAC_ESPECIALES")
    private BigInteger safNumCapacEspeciales;
    @Column(name = "SAF_NUM_DOC_HOMBRES")
    private BigInteger safNumDocHombres;
    @Column(name = "SAF_NUM_DOC_MUJERES")
    private BigInteger safNumDocMujeres;
    @Column(name = "SAF_NUM_DOC_TOTAL")
    private BigInteger safNumDocTotal;
    @Column(name = "SAF_NUM_EST_HOMBRES")
    private BigInteger safNumEstHombres;
    @Column(name = "SAF_NUM_EST_MUJERES")
    private BigInteger safNumEstMujeres;
    @Column(name = "SAF_NUM_EST_TOTAL")
    private BigInteger safNumEstTotal;
    @Size(max = 4000)
    @Column(name = "SAF_FACTORES_C_EXITO")
    private String safFactoresCExito;
    @Size(max = 4000)
    @Column(name = "SAF_RESTICCIONES_SUPUESTO")
    private String safResticcionesSupuesto;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @Size(max = 4000)
    @Column(name = "SAF_ANALISIS_COMPARA")
    private String safAnalisisCompara;
    
    public SeaAnalisisFormato() {
        safNumDocHombres = BigInteger.ZERO;
        safNumDocMujeres = BigInteger.ZERO;
        safNumEstHombres  = BigInteger.ZERO;
        safNumEstMujeres = BigInteger.ZERO;
        safNumHombresD = BigInteger.ZERO;
        safNumMujeresD = BigInteger.ZERO;
        safTotalNumIndirecto = BigInteger.ZERO;
        safNumCapacEspeciales = BigInteger.ZERO;
    }

    public SeaAnalisisFormato(BigDecimal safId) {
        this.safId = safId;
    }

    public BigDecimal getSafId() {
        return safId;
    }

    public void setSafId(BigDecimal safId) {
        this.safId = safId;
    }

    public BigInteger getSafNumHombresD() {
        return safNumHombresD;
    }

    public void setSafNumHombresD(BigInteger safNumHombresD) {
        this.safNumHombresD = safNumHombresD;
    }

    public BigInteger getSafNumMujeresD() {
        return safNumMujeresD;
    }

    public void setSafNumMujeresD(BigInteger safNumMujeresD) {
        this.safNumMujeresD = safNumMujeresD;
    }

    public BigInteger getSafTotalNumDirectos() {
        return safTotalNumDirectos;
    }

    public void setSafTotalNumDirectos(BigInteger safTotalNumDirectos) {
        this.safTotalNumDirectos = safTotalNumDirectos;
    }

    public BigInteger getSafTotalNumIndirecto() {
        return safTotalNumIndirecto;
    }

    public void setSafTotalNumIndirecto(BigInteger safTotalNumIndirecto) {
        this.safTotalNumIndirecto = safTotalNumIndirecto;
    }

    public BigInteger getSafNumCapacEspeciales() {
        return safNumCapacEspeciales;
    }

    public void setSafNumCapacEspeciales(BigInteger safNumCapacEspeciales) {
        this.safNumCapacEspeciales = safNumCapacEspeciales;
    }

    public BigInteger getSafNumDocHombres() {
        return safNumDocHombres;
    }

    public void setSafNumDocHombres(BigInteger safNumDocHombres) {
        this.safNumDocHombres = safNumDocHombres;
    }

    public BigInteger getSafNumDocMujeres() {
        return safNumDocMujeres;
    }

    public void setSafNumDocMujeres(BigInteger safNumDocMujeres) {
        this.safNumDocMujeres = safNumDocMujeres;
    }

    public BigInteger getSafNumDocTotal() {
        return safNumDocTotal;
    }

    public void setSafNumDocTotal(BigInteger safNumDocTotal) {
        this.safNumDocTotal = safNumDocTotal;
    }

    public BigInteger getSafNumEstHombres() {
        return safNumEstHombres;
    }

    public void setSafNumEstHombres(BigInteger safNumEstHombres) {
        this.safNumEstHombres = safNumEstHombres;
    }

    public BigInteger getSafNumEstMujeres() {
        return safNumEstMujeres;
    }

    public void setSafNumEstMujeres(BigInteger safNumEstMujeres) {
        this.safNumEstMujeres = safNumEstMujeres;
    }

    public BigInteger getSafNumEstTotal() {
        return safNumEstTotal;
    }

    public void setSafNumEstTotal(BigInteger safNumEstTotal) {
        this.safNumEstTotal = safNumEstTotal;
    }

    public String getSafFactoresCExito() {
        return safFactoresCExito;
    }

    public void setSafFactoresCExito(String safFactoresCExito) {
        this.safFactoresCExito = safFactoresCExito;
    }

    public String getSafResticcionesSupuesto() {
        return safResticcionesSupuesto;
    }

    public void setSafResticcionesSupuesto(String safResticcionesSupuesto) {
        this.safResticcionesSupuesto = safResticcionesSupuesto;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    public String getSafAnalisisCompara() {
        return safAnalisisCompara;
    }

    public void setSafAnalisisCompara(String safAnalisisCompara) {
        this.safAnalisisCompara = safAnalisisCompara;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (safId != null ? safId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaAnalisisFormato)) {
            return false;
        }
        SeaAnalisisFormato other = (SeaAnalisisFormato) object;
        if ((this.safId == null && other.safId != null) || (this.safId != null && !this.safId.equals(other.safId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaAnalisisFormato[ safId=" + safId + " ]";
    }

    public BigInteger getTotalDirectos(){
        BigInteger total = BigInteger.ZERO;
        if (safNumHombresD!=null){
            total= total.add(safNumHombresD);
        }
        if (safNumMujeresD!=null){
            total= total.add(safNumMujeresD);
        }
        if (safNumCapacEspeciales!=null){
            total= total.add(safNumCapacEspeciales);
        }
        return total;
    }
    public BigInteger getTotalDocentes(){
        BigInteger total = BigInteger.ZERO;
        if (safNumDocHombres!=null){
            total= total.add(safNumDocHombres);
        }
        if (safNumDocMujeres!=null){
            total= total.add(safNumDocMujeres);
        }
        return total;
    }
    public BigInteger getTotalEstudiantes(){
        BigInteger total = BigInteger.ZERO;
        if (safNumEstHombres!=null){
            total= total.add(safNumEstHombres);
        }
        if (safNumEstMujeres!=null){
            total= total.add(safNumEstMujeres);
        }
        return total;
    }
    
    
}
