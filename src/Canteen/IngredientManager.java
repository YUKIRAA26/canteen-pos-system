package Canteen;
import java.util.*;
import java.util.stream.Stream;

public class IngredientManager {
	private final static  Scanner scanner = new Scanner(System.in);
	private final static Map<String, Ingredients> ingredients = new HashMap<>();
	
	public static void addIngredient() {
		String id;
		while(true) {
			id = Exceptions.StringException("Enter Ingredient ID: ");
			if(ingredients.containsKey(id)) {
				System.out.println("ID Already Exist! ");
				continue;
			}
			break;
		}
		String name = Exceptions.StringException("Enter Ingredient Name: ");
		String unit = Exceptions.StringException("Enter Ingredient Unit: ");
		double currentStock = Exceptions.DoubleException("Enter Stock: ");
		double reorderLevel = Exceptions.DoubleException("Enter Re-Order Level: ");
		
		

		ingredients.put(id, new Ingredients(id,name,unit,currentStock,reorderLevel));
		System.out.println("Succesfully Added Ingredient! ");
	}
	
	static {seedInitialData();}
	
	public static void removeIng(String id) {
	    if (ingredients.containsKey(id)) {
	        ingredients.remove(id);
	        System.out.println("Ingredient removed!");
	    } else {
	        System.out.println("No ingredient found with that ID.");
	    }
	}
	
	public static void viewAllIngredients() {
		if(ingredients.isEmpty()) {
			System.out.println("No Ingredients Found!  ");
			return;
		}
		
		ingredients.values().stream()
			.sorted((a,b) -> a.getName().compareToIgnoreCase(b.getName()))
			.forEach(ing ->  System.out.println(
		            ing.getId() + " | " + ing.getName() + " | "
		            + ing.getCurrentStock() + " " + ing.getUnit()
		            + " (reorder at " + ing.getReorderLevel() + ")"
		      ));
		
	}

	
	private static void seedInitialData() {
		ingredients.put("101", new Ingredients("101","Rice","Cups",50,10));
		ingredients.put("102", new Ingredients("102","Chicken","pcs",20,5));
		ingredients.put("103", new Ingredients("103","Egg","pcs",30,8));
		ingredients.put("104", new Ingredients("104","Soy Sauce","ml",1000,200));
		ingredients.put("105", new Ingredients("105","Soda Can","pcs",30,10));
	}
	
	public static void displayLowStock() {
		ArrayList<Ingredients> lowStock = new ArrayList<>(ingredients.values());
		
		lowStock.stream()
			.sorted((a,b) -> Double.compare(b.getCurrentStock(), a.getCurrentStock()))
			.filter(n -> n.getCurrentStock() <= n.getReorderLevel())
			.forEach(n -> System.out.println("Id: " + n.getId() + " "
					+ "Name: " + n.getName() + " " + "Stock: " + n.getCurrentStock()));
		
	}
	
	public static Map<String, Ingredients> getIngredients() {
		return ingredients;
	}
	
	
}
