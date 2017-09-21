package org.rest.controller;

import org.rest.entity.User;
import org.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(produces={"application/json"})
	public ResponseEntity<Iterable<User>> getUsers(){
		
		return userService.getUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, produces={"application/json"}, consumes={"application/json"})
	public ResponseEntity<User> register(@RequestBody User user){
		
		return userService.createUser(user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, produces={"application/json"}, consumes={"application/json"})
	public ResponseEntity<User> update(@PathVariable(value="id", name="id", required=true) Integer id, @RequestBody User user){
		
		return userService.updateUser(id,user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces={"application/json"}, consumes={"application/json"})
	public ResponseEntity<Boolean> delete(@PathVariable(value="id", name="id", required=true) Integer id){
		
		return userService.deleteUser(id);
	}
}
