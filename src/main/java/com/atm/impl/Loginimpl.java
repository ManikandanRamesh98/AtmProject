package com.atm.impl;

import com.atm.models.Loginmodel;

public interface Loginimpl {
	// remove login details:
	public int removelogindetail(Loginmodel loginpojo) throws Exception;

	// Insert Data in to login table:
	public void insertdata(Loginmodel loginpojo) throws Exception;
}
