package com.nrcan.entities;

public class StationSurficialEntity {
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
	private String mapSheet;
	private String legendVal;
	private String partner;
	private String metaId;
	
	public StationSurficialEntity (String[] contentValues) {
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
		this.mapSheet = contentValues[24];
		this.legendVal = contentValues[25];
		this.partner = contentValues[26];
		this.metaId = contentValues[27];
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
	public String getOcQuality() {
		return ocQuality;
	}
	public void setOcQuality(String ocQuality) {
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
	public String getMapSheet() {
		return mapSheet;
	}
	public void setMapSheet(String mapSheet) {
		this.mapSheet = mapSheet;
	}
	public String getLegendVal() {
		return legendVal;
	}
	public void setLegendVal(String legendVal) {
		this.legendVal = legendVal;
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
