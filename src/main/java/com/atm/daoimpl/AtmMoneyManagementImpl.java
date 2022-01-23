package com.atm.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.atm.dao.AtmMoneyManagementDao;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.util.ConnectionUtil;

public class AtmMoneyManagementImpl implements AtmMoneyManagementDao{
//Deposit money:
	public int depositmoney(AtmMoneyManagementModel atmMoneyManagement) throws SQLException{
		
		String query = "insert into atm_money_management(money_deposited,money_balance,agent_name) values(?,?,?)";
		String query1 = "commit";
				PreparedStatement statement = null;
				Connection con = null;
				int res = -1;
				try {
					 con = ConnectionUtil.getConnection();
					statement = con.prepareStatement(query);
					statement.setLong(1, atmMoneyManagement.getMoneydeposited());
					statement.setLong(2, atmMoneyManagement.getMoneydeposited());
					statement.setString(3, atmMoneyManagement.getAgentname());
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
	
	//History Agent:
	public List<AtmMoneyManagementModel> history() throws SQLException {
		List<AtmMoneyManagementModel> atmMoneyManagementModels = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,money_deposited,money_balance,substr(deposited_at,1,14),agent_name from atm_money_management order by id desc";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(query);
					while(res.next()) {
						atmMoneyManagementModels.add(new AtmMoneyManagementModel(res.getInt(1),res.getLong(2),res.getLong(3),res.getString(4),res.getString(5)));
					}
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
		
				return atmMoneyManagementModels;
	}
	
	//previous balance:
	public Long previousbal() throws SQLException {
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select money_balance from atm_money_management where id in (select max(id) from atm_money_management)";
			 statement = con.createStatement();
			ResultSet res = statement.executeQuery(query);
					while(res.next()) {
						return res.getLong(1);
					}
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
		
				return -1l;
	}
	
	//update balance:
	public int updatebal(AtmMoneyManagementModel atmMoneyManagement) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "update atm_money_management set money_balance = ? where id in (select max(id) from atm_money_management)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
					statement.setLong(1, atmMoneyManagement.getMoneybalance());
					
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
				
}
