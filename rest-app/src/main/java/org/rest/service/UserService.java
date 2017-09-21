package org.rest.service;

import org.rest.entity.User;
import org.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<Iterable<User>> getUsers() {
		
		Iterable<User> userList = userRepository.findAll();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<User> createUser(User user) {
		
		userRepository.save(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<User> updateUser(Integer id, User user) {
		
		User updatableUser = userRepository.findOne(id);
		
		if(updatableUser!=null){
			updatableUser.setAge(user.getAge());
			updatableUser.setFirstname(user.getFirstname());
			updatableUser.setLastname(user.getLastname());
			userRepository.save(updatableUser);
			return new ResponseEntity<>(updatableUser,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	public ResponseEntity<Boolean> deleteUser(Integer id) {
		
		User updatableUser = userRepository.findOne(id);
		
		if(updatableUser!=null){
			userRepository.delete(updatableUser);
			return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
		}
		return new ResponseEntity<>(Boolean.FALSE,HttpStatus.OK);
	}
}
