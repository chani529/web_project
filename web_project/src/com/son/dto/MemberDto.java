package com.son.dto;

public class MemberDto {
	private int mno;
	private String mname;
	private String mpass;
	private String memail;
	private String mdate;
	private String mip;
	private String mbirthday;
	private String mintro;
	private String mimage;
	private String foreignid;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMip() {
		return mip;
	}
	public void setMip(String mip) {
		this.mip = mip;
	}
	public String getMbirthday() {
		return mbirthday;
	}
	public void setMbirthday(String mbirthday) {
		this.mbirthday = mbirthday;
	}
	public String getMintro() {
		return mintro;
	}
	public void setMintro(String mintro) {
		this.mintro = mintro;
	}
	public String getMimage() {
		return mimage;
	}
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	public String getForeignid() {
		return foreignid;
	}
	public void setForeignid(String foreignid) {
		this.foreignid = foreignid;
	}
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mname=" + mname + ", mpass=" + mpass + ", memail=" + memail + ", mdate="
				+ mdate + ", mip=" + mip + ", mbirthday=" + mbirthday + ", mintro=" + mintro + ", mimage=" + mimage
				+ ", foreignid=" + foreignid + "]";
	}
	public MemberDto(int mno, String mname, String mpass, String memail, String mdate, String mip, String mbirthday,
			String mintro, String mimage, String foreignid) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mpass = mpass;
		this.memail = memail;
		this.mdate = mdate;
		this.mip = mip;
		this.mbirthday = mbirthday;
		this.mintro = mintro;
		this.mimage = mimage;
		this.foreignid = foreignid;
	}
	public MemberDto() {
		super();
	}
}