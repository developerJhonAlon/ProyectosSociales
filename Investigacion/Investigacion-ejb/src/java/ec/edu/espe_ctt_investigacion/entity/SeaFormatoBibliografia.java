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
@Table(name = "SEA_FORMATO_BIBLIOGRAFIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaFormatoBibliografia.findAll", query = "SELECT s FROM SeaFormatoBibliografia s"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbId", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbId = :sfbId"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbAutor", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbAutor = :sfbAutor"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbTitulo", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbTitulo = :sfbTitulo"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbEdicion", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbEdicion = :sfbEdicion"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbAnio", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbAnio = :sfbAnio"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbEditorial", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbEditorial = :sfbEditorial"),
    @NamedQuery(name = "SeaFormatoBibliografia.findBySfbIdioma", query = "SELECT s FROM SeaFormatoBibliografia s WHERE s.sfbIdioma = :sfbIdioma")})
public class SeaFormatoBibliografia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_FORMATO_BIBLIOGRAFIA", sequenceName = "SEQ_SEA_FORMATO_BIBLIOGRAFIA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_FORMATO_BIBLIOGRAFIA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFB_ID")
    private BigDecimal sfbId;
    @Size(max = 2000)
    @Column(name = "SFB_AUTOR")
    private String sfbAutor;
    @Size(max = 2000)
    @Column(name = "SFB_TITULO")
    private String sfbTitulo;
    @Size(max = 50)
    @Column(name = "SFB_EDICION")
    private String sfbEdicion;
    @Size(max = 4)
    @Column(name = "SFB_ANIO")
    private String sfbAnio;
    @Size(max = 50)
    @Column(name = "SFB_EDITORIAL")
    private String sfbEditorial;
    @Size(max = 50)
    @Column(name = "SFB_IDIOMA")
    private String sfbIdioma;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @Size(max = 50)
    @Column(name = "SFB_NUMPAG")
    private String sfbNumpag;
    @Size(max = 1000)
    @Column(name = "SFB_URL")
    private String sfbUrl;
    @Size(max = 2000)
    @Column(name = "SFB_OBSERVACION")
    private String sfbObservacion;

    public SeaFormatoBibliografia() {
    }

    public SeaFormatoBibliografia(BigDecimal sfbId) {
        this.sfbId = sfbId;
    }

    public BigDecimal getSfbId() {
        return sfbId;
    }

    public void setSfbId(BigDecimal sfbId) {
        this.sfbId = sfbId;
    }

    public String getSfbAutor() {
        return sfbAutor;
    }

    public void setSfbAutor(String sfbAutor) {
        this.sfbAutor = sfbAutor;
    }

    public String getSfbTitulo() {
        return sfbTitulo;
    }

    public void setSfbTitulo(String sfbTitulo) {
        this.sfbTitulo = sfbTitulo;
    }

    public String getSfbEdicion() {
        return sfbEdicion;
    }

    public void setSfbEdicion(String sfbEdicion) {
        this.sfbEdicion = sfbEdicion;
    }

    public String getSfbAnio() {
        return sfbAnio;
    }

    public void setSfbAnio(String sfbAnio) {
        this.sfbAnio = sfbAnio;
    }

    public String getSfbEditorial() {
        return sfbEditorial;
    }

    public void setSfbEditorial(String sfbEditorial) {
        this.sfbEditorial = sfbEditorial;
    }

    public String getSfbIdioma() {
        return sfbIdioma;
    }

    public void setSfbIdioma(String sfbIdioma) {
        this.sfbIdioma = sfbIdioma;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    public String getSfbNumpag() {
        return sfbNumpag;
    }

    public void setSfbNumpag(String sfbNumpag) {
        this.sfbNumpag = sfbNumpag;
    }

    public String getSfbUrl() {
        return sfbUrl;
    }

    public void setSfbUrl(String sfbUrl) {
        this.sfbUrl = sfbUrl;
    }

    public String getSfbObservacion() {
        return sfbObservacion;
    }

    public void setSfbObservacion(String sfbObservacion) {
        this.sfbObservacion = sfbObservacion;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfbId != null ? sfbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaFormatoBibliografia)) {
            return false;
        }
        SeaFormatoBibliografia other = (SeaFormatoBibliografia) object;
        if ((this.sfbId == null && other.sfbId != null) || (this.sfbId != null && !this.sfbId.equals(other.sfbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaFormatoBibliografia[ sfbId=" + sfbId + " ]";
    }
    
}
