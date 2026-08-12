package Recursion;


public class PrintAsciiValueOfACharacter {
    static void subsequencesWithAscii(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequencesWithAscii(up.substring(1),p + ch);
        subsequencesWithAscii(up.substring(1),p);
        subsequencesWithAscii(up.substring(1),p + (int)ch);
    }
}
