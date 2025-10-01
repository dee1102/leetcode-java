// brute force
//

class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int asciiValueLower = (int) 'a';
        int asciiDigitLower = (int) '0';
        int asciiDigitHigher = (int) '9';
        char[] cArray = s.toCharArray();

        for (int i = 0; i < cArray.length; i++) {
            // System.out.println(cArray[i]);
            // System.out.println((int) cArray[i]);
            if ((int) cArray[i] < asciiDigitLower || ((int) cArray[i] > asciiDigitHigher && (int) cArray[i] < asciiValueLower) || (int) cArray[i] > asciiValueLower + 25 ) {
                System.out.println(cArray[i]);
                System.out.println((int) cArray[i]);
                cArray[i] = ' ';
            }
        }

        s = new String(cArray);
        s = s.replaceAll(" ", "");

        System.out.println(s);
        String sFirst = s.substring(0, s.length()/2);
        String sSecond = "";

        cArray = s.toCharArray();
        for (int i = s.length() - 1; i >= ((s.length() % 2 == 0)? s.length()/2 : s.length()/2+1) ; i--) {
            sSecond += cArray[i];
        } // O(n²) - due to += on a String → O(n²), because each += creates a new string copy (concat() is just as bad)
        // Use StringBuilder — It's O(n)
        // This makes string building amortized O(1) per append(), so the whole loop is O(n) instead of O(n²).


        System.out.println(sFirst);
        System.out.println(sSecond);
        return sFirst.equals(sSecond);
    }
}