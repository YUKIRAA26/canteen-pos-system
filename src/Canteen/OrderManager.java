package Canteen;
import java.util.*;


public class OrderManager {
	private static final Scanner scanner = new Scanner(System.in);
    private static final List<OrderItem> cart = new ArrayList<>();

	public static void addOrder() {
		List<ItemMenu> menuList = new ArrayList<>(ItemManager.getItemList().values());
		
		for(int i = 0; i < menuList.size() ; i++ ) {
			ItemMenu itemMenu = menuList.get(i);
			System.out.println((i + 1) + " " +  itemMenu.getName() + " " + itemMenu.getPrice() + "$" );
		}
		
		while(true) {
			int choice = Exceptions.IntegerException("Enter choice: ");
			if(choice > menuList.size()) {
				System.out.println("Invalid Item Choice! ");
				return;
			}
			
			
			int quantity = Exceptions.IntegerException("Enter quantity: ");
			
			ItemMenu selected = menuList.get(choice - 1);
			
			
			if(canFulfillOrder(selected, quantity)) {
			    boolean found = false;
			    
			    for(OrderItem list: cart) {
			    	if(list.getItemMenu().getId().equalsIgnoreCase(selected.getId())) {
			    		list.setQuantity(list.getQuantity() + quantity);
			    		found = true;
			    		break;
			    	}
			    	
			    }
				
				if(!found) {
					cart.add(new OrderItem(selected, quantity));
				}
				
			} else {
			    continue;
			}
			
			System.out.println("Succesfully added " + menuList.get(choice - 1).getName() + " " + quantity + "x");
	
			
			System.out.print("Do u want to add more? (Y/N): ");
			char orderMore = scanner.nextLine().charAt(0);
			
			if(Character.toUpperCase(orderMore) != 'Y') break;
		}	
	}
	
	public static void removeOrder() {
		if(cart.isEmpty()) {
			System.out.println("You haven't order yet! ");
			return;
		}
		
		while(true) {
			for(int i = 0; i < cart.size();i++) {
				System.out.println((i + 1) + " " + cart.get(i));			
			}
			
			int choice = Exceptions.IntegerException("Enter Item To Remove: ");
			if(choice > cart.size()) {
				System.out.println("item is not identified! ");
				continue;
			}
	
			cart.remove(choice - 1);
			break;
		}
		
		System.out.println("Succesfully removed item! ");
	}
	
	public static void updateQuantity() {
		if(cart.isEmpty()) {
			System.out.println("You haven't order yet! ");
			return;
		}
		
		while(true) {
			for(int i = 0; i < cart.size();i++) {
				System.out.println((i + 1) + " " + cart.get(i));			
			}
			
			int choice = Exceptions.IntegerException("Enter Item To Update: ");
			if(choice > cart.size()) {
				System.out.println("item is not identified! ");
				continue;
			}
			
			int newQty = Exceptions.IntegerException("Enter New Quantity: ");

			cart.get(choice - 1).setQuantity(newQty);
			break;
		}
		
		System.out.println("Succesfully Updated item! ");
	}
	
	private static boolean canFulfillOrder(ItemMenu selected, int quantity) {
		
		for(Map.Entry<String, Double> entry: selected.getRecipe().entrySet()) {
			String ingredientId = entry.getKey();
			double totalNeed = entry.getValue() * quantity;
			
			Ingredients ing = IngredientManager.getIngredients().get(ingredientId);
			
			if(ing.getCurrentStock() < totalNeed) {
				System.out.println("Not enough " + ing.getName() + "!");
				return false;
			}

		}
		
		for(Map.Entry<String, Double> entry: selected.getRecipe().entrySet()){
			String ingredientId = entry.getKey();
			double totalNeed = entry.getValue() * quantity;
			
			Ingredients ing = IngredientManager.getIngredients().get(ingredientId);
			double newStock = ing.getCurrentStock() - totalNeed;
			ing.setCurrentStock(newStock);
			
		}
		
		return true;
	}
	
	public static void displayCart() {
		if(cart.isEmpty()) {
			System.out.println("You haven't order yet! ");
			return;
		}
		
		for(int i = 0; i < cart.size();i++) {
			System.out.println((i + 1) + "." + " " + cart.get(i));			
		}
		
		System.out.println();
		System.out.println("1. Update Quantity ");
		System.out.println("2. Remove Order");
		System.out.println("3. Exit");
		int choice = Exceptions.IntegerException("Enter choice: ");
		
		if(choice == 3) {
			return;
		}
		
		switch(choice) {
			case 1 -> updateQuantity();
			case 2 -> removeOrder();
			default -> System.out.println("Please enter 1-3 only! ");
		}
	}
	
	public static List<OrderItem> getOrderItem(){
		return cart;
	}
}
