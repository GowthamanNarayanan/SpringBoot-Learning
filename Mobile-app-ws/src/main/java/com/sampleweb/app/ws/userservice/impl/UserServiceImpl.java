package com.sampleweb.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleweb.app.ws.shared.Utils;
import com.sampleweb.app.ws.ui.model.request.UserDataRequestJSON;
import com.sampleweb.app.ws.ui.model.response.UserRest;
import com.sampleweb.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String,UserRest> users;
	
	Utils util;
	
	UserServiceImpl(){}
	
	@Autowired
	UserServiceImpl(Utils util){
		
		this.util=util;
	}

	@Override
	public UserRest createUser(UserDataRequestJSON Req) {
		UserRest u = new UserRest();
		//if (Req.getUserID().equals("680862")) {
			u.setFirstName(Req.getFirstName());
			u.setLastName(Req.getLastName());
			u.setEmail(Req.getEmail());
			
			String userid=util.generateUserId(); 
			u.setUserID(userid);
			if(users==null) users=new HashMap<>();
			users.put(userid,u);
			
			return u;
	}

}
