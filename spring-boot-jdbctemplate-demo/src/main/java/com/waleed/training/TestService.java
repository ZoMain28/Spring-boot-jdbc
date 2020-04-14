package com.waleed.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	UserDao dao;

	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}
	
	String getUserName(int id, String address) {
		return dao.getUserName(id, address);
	}
	String updateUser(User user,int id) {
		return dao.updateUser(user,id);
	}
	String deleteUser(int id) {
		return dao.deleteUser(id);
	}
	String createUser(int id,String name,String address) {
		return dao.createUser(id,name,address);
	}
}
