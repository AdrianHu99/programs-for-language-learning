package org.adrian.login.service;

import java.util.HashMap;

import org.adrian.login.dto.User;

public class LoginService {
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("qi", "hu");
		users.put("zhang", "bihua");
		users.put("xin", "zhong");
	}
	
	
	public boolean authenticate(String userId, String password){
		System.out.println(password);
		System.out.println(users.get(userId));
		if(password.equals(users.get(userId))){
			return true;
		}else{
			return false;
		}
		/*if(password == null||password.trim()=="")return false;
		return true;*/
		
		
	}

	public User getUserDetails(String userId){
		
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		
		return user;
		
	}
}
