package lab9;

import java.util.Scanner;

public class ReverseARray {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int value;
		
		System.out.print("Enter the value: ");
		value = scan.nextInt();
		
		int[] array = new int[value];
		for (int i = 0; i < value; i++) {
			array[i] = i;
		}
		
		for (int print : array){
			System.out.println(print);
		}
		
		System.out.println("=====================================");
		
		for (int i = 1; i <= value; i++) {
			array[array.length - i] = i - 1;
		}
		
		for (int print : array){
			System.out.println(print);
		}
		
		
	}
	
}
