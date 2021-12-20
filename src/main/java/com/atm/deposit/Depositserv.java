package com.atm.deposit;

import com.atm.dao.Depositdao;
import com.atm.dao.Userprofiledao;
import com.atm.models.Depositpojo;
import com.atm.models.Userprofilepojo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.net.aso.b;

@WebServlet("/depserv")
public class Depositserv extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res) {
	Userprofiledao userprofiledao = new Userprofiledao();
	Depositdao depositdao = new Depositdao();
	HttpSession session = req.getSession();
	String uname = session.getAttribute("user").toString();
	int eamount = (int)session.getAttribute("depamount");
	try {
		Userprofilepojo userprofilepojo = new Userprofilepojo(uname);
		if(userprofiledao.getbal(userprofilepojo) > 0) {
		 int bal= userprofiledao.getbal(userprofilepojo);
if(eamount > 0 && eamount < 30000) {
	int newbal = bal+eamount;
	Userprofilepojo userprofilepojo2 = new Userprofilepojo(uname, newbal);
			int i = userprofiledao.insbal(userprofilepojo2);
			if(i > 0) {
				Userprofilepojo userprofilepojo3 = new Userprofilepojo(uname);
				Long acc =userprofiledao.getaccno(userprofilepojo3);
				if(acc > 0) {
					Depositpojo depositpojo = new Depositpojo(acc,eamount);
					depositdao.insdep(depositpojo);
				session.setAttribute("depsuccamount", eamount);
				session.setAttribute("depsuccbal", newbal);
				res.sendRedirect("Depsucc.jsp");
				}else {
					System.out.println("cant get useracc");
				}
			}else {
				res.getWriter().println("something went wrong!!");
			}
		 }else {
			 res.getWriter().println("enter the valid amount!!");
		 }
		}else {
			res.sendRedirect("Invaliduser.jsp");
		}
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
