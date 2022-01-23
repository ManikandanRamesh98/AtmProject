package com.atm.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.atm.dao.UserprofileDao;
import com.atm.models.UserProfileModel;
import com.atm.util.ConnectionUtil;

public class UserProfileImpl implements UserprofileDao {

	// Get Balance:
	public int getbal(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select balance from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				res = rSet.getInt(1);
			}
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

	// update balance:
	public int insbal(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null; 
		try {
			con = ConnectionUtil.getConnection();
			String query = "update userprofile set balance = ? where username in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setInt(1, userprofilepojo.getBalance());
			statement.setString(2, userprofilepojo.getUsername());
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

	// get Account number:
	public Long getaccno(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		Long resLong = -1l;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select user_acc_no from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				resLong = rs.getLong(1);
			}
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
		
		return resLong;
	}

	// get user details:
	public ResultSet getuserdetails(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			rs = statement.executeQuery();
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
		return rs;
	}

	// insert user profile details:

	public int insuserprofile(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into userprofile(username,user_acc_no,mob_no,user_pin) values(?,?,?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			statement.setLong(2, userprofilepojo.getUser_acc_no());
			statement.setLong(3, userprofilepojo.getMob_no());
			statement.setInt(4, userprofilepojo.getUser_pin());
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

	// get user details All:
	public ResultSet getuserdetails() throws SQLException {
		Connection con = null;
		Statement statement = null; 
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();

			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at  from userprofile";
			statement = con.createStatement();
			 rs = statement.executeQuery(query);
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

		return rs;
	}

	// remove account:
	public int removeuserprof(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from userprofile where user_acc_no in ? and id in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setLong(1, userprofilepojo.getUser_acc_no());
			statement.setInt(2, userprofilepojo.getId());
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

	// get max account:
	public long getusermaxacc() throws SQLException {
		Connection con = null;
		long accno = -1l;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select max(user_acc_no) from userprofile";
			 statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				accno = rs.getLong(1);
			}
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
		return accno;
	}

	// get max pin:
	public int getusermaxpin() throws SQLException {
		int pin = -1;
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select max(user_pin) from userprofile";
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				pin = rs.getInt(1);
			}
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
		return pin;
	}

	// get user_pin:
	public int getuserpin(String username) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select user_pin from userprofile where username in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, username);

			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
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

		return -1;
		
	}

	public int moneytransf(UserProfileModel userprofilepojo) throws SQLException {
		Connection con = null;
		int res = -1;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select balance from userprofile where username in ? and user_acc_no in ?";
			statement = con.prepareStatement(query);
			statement.setString(1, userprofilepojo.getUsername());
			statement.setLong(2, userprofilepojo.getUser_acc_no());
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()) {
				res = rSet.getInt(1);
			}
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
	
	//update User Pin:
	public int updatepin(UserProfileModel userProfileModel) throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "update userprofile set user_pin = ? where username in ?";
			pStatement = con.prepareStatement(query);
			pStatement.setInt(1, userProfileModel.getUser_pin());
			pStatement.setString(2, userProfileModel.getUsername());
			res= pStatement.executeUpdate();
			pStatement.executeUpdate("commit");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pStatement != null) {
				pStatement.close();
				}
				if(con != null) {
					con.close();
				}
		}
	
		return res;
		
	}
	
	//check usermobile no exist:
	public boolean usermobileexist(UserProfileModel userProfileModel)throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "select id,username,user_acc_no,balance,mob_no,user_pin,acc_created_at from userprofile where mob_no in ?";
			pStatement = con.prepareStatement(query);
			pStatement.setLong(1, userProfileModel.getMob_no());
			ResultSet rSet = pStatement.executeQuery();
			if(rSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pStatement != null) {
				pStatement.close();
				}
				if(con != null) {
					con.close();
				}
		}
	
		
		return false;
	}
	

}
