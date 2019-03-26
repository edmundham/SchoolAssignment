package q3;

/**
 * <p>This is where you put your description about what this class does. You
 * don't have to write an essay but you should describe exactly what it does.
 * Describing it will help you to understand the programming problem better.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */

public class Book {
    
    /**
     * <p>It instantiate the title of the book.</p>
     */
    private String title;
    
    /**
     * <p>It instantiate the author of the book.</p>
     */
    private String author;
    
    /**
     * <p>It instantiate the publisher of the book.</p>
     */
    private String publisher;
    
    /**
     * <p>It instantiate the copyright date of the book.</p>
     */
    private String copyrightDate;
    
    /**
     * <p>It is a constructor that contains title, author, publisher,
     * and copyright date of the certain book.</p>
     * 
     * @param name is the title of the book.
     * @param person is the author of the book.
     * @param company is the publisher of the book.
     * @param date is the copyright date of the book.
     */
    public Book(String name, String person, String company, String date) {
        title = name;
        author = person;
        publisher = company;
        copyrightDate = date;    
    }
    
    /**
     * <p>It is a no-argument constructor that has no data inside.</p>
     */
    public Book() {
    }
    
    /**
     * <p>This method is a setter method which set title as
     * name parameter.</p>
     * 
     * @param name is the title of the book.
     */
    public void setTitle(String name) {
        title = name;
    }
    
    /**
     * <p>This method is a getter method which return
     * title of the book.</p>
     * 
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * <p>This method is a setter method which set author as
     * person parameter.</p>
     * 
     * @param person is the author of the book.
     */
    public void setAuthor(String person) {
        author = person;
    }
    
    /**
     * <p>This method is a getter method which return
     * author of the book.</p>
     * 
     * @return author of the book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * <p>This method is a setter method which set publisher as
     * company parameter.</p>
     * 
     * @param company is the publisher of the book.
     */
    public void setPublisher(String company) {
        publisher = company;
    }
    
    /**
     * <p>This method is a getter method which return
     * publisher of the book.</p>
     * 
     * @return publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * <p>This method is a setter method which set copyrightDate as
     * date parameter.</p>
     * 
     * @param date is the copyrightDate of the book.
     */
    public void setCopyrightDate(String date) {
        copyrightDate = date;
    }
    
    /**
     * <p>This method is a getter method which return
     * publisher of the book.</p>
     * 
     * @return copyrightDate of the book
     */
    public String getCopyrightDate() {
        return copyrightDate;
    }
    
    /**
     * <p>This method will return well-organized description with
     * title, author, publisher, and copyright date of the certain book.</p>
     * 
     * @return well-organized description of the certain book
     */
    public String toString() {
        return "Title of the book: \t\t" + title 
                + "\nAuthor of the book: \t\t" + author
                + "\nPublisher of the book: \t\t" + publisher
                + "\nCopyright date of the book: \t" + copyrightDate;
    }
}
