/*
Good space complexity, but not that great time complexity. Because we go back in haystack each time we need to reset. It is n x m and if n = m then it is O(n2).
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0, start = -1;
        if (haystack.length() < needle.length()) {
            return start;
        }

        while (j < haystack.length() && i < needle.length()) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                if (start == -1) {
                    start = j;
                }
                i++;
                j++;
            } else {
                if (start != -1) {
                    j = start + 1;
                    start = -1;
                    i = 0;
                } else {
                    j++;
                }
            }
        }
        if (i != needle.length()) {
            return -1;
        }
        return start;
    }
}


/*
Built-in String class methods
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
 */