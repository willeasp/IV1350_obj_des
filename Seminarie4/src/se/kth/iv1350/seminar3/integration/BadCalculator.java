package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.DiscountDTO;

/**
 * A DiscountCalculator that doesn't give so much discount
 */
public class BadCalculator implements DiscountCalculator {

	
	@Override
	public DiscountDTO calculateDiscount(CustomerDTO customer) {
		return new DiscountDTO(percent(2));
	}
	
	private double percent(double p) {
		return p/100;
	}

}
