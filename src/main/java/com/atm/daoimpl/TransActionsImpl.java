package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atm.models.TransActionsModel;

import com.atm.util.ConnectionUtil;

public class TransActionsImpl {
	
	// Insert TransAction Data:
		public int insertTransAction(TransActionsModel transActionsModel) throws SQLException {
			Connection con = null;
			int res = -1;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "insert into transactions(user_acc_no,transaction_amount,transaction_type,money_transfer) values(?,?,?,?)";
				String query1 = "commit";
				statement = con.prepareStatement(query);
				statement.setLong(1, transActionsModel.getUserAccnoLong());
				statement.setInt(2, transActionsModel.getTransActionAmount());
				statement.setString(3, transActionsModel.getTransActionType());
				statement.setString(4, transActionsModel.getMoneyTransfer());
				res = statement.executeUpdate();
				statement.executeUpdate(query1);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
			return res;
}
		
		// Remove account:
		public int transactionsremove(TransActionsModel transActionsModel) throws SQLException {
			Connection con = null;
			int res = -1;
			PreparedStatement statement = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "delete from transactions where user_acc_no in ?";
				String query1 = "commit";
				statement = con.prepareStatement(query);
				statement.setLong(1, transActionsModel.getUserAccnoLong());
				 res = statement.executeUpdate();
				statement.executeUpdate(query1);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(statement != null) {
					statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
			return res;
		}
		
		
		//check withdraw limit:
		public int checkwithdrawlimit(TransActionsModel transActionsModel) throws Exception {
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
	        
	        
			String query = "select sum(abs(transaction_amount)) from transactions where transaction_at like '"+finaldateString+"%' and user_acc_no in ? and transaction_type = 'withdraw'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
	
			preparedStatement.setLong(1,  transActionsModel.getUserAccnoLong());
			ResultSet rSet2 = preparedStatement.executeQuery();
			int total = -1;
			while(rSet2.next()) {
	        	total = rSet2.getInt(1);
	        	System.out.println(total);
	        	return total;
	        }
			
			return total;
		}
		
		//check deposit limit:
		
				public int checkDepositLimit(TransActionsModel transActionsModel) throws Exception {
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
			        
			        
					String query = "select sum(abs(transaction_amount)) from transactions where transaction_at like '"+finaldateString+"%' and user_acc_no in ? and transaction_type = 'deposit'";
					PreparedStatement preparedStatement = con.prepareStatement(query);
			
					preparedStatement.setLong(1,  transActionsModel.getUserAccnoLong());
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
