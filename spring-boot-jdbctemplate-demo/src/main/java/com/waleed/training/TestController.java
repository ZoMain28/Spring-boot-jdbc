package com.waleed.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}
	
	@RequestMapping("/users/name/{id}/{address}")
	String getUserName( @PathVariable int id, @PathVariable String address) {
		return service.getUserName(id, address);
	}
	@RequestMapping( method=RequestMethod.PUT, value="/users/update/{id}")
	String updateUser( @RequestBody User user, @PathVariable int id) {
		return service.updateUser(user,id);
	}
	@RequestMapping("/users/delete/{id}")
	String deleteUser( @PathVariable int id) {
		return service.deleteUser(id);
	}
	@RequestMapping("/users/create/{id}/{name}/{address}")
	String createUser( @PathVariable int id, @PathVariable String name, @PathVariable String address) {
		return service.createUser(id,name,address);
	}
}
