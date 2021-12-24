package com.atm.controller;

import com.atm.impl.AtmMoneyManagementImpl;
import com.atm.impl.UserProfileImpl;
import com.atm.impl.WithdrawImpl;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.models.UserProfileModel;

import com.atm.models.WithdrawModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdrawserv")
public class WithdrawController extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		WithdrawImpl withdrawimpl = new WithdrawImpl();
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("withamount");

		try {
			// amount less than atm money:
			Long dedbaL = atmMoneyManagementimpl.previousbal();
			if (eamount <= dedbaL) {
				UserProfileModel userprofilemodel = new UserProfileModel(uname);
				if (userprofileimpl.getbal(userprofilemodel) > 0) {
					int bal = userprofileimpl.getbal(userprofilemodel);
					if (eamount <= bal && eamount > 0) {
						int newbal = bal - eamount;
						UserProfileModel userprofilemodel2 = new UserProfileModel(uname, newbal);
						int i = userprofileimpl.insbal(userprofilemodel2);
						if (i > 0) {
							UserProfileModel userprofilemodel3 = new UserProfileModel(uname, newbal);
							Long acc = userprofileimpl.getaccno(userprofilemodel3);
							if (acc > 0) {
								WithdrawModel withdrawmodel = new WithdrawModel(acc, -eamount);
								withdrawimpl.inswith(withdrawmodel);
								session.setAttribute("withamount", eamount);
								session.setAttribute("withbal", newbal);
								// Atm money management:
								Long dedbaL1 = atmMoneyManagementimpl.previousbal() - eamount;
								AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(dedbaL1);
								int insatm = atmMoneyManagementimpl.updatebal(atmMoneyManagement);
								if (insatm > 0) {
									res.sendRedirect("Withdrawsucc.jsp");
								} else {
									res.getWriter().println("something went wrong!!");
								}
							} else {
								System.out.println("cant get useracc");
							}
						} else {
							res.getWriter().println("something went wrong!!");
						}
					} else {
						res.getWriter().println("enter the valid amount!!");
					}
				} else {
					res.sendRedirect("Invaliduser.jsp");
				}
			} else {
				res.sendRedirect("NoMoney.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
