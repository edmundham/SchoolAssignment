package lab9;

import java.util.Scanner;

public class IntegerListTest {

	static IntegerList list = new IntegerList(10);
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		printMenu();
		int choice = scan.nextInt();
		
		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
		}
		
	}
	
	public static void dispatch(int choice) {
		int loc;
		switch(choice) {
		case 0:
			System.out.println("Bye! ");
			break;
		case 1:
			System.out.println("How big should the list be?");
			int size = scan.nextInt();
			list = new IntegerList(size);
			list.randomize();
			break;
		case 2:
			list.print();
			break;
		case 3:
			list.increaseSize();
			break;
		case 4:
			System.out.println("What number you want to add?");
			int num = scan.nextInt();
			list.addElement(num);
			break;
		case 5:
			System.out.println("What number you want to remove?");
			int num1 = scan.nextInt();
			list.removeFirst(num1);;
			break;
		case 6:
			System.out.println("What number you want to remove?");
			int num2 = scan.nextInt();
			list.removeAll(num2);
			break;
		default:
				System.out.println("Sorry, invalid choice");
		}
	}
	
	public static void printMenu() {
		System.out.println("\n Menu    ");
		System.out.println("   ========");
		System.out.println("0: Quit");
		System.out.println("1: Create a new list (** do this first!! **)");
		System.out.println("2: Print the list");
		System.out.println("3: Double the list size");
		System.out.println("4: Add an element");
		System.out.println("5: Remove an element that you enter only once");
		System.out.println("6: Remove all elements that you enter");
		System.out.print("\nEnter your choice: ");
	}
	
}
