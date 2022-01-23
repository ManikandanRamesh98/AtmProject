package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.daoimpl.TransActionsImpl;
import com.atm.daoimpl.UserProfileImpl;

import com.atm.exception.AtmOutOfCashException;
import com.atm.exception.LowBalanceException;
import com.atm.models.AtmMoneyManagementModel;
import com.atm.models.TransActionsModel;
import com.atm.models.UserProfileModel;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdrawserv")
public class WithdrawController extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		TransActionsModel transActionsModel = new TransActionsModel();
		TransActionsImpl transActionsImpl = new TransActionsImpl(); 
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("withamount");
		UserProfileModel userprofilemodel4 = new UserProfileModel(uname);
		Long accno;

		try {

			accno = userprofileimpl.getaccno(userprofilemodel4);
			
			//
			transActionsModel.setUserAccnoLong(accno);
			int withdrawSum = transActionsImpl.checkwithdrawlimit(transActionsModel);
			int withdrawCheck = 0;
			// amount should be less than 10000:
			if (eamount <= 10000) {
				// withdraw sum should be less than 10000:
				withdrawCheck = eamount + withdrawSum;
				if (withdrawCheck <= 10000) {
					// amount less than atm money:
					Long dedbaL = atmMoneyManagementimpl.previousbal();
					if (eamount <= dedbaL) {
						UserProfileModel userprofilemodel = new UserProfileModel(uname);
						if (userprofileimpl.getbal(userprofilemodel) >= 0) {
							int bal = userprofileimpl.getbal(userprofilemodel);
							if (eamount <= bal && eamount > 0) {

								int newbal = bal - eamount;
								UserProfileModel userprofilemodel2 = new UserProfileModel(uname, newbal);
								int i = userprofileimpl.insbal(userprofilemodel2);
								if (i > 0) {
									UserProfileModel userprofilemodel3 = new UserProfileModel(uname, newbal);
									Long acc = userprofileimpl.getaccno(userprofilemodel3);
										transActionsModel.setUserAccnoLong(acc);
										transActionsModel.setTransActionAmount(-eamount);
										transActionsModel.setTransActionType("withdraw");
										transActionsImpl.insertTransAction(transActionsModel);
										session.setAttribute("withamount", eamount);
										session.setAttribute("withbal", newbal);
										// Atm money management:
										Long dedbaL1 = atmMoneyManagementimpl.previousbal() - eamount;
										AtmMoneyManagementModel atmMoneyManagement = new AtmMoneyManagementModel(
												dedbaL1);
										int insatm = atmMoneyManagementimpl.updatebal(atmMoneyManagement);
										if (insatm > 0) {
											res.sendRedirect("Withdrawsucc.jsp");
										} else {
											res.getWriter().println("something went wrong!!");
										}
								} else {
									res.getWriter().println("something went wrong!!");
								}

							} else {
								throw new LowBalanceException();
							}
						} else {
							res.sendRedirect("Invaliduser.jsp");
						}
					} else {
						throw new AtmOutOfCashException();

					}
				} else {
					int remainingWithdraw = (10000 - withdrawSum);
					if (remainingWithdraw > 0) {
						session.setAttribute("remainingWithdraw", remainingWithdraw);
						res.sendRedirect("Withdraw.jsp");
					} else {
						res.sendRedirect("WithdrawLimitExceed.jsp");
					}
				}
			} else {

				session.setAttribute("amountexceed", true);
				res.sendRedirect("Withdraw.jsp");
			}

		} catch (AtmOutOfCashException e) {
			res.sendRedirect(e.getMessage());
		} catch (LowBalanceException e) {
			res.sendRedirect(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
