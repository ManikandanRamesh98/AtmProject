package com.atm.dao;

import com.atm.models.Withdrawmodel;

public interface WithdrawDao {
	// insert withdraw:
	public int inswith(Withdrawmodel withdrawpojo) throws Exception;

	// remove account
	public int removewith(Withdrawmodel withdrawpojo) throws Exception;
}
