package com.trungtamjava.client;

import java.io.IOException;
import java.util.*;
import java.lang.*;

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

@WebServlet(urlPatterns = "/SearchClient")
public class SearchClient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.setContentType("text/html");


		String name = req.getParameter("fname");
		if (name == null) {
			name = "";
		}

		PersonDao personDao = new PersonDaoImpl2();
		List<Person> persons = personDao.search(name);
		req.setAttribute("personlist", persons);

		RequestDispatcher dispatcher = req.getRequestDispatcher("ThemeClient/table.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}