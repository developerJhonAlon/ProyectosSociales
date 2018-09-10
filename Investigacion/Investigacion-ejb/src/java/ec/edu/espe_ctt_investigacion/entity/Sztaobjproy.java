/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.internal.util.logging.Log;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZTAOBJPROY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sztaobjproy.findAll", query = "SELECT s FROM Sztaobjproy s"),
    @NamedQuery(name = "Sztaobjproy.findBySztaobjproyCode", query = "SELECT s FROM Sztaobjproy s WHERE s.sztaobjproyCode = :sztaobjproyCode"),
    @NamedQuery(name = "Sztaobjproy.findBySztaobjproyDescr", query = "SELECT s FROM Sztaobjproy s WHERE s.sztaobjproyDescr = :sztaobjproyDescr")})
public class Sztaobjproy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAOBJPROY", sequenceName = "SEQ_SZDTAOBJPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAOBJPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTAOBJPROY_CODE")
    private BigDecimal sztaobjproyCode;
    @Size(max = 4000)
    @Column(name = "SZTAOBJPROY_DESCR")
    private String sztaobjproyDescr;
    @OneToMany(mappedBy = "sztaobjproyPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sztaobjproy> sztaobjproyList;
    @JoinColumn(name = "SZTAOBJPROY_PADRE", referencedColumnName = "SZTAOBJPROY_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sztaobjproy sztaobjproyPadre;
    @JoinColumn(name = "SFL_ID", referencedColumnName = "SFL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaFormatoLargo sflId;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet prdId;
    @Size(max = 4000)
    @Column(name = "SZTAOBJPROY_RESULT")
    private String sztaobjproyResult;
    
    public Sztaobjproy() {
    }

    public Sztaobjproy(BigDecimal sztaobjproyCode) {
        this.sztaobjproyCode = sztaobjproyCode;
    }

    public BigDecimal getSztaobjproyCode() {
        return sztaobjproyCode;
    }

    public void setSztaobjproyCode(BigDecimal sztaobjproyCode) {
        this.sztaobjproyCode = sztaobjproyCode;
    }

    public String getSztaobjproyDescr() {
        return sztaobjproyDescr;
    }

    public void setSztaobjproyDescr(String sztaobjproyDescr) {
        this.sztaobjproyDescr = sztaobjproyDescr;
    }
    

    @XmlTransient
    public List<Sztaobjproy> getSztaobjproyList() {
        return sztaobjproyList;
    }
       @XmlTransient
    public List<Sztaobjproy> getSztaobjproyActividadList() {
        List<Sztaobjproy> activLIst = new ArrayList<>();
           for (Sztaobjproy sztaobjproy : sztaobjproyList) {
               if(sztaobjproy.prdId.getPrdId().equals(new Long(308))){
                   activLIst.add(sztaobjproy);
               }
           }
        return activLIst;
    }
       @XmlTransient
    public List<Sztaobjproy> getSztaobjproyIndicadorList() {
        List<Sztaobjproy> indicLIst = new ArrayList<>();
           for (Sztaobjproy sztaobjproy : sztaobjproyList) {
               if(sztaobjproy.prdId.getPrdId().equals(new Long(305))){
                   indicLIst.add(sztaobjproy);
               }
           }
        return indicLIst;
    }

    public void setSztaobjproyList(List<Sztaobjproy> sztaobjproyList) {
        this.sztaobjproyList = sztaobjproyList;
    }

    public Sztaobjproy getSztaobjproyPadre() {
        return sztaobjproyPadre;
    }

    public void setSztaobjproyPadre(Sztaobjproy sztaobjproyPadre) {
        this.sztaobjproyPadre = sztaobjproyPadre;
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

    public String getSztaobjproyResult() {
        return sztaobjproyResult;
    }

    public void setSztaobjproyResult(String sztaobjproyResult) {
        this.sztaobjproyResult = sztaobjproyResult;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sztaobjproyCode != null ? sztaobjproyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sztaobjproy)) {
            return false;
        }
        Sztaobjproy other = (Sztaobjproy) object;
        if ((this.sztaobjproyCode == null && other.sztaobjproyCode != null) || (this.sztaobjproyCode != null && !this.sztaobjproyCode.equals(other.sztaobjproyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Sztaobjproy[ sztaobjproyCode=" + sztaobjproyCode + " ]";
    }
    
}
