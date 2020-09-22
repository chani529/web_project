package com.son.dto;

public class OptionDto {
private int sno;
private String option_name;
private String option_content;
private int option_price;
private int ono;
@Override
public String toString() {
	return "OptionDto [sno=" + sno + ", option_name=" + option_name + ", option_content=" + option_content
			+ ", option_price=" + option_price + ", ono=" + ono + "]";
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getOption_name() {
	return option_name;
}
public void setOption_name(String option_name) {
	this.option_name = option_name;
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
public int getOno() {
	return ono;
}
public void setOno(int ono) {
	this.ono = ono;
}
public OptionDto(int sno, String option_name, String option_content, int option_price, int ono) {
	super();
	this.sno = sno;
	this.option_name = option_name;
	this.option_content = option_content;
	this.option_price = option_price;
	this.ono = ono;
}
public OptionDto(int sno, String option_name, String option_content, int option_price) {
	super();
	this.sno = sno;
	this.option_name = option_name;
	this.option_content = option_content;
	this.option_price = option_price;
}
public OptionDto() {
	super();
}
}
