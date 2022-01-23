package com.atm.controller;

import java.io.IOException;

import com.atm.daoimpl.UserProfileImpl;
import com.atm.models.UserProfileModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/balanceservlet")
public class BalanceController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user = session.getAttribute("user").toString();
	UserProfileImpl userProfiledao = new UserProfileImpl();
	UserProfileModel userprofilepojo = new UserProfileModel(user);
	try {
		int balance = userProfiledao.getbal(userprofilepojo);
		req.setAttribute("balanceInt", balance);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Balance.jsp");
		requestDispatcher.forward(req, resp);
	} catch (Exception e) {

		e.printStackTrace();
	}
}
}
