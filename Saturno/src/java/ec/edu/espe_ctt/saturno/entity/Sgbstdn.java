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
@Table(name = "SGBSTDN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sgbstdn.findAll", query = "SELECT s FROM Sgbstdn s"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnPidm", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnPK.sgbstdnPidm = :sgbstdnPidm"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeEff", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnPK.sgbstdnTermCodeEff = :sgbstdnTermCodeEff"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnStstCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnStstCode = :sgbstdnStstCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLevlCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLevlCode = :sgbstdnLevlCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnStypCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnStypCode = :sgbstdnStypCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeMatric", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeMatric = :sgbstdnTermCodeMatric"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeAdmit", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeAdmit = :sgbstdnTermCodeAdmit"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnExpGradDate", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnExpGradDate = :sgbstdnExpGradDate"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCampCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCampCode = :sgbstdnCampCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnFullPartInd", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnFullPartInd = :sgbstdnFullPartInd"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnSessCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnSessCode = :sgbstdnSessCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnResdCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnResdCode = :sgbstdnResdCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCollCode1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCollCode1 = :sgbstdnCollCode1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDegcCode1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDegcCode1 = :sgbstdnDegcCode1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCode1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCode1 = :sgbstdnMajrCode1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeMinr1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeMinr1 = :sgbstdnMajrCodeMinr1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeMinr12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeMinr12 = :sgbstdnMajrCodeMinr12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc1 = :sgbstdnMajrCodeConc1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc12 = :sgbstdnMajrCodeConc12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc13", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc13 = :sgbstdnMajrCodeConc13"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCollCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCollCode2 = :sgbstdnCollCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDegcCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDegcCode2 = :sgbstdnDegcCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCode2 = :sgbstdnMajrCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeMinr2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeMinr2 = :sgbstdnMajrCodeMinr2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeMinr22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeMinr22 = :sgbstdnMajrCodeMinr22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc2 = :sgbstdnMajrCodeConc2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc22 = :sgbstdnMajrCodeConc22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc23", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc23 = :sgbstdnMajrCodeConc23"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnOrsnCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnOrsnCode = :sgbstdnOrsnCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnPracCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnPracCode = :sgbstdnPracCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAdvrPidm", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAdvrPidm = :sgbstdnAdvrPidm"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnGradCreditApprInd", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnGradCreditApprInd = :sgbstdnGradCreditApprInd"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCaplCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCaplCode = :sgbstdnCaplCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLeavCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLeavCode = :sgbstdnLeavCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLeavFromDate", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLeavFromDate = :sgbstdnLeavFromDate"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLeavToDate", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLeavToDate = :sgbstdnLeavToDate"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAstdCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAstdCode = :sgbstdnAstdCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeAstd", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeAstd = :sgbstdnTermCodeAstd"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnRateCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnRateCode = :sgbstdnRateCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnActivityDate", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnActivityDate = :sgbstdnActivityDate"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCode12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCode12 = :sgbstdnMajrCode12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCode22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCode22 = :sgbstdnMajrCode22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnEdlvCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnEdlvCode = :sgbstdnEdlvCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnIncmCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnIncmCode = :sgbstdnIncmCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAdmtCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAdmtCode = :sgbstdnAdmtCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnEmexCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnEmexCode = :sgbstdnEmexCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAprnCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAprnCode = :sgbstdnAprnCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTrcnCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTrcnCode = :sgbstdnTrcnCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnGainCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnGainCode = :sgbstdnGainCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnVoedCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnVoedCode = :sgbstdnVoedCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnBlckCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnBlckCode = :sgbstdnBlckCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeGrad", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeGrad = :sgbstdnTermCodeGrad"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAcyrCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAcyrCode = :sgbstdnAcyrCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDeptCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDeptCode = :sgbstdnDeptCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnSiteCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnSiteCode = :sgbstdnSiteCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDeptCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDeptCode2 = :sgbstdnDeptCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnEgolCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnEgolCode = :sgbstdnEgolCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDegcCodeDual", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDegcCodeDual = :sgbstdnDegcCodeDual"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLevlCodeDual", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLevlCodeDual = :sgbstdnLevlCodeDual"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDeptCodeDual", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDeptCodeDual = :sgbstdnDeptCodeDual"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCollCodeDual", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCollCodeDual = :sgbstdnCollCodeDual"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeDual", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeDual = :sgbstdnMajrCodeDual"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnBsklCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnBsklCode = :sgbstdnBsklCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnPrimRollInd", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnPrimRollInd = :sgbstdnPrimRollInd"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnProgram1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnProgram1 = :sgbstdnProgram1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeCtlg1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeCtlg1 = :sgbstdnTermCodeCtlg1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDeptCode12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDeptCode12 = :sgbstdnDeptCode12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc121", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc121 = :sgbstdnMajrCodeConc121"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc122", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc122 = :sgbstdnMajrCodeConc122"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc123", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc123 = :sgbstdnMajrCodeConc123"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnSecdRollInd", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnSecdRollInd = :sgbstdnSecdRollInd"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeAdmit2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeAdmit2 = :sgbstdnTermCodeAdmit2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnAdmtCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnAdmtCode2 = :sgbstdnAdmtCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnProgram2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnProgram2 = :sgbstdnProgram2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeCtlg2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeCtlg2 = :sgbstdnTermCodeCtlg2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnLevlCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnLevlCode2 = :sgbstdnLevlCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCampCode2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCampCode2 = :sgbstdnCampCode2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDeptCode22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDeptCode22 = :sgbstdnDeptCode22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc221", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc221 = :sgbstdnMajrCodeConc221"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc222", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc222 = :sgbstdnMajrCodeConc222"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnMajrCodeConc223", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnMajrCodeConc223 = :sgbstdnMajrCodeConc223"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCurrRule1", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCurrRule1 = :sgbstdnCurrRule1"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmjrRule11", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmjrRule11 = :sgbstdnCmjrRule11"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule111", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule111 = :sgbstdnCconRule111"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule112", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule112 = :sgbstdnCconRule112"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule113", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule113 = :sgbstdnCconRule113"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmjrRule12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmjrRule12 = :sgbstdnCmjrRule12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule121", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule121 = :sgbstdnCconRule121"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule122", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule122 = :sgbstdnCconRule122"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule123", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule123 = :sgbstdnCconRule123"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmnrRule11", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmnrRule11 = :sgbstdnCmnrRule11"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmnrRule12", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmnrRule12 = :sgbstdnCmnrRule12"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCurrRule2", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCurrRule2 = :sgbstdnCurrRule2"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmjrRule21", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmjrRule21 = :sgbstdnCmjrRule21"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule211", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule211 = :sgbstdnCconRule211"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule212", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule212 = :sgbstdnCconRule212"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule213", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule213 = :sgbstdnCconRule213"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmjrRule22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmjrRule22 = :sgbstdnCmjrRule22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule221", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule221 = :sgbstdnCconRule221"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule222", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule222 = :sgbstdnCconRule222"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCconRule223", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCconRule223 = :sgbstdnCconRule223"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmnrRule21", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmnrRule21 = :sgbstdnCmnrRule21"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCmnrRule22", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCmnrRule22 = :sgbstdnCmnrRule22"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnPrevCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnPrevCode = :sgbstdnPrevCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodePrev", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodePrev = :sgbstdnTermCodePrev"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnCastCode", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnCastCode = :sgbstdnCastCode"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnTermCodeCast", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnTermCodeCast = :sgbstdnTermCodeCast"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnDataOrigin", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnDataOrigin = :sgbstdnDataOrigin"),
    @NamedQuery(name = "Sgbstdn.findBySgbstdnUserId", query = "SELECT s FROM Sgbstdn s WHERE s.sgbstdnUserId = :sgbstdnUserId")})
public class Sgbstdn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgbstdnPK sgbstdnPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SGBSTDN_STST_CODE")
    private String sgbstdnStstCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_LEVL_CODE")
    private String sgbstdnLevlCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SGBSTDN_STYP_CODE")
    private String sgbstdnStypCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_MATRIC")
    private String sgbstdnTermCodeMatric;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_ADMIT")
    private String sgbstdnTermCodeAdmit;
    @Column(name = "SGBSTDN_EXP_GRAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sgbstdnExpGradDate;
    @Size(max = 3)
    @Column(name = "SGBSTDN_CAMP_CODE")
    private String sgbstdnCampCode;
    @Size(max = 1)
    @Column(name = "SGBSTDN_FULL_PART_IND")
    private String sgbstdnFullPartInd;
    @Size(max = 1)
    @Column(name = "SGBSTDN_SESS_CODE")
    private String sgbstdnSessCode;
    @Size(max = 1)
    @Column(name = "SGBSTDN_RESD_CODE")
    private String sgbstdnResdCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_COLL_CODE_1")
    private String sgbstdnCollCode1;
    @Size(max = 6)
    @Column(name = "SGBSTDN_DEGC_CODE_1")
    private String sgbstdnDegcCode1;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_1")
    private String sgbstdnMajrCode1;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_MINR_1")
    private String sgbstdnMajrCodeMinr1;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_MINR_1_2")
    private String sgbstdnMajrCodeMinr12;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_1")
    private String sgbstdnMajrCodeConc1;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_1_2")
    private String sgbstdnMajrCodeConc12;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_1_3")
    private String sgbstdnMajrCodeConc13;
    @Size(max = 2)
    @Column(name = "SGBSTDN_COLL_CODE_2")
    private String sgbstdnCollCode2;
    @Size(max = 6)
    @Column(name = "SGBSTDN_DEGC_CODE_2")
    private String sgbstdnDegcCode2;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_2")
    private String sgbstdnMajrCode2;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_MINR_2")
    private String sgbstdnMajrCodeMinr2;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_MINR_2_2")
    private String sgbstdnMajrCodeMinr22;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_2")
    private String sgbstdnMajrCodeConc2;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_2_2")
    private String sgbstdnMajrCodeConc22;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_2_3")
    private String sgbstdnMajrCodeConc23;
    @Size(max = 1)
    @Column(name = "SGBSTDN_ORSN_CODE")
    private String sgbstdnOrsnCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_PRAC_CODE")
    private String sgbstdnPracCode;
    @Column(name = "SGBSTDN_ADVR_PIDM")
    private Integer sgbstdnAdvrPidm;
    @Size(max = 1)
    @Column(name = "SGBSTDN_GRAD_CREDIT_APPR_IND")
    private String sgbstdnGradCreditApprInd;
    @Size(max = 2)
    @Column(name = "SGBSTDN_CAPL_CODE")
    private String sgbstdnCaplCode;
    @Size(max = 1)
    @Column(name = "SGBSTDN_LEAV_CODE")
    private String sgbstdnLeavCode;
    @Column(name = "SGBSTDN_LEAV_FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sgbstdnLeavFromDate;
    @Column(name = "SGBSTDN_LEAV_TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sgbstdnLeavToDate;
    @Size(max = 2)
    @Column(name = "SGBSTDN_ASTD_CODE")
    private String sgbstdnAstdCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_ASTD")
    private String sgbstdnTermCodeAstd;
    @Size(max = 5)
    @Column(name = "SGBSTDN_RATE_CODE")
    private String sgbstdnRateCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SGBSTDN_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sgbstdnActivityDate;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_1_2")
    private String sgbstdnMajrCode12;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_2_2")
    private String sgbstdnMajrCode22;
    @Size(max = 3)
    @Column(name = "SGBSTDN_EDLV_CODE")
    private String sgbstdnEdlvCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_INCM_CODE")
    private String sgbstdnIncmCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_ADMT_CODE")
    private String sgbstdnAdmtCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_EMEX_CODE")
    private String sgbstdnEmexCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_APRN_CODE")
    private String sgbstdnAprnCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_TRCN_CODE")
    private String sgbstdnTrcnCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_GAIN_CODE")
    private String sgbstdnGainCode;
    @Size(max = 2)
    @Column(name = "SGBSTDN_VOED_CODE")
    private String sgbstdnVoedCode;
    @Size(max = 10)
    @Column(name = "SGBSTDN_BLCK_CODE")
    private String sgbstdnBlckCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_GRAD")
    private String sgbstdnTermCodeGrad;
    @Size(max = 4)
    @Column(name = "SGBSTDN_ACYR_CODE")
    private String sgbstdnAcyrCode;
    @Size(max = 4)
    @Column(name = "SGBSTDN_DEPT_CODE")
    private String sgbstdnDeptCode;
    @Size(max = 3)
    @Column(name = "SGBSTDN_SITE_CODE")
    private String sgbstdnSiteCode;
    @Size(max = 4)
    @Column(name = "SGBSTDN_DEPT_CODE_2")
    private String sgbstdnDeptCode2;
    @Size(max = 2)
    @Column(name = "SGBSTDN_EGOL_CODE")
    private String sgbstdnEgolCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_DEGC_CODE_DUAL")
    private String sgbstdnDegcCodeDual;
    @Size(max = 2)
    @Column(name = "SGBSTDN_LEVL_CODE_DUAL")
    private String sgbstdnLevlCodeDual;
    @Size(max = 4)
    @Column(name = "SGBSTDN_DEPT_CODE_DUAL")
    private String sgbstdnDeptCodeDual;
    @Size(max = 2)
    @Column(name = "SGBSTDN_COLL_CODE_DUAL")
    private String sgbstdnCollCodeDual;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_DUAL")
    private String sgbstdnMajrCodeDual;
    @Size(max = 2)
    @Column(name = "SGBSTDN_BSKL_CODE")
    private String sgbstdnBsklCode;
    @Size(max = 1)
    @Column(name = "SGBSTDN_PRIM_ROLL_IND")
    private String sgbstdnPrimRollInd;
    @Size(max = 12)
    @Column(name = "SGBSTDN_PROGRAM_1")
    private String sgbstdnProgram1;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_CTLG_1")
    private String sgbstdnTermCodeCtlg1;
    @Size(max = 4)
    @Column(name = "SGBSTDN_DEPT_CODE_1_2")
    private String sgbstdnDeptCode12;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_121")
    private String sgbstdnMajrCodeConc121;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_122")
    private String sgbstdnMajrCodeConc122;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_123")
    private String sgbstdnMajrCodeConc123;
    @Size(max = 1)
    @Column(name = "SGBSTDN_SECD_ROLL_IND")
    private String sgbstdnSecdRollInd;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_ADMIT_2")
    private String sgbstdnTermCodeAdmit2;
    @Size(max = 2)
    @Column(name = "SGBSTDN_ADMT_CODE_2")
    private String sgbstdnAdmtCode2;
    @Size(max = 12)
    @Column(name = "SGBSTDN_PROGRAM_2")
    private String sgbstdnProgram2;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_CTLG_2")
    private String sgbstdnTermCodeCtlg2;
    @Size(max = 2)
    @Column(name = "SGBSTDN_LEVL_CODE_2")
    private String sgbstdnLevlCode2;
    @Size(max = 3)
    @Column(name = "SGBSTDN_CAMP_CODE_2")
    private String sgbstdnCampCode2;
    @Size(max = 4)
    @Column(name = "SGBSTDN_DEPT_CODE_2_2")
    private String sgbstdnDeptCode22;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_221")
    private String sgbstdnMajrCodeConc221;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_222")
    private String sgbstdnMajrCodeConc222;
    @Size(max = 4)
    @Column(name = "SGBSTDN_MAJR_CODE_CONC_223")
    private String sgbstdnMajrCodeConc223;
    @Column(name = "SGBSTDN_CURR_RULE_1")
    private Integer sgbstdnCurrRule1;
    @Column(name = "SGBSTDN_CMJR_RULE_1_1")
    private Integer sgbstdnCmjrRule11;
    @Column(name = "SGBSTDN_CCON_RULE_11_1")
    private Integer sgbstdnCconRule111;
    @Column(name = "SGBSTDN_CCON_RULE_11_2")
    private Integer sgbstdnCconRule112;
    @Column(name = "SGBSTDN_CCON_RULE_11_3")
    private Integer sgbstdnCconRule113;
    @Column(name = "SGBSTDN_CMJR_RULE_1_2")
    private Integer sgbstdnCmjrRule12;
    @Column(name = "SGBSTDN_CCON_RULE_12_1")
    private Integer sgbstdnCconRule121;
    @Column(name = "SGBSTDN_CCON_RULE_12_2")
    private Integer sgbstdnCconRule122;
    @Column(name = "SGBSTDN_CCON_RULE_12_3")
    private Integer sgbstdnCconRule123;
    @Column(name = "SGBSTDN_CMNR_RULE_1_1")
    private Integer sgbstdnCmnrRule11;
    @Column(name = "SGBSTDN_CMNR_RULE_1_2")
    private Integer sgbstdnCmnrRule12;
    @Column(name = "SGBSTDN_CURR_RULE_2")
    private Integer sgbstdnCurrRule2;
    @Column(name = "SGBSTDN_CMJR_RULE_2_1")
    private Integer sgbstdnCmjrRule21;
    @Column(name = "SGBSTDN_CCON_RULE_21_1")
    private Integer sgbstdnCconRule211;
    @Column(name = "SGBSTDN_CCON_RULE_21_2")
    private Integer sgbstdnCconRule212;
    @Column(name = "SGBSTDN_CCON_RULE_21_3")
    private Integer sgbstdnCconRule213;
    @Column(name = "SGBSTDN_CMJR_RULE_2_2")
    private Integer sgbstdnCmjrRule22;
    @Column(name = "SGBSTDN_CCON_RULE_22_1")
    private Integer sgbstdnCconRule221;
    @Column(name = "SGBSTDN_CCON_RULE_22_2")
    private Integer sgbstdnCconRule222;
    @Column(name = "SGBSTDN_CCON_RULE_22_3")
    private Integer sgbstdnCconRule223;
    @Column(name = "SGBSTDN_CMNR_RULE_2_1")
    private Integer sgbstdnCmnrRule21;
    @Column(name = "SGBSTDN_CMNR_RULE_2_2")
    private Integer sgbstdnCmnrRule22;
    @Size(max = 2)
    @Column(name = "SGBSTDN_PREV_CODE")
    private String sgbstdnPrevCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_PREV")
    private String sgbstdnTermCodePrev;
    @Size(max = 2)
    @Column(name = "SGBSTDN_CAST_CODE")
    private String sgbstdnCastCode;
    @Size(max = 6)
    @Column(name = "SGBSTDN_TERM_CODE_CAST")
    private String sgbstdnTermCodeCast;
    @Size(max = 30)
    @Column(name = "SGBSTDN_DATA_ORIGIN")
    private String sgbstdnDataOrigin;
    @Size(max = 30)
    @Column(name = "SGBSTDN_USER_ID")
    private String sgbstdnUserId;

    public Sgbstdn() {
    }

    public Sgbstdn(SgbstdnPK sgbstdnPK) {
        this.sgbstdnPK = sgbstdnPK;
    }

    public Sgbstdn(SgbstdnPK sgbstdnPK, String sgbstdnStstCode, String sgbstdnStypCode, Date sgbstdnActivityDate) {
        this.sgbstdnPK = sgbstdnPK;
        this.sgbstdnStstCode = sgbstdnStstCode;
        this.sgbstdnStypCode = sgbstdnStypCode;
        this.sgbstdnActivityDate = sgbstdnActivityDate;
    }

    public Sgbstdn(int sgbstdnPidm, String sgbstdnTermCodeEff) {
        this.sgbstdnPK = new SgbstdnPK(sgbstdnPidm, sgbstdnTermCodeEff);
    }

    public SgbstdnPK getSgbstdnPK() {
        return sgbstdnPK;
    }

    public void setSgbstdnPK(SgbstdnPK sgbstdnPK) {
        this.sgbstdnPK = sgbstdnPK;
    }

    public String getSgbstdnStstCode() {
        return sgbstdnStstCode;
    }

    public void setSgbstdnStstCode(String sgbstdnStstCode) {
        this.sgbstdnStstCode = sgbstdnStstCode;
    }

    public String getSgbstdnLevlCode() {
        return sgbstdnLevlCode;
    }

    public void setSgbstdnLevlCode(String sgbstdnLevlCode) {
        this.sgbstdnLevlCode = sgbstdnLevlCode;
    }

    public String getSgbstdnStypCode() {
        return sgbstdnStypCode;
    }

    public void setSgbstdnStypCode(String sgbstdnStypCode) {
        this.sgbstdnStypCode = sgbstdnStypCode;
    }

    public String getSgbstdnTermCodeMatric() {
        return sgbstdnTermCodeMatric;
    }

    public void setSgbstdnTermCodeMatric(String sgbstdnTermCodeMatric) {
        this.sgbstdnTermCodeMatric = sgbstdnTermCodeMatric;
    }

    public String getSgbstdnTermCodeAdmit() {
        return sgbstdnTermCodeAdmit;
    }

    public void setSgbstdnTermCodeAdmit(String sgbstdnTermCodeAdmit) {
        this.sgbstdnTermCodeAdmit = sgbstdnTermCodeAdmit;
    }

    public Date getSgbstdnExpGradDate() {
        return sgbstdnExpGradDate;
    }

    public void setSgbstdnExpGradDate(Date sgbstdnExpGradDate) {
        this.sgbstdnExpGradDate = sgbstdnExpGradDate;
    }

    public String getSgbstdnCampCode() {
        return sgbstdnCampCode;
    }

    public void setSgbstdnCampCode(String sgbstdnCampCode) {
        this.sgbstdnCampCode = sgbstdnCampCode;
    }

    public String getSgbstdnFullPartInd() {
        return sgbstdnFullPartInd;
    }

    public void setSgbstdnFullPartInd(String sgbstdnFullPartInd) {
        this.sgbstdnFullPartInd = sgbstdnFullPartInd;
    }

    public String getSgbstdnSessCode() {
        return sgbstdnSessCode;
    }

    public void setSgbstdnSessCode(String sgbstdnSessCode) {
        this.sgbstdnSessCode = sgbstdnSessCode;
    }

    public String getSgbstdnResdCode() {
        return sgbstdnResdCode;
    }

    public void setSgbstdnResdCode(String sgbstdnResdCode) {
        this.sgbstdnResdCode = sgbstdnResdCode;
    }

    public String getSgbstdnCollCode1() {
        return sgbstdnCollCode1;
    }

    public void setSgbstdnCollCode1(String sgbstdnCollCode1) {
        this.sgbstdnCollCode1 = sgbstdnCollCode1;
    }

    public String getSgbstdnDegcCode1() {
        return sgbstdnDegcCode1;
    }

    public void setSgbstdnDegcCode1(String sgbstdnDegcCode1) {
        this.sgbstdnDegcCode1 = sgbstdnDegcCode1;
    }

    public String getSgbstdnMajrCode1() {
        return sgbstdnMajrCode1;
    }

    public void setSgbstdnMajrCode1(String sgbstdnMajrCode1) {
        this.sgbstdnMajrCode1 = sgbstdnMajrCode1;
    }

    public String getSgbstdnMajrCodeMinr1() {
        return sgbstdnMajrCodeMinr1;
    }

    public void setSgbstdnMajrCodeMinr1(String sgbstdnMajrCodeMinr1) {
        this.sgbstdnMajrCodeMinr1 = sgbstdnMajrCodeMinr1;
    }

    public String getSgbstdnMajrCodeMinr12() {
        return sgbstdnMajrCodeMinr12;
    }

    public void setSgbstdnMajrCodeMinr12(String sgbstdnMajrCodeMinr12) {
        this.sgbstdnMajrCodeMinr12 = sgbstdnMajrCodeMinr12;
    }

    public String getSgbstdnMajrCodeConc1() {
        return sgbstdnMajrCodeConc1;
    }

    public void setSgbstdnMajrCodeConc1(String sgbstdnMajrCodeConc1) {
        this.sgbstdnMajrCodeConc1 = sgbstdnMajrCodeConc1;
    }

    public String getSgbstdnMajrCodeConc12() {
        return sgbstdnMajrCodeConc12;
    }

    public void setSgbstdnMajrCodeConc12(String sgbstdnMajrCodeConc12) {
        this.sgbstdnMajrCodeConc12 = sgbstdnMajrCodeConc12;
    }

    public String getSgbstdnMajrCodeConc13() {
        return sgbstdnMajrCodeConc13;
    }

    public void setSgbstdnMajrCodeConc13(String sgbstdnMajrCodeConc13) {
        this.sgbstdnMajrCodeConc13 = sgbstdnMajrCodeConc13;
    }

    public String getSgbstdnCollCode2() {
        return sgbstdnCollCode2;
    }

    public void setSgbstdnCollCode2(String sgbstdnCollCode2) {
        this.sgbstdnCollCode2 = sgbstdnCollCode2;
    }

    public String getSgbstdnDegcCode2() {
        return sgbstdnDegcCode2;
    }

    public void setSgbstdnDegcCode2(String sgbstdnDegcCode2) {
        this.sgbstdnDegcCode2 = sgbstdnDegcCode2;
    }

    public String getSgbstdnMajrCode2() {
        return sgbstdnMajrCode2;
    }

    public void setSgbstdnMajrCode2(String sgbstdnMajrCode2) {
        this.sgbstdnMajrCode2 = sgbstdnMajrCode2;
    }

    public String getSgbstdnMajrCodeMinr2() {
        return sgbstdnMajrCodeMinr2;
    }

    public void setSgbstdnMajrCodeMinr2(String sgbstdnMajrCodeMinr2) {
        this.sgbstdnMajrCodeMinr2 = sgbstdnMajrCodeMinr2;
    }

    public String getSgbstdnMajrCodeMinr22() {
        return sgbstdnMajrCodeMinr22;
    }

    public void setSgbstdnMajrCodeMinr22(String sgbstdnMajrCodeMinr22) {
        this.sgbstdnMajrCodeMinr22 = sgbstdnMajrCodeMinr22;
    }

    public String getSgbstdnMajrCodeConc2() {
        return sgbstdnMajrCodeConc2;
    }

    public void setSgbstdnMajrCodeConc2(String sgbstdnMajrCodeConc2) {
        this.sgbstdnMajrCodeConc2 = sgbstdnMajrCodeConc2;
    }

    public String getSgbstdnMajrCodeConc22() {
        return sgbstdnMajrCodeConc22;
    }

    public void setSgbstdnMajrCodeConc22(String sgbstdnMajrCodeConc22) {
        this.sgbstdnMajrCodeConc22 = sgbstdnMajrCodeConc22;
    }

    public String getSgbstdnMajrCodeConc23() {
        return sgbstdnMajrCodeConc23;
    }

    public void setSgbstdnMajrCodeConc23(String sgbstdnMajrCodeConc23) {
        this.sgbstdnMajrCodeConc23 = sgbstdnMajrCodeConc23;
    }

    public String getSgbstdnOrsnCode() {
        return sgbstdnOrsnCode;
    }

    public void setSgbstdnOrsnCode(String sgbstdnOrsnCode) {
        this.sgbstdnOrsnCode = sgbstdnOrsnCode;
    }

    public String getSgbstdnPracCode() {
        return sgbstdnPracCode;
    }

    public void setSgbstdnPracCode(String sgbstdnPracCode) {
        this.sgbstdnPracCode = sgbstdnPracCode;
    }

    public Integer getSgbstdnAdvrPidm() {
        return sgbstdnAdvrPidm;
    }

    public void setSgbstdnAdvrPidm(Integer sgbstdnAdvrPidm) {
        this.sgbstdnAdvrPidm = sgbstdnAdvrPidm;
    }

    public String getSgbstdnGradCreditApprInd() {
        return sgbstdnGradCreditApprInd;
    }

    public void setSgbstdnGradCreditApprInd(String sgbstdnGradCreditApprInd) {
        this.sgbstdnGradCreditApprInd = sgbstdnGradCreditApprInd;
    }

    public String getSgbstdnCaplCode() {
        return sgbstdnCaplCode;
    }

    public void setSgbstdnCaplCode(String sgbstdnCaplCode) {
        this.sgbstdnCaplCode = sgbstdnCaplCode;
    }

    public String getSgbstdnLeavCode() {
        return sgbstdnLeavCode;
    }

    public void setSgbstdnLeavCode(String sgbstdnLeavCode) {
        this.sgbstdnLeavCode = sgbstdnLeavCode;
    }

    public Date getSgbstdnLeavFromDate() {
        return sgbstdnLeavFromDate;
    }

    public void setSgbstdnLeavFromDate(Date sgbstdnLeavFromDate) {
        this.sgbstdnLeavFromDate = sgbstdnLeavFromDate;
    }

    public Date getSgbstdnLeavToDate() {
        return sgbstdnLeavToDate;
    }

    public void setSgbstdnLeavToDate(Date sgbstdnLeavToDate) {
        this.sgbstdnLeavToDate = sgbstdnLeavToDate;
    }

    public String getSgbstdnAstdCode() {
        return sgbstdnAstdCode;
    }

    public void setSgbstdnAstdCode(String sgbstdnAstdCode) {
        this.sgbstdnAstdCode = sgbstdnAstdCode;
    }

    public String getSgbstdnTermCodeAstd() {
        return sgbstdnTermCodeAstd;
    }

    public void setSgbstdnTermCodeAstd(String sgbstdnTermCodeAstd) {
        this.sgbstdnTermCodeAstd = sgbstdnTermCodeAstd;
    }

    public String getSgbstdnRateCode() {
        return sgbstdnRateCode;
    }

    public void setSgbstdnRateCode(String sgbstdnRateCode) {
        this.sgbstdnRateCode = sgbstdnRateCode;
    }

    public Date getSgbstdnActivityDate() {
        return sgbstdnActivityDate;
    }

    public void setSgbstdnActivityDate(Date sgbstdnActivityDate) {
        this.sgbstdnActivityDate = sgbstdnActivityDate;
    }

    public String getSgbstdnMajrCode12() {
        return sgbstdnMajrCode12;
    }

    public void setSgbstdnMajrCode12(String sgbstdnMajrCode12) {
        this.sgbstdnMajrCode12 = sgbstdnMajrCode12;
    }

    public String getSgbstdnMajrCode22() {
        return sgbstdnMajrCode22;
    }

    public void setSgbstdnMajrCode22(String sgbstdnMajrCode22) {
        this.sgbstdnMajrCode22 = sgbstdnMajrCode22;
    }

    public String getSgbstdnEdlvCode() {
        return sgbstdnEdlvCode;
    }

    public void setSgbstdnEdlvCode(String sgbstdnEdlvCode) {
        this.sgbstdnEdlvCode = sgbstdnEdlvCode;
    }

    public String getSgbstdnIncmCode() {
        return sgbstdnIncmCode;
    }

    public void setSgbstdnIncmCode(String sgbstdnIncmCode) {
        this.sgbstdnIncmCode = sgbstdnIncmCode;
    }

    public String getSgbstdnAdmtCode() {
        return sgbstdnAdmtCode;
    }

    public void setSgbstdnAdmtCode(String sgbstdnAdmtCode) {
        this.sgbstdnAdmtCode = sgbstdnAdmtCode;
    }

    public String getSgbstdnEmexCode() {
        return sgbstdnEmexCode;
    }

    public void setSgbstdnEmexCode(String sgbstdnEmexCode) {
        this.sgbstdnEmexCode = sgbstdnEmexCode;
    }

    public String getSgbstdnAprnCode() {
        return sgbstdnAprnCode;
    }

    public void setSgbstdnAprnCode(String sgbstdnAprnCode) {
        this.sgbstdnAprnCode = sgbstdnAprnCode;
    }

    public String getSgbstdnTrcnCode() {
        return sgbstdnTrcnCode;
    }

    public void setSgbstdnTrcnCode(String sgbstdnTrcnCode) {
        this.sgbstdnTrcnCode = sgbstdnTrcnCode;
    }

    public String getSgbstdnGainCode() {
        return sgbstdnGainCode;
    }

    public void setSgbstdnGainCode(String sgbstdnGainCode) {
        this.sgbstdnGainCode = sgbstdnGainCode;
    }

    public String getSgbstdnVoedCode() {
        return sgbstdnVoedCode;
    }

    public void setSgbstdnVoedCode(String sgbstdnVoedCode) {
        this.sgbstdnVoedCode = sgbstdnVoedCode;
    }

    public String getSgbstdnBlckCode() {
        return sgbstdnBlckCode;
    }

    public void setSgbstdnBlckCode(String sgbstdnBlckCode) {
        this.sgbstdnBlckCode = sgbstdnBlckCode;
    }

    public String getSgbstdnTermCodeGrad() {
        return sgbstdnTermCodeGrad;
    }

    public void setSgbstdnTermCodeGrad(String sgbstdnTermCodeGrad) {
        this.sgbstdnTermCodeGrad = sgbstdnTermCodeGrad;
    }

    public String getSgbstdnAcyrCode() {
        return sgbstdnAcyrCode;
    }

    public void setSgbstdnAcyrCode(String sgbstdnAcyrCode) {
        this.sgbstdnAcyrCode = sgbstdnAcyrCode;
    }

    public String getSgbstdnDeptCode() {
        return sgbstdnDeptCode;
    }

    public void setSgbstdnDeptCode(String sgbstdnDeptCode) {
        this.sgbstdnDeptCode = sgbstdnDeptCode;
    }

    public String getSgbstdnSiteCode() {
        return sgbstdnSiteCode;
    }

    public void setSgbstdnSiteCode(String sgbstdnSiteCode) {
        this.sgbstdnSiteCode = sgbstdnSiteCode;
    }

    public String getSgbstdnDeptCode2() {
        return sgbstdnDeptCode2;
    }

    public void setSgbstdnDeptCode2(String sgbstdnDeptCode2) {
        this.sgbstdnDeptCode2 = sgbstdnDeptCode2;
    }

    public String getSgbstdnEgolCode() {
        return sgbstdnEgolCode;
    }

    public void setSgbstdnEgolCode(String sgbstdnEgolCode) {
        this.sgbstdnEgolCode = sgbstdnEgolCode;
    }

    public String getSgbstdnDegcCodeDual() {
        return sgbstdnDegcCodeDual;
    }

    public void setSgbstdnDegcCodeDual(String sgbstdnDegcCodeDual) {
        this.sgbstdnDegcCodeDual = sgbstdnDegcCodeDual;
    }

    public String getSgbstdnLevlCodeDual() {
        return sgbstdnLevlCodeDual;
    }

    public void setSgbstdnLevlCodeDual(String sgbstdnLevlCodeDual) {
        this.sgbstdnLevlCodeDual = sgbstdnLevlCodeDual;
    }

    public String getSgbstdnDeptCodeDual() {
        return sgbstdnDeptCodeDual;
    }

    public void setSgbstdnDeptCodeDual(String sgbstdnDeptCodeDual) {
        this.sgbstdnDeptCodeDual = sgbstdnDeptCodeDual;
    }

    public String getSgbstdnCollCodeDual() {
        return sgbstdnCollCodeDual;
    }

    public void setSgbstdnCollCodeDual(String sgbstdnCollCodeDual) {
        this.sgbstdnCollCodeDual = sgbstdnCollCodeDual;
    }

    public String getSgbstdnMajrCodeDual() {
        return sgbstdnMajrCodeDual;
    }

    public void setSgbstdnMajrCodeDual(String sgbstdnMajrCodeDual) {
        this.sgbstdnMajrCodeDual = sgbstdnMajrCodeDual;
    }

    public String getSgbstdnBsklCode() {
        return sgbstdnBsklCode;
    }

    public void setSgbstdnBsklCode(String sgbstdnBsklCode) {
        this.sgbstdnBsklCode = sgbstdnBsklCode;
    }

    public String getSgbstdnPrimRollInd() {
        return sgbstdnPrimRollInd;
    }

    public void setSgbstdnPrimRollInd(String sgbstdnPrimRollInd) {
        this.sgbstdnPrimRollInd = sgbstdnPrimRollInd;
    }

    public String getSgbstdnProgram1() {
        return sgbstdnProgram1;
    }

    public void setSgbstdnProgram1(String sgbstdnProgram1) {
        this.sgbstdnProgram1 = sgbstdnProgram1;
    }

    public String getSgbstdnTermCodeCtlg1() {
        return sgbstdnTermCodeCtlg1;
    }

    public void setSgbstdnTermCodeCtlg1(String sgbstdnTermCodeCtlg1) {
        this.sgbstdnTermCodeCtlg1 = sgbstdnTermCodeCtlg1;
    }

    public String getSgbstdnDeptCode12() {
        return sgbstdnDeptCode12;
    }

    public void setSgbstdnDeptCode12(String sgbstdnDeptCode12) {
        this.sgbstdnDeptCode12 = sgbstdnDeptCode12;
    }

    public String getSgbstdnMajrCodeConc121() {
        return sgbstdnMajrCodeConc121;
    }

    public void setSgbstdnMajrCodeConc121(String sgbstdnMajrCodeConc121) {
        this.sgbstdnMajrCodeConc121 = sgbstdnMajrCodeConc121;
    }

    public String getSgbstdnMajrCodeConc122() {
        return sgbstdnMajrCodeConc122;
    }

    public void setSgbstdnMajrCodeConc122(String sgbstdnMajrCodeConc122) {
        this.sgbstdnMajrCodeConc122 = sgbstdnMajrCodeConc122;
    }

    public String getSgbstdnMajrCodeConc123() {
        return sgbstdnMajrCodeConc123;
    }

    public void setSgbstdnMajrCodeConc123(String sgbstdnMajrCodeConc123) {
        this.sgbstdnMajrCodeConc123 = sgbstdnMajrCodeConc123;
    }

    public String getSgbstdnSecdRollInd() {
        return sgbstdnSecdRollInd;
    }

    public void setSgbstdnSecdRollInd(String sgbstdnSecdRollInd) {
        this.sgbstdnSecdRollInd = sgbstdnSecdRollInd;
    }

    public String getSgbstdnTermCodeAdmit2() {
        return sgbstdnTermCodeAdmit2;
    }

    public void setSgbstdnTermCodeAdmit2(String sgbstdnTermCodeAdmit2) {
        this.sgbstdnTermCodeAdmit2 = sgbstdnTermCodeAdmit2;
    }

    public String getSgbstdnAdmtCode2() {
        return sgbstdnAdmtCode2;
    }

    public void setSgbstdnAdmtCode2(String sgbstdnAdmtCode2) {
        this.sgbstdnAdmtCode2 = sgbstdnAdmtCode2;
    }

    public String getSgbstdnProgram2() {
        return sgbstdnProgram2;
    }

    public void setSgbstdnProgram2(String sgbstdnProgram2) {
        this.sgbstdnProgram2 = sgbstdnProgram2;
    }

    public String getSgbstdnTermCodeCtlg2() {
        return sgbstdnTermCodeCtlg2;
    }

    public void setSgbstdnTermCodeCtlg2(String sgbstdnTermCodeCtlg2) {
        this.sgbstdnTermCodeCtlg2 = sgbstdnTermCodeCtlg2;
    }

    public String getSgbstdnLevlCode2() {
        return sgbstdnLevlCode2;
    }

    public void setSgbstdnLevlCode2(String sgbstdnLevlCode2) {
        this.sgbstdnLevlCode2 = sgbstdnLevlCode2;
    }

    public String getSgbstdnCampCode2() {
        return sgbstdnCampCode2;
    }

    public void setSgbstdnCampCode2(String sgbstdnCampCode2) {
        this.sgbstdnCampCode2 = sgbstdnCampCode2;
    }

    public String getSgbstdnDeptCode22() {
        return sgbstdnDeptCode22;
    }

    public void setSgbstdnDeptCode22(String sgbstdnDeptCode22) {
        this.sgbstdnDeptCode22 = sgbstdnDeptCode22;
    }

    public String getSgbstdnMajrCodeConc221() {
        return sgbstdnMajrCodeConc221;
    }

    public void setSgbstdnMajrCodeConc221(String sgbstdnMajrCodeConc221) {
        this.sgbstdnMajrCodeConc221 = sgbstdnMajrCodeConc221;
    }

    public String getSgbstdnMajrCodeConc222() {
        return sgbstdnMajrCodeConc222;
    }

    public void setSgbstdnMajrCodeConc222(String sgbstdnMajrCodeConc222) {
        this.sgbstdnMajrCodeConc222 = sgbstdnMajrCodeConc222;
    }

    public String getSgbstdnMajrCodeConc223() {
        return sgbstdnMajrCodeConc223;
    }

    public void setSgbstdnMajrCodeConc223(String sgbstdnMajrCodeConc223) {
        this.sgbstdnMajrCodeConc223 = sgbstdnMajrCodeConc223;
    }

    public Integer getSgbstdnCurrRule1() {
        return sgbstdnCurrRule1;
    }

    public void setSgbstdnCurrRule1(Integer sgbstdnCurrRule1) {
        this.sgbstdnCurrRule1 = sgbstdnCurrRule1;
    }

    public Integer getSgbstdnCmjrRule11() {
        return sgbstdnCmjrRule11;
    }

    public void setSgbstdnCmjrRule11(Integer sgbstdnCmjrRule11) {
        this.sgbstdnCmjrRule11 = sgbstdnCmjrRule11;
    }

    public Integer getSgbstdnCconRule111() {
        return sgbstdnCconRule111;
    }

    public void setSgbstdnCconRule111(Integer sgbstdnCconRule111) {
        this.sgbstdnCconRule111 = sgbstdnCconRule111;
    }

    public Integer getSgbstdnCconRule112() {
        return sgbstdnCconRule112;
    }

    public void setSgbstdnCconRule112(Integer sgbstdnCconRule112) {
        this.sgbstdnCconRule112 = sgbstdnCconRule112;
    }

    public Integer getSgbstdnCconRule113() {
        return sgbstdnCconRule113;
    }

    public void setSgbstdnCconRule113(Integer sgbstdnCconRule113) {
        this.sgbstdnCconRule113 = sgbstdnCconRule113;
    }

    public Integer getSgbstdnCmjrRule12() {
        return sgbstdnCmjrRule12;
    }

    public void setSgbstdnCmjrRule12(Integer sgbstdnCmjrRule12) {
        this.sgbstdnCmjrRule12 = sgbstdnCmjrRule12;
    }

    public Integer getSgbstdnCconRule121() {
        return sgbstdnCconRule121;
    }

    public void setSgbstdnCconRule121(Integer sgbstdnCconRule121) {
        this.sgbstdnCconRule121 = sgbstdnCconRule121;
    }

    public Integer getSgbstdnCconRule122() {
        return sgbstdnCconRule122;
    }

    public void setSgbstdnCconRule122(Integer sgbstdnCconRule122) {
        this.sgbstdnCconRule122 = sgbstdnCconRule122;
    }

    public Integer getSgbstdnCconRule123() {
        return sgbstdnCconRule123;
    }

    public void setSgbstdnCconRule123(Integer sgbstdnCconRule123) {
        this.sgbstdnCconRule123 = sgbstdnCconRule123;
    }

    public Integer getSgbstdnCmnrRule11() {
        return sgbstdnCmnrRule11;
    }

    public void setSgbstdnCmnrRule11(Integer sgbstdnCmnrRule11) {
        this.sgbstdnCmnrRule11 = sgbstdnCmnrRule11;
    }

    public Integer getSgbstdnCmnrRule12() {
        return sgbstdnCmnrRule12;
    }

    public void setSgbstdnCmnrRule12(Integer sgbstdnCmnrRule12) {
        this.sgbstdnCmnrRule12 = sgbstdnCmnrRule12;
    }

    public Integer getSgbstdnCurrRule2() {
        return sgbstdnCurrRule2;
    }

    public void setSgbstdnCurrRule2(Integer sgbstdnCurrRule2) {
        this.sgbstdnCurrRule2 = sgbstdnCurrRule2;
    }

    public Integer getSgbstdnCmjrRule21() {
        return sgbstdnCmjrRule21;
    }

    public void setSgbstdnCmjrRule21(Integer sgbstdnCmjrRule21) {
        this.sgbstdnCmjrRule21 = sgbstdnCmjrRule21;
    }

    public Integer getSgbstdnCconRule211() {
        return sgbstdnCconRule211;
    }

    public void setSgbstdnCconRule211(Integer sgbstdnCconRule211) {
        this.sgbstdnCconRule211 = sgbstdnCconRule211;
    }

    public Integer getSgbstdnCconRule212() {
        return sgbstdnCconRule212;
    }

    public void setSgbstdnCconRule212(Integer sgbstdnCconRule212) {
        this.sgbstdnCconRule212 = sgbstdnCconRule212;
    }

    public Integer getSgbstdnCconRule213() {
        return sgbstdnCconRule213;
    }

    public void setSgbstdnCconRule213(Integer sgbstdnCconRule213) {
        this.sgbstdnCconRule213 = sgbstdnCconRule213;
    }

    public Integer getSgbstdnCmjrRule22() {
        return sgbstdnCmjrRule22;
    }

    public void setSgbstdnCmjrRule22(Integer sgbstdnCmjrRule22) {
        this.sgbstdnCmjrRule22 = sgbstdnCmjrRule22;
    }

    public Integer getSgbstdnCconRule221() {
        return sgbstdnCconRule221;
    }

    public void setSgbstdnCconRule221(Integer sgbstdnCconRule221) {
        this.sgbstdnCconRule221 = sgbstdnCconRule221;
    }

    public Integer getSgbstdnCconRule222() {
        return sgbstdnCconRule222;
    }

    public void setSgbstdnCconRule222(Integer sgbstdnCconRule222) {
        this.sgbstdnCconRule222 = sgbstdnCconRule222;
    }

    public Integer getSgbstdnCconRule223() {
        return sgbstdnCconRule223;
    }

    public void setSgbstdnCconRule223(Integer sgbstdnCconRule223) {
        this.sgbstdnCconRule223 = sgbstdnCconRule223;
    }

    public Integer getSgbstdnCmnrRule21() {
        return sgbstdnCmnrRule21;
    }

    public void setSgbstdnCmnrRule21(Integer sgbstdnCmnrRule21) {
        this.sgbstdnCmnrRule21 = sgbstdnCmnrRule21;
    }

    public Integer getSgbstdnCmnrRule22() {
        return sgbstdnCmnrRule22;
    }

    public void setSgbstdnCmnrRule22(Integer sgbstdnCmnrRule22) {
        this.sgbstdnCmnrRule22 = sgbstdnCmnrRule22;
    }

    public String getSgbstdnPrevCode() {
        return sgbstdnPrevCode;
    }

    public void setSgbstdnPrevCode(String sgbstdnPrevCode) {
        this.sgbstdnPrevCode = sgbstdnPrevCode;
    }

    public String getSgbstdnTermCodePrev() {
        return sgbstdnTermCodePrev;
    }

    public void setSgbstdnTermCodePrev(String sgbstdnTermCodePrev) {
        this.sgbstdnTermCodePrev = sgbstdnTermCodePrev;
    }

    public String getSgbstdnCastCode() {
        return sgbstdnCastCode;
    }

    public void setSgbstdnCastCode(String sgbstdnCastCode) {
        this.sgbstdnCastCode = sgbstdnCastCode;
    }

    public String getSgbstdnTermCodeCast() {
        return sgbstdnTermCodeCast;
    }

    public void setSgbstdnTermCodeCast(String sgbstdnTermCodeCast) {
        this.sgbstdnTermCodeCast = sgbstdnTermCodeCast;
    }

    public String getSgbstdnDataOrigin() {
        return sgbstdnDataOrigin;
    }

    public void setSgbstdnDataOrigin(String sgbstdnDataOrigin) {
        this.sgbstdnDataOrigin = sgbstdnDataOrigin;
    }

    public String getSgbstdnUserId() {
        return sgbstdnUserId;
    }

    public void setSgbstdnUserId(String sgbstdnUserId) {
        this.sgbstdnUserId = sgbstdnUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgbstdnPK != null ? sgbstdnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sgbstdn)) {
            return false;
        }
        Sgbstdn other = (Sgbstdn) object;
        if ((this.sgbstdnPK == null && other.sgbstdnPK != null) || (this.sgbstdnPK != null && !this.sgbstdnPK.equals(other.sgbstdnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Sgbstdn[ sgbstdnPK=" + sgbstdnPK + " ]";
    }
    
}
