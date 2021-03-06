package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ShoppingCart {
	
	@Data
	@AllArgsConstructor
	private static class ShoppingItem {
		private int card;
		private Item item;
	}
	
	private class Totali {
		private double totalTax = 0d;
		private double totalCart = 0d;
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
		final Totali totali = new Totali();
		Consumer<Double> calcolatoreTotalTax = (t) -> totali.totalTax = new BigDecimal("" + totali.totalTax).add(new BigDecimal("" + t)).doubleValue();
		Consumer<Double> calcolatoreTotalCart = (t) -> totali.totalCart = new BigDecimal("" + totali.totalCart).add(new BigDecimal("" + t)).doubleValue();
		
		StringBuilder sb = new StringBuilder();
		for (ShoppingItem shoppingItem: shoppingCart) {
			sb.append(itemOutput.output(shoppingItem.getCard(), shoppingItem.getItem(), calcolatoreTotalTax, calcolatoreTotalCart));
			sb.append(System.getProperty("line.separator"));
		}
		sb.append("Sales Taxes: " + totali.totalTax);
		sb.append(System.getProperty("line.separator"));
		sb.append("Total: " + totali.totalCart);
		
		return sb.toString();
	}

}
