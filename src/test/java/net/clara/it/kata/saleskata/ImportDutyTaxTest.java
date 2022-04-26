package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ImportDutyTaxTest {

	@Test
	public void testImportedDutyTaxForBook() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 10.00);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}

	@Test
	public void testImportedDutyTaxForMusicCD() {
		Item item = new Item("music CD", Item.ItemType.OTHER, false, 14.99);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}

	@Test
	public void testImportedDutyTaxForChocolateBar() {
		Item item = new Item("chocolate bar", Item.ItemType.FOOD, false, 14.99);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}
	
	@Test
	public void testImportedDutyTaxForImportedChocolate() {
		Item item = new Item("imported box of chocolates", Item.ItemType.FOOD, true, 10.00);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0.5);
	}

	@Test
	public void testImportedDutyTaxForImportedPerfume() {
		Item item = new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 47.5);
		
		Tax basicSalesTax = new ImportDutyTax();
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(2.4);
	}
}