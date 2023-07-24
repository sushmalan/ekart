package com.ssd.ecort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

		UserService userService = new UserService();
		try {
			
			String uname =request.getParameter("uname");
			String email =request.getParameter("email");
			String pwd =request.getParameter("pwd");
			
			
			String errorMsg="Please Eneter Valied";
			boolean isValied = false;
			
			if(uname==null || uname.isBlank() || uname.isEmpty()) {
				
				errorMsg =  errorMsg + "User Name";
				isValied =true;
				
			}
			
			
			if(email==null || email.isBlank() || email.isEmpty()) {
				
				errorMsg =  errorMsg + "Email";
				isValied =true;
				
			}
			
			if(pwd==null || pwd.isBlank() || pwd.isEmpty()) {
				
				errorMsg =  errorMsg + "Password";
				isValied =true;
				
			}
			
			if(!isValied) {
			UserDto dto = new UserDto();
			dto.setName(request.getParameter("uname"));
			dto.setEmail(request.getParameter("email"));
			dto.setPwd(request.getParameter("pwd"));
			dto.setMobileNo(Long.valueOf(request.getParameter("mobleNo")));
			dto.setAddress(request.getParameter("address"));

			userService.createUser(dto);

			request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				
				request.setAttribute("errorMsg", errorMsg);
				request.setAttribute("isValied", isValied);
				request.getRequestDispatcher("userSignup.jsp").forward(request, response);
			}
		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}

	
}
