package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.AtmMoneyManagementModel;

public interface AtmMoneyManagementDao {
	//Deposit money Agent:
	public int depositmoney(AtmMoneyManagementModel atmMoneyManagement) throws Exception;
	
	//History money Deposited Agent:
	public ResultSet history() throws Exception;
}
