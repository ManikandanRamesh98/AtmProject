package com.atm.withdraw;


import com.atm.impl.AtmMoneyManagementimpl;
import com.atm.impl.UserProfileimpl;
import com.atm.impl.Withdrawimpl;
import com.atm.models.AtmMoneyManagement;
import com.atm.models.Userprofilemodel;

import com.atm.models.Withdrawmodel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdrawserv")
public class Withdrawserv extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		UserProfileimpl userprofiledao = new UserProfileimpl();
		Withdrawimpl withdrawdao = new Withdrawimpl();
		AtmMoneyManagementimpl atmMoneyManagementimpl = new AtmMoneyManagementimpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("withamount");
		
		try {
			//amount less than atm money:
			Long dedbaL = atmMoneyManagementimpl.previousbal();
			if(eamount <= dedbaL) {
			Userprofilemodel userprofilepojo = new Userprofilemodel(uname);
			if (userprofiledao.getbal(userprofilepojo) > 0) {
				int bal = userprofiledao.getbal(userprofilepojo);
				if (eamount <= bal && eamount > 0) {
					int newbal = bal - eamount;
					Userprofilemodel userprofilepojo2 = new Userprofilemodel(uname, newbal);
					int i = userprofiledao.insbal(userprofilepojo2);
					if (i > 0) {
						Userprofilemodel userprofilepojo3 = new Userprofilemodel(uname, newbal);
						Long acc = userprofiledao.getaccno(userprofilepojo3);
						if (acc > 0) {
							Withdrawmodel withdrawpojo = new Withdrawmodel(acc, -eamount);
							withdrawdao.inswith(withdrawpojo);
							session.setAttribute("withamount", eamount);
							session.setAttribute("withbal", newbal);
							//Atm money management:
							Long dedbaL1 = atmMoneyManagementimpl.previousbal() - eamount;
							AtmMoneyManagement atmMoneyManagement = new AtmMoneyManagement(dedbaL1);
							int insatm = atmMoneyManagementimpl.updatebal(atmMoneyManagement);
							if(insatm > 0) {
							res.sendRedirect("Withdrawsucc.jsp");
							}else {
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
			}else {
				res.sendRedirect("NoMoney.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
