package com.bank.login;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginval")
public class Loginval extends HttpServlet {
	

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		boolean flag = false;
		Userdao userdao = new Userdao();
		Logindetailsdao logindetailsdao = new Logindetailsdao();
		HttpSession session = request.getSession();
		
		
//		//get table:
//		ResultSet rs = null;
//		try {
//			 rs = userdao.gettable();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	try {
		Usernamepasspojo usernamepasspojo = new Usernamepasspojo(uname,pass);
		String role = userdao.getrole(usernamepasspojo);
			if(role != null) {
				if(role.equals("user")) {
					Loginpojo loginpojo = new Loginpojo(uname,role);
					logindetailsdao.insertdata(loginpojo);
					flag = true;
					session.setAttribute("user", uname);
					response.sendRedirect("Welcomepage.jsp");
				}
//					else if(role.equals("agent")) {
//					userdao.insertdata(uname,role);
//					 System.out.println("this is agent!!");
//					flag = true;
//					session.setAttribute("agent", uname);
//					response.sendRedirect("Agent.jsp");
//				}
					else if(role.equals("admin")) {
						Loginpojo loginpojo = new Loginpojo(uname,role);
						logindetailsdao.insertdata(loginpojo);
					System.out.println("this is admin");
					flag = true;
					session.setAttribute("admin", uname);
					response.sendRedirect("Admin.jsp");
				}
			}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		//invaliduser redirect
		
		if(!flag) {
			response.sendRedirect("Invaliduser.jsp");
		}
 	}

	
	

}
