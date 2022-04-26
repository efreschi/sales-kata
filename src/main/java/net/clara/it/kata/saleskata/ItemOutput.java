package net.clara.it.kata.saleskata;

public class ItemOutput {

	public String output(Item item) {
		return item.getName() + ": " + item.getPrice();
	}

}
