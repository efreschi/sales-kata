package net.clara.it.kata.saleskata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.clara.it.kata.saleskata.Item.ItemType;

public class ItemTax {
	
	private static Set<ItemType> exemptTypes = new HashSet<ItemType>(
			Arrays.asList(Item.ItemType.BOOK, Item.ItemType.FOOD, Item.ItemType.MEDICAL));

	private List<Tax> taxes = new ArrayList<Tax>();

	public ItemTax() {
		super();
		taxes.add(new BasicSalesTax(exemptTypes));
		taxes.add(new ImportDutyTax());
	}
	
	public double apply(Item item) {
		Double total = 0.0D;
		for(Tax tax : taxes){
            total = total + tax.apply(item);
        }
        return total;
	}
	

	public static Set<ItemType> getExemptTypes() {
		return exemptTypes;
	}
	

}
