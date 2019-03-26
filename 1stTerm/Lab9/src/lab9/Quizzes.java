package lab9;

import java.util.Scanner;

public class Quizzes {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String another;
		
		do {
		int count = 0;
		
		System.out.println("Enter how many questions are in the quz:");
		int questions = scan.nextInt();
		
		int[] quiz = new int[questions];
		
		System.out.println("Enter the key or answer with a space.");
		for (int i = 0; i < questions; i++) {
			quiz[i] = scan.nextInt();
		}
		
		System.out.println("Enter the answers for the quiz to be graded.");
		for (int i = 0; i < questions; i++) {
			int answer = scan.nextInt();
			if (answer == quiz[i]) {
				count++;
			}
		}
		
		System.out.println(count + " / " + questions);
		System.out.println("Grade another quiz? (y/n).");
		another = scan.next();
		
		} while (another.equalsIgnoreCase("y"));
		
	}
	
}
