package com.ssd.ecort.dto;

import java.sql.Date;

public class OrderDto extends ProductDto{
	
	private Integer oId;
	private Integer uId;
	private Integer noOfOrders;
	private Date oDate;
	
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Integer getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(Integer noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	
	public OrderDto(Integer id, String name, String category, Double price, String image, Integer oId, Integer uId,
			Integer noOfOrders, Date oDate) {
		
		super(id, name, category, price, image);
		this.oId = oId;
		this.uId = uId;
		this.noOfOrders = noOfOrders;
		this.oDate = oDate;
	}
	
	public OrderDto(Integer id, String name, String category, Double price, String image) {
		super(id, name, category, price, image);
	}
	
	public OrderDto() {
		
	}
	
	public OrderDto(Integer id, String name, String category, Double price, String image, Integer uId,
			Integer noOfOrders, Date oDate) {
		super(id, name, category, price, image);
		this.uId = uId;
		this.noOfOrders = noOfOrders;
		this.oDate = oDate;
	}
	@Override
	public String toString() {
		return "OrderDto [oId=" + oId + ", uId=" + uId + ", noOfOrders=" + noOfOrders + ", oDate=" + oDate + "]";
	}
	
	

}
