package com.nrcan.entities;

import java.util.ArrayList;

public class StationBedrockEntity {
	private int nrcanId2;
	private int nrcanId1;
	private String id;
	private String stationId;
	private String travNo;
	private String visitDate;
	private String visitTime;
	private String latitude;
	private String longitude;
	private String easting;
	private String northing;
	private String datumZone;
	private String elevation;
	private String elevMethod;
	private String entryType;
	private String pDop;
	private String satsUsed;
	private String obsType;
	private String ocQuality;
	private String physEnv;
	private String ocSize;
	private String notes;
	private String slsNotes;
	private String airPhoto;
	private String partner;
	private String metaId;
	
	public StationBedrockEntity(){
		clearEntity();
	}
	
	public void setEntity (ArrayList<String> contentValues) {
		this.nrcanId2 = Integer.parseInt(contentValues.get(0));
		this.nrcanId1 = Integer.parseInt(contentValues.get(1));
		this.id = contentValues.get(2);
		this.stationId = contentValues.get(3);
		this.travNo = contentValues.get(4);
		this.visitDate = contentValues.get(5);
		this.visitTime = contentValues.get(6);
		this.latitude = contentValues.get(7);
		this.longitude = contentValues.get(8);
		this.easting = contentValues.get(9);
		this.northing = contentValues.get(10);
		this.datumZone = contentValues.get(11);
		this.elevation = contentValues.get(12);
		this.elevMethod = contentValues.get(13);
		this.entryType = contentValues.get(14);
		this.pDop = contentValues.get(15);
		this.satsUsed = contentValues.get(16);
		this.obsType = contentValues.get(17);
		this.ocQuality = contentValues.get(18);
		this.physEnv = contentValues.get(19);
		this.ocSize = contentValues.get(20);
		this.notes = contentValues.get(21);
		this.slsNotes = contentValues.get(22);
		this.airPhoto = contentValues.get(23);
		this.partner = contentValues.get(24);
		this.metaId = contentValues.get(25);
    }
	
	
	public void setEntity (String[] contentValues) {
		this.nrcanId2 = Integer.parseInt(contentValues[0]);
		this.nrcanId1 = Integer.parseInt(contentValues[1]);
		this.id = contentValues[2];
		this.stationId = contentValues[3];
		this.travNo = contentValues[4];
		this.visitDate = contentValues[5];
		this.visitTime = contentValues[6];
		this.latitude = contentValues[7];
		this.longitude = contentValues[8];
		this.easting = contentValues[9];
		this.northing = contentValues[10];
		this.datumZone = contentValues[11];
		this.elevation = contentValues[12];
		this.elevMethod = contentValues[13];
		this.entryType = contentValues[14];
		this.pDop = contentValues[15];
		this.satsUsed = contentValues[16];
		this.obsType = contentValues[17];
		this.ocQuality = contentValues[18];
		this.physEnv = contentValues[19];
		this.ocSize = contentValues[20];
		this.notes = contentValues[21];
		this.slsNotes = contentValues[22];
		this.airPhoto = contentValues[23];
		this.partner = contentValues[24];
		this.metaId = contentValues[25];
    }
	
	public void clearEntity(){
		this.id = "";
		this.stationId = "";
		this.travNo = "";
		this.visitDate = "";
		this.visitTime = "";
		this.latitude = "";
		this.longitude = "";
		this.easting = "";
		this.northing = "";
		this.datumZone = "";
		this.elevation = "";
		this.elevMethod = "";
		this.entryType = "";
		this.pDop = "";
		this.satsUsed = "";
		this.obsType = "";
		this.ocQuality = "";
		this.physEnv = "";
		this.ocSize = "";
		this.notes = "";
		this.slsNotes = "";
		this.airPhoto = "";
		this.partner = "";
		this.metaId = "";
	}
	
	public int getNrcanId2() {
		return nrcanId2;
	}
	public void setNrcanId2(int nrcanId2) {
		this.nrcanId2 = nrcanId2;
	}
	public int getNrcanId1() {
		return nrcanId1;
	}
	public void setNrcanId1(int nrcanId1) {
		this.nrcanId1 = nrcanId1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getTravNo() {
		return travNo;
	}
	public void setTravNo(String travNo) {
		this.travNo = travNo;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getEasting() {
		return easting;
	}
	public void setEasting(String easting) {
		this.easting = easting;
	}
	public String getNorthing() {
		return northing;
	}
	public void setNorthing(String northing) {
		this.northing = northing;
	}
	public String getDatumZone() {
		return datumZone;
	}
	public void setDatumZone(String datumZone) {
		this.datumZone = datumZone;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getElevMethod() {
		return elevMethod;
	}
	public void setElevMethod(String elevMethod) {
		this.elevMethod = elevMethod;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	public String getpDop() {
		return pDop;
	}
	public void setpDop(String pDop) {
		this.pDop = pDop;
	}
	public String getSatsUsed() {
		return satsUsed;
	}
	public void setSatsUsed(String satsUsed) {
		this.satsUsed = satsUsed;
	}
	public String getObsType() {
		return obsType;
	}
	public void setObsType(String obsType) {
		this.obsType = obsType;
	}
	public String getOCQuality() {
		return ocQuality;
	}
	public void setOCQuality(String ocQuality) {
		this.ocQuality = ocQuality;
	}
	public String getPhysEnv() {
		return physEnv;
	}
	public void setPhysEnv(String physEnv) {
		this.physEnv = physEnv;
	}
	public String getOcSize() {
		return ocSize;
	}
	public void setOcSize(String ocSize) {
		this.ocSize = ocSize;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getSlsNotes() {
		return slsNotes;
	}
	public void setSlsNotes(String slsNotes) {
		this.slsNotes = slsNotes;
	}
	public String getAirPhoto() {
		return airPhoto;
	}
	public void setAirPhoto(String airPhoto) {
		this.airPhoto = airPhoto;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getMetaId() {
		return metaId;
	}
	public void setMetaId(String metaId) {
		this.metaId = metaId;
	}
	

}
