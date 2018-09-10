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
@Table(name = "SEA_PROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeaPrograma.findAll", query = "SELECT s FROM SeaPrograma s"),
    @NamedQuery(name = "SeaPrograma.findByProgId", query = "SELECT s FROM SeaPrograma s WHERE s.progId = :progId"),
    @NamedQuery(name = "SeaPrograma.findByProgDescrip", query = "SELECT s FROM SeaPrograma s WHERE s.progDescrip = :progDescrip")})
public class SeaPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SEA_PROGRAMA", sequenceName = "SEQ_SEA_PROGRAMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEA_PROGRAMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROG_ID")
    private BigDecimal progId;
    @Size(max = 150)
    @Column(name = "PROG_DESCRIP")
    private String progDescrip;
    @OneToMany(mappedBy = "progId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProg> seaDatGeneralProgList;
    @OneToMany(mappedBy = "progId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeaDatGeneralProy> seaDatGeneralProyList;

    public SeaPrograma() {
    }

    public SeaPrograma(BigDecimal progId) {
        this.progId = progId;
    }

    public BigDecimal getProgId() {
        return progId;
    }

    public void setProgId(BigDecimal progId) {
        this.progId = progId;
    }

    public String getProgDescrip() {
        return progDescrip;
    }

    public void setProgDescrip(String progDescrip) {
        this.progDescrip = progDescrip;
    }

    @XmlTransient
    public List<SeaDatGeneralProg> getSeaDatGeneralProgList() {
        return seaDatGeneralProgList;
    }

    public void setSeaDatGeneralProgList(List<SeaDatGeneralProg> seaDatGeneralProgList) {
        this.seaDatGeneralProgList = seaDatGeneralProgList;
    }

    @XmlTransient
    public List<SeaDatGeneralProy> getSeaDatGeneralProyList() {
        return seaDatGeneralProyList;
    }

    public void setSeaDatGeneralProyList(List<SeaDatGeneralProy> seaDatGeneralProyList) {
        this.seaDatGeneralProyList = seaDatGeneralProyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (progId != null ? progId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeaPrograma)) {
            return false;
        }
        SeaPrograma other = (SeaPrograma) object;
        if ((this.progId == null && other.progId != null) || (this.progId != null && !this.progId.equals(other.progId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt_investigacion.entity.SeaPrograma[ progId=" + progId + " ]";
    }
    
}
