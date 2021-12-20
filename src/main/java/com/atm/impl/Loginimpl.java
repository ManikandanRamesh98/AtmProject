package com.atm.impl;

import com.atm.models.Loginpojo;

public interface Loginimpl {
	//remove login details:
	public int removelogindetail(Loginpojo loginpojo) throws Exception;
	//Insert Data in to login table:
    public void insertdata(Loginpojo loginpojo) throws Exception;
}
