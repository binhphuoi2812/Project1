package com.trungtamjava.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.outdao.BillProductDao;
import com.trungtamjava.outdao.BillProductDaoImpl;
import com.trungtamjava.outdao.billDao;
import com.trungtamjava.outdao.billDaoImpl;
import com.trungtamjava.outmodel.BillProduct;
import com.trungtamjava.outmodel.Person;
import com.trungtamjava.outmodel.bill;

@WebServlet(urlPatterns = "/add-order")
public class AddOrderController extends HttpServlet {
             billDao BillDao = new billDaoImpl();
             BillProductDao billProductDao = new BillProductDaoImpl();
             

         	@Override
         	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         		HttpSession session = req.getSession();
         		Object obj = session.getAttribute("cart");

         		if (obj != null) {
         			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;

         			bill bill1 = new bill();

         			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         			bill1.setBuyDate(sdf.format(new Date()));

         			Person buyer = (Person) session.getAttribute("loginUser");
         			bill1.setBuyer(buyer);

         			billDao.create(bill1);
         			long total = 0;
         			for (Entry<String, BillProduct> entry : map.entrySet()) {
         				BillProduct billProduct = entry.getValue();

         				billProduct.setBill(bill1);

         				billProductDao.create(billProduct);
         				total += billProduct.getQuantity() * billProduct.getUnitPrice();
         			}
         			
         			
         			bill1.setPriceTotal(total);
         			billDao.update(bill1);

         			
         			session.removeAttribute("cart");
         			resp.sendRedirect(req.getContextPath() + "/bill");
         		} else {
         			resp.sendRedirect(req.getContextPath() + "/ProductInfo");
         		}

         	}
}
