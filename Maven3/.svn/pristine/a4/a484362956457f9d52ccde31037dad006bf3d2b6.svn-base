package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.outdao.PersonDao;
import com.trungtamjava.outdao.PersonDaoImpl;
import com.trungtamjava.outdao.PersonDaoImpl2;
import com.trungtamjava.outmodel.Person;

@WebServlet(urlPatterns = "/AddClient")
public class AddClient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		RequestDispatcher dispatcher = req.getRequestDispatcher("ThemeClient/index2.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String role = req.getParameter("role");
		String imageurl = req.getParameter("imageurl");
		

		Person person = new Person();
		person.setName(fname);
		person.setRole(role);
		person.setImageurl(imageurl);
	
		PersonDao personDao = new PersonDaoImpl2();
		personDao.create(person);
	}
}