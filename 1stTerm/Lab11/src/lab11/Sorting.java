package lab11;

public class Sorting {

    public static void selectionSort(Comparable[] list) {
        
        int min;
        Comparable temp;
        
        for (int i = 0; i <list.length - 1; i++) {
            min = i;
            
            for (int scan = i + 1; i < list.length; i++) {
                if (list[scan].compareTo(list[min]) < 0) {
                    min = scan;
                }
                
                temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }
        
        public static void insertionSort(Comparable[] list) {
            
            for (int i = 1; i < list.length; i++) {
                Comparable key = list[i];
                int position = i;
                
                while (position > 0 && key.compareTo(list[position - 1]) < 0) {
                    list[position] = list[position - 1];
                    position--;
                }
                
                list[position] = key;
            }
        }
    
}
