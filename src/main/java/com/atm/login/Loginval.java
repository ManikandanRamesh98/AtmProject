package com.atm.login;

import com.atm.dao.Logindetailsdao;
import com.atm.dao.Usernamepassworddao;
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
		Usernamepassworddao userdao = new Usernamepassworddao();
		Logindetailsdao logindetailsdao = new Logindetailsdao();
		HttpSession session = request.getSession();

		try {
			Usernamepasswordmodel usernamepasspojo = new Usernamepasswordmodel(uname, pass);
			String role = userdao.getrole(usernamepasspojo);
			if (role != null) {
				if (role.equals("user")) {
					Loginmodel loginpojo = new Loginmodel(uname, role);
					logindetailsdao.insertdata(loginpojo);
					flag = true;
					session.setAttribute("user", uname);
					response.sendRedirect("Welcomepage.jsp");
				}

				else if (role.equals("admin")) {
					Loginmodel loginpojo = new Loginmodel(uname, role);
					logindetailsdao.insertdata(loginpojo);
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
