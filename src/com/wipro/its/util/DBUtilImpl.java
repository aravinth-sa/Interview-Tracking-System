package com.wipro.its.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilImpl implements DBUtil{

	private static final String USERNAME="B42225334058";
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String PASSWORD="B42225334058";
	private static Connection con;
	
	@Override
	public Connection getDBConnection() {
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
