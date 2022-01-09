package com.atm.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.util.ConnectionUtil;

public class Main {
public static void main(String[] args) throws Exception {
//	InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
//	System.out.println(invalidPinLockDaoimpl.getsysdate());
	
	
	Connection con = ConnectionUtil.getConnection();
	String query = "select substr((current_timestamp-acc_lockedat),1,13) from invalidpinlock where username in ?";
	
	PreparedStatement statement = con.prepareStatement(query);
	statement.setString(1, "Mani");
	ResultSet rSet = statement.executeQuery();
	while(rSet.next()) {
		System.out.println(rSet.getString(1));
		String ret = rSet.getString(1);
		String ret1 = ret.substring(11, 13);
		if(ret1.matches("[0][0-9]")) {
		int res = Integer.parseInt(ret1.substring(1));
		System.out.println(res +"hjk");
	}else {
		
	}
	
}
}
}
