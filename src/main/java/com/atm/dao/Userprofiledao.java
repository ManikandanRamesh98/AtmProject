package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.Userprofilemodel;

public interface UserprofileDao {
	// get balance:
	public int getbal(Userprofilemodel userprofilepojo) throws Exception;

	// ins balance:
	public int insbal(Userprofilemodel userprofilepojo) throws Exception;

	// get account no:
	public Long getaccno(Userprofilemodel userprofilepojo) throws Exception;

	// get user details:
	public ResultSet getuserdetails(Userprofilemodel userprofilepojo) throws Exception;

	// insert user profile details:
	public int insuserprofile(Userprofilemodel userprofilepojo) throws Exception;

	// get user details All
	public ResultSet getuserdetails() throws Exception;

	// remove account:
	public int removeuserprof(Userprofilemodel userprofilepojo) throws Exception;

	// get max account:
	public ResultSet getusermaxacc() throws Exception;

	// get max pin:
	public ResultSet getusermaxpin() throws Exception;

	// get user pin:
	public int getuserpin(String username) throws Exception;
}
