package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.DiscountDTO;

/**
 * Describes a calculator for discounts
 */
public interface DiscountCalculator {
	public DiscountDTO calculateDiscount(CustomerDTO customer);
}
