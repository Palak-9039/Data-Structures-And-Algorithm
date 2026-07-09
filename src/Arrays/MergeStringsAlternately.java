package Arrays;


/*
 LeetCode 1768
 Merge Strings Alternatively
 Link : https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Two Pointers
- Convert both the given strings to character arrays w1 and w2.
- Using a while loop with two independent pointers i and j. As long as both strings have characters remaining, append one character from w1 and one from w2 alternatively, incrementing the pointers at the same time.
- If any of the strings runs out of characters, append the remaining characters of the longer string directly to the string builder.
- String builder is used to dynamically construct the string without repeated string allocations.

 Time Complexity: O(n+m) - Where n is the length of word1 and m is the length of word2. Every character from both strings are read and processed only once.
 Space Complexity: O(n+m) - Storing the primitive character arrays and building the final output string takes memory proportional to the total length of the two words combined.
 */

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int w1Len = w1.length;
        int w2Len = w2.length;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i < w1Len && j < w2Len) {
            sb.append(w1[i++]);
            sb.append(w2[j++]);
        }

        if(w1Len < w2Len) {
            sb.append(w2,j,w2Len-j);
        }else if(w2Len < w1Len) {
            sb.append(w1,i,w1Len-i);
        }

        return sb.toString();
    }
}
