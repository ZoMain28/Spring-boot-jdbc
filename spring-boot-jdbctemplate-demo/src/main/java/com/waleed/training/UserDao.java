package com.waleed.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	
	@Autowired
	JdbcTemplate template;
	
	Integer getCountOfUsers() {
		return template.queryForObject("select count(*) from user", Integer.class);
	}
	
	String getUserName( int id, String address) {
		return template.queryForObject(
				"select name from user where id=? and address = ?",
				new Object[] {id, address},
				String.class);
	}
	String createUser(int id,String name,String address) {
		template.update(" insert into user values(?,?,?)", id, name,address); 
		return "New User created";
	}

	String updateUser(User user,int id ) {
		
		template.update("update user set name=?, address=? where id=?",user.getName(),user.getAddress(),id);
		return "Details updated";		
				
		
	}
	String deleteUser(int id) {
		
		
		template.update("delete from user where id=?",id);
		return "User deleted";		
				
		
	}
	}
