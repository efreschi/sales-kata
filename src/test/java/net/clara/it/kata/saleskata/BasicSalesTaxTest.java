package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicSalesTaxTest {
	

	@Test
	public void testBasicSalexTaxForBook() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}

	@Test
	public void testBasicSalexTaxForImportedPerfume() {
		Item item = new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 47.5);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(4.75);
	}

	@Test
	public void testBasicSalexTaxForImportedBook() {
		Item item = new Item("book", Item.ItemType.BOOK, true, 12.49);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}

	@Test
	public void testBasicSalexTaxForMusicCD() {
		Item item = new Item("music CD", Item.ItemType.OTHER, false, 14.99);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(1.5);
	}

	@Test
	public void testBasicSalexTaxForChocolateBar() {
		Item item = new Item("chocolate bar", Item.ItemType.FOOD, false, 0.85);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}

	@Test
	public void testBasicSalexTaxForBottlePerfume() {
		Item item = new Item("bottle of perfume", Item.ItemType.OTHER, false, 47.5);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(4.75);
	}

	@Test
	public void testBasicSalexTaxPackectHeadachePills() {
		Item item = new Item("packet of headache pills", Item.ItemType.MEDICAL, false, 9.75);
		
		Tax basicSalesTax = new BasicSalesTax(ItemTax.getExemptTypes());
		double tax = basicSalesTax.apply(item);
		assertThat(tax).isEqualTo(0D);
	}
}
