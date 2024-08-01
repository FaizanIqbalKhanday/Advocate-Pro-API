package com.codecubes.AdvocatePro.model;

import jakarta.persistence.Embeddable;

@Embeddable
public
class CaseDetails {
    private String caseType;

    private String filingNumber;

    private String filingDate;

    private String registrationNumber;

    private String registrationDate;

    private String ncrNumber;
    private String act;
    private String Section;

    public CaseDetails() {
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

    public CaseDetails(String caseType, String filingNumber,
                       String filingDate, String registrationNumber, String registrationDate, String ncrNumber,
                       String act, String section) {
        this.caseType = caseType;
        this.filingNumber = filingNumber;
        this.filingDate = filingDate;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.ncrNumber = ncrNumber;
        this.act = act;
        Section = section;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNcrNumber() {
        return ncrNumber;
    }

    public void setNcrNumber(String ncrNumber) {
        this.ncrNumber = ncrNumber;
    }
}
