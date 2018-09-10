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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SFRSTCR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sfrstcr.findAll", query = "SELECT s FROM Sfrstcr s"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrTermCode", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrPK.sfrstcrTermCode = :sfrstcrTermCode"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrPidm", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrPK.sfrstcrPidm = :sfrstcrPidm"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCrn", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrPK.sfrstcrCrn = :sfrstcrCrn"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrClassSortKey", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrClassSortKey = :sfrstcrClassSortKey"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrRegSeq", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrRegSeq = :sfrstcrRegSeq"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrPtrmCode", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrPtrmCode = :sfrstcrPtrmCode"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrRstsDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrRstsDate = :sfrstcrRstsDate"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrErrorFlag", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrErrorFlag = :sfrstcrErrorFlag"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrMessage", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrMessage = :sfrstcrMessage"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrBillHr", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrBillHr = :sfrstcrBillHr"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrWaivHr", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrWaivHr = :sfrstcrWaivHr"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCreditHr", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCreditHr = :sfrstcrCreditHr"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrBillHrHold", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrBillHrHold = :sfrstcrBillHrHold"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCreditHrHold", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCreditHrHold = :sfrstcrCreditHrHold"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGmodCode", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGmodCode = :sfrstcrGmodCode"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGrdeCode", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGrdeCode = :sfrstcrGrdeCode"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGrdeCodeMid", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGrdeCodeMid = :sfrstcrGrdeCodeMid"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGrdeDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGrdeDate = :sfrstcrGrdeDate"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrDuplOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrDuplOver = :sfrstcrDuplOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrLinkOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrLinkOver = :sfrstcrLinkOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCorqOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCorqOver = :sfrstcrCorqOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrPreqOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrPreqOver = :sfrstcrPreqOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrTimeOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrTimeOver = :sfrstcrTimeOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCapcOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCapcOver = :sfrstcrCapcOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrLevlOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrLevlOver = :sfrstcrLevlOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCollOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCollOver = :sfrstcrCollOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrMajrOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrMajrOver = :sfrstcrMajrOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrClasOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrClasOver = :sfrstcrClasOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrApprOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrApprOver = :sfrstcrApprOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrApprReceivedInd", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrApprReceivedInd = :sfrstcrApprReceivedInd"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrAddDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrAddDate = :sfrstcrAddDate"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrActivityDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrActivityDate = :sfrstcrActivityDate"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrReservedKey", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrReservedKey = :sfrstcrReservedKey"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrAttendHr", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrAttendHr = :sfrstcrAttendHr"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrReptOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrReptOver = :sfrstcrReptOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrRpthOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrRpthOver = :sfrstcrRpthOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrTestOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrTestOver = :sfrstcrTestOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrCampOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrCampOver = :sfrstcrCampOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrUser", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrUser = :sfrstcrUser"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrDegcOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrDegcOver = :sfrstcrDegcOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrProgOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrProgOver = :sfrstcrProgOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrLastAttend", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrLastAttend = :sfrstcrLastAttend"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGcmtCode", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGcmtCode = :sfrstcrGcmtCode"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrDataOrigin", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrDataOrigin = :sfrstcrDataOrigin"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrAssessActivityDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrAssessActivityDate = :sfrstcrAssessActivityDate"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrDeptOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrDeptOver = :sfrstcrDeptOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrAttsOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrAttsOver = :sfrstcrAttsOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrChrtOver", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrChrtOver = :sfrstcrChrtOver"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrRmsgCde", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrRmsgCde = :sfrstcrRmsgCde"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrWlPriority", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrWlPriority = :sfrstcrWlPriority"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrWlPriorityOrig", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrWlPriorityOrig = :sfrstcrWlPriorityOrig"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrGrdeCodeIncmpFinal", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrGrdeCodeIncmpFinal = :sfrstcrGrdeCodeIncmpFinal"),
    @NamedQuery(name = "Sfrstcr.findBySfrstcrIncompleteExtDate", query = "SELECT s FROM Sfrstcr s WHERE s.sfrstcrIncompleteExtDate = :sfrstcrIncompleteExtDate")})
public class Sfrstcr implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SfrstcrPK sfrstcrPK;
    @Column(name = "SFRSTCR_CLASS_SORT_KEY")
    private Short sfrstcrClassSortKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFRSTCR_REG_SEQ")
    private short sfrstcrRegSeq;
    @Size(max = 3)
    @Column(name = "SFRSTCR_PTRM_CODE")
    private String sfrstcrPtrmCode;
    @Column(name = "SFRSTCR_RSTS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrRstsDate;
    @Size(max = 1)
    @Column(name = "SFRSTCR_ERROR_FLAG")
    private String sfrstcrErrorFlag;
    @Size(max = 200)
    @Column(name = "SFRSTCR_MESSAGE")
    private String sfrstcrMessage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SFRSTCR_BILL_HR")
    private BigDecimal sfrstcrBillHr;
    @Column(name = "SFRSTCR_WAIV_HR")
    private BigDecimal sfrstcrWaivHr;
    @Column(name = "SFRSTCR_CREDIT_HR")
    private BigDecimal sfrstcrCreditHr;
    @Column(name = "SFRSTCR_BILL_HR_HOLD")
    private BigDecimal sfrstcrBillHrHold;
    @Column(name = "SFRSTCR_CREDIT_HR_HOLD")
    private BigDecimal sfrstcrCreditHrHold;
    @Size(max = 1)
    @Column(name = "SFRSTCR_GMOD_CODE")
    private String sfrstcrGmodCode;
    @Size(max = 6)
    @Column(name = "SFRSTCR_GRDE_CODE")
    private String sfrstcrGrdeCode;
    @Size(max = 6)
    @Column(name = "SFRSTCR_GRDE_CODE_MID")
    private String sfrstcrGrdeCodeMid;
    @Column(name = "SFRSTCR_GRDE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrGrdeDate;
    @Size(max = 1)
    @Column(name = "SFRSTCR_DUPL_OVER")
    private String sfrstcrDuplOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_LINK_OVER")
    private String sfrstcrLinkOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_CORQ_OVER")
    private String sfrstcrCorqOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_PREQ_OVER")
    private String sfrstcrPreqOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_TIME_OVER")
    private String sfrstcrTimeOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_CAPC_OVER")
    private String sfrstcrCapcOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_LEVL_OVER")
    private String sfrstcrLevlOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_COLL_OVER")
    private String sfrstcrCollOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_MAJR_OVER")
    private String sfrstcrMajrOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_CLAS_OVER")
    private String sfrstcrClasOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_APPR_OVER")
    private String sfrstcrApprOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_APPR_RECEIVED_IND")
    private String sfrstcrApprReceivedInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFRSTCR_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrAddDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SFRSTCR_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrActivityDate;
    @Size(max = 82)
    @Column(name = "SFRSTCR_RESERVED_KEY")
    private String sfrstcrReservedKey;
    @Column(name = "SFRSTCR_ATTEND_HR")
    private BigDecimal sfrstcrAttendHr;
    @Size(max = 1)
    @Column(name = "SFRSTCR_REPT_OVER")
    private String sfrstcrReptOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_RPTH_OVER")
    private String sfrstcrRpthOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_TEST_OVER")
    private String sfrstcrTestOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_CAMP_OVER")
    private String sfrstcrCampOver;
    @Size(max = 30)
    @Column(name = "SFRSTCR_USER")
    private String sfrstcrUser;
    @Size(max = 1)
    @Column(name = "SFRSTCR_DEGC_OVER")
    private String sfrstcrDegcOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_PROG_OVER")
    private String sfrstcrProgOver;
    @Column(name = "SFRSTCR_LAST_ATTEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrLastAttend;
    @Size(max = 7)
    @Column(name = "SFRSTCR_GCMT_CODE")
    private String sfrstcrGcmtCode;
    @Size(max = 30)
    @Column(name = "SFRSTCR_DATA_ORIGIN")
    private String sfrstcrDataOrigin;
    @Column(name = "SFRSTCR_ASSESS_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrAssessActivityDate;
    @Size(max = 1)
    @Column(name = "SFRSTCR_DEPT_OVER")
    private String sfrstcrDeptOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_ATTS_OVER")
    private String sfrstcrAttsOver;
    @Size(max = 1)
    @Column(name = "SFRSTCR_CHRT_OVER")
    private String sfrstcrChrtOver;
    @Size(max = 4)
    @Column(name = "SFRSTCR_RMSG_CDE")
    private String sfrstcrRmsgCde;
    @Column(name = "SFRSTCR_WL_PRIORITY")
    private BigDecimal sfrstcrWlPriority;
    @Size(max = 1)
    @Column(name = "SFRSTCR_WL_PRIORITY_ORIG")
    private String sfrstcrWlPriorityOrig;
    @Size(max = 6)
    @Column(name = "SFRSTCR_GRDE_CODE_INCMP_FINAL")
    private String sfrstcrGrdeCodeIncmpFinal;
    @Column(name = "SFRSTCR_INCOMPLETE_EXT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sfrstcrIncompleteExtDate;
    @JoinColumn(name = "SFRSTCR_TERM_CODE", referencedColumnName = "STVTERM_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stvterm stvterm;
    @JoinColumn(name = "SFRSTCR_RSTS_CODE", referencedColumnName = "STVRSTS_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvrsts sfrstcrRstsCode;
    @JoinColumn(name = "SFRSTCR_LEVL_CODE", referencedColumnName = "STVLEVL_CODE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stvlevl sfrstcrLevlCode;
    @JoinColumn(name = "SFRSTCR_CAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stvcamp sfrstcrCampCode;
    
//    @JoinColumn(name = "USU_ID_DOCENTE", referencedColumnName = "USU_ID")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private SegUsuario usuario;    

    public Sfrstcr() {
    }

    public Sfrstcr(SfrstcrPK sfrstcrPK) {
        this.sfrstcrPK = sfrstcrPK;
    }

    public Sfrstcr(SfrstcrPK sfrstcrPK, short sfrstcrRegSeq, Date sfrstcrAddDate, Date sfrstcrActivityDate) {
        this.sfrstcrPK = sfrstcrPK;
        this.sfrstcrRegSeq = sfrstcrRegSeq;
        this.sfrstcrAddDate = sfrstcrAddDate;
        this.sfrstcrActivityDate = sfrstcrActivityDate;
    }

    public Sfrstcr(String sfrstcrTermCode, int sfrstcrPidm, String sfrstcrCrn) {
        this.sfrstcrPK = new SfrstcrPK(sfrstcrTermCode, sfrstcrPidm, sfrstcrCrn);
    }

    public SfrstcrPK getSfrstcrPK() {
        return sfrstcrPK;
    }

    public void setSfrstcrPK(SfrstcrPK sfrstcrPK) {
        this.sfrstcrPK = sfrstcrPK;
    }

    public Short getSfrstcrClassSortKey() {
        return sfrstcrClassSortKey;
    }

    public void setSfrstcrClassSortKey(Short sfrstcrClassSortKey) {
        this.sfrstcrClassSortKey = sfrstcrClassSortKey;
    }

    public short getSfrstcrRegSeq() {
        return sfrstcrRegSeq;
    }

    public void setSfrstcrRegSeq(short sfrstcrRegSeq) {
        this.sfrstcrRegSeq = sfrstcrRegSeq;
    }

    public String getSfrstcrPtrmCode() {
        return sfrstcrPtrmCode;
    }

    public void setSfrstcrPtrmCode(String sfrstcrPtrmCode) {
        this.sfrstcrPtrmCode = sfrstcrPtrmCode;
    }

    public Date getSfrstcrRstsDate() {
        return sfrstcrRstsDate;
    }

    public void setSfrstcrRstsDate(Date sfrstcrRstsDate) {
        this.sfrstcrRstsDate = sfrstcrRstsDate;
    }

    public String getSfrstcrErrorFlag() {
        return sfrstcrErrorFlag;
    }

    public void setSfrstcrErrorFlag(String sfrstcrErrorFlag) {
        this.sfrstcrErrorFlag = sfrstcrErrorFlag;
    }

    public String getSfrstcrMessage() {
        return sfrstcrMessage;
    }

    public void setSfrstcrMessage(String sfrstcrMessage) {
        this.sfrstcrMessage = sfrstcrMessage;
    }

    public BigDecimal getSfrstcrBillHr() {
        return sfrstcrBillHr;
    }

    public void setSfrstcrBillHr(BigDecimal sfrstcrBillHr) {
        this.sfrstcrBillHr = sfrstcrBillHr;
    }

    public BigDecimal getSfrstcrWaivHr() {
        return sfrstcrWaivHr;
    }

    public void setSfrstcrWaivHr(BigDecimal sfrstcrWaivHr) {
        this.sfrstcrWaivHr = sfrstcrWaivHr;
    }

    public BigDecimal getSfrstcrCreditHr() {
        return sfrstcrCreditHr;
    }

    public void setSfrstcrCreditHr(BigDecimal sfrstcrCreditHr) {
        this.sfrstcrCreditHr = sfrstcrCreditHr;
    }

    public BigDecimal getSfrstcrBillHrHold() {
        return sfrstcrBillHrHold;
    }

    public void setSfrstcrBillHrHold(BigDecimal sfrstcrBillHrHold) {
        this.sfrstcrBillHrHold = sfrstcrBillHrHold;
    }

    public BigDecimal getSfrstcrCreditHrHold() {
        return sfrstcrCreditHrHold;
    }

    public void setSfrstcrCreditHrHold(BigDecimal sfrstcrCreditHrHold) {
        this.sfrstcrCreditHrHold = sfrstcrCreditHrHold;
    }

    public String getSfrstcrGmodCode() {
        return sfrstcrGmodCode;
    }

    public void setSfrstcrGmodCode(String sfrstcrGmodCode) {
        this.sfrstcrGmodCode = sfrstcrGmodCode;
    }

    public String getSfrstcrGrdeCode() {
        return sfrstcrGrdeCode;
    }

    public void setSfrstcrGrdeCode(String sfrstcrGrdeCode) {
        this.sfrstcrGrdeCode = sfrstcrGrdeCode;
    }

    public String getSfrstcrGrdeCodeMid() {
        return sfrstcrGrdeCodeMid;
    }

    public void setSfrstcrGrdeCodeMid(String sfrstcrGrdeCodeMid) {
        this.sfrstcrGrdeCodeMid = sfrstcrGrdeCodeMid;
    }

    public Date getSfrstcrGrdeDate() {
        return sfrstcrGrdeDate;
    }

    public void setSfrstcrGrdeDate(Date sfrstcrGrdeDate) {
        this.sfrstcrGrdeDate = sfrstcrGrdeDate;
    }

    public String getSfrstcrDuplOver() {
        return sfrstcrDuplOver;
    }

    public void setSfrstcrDuplOver(String sfrstcrDuplOver) {
        this.sfrstcrDuplOver = sfrstcrDuplOver;
    }

    public String getSfrstcrLinkOver() {
        return sfrstcrLinkOver;
    }

    public void setSfrstcrLinkOver(String sfrstcrLinkOver) {
        this.sfrstcrLinkOver = sfrstcrLinkOver;
    }

    public String getSfrstcrCorqOver() {
        return sfrstcrCorqOver;
    }

    public void setSfrstcrCorqOver(String sfrstcrCorqOver) {
        this.sfrstcrCorqOver = sfrstcrCorqOver;
    }

    public String getSfrstcrPreqOver() {
        return sfrstcrPreqOver;
    }

    public void setSfrstcrPreqOver(String sfrstcrPreqOver) {
        this.sfrstcrPreqOver = sfrstcrPreqOver;
    }

    public String getSfrstcrTimeOver() {
        return sfrstcrTimeOver;
    }

    public void setSfrstcrTimeOver(String sfrstcrTimeOver) {
        this.sfrstcrTimeOver = sfrstcrTimeOver;
    }

    public String getSfrstcrCapcOver() {
        return sfrstcrCapcOver;
    }

    public void setSfrstcrCapcOver(String sfrstcrCapcOver) {
        this.sfrstcrCapcOver = sfrstcrCapcOver;
    }

    public String getSfrstcrLevlOver() {
        return sfrstcrLevlOver;
    }

    public void setSfrstcrLevlOver(String sfrstcrLevlOver) {
        this.sfrstcrLevlOver = sfrstcrLevlOver;
    }

    public String getSfrstcrCollOver() {
        return sfrstcrCollOver;
    }

    public void setSfrstcrCollOver(String sfrstcrCollOver) {
        this.sfrstcrCollOver = sfrstcrCollOver;
    }

    public String getSfrstcrMajrOver() {
        return sfrstcrMajrOver;
    }

    public void setSfrstcrMajrOver(String sfrstcrMajrOver) {
        this.sfrstcrMajrOver = sfrstcrMajrOver;
    }

    public String getSfrstcrClasOver() {
        return sfrstcrClasOver;
    }

    public void setSfrstcrClasOver(String sfrstcrClasOver) {
        this.sfrstcrClasOver = sfrstcrClasOver;
    }

    public String getSfrstcrApprOver() {
        return sfrstcrApprOver;
    }

    public void setSfrstcrApprOver(String sfrstcrApprOver) {
        this.sfrstcrApprOver = sfrstcrApprOver;
    }

    public String getSfrstcrApprReceivedInd() {
        return sfrstcrApprReceivedInd;
    }

    public void setSfrstcrApprReceivedInd(String sfrstcrApprReceivedInd) {
        this.sfrstcrApprReceivedInd = sfrstcrApprReceivedInd;
    }

    public Date getSfrstcrAddDate() {
        return sfrstcrAddDate;
    }

    public void setSfrstcrAddDate(Date sfrstcrAddDate) {
        this.sfrstcrAddDate = sfrstcrAddDate;
    }

    public Date getSfrstcrActivityDate() {
        return sfrstcrActivityDate;
    }

    public void setSfrstcrActivityDate(Date sfrstcrActivityDate) {
        this.sfrstcrActivityDate = sfrstcrActivityDate;
    }

    public String getSfrstcrReservedKey() {
        return sfrstcrReservedKey;
    }

    public void setSfrstcrReservedKey(String sfrstcrReservedKey) {
        this.sfrstcrReservedKey = sfrstcrReservedKey;
    }

    public BigDecimal getSfrstcrAttendHr() {
        return sfrstcrAttendHr;
    }

    public void setSfrstcrAttendHr(BigDecimal sfrstcrAttendHr) {
        this.sfrstcrAttendHr = sfrstcrAttendHr;
    }

    public String getSfrstcrReptOver() {
        return sfrstcrReptOver;
    }

    public void setSfrstcrReptOver(String sfrstcrReptOver) {
        this.sfrstcrReptOver = sfrstcrReptOver;
    }

    public String getSfrstcrRpthOver() {
        return sfrstcrRpthOver;
    }

    public void setSfrstcrRpthOver(String sfrstcrRpthOver) {
        this.sfrstcrRpthOver = sfrstcrRpthOver;
    }

    public String getSfrstcrTestOver() {
        return sfrstcrTestOver;
    }

    public void setSfrstcrTestOver(String sfrstcrTestOver) {
        this.sfrstcrTestOver = sfrstcrTestOver;
    }

    public String getSfrstcrCampOver() {
        return sfrstcrCampOver;
    }

    public void setSfrstcrCampOver(String sfrstcrCampOver) {
        this.sfrstcrCampOver = sfrstcrCampOver;
    }

    public String getSfrstcrUser() {
        return sfrstcrUser;
    }

    public void setSfrstcrUser(String sfrstcrUser) {
        this.sfrstcrUser = sfrstcrUser;
    }

    public String getSfrstcrDegcOver() {
        return sfrstcrDegcOver;
    }

    public void setSfrstcrDegcOver(String sfrstcrDegcOver) {
        this.sfrstcrDegcOver = sfrstcrDegcOver;
    }

    public String getSfrstcrProgOver() {
        return sfrstcrProgOver;
    }

    public void setSfrstcrProgOver(String sfrstcrProgOver) {
        this.sfrstcrProgOver = sfrstcrProgOver;
    }

    public Date getSfrstcrLastAttend() {
        return sfrstcrLastAttend;
    }

    public void setSfrstcrLastAttend(Date sfrstcrLastAttend) {
        this.sfrstcrLastAttend = sfrstcrLastAttend;
    }

    public String getSfrstcrGcmtCode() {
        return sfrstcrGcmtCode;
    }

    public void setSfrstcrGcmtCode(String sfrstcrGcmtCode) {
        this.sfrstcrGcmtCode = sfrstcrGcmtCode;
    }

    public String getSfrstcrDataOrigin() {
        return sfrstcrDataOrigin;
    }

    public void setSfrstcrDataOrigin(String sfrstcrDataOrigin) {
        this.sfrstcrDataOrigin = sfrstcrDataOrigin;
    }

    public Date getSfrstcrAssessActivityDate() {
        return sfrstcrAssessActivityDate;
    }

    public void setSfrstcrAssessActivityDate(Date sfrstcrAssessActivityDate) {
        this.sfrstcrAssessActivityDate = sfrstcrAssessActivityDate;
    }

    public String getSfrstcrDeptOver() {
        return sfrstcrDeptOver;
    }

    public void setSfrstcrDeptOver(String sfrstcrDeptOver) {
        this.sfrstcrDeptOver = sfrstcrDeptOver;
    }

    public String getSfrstcrAttsOver() {
        return sfrstcrAttsOver;
    }

    public void setSfrstcrAttsOver(String sfrstcrAttsOver) {
        this.sfrstcrAttsOver = sfrstcrAttsOver;
    }

    public String getSfrstcrChrtOver() {
        return sfrstcrChrtOver;
    }

    public void setSfrstcrChrtOver(String sfrstcrChrtOver) {
        this.sfrstcrChrtOver = sfrstcrChrtOver;
    }

    public String getSfrstcrRmsgCde() {
        return sfrstcrRmsgCde;
    }

    public void setSfrstcrRmsgCde(String sfrstcrRmsgCde) {
        this.sfrstcrRmsgCde = sfrstcrRmsgCde;
    }

    public BigDecimal getSfrstcrWlPriority() {
        return sfrstcrWlPriority;
    }

    public void setSfrstcrWlPriority(BigDecimal sfrstcrWlPriority) {
        this.sfrstcrWlPriority = sfrstcrWlPriority;
    }

    public String getSfrstcrWlPriorityOrig() {
        return sfrstcrWlPriorityOrig;
    }

    public void setSfrstcrWlPriorityOrig(String sfrstcrWlPriorityOrig) {
        this.sfrstcrWlPriorityOrig = sfrstcrWlPriorityOrig;
    }

    public String getSfrstcrGrdeCodeIncmpFinal() {
        return sfrstcrGrdeCodeIncmpFinal;
    }

    public void setSfrstcrGrdeCodeIncmpFinal(String sfrstcrGrdeCodeIncmpFinal) {
        this.sfrstcrGrdeCodeIncmpFinal = sfrstcrGrdeCodeIncmpFinal;
    }

    public Date getSfrstcrIncompleteExtDate() {
        return sfrstcrIncompleteExtDate;
    }

    public void setSfrstcrIncompleteExtDate(Date sfrstcrIncompleteExtDate) {
        this.sfrstcrIncompleteExtDate = sfrstcrIncompleteExtDate;
    }

    public Stvterm getStvterm() {
        return stvterm;
    }

    public void setStvterm(Stvterm stvterm) {
        this.stvterm = stvterm;
    }

    public Stvrsts getSfrstcrRstsCode() {
        return sfrstcrRstsCode;
    }

    public void setSfrstcrRstsCode(Stvrsts sfrstcrRstsCode) {
        this.sfrstcrRstsCode = sfrstcrRstsCode;
    }

    public Stvlevl getSfrstcrLevlCode() {
        return sfrstcrLevlCode;
    }

    public void setSfrstcrLevlCode(Stvlevl sfrstcrLevlCode) {
        this.sfrstcrLevlCode = sfrstcrLevlCode;
    }

    public Stvcamp getSfrstcrCampCode() {
        return sfrstcrCampCode;
    }

    public void setSfrstcrCampCode(Stvcamp sfrstcrCampCode) {
        this.sfrstcrCampCode = sfrstcrCampCode;
    }

//    public SegUsuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(SegUsuario usuario) {
//        this.usuario = usuario;
//    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfrstcrPK != null ? sfrstcrPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sfrstcr)) {
            return false;
        }
        Sfrstcr other = (Sfrstcr) object;
        if ((this.sfrstcrPK == null && other.sfrstcrPK != null) || (this.sfrstcrPK != null && !this.sfrstcrPK.equals(other.sfrstcrPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Sfrstcr[ sfrstcrPK=" + sfrstcrPK + " ]";
    }
    
}
