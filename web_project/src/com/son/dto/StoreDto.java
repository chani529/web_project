package com.son.dto;

public class StoreDto {
private int sno;
private String sname;
private String pname;
private int sprice;
private int ssale;
private String sdate;
private int sdelivery;
private int shit;
private String sip;
private int ssalecnt;
private String simage;
private String smaker;
private int cno;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getSprice() {
	return sprice;
}
public void setSprice(int sprice) {
	this.sprice = sprice;
}
public int getSsale() {
	return ssale;
}
public void setSsale(int ssale) {
	this.ssale = ssale;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public int getSdelivery() {
	return sdelivery;
}
public void setSdelivery(int sdelivery) {
	this.sdelivery = sdelivery;
}
public int getShit() {
	return shit;
}
public void setShit(int shit) {
	this.shit = shit;
}
public String getSip() {
	return sip;
}
public void setSip(String sip) {
	this.sip = sip;
}
public int getSsalecnt() {
	return ssalecnt;
}
public void setSsalecnt(int ssalecnt) {
	this.ssalecnt = ssalecnt;
}
public String getSimage() {
	return simage;
}
public void setSimage(String simage) {
	this.simage = simage;
}
public String getSmaker() {
	return smaker;
}
public void setSmaker(String smaker) {
	this.smaker = smaker;
}
public int getCno() {
	return cno;
}
public void setCno(int cno) {
	this.cno = cno;
}
@Override
public String toString() {
	return "StoreDto [sno=" + sno + ", sname=" + sname + ", pname=" + pname + ", sprice=" + sprice + ", ssale=" + ssale
			+ ", sdate=" + sdate + ", sdelivery=" + sdelivery + ", shit=" + shit + ", sip=" + sip + ", ssalecnt="
			+ ssalecnt + ", simage=" + simage + ", smaker=" + smaker + ", cno=" + cno + "]";
}
public StoreDto(int sno, String sname, String pname, int sprice, int ssale, String sdate, int sdelivery, int shit,
		String sip, int ssalecnt, String simage, String smaker, int cno) {
	super();
	this.sno = sno;
	this.sname = sname;
	this.pname = pname;
	this.sprice = sprice;
	this.ssale = ssale;
	this.sdate = sdate;
	this.sdelivery = sdelivery;
	this.shit = shit;
	this.sip = sip;
	this.ssalecnt = ssalecnt;
	this.simage = simage;
	this.smaker = smaker;
	this.cno = cno;
}
public StoreDto() {
	super();
}
}
