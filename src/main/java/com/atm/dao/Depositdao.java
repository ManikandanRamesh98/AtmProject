package com.atm.dao;

import com.atm.models.DepositModel;

public interface DepositDao {
	// insert deposit:
	public int insdep(DepositModel depositpojo) throws Exception;

	// remove account:
	public int removedep(DepositModel depositpojo) throws Exception;
	
	//check Deposit limit:
			public int checkwithdrawlimit(DepositModel depositModel) throws Exception;
}
