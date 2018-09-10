/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.imageio.ImageIO;
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
@Table(name = "SEG_OPCION",schema = "SISEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegOpcion.findAll", query = "SELECT s FROM SegOpcion s"),
    @NamedQuery(name = "SegOpcion.findByOpcId", query = "SELECT s FROM SegOpcion s WHERE s.opcId = :opcId"),
    @NamedQuery(name = "SegOpcion.findByOpcNombre", query = "SELECT s FROM SegOpcion s WHERE s.opcNombre = :opcNombre"),
    @NamedQuery(name = "SegOpcion.findByOpcNivel", query = "SELECT s FROM SegOpcion s WHERE s.opcNivel = :opcNivel"),
    @NamedQuery(name = "SegOpcion.findByOpcOrden", query = "SELECT s FROM SegOpcion s WHERE s.opcOrden = :opcOrden"),
    @NamedQuery(name = "SegOpcion.findByOpcUrl", query = "SELECT s FROM SegOpcion s WHERE s.opcUrl = :opcUrl")})
public class SegOpcion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEG_OPCION", sequenceName = "SEQ_SEG_OPCION", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_SEG_OPCION")    
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "OPC_ID")
    private BigDecimal opcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "OPC_NOMBRE")
    private String opcNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_NIVEL")
    private BigInteger opcNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_ORDEN")
    private BigInteger opcOrden;
    @Size(max=60)
    @Column(name = "OPC_IMAGEN")
    private String opcImagen;
    @Size(max = 128)
    @Column(name = "OPC_URL")
     private String opcUrl;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "segOpcion")
    private List<SegOpcPerfil> segOpcPerfilList;
    @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
    @ManyToOne(optional = false)
    private SegSistemas segSistemas;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "segOpcion")
    private List<SegOpcion> segOpcionList;
    @JoinColumn(name = "SEG_OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne
    private SegOpcion segOpcion;

   ;
      @Transient
    private Collection<SegOpcion> lhijos;
      
     
    

       
    public SegOpcion() {
    }

    public SegOpcion(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public SegOpcion(BigDecimal opcId, String opcNombre, BigInteger opcNivel, BigInteger opcOrden) {
        this.opcId = opcId;
        this.opcNombre = opcNombre;
        this.opcNivel = opcNivel;
        this.opcOrden = opcOrden;
    }

    public BigDecimal getOpcId() {
        return opcId;
    }

    public void setOpcId(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public String getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(String opcNombre) {
        this.opcNombre = opcNombre;
    }

    public BigInteger getOpcNivel() {
        return opcNivel;
    }

    public void setOpcNivel(BigInteger opcNivel) {
        this.opcNivel = opcNivel;
    }

    public BigInteger getOpcOrden() {
        return opcOrden;
    }

    public void setOpcOrden(BigInteger opcOrden) {
        this.opcOrden = opcOrden;
    }

    public String getOpcUrl() {
        return opcUrl;
    }

    public void setOpcUrl(String opcUrl) {
        this.opcUrl = opcUrl;
    }

    public Collection<SegOpcion> getLhijos() {
        return lhijos;
    }

    public void setLhijos(Collection<SegOpcion> lhijos) {
        this.lhijos = lhijos;
    }

    public SegSistemas getSegSistemas() {
        return segSistemas;
    }

    public void setSegSistemas(SegSistemas segSistemas) {
        this.segSistemas = segSistemas;
    }

    public SegOpcion getSegOpcion() {
        return segOpcion;
    }

    public void setSegOpcion(SegOpcion segOpcion) {
        this.segOpcion = segOpcion;
    }

    public String getOpcImagen() {
        return opcImagen;
    }

    public void setOpcImagen(String opcImagen) {
        this.opcImagen = opcImagen;
    }

   

    
    @XmlTransient
    public List<SegOpcPerfil> getSegOpcPerfilList() {
        return segOpcPerfilList;
    }

    public void setSegOpcPerfilList(List<SegOpcPerfil> segOpcPerfilList) {
        this.segOpcPerfilList = segOpcPerfilList;
    }

  
    @XmlTransient
    public List<SegOpcion> getSegOpcionList() {
        return segOpcionList;
    }

    public void setSegOpcionList(List<SegOpcion> segOpcionList) {
        this.segOpcionList = segOpcionList;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcId != null ? opcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOpcion)) {
            return false;
        }
        SegOpcion other = (SegOpcion) object;
        if ((this.opcId == null && other.opcId != null) || (this.opcId != null && !this.opcId.equals(other.opcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegOpcion[ opcId=" + opcId + " ]";
    }
    
}
