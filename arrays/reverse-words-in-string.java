import java.util.*;
class Solution {
    public String reverseWords(String s) {
        String[] splitString = s.split(" ");
        List<String> finalString = new ArrayList<String>();
        int j = splitString.length - 1;
        while (j >= 0) {
            if (!splitString[j].equals("")) {
                finalString.add(splitString[j]);
            }
            j--;
        }
        return String.join(" ", finalString);
    }
}