package com.codecubes.AdvocatePro.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public
class Cases {
    @Embedded
    private CaseDetails caseDetails;
    @Embedded
    private CaseStatus caseStatus;
    @Embedded
    private ClientDetails clientDetails;
    private FIRDetails firDetails;

    public Cases() {
    }

    public Cases(CaseDetails caseDetails, CaseStatus caseStatus,
                 ClientDetails clientDetails, FIRDetails firDetails) {
        this.caseDetails = caseDetails;
        this.caseStatus = caseStatus;
        this.clientDetails = clientDetails;
        this.firDetails = firDetails;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public FIRDetails getFirDetails() {
        return firDetails;
    }

    public void setFirDetails(FIRDetails firDetails) {
        this.firDetails = firDetails;
    }


    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }
}
