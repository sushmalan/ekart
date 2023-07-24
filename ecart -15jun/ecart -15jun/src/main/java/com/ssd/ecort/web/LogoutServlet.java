package com.ssd.ecort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.CartDto;
import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.service.CartService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CartDto> oldCartList = (List<CartDto>) request.getSession().getAttribute("oldCartList");
		
		UserDto userDto = (UserDto) request.getSession().getAttribute("user");
		
		if (userDto == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		
		CartService service = new CartService();
		if(oldCartList!=null && oldCartList.size()>0  ) {
		service.saveCartData(oldCartList, userDto.getId());
		}
		
		request.getSession().removeAttribute("oldCartList");
		request.getSession().removeAttribute("user");
		response.sendRedirect("login.jsp");
	}

}
