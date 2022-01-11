package com.atm.models;

public class WithdrawModel {
	private int id;
	private Long useraccno;
	private int withamount;
	private String withdrawat;
	private String moneytransfer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUser_acc_no() {
		return useraccno;
	}
	
	public String getmoneytransfer() {
		return this.moneytransfer;
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

	public WithdrawModel(int id, Long user_acc_no, int with_amount, String withdraw_at) {

		this.id = id;
		this.useraccno = user_acc_no;
		this.withamount = with_amount;
		this.withdrawat = withdraw_at;
	}

	public WithdrawModel() {
		super();
	}

	public WithdrawModel(Long user_acc_no, int with_amount) {

		this.useraccno = user_acc_no;
		this.withamount = with_amount;

	}

	public WithdrawModel(Long user_acc_no) {

		this.useraccno = user_acc_no;

	}

	public WithdrawModel(Long user_acc_no, int with_amount, String moneytransfname) {

		this.useraccno = user_acc_no;
		this.withamount = with_amount;
		this.moneytransfer = moneytransfname;
	}

	@Override
	public String toString() {
		return "Withdrawpojo [id=" + id + ", user_acc_no=" + useraccno + ", with_amount=" + withamount
				+ ", withdraw_at=" + withdrawat + "]";
	}

}
