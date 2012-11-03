package com.nrcan.entities;

public class Metadata {
    
       // Table column values
    private int mdID;
    private String mdProjectName;
    private String mdProjectCode;
    private String mdProjectLead;
    private String mdProjectType;
    private String mdGeologist;
    private String mdGeolcode;
    private String mdDigcamera;
    private String mdDatum;
    private String mdMapPath;
    
    // Define a contract between the controller and model, to pass the data in
    // the order in which the columns show up in the create table statement.
    public Metadata(String[] contentValues) {

        this.mdID = Integer.parseInt(contentValues[0]);
        this.mdProjectName = contentValues[1];
        this.mdProjectCode = contentValues[2];
        this.mdProjectLead = contentValues[3];
        this.mdProjectType = contentValues[4];
        this.mdGeologist = contentValues[5];
        this.mdGeolcode = contentValues[6];
        this.mdDigcamera = contentValues[7];
        this.mdDatum = contentValues[8];
        this.mdMapPath = contentValues[9];
    }

    // this is a checked exception
    public void setID(String mdID) {

        if(mdID == null) {
            throw new IllegalArgumentException("setID() mdID is null");
        }

        try {
            this.mdID = Integer.parseInt(mdID);
        } catch(NumberFormatException nfe) {
            throw new IllegalArgumentException(nfe);
        }
    }

    public int getID() {
        return mdID;
    }

    public void setProjectName(String mdProjectName) {
        this.mdProjectName = mdProjectName;
    }

    public String getProjectName() {
        return mdProjectName;
    }

    public void setCode(String mdProjectCode) {
        this.mdProjectCode = mdProjectCode;
    }

    public String getProjectCode() {
        return mdProjectCode;
    }

    public void setProjectLead(String mdProjectLead) {
        this.mdProjectLead = mdProjectLead;
    }

    public String getProjectLead() {
        return mdProjectLead;
    }

    public void setProjectType(String mdProjectType) {
        this.mdProjectType = mdProjectType;
    }

    public String getProjectType() {
        return mdProjectType;
    }

    public void setGeolcode(String mdGeolcode) {
        this.mdGeolcode = mdGeolcode;
    }

    public String getGeolcode() {
        return mdGeolcode;
    }

    public void setGeologist(String mdGeologist) {
        this.mdGeologist = mdGeologist;
    }

    public String getGeologist() {
        return mdGeologist;
    }

    public void setMapPath(String mdMapPath) {
        this.mdMapPath = mdMapPath;
    }

    public String getMapPath() {
        return mdMapPath;
    }

    public void setDatum(String mdDatum) {
        this.mdDatum = mdDatum;
    }

    public String getDatum() {
        return mdDatum;
    }

    public void setDigcamera(String mdDigcamera) {
        this.mdDigcamera = mdDigcamera;
    }

    public String getDigcamera() {
        return mdDigcamera;
    }
}
