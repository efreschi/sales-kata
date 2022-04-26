package net.clara.it.kata.saleskata;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

	private String name;
	private String type;
	private double price;
}
