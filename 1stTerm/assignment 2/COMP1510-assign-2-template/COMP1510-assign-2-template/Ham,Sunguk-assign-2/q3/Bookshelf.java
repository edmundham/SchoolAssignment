package q3;

/**
 * <p>This program will invoke Book.java class to create several books
 * with title, author, publisher, and copyright date of the books, and
 * finally print well-organized description of these books.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */
public class Bookshelf {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        
        // Create an object
        Book hungerGame = new Book();
        // Create an object
        Book harryPotter = new Book("Harry Potter", "J. K. Rolling",
                "Bloomsbury", "July 30th, 1997");
        // Create an object
        Book theOldMan = new Book("The Old Man and the Sea", "Ernest Hemingway",
                "Charles Scribner\'s Sons", "September 1st, 1952");
        
        // Set and get the title of the hungerGame object
        hungerGame.setTitle("Hunger Game");
        hungerGame.getTitle();
        
        // Set and get the author of the hungerGame object
        hungerGame.setAuthor("Suzanne Collins");
        hungerGame.getAuthor();
        
        // Set and get the publisher of the hungerGame object
        hungerGame.setPublisher("Scholastic Corporation");
        hungerGame.getPublisher();
        
        // Set and get the copyright date of the hungerGame object
        hungerGame.setCopyrightDate("October 1st, 2008");
        hungerGame.getCopyrightDate();
        
        // Print well-organized description of harryPotter object
        System.out.println(harryPotter);
        
        System.out.println("------------------------------------------------");
        
        // Print well-organized description of hungerGame object
        System.out.println(hungerGame);

        System.out.println("------------------------------------------------");
        
        // Print well-organized description of theOldMan object
        System.out.println(theOldMan);
    }

};
