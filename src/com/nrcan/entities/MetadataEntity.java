package com.nrcan.entities;

import java.util.ArrayList;

public class MetadataEntity {
    
    private int nrcanId1;
    private String prjct_name;
    private String prjct_code;
    private String prjct_lead;
    private String prjct_type;
    private String geolcode;
    private String geologist;
    private String mappath;
    private String prj_name;
    private String prj_type;
    private String prj_datum;
    private String digcamera;
    private String stnstartno;
    private String metaid;
    
    public MetadataEntity() {
        clearEntity();
    }
    
    public void setEntity(ArrayList<String> contentValues) {
        this.nrcanId1 = Integer.parseInt(contentValues.get(0));
        this.prjct_name = contentValues.get(1);
        this.prjct_code = contentValues.get(2);
        this.prjct_lead = contentValues.get(3);
        this.prjct_type = contentValues.get(4);
        this.geolcode = contentValues.get(5);
        this.geologist = contentValues.get(6);
        this.mappath = contentValues.get(7);
        this.prj_name = contentValues.get(8);
        this.prj_type = contentValues.get(9);
        this.prj_datum = contentValues.get(10);
        this.digcamera = contentValues.get(11);
        this.stnstartno = contentValues.get(12);
        this.metaid = contentValues.get(13);
    }
    
    public void setEntity(String[] contentValues) {
        this.nrcanId1 = Integer.parseInt(contentValues[0]);
        this.prjct_name = contentValues[1];
        this.prjct_code = contentValues[2];
        this.prjct_lead = contentValues[3];
        this.prjct_type = contentValues[4];
        this.geolcode = contentValues[5];
        this.geologist = contentValues[6];
        this.mappath = contentValues[7];
        this.prj_name = contentValues[8];
        this.prj_type = contentValues[9];
        this.prj_datum = contentValues[10];
        this.digcamera = contentValues[11];
        this.stnstartno = contentValues[12];
        this.metaid = contentValues[13];
    }
    
    public void clearEntity(){
    	this.prjct_name = "";
        this.prjct_code = "";
        this.prjct_lead = "";
        this.prjct_type = "";
        this.geolcode = "";
        this.geologist = "";
        this.mappath = "";
        this.prj_name = "";
        this.prj_type = "";
        this.prj_datum = "";
        this.digcamera = "";
        this.stnstartno = "";
        this.metaid = "";
    }

	public int getNrcanId1() {
		return nrcanId1;
	}

	public void setNrcanId1(int nrcanId1) {
		this.nrcanId1 = nrcanId1;
	}

	public String getPrjct_name() {
		return prjct_name;
	}

	public void setPrjct_name(String prjct_name) {
		this.prjct_name = prjct_name;
	}

	public String getPrjct_code() {
		return prjct_code;
	}

	public void setPrjct_code(String prjct_code) {
		this.prjct_code = prjct_code;
	}

	public String getPrjct_lead() {
		return prjct_lead;
	}

	public void setPrjct_lead(String prjct_lead) {
		this.prjct_lead = prjct_lead;
	}

	public String getPrjct_type() {
		return prjct_type;
	}

	public void setPrjct_type(String prjct_type) {
		this.prjct_type = prjct_type;
	}

	public String getGeolcode() {
		return geolcode;
	}

	public void setGeolcode(String geolcode) {
		this.geolcode = geolcode;
	}

	public String getGeologist() {
		return geologist;
	}

	public void setGeologist(String geologist) {
		this.geologist = geologist;
	}

	public String getMappath() {
		return mappath;
	}

	public void setMappath(String mappath) {
		this.mappath = mappath;
	}

	public String getPrj_name() {
		return prj_name;
	}

	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}

	public String getPrj_type() {
		return prj_type;
	}

	public void setPrj_type(String prj_type) {
		this.prj_type = prj_type;
	}

	public String getPrj_datum() {
		return prj_datum;
	}

	public void setPrj_datum(String prj_datum) {
		this.prj_datum = prj_datum;
	}

	public String getDigcamera() {
		return digcamera;
	}

	public void setDigcamera(String digcamera) {
		this.digcamera = digcamera;
	}

	public String getStnstartno() {
		return stnstartno;
	}

	public void setStnstartno(String stnstartno) {
		this.stnstartno = stnstartno;
	}

	public String getMetaid() {
		return metaid;
	}

	public void setMetaid(String metaid) {
		this.metaid = metaid;
	}
}
