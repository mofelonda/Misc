
import java.util.ArrayList;
public class ShoppingCart {
	private String customerName;
	private String currentDate;
	private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
	
	public ShoppingCart() {
		customerName = "none";
		currentDate  = "January 1, 2016";
	}
	
	public ShoppingCart(String custyName, String curryDate) {
		customerName = custyName;
		currentDate  = curryDate;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getDate() {
		return currentDate;
	}
	
	public void addItem(ItemToPurchase item) {
		cartItems.add(item);
	}
	
	public void removeItem(String itemName) {
		boolean found = false;
		
		while (!cartItems.isEmpty() && !found) {
			
			for (int i = 0; i < cartItems.size(); i++) {
				
				if (cartItems.get(i).getName().equals(itemName)) {
					cartItems.remove(i);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Item not found in cart. Nothing removed.");
				break;
			}
		}
	}
	public void modifyItem(ItemToPurchase item) {
		boolean found = false;
		
		while (!cartItems.isEmpty() && !found) {
			
			for (int i = 0; i < cartItems.size(); i++) {
				
				if (cartItems.get(i).getName().equals(item.getName())) {
					found = true;
					if (item.getQuantity() != 0) {
						cartItems.get(i).setQuantity(item.getQuantity());
						break;
					}
				}
			}
			break;
		}
		if (!found) {
			System.out.println("Item not found in cart. Nothing modified.");
		}
	}
	public int getNumItemsInCart() {
		int totalQuantity = 0;
		
		for (int i = 0; i < cartItems.size(); ++ i) {
			totalQuantity += cartItems.get(i).getQuantity();
		}
		return totalQuantity;
	}
	
	public int getCostOfCart() {
		int totalCost = 0;
		
		for (int i = 0; i < cartItems.size(); i++) {
			totalCost += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
		}
		return totalCost;
	}
	
	public void printTotal() {
		int totalCost = 0;
		
		System.out.println(customerName + "'s Shopping Cart - " + currentDate);
		System.out.println("Number of Items: " + getNumItemsInCart());
		System.out.println("");
		
		if (cartItems.size() > 0) {
			
			for (int i = 0; i < cartItems.size(); ++i) {
				cartItems.get(i).printItemCost();
			}
		}
		else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		
		totalCost = getCostOfCart();
		System.out.println("");
		System.out.println("Total: $" + totalCost);
	}
	public void printDescriptions() {
		System.out.println(customerName + "'s Shopping Cart - " + currentDate);
		System.out.println("");
		System.out.println("Item Descriptions");
		
		if (cartItems.size() > 0) {
			
			for (int i = 0; i < cartItems.size(); ++i) {
				cartItems.get(i).printItemDescription();
			}
		}
		else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
	}
}