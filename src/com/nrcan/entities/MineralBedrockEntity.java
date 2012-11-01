package com.nrcan.entities;

public class MineralBedrockEntity {
	private String stationID;
	private String earthmatID;
	private String mineralID;
	private int mineralNo;
	private String mineral;
	private String form;
	private String habit;
	private String occurrence;
	private String colour;
	private int sizeMinmm;
	private int SizeMaxmm;
	private int mode;
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
	public int getMineralNo() {
		return mineralNo;
	}
	public void setMineralNo(int mineralNo) {
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
	public int getSizeMinmm() {
		return sizeMinmm;
	}
	public void setSizeMinmm(int sizeMinmm) {
		this.sizeMinmm = sizeMinmm;
	}
	public int getSizeMaxmm() {
		return SizeMaxmm;
	}
	public void setSizeMaxmm(int sizeMaxmm) {
		SizeMaxmm = sizeMaxmm;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	private String notes;

}
