package Recursion;
import java.util.Arrays;

 /*
 Recursive Selection Sort

 Approach:
 - Use recursion to simulate both loops of the iterative Selection sort.
 - The parameter 'r' represents the size of the current unsorted position.
 - The parameter 'j' recursively traverses the unsorted portion to find the maximum element.
 - The parameter 'max' stores the index of the maximum element found so far.
 - Once the traversal is complete, swap the maximum element with the last element of the unsorted portion.
 - Reduce the unsorted portion by one and repeat recursively until the array is fully sorted.

 * Why this works:
 - First recursive call replaces the inner loop by finding the maximum element.
 - Second recursive call replaces the outer loop by reducing the unsorted portion after every pass.
 - After each pass the largest element of the unsorted position is placed at its correct position.
 - Eventually the unsorted portion becomes empty, and the array is sorted.

 Time Complexity: O(n^2) - Each recursive pass scans the remaining unsorted elements, just like iterative selection sort.
 Space Complexity: O(n) - Due to the recursive call stack.
 */


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {34, 3, 5, 1, 2};
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int r, int j, int max) {
        if (r == 0) return;

        if (j < r) {
            if (arr[j] > arr[max]) {
                max = j;
            }
            selectionSort(arr, r, j + 1, max);
        } else {
            swap(arr, j - 1, max);
            selectionSort(arr, r - 1, 0, 0);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
