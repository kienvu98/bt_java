package com.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.User;

@RestController
@RequestMapping("/demo")
public class UserController {

	@GetMapping(value ="/list")
	public ArrayList<User> list() {
		User u1 = new User(1, "Kien", "Hai Phong");
		User u2 = new User(2, "Thao", "Hai Phong");
		ArrayList<User> list= new ArrayList();
		list.add(u1);
		list.add(u2);
		return list;
	}
}
