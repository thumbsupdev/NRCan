package com.nrcan.entities;

import java.util.ArrayList;

public class StructureEntity {
	private int nrcanId4;
	private int nrcanId3;
	private String stationId;
	private String earthMatID;
	private String structId;
	private String structNo;
	private String strucClass;
	private String strucType;
	private String detail;
	private String method;
	private String format;
	private String attitude;
	private String younging;
	private String generation;
	private String strain;
	private String flattening;
	private String related;
	private String fabric;
	private String sense;
	private String azimuth;
	private String dipplunge;
	private String symang;
	private String notes;
	
	public StructureEntity(){
		clearEntity();
	}
	
	public void setEntity (ArrayList<String> contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues.get(0));
		this.nrcanId3 = Integer.parseInt(contentValues.get(1));
		this.stationId = contentValues.get(2);
		this.earthMatID = contentValues.get(3);
		this.structId = contentValues.get(4);
		this.structNo = contentValues.get(5);
		this.strucClass = contentValues.get(6);
		this.strucType = contentValues.get(7);
		this.detail = contentValues.get(8);
		this.method = contentValues.get(9);
		this.format = contentValues.get(10);
		this.attitude = contentValues.get(11);
		this.younging = contentValues.get(12);
		this.generation = contentValues.get(13);
		this.strain = contentValues.get(14);
		this.flattening = contentValues.get(15);
		this.related = contentValues.get(16);
		this.fabric = contentValues.get(17);
		this.sense = contentValues.get(18);
		this.azimuth = contentValues.get(19);
		this.dipplunge = contentValues.get(20);
		this.symang = contentValues.get(21);
		this.notes = contentValues.get(22);
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues[0]);
		this.nrcanId3 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.earthMatID = contentValues[3];
		this.structId = contentValues[4];
		this.structNo = contentValues[5];
		this.strucClass = contentValues[6];
		this.strucType = contentValues[7];
		this.detail = contentValues[8];
		this.method = contentValues[9];
		this.format = contentValues[10];
		this.attitude = contentValues[11];
		this.younging = contentValues[12];
		this.generation = contentValues[13];
		this.strain = contentValues[14];
		this.flattening = contentValues[15];
		this.related = contentValues[16];
		this.fabric = contentValues[17];
		this.sense = contentValues[18];
		this.azimuth = contentValues[19];
		this.dipplunge = contentValues[20];
		this.symang = contentValues[21];
		this.notes = contentValues[22];
	}
	
	public void clearEntity() {
		this.stationId = "";
		this.earthMatID = "";
		this.structId = "";
		this.structNo = "";
		this.strucClass = "";
		this.strucType = "";
		this.detail = "";
		this.method = "";
		this.format = "";
		this.attitude = "";
		this.younging = "";
		this.generation = "";
		this.strain = "";
		this.flattening = "";
		this.related = "";
		this.fabric = "";
		this.sense = "";
		this.azimuth = "";
		this.dipplunge = "";
		this.symang = "";
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
	public String getEarthMatID() {
		return earthMatID;
	}
	public void setEarthMatID(String earthMatID) {
		this.earthMatID = earthMatID;
	}
	public String getStructId() {
		return structId;
	}
	public void setStructId(String structId) {
		this.structId = structId;
	}
	public String getStructNo() {
		return structNo;
	}
	public void setStructNo(String structNo) {
		this.structNo = structNo;
	}
	public String getStrucClass() {
		return strucClass;
	}
	public void setStrucClass(String strucClass) {
		this.strucClass = strucClass;
	}
	public String getStrucType() {
		return strucType;
	}
	public void setStrucType(String strucType) {
		this.strucType = strucType;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getAttitude() {
		return attitude;
	}
	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}
	public String getYounging() {
		return younging;
	}
	public void setYounging(String younging) {
		this.younging = younging;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	public String getFlattening() {
		return flattening;
	}
	public void setFlattening(String flattening) {
		this.flattening = flattening;
	}
	public String getRelated() {
		return related;
	}
	public void setRelated(String related) {
		this.related = related;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getSense() {
		return sense;
	}
	public void setSense(String sense) {
		this.sense = sense;
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
	public String getSymang() {
		return symang;
	}
	public void setSymang(String symang) {
		this.symang = symang;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
