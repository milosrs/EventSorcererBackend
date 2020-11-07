package rixon.event.sourcing.EventSorcerer.commands.product;

import lombok.Getter;
import lombok.Setter;
import rixon.event.sourcing.EventSorcerer.commands.BaseCommand;
import rixon.event.sourcing.EventSorcerer.model.enums.ProductType;

public class CreateProductCommand extends BaseCommand {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private Double price;
	@Getter @Setter
	private boolean isAvailable;
	@Getter @Setter
	private ProductType type;
}
