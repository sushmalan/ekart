package com.ssd.ecort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssd.ecort.dto.ProductDto;
import com.ssd.ecort.utility.DbConnection;

public class ProductDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static String ALLPRODUCTS = "select * from products";

	public List<ProductDto> getAllProducts() {
		List<ProductDto> productList = new ArrayList<>();
		try {

			conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(ALLPRODUCTS);

			rs = ps.executeQuery();

			while (rs.next()) {
				
				ProductDto dto = new ProductDto();
				// id, name, category, price, image
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getString(3));
				dto.setPrice(rs.getDouble(4));
				dto.setImage(rs.getString(5));
				productList.add(dto);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return productList;
	}

}
