/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "SOBTERM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sobterm.findAll", query = "SELECT s FROM Sobterm s"),
    @NamedQuery(name = "Sobterm.findBySobtermTermCode", query = "SELECT s FROM Sobterm s WHERE s.sobtermTermCode = :sobtermTermCode"),
    @NamedQuery(name = "Sobterm.findBySobtermCrnOneup", query = "SELECT s FROM Sobterm s WHERE s.sobtermCrnOneup = :sobtermCrnOneup"),
    @NamedQuery(name = "Sobterm.findBySobtermRegAllowed", query = "SELECT s FROM Sobterm s WHERE s.sobtermRegAllowed = :sobtermRegAllowed"),
    @NamedQuery(name = "Sobterm.findBySobtermReadmReq", query = "SELECT s FROM Sobterm s WHERE s.sobtermReadmReq = :sobtermReadmReq"),
    @NamedQuery(name = "Sobterm.findBySobtermFeeAssessment", query = "SELECT s FROM Sobterm s WHERE s.sobtermFeeAssessment = :sobtermFeeAssessment"),
    @NamedQuery(name = "Sobterm.findBySobtermFeeAssessmntEffDate", query = "SELECT s FROM Sobterm s WHERE s.sobtermFeeAssessmntEffDate = :sobtermFeeAssessmntEffDate"),
    @NamedQuery(name = "Sobterm.findBySobtermDuplSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermDuplSeverity = :sobtermDuplSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermLinkSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermLinkSeverity = :sobtermLinkSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermPreqSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermPreqSeverity = :sobtermPreqSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermCorqSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermCorqSeverity = :sobtermCorqSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermTimeSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermTimeSeverity = :sobtermTimeSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermCapcSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermCapcSeverity = :sobtermCapcSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermLevlSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermLevlSeverity = :sobtermLevlSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermCollSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermCollSeverity = :sobtermCollSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermMajrSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermMajrSeverity = :sobtermMajrSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermClasSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermClasSeverity = :sobtermClasSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermApprSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermApprSeverity = :sobtermApprSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermMaxhSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermMaxhSeverity = :sobtermMaxhSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermHoldSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermHoldSeverity = :sobtermHoldSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermActivityDate", query = "SELECT s FROM Sobterm s WHERE s.sobtermActivityDate = :sobtermActivityDate"),
    @NamedQuery(name = "Sobterm.findBySobtermHold", query = "SELECT s FROM Sobterm s WHERE s.sobtermHold = :sobtermHold"),
    @NamedQuery(name = "Sobterm.findBySobtermRefundInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermRefundInd = :sobtermRefundInd"),
    @NamedQuery(name = "Sobterm.findBySobtermBycrnInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermBycrnInd = :sobtermBycrnInd"),
    @NamedQuery(name = "Sobterm.findBySobtermReptSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermReptSeverity = :sobtermReptSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermRpthSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermRpthSeverity = :sobtermRpthSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermTestSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermTestSeverity = :sobtermTestSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermCampSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermCampSeverity = :sobtermCampSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermFeeAssessVr", query = "SELECT s FROM Sobterm s WHERE s.sobtermFeeAssessVr = :sobtermFeeAssessVr"),
    @NamedQuery(name = "Sobterm.findBySobtermPrintBillVr", query = "SELECT s FROM Sobterm s WHERE s.sobtermPrintBillVr = :sobtermPrintBillVr"),
    @NamedQuery(name = "Sobterm.findBySobtermTmstCalcInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermTmstCalcInd = :sobtermTmstCalcInd"),
    @NamedQuery(name = "Sobterm.findBySobtermInclAttmptHrsInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermInclAttmptHrsInd = :sobtermInclAttmptHrsInd"),
    @NamedQuery(name = "Sobterm.findBySobtermCredWebUpdInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermCredWebUpdInd = :sobtermCredWebUpdInd"),
    @NamedQuery(name = "Sobterm.findBySobtermGmodWebUpdInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermGmodWebUpdInd = :sobtermGmodWebUpdInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLevlWebUpdInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLevlWebUpdInd = :sobtermLevlWebUpdInd"),
    @NamedQuery(name = "Sobterm.findBySobtermClosectWebDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermClosectWebDispInd = :sobtermClosectWebDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermMailerWebInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermMailerWebInd = :sobtermMailerWebInd"),
    @NamedQuery(name = "Sobterm.findBySobtermSchdWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermSchdWebSearchInd = :sobtermSchdWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermCampWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermCampWebSearchInd = :sobtermCampWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermSessWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermSessWebSearchInd = :sobtermSessWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermInstrWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermInstrWebSearchInd = :sobtermInstrWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermFacschdWebDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermFacschdWebDispInd = :sobtermFacschdWebDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermClaslstWebDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermClaslstWebDispInd = :sobtermClaslstWebDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermOverappWebUpdInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermOverappWebUpdInd = :sobtermOverappWebUpdInd"),
    @NamedQuery(name = "Sobterm.findBySobtermAddDrpWebUpdInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermAddDrpWebUpdInd = :sobtermAddDrpWebUpdInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDegreeSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermDegreeSeverity = :sobtermDegreeSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermProgramSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermProgramSeverity = :sobtermProgramSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermInprogressUsageInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermInprogressUsageInd = :sobtermInprogressUsageInd"),
    @NamedQuery(name = "Sobterm.findBySobtermGradeDetailWebInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermGradeDetailWebInd = :sobtermGradeDetailWebInd"),
    @NamedQuery(name = "Sobterm.findBySobtermMidtermWebInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermMidtermWebInd = :sobtermMidtermWebInd"),
    @NamedQuery(name = "Sobterm.findBySobtermProfileSendInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermProfileSendInd = :sobtermProfileSendInd"),
    @NamedQuery(name = "Sobterm.findBySobtermCutoffDate", query = "SELECT s FROM Sobterm s WHERE s.sobtermCutoffDate = :sobtermCutoffDate"),
    @NamedQuery(name = "Sobterm.findBySobtermTivDateSource", query = "SELECT s FROM Sobterm s WHERE s.sobtermTivDateSource = :sobtermTivDateSource"),
    @NamedQuery(name = "Sobterm.findBySobtermWebCappTermInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermWebCappTermInd = :sobtermWebCappTermInd"),
    @NamedQuery(name = "Sobterm.findBySobtermWebCappCatlgInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermWebCappCatlgInd = :sobtermWebCappCatlgInd"),
    @NamedQuery(name = "Sobterm.findBySobtermAttrWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermAttrWebSearchInd = :sobtermAttrWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLevlWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLevlWebSearchInd = :sobtermLevlWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermInsmWebSearchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermInsmWebSearchInd = :sobtermInsmWebSearchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLsTitleWebsDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLsTitleWebsDispInd = :sobtermLsTitleWebsDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLsDescWebsDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLsDescWebsDispInd = :sobtermLsDescWebsDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDurationWebSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermDurationWebSrchInd = :sobtermDurationWebSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLevlWebCatlSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLevlWebCatlSrchInd = :sobtermLevlWebCatlSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermStypWebCatlSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermStypWebCatlSrchInd = :sobtermStypWebCatlSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermCollWebCatlSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermCollWebCatlSrchInd = :sobtermCollWebCatlSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDivWebCatlSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermDivWebCatlSrchInd = :sobtermDivWebCatlSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDeptWebCatlSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermDeptWebCatlSrchInd = :sobtermDeptWebCatlSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermProgAttWebcSrchInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermProgAttWebcSrchInd = :sobtermProgAttWebcSrchInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLcTitleWebcDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLcTitleWebcDispInd = :sobtermLcTitleWebcDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermLcDescWebcDispInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermLcDescWebcDispInd = :sobtermLcDescWebcDispInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDynamicSchedTermInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermDynamicSchedTermInd = :sobtermDynamicSchedTermInd"),
    @NamedQuery(name = "Sobterm.findBySobtermDataOrigin", query = "SELECT s FROM Sobterm s WHERE s.sobtermDataOrigin = :sobtermDataOrigin"),
    @NamedQuery(name = "Sobterm.findBySobtermUserId", query = "SELECT s FROM Sobterm s WHERE s.sobtermUserId = :sobtermUserId"),
    @NamedQuery(name = "Sobterm.findBySobtermAssessSwapInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermAssessSwapInd = :sobtermAssessSwapInd"),
    @NamedQuery(name = "Sobterm.findBySobtermAssessRevNrfInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermAssessRevNrfInd = :sobtermAssessRevNrfInd"),
    @NamedQuery(name = "Sobterm.findBySobtermAssessRegGraceInd", query = "SELECT s FROM Sobterm s WHERE s.sobtermAssessRegGraceInd = :sobtermAssessRegGraceInd"),
    @NamedQuery(name = "Sobterm.findBySobtermMinhSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermMinhSeverity = :sobtermMinhSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermDeptSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermDeptSeverity = :sobtermDeptSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermAttsSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermAttsSeverity = :sobtermAttsSeverity"),
    @NamedQuery(name = "Sobterm.findBySobtermChrtSeverity", query = "SELECT s FROM Sobterm s WHERE s.sobtermChrtSeverity = :sobtermChrtSeverity")})
public class Sobterm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SOBTERM_TERM_CODE")
    private String sobtermTermCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOBTERM_CRN_ONEUP")
    private int sobtermCrnOneup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_REG_ALLOWED")
    private String sobtermRegAllowed;
    @Size(max = 6)
    @Column(name = "SOBTERM_READM_REQ")
    private String sobtermReadmReq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_FEE_ASSESSMENT")
    private String sobtermFeeAssessment;
    @Column(name = "SOBTERM_FEE_ASSESSMNT_EFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sobtermFeeAssessmntEffDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DUPL_SEVERITY")
    private String sobtermDuplSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LINK_SEVERITY")
    private String sobtermLinkSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_PREQ_SEVERITY")
    private String sobtermPreqSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CORQ_SEVERITY")
    private String sobtermCorqSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_TIME_SEVERITY")
    private String sobtermTimeSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CAPC_SEVERITY")
    private String sobtermCapcSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LEVL_SEVERITY")
    private String sobtermLevlSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_COLL_SEVERITY")
    private String sobtermCollSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_MAJR_SEVERITY")
    private String sobtermMajrSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CLAS_SEVERITY")
    private String sobtermClasSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_APPR_SEVERITY")
    private String sobtermApprSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_MAXH_SEVERITY")
    private String sobtermMaxhSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_HOLD_SEVERITY")
    private String sobtermHoldSeverity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOBTERM_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sobtermActivityDate;
    @Size(max = 3)
    @Column(name = "SOBTERM_HOLD")
    private String sobtermHold;
    @Size(max = 1)
    @Column(name = "SOBTERM_REFUND_IND")
    private String sobtermRefundInd;
    @Size(max = 1)
    @Column(name = "SOBTERM_BYCRN_IND")
    private String sobtermBycrnInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_REPT_SEVERITY")
    private String sobtermReptSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_RPTH_SEVERITY")
    private String sobtermRpthSeverity;
    @Size(max = 1)
    @Column(name = "SOBTERM_TEST_SEVERITY")
    private String sobtermTestSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CAMP_SEVERITY")
    private String sobtermCampSeverity;
    @Size(max = 1)
    @Column(name = "SOBTERM_FEE_ASSESS_VR")
    private String sobtermFeeAssessVr;
    @Size(max = 1)
    @Column(name = "SOBTERM_PRINT_BILL_VR")
    private String sobtermPrintBillVr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_TMST_CALC_IND")
    private String sobtermTmstCalcInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_INCL_ATTMPT_HRS_IND")
    private String sobtermInclAttmptHrsInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CRED_WEB_UPD_IND")
    private String sobtermCredWebUpdInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_GMOD_WEB_UPD_IND")
    private String sobtermGmodWebUpdInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LEVL_WEB_UPD_IND")
    private String sobtermLevlWebUpdInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CLOSECT_WEB_DISP_IND")
    private String sobtermClosectWebDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_MAILER_WEB_IND")
    private String sobtermMailerWebInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_SCHD_WEB_SEARCH_IND")
    private String sobtermSchdWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CAMP_WEB_SEARCH_IND")
    private String sobtermCampWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_SESS_WEB_SEARCH_IND")
    private String sobtermSessWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_INSTR_WEB_SEARCH_IND")
    private String sobtermInstrWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_FACSCHD_WEB_DISP_IND")
    private String sobtermFacschdWebDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CLASLST_WEB_DISP_IND")
    private String sobtermClaslstWebDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_OVERAPP_WEB_UPD_IND")
    private String sobtermOverappWebUpdInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ADD_DRP_WEB_UPD_IND")
    private String sobtermAddDrpWebUpdInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DEGREE_SEVERITY")
    private String sobtermDegreeSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_PROGRAM_SEVERITY")
    private String sobtermProgramSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_INPROGRESS_USAGE_IND")
    private String sobtermInprogressUsageInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SOBTERM_GRADE_DETAIL_WEB_IND")
    private String sobtermGradeDetailWebInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SOBTERM_MIDTERM_WEB_IND")
    private String sobtermMidtermWebInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SOBTERM_PROFILE_SEND_IND")
    private String sobtermProfileSendInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOBTERM_CUTOFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sobtermCutoffDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_TIV_DATE_SOURCE")
    private String sobtermTivDateSource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_WEB_CAPP_TERM_IND")
    private String sobtermWebCappTermInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_WEB_CAPP_CATLG_IND")
    private String sobtermWebCappCatlgInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ATTR_WEB_SEARCH_IND")
    private String sobtermAttrWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LEVL_WEB_SEARCH_IND")
    private String sobtermLevlWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_INSM_WEB_SEARCH_IND")
    private String sobtermInsmWebSearchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LS_TITLE_WEBS_DISP_IND")
    private String sobtermLsTitleWebsDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LS_DESC_WEBS_DISP_IND")
    private String sobtermLsDescWebsDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DURATION_WEB_SRCH_IND")
    private String sobtermDurationWebSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LEVL_WEB_CATL_SRCH_IND")
    private String sobtermLevlWebCatlSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_STYP_WEB_CATL_SRCH_IND")
    private String sobtermStypWebCatlSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_COLL_WEB_CATL_SRCH_IND")
    private String sobtermCollWebCatlSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DIV_WEB_CATL_SRCH_IND")
    private String sobtermDivWebCatlSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DEPT_WEB_CATL_SRCH_IND")
    private String sobtermDeptWebCatlSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_PROG_ATT_WEBC_SRCH_IND")
    private String sobtermProgAttWebcSrchInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LC_TITLE_WEBC_DISP_IND")
    private String sobtermLcTitleWebcDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_LC_DESC_WEBC_DISP_IND")
    private String sobtermLcDescWebcDispInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DYNAMIC_SCHED_TERM_IND")
    private String sobtermDynamicSchedTermInd;
    @Size(max = 30)
    @Column(name = "SOBTERM_DATA_ORIGIN")
    private String sobtermDataOrigin;
    @Size(max = 30)
    @Column(name = "SOBTERM_USER_ID")
    private String sobtermUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ASSESS_SWAP_IND")
    private String sobtermAssessSwapInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ASSESS_REV_NRF_IND")
    private String sobtermAssessRevNrfInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ASSESS_REG_GRACE_IND")
    private String sobtermAssessRegGraceInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_MINH_SEVERITY")
    private String sobtermMinhSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_DEPT_SEVERITY")
    private String sobtermDeptSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_ATTS_SEVERITY")
    private String sobtermAttsSeverity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOBTERM_CHRT_SEVERITY")
    private String sobtermChrtSeverity;
    @JoinColumn(name = "SOBTERM_TERM_CODE", referencedColumnName = "STVTERM_CODE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Stvterm stvterm;

    public Sobterm() {
    }

    public Sobterm(String sobtermTermCode) {
        this.sobtermTermCode = sobtermTermCode;
    }

    public Sobterm(String sobtermTermCode, int sobtermCrnOneup, String sobtermRegAllowed, String sobtermFeeAssessment, String sobtermDuplSeverity, String sobtermLinkSeverity, String sobtermPreqSeverity, String sobtermCorqSeverity, String sobtermTimeSeverity, String sobtermCapcSeverity, String sobtermLevlSeverity, String sobtermCollSeverity, String sobtermMajrSeverity, String sobtermClasSeverity, String sobtermApprSeverity, String sobtermMaxhSeverity, String sobtermHoldSeverity, Date sobtermActivityDate, String sobtermReptSeverity, String sobtermRpthSeverity, String sobtermCampSeverity, String sobtermTmstCalcInd, String sobtermInclAttmptHrsInd, String sobtermCredWebUpdInd, String sobtermGmodWebUpdInd, String sobtermLevlWebUpdInd, String sobtermClosectWebDispInd, String sobtermMailerWebInd, String sobtermSchdWebSearchInd, String sobtermCampWebSearchInd, String sobtermSessWebSearchInd, String sobtermInstrWebSearchInd, String sobtermFacschdWebDispInd, String sobtermClaslstWebDispInd, String sobtermOverappWebUpdInd, String sobtermAddDrpWebUpdInd, String sobtermDegreeSeverity, String sobtermProgramSeverity, String sobtermInprogressUsageInd, String sobtermGradeDetailWebInd, String sobtermMidtermWebInd, String sobtermProfileSendInd, Date sobtermCutoffDate, String sobtermTivDateSource, String sobtermWebCappTermInd, String sobtermWebCappCatlgInd, String sobtermAttrWebSearchInd, String sobtermLevlWebSearchInd, String sobtermInsmWebSearchInd, String sobtermLsTitleWebsDispInd, String sobtermLsDescWebsDispInd, String sobtermDurationWebSrchInd, String sobtermLevlWebCatlSrchInd, String sobtermStypWebCatlSrchInd, String sobtermCollWebCatlSrchInd, String sobtermDivWebCatlSrchInd, String sobtermDeptWebCatlSrchInd, String sobtermProgAttWebcSrchInd, String sobtermLcTitleWebcDispInd, String sobtermLcDescWebcDispInd, String sobtermDynamicSchedTermInd, String sobtermAssessSwapInd, String sobtermAssessRevNrfInd, String sobtermAssessRegGraceInd, String sobtermMinhSeverity, String sobtermDeptSeverity, String sobtermAttsSeverity, String sobtermChrtSeverity) {
        this.sobtermTermCode = sobtermTermCode;
        this.sobtermCrnOneup = sobtermCrnOneup;
        this.sobtermRegAllowed = sobtermRegAllowed;
        this.sobtermFeeAssessment = sobtermFeeAssessment;
        this.sobtermDuplSeverity = sobtermDuplSeverity;
        this.sobtermLinkSeverity = sobtermLinkSeverity;
        this.sobtermPreqSeverity = sobtermPreqSeverity;
        this.sobtermCorqSeverity = sobtermCorqSeverity;
        this.sobtermTimeSeverity = sobtermTimeSeverity;
        this.sobtermCapcSeverity = sobtermCapcSeverity;
        this.sobtermLevlSeverity = sobtermLevlSeverity;
        this.sobtermCollSeverity = sobtermCollSeverity;
        this.sobtermMajrSeverity = sobtermMajrSeverity;
        this.sobtermClasSeverity = sobtermClasSeverity;
        this.sobtermApprSeverity = sobtermApprSeverity;
        this.sobtermMaxhSeverity = sobtermMaxhSeverity;
        this.sobtermHoldSeverity = sobtermHoldSeverity;
        this.sobtermActivityDate = sobtermActivityDate;
        this.sobtermReptSeverity = sobtermReptSeverity;
        this.sobtermRpthSeverity = sobtermRpthSeverity;
        this.sobtermCampSeverity = sobtermCampSeverity;
        this.sobtermTmstCalcInd = sobtermTmstCalcInd;
        this.sobtermInclAttmptHrsInd = sobtermInclAttmptHrsInd;
        this.sobtermCredWebUpdInd = sobtermCredWebUpdInd;
        this.sobtermGmodWebUpdInd = sobtermGmodWebUpdInd;
        this.sobtermLevlWebUpdInd = sobtermLevlWebUpdInd;
        this.sobtermClosectWebDispInd = sobtermClosectWebDispInd;
        this.sobtermMailerWebInd = sobtermMailerWebInd;
        this.sobtermSchdWebSearchInd = sobtermSchdWebSearchInd;
        this.sobtermCampWebSearchInd = sobtermCampWebSearchInd;
        this.sobtermSessWebSearchInd = sobtermSessWebSearchInd;
        this.sobtermInstrWebSearchInd = sobtermInstrWebSearchInd;
        this.sobtermFacschdWebDispInd = sobtermFacschdWebDispInd;
        this.sobtermClaslstWebDispInd = sobtermClaslstWebDispInd;
        this.sobtermOverappWebUpdInd = sobtermOverappWebUpdInd;
        this.sobtermAddDrpWebUpdInd = sobtermAddDrpWebUpdInd;
        this.sobtermDegreeSeverity = sobtermDegreeSeverity;
        this.sobtermProgramSeverity = sobtermProgramSeverity;
        this.sobtermInprogressUsageInd = sobtermInprogressUsageInd;
        this.sobtermGradeDetailWebInd = sobtermGradeDetailWebInd;
        this.sobtermMidtermWebInd = sobtermMidtermWebInd;
        this.sobtermProfileSendInd = sobtermProfileSendInd;
        this.sobtermCutoffDate = sobtermCutoffDate;
        this.sobtermTivDateSource = sobtermTivDateSource;
        this.sobtermWebCappTermInd = sobtermWebCappTermInd;
        this.sobtermWebCappCatlgInd = sobtermWebCappCatlgInd;
        this.sobtermAttrWebSearchInd = sobtermAttrWebSearchInd;
        this.sobtermLevlWebSearchInd = sobtermLevlWebSearchInd;
        this.sobtermInsmWebSearchInd = sobtermInsmWebSearchInd;
        this.sobtermLsTitleWebsDispInd = sobtermLsTitleWebsDispInd;
        this.sobtermLsDescWebsDispInd = sobtermLsDescWebsDispInd;
        this.sobtermDurationWebSrchInd = sobtermDurationWebSrchInd;
        this.sobtermLevlWebCatlSrchInd = sobtermLevlWebCatlSrchInd;
        this.sobtermStypWebCatlSrchInd = sobtermStypWebCatlSrchInd;
        this.sobtermCollWebCatlSrchInd = sobtermCollWebCatlSrchInd;
        this.sobtermDivWebCatlSrchInd = sobtermDivWebCatlSrchInd;
        this.sobtermDeptWebCatlSrchInd = sobtermDeptWebCatlSrchInd;
        this.sobtermProgAttWebcSrchInd = sobtermProgAttWebcSrchInd;
        this.sobtermLcTitleWebcDispInd = sobtermLcTitleWebcDispInd;
        this.sobtermLcDescWebcDispInd = sobtermLcDescWebcDispInd;
        this.sobtermDynamicSchedTermInd = sobtermDynamicSchedTermInd;
        this.sobtermAssessSwapInd = sobtermAssessSwapInd;
        this.sobtermAssessRevNrfInd = sobtermAssessRevNrfInd;
        this.sobtermAssessRegGraceInd = sobtermAssessRegGraceInd;
        this.sobtermMinhSeverity = sobtermMinhSeverity;
        this.sobtermDeptSeverity = sobtermDeptSeverity;
        this.sobtermAttsSeverity = sobtermAttsSeverity;
        this.sobtermChrtSeverity = sobtermChrtSeverity;
    }

    public String getSobtermTermCode() {
        return sobtermTermCode;
    }

    public void setSobtermTermCode(String sobtermTermCode) {
        this.sobtermTermCode = sobtermTermCode;
    }

    public int getSobtermCrnOneup() {
        return sobtermCrnOneup;
    }

    public void setSobtermCrnOneup(int sobtermCrnOneup) {
        this.sobtermCrnOneup = sobtermCrnOneup;
    }

    public String getSobtermRegAllowed() {
        return sobtermRegAllowed;
    }

    public void setSobtermRegAllowed(String sobtermRegAllowed) {
        this.sobtermRegAllowed = sobtermRegAllowed;
    }

    public String getSobtermReadmReq() {
        return sobtermReadmReq;
    }

    public void setSobtermReadmReq(String sobtermReadmReq) {
        this.sobtermReadmReq = sobtermReadmReq;
    }

    public String getSobtermFeeAssessment() {
        return sobtermFeeAssessment;
    }

    public void setSobtermFeeAssessment(String sobtermFeeAssessment) {
        this.sobtermFeeAssessment = sobtermFeeAssessment;
    }

    public Date getSobtermFeeAssessmntEffDate() {
        return sobtermFeeAssessmntEffDate;
    }

    public void setSobtermFeeAssessmntEffDate(Date sobtermFeeAssessmntEffDate) {
        this.sobtermFeeAssessmntEffDate = sobtermFeeAssessmntEffDate;
    }

    public String getSobtermDuplSeverity() {
        return sobtermDuplSeverity;
    }

    public void setSobtermDuplSeverity(String sobtermDuplSeverity) {
        this.sobtermDuplSeverity = sobtermDuplSeverity;
    }

    public String getSobtermLinkSeverity() {
        return sobtermLinkSeverity;
    }

    public void setSobtermLinkSeverity(String sobtermLinkSeverity) {
        this.sobtermLinkSeverity = sobtermLinkSeverity;
    }

    public String getSobtermPreqSeverity() {
        return sobtermPreqSeverity;
    }

    public void setSobtermPreqSeverity(String sobtermPreqSeverity) {
        this.sobtermPreqSeverity = sobtermPreqSeverity;
    }

    public String getSobtermCorqSeverity() {
        return sobtermCorqSeverity;
    }

    public void setSobtermCorqSeverity(String sobtermCorqSeverity) {
        this.sobtermCorqSeverity = sobtermCorqSeverity;
    }

    public String getSobtermTimeSeverity() {
        return sobtermTimeSeverity;
    }

    public void setSobtermTimeSeverity(String sobtermTimeSeverity) {
        this.sobtermTimeSeverity = sobtermTimeSeverity;
    }

    public String getSobtermCapcSeverity() {
        return sobtermCapcSeverity;
    }

    public void setSobtermCapcSeverity(String sobtermCapcSeverity) {
        this.sobtermCapcSeverity = sobtermCapcSeverity;
    }

    public String getSobtermLevlSeverity() {
        return sobtermLevlSeverity;
    }

    public void setSobtermLevlSeverity(String sobtermLevlSeverity) {
        this.sobtermLevlSeverity = sobtermLevlSeverity;
    }

    public String getSobtermCollSeverity() {
        return sobtermCollSeverity;
    }

    public void setSobtermCollSeverity(String sobtermCollSeverity) {
        this.sobtermCollSeverity = sobtermCollSeverity;
    }

    public String getSobtermMajrSeverity() {
        return sobtermMajrSeverity;
    }

    public void setSobtermMajrSeverity(String sobtermMajrSeverity) {
        this.sobtermMajrSeverity = sobtermMajrSeverity;
    }

    public String getSobtermClasSeverity() {
        return sobtermClasSeverity;
    }

    public void setSobtermClasSeverity(String sobtermClasSeverity) {
        this.sobtermClasSeverity = sobtermClasSeverity;
    }

    public String getSobtermApprSeverity() {
        return sobtermApprSeverity;
    }

    public void setSobtermApprSeverity(String sobtermApprSeverity) {
        this.sobtermApprSeverity = sobtermApprSeverity;
    }

    public String getSobtermMaxhSeverity() {
        return sobtermMaxhSeverity;
    }

    public void setSobtermMaxhSeverity(String sobtermMaxhSeverity) {
        this.sobtermMaxhSeverity = sobtermMaxhSeverity;
    }

    public String getSobtermHoldSeverity() {
        return sobtermHoldSeverity;
    }

    public void setSobtermHoldSeverity(String sobtermHoldSeverity) {
        this.sobtermHoldSeverity = sobtermHoldSeverity;
    }

    public Date getSobtermActivityDate() {
        return sobtermActivityDate;
    }

    public void setSobtermActivityDate(Date sobtermActivityDate) {
        this.sobtermActivityDate = sobtermActivityDate;
    }

    public String getSobtermHold() {
        return sobtermHold;
    }

    public void setSobtermHold(String sobtermHold) {
        this.sobtermHold = sobtermHold;
    }

    public String getSobtermRefundInd() {
        return sobtermRefundInd;
    }

    public void setSobtermRefundInd(String sobtermRefundInd) {
        this.sobtermRefundInd = sobtermRefundInd;
    }

    public String getSobtermBycrnInd() {
        return sobtermBycrnInd;
    }

    public void setSobtermBycrnInd(String sobtermBycrnInd) {
        this.sobtermBycrnInd = sobtermBycrnInd;
    }

    public String getSobtermReptSeverity() {
        return sobtermReptSeverity;
    }

    public void setSobtermReptSeverity(String sobtermReptSeverity) {
        this.sobtermReptSeverity = sobtermReptSeverity;
    }

    public String getSobtermRpthSeverity() {
        return sobtermRpthSeverity;
    }

    public void setSobtermRpthSeverity(String sobtermRpthSeverity) {
        this.sobtermRpthSeverity = sobtermRpthSeverity;
    }

    public String getSobtermTestSeverity() {
        return sobtermTestSeverity;
    }

    public void setSobtermTestSeverity(String sobtermTestSeverity) {
        this.sobtermTestSeverity = sobtermTestSeverity;
    }

    public String getSobtermCampSeverity() {
        return sobtermCampSeverity;
    }

    public void setSobtermCampSeverity(String sobtermCampSeverity) {
        this.sobtermCampSeverity = sobtermCampSeverity;
    }

    public String getSobtermFeeAssessVr() {
        return sobtermFeeAssessVr;
    }

    public void setSobtermFeeAssessVr(String sobtermFeeAssessVr) {
        this.sobtermFeeAssessVr = sobtermFeeAssessVr;
    }

    public String getSobtermPrintBillVr() {
        return sobtermPrintBillVr;
    }

    public void setSobtermPrintBillVr(String sobtermPrintBillVr) {
        this.sobtermPrintBillVr = sobtermPrintBillVr;
    }

    public String getSobtermTmstCalcInd() {
        return sobtermTmstCalcInd;
    }

    public void setSobtermTmstCalcInd(String sobtermTmstCalcInd) {
        this.sobtermTmstCalcInd = sobtermTmstCalcInd;
    }

    public String getSobtermInclAttmptHrsInd() {
        return sobtermInclAttmptHrsInd;
    }

    public void setSobtermInclAttmptHrsInd(String sobtermInclAttmptHrsInd) {
        this.sobtermInclAttmptHrsInd = sobtermInclAttmptHrsInd;
    }

    public String getSobtermCredWebUpdInd() {
        return sobtermCredWebUpdInd;
    }

    public void setSobtermCredWebUpdInd(String sobtermCredWebUpdInd) {
        this.sobtermCredWebUpdInd = sobtermCredWebUpdInd;
    }

    public String getSobtermGmodWebUpdInd() {
        return sobtermGmodWebUpdInd;
    }

    public void setSobtermGmodWebUpdInd(String sobtermGmodWebUpdInd) {
        this.sobtermGmodWebUpdInd = sobtermGmodWebUpdInd;
    }

    public String getSobtermLevlWebUpdInd() {
        return sobtermLevlWebUpdInd;
    }

    public void setSobtermLevlWebUpdInd(String sobtermLevlWebUpdInd) {
        this.sobtermLevlWebUpdInd = sobtermLevlWebUpdInd;
    }

    public String getSobtermClosectWebDispInd() {
        return sobtermClosectWebDispInd;
    }

    public void setSobtermClosectWebDispInd(String sobtermClosectWebDispInd) {
        this.sobtermClosectWebDispInd = sobtermClosectWebDispInd;
    }

    public String getSobtermMailerWebInd() {
        return sobtermMailerWebInd;
    }

    public void setSobtermMailerWebInd(String sobtermMailerWebInd) {
        this.sobtermMailerWebInd = sobtermMailerWebInd;
    }

    public String getSobtermSchdWebSearchInd() {
        return sobtermSchdWebSearchInd;
    }

    public void setSobtermSchdWebSearchInd(String sobtermSchdWebSearchInd) {
        this.sobtermSchdWebSearchInd = sobtermSchdWebSearchInd;
    }

    public String getSobtermCampWebSearchInd() {
        return sobtermCampWebSearchInd;
    }

    public void setSobtermCampWebSearchInd(String sobtermCampWebSearchInd) {
        this.sobtermCampWebSearchInd = sobtermCampWebSearchInd;
    }

    public String getSobtermSessWebSearchInd() {
        return sobtermSessWebSearchInd;
    }

    public void setSobtermSessWebSearchInd(String sobtermSessWebSearchInd) {
        this.sobtermSessWebSearchInd = sobtermSessWebSearchInd;
    }

    public String getSobtermInstrWebSearchInd() {
        return sobtermInstrWebSearchInd;
    }

    public void setSobtermInstrWebSearchInd(String sobtermInstrWebSearchInd) {
        this.sobtermInstrWebSearchInd = sobtermInstrWebSearchInd;
    }

    public String getSobtermFacschdWebDispInd() {
        return sobtermFacschdWebDispInd;
    }

    public void setSobtermFacschdWebDispInd(String sobtermFacschdWebDispInd) {
        this.sobtermFacschdWebDispInd = sobtermFacschdWebDispInd;
    }

    public String getSobtermClaslstWebDispInd() {
        return sobtermClaslstWebDispInd;
    }

    public void setSobtermClaslstWebDispInd(String sobtermClaslstWebDispInd) {
        this.sobtermClaslstWebDispInd = sobtermClaslstWebDispInd;
    }

    public String getSobtermOverappWebUpdInd() {
        return sobtermOverappWebUpdInd;
    }

    public void setSobtermOverappWebUpdInd(String sobtermOverappWebUpdInd) {
        this.sobtermOverappWebUpdInd = sobtermOverappWebUpdInd;
    }

    public String getSobtermAddDrpWebUpdInd() {
        return sobtermAddDrpWebUpdInd;
    }

    public void setSobtermAddDrpWebUpdInd(String sobtermAddDrpWebUpdInd) {
        this.sobtermAddDrpWebUpdInd = sobtermAddDrpWebUpdInd;
    }

    public String getSobtermDegreeSeverity() {
        return sobtermDegreeSeverity;
    }

    public void setSobtermDegreeSeverity(String sobtermDegreeSeverity) {
        this.sobtermDegreeSeverity = sobtermDegreeSeverity;
    }

    public String getSobtermProgramSeverity() {
        return sobtermProgramSeverity;
    }

    public void setSobtermProgramSeverity(String sobtermProgramSeverity) {
        this.sobtermProgramSeverity = sobtermProgramSeverity;
    }

    public String getSobtermInprogressUsageInd() {
        return sobtermInprogressUsageInd;
    }

    public void setSobtermInprogressUsageInd(String sobtermInprogressUsageInd) {
        this.sobtermInprogressUsageInd = sobtermInprogressUsageInd;
    }

    public String getSobtermGradeDetailWebInd() {
        return sobtermGradeDetailWebInd;
    }

    public void setSobtermGradeDetailWebInd(String sobtermGradeDetailWebInd) {
        this.sobtermGradeDetailWebInd = sobtermGradeDetailWebInd;
    }

    public String getSobtermMidtermWebInd() {
        return sobtermMidtermWebInd;
    }

    public void setSobtermMidtermWebInd(String sobtermMidtermWebInd) {
        this.sobtermMidtermWebInd = sobtermMidtermWebInd;
    }

    public String getSobtermProfileSendInd() {
        return sobtermProfileSendInd;
    }

    public void setSobtermProfileSendInd(String sobtermProfileSendInd) {
        this.sobtermProfileSendInd = sobtermProfileSendInd;
    }

    public Date getSobtermCutoffDate() {
        return sobtermCutoffDate;
    }

    public void setSobtermCutoffDate(Date sobtermCutoffDate) {
        this.sobtermCutoffDate = sobtermCutoffDate;
    }

    public String getSobtermTivDateSource() {
        return sobtermTivDateSource;
    }

    public void setSobtermTivDateSource(String sobtermTivDateSource) {
        this.sobtermTivDateSource = sobtermTivDateSource;
    }

    public String getSobtermWebCappTermInd() {
        return sobtermWebCappTermInd;
    }

    public void setSobtermWebCappTermInd(String sobtermWebCappTermInd) {
        this.sobtermWebCappTermInd = sobtermWebCappTermInd;
    }

    public String getSobtermWebCappCatlgInd() {
        return sobtermWebCappCatlgInd;
    }

    public void setSobtermWebCappCatlgInd(String sobtermWebCappCatlgInd) {
        this.sobtermWebCappCatlgInd = sobtermWebCappCatlgInd;
    }

    public String getSobtermAttrWebSearchInd() {
        return sobtermAttrWebSearchInd;
    }

    public void setSobtermAttrWebSearchInd(String sobtermAttrWebSearchInd) {
        this.sobtermAttrWebSearchInd = sobtermAttrWebSearchInd;
    }

    public String getSobtermLevlWebSearchInd() {
        return sobtermLevlWebSearchInd;
    }

    public void setSobtermLevlWebSearchInd(String sobtermLevlWebSearchInd) {
        this.sobtermLevlWebSearchInd = sobtermLevlWebSearchInd;
    }

    public String getSobtermInsmWebSearchInd() {
        return sobtermInsmWebSearchInd;
    }

    public void setSobtermInsmWebSearchInd(String sobtermInsmWebSearchInd) {
        this.sobtermInsmWebSearchInd = sobtermInsmWebSearchInd;
    }

    public String getSobtermLsTitleWebsDispInd() {
        return sobtermLsTitleWebsDispInd;
    }

    public void setSobtermLsTitleWebsDispInd(String sobtermLsTitleWebsDispInd) {
        this.sobtermLsTitleWebsDispInd = sobtermLsTitleWebsDispInd;
    }

    public String getSobtermLsDescWebsDispInd() {
        return sobtermLsDescWebsDispInd;
    }

    public void setSobtermLsDescWebsDispInd(String sobtermLsDescWebsDispInd) {
        this.sobtermLsDescWebsDispInd = sobtermLsDescWebsDispInd;
    }

    public String getSobtermDurationWebSrchInd() {
        return sobtermDurationWebSrchInd;
    }

    public void setSobtermDurationWebSrchInd(String sobtermDurationWebSrchInd) {
        this.sobtermDurationWebSrchInd = sobtermDurationWebSrchInd;
    }

    public String getSobtermLevlWebCatlSrchInd() {
        return sobtermLevlWebCatlSrchInd;
    }

    public void setSobtermLevlWebCatlSrchInd(String sobtermLevlWebCatlSrchInd) {
        this.sobtermLevlWebCatlSrchInd = sobtermLevlWebCatlSrchInd;
    }

    public String getSobtermStypWebCatlSrchInd() {
        return sobtermStypWebCatlSrchInd;
    }

    public void setSobtermStypWebCatlSrchInd(String sobtermStypWebCatlSrchInd) {
        this.sobtermStypWebCatlSrchInd = sobtermStypWebCatlSrchInd;
    }

    public String getSobtermCollWebCatlSrchInd() {
        return sobtermCollWebCatlSrchInd;
    }

    public void setSobtermCollWebCatlSrchInd(String sobtermCollWebCatlSrchInd) {
        this.sobtermCollWebCatlSrchInd = sobtermCollWebCatlSrchInd;
    }

    public String getSobtermDivWebCatlSrchInd() {
        return sobtermDivWebCatlSrchInd;
    }

    public void setSobtermDivWebCatlSrchInd(String sobtermDivWebCatlSrchInd) {
        this.sobtermDivWebCatlSrchInd = sobtermDivWebCatlSrchInd;
    }

    public String getSobtermDeptWebCatlSrchInd() {
        return sobtermDeptWebCatlSrchInd;
    }

    public void setSobtermDeptWebCatlSrchInd(String sobtermDeptWebCatlSrchInd) {
        this.sobtermDeptWebCatlSrchInd = sobtermDeptWebCatlSrchInd;
    }

    public String getSobtermProgAttWebcSrchInd() {
        return sobtermProgAttWebcSrchInd;
    }

    public void setSobtermProgAttWebcSrchInd(String sobtermProgAttWebcSrchInd) {
        this.sobtermProgAttWebcSrchInd = sobtermProgAttWebcSrchInd;
    }

    public String getSobtermLcTitleWebcDispInd() {
        return sobtermLcTitleWebcDispInd;
    }

    public void setSobtermLcTitleWebcDispInd(String sobtermLcTitleWebcDispInd) {
        this.sobtermLcTitleWebcDispInd = sobtermLcTitleWebcDispInd;
    }

    public String getSobtermLcDescWebcDispInd() {
        return sobtermLcDescWebcDispInd;
    }

    public void setSobtermLcDescWebcDispInd(String sobtermLcDescWebcDispInd) {
        this.sobtermLcDescWebcDispInd = sobtermLcDescWebcDispInd;
    }

    public String getSobtermDynamicSchedTermInd() {
        return sobtermDynamicSchedTermInd;
    }

    public void setSobtermDynamicSchedTermInd(String sobtermDynamicSchedTermInd) {
        this.sobtermDynamicSchedTermInd = sobtermDynamicSchedTermInd;
    }

    public String getSobtermDataOrigin() {
        return sobtermDataOrigin;
    }

    public void setSobtermDataOrigin(String sobtermDataOrigin) {
        this.sobtermDataOrigin = sobtermDataOrigin;
    }

    public String getSobtermUserId() {
        return sobtermUserId;
    }

    public void setSobtermUserId(String sobtermUserId) {
        this.sobtermUserId = sobtermUserId;
    }

    public String getSobtermAssessSwapInd() {
        return sobtermAssessSwapInd;
    }

    public void setSobtermAssessSwapInd(String sobtermAssessSwapInd) {
        this.sobtermAssessSwapInd = sobtermAssessSwapInd;
    }

    public String getSobtermAssessRevNrfInd() {
        return sobtermAssessRevNrfInd;
    }

    public void setSobtermAssessRevNrfInd(String sobtermAssessRevNrfInd) {
        this.sobtermAssessRevNrfInd = sobtermAssessRevNrfInd;
    }

    public String getSobtermAssessRegGraceInd() {
        return sobtermAssessRegGraceInd;
    }

    public void setSobtermAssessRegGraceInd(String sobtermAssessRegGraceInd) {
        this.sobtermAssessRegGraceInd = sobtermAssessRegGraceInd;
    }

    public String getSobtermMinhSeverity() {
        return sobtermMinhSeverity;
    }

    public void setSobtermMinhSeverity(String sobtermMinhSeverity) {
        this.sobtermMinhSeverity = sobtermMinhSeverity;
    }

    public String getSobtermDeptSeverity() {
        return sobtermDeptSeverity;
    }

    public void setSobtermDeptSeverity(String sobtermDeptSeverity) {
        this.sobtermDeptSeverity = sobtermDeptSeverity;
    }

    public String getSobtermAttsSeverity() {
        return sobtermAttsSeverity;
    }

    public void setSobtermAttsSeverity(String sobtermAttsSeverity) {
        this.sobtermAttsSeverity = sobtermAttsSeverity;
    }

    public String getSobtermChrtSeverity() {
        return sobtermChrtSeverity;
    }

    public void setSobtermChrtSeverity(String sobtermChrtSeverity) {
        this.sobtermChrtSeverity = sobtermChrtSeverity;
    }

    public Stvterm getStvterm() {
        return stvterm;
    }

    public void setStvterm(Stvterm stvterm) {
        this.stvterm = stvterm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobtermTermCode != null ? sobtermTermCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sobterm)) {
            return false;
        }
        Sobterm other = (Sobterm) object;
        if ((this.sobtermTermCode == null && other.sobtermTermCode != null) || (this.sobtermTermCode != null && !this.sobtermTermCode.equals(other.sobtermTermCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Sobterm[ sobtermTermCode=" + sobtermTermCode + " ]";
    }
    
}
