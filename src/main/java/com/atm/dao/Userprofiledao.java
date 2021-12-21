package com.atm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.atm.connection.Connect;
import com.atm.impl.Userprofileimpl;
import com.atm.models.Userprofilemodel;

public class Userprofiledao implements Userprofileimpl {
	
	//Get Balance:
	public int getbal(Userprofilemodel userprofilepojo)throws Exception {
Connection con = Connect.getConnection();

String query = "select balance from userprofile where username in ?";
PreparedStatement statement = con.prepareStatement(query);
statement.setString(1, userprofilepojo.getUsername());
ResultSet rSet = statement.executeQuery();

int res = -1;
while(rSet.next()) {
	res = rSet.getInt(1);
}
return res;
}
	
	//insert balance:
	public int insbal(Userprofilemodel userprofilepojo)throws Exception {
		Connection con = Connect.getConnection();

		String query = "update userprofile set balance = ? where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, userprofilepojo.getBalance());
		statement.setString(2, userprofilepojo.getUsername());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
System.out.println(i);
		return i;
}
	
	//get Account number:
	public Long getaccno(Userprofilemodel userprofilepojo)throws Exception {
		Connection con = Connect.getConnection();

		String query = "select user_acc_no from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, userprofilepojo.getUsername());
		ResultSet rs = statement.executeQuery();
Long resLong = -1l;
while(rs.next()) {
	resLong = rs.getLong(1);
}
return resLong;
	}
	
	//get user details:
	public ResultSet getuserdetails(Userprofilemodel userprofilepojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, userprofilepojo.getUsername());
		ResultSet rs = statement.executeQuery();
		return rs;
	}
	
	//insert user profile details:
	
	
	  public int insuserprofile(Userprofilemodel userprofilepojo) throws Exception {
		  Connection con = Connect.getConnection();

			String query = "insert into userprofile(username,user_acc_no,mob_no,user_pin) values(?,?,?,?)";
			String query1 = "commit";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			statement.setLong(2, userprofilepojo.getUser_acc_no());
			statement.setLong(3, userprofilepojo.getMob_no());
			statement.setInt(4, userprofilepojo.getUser_pin());
			int i = statement.executeUpdate();
			statement.executeUpdate(query1);
			return i;
	  }
	
	//get user details All:
		public ResultSet getuserdetails() throws Exception {
			Connection con = Connect.getConnection();

			String query = "select * from userprofile";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			return rs;
		}
		//remove account:
		public int removeuserprof(Userprofilemodel userprofilepojo) throws Exception{
			Connection con = Connect.getConnection();

			String query = "delete from userprofile where user_acc_no in ? and id in ?";
			String query1 = "commit";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setLong(1, userprofilepojo.getUser_acc_no());
			statement.setInt(2, userprofilepojo.getId());
			int i = statement.executeUpdate();
			statement.executeUpdate(query1);
			return i;
		}
		//get max account:
		public ResultSet getusermaxacc() throws Exception {
			Connection con = Connect.getConnection();

			String query = "select max(user_acc_no) from userprofile";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			return rs;
		}
		//get max pin:
				public ResultSet getusermaxpin() throws Exception {
					Connection con = Connect.getConnection();

					String query = "select max(user_pin) from userprofile";
					Statement statement = con.createStatement();
					
					ResultSet rs = statement.executeQuery(query);
					return rs;
				}
				
				
				
				//get user_pin:
				public int getuserpin(String username)throws Exception {
					Connection con = Connect.getConnection();

					String query = "select user_pin from userprofile where username in ?";
					PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, username);
					
					ResultSet rs = statement.executeQuery();
					while(rs.next()) {
						return rs.getInt(1);
					}
					return -1;
				}
				
				public int moneytransf(Userprofilemodel userprofilepojo)throws Exception {
					Connection con = Connect.getConnection();

					String query = "select balance from userprofile where username in ? and user_acc_no in ?";
					PreparedStatement statement = con.prepareStatement(query);
					statement.setString(1, userprofilepojo.getUsername());
					statement.setLong(2, userprofilepojo.getUser_acc_no());
					ResultSet rSet = statement.executeQuery();

					int res = -1;
					while(rSet.next()) {
						res = rSet.getInt(1);
					}
					return res;
					}
				
}
