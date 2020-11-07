package rixon.event.sourcing.EventSorcerer.commands.order;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import rixon.event.sourcing.EventSorcerer.commands.BaseCommand;
import rixon.event.sourcing.EventSorcerer.model.Product;

public class CreateOrderCommand extends BaseCommand {
	@Getter @Setter
	private Collection<Product> products;
	@Getter @Setter
	private boolean delivered;
	@Getter @Setter
	private Double totalBill;
}
