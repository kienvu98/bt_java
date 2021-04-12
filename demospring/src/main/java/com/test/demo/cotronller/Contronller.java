package com.test.demo.cotronller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.demo.service.UserService;
import com.test.model.User;

@RestController
@RequestMapping("/demo")
public class Contronller {
	
	@Autowired 
	UserService userService;

	@PostMapping("/add-user")
	public void add(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age) {
		User user = new User(id, name, age);
		userService.add(user);
		Logger logger= Logger.getLogger(Contronller.class);
		logger.info("add user");
	}
	
	@GetMapping("/search/{id}")
	public User user(@PathVariable int id) {
		User user= userService.search(id);	
		return user;
	}
	
	@PutMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		userService.delete(id);
		Logger logger= Logger.getLogger(Contronller.class);
		logger.info("delete user id :"+id);
	}
	
	@GetMapping("/list-user")
	public List<User> list(){
		return userService.list();
	}
}
