package rixon.event.sourcing.EventSorcerer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rixon.event.sourcing.EventSorcerer.dto.LoginDataDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDataDto loginData) {
		String data = loginData.getUsername() + " " + loginData.getPassword();
		System.out.println(data);
		return data;
	}
}
