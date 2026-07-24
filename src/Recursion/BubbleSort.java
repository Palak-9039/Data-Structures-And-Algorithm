package Recursion;
import java.util.Arrays;

/*
 Recursive Bubble Sort

 Approach:
 - Use recursion to simulate the iterative Bubble Sort process.
 -  i represents the number of elements that are still unsorted.
 -  j traverses the unsorted portion of the array, comparing adjacent elements.
 - If two adjacent elements are in the wrong order, swap them.
 - Continue the recursive calls until the end of the current pass is reached.
 - After completing one pass, recursively sort the remaining unsorted portion by decreasing i.
 - Stop the recursion when i becomes 0, indicating that the array is completely sorted.

 Why This Works:

 - During each recursive pass, the largest element in the unsorted portion moves up to its correct position at the end.
 - After every pass, the size of the unsorted portion decreases by one.
 - The recursion continues until no unsorted elements remain.
 - This follows the same logic as the iterative Bubble Sort but replaces loops with recursive function calls.

 Time Complexity:
 - Best Case: O(n^2)
 - Average Case: O(n^2)
 - Worst Case: O(n^2)

 Space Complexity: O(n) - Due to the recursive call stack.
*/


public class BubbleSort {

    static void bubbleSort(int[] arr, int i, int j) {
        if (i == 0) return;

        if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

            bubbleSort(arr, i, j + 1);
        } else {
            bubbleSort(arr, i - 1, 0);
        }
    }
}
