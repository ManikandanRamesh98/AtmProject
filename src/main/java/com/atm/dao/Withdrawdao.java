package com.atm.dao;

import com.atm.models.WithdrawModel;

public interface WithdrawDao {
	// insert withdraw:
	public int inswith(WithdrawModel withdrawpojo) throws Exception;

	// remove account
	public int removewith(WithdrawModel withdrawpojo) throws Exception;
}
