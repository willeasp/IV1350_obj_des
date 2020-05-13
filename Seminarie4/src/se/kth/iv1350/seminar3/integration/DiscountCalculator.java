package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.DiscountDTO;

/**
 * Describes a calculator for discounts
 */
public interface DiscountCalculator {
	/**
	 * 'Calculates' the discount for the customer
	 * @param customer The customer that will get discounted
	 * @return A percentage of discount.
	 */
	public DiscountDTO calculateDiscount(CustomerDTO customer);
}
