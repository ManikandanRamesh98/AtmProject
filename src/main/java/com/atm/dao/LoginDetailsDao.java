package com.atm.dao;

import java.sql.ResultSet;
import java.util.List;

import com.atm.models.LoginDetailsModel;

public interface LoginDetailsDao {
	// remove login details:
	public int removelogindetail(LoginDetailsModel loginpojo) throws Exception;

	// Insert Data in to login table:
	public int insertdata(LoginDetailsModel loginpojo) throws Exception;
	
	//fetch login details:
		public List<LoginDetailsModel> fetchlogin()throws Exception;
}
