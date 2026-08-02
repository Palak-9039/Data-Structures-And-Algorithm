package Arrays.Sorting;
import java.util.Arrays;
import static Arrays.Sorting.SelectionSort.swap;


/*
 Quick Sort

 Approach:
 - Select the middle element as the pivot.
 - Maintain two pointers, start and end, representing the current subarray.
 - Move the start pointer forward until an element greater than or equal to the pivot is found.
 - Move the end pointer backward until an element less than or equal to the pivot is found.
 - If the pointers have not crossed, swap the elements and continue moving both pointers.
 - Once the pointers cross, the array is partitioned into two halves.
 - Recursively apply the same process on the left and right partitions until each partition contains zero or one element.

 Why This Works:

 - Partitioning places elements smaller than the pivot on the left and larger elements on the right.
 - After partitioning, the two halves become independent and can be sorted recursively.
 - Since every recursive call works on a smaller subarray, the entire array eventually becomes sorted.

 Time Complexity:
 - Best Case: O(n log n)
 - Average Case: O(n log n)
 - Worst Case: O(n^2) when the pivot consistently produces highly unbalanced partitions.

 Space Complexity:
 - O(log n) due to the recursion stack in the average case.
 - O(n) recursion stack in the worst case.
*/

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;

        int start = low;
        int end = high;

        int pivot = nums[start + (end - start) / 2];

        while (start <= end) {
            while (nums[start] < pivot) start++;
            while (nums[end] > pivot) end--;

            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        quickSort(nums, low, end);
        quickSort(nums, start, high);

    }


}
