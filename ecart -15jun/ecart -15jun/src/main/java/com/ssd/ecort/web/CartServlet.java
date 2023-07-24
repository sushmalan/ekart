package com.ssd.ecort.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssd.ecort.dto.CartDto;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CartDto> oldCartList  = (List<CartDto>) request.getSession().getAttribute("oldCartList");
		Integer productId = Integer.valueOf(request.getParameter("id"));
		
		System.out.println(productId);
		
		CartDto cartDto = new CartDto();
		
		List<CartDto> newCartList = new ArrayList<>();
		
		if(oldCartList!=null&& oldCartList.size()>0) {
			
			newCartList = oldCartList;
			
			for(CartDto dto:newCartList) {
				
				if(dto.getId()==productId) {
					
					request.getRequestDispatcher("cartAlert.jsp").forward(request, response);
				}
			}
			
			cartDto.setId(productId);
			cartDto.setQuentity(1);
			newCartList.add(cartDto);
			HttpSession session   = request.getSession();
			session.setAttribute("oldCartList", newCartList);
			
		}else {
			cartDto.setId(productId);
			cartDto.setQuentity(1);
			newCartList.add(cartDto);
			HttpSession session   = request.getSession();
			session.setAttribute("oldCartList", newCartList);
			
		}
		
		
		request.getRequestDispatcher("products").forward(request, response);
		
	}

}
