package com.son.dbmanager;

import java.sql.Connection; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
private static Connection conn;
	public Connection getConnection() throws Exception{
	Context initContext = new InitialContext();
	Context envContext = (Context)initContext.lookup("java:/comp/env");
	DataSource db = (DataSource)envContext.lookup("jdbc/diffkdl529");
	conn = db.getConnection();
	return conn;
	}
	public static Connection getConn() { return conn; }
	public DBManager() { conn=null; }
}
