/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTALIQPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szdtaliqproy.findAll", query = "SELECT s FROM Szdtaliqproy s"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyCode", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyCode = :szdtaliqproyCode"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyValtot", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyValtot = :szdtaliqproyValtot"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyValespe", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyValespe = :szdtaliqproyValespe"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyValausp", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyValausp = :szdtaliqproyValausp"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyNomausp", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyNomausp = :szdtaliqproyNomausp"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyToteje", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyToteje = :szdtaliqproyToteje"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyComent", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyComent = :szdtaliqproyComent"),
    @NamedQuery(name = "Szdtaliqproy.findBySzdtaliqproyFechIng", query = "SELECT s FROM Szdtaliqproy s WHERE s.szdtaliqproyFechIng = :szdtaliqproyFechIng")})
public class Szdtaliqproy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@SequenceGenerator(name = "SEQ_SZDTALIQPROY", sequenceName = "SEQ_SZDTALIQPROY", allocationSize = 1)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTALIQPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTALIQPROY_CODE")
    private BigDecimal szdtaliqproyCode;
    @Column(name = "SZDTALIQPROY_VALTOT")
    private BigDecimal szdtaliqproyValtot;
    @Column(name = "SZDTALIQPROY_VALESPE")
    private BigDecimal szdtaliqproyValespe;
    @Column(name = "SZDTALIQPROY_VALAUSP")
    private BigDecimal szdtaliqproyValausp;
    @Size(max = 500)
    @Column(name = "SZDTALIQPROY_NOMAUSP")
    private String szdtaliqproyNomausp;
    @Column(name = "SZDTALIQPROY_TOTEJE")
    private BigDecimal szdtaliqproyToteje;
    @Size(max = 4000)
    @Column(name = "SZDTALIQPROY_COMENT")
    private String szdtaliqproyComent;
    @Column(name = "SZDTALIQPROY_FECH_ING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date szdtaliqproyFechIng;
    @Column(name = "SZDTALIQPROY_COST_FPROY")
    private BigDecimal szdtaliqproyCostFproy;
    @Column(name = "SZDTALIQPROY_APOR_FAUSP")
    private BigDecimal szdtaliqproyAporFausp;
    @Size(max = 4000)
    @Column(name = "SZDTALIQPROY_LOGROS")
    private String szdtaliqproyLogros;
    @Size(max = 4000)
    @Column(name = "SZDTALIQPROY_POSIB_APLIC")
    private String szdtaliqproyPosibAplic;
    @Size(max = 4000)
    @Column(name = "SZDTALIQPROY_COMEN_GENER")
    private String szdtaliqproyComenGener;
    @Size(max = 4000)
    @Column(name = "SZDTALIQPROY_DOCU_SOPORT")
    private String szdtaliqproyDocuSoport;
    @Column(name = "SZDTALIQPROY_PROY_CONCL")
    private Character szdtaliqproyProyConcl;
    @Column(name = "SZDTALIQPROY_PRESP_UTIL")
    private Character szdtaliqproyPrespUtil;
    @Lob
    @Column(name = "SZDTALIQPROY_JUST_CONCL")
    private String szdtaliqproyJustConcl;
    @Size(max = 500)
    @Column(name = "SZDTALIQPROY_CONCL_NOM")
    private String szdtaliqproyConclNom;
    @Lob
    @Column(name = "SZDTALIQPROY_CONCL_DIGI")
    private Serializable szdtaliqproyConclDigi;
    @Lob
    @Column(name = "SZDTALIQPROY_JUST_PRESUP")
    private String szdtaliqproyJustPresup;
    @Size(max = 500)
    @Column(name = "SZDTALIQPROY_PRESP_DOCU")
    private String szdtaliqproyPrespDocu;
    @Lob
    @Column(name = "SZDTALIQPROY_PRESP_DIGI")
    private Serializable szdtaliqproyPrespDigi;
    @Lob
    @Column(name = "SZDTALIQPROY_RESL_ALC")
    private String szdtaliqproyReslAlc;
    @Lob
    @Column(name = "SZDTALIQPROY_FACT_FDES")
    private String szdtaliqproyFactFdes;
    @Lob
    @Column(name = "SZDTALIQPROY_FACT_DDES")
    private String szdtaliqproyFactDdes;
    @Lob
    @Column(name = "SZDTALIQPROY_COOR_ACT")
    private String szdtaliqproyCoorAct;
    @Lob
    @Column(name ="SZDTALIQPROY_CONCLUSION" )
    private String szdtaliqproyConclusion;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;

    public Szdtaliqproy() {
    }

    public Szdtaliqproy(BigDecimal szdtaliqproyCode) {
        this.szdtaliqproyCode = szdtaliqproyCode;
    }

    public BigDecimal getSzdtaliqproyCode() {
        return szdtaliqproyCode;
    }

    public void setSzdtaliqproyCode(BigDecimal szdtaliqproyCode) {
        this.szdtaliqproyCode = szdtaliqproyCode;
    }

    public BigDecimal getSzdtaliqproyValtot() {
        return szdtaliqproyValtot;
    }

    public void setSzdtaliqproyValtot(BigDecimal szdtaliqproyValtot) {
        this.szdtaliqproyValtot = szdtaliqproyValtot;
    }

    public BigDecimal getSzdtaliqproyValespe() {
        return szdtaliqproyValespe;
    }

    public void setSzdtaliqproyValespe(BigDecimal szdtaliqproyValespe) {
        this.szdtaliqproyValespe = szdtaliqproyValespe;
    }

    public BigDecimal getSzdtaliqproyValausp() {
        return szdtaliqproyValausp;
    }

    public void setSzdtaliqproyValausp(BigDecimal szdtaliqproyValausp) {
        this.szdtaliqproyValausp = szdtaliqproyValausp;
    }

    public String getSzdtaliqproyNomausp() {
        return szdtaliqproyNomausp;
    }

    public void setSzdtaliqproyNomausp(String szdtaliqproyNomausp) {
        this.szdtaliqproyNomausp = szdtaliqproyNomausp;
    }

    public BigDecimal getSzdtaliqproyToteje() {
        return szdtaliqproyToteje;
    }

    public void setSzdtaliqproyToteje(BigDecimal szdtaliqproyToteje) {
        this.szdtaliqproyToteje = szdtaliqproyToteje;
    }

    public String getSzdtaliqproyComent() {
        return szdtaliqproyComent;
    }

    public void setSzdtaliqproyComent(String szdtaliqproyComent) {
        this.szdtaliqproyComent = szdtaliqproyComent;
    }

    public Date getSzdtaliqproyFechIng() {
        return szdtaliqproyFechIng;
    }

    public void setSzdtaliqproyFechIng(Date szdtaliqproyFechIng) {
        this.szdtaliqproyFechIng = szdtaliqproyFechIng;
    }

    public BigDecimal getSzdtaliqproyCostFproy() {
        return szdtaliqproyCostFproy;
    }

    public void setSzdtaliqproyCostFproy(BigDecimal szdtaliqproyCostFproy) {
        this.szdtaliqproyCostFproy = szdtaliqproyCostFproy;
    }

    public BigDecimal getSzdtaliqproyAporFausp() {
        return szdtaliqproyAporFausp;
    }

    public void setSzdtaliqproyAporFausp(BigDecimal szdtaliqproyAporFausp) {
        this.szdtaliqproyAporFausp = szdtaliqproyAporFausp;
    }

    public String getSzdtaliqproyLogros() {
        return szdtaliqproyLogros;
    }

    public void setSzdtaliqproyLogros(String szdtaliqproyLogros) {
        this.szdtaliqproyLogros = szdtaliqproyLogros;
    }

    public String getSzdtaliqproyPosibAplic() {
        return szdtaliqproyPosibAplic;
    }

    public void setSzdtaliqproyPosibAplic(String szdtaliqproyPosibAplic) {
        this.szdtaliqproyPosibAplic = szdtaliqproyPosibAplic;
    }

    public String getSzdtaliqproyComenGener() {
        return szdtaliqproyComenGener;
    }

    public void setSzdtaliqproyComenGener(String szdtaliqproyComenGener) {
        this.szdtaliqproyComenGener = szdtaliqproyComenGener;
    }

    public String getSzdtaliqproyDocuSoport() {
        return szdtaliqproyDocuSoport;
    }

    public void setSzdtaliqproyDocuSoport(String szdtaliqproyDocuSoport) {
        this.szdtaliqproyDocuSoport = szdtaliqproyDocuSoport;
    }

    public Character getSzdtaliqproyProyConcl() {
        return szdtaliqproyProyConcl;
    }

    public void setSzdtaliqproyProyConcl(Character szdtaliqproyProyConcl) {
        this.szdtaliqproyProyConcl = szdtaliqproyProyConcl;
    }

    public String getSzdtaliqproyJustConcl() {
        return szdtaliqproyJustConcl;
    }

    public void setSzdtaliqproyJustConcl(String szdtaliqproyJustConcl) {
        this.szdtaliqproyJustConcl = szdtaliqproyJustConcl;
    }

    public String getSzdtaliqproyConclNom() {
        return szdtaliqproyConclNom;
    }

    public void setSzdtaliqproyConclNom(String szdtaliqproyConclNom) {
        this.szdtaliqproyConclNom = szdtaliqproyConclNom;
    }

    public Serializable getSzdtaliqproyConclDigi() {
        return szdtaliqproyConclDigi;
    }

    public void setSzdtaliqproyConclDigi(Serializable szdtaliqproyConclDigi) {
        this.szdtaliqproyConclDigi = szdtaliqproyConclDigi;
    }

    public String getSzdtaliqproyJustPresup() {
        return szdtaliqproyJustPresup;
    }

    public void setSzdtaliqproyJustPresup(String szdtaliqproyJustPresup) {
        this.szdtaliqproyJustPresup = szdtaliqproyJustPresup;
    }

    public String getSzdtaliqproyPrespDocu() {
        return szdtaliqproyPrespDocu;
    }

    public void setSzdtaliqproyPrespDocu(String szdtaliqproyPrespDocu) {
        this.szdtaliqproyPrespDocu = szdtaliqproyPrespDocu;
    }

    public Serializable getSzdtaliqproyPrespDigi() {
        return szdtaliqproyPrespDigi;
    }

    public void setSzdtaliqproyPrespDigi(Serializable szdtaliqproyPrespDigi) {
        this.szdtaliqproyPrespDigi = szdtaliqproyPrespDigi;
    }

    public Character getSzdtaliqproyPrespUtil() {
        return szdtaliqproyPrespUtil;
    }

    public void setSzdtaliqproyPrespUtil(Character szdtaliqproyPrespUtil) {
        this.szdtaliqproyPrespUtil = szdtaliqproyPrespUtil;
    }

    

    public String getSzdtaliqproyReslAlc() {
        return szdtaliqproyReslAlc;
    }

    public void setSzdtaliqproyReslAlc(String szdtaliqproyReslAlc) {
        this.szdtaliqproyReslAlc = szdtaliqproyReslAlc;
    }

    public String getSzdtaliqproyFactFdes() {
        return szdtaliqproyFactFdes;
    }

    public void setSzdtaliqproyFactFdes(String szdtaliqproyFactFdes) {
        this.szdtaliqproyFactFdes = szdtaliqproyFactFdes;
    }

    public String getSzdtaliqproyFactDdes() {
        return szdtaliqproyFactDdes;
    }

    public void setSzdtaliqproyFactDdes(String szdtaliqproyFactDdes) {
        this.szdtaliqproyFactDdes = szdtaliqproyFactDdes;
    }

    public String getSzdtaliqproyCoorAct() {
        return szdtaliqproyCoorAct;
    }

    public void setSzdtaliqproyCoorAct(String szdtaliqproyCoorAct) {
        this.szdtaliqproyCoorAct = szdtaliqproyCoorAct;
    }

    public String getSzdtaliqproyConclusion() {
        return szdtaliqproyConclusion;
    }

    public void setSzdtaliqproyConclusion(String szdtaliqproyConclusion) {
        this.szdtaliqproyConclusion = szdtaliqproyConclusion;
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
        hash += (szdtaliqproyCode != null ? szdtaliqproyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szdtaliqproy)) {
            return false;
        }
        Szdtaliqproy other = (Szdtaliqproy) object;
        if ((this.szdtaliqproyCode == null && other.szdtaliqproyCode != null) || (this.szdtaliqproyCode != null && !this.szdtaliqproyCode.equals(other.szdtaliqproyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Szdtaliqproy[ szdtaliqproyCode=" + szdtaliqproyCode + " ]";
    }
    
}
