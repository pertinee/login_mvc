package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	public static final String DBDRIVER = "com.MySQL.jdbc.Driver";
	public static final String DBURL = "jdbc:MySQL://localhost:3306/books";
	public static final String DBUSER = "root";
	public static final String DBPASS = "";
	private Connection conn = null;
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConn() {
		return conn;
	}
	
	public void close() {
		if (this.conn!=null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
}
