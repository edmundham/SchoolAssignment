package lab11;

public class SelectionSort {

    public static void main(String[] args) {
        
        int[] array = {3, 2, 5, 2, 1, 7, 11, 18, 5, 6};
        
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        for (int num : array) {
            System.out.print(num + " ");
        }
        
    }
    
}
