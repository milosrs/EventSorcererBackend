package rixon.event.sourcing.EventSorcerer.model;

import java.util.Collection;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CoffeeShop {
	@Id
	@Getter @Setter
	private Long Id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private Double profit;
	@Getter @Setter
	private Collection<Table> tables;
	@Getter @Setter
	private Collection<Product> products;
	@Getter @Setter
	private Collection<Order> order;
}
