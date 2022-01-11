package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	public int checkwithdrawlimit(WithdrawModel withdrawModel) throws Exception {
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
        
        
		String query = "select sum(abs(with_amount)) from withdraw where withdraw_at like '"+finaldateString+"%' and user_acc_no in ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
System.out.println(withdrawModel.getUser_acc_no());
		preparedStatement.setLong(1, withdrawModel.getUser_acc_no());
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