/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SEA_OBJ_ENTREGABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaObjEntregables.findAll", query = "SELECT s FROM SeaObjEntregables s"),
    @NamedQuery(name = "SeaObjEntregables.findBySoeId", query = "SELECT s FROM SeaObjEntregables s WHERE s.soeId = :soeId"),
    @NamedQuery(name = "SeaObjEntregables.findBySoeDescripcion", query = "SELECT s FROM SeaObjEntregables s WHERE s.soeDescripcion = :soeDescripcion")})
public class SeaObjEntregables implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_OBJ_ENTREGABLES", sequenceName = "SEQ_SEA_OBJ_ENTREGABLES", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_OBJ_ENTREGABLES")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOE_ID")
    private BigDecimal soeId;
    @Size(max = 500)
    @Column(name = "SOE_DESCRIPCION")
    private String soeDescripcion;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    
    @OneToMany(mappedBy = "soeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaObjAdquisisiones> adquisicionList;

    

    public SeaObjEntregables() {
    }

    public SeaObjEntregables(BigDecimal soeId) {
        this.soeId = soeId;
    }

    public BigDecimal getSoeId() {
        return soeId;
    }

    public void setSoeId(BigDecimal soeId) {
        this.soeId = soeId;
    }

    public String getSoeDescripcion() {
        return soeDescripcion;
    }

    public void setSoeDescripcion(String soeDescripcion) {
        this.soeDescripcion = soeDescripcion;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }
    
    public SeaParametrosDet getPrdId() {
        return prdId;
    }

    public void setPrdId(SeaParametrosDet prdId) {
        this.prdId = prdId;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soeId != null ? soeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaObjEntregables)) {
            return false;
        }
        SeaObjEntregables other = (SeaObjEntregables) object;
        if ((this.soeId == null && other.soeId != null) || (this.soeId != null && !this.soeId.equals(other.soeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SeaObjEntregables[ soeId=" + soeId + " ]";
    }

    public List<SeaObjAdquisisiones> getAdquisicionList() {
        return adquisicionList;
    }

    public void setAdquisicionList(List<SeaObjAdquisisiones> adquisicionList) {
        this.adquisicionList = adquisicionList;
    }
    
    
    
}
