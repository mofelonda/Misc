
public class ItemToPurchase {
	private String name;
	private String description;
	private int price;
	private int quantity;
	
	public ItemToPurchase() {
		name = "none";
		description = "none";
		price = '0';
		quantity = '0';
	}
	
	public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
		name        = itemName;
		description = itemDescription;
		price       = itemPrice;
		quantity    = itemQuantity;
	}
	
	public void setName(String itemName) {
		name = itemName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String itemDescription) {
		description = itemDescription;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPrice(int itemPrice) {
		price = itemPrice;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setQuantity(int itemQuantity) {
		quantity = itemQuantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void printItemCost() {
		int subtotal = quantity * price;
		System.out.println(name + " " + quantity + " @ $" + price + " = $" + subtotal);
	}
	
	public void printItemDescription() {
		System.out.println(name + ": " + description);
	}
}