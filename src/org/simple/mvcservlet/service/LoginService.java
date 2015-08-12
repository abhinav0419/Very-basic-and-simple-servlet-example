package org.simple.mvcservlet.service;

import java.util.HashMap;

import org.simple.mvcservlet.dto.User;

public class LoginService {
	
	
	
	HashMap<String,String> users=new HashMap<String,String>();
	public LoginService(){
		users.put("Abhinav", "Abhinav");
		users.put("Goku","Goku");
	}
	
	public boolean authenticate(String userId,String password){
		if(password==null || password.trim()==""){
			return false;
		}
		return true;
		
	}
	
	public User getUserDetails(String userId){
		User user=new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
}
