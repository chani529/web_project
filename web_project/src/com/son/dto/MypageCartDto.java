package com.son.dto;

public class MypageCartDto {
	private int bno;
	private String simage;
	private String sname;
	private String option_content;
	private int bprice;
	private int num;
	private String bdate;
	private String address;
	private String address1;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getOption_content() {
		return option_content;
	}
	public void setOption_content(String option_content) {
		this.option_content = option_content;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
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
	@Override
	public String toString() {
		return "MypageCartDto [bno=" + bno + ", simage=" + simage + ", sname=" + sname + ", option_content="
				+ option_content + ", bprice=" + bprice + ", num=" + num + ", bdate=" + bdate + ", address=" + address
				+ ", address1=" + address1 + "]";
	}
	public MypageCartDto(int bno, String simage, String sname, String option_content, int bprice, int num, String bdate,
			String address, String address1) {
		super();
		this.bno = bno;
		this.simage = simage;
		this.sname = sname;
		this.option_content = option_content;
		this.bprice = bprice;
		this.num = num;
		this.bdate = bdate;
		this.address = address;
		this.address1 = address1;
	}
	public MypageCartDto() {
		super();
	}
	
}
