package com.son.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.StoreDto;

public class StoreDao {
	PreparedStatement pstmt;
	Connection conn;
	public ArrayList<StoreDto> hitList() {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store order by shit desc limit 0,5";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	public ArrayList<StoreDto> cateHitList(String cate) {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store where cno = (select cno from category where sub_sub_category = ?) order by shit desc limit 0,5";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	
	public ArrayList<StoreDto> list12(int start) {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store order by sdate limit ?,12";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	public ArrayList<StoreDto> cateList12(String cate, int start) {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store where cno = (select cno from category where sub_sub_category = ?) order by sdate limit ?,12";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate);
			pstmt.setInt(2, start);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	public ArrayList<StoreDto> subCateList12(int start,String sub_sub_category) {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store where cno = (select cno from category where sub_sub_category = ?) order by sdate desc limit ?,12;";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub_sub_category);
			pstmt.setInt(2, start);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	
	public StoreDto selectSno(int sno) {
		StoreDto dto = null;
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store where sno= ?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				dto= new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return dto;
	}
	
	public ArrayList<StoreDto> searchList(String search,int start) {
		ArrayList<StoreDto> list = new ArrayList<StoreDto>();
		pstmt = null;
		ResultSet rset = null;
		String sql = "select * from store where sname like '%"+search+"%' limit ?,12";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new StoreDto(
						rset.getInt(1),rset.getString(2),rset.getString(3),
						rset.getInt(4),rset.getInt(5),rset.getString(6),
						rset.getInt(7),rset.getInt(8),rset.getString(9),
						rset.getInt(10),rset.getString(11),rset.getString(12),
						rset.getInt(13)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return list;
	}
	
	public int searchListCnt(String search) {
		pstmt = null;
		ResultSet rset = null;
		int result = -1;
		String sql = "select count(*) from store where sname like '%"+search+"%'";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return result;
	}
	
	public int insertStore(StoreDto dto) {
		int result = 0;
		ResultSet rset = null;
		pstmt = null;
		String sql = "insert into store(sname,pname,sprice,ssale,sdelivery,sip,simage,smaker,cno) values (?,?,?,?,?,?,?,?,? )";//////
		String sql1 = "select last_insert_id()";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getSprice());
			pstmt.setInt(4, dto.getSsale());
			pstmt.setInt(5,dto.getSdelivery());
			pstmt.setString(6,dto.getSip());
			pstmt.setString(7,dto.getSimage());
			pstmt.setString(8,dto.getSmaker());
			pstmt.setInt(9,dto.getCno());
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql1);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (Exception e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return result;
	}

	public int editAction(StoreDto dto) {
		int result = 0;
		pstmt = null;
		String sql = "update store set where ";//////

		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);//////
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return result;
	}
	
	public int hitUpdate(int sno) {
		int result = 0;
		pstmt = null;
		String sql = "update store set shit = shit + 1 where sno = ?";//////
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);//////
			pstmt.setInt(1, sno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return result;
	}
	
	public int deleteAction(int sno) {
		int result = 0;
		pstmt = null;
		String sql = "delete from store where sno = ?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (Exception e) { } }
			if (conn != null) { try { conn.close(); } catch (Exception e) { } }
		}
		return result;
	}
	
	public int crawlingInsertStore(StoreDto dto) {
		int result = 0;
		pstmt = null;
		String sql = "insert into store(sname,pname,sprice,ssale,sdelivery,sip,simage,smaker,cno,sno) values (?,?,?,?,?,?,?,?,?,? )";//////

		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getSprice());
			pstmt.setInt(4, dto.getSsale());
			pstmt.setInt(5,dto.getSdelivery());
			pstmt.setString(6,dto.getSip());
			pstmt.setString(7,dto.getSimage());
			pstmt.setString(8,dto.getSmaker());
			pstmt.setInt(9,dto.getCno());
			pstmt.setInt(10,dto.getSno());
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
