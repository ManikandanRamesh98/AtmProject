package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.atm.dao.WithdrawDao;

import com.atm.models.WithdrawModel;
import com.atm.util.ConnectionUtil;

public class WithdrawImpl implements WithdrawDao {

	// Insert Withdraw Data:
	public int inswith(WithdrawModel withdrawpojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

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
		Connection con = ConnectionUtil.getConnection();

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
	
	//check withdraw limit:
	public boolean checkwithdrawlimit(WithdrawModel withdrawModel) throws Exception {
		Connection con = ConnectionUtil.getConnection();
        String sysdatequery = "select sysdate from dual";
        String sysdString = null;
        Statement statement = con.createStatement();
        ResultSet rSet = statement.executeQuery(sysdatequery);
        while(rSet.next()) {
        	sysdString = rSet.getString(1);
        }
		String query = "select sum(abs(with_amount)) from withdraw where withdraw_at like '?%' and user_acc_no in ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, sysdString);
		preparedStatement.setLong(2, withdrawModel.getUser_acc_no());
		ResultSet rSet2 = preparedStatement.executeQuery();
		int total = -1;
		while(rSet2.next()) {
        	total = rSet2.getInt(1);
        }
		if(total > 0) {
			if(total > 10000) {
				return true;
			}
		}
		return false;
	}
	
}