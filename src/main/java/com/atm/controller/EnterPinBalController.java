package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.InvalidPinLockDaoimpl;
import com.atm.daoimpl.UserProfileImpl;
import com.atm.exception.WithdrawWrongPinException;
import com.atm.models.InvalidPinLockModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/enterpinbalserv")
public class EnterPinBalController extends HttpServlet{
@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int pin = Integer.parseInt(req.getParameter("balpin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		InvalidPinLockDaoimpl invalidPinLockDaoimpl = new InvalidPinLockDaoimpl(); 
		try {
		//fetch user pin from table:
			int userpin = userprofileimpl.getuserpin(user);
			if (userpin > 0) {
				if (userpin == pin) {
					res.sendRedirect("balanceservlet");
				} else {
					//invalid pin section:
					int inv = (int)session.getAttribute("invalidpinlock");
					inv++;
					if(inv < 3) {
						session.removeAttribute("invalidpinlock");
					session.setAttribute("invalidpinlock", inv);
					session.setAttribute("invalidhomepin", true);
					res.sendRedirect("Welcomepage.jsp");
					}else {
						//invalid pin entry more than three time:
						InvalidPinLockModel invalidPinLockModel = new InvalidPinLockModel(user);
						//insert data in invalidpinlock table:
						invalidPinLockDaoimpl.insertlock(invalidPinLockModel);
						res.sendRedirect("InvalidPinMax.jsp");
					}
				}
			}
		} 
		
		catch (Exception e) {

			e.printStackTrace();
		}
	}
}

