package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, loginpojo.getUsername());
		st.setString(2, loginpojo.getRole());
		int res = st.executeUpdate();
		if (res > 0) {
			System.out.println(res + " is affected!!");
		}
		st.close();
		con.close();
	}

}
