package Recursion;

public class SkipAString {

    static String skip(String up,String wordToSkip,String ans){
        if(up.isEmpty())return ans;

        if(up.startsWith(wordToSkip)){
            return skip(up.substring(wordToSkip.length()),wordToSkip,ans);
        }else{
            return skip(up.substring(1),wordToSkip,ans + up.charAt(0));
        }
    }
}
