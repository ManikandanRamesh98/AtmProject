package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.WithdrawImpl;
import com.atm.exception.AtmOutOfCashException;
import com.atm.exception.LowBalanceException;
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
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		WithdrawImpl withdrawimpl = new WithdrawImpl();
		AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("withamount");
		UserProfileModel userprofilemodel4 = new UserProfileModel(uname);
		Long accno;

		try {

			accno = userprofileimpl.getaccno(userprofilemodel4);
			WithdrawModel withdrawModel = new WithdrawModel();
			withdrawModel.setUser_acc_no(accno);
			int withdrawSum = withdrawimpl.checkwithdrawlimit(withdrawModel);
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
									if (acc > 0) {
										WithdrawModel withdrawmodel = new WithdrawModel(acc, -eamount);
										withdrawimpl.inswith(withdrawmodel);
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
										System.out.println("cant get useracc");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
