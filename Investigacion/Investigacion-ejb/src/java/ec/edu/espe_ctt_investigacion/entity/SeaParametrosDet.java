/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PARAMETROS_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaParametrosDet.findAll", query = "SELECT s FROM SeaParametrosDet s"),
    @NamedQuery(name = "SeaParametrosDet.findByPrdId", query = "SELECT s FROM SeaParametrosDet s WHERE s.prdId = :prdId"),
    @NamedQuery(name = "SeaParametrosDet.findByPrdIdAlt", query = "SELECT s FROM SeaParametrosDet s WHERE s.prdIdAlt = :prdIdAlt"),
    @NamedQuery(name = "SeaParametrosDet.findByPrdDescripcion", query = "SELECT s FROM SeaParametrosDet s WHERE s.prdDescripcion = :prdDescripcion"),
    @NamedQuery(name = "SeaParametrosDet.findByPrdEstado", query = "SELECT s FROM SeaParametrosDet s WHERE s.prdEstado = :prdEstado"),
    @NamedQuery(name = "SeaParametrosDet.findByPrdOrden", query = "SELECT s FROM SeaParametrosDet s WHERE s.prdOrden = :prdOrden")})
public class SeaParametrosDet implements Serializable {

    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaFormatoLargo> seaFormatoLargoList;
    @OneToMany(mappedBy = "prdIdCategoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaFormatoLargo> seaFormatoLargoList1;
    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProy> seaDatGeneralProyList;
    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaParesConvoca> seaParesConvocaList;
    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaComisionXConvoca> seaComisionXConvocaList;
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SEQ_SEA_PARAMETROS_DET", sequenceName = "SEQ_SEA_PARAMETROS_DET", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PARAMETROS_DET")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRD_ID")
    private Long prdId;
    public final static Long PARAM_TIPO_COMPROMISO_PARTICIPACION_ENTIDAD = new Long(316);
    public final static Long PARAM_TIPO_COMPROMISO_PARTICIPACION_COMUNIDAD = new Long(317);

    public final static Long PARAM_TIPO_ORGANIZACION_INSTITUCION_PUBLICA = new Long(309);
    public final static Long PARAM_TIPO_ORGANIZACION_INSTITUCION_PRIVADA = new Long(310);
    public final static Long PARAM_TIPO_ORGANIZACION_ONG = new Long(311);
    public final static Long PARAM_TIPO_ORGANIZACION_RURAL = new Long(312);
    public final static Long PARAM_TIPO_ORGANIZACION_URBANO_MARGINAL = new Long(313);
    public final static Long PARAM_TIPO_ORGANIZACION_GRUPO_ATENCION_PRIORITARIA = new Long(314);
    public final static Long PARAM_TIPO_ORGANIZACION_OTROS = new Long(315);

    public final static Long PARAM_TIPO_POBLACION_BENEFICIARIA_URBANO_MARGINAL = new Long(294);
    public final static Long PARAM_TIPO_POBLACION_BENEFICIARIA_RURAL = new Long(295);
    public final static Long PARAM_TIPO_POBLACION_GRUPO_ATENCION_PRIORITARIA = new Long(301);

    public final static Long ESTADO_CREADO = new Long(341);
    public final static Long ESTADO_REVISION = new Long(342);
    public final static Long ESTADO_CERRADO_PERFIL = new Long(343);
    public final static Long ESTADO_CERRADO_CALIFICACION = new Long(344);
    public final static Long ESTADO_RECHAZADO_COMISION_VINCULACION = new Long(345);
    public final static Long ESTADO_APROBADO_COMISION_VINCULACION = new Long(346);
    public final static Long ESTADO_RECHAZADO_VICERRECTORADO = new Long(347);
    public final static Long ESTADO_APROBADO_VICERRECTORADO = new Long(348);
    public final static Long ESTADO_RECHAZADO_CONSEJO_ACADEMICO = new Long(349);
    public final static Long ESTADO_APROBADO_CONSEJO_ACADEMICO = new Long(350);
    public final static Long ESTADO_CERRADO_EJECUCION = new Long(351);
    public final static Long ESTADO_CERRADO = new Long(352);
    public final static Long ESTADO_EVALUADO = new Long(353);

    public final static Long COBERTURA_NACIONAL = new Long(354);
    public final static Long COBERTURA_PROVINCIAL = new Long(355);
    public final static Long COBERTURA_CANTONAL = new Long(356);
    public final static Long COBERTURA_PARROQUIAL = new Long(357);
    
    
    public final static Long CATEGORIA_INDISPENSABLE = new Long(271);
    public final static Long CATEGORIA_NECESARIO = new Long(272);
    public final static Long CATEGORIA_DESEABLE = new Long(273);
    public final static Long CATEGORIA_ADMISIBLE = new Long(274);
    
    
    public final static Long TIPO_OBJETIVO_FIN = new Long(302);
    public final static Long TIPO_OBJETIVO_GENERAL = new Long(303);
    public final static Long TIPO_OBJETIVO_ESPECIFICO = new Long(304);
    public final static Long TIPO_OBJETIVO_ACTIVIDAD = new Long(308);
    
    

    @Size(max = 20)
    @Column(name = "PRD_ID_ALT")
    private String prdIdAlt;
    @Size(max = 150)
    @Column(name = "PRD_DESCRIPCION")
    private String prdDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PRD_ESTADO")
    private String prdEstado;
    @Column(name = "PRD_ORDEN")
    private BigInteger prdOrden;
    @JoinColumn(name = "PAR_ID", referencedColumnName = "PAR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeaParametros seaParametros;
    @OneToMany(mappedBy = "prdId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaConvoca> seaConvocaList;
    
    public final static Long PARAM_TIPO_INVESTIGACION = new Long(93); 

    public SeaParametrosDet() {
        prdEstado = "A";
    }

    public SeaParametrosDet(Long prdId) {
        this.prdId = prdId;
    }

    public SeaParametrosDet(Long prdId, String prdEstado) {
        this.prdId = prdId;
        this.prdEstado = prdEstado;
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public String getPrdIdAlt() {
        return prdIdAlt;
    }

    public void setPrdIdAlt(String prdIdAlt) {
        this.prdIdAlt = prdIdAlt;
    }

    public String getPrdDescripcion() {
        return prdDescripcion;
    }

    public void setPrdDescripcion(String prdDescripcion) {
        this.prdDescripcion = prdDescripcion;
    }

    public String getPrdEstado() {
        return prdEstado;
    }

    public void setPrdEstado(String prdEstado) {
        this.prdEstado = prdEstado;
    }

    public BigInteger getPrdOrden() {
        return prdOrden;
    }

    public void setPrdOrden(BigInteger prdOrden) {
        this.prdOrden = prdOrden;
    }

    public SeaParametros getSeaParametros() {
        return seaParametros;
    }

    public void setSeaParametros(SeaParametros seaParametros) {
        this.seaParametros = seaParametros;
    }

    @XmlTransient
    public List<SeaConvoca> getSeaConvocaList() {
        return seaConvocaList;
    }

    public void setSeaConvocaList(List<SeaConvoca> seaConvocaList) {
        this.seaConvocaList = seaConvocaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdId != null ? prdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaParametrosDet)) {
            return false;
        }
        SeaParametrosDet other = (SeaParametrosDet) object;
        if ((this.prdId == null && other.prdId != null) || (this.prdId != null && !this.prdId.equals(other.prdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet[ prdId=" + prdId + " ]";
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
    public List<SeaFormatoLargo> getSeaFormatoLargoList() {
        return seaFormatoLargoList;
    }

    public void setSeaFormatoLargoList(List<SeaFormatoLargo> seaFormatoLargoList) {
        this.seaFormatoLargoList = seaFormatoLargoList;
    }

    @XmlTransient
    public List<SeaFormatoLargo> getSeaFormatoLargoList1() {
        return seaFormatoLargoList1;
    }

    public void setSeaFormatoLargoList1(List<SeaFormatoLargo> seaFormatoLargoList1) {
        this.seaFormatoLargoList1 = seaFormatoLargoList1;
    }

    @XmlTransient
    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
        return seaDatGeneralProyList;
    }

    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
        this.seaDatGeneralProyList = seaDatGeneralProyList;
    }

    @Transient
    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
