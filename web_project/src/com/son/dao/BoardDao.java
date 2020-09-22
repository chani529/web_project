package com.son.dao;

import java.net.InetAddress;   
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.BoardDto;

public class BoardDao {
	Connection conn;
	PreparedStatement pstmt;
	
	public ArrayList<BoardDto> listAll(){
		ResultSet rset = null;
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "select * from mvcboard5 order by bdate desc";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int bno=Integer.parseInt(rset.getString("bno"));
				String bname=rset.getString("bname");
				String btitle=rset.getString("btitle");
				String bcontent=rset.getString("bcontent");
				String bdate=rset.getString("bdate");
				int bhit=Integer.parseInt(rset.getString("bhit"));
				String bip=rset.getString("bip");
				String btype = rset.getString("btype");
				list.add(new BoardDto(bno, bname, btitle,bcontent,bdate,bhit,bip,btype));
			}
		}catch(Exception e) {e.printStackTrace();}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return list;
	}
	public ArrayList<BoardDto> list10(int first){
		ResultSet rset = null;
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "select * from mvcboard5 order by bdate desc limit ?, 10";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, first);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int bno=Integer.parseInt(rset.getString("bno"));
				String bname=rset.getString("bname");
				String btitle=rset.getString("btitle");
				String bcontent=rset.getString("bcontent");
				String bdate=rset.getString("bdate");
				int bhit=Integer.parseInt(rset.getString("bhit"));
				String bip=rset.getString("bip");
				String btype = rset.getString("btype");
				list.add(new BoardDto(bno, bname, btitle,bcontent,bdate,bhit,bip,btype));
			}
		}catch(Exception e) {e.printStackTrace();}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return list;
	}
	public int listCnt() {
		int cnt=0;
		ResultSet rset = null;
		String sql = "select count(*) from mvcboard5";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cnt = Integer.parseInt(rset.getString(1));
			}
		}catch(Exception e) {e.printStackTrace();}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		
		
		return cnt;
	}
	public int write(BoardDto dto) {
		int result =0;
		String sql ="insert into mvcboard5 (bname, btitle, bcontent, bip, btype) values (?,?,?,?,?)";
		String bname = dto.getBname();
		String btitle = dto.getBtitle();
		String bcontent = dto.getBcontent();
		String btype = dto.getBtype();
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(5, btype);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
	 return result;
	}
	
	public BoardDto detail(int bno) {
		BoardDto dto= new BoardDto();
		ResultSet rset = null;
		String sql ="select * from mvcboard5 where bno =" + bno;
		dto.setBno(bno);
		try {
			DBManager db = new DBManager();			
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				dto.setBname(rset.getString("bname"));
				dto.setBtitle(rset.getString("btitle"));
				dto.setBcontent(rset.getString("bcontent"));
				dto.setBdate(rset.getString("bdate"));
				dto.setBhit(Integer.parseInt(rset.getString("bhit")));
				dto.setBtype(rset.getString("btype"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return dto;
	}
	
	public int addhit(int bno) {
		int result = 0;
		String sql ="update mvcboard5 set bhit = bhit + 1 where bno =" + bno;
		try {
			DBManager db = new DBManager();			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		
		return result;
	}
	
	public int update (BoardDto dto) {
		int result=0;
		DBManager db = new DBManager();
		String sql="update mvcboard5 set btitle = ?, bcontent = ?, btype= ?  where bno = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(4, dto.getBno());
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBtype());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	
	public int delete(int bno) {
		int result =0;
		ResultSet rset = null;
		DBManager db = new DBManager();
		String sql ="delete from mvcboard5 where bno =?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public BoardDao() {
		conn =null;
		pstmt = null;
	}
}
