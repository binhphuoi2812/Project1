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

@WebServlet(urlPatterns = "/UpdateClient")
public class UpdateClient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.setContentType("text/html");

		String id = req.getParameter("id");
		PersonDao personDao = new PersonDaoImpl2();
		Person person = personDao.get(Integer.parseInt(id));
		
		req.setAttribute("person", person);
		RequestDispatcher dispatcher = req.getRequestDispatcher("ThemeClient/update.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		int id = Integer.parseInt(req.getParameter("id"));
		String role = req.getParameter("role");
		String imageurl = req.getParameter("imageurl");

		Person person = new Person();
		person.setId(id);
		person.setName(fname);
		person.setRole(role);
		person.setImageurl(imageurl);

		PersonDao personDao = new PersonDaoImpl2();
		personDao.update(person);
		
		resp.sendRedirect("/Final/SearchClient");
	}
}