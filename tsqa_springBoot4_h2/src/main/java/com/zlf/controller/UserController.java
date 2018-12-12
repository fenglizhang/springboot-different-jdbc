package com.zlf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlf.bo.User;
import com.zlf.repository.UserRepository;

@RestController
@RequestMapping("/lol")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{id}")
	// 注意，此处使用的是GetMapping注解，该注解的作用类似与@RequestMapping(value="/user/{id}"
	// ,method=RequestMethod.GET)，@PostMapping注解同理	
	public User findById(@PathVariable int id) {
		return this.userRepository.findOne(id);
	}
	
	@RequestMapping("/getAll")
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
}
