package com.atm.models;

public class RemovedUsersModel {
private int id;
private long useraccno;
private String username;
private int lastbalance;
private long mobno;
private int userpin;
private String accremovedat;

public RemovedUsersModel(int id, long useraccno, String username, int lastbalance, long mobno, int userpin,
		String accremovedat) {
	super();
	this.id = id;
	this.useraccno = useraccno;
	this.username = username;
	this.lastbalance = lastbalance;
	this.mobno = mobno;
	this.userpin = userpin;
	this.accremovedat = accremovedat;
}


public RemovedUsersModel(long useraccno, String username, int lastbalance, long mobno, int userpin) {
	super();
	this.useraccno = useraccno;
	this.username = username;
	this.lastbalance = lastbalance;
	this.mobno = mobno;
	this.userpin = userpin;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public long getUseraccno() {
	return useraccno;
}

public void setUseraccno(long useraccno) {
	this.useraccno = useraccno;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getLastbalance() {
	return lastbalance;
}

public void setLastbalance(int lastbalance) {
	this.lastbalance = lastbalance;
}

public long getMobno() {
	return mobno;
}

public void setMobno(long mobno) {
	this.mobno = mobno;
}

public int getUserpin() {
	return userpin;
}

public void setUserpin(int userpin) {
	this.userpin = userpin;
}

public String getAccremovedat() {
	return accremovedat;
}

public void setAccremovedat(String accremovedat) {
	this.accremovedat = accremovedat;
}

@Override
public String toString() {
	return "Removedusersmodel [id=" + id + ", useraccno=" + useraccno + ", username=" + username + ", lastbalance="
			+ lastbalance + ", mobno=" + mobno + ", userpin=" + userpin + ", accremovedat=" + accremovedat + "]";
}


}
