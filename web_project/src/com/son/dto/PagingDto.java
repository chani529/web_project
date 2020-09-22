package com.son.dto;
import java.util.ArrayList;

public class PagingDto {
private int pageTotal;
private int onPageLimit;
private int pageAll;
private int bottomList;
private int pno;
private int bottom_current;
private int bottom_start;
private int bottom_end;
private ArrayList<?> list;
@Override
public String toString() {
	return "PagingDto2 [pageTotal=" + pageTotal + ", onPageLimit=" + onPageLimit + ", pageAll=" + pageAll
			+ ", bottomList=" + bottomList + ", pno=" + pno + ", bottom_current=" + bottom_current + ", bottom_start="
			+ bottom_start + ", bottom_end=" + bottom_end + ", list=" + list + "]";
}
public int getPageTotal() {
	return pageTotal;
}
public void setPageTotal(int pageTotal) {
	this.pageTotal = pageTotal;
}
public int getOnPageLimit() {
	return onPageLimit;
}
public void setOnPageLimit(int onPageLimit) {
	this.onPageLimit = onPageLimit;
}
public int getPageAll() {
	return pageAll;
}
public void setPageAll(int pageAll) {
	this.pageAll = pageAll;
}
public int getBottomList() {
	return bottomList;
}
public void setBottomList(int bottomList) {
	this.bottomList = bottomList;
}
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public int getBottom_current() {
	return bottom_current;
}
public void setBottom_current(int bottom_current) {
	this.bottom_current = bottom_current;
}
public int getBottom_start() {
	return bottom_start;
}
public void setBottom_start(int bottom_start) {
	this.bottom_start = bottom_start;
}
public int getBottom_end() {
	return bottom_end;
}
public void setBottom_end(int bottom_end) {
	this.bottom_end = bottom_end;
}
public ArrayList<?> getList() {
	return list;
}
public void setList(ArrayList<?> list) {
	this.list = list;
}
public PagingDto(int pageTotal, int onPageLimit, int pageAll, int bottomList, int pno, int bottom_current,
		int bottom_start, int bottom_end, ArrayList<?> list) {
	super();
	this.pageTotal = pageTotal;
	this.onPageLimit = onPageLimit;
	this.pageAll = pageAll;
	this.bottomList = bottomList;
	this.pno = pno;
	this.bottom_current = bottom_current;
	this.bottom_start = bottom_start;
	this.bottom_end = bottom_end;
	this.list = list;
}
public PagingDto() {
	super();
}


}
