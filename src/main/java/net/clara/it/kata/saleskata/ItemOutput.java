package net.clara.it.kata.saleskata;

import java.math.BigDecimal;

public class ItemOutput {
	
	private Tax itemTax;

	public ItemOutput(Tax itemTax) {
		super();
		this.itemTax = itemTax;
	}

	public String output(int card, Item item) {
		return card + " " + item.getName() + ": " + getItemTotalPrice(card, item);
	}
	
	protected double getItemTotalPrice(int card, Item item) {
		return new BigDecimal("" + card)
				.multiply(new BigDecimal("" + item.getPrice()).add(new BigDecimal("" + itemTax.apply(item))))
				.doubleValue();
	}

}
