package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.util.ConnectionUtil;

public class MiniStatementImpl {
	// Get MiniStatement:
	public ResultSet getministatement(Long accno) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String query = "select trans,substr(trans_at,1,14),money_transfer from(select trans,withdraw_at trans_at,money_transfer from(select with_amount trans,withdraw_at,money_transfer from withdraw where user_acc_no in ? order by rownum desc)where rownum < 4 union all select trans,dep_at trans_at,money_transfer from(select dep_amount trans,dep_at,money_transfer  from deposit where user_acc_no in ? order by rownum desc) where rownum < 4 order by trans_at desc)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setLong(1, accno);
		statement.setLong(2, accno);
		ResultSet rSet = statement.executeQuery();
		return rSet;
	}
}
