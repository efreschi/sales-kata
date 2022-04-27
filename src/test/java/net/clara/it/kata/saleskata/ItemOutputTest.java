package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class ItemOutputTest {
	
	@Test
	public void testItemOutputForBook() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0D);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item);
		assertThat(res).isEqualToIgnoringCase("1 book: 12.49");
	}

	@Test
	public void testItemOutputFor2Book() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0d);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(2, item);
		assertThat(res).isEqualToIgnoringCase("2 book: 24.98");
	}

	@Test
	public void testItemOutputForMusicCD() {
		Item item = new Item("music CD", Item.ItemType.OTHER, false, 14.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.5);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item);
		assertThat(res).isEqualToIgnoringCase("1 music CD: 16.49");
	}

	@Test
	public void testItemOutputFor3BoxOfImportedChocolate() {
		Item item = new Item("box of imported chocolates", Item.ItemType.FOOD, true, 11.25);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0.6);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(3, item);
		assertThat(res).isEqualToIgnoringCase("3 box of imported chocolates: 35.55");
	}

	@Test
	public void testItemOutputForBottlePerfume() {
		Item item = new Item("bottle of perfume", Item.ItemType.OTHER, false, 18.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.9);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item);
		assertThat(res).isEqualToIgnoringCase("1 bottle of perfume: 20.89");
	}
}
