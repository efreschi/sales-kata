package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicSalesTaxTest {

	@Test
	public void testObjectPriceTaxInput1() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);
		
		Tax basicSalesTax = new BasicSalesTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(1.25);
	}

	@Test
	public void testBasicTaxTaxInput2() {
		Item item = new Item("imported bottle of perfume", Item.ItemType.OTHER, false, 47.5);
		
		Tax basicSalesTax = new BasicSalesTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(4.75);
	}

	@Test
	public void testObjectPriceImportedTaxInput1() {
		Item item = new Item("book", Item.ItemType.BOOK, true, 12.49);
		
		Tax basicSalesTax = new BasicSalesTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(1.25);
	}
}