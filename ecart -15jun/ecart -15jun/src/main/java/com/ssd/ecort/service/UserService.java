package com.ssd.ecort.service;

import com.ssd.ecort.dao.UserDao;
import com.ssd.ecort.dto.UserDto;

public class UserService {
	public UserDao dao = new UserDao();
	public void createUser(UserDto dto) {
		dao.createUser(dto);
	}
	
	public UserDto loginUser(UserDto dto) {
		
		return dao.loginUser(dto);
	}

}
