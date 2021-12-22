package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.AtmMoneyManagement;

public interface AtmMoneyManagementdao {
	//Deposit money Agent:
	public int depositmoney(AtmMoneyManagement atmMoneyManagement) throws Exception;
	
	//History money Deposited Agent:
	public ResultSet history() throws Exception;
}
