package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.DiscountDatabase;
import se.kth.iv1350.seminar3.integration.ExternalAccountingSystem;
import se.kth.iv1350.seminar3.integration.ExternalInventorySystem;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Register;
import se.kth.iv1350.seminar3.model.Sale;
import se.kth.iv1350.seminar3.model.SaleLog;

/**
 * Controller layer for the process sale.
 *
 */
public class Controller {
	private Sale sale;
	private SaleLog log;
	private DiscountDatabase discountDatabase;
	private ExternalInventorySystem externalInventorySystem;
	private ExternalAccountingSystem externalAccountingSystem;
	private Register register;
	private Printer printer;

	public Controller (ExternalInventorySystem extinvsys, ExternalAccountingSystem extaccsys, DiscountDatabase discountDB, Printer printer) {
		this.externalInventorySystem = extinvsys;
		this.externalAccountingSystem = extaccsys;
		this.discountDatabase = discountDB;
		this.printer = printer;
		
		this.register = new Register();
		this.log = new SaleLog();
	}
	
	/**
	 *  Creates a new <code>Sale</code>.
	 */
	public void startNewSale() {
		this.sale = new Sale(this.printer);
	}

	/**
	 * Adds item to Sale if found in the external inventory system. 	 
	 * @param itemEntry Container for item identifier and quantity.
	 * @return The item found in the external inventory system.
	 */
	public ItemDTO registerItem(ItemEntryDTO itemEntry) {
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		this.sale.addItem(item);
		return item;		
	}

	/**
	 * 
	 * @return Current state of the sale.
	 */
	public SaleDTO endSale() {
		return getCurrentSale();
	}

	public SaleDTO getCurrentSale() {
		return sale.getCurrent();
	}

	public void discountRequest(CustomerDTO customer) {

	}

	/**
	 * Declare payment of sale.
	 * @param amountPaid The amount payed.
	 * @return	Amount of change to be given back to the customer.
	 */
	public double payment(PaymentDTO amountPaid) {
		this.register.increaseBalance(amountPaid);
		SaleDTO completedSale = this.sale.saleCompleted(amountPaid);
		this.log.addSale(completedSale);
		this.externalInventorySystem.updateInventory(completedSale);
		this.externalAccountingSystem.updateAccounting(completedSale);
		return completedSale.getChange();		
	}

}
