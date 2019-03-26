package lab9;

import java.text.NumberFormat;

public class Item {

	private String name;
	private double price;
	private int quantity;
	
	public Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return (name + "\t\t" + fmt.format(price) + "\t\t" + quantity + "\t\t"
				+ fmt.format(price * quantity));
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
