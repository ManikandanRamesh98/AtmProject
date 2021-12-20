package com.atm.impl;

import com.atm.models.Withdrawpojo;

public interface Withdrawimpl {
	//insert withdraw:
	public int inswith(Withdrawpojo withdrawpojo)throws Exception;
	//remove account
		public int removewith(Withdrawpojo withdrawpojo) throws Exception;
}
