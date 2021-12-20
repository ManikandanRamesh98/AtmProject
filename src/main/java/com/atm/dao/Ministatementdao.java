package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.connection.Connect;

public class Ministatementdao {
public ResultSet getministatement(Long accno) throws Exception {
	Connection connection = Connect.getConnection();
	String query = "select with_amount trans,withdraw_at trans_at from withdraw where user_acc_no in ? union all select dep_amount trans,dep_at trans_at from deposit where user_acc_no in ? order by trans_at desc";
	PreparedStatement statement = connection.prepareStatement(query);
	statement.setLong(1, accno);
	statement.setLong(2, accno);
	ResultSet rSet = statement.executeQuery();
	return rSet;
}
}
