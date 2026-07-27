package Arrays;

/*
 LeetCode 80
 Remove Duplicates from Sorted Array II
 Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Two Pointers
 - If the array contains two or fewer elements, return its length since all elements are valid.
 - Initialize pointer i at index 2, as the first two elements can always remain.
 - Traverse the array using pointer j starting from index 2.
 - Compare the current element nums[j] with nums[i - 2].
 - If they are different, it means the current element has appeared fewer than two times in the result.
 - Place nums[j] at index i and increment i.
 - After the traversal, the first i elements contain the modified array where each unique element appears at most twice.

 Why This Works:

 - Since the array is sorted, duplicate elements appear consecutively.
 - Pointer i always represents the next valid position to place an element.
 - Comparing with nums[i - 2] ensures that no element is inserted more than twice.
 - The first two occurrences of each element are preserved, while any additional duplicates are skipped.
 - The relative order of the remaining elements is maintained.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - The operation is performed in-place using two pointers.
*/

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
