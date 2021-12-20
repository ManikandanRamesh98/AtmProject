package com.bank.login;

public class Withdrawpojo {
	private int id;
	private Long useraccno;
	private int withamount;
	private String withdrawat;
	
	
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
	public int getWith_amount() {
		return withamount;
	}
	public void setWith_amount(int with_amount) {
		this.withamount = with_amount;
	}
	public String getWithdraw_at() {
		return withdrawat;
	}
	public void setWithdraw_at(String withdraw_at) {
		this.withdrawat = withdraw_at;
	}
	
	public Withdrawpojo(int id, Long user_acc_no, int with_amount, String withdraw_at) {
	
		this.id = id;
		this.useraccno = user_acc_no;
		this.withamount = with_amount;
		this.withdrawat = withdraw_at;
	}
	
	public Withdrawpojo(Long user_acc_no, int with_amount) {
		
		this.useraccno = user_acc_no;
		this.withamount = with_amount;
		
	}
	
public Withdrawpojo(Long user_acc_no) {
		
		this.useraccno = user_acc_no;
		
	}
	@Override
	public String toString() {
		return "Withdrawpojo [id=" + id + ", user_acc_no=" + useraccno + ", with_amount=" + withamount
				+ ", withdraw_at=" + withdrawat + "]";
	}
	
	
}
