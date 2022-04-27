package net.clara.it.kata.saleskata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.clara.it.kata.saleskata.Item.ItemType;

public class ItemTax implements Tax {
	
	private static Set<ItemType> exemptTypes = new HashSet<ItemType>(
			Arrays.asList(Item.ItemType.BOOK, Item.ItemType.FOOD, Item.ItemType.MEDICAL));

	private List<RateTax> taxes = new ArrayList<RateTax>();

	public ItemTax() {
		super();
		taxes.add(new BasicSalesTax(exemptTypes));
		taxes.add(new ImportDutyTax());
	}
	
	@Override
	public double apply(Item item) {
		Double total = 0.0D;
		for(RateTax tax : taxes){
            total = total + tax.apply(item);
        }
        return total;
	}
	

	public static Set<ItemType> getDefaultExemptTypes() {
		return exemptTypes;
	}
	

}
