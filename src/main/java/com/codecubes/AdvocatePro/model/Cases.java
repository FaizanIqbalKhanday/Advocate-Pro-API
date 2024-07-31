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
    private FeeAmount feeAmount;

    public Cases() {
    }

    public Cases(CaseDetails caseDetails, CaseStatus caseStatus, FeeAmount feeAmount) {
        this.caseDetails = caseDetails;
        this.caseStatus = caseStatus;
        this.feeAmount=feeAmount;
    }

    public FeeAmount getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(FeeAmount feeAmount) {
        this.feeAmount = feeAmount;
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
