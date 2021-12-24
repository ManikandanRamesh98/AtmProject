package com.atm.models;

public class UsernamePasswordModel {
	private int id;
	private String username;
	private String password;
	private String created_at;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UsernamePasswordModel(int id, String username, String password, String created_at, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.created_at = created_at;
		this.role = role;
	}

	public UsernamePasswordModel(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public UsernamePasswordModel(String username) {

		this.username = username;
	}

	public UsernamePasswordModel(String username, String password, String role) {

		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usernamepasspojo [id=" + id + ", username=" + username + ", password=" + password + ", created_at="
				+ created_at + ", role=" + role + "]";
	}

}
