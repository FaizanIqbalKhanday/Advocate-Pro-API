package com.codecubes.AdvocatePro.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "advocate_details")
public class AdvocateDetails {

    private String advocateEmail;
    @Column(name = "advocate_name")
    private String AdvocateName;
    @Id
    private String advocatePhoneNumber;
    private String password;
    @ElementCollection
    private List<Cases> casesList;

    public AdvocateDetails() {
    }

    public String getAdvocateEmail() {
        return advocateEmail;
    }

    public AdvocateDetails(String advocateEmail, String advocateName, String advocatePhoneNumber, String password, List<Cases> casesList) {
        this.advocateEmail = advocateEmail;
        AdvocateName = advocateName;
        this.advocatePhoneNumber = advocatePhoneNumber;
        this.password = password;
        this.casesList = casesList;
    }

    public void setAdvocateEmail(String advocateEmail) {
        this.advocateEmail = advocateEmail;
    }

    public String getAdvocatePhoneNumber() {
        return advocatePhoneNumber;
    }

    public void setAdvocatePhoneNumber(String advocatePhoneNumber) {
        this.advocatePhoneNumber = advocatePhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
@Embeddable
class ClientDetails {
    private String clientName;
    private String ClientPhoneNumber;
    private int totalFees;
    private int paidFees;
    private int balanceFees;


    public ClientDetails() {
    }

    public ClientDetails(String clientName, String clientPhoneNumber, int totalFees, int paidFees) {
        this.clientName = clientName;
        ClientPhoneNumber = clientPhoneNumber;
        this.totalFees = totalFees;
        this.paidFees = paidFees;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return ClientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        ClientPhoneNumber = clientPhoneNumber;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }

    public int getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(int paidFees) {
        this.paidFees = paidFees;
    }

    public int getBalanceFees() {
        return balanceFees;
    }

    public void setBalanceFees(int balanceFees) {
        this.balanceFees = totalFees-paidFees;
    }

}
