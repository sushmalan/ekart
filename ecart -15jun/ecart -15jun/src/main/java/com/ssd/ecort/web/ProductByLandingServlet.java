package com.ssd.ecort.web;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.OrderDto;
import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.service.OrderService;

/**
 * Servlet implementation class ProductByLandingServlet
 */
@WebServlet("/order-now-landing")
public class ProductByLandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductByLandingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDto user = (UserDto) request.getSession().getAttribute("user");

		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		LocalDate oDate = LocalDate.now();

		Date date = Date.valueOf(oDate);

		Integer produtId = Integer.valueOf(request.getParameter("id"));

		Integer noOrders = Integer.valueOf(request.getParameter("quantity"));

		Integer uId = user.getId();
		
		OrderDto oDto = new OrderDto();
		oDto.setId(produtId);
		oDto.setuId(uId);
		oDto.setNoOfOrders(noOrders);
		oDto.setoDate(date);
		
		OrderService oService = new OrderService();
		
		oService.placeYourOrder(oDto);
		
		request.getRequestDispatcher("products").forward(request, response);

	}

}
