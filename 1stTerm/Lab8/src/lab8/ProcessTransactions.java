package lab8;

import java.util.Scanner;

public class ProcessTransactions {

	public static void main(String[] args) {
		
		Account acct1, acct2;
		String keepGoing = "y";
		String action;
		double amount;
		long acctNumber;
		
		Scanner scan = new Scanner(System.in);
		
		acct1 = new Account(1000, "Sue", 123);
		acct2 = new Account(1000, "Joe", 456);
		
		System.out.println("The following accounts are available: \n");
//		acct1.printSummary();
		
		System.out.println();
//		acct2.printSummary();
		
		while (keepGoing.equals("y") || keepGoing.equals("y")) {
			System.out.println("\nEnter the number of the account you would"
					+ " like to access: ");
			
			acctNumber = scan.nextLong();
			System.out.println("Would you like to make a deposit (D) or"
					+ " withdrawl (W)?");
			
			action = scan.next();
			System.out.println("Enter the amount: ");
			amount = scan.nextDouble();
			
//			if (amount > 0) {
//				if (acctNumber == acct1.getAcctNum()) {
//					if (action.equals("w") || action.equals("W")) {
//						acct1.withdraw(amount);
//					} else if (action.equals("D") || action.equals("d")) {
//						acct1.deposit(amount);
//					} else {
//						System.out.println("Sorry, invalid action.");
//					} else if (acctNumber == acct2.getAcctNum()) {
//						if (action.equalsIgnoreCase("w")) {
//							
//						}
//				}
//			}
//		}
		
		
		}
	}
}
	
	

