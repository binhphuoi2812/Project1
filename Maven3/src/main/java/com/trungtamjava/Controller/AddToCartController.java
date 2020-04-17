package com.trungtamjava.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.outdao.ProductDao;
import com.trungtamjava.outdao.ProductDaoImpl;
import com.trungtamjava.outmodel.BillProduct;
import com.trungtamjava.outmodel.Product;

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao productDao = new ProductDaoImpl();

		String pId = req.getParameter("pid");
		Product product = productDao.get(Integer.parseInt(pId));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if (obj == null) {
			BillProduct billproduct = new BillProduct();
			billproduct.setProduct(product);
			billproduct.setQuantity(1);
			billproduct.setUnitPrice(product.getPrice());

			Map<String, BillProduct> map = new HashMap<>();
			map.put(pId, billproduct);

			session.setAttribute("cart", map);
		}

		else {
			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;
			BillProduct billproduct = map.get(pId);

			if (billproduct == null) {
				BillProduct billproducts = new BillProduct();
				billproducts.setProduct(product);
				billproducts.setQuantity(1);
				billproducts.setUnitPrice(product.getPrice());

				map.put(pId, billproducts);
			} else {

				billproduct.setQuantity(1 + billproduct.getQuantity());

			}
			session.setAttribute("cart", map);

		}

		resp.sendRedirect(req.getContextPath() + "/cart");
	}

}
