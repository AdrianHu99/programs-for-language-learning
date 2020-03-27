package DAO;

import java.util.HashMap;

import Entity.User;

public class LoginService {
	HashMap<String, String> users = new HashMap<String, String>();
	public LoginService(){
		users.put("qi", "hu");
		users.put("zhang", "bihua");
	}
	
	public boolean authenticate(String userId, String password){
		System.out.println(password);
		System.out.println(users.get(userId));
		if(password.equals(users.get(userId))){// it is equals(), not just ==
			return true;
		}else{
			return false;
		}
	}

	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
}