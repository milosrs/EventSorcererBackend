package rixon.event.sourcing.EventSorcerer.commands;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class BaseCommand {
	@Getter @Setter
	private String userIssuedBy;
	@Getter @Setter
	private LocalDate dateTimeIssued;
}
