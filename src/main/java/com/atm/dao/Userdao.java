package com.atm.dao;

import java.sql.*;
import java.util.Scanner;

import com.atm.connection.Connect;
import com.atm.impl.Userimpl;
import com.atm.models.Usernamepasspojo;

public class Userdao implements Userimpl{
Scanner sc = new Scanner(System.in);


    //fetch data:
    public String getrole(Usernamepasspojo usernamepasspojo) throws Exception{
  
String role = null;
        Connection con = Connect.getConnection();

        String query = "select * from usernamepass where username in ? and password in ?";
        PreparedStatement st = con.prepareStatement(query);
           st.setString(1, usernamepasspojo.getUsername());
           st.setString(2, usernamepasspojo.getPassword());
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
        	role = rs.getString(5);
        	
        }
        
        return role;
    }
    
    //get role:
    public String getrole1(Usernamepasspojo usernamepasspojo) throws Exception {
    	Connection con = Connect.getConnection();
    	
    	String query = "select role from usernamepass where username in ?";
    	PreparedStatement st = con.prepareStatement(query);
    	st.setString(1, usernamepasspojo.getUsername());
    	ResultSet rs = st.executeQuery();
    	rs.next();
    	String res = rs.getString(1);
    	return res;
    }

  //passchange:
  	public int pinchange(Usernamepasspojo usernamepasspojo) throws Exception{
  		Connection con = Connect.getConnection();

  		String query = "update usernamepass set password = ? where username in ?";
  		String query1 = "commit";
  		PreparedStatement statement = con.prepareStatement(query);
  		statement.setString(1, usernamepasspojo.getPassword());
  		statement.setString(2, usernamepasspojo.getUsername());
  		int i = statement.executeUpdate();
  		
  		statement.executeUpdate(query1);
  		return i;
  	}
  	
  	//insusernamepass:
  public int insusernamepass(Usernamepasspojo usernamepasspojo) throws Exception {
	  Connection con = Connect.getConnection();

		String query = "insert into usernamepass(username,password,role) values(?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		statement.setString(2, usernamepasspojo.getPassword());
		statement.setString(3, usernamepasspojo.getRole());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
  }
  
  //removeacc:
  public int removeuser(Usernamepasspojo usernamepasspojo) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from usernamepass where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
