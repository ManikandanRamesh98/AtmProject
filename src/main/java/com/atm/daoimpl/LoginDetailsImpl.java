package com.atm.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.atm.dao.LoginDetailsDao;
import com.atm.models.LoginDetailsModel;
import com.atm.util.ConnectionUtil;


public class LoginDetailsImpl implements LoginDetailsDao {
	// Remove Account:
	public int removelogindetail(LoginDetailsModel loginpojo) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		int res = -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "delete from login where username in ?";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, loginpojo.getUsername());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				
				}
				if(con != null) {
					con.close();
				}
			}

	
		return res;
		
	}

	// Insert Data in to login table:
	public int insertdata(LoginDetailsModel loginpojo) throws SQLException {

		Connection con = null;
		PreparedStatement statement = null;
		int res= -1;
		try {
			con = ConnectionUtil.getConnection();
			String query = "insert into login(username,role) values(?,?)";
			String query1 = "commit";
			statement = con.prepareStatement(query);
			statement.setString(1, loginpojo.getUsername());
			statement.setString(2, loginpojo.getRole());
			res = statement.executeUpdate();
			statement.executeUpdate(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
				
				}
				if(con != null) {
					con.close();
				}
			}
		return res;
		
	}
	
	//fetch login details:
	public List<LoginDetailsModel> fetchlogin()throws SQLException {
		Connection con = null;
		Statement statement = null;
		List<LoginDetailsModel> loginDetailsModels = new ArrayList<>();;
		try {
			con = ConnectionUtil.getConnection();
		String query = "select id,username,substr(logged_at,1,14),role from login order by logged_at desc";
		statement = con.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		
		while(rSet.next()) {
			loginDetailsModels.add(new LoginDetailsModel(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4)));
		}
		} catch (Exception e) {
			e.printStackTrace();
		
	}finally {
		if(statement != null) {
			statement.close();
			
			}
			if(con != null) {
				con.close();
			}
		}
		return loginDetailsModels;

}
}
