package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.outdao.PersonDao;
import com.trungtamjava.outdao.PersonDaoImpl;
import com.trungtamjava.outdao.PersonDaoImpl2;
import com.trungtamjava.outmodel.Person;

@WebServlet(urlPatterns = "/delete-from-cart")
public class DeleteFormCart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		PersonDao personDao = new PersonDaoImpl2();
		personDao.delete(Integer.parseInt(id));
		
		resp.sendRedirect("/Final/SearchClient");//chuyen huong 
		//resp.sendRedirect(req.getContextPath()+"HelloWeb09/Search");
		
	}

}