package com.codecubes.AdvocatePro.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FIRDetails {
    private int firNumber;
    private String policeStation;
    private String Date;

    public FIRDetails() {
    }

    public FIRDetails(int firNumber, String policeStation, String date) {
        this.firNumber = firNumber;
        this.policeStation = policeStation;
        Date = date;
    }

    public int getFirNumber() {
        return firNumber;
    }

    public void setFirNumber(int firNumber) {
        this.firNumber = firNumber;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
