package com.atm.deposit;

import com.atm.impl.Depositimpl;
import com.atm.impl.UserProfileimpl;
import com.atm.models.Depositmodel;

import com.atm.models.Userprofilemodel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/depserv")
public class Depositserv extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		UserProfileimpl userprofileimpl = new UserProfileimpl();
		Depositimpl depositimpl = new Depositimpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("depamount");
		try {
			Userprofilemodel userprofilemodel = new Userprofilemodel(uname);
			// get user balance:
			if (userprofileimpl.getbal(userprofilemodel) > 0) {
				int bal = userprofileimpl.getbal(userprofilemodel);
				// Amount greater than 0 and less than 30000:
				if (eamount > 0 && eamount < 30000) {
					int newbal = bal + eamount;
					Userprofilemodel userprofilemodel2 = new Userprofilemodel(uname, newbal);
					// update New Balance:
					int updatebal = userprofileimpl.insbal(userprofilemodel2);
					if (updatebal > 0) {
						// Get User Account Number:
						Userprofilemodel userprofilemodel3 = new Userprofilemodel(uname);
						Long acc = userprofileimpl.getaccno(userprofilemodel3);
						if (acc > 0) {
							// Insert in Deposit table:
							Depositmodel depositmodel = new Depositmodel(acc, eamount);
							depositimpl.insdep(depositmodel);
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
