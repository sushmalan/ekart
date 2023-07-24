package com.ssd.ecort.service;

import java.util.List;

import com.ssd.ecort.dao.CartDao;
import com.ssd.ecort.dto.CartDto;

public class CartService {

	public CartDao dao = new CartDao();
	
	public List<CartDto> getAllProductsByCartList(List<CartDto> oldCartList ){
		return dao.getAllProducts(oldCartList);
	}
	
	public void saveCartData(List<CartDto> cartList,Integer uid) {
		dao.saveCartData(cartList,uid);
	}
	
	public List<CartDto> getCartListByUserId(Integer uId){
		return dao.getCartList(uId);
	}
	
	public void removeCrtListByUserId(Integer uId){
		dao.revomeCrtListByUserId(uId);
	}

}
