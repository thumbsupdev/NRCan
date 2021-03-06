package com.nrcan.entities;

import java.util.ArrayList;

public class SampleBedrockEntity {
	private int nrcanId4;
	private int nrcanId3;
	private String stationId;
	private String earthMatId;
	private String sampleId;
	private String sampleNo;
	private String sampleType;
	private String purpose;
	private String format;
	private String azimuth;
	private String dipplunge;
	private String surface;
	private String notes;
	
	public SampleBedrockEntity(){
		clearEntity();
	}
	
	public void setEntity (ArrayList<String> contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues.get(0));
		this.nrcanId3 = Integer.parseInt(contentValues.get(1));
		this.stationId = contentValues.get(2);
		this.earthMatId = contentValues.get(3);
		this.sampleId = contentValues.get(4);
		this.sampleNo = contentValues.get(5);
		this.sampleType = contentValues.get(6);
		this.purpose = contentValues.get(7);
		this.format = contentValues.get(8);
		this.azimuth = contentValues.get(9);
		this.dipplunge = contentValues.get(10);
		this.surface = contentValues.get(11);
		this.notes = contentValues.get(12);
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues[0]);
		this.nrcanId3 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.earthMatId = contentValues[3];
		this.sampleId = contentValues[4];
		this.sampleNo = contentValues[5];
		this.sampleType = contentValues[6];
		this.purpose = contentValues[7];
		this.format = contentValues[8];
		this.azimuth = contentValues[9];
		this.dipplunge = contentValues[10];
		this.surface = contentValues[11];
		this.notes = contentValues[12];
	}
	
	public void clearEntity(){
		this.stationId = "";
		this.earthMatId = "";
		this.sampleId = "";
		this.sampleNo = "";
		this.sampleType = "";
		this.purpose = "";
		this.format = "";
		this.azimuth = "";
		this.dipplunge = "";
		this.surface = "";
		this.notes = "";
	}
	
	public int getNrcanId4() {
		return nrcanId4;
	}
	public void setNrcanId4(int nrcanId4) {
		this.nrcanId4 = nrcanId4;
	}
	public int getNrcanId3() {
		return nrcanId3;
	}
	public void setNrcanId3(int nrcanId3) {
		this.nrcanId3 = nrcanId3;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getEarthMatId() {
		return earthMatId;
	}
	public void setEarthMatId(String earthMatId) {
		this.earthMatId = earthMatId;
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(String azimuth) {
		this.azimuth = azimuth;
	}
	public String getDipplunge() {
		return dipplunge;
	}
	public void setDipplunge(String dipplunge) {
		this.dipplunge = dipplunge;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
