package com.codecubes.AdvocatePro.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "advocate_details")
public class AdvocateDetails {
    @Id
    private String advocateId;
    @Column(name = "advocate_name")
    private String AdvocateName;
    @ElementCollection
    private List<Cases> casesList;

    public AdvocateDetails() {
    }

    public AdvocateDetails(String advocateId, String advocateName, List<Cases> casesList) {
        this.advocateId = advocateId;
        AdvocateName = advocateName;
        this.casesList = casesList;
    }

    public String getAdvocateId() {
        return advocateId;
    }

    public void setAdvocateId(String advocateId) {
        this.advocateId = advocateId;
    }

    public String getAdvocateName() {
        return AdvocateName;
    }

    public void setAdvocateName(String advocateName) {
        AdvocateName = advocateName;
    }

    public List<Cases> getCasesList() {
        return casesList;
    }

    public void setCasesList(List<Cases> casesList) {
        this.casesList = casesList;
    }
}

@Embeddable
class CaseStatus{
private String firstHearingDate;

private String nextHearingDate;

private String caseStage;

private String courtNumberAndJudge;

    public CaseStatus() {
    }

    public CaseStatus(String firstHearingDate, String nextHearingDate,
                      String caseStage, String courtNumberAndJudge) {
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
