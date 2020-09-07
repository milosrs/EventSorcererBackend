package rixon.event.sourcing.EventSorcerer.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rixon.event.sourcing.EventSorcerer.model.enums.UserType;

@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id @Getter @Setter
	private Long id;
	@Getter @Setter
	private String username;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String lastName;
	@Getter @Setter
	private LocalDate birthDay;
	@Getter @Setter
	private UserType type;
	@Getter @Setter
	private Double salary;
}
