package lab11;

public class InsertionSort {

    public static void main(String[] args) {
        
        int[] array = {3, 2, 5, 2, 1, 7, 11, 18, 5, 6};
        
        for (int num : array) {
            System.out.println(num);
        }
        
        System.out.println();
        
        /**
         * 3 2 5 2 1 7 11 18 5 6
         * 2 3 5 2 1 7 11 18 5 6
         * 2 3 5 2 1 7 11 18 5 6
         * 2 2 3 5 1 7 11 18 5 6
         * 1 2 2 3 5 7 11 18 5 6
         * 1 2 2 3 5 7 11 18 5 6
         * 1 2 2 3 5 7 11 18 5 6
         * 1 2 2 3 5 5 7 11 18 6
         * 1 2 2 3 5 5 6 7 11 18
         */
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
            
        }
        
        for (int num : array) {
            System.out.println(num);
        }
        
    }
    
}
