package com.son.dto;

public class BuyDto {
	
private int bno;
private String mname;
private String postcode;
private String address;
private String address1;
private int sno;
private int ono;
private int num;
private String bdate;
private String bip;
@Override
public String toString() {
	return "BuyDto [bno=" + bno + ", mname=" + mname + ", postcode=" + postcode + ", address=" + address + ", address1="
			+ address1 + ", sno=" + sno + ", ono=" + ono + ", num=" + num + ", bdate=" + bdate + ", bip=" + bip + "]";
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getPostcode() {
	return postcode;
}
public void setPostcode(String postcode) {
	this.postcode = postcode;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getOno() {
	return ono;
}
public void setOno(int ono) {
	this.ono = ono;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
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
public BuyDto(int bno, String mname, String postcode, String address, String address1, int sno, int ono, int num,
		String bdate, String bip) {
	super();
	this.bno = bno;
	this.mname = mname;
	this.postcode = postcode;
	this.address = address;
	this.address1 = address1;
	this.sno = sno;
	this.ono = ono;
	this.num = num;
	this.bdate = bdate;
	this.bip = bip;
}
public BuyDto() {
	super();
}

}
