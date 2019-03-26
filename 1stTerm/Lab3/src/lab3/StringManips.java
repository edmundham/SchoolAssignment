package lab3;

// **********************************************************************
//  StringManips.java
//
//  Test several methods for manipulating String objects
// **********************************************************************

import java.util.Scanner;

public class StringManips {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String phrase = new String ("This is a String test.");
        int phraseLength;   // number of characters in the phrase String
        int middleIndex;    // index of the middle character in the string
        String firstHalf;   // first half of the phrase String
        String secondHalf;  // second half of the phrase String
        String switchedPhrase; // a new phrase with original halves switched
        String middle3;     // question1
        String city;
        String state;
        
        // compute the length and middle index of the phrase
        phraseLength = phrase.length();
        middleIndex = phraseLength / 2;
        
        // get the substring for reach half of the phrase
        firstHalf = phrase.substring(0, middleIndex);
        secondHalf = phrase.substring(middleIndex, phraseLength);
        middle3 = phrase.substring(middleIndex - 1, middleIndex + 2);
        // concatenate the firstHalf at the end of the secondHalf
        switchedPhrase = new String(phrase.replace(' ', '*'));
        
        // print information about the phrase
        System.out.println();
        System.out.println("Original phrase: " + phrase);
        System.out.println("Length of the phrase: " + phraseLength +
                           " characters");
        System.out.println("Index of the middle: " + middleIndex);
        System.out.println("Character at the middle index: " +
                           phrase.charAt(middleIndex));
        System.out.println("Switched phrase: " + switchedPhrase);
        System.out.println("This is the question number 1: " + middle3);
        
        System.out.println();
        System.out.print("Enter the city that you were born: ");
        city = scan.nextLine();
        System.out.print("Enter the state that you were born: ");
        state = scan.nextLine();
        
        city = city.toLowerCase();
        state = state.toUpperCase();
        
        String cityState = new String(state.concat(city.concat(state)));
        
        System.out.println(cityState);
        
    }
}
