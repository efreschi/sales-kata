package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ImportDutyTaxTest {

	@Test
	public void testImportedDutyTaxInput1() {
		Item item = new Item("imported box of chocolates", Item.ItemType.BOOK, 10.00);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0.5);
	}

	@Test
	public void testImportedDutyTaxInput2() {
		Item item = new Item("imported bottle of perfume", Item.ItemType.OTHER, 47.5);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(2.4);
	}
}