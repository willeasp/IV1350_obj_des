package model;

import java.util.LinkedList;

import dto.SaleDTO;

public class SaleLog {
	private LinkedList<SaleDTO> saleLog;

	public SaleLog() {
		saleLog = new LinkedList<SaleDTO>();
	}

	/**
	 * Store a sale in the salelog.
	 * @param completedSale The sale to be added the log.
	 */
	public void addSale(SaleDTO completedSale) {
		this.saleLog.add(completedSale);
	}
	
	public LinkedList<SaleDTO> getSaleLog() {
		return new LinkedList<SaleDTO>(this.saleLog);
	}

}
