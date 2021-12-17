package com.bank.login;

import java.util.Objects;

public class Loginpojo {
private int id;
private String username;
private String logged_at;
private String role;


public Loginpojo(int id, String username, String logged_at, String role) {
	
	id = id;
	this.username = username;
	this.logged_at = logged_at;
	role = role;
}

public Loginpojo(String username) {
	this.username = username;
}

public Loginpojo(String username,String role) {
	this.username = username;
	this.role = role;
}



public int getId() {
	return id;
}

public void setId(int id) {
	id = id;
}


public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}


public String getLogged_at() {
	return logged_at;
}


public void setLogged_at(String logged_at) {
	this.logged_at = logged_at;
}


public String getRole() {
	return role;
}


public void setRole(String role) {
	role = role;
}

@Override
public String toString() {
	return "Loginpojo [Id=" + id + ", username=" + username + ", logged_at=" + logged_at + ", Role=" + role + "]";
}







@Override
public int hashCode() {
	return Objects.hash(id, role, logged_at, username);
}







@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Loginpojo other = (Loginpojo) obj;
	return id == other.id && Objects.equals(role, other.role) && Objects.equals(logged_at, other.logged_at)
			&& Objects.equals(username, other.username);
}


}
