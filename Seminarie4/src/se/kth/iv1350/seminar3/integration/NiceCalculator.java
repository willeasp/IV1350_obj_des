package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.DiscountDTO;

public class NiceCalculator implements DiscountCalculator {

	@Override
	public DiscountDTO calculateDiscount(CustomerDTO customer) {
		return new DiscountDTO(percent(20));
	}
	
	private double percent(double p) {
		return p/100;
	}
}
