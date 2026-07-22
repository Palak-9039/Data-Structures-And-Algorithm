package Arrays;


/*
 LeetCode 88
 Merge Sorted Array
 Link : https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Three Pointers
 - Initialize three pointers:
    i at the last valid element of nums1 (m - 1).
    j at the last element of nums2 (n - 1).
    k at the last index of nums1 (m + n - 1).
 - Compare nums1[i] and nums2[j].
 - Place the larger element at nums1[k] and move the corresponding pointer backward.
 - Decrement k after every placement.
 - Continue until either array is completely traversed.
 - If any elements remain in nums2, copy them into nums1.
 - No action is needed for remaining elements in nums1 since they are already in their correct positions.

 Why This Works:

 - Both arrays are already sorted in non-decreasing order.
 - Filling nums1 from the end prevents overwriting elements that have not yet been processed.
 - At each step, the largest remaining element is placed at the end of the merged array, maintaining the sorted order.
 - If nums2 still contains elements after the main loop, they must be copied.
 - If nums1 contains remaining elements, they are already in the correct positions, so no additional work is required.

 Time Complexity: O(m + n) - Each element from both arrays is processed at most once.
 Space Complexity: O(1) - The merge is performed in-place using only three pointer variables.
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        int c = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[c] = nums1[i];
                i--;
            } else {
                nums1[c] = nums2[j];
                j--;
            }
            c--;
        }

        while (j >= 0) {
            nums1[c] = nums2[j];
            j--;
            c--;
        }
    }
}
