package com.atm.controller;

import java.io.IOException;
import java.util.List;

import com.atm.daoimpl.LoginDetailsImpl;
import com.atm.models.LoginDetailsModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logindetailsservlet")
public class LoginDetailsController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	LoginDetailsImpl logindetailsdao = new LoginDetailsImpl();
		try {
			List<LoginDetailsModel> loginDetailsModels = logindetailsdao.fetchlogin();
			req.setAttribute("logindetailsobj", loginDetailsModels);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Logindetails.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
}
