package Lab51;

    import java.util.Scanner;

public class PowerOf2 {

    public static void main(String[] args) {
        
        int numPowersOf2;       //How many powers of 2 to compute
        int nextPowerOf2 = 1;   //Current power of 2
        int exponent;           //also serves as a counter for the loop Scanner
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many powers of 2 would you like printed: ");
        numPowersOf2 = scan.nextInt();
        
        //Print a message saying how many powers of 2 will be printed
        System.out.println("Here are the first " + numPowersOf2
                + " powers of 2:");
        
        //Initialize exponent -- the first thing printed is 2 to the what?
        exponent = 0;
        
        while (numPowersOf2 > exponent) {
            //Print out current power of 2
            System.out.println((int) (Math.pow(2, exponent)));
            
            //Find next power of 2 -- how do you get this from the last one?
            
            
            //increment exponent
            exponent++;
        }
        
        
    }
}
