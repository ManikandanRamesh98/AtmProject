package com.atm.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.atm.models.DepositModel;
import com.atm.util.ConnectionUtil;

public class DepositImpl implements com.atm.dao.DepositDao {
	// Insert data in Deposit:
	public int insdep(DepositModel depositpojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into deposit(user_acc_no,dep_amount,money_transfer) values(?,?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setLong(1, depositpojo.getUser_acc_no());
			statement.setInt(2, depositpojo.getDep_amount());
			statement.setString(3, depositpojo.getmoneytransfer());
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
	

	// remove account:
	public int removedep(DepositModel depositpojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from deposit where user_acc_no in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setLong(1, depositpojo.getUser_acc_no());
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
	
	//check Deposit limit:
		public int checkwithdrawlimit(DepositModel depositModel) throws SQLException {
			Connection con = null;
			Statement statement = null;
			PreparedStatement preparedStatement = null;
			int total = -1;
			try {
				con = ConnectionUtil.getConnection();
				 String sysdatequery = "select current_timestamp from dual";
			        String sysdString = null;
			        statement = con.createStatement();
			        ResultSet rSet = statement.executeQuery(sysdatequery);
			        while(rSet.next()) {
			        	sysdString = rSet.getString(1);
			        	
			        }
			        
			        if(sysdString != null) {
			        sysdString = sysdString.substring(2, 10);
			 
			        
			        String yearString = sysdString.substring(0,2);
			        
			        String monthString = sysdString.substring(3,5);
			       
			        String dayString = sysdString.substring(6,8);
			        
			        String finaldateString = dayString + "-" +monthString + "-" + yearString;
			        String query = "select sum(abs(dep_amount)) from deposit where dep_at like '"+finaldateString+"%' and user_acc_no in ?";
			        preparedStatement = con.prepareStatement(query);
					preparedStatement.setLong(1, depositModel.getUser_acc_no());
					ResultSet rSet2 = preparedStatement.executeQuery();
					
					while(rSet2.next()) {
			        	total = rSet2.getInt(1);
			        	return total;
			        }
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
					if(con != null) {
						con.close();
					}
				}
	       
			
			return total;
		}
}
