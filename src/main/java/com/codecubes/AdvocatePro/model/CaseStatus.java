package com.codecubes.AdvocatePro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CaseStatus {

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
