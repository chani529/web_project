package com.son.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.CategoryDto;

public class CategoryDao {
	PreparedStatement pstmt;
	Connection conn;
	public ArrayList<String> selectCategory(String category){
		ArrayList<String> list = new ArrayList<String>();
			pstmt = null;
			ResultSet rset = null;
			String sql = "select distinct sub_category from category where category = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
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
	public ArrayList<String> selectSubCategory(String sub_category){
		ArrayList<String> list = new ArrayList<String>();
			pstmt = null;
			ResultSet rset = null;
			String sql = "select sub_sub_category from category where sub_category = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub_category);
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
	public int getCno(String category,String sub_category,String sub_sub_category){
			pstmt = null;
			int result = -1;
			ResultSet rset = null;
			String sql = "select cno from category where category = ? and sub_category = ? and sub_sub_category = ?";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, sub_category);
			pstmt.setString(3, sub_sub_category);
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
	public CategoryDto getCategory(int cno) {
		CategoryDto dto=null;
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from category where cno=?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cno);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			dto = new CategoryDto(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
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
	public ArrayList<String> listAll(){
		ArrayList<String> list = new ArrayList<String>();
			pstmt = null;
			ResultSet rset = null;
			String sql = "select sub_sub_category from category order by cno";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	public int crawlingCno(String sub_sub_category){
		pstmt = null;
		int result = -1;
		ResultSet rset = null;
		String sql = "select cno from category where sub_sub_category = ?";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sub_sub_category);
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
}
