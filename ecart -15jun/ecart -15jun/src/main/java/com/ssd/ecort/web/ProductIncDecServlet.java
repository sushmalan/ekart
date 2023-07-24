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
 * Servlet implementation class ProductIncDecServlet
 */
@WebServlet("/quantity-inc-dec")
public class ProductIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Integer productId = Integer.valueOf(request.getParameter("id"));
		List<CartDto> oldCartList = (List<CartDto>) request.getSession().getAttribute("oldCartList");

		System.out.println("action/...." + action);

		System.out.println("productId..." + productId);
		int produtIndex = 0;
		for (CartDto cartDto : oldCartList) {

			if (cartDto.getId() == productId) {
				produtIndex = oldCartList.indexOf(cartDto);
			}
		}
		CartDto newCartDto = new CartDto();

		CartDto dto = oldCartList.get(produtIndex);

		
		newCartDto.setId(dto.getId());
		newCartDto.setName(dto.getName());
		newCartDto.setCategory(dto.getCategory());
		newCartDto.setPrice(dto.getPrice());
		oldCartList.remove(produtIndex);
		
		
		if (action.equals("inc")) {
			
			newCartDto.setQuentity(dto.getQuentity() + 1);
			
			oldCartList.add(produtIndex, newCartDto);
			
		} else {
			
			newCartDto.setQuentity(dto.getQuentity() - 1);
			oldCartList.add(produtIndex, newCartDto);
		}
		

		request.getSession().setAttribute("oldCartList", oldCartList);

		request.getRequestDispatcher("checkoutcart").forward(request, response);

	}

}
