package com.ssd.ecort.dto;

public class CartDto extends ProductDto{
	
	private Integer quentity;

	public Integer getQuentity() {
		return quentity;
	}

	public void setQuentity(Integer quentity) {
		this.quentity = quentity;
	}

	public CartDto(Integer id, String name, String category, Double price, String image, Integer quentity) {
		super(id, name, category, price, image);
		this.quentity = quentity;
	}

	public CartDto(Integer id, String name, String category, Double price, String image) {
		super(id, name, category, price, image);
	}
	
	public CartDto() {
		
	}
	
	
	
	
	
	
	
	

}
