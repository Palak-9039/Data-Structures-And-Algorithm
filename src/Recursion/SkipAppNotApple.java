package Recursion;

/*
 Skip "app" from String but not "apple"

 Approach:
 - Treat the string as the unprocessed part of the input.
 - At each recursive call, check whether the current string starts
   with "app".
 - If it starts with "app" and does not start with "apple",
   skip those three characters and recursively process the remaining string.
 - Otherwise, keep the first character and recursively process the remaining string.
 - Continue until the unprocessed string becomes empty.

 Why This Works:
 - "app" is skipped only when it is not part of the word "apple".
 - When "apple" is encountered, the condition prevents "app" from being skipped, so its characters are preserved.

 Time Complexity: O(n^2) - substring() and String concatenation create new strings.

 Space Complexity: O(n) - Recursion stack.
*/

public class SkipAppNotApple {
    static String skip(String up){
        if(up.isEmpty())return "";

        if(up.startsWith("app") && !up.startsWith("apple")){
            return skip(up.substring(3));
        }else{
            return up.charAt(0) + skip(up.substring(1));
        }
    }
}
