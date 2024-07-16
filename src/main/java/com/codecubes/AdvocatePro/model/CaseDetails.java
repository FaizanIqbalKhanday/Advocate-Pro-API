package com.codecubes.AdvocatePro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
 @Entity
public class CaseDetails {

    private String caseType;

    private String filingNumber;

    private String filingDate;

    private String registrationNumber;

    private String registrationDate;
    @Id
    private String ncrNumber;
    @Embedded
    private CaseStatus caseStatus;

    public CaseDetails() {
    }

    public CaseDetails(String caseType, String filingNumber, String filingDate, String registrationNumber, String registrationDate,String ncrNumber, CaseStatus caseStatus) {
        this.caseType = caseType;
        this.filingNumber = filingNumber;
        this.filingDate = filingDate;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.ncrNumber=ncrNumber;
        this.caseStatus = caseStatus;
    }

     public String getNcrNumber() {
         return ncrNumber;
     }

     public void setNcrNumber(String ncrNumber) {
         this.ncrNumber = ncrNumber;
     }

     public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(String filingNumber) {
        this.filingNumber = filingNumber;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    @JsonProperty("registrationDate")
    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }
    @JsonProperty("caseStatus")
    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }
}
@Embeddable
class CaseStatus {

    private String firstHearingDate;

    private String nextHearingDate;

    private String caseStage;

    private String courtNumberAndJudge;

    public CaseStatus() {
    }

    public CaseStatus(String firstHearingDate, String nextHearingDate, String caseStage, String courtNumberAndJudge) {
        this.firstHearingDate = firstHearingDate;
        this.nextHearingDate = nextHearingDate;
        this.caseStage = caseStage;
        this.courtNumberAndJudge = courtNumberAndJudge;
    }
    public String getFirstHearingDate() {
        return firstHearingDate;
    }

    public void setFirstHearingDate(String firstHearingDate) {
        this.firstHearingDate = firstHearingDate;
    }

    public String getNextHearingDate() {
        return nextHearingDate;
    }

    public void setNextHearingDate(String nextHearingDate) {
        this.nextHearingDate = nextHearingDate;
    }
    public String getCaseStage() {
        return caseStage;
    }

    public void setCaseStage(String caseStage) {
        this.caseStage = caseStage;
    }

    public String getCourtNumberAndJudge() {
        return courtNumberAndJudge;
    }

    public void setCourtNumberAndJudge(String courtNumberAndJudge) {
        this.courtNumberAndJudge = courtNumberAndJudge;
    }
}
