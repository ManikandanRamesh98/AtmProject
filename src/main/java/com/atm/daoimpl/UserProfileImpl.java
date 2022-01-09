package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.atm.dao.UserprofileDao;
import com.atm.models.UserProfileModel;
import com.atm.util.ConnectionUtil;

public class UserProfileImpl implements UserprofileDao {

	// Get Balance:
	public int getbal(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		String query = "{call bank.getbal(?,?)}";
//		String query = "select balance from userprofile where username in ?";
//		PreparedStatement statement = con.prepareStatement(query);
		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, userprofilepojo.getUsername());
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
//		ResultSet rSet = statement.executeQuery();
//
//		int res = -1;
//		while (rSet.next()) {
//			res = rSet.getInt(1);
//		}
		int res = statement.getInt(2);

		return res;
	}

	// update balance:
	public int insbal(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "update userprofile set balance = ? where username in ?";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);

		String query = "{call bank.updatebal(?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setInt(1, userprofilepojo.getBalance());
		statement.setString(2, userprofilepojo.getUsername());
		statement.registerOutParameter(3, Types.INTEGER);
		statement.execute();

		int res = statement.getInt(3);
		return res;
	}

	// get Account number:
	public Long getaccno(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "select user_acc_no from userprofile where username in ?";
//		PreparedStatement statement = con.prepareStatement(query);
		String query = "{call bank.getaccno(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, userprofilepojo.getUsername());
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
//		ResultSet rs = statement.executeQuery();
//		Long resLong = -1l;
//		while (rs.next()) {
//			resLong = rs.getLong(1);
//		}
		Long resLong = statement.getLong(2);
		return resLong;
	}

	// get user details:
	public ResultSet getuserdetails(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		String query = "select * from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, userprofilepojo.getUsername());
		ResultSet rs = statement.executeQuery();
		return rs;
	}

	// insert user profile details:

	public int insuserprofile(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "insert into userprofile(username,user_acc_no,mob_no,user_pin) values(?,?,?,?)";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
		String query = "{call bank.insertuserprofile(?,?,?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, userprofilepojo.getUsername());
		statement.setLong(2, userprofilepojo.getUser_acc_no());
		statement.setLong(3, userprofilepojo.getMob_no());
		statement.setInt(4, userprofilepojo.getUser_pin());
		statement.registerOutParameter(5, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(5);
		return res;
	}

	// get user details All:
	public ResultSet getuserdetails() throws Exception {
		Connection con = ConnectionUtil.getConnection();

		String query = "select * from userprofile";
		Statement statement = con.createStatement();

		ResultSet rs = statement.executeQuery(query);
		return rs;
	}

	// remove account:
	public int removeuserprof(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "delete from userprofile where user_acc_no in ? and id in ?";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
		String query = "{call bank.removeuserprofile(?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, userprofilepojo.getUser_acc_no());
		statement.setInt(2, userprofilepojo.getId());
		statement.registerOutParameter(3, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(3);

		return res;
	}

	// get max account:
	public long getusermaxacc() throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "select max(user_acc_no) from userprofile";
//		Statement statement = con.createStatement();
		String query = "{call bank.getusermaxaccno(?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.registerOutParameter(1, Types.INTEGER);
		statement.execute();
//		ResultSet rs = statement.executeQuery(query);
//		return rs;
		long accno = statement.getLong(1);
		return accno;
	}

	// get max pin:
	public int getusermaxpin() throws Exception {
		Connection con = ConnectionUtil.getConnection();
//
//		String query = "select max(user_pin) from userprofile";
		
//		Statement statement = con.createStatement();
//
//		ResultSet rs = statement.executeQuery(query);
		String query = "{call bank.getusermaxpin(?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.registerOutParameter(1, Types.INTEGER);
		statement.execute();
		int pin = statement.getInt(1);
		return pin;
	}

	// get user_pin:
	public int getuserpin(String username) throws Exception {
		Connection con = ConnectionUtil.getConnection();

//		String query = "select user_pin from userprofile where username in ?";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setString(1, username);
//
//		ResultSet rs = statement.executeQuery();
//		while (rs.next()) {
//			return rs.getInt(1);
//		}
//		return -1;
		
		String query = "{call bank.getuserpin(?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, username);
		statement.registerOutParameter(2, Types.INTEGER);
		statement.execute();
		int pin = statement.getInt(2);
		return pin;
	}

	public int moneytransf(UserProfileModel userprofilepojo) throws Exception {
		Connection con = ConnectionUtil.getConnection();
//
//		String query = "select balance from userprofile where username in ? and user_acc_no in ?";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setString(1, userprofilepojo.getUsername());
//		statement.setLong(2, userprofilepojo.getUser_acc_no());
//		ResultSet rSet = statement.executeQuery();
//
//		int res = -1;
//		while (rSet.next()) {
//			res = rSet.getInt(1);
//		}
//		return res;
		
		String query = "{call bank.moneytransferbal(?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setString(1, userprofilepojo.getUsername());
		statement.setLong(2, userprofilepojo.getUser_acc_no());
		statement.registerOutParameter(3, Types.INTEGER);
		statement.execute();
		int bal = statement.getInt(3);
		return bal;
	}
	
	//update User Pin:
	public int updatepin(UserProfileModel userProfileModel) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String query = "update userprofile set user_pin = ? where username in ?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setInt(1, userProfileModel.getUser_pin());
		pStatement.setString(2, userProfileModel.getUsername());
		int res = pStatement.executeUpdate();
		return res;
		
	}
	
	//check usermobile no exist:
	public boolean usermobileexist(UserProfileModel userProfileModel)throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String query = "select * from userprofile where mob_no in ?";
		PreparedStatement pStatement = con.prepareStatement(query);
		pStatement.setLong(1, userProfileModel.getMob_no());
		ResultSet rSet = pStatement.executeQuery();
		if(rSet.next()) {
			return true;
		}
		return false;
	}
	

}
