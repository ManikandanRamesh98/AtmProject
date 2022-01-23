package com.atm.dao;

import java.sql.ResultSet;
import java.util.List;

import com.atm.models.TransActionsModel;

public interface MiniStatementDao {
	// Get MiniStatement:
		public List<TransActionsModel> getministatement(Long accno) throws Exception;
}
