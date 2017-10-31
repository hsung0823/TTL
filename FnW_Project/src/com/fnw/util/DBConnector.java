package com.fnw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	
	public static Connection getConnect() throws Exception {
		//1로그인정보
		String user="library";
		String password="library";
		String url="jdbc:oracle:thin:@192.168.20.46:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//driver
		Class.forName(driver);
		
		//con
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		rs.close();
		st.close();
		con.close();
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();
	}
	
}
