package rixon.event.sourcing.EventSorcerer.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.keycloak.representations.account.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rixon.event.sourcing.EventSorcerer.aggregates.UserAgregate;


@RestController
@RequestMapping("/auth")
public class AuthController {	
	@Autowired
	private UserAgregate userAgregate;
	
	@GetMapping("/api/userInfo")
	public UserRepresentation getUserInfo(@RequestParam String username) {
		try {
			return userAgregate.getUserInfo(username);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
