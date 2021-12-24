package com.atm.controller;
import java.io.IOException;

import com.atm.impl.AtmMoneyManagementImpl;
import com.atm.models.AtmMoneyManagementModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/depagentserv")
public class AtmMoneyManagementController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long eamount = Long.parseLong(req.getParameter("depagentamount"));
		
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String agent = session.getAttribute("agent").toString();
		try {
			Long prevbal = atmMoneyManagementimpl.previousbal();

			if (eamount >= 2000 && eamount <= 50000) {
				if (prevbal <= 2000) {
					AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(eamount, agent);
					try {
						int ins = atmMoneyManagementimpl.depositmoney(atmMoneyManagement);
						if (ins > 0) {
							session.setAttribute("agentdepamount", eamount);
							resp.sendRedirect("AtmMoneymanagementsucc.jsp");
						} else {
							resp.getWriter().println("Something wrong try again!!");
						}
					} catch (Exception e) {
						resp.getWriter().println("Something wrong try again!!");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					resp.getWriter().println("No Need To Refill!!");
				}
			} else {
				resp.getWriter().println("Enter Valid Amount!!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
