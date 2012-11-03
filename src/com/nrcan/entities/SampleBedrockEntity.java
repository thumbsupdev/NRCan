package com.nrcan.entities;

public class SampleBedrockEntity {
	private String stationId;
	private String earthMatId;
	private int sampleNo;
	private String sampleType;
	private String purpose;
	private String format;
	private int azimuth;
	private int dipplunge;
	private String surface;
	private String notes;
	
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
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
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
	public int getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(int azimuth) {
		this.azimuth = azimuth;
	}
	public int getDipplunge() {
		return dipplunge;
	}
	public void setDipplunge(int dipplunge) {
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