package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
	
	private static final String SEP = System.getProperty("line.separator");

	@Test
	public void testShoppingCart2Book() {
		ShoppingCart cart1 = new ShoppingCart(new ItemOutput(new ItemTax(ItemTax.getDefaultTaxes())));
		cart1.addItem(2, new Item("book", Item.ItemType.BOOK, false, 12.49));
		
		String receipt = cart1.getReceipt();
		assertThat(receipt).isEqualTo(String.format("2 book: 24.98%sSales Taxes: 0.0%sTotal: 24.98", SEP, SEP));
	}

	@Test
	public void criterioAccettazione1() {
		ShoppingCart cart1 = new ShoppingCart(new ItemOutput(new ItemTax(ItemTax.getDefaultTaxes())));
		cart1.addItem(2, new Item("book", Item.ItemType.BOOK, false, 12.49));
		cart1.addItem(1, new Item("music CD", Item.ItemType.OTHER, false, 14.99));
		cart1.addItem(1, new Item("chocolate bar", Item.ItemType.FOOD, false, 0.85));
		
		String receipt = cart1.getReceipt();
		String expected = String.format(
				"2 book: 24.98%s1 music CD: 16.49%s1 chocolate bar: 0.85%sSales Taxes: 1.5%sTotal: 42.32", SEP, SEP,
				SEP, SEP);
		assertThat(receipt).isEqualTo(expected);
	}

	@Test
	public void criterioAccettazione2() {
		ShoppingCart cart1 = new ShoppingCart(new ItemOutput(new ItemTax(ItemTax.getDefaultTaxes())));
		cart1.addItem(1, new Item("imported box of chocolates", Item.ItemType.FOOD, true, 10.00));
		cart1.addItem(1, new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 47.50));
		
		String receipt = cart1.getReceipt();
		String expected = String.format(
				"1 imported box of chocolates: 10.5%s1 imported bottle of perfume: 54.65%sSales Taxes: 7.65%sTotal: 65.15", SEP, SEP,
				SEP);
		assertThat(receipt).isEqualTo(expected);
	}

	@Test
	public void criterioAccettazione3() {
		ShoppingCart cart1 = new ShoppingCart(new ItemOutput(new ItemTax(ItemTax.getDefaultTaxes())));
		cart1.addItem(1, new Item("imported bottle of perfume", Item.ItemType.OTHER, true, 27.99));
		cart1.addItem(1, new Item("bottle of perfume", Item.ItemType.OTHER, false, 18.99));
		cart1.addItem(1, new Item("packet of headache pills", Item.ItemType.MEDICAL, false, 9.75));
		cart1.addItem(3, new Item("box of imported chocolates", Item.ItemType.FOOD, true, 11.25));
		
		String receipt = cart1.getReceipt();
		String expected = String.format(
				"1 imported bottle of perfume: 32.19%s1 bottle of perfume: 20.89%s1 packet of headache pills: 9.75%s3 box of imported chocolates: 35.55%sSales Taxes: 7.9%sTotal: 98.38", SEP, SEP,
				SEP, SEP, SEP);
		assertThat(receipt).isEqualTo(expected);
	}
}
