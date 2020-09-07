package rixon.event.sourcing.EventSorcerer.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Table {
	@Id @Getter @Setter
	private Long id;
	@Getter @Setter
	private int seatsNumber;
	@Getter @Setter
	private int seatsTaken;
	@Getter @Setter
	private boolean reserved;
	@Getter @Setter
	private LocalDate reservedFrom;
	@Getter @Setter
	private LocalDate reservedTo;
}
