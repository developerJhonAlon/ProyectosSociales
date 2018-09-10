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
@Table(name = "SZTAINANEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztainanex.findAll", query = "SELECT s FROM Sztainanex s"),
    @NamedQuery(name = "Sztainanex.findBySztainanexCode", query = "SELECT s FROM Sztainanex s WHERE s.sztainanexCode = :sztainanexCode"),
    @NamedQuery(name = "Sztainanex.findBySztainanexAnexoNombre", query = "SELECT s FROM Sztainanex s WHERE s.sztainanexAnexoNombre = :sztainanexAnexoNombre")})
public class Sztainanex implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZTAINANEX", sequenceName = "SEQ_SZTAINANEX", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZTAINANEX")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAINANEX_CODE")
    private BigDecimal sztainanexCode;
    @Size(max = 250)
    @Column(name = "SZTAINANEX_ANEXO_NOMBRE")
    private String sztainanexAnexoNombre;
    @Lob
    @Column(name = "SZTAINANEX_ANEXO_DIGI")
    private byte[] sztainanexAnexoDigi;
    @JoinColumn(name = "DATGEPROY_ID", referencedColumnName = "DATGEPROY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaDatGeneralProy datgeproyId;
    @Column(name = "SZTAINANEX_ESTADO")
    private Character tipoAnexo;

    public final static Character TIPO_IMAGEN_RESUMEN = 'R';
    public final static Character TIPO_IMAGEN_OBJETIVO = 'D';
    public final static Character TIPO_ANEXO_PROYECTO = 'P';

    public Sztainanex() {
    }

    public Sztainanex(BigDecimal sztainanexCode) {
        this.sztainanexCode = sztainanexCode;
    }

    public BigDecimal getSztainanexCode() {
        return sztainanexCode;
    }

    public void setSztainanexCode(BigDecimal sztainanexCode) {
        this.sztainanexCode = sztainanexCode;
    }

    public String getSztainanexAnexoNombre() {
        return sztainanexAnexoNombre;
    }

    public void setSztainanexAnexoNombre(String sztainanexAnexoNombre) {
        this.sztainanexAnexoNombre = sztainanexAnexoNombre;
    }

    public byte[] getSztainanexAnexoDigi() {
        return sztainanexAnexoDigi;
    }

    public void setSztainanexAnexoDigi(byte[] sztainanexAnexoDigi) {
        this.sztainanexAnexoDigi = sztainanexAnexoDigi;
    }

    public SeaDatGeneralProy getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(SeaDatGeneralProy datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public Character getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(Character tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztainanexCode != null ? sztainanexCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztainanex)) {
            return false;
        }
        Sztainanex other = (Sztainanex) object;
        if ((this.sztainanexCode == null && other.sztainanexCode != null) || (this.sztainanexCode != null && !this.sztainanexCode.equals(other.sztainanexCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztainanex[ sztainanexCode=" + sztainanexCode + " ]";
    }

}
