package Canteen;
import java.util.*;

public class ItemManager {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Map<String,ItemMenu> itemMenu = new HashMap<>();
	
	public static void addMenu() {
		String id;
		while(true) {
			id = Exceptions.StringException("Enter Item ID: ");
			if(itemMenu.containsKey(id)) {
				System.out.println("ID Already Exist! ");
				continue;
			}
			break;
		}
		String name = Exceptions.StringException("Enter ItemName Name: ");
		
		MenuCategory category;
		while(true) {

			String categoryInput = Exceptions.StringException("Enter Item Category(Meals,Snacks,Drinks): ");
			boolean isValid = Arrays.stream(MenuCategory.values())
					.anyMatch(c -> c.name().equalsIgnoreCase(categoryInput));
			
			if(!isValid) {
				System.out.println("Category does not exist! ");
				continue;
			}
			category = MenuCategory.valueOf(categoryInput.toUpperCase());
			break;
		}
		double price = Exceptions.DoubleException("Enter Item Price: ");
		
		Map<String, Double> recipe = new HashMap<>();
		
		while(true) {
			System.out.println("== Make recipe of your item ==");
			IngredientManager.viewAllIngredients();
			
			String ingredientId = Exceptions.StringException("Enter Ingredient Id: ");
			
			if(!IngredientManager.getIngredients().containsKey(ingredientId)) {
				System.out.println("Ingredient ID does not exist! ");
				continue;
			}
			
			Double qty = Exceptions.DoubleException("Enter Quantity: ");
			recipe.put(ingredientId, qty);
			
			String more = Exceptions.StringException("Add another ingredient? (Y/N):  ");
			if(!more.equalsIgnoreCase("y")) {
				break;
			}
		}
		itemMenu.put(id, new ItemMenu(id,name,category,price,recipe));
		System.out.println("Succesfully Added Menu! ");
		
	}
	
	public static void removeMenu() {
		String id = Exceptions.StringException("Enter Menu ID: ");
		if(!itemMenu.containsKey(id)) {
			System.out.println("Menu does not exist! ");
			return;
		}
		itemMenu.remove(id);
		System.out.println("Succesfully removed item! ");
	}
	
	static {
		seedInitialDataRecipe();
	}
	
	public static void displayItemMenu() {
		if(itemMenu.isEmpty()) {
			System.out.println("No menu yet! ");
			return;
		}
		
		itemMenu.values().stream()
			.sorted((a,b) -> a.getName().compareToIgnoreCase(b.getName()))
			.forEach(menu -> System.out.println(menu));
	}
	
	private static void seedInitialDataRecipe() {
		Map<String, Double> chickenRiceRecipe = new HashMap<>();
		chickenRiceRecipe.put("101", 1.0);   
		chickenRiceRecipe.put("102", 1.0);  
		chickenRiceRecipe.put("104", 20.0);
		itemMenu.put("M101", new ItemMenu("101", "Chicken Rice", MenuCategory.MEALS,60,chickenRiceRecipe));
	}
	
	
	public static Map<String, ItemMenu> getItemList(){
		return itemMenu;
	}
}
