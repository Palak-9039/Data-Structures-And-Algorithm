package Arrays;

import java.util.HashMap;

/*
 Minimum Window Substring

 Approach:
 - Create a frequency map of all characters in the target string t.
 - Maintain a variable remaining to track how many required characters are still missing.
 - Use two pointers, 'left' and 'right', to represent the current sliding window.
 - Expand the window by moving the 'right' pointer.
 - Whenever a required character is encountered, update its frequency in the map and decrease remaining if it was still needed.
 - Once remaining becomes 0, the current window contains all the required characters.
 - Record the current window if it is smaller than the best answer found so far.
 - Shrink the window by moving the left pointer while it remains valid.
 - If removing a character makes the window invalid, stop shrinking and continue expanding with the right pointer.
 - Repeat the process until the entire string has been processed.

 Why This Works:

 - The frequency map keeps track of how many occurrences of each character are still required.
 - The remaining variable tells us exactly when the current window becomes valid.
 - Expanding the window ensures we eventually include all required characters.
 - Shrinking the window removes unnecessary characters, guaranteeing that we find the minimum valid window.

 Time Complexity: O(m + n)
 - Building the frequency map takes O(n), where n is the length of t.
 - Each character of s is visited at most twice (once by right and once by left).

 Space Complexity: O(k)
 - k is the number of distinct characters in t stored in the frequency map.
*/


public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int remaining = t.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        int left = 0;

        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right)) > 0){
                    remaining--;
                }

                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }

            while(remaining == 0){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0){
                        remaining++;
                    }
                }
                left++;
            }
        }
        return minLen ==  Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
