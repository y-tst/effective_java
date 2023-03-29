import edu.yanchuk.algorithms.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] arr = {10, 8, 6, 4, 2, 0, 1, 3, 5, 7, 9};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortEmpty() {
        int[] arr = {};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSingle() {
        int[] arr = {1};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, arr);
    }
}

