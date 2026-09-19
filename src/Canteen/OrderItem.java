package Canteen;

public class OrderItem {
	private ItemMenu itemMenu;
	private int quantity;
	
	public OrderItem(ItemMenu itemMenu, int quantity) {
		this.setItemMenu(itemMenu);
		this.setQuantity(quantity);
	}

	public ItemMenu getItemMenu() {return itemMenu;}
	public void setItemMenu(ItemMenu itemMenu) {this.itemMenu = itemMenu;}
	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	public double getSubtotal() { return itemMenu.getPrice() * quantity; }

	
	  @Override
	    public String toString() {
	        return itemMenu.getName() + " x" + quantity + " = ₱" + String.format("%.2f", getSubtotal());
	    }
}
