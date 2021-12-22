package com.atm.dao;

import com.atm.models.Loginmodel;

public interface LoginDao {
	// remove login details:
	public int removelogindetail(Loginmodel loginpojo) throws Exception;

	// Insert Data in to login table:
	public void insertdata(Loginmodel loginpojo) throws Exception;
}
