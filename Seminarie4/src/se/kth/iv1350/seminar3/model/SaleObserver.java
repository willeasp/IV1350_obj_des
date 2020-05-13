package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;

/**
 * Implemented by a class that will observe a <code>Sale</code>
 */
public interface SaleObserver {
	/**
	 * Invoked when a payment has been done. Notifies observers to update.
	 * @param completedSale The sale that was completed.
	 */
	void newPayment(SaleDTO completedSale);
}
