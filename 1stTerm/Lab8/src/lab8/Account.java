package lab8;

import java.util.Random;

public class Account {

    private double balance;
    private String name;
    private long acctNum;
    private double fee;
    private static int countTotalDeposit;
    private static int countTotalWithdrawl;
    private static int totalDeposit;
    private static int totalWithdrawl;
    
    private static int numAccounts;
    
    Random generator = new Random();
    
    public Account(double balance, String name, long acctNum) {
        this.balance = balance;
        this.name= name;
        this.acctNum= acctNum;
        numAccounts++;
    }
    
    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
        acctNum = generator.nextLong();
        numAccounts++;
    }
    
    public Account(String name) {
        balance = 0;
        this.name = name;
        acctNum = generator.nextLong();
        numAccounts++;
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }   else {
            System.out.println("Insufficient funds");
        }
    }
    
    public void withdraw(double amount, double fee) {
    	countTotalWithdrawl++;
    	totalWithdrawl += amount;
        if (balance >= amount + fee) {
            balance -= amount + fee;
        }   else {
            System.out.println("Insufficient funds");
        }
    }
    
    public void deposit(double amount) {
    	countTotalDeposit++;
    	totalDeposit += amount;
        balance += amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getName() {
    	return name;
    }
    
    public long getAcctNum() {
    	return acctNum;
    }
    
    public static int getNumAccounts() {
        return numAccounts;
    }

    public String toString() {
        return "Name: " + name
                + "\nAccount Number: " + acctNum
                + "\nBalance: " + balance
                + "\n==============================================";
    }
    
    public void close() {
    	balance = 0;
    	name = "CLOSED";
    	numAccounts--;
    }
    
    public static Account consolidate(Account acct1, Account acct2) {
    	if (acct1.getName() == acct2.getName() 
    			&& acct1.getAcctNum() != acct2.getAcctNum()) {
    		double sumBal = acct1.getBalance() + acct2.getBalance();
			Account newAccount = new Account(sumBal, acct1.getName());
			acct1.close();
			acct2.close();
			return newAccount;
    	}	else {
    		System.out.println("===================================");
    			System.out.println("Invalid consolidate.");
    			return null;
    		}
    }
    
    public static int getNumDeposits() {
    	return countTotalDeposit;
    }
    
    public static int getNumWithdrawls() {
    	return countTotalWithdrawl;
    }
    
    public static int getTotalDeposits() {
    	return totalDeposit;
    }
    
    public static int getTotalWithdrawls() {
    	return totalWithdrawl;
    }
    
    
    
}
