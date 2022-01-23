package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.jar.Manifest;

import com.atm.models.InvalidPinLockModel;
import com.atm.util.ConnectionUtil;

public class InvalidPinLockDaoimpl {
	//Insert data in table:
public int insertlock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "insert into invalidpinlock(username) values(?)";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		
		 res = statement.executeUpdate();
		statement.executeUpdate("commit");
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

//check whether the acc is locked or not:
public boolean status(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	try {
		con = ConnectionUtil.getConnection();
		String query = "select * from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		ResultSet rSet = statement.executeQuery();
		if(rSet.next()) {
			return true;
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
	
	return false;
}
//delete entries from table:

public int deletelock(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con = null;
	PreparedStatement statement = null;
	int res = -1;
	try {
		con = ConnectionUtil.getConnection();
		String query = "delete from invalidpinlock where username in ?";
		statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		 res = statement.executeUpdate();
		statement.executeUpdate("commit");
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

//retrive the releasing time:
public int retriveat(InvalidPinLockModel invalidPinLockModel) throws SQLException {
	Connection con;
	try {
		con = ConnectionUtil.getConnection();
		//calculate minutes:
		String query = "select substr((current_timestamp-acc_lockedat),-12,2) from invalidpinlock where username in ?";
		//calculate days:
		String datequery = "select substr((current_timestamp-acc_lockedat),2,2) from invalidpinlock where username in ?";
		//calculate hours:
		String hoursqueryString = "select substr((current_timestamp-acc_lockedat),5,2) from invalidpinlock where username in ?";
		int date = 0;
		int hours = 0; 

		//date:
		PreparedStatement statement1 = con.prepareStatement(datequery);
		statement1.setString(1, invalidPinLockModel.getUsername());
		
		ResultSet rSet1 = statement1.executeQuery();
		while(rSet1.next()) {
			String ret = rSet1.getString(1);
			if(ret.matches("[0][0-9]")) {
			 date = Integer.parseInt(ret.substring(1));
			
			}else {
				
			 date = Integer.parseInt(rSet1.getString(1));
			}
		}
		
		//hours:
		PreparedStatement statement2 = con.prepareStatement(hoursqueryString);
		statement2.setString(1, invalidPinLockModel.getUsername());
		
		ResultSet rSet2 = statement2.executeQuery();
		while(rSet2.next()) {
			String ret = rSet2.getString(1);
			if(ret.matches("[0][0-9]")) {
			 hours = Integer.parseInt(ret.substring(1));
			
			}else {
			 hours = Integer.parseInt(rSet2.getString(1));
			}
		}
		
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, invalidPinLockModel.getUsername());
		
		ResultSet rSet = statement.executeQuery();
		while(rSet.next()) {
			System.out.println(rSet.getString(1));
			String ret = rSet.getString(1);
			if(date < 1) {
				if(hours < 1) {
			if(ret.matches("[0][0-9]")) {
			return Integer.parseInt(ret.substring(1));
			}else {
				return Integer.parseInt(ret);
			}
		}else {
			return 100;
		}
				}else {
			return 100;
		}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return -1;
}
}

