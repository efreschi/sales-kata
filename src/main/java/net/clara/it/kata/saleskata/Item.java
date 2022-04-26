package net.clara.it.kata.saleskata;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
	
	public static enum ItemType {
		BOOK, FOOD, MEDICAL, OTHER;
	}

	private String name;
	private ItemType type;
	private double price;
}
