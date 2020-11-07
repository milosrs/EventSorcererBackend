package rixon.event.sourcing.EventSorcerer.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rixon.event.sourcing.EventSorcerer.model.enums.ProductType;

@NoArgsConstructor
@AllArgsConstructor
public class Product extends Persistable {
	@Getter @Setter
	private LocalDate createdOn;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private Double price;
	@Getter @Setter
	private ProductType type;
}
