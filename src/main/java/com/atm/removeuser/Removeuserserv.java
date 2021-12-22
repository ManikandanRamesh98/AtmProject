package com.atm.removeuser;

import java.io.IOException;
import java.sql.ResultSet;

import com.atm.impl.Depositimpl;
import com.atm.impl.Logindetailsimpl;
import com.atm.impl.RemovedUsersimpl;
import com.atm.impl.UserProfileimpl;
import com.atm.impl.UsernamePasswordimpl;
import com.atm.impl.Withdrawimpl;
import com.atm.models.Depositmodel;
import com.atm.models.Loginmodel;

import com.atm.models.Removedusersmodel;

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
	Logindetailsimpl logindetailsdao = new Logindetailsimpl();
	Withdrawimpl withdrawimpl = new Withdrawimpl();
	Depositimpl depositdao = new Depositimpl();
	UserProfileimpl userprofiledao = new UserProfileimpl();
	RemovedUsersimpl removedusersdao = new RemovedUsersimpl();
	UsernamePasswordimpl userdao = new UsernamePasswordimpl();
HttpSession session = req.getSession();
String user = req.getParameter("remusername");
int id = Integer.parseInt(req.getParameter("remuserid"));
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
			int withrem = withdrawimpl.removewith(withdrawpojo);
			if(withrem >= 0) {
				Depositmodel depositpojo = new Depositmodel(accno);
				int deprem = depositdao.removedep(depositpojo);
				if(deprem >= 0) {
					Userprofilemodel userprofilepojo = new Userprofilemodel(user);
					ResultSet resultSet = userprofiledao.getuserdetails(userprofilepojo);
					while (resultSet.next()) {
						int lastbalance = resultSet.getInt(4);
						Long mobno = resultSet.getLong(5);
						int userpin = resultSet.getInt(6);
						Removedusersmodel removedusersmodel = new Removedusersmodel(accno, user, lastbalance, mobno, userpin);
						removedusersdao.insremoveusers(removedusersmodel);
					}
					}
					Userprofilemodel userprofilepojo = new Userprofilemodel(accno,id);
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
		

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
