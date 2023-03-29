package edu.yanchuk.algorithms;

import edu.yanchuk.algorithms.PrintArray;

import static edu.yanchuk.algorithms.PrintArray.*;

public class IterativeBinarySearch {

    public static void main(String[] args) {

        printSortedArray();
        System.out.println("\nThe index of searched number in array: " + binarySearch(sortedIntArray, 58));
    }

    public static int binarySearch(int[] arrayForSearch, int target) {
        int low = 0;
        int high = arrayForSearch.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (target < arrayForSearch[middle])
                high = middle - 1;
            else if (target > arrayForSearch[middle])
                low = middle + 1;
            else return middle;
        }
        return -1;
    }
}
