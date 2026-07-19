package Arrays;


/*
 LeetCode 27
 Remove Element
 Link : https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150

 Approach:
 - Two Pointers
 - Maintain a pointer 'i' to track the position where the next valid element should be placed.
 - Traverse the array using another pointer 'j'.
 - If nums[j] is not equal to val, copy nums[j] to nums[i] and increment i.
 - If nums[j] equals val, simply skip it.
 - After the traversal, the first i elements of the array contain all the elements except val.

 Why This Works:

 - Pointer j scans every element in the array exactly once.
 - Pointer i always points to the next available position for a valid element.
 - Every element that is not equal to val is copied to the front of the array while preserving the relative order.
 - Elements equal to val are ignored, effectively removing them in-place.
 - Since the array is modified in-place without using any extra data structure, the solution satisfies the O(1) space requirement.

 Time Complexity: O(n) - The array is traversed only once.
 Space Complexity: O(1) - Only two pointer variables are used.
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int c = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
