package com.son.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.son.dbmanager.DBManager;

public class StoreConDao {
	PreparedStatement pstmt;
	Connection conn;
	public int insertContent(int sno,String scontent) {
		int result=-1;
		pstmt = null;
		String sql = "insert into store_content value(?,?)";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		pstmt.setString(2, scontent);
		result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public String getContent(int sno){
			String result=null;
			pstmt = null;
			ResultSet rset = null;
			String sql = "select scontent from store_content where sno = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getString(1);
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
}
