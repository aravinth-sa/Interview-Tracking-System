package com.wipro.its.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.wipro.its.bean.CredentialsBean;
@Repository
public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		System.out.println("authenticating.....");
		Connection con = new DBUtilImpl().getDBConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT USERID , PASSWORD FROM User_Credentials WHERE USERID=?");
			ps.setString(1, credentialsBean.getUserID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(2).equals(credentialsBean.getPassword())) {
					return true;
				} else
					return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public String authorize(String userID) {

		System.out.println("authorizing.....");
		Connection con = new DBUtilImpl().getDBConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT USERTYPE,Loginstatus FROM User_Credentials WHERE USERID=?");
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getInt(2));
				if (rs.getInt(2) == 0){
					System.out.println(rs.getString(1));
					return rs.getString(1);
				}
				else
					return "fail";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,
			int loginStatus) {
		
		System.out.println("changing login status to 1/0.....");
		Connection con = new DBUtilImpl().getDBConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE User_Credentials SET Loginstatus=? WHERE USERID=?");
			ps.setString(2, credentialsBean.getUserID());
			ps.setInt(1,loginStatus);
			if(ps.executeUpdate()!=0)
				return true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
		return false;
	}

}
