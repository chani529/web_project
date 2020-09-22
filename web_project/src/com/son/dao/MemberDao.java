package com.son.dao;

import java.net.InetAddress;  
import java.sql.*;
import com.son.dbmanager.DBManager;
import com.son.dto.MemberDto;


public class MemberDao {
	PreparedStatement pstmt;
	Connection conn;
	public int foreignJoin(MemberDto dto) {
		int result =-1;
		InetAddress local =null; 
		String sql = "insert into mvcmember3 (mname,memail,mip,mimage,foreignid) values (?,?,?,?,?)";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		local = InetAddress.getLocalHost();
		String mip = local.getHostAddress();
		pstmt.setString(1, dto.getMname());
		pstmt.setString(2, dto.getMemail());
		pstmt.setString(3, mip);
		pstmt.setString(4, dto.getMimage());
		pstmt.setString(5, dto.getForeignid());
		result = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
				if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	
	public int doubleEmail(String email) {
		int result=-1;
		pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from mvcmember3 where memail= ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		rset = pstmt.executeQuery();
		if(rset.next()) {
				result = rset.getInt(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public int doubleMname(String mname) {
		int result=-1;
		pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from mvcmember3 where mname= ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		rset = pstmt.executeQuery();
		if(rset.next()) {
				result = rset.getInt(1);
				System.out.println(result);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	
	public String foreignidChk(String foreignid) {
		pstmt = null;
		ResultSet rset = null;
		String result = null;
		String sql = "select count(*),mname from mvcmember3 where foreignid= ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, foreignid);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			if(rset.getInt(1)==1) {result = rset.getString(2);}else {
				result=null;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public int joinAction(MemberDto dto) {
		pstmt = null;
		InetAddress local =null; 
		int result =0;
		String sql = "insert into mvcmember3 (mname,mpass,memail,mip) values (?,?,?,?)";
		
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		local = InetAddress.getLocalHost();
		String mip = local.getHostAddress();
		pstmt.setString(1, dto.getMname());
		pstmt.setString(2, dto.getMpass());
		pstmt.setString(3, dto.getMemail());
		pstmt.setString(4, mip);
		result = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
				if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	
	public MemberDto selectMname(String mname) {
		MemberDto dto = new MemberDto();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from mvcmember3 where mname= ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			dto.setMname(rset.getString("mname"));
			dto.setMemail(rset.getString("memail"));
			dto.setMdate(rset.getString("mdate"));
			dto.setMbirthday(rset.getString("mbirthday"));
			dto.setMintro(rset.getString("mintro"));
			dto.setMpass(rset.getString("mpass"));
			dto.setMimage(rset.getString("mimage"));
			dto.setForeignid(rset.getString("foreignid"));
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
	public String login(String memail,String mpass) {
		pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*),mname from mvcmember3 where memail= ? and mpass = ?";
		String mname=null;
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memail);
		pstmt.setString(2, mpass);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			if(rset.getString(1).equals("1")){
				mname= rset.getString(2);
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return mname;
	}
	public int pass_change(String mname,String mpass,String mpassChange) {
		pstmt = null;
		String sql = "update mvcmember3 set mpass=? where mname=? and mpass=?";
		int result = 0;
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mpassChange);
		pstmt.setString(2, mname);
		pstmt.setString(3, mpass);
		result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public int editAction(MemberDto dto,String session_mname) {
		int result =0;
		pstmt = null;
		String sql = "update mvcmember3 set mname = ? , mintro = ? ,mimage=? ,mbirthday=? where mname = ?";
		String mname = dto.getMname();
		String mintro = dto.getMintro();
		String mimage = dto.getMimage();
		String mbirthday = dto.getMbirthday();
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		pstmt.setString(2, mintro);
		pstmt.setString(3, mimage);
		pstmt.setString(4, mbirthday);
		pstmt.setString(5, session_mname);
		result = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public int mnameChk(String mname) {
		int result = -1;
		pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from mvcmember3 where mname = ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		rset= pstmt.executeQuery();
		if(rset.next()) {
			result =rset.getInt(1);	
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public int passChkAction(String mname,String mpass) {
		int result =0;
		pstmt = null;
		String sql = "select count(*) from mvcmember3 where mname = ? and mpass= ?";
		ResultSet rset= null;
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		pstmt.setString(2, mpass);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			result = rset.getInt(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	
	public int deleteAction(String mname, String mpass) {
		int result =-1;
		pstmt = null;
		String sql = "delete from mvcmember3 where mname = ? and mpass = ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		pstmt.setString(2, mpass);
		result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public String getMimage(String mname) {
		ResultSet rset=null;
		pstmt = null;
		String sql = "select mimage from mvcmember3 where mname = ?";
		String mimage = null;
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mname);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			mimage= rset.getString(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try{rset.close();}catch(Exception e) {}}
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return mimage;
	}
}
