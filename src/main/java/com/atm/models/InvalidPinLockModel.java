package com.atm.models;

import java.sql.Timestamp;

public class InvalidPinLockModel {
private int id;
private String username;
private String acclockedat;
private Timestamp accretriveat;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getAcclockedat() {
	return acclockedat;
}

public void setAcclockedat(String acclockedat) {
	this.acclockedat = acclockedat;
}

public Timestamp getAccretriveat() {
	return accretriveat;
}

public void setAccretriveat(Timestamp accretriveat) {
	this.accretriveat = accretriveat;
}

public InvalidPinLockModel(String username, Timestamp accretriveat) {
	
	this.username = username;
	this.accretriveat = accretriveat;
}


public InvalidPinLockModel(String username) {
	
	this.username = username;
	
}

@Override
public String toString() {
	return "InvalidPinLockModel [id=" + id + ", username=" + username + ", acclockedat=" + acclockedat
			+ ", accretriveat=" + accretriveat + "]";
}

}
