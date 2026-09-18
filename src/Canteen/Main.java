package Canteen;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		boolean running = true;
		
		System.out.println("=================================");
		System.out.println("   CANTEEN POS/INVETORY SYSTEM   ");
		System.out.println("=================================");
		
		while(running) {
			mainMenu();
			String choice = Exceptions.StringException("Enter Choice: ");
			
			if(choice.equals("9")) return;
			
			switch(choice) {
				case "1" -> ItemManager.displayItemMenu();
				case "2" -> OrderManager.addOrder();
				case "3" -> OrderManager.displayCart();
				case "4" -> CheckOut.checkOut();
				case "6" -> IngredientManager.addIngredient();
				case "7" -> ItemManager.addMenu();
				case "8" -> IngredientManager.displayLowStock();
				
			}
			
		}
		
	}
	
	private static void mainMenu() {
		System.out.println("1. View Menu ");
		System.out.println("2. Order / Sell Item ");
		System.out.println("3. View Cart ");
		System.out.println("4. Check Out ");
		System.out.println("5. View Sales Report ");
		System.out.println("----- ADMIN -----");
		System.out.println("6. Add Stock (Ingredient)");
		System.out.println("7. Add Menu Item ");
		System.out.println("8. View Low Stock ");
		System.out.println("9. Exit");
	}
	
}
