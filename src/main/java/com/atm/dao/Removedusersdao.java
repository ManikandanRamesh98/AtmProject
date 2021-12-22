package com.atm.dao;

import java.sql.ResultSet;

import com.atm.models.Removedusersmodel;

public interface RemovedusersDao {
//insert data in removed users table:
	public int insremoveusers(Removedusersmodel removedusersmodel) throws Exception;

	// fetch users data:
	public ResultSet fetchremoveusers() throws Exception;

}
