package com.atm.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.atm.dao.LoginDetailsDao;
import com.atm.models.LoginDetailsModel;
import com.atm.util.ConnectionUtil;

import jakarta.servlet.http.HttpServlet;

public class LoginDetailsImpl implements LoginDetailsDao {
	// Remove Account:
	public int removelogindetail(LoginDetailsModel loginpojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "delete from login where username in ?";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setString(1, loginpojo.getUsername());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
		String query = "{call bank.removelogindetails(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, loginpojo.getUsername());
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(2);
		return res;
	}

	// Insert Data in to login table:
	public int insertdata(LoginDetailsModel loginpojo) throws Exception {

		Connection con = ConnectionUtil.getConnection();

//		String query = "insert into login(username,role) values(?,?)";
//		String query1 = "commit";
//		PreparedStatement st = con.prepareStatement(query);
//		st.setString(1, loginpojo.getUsername());
//		st.setString(2, loginpojo.getRole());
//		int res = st.executeUpdate();
//		st.executeUpdate(query1);
//		if (res > 0) {
//			System.out.println(res + " is affected!!");
//		}
		
		String query = "{call bank.insertlogindetails(?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, loginpojo.getUsername());
		statement.setString(2, loginpojo.getRole());
		statement.registerOutParameter(3, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(3);
		return res;
		
	}
	
	//fetch login details:
	public ResultSet fetchlogin()throws Exception {
		Connection con = ConnectionUtil.getConnection();

		String query = "select id,username,substr(logged_at,1,14),role from login order by logged_at desc";
		Statement statement = con.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		
		
		return rSet;
	}

}
