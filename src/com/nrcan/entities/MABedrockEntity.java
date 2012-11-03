package com.nrcan.entities;

public class MABedrockEntity {
	private int nrcanId3;
	private int nrcanId2;
	private String stationID;
	private String maNo;
	private String manID;
	private String ma;
	private String unit;
	private String mineral;
	private String mode;
	private String distribute;
	private String notes;
	
	public MABedrockEntity (String[] contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues[0]);
		this.nrcanId2 = Integer.parseInt(contentValues[1]);
		this.stationID = contentValues[2];
		this.maNo = contentValues[3];
		this.manID = contentValues[4];
		this.ma = contentValues[5];
		this.unit = contentValues[6];
		this.mineral = contentValues[7];
		this.mode = contentValues[8];
		this.distribute = contentValues[9];
		this.notes = contentValues[10];
	}
	
	public int getNrcanId3() {
		return nrcanId3;
	}
	public void setNrcanId3(int nrcanId3) {
		this.nrcanId3 = nrcanId3;
	}
	public int getNrcanId2() {
		return nrcanId2;
	}
	public void setNrcanId2(int nrcanId2) {
		this.nrcanId2 = nrcanId2;
	}
	public String getStationID() {
		return stationID;
	}
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	public String getMaNo() {
		return maNo;
	}
	public void setMaNo(String maNo) {
		this.maNo = maNo;
	}
	public String getManID() {
		return manID;
	}
	public void setManID(String manID) {
		this.manID = manID;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMineral() {
		return mineral;
	}
	public void setMineral(String mineral) {
		this.mineral = mineral;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getDistribute() {
		return distribute;
	}
	public void setDistribute(String distribute) {
		this.distribute = distribute;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
