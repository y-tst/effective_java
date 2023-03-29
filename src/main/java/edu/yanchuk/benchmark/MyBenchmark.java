package edu.yanchuk.benchmark;

import edu.yanchuk.algorithms.IterativeBinarySearch;
import edu.yanchuk.algorithms.RecursiveBinarySearch;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class MyBenchmark {

    private static final int ARRAY_SIZE = 10000;
    private static final int TARGET = 9999;

    private int[] arr = new int[ARRAY_SIZE];

    public MyBenchmark() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
    }

    @Benchmark
    public void binarySearch() {
        IterativeBinarySearch.binarySearch(arr, TARGET);
    }

    @Benchmark
    public  void recursiveBinarySearch() {
        RecursiveBinarySearch.recursiveBinarySearch(arr, TARGET);
    }
}
