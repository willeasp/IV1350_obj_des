package se.kth.iv1350.seminar3.dto;

/**
 * DTO for carrying Customer Identification.
 *
 */
public class CustomerDTO {

	private int customerID;

	/**
	 * creates an instance
	 * @param customerID The ID number of the customer
	 */
	public CustomerDTO(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * 
	 * @return The ID number
	 */
	public int getCustomerID() {
		return customerID;
	}

}
