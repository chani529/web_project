package com.son.dto;

public class CartDto {
private String simage;
private String sname;
private int sdelivery;
private String option_content;
private int option_price;
private int num;
private int indexId;
@Override
public String toString() {
	return "CartDto [simage=" + simage + ", sname=" + sname + ", sdelivery=" + sdelivery + ", option_content="
			+ option_content + ", option_price=" + option_price + ", num=" + num + ", indexId=" + indexId + "]";
}
public String getSimage() {
	return simage;
}
public void setSimage(String simage) {
	this.simage = simage;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int getSdelivery() {
	return sdelivery;
}
public void setSdelivery(int sdelivery) {
	this.sdelivery = sdelivery;
}
public String getOption_content() {
	return option_content;
}
public void setOption_content(String option_content) {
	this.option_content = option_content;
}
public int getOption_price() {
	return option_price;
}
public void setOption_price(int option_price) {
	this.option_price = option_price;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getIndexId() {
	return indexId;
}
public void setIndexId(int indexId) {
	this.indexId = indexId;
}
public CartDto(String simage, String sname, int sdelivery, String option_content, int option_price, int num,
		int indexId) {
	super();
	this.simage = simage;
	this.sname = sname;
	this.sdelivery = sdelivery;
	this.option_content = option_content;
	this.option_price = option_price;
	this.num = num;
	this.indexId = indexId;
}
public CartDto() {
	super();
}

}
