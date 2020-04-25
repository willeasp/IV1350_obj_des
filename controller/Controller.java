package controller;

import model.Sale;
import model.SaleLog;
import integration.DiscountDatabase;
import integration.ExternalInventorySystem;
import integration.ExternalAccountingSystem;
import model.Register;
import integration.Printer;
import dto.ItemDTO;
import dto.ItemEntryDTO;
import dto.SaleDTO;
import dto.CustomerDTO;
import dto.PaymentDTO;

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

	public SaleDTO endSale() {
		return getCurrentSale();
	}

	public SaleDTO getCurrentSale() {
		return sale.getCurrent();
	}

	public void discountRequest(CustomerDTO customer) {

	}

	public void payment(PaymentDTO amountPaid) {
		this.register.increaseBalance(amountPaid);
		this.sale.saleCompleted(amountPaid);
		
	}

}
