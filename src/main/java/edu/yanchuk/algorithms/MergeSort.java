package edu.yanchuk.algorithms;

import static edu.yanchuk.algorithms.PrintArray.*;

public class MergeSort {
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {

        int[] arr = unsortedIntArray;

        printUnsortedArray();
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}

