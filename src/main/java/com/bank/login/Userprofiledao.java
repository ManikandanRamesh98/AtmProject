package com.bank.login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Userprofiledao  {
	
	public int getbal(String username)throws Exception {
Connection con = Connect.getConnection();

String query = "select balance from userprofile where username in ?";
PreparedStatement statement = con.prepareStatement(query);
statement.setString(1, username);
ResultSet rSet = statement.executeQuery();

int res = -1;
while(rSet.next()) {
	res = rSet.getInt(1);
}
return res;
}
	
	//insert balance:
	public int insbal(int bal,String username)throws Exception {
		Connection con = Connect.getConnection();

		String query = "update userprofile set balance = ? where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, bal);
		statement.setString(2, username);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
System.out.println(i);
		return i;
}
	
	//getaccnof
	public Long getaccno(String uname)throws Exception {
		Connection con = Connect.getConnection();

		String query = "select user_acc_no from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, uname);
		ResultSet rs = statement.executeQuery();
Long resLong = -1l;
while(rs.next()) {
	resLong = rs.getLong(1);
}
return resLong;
	}
	
	//getuserdetails
	public ResultSet getuserdetails(String user) throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		return rs;
	}
	
	//insuserprofile details:
	
	
	  public int insuserprofile(String username,Long accno,Long mobno,int userpin) throws Exception {
		  Connection con = Connect.getConnection();

			String query = "insert into userprofile(username,user_acc_no,mob_no,user_pin) values(?,?,?,?)";
			String query1 = "commit";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, username);
			statement.setLong(2, accno);
			statement.setLong(3, mobno);
			statement.setInt(4, userpin);
			int i = statement.executeUpdate();
			statement.executeUpdate(query1);
			return i;
	  }
	
	//getuserdetails All
		public ResultSet getuserdetails() throws Exception {
			Connection con = Connect.getConnection();

			String query = "select * from userprofile";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			return rs;
		}
		//removeacc:
		public int removeuserprof(Long accno) throws Exception{
			Connection con = Connect.getConnection();

			String query = "delete from userprofile where user_acc_no in ?";
			String query1 = "commit";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setLong(1, accno);
			int i = statement.executeUpdate();
			statement.executeUpdate(query1);
			return i;
		}
		//get max acc:
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
}
