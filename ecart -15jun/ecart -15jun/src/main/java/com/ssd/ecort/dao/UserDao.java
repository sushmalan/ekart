package com.ssd.ecort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssd.ecort.dto.UserDto;
import com.ssd.ecort.utility.DbConnection;

public class UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static String INSERTUSER = "INSERT INTO user (name, email, pwd, mno, address) VALUES (?,?,?,?,?)";

	public static String LOGINUSER = "select * from user where email=? and pwd=?";

	public void createUser(UserDto dto) {

		try {
			conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(INSERTUSER);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPwd());
			ps.setLong(4, dto.getMobileNo());
			ps.setString(5, dto.getAddress());

			int noOfRecords = ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserDto loginUser(UserDto dto) {
		
		UserDto userDto =null;
		
		try {
			conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(LOGINUSER);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPwd());


			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				userDto = new UserDto();
				
				userDto.setId(rs.getInt(1));
				userDto.setName(rs.getString(2));
				userDto.setEmail(rs.getString(3));
				userDto.setPwd(rs.getString(4));
				userDto.setMobileNo(rs.getLong(5));
				userDto.setAddress(rs.getString(6));
				
				
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return userDto;
	}
}
