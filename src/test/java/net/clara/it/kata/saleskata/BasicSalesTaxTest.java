package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicSalesTaxTest {

	@Test
	public void testObjectPriceTaxInput1() {
		Item item = new Item("book", Item.ItemType.BOOK, 12.49);
		BasicSalesTax basicSalesTax = new BasicSalesTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(1.25);
	}
}
