package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

import com.atm.models.UsernamePasswordModel;
import com.atm.util.ConnectionUtil;

public class UsernamePasswordImpl implements com.atm.dao.UsernamePasswordDao {
	Scanner sc = new Scanner(System.in);

	// Get Role:
	public String getrole(UsernamePasswordModel usernamepasspojo) throws Exception {

		String role = null;
		Connection con = ConnectionUtil.getConnection();

//		String query = "select * from usernamepassword where username in ? and password in ?";
//		PreparedStatement st = con.prepareStatement(query);
		String query = "{call bank.getrole(?,?,?)}";
		CallableStatement st = con.prepareCall(query);
		st.setString(1, usernamepasspojo.getUsername());
		st.setString(2, usernamepasspojo.getPassword());
		st.registerOutParameter(3, Types.VARCHAR);
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			role = rs.getString(5);
//
//		}
		st.execute();
		 role = st.getString(3);
		System.out.println(role);

		return role;
	}

	// get role1:
	public String getrole1(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		String query = "select role from usernamepassword where username in ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, usernamepasspojo.getUsername());
		ResultSet rs = st.executeQuery();
		rs.next();
		String res = rs.getString(1);
		return res;
	}

	// password change:
	public int pinchange(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "update usernamepassword set password = ? where username in ?";
//		String query1 = "commit";
		String query = "{call bank.passchange(?,?,?)}";
		CallableStatement statement = con.prepareCall(query);
//		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getPassword());
		statement.setString(2, usernamepasspojo.getUsername());
		statement.registerOutParameter(3, Types.INTEGER);
		statement.execute();
		int i = statement.getInt(3);

//		statement.executeUpdate(query1);
		return i;
	}

	// insert User name password:
	public int insusernamepass(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		
		String query = "{call bank.insertusernamepass(?,?,?,?)}";
		CallableStatement statement = con.prepareCall(query);

//		String query = "insert into usernamepassword(username,password,role) values(?,?,?)";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		statement.setString(2, usernamepasspojo.getPassword());
		statement.setString(3, usernamepasspojo.getRole());
		statement.registerOutParameter(4, Types.INTEGER);
		statement.execute();
		int i = statement.getInt(4);
		return i;
	}

	// remove account:
	public int removeuser(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "delete from usernamepassword where username in ?";
//		String query1 = "commit";
		String query = "{call bank.removeuser(?,?)}";
		CallableStatement statement = con.prepareCall(query);
		
//		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int i = statement.getInt(2);
		
		return i;
	}
}
