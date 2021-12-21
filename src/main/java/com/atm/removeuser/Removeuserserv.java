package com.atm.removeuser;

import java.io.IOException;

import com.atm.dao.Depositdao;
import com.atm.dao.Logindetailsdao;
import com.atm.dao.Usernamepassworddao;
import com.atm.dao.Userprofiledao;
import com.atm.dao.Withdrawdao;
import com.atm.models.Depositmodel;
import com.atm.models.Loginmodel;
import com.atm.models.Usernamepasswordmodel;
import com.atm.models.Userprofilemodel;
import com.atm.models.Withdrawmodel;

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
	Usernamepassworddao userdao = new Usernamepassworddao();
HttpSession session = req.getSession();
String user = req.getParameter("remusername");
Long accno = -1l;
try {
	Userprofilemodel userprofilepojo = new Userprofilemodel(user);
	accno = userprofiledao.getaccno(userprofilepojo);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	try {
		Loginmodel loginpojo = new Loginmodel(user);
		int lrem = logindetailsdao.removelogindetail(loginpojo);
		if(lrem >= 0) {
			Withdrawmodel withdrawpojo = new Withdrawmodel(accno);
			int withrem = withdrawdao.removewith(withdrawpojo);
			if(withrem >= 0) {
				Depositmodel depositpojo = new Depositmodel(accno);
				int deprem = depositdao.removedep(depositpojo);
				if(deprem >= 0) {
					Userprofilemodel userprofilepojo = new Userprofilemodel(accno);
					int userprofrem = userprofiledao.removeuserprof(userprofilepojo);
					if(userprofrem > 0) {
						Usernamepasswordmodel usernamepasspojo = new Usernamepasswordmodel(user);
						int userrem = userdao.removeuser(usernamepasspojo);
						if(userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						}else {
							resp.getWriter().println("Invalid UserName");
						}
					}else {
						Usernamepasswordmodel usernamepasspojo = new Usernamepasswordmodel(user);
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
