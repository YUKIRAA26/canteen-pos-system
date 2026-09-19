package Canteen;
import java.util.*;

public class CheckOut {
	private final static Scanner scanner = new Scanner(System.in);
	
	
	public static void checkOut() {
		
		System.out.println("======================");
		System.out.println("       CHECK-OUT      ");
		System.out.println("======================");
		double total = 0;
		
		for(int i = 0; i < OrderManager.getOrderItem().size();i++) {
			total += OrderManager.getOrderItem().get(i).getSubtotal();
			System.out.println((i + 1) + "." + " " + OrderManager.getOrderItem().get(i));
		}
		
		System.out.println("Total: " + "$" + total);
		
		
		
		System.out.println();
		
		System.out.print("Confirm order? (Y/N): ");
		char confirm = scanner.nextLine().charAt(0);
		
		if(!(Character.toUpperCase(confirm) == 'Y')) {
			System.out.println("Not enough money! ");
			return;
		}
		
		double change = 0;
		double money = Exceptions.DoubleException("Enter Money: ");
		
		
		if(money >= total) {
			
			change = money - total;
			System.out.println("Money: " + money);
			System.out.println("total: " + total);
			System.out.println("Change: " + change);
			System.out.println("Thank you for ordering! ");
			
			OrderManager.getOrderItem().clear();
			return;
		}
		
		
		
		
	}
}
