package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.InvalidPinLockModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Enterpinminiserv")
public class EnterPinMiniStatementController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	int pin = Integer.parseInt(req.getParameter("minipin"));
	UserProfileImpl userprofileimpl = new UserProfileImpl();
	InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl(); 
	try {
		int userpin = userprofileimpl.getuserpin(user);
		if (userpin > 0) {
			if (userpin == pin) {
				res.sendRedirect("Ministatement.jsp");
			} else {
				int inv = (int)session.getAttribute("invalidpinlock");
				inv++;
				if(inv < 3) {
					session.removeAttribute("invalidpinlock");
				session.setAttribute("invalidpinlock", inv);
				session.setAttribute("invalidhomepin", true);
				res.sendRedirect("Welcomepage.jsp");
				}else {
					InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(user);
					invalidPinLockDaoimpl.insertlock(invalidPinLockModel);
					res.sendRedirect("InvalidPinMax.jsp");
				}
			}
		}
	} 
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
