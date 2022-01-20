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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			//check if user Exsist:
			if (role != null) {
				
				if (role.equals("user")) {
					//check the user in invalid pin lock table:
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
					//fetch retriveat minutes:
					int retriveat = invalidPinLockDaoimpl.retriveat(invalidPinLockModel);
					System.out.println(retriveat + "ret");
					if(retriveat > 2) {
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
						response.sendRedirect("InvalidPinMax.jsp");
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
