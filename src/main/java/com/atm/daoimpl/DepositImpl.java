package com.atm.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import com.atm.models.DepositModel;
import com.atm.util.ConnectionUtil;

public class DepositImpl implements com.atm.dao.DepositDao {
	// Insert data in Deposit:
	public int insdep(DepositModel depositpojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();
//
//		String query = "insert into deposit(user_acc_no,dep_amount,money_transfer) values(?,?,?)";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, depositpojo.getUser_acc_no());
//		statement.setInt(2, depositpojo.getDep_amount());
//		statement.setString(3, depositpojo.getmoneytransfer());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
		
		String query = "{call bank.insertdeposit(?,?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, depositpojo.getUser_acc_no());
		statement.setInt(2, depositpojo.getDep_amount());
		statement.setString(3, depositpojo.getmoneytransfer());
		statement.registerOutParameter(4, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(4);
		return res;
	}
	

	// remove account:
	public int removedep(DepositModel depositpojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "delete from deposit where user_acc_no in ?";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, depositpojo.getUser_acc_no());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
		String query = "{call bank.removedeposit(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, depositpojo.getUser_acc_no());

		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(2);
		return res;
	}
}
