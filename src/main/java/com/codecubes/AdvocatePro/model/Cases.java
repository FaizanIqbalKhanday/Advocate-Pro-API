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

    public Cases() {
    }

    public Cases(CaseDetails caseDetails, CaseStatus caseStatus) {
        this.caseDetails = caseDetails;
        this.caseStatus = caseStatus;
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
