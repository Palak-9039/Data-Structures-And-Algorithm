package Arrays;

/*
 LeetCode 26
 Remove Duplicates from Sorted Array
 Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Two Pointers
 - Handle the edge case where the array is empty by returning 0.
 - Initialize pointer i at the first element to track the position of the last unique element.
 - Traverse the array using pointer j starting from the second element.
 - If nums[j] is different from nums[i], a new unique element is found.
 - Increment i and place the new unique element at nums[i].
 - After the traversal, the first 'i + 1' elements contain all the unique elements in sorted order.

 Why This Works:

 - Since the array is already sorted, duplicate elements always appear consecutively.
 - Pointer i always points to the last unique element placed in the array.
 - Pointer j scans every element exactly once.
 - Whenever a new unique element is found, it is placed immediately after the previous unique element, ensuring all unique elements remain at the beginning of the array.
 - The relative order of the unique elements is preserved, and no extra space is used.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - The operation is performed in-place using two pointers.
*/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
