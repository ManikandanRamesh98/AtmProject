package com.atm.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.atm.models.DepositModel;
import com.atm.models.WithdrawModel;
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
	
	//check Deposit limit:
		public int checkwithdrawlimit(DepositModel depositModel) throws Exception {
			Connection con = ConnectionUtil.getConnection();
	        String sysdatequery = "select current_timestamp from dual";
	        String sysdString = null;
	        Statement statement = con.createStatement();
	        ResultSet rSet = statement.executeQuery(sysdatequery);
	        while(rSet.next()) {
	        	sysdString = rSet.getString(1);
	        	
	        }
	        System.out.println(sysdString);
	        sysdString = sysdString.substring(2, 10);
	        System.out.println(sysdString);
	        String yearString = sysdString.substring(0,2);
	        System.out.println(yearString);
	        String monthString = sysdString.substring(3,5);
	        System.out.println(monthString);
	        String dayString = sysdString.substring(6,8);
	        System.out.println(dayString);
	        String finaldateString = dayString + "-" +monthString + "-" + yearString;
	        System.out.println(finaldateString);
	        
	        
			String query = "select sum(abs(dep_amount)) from deposit where dep_at like '"+finaldateString+"%' and user_acc_no in ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
	System.out.println(depositModel.getUser_acc_no());
			preparedStatement.setLong(1, depositModel.getUser_acc_no());
			ResultSet rSet2 = preparedStatement.executeQuery();
			int total = -1;
			while(rSet2.next()) {
	        	total = rSet2.getInt(1);
	        	System.out.println(total);
	        	return total;
	        }
			
			return total;
		}
}
