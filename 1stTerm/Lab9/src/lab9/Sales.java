package lab9;

import java.util.Scanner;

public class Sales {

	public static void main(String[] args) {
		
		int salesPeople = 0;
		int sum;
		int max = 0;
		int maxP = 0;
		int min = 999999999;
		int minP = 0;
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the number of salesperson: ");
		salesPeople = scan.nextInt();
		
		int[] sales = new int[salesPeople];
		
		for (int i = 1; i < sales.length; i++) {
			System.out.println("Enter sales for salesperson " + i + ": ");
			sales[i] = scan.nextInt();
			if (sales[i] > max) {
				max = sales[i];
				maxP = i;
			}
			if (sales[i] < min) {
				min = sales[i];
				minP = i;
			}
		}
		
		System.out.println("\nSalesperson Sales");
		System.out.println(" ----------------- ");
		
		sum = 0;
		for (int i = 1; i < sales.length; i++) {
			System.out.println("    " + i + "        " + sales[i]);
			sum += sales[i];
		}
		
		System.out.println("\nTotal sales: " + sum);
		int average = sum / 5;
		System.out.println("Average: " + average);
		System.out.println("Salesperson " + maxP + " had the highest"
				+ " sale with $" + max);
		System.out.println("Salesperson " + minP + " had the lowest"
				+ " sale with $" + min);
		System.out.println("Enter a value: ");
		int value = scan.nextInt();
		for (int i = 1; i < sales.length; i++) {
			if (value > sales[i]) {
				System.out.println("Salesperson " + i + " exceeds the value"
						+ " you entered: $" + sales[i]);
			}
		}
	}
	
}
