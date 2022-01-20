package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.atm.dao.AtmMoneyManagementDao;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.util.ConnectionUtil;

public class AtmMoneyManagementImpl implements AtmMoneyManagementDao{
//Deposit money:
	public int depositmoney(AtmMoneyManagementModel atmMoneyManagement) throws Exception {
		Connection con = ConnectionUtil.getConnection();
//		String query = "insert into atm_money_management(money_deposited,money_balance,agent_name) values(?,?,?)";
//		String query1 = "commit";
//				PreparedStatement statement = con.prepareStatement(query);
//				statement.setLong(1, atmMoneyManagement.getMoneydeposited());
//				statement.setLong(2, atmMoneyManagement.getMoneydeposited());
//				statement.setString(3, atmMoneyManagement.getAgentname());
//				int res = statement.executeUpdate();
//				statement.executeUpdate(query1);
//				return res;
		String query = "{call bank.depositmoneyagent(?,?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, atmMoneyManagement.getMoneydeposited());
		statement.setLong(2, atmMoneyManagement.getMoneydeposited());
		statement.setString(3, atmMoneyManagement.getAgentname());
		statement.registerOutParameter(4, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(4);
		return res;
	}
	
	//History Agent:
	public ResultSet history() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String query = "select id,money_deposited,money_balance,substr(deposited_at,1,14),agent_name from atm_money_management order by id desc";
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(query);
				return res;
	}
	
	//previous balance:
	public Long previousbal() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String query = "select money_balance from atm_money_management where id in (select max(id) from atm_money_management)";
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(query);
				while(res.next()) {
					return res.getLong(1);
				}
				return -1l;
	}
	
	//update balance:
	public int updatebal(AtmMoneyManagementModel atmMoneyManagement) throws Exception {
		Connection con = ConnectionUtil.getConnection();
//		String query = "update atm_money_management set money_balance = ? where id in (select max(id) from atm_money_management)";
//		String query1 = "commit";
//				PreparedStatement statement = con.prepareStatement(query);
//				statement.setLong(1, atmMoneyManagement.getMoneybalance());
//				
//				int res = statement.executeUpdate();
//				statement.executeUpdate(query1);
//				return res;
//				
		
		String query = "{call bank.updatebalagent(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, atmMoneyManagement.getMoneybalance());
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(2);
		return res;
	}
				
}
