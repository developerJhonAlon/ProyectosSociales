/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "SEA_CONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaConvoca.findAll", query = "SELECT s FROM SeaConvoca s"),
    @NamedQuery(name = "SeaConvoca.findByConvocaId", query = "SELECT s FROM SeaConvoca s WHERE s.convocaId = :convocaId"),
    @NamedQuery(name = "SeaConvoca.findByConvocaTitulo", query = "SELECT s FROM SeaConvoca s WHERE s.convocaTitulo = :convocaTitulo"),
    @NamedQuery(name = "SeaConvoca.findByConvocaDocNombre", query = "SELECT s FROM SeaConvoca s WHERE s.convocaDocNombre = :convocaDocNombre"),
    @NamedQuery(name = "SeaConvoca.findByConvocaSecuencial", query = "SELECT s FROM SeaConvoca s WHERE s.convocaSecuencial = :convocaSecuencial")})

public class SeaConvoca implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_CONVOCA", sequenceName = "SEQ_SEA_CONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_CONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONVOCA_ID")
    private BigDecimal convocaId;
    @Size(max = 250)
    @Column(name = "CONVOCA_TITULO")
    private String convocaTitulo;
    @Size(max = 500)
    @Column(name = "CONVOCA_DOC_NOMBRE")
    private String convocaDocNombre;
    @Lob
    @Column(name = "CONVOCA_DIGITAL")
    private Serializable convocaDigital;
    @Size(max = 4)
    @Column(name = "CONVOCA_ANIO")
    private String convocaAnio;
    @Column(name = "CONVOCA_SECUENCIAL")
    private BigInteger convocaSecuencial;
    @Column(name = "CONVOCA_FINANCIAMIENTO")
    private BigDecimal convocaFinanciamiento;
    @Column(name = "CONVOCA_CODIGO")
    private String convocaCodigo;
    @Column(name = "CONVOCA_CALIFICA1")
    private String convocaCalifica1;
    @Column(name = "CONVOCA_EVALUA1")
    private String convocaEvalua1;
    @Column(name = "CONVOCA_CALIFICA2")
    private String convocaCalifica2;
    @Column(name = "CONVOCA_EVALUA2")
    private String convocaEvalua2;
    @Column(name = "CONVOCA_FORMATO_FASE1")
    private String convocaFormatoF1;
    @Column(name = "CONVOCA_FORMATO_FASE2")
    private String convocaFormatoF2;
    @Column(name = "CONVOCA_SELEC_PRIORI_FASE2")
    private String convocaSeleccionF2;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaBasesConvoca> seaBasesConvocaList;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @Column(name = "CONVOCA_FECHA_INICIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convocaFechaInicia;
    @Column(name = "CONVOCA_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convocaFechaFin;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuId;
    @Column(name = "CONVOCA_ESTADO")
    private String convocaEstado;
    @Size(max = 2000)
    @Column(name = "CONVOCA_FINANC_OBSERV")
    private String financiamientoObservaciones;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProy> seaDatGeneralProyList;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaParesConvoca> seaParesConvocaList;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaComisionXConvoca> seaComisionXConvocaList;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaFinanciaConvoca> financiamientoRecursoList;
    @OneToMany(mappedBy = "convocaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaNoFinanciaConvoca> noFinanciamientoRecursoList;
    @Size(max = 1000)
    @Column(name = "CONVOCA_DOC_COMISION_NOM")
    private String documentoComisionNombre;
    @Lob
    @Column(name = "CONVOCA_DOC_COMISION_DIG")
    private byte[] documentoComisionDigital;

    public SeaConvoca() {
        convocaFinanciamiento = BigDecimal.ZERO;
    }

    public SeaConvoca(BigDecimal convocaId) {
        this.convocaId = convocaId;
    }

    public BigDecimal getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(BigDecimal convocaId) {
        this.convocaId = convocaId;
    }

    public String getConvocaTitulo() {
        return convocaTitulo;
    }

    public void setConvocaTitulo(String convocaTitulo) {
        this.convocaTitulo = convocaTitulo;
    }

    public String getConvocaDocNombre() {
        return convocaDocNombre;
    }

    public void setConvocaDocNombre(String convocaDocNombre) {
        this.convocaDocNombre = convocaDocNombre;
    }

    public Serializable getConvocaDigital() {
        return convocaDigital;
    }

    public void setConvocaDigital(Serializable convocaDigital) {
        this.convocaDigital = convocaDigital;
    }

    public BigDecimal getConvocaFinanciamiento() {
        return convocaFinanciamiento;
    }

    public void setConvocaFinanciamiento(BigDecimal convocaFinanciamiento) {
        this.convocaFinanciamiento = convocaFinanciamiento;
    }

    public String getConvocaAnio() {
        return convocaAnio;
    }

    public void setConvocaAnio(String convocaAnio) {
        this.convocaAnio = convocaAnio;
    }

    public BigInteger getConvocaSecuencial() {
        return convocaSecuencial;
    }

    public void setConvocaSecuencial(BigInteger convocaSecuencial) {
        this.convocaSecuencial = convocaSecuencial;
    }

    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }

    public String getConvocaCodigo() {
        return convocaCodigo;
    }

    public void setConvocaCodigo(String convocaCodigo) {
        this.convocaCodigo = convocaCodigo;
    }

    public String getConvocaCalifica1() {
        return convocaCalifica1;
    }

    public void setConvocaCalifica1(String convocaCalifica1) {
        this.convocaCalifica1 = convocaCalifica1;
    }

    public String getConvocaEvalua1() {
        return convocaEvalua1;
    }

    public void setConvocaEvalua1(String convocaEvalua1) {
        this.convocaEvalua1 = convocaEvalua1;
    }

    public String getConvocaCalifica2() {
        return convocaCalifica2;
    }

    public void setConvocaCalifica2(String convocaCalifica2) {
        this.convocaCalifica2 = convocaCalifica2;
    }

    public String getConvocaEvalua2() {
        return convocaEvalua2;
    }

    public void setConvocaEvalua2(String convocaEvalua2) {
        this.convocaEvalua2 = convocaEvalua2;
    }

    public String getConvocaFormatoF1() {
        return convocaFormatoF1;
    }

    public void setConvocaFormatoF1(String convocaFormatoF1) {
        this.convocaFormatoF1 = convocaFormatoF1;
    }

    public String getConvocaSeleccionF2() {
        return convocaSeleccionF2;
    }

    public void setConvocaSeleccionF2(String convocaSeleccionF2) {
        this.convocaSeleccionF2 = convocaSeleccionF2;
    }

    public String getConvocaFormatoF2() {
        return convocaFormatoF2;
    }

    public void setConvocaFormatoF2(String convocaFormatoF2) {
        this.convocaFormatoF2 = convocaFormatoF2;
    }

    public Date getConvocaFechaInicia() {
        return convocaFechaInicia;
    }

    public void setConvocaFechaInicia(Date convocaFechaInicia) {
        this.convocaFechaInicia = convocaFechaInicia;
    }

    public Date getConvocaFechaFin() {
        return convocaFechaFin;
    }

    public void setConvocaFechaFin(Date convocaFechaFin) {
        this.convocaFechaFin = convocaFechaFin;
    }

    public SegUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SegUsuario usuId) {
        this.usuId = usuId;
    }

    public String getConvocaEstado() {
        return convocaEstado;
    }

    public void setConvocaEstado(String convocaEstado) {
        this.convocaEstado = convocaEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (convocaId != null ? convocaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaConvoca)) {
            return false;
        }
        SeaConvoca other = (SeaConvoca) object;
        if ((this.convocaId == null && other.convocaId != null) || (this.convocaId != null && !this.convocaId.equals(other.convocaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaConvoca[ convocaId=" + convocaId + " ]";
    }

    @XmlTransient
    public List<SeaBasesConvoca> getSeaBasesConvocaList() {
        return seaBasesConvocaList;
    }

    public void setSeaBasesConvocaList(List<SeaBasesConvoca> seaBasesConvocaList) {
        this.seaBasesConvocaList = seaBasesConvocaList;
    }

    @XmlTransient
    public List<SeaComisionXConvoca> getSeaComisionXConvocaList() {
        return seaComisionXConvocaList;
    }

    public void setSeaComisionXConvocaList(List<SeaComisionXConvoca> seaComisionXConvocaList) {
        this.seaComisionXConvocaList = seaComisionXConvocaList;
    }

    @XmlTransient
    public List<SeaPorcenXCrConvoca> getSeaPorcenXCrConvocaList() {
        return seaPorcenXCrConvocaList;
    }

    public void setSeaPorcenXCrConvocaList(List<SeaPorcenXCrConvoca> seaPorcenXCrConvocaList) {
        this.seaPorcenXCrConvocaList = seaPorcenXCrConvocaList;
    }

    @XmlTransient
    public List<SeaParesConvoca> getSeaParesConvocaList() {
        return seaParesConvocaList;
    }

    public void setSeaParesConvocaList(List<SeaParesConvoca> seaParesConvocaList) {
        this.seaParesConvocaList = seaParesConvocaList;
    }

    @XmlTransient
    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
        return seaDatGeneralProyList;
    }

    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
        this.seaDatGeneralProyList = seaDatGeneralProyList;
    }

    public String getFinanciamientoObservaciones() {
        return financiamientoObservaciones;
    }

    public void setFinanciamientoObservaciones(String financiamientoObservaciones) {
        this.financiamientoObservaciones = financiamientoObservaciones;
    }

    public List<SeaFinanciaConvoca> getFinanciamientoRecursoList() {
        return financiamientoRecursoList;
    }

    public void setFinanciamientoRecursoList(List<SeaFinanciaConvoca> financiamientoRecursoList) {
        this.financiamientoRecursoList = financiamientoRecursoList;
    }

    public void addFinanciamientoRecurso(SeaFinanciaConvoca financiamientoRecurso) throws Exception {
        if (financiamientoRecursoList == null) {
            financiamientoRecursoList = new ArrayList<>();
        }
        BigInteger porcentajeTotal = BigInteger.ZERO;
        for (SeaFinanciaConvoca fin : financiamientoRecursoList) {
            if (fin.getSrcId().getScpId().equals(financiamientoRecurso.getSrcId().getScpId())) {
                throw new Exception("El recurso ya ha sido agregado");
            }
            porcentajeTotal = porcentajeTotal.add(fin.getSfcPorcentaje());
        }
        porcentajeTotal = porcentajeTotal.add(financiamientoRecurso.getSfcPorcentaje());
        if (porcentajeTotal.compareTo(new BigInteger("100")) > 0) {
            throw new Exception("El porcentaje Total no debe ser mayor a 100");
        }

        SeaFinanciaConvoca financiamientoRecursoNuevo = new SeaFinanciaConvoca();
        financiamientoRecursoNuevo.setConvocaId(this);
        financiamientoRecursoNuevo.setSfcPorcentaje(financiamientoRecurso.getSfcPorcentaje());
        financiamientoRecursoNuevo.setSrcId(financiamientoRecurso.getSrcId());
        //BeanUtils.copyProperties(financiamientoRecursoNuevo, financiamientoRecurso);
        financiamientoRecursoList.add(financiamientoRecursoNuevo);
    }

    public void removeFinanciamientoRecurso(SeaFinanciaConvoca financiamientoRecurso) {
        financiamientoRecursoList.remove(financiamientoRecurso);
    }

    public List<SeaNoFinanciaConvoca> getNoFinanciamientoRecursoList() {
        return noFinanciamientoRecursoList;
    }

    public void setNoFinanciamientoRecursoList(List<SeaNoFinanciaConvoca> noFinanciamientoRecursoList) {
        this.noFinanciamientoRecursoList = noFinanciamientoRecursoList;
    }

    public void removeNoFinanciamientoRecurso(SeaNoFinanciaConvoca seaNoFinanciaConvoca) {
        noFinanciamientoRecursoList.remove(seaNoFinanciaConvoca);
    }

    public void addNoFinanciamientoRecurso(SeaNoFinanciaConvoca seaNoFinanciaConvoca) {
        if (noFinanciamientoRecursoList == null) {
            noFinanciamientoRecursoList = new ArrayList<>();
        }
        SeaNoFinanciaConvoca seaNoFinanciaConvocaNuevo = new SeaNoFinanciaConvoca();
        seaNoFinanciaConvocaNuevo.setConvocaId(this);
        seaNoFinanciaConvocaNuevo.setSnfcDetalle(seaNoFinanciaConvoca.getSnfcDetalle());
        noFinanciamientoRecursoList.add(seaNoFinanciaConvocaNuevo);
    }

    public String getDocumentoComisionNombre() {
        return documentoComisionNombre;
    }

    public void setDocumentoComisionNombre(String documentoComisionNombre) {
        this.documentoComisionNombre = documentoComisionNombre;
    }

    public byte[] getDocumentoComisionDigital() {
        return documentoComisionDigital;
    }

    public void setDocumentoComisionDigital(byte[] documentoComisionDigital) {
        this.documentoComisionDigital = documentoComisionDigital;
    }

    public String getNombrePresidenteComision(){
        if (seaComisionXConvocaList!=null){
            for (SeaComisionXConvoca c : seaComisionXConvocaList) {
                if (c.getTipresId().getTipresId().intValue()==SeaTipoRespons.TIPO_PRESIDENTE_COMISION){
                    return c.getUsuId().getNombresCompletos();
                }
            }
        }
        return null;
    }
}
