package Recursion;

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
