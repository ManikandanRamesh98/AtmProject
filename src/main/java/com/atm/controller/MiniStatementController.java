package com.atm.controller;

import java.io.IOException;
import java.util.List;

import com.atm.daoimpl.MiniStatementImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/minisateserv")

public class MiniStatementController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("index.jsp");
		} else {
			user = session.getAttribute("user").toString();
		}
		UserProfileImpl userProfileImpl = new UserProfileImpl();
		UserProfileModel userprofilepojo = new UserProfileModel(user);
		try {
			Long accno = userProfileImpl.getaccno(userprofilepojo);
			MiniStatementImpl miniStatementImpl = new MiniStatementImpl();
			List<TransActionsModel> ministatementobj = miniStatementImpl.getministatement(accno);
			req.setAttribute("ministatementjspobj", ministatementobj);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Ministatement.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
