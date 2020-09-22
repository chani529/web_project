package com.son.dto;

public class ReplyDto {
	private int bno;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;
	private int bgroup;
	private int bstep;
	private int bindent;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
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
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	
	@Override
	public String toString() {
		return "MvcboardDto [bno=" + bno + ", bname=" + bname + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bdate=" + bdate + ", bhit=" + bhit + ", bip=" + bip + ", bgroup=" + bgroup + ", bstep=" + bstep
				+ ", bindent=" + bindent + "]";
	}
	public ReplyDto(int bno, String bname, String btitle, String bcontent, String bdate, int bhit, String bip,
			int bgroup, int bstep, int bindent) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bip = bip;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
	}
	public ReplyDto() {
		super();
	}
	
}
