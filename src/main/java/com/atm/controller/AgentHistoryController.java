package com.atm.controller;

import java.io.IOException;
import java.util.List;

import com.atm.daoimpl.AtmMoneyManagementImpl;
import com.atm.models.AtmMoneyManagementModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/agenthistoryservlet")
public class AgentHistoryController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
			try {
				List<AtmMoneyManagementModel> atmMoneyManagementModels = atmMoneyManagementimpl.history();
				req.setAttribute("agenthistoryobj", atmMoneyManagementModels);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Historyagent.jsp");
				requestDispatcher.forward(req, resp);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
}
}
