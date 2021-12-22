package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.atm.connection.Connect;
import com.atm.impl.Loginimpl;
import com.atm.models.Loginmodel;

import jakarta.servlet.http.HttpServlet;

public class Logindetailsdao implements Loginimpl {
	// Remove Account:
	public int removelogindetail(Loginmodel loginpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "delete from login where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, loginpojo.getUsername());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

	// Insert Data in to login table:
	public void insertdata(Loginmodel loginpojo) throws Exception {

		Connection con = Connect.getConnection();

		String query = "insert into login(username,role) values(?,?)";
		String query1 = "commit";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, loginpojo.getUsername());
		st.setString(2, loginpojo.getRole());
		int res = st.executeUpdate();
		st.executeUpdate(query1);
		if (res > 0) {
			System.out.println(res + " is affected!!");
		}
		
	}
	
	//fetch login details:
	public ResultSet fetchlogin()throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from login";
		Statement statement = con.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		
		
		return rSet;
	}

}
