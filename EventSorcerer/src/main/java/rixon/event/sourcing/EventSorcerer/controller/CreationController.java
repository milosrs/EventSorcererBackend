package rixon.event.sourcing.EventSorcerer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

import org.keycloak.representations.UserInfo;
import org.keycloak.representations.account.UserRepresentation;

import rixon.event.sourcing.EventSorcerer.aggregates.UserAgregate;
import rixon.event.sourcing.EventSorcerer.commands.product.CreateProductCommand;

@RestController
public class CreationController {
	@Autowired
	private UserAgregate userAgregate;

	@PostMapping(ControllerEndpointsPrefix.WORKER + "/create/product")
	public boolean createProduct(CreateProductCommand command) {
		return true;
	}
}
