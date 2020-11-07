package rixon.event.sourcing.EventSorcerer.model;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Order extends Persistable {
	@Getter @Setter
	private LocalDate receivedOn;
	@Getter @Setter
	private Collection<Product> products;
	@Getter @Setter
	private boolean delivered;
	@Getter @Setter
	private Double totalBill;
}
