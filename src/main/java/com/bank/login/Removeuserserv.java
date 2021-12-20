package com.bank.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/removeaccserv")
public class Removeuserserv extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Logindetailsdao logindetailsdao = new Logindetailsdao();
	Withdrawdao withdrawdao = new Withdrawdao();
	Depositdao depositdao = new Depositdao();
	Userprofiledao userprofiledao = new Userprofiledao();
	Userdao userdao = new Userdao();
HttpSession session = req.getSession();
String user = req.getParameter("remusername");
Long accno = -1l;
try {
	Userprofilepojo userprofilepojo = new Userprofilepojo(user);
	accno = userprofiledao.getaccno(userprofilepojo);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	try {
		Loginpojo loginpojo = new Loginpojo(user);
		int lrem = logindetailsdao.removelogindetail(loginpojo);
		if(lrem >= 0) {
			Withdrawpojo withdrawpojo = new Withdrawpojo(accno);
			int withrem = withdrawdao.removewith(withdrawpojo);
			if(withrem >= 0) {
				Depositpojo depositpojo = new Depositpojo(accno);
				int deprem = depositdao.removedep(depositpojo);
				if(deprem >= 0) {
					Userprofilepojo userprofilepojo = new Userprofilepojo(accno);
					int userprofrem = userprofiledao.removeuserprof(userprofilepojo);
					if(userprofrem > 0) {
						Usernamepasspojo usernamepasspojo = new Usernamepasspojo(user);
						int userrem = userdao.removeuser(usernamepasspojo);
						if(userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						}else {
							resp.getWriter().println("Invalid UserName");
						}
					}else {
						Usernamepasspojo usernamepasspojo = new Usernamepasspojo(user);
						int userrem = userdao.removeuser(usernamepasspojo);
						if(userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						}else {
							resp.getWriter().println("Invalid UserName");
						}
					}
				}
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
