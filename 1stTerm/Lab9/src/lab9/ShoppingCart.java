package lab9;

import java.text.NumberFormat;

public class ShoppingCart {

	private int itemCount;
	private double totalPrice;
	private int capacity;
	private Item[] cart;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public ShoppingCart() {
		capacity = 5;
		itemCount = 0;
		totalPrice = 0;
		cart = new Item[capacity];
	}
	
	public void addToCart(String itemName, double price, int quantity) {
		if (itemCount == cart.length) {
			increaseSize();
		}
		
		cart[itemCount] = new Item(itemName, price, quantity);
		itemCount++;
		
		totalPrice += price * quantity;
	}
	
	public String toString() {
		
		String contents = "\nShopping Cart\n";
		contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
		
		for (int i = 0; i < itemCount; i++) {
			contents += cart[i].toString() + "\n";
		}
		
		contents += "\nTotal Price: " + fmt.format(totalPrice);
		contents += "\n";
		
		return contents;
	}
	
	private void increaseSize() {
		Item[] temp = new Item[cart.length + 3];
		
		for (int i = 0; i < cart.length; i++) {
			temp[i] = cart[i];
		}
		
		cart = temp;
	}
	
	public void printTotal() {
		System.out.println("Please pay $" + fmt.format(totalPrice));
	}
	
}
