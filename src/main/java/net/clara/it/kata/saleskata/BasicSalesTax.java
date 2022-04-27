package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import net.clara.it.kata.saleskata.Item.ItemType;

public class BasicSalesTax extends RateTax {
	
	private static final BigDecimal RATE = new BigDecimal("0.1");

	private Set<ItemType> exemptTypes = new HashSet<>();
	
	public BasicSalesTax(Set<ItemType> exemptTypes) {
		super();
		if (exemptTypes != null) {
		this.exemptTypes.addAll(exemptTypes);
			
		}
	}
	
	

	@Override
	public double apply(Item item) {
		if (!isItemExempted(item)) {
			return super.apply(item);
		}
		return 0D;
	}



	protected boolean isItemExempted(Item item) {
		return exemptTypes.contains(item.getType());
	}



	@Override
	protected BigDecimal getRate() {
		return RATE;
	}

}
