package com.son.dao;

import java.sql.*;  
import java.util.ArrayList;
import com.son.dbmanager.DBManager;
import com.son.dto.HomeBoardDto;

public class HomeBoardDao {
PreparedStatement pstmt;
ResultSet rset;
Connection conn;

public ArrayList<HomeBoardDto> list12(int pno) {
	ArrayList<HomeBoardDto> list = new ArrayList<HomeBoardDto>();
	String sql = "select * from homeboard order by bno desc limit ? , 12";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pno);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			list.add(new HomeBoardDto(rset.getInt(1), rset.getInt(2), rset.getInt(3),rset.getInt(4),
					rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getString(12),rset.getString(13)));
		}
	}catch(Exception e){e.printStackTrace();}finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return list;
}


public int listCnt() {
	String sql = "select count(*) from homeboard";
	int cnt = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		if(rset.next()) {
			cnt = rset.getInt(1);
		}
	}catch(Exception e){}finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	
	return cnt;
}
public ArrayList<HomeBoardDto> hitList(int pno) {
	ArrayList<HomeBoardDto> list = new ArrayList<HomeBoardDto>();
	String sql = "select * from homeboard order by bhit desc limit ? , 12";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pno);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			list.add(new HomeBoardDto(rset.getInt(1), rset.getInt(2), rset.getInt(3),rset.getInt(4),
					rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getString(12),rset.getString(13)));
		}
	}catch(Exception e){e.printStackTrace();}finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return list;
} 
public int writeAction(HomeBoardDto dto) {
	int result=0;
	String sql = "insert into homeboard (residence,realArea,expertise,family,btitle,bcontent,bip,bfile,mname,mimage) values (?,?,?,?,?,?,?,?,?,?)";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,dto.getResidence());
		pstmt.setInt(2,dto.getRealArea());
		pstmt.setInt(3,dto.getExpertise());
		pstmt.setString(4,dto.getFamily());
		pstmt.setString(5,dto.getBtitle());
		pstmt.setString(6,dto.getBcontent());
		pstmt.setString(7,dto.getBip());
		String bfile= dto.getBfile();
		if(bfile==null) {
			bfile="no.jpg";
		}
		pstmt.setString(8,bfile);
		String mname= dto.getMname();
		System.out.println(mname);
		pstmt.setString(9,mname);
		pstmt.setString(10,dto.getMimage());
		result = pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int updateBhit(int bno) {
	int result=0;
	String sql = "update homeboard set bhit = bhit+1 where bno=?";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,bno);
		result = pstmt.executeUpdate();
	}catch(Exception e){}finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public HomeBoardDto selectBno(int bno) {
	HomeBoardDto dto = null;
	String sql = "select * from homeboard where bno = ?";
	try {
		DBManager db=new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			dto=new HomeBoardDto(rset.getInt(1), rset.getInt(2), rset.getInt(3),rset.getInt(4),
					rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getString(12),rset.getString(13));
		}
	}catch(Exception e){e.printStackTrace();}finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return dto;
}

public int update(HomeBoardDto dto) {
	int result=0;
	String sql = "update homeboard set residence=?,realArea=?,expertise=?,family=?,btitle=?,bcontent=?,bfile=?  where bno=?";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getResidence());
		pstmt.setInt(2, dto.getRealArea());
		pstmt.setInt(3, dto.getExpertise());
		pstmt.setString(4, dto.getFamily());
		pstmt.setString(5, dto.getBtitle());
		pstmt.setString(6, dto.getBcontent());
		pstmt.setString(7, dto.getBfile());
		pstmt.setInt(8, dto.getBno());
		result = pstmt.executeUpdate();
	}catch(Exception e){}finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}

public int deleteAction(int bno) {
	int result = 0;
	pstmt = null;
	String sql = "delete from homeboard where bno = ?";
	try {
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		result = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
		if (conn != null) { try { conn.close(); } catch (Exception e) { } }
	}
	return result;
}
}
