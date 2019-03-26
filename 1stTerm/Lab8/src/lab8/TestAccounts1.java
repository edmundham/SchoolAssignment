package lab8;

import java.util.Scanner;

public class TestAccounts1 {

	public static void main(String[] args) {
		Account testAcct;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many accounts would you like to crate?");
		int num = scan.nextInt();
		
		for (int i = 1; i <= num; i++) {
			testAcct = new Account(100, "Name" + i);
			System.out.println("\nCreated account " + testAcct);
			System.out.println("Now there are " + Account.getNumAccounts()
					+ " accounts");
		}
		
		System.out.println("========================================");
		
		Account acct1 = new Account(100, "Tom");
		Account acct2 = new Account(100, "Tom");
		Account acct3 = new Account(100, "Jerry");
		
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
		
		System.out.println(Account.consolidate(acct1, acct2));
		System.out.println(Account.consolidate(acct1, acct3));
		System.out.println(Account.consolidate(acct1, acct1));
	}
}
