/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Administrador
 */
@Entity
@Table(name = "SEA_CLASIFICADOR_PRESUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaClasificadorPresup.findAll", query = "SELECT s FROM SeaClasificadorPresup s"),
    @NamedQuery(name = "SeaClasificadorPresup.findByScpId", query = "SELECT s FROM SeaClasificadorPresup s WHERE s.scpId = :scpId"),
    @NamedQuery(name = "SeaClasificadorPresup.findByScpNombre", query = "SELECT s FROM SeaClasificadorPresup s WHERE s.scpNombre = :scpNombre"),
    @NamedQuery(name = "SeaClasificadorPresup.findByScpEjercicio", query = "SELECT s FROM SeaClasificadorPresup s WHERE s.scpEjercicio = :scpEjercicio")})
public class SeaClasificadorPresup implements Serializable, Comparable<SeaClasificadorPresup> {

    @OneToMany(mappedBy = "scpId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaRecursosConvoca> seaRecursosConvocaList;
    /*@OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PresupuestoPartida> seaPresupuestoXPartidaList;*/
    @OneToMany(mappedBy = "scpId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaTotalPresupAnual> seaTotalPresupAnualList;
    @OneToMany(mappedBy = "scpId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaProgramaAnual> seaProgramaAnualList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SCP_ID")
    private BigDecimal scpId;
    @Size(max = 1000)
    @Column(name = "SCP_NOMBRE")
    private String scpNombre;
    @Column(name = "SCP_EJERCICIO")
    private BigInteger scpEjercicio;
    @OneToMany(mappedBy = "scpPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeaClasificadorPresup> seaClasificadorPresupList;
    @JoinColumn(name = "SCP_PADRE", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup scpPadre;

    public SeaClasificadorPresup() {
    }

    public SeaClasificadorPresup(BigDecimal scpId) {
        this.scpId = scpId;
    }

    public BigDecimal getScpId() {
        return scpId;
    }

    public void setScpId(BigDecimal scpId) {
        this.scpId = scpId;
    }

    public String getScpNombre() {
        return scpNombre;
    }

    public void setScpNombre(String scpNombre) {
        this.scpNombre = scpNombre;
    }

    public BigInteger getScpEjercicio() {
        return scpEjercicio;
    }

    public void setScpEjercicio(BigInteger scpEjercicio) {
        this.scpEjercicio = scpEjercicio;
    }

    @XmlTransient
    public List<SeaClasificadorPresup> getSeaClasificadorPresupList() {
        Collections.sort(seaClasificadorPresupList);
        return seaClasificadorPresupList;
    }

    public void setSeaClasificadorPresupList(List<SeaClasificadorPresup> seaClasificadorPresupList) {
        this.seaClasificadorPresupList = seaClasificadorPresupList;
    }

    public SeaClasificadorPresup getScpPadre() {
        return scpPadre;
    }

    public void setScpPadre(SeaClasificadorPresup scpPadre) {
        this.scpPadre = scpPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scpId != null ? scpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaClasificadorPresup)) {
            return false;
        }
        SeaClasificadorPresup other = (SeaClasificadorPresup) object;
        if ((this.scpId == null && other.scpId != null) || (this.scpId != null && !this.scpId.equals(other.scpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup[ scpId=" + scpId + " ]";
    }

    @XmlTransient
    public List<SeaProgramaAnual> getSeaProgramaAnualList() {
        return seaProgramaAnualList;
    }

    public void setSeaProgramaAnualList(List<SeaProgramaAnual> seaProgramaAnualList) {
        this.seaProgramaAnualList = seaProgramaAnualList;
    }

    @XmlTransient
    public List<SeaTotalPresupAnual> getSeaTotalPresupAnualList() {
        return seaTotalPresupAnualList;
    }

    public void setSeaTotalPresupAnualList(List<SeaTotalPresupAnual> seaTotalPresupAnualList) {
        this.seaTotalPresupAnualList = seaTotalPresupAnualList;
    }

    /*@XmlTransient
    public List<PresupuestoPartida> getSeaPresupuestoXPartidaList() {
        return seaPresupuestoXPartidaList;
    }

    public void setSeaPresupuestoXPartidaList(List<PresupuestoPartida> seaPresupuestoXPartidaList) {
        this.seaPresupuestoXPartidaList = seaPresupuestoXPartidaList;
    }*/

    @XmlTransient
    public List<SeaRecursosConvoca> getSeaRecursosConvocaList() {
        return seaRecursosConvocaList;
    }

    public void setSeaRecursosConvocaList(List<SeaRecursosConvoca> seaRecursosConvocaList) {
        this.seaRecursosConvocaList = seaRecursosConvocaList;
    }

    @Override
    public int compareTo(SeaClasificadorPresup o) {
        /*try {
        if (isEsPartida() && o.isEsSubGrupo2()){
            return this.scpPadre.scpId.compareTo(o.scpId);
        }
        if (isEsSubGrupo2() && o.isEsSubGrupo1()){
            return this.scpPadre.scpId.compareTo(o.scpId);
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return this.scpId.toString().compareTo(o.scpId.toString());
    }

    public String getGrupo() {
        if (scpPadre == null) {
            return scpId.toString() + ". " + scpNombre;
        } else if (scpPadre.getScpPadre() == null) {
            return scpPadre.getScpId().toString() + ". " + scpPadre.getScpNombre();
        } else if (scpPadre.getScpPadre().getScpPadre() == null) {
            return scpPadre.getScpPadre().getScpId().toString() + ". " + scpPadre.getScpPadre().getScpNombre();
        } else {
            return scpPadre.getScpPadre().getScpPadre().getScpId().toString() + ". " + scpPadre.getScpPadre().getScpPadre().getScpNombre();
        }

    }

    public String getSubGrupo1() {
        if (scpPadre == null) {
            return "";
        } else if (scpPadre.getScpPadre() == null) {
            return scpId.toString() + ". " + scpNombre;
        } else if (scpPadre.getScpPadre().getScpPadre() == null) {
            return scpPadre.getScpId().toString() + ". " + scpPadre.getScpNombre();
        } else {
            return scpPadre.getScpPadre().getScpId().toString() + ". " + scpPadre.getScpPadre().getScpNombre();
        }

    }

    public String getSubGrupo2() {
        if (scpPadre == null) {
            return "";
        } else if (scpPadre.getScpPadre() == null) {
            return "";

        } else if (scpPadre.getScpPadre().getScpPadre() == null) {
            return scpId.toString() + ". " + scpNombre;
        } else {
            return scpPadre.getScpId().toString() + ". " + scpPadre.getScpNombre();
        }
    }

    public String getPartida() {
        if (scpPadre == null) {
            return "";
        } else if (scpPadre.getScpPadre() == null) {
            return "";

        } else if (scpPadre.getScpPadre().getScpPadre() == null) {
            return "";
        } else {
            return scpId.toString() + ". " + scpNombre;
        }
    }
    
    public boolean isEsGrupo(){
        if (scpPadre==null){
            return true;
        }
        return false;
    }
    public boolean isEsSubGrupo1(){
        if (scpPadre!=null && scpPadre.getScpPadre()==null){
            return true;
        }
        return false;
    }
    public boolean isEsSubGrupo2(){
        if (scpPadre!=null && scpPadre.getScpPadre()!=null &&  scpPadre.getScpPadre().getScpPadre()==null){
            return true;
        }
        return false;
    }
    public boolean isEsPartida(){
        if (scpPadre!=null && scpPadre.getScpPadre()!=null &&  scpPadre.getScpPadre().getScpPadre()!=null){
            return true;
        }
        return false;
    }
    
    public String getPartidaNombreCompleto() {
        StringBuilder nom = new StringBuilder();
            nom.append(this.getScpPadre().getScpPadre().getScpPadre().getScpId())
                    .append(". ").append(this.getScpPadre().getScpPadre().getScpPadre().getScpNombre())
                    .append("\r\n").append(this.getScpPadre().getScpPadre().getScpId())
                    .append(". ").append(this.getScpPadre().getScpPadre().getScpNombre())
                    .append("\r\n").append(this.getScpPadre().getScpId())
                    .append(". ").append(this.getScpPadre().getScpNombre())
                    .append("\r\n").append(this.getScpId())
                    .append(". ").append(this.getScpNombre());
        return nom.toString();
    }

}
