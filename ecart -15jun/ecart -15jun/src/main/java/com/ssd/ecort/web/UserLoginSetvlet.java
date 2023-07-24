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
import com.ssd.ecort.service.UserService;

/**
 * Servlet implementation class UserLoginSetvlet
 */
@WebServlet("/login")
public class UserLoginSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginSetvlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			UserService userService = new UserService();

			UserDto dto = new UserDto();

			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));

			dto = userService.loginUser(dto);

			if (dto == null) {
				req.getRequestDispatcher("login.jsp").forward(req, resp);

			} else {
				CartService service  = new CartService();
				List<CartDto> cartList = service.getCartListByUserId(dto.getId());
				
				req.getSession().setAttribute("user", dto);
				req.getSession().setAttribute("oldCartList", cartList);
				
				
				service.removeCrtListByUserId(dto.getId());
				
				req.getRequestDispatcher("/products").forward(req, resp);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

    }
}
