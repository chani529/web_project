package com.son.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.son.dbmanager.DBManager;
import com.son.dto.BuyDto;

public class BuyDao {
	PreparedStatement pstmt;
	Connection conn;
	public int insertBuy(BuyDto buyDto){
			pstmt = null;
			int result=-1;
			ResultSet rset=null;
			String sql = "insert into buydb(mname,postcode,address,address1,sno,ono,num,bip) values (?,?,?,?,?,?,?,?)";
			String sql1 = "select last_insert_id()";
			try{
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buyDto.getMname());
			pstmt.setString(2, buyDto.getPostcode());
			pstmt.setString(3, buyDto.getAddress());
			pstmt.setString(4, buyDto.getAddress1());
			pstmt.setInt(5, buyDto.getSno());
			pstmt.setInt(6, buyDto.getOno());
			pstmt.setInt(7, buyDto.getNum());
			pstmt.setString(8, buyDto.getBip());
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql1);
			rset= pstmt.executeQuery();
			if(rset.next()) {
				result=rset.getInt(1);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
				if(conn!=null) {try{conn.close();}catch(Exception e) {}}
			}
			return result;
	}
	public ArrayList<BuyDto> selectAll(BuyDto buyDto){
		ArrayList<BuyDto> list = new ArrayList<BuyDto>();
		pstmt = null;
		ResultSet rset=null;
		String sql = "select * from buydb where mname=? order by bdate desc";
		try{
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, buyDto.getMname());
		rset= pstmt.executeQuery();
		while(rset.next()) {
			list.add(new BuyDto(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5),
					rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9), rset.getString(10)));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try{pstmt.close();}catch(Exception e) {}}
			if(conn!=null) {try{conn.close();}catch(Exception e) {}}
		}
		return list;
}
}
