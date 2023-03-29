package edu.yanchuk.algorithms;

public class PrintArray {

    public static int[] unsortedIntArray = {12, 4, 10, 0, 45, 90, 150, 12, 15, 1, 3, 101, 7, 2};
    public static int[] sortedIntArray = {1, 2, 3, 5, 10, 12, 22, 58, 64, 87};

    public static void printSortedArray() {
        System.out.println("Sorted array:");

        for (int i = 0; i <= sortedIntArray.length - 1; i++) {
            System.out.print(sortedIntArray[i] + " ");
        }
    }

    public static void printUnsortedArray() {
        System.out.println("Unsorted array:");

        for (int i = 0; i <= unsortedIntArray.length - 1; i++) {
            System.out.print(unsortedIntArray[i] + " ");
        }
    }
    public static void printSortedArray(int[] arrayToPrint) {

        System.out.println("Sorted array:");

        for (int k = 0; k <= arrayToPrint.length - 1; k++) {
            System.out.print(unsortedIntArray[k] + " ");
        }
    }
}
