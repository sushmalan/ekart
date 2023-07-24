package com.ssd.ecort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.CartDto;
import com.ssd.ecort.service.CartService;

/**
 * Servlet implementation class CheckoutCartServlet
 */
@WebServlet("/checkoutcart")
public class CheckoutCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartService crs = new CartService();
		
		List<CartDto> cartList =  (List<CartDto>) request.getSession().getAttribute("oldCartList");
	
		List<CartDto> newCartList  = crs.getAllProductsByCartList(cartList);
		
		double toatlPrice = 0.0;
		
		for(CartDto dto:newCartList) {
			toatlPrice = toatlPrice + dto.getPrice();
		}
		
		request.setAttribute("toatlPrice", toatlPrice);
		request.getSession().setAttribute("oldCartList", newCartList);
		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
