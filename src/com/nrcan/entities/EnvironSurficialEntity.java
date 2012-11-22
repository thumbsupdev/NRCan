package com.nrcan.entities;

public class EnvironSurficialEntity {
	private int nrcanId3;
	private int nrcanId2;
	private String stationId;
	private String drainage;
	private String slope;
	private String aspect;
	private String pfPresent;
	private String pfIndic;
	private String pfDepth;
	private String gossanPres;
	private String gossanMat;
	private String bRock;
	private String exposure;
	private String vegetation;
	private String boulders;
	private String bouldFld;
	private String boFldTyp;
	private String grndCover;
	private String pcentCover;
	private String patternGrn;
	private String patArea;
	private String notes;
	
	public EnvironSurficialEntity(){
		this.stationId = "";
		this.drainage = "";
		this.slope = "";
		this.aspect = "";
		this.pfPresent = "";
		this.pfIndic = "";
		this.pfDepth = "";
		this.gossanPres = "";
		this.gossanMat = "";
		this.bRock = "";
		this.exposure = "";
		this.vegetation = "";
		this.boulders = "";
		this.bouldFld = "";
		this.boFldTyp = "";
		this.grndCover = "";
		this.pcentCover = "";
		this.patternGrn = "";
		this.patArea = "";
		this.notes = "";
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues[0]);
		this.nrcanId2 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.drainage = contentValues[3];
		this.slope = contentValues[4];
		this.aspect = contentValues[5];
		this.pfPresent = contentValues[6];
		this.pfIndic = contentValues[7];
		this.pfDepth = contentValues[8];
		this.gossanPres = contentValues[9];
		this.gossanMat = contentValues[10];
		this.bRock = contentValues[11];
		this.exposure = contentValues[12];
		this.vegetation = contentValues[13];
		this.boulders = contentValues[14];
		this.bouldFld = contentValues[15];
		this.boFldTyp = contentValues[16];
		this.grndCover = contentValues[17];
		this.pcentCover = contentValues[18];
		this.patternGrn = contentValues[19];
		this.patArea = contentValues[20];
		this.notes = contentValues[21];
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
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getDrainage() {
		return drainage;
	}
	public void setDrainage(String drainage) {
		this.drainage = drainage;
	}
	public String getSlope() {
		return slope;
	}
	public void setSlope(String slope) {
		this.slope = slope;
	}
	public String getAspect() {
		return aspect;
	}
	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
	public String getPfPresent() {
		return pfPresent;
	}
	public void setPfPresent(String pfPresent) {
		this.pfPresent = pfPresent;
	}
	public String getPfIndic() {
		return pfIndic;
	}
	public void setPfIndic(String pfIndic) {
		this.pfIndic = pfIndic;
	}
	public String getPfDepth() {
		return pfDepth;
	}
	public void setPfDepth(String pfDepth) {
		this.pfDepth = pfDepth;
	}
	public String getGossanPres() {
		return gossanPres;
	}
	public void setGossanPres(String gossanPres) {
		this.gossanPres = gossanPres;
	}
	public String getGossanMat() {
		return gossanMat;
	}
	public void setGossanMat(String gossanMat) {
		this.gossanMat = gossanMat;
	}
	public String getbRock() {
		return bRock;
	}
	public void setbRock(String bRock) {
		this.bRock = bRock;
	}
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	public String getVegetation() {
		return vegetation;
	}
	public void setVegetation(String vegetation) {
		this.vegetation = vegetation;
	}
	public String getBoulders() {
		return boulders;
	}
	public void setBoulders(String boulders) {
		this.boulders = boulders;
	}
	public String getBouldFld() {
		return bouldFld;
	}
	public void setBouldFld(String bouldFld) {
		this.bouldFld = bouldFld;
	}
	public String getBoFldTyp() {
		return boFldTyp;
	}
	public void setBoFldTyp(String boFldTyp) {
		this.boFldTyp = boFldTyp;
	}
	public String getGrndCover() {
		return grndCover;
	}
	public void setGrndCover(String grndCover) {
		this.grndCover = grndCover;
	}
	public String getPcentCover() {
		return pcentCover;
	}
	public void setPcentCover(String pcentCover) {
		this.pcentCover = pcentCover;
	}
	public String getPatternGrn() {
		return patternGrn;
	}
	public void setPatternGrn(String patternGrn) {
		this.patternGrn = patternGrn;
	}
	public String getPatArea() {
		return patArea;
	}
	public void setPatArea(String patArea) {
		this.patArea = patArea;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
