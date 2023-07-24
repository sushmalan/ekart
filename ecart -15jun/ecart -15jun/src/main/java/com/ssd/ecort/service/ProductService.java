package com.ssd.ecort.service;

import java.util.List;

import com.ssd.ecort.dao.ProductDao;
import com.ssd.ecort.dto.ProductDto;

public class ProductService {
	
	public ProductDao dao = new ProductDao();
	
	public List<ProductDto> getAllProducts(){
		
		return dao.getAllProducts();
		
	}

}
