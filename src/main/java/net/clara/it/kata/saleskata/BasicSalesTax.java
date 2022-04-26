package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicSalesTax {
	
	private static final BigDecimal RATE = new BigDecimal("0.1");
	
	public double apply(Item item) {
		return new BigDecimal("" + item.getPrice())
				.multiply(RATE)
				.setScale(2, RoundingMode.CEILING)
				.doubleValue();
	}

}
