package com.atm.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import com.atm.connection.Connect;
import com.atm.dao.WithdrawDao;

import com.atm.models.WithdrawModel;

public class WithdrawImpl implements WithdrawDao {

	// Insert Withdraw Data:
	public int inswith(WithdrawModel withdrawpojo) throws Exception {
		Connection con = Connect.getConnection();

//		String query = "insert into withdraw(user_acc_no,with_amount,money_transfer) values(?,?,?)";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, withdrawpojo.getUser_acc_no());
//		statement.setInt(2, withdrawpojo.getWith_amount());
//		statement.setString(3, withdrawpojo.getmoneytransfer());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
		String query = "{call bank.insertwithdraw(?,?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());
		statement.setInt(2, withdrawpojo.getWith_amount());
		statement.setString(3, withdrawpojo.getmoneytransfer());
		statement.registerOutParameter(4, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(4);
		return res;
	}

	// Remove account:
	public int removewith(WithdrawModel withdrawpojo) throws Exception {
		Connection con = Connect.getConnection();

//		String query = "delete from withdraw where user_acc_no in ?";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, withdrawpojo.getUser_acc_no());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;

		String query = "{call bank.removewithdraw(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());

		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(2);
		return res;
	}
}