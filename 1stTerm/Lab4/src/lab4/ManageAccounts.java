package lab4;

public class ManageAccounts {
    public static void main(String[] args) {
        
        Account acct1, acct2;
        
        acct1 = new Account(1000, "Sally", 1111);
        acct2 = new Account(500, "Joe", 2222);
        
        acct2.deposit(100);
        
        acct2.getBalance();
        System.out.println(acct2);
        
        acct1.withdraw(50);
        
        acct1.getBalance();
        System.out.println(acct1);
        
        acct1.chargeFee();
        acct2.chargeFee();
        
        acct2.changeName("Joseph");
        
        acct1.getBalance();
        acct2.getBalance();
        
        System.out.println();
        System.out.println();
        System.out.println(acct1);
        System.out.println(acct2);
    }
}
