package com.ssd.ecort.service;

import java.util.List;

import com.ssd.ecort.dao.OrderDao;
import com.ssd.ecort.dto.OrderDto;

public class OrderService {
	
	private OrderDao dao = new OrderDao();
	public void placeYourOrder(OrderDto dto) {
		dao.placeOrder(dto);
	}
	
	public void placeAllYourOrders(List<OrderDto> orderList) {
		dao.placeAllOrders(orderList);
	}


}
