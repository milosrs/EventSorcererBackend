package rixon.event.sourcing.EventSorcerer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EventSorcererApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSorcererApplication.class, args);
	}

}
