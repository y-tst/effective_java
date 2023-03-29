package edu.yanchuk.algorithms;

import static edu.yanchuk.algorithms.PrintArray.*;

public class RecursiveBinarySearch {

    public static void main(String[] args) {

        printSortedArray();
        System.out.println("\nThe index of searched number in array: " + recursiveBinarySearch(sortedIntArray, 58));
    }

    public static int recursiveBinarySearch(int[] array, int target) {
        return recursiveBinarySearch(array, target, 0, array.length - 1);
    }

    private static int recursiveBinarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // element not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return recursiveBinarySearch(array, target, mid + 1, right);
        } else {
            return recursiveBinarySearch(array, target, left, mid - 1);
        }
    }

}
