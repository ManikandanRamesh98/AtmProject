package com.atm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.atm.connection.Connect;
import com.atm.dao.WithdrawDao;

import com.atm.models.Withdrawmodel;

public class Withdrawimpl implements WithdrawDao {

	// Insert Withdraw Data:
	public int inswith(Withdrawmodel withdrawpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into withdraw(user_acc_no,with_amount,money_transfer) values(?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());
		statement.setInt(2, withdrawpojo.getWith_amount());
		statement.setString(3, withdrawpojo.getmoneytransfer());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

	// Remove account:
	public int removewith(Withdrawmodel withdrawpojo) throws Exception {
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