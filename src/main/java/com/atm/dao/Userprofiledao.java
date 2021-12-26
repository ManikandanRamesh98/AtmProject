package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.UserProfileModel;

public interface UserprofileDao {
	// get balance:
	public int getbal(UserProfileModel userprofilepojo) throws Exception;

	// ins balance:
	public int insbal(UserProfileModel userprofilepojo) throws Exception;

	// get account no:
	public Long getaccno(UserProfileModel userprofilepojo) throws Exception;

	// get user details:
	public ResultSet getuserdetails(UserProfileModel userprofilepojo) throws Exception;

	// insert user profile details:
	public int insuserprofile(UserProfileModel userprofilepojo) throws Exception;

	// get user details All
	public ResultSet getuserdetails() throws Exception;

	// remove account:
	public int removeuserprof(UserProfileModel userprofilepojo) throws Exception;

	// get max account:
	public long getusermaxacc() throws Exception;

	// get max pin:
	public int getusermaxpin() throws Exception;

	// get user pin:
	public int getuserpin(String username) throws Exception;
}
