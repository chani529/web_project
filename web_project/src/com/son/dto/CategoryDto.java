package com.son.dto;

public class CategoryDto {
	private String category;
	private String sub_category;
	private String sub_sub_category;
	private int cno;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public String getSub_sub_category() {
		return sub_sub_category;
	}
	public void setSub_sub_category(String sub_sub_category) {
		this.sub_sub_category = sub_sub_category;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	@Override
	public String toString() {
		return "CategoryDto [category=" + category + ", sub_category=" + sub_category + ", sub_sub_category="
				+ sub_sub_category + ", cno=" + cno + "]";
	}
	public CategoryDto(String category, String sub_category, String sub_sub_category, int cno) {
		super();
		this.category = category;
		this.sub_category = sub_category;
		this.sub_sub_category = sub_sub_category;
		this.cno = cno;
	}
	public CategoryDto() {
		super();
	}
	
	
}
