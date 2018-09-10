/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SSBSECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ssbsect.findAll", query = "SELECT s FROM Ssbsect s"),
    @NamedQuery(name = "Ssbsect.findBySsbsectTermCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPK.ssbsectTermCode = :ssbsectTermCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCrn", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPK.ssbsectCrn = :ssbsectCrn"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPtrmCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPtrmCode = :ssbsectPtrmCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSubjCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSubjCode = :ssbsectSubjCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCrseNumb", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCrseNumb = :ssbsectCrseNumb"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSeqNumb", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSeqNumb = :ssbsectSeqNumb"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSstsCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSstsCode = :ssbsectSstsCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSchdCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSchdCode = :ssbsectSchdCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCampCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCampCode = :ssbsectCampCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCrseTitle", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCrseTitle = :ssbsectCrseTitle"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCreditHrs", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCreditHrs = :ssbsectCreditHrs"),
    @NamedQuery(name = "Ssbsect.findBySsbsectBillHrs", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectBillHrs = :ssbsectBillHrs"),
    @NamedQuery(name = "Ssbsect.findBySsbsectGmodCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectGmodCode = :ssbsectGmodCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSaprCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSaprCode = :ssbsectSaprCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSessCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSessCode = :ssbsectSessCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectLinkIdent", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectLinkIdent = :ssbsectLinkIdent"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPrntInd", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPrntInd = :ssbsectPrntInd"),
    @NamedQuery(name = "Ssbsect.findBySsbsectGradableInd", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectGradableInd = :ssbsectGradableInd"),
    @NamedQuery(name = "Ssbsect.findBySsbsectTuiwInd", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectTuiwInd = :ssbsectTuiwInd"),
    @NamedQuery(name = "Ssbsect.findBySsbsectRegOneup", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectRegOneup = :ssbsectRegOneup"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPriorEnrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPriorEnrl = :ssbsectPriorEnrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectProjEnrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectProjEnrl = :ssbsectProjEnrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectMaxEnrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectMaxEnrl = :ssbsectMaxEnrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectEnrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectEnrl = :ssbsectEnrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSeatsAvail", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSeatsAvail = :ssbsectSeatsAvail"),
    @NamedQuery(name = "Ssbsect.findBySsbsectTotCreditHrs", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectTotCreditHrs = :ssbsectTotCreditHrs"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCensusEnrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCensusEnrl = :ssbsectCensusEnrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCensusEnrlDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCensusEnrlDate = :ssbsectCensusEnrlDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectActivityDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectActivityDate = :ssbsectActivityDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPtrmStartDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPtrmStartDate = :ssbsectPtrmStartDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPtrmEndDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPtrmEndDate = :ssbsectPtrmEndDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectPtrmWeeks", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectPtrmWeeks = :ssbsectPtrmWeeks"),
    @NamedQuery(name = "Ssbsect.findBySsbsectReservedInd", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectReservedInd = :ssbsectReservedInd"),
    @NamedQuery(name = "Ssbsect.findBySsbsectWaitCapacity", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectWaitCapacity = :ssbsectWaitCapacity"),
    @NamedQuery(name = "Ssbsect.findBySsbsectWaitCount", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectWaitCount = :ssbsectWaitCount"),
    @NamedQuery(name = "Ssbsect.findBySsbsectWaitAvail", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectWaitAvail = :ssbsectWaitAvail"),
    @NamedQuery(name = "Ssbsect.findBySsbsectLecHr", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectLecHr = :ssbsectLecHr"),
    @NamedQuery(name = "Ssbsect.findBySsbsectLabHr", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectLabHr = :ssbsectLabHr"),
    @NamedQuery(name = "Ssbsect.findBySsbsectOthHr", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectOthHr = :ssbsectOthHr"),
    @NamedQuery(name = "Ssbsect.findBySsbsectContHr", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectContHr = :ssbsectContHr"),
    @NamedQuery(name = "Ssbsect.findBySsbsectAcctCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectAcctCode = :ssbsectAcctCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectAcclCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectAcclCode = :ssbsectAcclCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCensus2Date", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCensus2Date = :ssbsectCensus2Date"),
    @NamedQuery(name = "Ssbsect.findBySsbsectEnrlCutOffDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectEnrlCutOffDate = :ssbsectEnrlCutOffDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectAcadCutOffDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectAcadCutOffDate = :ssbsectAcadCutOffDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectDropCutOffDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectDropCutOffDate = :ssbsectDropCutOffDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCensus2Enrl", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCensus2Enrl = :ssbsectCensus2Enrl"),
    @NamedQuery(name = "Ssbsect.findBySsbsectVoiceAvail", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectVoiceAvail = :ssbsectVoiceAvail"),
    @NamedQuery(name = "Ssbsect.findBySsbsectCappPrereqTestInd", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectCappPrereqTestInd = :ssbsectCappPrereqTestInd"),
    @NamedQuery(name = "Ssbsect.findBySsbsectGschName", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectGschName = :ssbsectGschName"),
    @NamedQuery(name = "Ssbsect.findBySsbsectBestOfComp", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectBestOfComp = :ssbsectBestOfComp"),
    @NamedQuery(name = "Ssbsect.findBySsbsectSubsetOfComp", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectSubsetOfComp = :ssbsectSubsetOfComp"),
    @NamedQuery(name = "Ssbsect.findBySsbsectInsmCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectInsmCode = :ssbsectInsmCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectRegFromDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectRegFromDate = :ssbsectRegFromDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectRegToDate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectRegToDate = :ssbsectRegToDate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectLearnerRegstartFdate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectLearnerRegstartFdate = :ssbsectLearnerRegstartFdate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectLearnerRegstartTdate", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectLearnerRegstartTdate = :ssbsectLearnerRegstartTdate"),
    @NamedQuery(name = "Ssbsect.findBySsbsectDuntCode", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectDuntCode = :ssbsectDuntCode"),
    @NamedQuery(name = "Ssbsect.findBySsbsectNumberOfUnits", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectNumberOfUnits = :ssbsectNumberOfUnits"),
    @NamedQuery(name = "Ssbsect.findBySsbsectNumberOfExtensions", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectNumberOfExtensions = :ssbsectNumberOfExtensions"),
    @NamedQuery(name = "Ssbsect.findBySsbsectDataOrigin", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectDataOrigin = :ssbsectDataOrigin"),
    @NamedQuery(name = "Ssbsect.findBySsbsectUserId", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectUserId = :ssbsectUserId"),
    @NamedQuery(name = "Ssbsect.findBySsbsectIntgCde", query = "SELECT s FROM Ssbsect s WHERE s.ssbsectIntgCde = :ssbsectIntgCde")})
public class Ssbsect implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SsbsectPK ssbsectPK;
    @Size(max = 3)
    @Column(name = "SSBSECT_PTRM_CODE")
    private String ssbsectPtrmCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SSBSECT_SUBJ_CODE")
    private String ssbsectSubjCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SSBSECT_CRSE_NUMB")
    private String ssbsectCrseNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SSBSECT_SEQ_NUMB")
    private String ssbsectSeqNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SSBSECT_SSTS_CODE")
    private String ssbsectSstsCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SSBSECT_SCHD_CODE")
    private String ssbsectSchdCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SSBSECT_CAMP_CODE")
    private String ssbsectCampCode;
    @Size(max = 30)
    @Column(name = "SSBSECT_CRSE_TITLE")
    private String ssbsectCrseTitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SSBSECT_CREDIT_HRS")
    private BigDecimal ssbsectCreditHrs;
    @Column(name = "SSBSECT_BILL_HRS")
    private BigDecimal ssbsectBillHrs;
    @Size(max = 1)
    @Column(name = "SSBSECT_GMOD_CODE")
    private String ssbsectGmodCode;
    @Size(max = 2)
    @Column(name = "SSBSECT_SAPR_CODE")
    private String ssbsectSaprCode;
    @Size(max = 1)
    @Column(name = "SSBSECT_SESS_CODE")
    private String ssbsectSessCode;
    @Size(max = 2)
    @Column(name = "SSBSECT_LINK_IDENT")
    private String ssbsectLinkIdent;
    @Size(max = 1)
    @Column(name = "SSBSECT_PRNT_IND")
    private String ssbsectPrntInd;
    @Size(max = 1)
    @Column(name = "SSBSECT_GRADABLE_IND")
    private String ssbsectGradableInd;
    @Size(max = 1)
    @Column(name = "SSBSECT_TUIW_IND")
    private String ssbsectTuiwInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_REG_ONEUP")
    private short ssbsectRegOneup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_PRIOR_ENRL")
    private short ssbsectPriorEnrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_PROJ_ENRL")
    private short ssbsectProjEnrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_MAX_ENRL")
    private short ssbsectMaxEnrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_ENRL")
    private short ssbsectEnrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_SEATS_AVAIL")
    private short ssbsectSeatsAvail;
    @Column(name = "SSBSECT_TOT_CREDIT_HRS")
    private BigDecimal ssbsectTotCreditHrs;
    @Column(name = "SSBSECT_CENSUS_ENRL")
    private Short ssbsectCensusEnrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_CENSUS_ENRL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectCensusEnrlDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectActivityDate;
    @Column(name = "SSBSECT_PTRM_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectPtrmStartDate;
    @Column(name = "SSBSECT_PTRM_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectPtrmEndDate;
    @Column(name = "SSBSECT_PTRM_WEEKS")
    private Short ssbsectPtrmWeeks;
    @Size(max = 1)
    @Column(name = "SSBSECT_RESERVED_IND")
    private String ssbsectReservedInd;
    @Column(name = "SSBSECT_WAIT_CAPACITY")
    private Short ssbsectWaitCapacity;
    @Column(name = "SSBSECT_WAIT_COUNT")
    private Short ssbsectWaitCount;
    @Column(name = "SSBSECT_WAIT_AVAIL")
    private Short ssbsectWaitAvail;
    @Column(name = "SSBSECT_LEC_HR")
    private BigDecimal ssbsectLecHr;
    @Column(name = "SSBSECT_LAB_HR")
    private BigDecimal ssbsectLabHr;
    @Column(name = "SSBSECT_OTH_HR")
    private BigDecimal ssbsectOthHr;
    @Column(name = "SSBSECT_CONT_HR")
    private BigDecimal ssbsectContHr;
    @Size(max = 2)
    @Column(name = "SSBSECT_ACCT_CODE")
    private String ssbsectAcctCode;
    @Size(max = 2)
    @Column(name = "SSBSECT_ACCL_CODE")
    private String ssbsectAcclCode;
    @Column(name = "SSBSECT_CENSUS_2_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectCensus2Date;
    @Column(name = "SSBSECT_ENRL_CUT_OFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectEnrlCutOffDate;
    @Column(name = "SSBSECT_ACAD_CUT_OFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectAcadCutOffDate;
    @Column(name = "SSBSECT_DROP_CUT_OFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectDropCutOffDate;
    @Column(name = "SSBSECT_CENSUS_2_ENRL")
    private Short ssbsectCensus2Enrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SSBSECT_VOICE_AVAIL")
    private String ssbsectVoiceAvail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SSBSECT_CAPP_PREREQ_TEST_IND")
    private String ssbsectCappPrereqTestInd;
    @Size(max = 10)
    @Column(name = "SSBSECT_GSCH_NAME")
    private String ssbsectGschName;
    @Column(name = "SSBSECT_BEST_OF_COMP")
    private Short ssbsectBestOfComp;
    @Column(name = "SSBSECT_SUBSET_OF_COMP")
    private Short ssbsectSubsetOfComp;
    @Size(max = 5)
    @Column(name = "SSBSECT_INSM_CODE")
    private String ssbsectInsmCode;
    @Column(name = "SSBSECT_REG_FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectRegFromDate;
    @Column(name = "SSBSECT_REG_TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectRegToDate;
    @Column(name = "SSBSECT_LEARNER_REGSTART_FDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectLearnerRegstartFdate;
    @Column(name = "SSBSECT_LEARNER_REGSTART_TDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssbsectLearnerRegstartTdate;
    @Size(max = 4)
    @Column(name = "SSBSECT_DUNT_CODE")
    private String ssbsectDuntCode;
    @Column(name = "SSBSECT_NUMBER_OF_UNITS")
    private BigDecimal ssbsectNumberOfUnits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSBSECT_NUMBER_OF_EXTENSIONS")
    private short ssbsectNumberOfExtensions;
    @Size(max = 30)
    @Column(name = "SSBSECT_DATA_ORIGIN")
    private String ssbsectDataOrigin;
    @Size(max = 30)
    @Column(name = "SSBSECT_USER_ID")
    private String ssbsectUserId;
    @Size(max = 5)
    @Column(name = "SSBSECT_INTG_CDE")
    private String ssbsectIntgCde;

    public Ssbsect() {
    }

    public Ssbsect(SsbsectPK ssbsectPK) {
        this.ssbsectPK = ssbsectPK;
    }

    public Ssbsect(SsbsectPK ssbsectPK, String ssbsectSubjCode, String ssbsectCrseNumb, String ssbsectSeqNumb, String ssbsectSstsCode, String ssbsectSchdCode, String ssbsectCampCode, short ssbsectRegOneup, short ssbsectPriorEnrl, short ssbsectProjEnrl, short ssbsectMaxEnrl, short ssbsectEnrl, short ssbsectSeatsAvail, Date ssbsectCensusEnrlDate, Date ssbsectActivityDate, String ssbsectVoiceAvail, String ssbsectCappPrereqTestInd, short ssbsectNumberOfExtensions) {
        this.ssbsectPK = ssbsectPK;
        this.ssbsectSubjCode = ssbsectSubjCode;
        this.ssbsectCrseNumb = ssbsectCrseNumb;
        this.ssbsectSeqNumb = ssbsectSeqNumb;
        this.ssbsectSstsCode = ssbsectSstsCode;
        this.ssbsectSchdCode = ssbsectSchdCode;
        this.ssbsectCampCode = ssbsectCampCode;
        this.ssbsectRegOneup = ssbsectRegOneup;
        this.ssbsectPriorEnrl = ssbsectPriorEnrl;
        this.ssbsectProjEnrl = ssbsectProjEnrl;
        this.ssbsectMaxEnrl = ssbsectMaxEnrl;
        this.ssbsectEnrl = ssbsectEnrl;
        this.ssbsectSeatsAvail = ssbsectSeatsAvail;
        this.ssbsectCensusEnrlDate = ssbsectCensusEnrlDate;
        this.ssbsectActivityDate = ssbsectActivityDate;
        this.ssbsectVoiceAvail = ssbsectVoiceAvail;
        this.ssbsectCappPrereqTestInd = ssbsectCappPrereqTestInd;
        this.ssbsectNumberOfExtensions = ssbsectNumberOfExtensions;
    }

    public Ssbsect(String ssbsectTermCode, String ssbsectCrn) {
        this.ssbsectPK = new SsbsectPK(ssbsectTermCode, ssbsectCrn);
    }

    public SsbsectPK getSsbsectPK() {
        return ssbsectPK;
    }

    public void setSsbsectPK(SsbsectPK ssbsectPK) {
        this.ssbsectPK = ssbsectPK;
    }

    public String getSsbsectPtrmCode() {
        return ssbsectPtrmCode;
    }

    public void setSsbsectPtrmCode(String ssbsectPtrmCode) {
        this.ssbsectPtrmCode = ssbsectPtrmCode;
    }

    public String getSsbsectSubjCode() {
        return ssbsectSubjCode;
    }

    public void setSsbsectSubjCode(String ssbsectSubjCode) {
        this.ssbsectSubjCode = ssbsectSubjCode;
    }

    public String getSsbsectCrseNumb() {
        return ssbsectCrseNumb;
    }

    public void setSsbsectCrseNumb(String ssbsectCrseNumb) {
        this.ssbsectCrseNumb = ssbsectCrseNumb;
    }

    public String getSsbsectSeqNumb() {
        return ssbsectSeqNumb;
    }

    public void setSsbsectSeqNumb(String ssbsectSeqNumb) {
        this.ssbsectSeqNumb = ssbsectSeqNumb;
    }

    public String getSsbsectSstsCode() {
        return ssbsectSstsCode;
    }

    public void setSsbsectSstsCode(String ssbsectSstsCode) {
        this.ssbsectSstsCode = ssbsectSstsCode;
    }

    public String getSsbsectSchdCode() {
        return ssbsectSchdCode;
    }

    public void setSsbsectSchdCode(String ssbsectSchdCode) {
        this.ssbsectSchdCode = ssbsectSchdCode;
    }

    public String getSsbsectCampCode() {
        return ssbsectCampCode;
    }

    public void setSsbsectCampCode(String ssbsectCampCode) {
        this.ssbsectCampCode = ssbsectCampCode;
    }

    public String getSsbsectCrseTitle() {
        return ssbsectCrseTitle;
    }

    public void setSsbsectCrseTitle(String ssbsectCrseTitle) {
        this.ssbsectCrseTitle = ssbsectCrseTitle;
    }

    public BigDecimal getSsbsectCreditHrs() {
        return ssbsectCreditHrs;
    }

    public void setSsbsectCreditHrs(BigDecimal ssbsectCreditHrs) {
        this.ssbsectCreditHrs = ssbsectCreditHrs;
    }

    public BigDecimal getSsbsectBillHrs() {
        return ssbsectBillHrs;
    }

    public void setSsbsectBillHrs(BigDecimal ssbsectBillHrs) {
        this.ssbsectBillHrs = ssbsectBillHrs;
    }

    public String getSsbsectGmodCode() {
        return ssbsectGmodCode;
    }

    public void setSsbsectGmodCode(String ssbsectGmodCode) {
        this.ssbsectGmodCode = ssbsectGmodCode;
    }

    public String getSsbsectSaprCode() {
        return ssbsectSaprCode;
    }

    public void setSsbsectSaprCode(String ssbsectSaprCode) {
        this.ssbsectSaprCode = ssbsectSaprCode;
    }

    public String getSsbsectSessCode() {
        return ssbsectSessCode;
    }

    public void setSsbsectSessCode(String ssbsectSessCode) {
        this.ssbsectSessCode = ssbsectSessCode;
    }

    public String getSsbsectLinkIdent() {
        return ssbsectLinkIdent;
    }

    public void setSsbsectLinkIdent(String ssbsectLinkIdent) {
        this.ssbsectLinkIdent = ssbsectLinkIdent;
    }

    public String getSsbsectPrntInd() {
        return ssbsectPrntInd;
    }

    public void setSsbsectPrntInd(String ssbsectPrntInd) {
        this.ssbsectPrntInd = ssbsectPrntInd;
    }

    public String getSsbsectGradableInd() {
        return ssbsectGradableInd;
    }

    public void setSsbsectGradableInd(String ssbsectGradableInd) {
        this.ssbsectGradableInd = ssbsectGradableInd;
    }

    public String getSsbsectTuiwInd() {
        return ssbsectTuiwInd;
    }

    public void setSsbsectTuiwInd(String ssbsectTuiwInd) {
        this.ssbsectTuiwInd = ssbsectTuiwInd;
    }

    public short getSsbsectRegOneup() {
        return ssbsectRegOneup;
    }

    public void setSsbsectRegOneup(short ssbsectRegOneup) {
        this.ssbsectRegOneup = ssbsectRegOneup;
    }

    public short getSsbsectPriorEnrl() {
        return ssbsectPriorEnrl;
    }

    public void setSsbsectPriorEnrl(short ssbsectPriorEnrl) {
        this.ssbsectPriorEnrl = ssbsectPriorEnrl;
    }

    public short getSsbsectProjEnrl() {
        return ssbsectProjEnrl;
    }

    public void setSsbsectProjEnrl(short ssbsectProjEnrl) {
        this.ssbsectProjEnrl = ssbsectProjEnrl;
    }

    public short getSsbsectMaxEnrl() {
        return ssbsectMaxEnrl;
    }

    public void setSsbsectMaxEnrl(short ssbsectMaxEnrl) {
        this.ssbsectMaxEnrl = ssbsectMaxEnrl;
    }

    public short getSsbsectEnrl() {
        return ssbsectEnrl;
    }

    public void setSsbsectEnrl(short ssbsectEnrl) {
        this.ssbsectEnrl = ssbsectEnrl;
    }

    public short getSsbsectSeatsAvail() {
        return ssbsectSeatsAvail;
    }

    public void setSsbsectSeatsAvail(short ssbsectSeatsAvail) {
        this.ssbsectSeatsAvail = ssbsectSeatsAvail;
    }

    public BigDecimal getSsbsectTotCreditHrs() {
        return ssbsectTotCreditHrs;
    }

    public void setSsbsectTotCreditHrs(BigDecimal ssbsectTotCreditHrs) {
        this.ssbsectTotCreditHrs = ssbsectTotCreditHrs;
    }

    public Short getSsbsectCensusEnrl() {
        return ssbsectCensusEnrl;
    }

    public void setSsbsectCensusEnrl(Short ssbsectCensusEnrl) {
        this.ssbsectCensusEnrl = ssbsectCensusEnrl;
    }

    public Date getSsbsectCensusEnrlDate() {
        return ssbsectCensusEnrlDate;
    }

    public void setSsbsectCensusEnrlDate(Date ssbsectCensusEnrlDate) {
        this.ssbsectCensusEnrlDate = ssbsectCensusEnrlDate;
    }

    public Date getSsbsectActivityDate() {
        return ssbsectActivityDate;
    }

    public void setSsbsectActivityDate(Date ssbsectActivityDate) {
        this.ssbsectActivityDate = ssbsectActivityDate;
    }

    public Date getSsbsectPtrmStartDate() {
        return ssbsectPtrmStartDate;
    }

    public void setSsbsectPtrmStartDate(Date ssbsectPtrmStartDate) {
        this.ssbsectPtrmStartDate = ssbsectPtrmStartDate;
    }

    public Date getSsbsectPtrmEndDate() {
        return ssbsectPtrmEndDate;
    }

    public void setSsbsectPtrmEndDate(Date ssbsectPtrmEndDate) {
        this.ssbsectPtrmEndDate = ssbsectPtrmEndDate;
    }

    public Short getSsbsectPtrmWeeks() {
        return ssbsectPtrmWeeks;
    }

    public void setSsbsectPtrmWeeks(Short ssbsectPtrmWeeks) {
        this.ssbsectPtrmWeeks = ssbsectPtrmWeeks;
    }

    public String getSsbsectReservedInd() {
        return ssbsectReservedInd;
    }

    public void setSsbsectReservedInd(String ssbsectReservedInd) {
        this.ssbsectReservedInd = ssbsectReservedInd;
    }

    public Short getSsbsectWaitCapacity() {
        return ssbsectWaitCapacity;
    }

    public void setSsbsectWaitCapacity(Short ssbsectWaitCapacity) {
        this.ssbsectWaitCapacity = ssbsectWaitCapacity;
    }

    public Short getSsbsectWaitCount() {
        return ssbsectWaitCount;
    }

    public void setSsbsectWaitCount(Short ssbsectWaitCount) {
        this.ssbsectWaitCount = ssbsectWaitCount;
    }

    public Short getSsbsectWaitAvail() {
        return ssbsectWaitAvail;
    }

    public void setSsbsectWaitAvail(Short ssbsectWaitAvail) {
        this.ssbsectWaitAvail = ssbsectWaitAvail;
    }

    public BigDecimal getSsbsectLecHr() {
        return ssbsectLecHr;
    }

    public void setSsbsectLecHr(BigDecimal ssbsectLecHr) {
        this.ssbsectLecHr = ssbsectLecHr;
    }

    public BigDecimal getSsbsectLabHr() {
        return ssbsectLabHr;
    }

    public void setSsbsectLabHr(BigDecimal ssbsectLabHr) {
        this.ssbsectLabHr = ssbsectLabHr;
    }

    public BigDecimal getSsbsectOthHr() {
        return ssbsectOthHr;
    }

    public void setSsbsectOthHr(BigDecimal ssbsectOthHr) {
        this.ssbsectOthHr = ssbsectOthHr;
    }

    public BigDecimal getSsbsectContHr() {
        return ssbsectContHr;
    }

    public void setSsbsectContHr(BigDecimal ssbsectContHr) {
        this.ssbsectContHr = ssbsectContHr;
    }

    public String getSsbsectAcctCode() {
        return ssbsectAcctCode;
    }

    public void setSsbsectAcctCode(String ssbsectAcctCode) {
        this.ssbsectAcctCode = ssbsectAcctCode;
    }

    public String getSsbsectAcclCode() {
        return ssbsectAcclCode;
    }

    public void setSsbsectAcclCode(String ssbsectAcclCode) {
        this.ssbsectAcclCode = ssbsectAcclCode;
    }

    public Date getSsbsectCensus2Date() {
        return ssbsectCensus2Date;
    }

    public void setSsbsectCensus2Date(Date ssbsectCensus2Date) {
        this.ssbsectCensus2Date = ssbsectCensus2Date;
    }

    public Date getSsbsectEnrlCutOffDate() {
        return ssbsectEnrlCutOffDate;
    }

    public void setSsbsectEnrlCutOffDate(Date ssbsectEnrlCutOffDate) {
        this.ssbsectEnrlCutOffDate = ssbsectEnrlCutOffDate;
    }

    public Date getSsbsectAcadCutOffDate() {
        return ssbsectAcadCutOffDate;
    }

    public void setSsbsectAcadCutOffDate(Date ssbsectAcadCutOffDate) {
        this.ssbsectAcadCutOffDate = ssbsectAcadCutOffDate;
    }

    public Date getSsbsectDropCutOffDate() {
        return ssbsectDropCutOffDate;
    }

    public void setSsbsectDropCutOffDate(Date ssbsectDropCutOffDate) {
        this.ssbsectDropCutOffDate = ssbsectDropCutOffDate;
    }

    public Short getSsbsectCensus2Enrl() {
        return ssbsectCensus2Enrl;
    }

    public void setSsbsectCensus2Enrl(Short ssbsectCensus2Enrl) {
        this.ssbsectCensus2Enrl = ssbsectCensus2Enrl;
    }

    public String getSsbsectVoiceAvail() {
        return ssbsectVoiceAvail;
    }

    public void setSsbsectVoiceAvail(String ssbsectVoiceAvail) {
        this.ssbsectVoiceAvail = ssbsectVoiceAvail;
    }

    public String getSsbsectCappPrereqTestInd() {
        return ssbsectCappPrereqTestInd;
    }

    public void setSsbsectCappPrereqTestInd(String ssbsectCappPrereqTestInd) {
        this.ssbsectCappPrereqTestInd = ssbsectCappPrereqTestInd;
    }

    public String getSsbsectGschName() {
        return ssbsectGschName;
    }

    public void setSsbsectGschName(String ssbsectGschName) {
        this.ssbsectGschName = ssbsectGschName;
    }

    public Short getSsbsectBestOfComp() {
        return ssbsectBestOfComp;
    }

    public void setSsbsectBestOfComp(Short ssbsectBestOfComp) {
        this.ssbsectBestOfComp = ssbsectBestOfComp;
    }

    public Short getSsbsectSubsetOfComp() {
        return ssbsectSubsetOfComp;
    }

    public void setSsbsectSubsetOfComp(Short ssbsectSubsetOfComp) {
        this.ssbsectSubsetOfComp = ssbsectSubsetOfComp;
    }

    public String getSsbsectInsmCode() {
        return ssbsectInsmCode;
    }

    public void setSsbsectInsmCode(String ssbsectInsmCode) {
        this.ssbsectInsmCode = ssbsectInsmCode;
    }

    public Date getSsbsectRegFromDate() {
        return ssbsectRegFromDate;
    }

    public void setSsbsectRegFromDate(Date ssbsectRegFromDate) {
        this.ssbsectRegFromDate = ssbsectRegFromDate;
    }

    public Date getSsbsectRegToDate() {
        return ssbsectRegToDate;
    }

    public void setSsbsectRegToDate(Date ssbsectRegToDate) {
        this.ssbsectRegToDate = ssbsectRegToDate;
    }

    public Date getSsbsectLearnerRegstartFdate() {
        return ssbsectLearnerRegstartFdate;
    }

    public void setSsbsectLearnerRegstartFdate(Date ssbsectLearnerRegstartFdate) {
        this.ssbsectLearnerRegstartFdate = ssbsectLearnerRegstartFdate;
    }

    public Date getSsbsectLearnerRegstartTdate() {
        return ssbsectLearnerRegstartTdate;
    }

    public void setSsbsectLearnerRegstartTdate(Date ssbsectLearnerRegstartTdate) {
        this.ssbsectLearnerRegstartTdate = ssbsectLearnerRegstartTdate;
    }

    public String getSsbsectDuntCode() {
        return ssbsectDuntCode;
    }

    public void setSsbsectDuntCode(String ssbsectDuntCode) {
        this.ssbsectDuntCode = ssbsectDuntCode;
    }

    public BigDecimal getSsbsectNumberOfUnits() {
        return ssbsectNumberOfUnits;
    }

    public void setSsbsectNumberOfUnits(BigDecimal ssbsectNumberOfUnits) {
        this.ssbsectNumberOfUnits = ssbsectNumberOfUnits;
    }

    public short getSsbsectNumberOfExtensions() {
        return ssbsectNumberOfExtensions;
    }

    public void setSsbsectNumberOfExtensions(short ssbsectNumberOfExtensions) {
        this.ssbsectNumberOfExtensions = ssbsectNumberOfExtensions;
    }

    public String getSsbsectDataOrigin() {
        return ssbsectDataOrigin;
    }

    public void setSsbsectDataOrigin(String ssbsectDataOrigin) {
        this.ssbsectDataOrigin = ssbsectDataOrigin;
    }

    public String getSsbsectUserId() {
        return ssbsectUserId;
    }

    public void setSsbsectUserId(String ssbsectUserId) {
        this.ssbsectUserId = ssbsectUserId;
    }

    public String getSsbsectIntgCde() {
        return ssbsectIntgCde;
    }

    public void setSsbsectIntgCde(String ssbsectIntgCde) {
        this.ssbsectIntgCde = ssbsectIntgCde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssbsectPK != null ? ssbsectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ssbsect)) {
            return false;
        }
        Ssbsect other = (Ssbsect) object;
        if ((this.ssbsectPK == null && other.ssbsectPK != null) || (this.ssbsectPK != null && !this.ssbsectPK.equals(other.ssbsectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Ssbsect[ ssbsectPK=" + ssbsectPK + " ]";
    }
    
}
