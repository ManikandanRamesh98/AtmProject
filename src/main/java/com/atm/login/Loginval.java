package com.atm.login;

import com.atm.impl.Logindetailsimpl;
import com.atm.impl.UsernamePasswordimpl;
import com.atm.models.Loginmodel;
import com.atm.models.Usernamepasswordmodel;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginval")
public class Loginval extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		boolean flag = false;
		UsernamePasswordimpl userimpl = new UsernamePasswordimpl();
		Logindetailsimpl logindetailsimpl = new Logindetailsimpl();
		HttpSession session = request.getSession();

		try {
			Usernamepasswordmodel usernamepassmodel = new Usernamepasswordmodel(uname, pass);
			String role = userimpl.getrole(usernamepassmodel);
			if (role != null) {
				if (role.equals("user")) {
					Loginmodel loginmodel = new Loginmodel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					flag = true;
					session.setAttribute("user", uname);
					response.sendRedirect("Welcomepage.jsp");
				}

				else if (role.equals("admin")) {
					Loginmodel loginmodel = new Loginmodel(uname, role);
					logindetailsimpl.insertdata(loginmodel);
					System.out.println("this is admin");
					flag = true;
					session.setAttribute("admin", uname);
					response.sendRedirect("Admin.jsp");
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
