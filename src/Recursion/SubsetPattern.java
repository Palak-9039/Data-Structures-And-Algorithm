package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetPattern {
    public static void main(String[] args) {
        System.out.println(subsetOfString("abc",""));
    }

    static List<String> subsetOfString(String up, String ans){
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        List<String> ansList = new ArrayList<>();
        ansList.addAll(subsetOfString(up.substring(1),ans + up.charAt(0)));
        ansList.addAll(subsetOfString(up.substring(1),ans));

        return ansList;
    }
}
