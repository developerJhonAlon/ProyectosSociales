/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
@Table(name = "SEA_LINEAINVES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaLineainves.findAll", query = "SELECT s FROM SeaLineainves s"),
    @NamedQuery(name = "SeaLineainves.findByLineaId", query = "SELECT s FROM SeaLineainves s WHERE s.lineaId = :lineaId"),
    @NamedQuery(name = "SeaLineainves.findByLineaIdPadre", query = "SELECT s FROM SeaLineainves s WHERE s.lineaIdPadre = :lineaIdPadre"),
    @NamedQuery(name = "SeaLineainves.findByLineaDescip", query = "SELECT s FROM SeaLineainves s WHERE s.lineaDescip = :lineaDescip"),
    @NamedQuery(name = "SeaLineainves.findByLineaUnesco", query = "SELECT s FROM SeaLineainves s WHERE s.lineaUnesco = :lineaUnesco")})
public class SeaLineainves implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_LINEAINVES", sequenceName = "SEQ_SEA_LINEAINVES", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_LINEAINVES")
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINEA_ID")
    private BigDecimal lineaId;
    @Size(max = 500)
    @Column(name = "LINEA_DESCIP")
    private String lineaDescip;
    @Column(name = "LINEA_UNESCO")
    private BigInteger lineaUnesco;
    @OneToMany(mappedBy = "lineaIdPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaLineainves> seaLineainvesList;

    @OneToMany(mappedBy = "lineaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDepcenproy> seaDepcenproyList;
    // private List<SeaDepcenproy> seaDepcenproyList;
    @OneToMany(mappedBy = "lineaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProy> seaDatGeneralProyList;

//    @OneToMany(mappedBy = "lineaIdPadre")
//    private List<SeaLineainves> seaLineainvesList;
    @JoinColumn(name = "LINEA_ID_PADRE", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaIdPadre;

//    @OneToMany(mappedBy = "lineaId")
//    private List<SeaDatGeneralProg> seaDatGeneralProgList;
//    @OneToMany(mappedBy = "lineaId")
//    private List<SeaDatGeneralProg> seaDatGeneralProgList;
//    @OneToMany(mappedBy = "lineaId")
//    private List<SeaDatGeneralProy> seaDatGeneralProyList;
    public SeaLineainves() {
    }

    public SeaLineainves(BigDecimal lineaId) {
        this.lineaId = lineaId;
    }

    public SeaLineainves(BigDecimal id, String descripcion) {
        this.lineaId = id;
        this.lineaDescip = descripcion;
        
    }

    public BigDecimal getLineaId() {
        return lineaId;
    }

    public void setLineaId(BigDecimal lineaId) {
        this.lineaId = lineaId;
    }

//    public BigInteger getLineaIdPadre() {
//        return lineaIdPadre;
//    }
//
//    public void setLineaIdPadre(BigInteger lineaIdPadre) {
//        this.lineaIdPadre = lineaIdPadre;
//    }
//    public List<SeaLineainves> getSeaLineainvesList() {
//        return seaLineainvesList;
//    }
//
//    public void setSeaLineainvesList(List<SeaLineainves> seaLineainvesList) {
//        this.seaLineainvesList = seaLineainvesList;
//    }
    public SeaLineainves getLineaIdPadre() {
        return lineaIdPadre;
    }

    public void setLineaIdPadre(SeaLineainves lineaIdPadre) {
        this.lineaIdPadre = lineaIdPadre;
    }

    public String getLineaDescip() {
        return lineaDescip;
    }

    public void setLineaDescip(String lineaDescip) {
        this.lineaDescip = lineaDescip;
    }

    public BigInteger getLineaUnesco() {
        return lineaUnesco;
    }

    public void setLineaUnesco(BigInteger lineaUnesco) {
        this.lineaUnesco = lineaUnesco;
    }

//    @XmlTransient
//    public List<SeaDatGeneralProg> getSeaDatGeneralProgList() {
//        return seaDatGeneralProgList;
//    }
//
//    public void setSeaDatGeneralProgList(List<SeaDatGeneralProg> seaDatGeneralProgList) {
//        this.seaDatGeneralProgList = seaDatGeneralProgList;
//    }
    @XmlTransient
//    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
//        return seaDatGeneralProyList;
//    }
//
//    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
//        this.seaDatGeneralProyList = seaDatGeneralProyList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaId != null ? lineaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaLineainves)) {
            return false;
        }
        SeaLineainves other = (SeaLineainves) object;
        if ((this.lineaId == null && other.lineaId != null) || (this.lineaId != null && !this.lineaId.equals(other.lineaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaLineainves[ lineaId=" + lineaId + " ]";
    }

    @XmlTransient
    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
        return seaDatGeneralProyList;
    }

    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
        this.seaDatGeneralProyList = seaDatGeneralProyList;
    }

    @XmlTransient
    public List<SeaDepcenproy> getSeaDepcenproyList() {
        return seaDepcenproyList;
    }

    public void setSeaDepcenproyList(List<SeaDepcenproy> seaDepcenproyList) {
        this.seaDepcenproyList = seaDepcenproyList;
    }

    @XmlTransient
    public List<SeaLineainves> getSeaLineainvesList() {
        return seaLineainvesList;
    }

    public void setSeaLineainvesList(List<SeaLineainves> seaLineainvesList) {
        this.seaLineainvesList = seaLineainvesList;
    }

    public void addSeaLineaInvest(SeaLineainves seaLineainves) {
        if (seaLineainvesList == null) {
            seaLineainvesList = new ArrayList<>();
        }
        seaLineainvesList.add(seaLineainves);
    }

    @Transient
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    
    public String getDescripcionCompleta(){
        if (lineaIdPadre!=null){
            return lineaIdPadre.getLineaDescip() + " - " + getLineaDescip();
        }
        else{
            return getLineaDescip();
        }
        
    }

}
