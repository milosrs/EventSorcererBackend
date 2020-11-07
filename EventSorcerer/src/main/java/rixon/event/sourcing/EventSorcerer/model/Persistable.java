package rixon.event.sourcing.EventSorcerer.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Persistable {
	@Id @Getter @Setter
	protected Long id;
}
