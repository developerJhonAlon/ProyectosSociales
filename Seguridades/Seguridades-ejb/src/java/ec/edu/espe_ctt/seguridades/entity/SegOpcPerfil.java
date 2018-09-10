/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEG_OPC_PERFIL",schema = "SISEAC" )
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegOpcPerfil.findAll", query = "SELECT s FROM SegOpcPerfil s"),
    @NamedQuery(name = "SegOpcPerfil.findByOppId", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppId = :oppId"),
    @NamedQuery(name = "SegOpcPerfil.findByOppActInact", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppActInact = :oppActInact"),
    @NamedQuery(name = "SegOpcPerfil.findByOppNuevo", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppNuevo = :oppNuevo"),
    @NamedQuery(name = "SegOpcPerfil.findByOppEliminar", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppEliminar = :oppEliminar"),
    @NamedQuery(name = "SegOpcPerfil.findByOppEditar", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppEditar = :oppEditar"),
    @NamedQuery(name = "SegOpcPerfil.findByOppImprimir", query = "SELECT s FROM SegOpcPerfil s WHERE s.oppImprimir = :oppImprimir")})
public class SegOpcPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ID")
    private BigDecimal oppId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ACT_INACT")
    private BigInteger oppActInact;
    @Column(name = "OPP_NUEVO")
    private BigInteger oppNuevo;
    @Column(name = "OPP_ELIMINAR")
    private BigInteger oppEliminar;
    @Column(name = "OPP_EDITAR")
    private BigInteger oppEditar;
    @Column(name = "OPP_IMPRIMIR")
    private BigInteger oppImprimir;
      @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    
    private SegOpcion segOpcion;

    public SegOpcPerfil() {
    }

    public SegOpcPerfil(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public SegOpcPerfil(BigDecimal oppId, BigInteger oppActInact) {
        this.oppId = oppId;
        this.oppActInact = oppActInact;
    }

    public BigDecimal getOppId() {
        return oppId;
    }

    public void setOppId(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public BigInteger getOppActInact() {
        return oppActInact;
    }

    public void setOppActInact(BigInteger oppActInact) {
        this.oppActInact = oppActInact;
    }

    public BigInteger getOppNuevo() {
        return oppNuevo;
    }

    public void setOppNuevo(BigInteger oppNuevo) {
        this.oppNuevo = oppNuevo;
    }

    public BigInteger getOppEliminar() {
        return oppEliminar;
    }

    public void setOppEliminar(BigInteger oppEliminar) {
        this.oppEliminar = oppEliminar;
    }

    public BigInteger getOppEditar() {
        return oppEditar;
    }

    public void setOppEditar(BigInteger oppEditar) {
        this.oppEditar = oppEditar;
    }

    public BigInteger getOppImprimir() {
        return oppImprimir;
    }

    public void setOppImprimir(BigInteger oppImprimir) {
        this.oppImprimir = oppImprimir;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    public SegOpcion getSegOpcion() {
        return segOpcion;
    }

    public void setSegOpcion(SegOpcion segOpcion) {
        this.segOpcion = segOpcion;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oppId != null ? oppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOpcPerfil)) {
            return false;
        }
        SegOpcPerfil other = (SegOpcPerfil) object;
        if ((this.oppId == null && other.oppId != null) || (this.oppId != null && !this.oppId.equals(other.oppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegOpcPerfil[ oppId=" + oppId + " ]";
    }
    
}
