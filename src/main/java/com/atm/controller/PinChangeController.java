package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.daoimpl.UsernamePasswordImpl;
import com.atm.models.UserProfileModel;
import com.atm.models.UsernamePasswordModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pinchangeserv")
public class PinChangeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserProfileImpl userProfileImpl = new UserProfileImpl();
		
		int pin = Integer.parseInt(req.getParameter("pininp"));
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int i = -1;
		try {
			UserProfileModel userProfileModel = new UserProfileModel(pin,user);
			i = userProfileImpl.updatepin(userProfileModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i > 0) {
			resp.sendRedirect("Pinchangesucc.jsp");
		} else {
			resp.getWriter().println("Something went wrong try again!!!");
		}
	}

}
