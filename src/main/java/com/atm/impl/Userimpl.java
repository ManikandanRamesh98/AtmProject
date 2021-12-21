package com.atm.impl;

import com.atm.models.Usernamepasswordmodel;

public interface Userimpl {
	// get role:
	public String getrole(Usernamepasswordmodel usernamepasspojo) throws Exception;

	// get role1:
	public String getrole1(Usernamepasswordmodel usernamepasspojo) throws Exception;

	// password change:
	public int pinchange(Usernamepasswordmodel usernamepasspojo) throws Exception;

	// insert user name password:
	public int insusernamepass(Usernamepasswordmodel usernamepasspojo) throws Exception;

	// remove account:
	public int removeuser(Usernamepasswordmodel usernamepasspojo) throws Exception;
}
