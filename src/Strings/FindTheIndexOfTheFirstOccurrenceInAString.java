package Strings;

/*
 LeetCode 28
 Find the Index of the First Occurrence in a String
 Link : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

 Approach:
 - Brute Force + Two Pointers
 - Iterate through every possible starting index in the haystack.
 - For each starting index, use two pointers:
   - One pointer (k) traverses the haystack from the current starting position.
   - Another pointer (j) traverses the needle.
 - Continue comparing characters while they match.
 - If all characters of the needle are matched, return the starting index.
 - If a mismatch occurs, move to the next starting position in the haystack and repeat the process.
 - If no match is found after checking all possible starting positions, return -1.

 * Why This Works:

 - Every valid starting position in the haystack is checked exactly once.
 - For each starting position, characters are compared sequentially with the needle.
 - If all characters match, the current starting index is the first occurrence of the needle.
 - If a mismatch occurs, the algorithm discards the current starting position and tries the next one.
 - Since every possible starting position is examined, the algorithm is guaranteed to find the first occurrence if it exists.

 Time Complexity: O((n - m + 1) * m) -> O(n * m)
 - n = length of haystack
 - m = length of needle
 - In the worst case, each starting position compares up to m characters.

 Space Complexity: O(1) - Only a few pointer variables are used.
*/

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            int k = i;

            while (k < haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
                j++;
                k++;
            }
            if (j == needle.length()) return i;

        }
        return -1;
    }
}
