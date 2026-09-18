package Canteen;

public class Ingredients {
	private String id;
	private String name;
	private String unit;
	private double currentStock;
	private double reorderLevel;
	
	public Ingredients(String id, String name, String unit
	, double currentStock, double reorderLevel) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.currentStock = currentStock;
		this.reorderLevel = reorderLevel;
	}
	
	public String getId() {return id;}
	public void setId(String Id) {this.id = Id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getUnit() {return unit;}
	public void setUnit(String unit) {this.unit = unit;}
	public double getCurrentStock() {return currentStock;}
	public void setCurrentStock(double currentStock) {this.currentStock = currentStock;}
	public double getReorderLevel() {return reorderLevel;}
	public void setReorderLevel(double reorderLevel) {this.reorderLevel = reorderLevel;}
	
	
	
}
