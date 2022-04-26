package net.clara.it.kata.saleskata;

import java.math.BigDecimal;

public class ImportDutyTax extends Tax {
	
	private static final BigDecimal RATE = new BigDecimal("0.05");

	@Override
	public double apply(Item item) {
		if (item.isImported()) {
			return super.apply(item);
		}
		return 0D;
	}

	@Override
	protected BigDecimal getRate() {
		return RATE;
	}

}
