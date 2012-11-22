package com.nrcan.entities;

public class EarthmatSurficialEntity {
	private int nrcanId4;
	private int nrcanId3;
	private String stationId;
	private String earthMatLt;
	private String earthMatNo;
	private String earthMatId;
	private String lithGroup;
	private String lithType;
	private String lithDetail;
	private String mapUnit;
	private String sufform;
	private String unitNo;
	private String matrixMod;
	private String matrix;
	private String jointing;
	private String compaction;
	private String oxidation;
	private String h2oContent;
	private String fissilty;
	private String hclReact;
	private String clastModal;
	private String clastMin;
	private String clastMax;
	private String clastPct;
	private String clastForm;
	private String sorting;
	private String modalRnd;
	private String maxRound;
	private String minRound;
	private String thickType;
	private String thickMin;
	private String thickMax;
	private String colour;
	private String lwrContact;
	private String intContact;
	private String latContact;
	private String erraticTyp;
	private String erraticPer;
	private String landForm;
	private String primeStruc;
	private String scndStruc;
	private String wayUp;
	private String notes;
	private String interp;
	private String interpConf;
	
	public EarthmatSurficialEntity(){
		this.stationId = "";
		this.earthMatLt = "";
		this.earthMatNo = "";
		this.earthMatId = "";
		this.lithGroup = "";
		this.lithType = "";
		this.lithDetail = "";
		this.mapUnit = "";
		this.sufform = "";
		this.unitNo = "";
		this.matrixMod = "";
		this.matrix = "";
		this.jointing = "";
		this.compaction = "";
		this.oxidation = "";
		this.h2oContent = "";
		this.fissilty = "";
		this.hclReact = "";
		this.clastModal = "";
		this.clastMin = "";
		this.clastMax = "";
		this.clastPct = "";
		this.clastForm = "";
		this.sorting = "";
		this.modalRnd = "";
		this.maxRound = "";
		this.minRound = "";
		this.thickType = "";
		this.thickMin = "";
		this.thickMax = "";
		this.colour = "";
		this.lwrContact = "";
		this.intContact = "";
		this.latContact = "";
		this.erraticTyp = "";
		this.erraticPer = "";
		this.landForm = "";
		this.primeStruc = "";
		this.scndStruc = "";
		this.wayUp = "";
		this.notes = "";
		this.interp = "";
		this.interpConf = "";
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId4 = Integer.parseInt(contentValues[0]);
		this.nrcanId3 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.earthMatLt = contentValues[3];
		this.earthMatNo = contentValues[4];
		this.earthMatId = contentValues[5];
		this.lithGroup = contentValues[6];
		this.lithType = contentValues[7];
		this.lithDetail = contentValues[8];
		this.mapUnit = contentValues[9];
		this.sufform = contentValues[10];
		this.unitNo = contentValues[11];
		this.matrixMod = contentValues[12];
		this.matrix = contentValues[13];
		this.jointing = contentValues[14];
		this.compaction = contentValues[15];
		this.oxidation = contentValues[16];
		this.h2oContent = contentValues[17];
		this.fissilty = contentValues[18];
		this.hclReact = contentValues[19];
		this.clastModal = contentValues[20];
		this.clastMin = contentValues[21];
		this.clastMax = contentValues[22];
		this.clastPct = contentValues[23];
		this.clastForm = contentValues[24];
		this.sorting = contentValues[25];
		this.modalRnd = contentValues[26];
		this.maxRound = contentValues[27];
		this.minRound = contentValues[28];
		this.thickType = contentValues[29];
		this.thickMin = contentValues[30];
		this.thickMax = contentValues[31];
		this.colour = contentValues[32];
		this.lwrContact = contentValues[33];
		this.intContact = contentValues[34];
		this.latContact = contentValues[35];
		this.erraticTyp = contentValues[36];
		this.erraticPer = contentValues[37];
		this.landForm = contentValues[38];
		this.primeStruc = contentValues[39];
		this.scndStruc = contentValues[40];
		this.wayUp = contentValues[41];
		this.notes = contentValues[42];
		this.interp = contentValues[43];
		this.interpConf = contentValues[44];
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
	public String getEarthMatLt() {
		return earthMatLt;
	}
	public void setEarthMatLt(String earthMatLt) {
		this.earthMatLt = earthMatLt;
	}
	public String getEarthMatNo() {
		return earthMatNo;
	}
	public void setEarthMatNo(String earthMatNo) {
		this.earthMatNo = earthMatNo;
	}
	public String getEarthMatId() {
		return earthMatId;
	}
	public void setEarthMatId(String earthMatId) {
		this.earthMatId = earthMatId;
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
	public String getSufform() {
		return sufform;
	}
	public void setSufform(String sufform) {
		this.sufform = sufform;
	}
	public String getUnitNo() {
		return unitNo;
	}
	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	public String getMatrixMod() {
		return matrixMod;
	}
	public void setMatrixMod(String matrixMod) {
		this.matrixMod = matrixMod;
	}
	public String getMatrix() {
		return matrix;
	}
	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}
	public String getJointing() {
		return jointing;
	}
	public void setJointing(String jointing) {
		this.jointing = jointing;
	}
	public String getCompaction() {
		return compaction;
	}
	public void setCompaction(String compaction) {
		this.compaction = compaction;
	}
	public String getOxidation() {
		return oxidation;
	}
	public void setOxidation(String oxidation) {
		this.oxidation = oxidation;
	}
	public String getH2oContent() {
		return h2oContent;
	}
	public void setH2oContent(String h2oContent) {
		this.h2oContent = h2oContent;
	}
	public String getFissilty() {
		return fissilty;
	}
	public void setFissilty(String fissilty) {
		this.fissilty = fissilty;
	}
	public String getHclReact() {
		return hclReact;
	}
	public void setHclReact(String hclReact) {
		this.hclReact = hclReact;
	}
	public String getClastModal() {
		return clastModal;
	}
	public void setClastModal(String clastModal) {
		this.clastModal = clastModal;
	}
	public String getClastMin() {
		return clastMin;
	}
	public void setClastMin(String clastMin) {
		this.clastMin = clastMin;
	}
	public String getClastMax() {
		return clastMax;
	}
	public void setClastMax(String clastMax) {
		this.clastMax = clastMax;
	}
	public String getClastPct() {
		return clastPct;
	}
	public void setClastPct(String clastPct) {
		this.clastPct = clastPct;
	}
	public String getClastForm() {
		return clastForm;
	}
	public void setClastForm(String clastForm) {
		this.clastForm = clastForm;
	}
	public String getSorting() {
		return sorting;
	}
	public void setSorting(String sorting) {
		this.sorting = sorting;
	}
	public String getModalRnd() {
		return modalRnd;
	}
	public void setModalRnd(String modalRnd) {
		this.modalRnd = modalRnd;
	}
	public String getMaxRound() {
		return maxRound;
	}
	public void setMaxRound(String maxRound) {
		this.maxRound = maxRound;
	}
	public String getMinRound() {
		return minRound;
	}
	public void setMinRound(String minRound) {
		this.minRound = minRound;
	}
	public String getThickType() {
		return thickType;
	}
	public void setThickType(String thickType) {
		this.thickType = thickType;
	}
	public String getThickMin() {
		return thickMin;
	}
	public void setThickMin(String thickMin) {
		this.thickMin = thickMin;
	}
	public String getThickMax() {
		return thickMax;
	}
	public void setThickMax(String thickMax) {
		this.thickMax = thickMax;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getLwrContact() {
		return lwrContact;
	}
	public void setLwrContact(String lwrContact) {
		this.lwrContact = lwrContact;
	}
	public String getIntContact() {
		return intContact;
	}
	public void setIntContact(String intContact) {
		this.intContact = intContact;
	}
	public String getLatContact() {
		return latContact;
	}
	public void setLatContact(String latContact) {
		this.latContact = latContact;
	}
	public String getErraticTyp() {
		return erraticTyp;
	}
	public void setErraticTyp(String erraticTyp) {
		this.erraticTyp = erraticTyp;
	}
	public String getErraticPer() {
		return erraticPer;
	}
	public void setErraticPer(String erraticPer) {
		this.erraticPer = erraticPer;
	}
	public String getLandForm() {
		return landForm;
	}
	public void setLandForm(String landForm) {
		this.landForm = landForm;
	}
	public String getPrimeStruc() {
		return primeStruc;
	}
	public void setPrimeStruc(String primeStruc) {
		this.primeStruc = primeStruc;
	}
	public String getScndStruc() {
		return scndStruc;
	}
	public void setScndStruc(String scndStruc) {
		this.scndStruc = scndStruc;
	}
	public String getWayUp() {
		return wayUp;
	}
	public void setWayUp(String wayUp) {
		this.wayUp = wayUp;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
