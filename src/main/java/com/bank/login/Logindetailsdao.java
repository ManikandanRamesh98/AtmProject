package com.bank.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServlet;

public class Logindetailsdao {
	public int removelogindetail(Loginpojo loginpojo) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from login where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, loginpojo.getUsername());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
	
	//Insert Data in to login table:
    public void insertdata(Loginpojo loginpojo) throws Exception {



        Connection con = Connect.getConnection();

        String query = "insert into login(username,role) values(?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,loginpojo.getUsername());
     st.setString(2, loginpojo.getRole());
        int res = st.executeUpdate();
        if(res > 0) {
        	System.out.println(res +" is affected!!");
        }
        st.close();
        con.close();
    }

}
