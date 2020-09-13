package rixon.event.sourcing.EventSorcerer.configuration;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import rixon.event.sourcing.EventSorcerer.model.enums.UserType;

/**
 * This is essentially WebSecurityConfigurerAdapter, but is configured to use Keycloak Authentication Server.
 * Server should be up and running on your local machine on port 8083.
 * @author milos
 *
 */
@Configuration
public class WebConfiguration extends KeycloakWebSecurityConfigurerAdapter {
	
	/**
	 * Call superclass configure method and set the Keycloak configuration
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		
		http
			.csrf().disable()
			.cors()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().anonymous()
			.and().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/*").permitAll()
			.and().authorizeRequests().antMatchers("/auth/**").permitAll()
			.and().authorizeRequests().antMatchers("/api/admin/**").hasRole(UserType.ADMIN.name())
			.and().authorizeRequests().antMatchers("/api/manager/**").hasAnyRole(UserType.MANAGER.name(), UserType.ADMIN.name())
			.and().authorizeRequests().antMatchers("/api/worker/**").hasAnyRole(UserType.ADMIN.name(), UserType.MANAGER.name(), UserType.WORKER.name())
			.anyRequest().authenticated();
	}

	/**
	 * Setup Auth Strategy. Don't add prefixes and suffixes to role strings
	 */
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}


	/**
	 * Setup CORS
	 * @return
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	/**
	 * Don't use keycloak.json. Instead, use application.yml properties.
	 * @return
	 */
	@Bean
	public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}
}
