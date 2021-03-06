package com.nrcan.entities;

import java.util.ArrayList;

public class EarthmatBedrockEntity {
	private int nrcanId3;
	private int nrcanId2;
	private String stationID;
	private String earthmatLT;
	private String earthmatNo;
	private String earthmatID;
	private String lithGroup;
	private String lithType;
	private String lithDetail;
	private String mapUnit;
	private String occurAs;
	private String modStruc;
	private String modTexture;
	private String modComp;
	private String grcrySize;
	private String defFabric;
	private String bedThick;
	private String mineral;
	private String minNote;
	private String colourF;
	private String colourW;
	private String colourInd;
	private String magSuscept;
	private String fossils;
	private String fossilNote;
	private String contact;
	private String contactUp;
	private String contactLow;
	private String interp;
	private String interpConf;
	
	public EarthmatBedrockEntity(){
		clearEntity();
	}
	
	public void setEntity (ArrayList<String> contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues.get(0));
		this.nrcanId2 = Integer.parseInt(contentValues.get(1));
		this.stationID = contentValues.get(2);
		this.earthmatLT = contentValues.get(3);
		this.earthmatNo = contentValues.get(4);
		this.earthmatID = contentValues.get(5);
		this.lithGroup = contentValues.get(6);
		this.lithType = contentValues.get(7);
		this.lithDetail = contentValues.get(8);
		this.mapUnit = contentValues.get(9);
		this.occurAs = contentValues.get(10);
		this.modStruc = contentValues.get(11);
		this.modTexture = contentValues.get(12);
		this.modComp = contentValues.get(13);
		this.grcrySize = contentValues.get(14);
		this.defFabric = contentValues.get(15);
		this.bedThick = contentValues.get(16);
		this.mineral = contentValues.get(17);
		this.minNote = contentValues.get(18);
		this.colourF = contentValues.get(19);
		this.colourW = contentValues.get(20);
		this.colourInd = contentValues.get(21);
		this.magSuscept = contentValues.get(22);
		this.fossils = contentValues.get(23);
		this.fossilNote = contentValues.get(24);
		this.contact = contentValues.get(25);
		this.contactUp = contentValues.get(26);
		this.contactLow = contentValues.get(27);
		this.interp = contentValues.get(28);
		this.interpConf = contentValues.get(29);
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues[0]);
		this.nrcanId2 = Integer.parseInt(contentValues[1]);
		this.stationID = contentValues[2];
		this.earthmatLT = contentValues[3];
		this.earthmatNo = contentValues[4];
		this.earthmatID = contentValues[5];
		this.lithGroup = contentValues[6];
		this.lithType = contentValues[7];
		this.lithDetail = contentValues[8];
		this.mapUnit = contentValues[9];
		this.occurAs = contentValues[10];
		this.modStruc = contentValues[11];
		this.modTexture = contentValues[12];
		this.modComp = contentValues[13];
		this.grcrySize = contentValues[14];
		this.defFabric = contentValues[15];
		this.bedThick = contentValues[16];
		this.mineral = contentValues[17];
		this.minNote = contentValues[18];
		this.colourF = contentValues[19];
		this.colourW = contentValues[20];
		this.colourInd = contentValues[21];
		this.magSuscept = contentValues[22];
		this.fossils = contentValues[23];
		this.fossilNote = contentValues[24];
		this.contact = contentValues[25];
		this.contactUp = contentValues[26];
		this.contactLow = contentValues[27];
		this.interp = contentValues[28];
		this.interpConf = contentValues[29];
	}
	
	public void clearEntity() {
		this.stationID = "";
		this.earthmatLT = "";
		this.earthmatNo = "";
		this.earthmatID = "";
		this.lithGroup = "";
		this.lithType = "";
		this.lithDetail = "";
		this.mapUnit = "";
		this.occurAs = "";
		this.modStruc = "";
		this.modTexture = "";
		this.modComp = "";
		this.grcrySize = "";
		this.defFabric = "";
		this.bedThick = "";
		this.mineral = "";
		this.minNote = "";
		this.colourF = "";
		this.colourW = "";
		this.colourInd = "";
		this.magSuscept = "";
		this.fossils = "";
		this.fossilNote = "";
		this.contact = "";
		this.contactUp = "";
		this.contactLow = "";
		this.interp = "";
		this.interpConf = ""; 
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

	public String getEarthmatLT() {
		return earthmatLT;
	}

	public void setEarthmatLT(String earthmatLT) {
		this.earthmatLT = earthmatLT;
	}

	public String getEarthmatNo() {
		return earthmatNo;
	}

	public void setEarthmatNo(String earthmatNo) {
		this.earthmatNo = earthmatNo;
	}

	public String getEarthmatID() {
		return earthmatID;
	}

	public void setEarthmatID(String earthmatID) {
		this.earthmatID = earthmatID;
	}

	public String getLithGroup() {
		return lithGroup;
	}

	public void setLithGroup(String lithGroup) {
		this.lithGroup = lithGroup;
	}

	public String getLithType() {
		return lithType;
	}

	public void setLithType(String lithType) {
		this.lithType = lithType;
	}

	public String getLithDetail() {
		return lithDetail;
	}

	public void setLithDetail(String lithDetail) {
		this.lithDetail = lithDetail;
	}

	public String getMapUnit() {
		return mapUnit;
	}

	public void setMapUnit(String mapUnit) {
		this.mapUnit = mapUnit;
	}

	public String getOccurAs() {
		return occurAs;
	}

	public void setOccurAs(String occurAs) {
		this.occurAs = occurAs;
	}

	public String getModStruc() {
		return modStruc;
	}

	public void setModStruc(String modStruc) {
		this.modStruc = modStruc;
	}

	public String getModTexture() {
		return modTexture;
	}

	public void setModTexture(String modTexture) {
		this.modTexture = modTexture;
	}

	public String getModComp() {
		return modComp;
	}

	public void setModComp(String modComp) {
		this.modComp = modComp;
	}

	public String getGrcrySize() {
		return grcrySize;
	}

	public void setGrcrySize(String grcrySize) {
		this.grcrySize = grcrySize;
	}

	public String getDefFabric() {
		return defFabric;
	}

	public void setDefFabric(String defFabric) {
		this.defFabric = defFabric;
	}

	public String getBedThick() {
		return bedThick;
	}

	public void setBedThick(String bedThick) {
		this.bedThick = bedThick;
	}

	public String getMineral() {
		return mineral;
	}

	public void setMineral(String mineral) {
		this.mineral = mineral;
	}

	public String getMinNote() {
		return minNote;
	}

	public void setMinNote(String minNote) {
		this.minNote = minNote;
	}

	public String getColourF() {
		return colourF;
	}

	public void setColourF(String colourF) {
		this.colourF = colourF;
	}

	public String getColourW() {
		return colourW;
	}

	public void setColourW(String colourW) {
		this.colourW = colourW;
	}

	public String getColourInd() {
		return colourInd;
	}

	public void setColourInd(String colourInd) {
		this.colourInd = colourInd;
	}

	public String getMagSuscept() {
		return magSuscept;
	}

	public void setMagSuscept(String magSuscept) {
		this.magSuscept = magSuscept;
	}

	public String getFossils() {
		return fossils;
	}

	public void setFossils(String fossils) {
		this.fossils = fossils;
	}

	public String getFossilNote() {
		return fossilNote;
	}

	public void setFossilNote(String fossilNote) {
		this.fossilNote = fossilNote;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactUp() {
		return contactUp;
	}

	public void setContactUp(String contactUp) {
		this.contactUp = contactUp;
	}

	public String getContactLow() {
		return contactLow;
	}

	public void setContactLow(String contactLow) {
		this.contactLow = contactLow;
	}

	public String getInterp() {
		return interp;
	}

	public void setInterp(String interp) {
		this.interp = interp;
	}

	public String getInterpConf() {
		return interpConf;
	}

	public void setInterpConf(String interpConf) {
		this.interpConf = interpConf;
	}

}
