package com.atm.controller;

import com.atm.daoimpl.*;
import com.atm.models.DepositModel;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;

import com.atm.models.WithdrawModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/moneytransferserv")
public class MoneyTransferController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("moneytransfname");
		Long accountno = Long.parseLong(req.getParameter("moneytransfaccno"));
		int eamount = Integer.parseInt(req.getParameter("moneytransfamount"));
		
TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl();
		UserProfileModel userprofilemodel = new UserProfileModel(username, accountno);
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		try {
			//fetch sender balance:
			int bal = userprofileimpl.moneytransf(userprofilemodel);
			if (bal >= 0) {
				UserProfileModel userprofilemodel1 = new UserProfileModel(user);
				int userbal = userprofileimpl.getbal(userprofilemodel1);
				
				if (eamount <= userbal && eamount > 0 && eamount <= 30000) {
					int withamount = userbal - eamount;
					UserProfileModel userprofilemodel2 = new UserProfileModel(user, withamount);
					userprofileimpl.insbal(userprofilemodel2);
						Long useraccountno = userprofileimpl.getaccno(userprofilemodel1);
						
						transActionsModel.setUserAccnoLong(useraccountno);
						transActionsModel.setTransActionAmount(-eamount);
						transActionsModel.setTransActionType("withdraw");
						transActionsModel.setMoneyTransfer("Money Transfer To" + username);
						transActionsImpl.insertTransAction(transActionsModel);
						
							//fetch receiver balance:
							UserProfileModel userprofilemodel3 = new UserProfileModel(username);
							int userbal2 = userprofileimpl.getbal(userprofilemodel3);
							//add received amount:
							int depamount = userbal2 + eamount;
							UserProfileModel userprofilemodel4 = new UserProfileModel(username, depamount);
							int upduserbal2 = userprofileimpl.insbal(userprofilemodel4);
							if (upduserbal2 > 0) {
								
								transActionsModel.setUserAccnoLong(accountno);
								transActionsModel.setTransActionAmount(eamount);
								transActionsModel.setTransActionType("deposit");
								transActionsModel.setMoneyTransfer("Money Transfer From" + user);
								int insdepuser = transActionsImpl.insertTransAction(transActionsModel);
								if (insdepuser > 0) {
									session.setAttribute("moneytransfname", username);
									session.setAttribute("moneytransfamount", eamount);
									UserProfileModel userprofilepojo = new UserProfileModel(user);
									UserProfileImpl userprofiledao = new UserProfileImpl();
									int userbal3 = userprofiledao.getbal(userprofilepojo);
									session.setAttribute("userbalint", userbal3);
									resp.sendRedirect("Moneytransfersucc.jsp");
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
			e.printStackTrace();
		}
	}
}