package rixon.event.sourcing.EventSorcerer.aggregates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.keycloak.representations.account.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserAgregate {
	@Value("{keycloak.auth-server-url}")
	private String authServerUrl;
	@Value("{keycloak.realm}")
	private String realm;

	private static final HttpClient client = HttpClient.newHttpClient();
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public UserRepresentation getUserInfo(final String username) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI(authServerUrl.replace("auth", realm) + "?username=" + username))
				.build();
		
		final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		final UserRepresentation userData = mapper.readValue(response.body(), UserRepresentation.class);
		
		return userData;
	}
}