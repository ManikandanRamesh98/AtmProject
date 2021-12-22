package com.atm.moneytransfer;

import com.atm.impl.Depositimpl;
import com.atm.impl.UserProfileimpl;
import com.atm.models.Depositmodel;

import com.atm.models.Userprofilemodel;

import com.atm.models.Withdrawmodel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.atm.impl.*;

@WebServlet("/moneytransferserv")
public class Moneytransferserv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("moneytransfname");
		Long accountno = Long.parseLong(req.getParameter("moneytransfaccno"));
		int eamount = Integer.parseInt(req.getParameter("moneytransfamount"));

		Userprofilemodel userprofilemodel = new Userprofilemodel(username, accountno);
		UserProfileimpl userprofileimpl = new UserProfileimpl();
		Withdrawimpl withdrawimpl = new Withdrawimpl();
		Depositimpl depositimpl = new Depositimpl();
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		try {
			int bal = userprofileimpl.moneytransf(userprofilemodel);
			if (bal >= 0) {
				Userprofilemodel userprofilemodel1 = new Userprofilemodel(user);
				int userbal = userprofileimpl.getbal(userprofilemodel1);
				System.out.println(userbal);
				if (eamount <= userbal && eamount > 0 && eamount <= 30000) {
					int withamount = userbal - eamount;
					Userprofilemodel userprofilemodel2 = new Userprofilemodel(user, withamount);
					int upduserbal = userprofileimpl.insbal(userprofilemodel2);
					if (upduserbal > 0) {
						Long useraccountno = userprofileimpl.getaccno(userprofilemodel1);
						Withdrawmodel withdrawmodel = new Withdrawmodel(useraccountno, -eamount,username);
						int inswithuser = withdrawimpl.inswith(withdrawmodel);
						if (inswithuser > 0) {
							Userprofilemodel userprofilemodel3 = new Userprofilemodel(username);
							int userbal2 = userprofileimpl.getbal(userprofilemodel3);
							int depamount = userbal2 + eamount;
							Userprofilemodel userprofilemodel4 = new Userprofilemodel(username, depamount);
							int upduserbal2 = userprofileimpl.insbal(userprofilemodel4);
							if (upduserbal2 > 0) {
								Depositmodel depositmodel = new Depositmodel(accountno, eamount,user);
								int insdepuser2 = depositimpl.insdep(depositmodel);
								if (insdepuser2 > 0) {
									session.setAttribute("moneytransfname", username);
									session.setAttribute("moneytransfamount", eamount);
									resp.sendRedirect("Moneytransfersucc.jsp");
								}

							} else {
								resp.getWriter().println("Something Went Wrong Try again Later!!!");
							}
						} else {
							resp.getWriter().println("Something Went Wrong Try again Later!!!");
						}
					} else {
						resp.getWriter().println("Something Went Wrong Try again Later!!!");
					}
				} else {
					resp.getWriter().println("Enter Valid Amount!!!");
				}
			} else {
				resp.getWriter().println("Invalid Username or Password!!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}