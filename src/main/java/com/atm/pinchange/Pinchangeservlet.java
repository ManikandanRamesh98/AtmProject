package com.atm.pinchange;

import java.io.IOException;

import com.atm.dao.Usernamepassworddao;
import com.atm.models.Usernamepasswordmodel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pinchangeserv")
public class Pinchangeservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usernamepassworddao userdao = new Usernamepassworddao();
		String pass = req.getParameter("pininp");
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int i = -1;
		try {
			Usernamepasswordmodel usernamepasspojo = new Usernamepasswordmodel(user, pass);
			i = userdao.pinchange(usernamepasspojo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i > 0) {
			resp.sendRedirect("Pinchangesucc.jsp");
		} else {
			resp.getWriter().println("Something went wrong try again!!!");
		}
	}

}
