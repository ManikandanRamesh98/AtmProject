package com.atm.dao;

import com.atm.models.UsernamePasswordModel;

public interface UsernamePasswordDao {
	// get role:
	public String getrole(UsernamePasswordModel usernamepasspojo) throws Exception;

	// password change:
	public int pinchange(UsernamePasswordModel usernamepasspojo) throws Exception;

	// insert user name password:
	public int insusernamepass(UsernamePasswordModel usernamepasspojo) throws Exception;

	// remove account:
	public int removeuser(UsernamePasswordModel usernamepasspojo) throws Exception;
}
