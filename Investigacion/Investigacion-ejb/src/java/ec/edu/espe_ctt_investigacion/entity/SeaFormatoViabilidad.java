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
@Table(name = "SEA_FORMATO_VIABILIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFormatoViabilidad.findAll", query = "SELECT s FROM SeaFormatoViabilidad s"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaId", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaId = :sfaId"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaViavilidadTec", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaViavilidadTec = :sfaViavilidadTec"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaEquipamientoTec", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaEquipamientoTec = :sfaEquipamientoTec"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaPerderPais", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaPerderPais = :sfaPerderPais"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaImpactosEsperados", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaImpactosEsperados = :sfaImpactosEsperados"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaDisponeMetodologia", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaDisponeMetodologia = :sfaDisponeMetodologia"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaImpactoAmbiental", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaImpactoAmbiental = :sfaImpactoAmbiental"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaSostenibilidadSocial", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaSostenibilidadSocial = :sfaSostenibilidadSocial"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaTranferenciaTecno", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaTranferenciaTecno = :sfaTranferenciaTecno"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaArticulosCientificos", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaArticulosCientificos = :sfaArticulosCientificos"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaPrototipos", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaPrototipos = :sfaPrototipos"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaPropiedadIntelecto", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaPropiedadIntelecto = :sfaPropiedadIntelecto"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaEmpresaSpin", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaEmpresaSpin = :sfaEmpresaSpin"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaAnalisisRiesgos", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaAnalisisRiesgos = :sfaAnalisisRiesgos"),
    @NamedQuery(name = "SeaFormatoViabilidad.findBySfaOtros", query = "SELECT s FROM SeaFormatoViabilidad s WHERE s.sfaOtros = :sfaOtros")})
public class SeaFormatoViabilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_VIABILIDAD", sequenceName = "SEQ_SEA_FORMATO_VIABILIDAD", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_VIABILIDAD")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFA_ID")
    private BigDecimal sfaId;
    @Size(max = 4000)
    @Column(name = "SFA_VIAVILIDAD_TEC")
    private String sfaViavilidadTec;
    @Size(max = 4000)
    @Column(name = "SFA_EQUIPAMIENTO_TEC")
    private String sfaEquipamientoTec;
    @Size(max = 4000)
    @Column(name = "SFA_PERDER_PAIS")
    private String sfaPerderPais;
    @Size(max = 4000)
    @Column(name = "SFA_IMPACTOS_ESPERADOS")
    private String sfaImpactosEsperados;
    @Size(max = 2)
    @Column(name = "SFA_DISPONE_METODOLOGIA")
    private String sfaDisponeMetodologia;
    @Size(max = 4000)
    @Column(name = "SFA_IMPACTO_AMBIENTAL")
    private String sfaImpactoAmbiental;
    @Size(max = 4000)
    @Column(name = "SFA_SOSTENIBILIDAD_SOCIAL")
    private String sfaSostenibilidadSocial;
    @Size(max = 4000)
    @Column(name = "SFA_TRANFERENCIA_TECNO")
    private String sfaTranferenciaTecno;
    @Size(max = 4000)
    @Column(name = "SFA_ARTICULOS_CIENTIFICOS")
    private String sfaArticulosCientificos;
    @Size(max = 4000)
    @Column(name = "SFA_PROTOTIPOS")
    private String sfaPrototipos;
    @Size(max = 4000)
    @Column(name = "SFA_PROPIEDAD_INTELECTO")
    private String sfaPropiedadIntelecto;
    @Size(max = 4000)
    @Column(name = "SFA_EMPRESA_SPIN")
    private String sfaEmpresaSpin;
    @Size(max = 4000)
    @Column(name = "SFA_ANALISIS_RIESGOS")
    private String sfaAnalisisRiesgos;
    @Size(max = 4000)
    @Column(name = "SFA_OTROS")
    private String sfaOtros;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public SeaFormatoViabilidad() {
    }

    public SeaFormatoViabilidad(BigDecimal sfaId) {
        this.sfaId = sfaId;
    }

    public BigDecimal getSfaId() {
        return sfaId;
    }

    public void setSfaId(BigDecimal sfaId) {
        this.sfaId = sfaId;
    }

    public String getSfaViavilidadTec() {
        return sfaViavilidadTec;
    }

    public void setSfaViavilidadTec(String sfaViavilidadTec) {
        this.sfaViavilidadTec = sfaViavilidadTec;
    }

    public String getSfaEquipamientoTec() {
        return sfaEquipamientoTec;
    }

    public void setSfaEquipamientoTec(String sfaEquipamientoTec) {
        this.sfaEquipamientoTec = sfaEquipamientoTec;
    }

    public String getSfaPerderPais() {
        return sfaPerderPais;
    }

    public void setSfaPerderPais(String sfaPerderPais) {
        this.sfaPerderPais = sfaPerderPais;
    }

    public String getSfaImpactosEsperados() {
        return sfaImpactosEsperados;
    }

    public void setSfaImpactosEsperados(String sfaImpactosEsperados) {
        this.sfaImpactosEsperados = sfaImpactosEsperados;
    }

    public String getSfaDisponeMetodologia() {
        return sfaDisponeMetodologia;
    }

    public void setSfaDisponeMetodologia(String sfaDisponeMetodologia) {
        this.sfaDisponeMetodologia = sfaDisponeMetodologia;
    }

    public String getSfaImpactoAmbiental() {
        return sfaImpactoAmbiental;
    }

    public void setSfaImpactoAmbiental(String sfaImpactoAmbiental) {
        this.sfaImpactoAmbiental = sfaImpactoAmbiental;
    }

    public String getSfaSostenibilidadSocial() {
        return sfaSostenibilidadSocial;
    }

    public void setSfaSostenibilidadSocial(String sfaSostenibilidadSocial) {
        this.sfaSostenibilidadSocial = sfaSostenibilidadSocial;
    }

    public String getSfaTranferenciaTecno() {
        return sfaTranferenciaTecno;
    }

    public void setSfaTranferenciaTecno(String sfaTranferenciaTecno) {
        this.sfaTranferenciaTecno = sfaTranferenciaTecno;
    }

    public String getSfaArticulosCientificos() {
        return sfaArticulosCientificos;
    }

    public void setSfaArticulosCientificos(String sfaArticulosCientificos) {
        this.sfaArticulosCientificos = sfaArticulosCientificos;
    }

    public String getSfaPrototipos() {
        return sfaPrototipos;
    }

    public void setSfaPrototipos(String sfaPrototipos) {
        this.sfaPrototipos = sfaPrototipos;
    }

    public String getSfaPropiedadIntelecto() {
        return sfaPropiedadIntelecto;
    }

    public void setSfaPropiedadIntelecto(String sfaPropiedadIntelecto) {
        this.sfaPropiedadIntelecto = sfaPropiedadIntelecto;
    }

    public String getSfaEmpresaSpin() {
        return sfaEmpresaSpin;
    }

    public void setSfaEmpresaSpin(String sfaEmpresaSpin) {
        this.sfaEmpresaSpin = sfaEmpresaSpin;
    }

    public String getSfaAnalisisRiesgos() {
        return sfaAnalisisRiesgos;
    }

    public void setSfaAnalisisRiesgos(String sfaAnalisisRiesgos) {
        this.sfaAnalisisRiesgos = sfaAnalisisRiesgos;
    }

    public String getSfaOtros() {
        return sfaOtros;
    }

    public void setSfaOtros(String sfaOtros) {
        this.sfaOtros = sfaOtros;
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
        hash += (sfaId != null ? sfaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoViabilidad)) {
            return false;
        }
        SeaFormatoViabilidad other = (SeaFormatoViabilidad) object;
        if ((this.sfaId == null && other.sfaId != null) || (this.sfaId != null && !this.sfaId.equals(other.sfaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFormatoViabilidad[ sfaId=" + sfaId + " ]";
    }
    
}
