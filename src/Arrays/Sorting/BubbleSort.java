package Arrays.Sorting;

/*
 Bubble Sort

 Approach:
 - Traverse the array multiple times.
 - In each pass, compare every pair of adjacent elements.
 - If the left element is greater than the right element, swap them.
 - After every pass, the largest unsorted element moves to its correct position at the end of the array.
 - Reduce the number of comparisons in each subsequent pass since the last elements are already sorted.
 - If no swaps occur during a pass, terminate early as the array is already sorted.

 Time Complexity:
 - Best Case: O(n)
 - Average Case: O(n^2)
 - Worst Case: O(n^2)

 Space Complexity: O(1) - Sorting is performed in-place.
*/

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            boolean swapped = false;

            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
