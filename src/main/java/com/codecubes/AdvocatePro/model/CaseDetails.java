package com.codecubes.AdvocatePro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CaseDetails {

    private String caseType;

    private String filingNumber;

    private String filingDate;

    private String registrationNumber;

    private String registrationDate;

    private CaseStatus caseStatus;

    public CaseDetails() {
    }

    public CaseDetails(String caseType, String filingNumber, String filingDate, String registrationNumber, String registrationDate, CaseStatus caseStatus) {
        this.caseType = caseType;
        this.filingNumber = filingNumber;
        this.filingDate = filingDate;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.caseStatus = caseStatus;
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
