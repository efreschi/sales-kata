package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ItemTaxTest {
	
	@Test
	public void testItemTaxForImportedBottlePerfume() {
		Item item = 
				new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 47.5);
		
		Tax tax1 = mock(Tax.class);
		Tax tax2 = mock(Tax.class);
		when(tax1.apply(item)).thenReturn(0D);
		when(tax2.apply(item)).thenReturn(7.15);
		
		Tax taxItem = new ItemTax(Arrays.asList(tax1, tax2));
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(7.15);
		
	}

	@Test
	public void testItemTaxForBook() {
		Item item = 
				new Item("book", Item.ItemType.BOOK, false, 12.49);
		
		Tax tax1 = mock(Tax.class);
		Tax tax2 = mock(Tax.class);
		when(tax1.apply(item)).thenReturn(0D);
		when(tax2.apply(item)).thenReturn(0D);
		
		Tax taxItem = new ItemTax(Arrays.asList(tax1, tax2));
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(0D);
		
	}

	@Test
	public void testItemTaxForMusicCDk() {
		Item item = 
				new Item("music CD", Item.ItemType.OTHER, false, 14.99);
		Tax tax1 = mock(Tax.class);
		Tax tax2 = mock(Tax.class);
		when(tax1.apply(item)).thenReturn(1.5);
		when(tax2.apply(item)).thenReturn(0d);
		
		Tax taxItem = new ItemTax(Arrays.asList(tax1, tax2));
		double tax = taxItem.apply(item);
		assertThat(tax).isEqualTo(1.5);
		
	}
}
