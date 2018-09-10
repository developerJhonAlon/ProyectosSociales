/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SEG_USUARIO", schema = "SISEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByUsuId", query = "SELECT s FROM SegUsuario s WHERE s.usuId = :usuId"),
    @NamedQuery(name = "SegUsuario.findByUsuCc", query = "SELECT s FROM SegUsuario s WHERE s.usuCc = :usuCc"),
    @NamedQuery(name = "SegUsuario.findByUsuClave", query = "SELECT s FROM SegUsuario s WHERE s.usuClave = :usuClave"),
    @NamedQuery(name = "SegUsuario.findByUsuNombres", query = "SELECT s FROM SegUsuario s WHERE s.usuNombres = :usuNombres"),
    @NamedQuery(name = "SegUsuario.findByUsuApellidos", query = "SELECT s FROM SegUsuario s WHERE s.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "SegUsuario.findByUsuEmail", query = "SELECT s FROM SegUsuario s WHERE s.usuEmail = :usuEmail"),
    @NamedQuery(name = "SegUsuario.findByUsuFecharegistro", query = "SELECT s FROM SegUsuario s WHERE s.usuFecharegistro = :usuFecharegistro"),
    @NamedQuery(name = "SegUsuario.findByUsuEstado", query = "SELECT s FROM SegUsuario s WHERE s.usuEstado = :usuEstado"),
    @NamedQuery(name = "SegUsuario.findByUsuMailSinformul", query = "SELECT s FROM SegUsuario s WHERE s.usuMailSinformul = :usuMailSinformul"),
    @NamedQuery(name = "SegUsuario.findByUsuMailIncompletos", query = "SELECT s FROM SegUsuario s WHERE s.usuMailIncompletos = :usuMailIncompletos"),
    @NamedQuery(name = "SegUsuario.findByUsuTipoDoc", query = "SELECT s FROM SegUsuario s WHERE s.usuTipoDoc = :usuTipoDoc"),
    @NamedQuery(name = "SegUsuario.findByUsuCodSenescyt", query = "SELECT s FROM SegUsuario s WHERE s.usuCodSenescyt = :usuCodSenescyt"),
    @NamedQuery(name = "SegUsuario.findByUsuFechaActMicuenta", query = "SELECT s FROM SegUsuario s WHERE s.usuFechaActMicuenta = :usuFechaActMicuenta"),
    @NamedQuery(name = "SegUsuario.findByUsuIdHexadecimal", query = "SELECT s FROM SegUsuario s WHERE s.usuIdHexadecimal = :usuIdHexadecimal"),
    @NamedQuery(name = "SegUsuario.findByUsuTratamiento", query = "SELECT s FROM SegUsuario s WHERE s.usuTratamiento = :usuTratamiento"),
    @NamedQuery(name = "SegUsuario.findByUsuModificacion", query = "SELECT s FROM SegUsuario s WHERE s.usuModificacion = :usuModificacion"),
    @NamedQuery(name = "SegUsuario.findByUsuTipoUser", query = "SELECT s FROM SegUsuario s WHERE s.usuTipoUser = :usuTipoUser"),
    @NamedQuery(name = "SegUsuario.findByUsuEmailInstitucional", query = "SELECT s FROM SegUsuario s WHERE s.usuEmailInstitucional = :usuEmailInstitucional")})
public class SegUsuario implements Serializable {
    @Size(max = 10)
    @Column(name = "USU_TELEFONO_FIJO")
    private String usuTelefonoFijo;
    @Size(max = 10)
    @Column(name = "USU_TELEFONO_CELULAR")
    private String usuTelefonoCelular;
    @Size(max = 9)
    @Column(name = "SPRIDEN_ID")
    private String spridenId;
    @Column(name = "SPRIDEN_PIDM")
    private Integer spridenPidm;
    @Column(name="USU_CLAVE_TMP" )
    @Size(min=1,max=200)
    private String usuClaveTmp;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "segUsuario")
//    private SeaDatPersonal seaDatPersonal;
//    @Size(max = 100)
//    @Column(name = "USU_EMAIL_INSTITUCIONAL")
//    private String usuEmailInstitucional;
//    @OneToMany(mappedBy = "usuId")
//    private List<SeaInfoCargosDirectivos> seaInfoCargosDirectivosList;
//    @OneToMany(mappedBy = "usuId")
//    private List<SeaInfoInvestigacionDocente> seaInfoInvestigacionDocenteList;
//    @OneToMany(mappedBy = "usuId")
//    private List<SeaInfoPublicacionDocente> seaInfoPublicacionDocenteList;
//    @OneToMany(mappedBy = "usuId")
//    private List<SeaInfoCapacitacionDocente> seaInfoCapacitacionDocenteList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
//    private List<SeaInfoExperienciaDocentes> seaInfoExperienciaDocentesList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
//    private List<SeaInfoAcademicaDocentes> seaInfoAcademicaDocentesList;
//    @OneToMany(mappedBy = "usuId")
//    
//    
//    
//  
//    private List<SeaDatFamDiscapacidad> seaDatFamDiscapacidadList;
//      @OneToMany(mappedBy = "usuId")

//    private List<SeaDocente> seaDocenteList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEG_USUARIO", sequenceName = "SEQ_SEG_USUARIO", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEG_USUARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_CC")
    private String usuCc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_NOMBRES")
    private String usuNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_APELLIDOS")
    private String usuApellidos;
    @Size(max = 100)
    @Column(name = "USU_EMAIL")
    private String usuEmail;
    @Column(name = "USU_FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecharegistro;
    @Size(max = 1)
    @Column(name = "USU_ESTADO")
    private String usuEstado;
    @Column(name = "USU_MAIL_SINFORMUL")
    private BigInteger usuMailSinformul;
    @Column(name = "USU_MAIL_INCOMPLETOS")
    private BigInteger usuMailIncompletos;
    @Size(max = 30)
    @Column(name = "USU_TIPO_DOC")
    private String usuTipoDoc;
    @Size(max = 30)
    @Column(name = "USU_COD_SENESCYT")
    private String usuCodSenescyt;
    @Column(name = "USU_FECHA_ACT_MICUENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaActMicuenta;
    @Size(max = 6)
    @Column(name = "USU_ID_HEXADECIMAL")
    private String usuIdHexadecimal;
    @Size(max = 25)
    @Column(name = "USU_TRATAMIENTO")
    private String usuTratamiento;
    @Column(name = "USU_MODIFICACION")
    private BigInteger usuModificacion;
     @Size(max = 100)
    @Column(name = "USU_EMAIL_INSTITUCIONAL")
    private String usuEmailInstitucional;
    @Size(max = 1)
    @Column(name = "USU_TIPO_USER")
    private String usuTipoUser;
    @Size(max = 20)
    @Column(name = "SPBPERS_NAME_PREFIX")
    private String usuTitulo;
    @Size(max = 1)
    @Column(name = "SPBPERS_SEX")//"F","M"
    private String usuSexo;
    
    
    
    
//    @OneToMany(mappedBy = "segUsuario")
//    private List<SegUsuPerfil> segUsuPerfilList;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public SegUsuario(BigDecimal usuId, String usuCc, String usuNombres, String usuApellidos) {
        this.usuId = usuId;
        this.usuCc = usuCc;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
    }

    public SegUsuario(BigDecimal usuId, String usuCc, String usuClave, String usuNombres, String usuApellidos) {
        this.usuId = usuId;
        this.usuCc = usuCc;
        this.usuClave = usuClave;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public String getUsuCc() {
        return usuCc;
    }

    public void setUsuCc(String usuCc) {
        this.usuCc = usuCc;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public Date getUsuFecharegistro() {
        return usuFecharegistro;
    }

    public void setUsuFecharegistro(Date usuFecharegistro) {
        this.usuFecharegistro = usuFecharegistro;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public BigInteger getUsuMailSinformul() {
        return usuMailSinformul;
    }

    public void setUsuMailSinformul(BigInteger usuMailSinformul) {
        this.usuMailSinformul = usuMailSinformul;
    }

    public BigInteger getUsuMailIncompletos() {
        return usuMailIncompletos;
    }

    public void setUsuMailIncompletos(BigInteger usuMailIncompletos) {
        this.usuMailIncompletos = usuMailIncompletos;
    }

    public String getUsuTipoDoc() {
        return usuTipoDoc;
    }

    public void setUsuTipoDoc(String usuTipoDoc) {
        this.usuTipoDoc = usuTipoDoc;
    }

    public String getUsuCodSenescyt() {
        return usuCodSenescyt;
    }

    public void setUsuCodSenescyt(String usuCodSenescyt) {
        this.usuCodSenescyt = usuCodSenescyt;
    }

    public Date getUsuFechaActMicuenta() {
        return usuFechaActMicuenta;
    }

    public void setUsuFechaActMicuenta(Date usuFechaActMicuenta) {
        this.usuFechaActMicuenta = usuFechaActMicuenta;
    }

    public String getUsuIdHexadecimal() {
        return usuIdHexadecimal;
    }

    public void setUsuIdHexadecimal(String usuIdHexadecimal) {
        this.usuIdHexadecimal = usuIdHexadecimal;
    }

    public String getUsuTratamiento() {
        return usuTratamiento;
    }

    public void setUsuTratamiento(String usuTratamiento) {
        this.usuTratamiento = usuTratamiento;
    }

    public BigInteger getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(BigInteger usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    public String getUsuTipoUser() {
        return usuTipoUser;
    }

    public void setUsuTipoUser(String usuTipoUser) {
        this.usuTipoUser = usuTipoUser;
    }

    public String getUsuEmailInstitucional() {
        return usuEmailInstitucional;
    }

    public void setUsuEmailInstitucional(String usuEmailInstitucional) {
        this.usuEmailInstitucional = usuEmailInstitucional;
    }

  

//    @XmlTransient
//    public List<SegUsuPerfil> getSegUsuPerfilList() {
//        return segUsuPerfilList;
//    }
//
//    public void setSegUsuPerfilList(List<SegUsuPerfil> segUsuPerfilList) {
//        this.segUsuPerfilList = segUsuPerfilList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.seguridades.entity.SegUsuario[ usuId=" + usuId + " ]";
    }

    public String getUsuTelefonoFijo() {
        return usuTelefonoFijo;
    }

    public void setUsuTelefonoFijo(String usuTelefonoFijo) {
        this.usuTelefonoFijo = usuTelefonoFijo;
    }

    public String getUsuTelefonoCelular() {
        return usuTelefonoCelular;
    }

    public void setUsuTelefonoCelular(String usuTelefonoCelular) {
        this.usuTelefonoCelular = usuTelefonoCelular;
    }

    public String getSpridenId() {
        return spridenId;
    }

    public void setSpridenId(String spridenId) {
        this.spridenId = spridenId;
    }

    public Integer getSpridenPidm() {
        return spridenPidm;
    }

    public void setSpridenPidm(Integer spridenPidm) {
        this.spridenPidm = spridenPidm;
    }

    public String getUsuClaveTmp() {
        return usuClaveTmp;
    }

    public void setUsuClaveTmp(String usuClaveTmp) {
        this.usuClaveTmp = usuClaveTmp;
    }
    
    
    @Transient
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Transient
    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombresCompletos(){
        String result= "";
        if (usuNombres!=null){
            result= usuNombres + " ";
        }
        if (usuApellidos!=null){
            result+=usuApellidos;
        }
        return result;
    }
    @Transient
    private Boolean selected;    

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getUsuTitulo() {
        return usuTitulo;
    }

    public void setUsuTitulo(String usuTitulo) {
        this.usuTitulo = usuTitulo;
    }

    public String getUsuSexo() {
        return usuSexo;
    }

    public void setUsuSexo(String usuSexo) {
        this.usuSexo = usuSexo;
    }


    
}
