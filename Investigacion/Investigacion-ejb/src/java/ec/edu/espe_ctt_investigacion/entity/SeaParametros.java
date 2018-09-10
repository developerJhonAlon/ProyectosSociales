/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEA_PARAMETROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaParametros.findAll", query = "SELECT s FROM SeaParametros s"),
    @NamedQuery(name = "SeaParametros.findByParId", query = "SELECT s FROM SeaParametros s WHERE s.parId = :parId"),
    @NamedQuery(name = "SeaParametros.findByParDescripcion", query = "SELECT s FROM SeaParametros s WHERE s.parDescripcion = :parDescripcion"),
    @NamedQuery(name = "SeaParametros.findByParNemonico", query = "SELECT s FROM SeaParametros s WHERE s.parNemonico = :parNemonico"),
    @NamedQuery(name = "SeaParametros.findByParEstado", query = "SELECT s FROM SeaParametros s WHERE s.parEstado = :parEstado")})
public class SeaParametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ID")
    private Long parId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAR_DESCRIPCION")
    private String parDescripcion;
    @Size(max = 20)
    @Column(name = "PAR_NEMONICO")
    private String parNemonico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PAR_ESTADO")
    private String parEstado;
    @OneToMany(mappedBy = "seaParametros", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaParametrosDet> seaParametrosDetList;


    public final static Long PARAM_TIPO_POBLACION = new Long(104); 
    public final static Long PARAM_SEMESTRE = new Long(105); 
    public final static Long PARAM_TIPO_ADQUISICION_PROYECTO = new Long(106); 
    public final static Long PARAM_TIPO_ORGANIZACION = new Long(109); 
    public final static Long PARAM_TIPO_COMPROMISO_PARTICIPACION = new Long(110); 
    public final static Long PARAM_ESTADO_PROYECTO_VINCULACION = new Long(116); 
    public final static Long PARAM_COBERTURA = new Long(117); 
    
    
        
    public SeaParametros() {
    }

    public SeaParametros(Long parId) {
        this.parId = parId;
    }

    public SeaParametros(Long parId, String parDescripcion, String parEstado) {
        this.parId = parId;
        this.parDescripcion = parDescripcion;
        this.parEstado = parEstado;
    }

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
    }

    public String getParDescripcion() {
        return parDescripcion;
    }

    public void setParDescripcion(String parDescripcion) {
        this.parDescripcion = parDescripcion;
    }

    public String getParNemonico() {
        return parNemonico;
    }

    public void setParNemonico(String parNemonico) {
        this.parNemonico = parNemonico;
    }

    public String getParEstado() {
        return parEstado;
    }

    public void setParEstado(String parEstado) {
        this.parEstado = parEstado;
    }

    @XmlTransient
    public List<SeaParametrosDet> getSeaParametrosDetList() {
        return seaParametrosDetList;
    }

    public void setSeaParametrosDetList(List<SeaParametrosDet> seaParametrosDetList) {
        this.seaParametrosDetList = seaParametrosDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parId != null ? parId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaParametros)) {
            return false;
        }
        SeaParametros other = (SeaParametros) object;
        if ((this.parId == null && other.parId != null) || (this.parId != null && !this.parId.equals(other.parId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaParametros[ parId=" + parId + " ]";
    }
    
}
