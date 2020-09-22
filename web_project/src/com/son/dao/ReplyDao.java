package com.son.dao;

import java.net.InetAddress; 
import java.sql.*;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.ReplyDto;


public class ReplyDao {
PreparedStatement pstmt;
Connection conn;
public ArrayList<ReplyDto> listAll(){
	ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
	ResultSet rset = null;
	String sql = "select * from mvcboard8 order by bstep desc , bindent asc";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			list.add(new ReplyDto(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6),rset.getString(7),rset.getInt(8),rset.getInt(9),rset.getInt(10)));
		}
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return list;
}
public int listCnt() {
	ResultSet rset = null;
	String sql = "select count(*) from mvcboard8";
	int result = -1;
	
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rset.getInt(1);
		}
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public ArrayList<ReplyDto> list10(int first){
	ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
	ResultSet rset = null;
	String sql = "select * from mvcboard8 order by bstep desc , bindent asc limit ?, 10";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, first);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			list.add(new ReplyDto(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6),rset.getString(7),rset.getInt(8),rset.getInt(9),rset.getInt(10)));
		}
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return list;
}
public ReplyDto selectBno(int bno){
	ReplyDto dto = null;
	ResultSet rset = null;
	String sql = "select * from mvcboard8 where bno = ?";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			dto = new ReplyDto(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6),rset.getString(7),rset.getInt(8),rset.getInt(9),rset.getInt(10));
		}
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(rset!=null) {try{rset.close();}catch(Exception e) {}}
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return dto;
}
public int create(ReplyDto dto){
	String sql = "insert into mvcboard8 (bname, btitle, bcontent, bip, bgroup, bstep) values (?,?,?,?,?,?)";
	int result  = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, dto.getBname());
		pstmt.setString(2, dto.getBtitle());
		pstmt.setString(3, dto.getBcontent());
		pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
		pstmt.setInt(5, dto.getBgroup());
		pstmt.setInt(6, dto.getBstep());
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int re_create(ReplyDto dto){
	String sql = "insert into mvcboard8 (bname, btitle, bcontent , bip , bgroup , bstep , bindent) values(?,?,?,?,?,?,?)";
	int result  = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, dto.getBname());
		pstmt.setString(2, dto.getBtitle());
		pstmt.setString(3, dto.getBcontent());
		pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
		pstmt.setInt(5, dto.getBgroup());
		pstmt.setInt(6, dto.getBstep());
		pstmt.setInt(7, dto.getBindent());
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int update(ReplyDto dto) {
	String sql = "update mvcboard8 set btitle = ?, bcontent=? where bno=?";
	int result  = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(3, dto.getBno());
		pstmt.setString(1, dto.getBtitle());
		pstmt.setString(2, dto.getBcontent());
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int delete(int bno) {
	String sql = "delete from mvcboard8 where bno=?";
	int result  = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int updateBhit(int bno) {
	String sql = "update mvcboard8 set bhit= bhit+1 where bno=?";
	int result  = 0;
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
public int max_read() {
		int result=-1;
		ResultSet rset = null;
		String sql = "select max(bstep) from mvcboard8";
		try {
			DBManager db = new DBManager();
			conn=db.getConnection();
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result=	rset.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
}
public int bstepUpdate(int first, int bstep) {
	int result=-1;
	String sql = "update mvcboard8 set bstep = bstep -1 where bstep > ? and bstep < ?";
	try {
		DBManager db = new DBManager();
		conn=db.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,first);
		pstmt.setInt(2,bstep);
		result = pstmt.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	finally {
		if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
		if(conn!=null) {try{conn.close();}catch(Exception e) {}}
	}
	return result;
}
}
