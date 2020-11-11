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

import org.keycloak.representations.UserInfo;
import org.keycloak.representations.account.UserRepresentation;

import rixon.event.sourcing.EventSorcerer.aggregates.UserAgregate;
import rixon.event.sourcing.EventSorcerer.commands.product.CreateProductCommand;

@RestController
@RequestMapping(ControllerEndpointsPrefix.WORKER + "/create")
public class CreationController {
	@Autowired
	private UserAgregate userAgregate;

	@PostMapping("/product")
	public boolean createProduct(@RequestBody CreateProductCommand command) {
		return true;
	}
}
