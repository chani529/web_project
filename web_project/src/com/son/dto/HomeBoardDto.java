package com.son.dto;

public class HomeBoardDto {
private int bno;
private int residence;
private int realArea;
private int expertise;
private String family;
private String btitle;
private String bcontent;
private int bhit;
private String bdate;
private String bip;
private String bfile;
private String mname;
private String mimage;
@Override
public String toString() {
	return "HomeBoardDto [bno=" + bno + ", residence=" + residence + ", realArea=" + realArea + ", expertise="
			+ expertise + ", family=" + family + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bhit=" + bhit
			+ ", bdate=" + bdate + ", bip=" + bip + ", bfile=" + bfile + ", mname=" + mname + ", mimage=" + mimage
			+ "]";
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public int getResidence() {
	return residence;
}
public void setResidence(int residence) {
	this.residence = residence;
}
public int getRealArea() {
	return realArea;
}
public void setRealArea(int realArea) {
	this.realArea = realArea;
}
public int getExpertise() {
	return expertise;
}
public void setExpertise(int expertise) {
	this.expertise = expertise;
}
public String getFamily() {
	return family;
}
public void setFamily(String family) {
	this.family = family;
}
public String getBtitle() {
	return btitle;
}
public void setBtitle(String btitle) {
	this.btitle = btitle;
}
public String getBcontent() {
	return bcontent;
}
public void setBcontent(String bcontent) {
	this.bcontent = bcontent;
}
public int getBhit() {
	return bhit;
}
public void setBhit(int bhit) {
	this.bhit = bhit;
}
public String getBdate() {
	return bdate;
}
public void setBdate(String bdate) {
	this.bdate = bdate;
}
public String getBip() {
	return bip;
}
public void setBip(String bip) {
	this.bip = bip;
}
public String getBfile() {
	return bfile;
}
public void setBfile(String bfile) {
	this.bfile = bfile;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMimage() {
	return mimage;
}
public void setMimage(String mimage) {
	this.mimage = mimage;
}
public HomeBoardDto(int bno, int residence, int realArea, int expertise, String family, String btitle, String bcontent,
		int bhit, String bdate, String bip, String bfile, String mname, String mimage) {
	super();
	this.bno = bno;
	this.residence = residence;
	this.realArea = realArea;
	this.expertise = expertise;
	this.family = family;
	this.btitle = btitle;
	this.bcontent = bcontent;
	this.bhit = bhit;
	this.bdate = bdate;
	this.bip = bip;
	this.bfile = bfile;
	this.mname = mname;
	this.mimage = mimage;
}
public HomeBoardDto() {
	super();
}

}
