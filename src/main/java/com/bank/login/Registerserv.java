package com.bank.login;

import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/registersucc")
public class Registerserv extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Userdao userdao = new Userdao();
	Userprofiledao userprofiledao = new Userprofiledao();
	Long accno = 0l;
	int userpin = 0;
	try {
		ResultSet rSet = userprofiledao.getusermaxacc();
		ResultSet rSet1 = userprofiledao.getusermaxpin();
		while(rSet.next()) {
			accno = rSet.getLong(1)+1;
		}
		while(rSet1.next()) {
		userpin = rSet1.getInt(1)+1;
		}
	}
	catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String username = req.getParameter("userreg");
	String password = req.getParameter("passreg");
	String role = req.getParameter("rolereg");
	Long mobno = Long.parseLong(req.getParameter("mobnoreg"));
	try {
		int ins = userdao.insusernamepass(username, password, role);
		if(ins > 0) {
			int profins = userprofiledao.insuserprofile(username, accno, mobno, userpin);
			if(profins > 0) {
				HttpSession session = req.getSession();
				session.setAttribute("reguser", username);
				resp.sendRedirect("Registeruserprofilesucc.jsp");
			}
			
		}else {
			resp.getWriter().println("something went wrong!! try again..");
		}
	} catch (Exception e) {
		e.printStackTrace();
}
}
}
