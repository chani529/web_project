package com.son.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.OptionDto;

public class OptionDao {
	PreparedStatement pstmt;
	Connection conn;
	public ArrayList<String> getOptionName(int sno){
		ArrayList<String> list = new ArrayList<String>();
			pstmt = null;
			ResultSet rset = null;
			String sql = "select distinct option_name from option_table where sno = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(rset.getString(1));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rset!=null) {try{rset.close();}catch(Exception e) {}}
				if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
				if(conn!=null) {try{conn.close();}catch(Exception e) {}}
			}
			return list;
	}
	public ArrayList<OptionDto> getOptionContent(String option_name,int sno){
		ArrayList<OptionDto> list = new ArrayList<OptionDto>();
			pstmt = null;
			ResultSet rset = null;
			String sql = "select * from option_table where option_name = ? and sno = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, option_name);
			pstmt.setInt(2, sno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new OptionDto(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getInt(5)));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rset!=null) {try{rset.close();}catch(Exception e) {}}
				if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
				if(conn!=null) {try{conn.close();}catch(Exception e) {}}
			}
			return list;
	}
	public int insertOption(OptionDto dto){
		int result =-1;
		pstmt = null;
		String sql = "insert into option_table(sno,option_name,option_content,option_price) values(?,?,?,?)";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getSno());
		pstmt.setString(2, dto.getOption_name());
		pstmt.setString(3, dto.getOption_content());
		pstmt.setInt(4, dto.getOption_price());
		result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return result;
	}
	public OptionDto getOption(int ono){
		OptionDto dto = null;
			pstmt = null;
			ResultSet rset = null;
			String sql = "select * from option_table where ono = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ono);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				dto = new OptionDto(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getInt(5));
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
}
