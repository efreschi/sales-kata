package net.clara.it.kata.saleskata;

import java.math.BigDecimal;

public class BasicSalesTax extends Tax {
	
	private static final BigDecimal RATE = new BigDecimal("0.1");

	@Override
	protected BigDecimal getRate() {
		return RATE;
	}

}
