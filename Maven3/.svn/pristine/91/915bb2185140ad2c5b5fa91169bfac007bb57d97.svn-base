package com.trungtamjava.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.outdao.billDao;
import com.trungtamjava.outdao.billDaoImpl;
import com.trungtamjava.outmodel.Person;
import com.trungtamjava.outmodel.bill;

@WebServlet(urlPatterns = "/member/bills")
public class ClientBillController extends HttpServlet {
	billDao BillDao = new billDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Person buyer = (Person) session.getAttribute("loginUser");
		
		
		List<bill> bills = (List<bill>) BillDao.get(buyer.getId());
		
		req.setAttribute("bills", bills);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/ThemeProduct/bill-list.jsp");
		dispatcher.forward(req, resp);
	}
}