/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "V_DIRECT_FORMATO_LARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VDirectFormatoLargo.findAll", query = "SELECT v FROM VDirectFormatoLargo v"),
    @NamedQuery(name = "VDirectFormatoLargo.findById", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.id = :id"),
    @NamedQuery(name = "VDirectFormatoLargo.findByDatgeproyId", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.datgeproyId = :datgeproyId"),
    @NamedQuery(name = "VDirectFormatoLargo.findBySflId", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.sflId = :sflId"),
    @NamedQuery(name = "VDirectFormatoLargo.findByUsuNombres", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VDirectFormatoLargo.findByUsuApellidos", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VDirectFormatoLargo.findBySflTituloEspaniol", query = "SELECT v FROM VDirectFormatoLargo v WHERE v.sflTituloEspaniol = :sflTituloEspaniol")})
public class VDirectFormatoLargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATGEPROY_ID")
    private BigInteger datgeproyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONVOCA_ID")
    private BigInteger convocaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFL_ID")
    private BigInteger sflId;
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
    @Size(max = 2000)
    @Column(name = "SFL_TITULO_ESPANIOL")
    private String sflTituloEspaniol;

    public VDirectFormatoLargo() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getDatgeproyId() {
        return datgeproyId;
    }

    public void setDatgeproyId(BigInteger datgeproyId) {
        this.datgeproyId = datgeproyId;
    }

    public BigInteger getConvocaId() {
        return convocaId;
    }

    public void setConvocaId(BigInteger convocaId) {
        this.convocaId = convocaId;
    }

    public BigInteger getSflId() {
        return sflId;
    }

    public void setSflId(BigInteger sflId) {
        this.sflId = sflId;
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

    public String getSflTituloEspaniol() {
        return sflTituloEspaniol;
    }

    public void setSflTituloEspaniol(String sflTituloEspaniol) {
        this.sflTituloEspaniol = sflTituloEspaniol;
    }
    
}
