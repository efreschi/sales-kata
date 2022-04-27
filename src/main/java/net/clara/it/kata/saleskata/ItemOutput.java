package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ItemOutput {
	
	private Tax itemTax;

	public ItemOutput(Tax itemTax) {
		super();
		this.itemTax = itemTax;
	}

	public String output(int card, Item item, Consumer<Double> totalTax, Consumer<Double> totalItems) {
		Double totalPriceItem = getItemTotalPrice(card, item, totalTax);
		totalItems.accept(totalPriceItem);
		return String.format("%s %s: %s", card, item.getName(), totalPriceItem);
	}
	
	protected double getItemTotalPrice(int card, Item item, Consumer<Double> totalTax) {
		Double tax = itemTax.apply(item);
		for (int i = 0; i < card; i++) {
			totalTax.accept(tax);
		}
		return new BigDecimal("" + card)
				.multiply(new BigDecimal("" + item.getPrice()).add(new BigDecimal("" + tax)))
				.doubleValue();
	}

}
