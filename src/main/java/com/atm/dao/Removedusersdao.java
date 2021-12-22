package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.atm.connection.Connect;
import com.atm.impl.Removedusersimpl;
import com.atm.models.Removedusersmodel;

public class Removedusersdao implements Removedusersimpl{
	// Insert data into removed users:
	public int insremoveusers(Removedusersmodel removedusersmodel) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into removedusers(user_acc_no,username,last_balance,mob_no,user_pin) values(?,?,?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, removedusersmodel.getUseraccno());
		statement.setString(2, removedusersmodel.getUsername());
		statement.setInt(3, removedusersmodel.getLastbalance());
		statement.setLong(4, removedusersmodel.getMobno());
		statement.setInt(5, removedusersmodel.getUserpin());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

//fetch user:

	public ResultSet fetchremoveusers() throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from removedusers";
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}
}
