package lab11;

import java.util.Arrays;

public class SortedIntList extends IntList {
    
    public SortedIntList(int size) {
        super(size);
    }
    
//    public void add(int value) {
//        if (numElements == list.length) {
//            System.out.println("Can't add, list is full");
//        } else {
//            for (int i = 0; i < list.length; i++) {
//                if (value < list[i] || list[i] == 0) {
//                    if (list[i] != 0) {
//                        list[i + 1] = list[i];
//                    }
//                    list[i] = value;
//                    numElements++;
//                    break;
//                }
//            }        
//        }
//    }
    
    public void add(int value) {
        if (numElements == list.length) {
            System.out.println("Can't add, list is full");
        } else {
            list[numElements] = value;
            numElements++;
        }
        for (int i = 0; i < list.length; i++) {
            Arrays.sort(list, 0, numElements);
        }
    }

}
