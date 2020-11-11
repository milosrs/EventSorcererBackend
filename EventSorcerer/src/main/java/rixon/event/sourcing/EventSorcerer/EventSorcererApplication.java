package rixon.event.sourcing.EventSorcerer;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EventSorcererApplication {

	public static void main(String[] args) {
		//Wanna know why this one-liner needs to be added?
		//Wanna know what OpenJDK and Elliptic Crpytography algorithms are? :D 
		//Go here: https://keycloak.discourse.group/t/spring-boot-and-openjdk-ecdsa-keyfactory-not-available/1849/4
		//And here: https://stackoverflow.com/questions/31971499/ecdhe-cipher-suites-not-supported-on-openjdk-8-installed-on-ec2-linux-machine/31973241#31973241
		//AND HERE: https://stackoverflow.com/questions/42159690/why-are-the-jce-unlimited-strength-not-included-by-default
		Security.addProvider(new BouncyCastleProvider());
		SpringApplication.run(EventSorcererApplication.class, args);
	}

}
