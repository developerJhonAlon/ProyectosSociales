/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEG_PERFIL",schema = "SISEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPerfil.findAll", query = "SELECT s FROM SegPerfil s"),
    @NamedQuery(name = "SegPerfil.findByPerId", query = "SELECT s FROM SegPerfil s WHERE s.perId = :perId"),
    @NamedQuery(name = "SegPerfil.findByPerNombre", query = "SELECT s FROM SegPerfil s WHERE s.perNombre = :perNombre")})
public class SegPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEG_PERFIL", sequenceName = "SEQ_SEG_PERFIL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_PERFIL")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil")
    @OneToMany(mappedBy = "segPerfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SegOpcPerfil> segOpcPerfilList;
    //@OneToMany(mappedBy = "SegPerfil")
    @OneToMany(mappedBy = "SegPerfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SegUsuPerfil> segUsuPerfilList;
    @JoinColumn(name = "SIS_ID", referencedColumnName = "SIS_ID")
    @ManyToOne
    private SegSistemas segSistemas;
    public final static String PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION= "ADMINISTRADOR DE VINCULACION";
    public final static String PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA= "ADMINISTRADOR DE VINCULACION (L)";
    public final static String PERFIL_VINCULACION_COORDINADOR_VINCULACION= "COORDINADOR DE VINCULACION";
    public final static String PERFIL_VINCULACION_DIRECTOR_PROGRAMA= "DIRECTOR DE PROGRAMA";
    public final static String PERFIL_VINCULACION_DIRECTOR_PROYECTO= "DIRECTOR DE PROYECTO";
    public final static String PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO= "DIRECTOR DE DEPARTAMENTO";
    public final static String PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION= "EVALUADOR UNIDAD VINCULACION";
    public final static String PERFIL_VINCULACION_EVALUADOR_VICERRECTORADO= "VICERRECTOR IITT";
    public final static String PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO= "EVALUADOR FINAL DE PROYECTO";
    public final static String PERFIL_VINCULACION_EVALUADOR_FINAL_PROGRAMA= "EVALUADOR FINAL DE PROGRAMA";
    public final static String PERFIL_VINCULACION_REPORTES= "REPORTES";
    public final static String PERFIL_VINCULACION_IMPRESION_CERTIFICADOS= "IMPRESION CERTIFICADOS";

    
    public final static String PERFIL_INVESTIGACION_ADMINISTRADOR= "ADMINISTRADOR DE INVESTIGACION";
    public final static String PERFIL_INVESTIGACION_DIRECCTOR_DEPARTAMENTO= "ACEPTACION NOTAS CONCEPTUALES";
    
    public SegPerfil() {
    }

    public SegPerfil(BigDecimal perId) {
        this.perId = perId;
    }

    public SegPerfil(BigDecimal perId, String perNombre) {
        this.perId = perId;
        this.perNombre = perNombre;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    @XmlTransient
    public List<SegOpcPerfil> getSegOpcPerfilList() {
        return segOpcPerfilList;
    }

    public void setSegOpcPerfilList(List<SegOpcPerfil> segOpcPerfilList) {
        this.segOpcPerfilList = segOpcPerfilList;
    }

    @XmlTransient
    public List<SegUsuPerfil> getSegUsuPerfilList() {
        return segUsuPerfilList;
    }

    public void setSegUsuPerfilList(List<SegUsuPerfil> segUsuPerfilList) {
        this.segUsuPerfilList = segUsuPerfilList;
    }

    public SegSistemas getSegSistemas() {
        return segSistemas;
    }

    public void setSegSistemas(SegSistemas segSistemas) {
        this.segSistemas = segSistemas;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegPerfil[ perId=" + perId + " ]";
    }
    
}
