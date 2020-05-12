package se.kth.iv1350.seminar3.dto;

/**
 * DTO for carrying Customer Identification.
 *
 */
public class CustomerDTO {

	private int customerID;

	public CustomerDTO(int customerID) {
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

}
