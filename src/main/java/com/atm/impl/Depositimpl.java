package com.atm.impl;

import com.atm.models.Depositmodel;

public interface Depositimpl {
	// insert deposit:
	public int insdep(Depositmodel depositpojo) throws Exception;

	// remove account:
	public int removedep(Depositmodel depositpojo) throws Exception;
}
