package com.nrcan.entities;

public class PhotoEntity {
	private int nrcanId3;
	private int nrcanId2;
	private String stationId;
	private String photoId;
	private String photoNo;
	private String category;
	private String fileNo;
	private String fileName;
	private String direction;
	private String caption;
	private String linkId;
	
	public PhotoEntity(){
		this.stationId = "";
		this.photoId = "";
		this.photoNo = "";
		this.category = "";
		this.fileNo = "";
		this.fileName = "";
		this.direction = "";
		this.caption = "";
		this.linkId = "";
	}
	
	public void setEntity (String[] contentValues) {
		this.nrcanId3 = Integer.parseInt(contentValues[0]);
		this.nrcanId2 = Integer.parseInt(contentValues[1]);
		this.stationId = contentValues[2];
		this.photoId = contentValues[3];
		this.photoNo = contentValues[4];
		this.category = contentValues[5];
		this.fileNo = contentValues[6];
		this.fileName = contentValues[7];
		this.direction = contentValues[8];
		this.caption = contentValues[9];
		this.linkId = contentValues[10];
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
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(String photoNo) {
		this.photoNo = photoNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

}
