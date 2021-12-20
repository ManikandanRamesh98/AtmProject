package com.bank.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Enterpindepservlet")
public class Enterpindeposit extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	int pin = Integer.parseInt(req.getParameter("deppin"));
	Userprofiledao userprofiledao = new Userprofiledao();
	try {
		int userpin = userprofiledao.getuserpin(user);
		if(userpin > 0) {
			if(userpin == pin) {
			res.sendRedirect("depserv");
			}else {
				session.setAttribute("invaliddeppin", true);
				res.sendRedirect("Deposit.jsp");
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
