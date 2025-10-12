class Solution {
    public static void main(String args[]) {
        int n = 7;
        int prev = 0;
        int result = 1;

        if (n < 2) {
            System.out.println(n);
        } else {
            int i = 2;
            while (i <= n) {
                int temp = result;
                result = result + prev;
                prev = temp;
                i++;
            }
        }
        System.out.println(result);
    }
}