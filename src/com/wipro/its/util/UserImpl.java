package com.wipro.its.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wipro.its.bean.CredentialsBean;
@Service
public class UserImpl implements User {

	
	AuthenticationImpl authenticationImpl=new AuthenticationImpl();

	@Override
	public String login(CredentialsBean credentialsBean) {
		boolean auth = authenticationImpl.authenticate(credentialsBean);

		if (auth == (true)) {
			String utype = authenticationImpl.authorize(credentialsBean.getUserID());
			if (utype.equals("fail")) {
				return "logged";
			} else {
				authenticationImpl.changeLoginStatus(credentialsBean, 1);
				System.out.println("^^^^" + utype);
				return utype;
			}

		}
		if (auth == (false)) {
			return "INVALID";
		}
		return null;
	}

	@Override
	public boolean logout(String userId) {
		System.out.println("changing logout status.....");
		Connection con = new DBUtilImpl().getDBConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT loginstatus FROM User_Credentials WHERE USERID=?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 1) {
					CredentialsBean cb=new CredentialsBean();
					cb.setUserID(userId);
					return authenticationImpl.changeLoginStatus(cb, 0);
				} else
					return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {
		
			Connection con = new DBUtilImpl().getDBConnection();
			try {
				PreparedStatement ps = con
						.prepareStatement("UPDATE User_Credentials set password=? where userid=? ");
				ps.setString(1, newPassword);
				ps.setString(2, credentialsBean.getUserID());
				if(ps.executeUpdate()!=0)
					return "SUCCESS";
				else
					return "FAIL";
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			

			return null;
	
	}

}
