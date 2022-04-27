package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ItemTaxTest {
	
	@Test
	public void testItemTaxForImportedBottlePerfume() {
		Item item = 
				new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 47.5);
		Tax taxItem = new ItemTax(ItemTax.getDefaultTaxes());
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(7.15);
		
	}

	@Test
	public void testItemTaxForBook() {
		Item item = 
				new Item("book", Item.ItemType.BOOK, false, 12.49);
		Tax taxItem = new ItemTax(ItemTax.getDefaultTaxes());
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(0D);
		
	}

	@Test
	public void testItemTaxForMusicCDk() {
		Item item = 
				new Item("music CD", Item.ItemType.OTHER, false, 14.99);
		Tax taxItem = new ItemTax(ItemTax.getDefaultTaxes());
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(1.5);
		
	}
}
