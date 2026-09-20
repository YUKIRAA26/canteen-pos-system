package Canteen;
import java.util.*;	

public class IngredientManager {
	private final static Map<String, Ingredients> ingredients = new HashMap<>();
	private final static Set<String> ingName = new HashSet<>();
	
	private static void addIngredient() {
		String id = Exceptions.idChecker(ingredients, "Enter ID: ");
		String name = Exceptions.nameChecker(ingName, "Enter Ingredient Name: ");
		String unit = Exceptions.StringException("Enter Ingredient Unit: ");
		double currentStock = Exceptions.DoubleException("Enter Stock: ");
		double reorderLevel = Exceptions.DoubleException("Enter Re-Order Level: ");
		
		
		ingName.add(name.toLowerCase());
		ingredients.put(id, new Ingredients(id,name,unit,currentStock,reorderLevel));
		System.out.println("Succesfully Added Ingredient! ");
	}
	
	static {seedInitialData();}
	
	private static void removeIng() {
		 if (ingredients.isEmpty()) {
		        System.out.println("No Ingredients Found! ");
		        return;
		    }
		
	   String id = Exceptions.existingId(ingredients, "Enter Id: ");
	   
	   Ingredients removed = ingredients.remove(id);
	   ingName.remove(removed.getName().toLowerCase());
	   System.out.println("Succesfully removed ingredient! ");
	}
	
	public static void viewAllIngredients() {
		if(ingredients.isEmpty()) {
			System.out.println("No Ingredients Found!  ");
			return;
		}
		
		System.out.println("======================= Display Stock =======================");
		ingredients.values().stream()
			.sorted((a,b) -> a.getName().compareToIgnoreCase(b.getName()))
			.forEach(ing ->  System.out.println(
		            ing.getId() + " | " + ing.getName() + " | "
		            + ing.getCurrentStock() + " " + ing.getUnit()
		            + " (reorder at " + ing.getReorderLevel() + ")"
		      ));
		
		System.out.println("===============================================================================");
		
	}

	
	private static void seedInitialData() {
		ingredients.put("101", new Ingredients("101","rice","Cups",50,10));
		ingName.add("rice");
		ingredients.put("102", new Ingredients("102","chicken","pcs",20,5));
		ingName.add("chicken");
		ingredients.put("103", new Ingredients("103","egg","pcs",30,8));
		ingName.add("egg");
		ingredients.put("104", new Ingredients("104","soy sauce","ml",1000,200));
		ingName.add("soy sauce");
		ingredients.put("105", new Ingredients("105","soda can","pcs",30,10));
		ingName.add("soda can");
	}
	
	public static void displayLowStock() {
		List<Ingredients> lowStock = ingredients.values().stream()
				.filter(n -> n.getCurrentStock() <= n.getReorderLevel())
				.sorted((a,b) -> Double.compare(b.getCurrentStock(), a.getCurrentStock()))
				.toList();
		
		if(lowStock.isEmpty()) {	
			System.out.println("\nNo low on stock yet!\n");
			return;
		}
		
		lowStock.stream()
			.forEach(n -> System.out.println("Id: " + n.getId() + " "
					+ "Name: " + n.getName() + " " + "Stock: " + n.getCurrentStock()));
		
	}
	
	private static void addStock() {
		
		  if (ingredients.isEmpty()) {
		        System.out.println("No Ingredients Found! ");
		        return;
		    }
		  viewAllIngredients();
		  String id = Exceptions.existingId(ingredients, "Enter ID to add stock: ");
		  double amount;
		while(true) {
			
			amount = Exceptions.DoubleException("Enter Amount to add: ");
			if(amount == 0) {
				System.out.println("Amount must be more than 0! ");
	            continue;
			}
			
			break;
		}
		
		Ingredients ing = ingredients.get(id);
		ing.addStock(amount);
		System.out.println("Stock updated! " + ing.getName() + " now has "
	            + ing.getCurrentStock() + " " + ing.getUnit());
	}
	
	public static void displayIngMenu() {
		System.out.println("=================");
		System.out.println("   INGREDIENTS   ");
		System.out.println("=================");
		
		while(true) {
			System.out.println("1. Add Ingredients");
			System.out.println("2. View Ingredients");
			System.out.println("3. Add Stock");
			System.out.println("4. Remove Ingredients");
			System.out.println("5. Exit");
			
			String choice = Exceptions.StringException("Enter Choice: ");
			
			if(choice.equalsIgnoreCase("5")) {
				return;
			}
			
			switch(choice) {
				case "1" -> addIngredient();
				case "2" -> viewAllIngredients();
				case "3" -> addStock();
				case "4" -> removeIng();
				default -> System.out.println("Invalid Input! ");
			}
		}
	}
	
	
	
	
	public static Map<String, Ingredients> getIngredients() {
		return ingredients;
	}
	
	
}
