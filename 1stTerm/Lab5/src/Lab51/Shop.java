package Lab51;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class Shop {

    public static void main(String[] args) {
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        ArrayList<Item> cart = new ArrayList<Item>();
        
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double totalPrice = 0;
        
        Scanner scan = new Scanner(System.in);
        
        char keepShopping = 'y';
        
        do {
            System.out.print("Enter the name of the item: ");
            itemName = scan.next();
            
            System.out.print("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            
            System.out.print("Enter the Quantity: ");
            quantity = scan.nextInt();
            
            // create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            // print the content of the cart object using println
            cart.add(item);
            
            totalPrice += item.getPrice() * item.getQuantity(); 
            
            for(Item list: cart) {
                System.out.println(list);
            }
            
            //cart.forEach(System.out::println);
            
            //System.out.println(cart);
            
            System.out.println("Total price is: " + fmt.format(totalPrice));
            System.out.print("Continue shopping (y/n)? ");
            keepShopping = scan.next().charAt(0);
            System.out.println("__________________________________");
            
        }   while(keepShopping == 'y' || keepShopping =='Y');
        
    }
}
