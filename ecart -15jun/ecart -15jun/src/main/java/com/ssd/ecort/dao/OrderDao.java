package com.ssd.ecort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ssd.ecort.dto.OrderDto;
import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.utility.DbConnection;

public class OrderDao {
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static String INSERTUSER = "INSERT INTO orders ( p_id, u_id, o_quantity, o_date) VALUES (?,?,?,?)";


	public void placeOrder(OrderDto dto) {

		try {
			
			conn = DbConnection.getDbConnection();
			 ps = conn.prepareStatement(INSERTUSER);
			 ps.setInt(1, dto.getId());
			 ps.setInt(2, dto.getuId());
			 ps.setInt(3, dto.getNoOfOrders());
			 ps.setDate(4, dto.getoDate());
			 
			 ps.executeUpdate();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void placeAllOrders(List<OrderDto> orderList) {

		try {
			
			conn = DbConnection.getDbConnection();
			
			for(OrderDto dto:orderList) {
			
			
			 ps = conn.prepareStatement(INSERTUSER);
			 ps.setInt(1, dto.getId());
			 ps.setInt(2, dto.getuId());
			 ps.setInt(3, dto.getNoOfOrders());
			 ps.setDate(4, dto.getoDate());
			 
			 ps.executeUpdate();
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}



			
