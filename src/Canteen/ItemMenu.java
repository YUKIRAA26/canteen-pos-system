package Canteen;

import java.util.Map;

public class ItemMenu {
	private String id;
	private String name;
	private MenuCategory category;
	private double price;
	private Map<String, Double> recipe;
	
	
	public ItemMenu(String id, String name, MenuCategory category,double price,Map<String,Double> recipe) {
		this.setId(id);
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
		this.setRecipe(recipe);
	}


	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public MenuCategory getCategory() {return category;}
	public void setCategory(MenuCategory category) {	this.category = category;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public Map<String, Double> getRecipe() {return recipe;}
	public void setRecipe(Map<String, Double> recipe) {this.recipe = recipe;}
	
	//TO STUDY!
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		    sb.append("┌─────────────────────────────\n");
		    sb.append("│ ID       : ").append(id).append("\n");
		    sb.append("│ Name     : ").append(name).append("\n");
		    sb.append("│ Category : ").append(category).append("\n");
		    sb.append("│ Price    : ₱").append(String.format("%.2f", price)).append("\n");
		    sb.append("│ Recipe   :\n");

		    if (recipe == null || recipe.isEmpty()) {
		        sb.append("│   (no ingredients)\n");
		    } else {
		        for (Map.Entry<String, Double> entry : recipe.entrySet()) {
		            sb.append("│   - ").append(entry.getKey())
		              .append(" x").append(entry.getValue()).append("\n");
		        }
		    }

		    sb.append("└─────────────────────────────");
		    return sb.toString();
	}
	
	
}
