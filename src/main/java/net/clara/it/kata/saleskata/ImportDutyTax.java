package net.clara.it.kata.saleskata;

import java.math.BigDecimal;

public class ImportDutyTax extends Tax {
	
	private static final BigDecimal RATE = new BigDecimal("0.05");

	@Override
	protected BigDecimal getRate() {
		return RATE;
	}

}
