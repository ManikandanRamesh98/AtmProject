package com.atm.moneytransfer;

import java.io.IOException;

import com.atm.dao.Depositdao;
import com.atm.dao.Userprofiledao;
import com.atm.dao.Withdrawdao;
import com.atm.models.Depositmodel;
import com.atm.models.Userprofilemodel;
import com.atm.models.Withdrawmodel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/moneytransferserv")
public class Moneytransferserv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("moneytransfname");
		Long accountno = Long.parseLong(req.getParameter("moneytransfaccno"));
		int eamount = Integer.parseInt(req.getParameter("moneytransfamount"));

		Userprofilemodel userprofilepojo = new Userprofilemodel(username, accountno);
		Userprofiledao userprofiledao = new Userprofiledao();
		Withdrawdao withdrawdao = new Withdrawdao();
		Depositdao depositdao = new Depositdao();
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		try {
			int bal = userprofiledao.moneytransf(userprofilepojo);
			if (bal >= 0) {
				Userprofilemodel userprofilepojo1 = new Userprofilemodel(user);
				int userbal = userprofiledao.getbal(userprofilepojo1);
				System.out.println(userbal);
				if (eamount <= userbal && eamount > 0 && eamount <= 30000) {
					int withamount = userbal - eamount;
					Userprofilemodel userprofilepojo2 = new Userprofilemodel(user, withamount);
					int upduserbal = userprofiledao.insbal(userprofilepojo2);
					if (upduserbal > 0) {
						Long useraccountno = userprofiledao.getaccno(userprofilepojo1);
						Withdrawmodel withdrawpojo = new Withdrawmodel(useraccountno, -eamount);
						int inswithuser = withdrawdao.inswith(withdrawpojo);
						if (inswithuser > 0) {
							Userprofilemodel userprofilepojo3 = new Userprofilemodel(username);
							int userbal2 = userprofiledao.getbal(userprofilepojo3);
							int depamount = userbal2 + eamount;
							Userprofilemodel userprofilepojo4 = new Userprofilemodel(username, depamount);
							int upduserbal2 = userprofiledao.insbal(userprofilepojo4);
							if (upduserbal2 > 0) {
								Depositmodel depositpojo = new Depositmodel(accountno, eamount);
								int insdepuser2 = depositdao.insdep(depositpojo);
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