package com.atm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.atm.connection.Connect;
import com.atm.dao.AtmMoneyManagementdao;
import com.atm.models.AtmMoneyManagement;

public class AtmMoneyManagementimpl implements AtmMoneyManagementdao{
//Deposit money:
	public int depositmoney(AtmMoneyManagement atmMoneyManagement) throws Exception {
		Connection con = Connect.getConnection();
		String query = "insert into atm_money_management(money_deposited,money_balance,agent_name) values(?,?,?)";
		String query1 = "commit";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setLong(1, atmMoneyManagement.getMoneydeposited());
				statement.setLong(2, atmMoneyManagement.getMoneydeposited());
				statement.setString(3, atmMoneyManagement.getAgentname());
				int res = statement.executeUpdate();
				statement.executeUpdate(query1);
				return res;
	}
	
	//History Agent:
	public ResultSet history() throws Exception {
		Connection con = Connect.getConnection();
		String query = "select * from atm_money_management";
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(query);
				return res;
	}
	
	//previous balance:
	public Long previousbal() throws Exception {
		Connection con = Connect.getConnection();
		String query = "select money_balance from atm_money_management where id in (select max(id) from atm_money_management)";
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(query);
				while(res.next()) {
					return res.getLong(1);
				}
				return -1l;
	}
	
	//update balance:
	public int updatebal(AtmMoneyManagement atmMoneyManagement) throws Exception {
		Connection con = Connect.getConnection();
		String query = "update atm_money_management set money_balance = ? where id in (select max(id) from atm_money_management)";
		String query1 = "commit";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setLong(1, atmMoneyManagement.getMoneybalance());
				
				int res = statement.executeUpdate();
				statement.executeUpdate(query1);
				return res;
	}
}
