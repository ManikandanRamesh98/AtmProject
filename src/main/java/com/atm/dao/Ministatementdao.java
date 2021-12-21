package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.connection.Connect;

public class Ministatementdao {
	// Get MiniStatement:
	public ResultSet getministatement(Long accno) throws Exception {
		Connection connection = Connect.getConnection();
		String query = "select *from(select with_amount trans,withdraw_at trans_at from withdraw where user_acc_no in ? union all select dep_amount trans,dep_at trans_at from deposit where user_acc_no in ?  order by trans_at desc)where rownum <8";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setLong(1, accno);
		statement.setLong(2, accno);
		ResultSet rSet = statement.executeQuery();
		return rSet;
	}
}
