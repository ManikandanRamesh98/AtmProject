package com.atm.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;


import com.atm.connection.Connect;
import com.atm.models.Depositmodel;

public class Depositimpl implements com.atm.dao.DepositDao {
	// Insert data in Deposit:
	public int insdep(Depositmodel depositpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into deposit(user_acc_no,dep_amount,money_transfer) values(?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, depositpojo.getUser_acc_no());
		statement.setInt(2, depositpojo.getDep_amount());
		statement.setString(3, depositpojo.getmoneytransfer());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

	// remove account:
	public int removedep(Depositmodel depositpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "delete from deposit where user_acc_no in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, depositpojo.getUser_acc_no());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
