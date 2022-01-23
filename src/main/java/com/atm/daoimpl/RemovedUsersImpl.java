package com.atm.daoimpl;

import java.sql.*;

import com.atm.dao.RemovedUsersDao;
import com.atm.models.RemovedUsersModel;
import com.atm.util.ConnectionUtil;


public class RemovedUsersImpl implements RemovedUsersDao {
	// Insert data into removed users:
	public int insremoveusers(RemovedUsersModel removedusersmodel) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into removedusers(user_acc_no,username,last_balance,mob_no,user_pin) values(?,?,?,?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setLong(1, removedusersmodel.getUseraccno());
			statement.setString(2, removedusersmodel.getUsername());
			statement.setInt(3, removedusersmodel.getLastbalance());
			statement.setLong(4, removedusersmodel.getMobno());
			statement.setInt(5, removedusersmodel.getUserpin());
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

//fetch user:

	public ResultSet fetchremoveusers() throws SQLException {
		Connection con = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,user_acc_no,username,last_balance,mob_no,user_pin,substr(acc_removed_at,1,16) from removedusers order by id desc";
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
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
		return resultSet;
	}
}
