import static edu.yanchuk.algorithms.IterativeBinarySearch.binarySearch;
import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int expected = 6;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        int expected = -1;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] arr = {};
        int target = 10;
        int expected = -1;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchSingleElementArrayFound() {
        int[] arr = {5};
        int target = 5;
        int expected = 0;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchSingleElementArrayNotFound() {
        int[] arr = {5};
        int target = 10;
        int expected = -1;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchDuplicateElements() {
        int[] arr = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        int target = 5;
        int expected = 5;
        int actual = binarySearch(arr, target);
        assertEquals(expected, actual);
    }
}
