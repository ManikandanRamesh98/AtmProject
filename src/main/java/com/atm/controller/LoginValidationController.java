package com.atm.controller;



import java.io.IOException;

import com.atm.impl.LoginDetailsImpl;
import com.atm.impl.UsernamePasswordImpl;
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

		try {
			UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(uname, pass);
			String role = userimpl.getrole(usernamepassmodel);
			if (role != null) {
				if (role.equals("user")) {
					LoginDetailsModel loginmodel = new LoginDetailsModel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					flag = true;
					session.setAttribute("user", uname);
					response.sendRedirect("Welcomepage.jsp");
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

		if (!flag) {
			response.sendRedirect("Invaliduser.jsp");
		}
	}

}
