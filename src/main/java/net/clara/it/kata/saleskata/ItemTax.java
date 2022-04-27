package net.clara.it.kata.saleskata;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.clara.it.kata.saleskata.Item.ItemType;

public class ItemTax implements Tax {
	
	private static Set<ItemType> defaultExemptTypes = new HashSet<ItemType>(
			Arrays.asList(Item.ItemType.BOOK, Item.ItemType.FOOD, Item.ItemType.MEDICAL));

	final private List<Tax> taxes;

	public ItemTax(List<Tax> taxes) {
		super();
		this.taxes = taxes;
	}
	
	@Override
	public double apply(Item item) {
		Double total = 0.0D;
		for(Tax tax : taxes){
            total = new BigDecimal("" + total).add(new BigDecimal("" + tax.apply(item))).doubleValue();
        }
        return total;
	}
	
	public static List<Tax> getDefaultTaxes() {
		return Arrays.asList(new BasicSalesTax(defaultExemptTypes), new ImportDutyTax());
	}
	
	public static Set<ItemType> getDefaultExemptTypes() {
		return defaultExemptTypes;
	}
	

}
