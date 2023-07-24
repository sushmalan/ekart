package com.ssd.ecort.web;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.CartDto;
import com.ssd.ecort.dto.OrderDto;
import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.service.OrderService;

/**
 * Servlet implementation class CheckoutAllProductsServlet
 */
@WebServlet("/cart-check-out")
public class CheckoutAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutAllProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CartDto> cartList =  (List<CartDto>) request.getSession().getAttribute("oldCartList");
		UserDto user = (UserDto) request.getSession().getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		List<OrderDto> orderList =new ArrayList<>();
		
		for(CartDto cartDto:cartList) {
			
			LocalDate oDate = LocalDate.now();
			
			Date date = Date.valueOf(oDate);
			
			OrderDto oDto = new OrderDto();
			
			oDto.setId(cartDto.getId());
			oDto.setuId(user.getId());
			oDto.setNoOfOrders(cartDto.getQuentity());
			oDto.setoDate(date);
			
			orderList.add(oDto);
		}
		
		OrderService oService = new OrderService();
		oService.placeAllYourOrders(orderList);
		cartList.clear();
		request.getRequestDispatcher("products").forward(request, response);
	}

}
