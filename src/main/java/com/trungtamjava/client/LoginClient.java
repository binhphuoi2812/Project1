package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.outdao.PersonDao;
import com.trungtamjava.outdao.PersonDaoImpl;
import com.trungtamjava.outdao.PersonDaoImpl2;
import com.trungtamjava.outmodel.Person;

@WebServlet(urlPatterns = "/DangNhapClient")
public class LoginClient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String err = req.getParameter("err");

		if (err != null) {
			req.setAttribute("errMsg", "Sai Tai Khoan Hoac Mat Khau");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("ThemeClient/index.jsp");

		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("Username");
		String password = req.getParameter("matkhau");

		PersonDao personDao = new PersonDaoImpl2();
		Person person = personDao.getByUsername(username);
		if (username != null && person.getPassword().equals(password)) {
			System.out.println("Thanh Cong");
			
		    HttpSession session = req.getSession();
            session.setAttribute("LoginUser", person);
			resp.sendRedirect("/Final/Dashboard");
		} else {
			System.out.println("Fail");

			resp.sendRedirect("/Final/DangNhapClient?err=1");
		}
	}
}
