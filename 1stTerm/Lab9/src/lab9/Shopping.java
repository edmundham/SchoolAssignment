package lab9;

import java.util.Scanner;
import java.text.NumberFormat;

public class Shopping {

	public static void main(String[] args) {
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		
		String itemName;
		double itemPrice;
		int quantity;
		String more;
		ShoppingCart cart = new ShoppingCart();
		
		do {
            System.out.print("Enter the name of the item: ");
            itemName = scan.next();
            
            System.out.print("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            
            System.out.print("Enter the Quantity: ");
            quantity = scan.nextInt();
            
            Item item = new Item(itemName, itemPrice, quantity);
            
            cart.addToCart(item.getName(), item.getPrice(),
            		item.getQuantity());
            
            System.out.println(cart);
            
            System.out.println("Do you wan to shop more? (y/n)");
            more = scan.next();
            
		} while (more.equalsIgnoreCase("y"));
		
		cart.printTotal();
		
	}
	
}
