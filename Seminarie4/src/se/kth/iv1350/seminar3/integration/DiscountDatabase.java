package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.DiscountDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;

/**
 * Integration for the discount database.
 *
 */
public class DiscountDatabase {

	/**
	 * Requests a discount
	 * @param customer The ID of a customer
	 * @param currentSale
	 * @return
	 */
	public DiscountDTO discountRequest(CustomerDTO customer, SaleDTO currentSale) {
		if (customer.getCustomerID() == 710123) {						// Kompispris för den jannen ;)
			return new NiceCalculator().calculateDiscount(customer);
		}
		else {
			return new BadCalculator().calculateDiscount(customer);
		}
	}

	public DiscountDatabase() {
	}

}
