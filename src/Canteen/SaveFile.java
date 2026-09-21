package Canteen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class SaveFile {
	public static void save(List<OrderItem> cart, double total) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
			LocalDateTime dayOrder = LocalDateTime.now();
			
			
			writer.write(dayOrder.toString());	
			writer.newLine();
			 writer.write("======================");
		        writer.newLine();
		        writer.write("       RECEIPT");
		        writer.newLine();
		        writer.write("======================");
		        
		        for (OrderItem receipt : cart) {
		            writer.newLine();
		            writer.write(receipt.getItemMenu().getName()
		                    + " x" + receipt.getQuantity()
		                    + " = ₱" + String.format("%.2f", receipt.getSubtotal()));
		        }

		        writer.newLine();
		        writer.write("----------------------");
		        writer.newLine();
		        writer.write("TOTAL: ₱" + String.format("%.2f", total));
		        writer.newLine();
		        writer.newLine();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
