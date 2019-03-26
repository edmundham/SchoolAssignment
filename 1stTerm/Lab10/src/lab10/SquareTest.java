package lab10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SquareTest {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("magicData.txt"));
        
        int count = 1;
        int size = scan.nextInt();
        
        //Expecting -1 at bottom of input file
        while (size != -1) {
            Square square = new Square(size);
            
            square.readSquare(scan);
            
            System.out.println("\n******** Square " + count + "********");
            square.printSquare();
            
            System.out.println(square.sumRow(1));
            System.out.println(square.sumCol(1));
            System.out.println(square.sumMainDiag());
            System.out.println(square.sumOtherDiag());
            System.out.println(square.magic());
            
            size = scan.nextInt();
            count++;
        }
        
    }
    
    
}
