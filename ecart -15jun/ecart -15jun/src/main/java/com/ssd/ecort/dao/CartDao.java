package com.ssd.ecort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssd.ecort.dto.CartDto;
import com.ssd.ecort.dto.OrderDto;
import com.ssd.ecort.utility.DbConnection;

public class CartDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static String ALLPRODUCTS = "select * from products where id=?";
	
	public static String INSERTUSER = "INSERT INTO cartlist ( pid, uid, quantity) VALUES (?,?,?)";
	
	public static String CARTLIST ="select * from cartlist where uid=?";
	
	public static String REMOVECARTLIT ="delete from cartlist where uid=?";

	public List<CartDto> getAllProducts(List<CartDto> oldCartList) {
		List<CartDto> cartList = new ArrayList<>();
		try {

			conn = DbConnection.getDbConnection();

			for (CartDto dto : oldCartList) {
				ps = conn.prepareStatement(ALLPRODUCTS);
				ps.setInt(1, dto.getId());
				rs = ps.executeQuery();
			
				// id, name, category, price, image
				while (rs.next()) {
					CartDto newDto = new CartDto();
					newDto.setId(rs.getInt("id"));
					newDto.setName(rs.getString("name"));
					newDto.setCategory(rs.getString("category"));
					Double price = rs.getDouble("price");

					Double productPrice = price * dto.getQuentity();
					newDto.setPrice(productPrice);
					newDto.setQuentity(dto.getQuentity());
					cartList.add(newDto);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return cartList;
	}
	



	public void saveCartData(List<CartDto> cartList,Integer uid) {

		try {
			
			conn = DbConnection.getDbConnection();
			
			
			for(CartDto dto:cartList) {
			 ps = conn.prepareStatement(INSERTUSER);
			 ps.setInt(1, dto.getId());
			 ps.setInt(2, uid);
			 ps.setInt(3, dto.getQuentity());
			 ps.executeUpdate();
			}
			 
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<CartDto> getCartList(Integer uId) {
		List<CartDto> cartList = new ArrayList<>();
		try {

			conn = DbConnection.getDbConnection();

			
				ps = conn.prepareStatement(CARTLIST);
				ps.setInt(1, uId);
				rs = ps.executeQuery();
			
				// id, name, category, price, image
				while (rs.next()) {
					CartDto newDto = new CartDto();
					newDto.setId(rs.getInt("pid"));
					newDto.setQuentity(rs.getInt("quantity"));
					cartList.add(newDto);
				}

		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return cartList;
	}
	
	public void revomeCrtListByUserId(Integer uId) {
		
		try {

			conn = DbConnection.getDbConnection();

			
				ps = conn.prepareStatement(REMOVECARTLIT);
				ps.setInt(1, uId);
				ps.executeUpdate();
			
				

		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
}
