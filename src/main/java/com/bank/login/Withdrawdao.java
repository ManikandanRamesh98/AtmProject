package com.bank.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Withdrawdao  {
	
	public int inswith(Withdrawpojo withdrawpojo)throws Exception {
Connection con = Connect.getConnection();

String query = "insert into withdraw(user_acc_no,with_amount) values(?,?)";
String query1 = "commit";
PreparedStatement statement = con.prepareStatement(query);
statement.setLong(1, withdrawpojo.getUser_acc_no());
statement.setInt(2, withdrawpojo.getWith_amount());
int i = statement.executeUpdate();
statement.executeUpdate(query1);
return i;
}
	
	
//	//fetch withdraw:
//	public ResultSet fetchwith()throws Exception {
//		Connection con = Connect.getConnection();
//
//		String query = "select user";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, accno);
//		statement.setInt(2, amount);
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
//		}
	
	//removeaccount
	public int removewith(Withdrawpojo withdrawpojo) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from withdraw where user_acc_no in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}