class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}

/* without collections
class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1;
        int end = -1;
        int start = -1;
        while (j >= 0 || (end != -1 && start != -1)) {
            if (s.charAt(j) == ' ') {
                if (end != -1) {
                    start = j++;
                    break;
                }
                j--;
            }
            if (s.charAt(j) != ' ') {
                if (end == -1) {
                    end = j;
                }
                j--;
            }
        }
        return end - start;
    }
}
*/