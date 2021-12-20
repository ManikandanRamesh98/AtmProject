package com.atm.impl;

import java.sql.ResultSet;

import com.atm.models.Userprofilepojo;

public interface Userprofileimpl {
	//get bal:
	public int getbal(Userprofilepojo userprofilepojo)throws Exception;
	//ins bal:
	public int insbal(Userprofilepojo userprofilepojo)throws Exception;
	//getaccnof
		public Long getaccno(Userprofilepojo userprofilepojo)throws Exception;
		//getuserdetails
		public ResultSet getuserdetails(Userprofilepojo userprofilepojo) throws Exception;
		//insuserprofile details:
		 public int insuserprofile(Userprofilepojo userprofilepojo) throws Exception;
		//getuserdetails All
			public ResultSet getuserdetails() throws Exception;
			//removeacc:
			public int removeuserprof(Userprofilepojo userprofilepojo) throws Exception;
			//get max acc:
			public ResultSet getusermaxacc() throws Exception;
			//get max pin:
			public ResultSet getusermaxpin() throws Exception;
			//get user_pin:
			public int getuserpin(String username)throws Exception;
}
