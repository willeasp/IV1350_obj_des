package integration;

import dto.ReceiptDTO;
import dto.ItemDTO;
import java.lang.StringBuilder;

public class Printer {

	public void printReceipt(ReceiptDTO receipt) {
		StringBuilder sb = new StringBuilder();
		sb.append("____________________________________\n"
				+ "                                    |\n");
		sb.append("RECEIPT\n");
		sb.append(receipt.getDate() + " " + receipt.getStartTime() + "\n");
		sb.append(receipt.getStoreName() + "\n" + receipt.getStoreAddress() + "\n\n");
		for(ItemDTO item : receipt.getItemList()) {
			sb.append(String.format("%-12s %5.2f$ * %d: %5.2f$\n", item.getName(), item.getPrice(), item.getQuantity(), item.getPrice()*item.getQuantity()));
		}
		sb.append(String.format("\n  TOTAL:  %.2f$   (incl. VAT)\n", receipt.getTotalPrice()));
		sb.append(String.format(  "  VAT:    %.2f$", receipt.getTotalVAT()));
		
		
		
		System.out.println(sb.toString());
	}

	public Printer() {
	}

}
