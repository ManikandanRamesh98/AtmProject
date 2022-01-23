package com.atm.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.atm.models.UsernamePasswordModel;
import com.atm.util.ConnectionUtil;

public class UsernamePasswordImpl implements com.atm.dao.UsernamePasswordDao {
	Scanner sc = new Scanner(System.in);

	// Get Role:
	public String getrole(UsernamePasswordModel usernamepasspojo) throws SQLException {

		String role = null;
		Connection con = null;
		PreparedStatement statement = null; 
		try {
			con = ConnectionUtil.getConnection();
			String query = "select role from usernamepassword where username in ? and password in ?";
			 statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUsername());
			statement.setString(2, usernamepasspojo.getPassword());
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				role = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return role;
	}

	
	// password change:
	public int pinchange(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "update usernamepassword set password = ? where username in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getPassword());
			statement.setString(2, usernamepasspojo.getUsername());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return res;
	}

	// insert User name password:
	public int insusernamepass(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into usernamepassword(username,password,role) values(?,?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUsername());
			statement.setString(2, usernamepasspojo.getPassword());
			statement.setString(3, usernamepasspojo.getRole());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return res;
	}

	// remove account:
	public int removeuser(UsernamePasswordModel usernamepasspojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from usernamepassword where username in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, usernamepasspojo.getUsername());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				}
				if(con != null) {
					con.close();
				}
			}
		return res;
	}
}
