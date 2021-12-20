package com.atm.impl;

import com.atm.models.Usernamepasspojo;

public interface Userimpl {
	//get role:
	public String getrole(Usernamepasspojo usernamepasspojo) throws Exception;
	  //get role1:
    public String getrole1(Usernamepasspojo usernamepasspojo) throws Exception;
  //passchange:
  	public int pinchange(Usernamepasspojo usernamepasspojo) throws Exception;
  //insusernamepass:
    public int insusernamepass(Usernamepasspojo usernamepasspojo) throws Exception;
  //removeacc:
    public int removeuser(Usernamepasspojo usernamepasspojo) throws Exception;
}
