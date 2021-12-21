package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.atm.connection.Connect;
import com.atm.impl.Depositimpl;
import com.atm.models.Depositmodel;

public class Depositdao implements Depositimpl {
	// Insert data in Deposit:
	public int insdep(Depositmodel depositpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into deposit(user_acc_no,dep_amount) values(?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, depositpojo.getUser_acc_no());
		statement.setInt(2, depositpojo.getDep_amount());
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
