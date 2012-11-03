package com.nrcan.entities;

public class MineralBedrockEntity {
	private int nrcanId4;
	private int nrcanId3;
	private String stationID;
	private String earthmatID;
	private String mineralID;
	private String mineralNo;
	private String mineral;
	private String form;
	private String habit;
	private String occurrence;
	private String colour;
	private String sizeMinmm;
	private String SizeMaxmm;
	private String mode;
	private String notes;
	
	public MineralBedrockEntity (String[] contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues[0]);
		this.nrcanId3 = Integer.parseInt(contentValues[1]);
		this.stationID = contentValues[2];
		this.earthmatID = contentValues[3];
		this.mineralID = contentValues[4];
		this.mineralNo = contentValues[5];
		this.mineral = contentValues[6];
		this.form = contentValues[7];
		this.habit = contentValues[8];
		this.occurrence = contentValues[9];
		this.colour = contentValues[10];
		this.sizeMinmm = contentValues[11];
		this.SizeMaxmm = contentValues[12];
		this.mode = contentValues[13];
		this.notes = contentValues[14];
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
	public String getStationID() {
		return stationID;
	}
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	public String getEarthmatID() {
		return earthmatID;
	}
	public void setEarthmatID(String earthmatID) {
		this.earthmatID = earthmatID;
	}
	public String getMineralID() {
		return mineralID;
	}
	public void setMineralID(String mineralID) {
		this.mineralID = mineralID;
	}
	public String getMineralNo() {
		return mineralNo;
	}
	public void setMineralNo(String mineralNo) {
		this.mineralNo = mineralNo;
	}
	public String getMineral() {
		return mineral;
	}
	public void setMineral(String mineral) {
		this.mineral = mineral;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getOccurrence() {
		return occurrence;
	}
	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSizeMinmm() {
		return sizeMinmm;
	}
	public void setSizeMinmm(String sizeMinmm) {
		this.sizeMinmm = sizeMinmm;
	}
	public String getSizeMaxmm() {
		return SizeMaxmm;
	}
	public void setSizeMaxmm(String sizeMaxmm) {
		SizeMaxmm = sizeMaxmm;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
