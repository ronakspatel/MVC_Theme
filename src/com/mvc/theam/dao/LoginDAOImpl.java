package com.mvc.theam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.theam.model.Login;
import com.mvc.theam.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAOi{

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean loginAuth(Login l) {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select username from login where username = ? and password = ?");
			ps.setString(1, l.getUserName());
			ps.setString(2, l.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
