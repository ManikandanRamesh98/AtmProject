package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.util.ConnectionUtil;

public class MiniStatementImpl {
	// Get MiniStatement:
	public ResultSet getministatement(Long accno) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String query = "select * from(select with_amount trans,substr(withdraw_at,1,16) trans_at,money_transfer from withdraw where user_acc_no in ? union all select dep_amount trans,substr(dep_at,1,16) trans_at,money_transfer from deposit where user_acc_no in ?  order by trans_at desc)where rownum <8";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setLong(1, accno);
		statement.setLong(2, accno);
		ResultSet rSet = statement.executeQuery();
		return rSet;
	}
}
