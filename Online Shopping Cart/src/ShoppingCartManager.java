
import java.util.Scanner;

public class ShoppingCartManager {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		char input = '?';
		
		System.out.println("Enter Customer's Name:");
		String customerName = scnr.nextLine();
		System.out.println("Enter Today's Date:");
		String currentDate = scnr.nextLine();
		
		System.out.println("\nCustomer Name: " + customerName);
		System.out.println("Today's Date: " + currentDate + "\n");
		
		ShoppingCart shoppingCart = new ShoppingCart(customerName, currentDate);
		
		while(input != 'q') {
	         input = printMenu(shoppingCart, scnr);
		}
		scnr.close();
	}
	public static char printMenu(ShoppingCart shoppingCart, Scanner scnr) {
		String itemName = "";
		String itemDescription = "";
		int itemPrice = 0;
		int itemQuantity = 0;
		
		System.out.println("MENU");
		System.out.println("a - Add item to cart");
		System.out.println("d - Remove item from cart");
		System.out.println("c - Change item quantity");
		System.out.println("i - Output items' descriptions");
		System.out.println("o - Output shopping cart");
		System.out.println("q - Quit\n");
		
		char input = '?';
		
		while (input != 'a' && input != 'd' && input != 'c' && input != 'i' && input != 'o' && input != 'q') {

			System.out.println("Choose an option:");
			input = scnr.next().charAt(0);
			}
		
		
			switch (input) {
			
			case 'a':
				scnr.nextLine();
				System.out.println("ADD ITEM TO CART");
				
				System.out.println("Enter the item name:");
				itemName = scnr.nextLine();
				
				System.out.println("Enter the item description:");
				itemDescription = scnr.nextLine();
				
				System.out.println("Enter the item price:");
				itemPrice = scnr.nextInt();
				
				System.out.println("Enter the item quantity:");
				itemQuantity = scnr.nextInt();
				
				ItemToPurchase item = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
				shoppingCart.addItem(item);
				input = '?';
				break;
				
			case 'd':
				scnr.nextLine();
				System.out.println("REMOVE ITEM FROM CART");
				System.out.println("Enter name of item to remove:");
				
				itemName = scnr.nextLine();
				shoppingCart.removeItem(itemName);
				input = '?';
				break;
				
			case 'c':
				scnr.nextLine();
				System.out.println("CHANGE ITEM QUANTITY");
				System.out.println("Enter the item name:");
	            itemName = scnr.nextLine();
	         
	            System.out.println("Enter the new quantity:");
	            itemQuantity = scnr.nextInt();
	            
	            ItemToPurchase modItem = new ItemToPurchase();
	            modItem.setName(itemName);
	            modItem.setQuantity(itemQuantity);
				
				shoppingCart.modifyItem(modItem);
				input = '?';
				break;
				
			case 'i':
				scnr.nextLine();
	            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
				shoppingCart.printDescriptions();
				input = '?';
				break;
				
			case 'o':
				scnr.nextLine();
				System.out.println("OUTPUT SHOPPING CART");
				shoppingCart.printTotal();
				input = '?';
				break;
			}
	return input;
	}
}
