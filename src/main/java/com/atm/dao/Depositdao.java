package com.atm.dao;

import com.atm.models.Depositmodel;

public interface DepositDao {
	// insert deposit:
	public int insdep(Depositmodel depositpojo) throws Exception;

	// remove account:
	public int removedep(Depositmodel depositpojo) throws Exception;
}
