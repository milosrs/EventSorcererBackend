package rixon.event.sourcing.EventSorcerer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.keycloak.representations.UserInfo;
import org.keycloak.representations.account.UserRepresentation;

import rixon.event.sourcing.EventSorcerer.aggregates.UserAgregate;
import rixon.event.sourcing.EventSorcerer.commands.product.CreateProductCommand;
import rixon.event.sourcing.EventSorcerer.utility.SorcererToolbox;

@RestController
@RequestMapping(ControllerEndpointsPrefix.WORKER + "/create")
public class CreationController {
	@Autowired
	private UserAgregate userAgregate;
	@Autowired
	private SorcererToolbox utility;

	@PostMapping("/product")
	public boolean createProduct(@RequestBody CreateProductCommand command) {
		Set<String> roles = utility.getUserRoles();
		String jwt = utility.getJWTToken();
		roles.forEach(r -> System.out.println(r));
		System.out.println(jwt);
		return true;
	}
}
