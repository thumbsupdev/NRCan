package com.nrcan.entities;

public class SoilProSurficialEntity {
	private int nrcanId3;
	private int nrcanId2;
	private String soilProId;
	private String stationId;
	private String o_hrz;
	private String a_hrz;
	private String b_hrz;
	private String c_hrz;
	private String r_hrz;
	private String l_f_h;
	private String oQualifier;
	private String aQualifier;
	private String bQualifier;
	private String cQualifier;
	private String rQualifier;
	private String l_f_HQuali;
	private String totThick;
	private String aTop;
	private String bTop;
	private String cTop;
	private String rTop;
	private String notes;
	private String id;
	
	public SoilProSurficialEntity(){
		
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues[0]);
		this.nrcanId2 = Integer.parseInt(contentValues[1]);
		this.soilProId = contentValues[2];
		this.stationId = contentValues[3];
		this.o_hrz = contentValues[4];
		this.a_hrz = contentValues[5];
		this.b_hrz = contentValues[6];
		this.c_hrz = contentValues[7];
		this.r_hrz = contentValues[8];
		this.l_f_h = contentValues[9];
		this.oQualifier = contentValues[10];
		this.aQualifier = contentValues[11];
		this.bQualifier = contentValues[12];
		this.cQualifier = contentValues[13];
		this.rQualifier = contentValues[14];
		this.l_f_HQuali = contentValues[15];
		this.totThick = contentValues[16];
		this.aTop = contentValues[17];
		this.bTop = contentValues[18];
		this.cTop = contentValues[19];
		this.rTop = contentValues[20];
		this.notes = contentValues[21];
		this.id = contentValues[22];
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
	public String getSoilProId() {
		return soilProId;
	}
	public void setSoilProId(String soilProId) {
		this.soilProId = soilProId;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getO_hrz() {
		return o_hrz;
	}
	public void setO_hrz(String o_hrz) {
		this.o_hrz = o_hrz;
	}
	public String getA_hrz() {
		return a_hrz;
	}
	public void setA_hrz(String a_hrz) {
		this.a_hrz = a_hrz;
	}
	public String getB_hrz() {
		return b_hrz;
	}
	public void setB_hrz(String b_hrz) {
		this.b_hrz = b_hrz;
	}
	public String getC_hrz() {
		return c_hrz;
	}
	public void setC_hrz(String c_hrz) {
		this.c_hrz = c_hrz;
	}
	public String getR_hrz() {
		return r_hrz;
	}
	public void setR_hrz(String r_hrz) {
		this.r_hrz = r_hrz;
	}
	public String getL_f_h() {
		return l_f_h;
	}
	public void setL_f_h(String l_f_h) {
		this.l_f_h = l_f_h;
	}
	public String getoQualifier() {
		return oQualifier;
	}
	public void setoQualifier(String oQualifier) {
		this.oQualifier = oQualifier;
	}
	public String getaQualifier() {
		return aQualifier;
	}
	public void setaQualifier(String aQualifier) {
		this.aQualifier = aQualifier;
	}
	public String getbQualifier() {
		return bQualifier;
	}
	public void setbQualifier(String bQualifier) {
		this.bQualifier = bQualifier;
	}
	public String getcQualifier() {
		return cQualifier;
	}
	public void setcQualifier(String cQualifier) {
		this.cQualifier = cQualifier;
	}
	public String getrQualifier() {
		return rQualifier;
	}
	public void setrQualifier(String rQualifier) {
		this.rQualifier = rQualifier;
	}
	public String getL_f_HQuali() {
		return l_f_HQuali;
	}
	public void setL_f_HQuali(String l_f_HQuali) {
		this.l_f_HQuali = l_f_HQuali;
	}
	public String getTotThick() {
		return totThick;
	}
	public void setTotThick(String totThick) {
		this.totThick = totThick;
	}
	public String getaTop() {
		return aTop;
	}
	public void setaTop(String aTop) {
		this.aTop = aTop;
	}
	public String getbTop() {
		return bTop;
	}
	public void setbTop(String bTop) {
		this.bTop = bTop;
	}
	public String getcTop() {
		return cTop;
	}
	public void setcTop(String cTop) {
		this.cTop = cTop;
	}
	public String getrTop() {
		return rTop;
	}
	public void setrTop(String rTop) {
		this.rTop = rTop;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
