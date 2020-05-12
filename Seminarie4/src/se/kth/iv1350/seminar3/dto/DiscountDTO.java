package se.kth.iv1350.seminar3.dto;

/**
 * Carrier for discount information.
 */
public class DiscountDTO {

	private double discountPercentage;

	/**
	 * Creates an instance
	 * @param discountPercentage the amount of discount.
	 */
	public DiscountDTO(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	

}
