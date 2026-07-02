package Arrays;


/*
 LeetCode 1456
 Maximum Number of Vowels in a Substring of Given Length
 Link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75

 Approach:
- Sliding Window
- Count vowels in the first window.
- Move the window one character at a time.
- Add the new character.
- Remove the left character.
- Track the maximum vowel count.

Time Complexity: O(n)
Space Complexity: O(1)
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {

        int n = s.length();
        int maxVowels = 0;
        int vowelCount = 0;

        for(int i = 0; i < k; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ){
                vowelCount++;
            }
        }
        maxVowels = vowelCount;

        for(int i = k; i < n; i++){
            int left = i - k;
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }

            if(isVowel(s.charAt(left))){
                vowelCount--;
            }

            maxVowels = Math.max(maxVowels,vowelCount);
        }
        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }

}
