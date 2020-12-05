package com.sampleweb.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sampleweb.app.ws.exceptions.UserServiceException;
import com.sampleweb.app.ws.ui.model.request.UpdateUserDataRequestJSON;
import com.sampleweb.app.ws.ui.model.request.UserDataRequestJSON;
import com.sampleweb.app.ws.ui.model.response.UserRest;
import com.sampleweb.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String,UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/{userID}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
		
		//if(true) throw new UserServiceException("This is a user Error message");
		
		if (users.containsKey(userID))
		{
			return new ResponseEntity<>(users.get(userID),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping()
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int p,
			@RequestParam(value = "limit", defaultValue = "20") int l) {
		return "get user was called with page :" + p + " and limit :" + l;
	}

	@PostMapping(produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },consumes={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDataRequestJSON Req) {
		
		UserRest u=userService.createUser(Req);
			
			return new ResponseEntity<UserRest>(u,HttpStatus.OK);
		
	}

	@PutMapping(path = "/{userid}",produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },consumes={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userid,@Valid @RequestBody UpdateUserDataRequestJSON UR) {
		UserRest SourceData=users.get(userid);
		SourceData.setFirstName(UR.getFirstName());
		SourceData.setLastName(UR.getLastName());
		users.put(userid,SourceData);
		return SourceData;
	}

	@DeleteMapping(path = "/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userid) {
		users.remove(userid);
		return ResponseEntity.noContent().build();
		
	}

}
