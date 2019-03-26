package lab11;

public class ListTest {

    public static void main(String[] args) {
        
        SortedIntList myList = new SortedIntList(10);
        myList.add(50);
        myList.add(150);
        myList.add(100);
        myList.add(200);
        myList.add(75);
        myList.add(175);
        myList.add(25);
        
        System.out.println(myList);
        
    }
    
}
