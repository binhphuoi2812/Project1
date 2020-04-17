package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.outmodel.Person;

@WebServlet(urlPatterns ="/Dashboard")
public class Dashboard extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	resp.setContentType("text/html");
		HttpSession session = req.getSession();
		if(session.getAttribute("LoginUser")!= null) {
			Person loginUser = (Person) session.getAttribute("LoginUser");
			System.out.println("Login"+ loginUser.getName());
		}else {
			resp.sendRedirect(req.getContextPath()+"/Maven02/LoginClient");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Dashboard/Slider/index.html");

		dispatcher.forward(req, resp);
	}
}
