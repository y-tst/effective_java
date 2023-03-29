package edu.yanchuk.benchmark;

import edu.yanchuk.algorithms.IterativeBinarySearch;
import edu.yanchuk.algorithms.MergeSort;
import edu.yanchuk.algorithms.RecursiveBinarySearch;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;

@State(Scope.Benchmark)
public class MyBenchmark {

    private static final int ARRAY_SIZE = 10000;
    private static final int TARGET = 9999;

    private int[] arr = new int[ARRAY_SIZE];
    private int[] unsortedArray = new int[ARRAY_SIZE];

    public MyBenchmark() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    @Benchmark
    public void binarySearch() {
        IterativeBinarySearch.binarySearch(arr, TARGET);
    }

    @Benchmark
    public void recursiveBinarySearch() {
        RecursiveBinarySearch.recursiveBinarySearch(arr, TARGET);
    }

    @Benchmark
    public void mergeSort() {
        MergeSort.mergeSort(unsortedArray, 0, unsortedArray.length-1);
    }
}
