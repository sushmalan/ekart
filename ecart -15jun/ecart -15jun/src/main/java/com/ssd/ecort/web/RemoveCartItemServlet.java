package com.ssd.ecort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.CartDto;

/**
 * Servlet implementation class RemoveCartItemServlet
 */
@WebServlet("/remove-from-cart")
public class RemoveCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CartDto> cartList  =  (List<CartDto>) request.getSession().getAttribute("oldCartList");
		
		Integer productId = Integer.valueOf(request.getParameter("id"));
		int index =0;
		
		for(CartDto dto : cartList) {
			
			if(dto.getId()==productId) {
				
				index= cartList.indexOf(dto);
			}
		}
		cartList.remove(index);
		double toatlPrice = 0.0;
		for(CartDto dto:cartList) {
			toatlPrice = toatlPrice + dto.getPrice();
		}
		
		request.setAttribute("toatlPrice", toatlPrice);
		
		request.getSession().setAttribute("oldCartList", cartList);
		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}

}
