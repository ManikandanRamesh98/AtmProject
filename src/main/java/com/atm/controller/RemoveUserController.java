package com.atm.controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.atm.daoimpl.DepositImpl;
import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.daoimpl.RemovedUsersImpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.daoimpl.WithdrawImpl;
import com.atm.exception.InvalidUsernameAdminException;
import com.atm.models.DepositModel;
import com.atm.models.LoginDetailsModel;

import com.atm.models.RemovedUsersModel;

import com.atm.models.UsernamePasswordModel;

import com.atm.models.UserProfileModel;

import com.atm.models.WithdrawModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/removeaccserv")
public class RemoveUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginDetailsImpl logindetailsimpl = new LoginDetailsImpl();
		WithdrawImpl withdrawimpl = new WithdrawImpl();
		DepositImpl depositimpl = new DepositImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		RemovedUsersImpl removedusersimpl = new RemovedUsersImpl();
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		HttpSession session = req.getSession();
		String user = req.getParameter("remusername");
		int id = Integer.parseInt(req.getParameter("remuserid"));
		Long accno = -1l;
		try {
			UserProfileModel userprofilemodel = new UserProfileModel(user);
			accno = userprofileimpl.getaccno(userprofilemodel);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			LoginDetailsModel loginmodel = new LoginDetailsModel(user);
			int lrem = logindetailsimpl.removelogindetail(loginmodel);
			if (lrem >= 0) {
				WithdrawModel withdrawmodel = new WithdrawModel(accno);
				int withrem = withdrawimpl.removewith(withdrawmodel);
				if (withrem >= 0) {
					DepositModel depositmodel = new DepositModel(accno);
					int deprem = depositimpl.removedep(depositmodel);
					if (deprem >= 0) {
						UserProfileModel userprofilemodel = new UserProfileModel(user);
						ResultSet resultSet = userprofileimpl.getuserdetails(userprofilemodel);
						while (resultSet.next()) {
							int lastbalance = resultSet.getInt(4);
							Long mobno = resultSet.getLong(5);
							int userpin = resultSet.getInt(6);
							RemovedUsersModel removedusersmodel = new RemovedUsersModel(accno, user, lastbalance, mobno,
									userpin);
							removedusersimpl.insremoveusers(removedusersmodel);
						}
					}
					UserProfileModel userprofilemodel = new UserProfileModel(accno, id);
					int userprofrem = userprofileimpl.removeuserprof(userprofilemodel);
					if (userprofrem > 0) {
						UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(user);
						int userrem = userimpl.removeuser(usernamepassmodel);
						if (userrem > 0) {

							resp.sendRedirect("Userrem.jsp");
						} else {
							resp.getWriter().println("Invalid UserName");
						}
					} else {
						UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(user);
						int userrem = userimpl.removeuser(usernamepassmodel);
						if (userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						} else {
							throw new InvalidUsernameAdminException();
						}
					}
				}
			}

		} catch (InvalidUsernameAdminException e) {
			resp.sendRedirect(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
