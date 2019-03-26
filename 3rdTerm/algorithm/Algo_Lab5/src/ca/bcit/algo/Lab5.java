package ca.bcit.algo;

import java.util.Arrays;

public class Lab5 {

    public static int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static void main(String[] args) {
        System.out.println("Index of the largest number is: " + question1(array, 0, array.length - 1));

        System.out.println("==================================");

        System.out.print("Original array is: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        int[] sortedArray = mergeSort(array);
        System.out.print("Sorted array using merge sort is: ");
        for (int element : sortedArray) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("==================================");
        System.out.println("Is there an element where value and index match: "
        + question3(sortedArray, 0, sortedArray.length - 1));


    }

    private static int question1(int[] array, int start, int end) {
        if (end == start) {
            return start;
        }
        if (end - start == 1) {
            return array[start] > array[end] ? start : end;
        }

        int mid = (start + end) / 2;
        int firstHalf = question1(array, start, mid);
        int secondHalf = question1(array, mid, end);

        return array[firstHalf] > array[secondHalf] ? firstHalf : secondHalf;
    }

    private static int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int[] firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            return merge(firstHalf, secondHalf, array);
        }
        return null;
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] <= secondHalf[j]) {
                array[k] = firstHalf[i];
                i++;
            } else {
                array[k] = secondHalf[j];
                j++;
            }
            k++;
        }
        if (i == firstHalf.length) {
            for (; k < array.length; k++, j++) {
                array[k] = secondHalf[j];
            }
        } else {
            for (; k < array.length; k++, i++) {
                array[k] = firstHalf[i];
            }
        }
        return array;
    }

    private static boolean question3(int[] array, int start, int end) {
        if (end < start) {
            return false;
        }
        int mid = ((start + end) / 2) + start;
        if (array[mid] < mid) {
            return question3(array, mid + 1, end);
        } else if (mid < array[mid]) {
            return question3(array, start, mid - 1);
        } else {
            return mid == array[mid];
        }
    }



}
