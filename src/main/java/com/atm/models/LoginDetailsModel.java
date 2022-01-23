package com.atm.models;

import java.util.Objects;

public class LoginDetailsModel {
	private int id;
	private String username;
	private String loggedat;
	private String role;

	public LoginDetailsModel(int id, String username, String loggedat, String role) {

		this.id = id;
		this.username = username;
		this.loggedat = loggedat;
		this.role = role;
	}

	public LoginDetailsModel(String username) {
		this.username = username;
	}

	public LoginDetailsModel(String username, String role) {
		this.username = username;
		this.role = role;
	}

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

	public String getLoggedat() {
		return loggedat;
	}

	public void setLoggedat(String loggedat) {
		this.loggedat = loggedat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Loginpojo [Id=" + id + ", username=" + username + ", logged_at=" + loggedat + ", Role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role, loggedat, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetailsModel other = (LoginDetailsModel) obj;
		return id == other.id && Objects.equals(role, other.role) && Objects.equals(loggedat, other.loggedat)
				&& Objects.equals(username, other.username);
	}

}
