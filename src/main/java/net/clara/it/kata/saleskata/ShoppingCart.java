package net.clara.it.kata.saleskata;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ShoppingCart {
	
	@Data
	@AllArgsConstructor
	private static class ShoppingItem {
		private int card;
		private Item item;
	}
	
	private List<ShoppingItem> shoppingCart = new ArrayList<ShoppingItem>();
	private ItemOutput itemOutput;
	
	public ShoppingCart(ItemOutput itemOutput) {
		super();
		this.itemOutput = itemOutput;
	}

	public void addItem(int card, Item item) {
		shoppingCart.add(new ShoppingItem(card, item));
	}
	
	public String getReceipt() {
		StringBuilder sb = new StringBuilder();
		for (ShoppingItem shoppingItem: shoppingCart) {
			sb.append(itemOutput.output(shoppingItem.getCard(), shoppingItem.getItem()));
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
