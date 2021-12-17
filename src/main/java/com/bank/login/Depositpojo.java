package com.bank.login;

public class Depositpojo {
private int id;
private Long user_acc_no;
private int dep_amount;
private String dep_at;


@Override
public String toString() {
	return "Depositpojo [id=" + id + ", user_acc_no=" + user_acc_no + ", dep_amount=" + dep_amount + ", dep_at="
			+ dep_at + "]";
}


/**
 * @return the id
 */
public int getId() {
	return id;
}


/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}


/**
 * @return the user_acc_no
 */
public Long getUser_acc_no() {
	return user_acc_no;
}


/**
 * @param user_acc_no the user_acc_no to set
 */
public void setUser_acc_no(Long user_acc_no) {
	this.user_acc_no = user_acc_no;
}


/**
 * @return the dep_amount
 */
public int getDep_amount() {
	return dep_amount;
}


/**
 * @param dep_amount the dep_amount to set
 */
public void setDep_amount(int dep_amount) {
	this.dep_amount = dep_amount;
}


/**
 * @return the dep_at
 */
public String getDep_at() {
	return dep_at;
}


/**
 * @param dep_at the dep_at to set
 */
public void setDep_at(String dep_at) {
	this.dep_at = dep_at;
}


public Depositpojo(int id, Long user_acc_no, int dep_amount, String dep_at) {
	super();
	this.id = id;
	this.user_acc_no = user_acc_no;
	this.dep_amount = dep_amount;
	this.dep_at = dep_at;
}

public Depositpojo(Long user_acc_no, int dep_amount) {
	super();
	
	this.user_acc_no = user_acc_no;
	this.dep_amount = dep_amount;
	
}

public Depositpojo(Long user_acc_no) {
	super();
	
	this.user_acc_no = user_acc_no;
	
}

}
