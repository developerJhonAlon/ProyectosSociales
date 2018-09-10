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
import javax.persistence.Lob;
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
@Table(name = "SPBPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spbpers.findAll", query = "SELECT s FROM Spbpers s"),
    @NamedQuery(name = "Spbpers.findBySpbpersPidm", query = "SELECT s FROM Spbpers s WHERE s.spbpersPidm = :spbpersPidm"),
    @NamedQuery(name = "Spbpers.findBySpbpersSsn", query = "SELECT s FROM Spbpers s WHERE s.spbpersSsn = :spbpersSsn"),
    @NamedQuery(name = "Spbpers.findBySpbpersBirthDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersBirthDate = :spbpersBirthDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersLgcyCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersLgcyCode = :spbpersLgcyCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersEthnCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersEthnCode = :spbpersEthnCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersMrtlCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersMrtlCode = :spbpersMrtlCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersRelgCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersRelgCode = :spbpersRelgCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersSex", query = "SELECT s FROM Spbpers s WHERE s.spbpersSex = :spbpersSex"),
    @NamedQuery(name = "Spbpers.findBySpbpersConfidInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersConfidInd = :spbpersConfidInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersDeadInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersDeadInd = :spbpersDeadInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersVetcFileNumber", query = "SELECT s FROM Spbpers s WHERE s.spbpersVetcFileNumber = :spbpersVetcFileNumber"),
    @NamedQuery(name = "Spbpers.findBySpbpersLegalName", query = "SELECT s FROM Spbpers s WHERE s.spbpersLegalName = :spbpersLegalName"),
    @NamedQuery(name = "Spbpers.findBySpbpersPrefFirstName", query = "SELECT s FROM Spbpers s WHERE s.spbpersPrefFirstName = :spbpersPrefFirstName"),
    @NamedQuery(name = "Spbpers.findBySpbpersNamePrefix", query = "SELECT s FROM Spbpers s WHERE s.spbpersNamePrefix = :spbpersNamePrefix"),
    @NamedQuery(name = "Spbpers.findBySpbpersNameSuffix", query = "SELECT s FROM Spbpers s WHERE s.spbpersNameSuffix = :spbpersNameSuffix"),
    @NamedQuery(name = "Spbpers.findBySpbpersActivityDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersActivityDate = :spbpersActivityDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersVeraInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersVeraInd = :spbpersVeraInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersCitzInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersCitzInd = :spbpersCitzInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersDeadDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersDeadDate = :spbpersDeadDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersCitzCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersCitzCode = :spbpersCitzCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersHairCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersHairCode = :spbpersHairCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersEyesCode", query = "SELECT s FROM Spbpers s WHERE s.spbpersEyesCode = :spbpersEyesCode"),
    @NamedQuery(name = "Spbpers.findBySpbpersCityBirth", query = "SELECT s FROM Spbpers s WHERE s.spbpersCityBirth = :spbpersCityBirth"),
    @NamedQuery(name = "Spbpers.findBySpbpersStatCodeBirth", query = "SELECT s FROM Spbpers s WHERE s.spbpersStatCodeBirth = :spbpersStatCodeBirth"),
    @NamedQuery(name = "Spbpers.findBySpbpersDriverLicense", query = "SELECT s FROM Spbpers s WHERE s.spbpersDriverLicense = :spbpersDriverLicense"),
    @NamedQuery(name = "Spbpers.findBySpbpersStatCodeDriver", query = "SELECT s FROM Spbpers s WHERE s.spbpersStatCodeDriver = :spbpersStatCodeDriver"),
    @NamedQuery(name = "Spbpers.findBySpbpersNatnCodeDriver", query = "SELECT s FROM Spbpers s WHERE s.spbpersNatnCodeDriver = :spbpersNatnCodeDriver"),
    @NamedQuery(name = "Spbpers.findBySpbpersUomsCodeHeight", query = "SELECT s FROM Spbpers s WHERE s.spbpersUomsCodeHeight = :spbpersUomsCodeHeight"),
    @NamedQuery(name = "Spbpers.findBySpbpersHeight", query = "SELECT s FROM Spbpers s WHERE s.spbpersHeight = :spbpersHeight"),
    @NamedQuery(name = "Spbpers.findBySpbpersUomsCodeWeight", query = "SELECT s FROM Spbpers s WHERE s.spbpersUomsCodeWeight = :spbpersUomsCodeWeight"),
    @NamedQuery(name = "Spbpers.findBySpbpersWeight", query = "SELECT s FROM Spbpers s WHERE s.spbpersWeight = :spbpersWeight"),
    @NamedQuery(name = "Spbpers.findBySpbpersSdvetInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersSdvetInd = :spbpersSdvetInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersLicenseIssuedDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersLicenseIssuedDate = :spbpersLicenseIssuedDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersLicenseExpiresDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersLicenseExpiresDate = :spbpersLicenseExpiresDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersIncarInd", query = "SELECT s FROM Spbpers s WHERE s.spbpersIncarInd = :spbpersIncarInd"),
    @NamedQuery(name = "Spbpers.findBySpbpersItin", query = "SELECT s FROM Spbpers s WHERE s.spbpersItin = :spbpersItin"),
    @NamedQuery(name = "Spbpers.findBySpbpersActiveDutySeprDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersActiveDutySeprDate = :spbpersActiveDutySeprDate"),
    @NamedQuery(name = "Spbpers.findBySpbpersDataOrigin", query = "SELECT s FROM Spbpers s WHERE s.spbpersDataOrigin = :spbpersDataOrigin"),
    @NamedQuery(name = "Spbpers.findBySpbpersUserId", query = "SELECT s FROM Spbpers s WHERE s.spbpersUserId = :spbpersUserId"),
    @NamedQuery(name = "Spbpers.findBySpbpersEthnCde", query = "SELECT s FROM Spbpers s WHERE s.spbpersEthnCde = :spbpersEthnCde"),
    @NamedQuery(name = "Spbpers.findBySpbpersConfirmedReCde", query = "SELECT s FROM Spbpers s WHERE s.spbpersConfirmedReCde = :spbpersConfirmedReCde"),
    @NamedQuery(name = "Spbpers.findBySpbpersConfirmedReDate", query = "SELECT s FROM Spbpers s WHERE s.spbpersConfirmedReDate = :spbpersConfirmedReDate")})
public class Spbpers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPBPERS_PIDM")
    private Integer spbpersPidm;
    @Size(max = 15)
    @Column(name = "SPBPERS_SSN")
    private String spbpersSsn;
    @Column(name = "SPBPERS_BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersBirthDate;
    @Size(max = 1)
    @Column(name = "SPBPERS_LGCY_CODE")
    private String spbpersLgcyCode;
    @Size(max = 2)
    @Column(name = "SPBPERS_ETHN_CODE")
    private String spbpersEthnCode;
    @Size(max = 1)
    @Column(name = "SPBPERS_MRTL_CODE")
    private String spbpersMrtlCode;
    @Size(max = 2)
    @Column(name = "SPBPERS_RELG_CODE")
    private String spbpersRelgCode;
    @Size(max = 1)
    @Column(name = "SPBPERS_SEX")
    private String spbpersSex;
    @Size(max = 1)
    @Column(name = "SPBPERS_CONFID_IND")
    private String spbpersConfidInd;
    @Size(max = 1)
    @Column(name = "SPBPERS_DEAD_IND")
    private String spbpersDeadInd;
    @Size(max = 10)
    @Column(name = "SPBPERS_VETC_FILE_NUMBER")
    private String spbpersVetcFileNumber;
    @Size(max = 500)
    @Column(name = "SPBPERS_LEGAL_NAME")
    private String spbpersLegalName;
    @Size(max = 60)
    @Column(name = "SPBPERS_PREF_FIRST_NAME")
    private String spbpersPrefFirstName;
    @Size(max = 20)
    @Column(name = "SPBPERS_NAME_PREFIX")
    private String spbpersNamePrefix;
    @Size(max = 20)
    @Column(name = "SPBPERS_NAME_SUFFIX")
    private String spbpersNameSuffix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPBPERS_ACTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersActivityDate;
    @Size(max = 1)
    @Column(name = "SPBPERS_VERA_IND")
    private String spbpersVeraInd;
    @Size(max = 1)
    @Column(name = "SPBPERS_CITZ_IND")
    private String spbpersCitzInd;
    @Column(name = "SPBPERS_DEAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersDeadDate;
    @Lob
    @Column(name = "SPBPERS_PIN")
    private byte[] spbpersPin;
    @Size(max = 2)
    @Column(name = "SPBPERS_CITZ_CODE")
    private String spbpersCitzCode;
    @Size(max = 2)
    @Column(name = "SPBPERS_HAIR_CODE")
    private String spbpersHairCode;
    @Size(max = 2)
    @Column(name = "SPBPERS_EYES_CODE")
    private String spbpersEyesCode;
    @Size(max = 50)
    @Column(name = "SPBPERS_CITY_BIRTH")
    private String spbpersCityBirth;
    @Size(max = 3)
    @Column(name = "SPBPERS_STAT_CODE_BIRTH")
    private String spbpersStatCodeBirth;
    @Size(max = 20)
    @Column(name = "SPBPERS_DRIVER_LICENSE")
    private String spbpersDriverLicense;
    @Size(max = 3)
    @Column(name = "SPBPERS_STAT_CODE_DRIVER")
    private String spbpersStatCodeDriver;
    @Size(max = 5)
    @Column(name = "SPBPERS_NATN_CODE_DRIVER")
    private String spbpersNatnCodeDriver;
    @Size(max = 4)
    @Column(name = "SPBPERS_UOMS_CODE_HEIGHT")
    private String spbpersUomsCodeHeight;
    @Column(name = "SPBPERS_HEIGHT")
    private Short spbpersHeight;
    @Size(max = 4)
    @Column(name = "SPBPERS_UOMS_CODE_WEIGHT")
    private String spbpersUomsCodeWeight;
    @Column(name = "SPBPERS_WEIGHT")
    private Short spbpersWeight;
    @Size(max = 1)
    @Column(name = "SPBPERS_SDVET_IND")
    private String spbpersSdvetInd;
    @Column(name = "SPBPERS_LICENSE_ISSUED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersLicenseIssuedDate;
    @Column(name = "SPBPERS_LICENSE_EXPIRES_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersLicenseExpiresDate;
    @Size(max = 1)
    @Column(name = "SPBPERS_INCAR_IND")
    private String spbpersIncarInd;
    @Lob
    @Column(name = "SPBPERS_WEBID")
    private byte[] spbpersWebid;
    @Lob
    @Column(name = "SPBPERS_WEB_LAST_ACCESS")
    private byte[] spbpersWebLastAccess;
    @Lob
    @Column(name = "SPBPERS_PIN_DISABLED_IND")
    private byte[] spbpersPinDisabledInd;
    @Column(name = "SPBPERS_ITIN")
    private Integer spbpersItin;
    @Column(name = "SPBPERS_ACTIVE_DUTY_SEPR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersActiveDutySeprDate;
    @Size(max = 30)
    @Column(name = "SPBPERS_DATA_ORIGIN")
    private String spbpersDataOrigin;
    @Size(max = 30)
    @Column(name = "SPBPERS_USER_ID")
    private String spbpersUserId;
    @Size(max = 1)
    @Column(name = "SPBPERS_ETHN_CDE")
    private String spbpersEthnCde;
    @Size(max = 1)
    @Column(name = "SPBPERS_CONFIRMED_RE_CDE")
    private String spbpersConfirmedReCde;
    @Column(name = "SPBPERS_CONFIRMED_RE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spbpersConfirmedReDate;

    public Spbpers() {
    }

    public Spbpers(Integer spbpersPidm) {
        this.spbpersPidm = spbpersPidm;
    }

    public Spbpers(Integer spbpersPidm, Date spbpersActivityDate) {
        this.spbpersPidm = spbpersPidm;
        this.spbpersActivityDate = spbpersActivityDate;
    }

    public Integer getSpbpersPidm() {
        return spbpersPidm;
    }

    public void setSpbpersPidm(Integer spbpersPidm) {
        this.spbpersPidm = spbpersPidm;
    }

    public String getSpbpersSsn() {
        return spbpersSsn;
    }

    public void setSpbpersSsn(String spbpersSsn) {
        this.spbpersSsn = spbpersSsn;
    }

    public Date getSpbpersBirthDate() {
        return spbpersBirthDate;
    }

    public void setSpbpersBirthDate(Date spbpersBirthDate) {
        this.spbpersBirthDate = spbpersBirthDate;
    }

    public String getSpbpersLgcyCode() {
        return spbpersLgcyCode;
    }

    public void setSpbpersLgcyCode(String spbpersLgcyCode) {
        this.spbpersLgcyCode = spbpersLgcyCode;
    }

    public String getSpbpersEthnCode() {
        return spbpersEthnCode;
    }

    public void setSpbpersEthnCode(String spbpersEthnCode) {
        this.spbpersEthnCode = spbpersEthnCode;
    }

    public String getSpbpersMrtlCode() {
        return spbpersMrtlCode;
    }

    public void setSpbpersMrtlCode(String spbpersMrtlCode) {
        this.spbpersMrtlCode = spbpersMrtlCode;
    }

    public String getSpbpersRelgCode() {
        return spbpersRelgCode;
    }

    public void setSpbpersRelgCode(String spbpersRelgCode) {
        this.spbpersRelgCode = spbpersRelgCode;
    }

    public String getSpbpersSex() {
        return spbpersSex;
    }

    public void setSpbpersSex(String spbpersSex) {
        this.spbpersSex = spbpersSex;
    }

    public String getSpbpersConfidInd() {
        return spbpersConfidInd;
    }

    public void setSpbpersConfidInd(String spbpersConfidInd) {
        this.spbpersConfidInd = spbpersConfidInd;
    }

    public String getSpbpersDeadInd() {
        return spbpersDeadInd;
    }

    public void setSpbpersDeadInd(String spbpersDeadInd) {
        this.spbpersDeadInd = spbpersDeadInd;
    }

    public String getSpbpersVetcFileNumber() {
        return spbpersVetcFileNumber;
    }

    public void setSpbpersVetcFileNumber(String spbpersVetcFileNumber) {
        this.spbpersVetcFileNumber = spbpersVetcFileNumber;
    }

    public String getSpbpersLegalName() {
        return spbpersLegalName;
    }

    public void setSpbpersLegalName(String spbpersLegalName) {
        this.spbpersLegalName = spbpersLegalName;
    }

    public String getSpbpersPrefFirstName() {
        return spbpersPrefFirstName;
    }

    public void setSpbpersPrefFirstName(String spbpersPrefFirstName) {
        this.spbpersPrefFirstName = spbpersPrefFirstName;
    }

    public String getSpbpersNamePrefix() {
        return spbpersNamePrefix;
    }

    public void setSpbpersNamePrefix(String spbpersNamePrefix) {
        this.spbpersNamePrefix = spbpersNamePrefix;
    }

    public String getSpbpersNameSuffix() {
        return spbpersNameSuffix;
    }

    public void setSpbpersNameSuffix(String spbpersNameSuffix) {
        this.spbpersNameSuffix = spbpersNameSuffix;
    }

    public Date getSpbpersActivityDate() {
        return spbpersActivityDate;
    }

    public void setSpbpersActivityDate(Date spbpersActivityDate) {
        this.spbpersActivityDate = spbpersActivityDate;
    }

    public String getSpbpersVeraInd() {
        return spbpersVeraInd;
    }

    public void setSpbpersVeraInd(String spbpersVeraInd) {
        this.spbpersVeraInd = spbpersVeraInd;
    }

    public String getSpbpersCitzInd() {
        return spbpersCitzInd;
    }

    public void setSpbpersCitzInd(String spbpersCitzInd) {
        this.spbpersCitzInd = spbpersCitzInd;
    }

    public Date getSpbpersDeadDate() {
        return spbpersDeadDate;
    }

    public void setSpbpersDeadDate(Date spbpersDeadDate) {
        this.spbpersDeadDate = spbpersDeadDate;
    }

    public byte[] getSpbpersPin() {
        return spbpersPin;
    }

    public void setSpbpersPin(byte[] spbpersPin) {
        this.spbpersPin = spbpersPin;
    }

    public String getSpbpersCitzCode() {
        return spbpersCitzCode;
    }

    public void setSpbpersCitzCode(String spbpersCitzCode) {
        this.spbpersCitzCode = spbpersCitzCode;
    }

    public String getSpbpersHairCode() {
        return spbpersHairCode;
    }

    public void setSpbpersHairCode(String spbpersHairCode) {
        this.spbpersHairCode = spbpersHairCode;
    }

    public String getSpbpersEyesCode() {
        return spbpersEyesCode;
    }

    public void setSpbpersEyesCode(String spbpersEyesCode) {
        this.spbpersEyesCode = spbpersEyesCode;
    }

    public String getSpbpersCityBirth() {
        return spbpersCityBirth;
    }

    public void setSpbpersCityBirth(String spbpersCityBirth) {
        this.spbpersCityBirth = spbpersCityBirth;
    }

    public String getSpbpersStatCodeBirth() {
        return spbpersStatCodeBirth;
    }

    public void setSpbpersStatCodeBirth(String spbpersStatCodeBirth) {
        this.spbpersStatCodeBirth = spbpersStatCodeBirth;
    }

    public String getSpbpersDriverLicense() {
        return spbpersDriverLicense;
    }

    public void setSpbpersDriverLicense(String spbpersDriverLicense) {
        this.spbpersDriverLicense = spbpersDriverLicense;
    }

    public String getSpbpersStatCodeDriver() {
        return spbpersStatCodeDriver;
    }

    public void setSpbpersStatCodeDriver(String spbpersStatCodeDriver) {
        this.spbpersStatCodeDriver = spbpersStatCodeDriver;
    }

    public String getSpbpersNatnCodeDriver() {
        return spbpersNatnCodeDriver;
    }

    public void setSpbpersNatnCodeDriver(String spbpersNatnCodeDriver) {
        this.spbpersNatnCodeDriver = spbpersNatnCodeDriver;
    }

    public String getSpbpersUomsCodeHeight() {
        return spbpersUomsCodeHeight;
    }

    public void setSpbpersUomsCodeHeight(String spbpersUomsCodeHeight) {
        this.spbpersUomsCodeHeight = spbpersUomsCodeHeight;
    }

    public Short getSpbpersHeight() {
        return spbpersHeight;
    }

    public void setSpbpersHeight(Short spbpersHeight) {
        this.spbpersHeight = spbpersHeight;
    }

    public String getSpbpersUomsCodeWeight() {
        return spbpersUomsCodeWeight;
    }

    public void setSpbpersUomsCodeWeight(String spbpersUomsCodeWeight) {
        this.spbpersUomsCodeWeight = spbpersUomsCodeWeight;
    }

    public Short getSpbpersWeight() {
        return spbpersWeight;
    }

    public void setSpbpersWeight(Short spbpersWeight) {
        this.spbpersWeight = spbpersWeight;
    }

    public String getSpbpersSdvetInd() {
        return spbpersSdvetInd;
    }

    public void setSpbpersSdvetInd(String spbpersSdvetInd) {
        this.spbpersSdvetInd = spbpersSdvetInd;
    }

    public Date getSpbpersLicenseIssuedDate() {
        return spbpersLicenseIssuedDate;
    }

    public void setSpbpersLicenseIssuedDate(Date spbpersLicenseIssuedDate) {
        this.spbpersLicenseIssuedDate = spbpersLicenseIssuedDate;
    }

    public Date getSpbpersLicenseExpiresDate() {
        return spbpersLicenseExpiresDate;
    }

    public void setSpbpersLicenseExpiresDate(Date spbpersLicenseExpiresDate) {
        this.spbpersLicenseExpiresDate = spbpersLicenseExpiresDate;
    }

    public String getSpbpersIncarInd() {
        return spbpersIncarInd;
    }

    public void setSpbpersIncarInd(String spbpersIncarInd) {
        this.spbpersIncarInd = spbpersIncarInd;
    }

    public byte[] getSpbpersWebid() {
        return spbpersWebid;
    }

    public void setSpbpersWebid(byte[] spbpersWebid) {
        this.spbpersWebid = spbpersWebid;
    }

    public byte[] getSpbpersWebLastAccess() {
        return spbpersWebLastAccess;
    }

    public void setSpbpersWebLastAccess(byte[] spbpersWebLastAccess) {
        this.spbpersWebLastAccess = spbpersWebLastAccess;
    }

    public byte[] getSpbpersPinDisabledInd() {
        return spbpersPinDisabledInd;
    }

    public void setSpbpersPinDisabledInd(byte[] spbpersPinDisabledInd) {
        this.spbpersPinDisabledInd = spbpersPinDisabledInd;
    }

    public Integer getSpbpersItin() {
        return spbpersItin;
    }

    public void setSpbpersItin(Integer spbpersItin) {
        this.spbpersItin = spbpersItin;
    }

    public Date getSpbpersActiveDutySeprDate() {
        return spbpersActiveDutySeprDate;
    }

    public void setSpbpersActiveDutySeprDate(Date spbpersActiveDutySeprDate) {
        this.spbpersActiveDutySeprDate = spbpersActiveDutySeprDate;
    }

    public String getSpbpersDataOrigin() {
        return spbpersDataOrigin;
    }

    public void setSpbpersDataOrigin(String spbpersDataOrigin) {
        this.spbpersDataOrigin = spbpersDataOrigin;
    }

    public String getSpbpersUserId() {
        return spbpersUserId;
    }

    public void setSpbpersUserId(String spbpersUserId) {
        this.spbpersUserId = spbpersUserId;
    }

    public String getSpbpersEthnCde() {
        return spbpersEthnCde;
    }

    public void setSpbpersEthnCde(String spbpersEthnCde) {
        this.spbpersEthnCde = spbpersEthnCde;
    }

    public String getSpbpersConfirmedReCde() {
        return spbpersConfirmedReCde;
    }

    public void setSpbpersConfirmedReCde(String spbpersConfirmedReCde) {
        this.spbpersConfirmedReCde = spbpersConfirmedReCde;
    }

    public Date getSpbpersConfirmedReDate() {
        return spbpersConfirmedReDate;
    }

    public void setSpbpersConfirmedReDate(Date spbpersConfirmedReDate) {
        this.spbpersConfirmedReDate = spbpersConfirmedReDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spbpersPidm != null ? spbpersPidm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spbpers)) {
            return false;
        }
        Spbpers other = (Spbpers) object;
        if ((this.spbpersPidm == null && other.spbpersPidm != null) || (this.spbpersPidm != null && !this.spbpersPidm.equals(other.spbpersPidm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.saturno.entity.Spbpers[ spbpersPidm=" + spbpersPidm + " ]";
    }
    
}
