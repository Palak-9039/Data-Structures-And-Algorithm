package Arrays.Sorting;
import java.util.Arrays;

 /*
 Selection Sort Algorithm

 Approach:
 - Divide array in two parts, sorted and unsorted
  - unsorted portion at beginning
  - sorted portion at the end
 - In each pass, find a maximum element in the unsorted portion.
 - Reduce the size of the unsorted portion by one.
 - Repeat util the entire array is sorted.

 * Why it works:
 - After every pass the largest element among the remaining unsorted elements is placed at its correct position.
 - Since one element is sorted in every iteration, the sorted portion grows from the end of the array.
 - Eventually, all elements are placed in their correct positions.

 Time Complexity: O(n^2) - Two nested loops are used to find the maximum element in every pass.
 Space Complexity: O(1) -  - Sorting is performed in-place using only a few extra variables.

 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            swap(arr, arr.length - i - 1, max);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
