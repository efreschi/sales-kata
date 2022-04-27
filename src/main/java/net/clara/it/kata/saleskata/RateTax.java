package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class RateTax implements Tax {

	private static final BigDecimal VENTI = new BigDecimal("20");

	public RateTax() {
		super();
	}

	public double apply(Item item) {
		return new BigDecimal("" + item.getPrice())
				.multiply(getRate())
				.multiply(VENTI)
				.setScale(0, RoundingMode.CEILING)
				.divide(VENTI, 2, RoundingMode.UNNECESSARY)
				.doubleValue();
	}

	protected abstract BigDecimal getRate() ;

}