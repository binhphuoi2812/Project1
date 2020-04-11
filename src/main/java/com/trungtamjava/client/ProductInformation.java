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

import com.trungtamjava.outdao.ProductDao;
import com.trungtamjava.outdao.ProductDaoImpl;
import com.trungtamjava.outmodel.Product;

@WebServlet(urlPatterns = "/ProductInfo")
public class ProductInformation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	resp.setContentType("text/html");
		String name = req.getParameter("fname");
		if (name == null) {
			name = "";
		}
		ProductDao productDao = new ProductDaoImpl();
		List<Product> products = productDao.search(name);
		req.setAttribute("productlist", products);
		RequestDispatcher dispatcher = req.getRequestDispatcher("ProductInfo/index.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doGet(req,resp);

		
}
}