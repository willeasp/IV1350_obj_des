package se.kth.iv1350.seminar3.view;

import javax.swing.JOptionPane;

import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.model.SaleObserver;

/**
 * Observes the total revenue of a sale.
 */
public class TotalRevenueView implements SaleObserver {
	private int totalRevenue;
	
	/**
	 * Creates a new instance of the Observer class.
	 */
	public TotalRevenueView() {
		totalRevenue = 0;
	}

	/**
	 * Displays the total revenue from the sale.
	 */
	@Override
	public void newPayment(SaleDTO completedSale) {
		this.totalRevenue += completedSale.getAmountPaid() - completedSale.getChange();
		updateView();
	}
	
	private void updateView() {
		String message = "Total revenue is: " + totalRevenue + "$. Nice.";
		System.err.println(message);
	}
	
}
