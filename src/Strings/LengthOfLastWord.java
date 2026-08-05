package Strings;

/*
 LeetCode 121
 Length of Last Word
 Link : https://leetcode.com/problems/length-of-last-word/description/

 Approach:
 - Traverse the string from the end towards the beginning.
 - Skip all the trailing spaces until the first character of the last word is found.
 - Once the last word is found, keep moving backwards until a space or the beginning of the string is reached.
 - The difference between the starting and ending indices of the last word gives its length.
 - Return the length of the last word.

 Why This Works:

 - Skipping the trailing spaces ensures that the traversal starts from the actual last word.
 - Traversing backwards guarantees that the first word encountered is the last word in the string.
 - Since we stop as soon as the beginning of the last word is reached, no unnecessary characters are processed.


 Time Complexity: O(n) - In the worst case, the entire string is traversed once.
 Space Complexity: O(1) - Only a few variables are used.
*/


public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();

        for (int right = n - 1; right >= 0; right--) {
            if (s.charAt(right) == ' ') continue;

            int left = right;

            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            return right - left;
        }
        return 0;
    }
}
