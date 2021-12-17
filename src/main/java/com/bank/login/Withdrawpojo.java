package com.bank.login;

public class Withdrawpojo {
	private int id;
	private Long user_acc_no;
	private int with_amount;
	private String withdraw_at;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUser_acc_no() {
		return user_acc_no;
	}
	public void setUser_acc_no(Long user_acc_no) {
		this.user_acc_no = user_acc_no;
	}
	public int getWith_amount() {
		return with_amount;
	}
	public void setWith_amount(int with_amount) {
		this.with_amount = with_amount;
	}
	public String getWithdraw_at() {
		return withdraw_at;
	}
	public void setWithdraw_at(String withdraw_at) {
		this.withdraw_at = withdraw_at;
	}
	public Withdrawpojo(int id, Long user_acc_no, int with_amount, String withdraw_at) {
	
		this.id = id;
		this.user_acc_no = user_acc_no;
		this.with_amount = with_amount;
		this.withdraw_at = withdraw_at;
	}
	
	public Withdrawpojo(Long user_acc_no, int with_amount) {
		
		this.user_acc_no = user_acc_no;
		this.with_amount = with_amount;
		
	}
	
public Withdrawpojo(Long user_acc_no) {
		
		this.user_acc_no = user_acc_no;
		
	}
	@Override
	public String toString() {
		return "Withdrawpojo [id=" + id + ", user_acc_no=" + user_acc_no + ", with_amount=" + with_amount
				+ ", withdraw_at=" + withdraw_at + "]";
	}
	
	
}
