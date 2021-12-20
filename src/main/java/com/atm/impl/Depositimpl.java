package com.atm.impl;

import com.atm.models.Depositpojo;

public interface Depositimpl {
	//insert deposit:
	public int insdep(Depositpojo depositpojo)throws Exception;
	//remove account:
		public int removedep(Depositpojo depositpojo) throws Exception;
}
