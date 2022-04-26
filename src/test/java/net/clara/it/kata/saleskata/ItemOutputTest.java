package net.clara.it.kata.saleskata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ItemOutputTest {
	
	@Test
	public void test_InstanceGoodAndOutput() {
		Item item = new Item("book", Item.ItemType.BOOK, 12.49);
		ItemOutput itemOutput = new ItemOutput();
		String res = itemOutput.output(item);
		assertThat(res).isEqualToIgnoringCase("book: 12.49");
	}

}
