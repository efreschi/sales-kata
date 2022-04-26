package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ImportDutyTaxTest {

	@Test
	public void testObjectPriceTaxInput1() {
		Item item = new Item("imported box of chocolates", Item.ItemType.BOOK, 10.00);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0.5);
	}
}
