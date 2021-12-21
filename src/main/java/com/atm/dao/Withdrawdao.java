package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.atm.connection.Connect;
import com.atm.impl.Withdrawimpl;
import com.atm.models.Withdrawmodel;

public class Withdrawdao implements Withdrawimpl {

	// Insert Withdraw Data:
	public int inswith(Withdrawmodel withdrawpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into withdraw(user_acc_no,with_amount) values(?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());
		statement.setInt(2, withdrawpojo.getWith_amount());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

	// Remove account:
	public int removewith(Withdrawmodel withdrawpojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "delete from withdraw where user_acc_no in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, withdrawpojo.getUser_acc_no());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}