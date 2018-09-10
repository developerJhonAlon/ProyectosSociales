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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZTAOBJBVPR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztaobjbvpr.findAll", query = "SELECT s FROM Sztaobjbvpr s"),
    @NamedQuery(name = "Sztaobjbvpr.findBySztaobjbvprCode", query = "SELECT s FROM Sztaobjbvpr s WHERE s.sztaobjbvprCode = :sztaobjbvprCode")})
public class Sztaobjbvpr implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZTAOBJBVPR", sequenceName = "SEQ_SZTAOBJBVPR", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZTAOBJBVPR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAOBJBVPR_CODE")
    private BigDecimal sztaobjbvprCode;
    @JoinColumn(name = "OBPLABV_ID", referencedColumnName = "OBPLABV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaObplanbv obplabvId;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @OneToMany(mappedBy = "sztaobjbvprCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sztapolobjbv> politicaList;

    public Sztaobjbvpr() {
    }

    public Sztaobjbvpr(BigDecimal sztaobjbvprCode) {
        this.sztaobjbvprCode = sztaobjbvprCode;
    }

    public BigDecimal getSztaobjbvprCode() {
        return sztaobjbvprCode;
    }

    public void setSztaobjbvprCode(BigDecimal sztaobjbvprCode) {
        this.sztaobjbvprCode = sztaobjbvprCode;
    }

    public SeaObplanbv getObplabvId() {
        return obplabvId;
    }

    public void setObplabvId(SeaObplanbv obplabvId) {
        this.obplabvId = obplabvId;
    }

    public SeaFormatoLargo getSflId() {
        return sflId;
    }

    public void setSflId(SeaFormatoLargo sflId) {
        this.sflId = sflId;
    }

    @XmlTransient
    public List<Sztapolobjbv> getPoliticaList() {
        return politicaList;
    }

    public void setPoliticaList(List<Sztapolobjbv> politicaList) {
        this.politicaList = politicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztaobjbvprCode != null ? sztaobjbvprCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztaobjbvpr)) {
            return false;
        }
        Sztaobjbvpr other = (Sztaobjbvpr) object;
        if ((this.sztaobjbvprCode == null && other.sztaobjbvprCode != null) || (this.sztaobjbvprCode != null && !this.sztaobjbvprCode.equals(other.sztaobjbvprCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztaobjbvpr[ sztaobjbvprCode=" + sztaobjbvprCode + " ]";
    }
    
}
