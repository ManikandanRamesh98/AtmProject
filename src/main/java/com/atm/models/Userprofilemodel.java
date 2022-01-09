package com.atm.models;

public class UserProfileModel {
	private int id;
	private String username;
	private Long user_acc_no;
	private int balance;
	private Long mob_no;
	private int user_pin;
	private String acc_created_at;

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

	public Long getUser_acc_no() {
		return user_acc_no;
	}

	public void setUser_acc_no(Long user_acc_no) {
		this.user_acc_no = user_acc_no;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Long getMob_no() {
		return mob_no;
	}

	public void setMob_no(Long mob_no) {
		this.mob_no = mob_no;
	}

	public int getUser_pin() {
		return user_pin;
	}

	public void setUser_pin(int user_pin) {
		this.user_pin = user_pin;
	}

	public String getAcc_created_at() {
		return acc_created_at;
	}

	public void setAcc_created_at(String acc_created_at) {
		this.acc_created_at = acc_created_at;
	}

	public UserProfileModel(int id, String username, Long user_acc_no, int balance, Long mob_no, int user_pin,
			String acc_created_at) {
		super();
		this.id = id;
		this.username = username;
		this.user_acc_no = user_acc_no;
		this.balance = balance;
		this.mob_no = mob_no;
		this.user_pin = user_pin;
		this.acc_created_at = acc_created_at;
	}

	public UserProfileModel(String username, int balance) {

		this.username = username;
		this.balance = balance;
	}

	public UserProfileModel(String username) {

		this.username = username;
	}

	public UserProfileModel(String username, Long user_acc_no, Long mob_no, int user_pin) {

		this.username = username;
		this.user_acc_no = user_acc_no;
		this.mob_no = mob_no;
		this.user_pin = user_pin;
	}
	public UserProfileModel(int user_pin,String username) {

		this.username = username;
		this.user_pin = user_pin;
	}
	public UserProfileModel(Long acc_no) {

		this.user_acc_no = acc_no;
	}
	public UserProfileModel(Long acc_no,int id) {

		this.user_acc_no = acc_no;
		this.id = id;
	}
	public UserProfileModel(Long mob_no,String s) {

		this.mob_no = mob_no;
	}
	public UserProfileModel(String username, Long user_acc_no) {

		this.username = username;
		this.user_acc_no = user_acc_no;
	}
	

	@Override
	public String toString() {
		return "Userprofilepojo [id=" + id + ", username=" + username + ", user_acc_no=" + user_acc_no + ", balance="
				+ balance + ", mob_no=" + mob_no + ", user_pin=" + user_pin + ", acc_created_at=" + acc_created_at
				+ "]";
	}

}
