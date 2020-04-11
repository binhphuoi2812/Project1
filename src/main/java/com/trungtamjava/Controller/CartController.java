package com.trungtamjava.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.trungtamjava.outmodel.BillProduct;
import com.trungtamjava.outmodel.Person;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		
		List<BillProduct> products = new ArrayList<> ();
		
		if(obj != null) {
			Map<String , BillProduct> map = (Map<String, BillProduct>) obj;
			
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("ThemeClient/cart.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}
}