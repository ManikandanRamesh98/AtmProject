package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.RemovedUsersModel;

public interface RemovedUsersDao {
//insert data in removed users table:
	public int insremoveusers(RemovedUsersModel removedusersmodel) throws Exception;

	// fetch users data:
	public ResultSet fetchremoveusers() throws Exception;

}
