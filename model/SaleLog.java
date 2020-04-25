package model;

import java.util.LinkedList;

import dto.SaleDTO;

public class SaleLog {
	private LinkedList<SaleDTO> saleLog;

	public SaleLog() {
		saleLog = new LinkedList<SaleDTO>();
	}

	public void addSale(SaleDTO completedSale) {
		this.saleLog.add(completedSale);
	}

}
