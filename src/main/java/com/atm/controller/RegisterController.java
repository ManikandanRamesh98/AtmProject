package com.atm.controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.atm.models.UsernamePasswordModel;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.exception.MobileNoAlreadyRegException;
import com.atm.exception.UserNameAlreadyExistException;
import com.atm.models.UserProfileModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registersucc")
public class RegisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		Long accno = 0l;
		int userpin = 0;
		try {
			if (userprofileimpl.getusermaxacc() > 0 && userprofileimpl.getusermaxpin() > 0) {
				accno = userprofileimpl.getusermaxacc() + 1;
				userpin = userprofileimpl.getusermaxpin() + 1;
			} else {
				accno = 12345678901l;
				userpin = 1234;
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = req.getParameter("userreg");
		String password = req.getParameter("passreg");
		String role = req.getParameter("rolereg");
		Long mobno = Long.parseLong(req.getParameter("mobnoreg"));
		UserProfileModel userProfileModel = new UserProfileModel(mobno, "s");
		UserProfileImpl userProfileImpl2 = new UserProfileImpl();
		boolean flag = false;
		try {
			flag = userProfileImpl2.usermobileexist(userProfileModel);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (!flag) {
				UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(username, password, role);
				int ins = userimpl.insusernamepass(usernamepassmodel);
				if (ins > 0) {
					if (role.equals("admin")) {
						HttpSession session = req.getSession();
						session.setAttribute("adminreg", username);
						resp.sendRedirect("Adminregsucc.jsp");
					} else if (role.equals("agent")) {
						HttpSession session = req.getSession();
						session.setAttribute("agentreg", username);
						resp.sendRedirect("Agentregsucc.jsp");
					} else {
						UserProfileModel userprofilemodel = new UserProfileModel(username, accno, mobno, userpin);
						int profins = userprofileimpl.insuserprofile(userprofilemodel);
						if (profins > 0) {
							HttpSession session = req.getSession();
							session.setAttribute("reguser", username);
							resp.sendRedirect("Registeruserprofilesucc.jsp");
						} else {
							throw new MobileNoAlreadyRegException();
						}
					}

				} else {
					throw new UserNameAlreadyExistException();
				}
			} else {
				throw new MobileNoAlreadyRegException();
			}
		} catch (UserNameAlreadyExistException e) {
			// TODO: handle exception
			resp.sendRedirect(e.getMessage());
		} catch (MobileNoAlreadyRegException e) {
			resp.sendRedirect(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
