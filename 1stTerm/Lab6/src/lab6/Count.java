package lab6;

    import java.util.Scanner;

public class Count {

    public static void main(String[] args) {
        
        String phrase = "";            // a string of characters;
        int length;               // the length of the phrase
        char ch;                  // an individual character in the string
        
        Scanner scan = new Scanner(System.in);
        
        //print a program header
        System.out.println();
        System.out.println("Character Counter");
        System.out.println();
        
        do {
            // refresh all counts every time
            int countBlank = 0;       // the number of blanks (spaces) in the phrase
            int countA = 0;
            int counta = 0;
            int counte = 0;
            int countE = 0;
            int counts = 0;
            int countS = 0;
            int countt = 0;
            int countT = 0;
            
            // read in a string and find its length
            System.out.print("Enter a sentence or phrase (quit to terminate): ");
            phrase = scan.nextLine();
            length = phrase.length();
        
        // a for loop to go through the string character by character
            if (!phrase.equalsIgnoreCase("quit")) {
                
        for (int count = 0; count < length; count++) {
            ch = phrase.charAt(count);
            
            switch (ch) {
            case 'a':
                counta++;
                break;
            case 'A':
                countA++;
                break;
            case 'e':
                counte++;
                break;
            case 'E':
                countE++;
                break;
            case 's':
                counts++;
                break;
            case 'S':
                countS++;
                break;
            case 't':
                countt++;
                break;
            case 'T':
                countT++;
                break;
            case ' ':
                countBlank++;
                break;
            }
            
        }
        // Print the results
        System.out.println();
        System.out.println("Number of blank spaces: " +  countBlank);
        System.out.println("Number of a character: " +  counta);
        System.out.println("Number of A character: " +  countA);
        System.out.println("Number of e character: " +  counte);
        System.out.println("Number of E character: " +  countE);
        System.out.println("Number of s character: " +  counts);
        System.out.println("Number of S character: " +  countS);
        System.out.println("Number of t character: " +  countt);
        System.out.println("Number of T character: " +  countT);
        System.out.println();
        
            }
        
        
        } while (!phrase.equalsIgnoreCase("quit"));
        
        
        
    }
}
