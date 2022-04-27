package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ItemOutputTest {
	
	@Test
	public void testItemOutputForBook() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0D);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {}, (i) -> {});
		assertThat(res).isEqualToIgnoringCase("1 book: 12.49");
	}

	@Test
	public void testItemOutputForBookAndCheckTotal() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0D);
		
		final Double[] totali = new Double[] {0D, 0D};
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {
			totali[0] = BigDecimal.valueOf(totali[0]).add(BigDecimal.valueOf(t)).doubleValue();
		}, (i) -> {
			totali[1] = BigDecimal.valueOf(totali[1]).add(BigDecimal.valueOf(i)).doubleValue();
		});
		assertThat(totali[0]).isEqualTo(0D);
		assertThat(totali[1]).isEqualTo(12.49);
		assertThat(res).isEqualToIgnoringCase("1 book: 12.49");
	}

	@Test
	public void testItemOutputFor2Book() {
		Item item = new Item("book", Item.ItemType.BOOK, false, 12.49);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0d);
		
		final Double[] totali = new Double[] {0D, 0D};
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(2, item, (t) -> {
			totali[0] = BigDecimal.valueOf(totali[0]).add(BigDecimal.valueOf(t)).doubleValue();
		}, (i) -> {
			totali[1] = BigDecimal.valueOf(totali[1]).add(BigDecimal.valueOf(i)).doubleValue();
		});
		assertThat(totali[0]).isEqualTo(0D);
		assertThat(totali[1]).isEqualTo(24.98);
		assertThat(res).isEqualToIgnoringCase("2 book: 24.98");
	}

	@Test
	public void testItemOutputForMusicCD() {
		Item item = new Item("music CD", Item.ItemType.OTHER, false, 14.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.5);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {}, (i) -> {});
		assertThat(res).isEqualToIgnoringCase("1 music CD: 16.49");
	}

	@Test
	public void testItemOutputForMusicCDAndCheckTotali() {
		Item item = new Item("music CD", Item.ItemType.OTHER, false, 14.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.5);
		
		final Double[] totali = new Double[] {0D, 0D};
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {
			totali[0] = BigDecimal.valueOf(totali[0]).add(BigDecimal.valueOf(t)).doubleValue();
		}, (i) -> {
			totali[1] = BigDecimal.valueOf(totali[1]).add(BigDecimal.valueOf(i)).doubleValue();
		});
		assertThat(totali[0]).isEqualTo(1.5);
		assertThat(totali[1]).isEqualTo(16.49);
		assertThat(res).isEqualToIgnoringCase("1 music CD: 16.49");
	}

	@Test
	public void testItemOutputFor3BoxOfImportedChocolateAndCheckTotali() {
		Item item = new Item("box of imported chocolates", Item.ItemType.FOOD, true, 11.25);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0.6);
		
		final Double[] totali = new Double[] {0D, 0D};
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(3, item, (t) -> {
			totali[0] = BigDecimal.valueOf(totali[0]).add(BigDecimal.valueOf(t)).doubleValue();
		}, (i) -> {
			totali[1] = BigDecimal.valueOf(totali[1]).add(BigDecimal.valueOf(i)).doubleValue();
		});
		assertThat(totali[0]).isEqualTo(1.8);
		assertThat(totali[1]).isEqualTo(35.55);
		assertThat(res).isEqualToIgnoringCase("3 box of imported chocolates: 35.55");
	}

	@Test
	public void testItemOutputFor3BoxOfImportedChocolate() {
		Item item = new Item("box of imported chocolates", Item.ItemType.FOOD, true, 11.25);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(0.6);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(3, item, (t) -> {}, (i) -> {});
		assertThat(res).isEqualToIgnoringCase("3 box of imported chocolates: 35.55");
	}

	@Test
	public void testItemOutputForBottlePerfume() {
		Item item = new Item("bottle of perfume", Item.ItemType.OTHER, false, 18.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.9);
		
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {}, (i) -> {});
		assertThat(res).isEqualToIgnoringCase("1 bottle of perfume: 20.89");
	}
	
	@Test
	public void testItemOutputForBottlePerfumeAndCheckTotali() {
		Item item = new Item("bottle of perfume", Item.ItemType.OTHER, false, 18.99);

		Tax itemTax = mock(ItemTax.class);
		when(itemTax.apply(item)).thenReturn(1.9);
		
		final Double[] totali = new Double[] {0D, 0D};
		ItemOutput itemOutput = new ItemOutput(itemTax);
		String res = itemOutput.output(1, item, (t) -> {
			totali[0] = BigDecimal.valueOf(totali[0]).add(BigDecimal.valueOf(t)).doubleValue();
		}, (i) -> {
			totali[1] = BigDecimal.valueOf(totali[1]).add(BigDecimal.valueOf(i)).doubleValue();
		});
		assertThat(totali[0]).isEqualTo(1.9);
		assertThat(totali[1]).isEqualTo(20.89);
		assertThat(res).isEqualToIgnoringCase("1 bottle of perfume: 20.89");
	}
}
