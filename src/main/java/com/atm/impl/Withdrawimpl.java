package com.atm.impl;

import com.atm.models.Withdrawmodel;

public interface Withdrawimpl {
	// insert withdraw:
	public int inswith(Withdrawmodel withdrawpojo) throws Exception;

	// remove account
	public int removewith(Withdrawmodel withdrawpojo) throws Exception;
}
