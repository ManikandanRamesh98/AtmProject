package com.atm.models;

public class Depositpojo {
private int id;
private Long useraccno;
private int depamount;
private String depat;


@Override
public String toString() {
	return "Depositpojo [id=" + id + ", user_acc_no=" + useraccno + ", dep_amount=" + depamount + ", dep_at="
			+ depat + "]";
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public Long getUser_acc_no() {
	return useraccno;
}



public void setUser_acc_no(Long user_acc_no) {
	this.useraccno = user_acc_no;
}



public int getDep_amount() {
	return depamount;
}


public void setDep_amount(int dep_amount) {
	this.depamount = dep_amount;
}



public String getDep_at() {
	return depat;
}



public void setDep_at(String dep_at) {
	this.depat = dep_at;
}


public Depositpojo(int id, Long user_acc_no, int dep_amount, String dep_at) {
	
	this.id = id;
	this.useraccno = user_acc_no;
	this.depamount = dep_amount;
	this.depat = dep_at;
}

public Depositpojo(Long user_acc_no, int dep_amount) {
	
	
	this.useraccno = user_acc_no;
	this.depamount = dep_amount;
	
}

public Depositpojo(Long user_acc_no) {
	
	
	this.useraccno = user_acc_no;
	
}

}
