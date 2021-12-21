package com.atm.deposit;

import com.atm.dao.Depositdao;
import com.atm.dao.Userprofiledao;
import com.atm.models.Depositmodel;
import com.atm.models.Userprofilemodel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.net.aso.b;

@WebServlet("/depserv")
public class Depositserv extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		Userprofiledao userprofiledao = new Userprofiledao();
		Depositdao depositdao = new Depositdao();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("depamount");
		try {
			Userprofilemodel userprofilepojo = new Userprofilemodel(uname);
			// get user balance:
			if (userprofiledao.getbal(userprofilepojo) > 0) {
				int bal = userprofiledao.getbal(userprofilepojo);
				// Amount greater than 0 and less than 30000:
				if (eamount > 0 && eamount < 30000) {
					int newbal = bal + eamount;
					Userprofilemodel userprofilepojo2 = new Userprofilemodel(uname, newbal);
					// update New Balance:
					int updatebal = userprofiledao.insbal(userprofilepojo2);
					if (updatebal > 0) {
						// Get User Account Number:
						Userprofilemodel userprofilepojo3 = new Userprofilemodel(uname);
						Long acc = userprofiledao.getaccno(userprofilepojo3);
						if (acc > 0) {
							// Insert in Deposit table:
							Depositmodel depositpojo = new Depositmodel(acc, eamount);
							depositdao.insdep(depositpojo);
							session.setAttribute("depsuccamount", eamount);
							session.setAttribute("depsuccbal", newbal);
							res.sendRedirect("Depsucc.jsp");
						} else {
							res.getWriter().println("Cant Get User Account No!!");
						}
					} else {
						res.getWriter().println("Something Went Wrong!!");
					}
				} else {
					res.getWriter().println("Enter The Valid Amount!!");
				}
			} else {
				res.sendRedirect("Invaliduser.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
