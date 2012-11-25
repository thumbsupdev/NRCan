package com.nrcan.entities;

public class PFlowSurficialEntity {
	private int nrcanId4;
	private int nrcanId3;
	private String stationId;
	private String earthMatId;
	private String pFlowId;
	private String pFlowNo;
	private String pfClass;
	private String pfFeature;
	private String pfSense;
	private String method;
	private String pfAzimuth;
	private String notes;
	private String relage;
	private String numIndic;
	private String definition;
	private String relation;
	private String notes_1;
	
	public PFlowSurficialEntity(){
		clearEntity();
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues[0]);
		this.nrcanId3 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.earthMatId = contentValues[3];
		this.pFlowId = contentValues[4];
		this.pFlowNo = contentValues[5];
		this.pfClass = contentValues[6];
		this.pfFeature = contentValues[7];
		this.pfSense = contentValues[8];
		this.method = contentValues[9];
		this.pfAzimuth = contentValues[10];
		this.notes = contentValues[11];
		this.relage = contentValues[12];
		this.numIndic = contentValues[13];
		this.definition = contentValues[14];
		this.relation = contentValues[15];
		this.notes_1 = contentValues[16];
	}
	
	public void clearEntity() {
		this.stationId = "";
		this.earthMatId = "";
		this.pFlowId = "";
		this.pFlowNo = "";
		this.pfClass = "";
		this.pfFeature = "";
		this.pfSense = "";
		this.method = "";
		this.pfAzimuth = "";
		this.notes = "";
		this.relage = "";
		this.numIndic = "";
		this.definition = "";
		this.relation = "";
		this.notes_1 = "";
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
	public String getpFlowId() {
		return pFlowId;
	}
	public void setpFlowId(String pFlowId) {
		this.pFlowId = pFlowId;
	}
	public String getpFlowNo() {
		return pFlowNo;
	}
	public void setpFlowNo(String pFlowNo) {
		this.pFlowNo = pFlowNo;
	}
	public String getPfClass() {
		return pfClass;
	}
	public void setPfClass(String pfClass) {
		this.pfClass = pfClass;
	}
	public String getPfFeature() {
		return pfFeature;
	}
	public void setPfFeature(String pfFeature) {
		this.pfFeature = pfFeature;
	}
	public String getPfSense() {
		return pfSense;
	}
	public void setPfSense(String pfSense) {
		this.pfSense = pfSense;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPfAzimuth() {
		return pfAzimuth;
	}
	public void setPfAzimuth(String pfAzimuth) {
		this.pfAzimuth = pfAzimuth;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRelage() {
		return relage;
	}
	public void setRelage(String relage) {
		this.relage = relage;
	}
	public String getNumIndic() {
		return numIndic;
	}
	public void setNumIndic(String numIndic) {
		this.numIndic = numIndic;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getNotes_1() {
		return notes_1;
	}
	public void setNotes_1(String notes_1) {
		this.notes_1 = notes_1;
	}
	
	

}
