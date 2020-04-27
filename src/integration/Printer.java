package integration;

import dto.ReceiptDTO;
import dto.ItemDTO;
import java.lang.StringBuilder;

public class Printer {

	public void printReceipt(ReceiptDTO receipt) {
		StringBuilder sb = new StringBuilder();
		sb.append("____________________________________\n"
				+ "                                    |\n");
		sb.append("             RECEIPT                |\n");
		sb.append(receipt.getDate() + " " + receipt.getStartTime() + "\n");
		sb.append(receipt.getStoreName() + "\n" + receipt.getStoreAddress() + "\n\n");
		for(ItemDTO item : receipt.getItemList()) {
			sb.append(String.format("%-12s %5.2f$ * %d: %5.2f$\n", item.getName(), item.getPrice(), item.getQuantity(), item.getPrice()*item.getQuantity()));
		}
		sb.append("------------------------------------");
		sb.append(String.format("\nTOTAL:  %.2f$  %-19s|\n", receipt.getTotalPrice(), "(incl. VAT)"));
		sb.append(String.format(  "VAT:    %.2f$                      |\n", receipt.getTotalVAT()));
		sb.append(                "____________________________________|\n");
		
		
		
		System.out.println(sb.toString());
	}

	public Printer() {
	}

}
