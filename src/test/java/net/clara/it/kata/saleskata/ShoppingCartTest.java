package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
	
	private static final String SEP = System.getProperty("line.separator");

	@Test
	public void testShoppingCart() {
		ShoppingCart cart1 = new ShoppingCart(new ItemOutput(new ItemTax(ItemTax.getDefaultTaxes())));
		cart1.addItem(2, new Item("book", Item.ItemType.BOOK, false, 12.49));
		
		String receipt = cart1.getReceipt();
		assertThat(receipt).isEqualTo(String.format("2 book: 24.98%sSales Taxes: 0.0%sTotal: 24.98", SEP, SEP));
	}
}
