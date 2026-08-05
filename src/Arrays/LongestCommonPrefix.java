package Arrays;


/*
 Longest Common Prefix

 Approach:
 - Assume the first string is the longest possible common prefix.
 - Compare this prefix with every other string in the array.
 - While the current string does not start with the prefix, keep removing the last character from the prefix.
 - If the prefix becomes empty, return an empty string since no common prefix exists.
 - After checking all the strings, the remaining prefix is the
   longest common prefix.

 Why This Works:
 - The common prefix can never be longer than the first string.
 - Whenever a string does not match the current prefix, shrinking the prefix is the only way to make it common for all strings.
 - After processing every string, the remaining prefix is guaranteed to be the longest common prefix.

 Time Complexity: O(n × m)
 - n = number of strings
 - m = length of the shortest common prefix.

 Space Complexity: O(1)
 - No extra data structures are used.
*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
