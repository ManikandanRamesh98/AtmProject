package com.atm.controller;



import java.io.IOException;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.exception.InvalidEntriesException;
import com.atm.models.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginval")
public class LoginValidationController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		boolean flag = false;
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		LoginDetailsImpl logindetailsimpl = new LoginDetailsImpl();
		HttpSession session = request.getSession();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl();
		InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(uname);
		try {
			UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(uname, pass);
			String role = userimpl.getrole(usernamepassmodel);
			if (role != null) {
				
				
				if (role.equals("user")) {
					if(!(invalidPinLockDaoimpl.status(invalidPinLockModel))) {
					if(session.getAttribute("invalidpinlock") == null) {
						session.setAttribute("invalidpinlock", 0);
					}
					LoginDetailsModel loginmodel = new LoginDetailsModel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					flag = true;
					session.setAttribute("user", uname);
					response.sendRedirect("Welcomepage.jsp");
				}else {
					int retriveat = invalidPinLockDaoimpl.retriveat(invalidPinLockModel);
					System.out.println(retriveat + "ret");
					if(retriveat > 5) {
						invalidPinLockDaoimpl.deletelock(invalidPinLockModel);
						if(session.getAttribute("invalidpinlock") == null) {
							session.setAttribute("invalidpinlock", 0);
						}
						LoginDetailsModel loginmodel = new LoginDetailsModel(uname, role);
						logindetailsimpl.insertdata(loginmodel);
						flag = true;
						session.setAttribute("user", uname);
						response.sendRedirect("Welcomepage.jsp");
					}else {
						flag = true;
						response.getWriter().println("yor account is lockes try after 2 Min!!");
					}
				}
				}

				else if (role.equals("admin")) {
					LoginDetailsModel loginmodel = new LoginDetailsModel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					System.out.println("this is admin");
					flag = true;
					session.setAttribute("admin", uname);
					response.sendRedirect("Admin.jsp");
				}else if(role.equals("agent")) {
					LoginDetailsModel loginmodel = new LoginDetailsModel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					System.out.println("this is agent");
					flag = true;
					session.setAttribute("agent", uname);
					response.sendRedirect("Agent.jsp");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// invalid user redirect:
try {
		if (!flag) {
/*			response.sendRedirect("Invaliduser.jsp");*/
			throw new InvalidEntriesException();
		}
}catch(InvalidEntriesException e) {
	String red = e.getMessage();
	response.sendRedirect(red);
}
	}

}
