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
	
	private List<ShoppingItem> shoppingCard = new ArrayList<ShoppingItem>();
	private ItemOutput itemOutput;
	
	public ShoppingCart(ItemOutput itemOutput) {
		super();
		this.itemOutput = itemOutput;
	}

	public void addItem(int card, Item item) {
		shoppingCard.add(new ShoppingItem(card, item));
	}
	
	public String getReceipt() {
		return null;
	}

}
