package com.atm.dao;


import java.sql.SQLException;
import java.util.List;

import com.atm.models.AtmMoneyManagementModel;

public interface AtmMoneyManagementDao {
	//Deposit money Agent:
	public int depositmoney(AtmMoneyManagementModel atmMoneyManagement) throws SQLException;
	
	//History money Deposited Agent:
	public List<AtmMoneyManagementModel> history() throws SQLException;
	
	//previous balance:
	public Long previousbal() throws SQLException ;
}
